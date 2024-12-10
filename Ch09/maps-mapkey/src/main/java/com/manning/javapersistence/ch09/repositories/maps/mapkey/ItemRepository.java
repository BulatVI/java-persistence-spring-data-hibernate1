 
package com.manning.javapersistence.ch09.repositories.maps.mapkey;

import com.manning.javapersistence.ch09.maps.mapkey.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
