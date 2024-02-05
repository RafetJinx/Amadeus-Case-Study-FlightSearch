package com.example.FlightSearch.service.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.location.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    DataResult<List<Country>> findAllCountries();

    DataResult<Optional<Country>> findCountryById(Long id);

    DataResult<Country> saveCountry(Country country);

    DataResult deleteCountry(Long id);
}
