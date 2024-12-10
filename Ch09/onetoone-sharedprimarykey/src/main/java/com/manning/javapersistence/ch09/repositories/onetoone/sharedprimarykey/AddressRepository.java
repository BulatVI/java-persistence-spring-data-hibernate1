 
package com.manning.javapersistence.ch09.repositories.onetoone.sharedprimarykey;

import com.manning.javapersistence.ch09.onetoone.sharedprimarykey.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
