package com.example.FlightSearch.repository.user;

import com.example.FlightSearch.model.user.IndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualUserRepository extends JpaRepository<IndividualUser, Long> {
}
