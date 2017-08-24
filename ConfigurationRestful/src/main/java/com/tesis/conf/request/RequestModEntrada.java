package com.tesis.conf.request;

import java.io.Serializable;

public class RequestModEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8044089266810014410L;
	private String cveArchivo;
	private String extension;
	private String modificacion;
	public String getCveArchivo() {
		return cveArchivo;
	}
	public void setCveArchivo(String cveArchivo) {
		this.cveArchivo = cveArchivo;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getModificacion() {
		return modificacion;
	}
	public void setModificacion(String modificacion) {
		this.modificacion = modificacion;
	}
	
	
}
