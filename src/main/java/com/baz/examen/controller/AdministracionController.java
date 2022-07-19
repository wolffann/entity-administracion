package com.baz.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baz.examen.model.AmigoDTO;
import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.model.UsuarioDTO;
import com.baz.examen.service.iface.AdministracionService;

@RestController
public class AdministracionController {
	
	@Autowired
	private AdministracionService administracionService;
		
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/usuario")	
	public UsuarioDTO guardarUsuario(@RequestBody UsuarioDTO usuario) {
		return administracionService.guardarUsuario(usuario);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/usuarios/notin/{idUsuario}")
	public List<UsuarioDTO> consultarUsuariosNotInIdUsuario(@PathVariable Integer idUsuario) {
		return administracionService.consultarUsuariosNotInIdUsuario(idUsuario);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/solicitud/amigo")
	public SolicitudAmigoDTO guardarSolicitudAmigo(@RequestBody SolicitudAmigoDTO solicitudAmigo) {
		return administracionService.guardarSolicitudAmigo(solicitudAmigo);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/solicitudes/from/others/to/usuario/{idUsuario}")
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(@PathVariable Integer idUsuario) {
		return administracionService.consultarSolicitudesFromOthersToIdUsuario(idUsuario);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/solicitud/estatus")
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(@RequestBody SolicitudAmigoDTO solicitudAmigo) {
		return administracionService.actualizarStatusSolicitudAmigo(solicitudAmigo);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/amigo")
	public AmigoDTO guardarAmigo(@RequestBody AmigoDTO amigo) {
		return administracionService.guardarAmigo(amigo);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/amigos/usuario/{idUsuario}")
	public List<AmigoDTO> consultarAmigosByIdUsuario(@PathVariable Integer idUsuario) {
		return administracionService.consultarAmigosByIdUsuario(idUsuario);
	}
	
	
}
