package com.tesis.conf.bo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tesis.conf.cron.CronConf;
import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.TipoEntrada;
import com.tesis.conf.dto.TipoEstatus;
import com.tesis.conf.request.RequestTipoEntrada;
import com.tesis.conf.response.ResponseTipoEntrada;
import com.tests.conf.util.Constantes;

@Service
public class TipoEntradaBO {

	private static final Logger log = Logger.getLogger(TipoEntradaBO.class);
	
	@Resource
	CronConf conf;
	
	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	
	ResponseTipoEntrada entrada;
	boolean entrada2 = false;
	
	public ResponseTipoEntrada tipoEntrada(RequestTipoEntrada entrada) {
		
		log.info("Inicia el negocio de entrada");
		
		
		ResponseTipoEntrada response = new ResponseTipoEntrada();
		if(!valida(entrada)) {
			response.setCodigo("01");
			response.setDesc("Hubo un error en los parametros");
			return response;
		}
		
		
		try {
		TipoEntrada entry = new TipoEntrada();
		entry.setCodigo(entrada.getCodigo());
		
		boolean bandera = conf.consulta(entry.getCodigo());
		if(bandera == true) {
		entry.setDescripcion(entrada.getDescripcion());
		entry.setExtension(entrada.getExtension());
		TipoEstatus estatus = new TipoEstatus();
		estatus = generalFacadoDAO.getEstatusDAOImpl().finAllActivo();
		entry.setActivo(estatus);
		Serializable numero = generalFacadoDAO.getEntradaDAOImpl().addConfPr(entry);
		log.info("Esto es numero "+numero);
			if(numero != null) {
				log.info("Todo salio bien");
				response.setCodigo("00");
				response.setDesc("Todo es correcto");
				return response;
			}
		}else {
			response.setCodigo(Constantes.CVE_RESPONSE_FAILED);
			response.setDesc(Constantes.FAILED);
			return response;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	private boolean valida(RequestTipoEntrada entrada2) {
		if(entrada2.getCodigo() == null && entrada2.equals("")) {
			return false;
		} else if(entrada2.getDescripcion() == null && entrada2.equals("")) {
			return false;
		} else if(entrada2.getExtension() == null && entrada2.equals("")) {
			return false;
		}
		return true;
	}
	
}
