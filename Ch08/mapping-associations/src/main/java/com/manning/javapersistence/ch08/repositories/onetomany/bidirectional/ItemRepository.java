 
package com.manning.javapersistence.ch08.repositories.onetomany.bidirectional;

import com.manning.javapersistence.ch08.onetomany.bidirectional.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
