package org.generation.joyaDelCaribe.model;

public class Usuario {
	private Long idUser;
	private String name;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	
	public Usuario(Long id, String name, String lastName, String phone, String email, String password) {
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public Usuario() {}

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
		return "Usuario [id=" + idUser + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", email="
				+ email + ", password=" + password + "]";
	}
	
		
}
