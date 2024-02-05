package com.example.FlightSearch.service.user;

import com.example.FlightSearch.model.user.CompanyEmployee;
import com.example.FlightSearch.repository.user.CompanyEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyEmployeeService {

    private final CompanyEmployeeRepository companyEmployeeRepository;

    @Autowired
    public CompanyEmployeeService(CompanyEmployeeRepository companyEmployeeRepository) {
        this.companyEmployeeRepository = companyEmployeeRepository;
    }

    public List<CompanyEmployee> findAllCompanyEmployees() {
        return companyEmployeeRepository.findAll();
    }

    public Optional<CompanyEmployee> findCompanyEmployeeById(Long id) {
        return companyEmployeeRepository.findById(id);
    }

    public CompanyEmployee saveCompanyEmployee(CompanyEmployee companyEmployee) {
        return companyEmployeeRepository.save(companyEmployee);
    }

    public void deleteCompanyEmployee(Long id) {
        companyEmployeeRepository.deleteById(id);
    }
}
