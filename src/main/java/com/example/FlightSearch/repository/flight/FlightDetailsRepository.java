package com.example.FlightSearch.repository.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.flight.FlightDetails;
import com.example.FlightSearch.model.flight.FlightType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {
    DataResult<List<FlightDetails>> findByFlightType(FlightType flightType);
}
