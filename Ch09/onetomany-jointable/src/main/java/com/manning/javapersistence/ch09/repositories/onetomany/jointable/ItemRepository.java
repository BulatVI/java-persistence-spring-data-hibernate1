 
package com.manning.javapersistence.ch09.repositories.onetomany.jointable;

import com.manning.javapersistence.ch09.onetomany.jointable.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
