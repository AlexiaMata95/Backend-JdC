package org.generation.joyaDelCaribe.service;

import java.util.List;
import java.util.Optional;

import org.generation.joyaDelCaribe.model.OrdenTieneProductos;
import org.generation.joyaDelCaribe.model.OrdenTieneProductosKey;
import org.generation.joyaDelCaribe.repository.OrdenTieneProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenTieneProductosService {
	@Autowired
	private OrdenTieneProductosRepository repository;

	public List<OrdenTieneProductos> findAll() {
		return repository.findAll();
	}

	public Optional<OrdenTieneProductos> findById(OrdenTieneProductosKey id) {
		return repository.findById(id);
	}

    public OrdenTieneProductos deleteById(OrdenTieneProductosKey id) {
        Optional<OrdenTieneProductos> optionalOrdenTieneProductos = repository.findById(id);
        if (optionalOrdenTieneProductos.isPresent()) {
            OrdenTieneProductos ordenTieneProductos = optionalOrdenTieneProductos.get();
            repository.deleteById(id);
            return ordenTieneProductos;
        }
        return null;
    }

	public OrdenTieneProductos save(OrdenTieneProductos ordenTieneProductos) {
		return repository.save(ordenTieneProductos);
	}

	public OrdenTieneProductos updateCantidad(OrdenTieneProductosKey id, int cantidad) {
		Optional<OrdenTieneProductos> optionalOrdenTieneProductos = repository.findById(id);
		if (optionalOrdenTieneProductos.isPresent()) {
			OrdenTieneProductos ordenTieneProductos = optionalOrdenTieneProductos.get();
			ordenTieneProductos.setCantidad(cantidad);
			return repository.save(ordenTieneProductos);
		}
		return null;
	}
}
