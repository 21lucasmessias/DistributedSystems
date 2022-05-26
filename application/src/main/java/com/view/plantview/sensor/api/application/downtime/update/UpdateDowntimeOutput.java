package com.view.plantview.sensor.api.application.downtime.update;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.downtime.DowntimeId;

public record UpdateDowntimeOutput(
        DowntimeId id
) {

    public static UpdateDowntimeOutput from(final Downtime downtime) {
        return new UpdateDowntimeOutput(downtime.getId());
    }
}
