package com.jdasilva.socialweb.usuarios.model.service;

import java.util.List;
import java.util.Optional;

import com.jdasilva.socialweb.commons.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findById(Long id);
	
	public Optional<Usuario> findByIdOptional(Long id);
	
	public List<Usuario> findAll();
}
