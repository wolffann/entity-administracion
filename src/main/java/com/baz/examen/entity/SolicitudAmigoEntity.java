package com.baz.examen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "solicitudamigo")
public class SolicitudAmigoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSOLICITUD")
	private Integer idSolicitud;
	
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	
	@Column(name = "IDAMIGO")
	private Integer idAmigo;

	@Column(name = "STSOLICITUD")
	private Character stSolicitud;
	
	@Column(name = "FHCREACION")
	private Date fhCreacion;
	
	@Column(name = "FHMODIFICACION")
	private Date fhModificacion;
	
}
