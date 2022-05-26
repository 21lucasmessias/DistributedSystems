package com.view.plantview.sensor.api.domain.downtime;

public record DowntimeSearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction
) {
}
