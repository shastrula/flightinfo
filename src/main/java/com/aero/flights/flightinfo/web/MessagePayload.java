package com.aero.flights.flightinfo.web;

public class MessagePayload {
    private int count;
    private String message;

    public MessagePayload(int count, String message) {
        this.count = count;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
