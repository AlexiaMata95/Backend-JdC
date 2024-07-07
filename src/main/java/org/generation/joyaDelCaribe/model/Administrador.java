package org.generation.joyaDelCaribe.model;
//POJO

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //tabla
@Table(name="administradores")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long idAdmin;
	@Column(nullable = false)
	private String correo;
	@Column(nullable = false)
	private String contrasena;
	
	public Administrador(String correo, String contrasena) {
		super();
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Administrador() {}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}

	
}