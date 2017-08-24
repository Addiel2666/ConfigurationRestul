package com.tesis.conf.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.AltaSocio;
import com.tesis.conf.response.SocioGETResponse;

@Service
public class SocioConsultaBO {
	@Resource
	GeneralFacadoDAO facadoDAO;
	
	public SocioGETResponse start() {
		SocioGETResponse list = new SocioGETResponse();
		List<AltaSocio> listaAll = new ArrayList<AltaSocio>();
		try {
			listaAll = facadoDAO.getAltaSocioDAOImpl().listaCompleta();
			list.setList(listaAll);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
