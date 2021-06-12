package com.example.restapicomponentone.repository;

import com.example.restapicomponentone.model.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CouchbaseRepository<Vehicle, String> {}
