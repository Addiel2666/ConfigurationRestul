package com.tesis.conf.bo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.request.AddConfProductoRequest;
import com.tesis.conf.request.AddSocioRequest;
import com.tesis.conf.response.AddConfProductoResponse;
import com.tesis.conf.validation.ValidacionesGenerales;
import com.tests.conf.util.Constantes;

@Service
public class AgregarConfiguracion {

	@Resource
	GeneralFacadoDAO generalFacadeDAO;
	
	public AddConfProductoResponse start(AddConfProductoRequest request) {
		AddConfProductoResponse response = new AddConfProductoResponse();
		
		if(!validaciones(request)) {
			response.setCodigo(Constantes.FAILED);
			response.setDesc(Constantes.FAILED_PARAMETERS);
			return response;
		}
		
		
		
		return response;
	}
	
	private boolean validaciones(AddConfProductoRequest request) {
		ValidacionesGenerales validacionesGenerales = new ValidacionesGenerales();
		if(request.getIdSocio() == null || request.getIdSocio().equals("")) {
			return false;
		}
		if(request.getIdEntrada() == null || request.getIdEntrada().equals("")) {
			return false;
		}
		if(request.getNombreCarga() == null || request.getNombreCarga().equals("")) {
			return false;
		}
		if(request.getNombreNegocio() == null || request.getNombreNegocio().equals("")) {
			return false;
		}
		if(request.getSeparador() == null || request.getSeparador().equals("")) {
			return false;
		}
		
		return true;
	}
	
}
