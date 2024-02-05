package com.example.FlightSearch.service.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.company.CompanyContactNumber;

import java.util.List;
import java.util.Optional;

public interface CompanyContactNumberService {

    DataResult<List<CompanyContactNumber>> findAllContactNumbers();

    DataResult<Optional<CompanyContactNumber>> findContactNumberById(Long id);

    DataResult<CompanyContactNumber> saveContactNumber(CompanyContactNumber contactNumber);

    DataResult deleteContactNumber(Long id);
}
