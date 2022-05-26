package com.view.plantview.sensor.api.application.downtime.create;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.downtime.DowntimeGateway;
import com.view.plantview.sensor.api.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateDowntimeUseCase extends CreateDowntimeUseCase {

    private final DowntimeGateway gateway;

    public DefaultCreateDowntimeUseCase(final DowntimeGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public Either<Notification, CreateDowntimeOutput> execute(final CreateDowntimeCommand aCommand) {
        final var aSensorId = aCommand.sensorId();
        final var anEquipment = aCommand.equipment();
        final var aDate = aCommand.date();
        final var aStart = aCommand.start();
        final var anEnd = aCommand.end();

        final var notification = Notification.create();

        final var aDowntime = Downtime.newDowntime(aSensorId, anEquipment, aDate, aStart, anEnd);

        aDowntime.validate(notification);

        return notification.hasErrors() ? Left(notification) : create(aDowntime);
    }

    private Either<Notification, CreateDowntimeOutput> create(final Downtime aDowntime) {
        return Try(() -> this.gateway.create(aDowntime))
                .toEither()
                .bimap(Notification::create, CreateDowntimeOutput::from);
    }
}
