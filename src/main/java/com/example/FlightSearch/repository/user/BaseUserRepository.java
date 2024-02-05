package com.example.FlightSearch.repository.user;

import com.example.FlightSearch.model.user.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

}
