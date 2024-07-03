package org.generation.joyaDelCaribe.model;

public class Producto {
	private Long idProducto;
	private String name;
	private String product;
	private Double price;
	private String image;
	private String category;
	private String description;
	private Double discount; //Descuento debe ser en decimal
	private Long idUser;
	private Long idOrden;
	
	public Producto(String name, String product, Double price, String image, String category, String description,
			Double discount, Long idUser, Long idOrden) {
		super();
		this.name = name;
		this.product = product;
		this.price = price;
		this.image = image;
		this.category = category;
		this.description = description;
		this.discount = discount;
		this.idUser = idUser;
		this.idOrden = idOrden;
	}

	public Producto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public Long getIdUser() {
		return idUser;
	}

	public Long getIdOrden() {
		return idOrden;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", name=" + name + ", product=" + product + ", price=" + price
				+ ", image=" + image + ", category=" + category + ", description=" + description + ", discount="
				+ discount + ", idUser=" + idUser + ", idOrden=" + idOrden + "]";
	}
		
}
