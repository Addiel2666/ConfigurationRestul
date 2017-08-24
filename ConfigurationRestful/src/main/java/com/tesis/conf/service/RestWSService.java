package com.tesis.conf.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesis.conf.bo.AgregarSocioBO;
import com.tesis.conf.bo.EliminaSocioBO;
import com.tesis.conf.bo.EliminacionEntradaBO;
import com.tesis.conf.bo.GETTipoEntradaBO;
import com.tesis.conf.bo.ModEntradaBO;
import com.tesis.conf.bo.ModSocioBO;
import com.tesis.conf.bo.SocioConsultaBO;
import com.tesis.conf.bo.TipoEntradaBO;
import com.tesis.conf.request.AddSocioRequest;
import com.tesis.conf.request.EliminarSocioRequest;
import com.tesis.conf.request.ModSocioRequest;
import com.tesis.conf.request.RequestEliminacionEntrada;
import com.tesis.conf.request.RequestModEntrada;
import com.tesis.conf.request.RequestTipoEntrada;
import com.tesis.conf.response.AddSocionResponse;
import com.tesis.conf.response.EliminaSocioResponse;
import com.tesis.conf.response.ModSocioResponse;
import com.tesis.conf.response.ResponseEliminacionEntrada;
import com.tesis.conf.response.ResponseGETTipoEntrada;
import com.tesis.conf.response.ResponseModEntrada;
import com.tesis.conf.response.ResponseTipoEntrada;
import com.tesis.conf.response.SocioGETResponse;

@Controller
public class RestWSService {

	@Resource
	TipoEntradaBO bo;
	
	@Resource
	ModEntradaBO modEntrada;
	
	@Resource
	EliminacionEntradaBO eliminaEntrada;
	
	@Resource
	GETTipoEntradaBO get;
	
	@Resource
	AgregarSocioBO agregar;
	
	@Resource
	ModSocioBO modSocio;
	
	@Resource
	EliminaSocioBO deleteSocio;
	
	@Resource
	SocioConsultaBO listaSocio;
	
	@RequestMapping(value = "getAltaCarga", method = RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public ResponseTipoEntrada tipoEntrada(@RequestBody RequestTipoEntrada entrada) {
		return bo.tipoEntrada(entrada);
	}
	
	@RequestMapping(value = "getModificacionCarga", method = RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public ResponseModEntrada modEntrada(@RequestBody RequestModEntrada request) {
		return modEntrada.start(request);
	}
	
	@RequestMapping(value = "getElminacionCarga", method = RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public ResponseEliminacionEntrada eliminacionEntrada(@RequestBody RequestEliminacionEntrada request) {
		return eliminaEntrada.start(request);
	}
	
	@RequestMapping(value = "getConsultaEntradas", method = RequestMethod.GET, produces= {"application/json"})
	@ResponseBody
	public ResponseGETTipoEntrada getTipoEntrada () {
		return get.start();
	}
	
	@RequestMapping(value = "addSocio",method = RequestMethod.POST, produces= {"application/json"})
	@ResponseBody
	public AddSocionResponse altaSocio(@RequestBody AddSocioRequest request) {
		return agregar.startAdd(request);
	}
	
	@RequestMapping(value = "modSocio",method = RequestMethod.POST, produces= {"application/json"})
	@ResponseBody
	public ModSocioResponse modSocio(@RequestBody ModSocioRequest request) {
		return modSocio.start(request);
	}
	
	@RequestMapping(value = "deleteSocio",method = RequestMethod.POST, produces= {"application/json"})
	@ResponseBody
	public EliminaSocioResponse deleteSocio(@RequestBody EliminarSocioRequest request) {
		return deleteSocio.start(request);
	}
	
	@RequestMapping(value = "getSocio",method = RequestMethod.GET, produces= {"application/json"})
	@ResponseBody
	public SocioGETResponse listaSocio() {
		return listaSocio.start();
	}
}
