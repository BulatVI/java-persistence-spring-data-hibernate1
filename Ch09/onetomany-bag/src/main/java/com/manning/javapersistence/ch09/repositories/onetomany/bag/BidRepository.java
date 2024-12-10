 
package com.manning.javapersistence.ch09.repositories.onetomany.bag;

import com.manning.javapersistence.ch09.onetomany.bag.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
