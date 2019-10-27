package com.aero.flights.flightinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private Date date;
    private String fromAirport;
    private String toAirport;

    protected Flight() {}

    public Flight(String number, Date date, String fromAirport, String toAirport) {
        this.number = number;
        this.date = date;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    @Override
    public String toString() {
        return "Id=" + this.id
               + " number=" + this.number
               + " date=" + this.date
               + " fromAirport=" + this.fromAirport
               + " toAirport=" + this.toAirport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
}
