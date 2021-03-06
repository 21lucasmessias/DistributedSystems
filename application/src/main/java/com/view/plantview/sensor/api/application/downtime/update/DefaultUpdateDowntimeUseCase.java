package com.view.plantview.sensor.api.application.downtime.update;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.downtime.DowntimeGateway;
import com.view.plantview.sensor.api.domain.downtime.DowntimeId;
import com.view.plantview.sensor.api.domain.exceptions.DomainException;
import com.view.plantview.sensor.api.domain.validation.Error;
import com.view.plantview.sensor.api.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultUpdateDowntimeUseCase extends UpdateDowntimeUseCase {
    private final DowntimeGateway gateway;

    public DefaultUpdateDowntimeUseCase(DowntimeGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public Either<Notification, UpdateDowntimeOutput> execute(final UpdateDowntimeCommand aCommand) {
        final var anId = DowntimeId.from(aCommand.id());
        final var aSensorId = aCommand.sensorId();
        final var anEquipment = aCommand.equipment();
        final var aDate = aCommand.date();
        final var aStart = aCommand.start();
        final var anEnd = aCommand.end();

        final var aDowntime = this.gateway.findById(anId).orElseThrow(notFound(anId));

        final var notification = Notification.create();

        aDowntime.update(aSensorId, anEquipment, aDate, aStart, anEnd);
        aDowntime.validate(notification);

        return notification.hasErrors() ? API.Left(notification) : update(aDowntime);
    }

    private Either<Notification, UpdateDowntimeOutput> update(final Downtime aDowntime) {
        return API.Try(() -> gateway.update(aDowntime))
                .toEither()
                .bimap(Notification::create, UpdateDowntimeOutput::from);
    }

    private Supplier<DomainException> notFound(final DowntimeId anId) {
        return () -> DomainException.with(new Error("Downtime with ID %s was not found.".formatted(anId.getValue())));
    }
}
