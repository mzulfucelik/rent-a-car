package com.mzulfucelik.rentacar.model.order;

import com.mzulfucelik.rentacar.dto.order.CustomerOrderDTO;
import com.mzulfucelik.rentacar.model.AbstractEntity;
import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import com.mzulfucelik.rentacar.model.car.VehicleExpense;
import com.mzulfucelik.rentacar.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private OwnedVehicle vehicle;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @OneToMany(fetch = FetchType.LAZY)
    private List<VehicleExpense> expenseList;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Double totalPrice;

    public CustomerOrder(CustomerOrderDTO dto, Customer customer, OwnedVehicle ownedVehicle) {
        this.vehicle = ownedVehicle;
        this.customer = customer;
        this.beginDate = dto.getBeginDate();
        this.endDate = dto.getEndDate();
        if (totalPrice != null) {
            this.totalPrice = dto.getTotalPrice();
        } else {
            long dayCount = ChronoUnit.DAYS.between(this.beginDate, LocalDate.now());
            totalPrice = dayCount * vehicle.getStandardRentPrice();
        }

    }
}
