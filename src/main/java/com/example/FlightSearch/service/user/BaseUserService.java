package com.example.FlightSearch.service.user;

import com.example.FlightSearch.model.user.BaseUser;
import com.example.FlightSearch.repository.user.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseUserService {

    private final BaseUserRepository baseUserRepository;

    @Autowired
    public BaseUserService(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    public List<BaseUser> findAllBaseUsers() {
        return baseUserRepository.findAll();
    }

    public Optional<BaseUser> findBaseUserById(Long id) {
        return baseUserRepository.findById(id);
    }

    public BaseUser saveBaseUser(BaseUser baseUser) {
        return baseUserRepository.save(baseUser);
    }

    public void deleteBaseUser(Long id) {
        baseUserRepository.deleteById(id);
    }
}
