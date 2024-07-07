package org.generation.joyaDelCaribe.controllers;

import java.util.List;
import java.util.Date;

import org.generation.joyaDelCaribe.model.Orden;
import org.generation.joyaDelCaribe.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/ordenes/")
public class OrdenController {
	private final OrdenService ordenService;
	
	@Autowired
	public OrdenController(OrdenService ordenService) {
		this.ordenService = ordenService;
	}
	
	@GetMapping
	public List<Orden> getOrdenes(){
		return ordenService.getAllOrdenes();
	}
	
	@GetMapping(path = "{ordenId}")
	public Orden getOrden(@PathVariable("ordenId") Long id) {
		return ordenService.getOrden(id);
	}
	
	@DeleteMapping(path = "{ordenId}")
	public Orden deleteOrden(@PathVariable("ordenId") Long id) {
		return ordenService.deleteOrden(id);
	}
	
	@PostMapping
	public Orden addOrden(@RequestBody Orden orden) {
		return ordenService.addOrden(orden);
	}
	
	@PutMapping(path = "{ordenId}")
	public Orden updateOrden(@PathVariable("ordenId") Long id,
			@RequestParam(required = false) Date fecha,
			@RequestParam(required = false) Integer cantidad,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) Integer usuarios_id)
	{
		return ordenService.updateOrden(id, usuarios_id, fecha, cantidad, precio);
	}
	
}//class OrdenController
