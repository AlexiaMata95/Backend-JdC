package org.generation.joyaDelCaribe.repository;

import java.util.Optional;

import org.generation.joyaDelCaribe.model.Usuario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
}
