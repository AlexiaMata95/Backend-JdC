package org.generation.joyaDelCaribe.repository;

import java.util.Optional;

import org.generation.joyaDelCaribe.model.Administrador;
import org.generation.joyaDelCaribe.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
	Optional<Administrador> findByCorreo(String correo);
}
