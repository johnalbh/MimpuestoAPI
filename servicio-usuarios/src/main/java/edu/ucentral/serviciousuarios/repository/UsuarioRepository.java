package edu.ucentral.serviciousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.ucentral.serviciousuarios.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>, JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
