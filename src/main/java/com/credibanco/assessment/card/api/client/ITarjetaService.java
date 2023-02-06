package com.credibanco.assessment.card.api.client;

import com.credibanco.assessment.card.dto.ConsultarTarjetaDAO;
import com.credibanco.assessment.card.dto.CrearTarjetaDAO;
import com.credibanco.assessment.card.dto.EliminarTarjetaDAO;
import com.credibanco.assessment.card.dto.EnrolarTarjetaDAO;
import com.credibanco.assessment.card.dto.ResponseConsultarTarjetaDAO;
import com.credibanco.assessment.card.dto.ResponseEliminarTarjetaDAO;
import com.credibanco.assessment.card.dto.ResponseEnrolarTarjetaDAO;
import com.credibanco.assessment.card.model.Tarjeta;

public interface ITarjetaService {
	public Tarjeta CrearTarjeta(CrearTarjetaDAO CrearTarjetaDAO);
	public ResponseEnrolarTarjetaDAO EnrolarTarjeta(EnrolarTarjetaDAO EnrolarTarjetaDAO);
	public ResponseConsultarTarjetaDAO ConsultarTarjeta(ConsultarTarjetaDAO ConsultarTarjetaDAO);
	public ResponseEliminarTarjetaDAO EliminarTarjeta(EliminarTarjetaDAO CrearTarjetaDAO);
}
