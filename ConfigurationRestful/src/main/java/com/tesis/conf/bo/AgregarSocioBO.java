package com.tesis.conf.bo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.AltaSocio;
import com.tesis.conf.dto.TipoEstatus;
import com.tesis.conf.request.AddSocioRequest;
import com.tesis.conf.response.AddSocionResponse;
import com.tesis.conf.validation.ValidacionesGenerales;
import com.tests.conf.util.Constantes;

@Service
public class AgregarSocioBO {

	@Resource
	GeneralFacadoDAO generalFacadoDAO;
	
	public AddSocionResponse startAdd(AddSocioRequest request) {
		AddSocionResponse response = new AddSocionResponse();
		AltaSocio socio = new AltaSocio();
		TipoEstatus estatus = new TipoEstatus();
		if(!validaciones(request)) {
			response.setCodigo(Constantes.FAILED);
			response.setDesc(Constantes.FAILED_PARAMETERS);
			return response;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date =  Calendar.getInstance().getTime();
		String dateToday = df.format(date);
		
		SimpleDateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date2 = df.parse(dateToday);
			socio.setFechaCreacion(date2);
			
			Date fechaInicio = fechas.parse(request.getFechaInicio());
			socio.setFechaVigenciaInicio(fechaInicio);
			Date fechaFin = fechas.parse(request.getFechaFin());
			socio.setFechaVigenciaFinal(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		socio.setNombreSocio(request.getNombreSocio());
		boolean validaClave = generalFacadoDAO.getAltaSocioDAOImpl().validaExistenciaNom(socio.getNombreSocio());
		if(validaClave==false) {
			response.setCodigo(Constantes.FAILED_CVE_NOM_SOCIO);
			response.setDesc(Constantes.FAILED_DES_NOM_SOCIO);
			return response;
		}
		socio.setClaveSocio(request.getClave());
		 validaClave = generalFacadoDAO.getAltaSocioDAOImpl().validaExistenciaCod(socio.getClaveSocio());
		if(validaClave==false) {
			response.setCodigo(Constantes.FAILED_CVE_CLV_SOCIO);
			response.setDesc(Constantes.FAILED_DES_CLV_SOCIO);
			return response;
		}
		socio.setDescripcionSocio(request.getDescripcion());
		estatus = generalFacadoDAO.getEstatusDAOImpl().finAllActivo();
		socio.setEstatus(estatus);
		
		Serializable guardado = null;
		try {
			guardado = generalFacadoDAO.getAltaSocioDAOImpl().addSocio(socio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(guardado == null) {
			response.setCodigo(Constantes.FAILED);
			response.setDesc(Constantes.CVE_RESPONSE_FAILED);
			return response;
		}
		response.setCodigo(Constantes.CVE_RESPONSE_EXITO);
		response.setDesc(Constantes.EXITO);
		return response;
	}

	private boolean validaciones(AddSocioRequest request) {
		ValidacionesGenerales validacionesGenerales = new ValidacionesGenerales();
		if(request.getClave() == null || request.getClave().equals("")) {
			return false;
		}
		if(request.getDescripcion() == null || request.getDescripcion().equals("")) {
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
