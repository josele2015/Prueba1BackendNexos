package com.credibanco.assessment.card.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "transaccion")
@Table(name = "transaccion", 
	indexes = {
	    @Index(name = "fk_Transaccion_Tarjeta_idx", columnList = "tarjeta_iIdTarjeta")
	    })
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaccion implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidtransaccion", nullable = false)	
	@NotNull
	private int iIdtransaccion;

//	tarjeta_iIdtarjeta
	@ManyToOne(targetEntity = Tarjeta.class,fetch= FetchType.LAZY)
	@JoinColumn(name="tarjeta_iidtarjeta", nullable=false)
	@NotNull
	private Tarjeta tarjeta_iidtarjeta;

	@Column(name = "lvalorcompra", nullable = false)
	@NotNull
	private long lvalorcompra;
	@Column(name = "inumeroreferencia", nullable = false)
	@NotNull
	private int inumeroreferencia;
	
	@Column(name = "tdireccioncompra",length =50, nullable = false)
	@NotNull
	private String tDireccionCompra;
	
	@Column(name = "testadotransaccion",length=100, nullable = false)
	@NotNull
	private String tEstadoTransaccion;
	
	@Column(name = "dtfechacreacion", nullable = false)
	@NotNull
	private Date dtFechaCreacion;
	
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

	public int getinumeroreferencia() {
		return inumeroreferencia;
	}

	public void setinumeroreferencia(int inumeroreferencia) {
		this.inumeroreferencia = inumeroreferencia;
	}
	
	public long getLvalorcompra() {
		return lvalorcompra;
	}

	public void setLvalorcompra(long lvalorcompra) {
		this.lvalorcompra = lvalorcompra;
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

	public Date getDtFechaCreacion() {
		return dtFechaCreacion;
	}

	public void setDtFechaCreacion(Date dtFechaCreacion) {
		this.dtFechaCreacion = dtFechaCreacion;
	}

	public boolean isbEstado() {
		return bEstado;
	}

	public void setbEstado(boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Tarjeta getTarjeta_iidtarjeta() {
		return tarjeta_iidtarjeta;
	}

	public void setTarjeta_iidtarjeta(Tarjeta tarjeta_iidtarjeta) {
		this.tarjeta_iidtarjeta = tarjeta_iidtarjeta;
	}
	public int getInumeroreferencia() {
		return inumeroreferencia;
	}

	public void setInumeroreferencia(int inumeroreferencia) {
		this.inumeroreferencia = inumeroreferencia;
	}
	

}
