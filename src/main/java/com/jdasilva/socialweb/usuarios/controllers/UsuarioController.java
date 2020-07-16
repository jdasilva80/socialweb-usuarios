package com.jdasilva.socialweb.usuarios.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdasilva.socialweb.commons.errors.UsuarioNoEncontrado;
import com.jdasilva.socialweb.commons.models.entity.Contacto;
import com.jdasilva.socialweb.commons.models.entity.Usuario;
import com.jdasilva.socialweb.usuarios.model.service.IUsuarioService;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	Environment environment;

	@Value("${server.port}")
	Integer port;

	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable Long id) throws Exception {

		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();

		try {
			usuario = usuarioService.findByIdOptional(id).orElseThrow(() -> new UsuarioNoEncontrado(id.toString()));

			List<Contacto> contactos = usuario.getContactos().stream().map((contacto) -> {
				Usuario user = usuarioService.findByIdOptional(contacto.getId()).orElse(null);
				if (user != null) {
					contacto.setUsername(user.getUsername());
					contacto.setNombre(user.getNombre());
					contacto.setApellidos(user.getApellidos());
					contacto.setUsuarioId(user.getId());
					contacto.setEmail(user.getEmail());
					contacto.setFechaNacimiento(user.getFechaNacimiento());
				}
				return contacto;

			}).filter((u) -> !u.getUsuarioId().equals(id)).collect(Collectors.toList());
			// usuario.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			usuario.setContactos(contactos);

			usuario.setPort(port);

		} catch (DataAccessException e) {

			response.put("mensaje",
					"Error al consultar el usuario con id: ".concat(id.toString()).concat(" en la bd."));
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		boolean ok = false;

		if (ok) {

			throw new Exception("error al cargar el usuario");
		}

		Thread.sleep(3000);// para generar un timeout, error por latencia

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

	@GetMapping("/{username}")
	public ResponseEntity<?> getUsuarioByUsername(@PathVariable String username) throws Exception {

		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();

		try {
			usuario = usuarioService.findByUsername(username);

			if (usuario == null) {
				throw new UsuarioNoEncontrado(username);
			}

			List<Contacto> contactos = usuario.getContactos().stream().map((contacto) -> {
				Usuario user = usuarioService.findByIdOptional(contacto.getId()).orElse(null);
				if (user != null) {
					contacto.setUsername(user.getUsername());
					contacto.setNombre(user.getNombre());
					contacto.setApellidos(user.getApellidos());
					contacto.setUsuarioId(user.getId());
					contacto.setEmail(user.getEmail());
					contacto.setFechaNacimiento(user.getFechaNacimiento());
				}
				return contacto;

			}).filter((u) -> !u.getUsuarioId().equals(id)).collect(Collectors.toList());
			// usuario.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			usuario.setContactos(contactos);

			usuario.setPort(port);

		} catch (DataAccessException e) {

			response.put("mensaje",
					"Error al consultar el usuario con id: ".concat(id.toString()).concat(" en la bd."));
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		boolean ok = false;

		if (ok) {

			throw new Exception("error al cargar el usuario");
		}

		Thread.sleep(3000);// para generar un timeout, error por latencia

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

	@GetMapping("/all")
	public List<Usuario> findAllUsuarios() {

		return usuarioService.findAll();
	}
}
