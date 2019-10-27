package com.aero.flights.flightinfo.web;

import com.aero.flights.flightinfo.entity.Flight;
import com.aero.flights.flightinfo.services.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/flights")
public class FlightController {
    private static Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(method = {RequestMethod.POST})
    public @ResponseBody
    Flight insertCustomer(@RequestBody Flight flight) {
        Flight result = flightRepository.save(flight);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Flight getCustomer(@PathVariable long id) {
        return getFlightById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    Flight updateFlights(@RequestBody Flight flight, @PathVariable long id) {

        if(flight!=null) {
            Flight result = getFlightById(id);
            if(result!=null) {
                flightRepository.save(flight);
            }

            return flight;
        }
        return null;
    }

    private Flight getFlightById(@PathVariable long id) {
        return flightRepository.findById(id);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Flight> listAllFlights() {
        List<Flight> flightList = flightRepository.findAll();

        if(flightList==null) {
            return new ArrayList<>();
        }

        return flightList;
    }

}
