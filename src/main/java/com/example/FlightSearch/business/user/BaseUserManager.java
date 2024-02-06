package com.example.FlightSearch.business.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.error.ErrorDataResult;
import com.example.FlightSearch.core.utilities.results.dataResult.success.SuccessDataResult;
import com.example.FlightSearch.model.user.BaseUser;
import com.example.FlightSearch.repository.user.BaseUserRepository;
import com.example.FlightSearch.service.user.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseUserManager implements BaseUserService {

    private final BaseUserRepository baseUserRepository;

    @Autowired
    public BaseUserManager(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    @Override
    public DataResult<List<BaseUser>> findAllBaseUsers() {
        try {
            List<BaseUser> baseUsers = baseUserRepository.findAll();
            if (!baseUsers.isEmpty()) {
                return new SuccessDataResult<>("Base users retrieved successfully.", baseUsers);
            } else {
                return new SuccessDataResult<>("No base users found.", baseUsers);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving base users.");
        }
    }

    @Override
    public DataResult<Optional<BaseUser>> findBaseUserById(Long id) {
        try {
            Optional<BaseUser> baseUser = baseUserRepository.findById(id);
            if (baseUser.isPresent()) {
                return new SuccessDataResult<>("Base user found successfully.", baseUser);
            } else {
                return new SuccessDataResult<>("Base user not found.", baseUser);
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while retrieving the base user.");
        }
    }

    @Override
    public DataResult<BaseUser> saveBaseUser(BaseUser baseUser) {
        try {
            BaseUser savedBaseUser = baseUserRepository.save(baseUser);
            return new SuccessDataResult<>("Base user saved successfully.", savedBaseUser);
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while saving the base user.");
        }
    }

    @Override
    public DataResult<Void> deleteBaseUser(Long id) {
        try {
            Optional<BaseUser> existingBaseUser = baseUserRepository.findById(id);
            if (existingBaseUser.isPresent()) {
                baseUserRepository.deleteById(id);
                return new SuccessDataResult<>("Base user deleted successfully.");
            } else {
                return new SuccessDataResult<>("Base user did not exist.");
            }
        } catch (Exception e) {
            return new ErrorDataResult<>("An error occurred while deleting the base user.");
        }
    }
}
