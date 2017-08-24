package com.tesis.conf.bo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.TipoEntrada;
import com.tesis.conf.request.RequestEliminacionEntrada;
import com.tesis.conf.response.ResponseEliminacionEntrada;
import com.tests.conf.util.Constantes;

@Service
public class EliminacionEntradaBO {

	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	
	public ResponseEliminacionEntrada start(RequestEliminacionEntrada request) {
		
		ResponseEliminacionEntrada response = new ResponseEliminacionEntrada();
		
		try {
			TipoEntrada entrada = new TipoEntrada();
			entrada.setCodigo(request.getCveCodigo());
			
			Serializable numero = generalFacadoDAO.getEntradaDAOImpl().elimina(entrada);
			
			if(numero != null) {
				response.setCodigo(Constantes.CVE_RESPONSE_EXITO);
				response.setDesc(Constantes.EXITO);
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
