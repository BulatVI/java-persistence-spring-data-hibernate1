package com.manning.javapersistence.ch08.repositories.onetomany.orphanremoval;

import com.manning.javapersistence.ch08.onetomany.orphanremoval.Bid;
import com.manning.javapersistence.ch08.onetomany.orphanremoval.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
