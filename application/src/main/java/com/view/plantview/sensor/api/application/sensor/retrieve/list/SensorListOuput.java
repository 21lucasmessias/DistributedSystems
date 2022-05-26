package com.view.plantview.sensor.api.application.sensor.retrieve.list;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.sensor.Sensor;
import com.view.plantview.sensor.api.domain.sensor.SensorId;

public record SensorListOuput(
        SensorId id,
        String idExternal,
        Equipment equipment,
        Downtime downtime
) {

    public static SensorListOuput from(final Sensor aSensor) {
        return new SensorListOuput(
                aSensor.getId(),
                aSensor.getIdExternal(),
                aSensor.getEquipment(),
                aSensor.getDowntime()
        );
    }
}
