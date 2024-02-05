package com.example.FlightSearch.service.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.user.BaseUser;

import java.util.List;
import java.util.Optional;

public interface BaseUserService {

    DataResult<List<BaseUser>> findAllBaseUsers();

    DataResult<Optional<BaseUser>> findBaseUserById(Long id);

    DataResult<BaseUser> saveBaseUser(BaseUser baseUser);

    DataResult deleteBaseUser(Long id);
}
