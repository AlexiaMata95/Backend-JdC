package org.generation.joyaDelCaribe.service;

import java.util.List;

import org.generation.joyaDelCaribe.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class AdministradorService {
	List<Administrador> listaAdmin = new ArrayList<Administrador>();
	

	@Autowired
	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}//constructor
	/*
	public AdministradorService() { // Va a agregarle datos a la lista 
		listaAdmin.add( new Administrador("alexia@bootcamp.com", "UnaContra12"));
		listaAdmin.add( new Administrador("alan@bootcamp.com", "UnaContra13"));
		listaAdmin.add( new Administrador("esdras@bootcamp.com", "UnaContra14"));
		listaAdmin.add( new Administrador("diana@bootcamp.com", "UnaContra15"));
	}
	*/

	public ArrayList<Administrador> getAllAdmins() {
		return listaAdmin;
	}

	public Administrador getAdmin(int id) {
		Administrador tmpAdmin = null;
		for (Administrador administrador : listaAdmin) {
			if(administrador.getIdAdmin() == id) {
				tmpAdmin = administrador;
				break;
			}
		}
		return tmpAdmin;
	}

	public Administrador deleteAdmin(int id) {
		Administrador tmpAdmin = null;
		for (Administrador administrador : listaAdmin) {
			if(administrador.getIdAdmin() == id) {
				tmpAdmin = administrador;
				listaAdmin.remove(listaAdmin.indexOf(administrador));
				break;
			}
		}
		return tmpAdmin;
	}

	public Administrador addAdmin(Administrador admin) {
		Administrador tmpAdmin = null;
		boolean adminExists = false;
		for (Administrador administrador : listaAdmin) {
			if(administrador.getEmail().equals(admin.getEmail())) {
				adminExists = true;
				break;
			}
		}
		if(!adminExists) {
			listaAdmin.add(admin);
			tmpAdmin = admin;
		}
		return tmpAdmin;
	}

	public Administrador updateAdmin(int id, String email, String password) {
		Administrador tmpAdmin = null;
		for (Administrador administrador : listaAdmin) {
			if(administrador.getIdAdmin() == id) {
				if (email != null) { administrador.setEmail(email); }
				if (password != null) { administrador.setPassword(password); }
				tmpAdmin = administrador;
				break;
			}
		}
		return tmpAdmin;
	}
			
}
