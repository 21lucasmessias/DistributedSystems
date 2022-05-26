package com.view.plantview.sensor.api.domain.downtime;

import com.view.plantview.sensor.api.domain.pagination.Pagination;
import com.view.plantview.sensor.api.domain.sensor.SensorId;

import java.util.Optional;

public interface DowntimeGateway {
    Downtime create(Downtime aDowntime);

    void deleteById(DowntimeId anId);

    Optional<Downtime> findById(DowntimeId anId);

    Optional<Downtime> findLatestBySensorId(SensorId anId);

    Downtime update(Downtime aDowntime);

    Pagination<Downtime> findAll(DowntimeSearchQuery aQuery);
}
