 
package com.manning.javapersistence.ch08.repositories.onetomany.cascadepersist;

import com.manning.javapersistence.ch08.onetomany.cascadepersist.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
