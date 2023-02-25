package com.credibanco.assessment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.model.Transaccion;
@Repository
public interface ITransaccionRepo extends JpaRepository<Transaccion, Integer> {
	public List<Transaccion> findByInumeroreferencia(int iNumeroReferencia);
	
	@Query(value="SELECT * from transaccion tr WHERE tr.inumeroreferencia = ?1 "
			+ "AND tr.tarjeta_iidtarjeta = ?2 AND tr.lvalorcompra=?3 ",nativeQuery = true)		
	public List<Transaccion> BuscarTransaccion(
		int iNumeroReferencia,int tarjeta_iidtarjeta,          long lValorCompra);
	
}
