package com.view.plantview.sensor.api.domain.sensor;

import com.view.plantview.sensor.api.domain.AggregateRoot;
import com.view.plantview.sensor.api.domain.downtime.Downtime;
import com.view.plantview.sensor.api.domain.equipment.Equipment;
import com.view.plantview.sensor.api.domain.validation.ValidationHandler;

public class Sensor extends AggregateRoot<SensorId> implements Cloneable {
    private Equipment equipment;
    private Downtime downtime;
    private String idExternal;

    private Sensor(final SensorId anId, final String anExternalId, final Equipment anEquipment) {
        super(anId);
        this.idExternal = anExternalId;
        this.equipment = anEquipment;
    }

    public static Sensor newSensor(final String anExternalId, final Equipment anEquipment) {
        final var id = SensorId.unique();
        return new Sensor(id, anExternalId, anEquipment);
    }

    public void updateEquipment(Equipment anEquipment) {
        this.equipment = anEquipment;
    }

    public void updateDowntime(Downtime anDowntime) {
        this.downtime = anDowntime;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new SensorValidator(this, handler).validate();
    }

    public SensorId getId() {
        return id;
    }

    public String getIdExternal() {
        return idExternal;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Downtime getDowntime() {
        return downtime;
    }

    public Sensor update(String anIdExternal, Equipment anEquipment, Downtime aDowntime) {
        this.idExternal = anIdExternal;
        this.equipment = anEquipment;
        this.downtime = aDowntime;

        return this;
    }

    @Override
    public Sensor clone() {
        try {
            return (Sensor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
