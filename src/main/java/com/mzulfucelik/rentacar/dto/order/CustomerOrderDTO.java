package com.mzulfucelik.rentacar.dto.order;

import com.mzulfucelik.rentacar.dto.AbstractDTO;
import com.mzulfucelik.rentacar.dto.SimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerOrderDTO extends AbstractDTO {
    private SimpleDTO vehicle;
    private SimpleDTO customer;
    private List<SimpleDTO> expenseList;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Double totalPrice;
}
