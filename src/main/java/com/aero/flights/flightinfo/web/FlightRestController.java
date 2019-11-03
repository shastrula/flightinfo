package com.aero.flights.flightinfo.web;

import com.aero.flights.flightinfo.entity.Flight;
import com.aero.flights.flightinfo.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Transactional
public class FlightRestController {
    private static final String DEFAULT_MAPPING = "/flightrest";
    private static Logger logger = LoggerFactory.getLogger(FlightRestController.class);

    @Autowired
    private FlightRepository flightRepository;

    @PostMapping(DEFAULT_MAPPING + "/add")
    public @Valid Flight createFlight(@Valid Flight flight, BindingResult result, Model model) {
        logger.info("Flight=" + flight);

        if (result.hasErrors()) {
            return null;
        }
            if(flight.getNumber()!=null) {
                Flight existingFlight = getFlightByNumber(flight.getNumber());

                if(existingFlight!=null) {
                    flight.setId(existingFlight.getId());
                }
            }

            flightRepository.save(flight);

            return flight;
    }


    @PostMapping(DEFAULT_MAPPING + "/update/{id}")
    public @Valid Flight updateFlight(@Valid Flight flight, BindingResult result, Model model) {
        logger.info("Updating Flight=" + flight);

        if (result.hasErrors()) {
            return null;
        }

        flightRepository.save(flight);
        return flight;
    }

    @GetMapping(DEFAULT_MAPPING + "/{id}")
    public @ResponseBody
    Flight getCustomer(@PathVariable long id) {
        return getFlightById(id);
    }

    private Flight getFlightById(@PathVariable long id) {
        return flightRepository.findById(id);
    }

    private Flight getFlightByNumber(@PathVariable String number) {
        return flightRepository.findByNumber(number);
    }

    @GetMapping(DEFAULT_MAPPING + "/findAll")
    public List<Flight> listAllFlights(Model model) {
        List<Flight> flightList = flightRepository.findAll();

        if(flightList==null) {
            flightList = new ArrayList<>();
        }

        return flightList;
    }

}
