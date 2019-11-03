package com.aero.flights.flightinfo.rest;

import com.aero.flights.flightinfo.entity.Flight;
import com.aero.flights.flightinfo.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageRestController {
    private static Logger logger = LoggerFactory.getLogger(MessageRestController.class);
    private static final String DEFAULT_MAPPING = "/message";
    private static final String queueName = "flight-queue";

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private FlightRestController flightRestController;


    @GetMapping(DEFAULT_MAPPING + "/manual")
    public void sendMessage() {
        logger.info("Sending all flights");
        List<Flight> flightList = flightRestController.findAll();
        for(Flight flight : flightList) {
            messageSender.sendMessage(queueName, flight.toString());
        }
    }

}
