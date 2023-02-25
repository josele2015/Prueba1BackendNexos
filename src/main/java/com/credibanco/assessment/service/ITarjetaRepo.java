package com.credibanco.assessment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.Tarjeta;
@Repository
public interface ITarjetaRepo extends JpaRepository<Tarjeta, Integer> {
	
	//SQL NATIVE 
	@Query(value="SELECT * from Tarjeta t "
			+ "WHERE t.inumerovalidacion = ?1 "
			+ "AND t.tnumerotarjeta=?2 "
			+ "ORDER BY t.iidtarjeta ASC LIMIT 1",nativeQuery = true)
	public Tarjeta BuscarUnaTarjeta(int INumeroValidacion,String tnumerotarjeta);
//	
	//JQL recomendable manejar todo en  
	@Query("SELECT t FROM tarjeta t WHERE t.inumerovalidacion = ?1 ")
	public List<Tarjeta> findByInumerovalidacion(String iNumeroValidacion);
	
	//QueryMethod
	public List<Tarjeta> findByTnumerotarjeta(String tnumerotarjeta);
}
