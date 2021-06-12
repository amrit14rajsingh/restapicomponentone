package com.example.restapicomponentone.health;

import com.couchbase.client.java.Cluster;
import com.example.restapicomponentone.model.Vehicle;
import com.example.restapicomponentone.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.couchbase.client.core.diagnostics.DiagnosticsResult;
import com.couchbase.client.java.Cluster;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.util.Assert;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CouchbaseHealthCheck implements HealthIndicator {
    private final VehicleRepository vehicleRepository;

    @Override
    public Health health() {
        Optional<Vehicle> vehicle = vehicleRepository.findById("2020:1234567:Toyota");
        if (vehicle.isPresent())
            return Health.up().withDetail("response_code","...").build();
        else
            return Health.down().build();
    }
}





/**
 * {@link HealthIndicator} for Couchbase.
 *
 * @author Eddú Meléndez
 * @author Stephane Nicoll
 * @since 2.0.0
 */
/*
public class CouchbaseHealthIndicator extends AbstractHealthIndicator {

    private final Cluster cluster;

    */
/**
     * Create an indicator with the specified {@link Cluster}.
     * @param cluster the Couchbase Cluster
     * @since 2.0.6
     *//*

    public CouchbaseHealthIndicator(Cluster cluster) {
        super("Couchbase health check failed");
        Assert.notNull(cluster, "Cluster must not be null");
        this.cluster = cluster;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        DiagnosticsResult diagnostics = this.cluster.diagnostics();
        new CouchbaseHealth(diagnostics).applyTo(builder);
    }

}
*/
