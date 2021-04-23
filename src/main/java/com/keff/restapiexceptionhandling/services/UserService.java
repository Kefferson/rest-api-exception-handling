package com.keff.restapiexceptionhandling.services;

import com.keff.restapiexceptionhandling.dtos.UserRequestDTO;
import com.keff.restapiexceptionhandling.dtos.UserResponseDTO;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserRequestDTO userRequestDTO) {

        return userRepository.save(userRequestDTO.toEntity());
    }

    public User findById(Long id) {

        Optional<User> possibleUser = userRepository.findById(id);

        if (possibleUser.isEmpty()) {
            throw new NoSuchElementException("User not found.");
        }

        return possibleUser.get();
    }

    public List<UserResponseDTO> findAll() {

        return userRepository.findAll()
                .stream()
                .map(User::toResponse)
                .collect(Collectors.toList());
    }
}
