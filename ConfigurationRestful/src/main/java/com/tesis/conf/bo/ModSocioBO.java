package com.tesis.conf.bo;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.AltaSocio;
import com.tesis.conf.request.ModSocioRequest;
import com.tesis.conf.response.ModSocioResponse;
import com.tesis.conf.validation.ValidacionesGenerales;
import com.tests.conf.util.Constantes;

@Service
public class ModSocioBO {

	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	
	public ModSocioResponse start(ModSocioRequest request) {
		ModSocioResponse response = new ModSocioResponse();
		ValidacionesGenerales generales = new ValidacionesGenerales();
	
		if(!validaciones(request)) {
			response.setCodigo(Constantes.FAILED);
			response.setDesc(Constantes.FAILED_PARAMETERS);
			return response;
		}
		
		Serializable registroExist = generalFacadoDAO.getAltaSocioDAOImpl().validaDatos(request.getClaveSocioOld());
		System.out.println("esto es registo "+registroExist);
		if(registroExist == null) {
			response.setCodigo(Constantes.FAILED_CVE_REGISTRO);
			response.setDesc(Constantes.FAILED_DES_REGISTRO);
			return response;
		}else {
			AltaSocio socio =new AltaSocio();
//			altaSocio = generalFacadoDAO.getAltaSocioDAOImpl().validaExistenciaCod2(request.getClaveSocio(), registroExist);
			
			Date fechaInicio = generales.fechaTransformada(request.getFechaInicio());
			Date fechaFin = generales.fechaTransformada(request.getFechaFin());
			
			
			socio.setNombreSocio(request.getNombreSocio());
			socio.setClaveSocio(request.getClaveSocioNew());
			socio.setFechaVigenciaInicio(fechaInicio);
			socio.setFechaVigenciaFinal(fechaFin);
			
			String actualizo = generalFacadoDAO.getAltaSocioDAOImpl().actualiza(socio,registroExist );
			if(actualizo == Constantes.EXITO) {
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
	
	private boolean validaciones(ModSocioRequest request) {
		ValidacionesGenerales validacionesGenerales = new ValidacionesGenerales();
		if(request.getClaveSocioNew() == null || request.getClaveSocioNew().equals("")) {
			return false;
		}
	
		if(request.getFechaInicio() == null || request.getFechaInicio().equals("")) {
			return false;
		}
		if(request.getFechaFin() == null || request.getFechaFin().equals("")) {
			return false;
		}
		if(request.getNombreSocio() == null || request.getNombreSocio().equals("")) {
			return false;
		}
		if(!validacionesGenerales.fecha("dd/MM/yyyy",request.getFechaInicio())) {
			return false;
		}
		if(!validacionesGenerales.fecha("dd/MM/yyyy",request.getFechaFin())) {
			return false;
		}
		return true;
	}
	
}
