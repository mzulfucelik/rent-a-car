package com.mzulfucelik.rentacar.model.customer;

import com.mzulfucelik.rentacar.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractEntity {
    private String name;
    private String surname;
    @Email
    private String email;
    private String address;
    private LocalDate birthdate;
    private String identityNo;
    private String phoneNumber;
    private String driverLicenseNo;
}
