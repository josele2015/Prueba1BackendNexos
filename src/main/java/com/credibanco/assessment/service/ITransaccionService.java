package com.credibanco.assessment.service;

import com.credibanco.assessment.card.api.client.ResponseAnularTransaccion;
import com.credibanco.assessment.card.api.client.ResponseCrearTransaccion;
import com.credibanco.assessment.card.dto.RequestAnularTransaccionDAO;
import com.credibanco.assessment.card.dto.RequestCrearTransaccionDAO;

public interface ITransaccionService {
	public ResponseCrearTransaccion  CrearTransaccion(RequestCrearTransaccionDAO requestCrearTransaccionDAO);
	public ResponseAnularTransaccion AnularTransaccion(RequestAnularTransaccionDAO requestAnularTransaccionDAO);
}
