package com.view.plantview.sensor.api.domain;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.exceptions.DomainException;
import com.view.plantview.sensor.api.domain.sensor.SensorId;
import com.view.plantview.sensor.api.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

public class DowntimeTest {

    @Test
    public void givenAValidParams_whenCallNewDowntime_thenInstantiateADowntime() {
        final var expectedSensorId = SensorId.from("1");
        final var expectedEquipment = new Equipment("1", "1", "1");
        final var expectedDate = LocalDate.now();
        final var expectedStart = Instant.now();
        final var expectedEnd = Instant.now().plusSeconds(1);

        final var actualDowntime = Downtime.newDowntime(expectedSensorId, expectedEquipment, expectedDate, expectedStart, expectedEnd);

        Assertions.assertNotNull(actualDowntime);
        Assertions.assertEquals(expectedSensorId, actualDowntime.getSensorId());
        Assertions.assertEquals(expectedEquipment, actualDowntime.getEquipment());
        Assertions.assertEquals(expectedDate, actualDowntime.getDate());
        Assertions.assertEquals(expectedStart, actualDowntime.getStart());
        Assertions.assertEquals(expectedEnd, actualDowntime.getEnd());

    }

    @Test
    public void givenAnInvalidSensorId_whenCallNewDowntime_thenThrowException() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'sensorId' should not be null";

        final SensorId expectedSensorId = null;
        final var expectedEquipment = new Equipment("1", "1", "1");
        final var expectedDate = LocalDate.now();
        final var expectedStart = Instant.now();
        final var expectedEnd = Instant.now().plusSeconds(1);

        final var actualDowntime = Downtime.newDowntime(expectedSensorId, expectedEquipment, expectedDate, expectedStart, expectedEnd);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualDowntime.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidDate_whenCallNewDowntime_thenThrowException() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'date' should not be null";

        final var expectedSensorId = SensorId.from("1");
        final var expectedEquipment = new Equipment("1", "1", "1");
        final LocalDate expectedDate = null;
        final var expectedStart = Instant.now();
        final var expectedEnd = Instant.now().plusSeconds(1);

        final var actualDowntime = Downtime.newDowntime(expectedSensorId, expectedEquipment, expectedDate, expectedStart, expectedEnd);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualDowntime.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidStart_whenCallNewDowntime_thenThrowException() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'start' should not be null";

        final var expectedSensorId = SensorId.from("1");
        final var expectedEquipment = new Equipment("1", "1", "1");
        final var expectedDate = LocalDate.now();
        final Instant expectedStart = null;
        final var expectedEnd = Instant.now().plusSeconds(1);

        final var actualDowntime = Downtime.newDowntime(expectedSensorId, expectedEquipment, expectedDate, expectedStart, expectedEnd);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualDowntime.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidEnd_whenCallNewDowntime_thenThrowException() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'end' should not be null";

        final var expectedSensorId = SensorId.from("1");
        final var expectedEquipment = new Equipment("1", "1", "1");
        final var expectedDate = LocalDate.now();
        final var expectedStart = Instant.now();
        final Instant expectedEnd = null;

        final var actualDowntime = Downtime.newDowntime(expectedSensorId, expectedEquipment, expectedDate, expectedStart, expectedEnd);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualDowntime.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAValidDowntime_whenCallUpdateDowntime_thenShouldReturnUpdatedDowntime() {
        final var givenSensorId = SensorId.from("2");
        final var givenEquipment = new Equipment("2", "2", "2");
        final var givenDate = LocalDate.now().minusDays(1);
        final var givenStart = Instant.now().minusSeconds(10);
        final var givenEnd = Instant.now().minusSeconds(9);

        final var actualDowntime = Downtime.newDowntime(givenSensorId, givenEquipment, givenDate, givenStart, givenEnd);

        final var expectedSensorId = SensorId.from("1");
        final var expectedEquipment = new Equipment("1", "1", "1");
        final var expectedDate = LocalDate.now();
        final var expectedStart = Instant.now();
        final var expectedEnd = Instant.now().plusSeconds(1);

        actualDowntime.update(expectedSensorId, expectedEquipment, expectedDate, expectedStart, expectedEnd);

        Assertions.assertNotNull(actualDowntime);
        Assertions.assertEquals(expectedSensorId, actualDowntime.getSensorId());
        Assertions.assertEquals(expectedEquipment, actualDowntime.getEquipment());
        Assertions.assertEquals(expectedDate, actualDowntime.getDate());
        Assertions.assertEquals(expectedStart, actualDowntime.getStart());
        Assertions.assertEquals(expectedEnd, actualDowntime.getEnd());
    }
}
