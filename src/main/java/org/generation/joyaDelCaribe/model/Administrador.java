package org.generation.joyaDelCaribe.model;






//POJO

@Entity //tabla
@Table(name="administrador")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@cOLUMN(name="id", unique=true, nullable=false)
	
	private int idOrden;
	@Column (nullable=false)
	private integer idUser;
	@Column (nullable=false)
	private Date date;
	@Column (nullable=false)
	private integer quantity;
	@Column (nullable=false)
	private double price;
	@Column (nullable=false)
	priate static int total = 0;
	@Column (nullable=false)


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
