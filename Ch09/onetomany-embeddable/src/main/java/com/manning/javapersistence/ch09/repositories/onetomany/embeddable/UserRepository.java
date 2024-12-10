 
package com.manning.javapersistence.ch09.repositories.onetomany.embeddable;

import com.manning.javapersistence.ch09.onetomany.embeddable.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
