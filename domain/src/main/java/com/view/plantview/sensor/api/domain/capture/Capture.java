package com.view.plantview.sensor.api.domain.capture;

import com.view.plantview.sensor.api.domain.ValueObject;
import com.view.plantview.sensor.api.domain.sensor.SensorId;
import com.view.plantview.sensor.api.domain.status.Status;

import java.time.Instant;

public class Capture extends ValueObject {
    private final SensorId sensorExternalId;
    private final Status status;
    private final Instant captureTime;

    public Capture(final String aSensorExternalId, final Status aStatus, final Instant aCaptureTime) {
        this.sensorExternalId = SensorId.from(aSensorExternalId);
        this.status = aStatus;
        this.captureTime = aCaptureTime;
    }

    public SensorId getSensorExternalId() {
        return sensorExternalId;
    }

    public Status getStatus() {
        return status;
    }

    public Instant getCaptureTime() {
        return captureTime;
    }
}
