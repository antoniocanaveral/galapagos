package com.besixplus.sii.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASE Cgg_res_tramite
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tramite.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_tramite implements Serializable{
	private static final long serialVersionUID = 1051755832;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tramite.
	 */
	private com.besixplus.sii.objects.Cgg_res_tramite myCgg_res_tramite = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_tramite.
	 */
	public Cgg_res_tramite(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_tramite.
	 * @param inCgg_res_tramite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tramite.
	 */
	public Cgg_res_tramite(
			com.besixplus.sii.objects.Cgg_res_tramite inCgg_res_tramite
	){
		this.setCgg_res_tramite(inCgg_res_tramite);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tramite.
	 * @param inCgg_res_tramite OBJETO Cgg_res_tramite.
	 * @return void
	 */
	public void setCgg_res_tramite(com.besixplus.sii.objects.Cgg_res_tramite inCgg_res_tramite){
		this.myCgg_res_tramite = inCgg_res_tramite;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tramite.
	 * @return Cgg_res_tramite OBJETO Cgg_res_tramite.
	 */
	public com.besixplus.sii.objects.Cgg_res_tramite getCgg_res_tramite(){
		return this.myCgg_res_tramite;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_INSERT(?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tramite().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tramite().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_tramite().getCRPRO_CODIGO());
			stmInsert.setString(7, this.getCgg_res_tramite().getCRTST_CODIGO());
			stmInsert.setString(8, this.getCgg_res_tramite().getCVVEH_CODIGO());
			stmInsert.setString(9, this.getCgg_res_tramite().getCRETT_CODIGO());
			stmInsert.setString(10, this.getCgg_res_tramite().getCISLA_CODIGO());
			stmInsert.setString(11, this.getCgg_res_tramite().getCVMTR_CODIGO());
			stmInsert.setString(12, this.getCgg_res_tramite().getCGG_CVMTR_CODIGO());
			stmInsert.setString(13, this.getCgg_res_tramite().getCGG_CVVEH_CODIGO());
			stmInsert.setBigDecimal(14, this.getCgg_res_tramite().getCRTRA_ANIO());
			stmInsert.setBigDecimal(15, this.getCgg_res_tramite().getCRTRA_NUMERO());
			stmInsert.setTimestamp(16, this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION() == null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION().getTime()));
			stmInsert.setString(17, this.getCgg_res_tramite().getCRTRA_ACTIVIDAD_RESIDENCIA());
			stmInsert.setString(18, this.getCgg_res_tramite().getCRTRA_OBSERVACION());
			stmInsert.setInt(19, this.getCgg_res_tramite().getCRTRA_DIAS_PERMANENCIA());
			stmInsert.setInt(20, this.getCgg_res_tramite().getCRTRA_PENDIENTE());
			stmInsert.setString(21, this.getCgg_res_tramite().getCRTRA_OBSERVACION_PENDIENTE());
			stmInsert.setBoolean(22, this.getCgg_res_tramite().getCRTRA_ATENCION_CLIENTE());
			stmInsert.setString(23, this.getCgg_res_tramite().getCRTRA_COMUNICADO_RADIAL());
			stmInsert.setString(24, this.getCgg_res_tramite().getCRTRA_MOTIVO());
			stmInsert.setBigDecimal(25, this.getCgg_res_tramite().getCRTRA_FOLIO());
			stmInsert.setBoolean(26, this.getCgg_res_tramite().getCRTRA_GRUPO());
			stmInsert.setBigDecimal(27, this.getCgg_res_tramite().getCRTRA_ORDEN());
			stmInsert.setTimestamp(28, this.getCgg_res_tramite().getCRTRA_FECHA_INGRESO()==null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_INGRESO().getTime()));
			stmInsert.setTimestamp(29, this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA()==null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA().getTime()));
			stmInsert.setBoolean(30, this.getCgg_res_tramite().getCRTRA_ESTADO());
			stmInsert.setString(31, this.getCgg_res_tramite().getCRTRA_USUARIO_INSERT());
			stmInsert.setString(32, this.getCgg_res_tramite().getCRTRA_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_tramite().setCRTRA_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(29));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(29));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
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
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_COUNT(?) }");
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_UPDATE(?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?, ?, ?, ?,?,?,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tramite().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tramite().getCRPJR_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_tramite().getCRPRO_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_tramite().getCRTST_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_tramite().getCVVEH_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_tramite().getCRETT_CODIGO());
			stmUpdate.setString(9, this.getCgg_res_tramite().getCISLA_CODIGO());
			stmUpdate.setString(10, this.getCgg_res_tramite().getCVMTR_CODIGO());
			stmUpdate.setString(11, this.getCgg_res_tramite().getCGG_CVMTR_CODIGO());
			stmUpdate.setString(12, this.getCgg_res_tramite().getCGG_CVVEH_CODIGO());
			stmUpdate.setBigDecimal(13, this.getCgg_res_tramite().getCRTRA_ANIO());
			stmUpdate.setBigDecimal(14, this.getCgg_res_tramite().getCRTRA_NUMERO());
			stmUpdate.setTimestamp(15, new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION().getTime()));
			stmUpdate.setString(16, this.getCgg_res_tramite().getCRTRA_ACTIVIDAD_RESIDENCIA());
			stmUpdate.setString(17, this.getCgg_res_tramite().getCRTRA_OBSERVACION());
			stmUpdate.setInt(18, this.getCgg_res_tramite().getCRTRA_DIAS_PERMANENCIA());
			stmUpdate.setInt(19, this.getCgg_res_tramite().getCRTRA_PENDIENTE());
			stmUpdate.setString(20, this.getCgg_res_tramite().getCRTRA_OBSERVACION_PENDIENTE());
			stmUpdate.setBoolean(21, this.getCgg_res_tramite().getCRTRA_ATENCION_CLIENTE());
			stmUpdate.setString(22, this.getCgg_res_tramite().getCRTRA_COMUNICADO_RADIAL());
			stmUpdate.setString(23, this.getCgg_res_tramite().getCRTRA_MOTIVO());
			stmUpdate.setBigDecimal(24, this.getCgg_res_tramite().getCRTRA_FOLIO());
			stmUpdate.setBoolean(25, this.getCgg_res_tramite().getCRTRA_GRUPO());
			stmUpdate.setBigDecimal(26, this.getCgg_res_tramite().getCRTRA_ORDEN());
			stmUpdate.setTimestamp(27, this.getCgg_res_tramite().getCRTRA_FECHA_INGRESO()==null ? null : new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_INGRESO().getTime()));
			stmUpdate.setTimestamp(28, this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA()==null ? null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA().getTime()));
			stmUpdate.setBoolean(29, this.getCgg_res_tramite().getCRTRA_ESTADO());
			stmUpdate.setString(30, this.getCgg_res_tramite().getCRTRA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_tramite select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tramite().setCRTRA_CODIGO(results.getString(1));
				this.getCgg_res_tramite().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_tramite().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_res_tramite().setCGG_CRPER_CODIGO(results.getString(4));
				this.getCgg_res_tramite().setCRPRO_CODIGO(results.getString(5));
				this.getCgg_res_tramite().setCRTST_CODIGO(results.getString(6));
				this.getCgg_res_tramite().setCVVEH_CODIGO(results.getString(7));
				this.getCgg_res_tramite().setCRETT_CODIGO(results.getString(8));
				this.getCgg_res_tramite().setCISLA_CODIGO(results.getString(9));
				this.getCgg_res_tramite().setCVMTR_CODIGO(results.getString(10));
				this.getCgg_res_tramite().setCGG_CVMTR_CODIGO(results.getString(11));
				this.getCgg_res_tramite().setCGG_CVVEH_CODIGO(results.getString(12));
				this.getCgg_res_tramite().setCRTRA_ANIO(results.getBigDecimal(13));
				this.getCgg_res_tramite().setCRTRA_NUMERO(results.getBigDecimal(14));
				this.getCgg_res_tramite().setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				this.getCgg_res_tramite().setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				this.getCgg_res_tramite().setCRTRA_OBSERVACION(results.getString(17));
				this.getCgg_res_tramite().setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				this.getCgg_res_tramite().setCRTRA_PENDIENTE(results.getInt(19));
				this.getCgg_res_tramite().setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				this.getCgg_res_tramite().setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				this.getCgg_res_tramite().setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				this.getCgg_res_tramite().setCRTRA_MOTIVO(results.getString(23));
				this.getCgg_res_tramite().setCRTRA_FOLIO(results.getBigDecimal(24));
				this.getCgg_res_tramite().setCRTRA_GRUPO(results.getBoolean(25));
				this.getCgg_res_tramite().setCRTRA_ORDEN(results.getBigDecimal(26));
				this.getCgg_res_tramite().setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				this.getCgg_res_tramite().setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				this.getCgg_res_tramite().setCRTRA_ESTADO(results.getBoolean(29));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tramite();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRTRA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCRTRA_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_estado_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_RES_ESTADO_TRAMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_RES_ESTADO_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRETT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_estado_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_ESTADO_TRAMITE(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_RES_ESTADO_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRETT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_RES_ESTADO_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCRETT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRTST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCRTST_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_RES_PROCESO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_RES_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRPRO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_PROCESO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_RES_PROCESO(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRPRO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_RES_PROCESO(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCRPRO_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_VEH_VEHICULO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_VEH_VEHICULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_VEH_VEHICULO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_VEH_VEHICULO(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCVVEH_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_VEH_VEHICULO(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCVVEH_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_ISLA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_ISLA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCISLA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_ISLA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_ISLA(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCISLA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_ISLA(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCISLA_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_RES_PERSONA_JURIDICA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCRPJR_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_motor.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_VEH_MOTOR(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_VEH_MOTOR(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCVMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_motor.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_VEH_MOTOR(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_VEH_MOTOR(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCVMTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_VEH_MOTOR(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCVMTR_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_RES_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRPER_CODIGO());
			stmSelect.setString(3,this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}
	
	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO
	 * AL CODIGO DE LA PERSONA, DEL AUSPICIANTE Y AL TIPO DE SOLICITUD
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> selectCGG_RES_PERSONA_TIPO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> outCgg_res_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_S_CGG_RES_PERSONA_TIPO(?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRPER_CODIGO());
			stmSelect.setString(3,this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_res_tramite().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite tmpCgg_res_tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
				tmpCgg_res_tramite.setCRTRA_CODIGO(results.getString(1));
				tmpCgg_res_tramite.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_tramite.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_tramite.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_tramite.setCRPRO_CODIGO(results.getString(5));
				tmpCgg_res_tramite.setCRTST_CODIGO(results.getString(6));
				tmpCgg_res_tramite.setCVVEH_CODIGO(results.getString(7));
				tmpCgg_res_tramite.setCRETT_CODIGO(results.getString(8));
				tmpCgg_res_tramite.setCISLA_CODIGO(results.getString(9));
				tmpCgg_res_tramite.setCVMTR_CODIGO(results.getString(10));
				tmpCgg_res_tramite.setCGG_CVMTR_CODIGO(results.getString(11));
				tmpCgg_res_tramite.setCGG_CVVEH_CODIGO(results.getString(12));
				tmpCgg_res_tramite.setCRTRA_ANIO(results.getBigDecimal(13));
				tmpCgg_res_tramite.setCRTRA_NUMERO(results.getBigDecimal(14));
				tmpCgg_res_tramite.setCRTRA_FECHA_RECEPCION(results.getTimestamp(15));
				tmpCgg_res_tramite.setCRTRA_ACTIVIDAD_RESIDENCIA(results.getString(16));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION(results.getString(17));
				tmpCgg_res_tramite.setCRTRA_DIAS_PERMANENCIA(results.getInt(18));
				tmpCgg_res_tramite.setCRTRA_PENDIENTE(results.getInt(19));
				tmpCgg_res_tramite.setCRTRA_OBSERVACION_PENDIENTE(results.getString(20));
				tmpCgg_res_tramite.setCRTRA_ATENCION_CLIENTE(results.getBoolean(21));
				tmpCgg_res_tramite.setCRTRA_COMUNICADO_RADIAL(results.getString(22));
				tmpCgg_res_tramite.setCRTRA_MOTIVO(results.getString(23));
				tmpCgg_res_tramite.setCRTRA_FOLIO(results.getBigDecimal(24));
				tmpCgg_res_tramite.setCRTRA_GRUPO(results.getBoolean(25));
				tmpCgg_res_tramite.setCRTRA_ORDEN(results.getBigDecimal(26));
				//tmpCgg_res_tramite.setCRTRA_FECHA_INGRESO(results.getTimestamp(27));
				//tmpCgg_res_tramite.setCRTRA_FECHA_SALIDA(results.getTimestamp(28));
				tmpCgg_res_tramite.setCRTRA_RECALIFICACION(results.getBoolean(29));
				tmpCgg_res_tramite.setCRTRA_ESTADO(results.getBoolean(30));
				outCgg_res_tramite.add(tmpCgg_res_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}
	

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_D_CGG_RES_PERSONA(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRPER_CODIGO());
			stmDelete.setString(2, this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DS_CGG_RES_PERSONA(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_tramite().getCRPER_CODIGO());
				stmDelete.setString(2, this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite con la generacion del numero de tramite automatica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>String</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String [] insert1(
			java.sql.Connection inConnection
	){
		String [] outResult = null;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_INSERT_1(?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?, ?, ?::smallint,?::smallint, ?, ?, ?, ?, ?, ?, ?, ?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tramite().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tramite().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_tramite().getCRPRO_CODIGO());
			stmInsert.setString(7, this.getCgg_res_tramite().getCRTST_CODIGO());
			stmInsert.setString(8, this.getCgg_res_tramite().getCVVEH_CODIGO());
			stmInsert.setString(9, this.getCgg_res_tramite().getCRETT_CODIGO());
			stmInsert.setString(10, this.getCgg_res_tramite().getCISLA_CODIGO());
			stmInsert.setString(11, this.getCgg_res_tramite().getCVMTR_CODIGO());
			stmInsert.setString(12, this.getCgg_res_tramite().getCGG_CVMTR_CODIGO());
			stmInsert.setString(13, this.getCgg_res_tramite().getCGG_CVVEH_CODIGO());
			stmInsert.setBigDecimal(14, this.getCgg_res_tramite().getCRTRA_ANIO());
			stmInsert.setBigDecimal(15, this.getCgg_res_tramite().getCRTRA_NUMERO());
			stmInsert.setTimestamp(16, this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION() == null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION().getTime()));
			stmInsert.setString(17, this.getCgg_res_tramite().getCRTRA_ACTIVIDAD_RESIDENCIA());
			stmInsert.setString(18, this.getCgg_res_tramite().getCRTRA_OBSERVACION());
			stmInsert.setInt(19, this.getCgg_res_tramite().getCRTRA_DIAS_PERMANENCIA());
			stmInsert.setInt(20,this.getCgg_res_tramite().getCRTRA_PENDIENTE());
			stmInsert.setString(21, this.getCgg_res_tramite().getCRTRA_OBSERVACION_PENDIENTE());
			stmInsert.setBoolean(22, this.getCgg_res_tramite().getCRTRA_ATENCION_CLIENTE());
			stmInsert.setString(23, this.getCgg_res_tramite().getCRTRA_COMUNICADO_RADIAL());
			stmInsert.setString(24, this.getCgg_res_tramite().getCRTRA_MOTIVO());
			stmInsert.setBigDecimal(25, this.getCgg_res_tramite().getCRTRA_FOLIO());
			stmInsert.setTimestamp(26, this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA() == null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA().getTime()));
			stmInsert.setBoolean(27, this.getCgg_res_tramite().getCRTRA_ESTADO());
			stmInsert.setString(28, this.getCgg_res_tramite().getCRTRA_USUARIO_INSERT());
			stmInsert.setString(29, this.getCgg_res_tramite().getCRTRA_USUARIO_UPDATE());
			stmInsert.execute();
			String aux = stmInsert.getString(1);						
			outResult = aux.split(",");						
			this.getCgg_res_tramite().setCRTRA_CODIGO(outResult[0]);
			this.getCgg_res_tramite().setCRTRA_NUMERO(new BigDecimal(outResult[1]));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			//outResult = null;
			outResult = new String[2];
			outResult[1]=null;
			outResult[1]=e.getMessage(); 
		}
		return outResult;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA Y EL USUARIO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inUsername Nombre de usuario.
	 * @return NUMERO DE REGISTROS.
	 */
	public int selectCount1(
			java.sql.Connection inConnection,
			String inKeyword,
			String inUsername
	){
		int outCount = 0;		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_COUNT1(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inUsername);

			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO. 
	 * @param inDirection Direccion del ordenamiento de la consulta (<code>ASC|DESC</code>). 
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllDirect1(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT1(?,?,?,?,?,?) }");
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
				outCgg_res_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}
	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tramite DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public boolean delete1(
			java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{		
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}

		return outResult;
	}
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite con la generacion del numero de tramite automatica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>String</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String [] insert2(
			java.sql.Connection inConnection
	){
		String [] outResult = null;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_INSERT_2(?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint,?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tramite().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tramite().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_res_tramite().getCGG_CRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_tramite().getCRPRO_CODIGO());
			stmInsert.setString(7, this.getCgg_res_tramite().getCRTST_CODIGO());
			stmInsert.setString(8, this.getCgg_res_tramite().getCVVEH_CODIGO());
			stmInsert.setString(9, this.getCgg_res_tramite().getCRETT_CODIGO());
			stmInsert.setString(10, this.getCgg_res_tramite().getCISLA_CODIGO());
			stmInsert.setString(11, this.getCgg_res_tramite().getCVMTR_CODIGO());
			stmInsert.setString(12, this.getCgg_res_tramite().getCGG_CVMTR_CODIGO());
			stmInsert.setString(13, this.getCgg_res_tramite().getCGG_CVVEH_CODIGO());
			stmInsert.setBigDecimal(14, this.getCgg_res_tramite().getCRTRA_ANIO());
			stmInsert.setBigDecimal(15, this.getCgg_res_tramite().getCRTRA_NUMERO());
			stmInsert.setTimestamp(16, this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION() == null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_RECEPCION().getTime()));
			stmInsert.setString(17, this.getCgg_res_tramite().getCRTRA_ACTIVIDAD_RESIDENCIA());
			stmInsert.setString(18, this.getCgg_res_tramite().getCRTRA_OBSERVACION());
			stmInsert.setInt(19, this.getCgg_res_tramite().getCRTRA_DIAS_PERMANENCIA());
			stmInsert.setInt(20,this.getCgg_res_tramite().getCRTRA_PENDIENTE());
			stmInsert.setString(21, this.getCgg_res_tramite().getCRTRA_OBSERVACION_PENDIENTE());
			stmInsert.setBoolean(22, this.getCgg_res_tramite().getCRTRA_ATENCION_CLIENTE());
			stmInsert.setString(23, this.getCgg_res_tramite().getCRTRA_COMUNICADO_RADIAL());
			stmInsert.setString(24, this.getCgg_res_tramite().getCRTRA_MOTIVO());
			stmInsert.setBigDecimal(25, this.getCgg_res_tramite().getCRTRA_FOLIO());
			stmInsert.setBoolean(26, this.getCgg_res_tramite().getCRTRA_GRUPO());
			stmInsert.setBigDecimal(27, this.getCgg_res_tramite().getCRTRA_ORDEN());
			stmInsert.setTimestamp(28,  this.getCgg_res_tramite().getCRTRA_FECHA_INGRESO()== null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_INGRESO().getTime()));
			stmInsert.setTimestamp(29, this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA()== null?null:new java.sql.Timestamp(this.getCgg_res_tramite().getCRTRA_FECHA_SALIDA().getTime()));
			stmInsert.setBoolean(30, this.getCgg_res_tramite().getCRTRA_ESTADO());
			stmInsert.setString(31, this.getCgg_res_tramite().getCRTRA_USUARIO_INSERT());
			stmInsert.setString(32, this.getCgg_res_tramite().getCRTRA_USUARIO_UPDATE());;
			stmInsert.execute();
			String aux = stmInsert.getString(1);						
			outResult = aux.split(",");						
			this.getCgg_res_tramite().setCRTRA_CODIGO(outResult[0]);
			this.getCgg_res_tramite().setCRTRA_NUMERO(new BigDecimal(outResult[1]));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = null;
		}
		return outResult;
	}

	/**Selecciona un tramite en base a su clave primaria.
	 * @param inConnection Conexion de datos.
	 * @return Coleccion de tramites. 
	 */
	public ArrayList<HashMap<String,Object>>  selectDirect(
			java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS. 
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO. 
	 * @param inDirection Direccion del ordenamiento de la consulta (<code>ASC|DESC</code>). 
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageHistorial(
			java.sql.Connection inConnection,			
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_HISTORIAL(?,?,?,?,?) }");
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
				outCgg_res_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * Devuelve el numero de registro de todos los tramites deacuerdo a un criterio.
	 * @param inConnection Conexion de datos.
	 * @param inKeyword Criterio de busqueda de informacion.
	 * @return Numero de registros seleccionados.
	 */
	public int selectPageHistorialCount(
			java.sql.Connection inConnection,
			String inKeyword			
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_HISTORIAL_COUNT(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA, al igual que con su estado e isla de registro.
	 * @param inConnection CONEXION A LA BASE DE DATOS. 
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO. 
	 * @param inDirection Direccion del ordenamiento de la consulta (<code>ASC|DESC</code>). 
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCisla_codigo Codigo de isla.
	 * @param inCrett_codigo Codigo de estado de tramite.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageEstadoIsla(
			java.sql.Connection inConnection,			
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCisla_codigo,
			String inCrett_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_ESTADO_ISLA(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setInt(2, inStart);
			stmSelect.setInt(3, inLimit);
			stmSelect.setString(4, inSortFieldName);
			stmSelect.setString(5, inDirection);
			stmSelect.setString(6, inKeyword);
			stmSelect.setString(7, inCisla_codigo);
			stmSelect.setString(8, inCrett_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}

	/**
	 * Devuelve el numero de registro de todos los tramites deacuerdo a un criterio, estado e isla del tramite.
	 * @param inConnection Conexion de datos.
	 * @param inKeyword Criterio de busqueda de informacion.
	 * @param inCisla_codigo Codigo de isla.
	 * @param inCrett_codigo Codigo de estado de tramite.
	 * @return Numero de registros seleccionados.
	 */
	public int selectPageEstadoIslaCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inCisla_codigo,
			String inCrett_codigo
	){
		int outCount = 0;		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_ESTADO_ISLA_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCisla_codigo);
			stmSelect.setString(4, inCrett_codigo);			
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrtra_codigo CODIGO DEL TRAMITE A CONSULTAR
	 * @return ArrayList<HashMap<String,Object>> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectTramiteSeguimientoStatus(
			java.sql.Connection inConnection,
			String inCrtra_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		String tmpCrtra_codigo = inCrtra_codigo;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_SELECT_PLUS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrtra_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
				{
					if(results.getObject(i) != null)
					{
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
						if(results.getMetaData().getColumnName(i).toUpperCase().equals("CRTRA_CODIGO"))
							tmpCrtra_codigo = results.getObject(i).toString();
					}
				}
				tmpObj.put("SEGUIMIENTO", com.besixplus.sii.db.Cgg_res_seguimiento.selectSeguimientoStatus(inConnection,tmpCrtra_codigo));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA, al igual que con su estado e isla de registro.
	 * @param inConnection CONEXION A LA BASE DE DATOS. 
	 * @param inCrtra_codigo Codigo identificativo unico  de tramite.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectTramiteByCode(
			java.sql.Connection inConnection,			
			String inCrtra_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_SELECT2(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2, inCrtra_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite;
	}
	
	/**
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateAuspiciante(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_UPDATE_AUSPICIANTE(?,?,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tramite().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tramite().getCRPJR_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_tramite().getCRTRA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateIsla(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_UPDATE_ISLA(?,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_tramite().getCRTRA_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tramite().getCISLA_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tramite().getCRTRA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

}