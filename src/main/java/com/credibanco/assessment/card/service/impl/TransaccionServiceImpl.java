package com.credibanco.assessment.card.service.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.api.client.ResponseAnularTransaccion;
import com.credibanco.assessment.card.api.client.ResponseCrearTransaccion;
import com.credibanco.assessment.card.dto.RequestAnularTransaccionDAO;
import com.credibanco.assessment.card.dto.RequestCrearTransaccionDAO;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.model.Transaccion;
import com.credibanco.assessment.service.ITarjetaRepo;
import com.credibanco.assessment.service.ITransaccionRepo;
import com.credibanco.assessment.service.ITransaccionService;
@Service
public class TransaccionServiceImpl implements ITransaccionService{
	
	@Autowired
	private ITransaccionRepo iTransaccionRepo;
	@Autowired
	private ITarjetaRepo iTarjetaRepo;

	@Override
	public ResponseCrearTransaccion CrearTransaccion(RequestCrearTransaccionDAO requestCrearTransaccionDAO){
		ResponseCrearTransaccion responseCrearTransaccion=new ResponseCrearTransaccion();
		Transaccion transaccion=new Transaccion();
		Tarjeta tarjeta=new Tarjeta();
		
		tarjeta=iTarjetaRepo.findByTnumerotarjeta(requestCrearTransaccionDAO.getPAN()).get(0);
		transaccion=iTransaccionRepo.findByInumeroreferencia(
				Integer.parseInt(requestCrearTransaccionDAO.getNumeroReferencia())).get(0);
		transaccion.setTarjeta(tarjeta);
		transaccion.setlValorCompra(requestCrearTransaccionDAO.getTotalCompra());
		transaccion.setinumeroreferencia(Integer.parseInt(requestCrearTransaccionDAO.getNumeroReferencia()));
		transaccion.settDireccionCompra(requestCrearTransaccionDAO.getDireccionCompra());
		transaccion.settEstadoTransaccion("Aprobada");
		transaccion.setbEstado(true);
		transaccion.setDtFechaCreacion(new Date());
		
		iTransaccionRepo.save(transaccion);
		
		responseCrearTransaccion.setCodigorespuesta("00");
		responseCrearTransaccion.setEstadoTransacción("Aprobada");
		responseCrearTransaccion.setMensaje("Compra exitosa");
		responseCrearTransaccion.setNumeroReferencia(requestCrearTransaccionDAO.getNumeroReferencia());
		return responseCrearTransaccion;
	}

	@Override
	public ResponseAnularTransaccion AnularTransaccion(RequestAnularTransaccionDAO requestAnularTransaccionDAO) {
		ResponseAnularTransaccion responseAnularTransaccion=new ResponseAnularTransaccion();
		Transaccion transaccion=new Transaccion();
		Tarjeta tarjeta=new Tarjeta();
		tarjeta=iTarjetaRepo.findByTnumerotarjeta(requestAnularTransaccionDAO.getPAN()).get(0);
		transaccion=iTransaccionRepo.findByInumeroreferenciaAndTarjeta(
				Integer.parseInt(requestAnularTransaccionDAO.getNumeroReferencia())
				,Integer.parseInt(requestAnularTransaccionDAO.getPAN())).get(0);
		
		responseAnularTransaccion.setCodigoRespuesta("00");
		responseAnularTransaccion.setMensaje("Compra anulada");
		responseAnularTransaccion.setNumeroReferencia(transaccion.getinumeroreferencia());
		return responseAnularTransaccion;
	}
}
