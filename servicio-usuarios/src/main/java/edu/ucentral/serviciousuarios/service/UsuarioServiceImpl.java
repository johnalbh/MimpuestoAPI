package edu.ucentral.serviciousuarios.service;


import edu.ucentral.commonsservice.service.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.ucentral.commonusuarios.model.Usuario;
import edu.ucentral.serviciousuarios.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	}

}
