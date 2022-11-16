package com.mzulfucelik.rentacar.dto.customer;

import com.mzulfucelik.rentacar.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO extends AbstractDTO {
    private String name;
    private String surname;
    private String email;
    private String address;
    private LocalDate birthdate;
    private String identityNo;
    private String phoneNumber;
    private String driverLicenseNo;
}
