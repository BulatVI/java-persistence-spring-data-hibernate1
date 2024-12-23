 
package com.manning.javapersistence.ch08.repositories.onetomany.cascadepersist;

import com.manning.javapersistence.ch08.onetomany.cascadepersist.Bid;
import com.manning.javapersistence.ch08.onetomany.cascadepersist.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
