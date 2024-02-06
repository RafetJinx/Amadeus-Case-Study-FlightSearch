package com.example.FlightSearch.business.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.company.Company;
import com.example.FlightSearch.repository.company.CompanyRepository;
import com.example.FlightSearch.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyManager implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyManager(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public DataResult<List<Company>> findAllCompanies() {
        try {
            List<Company> companies = companyRepository.findAll();
            if (!companies.isEmpty()) {
                return new SuccessDataResult<>("Companies retrieved successfully.", companies);
            } else {
                return new SuccessDataResult<>("No companies found.", companies);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving companies.");
        }
    }

    @Override
    public DataResult<Optional<Company>> findCompanyById(Long id) {
        try {
            Optional<Company> company = companyRepository.findById(id);
            if (company.isPresent()) {
                return new SuccessDataResult<>("Company found successfully.", company);
            } else {
                return new SuccessDataResult<>("Company not found.", company);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the company.");
        }
    }

    @Override
    public DataResult<Company> saveCompany(Company company) {
        try {
            Company savedCompany = companyRepository.save(company);
            return new SuccessDataResult<>("Company saved successfully.", savedCompany);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the company.");
        }
    }

    @Override
    public DataResult<Void> deleteCompany(Long id) {
        try {
            Optional<Company> existingCompany = companyRepository.findById(id);
            if (existingCompany.isPresent()) {
                companyRepository.deleteById(id);
                return new SuccessDataResult<>("Company deleted successfully.");
            } else {
                return new SuccessDataResult<>("Company did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the company.");
        }
    }
}
