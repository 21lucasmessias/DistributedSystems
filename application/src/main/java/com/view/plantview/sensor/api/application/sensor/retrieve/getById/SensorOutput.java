package com.view.plantview.sensor.api.application.sensor.retrieve.getById;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.sensor.Sensor;
import com.view.plantview.sensor.api.domain.sensor.SensorId;

public record SensorOutput(
        SensorId id,
        String idExternal,
        Equipment equipment,
        Downtime downtime
) {

    public static SensorOutput from(final Sensor aSensor) {
        return new SensorOutput(
                aSensor.getId(),
                aSensor.getIdExternal(),
                aSensor.getEquipment(),
                aSensor.getDowntime()
        );
    }
}
