package edu.utfpr.domain.model;

public class Donation {

    private Number quantity;
    private String measureUnit;
    private String description;
    private String idDonor;

    public Donation(Number quantity, String measureUnit, String description, String idDonor) {
        this.quantity = quantity;
        this.measureUnit = measureUnit;
        this.description = description;
        this.idDonor = idDonor;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(String idDonor) {
        this.idDonor = idDonor;
    }
}
