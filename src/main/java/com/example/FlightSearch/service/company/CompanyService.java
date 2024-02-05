package com.example.FlightSearch.service.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    DataResult<List<Company>> findAllCompanies();

    DataResult<Optional<Company>> findCompanyById(Long id);

    DataResult<Company> saveCompany(Company company);

    DataResult deleteCompany(Long id);
}
