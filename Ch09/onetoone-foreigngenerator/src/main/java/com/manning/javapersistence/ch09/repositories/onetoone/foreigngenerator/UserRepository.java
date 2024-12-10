 
package com.manning.javapersistence.ch09.repositories.onetoone.foreigngenerator;

import com.manning.javapersistence.ch09.onetoone.foreigngenerator.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
