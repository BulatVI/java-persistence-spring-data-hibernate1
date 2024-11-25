package com.manning.javapersistence.springdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.manning.javapersistence.springdatajpa.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
