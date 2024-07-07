package org.generation.joyaDelCaribe.repository;
import java.util.Optional;

import org.generation.joyaDelCaribe.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>{
	Optional<Orden> findByIdOrden(Long idOrden);


	
}//interface OrdenRepository