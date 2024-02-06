package com.example.FlightSearch.business.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.flight.FlightDetails;
import com.example.FlightSearch.repository.flight.FlightDetailsRepository;
import com.example.FlightSearch.service.flight.FlightDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightDetailsManager implements FlightDetailsService {

    private final FlightDetailsRepository flightDetailsRepository;

    @Autowired
    public FlightDetailsManager(FlightDetailsRepository flightDetailsRepository) {
        this.flightDetailsRepository = flightDetailsRepository;
    }

    @Override
    public DataResult<List<FlightDetails>> findAllFlightDetails() {
        try {
            List<FlightDetails> flightDetails = flightDetailsRepository.findAll();
            if (!flightDetails.isEmpty()) {
                return new SuccessDataResult<>("Flight details retrieved successfully.", flightDetails);
            } else {
                return new SuccessDataResult<>("No flight details found.", flightDetails);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving flight details.");
        }
    }

    @Override
    public DataResult<Optional<FlightDetails>> findFlightDetailsById(Long id) {
        try {
            Optional<FlightDetails> flightDetail = flightDetailsRepository.findById(id);
            if (flightDetail.isPresent()) {
                return new SuccessDataResult<>("Flight detail found successfully.", flightDetail);
            } else {
                return new SuccessDataResult<>("Flight detail not found.", flightDetail);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the flight detail.");
        }
    }

    @Override
    public DataResult<FlightDetails> saveFlightDetails(FlightDetails flightDetails) {
        try {
            FlightDetails savedFlightDetails = flightDetailsRepository.save(flightDetails);
            return new SuccessDataResult<>("Flight details saved successfully.", savedFlightDetails);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the flight details.");
        }
    }

    @Override
    public DataResult<Void> deleteFlightDetails(Long id) {
        try {
            Optional<FlightDetails> existingFlightDetails = flightDetailsRepository.findById(id);
            if (existingFlightDetails.isPresent()) {
                flightDetailsRepository.deleteById(id);
                return new SuccessDataResult<>("Flight details deleted successfully.");
            } else {
                return new SuccessDataResult<>("Flight details did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the flight details.");
        }
    }
}
