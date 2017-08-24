package com.tesis.conf.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tesis.conf.dao.AltaSocioDAO;
import com.tesis.conf.dto.AltaSocio;
import com.tests.conf.util.Constantes;

@Repository
public class AltaSocioDAOImpl extends AltaSocioDAO<AltaSocio>{

	@Autowired
    public AltaSocioDAOImpl(
            @Qualifier("sessionFactory") SessionFactory sessionFactory) {
    	super.setSessionFactory(sessionFactory);
    }
	
	public AltaSocioDAOImpl(){}
	
	public boolean validaExistenciaCod(String codigo) {
		boolean validacionExitosa = false;
		Session session = getSessionFactory().openSession();
		Query q = session.getNamedQuery("AltaSocio.findByClaveSocio");
		q.setParameter("claveSocio", codigo);
		if(q.uniqueResult() == null) {
			validacionExitosa = true;
			return validacionExitosa;
		}else {
			
			return validacionExitosa;
		}
	}
	
	public AltaSocio validaExistenciaCod2(String codigo) {
		AltaSocio socio = new AltaSocio();
		Session session = getSessionFactory().openSession();
		Query q = session.getNamedQuery("AltaSocio.findByClaveSocio");
		q.setParameter("claveSocio", codigo);
		if(q.uniqueResult() != null) {
			socio = (AltaSocio) q.uniqueResult();
			return socio;
		}else {
			socio = null;
			return socio;
		}
	}
	
	public boolean validaExistenciaNom(String nombre) {
		boolean validacionExitosa = false;
		Session session = getSessionFactory().openSession();
		Query q = session.getNamedQuery("AltaSocio.findByNombreSocio");
		q.setParameter("nombreSocio", nombre);
		if(q.uniqueResult() == null) {
			validacionExitosa = true;
			return validacionExitosa;
			
		}else {
			
			return validacionExitosa;
		}
	}
	
	public Serializable validaDatos(String clave) {
		Serializable validacionExitosa = null;
		Session session = getSessionFactory().openSession();
		Query q = session.getNamedQuery("AltaSocio.findRegistro");
		q.setParameter("claveSocio", clave);
		if(q.uniqueResult() != null) {
			System.out.println("Ento aca");
			validacionExitosa = (Serializable) q.uniqueResult();
			System.out.println(validacionExitosa);
			return validacionExitosa;
			
		}else {
			
			return validacionExitosa;
		}
	}
	
	
	public String elimina(String entrada, Serializable registro) {
		
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("update AltaSocio set estatus = 0 where id = :id");
		query.setParameter("id", registro);
		
		int result = query.executeUpdate();
		
		if(result == 1) {
			return Constantes.EXITO;
		}else {
			return Constantes.FAILED;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AltaSocio> listaCompleta(){
		List<AltaSocio> lista = new ArrayList<AltaSocio>();
		Session session = getSessionFactory().openSession();
		Query q = session.getNamedQuery("AltaSocio.findAll");
		lista = q.list();
		return lista;
	}
	
	public String actualiza(AltaSocio request,Serializable registroExist) {
		Session session = getSessionFactory().openSession();
		
		Query query = session.createQuery("update AltaSocio set nombreSocio = :nombreSocio, fechaVigenciaFinal = :fechaVigenciaFinal"
				+ ", fechaVigenciaInicio = :fechaVigenciaInicio, claveSocio = :claveSocio where id = :id");
		query.setParameter("nombreSocio", request.getNombreSocio());
		query.setParameter("claveSocio", request.getClaveSocio());
		query.setParameter("fechaVigenciaInicio", request.getFechaVigenciaInicio());
		query.setParameter("fechaVigenciaFinal", request.getFechaVigenciaFinal());
		
		query.setParameter("id", registroExist);
		int result = query.executeUpdate();
		
		if(result == 1) {
			return Constantes.EXITO;
		}else {
			return Constantes.FAILED;
		}
		
		
		
//		Query q = session.createQuery("from AltaSocio where id = :id ");
//		q.setParameter("id",registroExist);
//		AltaSocio updat = (AltaSocio)q.list().get(0);
//
//		
//			updat.setClaveSocio(request.getClaveSocio());
//			updat.setNombreSocio(request.getNombreSocio());
//			updat.setFechaVigenciaFinal(request.getFechaVigenciaFinal());
//			updat.setFechaVigenciaInicio(request.getFechaVigenciaInicio());
//			session.update(updat);
//			return Constantes.EXITO;
	
	}
	
}
