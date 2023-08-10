package eu.codeacademy.LogisticsDemo.repositories;

import eu.codeacademy.LogisticsDemo.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}
