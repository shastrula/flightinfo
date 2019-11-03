package com.aero.flights.flightinfo.entity;

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
    @Pattern(message = "Flight Number should follow pattern XX999",
            regexp = "^([a-zA-Z]+[0-9]+)$"
        )
    private String number;
    @NotBlank(message = "Flight Date is mandatory")
    @Pattern(message = "Date should be in the following format (mm/dd/yyyy)",
            regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$"
    )
    @NotBlank(message = "Flight Date is mandatory")
    private String flightDate;
    @NotBlank(message = "From Airport is mandatory")
    private String fromAirport;
    @NotBlank(message = "To Airport is mandatory")
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
