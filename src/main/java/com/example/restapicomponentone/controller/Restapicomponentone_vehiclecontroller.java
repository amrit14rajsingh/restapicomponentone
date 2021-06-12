package com.example.restapicomponentone.controller;

import com.example.restapicomponentone.model.Vehicle;
import com.example.restapicomponentone.repository.VehicleRepository;
import com.example.restapicomponentone.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path ="/restapicomponentone_vehiclecontroller", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class Restapicomponentone_vehiclecontroller {
    private final VehicleService vehicleService;
    @PostMapping(value = "/vehicle", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create Vehicle in database")
    public ResponseEntity<Vehicle> addVehicleDetails(@ApiParam(name = "vehicle", value = "vehicle body {\n" +
            "        \"vin\": \"1234567\",\n" +
            "        \"year\": 2020,\n" +
            "        \"make\": \"Toyota\",\n" +
            "        \"model\": \"Corolla\"\n" +
            "        }", required = true)
                                                     @RequestBody(required = true) Vehicle vehicle,
                                                     @ApiParam(name = "TraceId",value = "Unique string as per REST STD TraceId standards, for tracking requests "
                                                             + "across services.\n \n e.g. 6dc33ac0-6c82-44va-b0a1-e05e7659d70b")
                                                     @RequestHeader(name = "TraceId", required = false)
                                                             String traceId) {
        /*List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle);*/
        System.out.println("Vehivle :: " + vehicle.getVin() + " : " + vehicle.getMake() + " : " + vehicle.getMake() + " : " + vehicle.getYear());
        List<String> ids = Arrays.asList(String.valueOf(vehicle.getYear()),vehicle.getVin(), vehicle.getMake());
        String.join(":",ids);
        if (null != ids) {
            vehicle.setId(String.join(":", ids));
        }
        if(null!=ids){
            return ResponseEntity.ok(vehicleService.saveVehicleData(vehicle));
         }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/vehicle/{vin}", produces = "application/json")
    @ApiOperation(value = "Get Vehicle from database")
    public ResponseEntity<Vehicle> getVehicleDetails( @ApiParam(name = "vin", value = "vin of vehicle", required = true)
                                                      @PathVariable("vin")
                                                      @NotBlank String vin,
                                                      @ApiParam(name = "TraceId",value = "Unique string as per REST STD TraceId standards, for tracking requests "
                                                                              + "across services.\n \n e.g. 6dc33ac0-6c82-44va-b0a1-e05e7659d70b")
                                                      @RequestHeader(name = "TraceId", required = false)
                                                              String traceId) {
        List<Vehicle> vehicleList = new ArrayList<>();
        Vehicle vehicle= new Vehicle();
        vehicleList.add(vehicle);
        vehicle.setVin("12345");vehicle.setMake("Honda");vehicle.setModel("City");vehicle.setYear(2021);
        System.out.println("Vehivle :: " + vehicle.getVin() + " : " + vehicle.getMake() + " : " + vehicle.getModel() + " : " + vehicle.getYear());
        if(!vehicle.getVin().equalsIgnoreCase("12345")){
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