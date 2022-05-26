package com.view.plantview.sensor.api.domain.equipment;

import com.view.plantview.sensor.api.domain.ValueObject;

public class Equipment extends ValueObject {
    private final String idExternal;
    private final String idExternalCompany;
    private final String idExternalBranch;

    public Equipment(String idExternal, String idExternalCompany, String idExternalBranch) {
        this.idExternal = idExternal;
        this.idExternalCompany = idExternalCompany;
        this.idExternalBranch = idExternalBranch;
    }

    public String getIdExternal() {
        return idExternal;
    }

    public String getIdExternalCompany() {
        return idExternalCompany;
    }

    public String getIdExternalBranch() {
        return idExternalBranch;
    }
}
