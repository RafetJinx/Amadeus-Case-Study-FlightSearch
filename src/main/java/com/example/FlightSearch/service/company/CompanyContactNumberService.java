package com.example.FlightSearch.service.company;

import com.example.FlightSearch.model.company.CompanyContactNumber;
import com.example.FlightSearch.repository.company.CompanyContactNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyContactNumberService {

    private final CompanyContactNumberRepository companyContactNumberRepository;

    @Autowired
    public CompanyContactNumberService(CompanyContactNumberRepository companyContactNumberRepository) {
        this.companyContactNumberRepository = companyContactNumberRepository;
    }

    public List<CompanyContactNumber> findAllContactNumbers() {
        return companyContactNumberRepository.findAll();
    }

    public Optional<CompanyContactNumber> findContactNumberById(Long id) {
        return companyContactNumberRepository.findById(id);
    }

    public CompanyContactNumber saveContactNumber(CompanyContactNumber contactNumber) {
        return companyContactNumberRepository.save(contactNumber);
    }

    public void deleteContactNumber(Long id) {
        companyContactNumberRepository.deleteById(id);
    }
}
