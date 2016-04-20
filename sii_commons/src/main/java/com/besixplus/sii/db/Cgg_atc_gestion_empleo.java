package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASE Cgg_gem_vacante
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_vacante.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_atc_gestion_empleo implements Serializable{
	private static final long serialVersionUID = 1787279565;

	/**
	 * CONSTRUCTOR DE LA TABLA Cgg_atc_gestion_empleo.
	 */
	public Cgg_atc_gestion_empleo(){}


	/**
	 * OBTIENE EL NUMERO DE REGISTROS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inGroupName NOMBRE DEL GRUPO
	 * @param inGroupValue VALOR DEL GRUPO
	 * @return NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inGroupName,
			String inGroupValue
	){
		int outCount = 0;
		if (inKeyword == null)
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_GEM_SELECT_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inGroupName);
			stmSelect.setString(4, inGroupValue);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_vacante QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inGroupName NOMBRE DEL GRUPO
	 * @param inGroupValue VALOR DEL GRUPO
	 * @param inUser NOMBRE DE USUARIO
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageDirect(
			java.sql.Connection inConnection,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inGroupName,
			String inGroupValue,
			String inUser
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_vacante = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_GEM_SELECT_PAGE(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, inStart);
			stmSelect.setInt(3, inLimit);
			stmSelect.setString(4, inSortFieldName);
			stmSelect.setString(5, inDirection);
			stmSelect.setString(6, inKeyword);
			stmSelect.setString(7, inGroupName);
			stmSelect.setString(8, inGroupValue);
			stmSelect.setString(9, inUser);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_vacante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE VARIAS TABLAS
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inGrupo GRUPO SELECCIONADO PARA UNA NUEVA SELECCION
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectGrupo(
			java.sql.Connection inConnection,			
			String inGrupo
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_vacante = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_GEM_SELECT_GRUPO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inGrupo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_vacante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante;
	}

	/**
	 * OBTIENE EL NUMERO DE REGISTROS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inArea NOMBRE DEL AREA
	 * @return NUMERO DE REGISTROS.
	 */
	public static int subscripcionSelectAreaCargoCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inArea
	){
		int outCount = 0;
		if (inKeyword == null)
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_GEM_SELECT_SUBSCRIP_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inArea);			
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_cargo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inArea NOMBRE DEL AREA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_gem_cargo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> subscripcionSelectAreaCargo(
			java.sql.Connection inConnection,		
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inArea
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_cargo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_GEM_SELECT_SUBSCRIP(?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setInt(2, inStart);
			stmSelect.setInt(3, inLimit);
			stmSelect.setString(4, inSortFieldName);
			stmSelect.setString(5, inDirection);
			stmSelect.setString(6, inKeyword);
			stmSelect.setString(7, inArea);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_cargo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_cargo;
	}

	/**
	 * AGREGA EL PERFIL DE USUARIO DE GESTION DE EMPLEO A UN USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrperNumeroResidencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_gem_cargo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SQLException 
	 */
	public static ArrayList<HashMap<String, Object>> activarUsuarioGestionEmpleo(
			java.sql.Connection inConnection,		
			String inCrperNumeroResidencia,
			String inUserName
	) throws SQLException{		
		ArrayList<HashMap<String, Object>> arrResult = new ArrayList<HashMap<String,Object>>();
		Array result=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_GEM_ACTIVAR(?,?) }");
		stmSelect.registerOutParameter(1, Types.ARRAY);			
		stmSelect.setString(2, inCrperNumeroResidencia);
		stmSelect.setString(3, inUserName);
		stmSelect.execute();			
		result = stmSelect.getArray(1);
		ResultSet results = result.getResultSet(); 
		int tmpColumnCount = results.getMetaData().getColumnCount();
		while (results.next()) {
			HashMap<String,Object> tmpObj = new HashMap<String,Object>();
			for (int i = 1 ; i <= tmpColumnCount; i++)
				if(results.getObject(i) != null)
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
			arrResult.add(tmpObj);
		}
		results.close();
		stmSelect.close();			

		return arrResult;
	}
	
	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_web_frase_bienvenida DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCusu_Codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return com.besixplus.sii.objects.Cgg_web_frase_bienvenida OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectEstadistica(
		java.sql.Connection inConnection,
		String inCusu_Codigo
	){
		ArrayList<HashMap<String,Object>> outRes = new ArrayList<HashMap<String,Object>>();		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ATC_GEM_ESTADISTICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCusu_Codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);			
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outRes.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outRes;
	}
}
