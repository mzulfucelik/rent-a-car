package com.mzulfucelik.rentacar.repository.car;

import com.mzulfucelik.rentacar.model.car.OwnedVehicle;
import com.mzulfucelik.rentacar.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnedVehicleRepository extends GenericRepository<OwnedVehicle> {

    long countOwnedVehicleByStatus(String status);

    Optional<List<OwnedVehicle>> getOwnedVehicleByStatus(String status);
}
