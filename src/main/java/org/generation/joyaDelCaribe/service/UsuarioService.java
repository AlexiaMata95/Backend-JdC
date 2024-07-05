package org.generation.joyaDelCaribe.service;

import java.util.List;
import java.util.Optional;

import org.generation.joyaDelCaribe.model.ChangePassword;
import org.generation.joyaDelCaribe.model.Usuario;
import org.generation.joyaDelCaribe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getAllUsers() {
		return usuarioRepository.findAll();
	}

	public Usuario getUser(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("El usuario con el id [" + id + "] no existe"));
	}

	public Usuario deleteUsuario(Long id) {
		Usuario tmpUser = null;
		if (usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}
		return tmpUser;
	}

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> tmpUser = usuarioRepository.findByEmail(usuario.getEmail());
		if (tmpUser.isEmpty()) {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			return usuarioRepository.save(usuario);
		}else {
			System.out.println("El usuario con el nombre [] ya existe");
			return null;
		}
	}

	public Usuario updateUser(Long id, ChangePassword changePassword) {
		Usuario tmpUser = null;
		if (usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			if(encoder.matches(changePassword.getPassword(), tmpUser.getPassword())) {
				tmpUser.setPassword(encoder.encode(changePassword.getNpassword()));
				usuarioRepository.save(tmpUser);
			}else {
				System.out.println("updateUser - El password del usuario [" + id + "] no coincide");
				tmpUser = null;
			}
		}
		return tmpUser;
	}
	
	public boolean validateUser(Usuario usuario) {
		Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
		if(userByEmail.isPresent()) {
			Usuario tmpUser = userByEmail.get();
			if(encoder.matches(usuario.getPassword(), tmpUser.getPassword())) {
				return true;
			}
		}
		return false;
	}

}