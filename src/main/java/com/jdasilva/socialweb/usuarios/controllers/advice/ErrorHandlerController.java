package com.jdasilva.socialweb.usuarios.controllers.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdasilva.socialweb.commons.errors.UsuarioNoEncontrado;

@RestControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler
	public ResponseEntity<?> usuarioNoEncontrado(UsuarioNoEncontrado exception) {

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "Servicio usuarios: " + exception.getMessage());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

	}
}
