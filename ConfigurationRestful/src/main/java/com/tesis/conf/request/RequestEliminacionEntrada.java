package com.tesis.conf.request;

import java.io.Serializable;

public class RequestEliminacionEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 946288979739671533L;
	private String cveCodigo;
	public String getCveCodigo() {
		return cveCodigo;
	}
	
	public void setCveCodigo(String cveCodigo) {
		this.cveCodigo = cveCodigo;
	}
	
	
}
