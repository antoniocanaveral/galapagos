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
 * CLASE Cgg_jur_proceso_judicial
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_proceso_judicial.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_jur_proceso_judicial implements Serializable{
	private static final long serialVersionUID = 970479414;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_proceso_judicial.
	 */
	private com.besixplus.sii.objects.Cgg_jur_proceso_judicial myCgg_jur_proceso_judicial = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_proceso_judicial.
	 */
	public Cgg_jur_proceso_judicial(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_proceso_judicial.
	 * @param inCgg_jur_proceso_judicial OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_proceso_judicial.
	 */
	public Cgg_jur_proceso_judicial(
			com.besixplus.sii.objects.Cgg_jur_proceso_judicial inCgg_jur_proceso_judicial
	){
		this.setCgg_jur_proceso_judicial(inCgg_jur_proceso_judicial);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_proceso_judicial.
	 * @param inCgg_jur_proceso_judicial OBJETO Cgg_jur_proceso_judicial.
	 * @return void
	 */
	public void setCgg_jur_proceso_judicial(com.besixplus.sii.objects.Cgg_jur_proceso_judicial inCgg_jur_proceso_judicial){
		this.myCgg_jur_proceso_judicial = inCgg_jur_proceso_judicial;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_proceso_judicial.
	 * @return Cgg_jur_proceso_judicial OBJETO Cgg_jur_proceso_judicial.
	 */
	public com.besixplus.sii.objects.Cgg_jur_proceso_judicial getCgg_jur_proceso_judicial(){
		return this.myCgg_jur_proceso_judicial;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_INSERT(?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_proceso_judicial().getCJPJU_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_proceso_judicial().getCCTN_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_proceso_judicial().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_jur_proceso_judicial().getCRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_jur_proceso_judicial().getCJPJU_NUMERO());
			stmInsert.setInt(7, this.getCgg_jur_proceso_judicial().getCJPJU_TIPO_PROCESO());
			stmInsert.setInt(8, this.getCgg_jur_proceso_judicial().getCJPJU_TIPO_ADVERSARIO());
			stmInsert.setTimestamp(9, new java.sql.Timestamp(this.getCgg_jur_proceso_judicial().getCJPJU_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(10, new java.sql.Timestamp(this.getCgg_jur_proceso_judicial().getCJPJU_FECHA_FINALIZACION().getTime()));
			stmInsert.setInt(11, this.getCgg_jur_proceso_judicial().getCJPJU_ESTADO_EJECUCION());
			stmInsert.setString(12, this.getCgg_jur_proceso_judicial().getCJPJU_RESPONSABLE());
			stmInsert.setString(13, this.getCgg_jur_proceso_judicial().getCJPJU_OBSERVACION());
			stmInsert.setBoolean(14, this.getCgg_jur_proceso_judicial().getCJPJU_ESTADO());
			stmInsert.setString(15, this.getCgg_jur_proceso_judicial().getCJPJU_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_jur_proceso_judicial().setCJPJU_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> outCgg_jur_proceso_judicial = new ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpCgg_jur_proceso_judicial = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
				tmpCgg_jur_proceso_judicial.setCJPJU_CODIGO(results.getString(1));
				tmpCgg_jur_proceso_judicial.setCCTN_CODIGO(results.getString(2));
				tmpCgg_jur_proceso_judicial.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_proceso_judicial.setCRPER_CODIGO(results.getString(4));				
				tmpCgg_jur_proceso_judicial.setCJPJU_NUMERO(results.getString(5));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_PROCESO(results.getInt(6));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_ADVERSARIO(results.getInt(7));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_FINALIZACION(results.getTimestamp(9));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO_EJECUCION(results.getInt(10));
				tmpCgg_jur_proceso_judicial.setCJPJU_RESPONSABLE(results.getString(11));
				tmpCgg_jur_proceso_judicial.setCJPJU_OBSERVACION(results.getString(12));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO(results.getBoolean(13));
				outCgg_jur_proceso_judicial.add(tmpCgg_jur_proceso_judicial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String, Object>> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_proceso_judicial = new ArrayList<HashMap<String,Object>>();
		try{


			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_proceso_judicial.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_proceso_judicial = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_proceso_judicial.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_COUNT(?) }");
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_proceso_judicial().getCJPJU_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_proceso_judicial().getCCTN_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_proceso_judicial().getCRPJR_CODIGO());
			stmUpdate.setString(4, this.getCgg_jur_proceso_judicial().getCRPER_CODIGO());			
			stmUpdate.setString(5, this.getCgg_jur_proceso_judicial().getCJPJU_NUMERO());
			stmUpdate.setInt(6, this.getCgg_jur_proceso_judicial().getCJPJU_TIPO_PROCESO());
			stmUpdate.setInt(7, this.getCgg_jur_proceso_judicial().getCJPJU_TIPO_ADVERSARIO());
			stmUpdate.setTimestamp(8, new java.sql.Timestamp(this.getCgg_jur_proceso_judicial().getCJPJU_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(9, new java.sql.Timestamp(this.getCgg_jur_proceso_judicial().getCJPJU_FECHA_FINALIZACION().getTime()));
			stmUpdate.setInt(10, this.getCgg_jur_proceso_judicial().getCJPJU_ESTADO_EJECUCION());
			stmUpdate.setString(11, this.getCgg_jur_proceso_judicial().getCJPJU_RESPONSABLE());
			stmUpdate.setString(12, this.getCgg_jur_proceso_judicial().getCJPJU_OBSERVACION());
			stmUpdate.setBoolean(13, this.getCgg_jur_proceso_judicial().getCJPJU_ESTADO());
			stmUpdate.setString(14, this.getCgg_jur_proceso_judicial().getCJPJU_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_proceso_judicial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_jur_proceso_judicial select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_proceso_judicial().getCJPJU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_proceso_judicial().setCJPJU_CODIGO(results.getString(1));
				this.getCgg_jur_proceso_judicial().setCCTN_CODIGO(results.getString(2));
				this.getCgg_jur_proceso_judicial().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_jur_proceso_judicial().setCRPER_CODIGO(results.getString(4));
				this.getCgg_jur_proceso_judicial().setCJPJU_NUMERO(results.getString(5));
				this.getCgg_jur_proceso_judicial().setCJPJU_TIPO_PROCESO(results.getInt(6));
				this.getCgg_jur_proceso_judicial().setCJPJU_TIPO_ADVERSARIO(results.getInt(7));
				this.getCgg_jur_proceso_judicial().setCJPJU_FECHA_INICIO(results.getTimestamp(8));
				this.getCgg_jur_proceso_judicial().setCJPJU_FECHA_FINALIZACION(results.getTimestamp(9));
				this.getCgg_jur_proceso_judicial().setCJPJU_ESTADO_EJECUCION(results.getInt(10));
				this.getCgg_jur_proceso_judicial().setCJPJU_RESPONSABLE(results.getString(11));
				this.getCgg_jur_proceso_judicial().setCJPJU_OBSERVACION(results.getString(12));
				this.getCgg_jur_proceso_judicial().setCJPJU_ESTADO(results.getBoolean(13));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_proceso_judicial();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCJPJU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCJPJU_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_proceso_judicial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> selectCGG_RES_PERSONA_JURIDICA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> outCgg_jur_proceso_judicial = new ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_proceso_judicial().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpCgg_jur_proceso_judicial = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
				tmpCgg_jur_proceso_judicial.setCJPJU_CODIGO(results.getString(1));
				tmpCgg_jur_proceso_judicial.setCCTN_CODIGO(results.getString(2));
				tmpCgg_jur_proceso_judicial.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_proceso_judicial.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_proceso_judicial.setCJPJU_NUMERO(results.getString(5));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_PROCESO(results.getInt(6));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_ADVERSARIO(results.getInt(7));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_FINALIZACION(results.getTimestamp(9));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO_EJECUCION(results.getInt(10));
				tmpCgg_jur_proceso_judicial.setCJPJU_RESPONSABLE(results.getString(11));
				tmpCgg_jur_proceso_judicial.setCJPJU_OBSERVACION(results.getString(12));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO(results.getBoolean(13));
				outCgg_jur_proceso_judicial.add(tmpCgg_jur_proceso_judicial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_PERSONA_JURIDICA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCRPJR_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_proceso_judicial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> outCgg_jur_proceso_judicial = new ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_proceso_judicial().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpCgg_jur_proceso_judicial = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
				tmpCgg_jur_proceso_judicial.setCJPJU_CODIGO(results.getString(1));
				tmpCgg_jur_proceso_judicial.setCCTN_CODIGO(results.getString(2));
				tmpCgg_jur_proceso_judicial.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_proceso_judicial.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_proceso_judicial.setCJPJU_NUMERO(results.getString(5));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_PROCESO(results.getInt(6));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_ADVERSARIO(results.getInt(7));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_FINALIZACION(results.getTimestamp(9));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO_EJECUCION(results.getInt(10));
				tmpCgg_jur_proceso_judicial.setCJPJU_RESPONSABLE(results.getString(11));
				tmpCgg_jur_proceso_judicial.setCJPJU_OBSERVACION(results.getString(12));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO(results.getBoolean(13));
				outCgg_jur_proceso_judicial.add(tmpCgg_jur_proceso_judicial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCRPER_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_proceso_judicial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> selectCGG_CANTON(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> outCgg_jur_proceso_judicial = new ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_proceso_judicial().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpCgg_jur_proceso_judicial = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
				tmpCgg_jur_proceso_judicial.setCJPJU_CODIGO(results.getString(1));
				tmpCgg_jur_proceso_judicial.setCCTN_CODIGO(results.getString(2));
				tmpCgg_jur_proceso_judicial.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_proceso_judicial.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_proceso_judicial.setCJPJU_NUMERO(results.getString(5));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_PROCESO(results.getInt(6));
				tmpCgg_jur_proceso_judicial.setCJPJU_TIPO_ADVERSARIO(results.getInt(7));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_jur_proceso_judicial.setCJPJU_FECHA_FINALIZACION(results.getTimestamp(9));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO_EJECUCION(results.getInt(10));
				tmpCgg_jur_proceso_judicial.setCJPJU_RESPONSABLE(results.getString(11));
				tmpCgg_jur_proceso_judicial.setCJPJU_OBSERVACION(results.getString(12));
				tmpCgg_jur_proceso_judicial.setCJPJU_ESTADO(results.getBoolean(13));
				outCgg_jur_proceso_judicial.add(tmpCgg_jur_proceso_judicial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_CANTON(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_PROCESO_JUDICIAL_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_jur_proceso_judicial().getCCTN_CODIGO());
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
	 * GENERA EL NUMERO DE PROCESO JUDICIAL DE LA TABLA Cgg_jur_proceso_judicial
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return valorProcesoJudicial NUMERO GENERADO PARA CADA PROCESO JUDICIAL
	 * @throws SQLException 
	 */
	public static String numeroProceso(
			java.sql.Connection inConnection
	) throws SQLException{
		String valorProcesoJudicial=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_PROCESO_JUDICIAL() }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);						
		stmSelect.execute();
		valorProcesoJudicial = stmSelect.getString(1);
		stmSelect.close();

		return valorProcesoJudicial;
	}

	/**
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE SEGUN EL USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return PERSONA DE RESPONSABLE DEL PROCESO 
	 * @throws SQLException 
	 */
	public static String responsableProceso(
			java.sql.Connection inConnection,
			String inUserName
	) throws SQLException{
		String valorResponsable=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_RESPONSABLE_PROCESO(?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);	
		stmSelect.setString(2, inUserName);	
		stmSelect.execute();
		valorResponsable = stmSelect.getString(1);
		stmSelect.close();

		return valorResponsable;
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllProceso(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_proceso_judicial = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_DESC_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_proceso_judicial.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_proceso_judicial;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_proceso_judicial.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCountProceso1(
			java.sql.Connection inConnection,
			String inUserName
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_DESC_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
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
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return NUMERO DE REGISTROS.
	 */
	public static int selectCountProceso(
			java.sql.Connection inConnection,
			String inKeyword,
			String inUserName
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCountProceso1(inConnection,inUserName);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_PROCESO_JUDICIAL_DESC_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inUserName);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE SEGUN EL USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return PERSONA DE RESPONSABLE DEL PROCESO 
	 * @throws SQLException 
	 */
	public static String responsableJuridico(
			java.sql.Connection inConnection,
			String inUserName
	) throws SQLException{
		String valorJuridico=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_RESPONSABLE_JURIDICO(?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);	
		stmSelect.setString(2, inUserName);	
		stmSelect.execute();
		valorJuridico = stmSelect.getString(1);
		stmSelect.close();

		return valorJuridico;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_proceso_judicial
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstado(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_HISTORIAL_PROCESO_UPDATE_PROCESO(?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_proceso_judicial().getCJPJU_CODIGO());					
			stmUpdate.setInt(2, this.getCgg_jur_proceso_judicial().getCJPJU_ESTADO_EJECUCION());			
			stmUpdate.setString(3, this.getCgg_jur_proceso_judicial().getCJPJU_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

}