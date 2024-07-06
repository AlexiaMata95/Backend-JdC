package org.generation.joyaDelCaribe.service;

import java.util.List;
import java.util.Optional;

import org.generation.joyaDelCaribe.model.Administrador;
import org.generation.joyaDelCaribe.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
	public final AdministradorRepository administradorRepository;
	
	@Autowired
	public AdministradorService(AdministradorRepository administradorRepository) { // Va a agregarle datos a la lista 
		this.administradorRepository = administradorRepository;
	}

	public List<Administrador> getAllAdmins() {
		return administradorRepository.findAll();
	}

	public Administrador getAdmin(Long id) {
		Administrador tmpAdmin = null;
		if (administradorRepository.existsById(id)) {
			tmpAdmin = administradorRepository.findById(id).get();
			administradorRepository.deleteById(id);
			}
		return tmpAdmin;
		}

	public Administrador deleteAdmin(Long id) {
		Administrador tmpAdmin = null;
			if(administradorRepository.existsById(id)) {
				tmpAdmin = administradorRepository.findById(id).get();
				administradorRepository.deleteById(id);
			}
		return tmpAdmin;
	}

	public Administrador addAdmin(Administrador admin) {
		Optional<Administrador> tmpAdmin = administradorRepository.findByEmail(admin.getEmail());
			if(tmpAdmin.isEmpty()) {
				return administradorRepository.save(admin);
			}else {
				System.out.println("El admin con el nombre [] ya existe");
				return null;
			}
	}

	public Administrador updateAdmin(Long id, String email, String password) {
		Administrador tmpAdmin = null;
			if(administradorRepository.existsById(id)) {
				Administrador administrador = administradorRepository.findById(id).get();
				if (email != null) { administrador.setEmail(email); }
				if (password != null) { administrador.setPassword(password); }
				administradorRepository.save(administrador);
				tmpAdmin=administrador;
			}
		return tmpAdmin;
	}
			
}
