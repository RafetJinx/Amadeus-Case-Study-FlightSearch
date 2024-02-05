package com.example.FlightSearch.service.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.user.IndividualUser;

import java.util.List;
import java.util.Optional;

public interface IndividualUserService {

    DataResult<List<IndividualUser>> findAllIndividualUsers();

    DataResult<Optional<IndividualUser>> findIndividualUserById(Long id);

    DataResult<IndividualUser> saveIndividualUser(IndividualUser individualUser);

    DataResult deleteIndividualUser(Long id);
}
