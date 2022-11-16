package com.mzulfucelik.rentacar.dto.order.repsonse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatisticResponse implements Serializable {
    private long rentableCar;
    private long rentedCar;
    private long totalCar;
}
