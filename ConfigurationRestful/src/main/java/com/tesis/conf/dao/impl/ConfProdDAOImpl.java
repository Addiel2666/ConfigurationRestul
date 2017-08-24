package com.tesis.conf.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tesis.conf.dao.ConfProdDAO;
import com.tesis.conf.dto.ConfiguracionProducto;

@Repository
public class ConfProdDAOImpl extends ConfProdDAO<ConfiguracionProducto>{
	private static final Logger log = Logger.getLogger(ConfProdDAOImpl.class);
	
	
	@Autowired
    public ConfProdDAOImpl(
            @Qualifier("sessionFactory") SessionFactory sessionFactory) {
    	super.setSessionFactory(sessionFactory);
    }
	
	public ConfProdDAOImpl(){}
}
