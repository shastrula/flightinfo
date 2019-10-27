package com.aero.flights.flightinfo.entity;

/**
 * Created by developer on 3/26/17.
 */
public class MessageInfo {
    private final String key;
    private final String message;
    private final Exception exception;

    public MessageInfo(String key, String message) {
        this.key = key;
        this.message = message;
        this.exception = null;
    }

    public MessageInfo(String key, Exception exception) {
        this.key = key;
        this.message = null;
        this.exception = exception;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return key + "=" + message;
    }
}
