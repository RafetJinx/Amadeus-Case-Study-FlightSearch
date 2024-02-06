package com.example.FlightSearch.business.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.location.City;
import com.example.FlightSearch.repository.location.CityRepository;
import com.example.FlightSearch.service.location.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityManager implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityManager(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public DataResult<List<City>> findAllCities() {
        try {
            List<City> cities = cityRepository.findAll();
            if (!cities.isEmpty()) {
                return new SuccessDataResult<>("Cities retrieved successfully.", cities);
            } else {
                return new SuccessDataResult<>("No cities found.", cities);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving cities.");
        }
    }

    @Override
    public DataResult<Optional<City>> findCityById(Long id) {
        try {
            Optional<City> city = cityRepository.findById(id);
            if (city.isPresent()) {
                return new SuccessDataResult<>("City found successfully.", city);
            } else {
                return new SuccessDataResult<>("City not found.", city);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the city.");
        }
    }

    @Override
    public DataResult<City> saveCity(City city) {
        try {
            City savedCity = cityRepository.save(city);
            return new SuccessDataResult<>("City saved successfully.", savedCity);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the city.");
        }
    }

    @Override
    public DataResult<Void> deleteCity(Long id) {
        try {
            Optional<City> existingCity = cityRepository.findById(id);
            if (existingCity.isPresent()) {
                cityRepository.deleteById(id);
                return new SuccessDataResult<>("City deleted successfully.");
            } else {
                return new SuccessDataResult<>("City did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the city.");
        }
    }
}
