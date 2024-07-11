package org.generation.joyaDelCaribe.controllers;

import java.util.List;
import java.util.Optional;

import org.generation.joyaDelCaribe.dto.OrdenTieneProductoDTO;
import org.generation.joyaDelCaribe.model.OrdenTieneProductos;
import org.generation.joyaDelCaribe.model.OrdenTieneProductosKey;
import org.generation.joyaDelCaribe.service.OrdenTieneProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"http://127.0.0.1:5501/", "https://baomasu.github.io/JoyaDelCaribe/"})
@RestController
@RequestMapping("/api/orden-tiene-productos")
public class OrdenTieneProductosController {

	@Autowired
	private OrdenTieneProductosService service;

	@GetMapping
	public List<OrdenTieneProductos> getAll() {
		return service.findAll();
	}

	@GetMapping("/{ordenId}/{ordenUsuariosId}/{productosId}")
	public Optional<OrdenTieneProductos> getById(@PathVariable Long ordenId, @PathVariable Long ordenUsuariosId,
			@PathVariable Long productosId) {
		OrdenTieneProductosKey id = new OrdenTieneProductosKey(ordenId, ordenUsuariosId, productosId);
		return service.findById(id);
	}

	@DeleteMapping("/{ordenId}/{ordenUsuariosId}/{productosId}")
	public OrdenTieneProductos delete(@PathVariable Long ordenId, @PathVariable Long ordenUsuariosId,
			@PathVariable Long productosId) {
		OrdenTieneProductosKey id = new OrdenTieneProductosKey(ordenId, ordenUsuariosId, productosId);
		return service.deleteById(id);
	}

	@PostMapping
	public OrdenTieneProductos create(@RequestBody OrdenTieneProductoDTO ordenTieneProductosDTO) {
		OrdenTieneProductosKey id = new OrdenTieneProductosKey(ordenTieneProductosDTO.getOrdenId(),
				ordenTieneProductosDTO.getOrdenUsuariosId(), ordenTieneProductosDTO.getProductosId());
		OrdenTieneProductos ordenTieneProductos = new OrdenTieneProductos(id, ordenTieneProductosDTO.getCantidad());
		return service.save(ordenTieneProductos);
	}

	@PutMapping("/{ordenId}/{ordenUsuariosId}/{productosId}/{cantidad}")
	public OrdenTieneProductos updateCantidad(@PathVariable Long ordenId, @PathVariable Long ordenUsuariosId,
			@PathVariable Long productosId, @PathVariable int cantidad) {
		OrdenTieneProductosKey id = new OrdenTieneProductosKey(ordenId, ordenUsuariosId, productosId);
		return service.updateCantidad(id, cantidad);
	}
}
