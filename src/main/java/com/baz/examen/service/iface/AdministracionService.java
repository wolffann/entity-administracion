package com.baz.examen.service.iface;

import java.util.List;

import com.baz.examen.model.AmigoDTO;
import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.model.UsuarioDTO;

public interface AdministracionService {
	
public UsuarioDTO guardarUsuario(UsuarioDTO usuario);
	
	public List<UsuarioDTO> consultarUsuariosNotInIdUsuario(Integer idUsuario);
	
	public SolicitudAmigoDTO guardarSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo);
	
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(Integer idUsuario);
	
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo);
	
	public AmigoDTO guardarAmigo(AmigoDTO amigo);

	public List<AmigoDTO> consultarAmigosByIdUsuario(Integer idUsuario);

}
