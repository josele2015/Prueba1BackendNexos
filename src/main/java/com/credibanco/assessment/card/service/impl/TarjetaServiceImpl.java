package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;
//
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.api.client.ITarjetaService;
import com.credibanco.assessment.card.api.client.exceptions.MessageStatus;
import com.credibanco.assessment.card.dto.ConsultarTarjetaDAO;
import com.credibanco.assessment.card.dto.CrearTarjetaDAO;
import com.credibanco.assessment.card.dto.EliminarTarjetaDAO;
import com.credibanco.assessment.card.dto.EnrolarTarjetaDAO;
import com.credibanco.assessment.card.dto.ResponseConsultarTarjetaDAO;
import com.credibanco.assessment.card.dto.ResponseEliminarTarjetaDAO;
import com.credibanco.assessment.card.dto.ResponseEnrolarTarjetaDAO;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.service.ITarjetaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.CommandLineRunner;
@Service
public class TarjetaServiceImpl implements ITarjetaService {
	@Autowired
	private ITarjetaRepo iTarjetaRepo;
//	public TarjetaServiceImpl(JpaRepository<Tarjeta, Integer> JpaRepository) {
//		super(JpaRepository);
//        this.iTarjetaRepo = iTarjetaRepo;
//    }
//	 @Override
//	  public void run(String... args) throws Exception {
//		 
//	 }
	@Override
	public Tarjeta CrearTarjeta(CrearTarjetaDAO crearTarjetaDAO) {
		// TODO Auto-generated method stub
		Tarjeta NewTarjeta=new Tarjeta();
    	MessageStatus messageStatus;

    	NewTarjeta.settTitular(crearTarjetaDAO.getTitular());
    	NewTarjeta.settCedula(crearTarjetaDAO.getCedula());
    	NewTarjeta.settTelefono(crearTarjetaDAO.getTelefono());
    	NewTarjeta.settEstado("Creada");
    	NewTarjeta.setiNumeroValidacion((int)(Math.random()*100));
    	NewTarjeta.settNumeroTarjeta(crearTarjetaDAO.getPan());
    	NewTarjeta.setbEstado(true);
    	NewTarjeta.setDtFechacreacion(new Date());
    	
    	iTarjetaRepo.save(NewTarjeta);
		return NewTarjeta;		
	}
//	String Query="SELECT t FROM tarjeta t WHERE t.tnumerotarjeta = ?1";
//	@Transactional
//	public List<Tarjeta> findEnrolarTarjeta(String PAN, String NumeroValidacion){
//		List<Tarjeta> employees = new ArrayList();
//		TypedQuery<Tarjeta> getQuery = iTarjetaRepo.createQuery(Query,      Employee.class).setParameter(1, years);
//			    employees = getQueryByYear.getResultList();
//			    return employees;
//	}
	@Override
	public ResponseEnrolarTarjetaDAO EnrolarTarjeta(EnrolarTarjetaDAO enrolarTarjetaDAO) {
		ResponseEnrolarTarjetaDAO responseEnrolarTarjetaDAO =new ResponseEnrolarTarjetaDAO();
		Tarjeta UpdateTarjeta=new Tarjeta();
		
//		iTarjetaRepo.findEnrolarTarjeta(enrolarTarjetaDAO.getPAN(), enrolarTarjetaDAO.getNumeroValidacion()+"");
		iTarjetaRepo.save(UpdateTarjeta);
		return responseEnrolarTarjetaDAO;
	}
	@Override
	public ResponseConsultarTarjetaDAO  ConsultarTarjeta(ConsultarTarjetaDAO ConsultarTarjetaDAO) {
		return null;
	}
	@Override
	public ResponseEliminarTarjetaDAO EliminarTarjeta(EliminarTarjetaDAO eliminarTarjetaDAO) {
		return null;
	}
}

