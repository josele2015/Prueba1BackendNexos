package com.credibanco.assessment.card.dto;

public class RequestAnularTransaccionDAO {
	private String PAN; 
	private String numeroReferencia;
	private int totalCompra;
	
	public RequestAnularTransaccionDAO(String pAN, String numeroReferencia, int totalCompra) {
		super();
		PAN = pAN;
		this.numeroReferencia = numeroReferencia;
		this.totalCompra = totalCompra;
	} 
	
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	public int getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(int totalCompra) {
		this.totalCompra = totalCompra;
	}
}
