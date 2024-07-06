package org.generation.joyaDelCaribe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproductos", unique=true, nullable=false)
	private Long idproductos;
	@Column(nullable=true)
	private String name;
	@Column(nullable=true)
	private String product;
	@Column(nullable=false)
	private Double price;
	@Column(nullable=false)
	private String img;
	@Column(nullable=false)
	private String category;
	@Column(nullable=true)
	private String description;
	@Column(nullable=true)
	private Double discount;//Descuento debe ser en decimal
	@Column(nullable=false)
	private Integer idorden;
	@Column(nullable=false)
	private Integer idusuario;


	public Producto(String name, String product, Double price, String image, String category, String description,
			Double discount, Integer idUser, Integer idOrden) {
		this.name = name;
		this.product = product;
		this.price = price;
		this.img = image;
		this.category = category;
		this.description = description;
		this.discount = discount;
		this.idusuario = idUser;
		this.idorden = idOrden;
	}

	public Producto() {
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
		return img;
	}

	public void setImage(String image) {
		this.img = image;
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
		return idproductos;
	}

	public Integer getIdUser() {
		return idusuario;
	}

	//public void setIdUser(Integer idUser) {
	//	this.idusuario = idUser;
	//}

	public Integer getIdOrden() {
		return idorden;
	}
	
	//public void setIdOrden(Integer idOrden) {
	//	this.idorden = idOrden;
	//}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idproductos + ", name=" + name + ", product=" + product + ", price=" + price
				+ ", image=" + img + ", category=" + category + ", description=" + description + ", discount="
				+ discount + ", idUser=" + idusuario + ", idOrden=" + idorden + "]";
	}
		
}