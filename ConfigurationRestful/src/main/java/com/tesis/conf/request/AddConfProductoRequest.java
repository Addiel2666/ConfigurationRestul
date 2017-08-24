package com.tesis.conf.request;

import java.io.Serializable;

public class AddConfProductoRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243516318806894209L;
	private String idSocio;
	private String nombreCarga;
	private String nombreNegocio;
	private String separador;
	private String idEntrada;
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombreCarga() {
		return nombreCarga;
	}
	public void setNombreCarga(String nombreCarga) {
		this.nombreCarga = nombreCarga;
	}
	public String getNombreNegocio() {
		return nombreNegocio;
	}
	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	public String getSeparador() {
		return separador;
	}
	public void setSeparador(String separador) {
		this.separador = separador;
	}
	public String getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(String idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	
}
