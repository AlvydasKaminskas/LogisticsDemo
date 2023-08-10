package eu.codeacademy.LogisticsDemo.repositories;

import eu.codeacademy.LogisticsDemo.entities.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailerRepository extends JpaRepository<Trailer, Long> {
}
