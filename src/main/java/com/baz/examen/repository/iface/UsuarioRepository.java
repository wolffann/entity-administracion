package com.baz.examen.repository.iface;

import java.util.List;

import com.baz.examen.entity.UsuarioEntity;

public interface UsuarioRepository {

	public List<UsuarioEntity> findUsuariosNotInIdUsuario(Integer idUsuario);
	
	public UsuarioEntity findUsuarioWithAmigos(Integer idUsuario);

}
