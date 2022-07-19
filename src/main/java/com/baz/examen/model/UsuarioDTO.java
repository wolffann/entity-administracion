package com.baz.examen.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_EMPTY)
@Data
public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = -282123333953146315L;

	private Integer idUsuario;
		
	private String txNombre;
	
	private String txNombre2;
		
	private String txApellido;
		
	private String txApellido2;
	
	private String fhNacimiento;
	
	private Character idSexo;
	
	private String txNacionalidad;
	
	private String txDireccion;
	
	private String txTelefono;
	
	private String txEmail;
	
	private String stUsuario;
	
	private Date fhCreacion;
	
	private Date fhModificacion;	
	
	
}
