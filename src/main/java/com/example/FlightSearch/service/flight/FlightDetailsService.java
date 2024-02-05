package com.example.FlightSearch.service.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.flight.FlightDetails;

import java.util.List;
import java.util.Optional;

public interface FlightDetailsService {

    DataResult<List<FlightDetails>> findAllFlightDetails();

    DataResult<Optional<FlightDetails>> findFlightDetailsById(Long id);

    DataResult<FlightDetails> saveFlightDetails(FlightDetails flightDetails);

    DataResult deleteFlightDetails(Long id);
}
