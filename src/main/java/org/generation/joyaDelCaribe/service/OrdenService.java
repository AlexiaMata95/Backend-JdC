package org.generation.joyaDelCaribe.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.org.generation.joyaDelCaribe.model.Orden;
import src.main.java.org.generation.joyaDelCaribe.repository.OrdenRepository;

@Service
public class OrdenService {
	List<Orden> listaOrden = new List<Orden>();

	// @Autowired
	// public OrdenService() { // Va a agregarle datos a la lista
	// listaOrden.add( new Orden(3,new Date(), 4, 1250.78));
	// listaOrden.add( new Orden(2,new Date(), 10, 3650.98));
	// listaOrden.add( new Orden(8,new Date(), 1, 299.3));
	// listaOrden.add( new Orden(4,new Date(), 5, 1580.42));
	// }//Constructor

	@Autowired
	public OrdenService(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}// constructor

	public List<Orden> getAllOrdenes() {
		return listaOrden;
	}// getAllOrdenes

	public Orden getOrden(int id) {
		Orden tmpOrden = null;
		for (Orden orden : listaOrden) {
			if (orden.getIdOrden() == id) {
				tmpOrden = orden;
				break;
			} // if
		} // for
		return tmpOrden;
	}// getOrden

	public Orden deleteOrden(int id) {
		Orden tmpOrden = null;
		for (Orden orden : listaOrden) {
			if (orden.getIdOrden() == id) {
				tmpOrden = orden;
				listaOrden.remove(listaOrden.indexOf(orden));
				break;
			} // if
		} // for
		return tmpOrden;
	}// deleteOrden

	public Orden addOrden(Orden orden) {
		Orden tmpOrden = null;
		boolean ordenExists = false;
		for (Orden ord : listaOrden) {
			if (ord.getIdOrden() == orden.getIdOrden()) {
				ordenExists = true;
				break;
			} // if
		} // for
		if (!ordenExists) {
			listaOrden.add(orden);
			tmpOrden = orden;
		} // if
		return tmpOrden;
	}// addOrden

	public Orden updateOrden(int id, Integer idUser, Date date, Integer quantity, Double price) {
		Orden tmpOrden = null;
		for (Orden orden : listaOrden) {
			if (orden.getIdOrden() == id) {
				if (idUser != null) {
					orden.setIdUser(idUser);
				}
				if (date != null) {
					orden.setDate(date);
				}
				if (quantity != null) {
					orden.setQuantity(quantity);
				}
				if (price != null) {
					orden.setPrice(price);
				}
				tmpOrden = orden;
				break;
			} // if
		} // for
		return tmpOrden;
	}// UpdateUorden

}// ClassOrdenService
