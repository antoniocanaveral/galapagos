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
* CLASE Cgg_res_seguimiento
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_seguimiento.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_seguimiento implements Serializable{
	private static final long serialVersionUID = 1237475760;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_seguimiento.
	*/
	private com.besixplus.sii.objects.Cgg_res_seguimiento myCgg_res_seguimiento = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_seguimiento.
	*/
	public Cgg_res_seguimiento(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_seguimiento.
	* @param inCgg_res_seguimiento OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_seguimiento.
	*/
	public Cgg_res_seguimiento(
		com.besixplus.sii.objects.Cgg_res_seguimiento inCgg_res_seguimiento
	){
		this.setCgg_res_seguimiento(inCgg_res_seguimiento);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_seguimiento.
	* @param inCgg_res_seguimiento OBJETO Cgg_res_seguimiento.
	* @return void
	*/
	public void setCgg_res_seguimiento(com.besixplus.sii.objects.Cgg_res_seguimiento inCgg_res_seguimiento){
		this.myCgg_res_seguimiento = inCgg_res_seguimiento;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_seguimiento.
	* @return Cgg_res_seguimiento OBJETO Cgg_res_seguimiento.
	*/
	public com.besixplus.sii.objects.Cgg_res_seguimiento getCgg_res_seguimiento(){
		return this.myCgg_res_seguimiento;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_INSERT_1(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?::smallint, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_seguimiento().getCRSEG_CODIGO());
			stmInsert.setString(3, this.getCgg_res_seguimiento().getCGG_CRSEG_CODIGO());
			stmInsert.setString(4, this.getCgg_res_seguimiento().getCRTRA_CODIGO());
			stmInsert.setString(5, this.getCgg_res_seguimiento().getCRFAS_CODIGO());
			stmInsert.setString(6, this.getCgg_res_seguimiento().getCGG_CRFAS_CODIGO());
			stmInsert.setString(7, this.getCgg_res_seguimiento().getCUSU_CODIGO());
			stmInsert.setString(8, this.getCgg_res_seguimiento().getCRSEG_DESCRIPCION());
			stmInsert.setInt(9, this.getCgg_res_seguimiento().getCRSEG_ESTADO_ATENCION());
			stmInsert.setString(10, this.getCgg_res_seguimiento().getCRSEG_OBSERVACION());
			stmInsert.setInt(11, this.getCgg_res_seguimiento().getCRSEG_TIPO_RESPUESTA());
			stmInsert.setString(12, this.getCgg_res_seguimiento().getCRSEG_TIPO_ACTIVIDAD());
			stmInsert.setTimestamp(13, this.getCgg_res_seguimiento().getCRSEG_FECHA_RECEPCION()==null?null:new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_RECEPCION().getTime()));
			stmInsert.setTimestamp(14, this.getCgg_res_seguimiento().getCRSEG_FECHA_REVISION()==null?null:new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_REVISION().getTime()));
			stmInsert.setTimestamp(15, this.getCgg_res_seguimiento().getCRSEG_FECHA_DESPACHO()==null?null:new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_DESPACHO().getTime()));
			stmInsert.setInt(16, this.getCgg_res_seguimiento().getCRSEG_ESTADO_HIJO());
			stmInsert.setTimestamp(17, this.getCgg_res_seguimiento().getCRSEG_FECHA_REAPERTURA()==null?null:new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_REAPERTURA().getTime()));
			stmInsert.setBigDecimal(18, this.getCgg_res_seguimiento().getCRSEG_VECES_REVISION());
			stmInsert.setBigDecimal(19, this.getCgg_res_seguimiento().getCRSEG_NUMERO());
			stmInsert.setBoolean(20, this.getCgg_res_seguimiento().getCRSEG_ESTADO());
			stmInsert.setString(21, this.getCgg_res_seguimiento().getCRSEG_USUARIO_INSERT());
			stmInsert.setString(22, this.getCgg_res_seguimiento().getCRSEG_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_seguimiento().setCRSEG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?::smallint, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_seguimiento().getCRSEG_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_seguimiento().getCGG_CRSEG_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_seguimiento().getCRTRA_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_seguimiento().getCRFAS_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_seguimiento().getCGG_CRFAS_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_seguimiento().getCUSU_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_seguimiento().getCRSEG_DESCRIPCION());
			stmUpdate.setInt(8, this.getCgg_res_seguimiento().getCRSEG_ESTADO_ATENCION());
			stmUpdate.setString(9, this.getCgg_res_seguimiento().getCRSEG_OBSERVACION());
			stmUpdate.setInt(10, this.getCgg_res_seguimiento().getCRSEG_TIPO_RESPUESTA());
			stmUpdate.setString(11, this.getCgg_res_seguimiento().getCRSEG_TIPO_ACTIVIDAD());
			stmUpdate.setTimestamp(12, this.getCgg_res_seguimiento().getCRSEG_FECHA_RECEPCION()==null?null:new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_RECEPCION().getTime()));
			stmUpdate.setTimestamp(13, this.getCgg_res_seguimiento().getCRSEG_FECHA_REVISION()==null?null: new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_REVISION().getTime()));
			stmUpdate.setTimestamp(14, this.getCgg_res_seguimiento().getCRSEG_FECHA_DESPACHO()==null ? null: new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_DESPACHO().getTime()));
			stmUpdate.setInt(15, this.getCgg_res_seguimiento().getCRSEG_ESTADO_HIJO());
			stmUpdate.setTimestamp(16, this.getCgg_res_seguimiento().getCRSEG_FECHA_REAPERTURA() == null ? null :new java.sql.Timestamp(this.getCgg_res_seguimiento().getCRSEG_FECHA_REAPERTURA().getTime()));
			stmUpdate.setBigDecimal(17, this.getCgg_res_seguimiento().getCRSEG_VECES_REVISION());
			stmUpdate.setBigDecimal(18, this.getCgg_res_seguimiento().getCRSEG_NUMERO());
			stmUpdate.setBoolean(19, this.getCgg_res_seguimiento().getCRSEG_ESTADO());
			stmUpdate.setString(20, this.getCgg_res_seguimiento().getCRSEG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_seguimiento select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_seguimiento().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_seguimiento().setCRSEG_CODIGO(results.getString(1));
				this.getCgg_res_seguimiento().setCGG_CRSEG_CODIGO(results.getString(2));
				this.getCgg_res_seguimiento().setCRTRA_CODIGO(results.getString(3));
				this.getCgg_res_seguimiento().setCRFAS_CODIGO(results.getString(4));
				this.getCgg_res_seguimiento().setCGG_CRFAS_CODIGO(results.getString(5));
				this.getCgg_res_seguimiento().setCUSU_CODIGO(results.getString(6));
				this.getCgg_res_seguimiento().setCRSEG_DESCRIPCION(results.getString(7));
				this.getCgg_res_seguimiento().setCRSEG_ESTADO_ATENCION(results.getInt(8));
				this.getCgg_res_seguimiento().setCRSEG_OBSERVACION(results.getString(9));
				this.getCgg_res_seguimiento().setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				this.getCgg_res_seguimiento().setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				this.getCgg_res_seguimiento().setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				this.getCgg_res_seguimiento().setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				this.getCgg_res_seguimiento().setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				this.getCgg_res_seguimiento().setCRSEG_ESTADO_HIJO(results.getInt(15));
				this.getCgg_res_seguimiento().setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				this.getCgg_res_seguimiento().setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				this.getCgg_res_seguimiento().setCRSEG_NUMERO(results.getBigDecimal(18));
				this.getCgg_res_seguimiento().setCRSEG_ESTADO(results.getBoolean(19));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_seguimiento();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_seguimiento().getCRSEG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_seguimiento().getCRSEG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_S_CGG_RES_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_seguimiento().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_D_CGG_RES_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_seguimiento().getCRTRA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DS_CGG_RES_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_seguimiento().getCRTRA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectCGG_RES_SEGUIMIENTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_seguimiento().getCGG_CRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SEGUIMIENTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_seguimiento().getCGG_CRSEG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DS_CGG_RES_SEGUIMIENTO(?) }");
				stmDelete.setString(1, this.getCgg_res_seguimiento().getCGG_CRSEG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_S_CGG_RES_FASE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_seguimiento().getCRFAS_CODIGO());
			stmSelect.setString(3,this.getCgg_res_seguimiento().getCGG_CRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_D_CGG_RES_FASE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_seguimiento().getCRFAS_CODIGO());
			stmDelete.setString(2, this.getCgg_res_seguimiento().getCGG_CRFAS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DS_CGG_RES_FASE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_seguimiento().getCRFAS_CODIGO());
				stmDelete.setString(2, this.getCgg_res_seguimiento().getCGG_CRFAS_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_seguimiento().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_seguimiento().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_seguimiento().getCUSU_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect1(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCrtst_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_SELECT1(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrtst_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirectVeh(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_SELECT_VEH(?,?,?,?,?,?) }");
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
				outCgg_res_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA. 
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return NUMERO DE FILAS SELECCIONADAS PARA EL CRITERIO Y USUARIO ESTABLECIDO.
	*/
	public int selectCount1(
			java.sql.Connection inConnection,
			String inKeyword,
			String inUserName
		){
		return selectCount1(inConnection, inKeyword, inUserName, "");
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA. 
	* @param inUserName NOMBRE DE USUARIO DE SEGUIMIENTO.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	* @return NUMERO DE FILAS SELECCIONADAS PARA EL CRITERIO Y USUARIO ESTABLECIDA.
	*/
	public int selectCount1(
		java.sql.Connection inConnection,
		String inKeyword,
		String inUserName,
		String inCrtst_codigo
	){
		int outCount = 0;		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_COUNT1(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inUserName);
			stmSelect.setString(4,inCrtst_codigo);
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
	* @param inUserName NOMBRE DEL USUARIO DEL SEGUIMIENTO.
	* @return NUMERO DE FILAS SELECCIONDAS PARA EL CRITERIO Y USUARIO ESTABLECIDO.
	*/
	public int selectCountVeh(
		java.sql.Connection inConnection,
		String inKeyword,
		String inUserName
	){
		int outCount = 0;		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_COUNT_VEH(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inUserName);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	* Selecciona todos los seguimientos iniciales o padres de un tramite los cuales siempre seran uno solo pero por cuestiones practicas se los realiza de seleccion multiple.
	* El seguimiento padre de un tramite es aquel q no tiene coincidencia en el campo CGG_CRSEG_CODIGO.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return Coleccion de objetos com.besixplus.sii.objects.Cgg_res_seguimiento.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> selectSeguimientoPadre(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> outCgg_res_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_PADRE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_seguimiento().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpCgg_res_seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				tmpCgg_res_seguimiento.setCRSEG_CODIGO(results.getString(1));
				tmpCgg_res_seguimiento.setCGG_CRSEG_CODIGO(results.getString(2));
				tmpCgg_res_seguimiento.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_seguimiento.setCRFAS_CODIGO(results.getString(4));
				tmpCgg_res_seguimiento.setCGG_CRFAS_CODIGO(results.getString(5));
				tmpCgg_res_seguimiento.setCUSU_CODIGO(results.getString(6));
				tmpCgg_res_seguimiento.setCRSEG_DESCRIPCION(results.getString(7));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_ATENCION(results.getInt(8));
				tmpCgg_res_seguimiento.setCRSEG_OBSERVACION(results.getString(9));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_RESPUESTA(results.getInt(10));
				tmpCgg_res_seguimiento.setCRSEG_TIPO_ACTIVIDAD(results.getString(11));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_RECEPCION(results.getTimestamp(12));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REVISION(results.getTimestamp(13));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_DESPACHO(results.getTimestamp(14));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO_HIJO(results.getInt(15));
				tmpCgg_res_seguimiento.setCRSEG_FECHA_REAPERTURA(results.getTimestamp(16));
				tmpCgg_res_seguimiento.setCRSEG_VECES_REVISION(results.getBigDecimal(17));
				tmpCgg_res_seguimiento.setCRSEG_NUMERO(results.getBigDecimal(18));
				tmpCgg_res_seguimiento.setCRSEG_ESTADO(results.getBoolean(19));
				outCgg_res_seguimiento.add(tmpCgg_res_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}
	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_seguimiento DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete1(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SEGUIMIENTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_seguimiento().getCRSEG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}
	
	/**
	* EJECUTA LA FUNCION DEFINIDA EN LA FASE CORRESPONDIENTE A UN SEGUIMIENTO Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inFunctionName NOMBRE DE LA FUNCION  A EJECUTRA.
	* @param inCrseg_codigo CODIGO DEL SEGUIMIENTO DESDE DONDE SE EJECUTA LA FUNCION.
	* @param inUserName USUARIO ENCARGADO DE CUMPLIR CON EL SEGUIMIENTO.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String ejecutarFuncionSeguimiento(
		java.sql.Connection inConnection,
		String inFunctionName,
		String inCrseg_codigo,
		String inUserName
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii."+inFunctionName+"(?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, inCrseg_codigo);
			stmInsert.setString(3, inUserName);
			
			stmInsert.execute();
			outResult = stmInsert.getString(1);
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE 
	* @return com.besixplus.sii.objects.Cgg_res_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectSeguimientoStatus(
		java.sql.Connection inConnection,
		String inCrtra_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SEGUIMIENTO_S_CGG_RES_TRAMITE_PLUS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrtra_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_seguimiento;
	}
	
	/**
	 * Obtiene una coleccion con informacion de seguimiento, tramite y otras tablas relacionadas.
	 * @param inConnection Conexion a base de datos. 
	 * @return Coleccion con informacion.
	 */
	public ArrayList<HashMap<String,Object>> selectSeguimientoTramite(
			java.sql.Connection inConnection			
		){
			ArrayList<HashMap<String,Object>> outCgg_res_seguimiento = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_SEGUIMIENTO_TRAMITE(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,this.getCgg_res_seguimiento().getCRSEG_CODIGO());
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_seguimiento.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_seguimiento;
		}
	/**SELECCIONA EL NUMERO DE NOTIFICACIONES
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inUserName NOMBRE DE USUARIO.
	 * @return NUMERO DE NOTIFICACIONES.
	 */
	public ArrayList<HashMap<String,Object>>  selectCountNotificacion(
			java.sql.Connection inConnection,
			String inUserName			
		){
		ArrayList<HashMap<String,Object>> outCgg_res_seguimiento = new ArrayList<HashMap<String,Object>>();		
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_NOTIFICACION_COUNT(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);				
				stmSelect.setString(2,inUserName);				
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_seguimiento.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_seguimiento;
		}
	
}