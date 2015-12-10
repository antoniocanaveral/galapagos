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
 * CLASE Cgg_jur_adjunto_proceso
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_adjunto_proceso.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_jur_adjunto_proceso implements Serializable{
	private static final long serialVersionUID = 1203561725;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_adjunto_proceso.
	 */
	private com.besixplus.sii.objects.Cgg_jur_adjunto_proceso myCgg_jur_adjunto_proceso = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_proceso.
	 */
	public Cgg_jur_adjunto_proceso(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_proceso.
	 * @param inCgg_jur_adjunto_proceso OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_adjunto_proceso.
	 */
	public Cgg_jur_adjunto_proceso(
			com.besixplus.sii.objects.Cgg_jur_adjunto_proceso inCgg_jur_adjunto_proceso
	){
		this.setCgg_jur_adjunto_proceso(inCgg_jur_adjunto_proceso);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_adjunto_proceso.
	 * @param inCgg_jur_adjunto_proceso OBJETO Cgg_jur_adjunto_proceso.
	 * @return void
	 */
	public void setCgg_jur_adjunto_proceso(com.besixplus.sii.objects.Cgg_jur_adjunto_proceso inCgg_jur_adjunto_proceso){
		this.myCgg_jur_adjunto_proceso = inCgg_jur_adjunto_proceso;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_adjunto_proceso.
	 * @return Cgg_jur_adjunto_proceso OBJETO Cgg_jur_adjunto_proceso.
	 */
	public com.besixplus.sii.objects.Cgg_jur_adjunto_proceso getCgg_jur_adjunto_proceso(){
		return this.myCgg_jur_adjunto_proceso;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_adjunto_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_adjunto_proceso().getCJADP_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_adjunto_proceso().getCJPJU_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_adjunto_proceso().getCJADP_DESCRIPCION());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_jur_adjunto_proceso().getCJHTP_FECHA_REGISTRO().getTime()));
			stmInsert.setString(6, this.getCgg_jur_adjunto_proceso().getCJADP_NOMBRE_ADJUNTO());
			stmInsert.setBytes(7, this.getCgg_jur_adjunto_proceso().getCJADP_ADJUNTO());
			stmInsert.setBoolean(8, this.getCgg_jur_adjunto_proceso().getCJADP_ESTADO());
			stmInsert.setString(9, this.getCgg_jur_adjunto_proceso().getCJADP_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_jur_adjunto_proceso().getCJHTP_CODIGO());
			stmInsert.execute();
			this.getCgg_jur_adjunto_proceso().setCJADP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> outCgg_jur_adjunto_proceso = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_adjunto_proceso tmpCgg_jur_adjunto_proceso = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
				tmpCgg_jur_adjunto_proceso.setCJADP_CODIGO(results.getString(1));
				tmpCgg_jur_adjunto_proceso.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_adjunto_proceso.setCJADP_DESCRIPCION(results.getString(3));
				tmpCgg_jur_adjunto_proceso.setCJHTP_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_jur_adjunto_proceso.setCJADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_jur_adjunto_proceso.setCJADP_ADJUNTO(results.getBytes(6));
				tmpCgg_jur_adjunto_proceso.setCJADP_ESTADO(results.getBoolean(7));
				tmpCgg_jur_adjunto_proceso.setCJHTP_CODIGO(results.getString(8));
				outCgg_jur_adjunto_proceso.add(tmpCgg_jur_adjunto_proceso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_proceso;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> outCgg_jur_adjunto_proceso = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_jur_adjunto_proceso tmpCgg_jur_adjunto_proceso = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
				tmpCgg_jur_adjunto_proceso.setCJADP_CODIGO(results.getString(1));
				tmpCgg_jur_adjunto_proceso.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_adjunto_proceso.setCJADP_DESCRIPCION(results.getString(3));
				tmpCgg_jur_adjunto_proceso.setCJHTP_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_jur_adjunto_proceso.setCJADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_jur_adjunto_proceso.setCJADP_ADJUNTO(results.getBytes(6));
				tmpCgg_jur_adjunto_proceso.setCJADP_ESTADO(results.getBoolean(7));
				tmpCgg_jur_adjunto_proceso.setCJHTP_CODIGO(results.getString(8));
				outCgg_jur_adjunto_proceso.add(tmpCgg_jur_adjunto_proceso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_proceso;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_adjunto_proceso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_adjunto_proceso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_proceso;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_adjunto_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_COUNT() }");
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
	 * @return NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_COUNT(?) }");
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_adjunto_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_adjunto_proceso().getCJADP_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_adjunto_proceso().getCJPJU_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_adjunto_proceso().getCJADP_DESCRIPCION());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_jur_adjunto_proceso().getCJHTP_FECHA_REGISTRO().getTime()));
			stmUpdate.setString(5, this.getCgg_jur_adjunto_proceso().getCJADP_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(6, this.getCgg_jur_adjunto_proceso().getCJADP_ADJUNTO());
			stmUpdate.setBoolean(7, this.getCgg_jur_adjunto_proceso().getCJADP_ESTADO());
			stmUpdate.setString(8, this.getCgg_jur_adjunto_proceso().getCJADP_USUARIO_UPDATE());
			stmUpdate.setString(9, this.getCgg_jur_adjunto_proceso().getCJHTP_CODIGO());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_adjunto_proceso DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_adjunto_proceso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_jur_adjunto_proceso select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_adjunto_proceso().getCJADP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_adjunto_proceso().setCJADP_CODIGO(results.getString(1));
				this.getCgg_jur_adjunto_proceso().setCJPJU_CODIGO(results.getString(2));
				this.getCgg_jur_adjunto_proceso().setCJADP_DESCRIPCION(results.getString(3));
				this.getCgg_jur_adjunto_proceso().setCJHTP_FECHA_REGISTRO(results.getTimestamp(4));
				this.getCgg_jur_adjunto_proceso().setCJADP_NOMBRE_ADJUNTO(results.getString(5));
				this.getCgg_jur_adjunto_proceso().setCJADP_ADJUNTO(results.getBytes(6));
				this.getCgg_jur_adjunto_proceso().setCJADP_ESTADO(results.getBoolean(7));
				this.getCgg_jur_adjunto_proceso().setCJHTP_CODIGO(results.getString(12));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_adjunto_proceso();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_adjunto_proceso DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJADP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJADP_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_historial_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_adjunto_proceso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> selectCGG_JUR_HISTORIAL_PROCESO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> outCgg_jur_adjunto_proceso = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_S_CGG_JUR_HISTORIAL_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_adjunto_proceso().getCJHTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_adjunto_proceso tmpCgg_jur_adjunto_proceso = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
				tmpCgg_jur_adjunto_proceso.setCJADP_CODIGO(results.getString(1));
				tmpCgg_jur_adjunto_proceso.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_adjunto_proceso.setCJADP_DESCRIPCION(results.getString(3));
				tmpCgg_jur_adjunto_proceso.setCJHTP_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_jur_adjunto_proceso.setCJADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_jur_adjunto_proceso.setCJADP_ADJUNTO(results.getBytes(6));
				tmpCgg_jur_adjunto_proceso.setCJADP_ESTADO(results.getBoolean(7));
				tmpCgg_jur_adjunto_proceso.setCJHTP_CODIGO(results.getString(8));
				outCgg_jur_adjunto_proceso.add(tmpCgg_jur_adjunto_proceso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_proceso;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_historial_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_JUR_HISTORIAL_PROCESO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_D_CGG_JUR_HISTORIAL_PROCESO(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJHTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_DS_CGG_JUR_HISTORIAL_PROCESO(?) }");
				stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJHTP_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_adjunto_proceso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> selectCGG_JUR_PROCESO_JUDICIAL(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso> outCgg_jur_adjunto_proceso = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_proceso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_S_CGG_JUR_PROCESO_JUDICIAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_adjunto_proceso().getCJPJU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_adjunto_proceso tmpCgg_jur_adjunto_proceso = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
				tmpCgg_jur_adjunto_proceso.setCJADP_CODIGO(results.getString(1));
				tmpCgg_jur_adjunto_proceso.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_adjunto_proceso.setCJADP_DESCRIPCION(results.getString(3));
				tmpCgg_jur_adjunto_proceso.setCJHTP_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_jur_adjunto_proceso.setCJADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_jur_adjunto_proceso.setCJADP_ADJUNTO(results.getBytes(6));
				tmpCgg_jur_adjunto_proceso.setCJADP_ESTADO(results.getBoolean(7));
				tmpCgg_jur_adjunto_proceso.setCJHTP_CODIGO(results.getString(8));
				outCgg_jur_adjunto_proceso.add(tmpCgg_jur_adjunto_proceso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_proceso;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_proceso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_JUR_PROCESO_JUDICIAL(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_D_CGG_JUR_PROCESO_JUDICIAL(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJPJU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_DS_CGG_JUR_PROCESO_JUDICIAL(?) }");
				stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJPJU_CODIGO());
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
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public String deleteAdjuntoProceso(
			java.sql.Connection inConnection
	){
		String outResult = "true";		
		try{				
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_PROCESO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_proceso().getCJADP_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}

		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.	
	 * @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectAllProceso(
			java.sql.Connection inConnection,
			String inCjpju_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_adjunto_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_S_CGG_JUR_PROCESO_JUDICIAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCjpju_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_adjunto_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.	
	 * @param inCjhtp_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectAllHistorialProceso(
			java.sql.Connection inConnection,
			String inCjhtp_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_adjunto_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_PROCESO_S_CGG_JUR_HISTORIAL_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCjhtp_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_adjunto_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}
}