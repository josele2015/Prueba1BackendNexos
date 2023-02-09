package com.credibanco.assessment.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.card.model.Transaccion;

public interface ITransaccionRepo extends JpaRepository<Transaccion, Integer> {
	
}
