package com.credibanco.assessment.card.api.client;

public class ResponseEliminarTarjetaDAO {
	private String CodigoRespuesta;
	private String Mensaje;
	
	public ResponseEliminarTarjetaDAO () {
		
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
	

}
