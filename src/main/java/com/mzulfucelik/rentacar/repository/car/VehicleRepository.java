package com.mzulfucelik.rentacar.repository.car;

import com.mzulfucelik.rentacar.model.car.Vehicle;
import com.mzulfucelik.rentacar.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends GenericRepository<Vehicle> {
}
