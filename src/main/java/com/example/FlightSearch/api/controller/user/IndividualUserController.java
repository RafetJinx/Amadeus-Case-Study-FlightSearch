package com.example.FlightSearch.api.controller.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.user.IndividualUser;
import com.example.FlightSearch.service.user.IndividualUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/individualUsers")
public class IndividualUserController {

    private final IndividualUserService individualUserService;

    @Autowired
    public IndividualUserController(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<IndividualUser>>> getAll() {
        DataResult<List<IndividualUser>> result = individualUserService.findAllIndividualUsers();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<IndividualUser>>> getById(@PathVariable Long id) {
        DataResult<Optional<IndividualUser>> result = individualUserService.findIndividualUserById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<IndividualUser>> add(@Valid @RequestBody IndividualUser individualUser) {
        DataResult<IndividualUser> result = individualUserService.saveIndividualUser(individualUser);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/individualUsers/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<IndividualUser>> update(@PathVariable Long id, @Valid @RequestBody IndividualUser individualUser) {
        individualUser.setId(id);
        DataResult<IndividualUser> result = individualUserService.saveIndividualUser(individualUser);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = individualUserService.deleteIndividualUser(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
