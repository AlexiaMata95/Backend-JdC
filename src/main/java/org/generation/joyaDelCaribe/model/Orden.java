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
@Table(name="orden")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long idOrden;
	@Column(nullable=false)
	private Date fecha;
	@Column(nullable=false)
	private Double total;
	@Column(nullable=false)
	private Integer usuarios_id;

	public Orden(Date fecha, Double total, Integer usuarios_id) {
		this.fecha = fecha;
		this.total = total;
		this.usuarios_id = usuarios_id;
	}

	public Orden() {}

	public Long getIdOrden() {
		return idOrden;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(Integer usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", fecha=" + fecha + ", total=" + total + ", usuarios_id=" + usuarios_id
				+ "]";
	}
}