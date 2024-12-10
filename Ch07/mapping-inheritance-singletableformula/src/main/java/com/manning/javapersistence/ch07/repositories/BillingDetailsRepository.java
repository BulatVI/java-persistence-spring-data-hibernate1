package com.manning.javapersistence.ch07.repositories;

import com.manning.javapersistence.ch07.model.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingDetailsRepository<T extends BillingDetails, ID> extends JpaRepository<T, ID> {
    List<T> findByOwner(String owner);
}
