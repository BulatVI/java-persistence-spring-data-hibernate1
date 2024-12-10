 
package com.manning.javapersistence.ch09.repositories.onetomany.embeddable;

import com.manning.javapersistence.ch09.onetomany.embeddable.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
