 
package com.manning.javapersistence.ch09.repositories.onetoone.foreigngenerator;

import com.manning.javapersistence.ch09.onetoone.foreigngenerator.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
