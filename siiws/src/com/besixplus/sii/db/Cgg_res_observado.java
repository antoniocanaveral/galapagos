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
* CLASE Cgg_res_observado
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_observado.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_observado implements Serializable{
	private static final long serialVersionUID = 1889913855;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_observado.
	*/
	private com.besixplus.sii.objects.Cgg_res_observado myCgg_res_observado = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_observado.
	*/
	public Cgg_res_observado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_observado.
	* @param inCgg_res_observado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_observado.
	*/
	public Cgg_res_observado(
		com.besixplus.sii.objects.Cgg_res_observado inCgg_res_observado
	){
		this.setCgg_res_observado(inCgg_res_observado);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_observado.
	* @param inCgg_res_observado OBJETO Cgg_res_observado.
	* @return void
	*/
	public void setCgg_res_observado(com.besixplus.sii.objects.Cgg_res_observado inCgg_res_observado){
		this.myCgg_res_observado = inCgg_res_observado;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_observado.
	* @return Cgg_res_observado OBJETO Cgg_res_observado.
	*/
	public com.besixplus.sii.objects.Cgg_res_observado getCgg_res_observado(){
		return this.myCgg_res_observado;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_observado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_INSERT(?, ?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_observado().getCROBS_CODIGO());
			stmInsert.setString(3, this.getCgg_res_observado().getCRPER_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_observado().getCROBS_FECHA_OBSERVACION().getTime()));
			stmInsert.setString(5, this.getCgg_res_observado().getCROBS_DESCRIPCION());
			stmInsert.setInt(6, this.getCgg_res_observado().getCROBS_RESUELTO());
			stmInsert.setTimestamp(7, this.getCgg_res_observado().getCROBS_FECHA_RESUELTO()==null?null:new java.sql.Timestamp(this.getCgg_res_observado().getCROBS_FECHA_RESUELTO().getTime()));
			stmInsert.setBoolean(8, this.getCgg_res_observado().getCROBS_ESTADO());
			stmInsert.setString(9, this.getCgg_res_observado().getCROBS_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_observado().getCROBS_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_observado().setCROBS_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_observado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_observado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_observado> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_observado> outCgg_res_observado = new ArrayList<com.besixplus.sii.objects.Cgg_res_observado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_observado tmpCgg_res_observado = new com.besixplus.sii.objects.Cgg_res_observado();
				tmpCgg_res_observado.setCROBS_CODIGO(results.getString(1));
				tmpCgg_res_observado.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_observado.setCROBS_FECHA_OBSERVACION(results.getTimestamp(3));
				tmpCgg_res_observado.setCROBS_DESCRIPCION(results.getString(4));
				tmpCgg_res_observado.setCROBS_RESUELTO(results.getInt(5));
				tmpCgg_res_observado.setCROBS_FECHA_RESUELTO(results.getTimestamp(6));
				tmpCgg_res_observado.setCROBS_ESTADO(results.getBoolean(7));
				outCgg_res_observado.add(tmpCgg_res_observado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_observado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_observado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_observado> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_observado> outCgg_res_observado = new ArrayList<com.besixplus.sii.objects.Cgg_res_observado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_observado tmpCgg_res_observado = new com.besixplus.sii.objects.Cgg_res_observado();
				tmpCgg_res_observado.setCROBS_CODIGO(results.getString(1));
				tmpCgg_res_observado.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_observado.setCROBS_FECHA_OBSERVACION(results.getTimestamp(3));
				tmpCgg_res_observado.setCROBS_DESCRIPCION(results.getString(4));
				tmpCgg_res_observado.setCROBS_RESUELTO(results.getInt(5));
				tmpCgg_res_observado.setCROBS_FECHA_RESUELTO(results.getTimestamp(6));
				tmpCgg_res_observado.setCROBS_ESTADO(results.getBoolean(7));
				outCgg_res_observado.add(tmpCgg_res_observado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_observado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_observado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_observado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_observado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_observado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_observado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_OBSERVADO_UPDATE(?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_observado().getCROBS_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_observado().getCRPER_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_res_observado().getCROBS_FECHA_OBSERVACION().getTime()));
			stmUpdate.setString(4, this.getCgg_res_observado().getCROBS_DESCRIPCION());
			stmUpdate.setInt(5, this.getCgg_res_observado().getCROBS_RESUELTO());
			//stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_res_observado().getCROBS_FECHA_RESUELTO().getTime()));
			stmUpdate.setTimestamp(6, this.getCgg_res_observado().getCROBS_FECHA_RESUELTO()==null?null:new java.sql.Timestamp(this.getCgg_res_observado().getCROBS_FECHA_RESUELTO().getTime()));
			stmUpdate.setBoolean(7, this.getCgg_res_observado().getCROBS_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_observado().getCROBS_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_observado DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_observado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_observado select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_observado().getCROBS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_observado().setCROBS_CODIGO(results.getString(1));
				this.getCgg_res_observado().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_observado().setCROBS_FECHA_OBSERVACION(results.getTimestamp(3));
				this.getCgg_res_observado().setCROBS_DESCRIPCION(results.getString(4));
				this.getCgg_res_observado().setCROBS_RESUELTO(results.getInt(5));
				this.getCgg_res_observado().setCROBS_FECHA_RESUELTO(results.getTimestamp(6));
				this.getCgg_res_observado().setCROBS_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_observado();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_observado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OBSERVADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_observado().getCROBS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OBSERVADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_observado().getCROBS_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_observado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_observado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_observado> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_observado> outCgg_res_observado = new ArrayList<com.besixplus.sii.objects.Cgg_res_observado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_observado().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_observado tmpCgg_res_observado = new com.besixplus.sii.objects.Cgg_res_observado();
				tmpCgg_res_observado.setCROBS_CODIGO(results.getString(1));
				tmpCgg_res_observado.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_observado.setCROBS_FECHA_OBSERVACION(results.getTimestamp(3));
				tmpCgg_res_observado.setCROBS_DESCRIPCION(results.getString(4));
				tmpCgg_res_observado.setCROBS_RESUELTO(results.getInt(5));
				tmpCgg_res_observado.setCROBS_FECHA_RESUELTO(results.getTimestamp(6));
				tmpCgg_res_observado.setCROBS_ESTADO(results.getBoolean(7));
				outCgg_res_observado.add(tmpCgg_res_observado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_observado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OBSERVADO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_observado().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OBSERVADO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_observado().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_observado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_observado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>>  selectCGG_RES_PERSONADirect(
		String inCrper_codigo,
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_observado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_observado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado;
	}
	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_observado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_observado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectCGG_RES_PERSONADirect(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_observado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OBSERVADO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_observado().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_observado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado;
	}

}