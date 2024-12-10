 
package com.manning.javapersistence.ch09.repositories.onetoone.jointable;

import com.manning.javapersistence.ch09.onetoone.jointable.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
