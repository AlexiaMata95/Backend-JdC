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
	@Column(name="id", unique=true, nullable=false)
	private Long idproductos;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String producto;
	@Column(nullable=false)
	private Double precio;
	@Column(nullable=false)
	private String imagen;
	@Column(nullable=false)
	private String categoria;
	private String descripcion;
	private Double descuento;//Descuento debe ser en decimal

	public Producto(String nombre, String producto, Double precio, String imagen, String categoria, String descripcion,
			Double descuento) {
		this.nombre = nombre;
		this.producto = producto;
		this.precio = precio;
		this.imagen = imagen;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.descuento = descuento;
	}

	public Producto() {}

	public Long getIdproductos() {
		return idproductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Producto [idproductos=" + idproductos + ", nombre=" + nombre + ", producto=" + producto + ", precio="
				+ precio + ", imagen=" + imagen + ", categoria=" + categoria + ", descripcion=" + descripcion
				+ ", descuento=" + descuento + ", orden_compras_id=" + "]";
	}
}