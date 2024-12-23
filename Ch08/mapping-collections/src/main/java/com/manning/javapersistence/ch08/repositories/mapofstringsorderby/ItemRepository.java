 
package com.manning.javapersistence.ch08.repositories.mapofstringsorderby;

import com.manning.javapersistence.ch08.mapofstringsorderby.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i inner join fetch i.images where i.id = :id")
    Item findItemWithImages(@Param("id") Long id);

    @Query(value = "SELECT FILENAME FROM IMAGE WHERE ITEM_ID = ?1",
            nativeQuery = true)
    Set<String> findImagesNative(Long id);
}
