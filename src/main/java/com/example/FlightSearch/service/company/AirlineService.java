package com.example.FlightSearch.service.company;

import com.example.FlightSearch.model.company.Airline;
import com.example.FlightSearch.repository.company.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll();
    }

    public Optional<Airline> findAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}
