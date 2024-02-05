package com.example.FlightSearch.repository.location;

import com.example.FlightSearch.model.location.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
