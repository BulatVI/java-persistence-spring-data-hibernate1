 
package com.manning.javapersistence.ch09.repositories.maps.ternary;

import com.manning.javapersistence.ch09.maps.ternary.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
