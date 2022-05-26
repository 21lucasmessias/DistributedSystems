package com.view.plantview.sensor.api.domain.downtime;

import com.view.plantview.sensor.api.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class DowntimeId extends Identifier {
    private final String value;

    private DowntimeId(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static DowntimeId unique() {
        return DowntimeId.from(UUID.randomUUID());
    }

    public static DowntimeId from(final String anId) {
        return new DowntimeId(anId);
    }

    public static DowntimeId from(final UUID uuid) {
        return new DowntimeId(uuid.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DowntimeId sensorId = (DowntimeId) o;
        return getValue().equals(sensorId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
