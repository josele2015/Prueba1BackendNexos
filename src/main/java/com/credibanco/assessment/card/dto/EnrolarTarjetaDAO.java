package com.credibanco.assessment.card.dto;

public class EnrolarTarjetaDAO {
	private String PAN;
	private int NumeroValidacion;
	
	public EnrolarTarjetaDAO(String pAN, int numeroValidacion) {
		super();
		PAN = pAN;
		NumeroValidacion = numeroValidacion;
	}
	
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public int getNumeroValidacion() {
		return NumeroValidacion;
	}
	public void setNumeroValidacion(int numeroValidacion) {
		NumeroValidacion = numeroValidacion;
	}
}
