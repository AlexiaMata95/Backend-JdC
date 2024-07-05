package org.generation.joyaDelCaribe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long idUser;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String phone;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	
	public Usuario(String name, String lastName, String phone, String email, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public Usuario() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Long getIdUser() {
		return idUser;
	}

	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + "]";
	}	
}
