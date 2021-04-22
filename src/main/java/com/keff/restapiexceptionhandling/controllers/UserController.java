package com.keff.restapiexceptionhandling.controllers;

import com.keff.restapiexceptionhandling.dtos.UserRequestDTO;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequestDTO dto) {

        User user = userService.saveUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user.toResponse());
    }
}
