package src.main.java.org.generation.joyaDelCaribe.repository;
import java.util.Optional;

import org.generation.ecommerce.model.Categoria;
import org.generation.ecommerce.model.Orden;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
	Optional<Orden> findByNombre(String nombre);
	
}
