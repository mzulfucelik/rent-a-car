package com.mzulfucelik.rentacar.controller.api.car;

import com.mzulfucelik.rentacar.controller.api.AbstractController;
import com.mzulfucelik.rentacar.dto.car.VehicleDTO;
import com.mzulfucelik.rentacar.model.car.Vehicle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController extends AbstractController<Vehicle, VehicleDTO> {
}
