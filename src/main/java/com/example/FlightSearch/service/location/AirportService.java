package com.example.FlightSearch.service.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.location.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    DataResult<List<Airport>> findAllAirports();

    DataResult<Optional<Airport>> findAirportById(Long id);

    DataResult<Airport> saveAirport(Airport airport);

    DataResult deleteAirport(Long id);
}
