package org.generation.joyaDelCaribe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrdenTieneProductosKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "orden_id", nullable = false)
	private Long orden_id;
	@Column(name = "orden_usuarios_id", nullable = false)
	private Long ordenUsuariosId;
	@Column(name = "productos_id", nullable = false)
	private Long productosId;
	
	public OrdenTieneProductosKey() {}

	public OrdenTieneProductosKey(Long orden_id, Long ordenUsuariosId, Long productosId) {
		this.orden_id = orden_id;
		this.ordenUsuariosId = ordenUsuariosId;
		this.productosId = productosId;
	}

	public Long getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(Long orden_id) {
		this.orden_id = orden_id;
	}

	public Long getOrdenUsuariosId() {
		return ordenUsuariosId;
	}

	public void setOrdenUsuariosId(Long ordenUsuariosId) {
		this.ordenUsuariosId = ordenUsuariosId;
	}

	public Long getProductosId() {
		return productosId;
	}

	public void setProductosId(Long productosId) {
		this.productosId = productosId;
	}
}
