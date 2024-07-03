package org.generation.joyaDelCaribe.model;

public class Administrador {
	private Long idAdmin;
	private String email;
	private String password;
	
	
	public Administrador(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Administrador() {}

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

	public Long getIdAdmin() {
		return idAdmin;
	}

	@Override
	public String toString() {
		return "Administrador [Id=" + idAdmin + ", email=" + email + ", password=" + password + "]";
	};	
		
}
