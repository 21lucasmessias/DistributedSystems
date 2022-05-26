package com.view.plantview.sensor.api.domain;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.exceptions.DomainException;
import com.view.plantview.sensor.api.domain.sensor.Sensor;
import com.view.plantview.sensor.api.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

public class SensorTest {

    @Test
    public void givenAValidParams_whenCallNewSensor_thenInstantiateASensor() {
        final var expectedExternalId = "externalSensorId1";

        var actualSensor = Sensor.newSensor(expectedExternalId, null);

        Assertions.assertNotNull(actualSensor);
        Assertions.assertNotNull(actualSensor.getId());
        Assertions.assertEquals(expectedExternalId, actualSensor.getIdExternal());

        final var givenEquipmentExternalId = "externalEquipmentId1";
        final var expectedEquipment = new Equipment(givenEquipmentExternalId, "", "");

        actualSensor = Sensor.newSensor(expectedExternalId, expectedEquipment);

        Assertions.assertNotNull(actualSensor);
        Assertions.assertNotNull(actualSensor.getId());
        Assertions.assertEquals(expectedExternalId, actualSensor.getIdExternal());
        Assertions.assertEquals(expectedEquipment, actualSensor.getEquipment());
    }

    @Test
    public void givenAnNullIdExternal_whenCallNewSensor_thenShouldThrowNullPointerException() {
        final var expectedExternalId = "externalSensorId1";
        Assertions.assertDoesNotThrow(() -> Sensor.newSensor(expectedExternalId, null));
    }

    @Test
    public void givenAnInvalidEmptyIdExternal_whenCallNewSensorAndValidate_thenShouldReceiveAnError() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'idExternal' should not be empty";
        final String expectedIdExternal = "  ";

        final var actualSensor = Sensor.newSensor(expectedIdExternal, null);
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualSensor.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnValidDowntime_whenCallUpdateDowntime_thenShouldUpdateDowntime() {
        final var expectedExternalId = "externalSensorId1";

        var actualSensor = Sensor.newSensor(expectedExternalId, null);

        final var expectedDowntime = Downtime.newDowntime(actualSensor.getId(), null, LocalDate.now(), Instant.now(), Instant.now().plusSeconds(1));

        actualSensor.updateDowntime(expectedDowntime);

        Assertions.assertNotNull(actualSensor);
        Assertions.assertNotNull(actualSensor.getId());
        Assertions.assertEquals(expectedExternalId, actualSensor.getIdExternal());
        Assertions.assertEquals(expectedDowntime, actualSensor.getDowntime());
    }

    @Test
    public void givenAnValidEquipment_whenCallUpdateEquipment_thenShouldUpdateEquipment() {
        final var expectedExternalId = "externalSensorId1";

        var actualSensor = Sensor.newSensor(expectedExternalId, null);

        final var expectedEquipment = new Equipment("", "", "");

        actualSensor.updateEquipment(expectedEquipment);

        Assertions.assertNotNull(actualSensor);
        Assertions.assertNotNull(actualSensor.getId());
        Assertions.assertEquals(expectedExternalId, actualSensor.getIdExternal());
        Assertions.assertEquals(expectedEquipment, actualSensor.getEquipment());
    }

    @Test
    public void givenAValidSensor_whenCallUpdateSensor_thenShouldReturnUpdatedSensor() {
        final var givenExternalId = "externalSensorId1";
        final var givenEquipmentExternalId = "externalEquipmentId1";
        final var givenEquipment = new Equipment(givenEquipmentExternalId, "", "");

        var actualSensor = Sensor.newSensor(givenExternalId, givenEquipment);

        final var expectedExternalId = "externalSensorId2";
        final var expectedEquipmentExternalId = "externalEquipmentId2";
        final var expectedEquipment = new Equipment(expectedEquipmentExternalId, "", "");
        final var expectedDowntime = Downtime.newDowntime(actualSensor.getId(), expectedEquipment, LocalDate.now(), Instant.now(), Instant.now().plusSeconds(1));

        actualSensor.update(expectedExternalId, expectedEquipment, expectedDowntime);

        Assertions.assertNotNull(actualSensor);
        Assertions.assertNotNull(actualSensor.getId());
        Assertions.assertEquals(expectedExternalId, actualSensor.getIdExternal());
        Assertions.assertEquals(expectedEquipment, actualSensor.getEquipment());
        Assertions.assertEquals(expectedDowntime, actualSensor.getDowntime());
    }
}
