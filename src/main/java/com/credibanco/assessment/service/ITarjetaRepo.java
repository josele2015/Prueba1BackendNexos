package com.credibanco.assessment.service;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.Tarjeta;
//import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
//@Transactional
@Repository
public interface ITarjetaRepo extends JpaRepository<Tarjeta, Long> {
	
//	@Query("SELECT t FROM tarjeta t "
//			+ "WHERE t.tnumerotarjeta = ?1 AND t.tcedula = ?2 "
//			+ "ORDER BY ASC LIMIT 1")
//	@Transactional(timeout = 10)
	@Query(value="SELECT t FROM Tarjeta t "
			+ "WHERE t.tNumeroTarjeta = ?1", nativeQuery=true)
	public List<Tarjeta> findEnrolarTarjeta(String tnumerotarjeta);
	
}
