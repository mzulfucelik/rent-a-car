package com.mzulfucelik.rentacar.controller.mapper.car;

import com.mzulfucelik.rentacar.controller.mapper.AbstractMapper;
import com.mzulfucelik.rentacar.dto.car.OwnedVehicleDTO;
import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class OwnedVehicleMapper extends AbstractMapper<OwnedVehicle, OwnedVehicleDTO> {

    private VehicleMapper vehicleMapper;

    @Autowired
    public OwnedVehicleMapper(VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    protected void fillDTO(OwnedVehicleDTO dto, OwnedVehicle entity) {
        dto.setVehicle(vehicleMapper.toSimpleDTO(entity.getVehicle()));
        dto.setKm(entity.getKm());
        dto.setStandardRentPrice(entity.getStandardRentPrice());
        dto.setStatus(entity.getStatus());
    }

    @Override
    protected void fillEntity(OwnedVehicle entity, OwnedVehicleDTO dto) {
        entity.setVehicle(vehicleMapper.toEntityFromSimpleDTO(dto.getVehicle()));
        entity.setKm(dto.getKm());
        entity.setStandardRentPrice(dto.getStandardRentPrice());
        entity.setStatus(dto.getStatus());
    }

    @Override
    protected String getLabel(OwnedVehicle entity) {
        String label = "";
        return label += entity.getId();
    }
}
