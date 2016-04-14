package com.besixplus.sii.db;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.besixplus.sii.objects.Cgg_sec_log;

/**
 * Clase Publica. 
 * Centraliza el manejo de errores de la Base de Datos
 * Autor: BESIXPLUS CIA. LTDA.
 */

public class SQLErrorHandler implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SQLErrorHandler() {
	}
	/**
	 * Metodo Publico Estatico. Administra los mensajes de error producidos por las clases de acceso a base de datos.
	 * @param inException Excepcion producida.
	 */
	public static void errorHandler(Exception inException){
		
		inException.printStackTrace();
		
		StringWriter tmpStr = new StringWriter();
		PrintWriter tmpPW = new PrintWriter(tmpStr);
		inException.printStackTrace(tmpPW);
		
		Cgg_sec_log tmpLog = new Cgg_sec_log();
		tmpLog.setCSLOG_CODIGO("KEYGEN");
		tmpLog.setCSLOG_FECHA(new Date());
		tmpLog.setCSLOG_MENSAJE(inException.getMessage());
		tmpLog.setCSLOG_PROCESO(tmpStr.toString());
		tmpLog.setCSLOG_TIPO(Cgg_sec_log.Tipo.ERROR.toString());
		tmpLog.setCSLOG_USUARIO(ManagerConnection.getAppUserName());
		Connection tmpCon = ManagerConnection.getConnection();
		new com.besixplus.sii.db.Cgg_sec_log(tmpLog).insert(tmpCon);
		try {
			tmpCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
