package com.aero.flights.flightinfo.entity;

import javax.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_id_seq")
    @SequenceGenerator(name="flight_id_seq", sequenceName = "FLIGHT_ID_SEQ", allocationSize = 100)
    private Long id;
    private String number;
    private String flightDate;
    private String fromAirport;
    private String toAirport;

    protected Flight() {}

    public Flight(String number, String flightDate, String fromAirport, String toAirport) {
        this.number = number;
        this.flightDate = flightDate;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    @Override
    public String toString() {
        return "Id=" + this.id
               + " number=" + this.number
               + " date=" + this.flightDate
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

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
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
