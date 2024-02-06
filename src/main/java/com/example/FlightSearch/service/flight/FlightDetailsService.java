package com.example.FlightSearch.service.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.flight.FlightDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightDetailsService {

    DataResult<List<FlightDetails>> findAllFlightDetails();

    DataResult<Optional<FlightDetails>> findFlightDetailsById(Long id);

    DataResult<FlightDetails> saveFlightDetails(FlightDetails flightDetails);

    DataResult deleteFlightDetails(Long id);

    DataResult<List<FlightDetails>> findFlightsById(Long departureAirportId,
                                                    Long arrivalAirportId,
                                                    LocalDateTime departureTime,
                                                    LocalDateTime returnTime);

    DataResult<List<FlightDetails>> findFlightsByName(String departureAirportName,
                                                      String arrivalAirportName,
                                                      LocalDateTime departureTime,
                                                      LocalDateTime returnTime);
}
