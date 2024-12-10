 
package com.manning.javapersistence.ch09.repositories.manytomany.ternary;

import com.manning.javapersistence.ch09.manytomany.ternary.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
