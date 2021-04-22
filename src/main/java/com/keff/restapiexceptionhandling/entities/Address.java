package com.keff.restapiexceptionhandling.entities;

import com.keff.restapiexceptionhandling.dtos.AddressResponseDTO;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String district;
    private String addOn;
    private String city;
    private String state;
    private String zipCode;
    @ManyToOne
    private User user;

    public AddressResponseDTO toResponse() {
        return new AddressResponseDTO(street, number, district, addOn, city, state, zipCode);
    }

    @Deprecated
    public Address() {
    }

    public Address(String street, String number, String district, String addOn, String city, String state, String zipCode, User user) {
        this.street = street;
        this.number = number;
        this.district = district;
        this.addOn = addOn;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
}
