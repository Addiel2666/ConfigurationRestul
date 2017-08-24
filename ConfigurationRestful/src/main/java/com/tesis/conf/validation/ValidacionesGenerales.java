package com.tesis.conf.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.tesis.conf.request.RequestModEntrada;
import com.tests.conf.util.Constantes;

public class ValidacionesGenerales {

	public String validaModificacion(RequestModEntrada entrada) {

		if(entrada.getExtension()== null || entrada.getExtension().equals("")) {
			return Constantes.FAILED ;
		}
		if(entrada.getModificacion() == null || entrada.getModificacion().equals("")) {
			return Constantes.FAILED ;
		}
		if(Integer.parseInt(entrada.getModificacion()) != 0) {
			return Constantes.FAILED ;
		}
		return Constantes.EXITO;
	}
	
	public boolean fecha(String mask,String fecha) {
		boolean retorno = false;
		try {
			Locale locInstancia = new Locale("es", "MX");
			DateFormat dfInstancia;
			Date dInstancia;
			dfInstancia = new SimpleDateFormat(mask,locInstancia);
			dInstancia = (Date)dfInstancia.parse(fecha);
			Calendar calendar = Calendar.getInstance(locInstancia);
			calendar.setTime(dInstancia);
			retorno = true;
		} catch (ParseException e) {
			retorno = false;
		}
		
		return retorno;
	}
	
	public Date fechaTransformada(String fecha) {
		
		SimpleDateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = fechas.parse(fecha);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
