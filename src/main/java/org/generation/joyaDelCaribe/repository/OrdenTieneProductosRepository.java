package org.generation.joyaDelCaribe.repository;

import org.generation.joyaDelCaribe.model.OrdenTieneProductos;
import org.generation.joyaDelCaribe.model.OrdenTieneProductosKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenTieneProductosRepository extends JpaRepository<OrdenTieneProductos, OrdenTieneProductosKey>{

}
