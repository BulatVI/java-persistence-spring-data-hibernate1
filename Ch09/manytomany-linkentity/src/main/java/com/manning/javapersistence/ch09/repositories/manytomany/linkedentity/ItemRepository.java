 
package com.manning.javapersistence.ch09.repositories.manytomany.linkedentity;

import com.manning.javapersistence.ch09.manytomany.linkedentity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
