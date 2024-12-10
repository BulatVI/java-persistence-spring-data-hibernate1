 
package com.manning.javapersistence.ch08.repositories.embeddablesetofstrings;

import com.manning.javapersistence.ch08.embeddablesetofstrings.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
