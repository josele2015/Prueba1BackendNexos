package com.credibanco.assessment.card.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.api.client.ResponseConsultarTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseCrearTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseEliminarTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseEnrolarTarjetaDAO;
import com.credibanco.assessment.card.api.client.exceptions.MessageStatus;
import com.credibanco.assessment.card.dto.RequestCrearTarjetaDAO;
import com.credibanco.assessment.card.dto.RequestTarjetaPANNumeroValidacionDAO;
import com.credibanco.assessment.card.exceptions.MessageError;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.service.impl.TarjetaServiceImpl;

@RestController
@RequestMapping("/tarjeta/v1")  
public class ControllerTarjeta {

	private TarjetaServiceImpl tarjetaServiceImpl; 
    ControllerTarjeta(TarjetaServiceImpl tarjetaServiceImpl) {
	    this.tarjetaServiceImpl = tarjetaServiceImpl;
    }
	@PostMapping("/postCrearTarjeta")
	public ResponseEntity<Object> CrearTarjeta(@RequestBody RequestCrearTarjetaDAO crearTarjetaDAO) {
//	public ResponseEntity<Object> CrearTarjeta(@RequestParam("bar") String foo,@RequestParam("bar") String foo2) {
		MessageStatus messageStatus;
		Tarjeta tarjeta;
		ResponseCrearTarjetaDAO responseCrearTarjetaDAO=new ResponseCrearTarjetaDAO();
		try {
			tarjeta=tarjetaServiceImpl.CrearTarjeta(crearTarjetaDAO);
			tarjetaServiceImpl.CrearTarjeta(crearTarjetaDAO);
			responseCrearTarjetaDAO=new ResponseCrearTarjetaDAO();
			if(tarjeta.gettEstado().equals("Creada")) {
				responseCrearTarjetaDAO.setCodigoRespuesta("00");
				responseCrearTarjetaDAO.setMensaje("Éxito");
			}else {
				responseCrearTarjetaDAO.setCodigoRespuesta("01");
				responseCrearTarjetaDAO.setMensaje("Fallido");
			}
			
			responseCrearTarjetaDAO.setNumeroValidacion(tarjeta.getiNumeroValidacion()+"");
			responseCrearTarjetaDAO.setPAN(tarjeta.gettNumeroTarjeta());
			
		}catch(Exception e) {
			MessageError messageError=new MessageError(e.getLocalizedMessage(),e);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de crear una nueva tarjeta",messageError);
    		return new ResponseEntity<Object>(messageStatus,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(responseCrearTarjetaDAO,HttpStatus.OK);
	}
	
	@PutMapping("/putEnrolarTarjeta")
	public ResponseEntity<Object> EnrolarTarjeta(@RequestBody RequestTarjetaPANNumeroValidacionDAO enrolarTarjetaDAO){
		MessageStatus messageStatus;
		ResponseEnrolarTarjetaDAO responseEnrolarTarjetaDAO;
		try {
			responseEnrolarTarjetaDAO=tarjetaServiceImpl.EnrolarTarjeta(enrolarTarjetaDAO);
		}catch(Exception e) {
			MessageError messageError=new MessageError(e.getLocalizedMessage(),e);
			messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de enrolar la tarjeta",messageError);
    		return new ResponseEntity<Object>(messageStatus,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(responseEnrolarTarjetaDAO,HttpStatus.OK);
	}
	
	
	@GetMapping("/getConsultarTarjeta")
	public ResponseEntity<Object> ConsultarTarjeta(@RequestParam String PAN) {
		MessageStatus messageStatus;
		ResponseConsultarTarjetaDAO responseEliminarTarjetaDAO;
		try {
			responseEliminarTarjetaDAO=tarjetaServiceImpl.ConsultarTarjeta(PAN);
		}catch(Exception e) {
			MessageError messageError=new MessageError(e.getLocalizedMessage(),e);
			messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de consultar una tarjeta",messageError);
			return new ResponseEntity<Object>(messageStatus,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(responseEliminarTarjetaDAO,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEliminarTarjeta")
	public ResponseEntity<Object> EliminarTarjeta(@RequestBody RequestTarjetaPANNumeroValidacionDAO EliminarTarjeta) {
		MessageStatus messageStatus;
		ResponseEliminarTarjetaDAO responseEliminarTarjetaDAO;
		try {
			responseEliminarTarjetaDAO=tarjetaServiceImpl.EliminarTarjeta(EliminarTarjeta);
		}catch(Exception e) {
			MessageError messageError=new MessageError(e.getLocalizedMessage(),e);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de eliminar la tarjeta",messageError);
    		return new ResponseEntity<Object>(messageStatus,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(responseEliminarTarjetaDAO,HttpStatus.OK);
	}
}
