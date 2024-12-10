 
package com.manning.javapersistence.ch09.repositories.onetoone.sharedprimarykey;

import com.manning.javapersistence.ch09.onetoone.sharedprimarykey.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
