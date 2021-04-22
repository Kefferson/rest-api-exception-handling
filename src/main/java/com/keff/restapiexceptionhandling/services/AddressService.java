package com.keff.restapiexceptionhandling.services;

import com.keff.restapiexceptionhandling.dtos.AddressRequestDTO;
import com.keff.restapiexceptionhandling.entities.Address;
import com.keff.restapiexceptionhandling.repositories.AddressRepository;
import com.keff.restapiexceptionhandling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    public Address saveAddress(AddressRequestDTO addressRequestDTO) {

        return addressRepository.save(addressRequestDTO.toEntity(userRepository));
    }

    public List<Address> findAddressList(Long userId) {

        return addressRepository.findByUserId(userId);
    }
}
