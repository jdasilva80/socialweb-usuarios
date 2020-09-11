package com.jdasilva.socialweb.usuarios.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jdasilva.socialweb.commons.models.usuarios.entity.Usuario;

@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	@RestResource(path="buscar-nombre")
	public Usuario findByUsername(@Param("username") String username);

	
}
