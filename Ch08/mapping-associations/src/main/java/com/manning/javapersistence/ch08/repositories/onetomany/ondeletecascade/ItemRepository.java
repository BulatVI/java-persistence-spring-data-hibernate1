 
package com.manning.javapersistence.ch08.repositories.onetomany.ondeletecascade;

import com.manning.javapersistence.ch08.onetomany.ondeletecascade.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i inner join fetch i.bids where i.id = :id")
    Item findItemWithBids(@Param("id") Long id);
}
