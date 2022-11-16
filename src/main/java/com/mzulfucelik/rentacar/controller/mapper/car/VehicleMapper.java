package com.mzulfucelik.rentacar.controller.mapper.car;

import com.mzulfucelik.rentacar.controller.mapper.AbstractMapper;
import com.mzulfucelik.rentacar.dto.car.VehicleDTO;
import com.mzulfucelik.rentacar.model.car.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper extends AbstractMapper<Vehicle, VehicleDTO> {
    @Override
    protected void fillDTO(VehicleDTO dto, Vehicle entity) {
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setVehicleClass(entity.getVehicleClass());
        dto.setTransmissionType(entity.getTransmissionType());
        dto.setFuelType(entity.getFuelType());
        dto.setPrice(entity.getPrice());
        dto.setEngineCapacity(entity.getEngineCapacity());
    }

    @Override
    protected void fillEntity(Vehicle entity, VehicleDTO dto) {
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setVehicleClass(dto.getVehicleClass());
        entity.setTransmissionType(dto.getTransmissionType());
        entity.setFuelType(dto.getFuelType());
        entity.setPrice(dto.getPrice());
        entity.setEngineCapacity(dto.getEngineCapacity());
    }

    @Override
    protected String getLabel(Vehicle entity) {
        return entity.getBrand() + "/" + entity.getModel();
    }
}
