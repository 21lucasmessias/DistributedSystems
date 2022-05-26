package com.view.plantview.sensor.api.domain.sensor;

import com.view.plantview.sensor.api.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class SensorId extends Identifier {
    private final String value;

    private SensorId(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static SensorId unique() {
        return SensorId.from(UUID.randomUUID());
    }

    public static SensorId from(final String anId) {
        return new SensorId(anId);
    }

    public static SensorId from(final UUID uuid) {
        return new SensorId(uuid.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SensorId sensorId = (SensorId) o;
        return getValue().equals(sensorId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
