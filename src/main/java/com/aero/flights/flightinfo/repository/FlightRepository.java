package com.aero.flights.flightinfo.repository;

import com.aero.flights.flightinfo.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Flight save(Flight flight);

    Flight findById(long id);

    List<Flight> findAll();

    Flight findByNumber(String number);

}
