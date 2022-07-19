package com.baz.examen.exception.custom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2056384477729240808L;
	
	private String codigoError;
	
	private String errorNegocio;
	
	public NotFoundException(String codigoError, String errorNegocio) {
		this.codigoError = codigoError;
		this.errorNegocio = errorNegocio;
	}

}
