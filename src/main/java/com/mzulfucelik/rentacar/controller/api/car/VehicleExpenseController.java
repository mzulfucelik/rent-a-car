package com.mzulfucelik.rentacar.controller.api.car;

import com.mzulfucelik.rentacar.controller.api.AbstractController;
import com.mzulfucelik.rentacar.dto.car.VehicleExpenseDTO;
import com.mzulfucelik.rentacar.model.car.VehicleExpense;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicleExpense")
public class VehicleExpenseController extends AbstractController<VehicleExpense, VehicleExpenseDTO> {
}
