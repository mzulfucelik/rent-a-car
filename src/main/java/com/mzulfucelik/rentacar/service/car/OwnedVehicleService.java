package com.mzulfucelik.rentacar.service.car;

import com.mzulfucelik.rentacar.controller.mapper.car.OwnedVehicleMapper;
import com.mzulfucelik.rentacar.dto.car.OwnedVehicleDTO;
import com.mzulfucelik.rentacar.enums.VehicleStatusType;
import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import com.mzulfucelik.rentacar.repository.car.OwnedVehicleRepository;
import com.mzulfucelik.rentacar.service.AbstractService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class OwnedVehicleService extends AbstractService<OwnedVehicle> {
    private OwnedVehicleRepository ownedVehicleRepository;
    private OwnedVehicleMapper ownedVehicleMapper;

    @Autowired
    public OwnedVehicleService(OwnedVehicleRepository ownedVehicleRepository, OwnedVehicleMapper ownedVehicleMapper) {
        this.ownedVehicleRepository = ownedVehicleRepository;
        this.ownedVehicleMapper = ownedVehicleMapper;
    }

    public List<OwnedVehicleDTO> getVehicleListByStatus(VehicleStatusType statusType) throws Exception {
        return ownedVehicleMapper.toDTOs(ownedVehicleRepository.getOwnedVehicleByStatus(statusType.getValue()).orElse(new ArrayList<>()));
    }

    public long getCarCountByStatus(String status) throws Exception {
        return ownedVehicleRepository.countOwnedVehicleByStatus(status);
    }

    public OwnedVehicle changeOwnedVehicleStatus(OwnedVehicle vehicle, String status) throws Exception {
        vehicle.setStatus(status);
        return save(vehicle);
    }
}
