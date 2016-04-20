package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
* CLASE Cgg_sec_objeto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_objeto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_objeto implements Serializable{
	private static final long serialVersionUID = 30363666;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_objeto.
	*/
	private com.besixplus.sii.objects.Cgg_sec_objeto myCgg_sec_objeto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto.
	*/
	public Cgg_sec_objeto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto.
	* @param inCgg_sec_objeto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_objeto.
	*/
	public Cgg_sec_objeto(
		com.besixplus.sii.objects.Cgg_sec_objeto inCgg_sec_objeto
	){
		this.setCgg_sec_objeto(inCgg_sec_objeto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_objeto.
	* @param inCgg_sec_objeto OBJETO Cgg_sec_objeto.
	* @return void
	*/
	public void setCgg_sec_objeto(com.besixplus.sii.objects.Cgg_sec_objeto inCgg_sec_objeto){
		this.myCgg_sec_objeto = inCgg_sec_objeto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_objeto.
	* @return Cgg_sec_objeto OBJETO Cgg_sec_objeto.
	*/
	public com.besixplus.sii.objects.Cgg_sec_objeto getCgg_sec_objeto(){
		return this.myCgg_sec_objeto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_INSERT(?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_objeto().getCSOBJ_CODIGO());
			stmInsert.setString(3, this.getCgg_sec_objeto().getCSOBJ_NOMBRE());
			stmInsert.setString(4, this.getCgg_sec_objeto().getCSOBJ_RUTA());
			stmInsert.setString(5, this.getCgg_sec_objeto().getCSOBJ_DESCRIPCION());
			stmInsert.setInt(6, this.getCgg_sec_objeto().getCSOBJ_TIPO());
			stmInsert.setBoolean(7, this.getCgg_sec_objeto().getCSOBJ_ESTADO());
			stmInsert.setString(8, this.getCgg_sec_objeto().getCSOBJ_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_sec_objeto().setCSOBJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> outCgg_sec_objeto = new ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_objeto tmpCgg_sec_objeto = new com.besixplus.sii.objects.Cgg_sec_objeto();
				tmpCgg_sec_objeto.setCSOBJ_CODIGO(results.getString(1));
				tmpCgg_sec_objeto.setCSOBJ_NOMBRE(results.getString(2));
				tmpCgg_sec_objeto.setCSOBJ_RUTA(results.getString(3));
				tmpCgg_sec_objeto.setCSOBJ_DESCRIPCION(results.getString(4));
				tmpCgg_sec_objeto.setCSOBJ_TIPO(results.getInt(5));
				tmpCgg_sec_objeto.setCSOBJ_ESTADO(results.getBoolean(6));
				outCgg_sec_objeto.add(tmpCgg_sec_objeto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO <code>ASC|DESC</code>.
	* @param inTypeObject TIPO DE OBJETOS QUE SE DESEA OBTENER: 0 - INTERFACES VISUALES, 1 - SERVICIOS WEB
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		int inTypeObject
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> outCgg_sec_objeto = new ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setInt(8, inTypeObject);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_objeto tmpCgg_sec_objeto = new com.besixplus.sii.objects.Cgg_sec_objeto();
				tmpCgg_sec_objeto.setCSOBJ_CODIGO(results.getString(1));
				tmpCgg_sec_objeto.setCSOBJ_NOMBRE(results.getString(2));
				tmpCgg_sec_objeto.setCSOBJ_RUTA(results.getString(3));
				tmpCgg_sec_objeto.setCSOBJ_DESCRIPCION(results.getString(4));
				tmpCgg_sec_objeto.setCSOBJ_TIPO(results.getInt(5));
				tmpCgg_sec_objeto.setCSOBJ_ESTADO(results.getBoolean(6));
				outCgg_sec_objeto.add(tmpCgg_sec_objeto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO <code>ASC|DESC</code>.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inTypeObject TIPO DE OBJETOS QUE SE DESEA OBTENER: 0 - INTERFACES VISUALES, 1 - SERVICIOS WEB
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ROL.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		int inTypeObject,
		String inCsrol_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_sec_objeto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setInt(8, inTypeObject);
			stmSelect.setString(9, inCsrol_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_sec_objeto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inTypeObject IDENTIFICATIVO DE TIPO DE OBJETO.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		int inTypeObject
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setInt(2, inTypeObject);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inTypeObject IDENTIFICATIVO DE TIPO DE OBJETO.
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ROL.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		int inTypeObject,
		String inCsrol_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setInt(3, inTypeObject);
			stmSelect.setString(4, inCsrol_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_UPDATE(?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sec_objeto().getCSOBJ_CODIGO());
			stmUpdate.setString(2, this.getCgg_sec_objeto().getCSOBJ_NOMBRE());
			stmUpdate.setString(3, this.getCgg_sec_objeto().getCSOBJ_RUTA());
			stmUpdate.setString(4, this.getCgg_sec_objeto().getCSOBJ_DESCRIPCION());
			stmUpdate.setInt(5, this.getCgg_sec_objeto().getCSOBJ_TIPO());
			stmUpdate.setBoolean(6, this.getCgg_sec_objeto().getCSOBJ_ESTADO());
			stmUpdate.setString(7, this.getCgg_sec_objeto().getCSOBJ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_objeto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_objeto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_objeto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_objeto().getCSOBJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_objeto().setCSOBJ_CODIGO(results.getString(1));
				this.getCgg_sec_objeto().setCSOBJ_NOMBRE(results.getString(2));
				this.getCgg_sec_objeto().setCSOBJ_RUTA(results.getString(3));
				this.getCgg_sec_objeto().setCSOBJ_DESCRIPCION(results.getString(4));
				this.getCgg_sec_objeto().setCSOBJ_TIPO(results.getInt(5));
				this.getCgg_sec_objeto().setCSOBJ_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_objeto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sec_objeto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sec_objeto().getCSOBJ_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sec_objeto().getCSOBJ_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}
	/**
	 * VERIFICA SI UN USUARIO TIENE ACCESO A UN OBJETO.
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inObject NOMBRE DEL OBJETO
	 * @param inPath RUTA DONDE SE ENCUENTRA EN OBJETO
	 * @param inUserName NOMBRE DE USUARIO
	 * @param inSW 0 = SOLO VERIFICA OBJETO, 1 = VERFICA OBJETO Y RUTA  
	 * @return
	 */
	public static boolean isGrant(
		java.sql.Connection inConnection,
		String inObject,
		String inPath,
		String inUserName,
		int inSW
	){
		boolean outResult = true;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_IS_GRANT(?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.BOOLEAN);
			stmSelect.setString(2,inObject);
			stmSelect.setString(3,inPath);
			stmSelect.setString(4, inUserName);
			stmSelect.setInt(5,inSW);
			stmSelect.execute();
			outResult = stmSelect.getBoolean(1);
			if(!outResult){
				com.besixplus.sii.objects.Cgg_sec_log tmpObj = new com.besixplus.sii.objects.Cgg_sec_log();
				tmpObj.setCSLOG_CODIGO("KEYGEN");
				tmpObj.setCSLOG_FECHA(new java.util.Date());
				tmpObj.setCSLOG_MENSAJE("Acceso no autorizado. Objeto: "+inObject+ " Ruta: "+inPath);
				tmpObj.setCSLOG_PROCESO(inPath);
				tmpObj.setCSLOG_TIPO(com.besixplus.sii.objects.Cgg_sec_log.Tipo.WARNING.toString());
				tmpObj.setCSLOG_USUARIO(inUserName);
				new com.besixplus.sii.db.Cgg_sec_log(tmpObj).insert(inConnection);
			}
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inTypeObject TIPO DE OBJETOS QUE SE DESEA OBTENER: 0 - INTERFACES VISUALES, 1 - SERVICIOS WEB
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static  ArrayList<HashMap<String,Object>> selectObjectsOnly(
		java.sql.Connection inConnection,
		int inTypeObject
		){
		ArrayList<HashMap<String,Object>> outCgg_sec_objeto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_SELECT_OBJ_ONLY(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, inTypeObject);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_sec_objeto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto;
	}

	/**
	 * OBTIENE LOS OBJETOS AUTORIZADOS PARA UN USUARIO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUsername NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inDesktopObjects OBTENER SOLO OBJETOS CON ACCESO DIRECTO.
	 * @return <code>ArrayList<String></code> COLECCION DE NOMBRES DE OBJETOS.
	 */
	public ArrayList<String> getObjectsFor(Connection inConnection, String inUsername, boolean inDesktopObjects){
		ArrayList<String> outObjects = new ArrayList<String>();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_SELECT_OBJ_FOR(?,?)}");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUsername);
			stmSelect.setBoolean(3, inDesktopObjects);
			stmSelect.execute();
			ResultSet tmpRes = (ResultSet) stmSelect.getObject(1);
			while(tmpRes.next()){
				outObjects.add(tmpRes.getString(1));
				outObjects.add(tmpRes.getString(2));
			}
			tmpRes.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outObjects;
	}

	/**
	 * OBTIENE LAS DEPENDENCIAS DE UN OBJETO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return <code>ArrayList<String></code> COLECCION DE NOMBRES DE OBJETOS.
	 */
	public ArrayList<String> getDepFor(Connection inConnection, String inUserName){
		ArrayList<String> outObjects = new ArrayList<String>();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_SELECT_DEP_OBJ_FOR(?)}");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet tmpRes = (ResultSet) stmSelect.getObject(1);
			while(tmpRes.next()){
				outObjects.add(tmpRes.getString(1));
			}
			tmpRes.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outObjects;
	}

}