package com.example.FlightSearch.api.controller.location;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.location.Country;
import com.example.FlightSearch.service.location.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<Country>>> getAll() {
        DataResult<List<Country>> result = countryService.findAllCountries();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<Country>>> getById(@PathVariable Long id) {
        DataResult<Optional<Country>> result = countryService.findCountryById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<Country>> add(@Valid @RequestBody Country country) {
        DataResult<Country> result = countryService.saveCountry(country);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/countries/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<Country>> update(@PathVariable Long id, @Valid @RequestBody Country country) {
        country.setId(id);
        DataResult<Country> result = countryService.saveCountry(country);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = countryService.deleteCountry(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
