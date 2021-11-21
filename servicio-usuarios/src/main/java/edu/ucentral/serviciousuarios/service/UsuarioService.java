package edu.ucentral.serviciousuarios.service;

import edu.ucentral.serviciousuarios.model.Usuario;

public interface UsuarioService extends CommonService<Usuario> {
	public Usuario findByUsername(String username);
}
