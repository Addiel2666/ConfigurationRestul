package com.tesis.conf.bo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.log4j.helpers.NullEnumeration;
import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.request.EliminarSocioRequest;
import com.tesis.conf.response.EliminaSocioResponse;
import com.tests.conf.util.Constantes;

@Service
public class EliminaSocioBO {

	
	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	
	public EliminaSocioResponse start(EliminarSocioRequest request) {
		EliminaSocioResponse response = new EliminaSocioResponse();
		
		Serializable numeroValida = generalFacadoDAO.getAltaSocioDAOImpl().validaDatos(request.getElimina());
		if(numeroValida == null) {
			response.setCodigo(Constantes.CVE_RESPONSE_FAILED);
			response.setDesc(Constantes.FAILED);
			return response;
		}
		
		String numeroElimina = generalFacadoDAO.getAltaSocioDAOImpl().elimina(request.getElimina(), numeroValida);
		if(numeroElimina == Constantes.EXITO) {
			response.setCodigo(Constantes.CVE_RESPONSE_EXITO);
			response.setDesc(Constantes.EXITO);
			return response;
		}else {
			response.setCodigo(Constantes.CVE_RESPONSE_FAILED);
			response.setDesc(Constantes.FAILED);
			return response;
		}
	}
	
}
