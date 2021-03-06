package com.keff.restapiexceptionhandling.dtos;

import com.keff.restapiexceptionhandling.entities.Address;
import com.keff.restapiexceptionhandling.entities.User;
import com.keff.restapiexceptionhandling.repositories.UserRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AddressRequestDTO {

    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String district;
    private String addOn;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zipCode;
    @NotNull
    private Long userId;

    public Address toEntity(UserRepository userRepository) {

        Optional<User> possibleUser = userRepository.findById(userId);

        if (possibleUser.isEmpty()) {
            throw new NoSuchElementException("User not found.");
        }

        User user = possibleUser.get();

        return new Address(street, number, district, addOn, city, state, zipCode, user);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
