 package com.manning.javapersistence.hibernateogm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Address {

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String zipcode;

    @Getter
    @Setter
    private String city;

    public Address(String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }
}
