package com.example.restapicomponentone.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    String vin;
    int year;
    String make;
    String model;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
