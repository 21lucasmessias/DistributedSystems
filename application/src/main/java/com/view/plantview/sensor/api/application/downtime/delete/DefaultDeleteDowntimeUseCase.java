package com.view.plantview.sensor.api.application.downtime.delete;

import com.view.plantview.sensor.api.domain.downtime.DowntimeGateway;
import com.view.plantview.sensor.api.domain.downtime.DowntimeId;

import java.util.Objects;

public class DefaultDeleteDowntimeUseCase extends DeleteDowntimeUseCase {

    private final DowntimeGateway gateway;

    public DefaultDeleteDowntimeUseCase(final DowntimeGateway aGateway) {
        this.gateway = Objects.requireNonNull(aGateway);
    }

    @Override
    public void execute(String anId) {
        this.gateway.deleteById(DowntimeId.from(anId));
    }
}
