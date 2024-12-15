 package com.manning.javapersistence.ch15.repositories;

import com.manning.javapersistence.ch15.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressEmbeddedRepository extends CrudRepository<User, Long> {

}
