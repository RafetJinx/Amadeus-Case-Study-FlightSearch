package com.example.FlightSearch.repository.company;

import com.example.FlightSearch.model.company.CompanyContactNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyContactNumberRepository extends JpaRepository<CompanyContactNumber, Long> {
}
