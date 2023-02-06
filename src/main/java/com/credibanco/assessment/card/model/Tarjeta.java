package com.credibanco.assessment.card.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tarjeta")
@Table(name = "tarjeta")

public class Tarjeta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidtarjeta", nullable = false)	
	private int iIdtarjeta;
	
	@Column(name = "ttitular",length = 100, nullable = false)
	private String tTitular;
	
	@Column(name = "tcedula",length = 15, nullable = false)
	private String tCedula;
	@Column(name = "ttelefono",length = 10, nullable = false)
	private String tTelefono;
	
	@Column(name = "testado",length = 8, nullable = false)
	private String tEstado;

	@Column(name = "inumerovalidacion", nullable = false)
	private int iNumeroValidacion;

	@Column(name = "tnumerotarjeta",length=19, nullable = false)
	private String tnumerotarjeta;
	
	@Column(name = "bestado", nullable = false)
	private Boolean bEstado;
	
	@Column(name = "dtfechacreacion", nullable = false)
	private Date dtFechacreacion;
	
	public Tarjeta(){
		
	}
	
	public int getiIdtarjeta() {
		return iIdtarjeta;
	}

	public void setiIdtarjeta(int iIdtarjeta) {
		this.iIdtarjeta = iIdtarjeta;
	}

	public String gettTitular() {
		return tTitular;
	}

	public void settTitular(String tTitular) {
		this.tTitular = tTitular;
	}

	public String gettCedula() {
		return tCedula;
	}

	public void settCedula(String tCedula) {
		this.tCedula = tCedula;
	}

	public String gettTelefono() {
		return tTelefono;
	}

	public void settTelefono(String tTelefono) {
		this.tTelefono = tTelefono;
	}

	public String gettEstado() {
		return tEstado;
	}

	public void settEstado(String tEstado) {
		this.tEstado = tEstado;
	}

	public int getiNumeroValidacion() {
		return iNumeroValidacion;
	}

	public void setiNumeroValidacion(int iNumeroValidacion) {
		this.iNumeroValidacion = iNumeroValidacion;
	}

	public String gettNumeroTarjeta() {
		return tnumerotarjeta;
	}

	public void settNumeroTarjeta(String tNumeroTarjeta) {
		this.tnumerotarjeta = tNumeroTarjeta;
	}

	public boolean isbEstado() {
		return bEstado;
	}

	public void setbEstado(boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Date getDtFechacreacion() {
		return dtFechacreacion;
	}

	public void setDtFechacreacion(Date dtFechacreacion) {
		this.dtFechacreacion = dtFechacreacion;
	}
}
