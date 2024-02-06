package com.example.FlightSearch.business.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.user.CompanyEmployee;
import com.example.FlightSearch.repository.user.CompanyEmployeeRepository;
import com.example.FlightSearch.service.user.CompanyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyEmployeeManager implements CompanyEmployeeService {

    private final CompanyEmployeeRepository companyEmployeeRepository;

    @Autowired
    public CompanyEmployeeManager(CompanyEmployeeRepository companyEmployeeRepository) {
        this.companyEmployeeRepository = companyEmployeeRepository;
    }

    @Override
    public DataResult<List<CompanyEmployee>> findAllCompanyEmployees() {
        try {
            List<CompanyEmployee> companyEmployees = companyEmployeeRepository.findAll();
            if (!companyEmployees.isEmpty()) {
                return new SuccessDataResult<>("Company employees retrieved successfully.", companyEmployees);
            } else {
                return new SuccessDataResult<>("No company employees found.", companyEmployees);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving company employees.");
        }
    }

    @Override
    public DataResult<Optional<CompanyEmployee>> findCompanyEmployeeById(Long id) {
        try {
            Optional<CompanyEmployee> companyEmployee = companyEmployeeRepository.findById(id);
            if (companyEmployee.isPresent()) {
                return new SuccessDataResult<>("Company employee found successfully.", companyEmployee);
            } else {
                return new SuccessDataResult<>("Company employee not found.", companyEmployee);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the company employee.");
        }
    }

    @Override
    public DataResult<CompanyEmployee> saveCompanyEmployee(CompanyEmployee companyEmployee) {
        try {
            CompanyEmployee savedCompanyEmployee = companyEmployeeRepository.save(companyEmployee);
            return new SuccessDataResult<>("Company employee saved successfully.", savedCompanyEmployee);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the company employee.");
        }
    }

    @Override
    public DataResult<Void> deleteCompanyEmployee(Long id) {
        try {
            Optional<CompanyEmployee> existingCompanyEmployee = companyEmployeeRepository.findById(id);
            if (existingCompanyEmployee.isPresent()) {
                companyEmployeeRepository.deleteById(id);
                return new SuccessDataResult<>("Company employee deleted successfully.");
            } else {
                return new SuccessDataResult<>("Company employee did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the company employee.");
        }
    }
}
