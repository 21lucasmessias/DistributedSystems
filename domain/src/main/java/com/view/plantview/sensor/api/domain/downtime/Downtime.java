package com.view.plantview.sensor.api.domain.downtime;

import com.view.plantview.sensor.api.domain.AggregateRoot;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.sensor.SensorId;
import com.view.plantview.sensor.api.domain.validation.ValidationHandler;

import java.time.Instant;
import java.time.LocalDate;

public class Downtime extends AggregateRoot<DowntimeId> implements Cloneable {

    private SensorId sensorId;
    private Equipment equipment;
    private LocalDate date;
    private Instant start;
    private Instant end;

    private Downtime(final DowntimeId anId, final SensorId aSensor, final Equipment anEquipment, final LocalDate aDate, final Instant aStart, final Instant aEnd) {
        super(anId);
        this.sensorId = aSensor;
        this.equipment = anEquipment;
        this.date = aDate;
        this.start = aStart;
        this.end = aEnd;
    }

    public static Downtime newDowntime(final SensorId aSensorId, final Equipment anEquipment, final LocalDate aDate, final Instant aStart, final Instant aEnd) {
        final var id = DowntimeId.unique();

        return new Downtime(id, aSensorId, anEquipment, aDate, aStart, aEnd);
    }

    @Override
    public void validate(ValidationHandler handler) {
        new DowntimeValidator(this, handler).validate();
    }

    public SensorId getSensorId() {
        return sensorId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public LocalDate getDate() {
        return date;
    }

    public Instant getStart() {
        return start;
    }

    public Instant getEnd() {
        return end;
    }

    public Downtime update(SensorId aSensorId, Equipment anEquipment, LocalDate aDate, Instant aStart, Instant anEnd) {
        this.sensorId = aSensorId;
        this.equipment = anEquipment;
        this.date = aDate;
        this.start = aStart;
        this.end = anEnd;

        return this;
    }

    @Override
    public Downtime clone() {
        try {
            return (Downtime) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
