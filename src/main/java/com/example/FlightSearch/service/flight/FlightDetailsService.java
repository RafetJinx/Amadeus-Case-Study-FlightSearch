package com.example.FlightSearch.service.flight;

import com.example.FlightSearch.model.flight.FlightDetails;
import com.example.FlightSearch.repository.flight.FlightDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightDetailsService {

    private final FlightDetailsRepository flightDetailsRepository;

    @Autowired
    public FlightDetailsService(FlightDetailsRepository flightDetailsRepository) {
        this.flightDetailsRepository = flightDetailsRepository;
    }

    public List<FlightDetails> findAllFlightDetails() {
        return flightDetailsRepository.findAll();
    }

    public Optional<FlightDetails> findFlightDetailsById(Long id) {
        return flightDetailsRepository.findById(id);
    }

    public FlightDetails saveFlightDetails(FlightDetails flightDetails) {
        return flightDetailsRepository.save(flightDetails);
    }

    public void deleteFlightDetails(Long id) {
        flightDetailsRepository.deleteById(id);
    }
}
