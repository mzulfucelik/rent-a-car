package com.mzulfucelik.rentacar.repository.customer;

import com.mzulfucelik.rentacar.model.customer.Customer;
import com.mzulfucelik.rentacar.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends GenericRepository<Customer> {
}
