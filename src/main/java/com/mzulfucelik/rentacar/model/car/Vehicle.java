package com.mzulfucelik.rentacar.model.car;

import com.mzulfucelik.rentacar.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends AbstractEntity {
    private String brand;
    private String model;
    private String vehicleClass;
    private String transmissionType;
    private String fuelType;
    private Double price;
    private Double engineCapacity;
}
