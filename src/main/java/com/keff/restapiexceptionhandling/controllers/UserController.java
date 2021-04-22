package com.keff.restapiexceptionhandling.controllers;

import com.keff.restapiexceptionhandling.dtos.UserDTO;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String createUser(@RequestBody @Valid UserDTO dto) {

        User user = dto.toEntity();
        userRepository.save(user);

        return "User created";
    }
}