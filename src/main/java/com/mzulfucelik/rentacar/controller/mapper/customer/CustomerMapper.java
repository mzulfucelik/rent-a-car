package com.mzulfucelik.rentacar.controller.mapper.customer;

import com.mzulfucelik.rentacar.controller.mapper.AbstractMapper;
import com.mzulfucelik.rentacar.dto.customer.CustomerDTO;
import com.mzulfucelik.rentacar.model.customer.Customer;
import org.springframework.stereotype.Component;

/*
    private String name;
    private String surname;
    @Email
    private String email;
    private String address;
    private LocalDate birthdate;
    private String identityNo;
    private String phoneNumber;
    private String driverLicenseNo;
 */


@Component
public class CustomerMapper extends AbstractMapper<Customer, CustomerDTO> {
    @Override
    protected void fillDTO(CustomerDTO dto, Customer entity) {
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setBirthdate(entity.getBirthdate());
        dto.setIdentityNo(entity.getIdentityNo());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setDriverLicenseNo(entity.getDriverLicenseNo());
    }

    @Override
    protected void fillEntity(Customer entity, CustomerDTO dto) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setBirthdate(dto.getBirthdate());
        entity.setIdentityNo(dto.getIdentityNo());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setDriverLicenseNo(dto.getDriverLicenseNo());
    }

    @Override
    protected String getLabel(Customer entity) {
        return entity.getName() + " " + entity.getSurname();
    }
}
