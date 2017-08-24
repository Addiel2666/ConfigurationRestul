package com.tesis.conf.request;

import java.io.Serializable;

public class ModSocioRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8901585114957016885L;
	private String nombreSocio;
	private String claveSocioOld;
	private String claveSocioNew;
	private String fechaInicio;
	private String fechaFin;
	public String getNombreSocio() {
		return nombreSocio;
	}
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	
	
	
	public String getClaveSocioOld() {
		return claveSocioOld;
	}
	public void setClaveSocioOld(String claveSocioOld) {
		this.claveSocioOld = claveSocioOld;
	}
	public String getClaveSocioNew() {
		return claveSocioNew;
	}
	public void setClaveSocioNew(String claveSocioNew) {
		this.claveSocioNew = claveSocioNew;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
