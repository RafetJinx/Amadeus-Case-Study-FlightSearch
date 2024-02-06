package com.example.FlightSearch.business.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.flight.Flight;
import com.example.FlightSearch.repository.flight.FlightRepository;
import com.example.FlightSearch.service.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightManager implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightManager(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public DataResult<List<Flight>> findAllFlights() {
        try {
            List<Flight> flights = flightRepository.findAll();
            if (!flights.isEmpty()) {
                return new SuccessDataResult<>("Flights retrieved successfully.", flights);
            } else {
                return new SuccessDataResult<>("No flights found.", flights);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving flights.");
        }
    }

    @Override
    public DataResult<Optional<Flight>> findFlightById(Long id) {
        try {
            Optional<Flight> flight = flightRepository.findById(id);
            if (flight.isPresent()) {
                return new SuccessDataResult<>("Flight found successfully.", flight);
            } else {
                return new SuccessDataResult<>("Flight not found.", flight);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the flight.");
        }
    }

    @Override
    public DataResult<Flight> saveFlight(Flight flight) {
        try {
            Flight savedFlight = flightRepository.save(flight);
            return new SuccessDataResult<>("Flight saved successfully.", savedFlight);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the flight.");
        }
    }

    @Override
    public DataResult<Void> deleteFlight(Long id) {
        try {
            Optional<Flight> existingFlight = flightRepository.findById(id);
            if (existingFlight.isPresent()) {
                flightRepository.deleteById(id);
                return new SuccessDataResult<>("Flight deleted successfully.");
            } else {
                return new SuccessDataResult<>("Flight did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the flight.");
        }
    }
}
