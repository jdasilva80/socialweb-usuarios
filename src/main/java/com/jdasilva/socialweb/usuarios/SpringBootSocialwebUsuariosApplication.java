package com.jdasilva.socialweb.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.jdasilva.socialweb.commons.models.entity.Usuario;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackageClasses = Usuario.class)
public class SpringBootSocialwebUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSocialwebUsuariosApplication.class, args);
	}

}
