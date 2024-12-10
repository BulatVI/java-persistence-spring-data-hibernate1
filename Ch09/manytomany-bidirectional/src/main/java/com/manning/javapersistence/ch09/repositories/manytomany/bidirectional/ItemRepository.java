 
package com.manning.javapersistence.ch09.repositories.manytomany.bidirectional;

import com.manning.javapersistence.ch09.manytomany.bidirectional.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
