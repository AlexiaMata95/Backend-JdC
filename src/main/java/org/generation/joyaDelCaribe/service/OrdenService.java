package org.generation.joyaDelCaribe.service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.generation.joyaDelCaribe.model.Orden;
import org.generation.joyaDelCaribe.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {
	//List<Orden> listaOrden = new List<Orden>();
	public final OrdenRepository ordenRepository;
	
	
	@Autowired
	public OrdenService(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}//constructor
	

	public List<Orden> getAllOrdenes() {
		return ordenRepository.findAll();
	}//getAllOrdenes

	public Orden getOrden(Long id) {
		return ordenRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("La orden con el id [" + id + "] no existe"));
	}//getOrden

	public Orden deleteOrden(Long id) {
		Orden tmpOrden = null;
		if (ordenRepository.existsById(id)) {
			tmpOrden = ordenRepository.findById(id).get();
			ordenRepository.deleteById(id);
		}
		return tmpOrden;
	}//deleteOrden

	public Orden addOrden(Orden orden) {
		Optional<Orden> tmpOrden = ordenRepository.findByIdOrden(orden.getIdOrden());
		if (tmpOrden.isEmpty()) {
			return ordenRepository.save(orden);
		}else {
			System.out.println("La orden con el id ["+ orden.getIdOrden() +"] ya existe");
			return null;
		}
	}//addOrden

	public Orden updateOrden(Long id, Integer idUser, Date date, Integer quantity, Double price) {
		Orden tmpOrden = null;
			if(ordenRepository.existsById(id)) {
				Orden orden=ordenRepository.findById(id).get();
				if (idUser != null) { orden.setUsuarios_id(idUser); }
				if (date != null) { orden.setFecha(date); }
				if (quantity != null) { orden.setCantidad(quantity); }
				if (price != null) { orden.setPrecio(price); }
				ordenRepository.save(orden);
				tmpOrden=orden;
			}//if
		return tmpOrden;
	}//UpdateUorden
			
}//ClassOrdenService