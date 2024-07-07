package org.generation.joyaDelCaribe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity //tabla en base de datos
@Table(name="orden_compras")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long idOrden;
	@Column(nullable=false)
	private Date fecha;
	@Column(nullable=false)
	private Integer cantidad;
	@Column(nullable=false)
	private Double precio;
	@Column(nullable=false)
	private Integer usuarios_id;

	public Orden(Integer usuarios_id, Date fecha, Integer cantidad, Double precio) {
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precio = precio;
		this.usuarios_id = usuarios_id;
	}

	public Orden() {}

	public Long getIdOrden() {
		return idOrden;
	}

	public Integer getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(Integer usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", usuarios_id=" + usuarios_id + ", fecha=" + fecha + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}
}