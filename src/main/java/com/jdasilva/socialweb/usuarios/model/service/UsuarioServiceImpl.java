package com.jdasilva.socialweb.usuarios.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdasilva.socialweb.commons.models.entity.Usuario;
import com.jdasilva.socialweb.usuarios.model.repository.IUsuarioDao;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {

		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Optional<Usuario> findByIdOptional(Long id) {

		return usuarioDao.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		
		 return StreamSupport.stream(usuarioDao.findAll().spliterator(), false) .collect(Collectors.toList());
	}

}
