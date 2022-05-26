package com.view.plantview.sensor.api.application.downtime.create;

import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.downtime.DowntimeId;

public record CreateDowntimeOutput(
        DowntimeId id
) {
    
    public static CreateDowntimeOutput from(Downtime downtime) {
        return new CreateDowntimeOutput(downtime.getId());
    }
}
