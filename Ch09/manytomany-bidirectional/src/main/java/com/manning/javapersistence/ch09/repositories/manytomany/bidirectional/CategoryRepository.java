 
package com.manning.javapersistence.ch09.repositories.manytomany.bidirectional;

import com.manning.javapersistence.ch09.manytomany.bidirectional.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
