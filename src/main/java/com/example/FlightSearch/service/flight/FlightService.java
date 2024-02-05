package com.example.FlightSearch.service.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.flight.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    DataResult<List<Flight>> findAllFlights();

    DataResult<Optional<Flight>> findFlightById(Long id);

    DataResult<Flight> saveFlight(Flight flight);

    DataResult deleteFlight(Long id);
}
