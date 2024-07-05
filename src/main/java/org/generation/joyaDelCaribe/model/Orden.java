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
@Table(name="ordenes")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	
	private int idOrden;
	@Column(nullable=false)
	private Integer idUser;
	@Column(nullable=false)
	private Date date;
	@Column(nullable=false)
	private Integer quantity;
	@Column(nullable=false)
	private Double price;
	@Column(nullable=false)
	private static int total =0;
	@Column(nullable=false)
	
	public Orden(Integer idUser, Date date, Integer quantity, Double price) {
		super();
		this.idUser = idUser;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
		Orden.total++;
		idOrden = total;
	}
	
	public Orden() {
		Orden.total++;
		idOrden = total;
		}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public String toString() {
		return "Orden [id=" + idOrden + ", idUser=" + idUser + ", fecha=" + date + ", cantidad=" + quantity + ", precio="
				+ price + "]";
	};
	
	
}
