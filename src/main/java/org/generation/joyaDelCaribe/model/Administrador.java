package org.generation.joyaDelCaribe.model;
//POJO

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //tabla
@Table(name="administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idadministrador", unique=true, nullable=false)
	private Long idAdmin;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	public Administrador(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Administrador() {}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", email=" + email + ", password=" + password + "]";
	}
}