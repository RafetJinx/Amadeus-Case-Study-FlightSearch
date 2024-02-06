package com.example.FlightSearch.business.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.company.CompanyContactNumber;
import com.example.FlightSearch.repository.company.CompanyContactNumberRepository;
import com.example.FlightSearch.service.company.CompanyContactNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyContactNumberManager implements CompanyContactNumberService {

    private final CompanyContactNumberRepository companyContactNumberRepository;

    @Autowired
    public CompanyContactNumberManager(CompanyContactNumberRepository companyContactNumberRepository) {
        this.companyContactNumberRepository = companyContactNumberRepository;
    }

    @Override
    public DataResult<List<CompanyContactNumber>> findAllContactNumbers() {
        try {
            List<CompanyContactNumber> contactNumbers = companyContactNumberRepository.findAll();
            if (!contactNumbers.isEmpty()) {
                return new SuccessDataResult<>("Contact numbers retrieved successfully.", contactNumbers);
            } else {
                return new SuccessDataResult<>("No contact numbers found.", contactNumbers);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving contact numbers.");
        }
    }

    @Override
    public DataResult<Optional<CompanyContactNumber>> findContactNumberById(Long id) {
        try {
            Optional<CompanyContactNumber> contactNumber = companyContactNumberRepository.findById(id);
            if (contactNumber.isPresent()) {
                return new SuccessDataResult<>("Contact number found successfully.", contactNumber);
            } else {
                return new SuccessDataResult<>("Contact number not found.", contactNumber);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the contact number.");
        }
    }

    @Override
    public DataResult<CompanyContactNumber> saveContactNumber(CompanyContactNumber contactNumber) {
        try {
            CompanyContactNumber savedContactNumber = companyContactNumberRepository.save(contactNumber);
            return new SuccessDataResult<>("Contact number saved successfully.", savedContactNumber);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the contact number.");
        }
    }

    @Override
    public DataResult<Void> deleteContactNumber(Long id) {
        try {
            Optional<CompanyContactNumber> existingContactNumber = companyContactNumberRepository.findById(id);
            if (existingContactNumber.isPresent()) {
                companyContactNumberRepository.deleteById(id);
                return new SuccessDataResult<>("Contact number deleted successfully.");
            } else {
                return new SuccessDataResult<>("Contact number did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the contact number.");
        }
    }
}
