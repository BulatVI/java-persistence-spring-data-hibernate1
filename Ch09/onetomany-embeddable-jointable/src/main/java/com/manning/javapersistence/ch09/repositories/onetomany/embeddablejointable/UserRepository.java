 
package com.manning.javapersistence.ch09.repositories.onetomany.embeddablejointable;

import com.manning.javapersistence.ch09.onetomany.embeddablejointable.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
