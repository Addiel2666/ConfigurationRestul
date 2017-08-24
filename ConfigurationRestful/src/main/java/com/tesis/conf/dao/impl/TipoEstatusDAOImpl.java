package com.tesis.conf.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tesis.conf.dao.TipoEstatusDAO;
import com.tesis.conf.dto.TipoEstatus;

@Repository
public class TipoEstatusDAOImpl extends TipoEstatusDAO<TipoEstatus>{
	@Autowired
    public TipoEstatusDAOImpl(
            @Qualifier("sessionFactory") SessionFactory sessionFactory) {
    	super.setSessionFactory(sessionFactory);
    }
	
	public TipoEstatusDAOImpl(){}
	

	public TipoEstatus finAllActivo() {
		TipoEstatus estatus = new TipoEstatus();
		Session session = getSessionFactory().openSession();
		Query query = session.getNamedQuery("TipoEstatus.findAllActivo");
		estatus = (TipoEstatus) query.uniqueResult();
		return estatus;
	}
	
}
