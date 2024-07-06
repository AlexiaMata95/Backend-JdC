package org.generation.joyaDelCaribe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity
@Table(name="productss")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long idproductos;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String product;
	@Column(nullable=false)
	private Double price;
	@Column(nullable=false)
	private String img;
	@Column(nullable=false)
	private String category;

	private String description;

	private Double discount;//Descuento debe ser en decimal
	@Column(nullable=false)
	private Integer idorden;
	@Column(nullable=false)
	private Integer idusuario;




	public Producto(String name, String product, Double price, String img, String category, String description,
			Double discount, Integer idorden, Integer idusuario) {
		super();
		this.name = name;
		this.product = product;
		this.price = price;
		this.img = img;
		this.category = category;
		this.description = description;
		this.discount = discount;
		this.idorden = idorden;
		this.idusuario = idusuario;
	}

	public Producto() {
	}

	public Long getIdproductos() {
		return idproductos;
	}

	public void setIdproductos(Long idproductos) {
		this.idproductos = idproductos;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public Integer getIdorden() {
		return idorden;
	}

	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Override
	public String toString() {
		return "Producto [idproductos=" + idproductos + ", name=" + name + ", product=" + product + ", price=" + price
				+ ", img=" + img + ", category=" + category + ", description=" + description + ", discount=" + discount
				+ ", idorden=" + idorden + ", idusuario=" + idusuario + "]";
	}
	
	



		
}