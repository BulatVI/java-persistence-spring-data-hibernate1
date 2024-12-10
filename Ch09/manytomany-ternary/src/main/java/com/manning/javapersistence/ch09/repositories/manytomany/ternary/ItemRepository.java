 
package com.manning.javapersistence.ch09.repositories.manytomany.ternary;

import com.manning.javapersistence.ch09.manytomany.ternary.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
