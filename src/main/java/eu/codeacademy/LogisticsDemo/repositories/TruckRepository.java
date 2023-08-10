package eu.codeacademy.LogisticsDemo.repositories;

import eu.codeacademy.LogisticsDemo.dto.TruckDTO;
import eu.codeacademy.LogisticsDemo.entities.Truck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
    Page<Truck> findTrucksByModel(String model, Pageable pageable);
}
