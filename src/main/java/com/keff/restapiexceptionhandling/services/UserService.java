package com.keff.restapiexceptionhandling.services;

import com.keff.restapiexceptionhandling.dtos.UserRequestDTO;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserRequestDTO userRequestDTO) {

        return userRepository.save(userRequestDTO.toEntity());
    }
}
