package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASE Cgg_res_notificacion
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_notificacion.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_notificacion implements Serializable{
	private static final long serialVersionUID = 1537797072;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_notificacion.
	 */
	private com.besixplus.sii.objects.Cgg_res_notificacion myCgg_res_notificacion = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_notificacion.
	 */
	public Cgg_res_notificacion(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_notificacion.
	 * @param inCgg_res_notificacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_notificacion.
	 */
	public Cgg_res_notificacion(
			com.besixplus.sii.objects.Cgg_res_notificacion inCgg_res_notificacion
			){
		this.setCgg_res_notificacion(inCgg_res_notificacion);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_notificacion.
	 * @param inCgg_res_notificacion OBJETO Cgg_res_notificacion.
	 * @return void
	 */
	public void setCgg_res_notificacion(com.besixplus.sii.objects.Cgg_res_notificacion inCgg_res_notificacion){
		this.myCgg_res_notificacion = inCgg_res_notificacion;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_notificacion.
	 * @return Cgg_res_notificacion OBJETO Cgg_res_notificacion.
	 */
	public com.besixplus.sii.objects.Cgg_res_notificacion getCgg_res_notificacion(){
		return this.myCgg_res_notificacion;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
			){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_notificacion().getCRNOT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_notificacion().getCRTNT_CODIGO());
			stmInsert.setString(4, this.getCgg_res_notificacion().getCRPER_CODIGO());
			stmInsert.setString(5, this.getCgg_res_notificacion().getCUSU_CODIGO());
			stmInsert.setString(6, this.getCgg_res_notificacion().getCGG_CUSU_CODIGO());
			stmInsert.setString(7, this.getCgg_res_notificacion().getCRRES_CODIGO());
			stmInsert.setString(8, this.getCgg_res_notificacion().getCRDEN_CODIGO());
			stmInsert.setString(9, this.getCgg_res_notificacion().getCCTN_CODIGO());
			stmInsert.setString(10, this.getCgg_res_notificacion().getCROSG_CODIGO());
			stmInsert.setString(11, this.getCgg_res_notificacion().getCGG_CROSG_CODIGO());
			stmInsert.setString(12, this.getCgg_res_notificacion().getCRNOT_NUMERO_NOTIFICACION());
			stmInsert.setTimestamp(13, new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_NOTIFICACION().getTime()));
			stmInsert.setString(14, this.getCgg_res_notificacion().getCRNOT_LUGAR_NOTIFICACION());
			stmInsert.setString(15, this.getCgg_res_notificacion().getCRNOT_REFERENCIA());
			stmInsert.setString(16, this.getCgg_res_notificacion().getCRNOT_OBSERVACION());
			stmInsert.setInt(17, this.getCgg_res_notificacion().getCRNOT_ESTADO_NOTIFICACION());
			stmInsert.setBoolean(18, this.getCgg_res_notificacion().getCRNOT_ESTADO());
			stmInsert.setString(19, this.getCgg_res_notificacion().getCRNOT_REGULARIZACION());
			stmInsert.setTimestamp(20, this.getCgg_res_notificacion().getCRNOT_FECHA_AUDIENCIA()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_AUDIENCIA().getTime()):null);
			stmInsert.setString(21, this.getCgg_res_notificacion().getCRNOT_EXTRACTO_AUDIENCIA());
			stmInsert.setString(22, this.getCgg_res_notificacion().getCRNOT_OBSERVACION_AUDIENCIA());
			stmInsert.setBoolean(23, this.getCgg_res_notificacion().getCRNOT_PROCEDE_NOTIFICACION());
			stmInsert.setString(24, this.getCgg_res_notificacion().getCRNOT_DESCRIPCION_ADJUNTO_AUD());
			stmInsert.setString(25, this.getCgg_res_notificacion().getCRNOT_NOMBRE_ADJUNTO_AUDIENCIA());
			stmInsert.setBytes(26, this.getCgg_res_notificacion().getCRNOT_ADJUNTO_AUDIENCIA());
			stmInsert.setTimestamp(27, this.getCgg_res_notificacion().getCRNOT_FECHA_SALIDA_VOLUNT()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_SALIDA_VOLUNT().getTime()):null);
			stmInsert.setTimestamp(28, this.getCgg_res_notificacion().getCRNOT_FECHA_EXPULSION()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_EXPULSION().getTime()):null);
			stmInsert.setString(29, this.getCgg_res_notificacion().getCRNOT_USUARIO_INSERT());
			stmInsert.setString(30, this.getCgg_res_notificacion().getCRNOT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_notificacion().setCRNOT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectAll(
			java.sql.Connection inConnection,
			String inUserName
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
			){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
			){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_notificacion().getCRNOT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_notificacion().getCRTNT_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_notificacion().getCRPER_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_notificacion().getCUSU_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_notificacion().getCGG_CUSU_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_notificacion().getCRRES_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_notificacion().getCRDEN_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_notificacion().getCCTN_CODIGO());
			stmUpdate.setString(9, this.getCgg_res_notificacion().getCROSG_CODIGO());
			stmUpdate.setString(10, this.getCgg_res_notificacion().getCGG_CROSG_CODIGO());
			stmUpdate.setString(11, this.getCgg_res_notificacion().getCRNOT_NUMERO_NOTIFICACION());
			stmUpdate.setTimestamp(12, new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_NOTIFICACION().getTime()));
			stmUpdate.setString(13, this.getCgg_res_notificacion().getCRNOT_LUGAR_NOTIFICACION());
			stmUpdate.setString(14, this.getCgg_res_notificacion().getCRNOT_REFERENCIA());
			stmUpdate.setString(15, this.getCgg_res_notificacion().getCRNOT_OBSERVACION());
			stmUpdate.setInt(16, this.getCgg_res_notificacion().getCRNOT_ESTADO_NOTIFICACION());
			stmUpdate.setBoolean(17, this.getCgg_res_notificacion().getCRNOT_ESTADO());
			stmUpdate.setString(18, this.getCgg_res_notificacion().getCRNOT_REGULARIZACION());
			stmUpdate.setTimestamp(19, this.getCgg_res_notificacion().getCRNOT_FECHA_AUDIENCIA()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_AUDIENCIA().getTime()):null);
			stmUpdate.setString(20, this.getCgg_res_notificacion().getCRNOT_EXTRACTO_AUDIENCIA());
			stmUpdate.setString(21, this.getCgg_res_notificacion().getCRNOT_OBSERVACION_AUDIENCIA());
			stmUpdate.setBoolean(22, this.getCgg_res_notificacion().getCRNOT_PROCEDE_NOTIFICACION());
			stmUpdate.setString(23, this.getCgg_res_notificacion().getCRNOT_DESCRIPCION_ADJUNTO_AUD());
			stmUpdate.setString(24, this.getCgg_res_notificacion().getCRNOT_NOMBRE_ADJUNTO_AUDIENCIA());
			stmUpdate.setBytes(25, this.getCgg_res_notificacion().getCRNOT_ADJUNTO_AUDIENCIA());
			stmUpdate.setTimestamp(26, this.getCgg_res_notificacion().getCRNOT_FECHA_SALIDA_VOLUNT()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_SALIDA_VOLUNT().getTime()):null);
			stmUpdate.setTimestamp(27, this.getCgg_res_notificacion().getCRNOT_FECHA_EXPULSION()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_EXPULSION().getTime()):null);
			stmUpdate.setString(28, this.getCgg_res_notificacion().getCRNOT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_notificacion select(
			java.sql.Connection inConnection
			){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCRNOT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_notificacion().setCRNOT_CODIGO(results.getString(1));
				this.getCgg_res_notificacion().setCRTNT_CODIGO(results.getString(2));
				this.getCgg_res_notificacion().setCRPER_CODIGO(results.getString(3));
				this.getCgg_res_notificacion().setCUSU_CODIGO(results.getString(4));
				this.getCgg_res_notificacion().setCGG_CUSU_CODIGO(results.getString(5));
				this.getCgg_res_notificacion().setCRRES_CODIGO(results.getString(6));
				this.getCgg_res_notificacion().setCRDEN_CODIGO(results.getString(7));
				this.getCgg_res_notificacion().setCCTN_CODIGO(results.getString(8));
				this.getCgg_res_notificacion().setCROSG_CODIGO(results.getString(9));
				this.getCgg_res_notificacion().setCGG_CROSG_CODIGO(results.getString(10));
				this.getCgg_res_notificacion().setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				this.getCgg_res_notificacion().setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				this.getCgg_res_notificacion().setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				this.getCgg_res_notificacion().setCRNOT_REFERENCIA(results.getString(14));
				this.getCgg_res_notificacion().setCRNOT_OBSERVACION(results.getString(15));
				this.getCgg_res_notificacion().setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				this.getCgg_res_notificacion().setCRNOT_ESTADO(results.getBoolean(17));
				this.getCgg_res_notificacion().setCRNOT_REGULARIZACION(results.getString(18));
				this.getCgg_res_notificacion().setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				this.getCgg_res_notificacion().setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				this.getCgg_res_notificacion().setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				this.getCgg_res_notificacion().setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				this.getCgg_res_notificacion().setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				this.getCgg_res_notificacion().setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				this.getCgg_res_notificacion().setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				this.getCgg_res_notificacion().setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				this.getCgg_res_notificacion().setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_notificacion();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCRNOT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCRNOT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_RES_RESOLUCION(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_RES_RESOLUCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCRRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_RES_RESOLUCION(?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCRRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_RES_RESOLUCION(?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCRRES_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_CANTON(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCCTN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_denuncia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_RES_DENUNCIA(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_RES_DENUNCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCRDEN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_denuncia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_DENUNCIA(
			java.sql.Connection inConnection
			){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_RES_DENUNCIA(?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCRDEN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_RES_DENUNCIA(?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCRDEN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_oficial_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_RES_OFICIAL_SEGUIMIENTO(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_RES_OFICIAL_SEGUIMIENTO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCROSG_CODIGO());
			stmSelect.setString(3,this.getCgg_res_notificacion().getCGG_CROSG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_oficial_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_OFICIAL_SEGUIMIENTO(
			java.sql.Connection inConnection
			){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_RES_OFICIAL_SEGUIMIENTO(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCROSG_CODIGO());
			stmDelete.setString(2, this.getCgg_res_notificacion().getCGG_CROSG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_RES_OFICIAL_SEGUIMIENTO(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCROSG_CODIGO());
				stmDelete.setString(2, this.getCgg_res_notificacion().getCGG_CROSG_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCRPER_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_RES_TIPO_NOTIFICACION(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_RES_TIPO_NOTIFICACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCRTNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_TIPO_NOTIFICACION(
			java.sql.Connection inConnection
			){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_RES_TIPO_NOTIFICACION(?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCRTNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_RES_TIPO_NOTIFICACION(?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCRTNT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> selectCGG_USUARIO(
			java.sql.Connection inConnection
			){
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> outCgg_res_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCUSU_CODIGO());
			stmSelect.setString(3,this.getCgg_res_notificacion().getCGG_CUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_notificacion tmpCgg_res_notificacion = new com.besixplus.sii.objects.Cgg_res_notificacion();
				tmpCgg_res_notificacion.setCRNOT_CODIGO(results.getString(1));
				tmpCgg_res_notificacion.setCRTNT_CODIGO(results.getString(2));
				tmpCgg_res_notificacion.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_notificacion.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_notificacion.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_res_notificacion.setCRRES_CODIGO(results.getString(6));
				tmpCgg_res_notificacion.setCRDEN_CODIGO(results.getString(7));
				tmpCgg_res_notificacion.setCCTN_CODIGO(results.getString(8));
				tmpCgg_res_notificacion.setCROSG_CODIGO(results.getString(9));
				tmpCgg_res_notificacion.setCGG_CROSG_CODIGO(results.getString(10));
				tmpCgg_res_notificacion.setCRNOT_NUMERO_NOTIFICACION(results.getString(11));
				tmpCgg_res_notificacion.setCRNOT_FECHA_NOTIFICACION(results.getTimestamp(12));
				tmpCgg_res_notificacion.setCRNOT_LUGAR_NOTIFICACION(results.getString(13));
				tmpCgg_res_notificacion.setCRNOT_REFERENCIA(results.getString(14));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION(results.getString(15));
				tmpCgg_res_notificacion.setCRNOT_ESTADO_NOTIFICACION(results.getInt(16));
				tmpCgg_res_notificacion.setCRNOT_ESTADO(results.getBoolean(17));
				tmpCgg_res_notificacion.setCRNOT_REGULARIZACION(results.getString(18));
				tmpCgg_res_notificacion.setCRNOT_FECHA_AUDIENCIA(results.getTimestamp(19));
				tmpCgg_res_notificacion.setCRNOT_EXTRACTO_AUDIENCIA(results.getString(20));
				tmpCgg_res_notificacion.setCRNOT_OBSERVACION_AUDIENCIA(results.getString(21));
				tmpCgg_res_notificacion.setCRNOT_PROCEDE_NOTIFICACION(results.getBoolean(22));
				tmpCgg_res_notificacion.setCRNOT_DESCRIPCION_ADJUNTO_AUD(results.getString(23));
				tmpCgg_res_notificacion.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(results.getString(24));
				tmpCgg_res_notificacion.setCRNOT_ADJUNTO_AUDIENCIA(results.getBytes(25));
				tmpCgg_res_notificacion.setCRNOT_FECHA_SALIDA_VOLUNT(results.getTimestamp(26));
				tmpCgg_res_notificacion.setCRNOT_FECHA_EXPULSION(results.getTimestamp(27));
				outCgg_res_notificacion.add(tmpCgg_res_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_notificacion().getCUSU_CODIGO());
			stmDelete.setString(2, this.getCgg_res_notificacion().getCGG_CUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_notificacion().getCUSU_CODIGO());
				stmDelete.setString(2, this.getCgg_res_notificacion().getCGG_CUSU_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectNotificacionConsulta(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
			){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_notificacion_s_consu(?,?,?,?,?,?) }");
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
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectNotificacionCount(
			java.sql.Connection inConnection,
			String inKeyword
			){
		int outCount = 0;		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_notificacion_s_consu_count(?) }");
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
	 * GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_res_notificacion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static String geneNumNotificacion(
			java.sql.Connection inConnection
			){
		String valorRetorno=null;
		try{

			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_NOTIFICACION() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
	/**
	 * TIEMPO MAXIMO DE DIAS PARA PRESENTARSE AUDIENCIA Cgg_res_notificacion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param incrnot_codigo IDENTIFICATIVO DE REGISTRO NOTIFICACION
	 *@return 
	 */
	public boolean timpoMaximoAudiencia(
			java.sql.Connection inConnection
			){
		boolean tiempoaud=true;
		try{

			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tiempo_maximo_audiencia(?) }");
			stmSelect.registerOutParameter(1, Types.BOOLEAN);
			stmSelect.setString(2,this.getCgg_res_notificacion().getCRNOT_CODIGO());
			stmSelect.execute();
			tiempoaud= stmSelect.getBoolean(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return tiempoaud;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona,Cgg_res_movilidad,Cgg_res_residencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectNotificacionConsultaNoResidente(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
			){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_notificacion_no_residencia_select(?,?,?,?,?,?) }");
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
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectNotificacionNoResidenteCount(
			java.sql.Connection inConnection,
			String inKeyword
			){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_notificacion_no_residencia_select_count(?) }");
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
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_movilidad,cgg_res_residencia,cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */



	public static ArrayList<HashMap<String,Object>> selectPersonaSelectNoResidente(
			java.sql.Connection inConnection,
			String inCrper_num_doc_identific

			){
		ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_num_doc_no_residente(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_num_doc_identific);
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_denuncia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateNotificacionMovi(
			java.sql.Connection inConnection
			){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.f_cgg_res_notificacion_update_movilidad(?,?::smallint,?,?,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_notificacion().getCRNOT_CODIGO());
			stmUpdate.setInt(2, this.getCgg_res_notificacion().getCRNOT_ESTADO_NOTIFICACION());
			stmUpdate.setTimestamp(3, this.getCgg_res_notificacion().getCRNOT_FECHA_SALIDA_VOLUNT()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_SALIDA_VOLUNT().getTime()):null);
			stmUpdate.setTimestamp(4, this.getCgg_res_notificacion().getCRNOT_FECHA_EXPULSION()!=null?new java.sql.Timestamp(this.getCgg_res_notificacion().getCRNOT_FECHA_EXPULSION().getTime()):null);
			stmUpdate.setBoolean(5, this.getCgg_res_notificacion().getCRNOT_ESTADO());
			stmUpdate.setString(6, this.getCgg_res_notificacion().getCRNOT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult ="false";
		}
		return outResult;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_resolucion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectResolucion(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
			){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_resolucion_select_notificacion(?,?,?,?,?,?) }");
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
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectResolucionCount(
			java.sql.Connection inConnection,
			String inKeyword
			){
		int outCount = 0;		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_resolucion_select_notificacion_count(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_oficial_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectOficialseguimiento(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
			){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_JEFE(?,?,?,?,?,?) }");
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
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectOficialseguimientoCount(
			java.sql.Connection inConnection,
			String inKeyword
			){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_JEFE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoNotificacion(
			java.sql.Connection inConnection
			){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_NOTIFICACION_ESTADO_UPDATE( ?,?::smallint,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_notificacion().getCRNOT_CODIGO());
			stmUpdate.setInt(2, this.getCgg_res_notificacion().getCRNOT_ESTADO_NOTIFICACION());	
			stmUpdate.setString(3, this.getCgg_res_notificacion().getCRNOT_OBSERVACION());	
			stmUpdate.setString(4, this.getCgg_res_notificacion().getCRNOT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_movilidad,cgg_res_residencia,cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersonaSelectoff(
			java.sql.Connection inConnection,
			String in_user_name,
			String in_Canton

			){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOTIFICACION_OFFLINE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, in_user_name);
			stmSelect.setString(3, in_Canton);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_oficial_seguimiento.
	 * @param inConnection Conexion a base de datos.
	 * @param in_user_name Nombre de usuario.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectOficialSelectoff(
			java.sql.Connection inConnection,
			String in_user_name
			){
		ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_SEGUIMIENTO_USUARIO_OFFLINE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, in_user_name);
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

}