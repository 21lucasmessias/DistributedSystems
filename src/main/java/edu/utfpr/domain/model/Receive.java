package edu.utfpr.domain.model;

public class Receive {
    private Number quantity;
    private String idDonation;
    private String idReceiver;

    public Receive(Number quantity, String idDonation, String idReceiver) {
        this.quantity = quantity;
        this.idDonation = idDonation;
        this.idReceiver = idReceiver;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public String getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(String idDonation) {
        this.idDonation = idDonation;
    }

    public String getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }
}
