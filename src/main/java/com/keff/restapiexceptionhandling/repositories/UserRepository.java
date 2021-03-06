package com.keff.restapiexceptionhandling.repositories;

import com.keff.restapiexceptionhandling.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
