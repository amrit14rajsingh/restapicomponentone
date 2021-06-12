package com.example.restapicomponentone.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
//import com.couchbase.client.java.repository.annotation.Field;

@Getter
@Setter
public class Vehicle {
    @Id
    private String id;
    @Version
    private long version;
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
