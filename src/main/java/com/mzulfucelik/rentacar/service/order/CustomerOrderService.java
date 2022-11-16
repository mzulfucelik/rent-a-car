package com.mzulfucelik.rentacar.service.order;

import com.mzulfucelik.rentacar.controller.mapper.order.CustomerOrderMapper;
import com.mzulfucelik.rentacar.dto.order.CustomerOrderDTO;
import com.mzulfucelik.rentacar.dto.order.repsonse.StatisticResponse;
import com.mzulfucelik.rentacar.enums.VehicleStatusType;
import com.mzulfucelik.rentacar.exception.DataNotFoundException;
import com.mzulfucelik.rentacar.exception.UserNotFoundException;
import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import com.mzulfucelik.rentacar.model.car.VehicleExpense;
import com.mzulfucelik.rentacar.model.customer.Customer;
import com.mzulfucelik.rentacar.model.order.CustomerOrder;
import com.mzulfucelik.rentacar.repository.order.CustomerOrderRepository;
import com.mzulfucelik.rentacar.service.AbstractService;
import com.mzulfucelik.rentacar.service.car.OwnedVehicleService;
import com.mzulfucelik.rentacar.service.customer.CustomerService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@NoArgsConstructor
@Service
public class CustomerOrderService extends AbstractService<CustomerOrder> {
    private CustomerService customerService;
    private CustomerOrderMapper customerOrderMapper;
    private CustomerOrderRepository customerOrderRepository;
    private OwnedVehicleService ownedVehicleService;

    @Autowired
    public CustomerOrderService(CustomerService customerService, CustomerOrderRepository customerOrderRepository, OwnedVehicleService ownedVehicleService, CustomerOrderMapper customerOrderMapper) {
        this.customerService = customerService;
        this.customerOrderRepository = customerOrderRepository;
        this.ownedVehicleService = ownedVehicleService;
        this.customerOrderMapper = customerOrderMapper;
    }

    public List<CustomerOrderDTO> getOldOrders(Long id) throws Exception {
        return getOldOrders(customerService.getById(id).orElseThrow(UserNotFoundException::new));
    }

    public CustomerOrderDTO createOrder(CustomerOrderDTO request) throws Exception {
        Customer customer = customerService.getById(request.getCustomer().getId()).orElseThrow(DataNotFoundException::new);
        OwnedVehicle vehicle = ownedVehicleService.getById(request.getVehicle().getId()).orElseThrow(DataNotFoundException::new);
        if (isCarUsable(vehicle, request.getBeginDate(), request.getEndDate())) {
            if (request.getBeginDate().isBefore(LocalDate.now()) && request.getEndDate().isAfter(LocalDate.now())) {
                vehicle = ownedVehicleService.changeOwnedVehicleStatus(vehicle, VehicleStatusType.RENTED.getValue());
            }
            return customerOrderMapper.toDTO(save(new CustomerOrder(request, customer, vehicle)));
        } else {
            throw new Exception("carIsNotRentableAtThatDays");
        }
    }

    public CustomerOrderDTO finishOrder(Long id) throws Exception {
        CustomerOrder order = getById(id).orElseThrow(DataNotFoundException::new);
        if (!order.getBeginDate().isAfter(LocalDate.now())) {
            OwnedVehicle vehicle = ownedVehicleService.getById(order.getVehicle().getId()).get();
            vehicle = ownedVehicleService.changeOwnedVehicleStatus(vehicle, VehicleStatusType.RENTABLE.getValue());
            order.setEndDate(LocalDate.now());
            order.setTotalPrice(calculateTotalPrice(vehicle, order) + calculateOrderExpense(order));
            return customerOrderMapper.toDTO(save(order));
        } else {
            throw new Exception("orderIsNotStartedYet");
        }
    }

    public StatisticResponse getStatistics() throws Exception {
        long rentedCarCount = ownedVehicleService.getCarCountByStatus(VehicleStatusType.RENTED.getValue());
        long rentableCarCount = ownedVehicleService.getCarCountByStatus(VehicleStatusType.RENTABLE.getValue());
        long totalCarCount = rentableCarCount + rentedCarCount;
        return new StatisticResponse(rentableCarCount, rentedCarCount, totalCarCount);
    }

    private Double calculateTotalPrice(OwnedVehicle vehicle, CustomerOrder order) throws Exception {
        long dayCount = ChronoUnit.DAYS.between(order.getBeginDate(), LocalDate.now());
        return dayCount * vehicle.getStandardRentPrice();
    }

    private Double calculateOrderExpense(CustomerOrder order) throws Exception {
        Double expenseTotal = 0d;

        if (order.getExpenseList() != null && !order.getExpenseList().isEmpty()) {
            for (VehicleExpense expense : order.getExpenseList()) {
                expenseTotal += expense.getPrice();
            }
        }
        return expenseTotal;
    }

    public List<CustomerOrderDTO> getOldOrders(Customer customer) throws Exception {
        return customerOrderMapper.toDTOs(customerOrderRepository.getCustomerOrderByCustomer(customer).orElseThrow(DataNotFoundException::new));
    }

    public Boolean isCarUsable(OwnedVehicle ownedVehicle, LocalDate begin, LocalDate end) throws Exception {
        return customerOrderRepository.getCustomerOrderByVehicleAndBeginDateIsBetween(ownedVehicle, begin, end).isPresent();
    }
}
