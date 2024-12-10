 
package com.manning.javapersistence.ch07.repositories;

import com.manning.javapersistence.ch07.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
