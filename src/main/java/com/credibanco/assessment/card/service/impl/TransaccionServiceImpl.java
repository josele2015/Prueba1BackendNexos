package com.credibanco.assessment.card.service.impl;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.credibanco.assessment.card.api.client.ResponseAnularTransaccion;
import com.credibanco.assessment.card.api.client.ResponseCrearTransaccion;
import com.credibanco.assessment.card.dto.RequestAnularTransaccionDAO;
import com.credibanco.assessment.card.dto.RequestCrearTransaccionDAO;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.model.Transaccion;
import com.credibanco.assessment.service.ITarjetaRepo;
import com.credibanco.assessment.service.ITransaccionRepo;
import com.credibanco.assessment.service.ITransaccionService;

public class TransaccionServiceImpl implements ITransaccionService{
	
	@Autowired
	private ITransaccionRepo iTransaccionRepo;
	@Autowired
	private ITarjetaRepo iTarjetaRepo;

	@Override
	public ResponseCrearTransaccion CrearTransaccion(RequestCrearTransaccionDAO requestCrearTransaccionDAO){
		Transaccion transaccion=new Transaccion();
		
		transaccion.setTarjeta(null);
		transaccion.setlValorCompra(0);
		transaccion.setiNumeroReferencia(0);
		transaccion.settDireccionCompra("");
		transaccion.settEstadoTransaccion("");
		transaccion.setbEstado(true);
		transaccion.setDtFechaCreacion(0);
		
		iTransaccionRepo.save(transaccion);
		return new ResponseCrearTransaccion();
	}

	@Override
	public ResponseAnularTransaccion AnularTransaccion(RequestAnularTransaccionDAO requestAnularTransaccionDAO) {
		return null;
	}
}
