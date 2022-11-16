package com.mzulfucelik.rentacar.controller.mapper.order;

import com.mzulfucelik.rentacar.controller.mapper.AbstractMapper;
import com.mzulfucelik.rentacar.controller.mapper.car.OwnedVehicleMapper;
import com.mzulfucelik.rentacar.controller.mapper.car.VehicleExpenseMapper;
import com.mzulfucelik.rentacar.controller.mapper.customer.CustomerMapper;
import com.mzulfucelik.rentacar.dto.order.CustomerOrderDTO;
import com.mzulfucelik.rentacar.model.order.CustomerOrder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class CustomerOrderMapper extends AbstractMapper<CustomerOrder, CustomerOrderDTO> {

    private OwnedVehicleMapper ownedVehicleMapper;
    private CustomerMapper customerMapper;
    private VehicleExpenseMapper vehicleExpenseMapper;

    @Autowired
    public CustomerOrderMapper(OwnedVehicleMapper ownedVehicleMapper, CustomerMapper customerMapper, VehicleExpenseMapper vehicleExpenseMapper) {
        this.ownedVehicleMapper = ownedVehicleMapper;
        this.customerMapper = customerMapper;
        this.vehicleExpenseMapper = vehicleExpenseMapper;
    }

    @Override
    protected void fillDTO(CustomerOrderDTO dto, CustomerOrder entity) {
        dto.setVehicle(ownedVehicleMapper.toSimpleDTO(entity.getVehicle()));
        dto.setCustomer(customerMapper.toSimpleDTO(entity.getCustomer()));
        dto.setExpenseList(vehicleExpenseMapper.toSimpleDTOs(entity.getExpenseList()));
        dto.setBeginDate(entity.getBeginDate());
        dto.setEndDate(entity.getEndDate());
        dto.setTotalPrice(entity.getTotalPrice());

    }

    @Override
    protected void fillEntity(CustomerOrder entity, CustomerOrderDTO dto) {
        entity.setVehicle(ownedVehicleMapper.toEntityFromSimpleDTO(dto.getVehicle()));
        entity.setCustomer(customerMapper.toEntityFromSimpleDTO(dto.getCustomer()));
        entity.setExpenseList(vehicleExpenseMapper.toEntitiesFromSimpleDTOs(dto.getExpenseList()));
        entity.setBeginDate(dto.getBeginDate());
        entity.setEndDate(dto.getEndDate());
        entity.setTotalPrice(dto.getTotalPrice());
    }

    @Override
    protected String getLabel(CustomerOrder entity) {
        return entity.getId().toString();
    }
}
