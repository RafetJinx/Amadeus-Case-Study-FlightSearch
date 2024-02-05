package com.example.FlightSearch.repository.company;

import com.example.FlightSearch.model.company.CompanyEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEmailRepository extends JpaRepository<CompanyEmail, Long> {
}
