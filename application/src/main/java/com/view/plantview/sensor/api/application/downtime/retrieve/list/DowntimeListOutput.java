package com.view.plantview.sensor.api.application.downtime.retrieve.list;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.downtime.DowntimeId;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.sensor.SensorId;

import java.time.Instant;
import java.time.LocalDate;

public record DowntimeListOutput(
        DowntimeId id,
        SensorId sensorId,
        Equipment equipment,
        LocalDate date,
        Instant start,
        Instant end
) {

    public static DowntimeListOutput from(Downtime aDowntime) {
        return new DowntimeListOutput(
                aDowntime.getId(),
                aDowntime.getSensorId(),
                aDowntime.getEquipment(),
                aDowntime.getDate(),
                aDowntime.getStart(),
                aDowntime.getEnd()
        );
    }
}
