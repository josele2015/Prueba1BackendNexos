package com.credibanco.assessment.card.api.client;

public class ResponseEnrolarTarjetaDAO {
	private String CodigoRespuesta;
	private String Mensaje;
	private String PAN;
	
	public ResponseEnrolarTarjetaDAO() {
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
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
}
