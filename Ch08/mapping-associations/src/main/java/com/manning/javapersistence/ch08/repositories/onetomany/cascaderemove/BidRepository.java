 
package com.manning.javapersistence.ch08.repositories.onetomany.cascaderemove;

import com.manning.javapersistence.ch08.onetomany.cascaderemove.Bid;
import com.manning.javapersistence.ch08.onetomany.cascaderemove.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
