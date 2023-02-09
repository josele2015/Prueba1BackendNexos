package com.credibanco.assessment.card.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.api.client.ResponseAnularTransaccion;
import com.credibanco.assessment.card.api.client.ResponseCrearTransaccion;
import com.credibanco.assessment.card.api.client.ResponseEliminarTarjetaDAO;
import com.credibanco.assessment.card.api.client.exceptions.MessageStatus;
import com.credibanco.assessment.card.dto.RequestAnularTransaccionDAO;
import com.credibanco.assessment.card.dto.RequestCrearTarjetaDAO;
import com.credibanco.assessment.card.dto.RequestCrearTransaccionDAO;
import com.credibanco.assessment.card.exceptions.MessageError;
import com.credibanco.assessment.card.service.impl.TarjetaServiceImpl;
import com.credibanco.assessment.card.service.impl.TransaccionServiceImpl;

@RestController
@RequestMapping("/transaccion/v1")
public class ControllerTransaccion {
	
	private TransaccionServiceImpl transaccionServiceImpl; 
	ControllerTransaccion(TransaccionServiceImpl transaccionServiceImpl) {
	    this.transaccionServiceImpl = transaccionServiceImpl;
    }
	
	public ResponseEntity<Object> CrearTransaccion(@RequestBody RequestCrearTransaccionDAO requestCrearTransaccionDAO) {
		MessageStatus messageStatus;
		ResponseCrearTransaccion responseCrearTransaccion;
		try {
			responseCrearTransaccion=transaccionServiceImpl.CrearTransaccion(requestCrearTransaccionDAO);
		}catch(Exception e) {
			MessageError messageError=new MessageError(e.getLocalizedMessage(),e);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento crear una transacción",messageError);
    		return new ResponseEntity<Object>(messageStatus,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(responseCrearTransaccion,HttpStatus.OK);
	}
	public ResponseEntity<Object> AnularTransacción(@RequestBody RequestAnularTransaccionDAO requestAnularTransaccionDAO) {
		MessageStatus messageStatus;
		ResponseAnularTransaccion responseAnularTransaccion;
		try {
			responseAnularTransaccion=transaccionServiceImpl.AnularTransaccion(requestAnularTransaccionDAO);
		}catch(Exception e) {
			MessageError messageError=new MessageError(e.getLocalizedMessage(),e);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de anular la tarjeta",messageError);
    		return new ResponseEntity<Object>(messageStatus,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(requestAnularTransaccionDAO,HttpStatus.OK);
	}
}
