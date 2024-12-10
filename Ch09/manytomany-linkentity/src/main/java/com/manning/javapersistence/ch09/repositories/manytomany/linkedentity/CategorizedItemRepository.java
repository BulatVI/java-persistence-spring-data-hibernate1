 
package com.manning.javapersistence.ch09.repositories.manytomany.linkedentity;

import com.manning.javapersistence.ch09.manytomany.linkedentity.CategorizedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorizedItemRepository extends JpaRepository<CategorizedItem, CategorizedItem.Id> {
}
