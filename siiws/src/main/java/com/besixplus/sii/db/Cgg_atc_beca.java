package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_atc_comunicado_radial
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_vacante.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_atc_beca implements Serializable{
	private static final long serialVersionUID = 1787279567;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_atc_comunicado_radial.
	*/
	public Cgg_atc_beca(){}	
	
	/**
	* OBTIENE EL TOTAL DE REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return outCount TOTAL REGISTROS.
	*/
	public static int selectBecaBeneficiarioCount(
		java.sql.Connection inConnection,
		String inKeyword		
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_BECA_BENEFICIARIO_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);			
			stmSelect.setString(2, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	* OBTIENE LOS REGISTROS DE RESOLUCIONES TOMADAS POR EL COMITE.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO 
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<HashMap<String,Object>> REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectBecaBeneficiario(			
		java.sql.Connection inConnection,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ATC_BECA_BENEFICIARIO(?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, inStart);
			stmSelect.setInt(3, inLimit);
			stmSelect.setString(4, inSortFieldName);
			stmSelect.setString(5, inDirection);
			stmSelect.setString(6, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_beca.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}
}