package org.generation.joyaDelCaribe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.org.generation.joyaDelCaribe.model.ChangePassword;
import src.main.java.org.generation.joyaDelCaribe.model.Usuario;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

	@Autowired
	public UsuarioService() {
		listaUser.add(new Usuario("Sofía", "Sanchez", "5512345678", "sofia@gmail.com", "7412369*Lo"));
		listaUser.add(new Usuario("Laura", "Martínez", "5598765421", "laura@gmail.com", "7412369*Li"));
		listaUser.add(new Usuario("Lucía", "García", "5515975312", "lucia@gmail.com", "7412369*Lu"));
	}

	public ArrayList<Usuario> getAllUsers() {
		return listaUser;
	}

	public ArrayList<Usuario> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario getUser(int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : listaUser) {
			if (usuario.getIdUser() == id) {
				tmpUser = usuario;
				break;
			}
		}
		return tmpUser;
	}

	public Usuario deleteUsuario(int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : listaUser) {
			if (usuario.getIdUser() == id) {
				tmpUser = listaUser.remove(listaUser.indexOf(usuario));
				break;
			}
		}
		return tmpUser;
	}

	public Usuario addUsuario(Usuario usuario) {
		Usuario tmpUser = null;
		boolean userExists = false;
		for (Usuario user : listaUser) {
			if (user.getEmail().equals(usuario.getEmail())) {
				userExists = true;
				break;
			}
		}
		if (!userExists) {
			listaUser.add(usuario);
			tmpUser = usuario;
		}
		return tmpUser;
	}

	public Usuario updateUser(int id, ChangePassword changePassword) {
		Usuario tmpUser = null;
		for (Usuario usuario : listaUser) {
			if (usuario.getIdUser() == id) {
				tmpUser = usuario;
				if (changePassword.getPassword().equals(tmpUser.getPassword())) {
					tmpUser.setPassword(changePassword.getNpassword());
					return usuario;
				} else {
					return null;
				}
			}
		}
		return null;
	}

}