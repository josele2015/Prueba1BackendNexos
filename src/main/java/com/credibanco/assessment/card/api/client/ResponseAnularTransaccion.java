package com.credibanco.assessment.card.api.client;

public class ResponseAnularTransaccion {
	
	private String CodigoRespuesta; 
	private String Mensaje; 
	private int NumeroReferencia;
	
	public ResponseAnularTransaccion(String codigoRespuesta, String mensaje, int numeroReferencia) {
		super();
		CodigoRespuesta = codigoRespuesta;
		Mensaje = mensaje;
		NumeroReferencia = numeroReferencia;
	}
	public String getCodigoRespuesta() {
		return CodigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		CodigoRespuesta = codigoRespuesta;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	public int getNumeroReferencia() {
		return NumeroReferencia;
	}
	public void setNumeroReferencia(int numeroReferencia) {
		NumeroReferencia = numeroReferencia;
	}
}
