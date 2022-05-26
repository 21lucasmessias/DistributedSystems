package com.view.plantview.sensor.api.application.downtime.retrieve.list;

import com.view.plantview.sensor.api.domain.downtime.DowntimeGateway;
import com.view.plantview.sensor.api.domain.downtime.DowntimeSearchQuery;
import com.view.plantview.sensor.api.domain.pagination.Pagination;

import java.util.Objects;

public class DefaultListDowntimeUseCase extends ListDowntimeUseCase {
    private final DowntimeGateway gateway;

    public DefaultListDowntimeUseCase(final DowntimeGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public Pagination<DowntimeListOutput> execute(DowntimeSearchQuery aQuery) {
        return this.gateway.findAll(aQuery)
                .map(DowntimeListOutput::from);
    }
}
