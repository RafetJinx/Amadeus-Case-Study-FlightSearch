package com.example.FlightSearch.repository.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.flight.Flight;
import com.example.FlightSearch.model.flight.FlightDetails;
import com.example.FlightSearch.model.flight.FlightType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {
    DataResult<List<FlightDetails>> findByFlightType(FlightType flightType);

    @Query("SELECT fd FROM FlightDetails fd " +
            "WHERE " +
            "(:departureAirportId IS NULL OR fd.departureAirport.id = :departureAirportId) AND " +
            "(:arrivalAirportId IS NULL OR fd.arrivalAirport.id = :arrivalAirportId) AND " +
            "fd.departureTime >= :departureTime AND " +
            "(:returnTime IS NULL OR fd.arrivalTime <= :returnTime) " +
            "ORDER BY fd.departureTime ASC")
    DataResult<List<FlightDetails>> findFlightsById(@Param("departureAirportId") Long departureAirportId,
                                                    @Param("arrivalAirportId") Long arrivalAirportId,
                                                    @Param("departureTime") LocalDateTime departureTime,
                                                    @Param("returnTime") LocalDateTime returnTime);

    @Query("SELECT fd FROM FlightDetails fd " +
            "WHERE " +
            "(:departureAirportName IS NULL OR fd.departureAirport.name = :departureAirportName) AND " +
            "(:arrivalAirportName IS NULL OR fd.arrivalAirport.name = :arrivalAirportName) AND " +
            "fd.departureTime >= :departureTime AND " +
            "(:returnTime IS NULL OR fd.arrivalTime <= :returnTime) " +
            "ORDER BY fd.departureTime ASC")
    DataResult<List<FlightDetails>> findFlightsByName(@Param("departureAirportName") String departureAirportName,
                                                      @Param("arrivalAirportName") String arrivalAirportName,
                                                      @Param("departureTime") LocalDateTime departureTime,
                                                      @Param("returnTime") LocalDateTime returnTime);

}
