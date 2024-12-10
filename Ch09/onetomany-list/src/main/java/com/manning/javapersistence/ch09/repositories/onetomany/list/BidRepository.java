 
package com.manning.javapersistence.ch09.repositories.onetomany.list;

import com.manning.javapersistence.ch09.onetomany.list.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
