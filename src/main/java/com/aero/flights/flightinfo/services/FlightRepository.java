package com.aero.flights.flightinfo.services;

import com.aero.flights.flightinfo.entity.Flight;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface FlightRepository extends Repository<Flight, Long> {

    Flight save(Flight flight);

    Flight findById(long id);

    List<Flight> findAll();
}
