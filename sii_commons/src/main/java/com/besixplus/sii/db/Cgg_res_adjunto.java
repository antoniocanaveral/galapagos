package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * CLASE Cgg_res_adjunto
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_adjunto.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_adjunto implements Serializable{
	private static final long serialVersionUID = 1779826068;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_adjunto.
	 */
	private com.besixplus.sii.objects.Cgg_res_adjunto myCgg_res_adjunto = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_adjunto.
	 */
	public Cgg_res_adjunto(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_adjunto.
	 * @param inCgg_res_adjunto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_adjunto.
	 */
	public Cgg_res_adjunto(
			com.besixplus.sii.objects.Cgg_res_adjunto inCgg_res_adjunto
	){
		this.setCgg_res_adjunto(inCgg_res_adjunto);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_adjunto.
	 * @param inCgg_res_adjunto OBJETO Cgg_res_adjunto.
	 * @return void
	 */
	public void setCgg_res_adjunto(com.besixplus.sii.objects.Cgg_res_adjunto inCgg_res_adjunto){
		this.myCgg_res_adjunto = inCgg_res_adjunto;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_adjunto.
	 * @return Cgg_res_adjunto OBJETO Cgg_res_adjunto.
	 */
	public com.besixplus.sii.objects.Cgg_res_adjunto getCgg_res_adjunto(){
		return this.myCgg_res_adjunto;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_adjunto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_adjunto().getCRADJ_CODIGO());
			stmInsert.setString(3, this.getCgg_res_adjunto().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_adjunto().getCRINF_CODIGO());
			stmInsert.setString(5, this.getCgg_res_adjunto().getCRNOT_CODIGO());
			stmInsert.setString(6, this.getCgg_res_adjunto().getCRRES_CODIGO());
			stmInsert.setString(7, this.getCgg_res_adjunto().getCRDPT_CODIGO());
			stmInsert.setString(8, this.getCgg_res_adjunto().getCRSEG_CODIGO());
			stmInsert.setString(9, this.getCgg_res_adjunto().getCRTPT_CODIGO());
			stmInsert.setString(10, this.getCgg_res_adjunto().getCRSSC_CODIGO());
			stmInsert.setString(11, this.getCgg_res_adjunto().getCRRQT_CODIGO());
			stmInsert.setString(12, this.getCgg_res_adjunto().getCRADJ_CONTENIDO());
			stmInsert.setString(13, this.getCgg_res_adjunto().getCRADJ_NOMBRE_ADJUNTO());
			stmInsert.setString(14, this.getCgg_res_adjunto().getCRADJ_OBSERVACION());
			stmInsert.setBytes(15, this.getCgg_res_adjunto().getCRADJ_ARCHIVO_ADJUNTO());
			stmInsert.setTimestamp(16, new java.sql.Timestamp(this.getCgg_res_adjunto().getCRADJ_FECHA_REGISTRO().getTime()));
			stmInsert.setBoolean(17, this.getCgg_res_adjunto().getCRADJ_ESTADO());
			stmInsert.setString(18, this.getCgg_res_adjunto().getCRADJ_USUARIO_INSERT());
			stmInsert.setString(19, this.getCgg_res_adjunto().getCRADJ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_adjunto().setCRADJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<HashMap<String, Object>> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_adjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_SELECT(?,?,?,?,?,?) }");
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

					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_adjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_adjunto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_adjunto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_adjunto().getCRADJ_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_adjunto().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_adjunto().getCRINF_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_adjunto().getCRNOT_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_adjunto().getCRRES_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_adjunto().getCRDPT_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_adjunto().getCRSEG_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_adjunto().getCRTPT_CODIGO());
			stmUpdate.setString(9, this.getCgg_res_adjunto().getCRSSC_CODIGO());
			stmUpdate.setString(10, this.getCgg_res_adjunto().getCRRQT_CODIGO());
			stmUpdate.setString(11, this.getCgg_res_adjunto().getCRADJ_CONTENIDO());
			stmUpdate.setString(12, this.getCgg_res_adjunto().getCRADJ_NOMBRE_ADJUNTO());
			stmUpdate.setString(13, this.getCgg_res_adjunto().getCRADJ_OBSERVACION());
			stmUpdate.setBytes(14, this.getCgg_res_adjunto().getCRADJ_ARCHIVO_ADJUNTO());
			stmUpdate.setTimestamp(15, new java.sql.Timestamp(this.getCgg_res_adjunto().getCRADJ_FECHA_REGISTRO().getTime()));
			stmUpdate.setBoolean(16, this.getCgg_res_adjunto().getCRADJ_ESTADO());
			stmUpdate.setString(17, this.getCgg_res_adjunto().getCRADJ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_adjunto select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRADJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_adjunto().setCRADJ_CODIGO(results.getString(1));
				this.getCgg_res_adjunto().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_adjunto().setCRINF_CODIGO(results.getString(3));
				this.getCgg_res_adjunto().setCRNOT_CODIGO(results.getString(4));
				this.getCgg_res_adjunto().setCRRES_CODIGO(results.getString(5));
				this.getCgg_res_adjunto().setCRDPT_CODIGO(results.getString(6));
				this.getCgg_res_adjunto().setCRSEG_CODIGO(results.getString(7));
				this.getCgg_res_adjunto().setCRTPT_CODIGO(results.getString(8));
				this.getCgg_res_adjunto().setCRSSC_CODIGO(results.getString(9));
				this.getCgg_res_adjunto().setCRRQT_CODIGO(results.getString(10));
				this.getCgg_res_adjunto().setCRADJ_CONTENIDO(results.getString(11));
				this.getCgg_res_adjunto().setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				this.getCgg_res_adjunto().setCRADJ_OBSERVACION(results.getString(13));
				this.getCgg_res_adjunto().setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				this.getCgg_res_adjunto().setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				this.getCgg_res_adjunto().setCRADJ_ESTADO(results.getBoolean(16));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_adjunto();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRADJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRADJ_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_deposito_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_DEPOSITO_GARANTIA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_DEPOSITO_GARANTIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRDPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_deposito_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_DEPOSITO_GARANTIA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_DEPOSITO_GARANTIA(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRDPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DS_CGG_RES_DEPOSITO_GARANTIA(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRDPT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_SEGUIMIENTO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_SEGUIMIENTO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRSEG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_RESOLUCION(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_RESOLUCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_RESOLUCION(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_RESOLUCION(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DS_CGG_RES_RESOLUCION(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRRES_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_TIPO_TRAMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_TIPO_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRTPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_TIPO_TRAMITE(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_TIPO_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRTPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DS_CGG_RES_TIPO_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRTPT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_informe_pareja.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_INFORME_PAREJA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_INFORME_PAREJA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRINF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_informe_pareja.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_INFORME_PAREJA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_INFORME_PAREJA(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRINF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DS_CGG_RES_INFORME_PAREJA(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRINF_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRPER_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_SESION_COMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_SESION_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRSSC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_SESION_COMITE(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_SESION_COMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRSSC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_DS_CGG_RES_SESION_COMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto().getCRSSC_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_requisito_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_REQUISITO_TRAMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_REQUISITO_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRRQT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_requisito_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_REQUISITO_TRAMITE(
			java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_REQUISITO_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRRQT_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_NOTIFICACION(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_NOTIFICACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRNOT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));
				tmpCgg_res_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto.setCRINF_CODIGO(results.getString(3));
				tmpCgg_res_adjunto.setCRNOT_CODIGO(results.getString(4));
				tmpCgg_res_adjunto.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_adjunto.setCRDPT_CODIGO(results.getString(6));
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));
				tmpCgg_res_adjunto.setCRTPT_CODIGO(results.getString(8));
				tmpCgg_res_adjunto.setCRSSC_CODIGO(results.getString(9));
				tmpCgg_res_adjunto.setCRRQT_CODIGO(results.getString(10));
				tmpCgg_res_adjunto.setCRADJ_CONTENIDO(results.getString(11));
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));
				tmpCgg_res_adjunto.setCRADJ_ARCHIVO_ADJUNTO(results.getBytes(14));
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_ESTADO(results.getBoolean(16));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_adjunto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insertAdjuntoSesion(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_SESION_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_adjunto().getCRADJ_CODIGO());
			stmInsert.setString(3, this.getCgg_res_adjunto().getCRRES_CODIGO());
			stmInsert.setString(4, this.getCgg_res_adjunto().getCRSSC_CODIGO());
			stmInsert.setString(5, this.getCgg_res_adjunto().getCRADJ_CONTENIDO());
			stmInsert.setString(6, this.getCgg_res_adjunto().getCRADJ_NOMBRE_ADJUNTO());
			stmInsert.setString(7, this.getCgg_res_adjunto().getCRADJ_OBSERVACION());
			stmInsert.setBytes(8, this.getCgg_res_adjunto().getCRADJ_ARCHIVO_ADJUNTO());
			stmInsert.setTimestamp(9,this.getCgg_res_adjunto().getCRADJ_FECHA_REGISTRO()==null?null:new java.sql.Timestamp(this.getCgg_res_adjunto().getCRADJ_FECHA_REGISTRO().getTime()));
			stmInsert.setBoolean(10, this.getCgg_res_adjunto().getCRADJ_ESTADO());
			stmInsert.setString(11, this.getCgg_res_adjunto().getCRADJ_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_res_adjunto().getCRADJ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_adjunto().setCRADJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_adjunto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insertCGG_VEH_VEHICULO(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_INSERT_CGG_VEH_VEHICULO(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_adjunto().getCRADJ_CODIGO());
			stmInsert.setString(3, this.getCgg_res_adjunto().getCVVEH_CODIGO());
			stmInsert.setString(4, this.getCgg_res_adjunto().getCRADJ_NOMBRE_ADJUNTO());
			stmInsert.setString(5, this.getCgg_res_adjunto().getCRADJ_OBSERVACION());
			stmInsert.setBytes(6, this.getCgg_res_adjunto().getCRADJ_ARCHIVO_ADJUNTO());
			stmInsert.setTimestamp(7,this.getCgg_res_adjunto().getCRADJ_FECHA_REGISTRO()==null?null:new java.sql.Timestamp(this.getCgg_res_adjunto().getCRADJ_FECHA_REGISTRO().getTime()));
			stmInsert.setBoolean(8, this.getCgg_res_adjunto().getCRADJ_ESTADO());
			stmInsert.setString(9, this.getCgg_res_adjunto().getCRADJ_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_adjunto().getCRADJ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_adjunto().setCRADJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public String deleteAdjunto(
			java.sql.Connection inConnection
	){
		String outResult = "true";		
		try{				
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_SESION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRADJ_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}

		return outResult;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectCGG_RES_SEGUIMIENTO1(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> outCgg_res_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2,this.getCgg_res_adjunto().getCRSEG_CODIGO());			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto tmpCgg_res_adjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
				tmpCgg_res_adjunto.setCRADJ_CODIGO(results.getString(1));				
				tmpCgg_res_adjunto.setCRSEG_CODIGO(results.getString(7));								
				tmpCgg_res_adjunto.setCRADJ_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_adjunto.setCRADJ_OBSERVACION(results.getString(13));				
				tmpCgg_res_adjunto.setCRADJ_FECHA_REGISTRO(results.getTimestamp(15));
				tmpCgg_res_adjunto.setCRADJ_USUARIO_INSERT(results.getString(18));
				tmpCgg_res_adjunto.setCRADJ_USUARIO_INSERT(results.getString(20));
				outCgg_res_adjunto.add(tmpCgg_res_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_SEGUIMIENTO1(
			java.sql.Connection inConnection
	){
		boolean outResult = true;	
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_D_CGG_RES_SEGUIMIENTO(?) }");			
			stmDelete.setString(1, this.getCgg_res_adjunto().getCRSEG_CODIGO());			
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	 * SELECCIONA TODOS LOS ADJUNTOS DE UN TRAMITE HASTA EL SEGUIMIENTO ESPECIFICADO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrtra_codigo IDENTIFICADOR UNICO DE TRAMITE.
	 * @return COLECCION DE ADJUNTOS.
	 */
	public ArrayList<HashMap<String,Object>> selectAdjuntoTramite(
			java.sql.Connection inConnection,
			String inCrtra_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_adjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_TRAMITE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrtra_codigo);
			stmSelect.setString(3, this.getCgg_res_adjunto().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++) {
					String colName = results.getMetaData().getColumnName(i).toUpperCase();
					Object colValue =  results.getObject(i);						
					tmpObj.put(colName,colValue);
				}
				outCgg_res_adjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<LinkedHashMap<String, Object>> selectCGG_VEH_VEHICULO(
			java.sql.Connection inConnection
	){
		ArrayList<LinkedHashMap<String, Object>> outCgg_res_adjunto = new ArrayList<LinkedHashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_S_CGG_VEH_VEHICULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				LinkedHashMap<String,Object> tmpObj = new LinkedHashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++) {
					String colName = results.getMetaData().getColumnName(i).toUpperCase();
					Object colValue =  results.getObject(i);						
					tmpObj.put(colName,colValue);
				}
				outCgg_res_adjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto;
	}

}