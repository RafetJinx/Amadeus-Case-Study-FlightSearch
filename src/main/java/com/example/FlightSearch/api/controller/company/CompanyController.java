package com.example.FlightSearch.api.controller.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.Company;
import com.example.FlightSearch.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<Company>>> getAll() {
        DataResult<List<Company>> result = companyService.findAllCompanies();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<Company>>> getById(@PathVariable Long id) {
        DataResult<Optional<Company>> result = companyService.findCompanyById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<Company>> add(@Valid @RequestBody Company company) {
        DataResult<Company> result = companyService.saveCompany(company);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/companies/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<Company>> update(@PathVariable Long id, @Valid @RequestBody Company company) {
        company.setId(id);
        DataResult<Company> result = companyService.saveCompany(company);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = companyService.deleteCompany(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
