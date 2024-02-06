package com.example.FlightSearch.api.controller.flight;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.flight.FlightDetails;
import com.example.FlightSearch.service.flight.FlightDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flightDetails")
public class FlightDetailsController {

    private final FlightDetailsService flightDetailsService;

    @Autowired
    public FlightDetailsController(FlightDetailsService flightDetailsService) {
        this.flightDetailsService = flightDetailsService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<FlightDetails>>> getAll() {
        DataResult<List<FlightDetails>> result = flightDetailsService.findAllFlightDetails();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<FlightDetails>>> getById(@PathVariable Long id) {
        DataResult<Optional<FlightDetails>> result = flightDetailsService.findFlightDetailsById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<FlightDetails>> add(@Valid @RequestBody FlightDetails flightDetails) {
        DataResult<FlightDetails> result = flightDetailsService.saveFlightDetails(flightDetails);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/flightDetails/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<FlightDetails>> update(@PathVariable Long id, @Valid @RequestBody FlightDetails flightDetails) {
        flightDetails.setId(id);
        DataResult<FlightDetails> result = flightDetailsService.saveFlightDetails(flightDetails);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = flightDetailsService.deleteFlightDetails(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/searchById")
    public ResponseEntity<DataResult<List<FlightDetails>>> searchFlightsById(
            @RequestParam(required = false) Long departureAirportId,
            @RequestParam(required = false) Long arrivalAirportId,
            @RequestParam LocalDateTime departureTime,
            @RequestParam(required = false) LocalDateTime returnTime) {
        DataResult<List<FlightDetails>> result = flightDetailsService.findFlightsById(departureAirportId, arrivalAirportId, departureTime, returnTime);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<DataResult<List<FlightDetails>>> searchFlightsByName(
            @RequestParam(required = false) String departureAirportName,
            @RequestParam(required = false) String arrivalAirportName,
            @RequestParam LocalDateTime departureTime,
            @RequestParam(required = false) LocalDateTime returnTime) {
        DataResult<List<FlightDetails>> result = flightDetailsService.findFlightsByName(departureAirportName, arrivalAirportName, departureTime, returnTime);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

}
