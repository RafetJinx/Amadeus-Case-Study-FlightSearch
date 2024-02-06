package com.example.FlightSearch.business.company;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.company.CompanyEmail;
import com.example.FlightSearch.repository.company.CompanyEmailRepository;
import com.example.FlightSearch.service.company.CompanyEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyEmailManager implements CompanyEmailService {

    private final CompanyEmailRepository companyEmailRepository;

    @Autowired
    public CompanyEmailManager(CompanyEmailRepository companyEmailRepository) {
        this.companyEmailRepository = companyEmailRepository;
    }

    @Override
    public DataResult<List<CompanyEmail>> findAllEmails() {
        try {
            List<CompanyEmail> emails = companyEmailRepository.findAll();
            if (!emails.isEmpty()) {
                return new SuccessDataResult<>("Emails retrieved successfully.", emails);
            } else {
                return new SuccessDataResult<>("No emails found.", emails);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving emails.");
        }
    }

    @Override
    public DataResult<Optional<CompanyEmail>> findEmailById(Long id) {
        try {
            Optional<CompanyEmail> email = companyEmailRepository.findById(id);
            if (email.isPresent()) {
                return new SuccessDataResult<>("Email found successfully.", email);
            } else {
                return new SuccessDataResult<>("Email not found.", email);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the email.");
        }
    }

    @Override
    public DataResult<CompanyEmail> saveEmail(CompanyEmail email) {
        try {
            CompanyEmail savedEmail = companyEmailRepository.save(email);
            return new SuccessDataResult<>("Email saved successfully.", savedEmail);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the email.");
        }
    }

    @Override
    public DataResult<Void> deleteEmail(Long id) {
        try {
            Optional<CompanyEmail> existingEmail = companyEmailRepository.findById(id);
            if (existingEmail.isPresent()) {
                companyEmailRepository.deleteById(id);
                return new SuccessDataResult<>("Email deleted successfully.");
            } else {
                return new SuccessDataResult<>("Email did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the email.");
        }
    }
}
