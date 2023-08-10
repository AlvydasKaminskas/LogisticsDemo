package eu.codeacademy.LogisticsDemo.repositories;

import eu.codeacademy.LogisticsDemo.entities.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
}
