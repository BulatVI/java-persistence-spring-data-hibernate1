 
package com.manning.javapersistence.ch08.repositories.onetomany.cascaderemove;

import com.manning.javapersistence.ch08.onetomany.cascaderemove.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
