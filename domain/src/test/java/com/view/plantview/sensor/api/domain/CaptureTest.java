package com.view.plantview.sensor.api.domain;

import com.view.plantview.sensor.api.domain.capture.Capture;
import com.view.plantview.sensor.api.domain.sensor.SensorId;
import com.view.plantview.sensor.api.domain.status.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class CaptureTest {

    @Test
    public void givenAValidParams_whenCallNewCapture_thenInstantiateACapture() {
        final var givenSensorExternalId = "externalSensorId1";
        final var expectedSensorExternalId = SensorId.from(givenSensorExternalId);
        final var expectedStatus = Status.ONLINE;
        final var expectedCaptureTime = Instant.now();

        final var actualCapture = new Capture(givenSensorExternalId, expectedStatus, expectedCaptureTime);

        Assertions.assertNotNull(actualCapture);
        Assertions.assertEquals(expectedSensorExternalId, actualCapture.getSensorExternalId());
        Assertions.assertEquals(expectedStatus, actualCapture.getStatus());
        Assertions.assertEquals(expectedCaptureTime, actualCapture.getCaptureTime());
    }
}
