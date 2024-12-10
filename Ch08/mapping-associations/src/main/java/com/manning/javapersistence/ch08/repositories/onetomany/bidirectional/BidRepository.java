 
package com.manning.javapersistence.ch08.repositories.onetomany.bidirectional;

import com.manning.javapersistence.ch08.onetomany.bidirectional.Bid;
import com.manning.javapersistence.ch08.onetomany.bidirectional.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
