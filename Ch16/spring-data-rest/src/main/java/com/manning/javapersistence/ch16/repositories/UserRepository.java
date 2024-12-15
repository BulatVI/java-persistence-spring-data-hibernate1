 package com.manning.javapersistence.ch16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;
import com.manning.javapersistence.ch16.model.User;

//@RepositoryRestResource(path = "users")
//@RepositoryRestResource(path = "users", exported = false)
public interface UserRepository extends JpaRepository<User, Long> {

//    @Override
//    @RestResource(exported = false)
//    void deleteById(Long id);
//
//    @Override
//    @RestResource(exported = false)
//    void delete(User entity);
}
