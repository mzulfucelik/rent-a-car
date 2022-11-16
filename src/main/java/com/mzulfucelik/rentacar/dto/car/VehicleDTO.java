package com.mzulfucelik.rentacar.dto.car;

import com.mzulfucelik.rentacar.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO extends AbstractDTO {
    private String brand;
    private String model;
    private String vehicleClass;
    private String transmissionType;
    private String fuelType;
    private Double price;
    private Double engineCapacity;
}
