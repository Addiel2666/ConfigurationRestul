package com.tesis.conf.dao.impl;




import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.tesis.conf.dao.TipoEntradaDAO;
import com.tesis.conf.dto.TipoEntrada;
import com.tests.conf.util.Constantes;

@Repository
public class TipoEntradaDAOImpl extends TipoEntradaDAO<TipoEntrada>{
private static final Logger log = Logger.getLogger(TipoEntradaDAOImpl.class);
	@Autowired
    public TipoEntradaDAOImpl(
            @Qualifier("sessionFactory") SessionFactory sessionFactory) {
    	super.setSessionFactory(sessionFactory);
    }
	
	public TipoEntradaDAOImpl(){}
	
	public String actualiza(TipoEntrada entrada) {
	
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("update TipoEntrada set extension = :extension"
				+ " where codigo = :codigo");
		query.setParameter("extension", entrada.getExtension());
		query.setParameter("codigo", entrada.getCodigo());
		int result = query.executeUpdate();
		log.info("Esto trae "+result);
		
		if(result == 1) {
			return Constantes.EXITO;
		}else {
			return Constantes.FAILED;
		}
	}
	
	public String elimina(TipoEntrada entrada) {
		
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("update TipoEntrada set activo = 0 where codigo = :codigo");
		query.setParameter("codigo", entrada.getCodigo());
		
		int result = query.executeUpdate();
		
		if(result == 1) {
			return Constantes.EXITO;
		}else {
			return Constantes.FAILED;
		}
	}
	
	public TipoEntrada findAll(String codigo) {
		TipoEntrada entrada = new TipoEntrada();
		Session sesion = getSessionFactory().openSession();
	    
		Query q = sesion.getNamedQuery("TipoEntrada.findByCodigo");
		    
		q.setParameter("codigo", codigo);
		entrada = (TipoEntrada) q.uniqueResult();
		return entrada;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoEntrada> findAll() {
		List<TipoEntrada> entrada = null;
		Session sesion = getSessionFactory().openSession();
	    
		Query q = sesion.getNamedQuery("TipoEntrada.findAll");
		    
		entrada = q.list();
		return entrada;
	}
	
//	@Autowired
//	SessionFactory sessionFactory;
//	Session session = null;
//	Transaction tx = null;
	
//	public TipoEntrada addConfPr(RequestTipoEntrada en) throws Exception {
//		session = sessionFactory.openSession();
//		tx = session.beginTransaction();
//		session.save(en);
//		tx.commit();
//		session.close();
//		return false;
//	}

//	@Override
//	public TipoEntrada getTipoEntradaById(long id) throws Exception {
//		session = sessionFactory.openSession();
//		TipoEntrada entrada = (TipoEntrada)session.load(TipoEntrada.class, new Long(id));
//		  tx = session.getTransaction();  
//		  session.beginTransaction();  
//		  tx.commit();  
//		return entrada;
//	}
//
//	@Override
//	public List<TipoEntrada> getTipoEntradaList() throws Exception {
//		session = sessionFactory.openSession();
//		tx = session.beginTransaction();
//		List<TipoEntrada> lista = session.createCriteria(TipoEntrada.class).list();
//		 tx.commit();  
//		  session.close();  
//		return lista;
//	}
//

//	@Override
//	public boolean addConfPr(TipoEntrada entrada) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
