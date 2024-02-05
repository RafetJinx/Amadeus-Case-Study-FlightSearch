package com.example.FlightSearch.repository.company;

import com.example.FlightSearch.model.company.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
