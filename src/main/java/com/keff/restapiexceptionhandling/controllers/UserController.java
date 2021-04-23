package com.keff.restapiexceptionhandling.controllers;

import com.keff.restapiexceptionhandling.dtos.UserRequestDTO;
import com.keff.restapiexceptionhandling.dtos.UserResponseDTO;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable Long id) {

        User user = userService.findById(id);

        return ResponseEntity.ok(user.toResponse());
    }

    @GetMapping
    public ResponseEntity<?> listUsers() {

        List<UserResponseDTO> userList = userService.findAll();

        if (userList.isEmpty()) {
            return ResponseEntity.ok("No users were found.");
        }

        return ResponseEntity.ok(userService.findAll());
    }
}
