package com.keff.restapiexceptionhandling.controllers;

import com.keff.restapiexceptionhandling.dtos.AddressRequestDTO;
import com.keff.restapiexceptionhandling.entities.Address;
import com.keff.restapiexceptionhandling.repositories.AddressRepository;
import com.keff.restapiexceptionhandling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressRequestDTO dto) {

        Address address = dto.toEntity(userRepository);
        addressRepository.save(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(address.toResponse());
    }
}
