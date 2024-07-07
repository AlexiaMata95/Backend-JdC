package org.generation.joyaDelCaribe.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orden_tiene_productos")
public class OrdenTieneProductos {
	
	@EmbeddedId
    private OrdenTieneProductosKey id;

	@Column(nullable = false)
    private int cantidad;
	
	public OrdenTieneProductos() {}

	public OrdenTieneProductos(OrdenTieneProductosKey id, int cantidad) {
		this.id = id;
		this.cantidad = cantidad;
	}

	public OrdenTieneProductosKey getId() {
		return id;
	}

	public void setId(OrdenTieneProductosKey id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "OrdenTieneProductos [id=" + id + ", cantidad=" + cantidad + "]";
	}
}
