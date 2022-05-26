package com.view.plantview.sensor.api.domain.sensor;

import com.view.plantview.sensor.api.domain.validation.Error;
import com.view.plantview.sensor.api.domain.validation.ValidationHandler;
import com.view.plantview.sensor.api.domain.validation.Validator;

public class SensorValidator extends Validator {
    final private Sensor sensor;

    protected SensorValidator(final Sensor sensor, final ValidationHandler aHandler) {
        super(aHandler);
        this.sensor = sensor;
    }

    @Override
    public void validate() {
        if (sensor.getIdExternal() == null) {
            this.validationHandler().append(new Error("'idExternal' should not be null"));
        }

        if (sensor.getIdExternal() != null && sensor.getIdExternal().trim().isEmpty()) {
            this.validationHandler().append(new Error("'idExternal' should not be empty"));
        }
    }
}
