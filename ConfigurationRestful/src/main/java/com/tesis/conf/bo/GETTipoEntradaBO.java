package com.tesis.conf.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tesis.conf.dao.GeneralFacadoDAO;
import com.tesis.conf.dto.TipoEntrada;
import com.tesis.conf.response.ResponseGETTipoEntrada;

@Service
public class GETTipoEntradaBO {

@Resource
GeneralFacadoDAO generalFacadoDAO;

	public ResponseGETTipoEntrada start() {
		ResponseGETTipoEntrada list = new ResponseGETTipoEntrada();
		List<TipoEntrada> listaAll = new ArrayList<TipoEntrada>();
		
		try {
			listaAll = generalFacadoDAO.getEntradaDAOImpl().findAll();
			list.setList(listaAll);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

}
