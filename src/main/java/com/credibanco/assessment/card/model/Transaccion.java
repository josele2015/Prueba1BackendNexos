package com.credibanco.assessment.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "transaccion")
//@Table(name = "transaccion", 
//	indexes = {
//	    @Index(name = "fk_Transaccion_Tarjeta_idx", columnList = "tarjeta_iIdTarjeta")})
@Table(name = "transaccion") 
public class Transaccion implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidtransaccion", nullable = false)	
	@NotNull
	private int iIdtransaccion;

//	tarjeta_iIdtarjeta
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="tarjeta_iidtarjeta", nullable=false)
	@NotNull
	private Tarjeta tarjeta;

	@Column(name = "lvalorcompra", nullable = false)
	@NotNull
	private long lValorCompra;
	
	@Column(name = "inumeroreferencia", nullable = false)
	@NotNull
	private int iNumeroReferencia;
	
	@Column(name = "tdireccioncompra",length =50, nullable = false)
	@NotNull
	private String tDireccionCompra;
	
	@Column(name = "testadotransaccion",length=100, nullable = false)
	@NotNull
	private String tEstadoTransaccion;
	
	@Column(name = "dtfechacreacion", nullable = false)
	@NotNull
	private int dtFechaCreacion;
	
	@Column(name = "bestado", nullable = false)
	@NotNull
	private boolean bEstado;

	public Transaccion() {
		
	}
	
	public int getiIdtransaccion() {
		return iIdtransaccion;
	}

	public void setiIdtransaccion(int iIdtransaccion) {
		this.iIdtransaccion = iIdtransaccion;
	}

	public long getlValorCompra() {
		return lValorCompra;
	}

	public void setlValorCompra(long lValorCompra) {
		this.lValorCompra = lValorCompra;
	}

	public int getiNumeroReferencia() {
		return iNumeroReferencia;
	}

	public void setiNumeroReferencia(int iNumeroReferencia) {
		this.iNumeroReferencia = iNumeroReferencia;
	}

	public String gettDireccionCompra() {
		return tDireccionCompra;
	}

	public void settDireccionCompra(String tDireccionCompra) {
		this.tDireccionCompra = tDireccionCompra;
	}

	public String gettEstadoTransaccion() {
		return tEstadoTransaccion;
	}

	public void settEstadoTransaccion(String tEstadoTransaccion) {
		this.tEstadoTransaccion = tEstadoTransaccion;
	}

	public int getDtFechaCreacion() {
		return dtFechaCreacion;
	}

	public void setDtFechaCreacion(int dtFechaCreacion) {
		this.dtFechaCreacion = dtFechaCreacion;
	}

	public boolean isbEstado() {
		return bEstado;
	}

	public void setbEstado(boolean bEstado) {
		this.bEstado = bEstado;
	}
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

}
