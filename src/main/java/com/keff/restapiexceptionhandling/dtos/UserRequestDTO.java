package com.keff.restapiexceptionhandling.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserRequestDTO {

    @NotBlank
    private String name;
    @Email
    @NotBlank
    @UniqueValue(fieldName = "email", domainClass = User.class)
    private String email;
    @NotBlank
    @UniqueValue(fieldName = "cpf", domainClass = User.class)
    private String cpf;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    public User toEntity() {
        return new User(name, email, cpf, birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
