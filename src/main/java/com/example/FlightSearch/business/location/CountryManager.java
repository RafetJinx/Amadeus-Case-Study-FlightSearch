package com.example.FlightSearch.business.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.location.Country;
import com.example.FlightSearch.repository.location.CountryRepository;
import com.example.FlightSearch.service.location.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryManager implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryManager(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public DataResult<List<Country>> findAllCountries() {
        try {
            List<Country> countries = countryRepository.findAll();
            if (!countries.isEmpty()) {
                return new SuccessDataResult<>("Countries retrieved successfully.", countries);
            } else {
                return new SuccessDataResult<>("No countries found.", countries);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving countries.");
        }
    }

    @Override
    public DataResult<Optional<Country>> findCountryById(Long id) {
        try {
            Optional<Country> country = countryRepository.findById(id);
            if (country.isPresent()) {
                return new SuccessDataResult<>("Country found successfully.", country);
            } else {
                return new SuccessDataResult<>("Country not found.", country);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the country.");
        }
    }

    @Override
    public DataResult<Country> saveCountry(Country country) {
        try {
            Country savedCountry = countryRepository.save(country);
            return new SuccessDataResult<>("Country saved successfully.", savedCountry);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the country.");
        }
    }

    @Override
    public DataResult<Void> deleteCountry(Long id) {
        try {
            Optional<Country> existingCountry = countryRepository.findById(id);
            if (existingCountry.isPresent()) {
                countryRepository.deleteById(id);
                return new SuccessDataResult<>("Country deleted successfully.");
            } else {
                return new SuccessDataResult<>("Country did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the country.");
        }
    }
}
