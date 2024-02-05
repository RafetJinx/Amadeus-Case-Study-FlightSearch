package com.example.FlightSearch.service.company;

import com.example.FlightSearch.model.company.CompanyEmail;
import com.example.FlightSearch.repository.company.CompanyEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyEmailService {

    private final CompanyEmailRepository companyEmailRepository;

    @Autowired
    public CompanyEmailService(CompanyEmailRepository companyEmailRepository) {
        this.companyEmailRepository = companyEmailRepository;
    }

    public List<CompanyEmail> findAllEmails() {
        return companyEmailRepository.findAll();
    }

    public Optional<CompanyEmail> findEmailById(Long id) {
        return companyEmailRepository.findById(id);
    }

    public CompanyEmail saveEmail(CompanyEmail email) {
        return companyEmailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        companyEmailRepository.deleteById(id);
    }
}
