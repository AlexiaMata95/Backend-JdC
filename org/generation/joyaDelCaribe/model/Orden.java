package org.generation.joyaDelCaribe.model;

public class Orden {
	private Long idOrden;
	private Long idUser;
	private String date;
	private int quantity;
	private double price;
	
	public Orden() {}

	public Orden(Long idUser, String date, int quantity, double price) {
		super();
		this.idUser = idUser;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getIdOrden() {
		return idOrden;
	}

	public Long getIdUser() {
		return idUser;
	}
	
	@Override
	public String toString() {
		return "Orden [id=" + idOrden + ", idUser=" + idUser + ", fecha=" + date + ", cantidad=" + quantity + ", precio="
				+ price + "]";
	};
	
	
}
