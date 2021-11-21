package edu.ucentral.serviciousuarios.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import edu.ucentral.serviciousuarios.model.Usuario;
import edu.ucentral.serviciousuarios.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS, RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuarioBd = optional.get();
		usuarioBd.setEmail(usuario.getEmail());
		usuarioBd.setEnabled(usuario.getEnabled());
		usuarioBd.setPassword(usuario.getPassword());
		usuarioBd.setRoles(usuario.getRoles());
		usuarioBd.setUsername(usuario.getUsername());
		usuarioBd.setNumeroIdentificacion(usuario.getNumeroIdentificacion());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioBd));
	}
	
	@GetMapping("buscar-username")
	public ResponseEntity<?> buscarPorUsername(@RequestParam String username){
		Usuario usuario = service.findByUsername(username);
		if(usuario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
}
