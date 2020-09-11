package com.jdasilva.socialweb.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.jdasilva.socialweb.commons.models.usuarios.entity.Contacto;
import com.jdasilva.socialweb.commons.models.usuarios.entity.Role;
import com.jdasilva.socialweb.commons.models.usuarios.entity.Usuario;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	@Override //para poder exponer los id de los usuarios json obtenidos por @RepositoryRestResource
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	
		config.exposeIdsFor(Usuario.class, Role.class, Contacto.class);
	}
	
	

}
