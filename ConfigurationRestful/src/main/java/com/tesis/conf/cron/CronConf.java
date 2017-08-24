package com.tesis.conf.cron;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.TipoEntrada;

@Service
public class CronConf {

	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	

	public boolean consulta(String altaEntrada) {
		
		TipoEntrada entrada = new TipoEntrada();
		entrada = generalFacadoDAO.getEntradaDAOImpl().findAll(altaEntrada);
		
		if(entrada != null) {
			return false;
		}else {
			return true;
		}
		
	}
	
}
