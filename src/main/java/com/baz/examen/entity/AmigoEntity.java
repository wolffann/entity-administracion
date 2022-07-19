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
@Table(name = "amigos")
public class AmigoEntity  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDRELACIONAMIGOS")
	private Integer idRelacionAmigos;
	
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	
	@Column(name = "IDAMIGO")
	private Integer idAmigo;
	
	@Column(name = "STAMIGO")
	private Character stAmigo;
	
	@Column(name = "FHCREACION")
	private Date fhCreacion;
	
	@Column(name = "FHMODIFICACION")
	private Date fhModificacion;

}
