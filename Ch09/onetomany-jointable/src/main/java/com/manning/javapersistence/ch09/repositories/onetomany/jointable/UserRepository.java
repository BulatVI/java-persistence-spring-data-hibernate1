 
package com.manning.javapersistence.ch09.repositories.onetomany.jointable;

import com.manning.javapersistence.ch09.onetomany.jointable.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
