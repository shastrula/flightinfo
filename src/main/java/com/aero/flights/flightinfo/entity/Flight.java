package com.aero.flights.flightinfo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@EntityListeners(AuditListener.class)
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_id_seq")
    @SequenceGenerator(name="flight_id_seq", sequenceName = "FLIGHT_ID_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank(message = "Number is mandatory")
    @Pattern(message = "Flight Number should follow pattern 999",
            regexp = "^([0-9]+)$")
    private String number;

    @NotBlank(message = "Airline Code is mandatory (WN|AA|DL|WS|UA)")
    @Pattern(message = "Enter valid airline code",
            regexp = "(WN|AA|DL|WS|UA)")
    private String airlineCode;

    @NotBlank(message = "Flight Date is mandatory")
    @Pattern(message = "Date should be in the following format (mm/dd/yyyy)",
            regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")
    @NotBlank(message = "Flight Date is mandatory")
    private String flightDate;

    @NotBlank(message = "From Airport is mandatory")
    private String fromAirport;

    @NotBlank(message = "To Airport is mandatory")
    private String toAirport;

    @Pattern(message = "Time should be in format HH:MM on a 24 hour clock",
            regexp ="^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$")
    private String departTime;

    @Pattern(message = "Time should be in format HH:MM on a 24 hour clock",
            regexp ="^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$")
    private String arrivalTime;

    public Flight() {
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
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

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
