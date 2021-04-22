package com.keff.restapiexceptionhandling.entities;

import com.keff.restapiexceptionhandling.dtos.UserResponseDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthdate;
    private @CreationTimestamp LocalDateTime createdAt;
    private @UpdateTimestamp LocalDateTime updatedAt;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    public UserResponseDTO toResponse() {
        return new UserResponseDTO(name, email, cpf, birthdate);
    }

    @Deprecated
    public User() {
    }

    public User(String name, String email, String cpf, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }
}
