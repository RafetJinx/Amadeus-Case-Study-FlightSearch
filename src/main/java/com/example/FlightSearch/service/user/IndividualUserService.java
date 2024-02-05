package com.example.FlightSearch.service.user;

import com.example.FlightSearch.model.user.IndividualUser;
import com.example.FlightSearch.repository.user.IndividualUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndividualUserService {

    private final IndividualUserRepository individualUserRepository;

    @Autowired
    public IndividualUserService(IndividualUserRepository individualUserRepository) {
        this.individualUserRepository = individualUserRepository;
    }

    public List<IndividualUser> findAllIndividualUsers() {
        return individualUserRepository.findAll();
    }

    public Optional<IndividualUser> findIndividualUserById(Long id) {
        return individualUserRepository.findById(id);
    }

    public IndividualUser saveIndividualUser(IndividualUser individualUser) {
        return individualUserRepository.save(individualUser);
    }

    public void deleteIndividualUser(Long id) {
        individualUserRepository.deleteById(id);
    }
}
