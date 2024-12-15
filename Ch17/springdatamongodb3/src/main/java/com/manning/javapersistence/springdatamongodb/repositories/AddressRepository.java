 package com.manning.javapersistence.springdatamongodb.repositories;

import com.manning.javapersistence.springdatamongodb.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
