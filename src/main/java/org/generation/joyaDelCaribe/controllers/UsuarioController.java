package org.generation.joyaDelCaribe.controllers;

import java.util.List;

import org.generation.joyaDelCaribe.model.ChangePassword;
import org.generation.joyaDelCaribe.model.Usuario;
import org.generation.joyaDelCaribe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {
	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getAllUsers();
	}
	
	@GetMapping(path = "{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long id) {
		return usuarioService.getUser(id);
	}
	
	@DeleteMapping(path = "{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long id) {
		return usuarioService.deleteUsuario(id);
	}
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	@PutMapping(path = "{userId}")
	public Usuario updateUsuario(@RequestBody ChangePassword changePassword, @PathVariable("userId") Long id) {
		return usuarioService.updateUser(id, changePassword);
	};
}