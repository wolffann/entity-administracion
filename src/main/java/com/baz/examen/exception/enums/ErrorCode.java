package com.baz.examen.exception.enums;

public enum ErrorCode {
	
	ERROR_INTERNO("50001", "Ocurrió un error durante la petición"),
	
	COMPONENTE_FALLIDO("50002", "Ocurrió una excepción al generar un componente del servicio"),
	
	CONSUMO_SERVICIO("50003", "Ocurrio un error al consumir algun servicio interno"),
	
	RECURSO_NO_ENCONTRADO("40001", "No se encontró el recurso solicitado");	
	
	ErrorCode(String codigo, String detalle) {
		this.codigo = codigo;
		this.detalle = detalle;		
	}
	
	private final String codigo;
	
	private final String detalle;
	
	public String codigo() {
		return this.codigo;
	}
	
	public String detalle() {
		return this.detalle;
	}
		

}
