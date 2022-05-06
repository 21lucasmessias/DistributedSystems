package edu.utfpr.domain.model;

import org.json.JSONObject;

public class Message {

    private String event;
    private JSONObject data;

    public Message(String event, JSONObject data) {
        this.event = event;
        this.data = data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
