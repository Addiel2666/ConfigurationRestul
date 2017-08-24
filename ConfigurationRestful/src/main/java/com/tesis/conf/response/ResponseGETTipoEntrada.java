package com.tesis.conf.response;

import java.io.Serializable;
import java.util.List;

import com.tesis.conf.dto.TipoEntrada;

public class ResponseGETTipoEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014135925442334894L;
	private List<TipoEntrada> list;
	public List<TipoEntrada> getList() {
		return list;
	}
	public void setList(List<TipoEntrada> list) {
		this.list = list;
	}
	
	
	
}
