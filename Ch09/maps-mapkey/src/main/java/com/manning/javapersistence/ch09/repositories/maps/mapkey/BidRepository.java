 

package com.manning.javapersistence.ch09.repositories.maps.mapkey;

import com.manning.javapersistence.ch09.maps.mapkey.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
