package com.mzulfucelik.rentacar.model.car;

import com.mzulfucelik.rentacar.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleExpense extends AbstractEntity {
    private String expenseType;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private OwnedVehicle vehicle;
}
