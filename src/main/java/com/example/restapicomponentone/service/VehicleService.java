package com.example.restapicomponentone.service;


import com.example.restapicomponentone.model.Vehicle;
import com.example.restapicomponentone.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    public Vehicle saveVehicleData(Vehicle vehicle){
        Vehicle vehicleS = vehicleRepository.save(vehicle);
        return vehicleS;
    }


}
