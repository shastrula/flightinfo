package com.aero.flights.flightinfo.web;

import com.aero.flights.flightinfo.entity.Flight;
import com.aero.flights.flightinfo.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class FlightController {
    private static final String DEFAULT_MAPPING = "/flight";
    private static Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/")
    public String showSignUpForm() {
        return "index";
    }


    @PostMapping(DEFAULT_MAPPING + "/add")
    public String createFlight(@RequestBody Flight requestFlight) {
        logger.info("Flight=" + requestFlight);
        if(requestFlight!=null) {
            if(requestFlight.getNumber()!=null) {
                Flight existingFlight = getFlightByNumber(requestFlight.getNumber());

                if(existingFlight!=null) {
                    requestFlight.setId(existingFlight.getId());
                }
            }

            flightRepository.save(requestFlight);
            return "SUCCESS";
        }

        return "FAILURE";
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
    public String listAllFlights(Model model) {
        List<Flight> flightList = flightRepository.findAll();

        if(flightList==null) {
            flightList = new ArrayList<>();
        }

        model.addAttribute("flights", flightList);
        return "flight/index";
    }

}
