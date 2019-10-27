package com.aero.flights.flightinfo.web;


import com.aero.flights.flightinfo.GetFlightRequest;
import com.aero.flights.flightinfo.GetFlightResponse;
import com.aero.flights.flightinfo.entity.Flight;
import com.aero.flights.flightinfo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FlightSoapEndpoint {
    private static final String NAMESPACE_URI = "http://flights.aero.com/flightinfo";

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    public FlightSoapEndpoint() {
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFlightRequest")
    @ResponsePayload
    public GetFlightResponse getCountry(@RequestPayload GetFlightRequest request) {
        GetFlightResponse response = new GetFlightResponse();
        Flight flightFromDb = flightRepository.findByNumber(request.getNumber());

        com.aero.flights.flightinfo.Flight flightSoap = transformFlightToSoap(flightFromDb);
        response.setFlight(flightSoap);

        return response;
    }

    private com.aero.flights.flightinfo.Flight transformFlightToSoap(Flight flightFromDb) {
        com.aero.flights.flightinfo.Flight flightSoap = new com.aero.flights.flightinfo.Flight();
        flightSoap.setId(flightFromDb.getId());
        flightSoap.setNumber(flightFromDb.getNumber());
        flightSoap.setFlightDate(flightFromDb.getFlightDate());
        flightSoap.setFromAirport(flightFromDb.getFromAirport());
        flightSoap.setToAirport(flightFromDb.getToAirport());

        return flightSoap;
    }
}