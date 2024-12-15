 package com.manning.javapersistence.ch15.repositories;

import com.manning.javapersistence.ch15.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressOneToOneRepository extends CrudRepository<Address, Long> {

}
