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
* CLASE Cgg_sec_sesion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_sesion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_sesion implements Serializable{
	private static final long serialVersionUID = 990562240;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_sesion.
	*/
	private com.besixplus.sii.objects.Cgg_sec_sesion myCgg_sec_sesion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_sesion.
	*/
	public Cgg_sec_sesion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_sesion.
	* @param inCgg_sec_sesion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_sesion.
	*/
	public Cgg_sec_sesion(
		com.besixplus.sii.objects.Cgg_sec_sesion inCgg_sec_sesion
	){
		this.setCgg_sec_sesion(inCgg_sec_sesion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_sesion.
	* @param inCgg_sec_sesion OBJETO Cgg_sec_sesion.
	* @return void
	*/
	public void setCgg_sec_sesion(com.besixplus.sii.objects.Cgg_sec_sesion inCgg_sec_sesion){
		this.myCgg_sec_sesion = inCgg_sec_sesion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_sesion.
	* @return Cgg_sec_sesion OBJETO Cgg_sec_sesion.
	*/
	public com.besixplus.sii.objects.Cgg_sec_sesion getCgg_sec_sesion(){
		return this.myCgg_sec_sesion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_sesion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_INSERT(?, ?, ?, ?, ?, ?, ?, ?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_sesion().getCSSSN_CODIGO());
			stmInsert.setString(3, this.getCgg_sec_sesion().getCUSU_CODIGO());
			stmInsert.setTimestamp(4, this.getCgg_sec_sesion().getCSSSN_FECHA_INICIO()!=null?new java.sql.Timestamp(this.getCgg_sec_sesion().getCSSSN_FECHA_INICIO().getTime()):null);
			stmInsert.setTimestamp(5, this.getCgg_sec_sesion().getCSSSN_FECHA_FIN()!=null?new java.sql.Timestamp(this.getCgg_sec_sesion().getCSSSN_FECHA_FIN().getTime()):null);
			stmInsert.setString(6, this.getCgg_sec_sesion().getCSSSN_ID());
			stmInsert.setString(7, this.getCgg_sec_sesion().getCSSSN_IP());
			stmInsert.setString(8, this.getCgg_sec_sesion().getCSSSN_ZONA_TIEMPO());
			stmInsert.setBoolean(9, this.getCgg_sec_sesion().getCSSSN_ACTIVO());
			stmInsert.setString(10, this.getCgg_sec_sesion().getCSSSN_CONTEXTO());
			stmInsert.execute();
			this.getCgg_sec_sesion().setCSSSN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_sesion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> outCgg_sec_sesion = new ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_sesion tmpCgg_sec_sesion = new com.besixplus.sii.objects.Cgg_sec_sesion();
				tmpCgg_sec_sesion.setCSSSN_CODIGO(results.getString(1));
				tmpCgg_sec_sesion.setCUSU_CODIGO(results.getString(2));
				tmpCgg_sec_sesion.setCSSSN_FECHA_INICIO(results.getTimestamp(3));
				tmpCgg_sec_sesion.setCSSSN_FECHA_FIN(results.getTimestamp(4));
				tmpCgg_sec_sesion.setCSSSN_ID(results.getString(5));
				tmpCgg_sec_sesion.setCSSSN_IP(results.getString(6));
				tmpCgg_sec_sesion.setCSSSN_ZONA_TIEMPO(results.getString(7));
				tmpCgg_sec_sesion.setCSSSN_ACTIVO(results.getBoolean(8));
				tmpCgg_sec_sesion.setCSSSN_CONTEXTO(results.getString(9));
				outCgg_sec_sesion.add(tmpCgg_sec_sesion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_sesion;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_sesion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectAllActive(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_sec_sesion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_SELECT_ACTIVE() }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_sec_sesion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_sesion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_sesion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> outCgg_sec_sesion = new ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_sec_sesion tmpCgg_sec_sesion = new com.besixplus.sii.objects.Cgg_sec_sesion();
				tmpCgg_sec_sesion.setCSSSN_CODIGO(results.getString(1));
				tmpCgg_sec_sesion.setCUSU_CODIGO(results.getString(2));
				tmpCgg_sec_sesion.setCSSSN_FECHA_INICIO(results.getTimestamp(3));
				tmpCgg_sec_sesion.setCSSSN_FECHA_FIN(results.getTimestamp(4));
				tmpCgg_sec_sesion.setCSSSN_ID(results.getString(5));
				tmpCgg_sec_sesion.setCSSSN_IP(results.getString(6));
				tmpCgg_sec_sesion.setCSSSN_ZONA_TIEMPO(results.getString(7));
				tmpCgg_sec_sesion.setCSSSN_ACTIVO(results.getBoolean(8));
				tmpCgg_sec_sesion.setCSSSN_CONTEXTO(results.getString(9));
				outCgg_sec_sesion.add(tmpCgg_sec_sesion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_sesion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sec_sesion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sec_sesion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SEC_SESION_UPDATE(?,?,?,?,?,?,?,?,?) }");
			stmUpdate.setString(1, this.getCgg_sec_sesion().getCSSSN_CODIGO());
			stmUpdate.setString(2, this.getCgg_sec_sesion().getCUSU_CODIGO());
			stmUpdate.setTimestamp(3, this.getCgg_sec_sesion().getCSSSN_FECHA_INICIO()!=null?new java.sql.Timestamp(this.getCgg_sec_sesion().getCSSSN_FECHA_INICIO().getTime()):null);
			stmUpdate.setTimestamp(4, this.getCgg_sec_sesion().getCSSSN_FECHA_FIN()!=null?new java.sql.Timestamp(this.getCgg_sec_sesion().getCSSSN_FECHA_FIN().getTime()):null);
			stmUpdate.setString(5, this.getCgg_sec_sesion().getCSSSN_ID());
			stmUpdate.setString(6, this.getCgg_sec_sesion().getCSSSN_IP());
			stmUpdate.setString(7, this.getCgg_sec_sesion().getCSSSN_ZONA_TIEMPO());
			stmUpdate.setBoolean(8, this.getCgg_sec_sesion().getCSSSN_ACTIVO());
			stmUpdate.setString(9, this.getCgg_sec_sesion().getCSSSN_CONTEXTO());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_sesion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_sesion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_sesion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_sesion().getCSSSN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_sesion().setCSSSN_CODIGO(results.getString(1));
				this.getCgg_sec_sesion().setCUSU_CODIGO(results.getString(2));
				this.getCgg_sec_sesion().setCSSSN_FECHA_INICIO(results.getTimestamp(3));
				this.getCgg_sec_sesion().setCSSSN_FECHA_FIN(results.getTimestamp(4));
				this.getCgg_sec_sesion().setCSSSN_ID(results.getString(5));
				this.getCgg_sec_sesion().setCSSSN_IP(results.getString(6));
				this.getCgg_sec_sesion().setCSSSN_ZONA_TIEMPO(results.getString(7));
				this.getCgg_sec_sesion().setCSSSN_ACTIVO(results.getBoolean(8));
				this.getCgg_sec_sesion().setCSSSN_CONTEXTO(results.getString(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_sesion();
	}
	
	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_sesion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_sesion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_sesion selectByID(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_SELECT_ID(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_sesion().getCSSSN_ID());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_sesion().setCSSSN_CODIGO(results.getString(1));
				this.getCgg_sec_sesion().setCUSU_CODIGO(results.getString(2));
				this.getCgg_sec_sesion().setCSSSN_FECHA_INICIO(results.getTimestamp(3));
				this.getCgg_sec_sesion().setCSSSN_FECHA_FIN(results.getTimestamp(4));
				this.getCgg_sec_sesion().setCSSSN_ID(results.getString(5));
				this.getCgg_sec_sesion().setCSSSN_IP(results.getString(6));
				this.getCgg_sec_sesion().setCSSSN_ZONA_TIEMPO(results.getString(7));
				this.getCgg_sec_sesion().setCSSSN_ACTIVO(results.getBoolean(8));
				this.getCgg_sec_sesion().setCSSSN_CONTEXTO(results.getString(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_sesion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sec_sesion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String delete(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_SESION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sec_sesion().getCSSSN_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		if(outResult.equals("true")){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_SESION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sec_sesion().getCSSSN_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_sec_sesion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_sesion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion> outCgg_sec_sesion = new ArrayList<com.besixplus.sii.objects.Cgg_sec_sesion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_sesion().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_sesion tmpCgg_sec_sesion = new com.besixplus.sii.objects.Cgg_sec_sesion();
				tmpCgg_sec_sesion.setCSSSN_CODIGO(results.getString(1));
				tmpCgg_sec_sesion.setCUSU_CODIGO(results.getString(2));
				tmpCgg_sec_sesion.setCSSSN_FECHA_INICIO(results.getTimestamp(3));
				tmpCgg_sec_sesion.setCSSSN_FECHA_FIN(results.getTimestamp(4));
				tmpCgg_sec_sesion.setCSSSN_ID(results.getString(5));
				tmpCgg_sec_sesion.setCSSSN_IP(results.getString(6));
				tmpCgg_sec_sesion.setCSSSN_ZONA_TIEMPO(results.getString(7));
				tmpCgg_sec_sesion.setCSSSN_ACTIVO(results.getBoolean(8));
				tmpCgg_sec_sesion.setCSSSN_CONTEXTO(results.getString(9));
				outCgg_sec_sesion.add(tmpCgg_sec_sesion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_sesion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_sec_sesion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_USUARIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_SESION_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_sec_sesion().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_SESION_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_sec_sesion().getCUSU_CODIGO());
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
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DE USUARIO.
	* @param inCsssn_id IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES.
	* @return int NUMERO DE SESIONES.
	*/
	public static int selectCountUserSession(
		java.sql.Connection inConnection,
		String inUserName,
		String inCsssn_id
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_COUNT_AS(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCsssn_id);
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
	 * @param inUserName NOMBRE DE USUARIO.
	 * @return int NUMERO DE SESIONES.
	 */
	public static int selectCountUserSession(
			java.sql.Connection inConnection,
			String inUserName,
			String inCsssn_id,
			String inCsssn_contexto
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_SESION_COUNT_AS(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCsssn_id);
			stmSelect.setString(4, inCsssn_contexto);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
}