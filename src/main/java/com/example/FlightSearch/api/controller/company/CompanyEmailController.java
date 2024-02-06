package com.example.FlightSearch.api.controller.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.CompanyEmail;
import com.example.FlightSearch.service.company.CompanyEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companyEmails")
public class CompanyEmailController {

    private final CompanyEmailService companyEmailService;

    @Autowired
    public CompanyEmailController(CompanyEmailService companyEmailService) {
        this.companyEmailService = companyEmailService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<CompanyEmail>>> getAll() {
        DataResult<List<CompanyEmail>> result = companyEmailService.findAllEmails();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<CompanyEmail>>> getById(@PathVariable Long id) {
        DataResult<Optional<CompanyEmail>> result = companyEmailService.findEmailById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<CompanyEmail>> add(@Valid @RequestBody CompanyEmail companyEmail) {
        DataResult<CompanyEmail> result = companyEmailService.saveEmail(companyEmail);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/companyEmails/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<CompanyEmail>> update(@PathVariable Long id, @Valid @RequestBody CompanyEmail companyEmail) {
        companyEmail.setId(id);
        DataResult<CompanyEmail> result = companyEmailService.saveEmail(companyEmail);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = companyEmailService.deleteEmail(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
