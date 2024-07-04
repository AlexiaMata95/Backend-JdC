package org.generation.joyaDelCaribe.model;

public class Administrador {
	private String email;
	private String password;
	private int idAdmin;
	private static int total;
	
	public Administrador(String email, String password) {
		this.email = email;
		this.password = password;
		Administrador.total++;
		this.idAdmin = total;
		
	}

	public Administrador() {
		Administrador.total++;
		this.idAdmin = total;
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

	public int getIdAdmin() {
		return idAdmin;
	}

	@Override
	public String toString() {
		return "Administrador [Id=" + idAdmin + ", email=" + email + ", password=" + password + "]";
	};	
		
}
