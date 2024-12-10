 
package com.manning.javapersistence.ch09.repositories.onetoone.foreignkey;

import com.manning.javapersistence.ch09.onetoone.foreignkey.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
