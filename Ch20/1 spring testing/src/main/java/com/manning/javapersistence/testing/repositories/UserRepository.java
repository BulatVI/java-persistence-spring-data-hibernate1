 package com.manning.javapersistence.testing.repositories;

import com.manning.javapersistence.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
