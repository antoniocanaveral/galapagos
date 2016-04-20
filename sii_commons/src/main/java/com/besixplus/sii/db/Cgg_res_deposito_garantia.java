package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

import org.postgresql.jdbc4.Jdbc4Array;

/**
 * CLASE Cgg_res_deposito_garantia
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_deposito_garantia.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_deposito_garantia implements Serializable{
	private static final long serialVersionUID = 146883567;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_deposito_garantia.
	 */
	private com.besixplus.sii.objects.Cgg_res_deposito_garantia myCgg_res_deposito_garantia = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_deposito_garantia.
	 */
	public Cgg_res_deposito_garantia(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_deposito_garantia.
	 * @param inCgg_res_deposito_garantia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_deposito_garantia.
	 */
	public Cgg_res_deposito_garantia(
			com.besixplus.sii.objects.Cgg_res_deposito_garantia inCgg_res_deposito_garantia
	){
		this.setCgg_res_deposito_garantia(inCgg_res_deposito_garantia);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_deposito_garantia.
	 * @param inCgg_res_deposito_garantia OBJETO Cgg_res_deposito_garantia.
	 * @return void
	 */
	public void setCgg_res_deposito_garantia(com.besixplus.sii.objects.Cgg_res_deposito_garantia inCgg_res_deposito_garantia){
		this.myCgg_res_deposito_garantia = inCgg_res_deposito_garantia;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_deposito_garantia.
	 * @return Cgg_res_deposito_garantia OBJETO Cgg_res_deposito_garantia.
	 */
	public com.besixplus.sii.objects.Cgg_res_deposito_garantia getCgg_res_deposito_garantia(){
		return this.myCgg_res_deposito_garantia;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_deposito_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_INSERT(?,?,?,?,?,?,?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_deposito_garantia().getCRCPJ_CODIGO());
			stmInsert.setString(4, this.getCgg_res_deposito_garantia().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_res_deposito_garantia().getCRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_deposito_garantia().getCGG_CRPJR_CODIGO());
			stmInsert.setString(7, this.getCgg_res_deposito_garantia().getCRDPT_NUMERO());
			stmInsert.setString(8, this.getCgg_res_deposito_garantia().getCRDPT_NUMERO_DOCUMENTO());
			stmInsert.setBoolean(9, this.getCgg_res_deposito_garantia().getCRDPT_CADUCA());
			stmInsert.setInt(10, this.getCgg_res_deposito_garantia().getCRDPT_TIPO());
			stmInsert.setBigDecimal(11, this.getCgg_res_deposito_garantia().getCRDPT_VALOR_DEPOSITO());
			stmInsert.setTimestamp(12, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEPOSITO()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEPOSITO().getTime()):null);
			stmInsert.setTimestamp(13, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_ENTREGA()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_ENTREGA().getTime()):null);
			stmInsert.setTimestamp(14, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CADUCIDAD()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CADUCIDAD().getTime()):null);
			stmInsert.setTimestamp(15, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CONTABILIZACION()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CONTABILIZACION().getTime()):null);
			stmInsert.setTimestamp(16, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_SOLIC_DEVOLUCION()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_SOLIC_DEVOLUCION().getTime()):null);
			stmInsert.setTimestamp(17, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEVOLUCION_DEFINITI()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEVOLUCION_DEFINITI().getTime()):null);
			stmInsert.setBoolean(18, this.getCgg_res_deposito_garantia().getCRDPT_DEVUELTO());
			stmInsert.setInt(19, this.getCgg_res_deposito_garantia().getCRDPT_ESTADO_DEPOSITO());
			stmInsert.setString(20, this.getCgg_res_deposito_garantia().getCRDPT_OBSERVACION());
			stmInsert.setBoolean(21, this.getCgg_res_deposito_garantia().getCRDPT_ESTADO());
			stmInsert.setString(22, this.getCgg_res_deposito_garantia().getCRDPT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_deposito_garantia().setCRDPT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> outCgg_res_deposito_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_deposito_garantia tmpCgg_res_deposito_garantia = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
				tmpCgg_res_deposito_garantia.setCRDPT_CODIGO(results.getString(1));
				tmpCgg_res_deposito_garantia.setCRCPJ_CODIGO(results.getString(2));
				tmpCgg_res_deposito_garantia.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_deposito_garantia.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_deposito_garantia.setCGG_CRPJR_CODIGO(results.getString(5));
				tmpCgg_res_deposito_garantia.setCRDPT_NUMERO(results.getString(6));
				tmpCgg_res_deposito_garantia.setCRDPT_NUMERO_DOCUMENTO(results.getString(7));
				tmpCgg_res_deposito_garantia.setCRDPT_CADUCA(results.getBoolean(8));
				tmpCgg_res_deposito_garantia.setCRDPT_TIPO(results.getInt(9));
				tmpCgg_res_deposito_garantia.setCRDPT_VALOR_DEPOSITO(results.getBigDecimal(10));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_ENTREGA(results.getTimestamp(12));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_CADUCIDAD(results.getTimestamp(13));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_CONTABILIZACION(results.getTimestamp(14));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_SOLIC_DEVOLUCION(results.getTimestamp(15));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_DEVOLUCION_DEFINITI(results.getTimestamp(16));
				tmpCgg_res_deposito_garantia.setCRDPT_DEVUELTO(results.getBoolean(17));
				tmpCgg_res_deposito_garantia.setCRDPT_ESTADO_DEPOSITO(results.getInt(18));
				tmpCgg_res_deposito_garantia.setCRDPT_OBSERVACION(results.getString(19));
				tmpCgg_res_deposito_garantia.setCRDPT_ESTADO(results.getBoolean(20));
				outCgg_res_deposito_garantia.add(tmpCgg_res_deposito_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_deposito_garantia;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> outCgg_res_deposito_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_deposito_garantia tmpCgg_res_deposito_garantia = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
				tmpCgg_res_deposito_garantia.setCRDPT_CODIGO(results.getString(1));
				tmpCgg_res_deposito_garantia.setCRCPJ_CODIGO(results.getString(2));
				tmpCgg_res_deposito_garantia.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_deposito_garantia.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_deposito_garantia.setCGG_CRPJR_CODIGO(results.getString(5));
				tmpCgg_res_deposito_garantia.setCRDPT_NUMERO(results.getString(6));
				tmpCgg_res_deposito_garantia.setCRDPT_NUMERO_DOCUMENTO(results.getString(7));
				tmpCgg_res_deposito_garantia.setCRDPT_CADUCA(results.getBoolean(8));
				tmpCgg_res_deposito_garantia.setCRDPT_TIPO(results.getInt(9));
				tmpCgg_res_deposito_garantia.setCRDPT_VALOR_DEPOSITO(results.getBigDecimal(10));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_ENTREGA(results.getTimestamp(12));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_CADUCIDAD(results.getTimestamp(13));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_CONTABILIZACION(results.getTimestamp(14));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_SOLIC_DEVOLUCION(results.getTimestamp(15));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_DEVOLUCION_DEFINITI(results.getTimestamp(16));
				tmpCgg_res_deposito_garantia.setCRDPT_DEVUELTO(results.getBoolean(17));
				tmpCgg_res_deposito_garantia.setCRDPT_ESTADO_DEPOSITO(results.getInt(18));
				tmpCgg_res_deposito_garantia.setCRDPT_OBSERVACION(results.getString(19));
				tmpCgg_res_deposito_garantia.setCRDPT_ESTADO(results.getBoolean(20));
				outCgg_res_deposito_garantia.add(tmpCgg_res_deposito_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_deposito_garantia;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inDisponibles IDENTIFICADOR DE DISPONIBILIDAD.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			boolean inDisponibles
	){
		ArrayList<HashMap<String,Object>> outCgg_res_deposito_garantia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setBoolean(8, inDisponibles);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_deposito_garantia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_deposito_garantia;
	}
	
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inDisponibles IDENTIFICATIVO DE DISPONIBILIDAD.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword,
			boolean inDisponibles
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setBoolean(3, inDisponibles);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_deposito_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_DEPOSITO_GARANTIA_UPDATE(?,?,?,?,?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_deposito_garantia().getCRCPJ_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_deposito_garantia().getCRPJR_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_deposito_garantia().getCRPER_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_deposito_garantia().getCGG_CRPJR_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_deposito_garantia().getCRDPT_NUMERO());
			stmUpdate.setString(7, this.getCgg_res_deposito_garantia().getCRDPT_NUMERO_DOCUMENTO());
			stmUpdate.setBoolean(8, this.getCgg_res_deposito_garantia().getCRDPT_CADUCA());
			stmUpdate.setInt(9, this.getCgg_res_deposito_garantia().getCRDPT_TIPO());
			stmUpdate.setBigDecimal(10, this.getCgg_res_deposito_garantia().getCRDPT_VALOR_DEPOSITO());
			stmUpdate.setTimestamp(11, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEPOSITO()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEPOSITO().getTime()):null);
			stmUpdate.setTimestamp(12, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_ENTREGA()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_ENTREGA().getTime()):null);
			stmUpdate.setTimestamp(13, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CADUCIDAD()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CADUCIDAD().getTime()):null);
			stmUpdate.setTimestamp(14, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CONTABILIZACION()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_CONTABILIZACION().getTime()):null);
			stmUpdate.setTimestamp(15, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_SOLIC_DEVOLUCION()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_SOLIC_DEVOLUCION().getTime()):null);
			stmUpdate.setTimestamp(16, this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEVOLUCION_DEFINITI()!=null?new java.sql.Timestamp(this.getCgg_res_deposito_garantia().getCRDPT_FECHA_DEVOLUCION_DEFINITI().getTime()):null);
			stmUpdate.setBoolean(17, this.getCgg_res_deposito_garantia().getCRDPT_DEVUELTO());
			stmUpdate.setInt(18, this.getCgg_res_deposito_garantia().getCRDPT_ESTADO_DEPOSITO());
			stmUpdate.setString(19, this.getCgg_res_deposito_garantia().getCRDPT_OBSERVACION());
			stmUpdate.setBoolean(20, this.getCgg_res_deposito_garantia().getCRDPT_ESTADO());
			stmUpdate.setString(21, this.getCgg_res_deposito_garantia().getCRDPT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_deposito_garantia DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_deposito_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_deposito_garantia select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_deposito_garantia().setCRDPT_CODIGO(results.getString(1));
				this.getCgg_res_deposito_garantia().setCRCPJ_CODIGO(results.getString(2));
				this.getCgg_res_deposito_garantia().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_res_deposito_garantia().setCRPER_CODIGO(results.getString(5));
				this.getCgg_res_deposito_garantia().setCGG_CRPJR_CODIGO(results.getString(6));
				this.getCgg_res_deposito_garantia().setCRDPT_NUMERO(results.getString(6));
				this.getCgg_res_deposito_garantia().setCRDPT_NUMERO_DOCUMENTO(results.getString(7));
				this.getCgg_res_deposito_garantia().setCRDPT_CADUCA(results.getBoolean(8));
				this.getCgg_res_deposito_garantia().setCRDPT_TIPO(results.getInt(9));
				this.getCgg_res_deposito_garantia().setCRDPT_VALOR_DEPOSITO(results.getBigDecimal(10));
				this.getCgg_res_deposito_garantia().setCRDPT_FECHA_DEPOSITO(results.getTimestamp(11));
				this.getCgg_res_deposito_garantia().setCRDPT_FECHA_ENTREGA(results.getTimestamp(12));
				this.getCgg_res_deposito_garantia().setCRDPT_FECHA_CADUCIDAD(results.getTimestamp(13));
				this.getCgg_res_deposito_garantia().setCRDPT_FECHA_CONTABILIZACION(results.getTimestamp(14));
				this.getCgg_res_deposito_garantia().setCRDPT_FECHA_SOLIC_DEVOLUCION(results.getTimestamp(15));
				this.getCgg_res_deposito_garantia().setCRDPT_FECHA_DEVOLUCION_DEFINITI(results.getTimestamp(16));
				this.getCgg_res_deposito_garantia().setCRDPT_DEVUELTO(results.getBoolean(17));
				this.getCgg_res_deposito_garantia().setCRDPT_ESTADO_DEPOSITO(results.getInt(18));
				this.getCgg_res_deposito_garantia().setCRDPT_OBSERVACION(results.getString(19));
				this.getCgg_res_deposito_garantia().setCRDPT_ESTADO(results.getBoolean(20));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_deposito_garantia();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_deposito_garantia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DEPOSITO_GARANTIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DEPOSITO_GARANTIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_cuenta_personajuridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_deposito_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> selectCGG_RES_CUENTA_PERSONAJURIDICA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> outCgg_res_deposito_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DEPOSITO_GARANTIA_S_CGG_RES_CUENTA_PERSONAJURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_deposito_garantia().getCRCPJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_deposito_garantia tmpCgg_res_deposito_garantia = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
				tmpCgg_res_deposito_garantia.setCRDPT_CODIGO(results.getString(1));
				tmpCgg_res_deposito_garantia.setCRCPJ_CODIGO(results.getString(2));
				tmpCgg_res_deposito_garantia.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_deposito_garantia.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_deposito_garantia.setCGG_CRPJR_CODIGO(results.getString(5));
				tmpCgg_res_deposito_garantia.setCRDPT_NUMERO(results.getString(6));
				tmpCgg_res_deposito_garantia.setCRDPT_NUMERO_DOCUMENTO(results.getString(7));
				tmpCgg_res_deposito_garantia.setCRDPT_CADUCA(results.getBoolean(8));
				tmpCgg_res_deposito_garantia.setCRDPT_TIPO(results.getInt(9));
				tmpCgg_res_deposito_garantia.setCRDPT_VALOR_DEPOSITO(results.getBigDecimal(10));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_ENTREGA(results.getTimestamp(12));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_CADUCIDAD(results.getTimestamp(13));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_CONTABILIZACION(results.getTimestamp(14));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_SOLIC_DEVOLUCION(results.getTimestamp(15));
				tmpCgg_res_deposito_garantia.setCRDPT_FECHA_DEVOLUCION_DEFINITI(results.getTimestamp(16));
				tmpCgg_res_deposito_garantia.setCRDPT_DEVUELTO(results.getBoolean(17));
				tmpCgg_res_deposito_garantia.setCRDPT_ESTADO_DEPOSITO(results.getInt(18));
				tmpCgg_res_deposito_garantia.setCRDPT_OBSERVACION(results.getString(19));
				tmpCgg_res_deposito_garantia.setCRDPT_ESTADO(results.getBoolean(20));
				outCgg_res_deposito_garantia.add(tmpCgg_res_deposito_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_deposito_garantia;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_cuenta_personajuridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_CUENTA_PERSONAJURIDICA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DEPOSITO_GARANTIA_D_CGG_RES_CUENTA_PERSONAJURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_res_deposito_garantia().getCRCPJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DEPOSITO_GARANTIA_DS_CGG_RES_CUENTA_PERSONAJURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_res_deposito_garantia().getCRCPJ_CODIGO());
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
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_deposito_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName  NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return com.besixplus.sii.objects.Cgg_res_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>> selectCGG_RES_DEPOSITO_GARANTIA(
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRM_S_CGG_RES_DPS_GRN(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
			stmSelect.setString(3, inUserName);
			stmSelect.setInt(4, inStart);
			stmSelect.setInt(5, inLimit);
			stmSelect.setString(6, inSortFieldName);
			stmSelect.setString(7, inDirection);
			stmSelect.setString(8, inKeyword);
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
	public int selectCountCGG_RES_DEPOSITO_GARANTIA(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRM_S_CGG_RES_DPS_GRN_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, this.getCgg_res_deposito_garantia().getCRDPT_CODIGO());
			stmSelect.setString(3, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * VERIFICA SI SE AUTORIZA LA DEVOLUCION DE UNA GARANTIA
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE.
	 * @param inTodo IDENTIFICATIVO DE SI SE AUTORIZA LA DEVOLUCION EN SU TOTALIDAD.
	 * @param inVerificar IDENTIFICATIVO DE AUTORIZADO O NO DE LA DEVOLUCION. 
	 * @return ARRAY DE MENSAJES POR LA QUE NO SE PUEDE HACER LA DEVOLUCION 
	 */
	public ArrayList<String> selectDevolucionGarantia(
			Connection inConnection,
			String inUserName,
			String inCrtra_codigo,
			boolean inTodo,
			boolean inVerificar
	){
		ArrayList<String> outMessages = new ArrayList<String>();
		String[] tmpMsg = null; 
		try {
			CallableStatement tmpStmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_DEPOSITO_GARANTIA_DEVOLUCION(?,?,?,?) }");
			tmpStmSelect.registerOutParameter(1, Types.ARRAY);
			tmpStmSelect.setString(2, inUserName);
			tmpStmSelect.setString(3, inCrtra_codigo);
			tmpStmSelect.setBoolean(4, inTodo);
			tmpStmSelect.setBoolean(5, inVerificar);
			tmpStmSelect.execute();
			if(tmpStmSelect.getObject(1)!= null){
				tmpMsg = ((String[])((Jdbc4Array)tmpStmSelect.getObject(1)).getArray());
				tmpStmSelect.close();

				for (String tmpM : tmpMsg) {
					outMessages.add(tmpM);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			outMessages.add(e.getMessage());
		}
		return outMessages;
	}
}