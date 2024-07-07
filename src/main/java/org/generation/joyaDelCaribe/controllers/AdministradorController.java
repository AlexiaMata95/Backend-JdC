package org.generation.joyaDelCaribe.controllers;



import java.util.List;

import org.generation.joyaDelCaribe.model.Administrador;
import org.generation.joyaDelCaribe.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/administradores/")
public class AdministradorController {
	private final AdministradorService adminService;
	
	@Autowired
	public AdministradorController(AdministradorService adminService) {
		this.adminService = adminService;
	}	
	
	@GetMapping
	public List<Administrador> getAdministradores(){
		return adminService.getAllAdmins();
	}
	
	@GetMapping(path = "{adminId}")
	public Administrador getAdministrador(@PathVariable("adminId") Long id) {
		return adminService.getAdmin(id);
	}
	
	@DeleteMapping(path = "{adminId}")
	public Administrador deleteAdmin(@PathVariable("adminId") Long id) {
		return adminService.deleteAdmin(id);
	}
	
	@PostMapping
	public Administrador addAdmin(@RequestBody Administrador admin) {
		return adminService.addAdmin(admin);
	}
	
	@PutMapping(path = "{adminId}")
	public Administrador updateAdmin(@PathVariable("adminId") Long id,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String contrasena) {
		return adminService.updateAdmin(id, correo, contrasena);
	}
	
}
