package com.example.FlightSearch.service.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {

    DataResult<List<Airline>> findAllAirlines();

    DataResult<Optional<Airline>> findAirlineById(Long id);

    DataResult<Airline> saveAirline(Airline airline);

    DataResult deleteAirline(Long id);
}
