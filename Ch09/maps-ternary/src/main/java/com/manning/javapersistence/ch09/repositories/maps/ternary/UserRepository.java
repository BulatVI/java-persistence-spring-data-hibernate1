 
package com.manning.javapersistence.ch09.repositories.maps.ternary;

import com.manning.javapersistence.ch09.maps.ternary.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
