package com.baz.examen.exception.custom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -8949090235939998120L;
	
	private String codigoError;
	
	private String errorTecnico;
	
	private String errorNegocio;
	
	private boolean imprimeStackTrace;
	
	public ServiceException(String codigoError, String errorTecnico, String errorNegocio) {
		this.codigoError = codigoError;
		this.errorTecnico = errorTecnico;
		this.errorNegocio = errorNegocio;
	}
	
	public ServiceException(String codigoError, String errorNegocio, String errorTecnico, Throwable e) {
		super(e);
		this.codigoError = codigoError;
		this.errorTecnico = errorTecnico;
		this.errorNegocio = errorNegocio;
		this.imprimeStackTrace = true;
	}

}
