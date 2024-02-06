package com.example.FlightSearch.api.controller.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.user.CompanyEmployee;
import com.example.FlightSearch.service.user.CompanyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companyEmployees")
public class CompanyEmployeeController {

    private final CompanyEmployeeService companyEmployeeService;

    @Autowired
    public CompanyEmployeeController(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<CompanyEmployee>>> getAll() {
        DataResult<List<CompanyEmployee>> result = companyEmployeeService.findAllCompanyEmployees();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<CompanyEmployee>>> getById(@PathVariable Long id) {
        DataResult<Optional<CompanyEmployee>> result = companyEmployeeService.findCompanyEmployeeById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<CompanyEmployee>> add(@Valid @RequestBody CompanyEmployee companyEmployee) {
        DataResult<CompanyEmployee> result = companyEmployeeService.saveCompanyEmployee(companyEmployee);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/companyEmployees/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<CompanyEmployee>> update(@PathVariable Long id, @Valid @RequestBody CompanyEmployee companyEmployee) {
        companyEmployee.setId(id);
        DataResult<CompanyEmployee> result = companyEmployeeService.saveCompanyEmployee(companyEmployee);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = companyEmployeeService.deleteCompanyEmployee(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
