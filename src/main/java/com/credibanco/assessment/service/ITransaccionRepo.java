package com.credibanco.assessment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.model.Transaccion;

public interface ITransaccionRepo extends JpaRepository<Transaccion, Integer> {
//	//QueryMethod	
//	@Query("SELECT t FROM transaccion t WHERE t.iNumeroReferencia = ?1 "
//			+ "and t.tarjeta_iidtarjeta = 2?")
//								   iNumeroReferencia
//	                         findByInumerovalidacion
	public List<Transaccion> findByInumeroreferencia(int iNumeroReferencia);
//	@Query("SELECT t FROM transaccion t WHERE t.iNumeroReferencia = ?1 "
//			+ "and t.tarjeta_iidtarjeta = 2?")
	public List<Transaccion> findByInumeroreferenciaAndTarjeta(int iNumeroReferencia,int iidtarjeta);
//	//QueryMethod
//	public List<Tarjeta> findByTnumerotarjeta(String tnumerotarjeta);
}
