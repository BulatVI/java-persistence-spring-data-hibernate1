 
package com.manning.javapersistence.ch09.repositories.onetomany.embeddablejointable;

import com.manning.javapersistence.ch09.onetomany.embeddablejointable.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
