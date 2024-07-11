package org.generation.joyaDelCaribe.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.generation.joyaDelCaribe.config.UserJwtFilter;
import org.generation.joyaDelCaribe.dto.UserToken;
import org.generation.joyaDelCaribe.model.Rol;
import org.generation.joyaDelCaribe.model.Usuario;
import org.generation.joyaDelCaribe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = {"http://127.0.0.1:5501/", "https://baomasu.github.io/JoyaDelCaribe/"})
@RestController
@RequestMapping(path="/api/login/")
public class UserLoginController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UserLoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public UserToken loginUser(@RequestBody Usuario usuario) throws ServletException {
		Rol userRol = usuarioService.getUserRole(usuario);
		if(usuarioService.validateUser(usuario, userRol)) {
			System.out.println("Usuario válido" + usuario.getContrasena());
			return new UserToken(generateToken(usuario.getCorreo(), userRol));
		}
		throw new ServletException("Nombre de ususario o contraseña incorrectos.");
	}
	
	private String generateToken(String username, Rol rol) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Desarrollo
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", rol.name())
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, UserJwtFilter.secret)
		.compact();
	}//generateToken
}
