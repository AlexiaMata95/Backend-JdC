package org.generation.joyaDelCaribe.service;

import java.util.ArrayList;

import org.generation.joyaDelCaribe.model.ChangePassword;
import org.generation.joyaDelCaribe.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> listaUser = new ArrayList<Usuario>();
	
	@Autowired
	public UsuarioService() {
		listaUser.add(new Usuario("Sofía","Sanchez","5512345678","sofia@gmail.com","7412369*Lo"));
		listaUser.add(new Usuario("Laura","Martínez","5598765421","laura@gmail.com","7412369*Li"));
		listaUser.add(new Usuario("Lucía","García","5515975312","lucia@gmail.com","7412369*Lu"));
	}
	
	public ArrayList<Usuario> getAllUsers(){
		return listaUser;
	}

	public ArrayList<Usuario> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario getUser(int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : listaUser) {
			if(usuario.getIdUser()==id) {
				tmpUser = usuario;
				break;
			}
		}
		return tmpUser;
	}

	public Usuario deleteUsuario(int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : listaUser) {
			if (usuario.getIdUser()==id) {
				tmpUser= listaUser.remove(listaUser.indexOf(usuario));
			}
		}
		return tmpUser;
	}

	public Usuario addUsuario(Usuario usuario) {
		listaUser.add(usuario);
		return usuario;
	}

	public Usuario updateUser(int id, ChangePassword changePassword) {
		Usuario tmpUser = null;
		for (Usuario usuario : listaUser) {
			if (usuario.getIdUser()==id) {
				tmpUser = usuario;
				if(changePassword.getPassword().equals(tmpUser.getPassword())) {
					tmpUser.setPassword(changePassword.getNpassword());
					return usuario;
				}else {
					return null;
				}
			}
		}
		return null;
	}


}