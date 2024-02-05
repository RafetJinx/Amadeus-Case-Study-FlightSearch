package com.example.FlightSearch.service.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.CompanyEmail;

import java.util.List;
import java.util.Optional;

public interface CompanyEmailService {

    DataResult<List<CompanyEmail>> findAllEmails();

    DataResult<Optional<CompanyEmail>> findEmailById(Long id);

    DataResult<CompanyEmail> saveEmail(CompanyEmail email);

    DataResult deleteEmail(Long id);
}
