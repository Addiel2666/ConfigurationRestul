package com.tesis.conf.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tesis.conf.dto.AltaSocio;
import com.tesis.conf.dto.ConfiguracionProducto;
import com.tesis.conf.dto.TipoEntrada;

public abstract class BaseDAO<T> {

	private SessionFactory sessionFactory	 = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public synchronized Serializable addConfPr(TipoEntrada entrada) throws Exception {
		Serializable resultado = null;
		Session session;
		try {
			session	 = sessionFactory.getCurrentSession(); 
			resultado = session.save(entrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	@Transactional
	public synchronized Serializable addSocio(AltaSocio entrada) throws Exception {
		Serializable resultado = null;
		Session session;
		try {
			session	 = sessionFactory.getCurrentSession(); 
			resultado = session.save(entrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	@Transactional
	public synchronized Serializable addConfProd(ConfiguracionProducto entrada) throws Exception {
		Serializable resultado = null;
		Session session;
		try {
			session	 = sessionFactory.getCurrentSession(); 
			resultado = session.save(entrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
//
	
	
	
}
