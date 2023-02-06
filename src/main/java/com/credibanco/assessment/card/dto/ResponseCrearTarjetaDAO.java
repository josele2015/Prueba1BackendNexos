package com.credibanco.assessment.card.dto;

public class ResponseCrearTarjetaDAO {
	
	private String CodigoRespuesta;
	private String Mensaje;
	private String NumeroValidacion;
	private String PAN;
	
	public ResponseCrearTarjetaDAO() {
	}
	
	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	public String getCodigoRespuesta() {
		return CodigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		CodigoRespuesta = codigoRespuesta;
	}

	public String getNumeroValidacion() {
		return NumeroValidacion;
	}

	public void setNumeroValidacion(String numeroValidacion) {
		NumeroValidacion = numeroValidacion;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}
}
