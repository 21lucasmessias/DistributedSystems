package com.view.plantview.sensor.api.domain.sensor;

import com.view.plantview.sensor.api.domain.pagination.Pagination;

import java.util.Optional;

public interface SensorGateway {
    Sensor create(Sensor aSensor);

    void deleteById(SensorId anId);

    Optional<Sensor> findById(SensorId anId);

    Sensor update(Sensor aSensor);

    Pagination<Sensor> findAll(SensorSearchQuery aQuery);
}
