package org.generation.joyaDelCaribe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.main.java.org.generation.joyaDelCaribe.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
	Optional<Orden> findByDate(Date date);

}// interface OrdenRepository
