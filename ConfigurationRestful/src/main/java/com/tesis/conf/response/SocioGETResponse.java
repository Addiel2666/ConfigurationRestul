package com.tesis.conf.response;

import java.io.Serializable;
import java.util.List;

import com.tesis.conf.dto.AltaSocio;

public class SocioGETResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747694540364107769L;
	private List<AltaSocio> list;
	public List<AltaSocio> getList() {
		return list;
	}
	public void setList(List<AltaSocio> list) {
		this.list = list;
	}
	
	
}
