package com.example.FlightSearch.service.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.user.CompanyEmployee;

import java.util.List;
import java.util.Optional;

public interface CompanyEmployeeService {

    DataResult<List<CompanyEmployee>> findAllCompanyEmployees();

    DataResult<Optional<CompanyEmployee>> findCompanyEmployeeById(Long id);

    DataResult<CompanyEmployee> saveCompanyEmployee(CompanyEmployee companyEmployee);

    DataResult deleteCompanyEmployee(Long id);
}
