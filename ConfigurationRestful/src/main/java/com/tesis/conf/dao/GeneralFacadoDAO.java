package com.tesis.conf.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.impl.AltaSocioDAOImpl;
import com.tesis.conf.dao.impl.ConfProdDAOImpl;
import com.tesis.conf.dao.impl.TipoEntradaDAOImpl;
import com.tesis.conf.dao.impl.TipoEstatusDAOImpl;

@Service
public class GeneralFacadoDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692044749298108140L;
	
	@Resource
	TipoEntradaDAOImpl entradaDAOImpl;
	@Resource
	TipoEstatusDAOImpl estatusDAOImpl;
	@Resource
	AltaSocioDAOImpl altaSocioDAOImpl;
	@Resource
	ConfProdDAOImpl confProdDAOImpl;
	
	public TipoEntradaDAOImpl getEntradaDAOImpl() {
		return entradaDAOImpl;
	}
	
	public TipoEstatusDAOImpl getEstatusDAOImpl() {
		return estatusDAOImpl;
	}

	public AltaSocioDAOImpl getAltaSocioDAOImpl() {
		return altaSocioDAOImpl;
	}

	public ConfProdDAOImpl getConfProdDAOImpl() {
		return confProdDAOImpl;
	};
	
	
}
