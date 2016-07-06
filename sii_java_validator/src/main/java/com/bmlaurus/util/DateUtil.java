/*
 * DateUtil.java
 * 
 * Copyright (c) 2010 Servicio de Rentas Internas.
 * Todos los derechos reservados.
 */

package com.bmlaurus.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase utilitaria de fechas
 * 
 * @author Ximena Silva
 * @version $Revision: 1.1 $
 */
public final class DateUtil {

	/**
	 * Formato :: yyyy-MM-ddd
	 */
	public static String F_yyyy_MM_dd = "yyyy-MM-dd";
	
	public static String F_ddMMyyyy = "dd/MM/yyyy";
	
	public static String FECHA_11JUNIO = "2015-06-11";
	
	public static int ANOS = 10;

	
	private DateUtil() {
	}

	
	/**
	 * Parsea una fecha String dado un patron
	 * 
	 * @param patron
	 * @param fecha
	 * @return
	 */
	public static Date formatDate(final String patron, final String fecha) {
		final DateFormat dateFormat = new SimpleDateFormat(patron);
		dateFormat.setLenient(Boolean.FALSE);
		try {

			return dateFormat.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Formatea una fecha Object dado un patron
	 * 
	 * @param patron
	 * @param fecha
	 * @return
	 */
	public static String formatDate(final String patron, final Object fecha) {
		final DateFormat dateFormat = new SimpleDateFormat(patron);
		return dateFormat.format(fecha);
	}

	/**
	 * Obtiene el anio de una fecha
	 * 
	 * @param fecha
	 * @return
	 */
	public static int getYear(final Date fecha) {
		GregorianCalendar fechaCal = new GregorianCalendar();
		fechaCal.setTime(fecha);
		return fechaCal.get(Calendar.YEAR);
	}

	/**
	 * Obtiene el mes de una fecha
	 * 
	 * @param fecha
	 * @return
	 */
	public static int getMonth(final Date fecha) {
		GregorianCalendar fechaCal = new GregorianCalendar();
		fechaCal.setTime(fecha);
		return fechaCal.get(Calendar.MONTH);
	}

	/**
	 * Obtiene el dia del mes de una fecha
	 * 
	 * @param fecha
	 * @return
	 */
	public static int getDay(final Date fecha) {
		GregorianCalendar fechaCal = new GregorianCalendar();
		fechaCal.setTime(fecha);
		return fechaCal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Suma años a la fecha enviada
	 * 
	 * @param fecha
	 * @param anos
	 * @return
	 */
	public static Date sumarAnos(final Date fecha, final int anos) {
		 Calendar c1 = GregorianCalendar.getInstance();
		 c1.setTime(fecha);
		 c1.add(Calendar.YEAR, anos);
		 return c1.getTime();
	}
	
	

}