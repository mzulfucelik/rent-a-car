package com.mzulfucelik.rentacar.model.car;

import com.mzulfucelik.rentacar.enums.VehicleStatusType;
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
public class OwnedVehicle extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
    private Integer km;
    private Double standardRentPrice;
    private String status = VehicleStatusType.RENTABLE.getValue();
}
