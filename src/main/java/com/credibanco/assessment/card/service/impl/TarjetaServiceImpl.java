package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.api.client.ResponseConsultarTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseEliminarTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseEnrolarTarjetaDAO;
import com.credibanco.assessment.card.dto.RequestCrearTarjetaDAO;
import com.credibanco.assessment.card.dto.RequestTarjetaPANNumeroValidacionDAO;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.service.ITarjetaRepo;
import com.credibanco.assessment.service.ITarjetaService;


@Service
public class TarjetaServiceImpl implements ITarjetaService {
	@Autowired
	private ITarjetaRepo iTarjetaRepo;

	//Metodo que permite crear una nueva tarjeta se
	@Override
	public Tarjeta CrearTarjeta(RequestCrearTarjetaDAO crearTarjetaDAO) {
		Tarjeta NewTarjeta=new Tarjeta();
    	NewTarjeta.settTitular(crearTarjetaDAO.getTitular());
    	NewTarjeta.settCedula(crearTarjetaDAO.getCedula());
    	NewTarjeta.settTelefono(crearTarjetaDAO.getTelefono());
    	NewTarjeta.settEstado("Creada");
    	NewTarjeta.setiNumeroValidacion((int)(Math.random()*100));
    	NewTarjeta.settNumeroTarjeta(crearTarjetaDAO.getPan());
    	NewTarjeta.setbEstado(true);
    	NewTarjeta.setDtFechacreacion(new Date());
    	
    	iTarjetaRepo.save(NewTarjeta);
		//enmascarar;
		return NewTarjeta;		
	}

	@Override
	@Transactional
	public ResponseEnrolarTarjetaDAO EnrolarTarjeta(RequestTarjetaPANNumeroValidacionDAO enrolarTarjetaDAO) {
		ResponseEnrolarTarjetaDAO responseEnrolarTarjetaDAO =new ResponseEnrolarTarjetaDAO();
		Tarjeta UpdateTarjeta=new Tarjeta();
	
		UpdateTarjeta=iTarjetaRepo.BuscarUnaTarjeta(enrolarTarjetaDAO.getNumeroValidacion(),enrolarTarjetaDAO.getPAN());
		UpdateTarjeta.settEstado("Enrolada");
		iTarjetaRepo.save(UpdateTarjeta);
		responseEnrolarTarjetaDAO.setCodigoRespuesta("00");
		responseEnrolarTarjetaDAO.setMensaje("Éxito");
		responseEnrolarTarjetaDAO.setPAN(UpdateTarjeta.gettNumeroTarjeta());
		return responseEnrolarTarjetaDAO;
	}
	
	@Override
	public ResponseConsultarTarjetaDAO ConsultarTarjeta(String PAN ) {
		ResponseConsultarTarjetaDAO responseConsultarTarjetaDAO=new ResponseConsultarTarjetaDAO();
		List<Tarjeta> ListTarjeta=new ArrayList<>();
		Tarjeta tarjeta=new Tarjeta();
		ListTarjeta=iTarjetaRepo.findByTnumerotarjeta(PAN);
		tarjeta=ListTarjeta.get(0);
		//enmascarar;
		responseConsultarTarjetaDAO.setPAN(PAN);
		responseConsultarTarjetaDAO.setTitular(tarjeta.gettTitular());
		responseConsultarTarjetaDAO.setCedula(tarjeta.gettCedula());
		responseConsultarTarjetaDAO.setTelefono(tarjeta.gettTelefono());
		responseConsultarTarjetaDAO.setEstado(tarjeta.gettEstado());
		return responseConsultarTarjetaDAO;
	}
	
	@Override
	public ResponseEliminarTarjetaDAO EliminarTarjeta(RequestTarjetaPANNumeroValidacionDAO eliminarTarjetaDAO) {
		ResponseEliminarTarjetaDAO responseEliminarTarjetaDAO =new ResponseEliminarTarjetaDAO();
		Tarjeta deleteTarjeta=new Tarjeta();
	
		deleteTarjeta=iTarjetaRepo.BuscarUnaTarjeta(eliminarTarjetaDAO.getNumeroValidacion(),eliminarTarjetaDAO.getPAN());
		iTarjetaRepo.delete(deleteTarjeta);
		responseEliminarTarjetaDAO.setCodigoRespuesta("00");
		responseEliminarTarjetaDAO.setMensaje("Se ha eliminado la tarjeta");
		return responseEliminarTarjetaDAO;
	}
	
}

