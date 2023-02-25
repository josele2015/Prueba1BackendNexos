package com.credibanco.assessment.card.dto;

public class RequestCrearTransaccionDAO {
	private String PAN;
	private String NumeroReferencia;
	private int TotalCompra;
	private String DireccionCompra;

	public RequestCrearTransaccionDAO(String pAN, String numeroReferencia, int totalCompra, 
			String direccionCompra) {
		super();
		PAN = pAN;
		NumeroReferencia = numeroReferencia;
		TotalCompra = totalCompra;
		DireccionCompra = direccionCompra;
	}

	
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getNumeroReferencia() {
		return NumeroReferencia;
	}
	public void setNumeroReferencia(String numeroReferencia) {
		NumeroReferencia = numeroReferencia;
	}
	public int getTotalCompra() {
		return TotalCompra;
	}
	public void setTotalCompra(int totalCompra) {
		TotalCompra = totalCompra;
	}
	public String getDireccionCompra() {
		return DireccionCompra;
	}
	public void setDireccionCompra(String direccionCompra) {
		DireccionCompra = direccionCompra;
	}
}
