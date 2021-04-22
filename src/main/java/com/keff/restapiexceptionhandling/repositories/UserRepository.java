package com.keff.restapiexceptionhandling.repositories;

import com.keff.restapiexceptionhandling.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
