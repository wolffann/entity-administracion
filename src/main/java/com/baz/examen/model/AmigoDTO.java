package com.baz.examen.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_EMPTY)
@Data
public class AmigoDTO implements Serializable {
	
	private static final long serialVersionUID = 8900603119240617393L;

	private Integer idUsuario;
	
	private Integer idAmigo;

	private Date fhCreacion;
	
	private Date fhModificacion;
	
}
