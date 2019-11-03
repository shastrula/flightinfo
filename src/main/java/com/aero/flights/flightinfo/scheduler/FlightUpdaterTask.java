package com.aero.flights.flightinfo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.aero.flights.flightinfo.entity.Flight;
import com.aero.flights.flightinfo.rest.FlightRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FlightUpdaterTask {

    private static final Logger log = LoggerFactory.getLogger(FlightUpdaterTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private FlightRestController flightRestController;

    @Scheduled(fixedRate = 15000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        log.info("Now updating all flights update time");
        List<Flight> flightList = flightRestController.findAll();

        for(Flight flight:flightList) {
            flight.setUpdated(new Date());
            flightRestController.updateFlight(flight);
        }



    }
}