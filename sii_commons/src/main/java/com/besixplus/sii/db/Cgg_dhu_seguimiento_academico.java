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
* CLASE Cgg_dhu_seguimiento_academico
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_seguimiento_academico.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_seguimiento_academico implements Serializable{
	private static final long serialVersionUID = 607090401;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico myCgg_dhu_seguimiento_academico = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_academico.
	*/
	public Cgg_dhu_seguimiento_academico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_academico.
	* @param inCgg_dhu_seguimiento_academico OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_seguimiento_academico.
	*/
	public Cgg_dhu_seguimiento_academico(
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico inCgg_dhu_seguimiento_academico
	){
		this.setCgg_dhu_seguimiento_academico(inCgg_dhu_seguimiento_academico);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_seguimiento_academico.
	* @param inCgg_dhu_seguimiento_academico OBJETO Cgg_dhu_seguimiento_academico.
	* @return void
	*/
	public void setCgg_dhu_seguimiento_academico(com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico inCgg_dhu_seguimiento_academico){
		this.myCgg_dhu_seguimiento_academico = inCgg_dhu_seguimiento_academico;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_seguimiento_academico.
	* @return Cgg_dhu_seguimiento_academico OBJETO Cgg_dhu_seguimiento_academico.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico getCgg_dhu_seguimiento_academico(){
		return this.myCgg_dhu_seguimiento_academico;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_INSERT(?, ?, ?::smallint, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_seguimiento_academico().getCDBEC_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_seguimiento_academico().getCDACD_CODIGO());
			stmInsert.setInt(4, this.getCgg_dhu_seguimiento_academico().getCDACD_NUMERO_CICLO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_academico().getCDACD_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_academico().getCDACD_FECHA_FIN().getTime()));
			stmInsert.setString(7, this.getCgg_dhu_seguimiento_academico().getCDACD_OBSERVACION());
			stmInsert.setInt(8, this.getCgg_dhu_seguimiento_academico().getCDACD_ESTADO_APROBACION());
			stmInsert.setBoolean(9, this.getCgg_dhu_seguimiento_academico().getCDACD_ESTADO());
			stmInsert.setString(10, this.getCgg_dhu_seguimiento_academico().getCDACD_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_dhu_seguimiento_academico().getCDACD_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_seguimiento_academico().setCDACD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> outCgg_dhu_seguimiento_academico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico tmpCgg_dhu_seguimiento_academico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
				tmpCgg_dhu_seguimiento_academico.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_academico.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_academico.setCDACD_NUMERO_CICLO(results.getInt(3));
				tmpCgg_dhu_seguimiento_academico.setCDACD_FECHA_INICIO(results.getTimestamp(4));
				tmpCgg_dhu_seguimiento_academico.setCDACD_FECHA_FIN(results.getTimestamp(5));
				tmpCgg_dhu_seguimiento_academico.setCDACD_OBSERVACION(results.getString(6));
				tmpCgg_dhu_seguimiento_academico.setCDACD_ESTADO_APROBACION(results.getInt(7));
				tmpCgg_dhu_seguimiento_academico.setCDACD_ESTADO(results.getBoolean(8));
				outCgg_dhu_seguimiento_academico.add(tmpCgg_dhu_seguimiento_academico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_academico;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> outCgg_dhu_seguimiento_academico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico tmpCgg_dhu_seguimiento_academico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
				tmpCgg_dhu_seguimiento_academico.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_academico.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_academico.setCDACD_NUMERO_CICLO(results.getInt(3));
				tmpCgg_dhu_seguimiento_academico.setCDACD_FECHA_INICIO(results.getTimestamp(4));
				tmpCgg_dhu_seguimiento_academico.setCDACD_FECHA_FIN(results.getTimestamp(5));
				tmpCgg_dhu_seguimiento_academico.setCDACD_OBSERVACION(results.getString(6));
				tmpCgg_dhu_seguimiento_academico.setCDACD_ESTADO_APROBACION(results.getInt(7));
				tmpCgg_dhu_seguimiento_academico.setCDACD_ESTADO(results.getBoolean(8));
				outCgg_dhu_seguimiento_academico.add(tmpCgg_dhu_seguimiento_academico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_academico;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_UPDATE(?, ?, ?::smallint, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_seguimiento_academico().getCDBEC_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_seguimiento_academico().getCDACD_CODIGO());
			stmUpdate.setInt(3, this.getCgg_dhu_seguimiento_academico().getCDACD_NUMERO_CICLO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_academico().getCDACD_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_academico().getCDACD_FECHA_FIN().getTime()));
			stmUpdate.setString(6, this.getCgg_dhu_seguimiento_academico().getCDACD_OBSERVACION());
			stmUpdate.setInt(7, this.getCgg_dhu_seguimiento_academico().getCDACD_ESTADO_APROBACION());
			stmUpdate.setBoolean(8, this.getCgg_dhu_seguimiento_academico().getCDACD_ESTADO());
			stmUpdate.setString(9, this.getCgg_dhu_seguimiento_academico().getCDACD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_academico DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_academico().getCDACD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_seguimiento_academico().setCDBEC_CODIGO(results.getString(1));
				this.getCgg_dhu_seguimiento_academico().setCDACD_CODIGO(results.getString(2));
				this.getCgg_dhu_seguimiento_academico().setCDACD_NUMERO_CICLO(results.getInt(3));
				this.getCgg_dhu_seguimiento_academico().setCDACD_FECHA_INICIO(results.getTimestamp(4));
				this.getCgg_dhu_seguimiento_academico().setCDACD_FECHA_FIN(results.getTimestamp(5));
				this.getCgg_dhu_seguimiento_academico().setCDACD_OBSERVACION(results.getString(6));
				this.getCgg_dhu_seguimiento_academico().setCDACD_ESTADO_APROBACION(results.getInt(7));
				this.getCgg_dhu_seguimiento_academico().setCDACD_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_seguimiento_academico();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_academico DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_academico().getCDACD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_academico().getCDACD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> selectCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> outCgg_dhu_seguimiento_academico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_S_CGG_DHU_BECA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_academico().getCDBEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico tmpCgg_dhu_seguimiento_academico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
				tmpCgg_dhu_seguimiento_academico.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_academico.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_academico.setCDACD_NUMERO_CICLO(results.getInt(3));
				tmpCgg_dhu_seguimiento_academico.setCDACD_FECHA_INICIO(results.getTimestamp(4));
				tmpCgg_dhu_seguimiento_academico.setCDACD_FECHA_FIN(results.getTimestamp(5));
				tmpCgg_dhu_seguimiento_academico.setCDACD_OBSERVACION(results.getString(6));
				tmpCgg_dhu_seguimiento_academico.setCDACD_ESTADO_APROBACION(results.getInt(7));
				tmpCgg_dhu_seguimiento_academico.setCDACD_ESTADO(results.getBoolean(8));
				outCgg_dhu_seguimiento_academico.add(tmpCgg_dhu_seguimiento_academico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_academico;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_D_CGG_DHU_BECA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_academico().getCDBEC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_DS_CGG_DHU_BECA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_academico().getCDBEC_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectBecaSeguimiento(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_beca_seguimiento_academico_select(?,?,?,?,?,?) }");
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
				outCgg_dhu_beca_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_seguimiento;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectBecaSeguimientoCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_beca_seguimiento_academico_select_count(?) }");
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
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectPersonaBecaSeguimiento(
		java.sql.Connection inConnection,
		String inCrper_num_doc_identific
		
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento_beca = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_beca_persona_seguimiento(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCrper_num_doc_identific);
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_seguimiento_beca.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_beca;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllSeguimiento(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_seguimiento_academico_select(?,?,?,?,?,?) }");
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
				outCgg_dhu_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_SADJUNTO QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param in_Cdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA.
	* @param in_Cdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCertificadoAdjunto(
		java.sql.Connection inConnection,
		String in_Cdbec_codigo,
		String in_Cdacd_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_sadjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_certificado_beca(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,in_Cdbec_codigo);
			stmSelect.setString(3,in_Cdacd_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_sadjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}	
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_curso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoAprobacion(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.f_cgg_dhu_seguimiento_academico_estado_update( ?,?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_seguimiento_academico().getCDACD_CODIGO());
			stmUpdate.setInt(2, this.getCgg_dhu_seguimiento_academico().getCDACD_ESTADO_APROBACION());		
			stmUpdate.setString(3, this.getCgg_dhu_seguimiento_academico().getCDACD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param in_cdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectSeguimientoCiclo(
		java.sql.Connection inConnection,
		String in_cdbec_codigo
		
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento_beca = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_numero_ciclo(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,in_cdbec_codigo);
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_seguimiento_beca.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_beca;
	}

}