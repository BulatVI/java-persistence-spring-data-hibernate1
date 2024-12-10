 
package com.manning.javapersistence.ch08.repositories.onetomany.ondeletecascade;

import com.manning.javapersistence.ch08.onetomany.ondeletecascade.Bid;
import com.manning.javapersistence.ch08.onetomany.ondeletecascade.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
