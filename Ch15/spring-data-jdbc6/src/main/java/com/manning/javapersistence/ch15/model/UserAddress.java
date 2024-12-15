 package com.manning.javapersistence.ch15.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("USERS_ADDRESSES")
public class UserAddress {

    private Long addressId;

    public UserAddress(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return addressId;
    }
}
