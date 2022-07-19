package com.baz.examen.repository.iface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.examen.entity.SolicitudAmigoEntity;

public interface SolicitudAmigoRepository extends JpaRepository<SolicitudAmigoEntity, Integer> {

	public List<SolicitudAmigoEntity> findByIdUsuarioAndStSolicitud(Integer idUsuario, Character stSolicitud);
	
}
