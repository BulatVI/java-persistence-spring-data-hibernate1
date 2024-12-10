 
package com.manning.javapersistence.ch09.repositories.manytomany.linkedentity;

import com.manning.javapersistence.ch09.manytomany.linkedentity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
