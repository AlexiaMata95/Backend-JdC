package org.generation.joyaDelCaribe.model;

import java.util.Date;

public class Orden {
	private int idOrden;
	private Integer idUser;
	private Date date;
	private Integer quantity;
	private Double price;
	private static int total =0;
	
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
