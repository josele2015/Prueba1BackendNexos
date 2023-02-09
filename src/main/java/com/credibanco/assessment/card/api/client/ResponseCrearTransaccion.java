package com.credibanco.assessment.card.api.client;

public class ResponseCrearTransaccion {

	private String Codigorespuesta; 
	private String Mensaje;
	private String EstadoTransacción;
	private String NumeroReferencia;
	
	public String getCodigorespuesta() {
		return Codigorespuesta;
	}
	public void setCodigorespuesta(String codigorespuesta) {
		Codigorespuesta = codigorespuesta;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	public String getEstadoTransacción() {
		return EstadoTransacción;
	}
	public void setEstadoTransacción(String estadoTransacción) {
		EstadoTransacción = estadoTransacción;
	}
	public String getNumeroReferencia() {
		return NumeroReferencia;
	}
	public void setNumeroReferencia(String numeroReferencia) {
		NumeroReferencia = numeroReferencia;
	}
}
