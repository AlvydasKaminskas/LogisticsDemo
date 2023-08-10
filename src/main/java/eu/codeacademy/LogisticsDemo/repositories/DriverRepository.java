package eu.codeacademy.LogisticsDemo.repositories;

import eu.codeacademy.LogisticsDemo.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
