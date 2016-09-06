package com.besixplus.sii.db;

import com.bmlaurus.objects.DinardapResidencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
* CLASE Cgg_res_residencia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_residencia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_residencia implements Serializable{
	private static final long serialVersionUID = 569603022;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_residencia.
	*/
	private com.besixplus.sii.objects.Cgg_res_residencia myCgg_res_residencia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_residencia.
	*/
	public Cgg_res_residencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_residencia.
	* @param inCgg_res_residencia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_residencia.
	*/
	public Cgg_res_residencia(
		com.besixplus.sii.objects.Cgg_res_residencia inCgg_res_residencia
	){
		this.setCgg_res_residencia(inCgg_res_residencia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_residencia.
	* @param inCgg_res_residencia OBJETO Cgg_res_residencia.
	* @return void
	*/
	public void setCgg_res_residencia(com.besixplus.sii.objects.Cgg_res_residencia inCgg_res_residencia){
		this.myCgg_res_residencia = inCgg_res_residencia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_residencia.
	* @return Cgg_res_residencia OBJETO Cgg_res_residencia.
	*/
	public com.besixplus.sii.objects.Cgg_res_residencia getCgg_res_residencia(){
		return this.myCgg_res_residencia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_residencia().getCRRSD_CODIGO());
			stmInsert.setString(3, this.getCgg_res_residencia().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_residencia().getCRTST_CODIGO());
			stmInsert.setString(5, this.getCgg_res_residencia().getCRTRA_CODIGO());
			stmInsert.setString(6, this.getCgg_res_residencia().getCGG_CRTRA_CODIGO());
			stmInsert.setInt(7, this.getCgg_res_residencia().getCRRSD_NUMERO());
			stmInsert.setInt(8, this.getCgg_res_residencia().getCRRSD_MODALIDAD());
			stmInsert.setTimestamp(9, this.getCgg_res_residencia().getCRRSD_FECHA_INICIO()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_INICIO().getTime()):null);
			stmInsert.setTimestamp(10, this.getCgg_res_residencia().getCRRSD_FECHA_CADUCIDAD()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_CADUCIDAD().getTime()):null);
			stmInsert.setBoolean(11, this.getCgg_res_residencia().getCRRSD_REVOCADA());
			stmInsert.setTimestamp(12, this.getCgg_res_residencia().getCRRSD_FECHA_REVOCATORIA()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_REVOCATORIA().getTime()):null);
			stmInsert.setString(13, this.getCgg_res_residencia().getCRRSD_MOTIVO_REVOCATORIA());
			stmInsert.setBoolean(14, this.getCgg_res_residencia().getCRRSD_VIGENTE());
			stmInsert.setBoolean(15, this.getCgg_res_residencia().getCRRSD_TRAMITE_PENDIENTE());
			stmInsert.setBoolean(16, this.getCgg_res_residencia().getCRRSD_ESTADO());
			stmInsert.setString(17, this.getCgg_res_residencia().getCRRSD_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_residencia().setCRRSD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> outCgg_res_residencia = new ArrayList<com.besixplus.sii.objects.Cgg_res_residencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_residencia tmpCgg_res_residencia = new com.besixplus.sii.objects.Cgg_res_residencia();
				tmpCgg_res_residencia.setCRRSD_CODIGO(results.getString(1));
				tmpCgg_res_residencia.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_residencia.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_residencia.setCRTRA_CODIGO(results.getString(4));
				tmpCgg_res_residencia.setCGG_CRTRA_CODIGO(results.getString(5));
				tmpCgg_res_residencia.setCRRSD_NUMERO(results.getInt(6));
				tmpCgg_res_residencia.setCRRSD_MODALIDAD(results.getInt(7));
				tmpCgg_res_residencia.setCRRSD_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_res_residencia.setCRRSD_FECHA_CADUCIDAD(results.getTimestamp(9));
				tmpCgg_res_residencia.setCRRSD_REVOCADA(results.getBoolean(10));
				tmpCgg_res_residencia.setCRRSD_FECHA_REVOCATORIA(results.getTimestamp(11));
				tmpCgg_res_residencia.setCRRSD_MOTIVO_REVOCATORIA(results.getString(12));
				tmpCgg_res_residencia.setCRRSD_VIGENTE(results.getBoolean(13));
				tmpCgg_res_residencia.setCRRSD_TRAMITE_PENDIENTE(results.getBoolean(14));
				tmpCgg_res_residencia.setCRRSD_ESTADO(results.getBoolean(15));
				outCgg_res_residencia.add(tmpCgg_res_residencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}


	public static ArrayList<DinardapResidencia> selectConsultaDinardap(Connection inConnection, String numeroIdentificacion){
		ArrayList<DinardapResidencia> outCgg_res_residencia = new ArrayList<>();

		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_SELECT_DINARDAP(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, numeroIdentificacion);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				DinardapResidencia tmpCgg_res_residencia = new DinardapResidencia();
				tmpCgg_res_residencia.setNumeroIdentificacion(results.getString(1));
				tmpCgg_res_residencia.setNombres(results.getString(2));
				tmpCgg_res_residencia.setPrimerApellido(results.getString(3));
				tmpCgg_res_residencia.setSegundoApellido(results.getString(4));
				tmpCgg_res_residencia.setTipoResidencia(results.getString(5));
				tmpCgg_res_residencia.setMotivoResidencia(results.getString(6));
				tmpCgg_res_residencia.setFechaInicioResidencia(results.getDate(7));
				tmpCgg_res_residencia.setFechaFinResidencia(results.getDate(8));
				tmpCgg_res_residencia.setVigente(results.getBoolean(9));
				outCgg_res_residencia.add(tmpCgg_res_residencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}

		return outCgg_res_residencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_residencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> outCgg_res_residencia = new ArrayList<com.besixplus.sii.objects.Cgg_res_residencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_residencia tmpCgg_res_residencia = new com.besixplus.sii.objects.Cgg_res_residencia();
				tmpCgg_res_residencia.setCRRSD_CODIGO(results.getString(1));
				tmpCgg_res_residencia.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_residencia.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_residencia.setCRTRA_CODIGO(results.getString(4));
				tmpCgg_res_residencia.setCGG_CRTRA_CODIGO(results.getString(5));
				tmpCgg_res_residencia.setCRRSD_NUMERO(results.getInt(6));
				tmpCgg_res_residencia.setCRRSD_MODALIDAD(results.getInt(7));
				tmpCgg_res_residencia.setCRRSD_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_res_residencia.setCRRSD_FECHA_CADUCIDAD(results.getTimestamp(9));
				tmpCgg_res_residencia.setCRRSD_REVOCADA(results.getBoolean(10));
				tmpCgg_res_residencia.setCRRSD_FECHA_REVOCATORIA(results.getTimestamp(11));
				tmpCgg_res_residencia.setCRRSD_MOTIVO_REVOCATORIA(results.getString(12));
				tmpCgg_res_residencia.setCRRSD_VIGENTE(results.getBoolean(13));
				tmpCgg_res_residencia.setCRRSD_TRAMITE_PENDIENTE(results.getBoolean(14));
				tmpCgg_res_residencia.setCRRSD_ESTADO(results.getBoolean(15));
				outCgg_res_residencia.add(tmpCgg_res_residencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_residencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_residencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_residencia().getCRRSD_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_residencia().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_residencia().getCRTST_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_residencia().getCRTRA_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_residencia().getCGG_CRTRA_CODIGO());
			stmUpdate.setInt(6, this.getCgg_res_residencia().getCRRSD_NUMERO());
			stmUpdate.setInt(7, this.getCgg_res_residencia().getCRRSD_MODALIDAD());
			stmUpdate.setTimestamp(8, this.getCgg_res_residencia().getCRRSD_FECHA_INICIO()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_INICIO().getTime()):null);
			stmUpdate.setTimestamp(9, this.getCgg_res_residencia().getCRRSD_FECHA_CADUCIDAD()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_CADUCIDAD().getTime()):null);
			stmUpdate.setBoolean(10, this.getCgg_res_residencia().getCRRSD_REVOCADA());
			stmUpdate.setTimestamp(11, this.getCgg_res_residencia().getCRRSD_FECHA_REVOCATORIA()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_REVOCATORIA().getTime()):null);
			stmUpdate.setString(12, this.getCgg_res_residencia().getCRRSD_MOTIVO_REVOCATORIA());
			stmUpdate.setBoolean(13, this.getCgg_res_residencia().getCRRSD_VIGENTE());
			stmUpdate.setBoolean(14, this.getCgg_res_residencia().getCRRSD_TRAMITE_PENDIENTE());
			stmUpdate.setBoolean(15, this.getCgg_res_residencia().getCRRSD_ESTADO());
			stmUpdate.setString(16, this.getCgg_res_residencia().getCRRSD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_residencia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_residencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_residencia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_residencia().getCRRSD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_residencia().setCRRSD_CODIGO(results.getString(1));
				this.getCgg_res_residencia().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_residencia().setCRTST_CODIGO(results.getString(3));
				this.getCgg_res_residencia().setCRTRA_CODIGO(results.getString(4));
				this.getCgg_res_residencia().setCGG_CRTRA_CODIGO(results.getString(5));
				this.getCgg_res_residencia().setCRRSD_NUMERO(results.getInt(6));
				this.getCgg_res_residencia().setCRRSD_MODALIDAD(results.getInt(7));
				this.getCgg_res_residencia().setCRRSD_FECHA_INICIO(results.getTimestamp(8));
				this.getCgg_res_residencia().setCRRSD_FECHA_CADUCIDAD(results.getTimestamp(9));
				this.getCgg_res_residencia().setCRRSD_REVOCADA(results.getBoolean(10));
				this.getCgg_res_residencia().setCRRSD_FECHA_REVOCATORIA(results.getTimestamp(11));
				this.getCgg_res_residencia().setCRRSD_MOTIVO_REVOCATORIA(results.getString(12));
				this.getCgg_res_residencia().setCRRSD_VIGENTE(results.getBoolean(13));
				this.getCgg_res_residencia().setCRRSD_TRAMITE_PENDIENTE(results.getBoolean(14));
				this.getCgg_res_residencia().setCRRSD_ESTADO(results.getBoolean(15));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_residencia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_residencia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_residencia().getCRRSD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_residencia().getCRRSD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_residencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_residencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> selectCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> outCgg_res_residencia = new ArrayList<com.besixplus.sii.objects.Cgg_res_residencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_S_CGG_RES_TRAMITE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_residencia().getCRTRA_CODIGO());
			stmSelect.setString(3,this.getCgg_res_residencia().getCGG_CRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_residencia tmpCgg_res_residencia = new com.besixplus.sii.objects.Cgg_res_residencia();
				tmpCgg_res_residencia.setCRRSD_CODIGO(results.getString(1));
				tmpCgg_res_residencia.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_residencia.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_residencia.setCRTRA_CODIGO(results.getString(4));
				tmpCgg_res_residencia.setCGG_CRTRA_CODIGO(results.getString(5));
				tmpCgg_res_residencia.setCRRSD_NUMERO(results.getInt(6));
				tmpCgg_res_residencia.setCRRSD_MODALIDAD(results.getInt(7));
				tmpCgg_res_residencia.setCRRSD_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_res_residencia.setCRRSD_FECHA_CADUCIDAD(results.getTimestamp(9));
				tmpCgg_res_residencia.setCRRSD_REVOCADA(results.getBoolean(10));
				tmpCgg_res_residencia.setCRRSD_FECHA_REVOCATORIA(results.getTimestamp(11));
				tmpCgg_res_residencia.setCRRSD_MOTIVO_REVOCATORIA(results.getString(12));
				tmpCgg_res_residencia.setCRRSD_VIGENTE(results.getBoolean(13));
				tmpCgg_res_residencia.setCRRSD_TRAMITE_PENDIENTE(results.getBoolean(14));
				tmpCgg_res_residencia.setCRRSD_ESTADO(results.getBoolean(15));
				outCgg_res_residencia.add(tmpCgg_res_residencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_residencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_D_CGG_RES_TRAMITE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_residencia().getCRTRA_CODIGO());
			stmDelete.setString(2, this.getCgg_res_residencia().getCGG_CRTRA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_DS_CGG_RES_TRAMITE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_residencia().getCRTRA_CODIGO());
				stmDelete.setString(2, this.getCgg_res_residencia().getCGG_CRTRA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_residencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_residencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> outCgg_res_residencia = new ArrayList<com.besixplus.sii.objects.Cgg_res_residencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_residencia().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_residencia tmpCgg_res_residencia = new com.besixplus.sii.objects.Cgg_res_residencia();
				tmpCgg_res_residencia.setCRRSD_CODIGO(results.getString(1));
				tmpCgg_res_residencia.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_residencia.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_residencia.setCRTRA_CODIGO(results.getString(4));
				tmpCgg_res_residencia.setCGG_CRTRA_CODIGO(results.getString(5));
				tmpCgg_res_residencia.setCRRSD_NUMERO(results.getInt(6));
				tmpCgg_res_residencia.setCRRSD_MODALIDAD(results.getInt(7));
				tmpCgg_res_residencia.setCRRSD_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_res_residencia.setCRRSD_FECHA_CADUCIDAD(results.getTimestamp(9));
				tmpCgg_res_residencia.setCRRSD_REVOCADA(results.getBoolean(10));
				tmpCgg_res_residencia.setCRRSD_FECHA_REVOCATORIA(results.getTimestamp(11));
				tmpCgg_res_residencia.setCRRSD_MOTIVO_REVOCATORIA(results.getString(12));
				tmpCgg_res_residencia.setCRRSD_VIGENTE(results.getBoolean(13));
				tmpCgg_res_residencia.setCRRSD_TRAMITE_PENDIENTE(results.getBoolean(14));
				tmpCgg_res_residencia.setCRRSD_ESTADO(results.getBoolean(15));
				outCgg_res_residencia.add(tmpCgg_res_residencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_residencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_residencia().getCRTST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_residencia().getCRTST_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_residencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_residencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> outCgg_res_residencia = new ArrayList<com.besixplus.sii.objects.Cgg_res_residencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_residencia().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_residencia tmpCgg_res_residencia = new com.besixplus.sii.objects.Cgg_res_residencia();
				tmpCgg_res_residencia.setCRRSD_CODIGO(results.getString(1));
				tmpCgg_res_residencia.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_residencia.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_residencia.setCRTRA_CODIGO(results.getString(4));
				tmpCgg_res_residencia.setCGG_CRTRA_CODIGO(results.getString(5));
				tmpCgg_res_residencia.setCRRSD_NUMERO(results.getInt(6));
				tmpCgg_res_residencia.setCRRSD_MODALIDAD(results.getInt(7));
				tmpCgg_res_residencia.setCRRSD_FECHA_INICIO(results.getTimestamp(8));
				tmpCgg_res_residencia.setCRRSD_FECHA_CADUCIDAD(results.getTimestamp(9));
				tmpCgg_res_residencia.setCRRSD_REVOCADA(results.getBoolean(10));
				tmpCgg_res_residencia.setCRRSD_FECHA_REVOCATORIA(results.getTimestamp(11));
				tmpCgg_res_residencia.setCRRSD_MOTIVO_REVOCATORIA(results.getString(12));
				tmpCgg_res_residencia.setCRRSD_VIGENTE(results.getBoolean(13));
				tmpCgg_res_residencia.setCRRSD_TRAMITE_PENDIENTE(results.getBoolean(14));
				tmpCgg_res_residencia.setCRRSD_ESTADO(results.getBoolean(15));
				outCgg_res_residencia.add(tmpCgg_res_residencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_residencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_residencia().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESIDENCIA_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_residencia().getCRPER_CODIGO());
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
	/* ACTUALIZAR ESTADO DE LA TABLA RESIDENCIA 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoResidencia(
			java.sql.Connection inConnection,
			String inCrmov_codigo
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call SII.F_CGG_RES_RESIDENCIA_CONTROL(?,?,?) }");
			stmUpdate.setString(1, inCrmov_codigo);
			stmUpdate.setString(2, this.getCgg_res_residencia().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_residencia().getCRRSD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* GENERA LA RESIDENCIA DE UN TRAMITE
	* @param inConnection CONEXION A LA BASE DE DATOS
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES
	* @param inCrtra_codigo CODIGO DE REGISTRO DE TRAMITE DE RESIDENCIA
	* @return <code>true</code> SI LA RESIDENCIA HA SIDO GENERADA, CASO CONTRARIO EL MENSAJE DE ERROR
	*/
	public static String generarResidencia(
		java.sql.Connection inConnection,
		String inUserName,
		String inCrtra_codigo
	){
		String outRes = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_RESIDENCIA_GENERAR(?,?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCrtra_codigo);
			stmSelect.execute();
			outRes = stmSelect.getString(1);
			outRes = outRes.toLowerCase();
			stmSelect.close();
		}catch(SQLException e){
			outRes = e.getMessage();
		}
		return outRes;
	}
	
	/**
	 * OBTIENE EL NUMERO DE REGISTROS DE RESIDENTES DE TIPO TRANSEUNTE.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return NUMERO DE REGISTROS.
	 */
	public static BigDecimal selectTranseunteCount(
			java.sql.Connection inConnection,
			String inKeyword
		){
		BigDecimal outCount=new BigDecimal(0);			
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_RESIDENCIA_TRANSEUNTE_COUNT(?) }");
				stmSelect.registerOutParameter(1, Types.NUMERIC);
				stmSelect.setString(2, inKeyword);
				stmSelect.execute();
				outCount = stmSelect.getBigDecimal(1);
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCount;
		}
	
	/**
	 * DEVUELVE UNA COLECCION DE DATOS CON INFORMACION DE LOS RESIDENTES TRANSEUNTES CON SU TRAMITE.
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO DE LA CONSULTA.
	 * @param inLimit TOTAL DE REGISTROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO. 
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return COLECCION DE DATOS CON INFORMACION.
	 */
	public static ArrayList<HashMap<String,Object>> selectTranseunteDirect(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
		){
			ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESIDENCIA_TRANSEUNTE(?,?,?,?,?) }");
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
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_residencia.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_residencia;
		}
	
	/**
	* VERIFICA QUE EXISTA UN TRAMITE DE TRANSEUNTE AUTORIZADO PARA EL USUARIO ACTUAL.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserNameATC CODIGO DE USUARIO DE CONSULTA DESDE ATENCION AL CLIENTE.
	* @return String NUMERO DE REGISTROS.
	*/
	public static  ArrayList<HashMap<String,Object>> selectResidenciaTranseunteTramite(
		java.sql.Connection inConnection,
		String inUserNameATC
	){
		
		ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_RES_RESIDENCIA_TRANSEUNTE_USUARIO_ATC(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserNameATC);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_residencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}
	
	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String updateFechaInicio(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call SII.F_CGG_RES_RESIDENCIA_UPDATE_FECHA_INICIO(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_residencia().getCRRSD_CODIGO());
			stmUpdate.setTimestamp(2, this.getCgg_res_residencia().getCRRSD_FECHA_INICIO()!=null?new java.sql.Timestamp(this.getCgg_res_residencia().getCRRSD_FECHA_INICIO().getTime()):null);
			stmUpdate.setBoolean(3, this.getCgg_res_residencia().getCRRSD_ESTADO());
			stmUpdate.setString(4, this.getCgg_res_residencia().getCRRSD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* GENERA LA RESIDENCIA DE UN TRAMITE
	* @param inConnection CONEXION A LA BASE DE DATOS
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES
	* @param inCrtra_codigo CODIGO DE REGISTRO DE TRAMITE DE RESIDENCIA
	* @return <code>true</code> SI LA RESIDENCIA HA SIDO GENERADA, CASO CONTRARIO EL MENSAJE DE ERROR
	*/
	public String selectExportable(
		java.sql.Connection inConnection,
		int inTipoResidencia
	){
		String outRes = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{  ? = call sii.F_CGG_RES_RESIDENCIA_EXPORTABLE(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setInt(2, inTipoResidencia);
			stmSelect.execute();
			outRes = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outRes = null;			
		}
		return outRes;
	}
	
	
}