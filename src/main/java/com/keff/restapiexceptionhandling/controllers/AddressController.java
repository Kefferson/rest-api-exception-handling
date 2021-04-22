package com.keff.restapiexceptionhandling.controllers;

import com.keff.restapiexceptionhandling.dtos.AddressRequestDTO;
import com.keff.restapiexceptionhandling.dtos.AddressResponseDTO;
import com.keff.restapiexceptionhandling.entities.Address;
import com.keff.restapiexceptionhandling.repositories.AddressRepository;
import com.keff.restapiexceptionhandling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> listAdresses(@PathVariable Long userId) {

        List<Address> addressList = addressRepository.findByUserId(userId);

        if (addressList.isEmpty()) {
            return ResponseEntity.ok().body("There are no addresses registered by this user.");
        }

        List<AddressResponseDTO> responseList = addressList
                .stream()
                .map(Address::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(responseList);
    }
}
