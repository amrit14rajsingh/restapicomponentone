package com.example.restapicomponentone.controller;

import com.example.restapicomponentone.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restapicomponentone_vehiclecontroller")
public class Restapicomponentone_vehiclecontroller {

    @PostMapping(value = "/vehicle", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Vehicle> addVehicleDetails(@RequestBody(required = true) Vehicle vehicle,
                                                     @RequestHeader(name = "traceId",
                                                             required = false) String traceIde) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle);
        System.out.println("Vehivle :: " + vehicle.getVin() + " : " + vehicle.getMake() + " : " + vehicle.getMake() + " : " + vehicle.getYear());
        if(!vehicle.getVin().equalsIgnoreCase("1234567")){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(vehicle);
        }
    }
}


/*
{
        "vin": "1234567",
        "year": 2020,
        "make": "Toyota",
        "model": "Corolla"
        }*/