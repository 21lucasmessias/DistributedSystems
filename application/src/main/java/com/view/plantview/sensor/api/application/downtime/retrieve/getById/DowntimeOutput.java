package com.view.plantview.sensor.api.application.downtime.retrieve.getById;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.downtime.DowntimeId;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.sensor.SensorId;

import java.time.Instant;
import java.time.LocalDate;

public record DowntimeOutput(
        DowntimeId id,
        SensorId sensorId,
        Equipment equipment,
        LocalDate date,
        Instant start,
        Instant end
) {

    public static DowntimeOutput from(final Downtime aDowntime) {
        return new DowntimeOutput(
                aDowntime.getId(),
                aDowntime.getSensorId(),
                aDowntime.getEquipment(),
                aDowntime.getDate(),
                aDowntime.getStart(),
                aDowntime.getEnd()
        );
    }
}
