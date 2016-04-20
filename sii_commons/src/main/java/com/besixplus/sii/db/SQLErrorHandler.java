package com.besixplus.sii.db;
import com.besixplus.sii.objects.Cgg_sec_log;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * CLASE PUBLICA
 * CENTRALIZA EL MANEJO DE ERRORES DE LA BASE DE DATOS.
 * Author: BESIXPLUS CIA. LTDA.
 */

public class SQLErrorHandler implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	public SQLErrorHandler() {
	}

	/**
	 * METODO PUBLICO ESTATICO. ADMINISTRA LOS MENSAJES DE ERROR PRODUCIDOS POR LAS CLASES DE ACCESO A LA BASE DE DATOS.
	 * @param inException EXCEPCION PRODUCIDA.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addError(int inTipoError,String inError){

		Cgg_sec_log tmpLog = new Cgg_sec_log();
		tmpLog.setCSLOG_CODIGO("KEYGEN");
		tmpLog.setCSLOG_FECHA(new Date());
		tmpLog.setCSLOG_MENSAJE(inError);
		tmpLog.setCSLOG_PROCESO("");
		tmpLog.setCSLOG_TIPO(String.valueOf(inTipoError));
		tmpLog.setCSLOG_USUARIO(ManagerConnection.getAppUserName());
		Connection tmpCon = ManagerConnection.getConnection();
		new com.besixplus.sii.db.Cgg_sec_log(tmpLog).insert(tmpCon);
		try {
			tmpCon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
