package com.example.FlightSearch.api.controller.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.CompanyContactNumber;
import com.example.FlightSearch.service.company.CompanyContactNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companyContactNumbers")
public class CompanyContactNumberController {

    private final CompanyContactNumberService companyContactNumberService;

    @Autowired
    public CompanyContactNumberController(CompanyContactNumberService companyContactNumberService) {
        this.companyContactNumberService = companyContactNumberService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<CompanyContactNumber>>> getAll() {
        DataResult<List<CompanyContactNumber>> result = companyContactNumberService.findAllContactNumbers();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<CompanyContactNumber>>> getById(@PathVariable Long id) {
        DataResult<Optional<CompanyContactNumber>> result = companyContactNumberService.findContactNumberById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<CompanyContactNumber>> add(@Valid @RequestBody CompanyContactNumber companyContactNumber) {
        DataResult<CompanyContactNumber> result = companyContactNumberService.saveContactNumber(companyContactNumber);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/companyContactNumbers/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<CompanyContactNumber>> update(@PathVariable Long id, @Valid @RequestBody CompanyContactNumber companyContactNumber) {
        companyContactNumber.setId(id);
        DataResult<CompanyContactNumber> result = companyContactNumberService.saveContactNumber(companyContactNumber);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = companyContactNumberService.deleteContactNumber(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
