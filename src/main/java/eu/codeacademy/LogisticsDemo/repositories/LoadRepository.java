package eu.codeacademy.LogisticsDemo.repositories;

import eu.codeacademy.LogisticsDemo.entities.Load;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadRepository extends JpaRepository<Load, Long> {
}
