package com.credibanco.assessment.service;

import java.util.List;

import com.credibanco.assessment.card.api.client.ResponseConsultarTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseEliminarTarjetaDAO;
import com.credibanco.assessment.card.api.client.ResponseEnrolarTarjetaDAO;
import com.credibanco.assessment.card.dto.RequestCrearTarjetaDAO;
import com.credibanco.assessment.card.dto.RequestTarjetaPANNumeroValidacionDAO;
import com.credibanco.assessment.card.model.Tarjeta;



public interface ITarjetaService {
	public Tarjeta CrearTarjeta(RequestCrearTarjetaDAO CrearTarjetaDAO);
	public ResponseEnrolarTarjetaDAO EnrolarTarjeta(RequestTarjetaPANNumeroValidacionDAO EnrolarTarjetaDAO);
	public ResponseConsultarTarjetaDAO ConsultarTarjeta(String PAN);
	public ResponseEliminarTarjetaDAO EliminarTarjeta(RequestTarjetaPANNumeroValidacionDAO EliminarTarjetaDAO);
	
}
