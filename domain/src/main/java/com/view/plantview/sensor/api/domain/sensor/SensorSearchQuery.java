package com.view.plantview.sensor.api.domain.sensor;

public record SensorSearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction
) {
}
