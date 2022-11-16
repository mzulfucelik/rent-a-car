package com.mzulfucelik.rentacar.controller.mapper.car;

import com.mzulfucelik.rentacar.controller.mapper.AbstractMapper;
import com.mzulfucelik.rentacar.dto.car.VehicleExpenseDTO;
import com.mzulfucelik.rentacar.model.car.VehicleExpense;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class VehicleExpenseMapper extends AbstractMapper<VehicleExpense, VehicleExpenseDTO> {
    private OwnedVehicleMapper ownedVehicleMapper;

    @Autowired
    public VehicleExpenseMapper(OwnedVehicleMapper ownedVehicleMapper) {
        this.ownedVehicleMapper = ownedVehicleMapper;
    }

    @Override
    protected void fillDTO(VehicleExpenseDTO dto, VehicleExpense entity) {
        dto.setExpenseType(entity.getExpenseType());
        dto.setPrice(entity.getPrice());
        dto.setVehicle(ownedVehicleMapper.toSimpleDTO(entity.getVehicle()));
    }

    @Override
    protected void fillEntity(VehicleExpense entity, VehicleExpenseDTO dto) {
        entity.setExpenseType(dto.getExpenseType());
        entity.setPrice(dto.getPrice());
        entity.setVehicle(ownedVehicleMapper.toEntityFromSimpleDTO(dto.getVehicle()));
    }

    @Override
    protected String getLabel(VehicleExpense entity) {
        return entity.getId().toString();
    }
}
