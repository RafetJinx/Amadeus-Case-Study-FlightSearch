package com.example.FlightSearch.api.controller.user;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;
import com.example.FlightSearch.model.user.BaseUser;
import com.example.FlightSearch.service.user.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/baseUsers")
public class BaseUserController {

    private final BaseUserService baseUserService;

    @Autowired
    public BaseUserController(BaseUserService baseUserService) {
        this.baseUserService = baseUserService;
    }

    @GetMapping("/")
    public ResponseEntity<DataResult<List<BaseUser>>> getAll() {
        DataResult<List<BaseUser>> result = baseUserService.findAllBaseUsers();
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Optional<BaseUser>>> getById(@PathVariable Long id) {
        DataResult<Optional<BaseUser>> result = baseUserService.findBaseUserById(id);
        return result.getData() != null
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<DataResult<BaseUser>> add(@Valid @RequestBody BaseUser baseUser) {
        DataResult<BaseUser> result = baseUserService.saveBaseUser(baseUser);
        return result.isSuccess()
                ? ResponseEntity.created(URI.create(String.format("/api/baseUsers/%s", result.getData().getId()))).body(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<BaseUser>> update(@PathVariable Long id, @Valid @RequestBody BaseUser baseUser) {
        baseUser.setId(id);
        DataResult<BaseUser> result = baseUserService.saveBaseUser(baseUser);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResult<Void>> delete(@PathVariable Long id) {
        DataResult<Void> result = baseUserService.deleteBaseUser(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
