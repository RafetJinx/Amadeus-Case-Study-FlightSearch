package com.example.FlightSearch.business.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.location.Airport;
import com.example.FlightSearch.repository.location.AirportRepository;
import com.example.FlightSearch.service.location.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportManager implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportManager(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public DataResult<List<Airport>> findAllAirports() {
        try {
            List<Airport> airports = airportRepository.findAll();
            if (!airports.isEmpty()) {
                return new SuccessDataResult<>("Airports retrieved successfully.", airports);
            } else {
                return new SuccessDataResult<>("No airports found.", airports);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving airports.");
        }
    }

    @Override
    public DataResult<Optional<Airport>> findAirportById(Long id) {
        try {
            Optional<Airport> airport = airportRepository.findById(id);
            if (airport.isPresent()) {
                return new SuccessDataResult<>("Airport found successfully.", airport);
            } else {
                return new SuccessDataResult<>("Airport not found.", airport);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the airport.");
        }
    }

    @Override
    public DataResult<Airport> saveAirport(Airport airport) {
        try {
            Airport savedAirport = airportRepository.save(airport);
            return new SuccessDataResult<>("Airport saved successfully.", savedAirport);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the airport.");
        }
    }

    @Override
    public DataResult<Void> deleteAirport(Long id) {
        try {
            Optional<Airport> existingAirport = airportRepository.findById(id);
            if (existingAirport.isPresent()) {
                airportRepository.deleteById(id);
                return new SuccessDataResult<>("Airport deleted successfully.");
            } else {
                return new SuccessDataResult<>("Airport did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the airport.");
        }
    }
}
