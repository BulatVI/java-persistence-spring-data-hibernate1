 package com.manning.javapersistence.querydsl.repositories;

import com.manning.javapersistence.querydsl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
