package org.generation.joyaDelCaribe.service;

import java.util.ArrayList;
import java.util.Date;

import org.generation.joyaDelCaribe.model.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {
	ArrayList<Orden> listaOrden = new ArrayList<Orden>();
	
	@Autowired
	public OrdenService() { // Va a agregarle datos a la lista 
		listaOrden.add( new Orden(3,new Date(), 4, 1250.78));
		listaOrden.add( new Orden(2,new Date(), 10, 3650.98));
		listaOrden.add( new Orden(8,new Date(), 1, 299.3));
		listaOrden.add( new Orden(4,new Date(), 5, 1580.42));
	}

	public ArrayList<Orden> getAllOrdenes() {
		return listaOrden;
	}

	public Orden getOrden(int id) {
		Orden tmpOrden = null;
		for (Orden orden : listaOrden) {
			if(orden.getIdOrden() == id) {
				tmpOrden = orden;
				break;
			}
		}
		return tmpOrden;
	}

	public Orden deleteOrden(int id) {
		Orden tmpOrden = null;
		for (Orden orden : listaOrden) {
			if(orden.getIdOrden() == id) {
				tmpOrden = orden;
				listaOrden.remove(listaOrden.indexOf(orden));
				break;
			}
		}
		return tmpOrden;
	}

	public Orden addOrden(Orden orden) {
		Orden tmpOrden = null;
		boolean ordenExists = false;
		for (Orden ord : listaOrden) {
			if(ord.getIdOrden() == orden.getIdOrden()) {
				ordenExists = true;
				break;
			}
		}
		if(!ordenExists) {
			listaOrden.add(orden);
			tmpOrden = orden;
		}
		return tmpOrden;
	}

	public Orden updateOrden(int id, Integer idUser, Date date, Integer quantity, Double price) {
		Orden tmpOrden = null;
		for (Orden orden : listaOrden) {
			if(orden.getIdOrden() == id) {
				if (idUser != null) { orden.setIdUser(idUser); }
				if (date != null) { orden.setDate(date); }
				if (quantity != null) { orden.setQuantity(quantity); }
				if (price != null) { orden.setPrice(price); }
				tmpOrden = orden;
				break;
			}
		}
		return tmpOrden;
	}
			
}
