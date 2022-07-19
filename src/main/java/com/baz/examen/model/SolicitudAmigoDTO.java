package com.baz.examen.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_EMPTY)
@Data
public class SolicitudAmigoDTO implements Serializable {
	
	private static final long serialVersionUID = 3602715500074602456L;

	private Integer idSolicitud;
	
	private Integer idUsuario;
	
	private Integer idAmigo;
	
	private Character stSolicitud;
	
	private Date fhCreacion;
	
	private Date fhModificacion;
	
}
