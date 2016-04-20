package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_web_agencia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_web_agencia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_web_agencia implements Serializable{
	private static final long serialVersionUID = 1686241;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_web_agencia.
	*/
	private com.besixplus.sii.objects.Cgg_web_agencia myCgg_web_agencia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_agencia.
	*/
	public Cgg_web_agencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_agencia.
	* @param inCgg_web_agencia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_web_agencia.
	*/
	public Cgg_web_agencia(
		com.besixplus.sii.objects.Cgg_web_agencia inCgg_web_agencia
	){
		this.setCgg_web_agencia(inCgg_web_agencia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_web_agencia.
	* @param inCgg_web_agencia OBJETO Cgg_web_agencia.
	* @return void
	*/
	public void setCgg_web_agencia(com.besixplus.sii.objects.Cgg_web_agencia inCgg_web_agencia){
		this.myCgg_web_agencia = inCgg_web_agencia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_web_agencia.
	* @return Cgg_web_agencia OBJETO Cgg_web_agencia.
	*/
	public com.besixplus.sii.objects.Cgg_web_agencia getCgg_web_agencia(){
		return this.myCgg_web_agencia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_web_agencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_web_agencia().getCWAGE_CODIGO());
			stmInsert.setString(3, this.getCgg_web_agencia().getCWMOD_CODIGO());
			stmInsert.setString(4, this.getCgg_web_agencia().getCWAGE_NOMBRE());
			stmInsert.setString(5, this.getCgg_web_agencia().getCWAGE_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_web_agencia().getCWAGE_ENCARGADO());
			stmInsert.setBoolean(7, this.getCgg_web_agencia().getCWAGE_ESTADO());
			stmInsert.setString(8, this.getCgg_web_agencia().getCWAGE_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_web_agencia().setCWAGE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_agencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> outCgg_web_agencia = new ArrayList<com.besixplus.sii.objects.Cgg_web_agencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_web_agencia tmpCgg_web_agencia = new com.besixplus.sii.objects.Cgg_web_agencia();
				tmpCgg_web_agencia.setCWAGE_CODIGO(results.getString(1));
				tmpCgg_web_agencia.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_web_agencia.setCWAGE_NOMBRE(results.getString(3));
				tmpCgg_web_agencia.setCWAGE_DESCRIPCION(results.getString(4));
				tmpCgg_web_agencia.setCWAGE_ENCARGADO(results.getString(5));
				tmpCgg_web_agencia.setCWAGE_ESTADO(results.getBoolean(6));
				outCgg_web_agencia.add(tmpCgg_web_agencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_agencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_agencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> outCgg_web_agencia = new ArrayList<com.besixplus.sii.objects.Cgg_web_agencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_SELECT(?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_web_agencia tmpCgg_web_agencia = new com.besixplus.sii.objects.Cgg_web_agencia();
				tmpCgg_web_agencia.setCWAGE_CODIGO(results.getString(1));
				tmpCgg_web_agencia.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_web_agencia.setCWAGE_NOMBRE(results.getString(3));
				tmpCgg_web_agencia.setCWAGE_DESCRIPCION(results.getString(4));
				tmpCgg_web_agencia.setCWAGE_ENCARGADO(results.getString(5));
				tmpCgg_web_agencia.setCWAGE_ESTADO(results.getBoolean(6));
				outCgg_web_agencia.add(tmpCgg_web_agencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_agencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_agencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_web_agencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_SELECT(?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_web_agencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_agencia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_web_agencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_COUNT() }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
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
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_web_agencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_WEB_AGENCIA_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_web_agencia().getCWAGE_CODIGO());
			stmUpdate.setString(2, this.getCgg_web_agencia().getCWMOD_CODIGO());
			stmUpdate.setString(3, this.getCgg_web_agencia().getCWAGE_NOMBRE());
			stmUpdate.setString(4, this.getCgg_web_agencia().getCWAGE_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_web_agencia().getCWAGE_ENCARGADO());
			stmUpdate.setBoolean(6, this.getCgg_web_agencia().getCWAGE_ESTADO());
			stmUpdate.setString(7, this.getCgg_web_agencia().getCWAGE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_web_agencia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_web_agencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_web_agencia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_web_agencia().getCWAGE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_web_agencia().setCWAGE_CODIGO(results.getString(1));
				this.getCgg_web_agencia().setCWMOD_CODIGO(results.getString(2));
				this.getCgg_web_agencia().setCWAGE_NOMBRE(results.getString(3));
				this.getCgg_web_agencia().setCWAGE_DESCRIPCION(results.getString(4));
				this.getCgg_web_agencia().setCWAGE_ENCARGADO(results.getString(5));
				this.getCgg_web_agencia().setCWAGE_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_web_agencia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_web_agencia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_AGENCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_web_agencia().getCWAGE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_AGENCIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_web_agencia().getCWAGE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_web_agencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_web_modulo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_web_agencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> selectCGG_WEB_MODULO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_agencia> outCgg_web_agencia = new ArrayList<com.besixplus.sii.objects.Cgg_web_agencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_S_CGG_WEB_MODULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_web_agencia().getCWMOD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_web_agencia tmpCgg_web_agencia = new com.besixplus.sii.objects.Cgg_web_agencia();
				tmpCgg_web_agencia.setCWAGE_CODIGO(results.getString(1));
				tmpCgg_web_agencia.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_web_agencia.setCWAGE_NOMBRE(results.getString(3));
				tmpCgg_web_agencia.setCWAGE_DESCRIPCION(results.getString(4));
				tmpCgg_web_agencia.setCWAGE_ENCARGADO(results.getString(5));
				tmpCgg_web_agencia.setCWAGE_ESTADO(results.getBoolean(6));
				outCgg_web_agencia.add(tmpCgg_web_agencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_agencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_web_agencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_web_modulo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_WEB_MODULO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_AGENCIA_D_CGG_WEB_MODULO(?) }");
			stmDelete.setString(1, this.getCgg_web_agencia().getCWMOD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_AGENCIA_DS_CGG_WEB_MODULO(?) }");
				stmDelete.setString(1, this.getCgg_web_agencia().getCWMOD_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_agencia_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCwage_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA AGENCIA 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_agencia_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectContactosByAgencia(
			java.sql.Connection inConnection,
			String inCwage_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_agencia_contacto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_AGENCIA_CONTACTO_BYAGENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCwage_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_agencia_contacto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_agencia_contacto;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_agencia_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO DE WEB MODULO.
	 * @param inCwage_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA AGENCIA 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_agencia_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAgenciasCGG_WEB_MODULO(
			java.sql.Connection inConnection,
			String inCwmod_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_agencia_contacto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_AGENCIA_S_CGG_WEB_MODULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCwmod_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_agencia_contacto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_agencia_contacto;
	}
}