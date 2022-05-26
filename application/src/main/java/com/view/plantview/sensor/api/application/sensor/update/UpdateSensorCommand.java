package com.view.plantview.sensor.api.application.sensor.update;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.equipment.Equipment;

public record UpdateSensorCommand(
        String id,
        String idExternal,
        Equipment equipment,
        Downtime downtime
) {

    public static UpdateSensorCommand with(
            final String anId,
            final String idExternal,
            final Equipment anEquipment,
            final Downtime anDowntime
    ) {
        return new UpdateSensorCommand(
                anId,
                idExternal,
                anEquipment,
                anDowntime
        );
    }
}
