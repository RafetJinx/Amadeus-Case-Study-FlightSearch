package com.example.FlightSearch.service.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.location.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    DataResult<List<City>> findAllCities();

    DataResult<Optional<City>> findCityById(Long id);

    DataResult<City> saveCity(City city);

    DataResult deleteCity(Long id);
}
