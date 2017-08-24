package com.tesis.conf.bo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.TipoEntrada;
import com.tesis.conf.request.RequestModEntrada;
import com.tesis.conf.response.ResponseModEntrada;
import com.tesis.conf.validation.ValidacionesGenerales;
import com.tests.conf.util.Constantes;

@Service
public class ModEntradaBO {

	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	
	private static final Logger log = Logger.getLogger(ModEntradaBO.class);
	
	public ResponseModEntrada start(RequestModEntrada request) {
		log.info("Inicia la modificacion del tipo de entrada");
		
		ValidacionesGenerales generales = new ValidacionesGenerales();
		ResponseModEntrada response = new ResponseModEntrada();
		TipoEntrada entrada = new TipoEntrada();
		
		if(generales.validaModificacion(request).equals(Constantes.FAILED)) {
			response.setCodigo(Constantes.CVE_RESPONSE_FAILED);
			response.setDesc(Constantes.FAILED);
			return response;
		}
		
		try {
			entrada.setExtension(request.getExtension());
			entrada.setCodigo(request.getCveArchivo());
			Serializable numero = generalFacadoDAO.getEntradaDAOImpl().actualiza(entrada);
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
