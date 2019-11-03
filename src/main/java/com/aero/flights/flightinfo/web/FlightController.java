package com.aero.flights.flightinfo.web;

import com.aero.flights.flightinfo.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class FlightController {
    private static final String DEFAULT_MAPPING = "/flight";
    private static Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    FlightRestController flightRestController;

    @GetMapping("/")
    public String showWebSiteIndex() {
        return "index";
    }

    @GetMapping(DEFAULT_MAPPING + "/signup")
    public String showFlightAdd(Flight flight) {
        return "flight/add-flight";
    }

    @PostMapping(DEFAULT_MAPPING + "/add")
    public String createFlight(@Valid Flight flight, BindingResult result, Model model) {
        logger.info("Flight=" + flight);

        if (result.hasErrors()) {
            return "flight/add-flight";
        }

        flightRestController.createFlight(flight);

        model.addAttribute("flights", flightRestController.findAll());
        return "flight/index";
    }

    @GetMapping(DEFAULT_MAPPING + "/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Flight flight = flightRestController.getFlightById(id);
        model.addAttribute("flight", flight);
        return "flight/update-flight";
    }


    @PostMapping(DEFAULT_MAPPING + "/update/{id}")
    public String updateFlight(@Valid Flight flight, BindingResult result, Model model) {
        logger.info("Updating Flight=" + flight);

        if (result.hasErrors()) {
            return "flight/update-flight";
        }

        flightRestController.updateFlight(flight);
        model.addAttribute("flights", flightRestController.findAll());
        return "flight/index";
    }

    @GetMapping(DEFAULT_MAPPING + "/{id}")
    public @ResponseBody
    Flight getCustomer(@PathVariable long id) {
        return getFlightById(id);
    }

    private Flight getFlightById(@PathVariable long id) {
        return flightRestController.getFlightById(id);
    }

    @GetMapping(DEFAULT_MAPPING + "/findAll")
    public String listAllFlights(Model model) {
        List<Flight> flightList = flightRestController.findAll();

        if(flightList==null) {
            flightList = new ArrayList<>();
        }

        model.addAttribute("flights", flightList);
        return "flight/index";
    }

}
