package com.mzulfucelik.rentacar.controller.api.car;

import com.mzulfucelik.rentacar.controller.api.AbstractController;
import com.mzulfucelik.rentacar.dto.car.OwnedVehicleDTO;
import com.mzulfucelik.rentacar.enums.VehicleStatusType;
import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import com.mzulfucelik.rentacar.service.car.OwnedVehicleService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/ownedVehicle")
public class OwnedVehicleController extends AbstractController<OwnedVehicle, OwnedVehicleDTO> {

    private OwnedVehicleService ownedVehicleService;

    @Autowired
    public OwnedVehicleController(OwnedVehicleService ownedVehicleService) {
        this.ownedVehicleService = ownedVehicleService;
    }

    @GetMapping("/getRentableVehicles")
    public ResponseEntity<List<OwnedVehicleDTO>> getRentableVehicleList() throws Exception {
        return new ResponseEntity<>(ownedVehicleService.getVehicleListByStatus(VehicleStatusType.RENTABLE), HttpStatus.OK);
    }

    @GetMapping("/getRentedVehicles")
    public ResponseEntity<List<OwnedVehicleDTO>> getRentedVehicles() throws Exception {
        return new ResponseEntity<>(ownedVehicleService.getVehicleListByStatus(VehicleStatusType.RENTED), HttpStatus.OK);
    }
}
