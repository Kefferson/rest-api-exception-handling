package com.keff.restapiexceptionhandling.repositories;

import com.keff.restapiexceptionhandling.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    public List<Address> findByUserId(Long userId);
}
