package com.mzulfucelik.rentacar.repository.order;

import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import com.mzulfucelik.rentacar.model.customer.Customer;
import com.mzulfucelik.rentacar.model.order.CustomerOrder;
import com.mzulfucelik.rentacar.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends GenericRepository<CustomerOrder> {

    Optional<List<CustomerOrder>> getCustomerOrderByVehicleAndBeginDateIsBetween(OwnedVehicle vehicle, LocalDate begin, LocalDate end);

    Optional<List<CustomerOrder>> getCustomerOrderByCustomer(Customer customer);
}
