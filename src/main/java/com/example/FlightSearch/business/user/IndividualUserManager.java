package com.example.FlightSearch.business.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.user.IndividualUser;
import com.example.FlightSearch.repository.user.IndividualUserRepository;
import com.example.FlightSearch.service.user.IndividualUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndividualUserManager implements IndividualUserService {

    private final IndividualUserRepository individualUserRepository;

    @Autowired
    public IndividualUserManager(IndividualUserRepository individualUserRepository) {
        this.individualUserRepository = individualUserRepository;
    }

    @Override
    public DataResult<List<IndividualUser>> findAllIndividualUsers() {
        try {
            List<IndividualUser> individualUsers = individualUserRepository.findAll();
            if (!individualUsers.isEmpty()) {
                return new SuccessDataResult<>("Individual users retrieved successfully.", individualUsers);
            } else {
                return new SuccessDataResult<>("No individual users found.", individualUsers);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving individual users.");
        }
    }

    @Override
    public DataResult<Optional<IndividualUser>> findIndividualUserById(Long id) {
        try {
            Optional<IndividualUser> individualUser = individualUserRepository.findById(id);
            if (individualUser.isPresent()) {
                return new SuccessDataResult<>("Individual user found successfully.", individualUser);
            } else {
                return new SuccessDataResult<>("Individual user not found.", individualUser);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the individual user.");
        }
    }

    @Override
    public DataResult<IndividualUser> saveIndividualUser(IndividualUser individualUser) {
        try {
            IndividualUser savedIndividualUser = individualUserRepository.save(individualUser);
            return new SuccessDataResult<>("Individual user saved successfully.", savedIndividualUser);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the individual user.");
        }
    }

    @Override
    public DataResult<Void> deleteIndividualUser(Long id) {
        try {
            Optional<IndividualUser> existingIndividualUser = individualUserRepository.findById(id);
            if (existingIndividualUser.isPresent()) {
                individualUserRepository.deleteById(id);
                return new SuccessDataResult<>("Individual user deleted successfully.");
            } else {
                return new SuccessDataResult<>("Individual user did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the individual user.");
        }
    }
}
