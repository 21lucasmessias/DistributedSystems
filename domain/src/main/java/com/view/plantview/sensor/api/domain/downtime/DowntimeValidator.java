package com.view.plantview.sensor.api.domain.downtime;

import com.view.plantview.sensor.api.domain.validation.Error;
import com.view.plantview.sensor.api.domain.validation.ValidationHandler;
import com.view.plantview.sensor.api.domain.validation.Validator;

public class DowntimeValidator extends Validator {

    private final Downtime downtime;

    protected DowntimeValidator(final Downtime aDowntime, final ValidationHandler aHandler) {
        super(aHandler);

        this.downtime = aDowntime;
    }

    @Override
    public void validate() {
        if (downtime.getDate() == null) {
            this.validationHandler().append(new Error("'date' should not be null"));
        }

        if (downtime.getStart() == null) {
            this.validationHandler().append(new Error("'start' should not be null"));
        }

        if (downtime.getEnd() == null) {
            this.validationHandler().append(new Error("'end' should not be null"));
        }

        if (downtime.getSensorId() == null) {
            this.validationHandler().append(new Error("'sensorId' should not be null"));
        }
    }
}
