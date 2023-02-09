package com.credibanco.assessment.card.dto;

public class RequestCrearTarjetaDAO {
	private String pan;

	private String titular;
	private String cedula;
	private String tipo;
	private String telefono;
	
	public RequestCrearTarjetaDAO(String pan, String titular, String cedula, String tipo, String telefono) {
		super();
		this.pan = pan;
		this.titular = titular;
		this.cedula = cedula;
		this.tipo = tipo;
		this.telefono = telefono;
	}

	public String getPan() {
		return pan;
	}



	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
