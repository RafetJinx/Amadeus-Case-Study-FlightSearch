package com.example.FlightSearch.business.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.company.Airline;
import com.example.FlightSearch.repository.company.AirlineRepository;
import com.example.FlightSearch.service.company.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineManager implements AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineManager(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public DataResult<List<Airline>> findAllAirlines() {
        try {
            List<Airline> airlines = airlineRepository.findAll();
            if (!airlines.isEmpty()) {
                return new SuccessDataResult<>("Airlines retrieved successfully.", airlines);
            } else {
                return new SuccessDataResult<>("No airlines found.", airlines);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving airlines.");
        }
    }

    @Override
    public DataResult<Optional<Airline>> findAirlineById(Long id) {
        try {
            Optional<Airline> airline = airlineRepository.findById(id);
            if (airline.isPresent()) {
                return new SuccessDataResult<>("Airline found successfully.", airline);
            } else {
                return new SuccessDataResult<>("Airline not found.", airline);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the airline.");
        }
    }

    @Override
    public DataResult<Airline> saveAirline(Airline airline) {
        try {
            Airline savedAirline = airlineRepository.save(airline);
            return new SuccessDataResult<>("Airline saved successfully.", savedAirline);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the airline.");
        }
    }

    @Override
    public DataResult<Void> deleteAirline(Long id) {
        try {
            Optional<Airline> airline = airlineRepository.findById(id);
            if (airline.isPresent()) {
                airlineRepository.deleteById(id);
                return new SuccessDataResult<>("Airline deleted successfully.");
            } else {
                return new SuccessDataResult<>("Airline did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the airline.");
        }
    }

}
