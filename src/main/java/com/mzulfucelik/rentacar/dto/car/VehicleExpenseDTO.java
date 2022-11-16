package com.mzulfucelik.rentacar.dto.car;

import com.mzulfucelik.rentacar.dto.AbstractDTO;
import com.mzulfucelik.rentacar.dto.SimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleExpenseDTO extends AbstractDTO {
    private String expenseType;
    private Double price;
    private SimpleDTO vehicle;
}
