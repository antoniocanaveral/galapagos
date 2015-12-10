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
* CLASE Cgg_res_carnet
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_carnet.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_carnet implements Serializable{
	private static final long serialVersionUID = 1149402091;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_carnet.
	*/
	private com.besixplus.sii.objects.Cgg_res_carnet myCgg_res_carnet = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_carnet.
	*/
	public Cgg_res_carnet(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_carnet.
	* @param inCgg_res_carnet OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_carnet.
	*/
	public Cgg_res_carnet(
		com.besixplus.sii.objects.Cgg_res_carnet inCgg_res_carnet
	){
		this.setCgg_res_carnet(inCgg_res_carnet);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_carnet.
	* @param inCgg_res_carnet OBJETO Cgg_res_carnet.
	* @return void
	*/
	public void setCgg_res_carnet(com.besixplus.sii.objects.Cgg_res_carnet inCgg_res_carnet){
		this.myCgg_res_carnet = inCgg_res_carnet;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_carnet.
	* @return Cgg_res_carnet OBJETO Cgg_res_carnet.
	*/
	public com.besixplus.sii.objects.Cgg_res_carnet getCgg_res_carnet(){
		return this.myCgg_res_carnet;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_carnet.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_carnet().getCRCNT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_carnet().getCRCOM_CODIGO());
			stmInsert.setString(4, this.getCgg_res_carnet().getCRADJ_CODIGO());
			stmInsert.setString(5, this.getCgg_res_carnet().getCRRSD_CODIGO());
			stmInsert.setString(6, this.getCgg_res_carnet().getCRCPJ_CODIGO());
			stmInsert.setString(7, this.getCgg_res_carnet().getCRCNT_SERIE());
			stmInsert.setInt(8, this.getCgg_res_carnet().getCRCNT_MOTIVO());
			stmInsert.setTimestamp(9, this.getCgg_res_carnet().getCRCNT_FECHA_EMISION()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_EMISION().getTime()):null);
			stmInsert.setTimestamp(10, this.getCgg_res_carnet().getCRCNT_FECHA_APROBACION()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_APROBACION().getTime()):null);
			stmInsert.setTimestamp(11, this.getCgg_res_carnet().getCRCNT_FECHA_CADUCIDAD()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_CADUCIDAD().getTime()):null);
			stmInsert.setTimestamp(12, this.getCgg_res_carnet().getCRCNT_FECHA_DEPOSITO()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_DEPOSITO().getTime()):null);
			stmInsert.setBoolean(13, this.getCgg_res_carnet().getCRCNT_CARNET_IMPRESO());
			stmInsert.setString(14, this.getCgg_res_carnet().getCRCNT_NUMERO_COMP());
			stmInsert.setBigDecimal(15, this.getCgg_res_carnet().getCRCNT_VALOR());
			stmInsert.setString(16, this.getCgg_res_carnet().getCRCNT_OBSERVACION());
			stmInsert.setBoolean(17, this.getCgg_res_carnet().getCRCNT_ESTADO());
			stmInsert.setString(18, this.getCgg_res_carnet().getCRCNT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_carnet().setCRCNT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_carnet.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> outCgg_res_carnet = new ArrayList<com.besixplus.sii.objects.Cgg_res_carnet>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_carnet tmpCgg_res_carnet = new com.besixplus.sii.objects.Cgg_res_carnet();
				tmpCgg_res_carnet.setCRCNT_CODIGO(results.getString(1));
				tmpCgg_res_carnet.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_carnet.setCRADJ_CODIGO(results.getString(3));
				tmpCgg_res_carnet.setCRRSD_CODIGO(results.getString(4));
				tmpCgg_res_carnet.setCRCPJ_CODIGO(results.getString(5));
				tmpCgg_res_carnet.setCRCNT_SERIE(results.getString(6));
				tmpCgg_res_carnet.setCRCNT_MOTIVO(results.getInt(7));
				tmpCgg_res_carnet.setCRCNT_FECHA_EMISION(results.getTimestamp(8));
				tmpCgg_res_carnet.setCRCNT_FECHA_APROBACION(results.getTimestamp(9));
				tmpCgg_res_carnet.setCRCNT_FECHA_CADUCIDAD(results.getTimestamp(10));
				tmpCgg_res_carnet.setCRCNT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_carnet.setCRCNT_CARNET_IMPRESO(results.getBoolean(12));
				tmpCgg_res_carnet.setCRCNT_NUMERO_COMP(results.getString(13));
				tmpCgg_res_carnet.setCRCNT_VALOR(results.getBigDecimal(14));
				tmpCgg_res_carnet.setCRCNT_OBSERVACION(results.getString(15));
				tmpCgg_res_carnet.setCRCNT_ESTADO(results.getBoolean(16));
				outCgg_res_carnet.add(tmpCgg_res_carnet);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_carnet;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_carnet QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> outCgg_res_carnet = new ArrayList<com.besixplus.sii.objects.Cgg_res_carnet>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_carnet tmpCgg_res_carnet = new com.besixplus.sii.objects.Cgg_res_carnet();
				tmpCgg_res_carnet.setCRCNT_CODIGO(results.getString(1));
				tmpCgg_res_carnet.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_carnet.setCRADJ_CODIGO(results.getString(3));
				tmpCgg_res_carnet.setCRRSD_CODIGO(results.getString(4));
				tmpCgg_res_carnet.setCRCPJ_CODIGO(results.getString(5));
				tmpCgg_res_carnet.setCRCNT_SERIE(results.getString(6));
				tmpCgg_res_carnet.setCRCNT_MOTIVO(results.getInt(7));
				tmpCgg_res_carnet.setCRCNT_FECHA_EMISION(results.getTimestamp(8));
				tmpCgg_res_carnet.setCRCNT_FECHA_APROBACION(results.getTimestamp(9));
				tmpCgg_res_carnet.setCRCNT_FECHA_CADUCIDAD(results.getTimestamp(10));
				tmpCgg_res_carnet.setCRCNT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_carnet.setCRCNT_CARNET_IMPRESO(results.getBoolean(12));
				tmpCgg_res_carnet.setCRCNT_NUMERO_COMP(results.getString(13));
				tmpCgg_res_carnet.setCRCNT_VALOR(results.getBigDecimal(14));
				tmpCgg_res_carnet.setCRCNT_OBSERVACION(results.getString(15));
				tmpCgg_res_carnet.setCRCNT_ESTADO(results.getBoolean(16));
				outCgg_res_carnet.add(tmpCgg_res_carnet);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_carnet;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_carnet QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrrsd_codigo CODIGO DE LA RESIDENCIA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCrrsd_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_carnet = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrrsd_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_carnet.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_carnet;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_carnet.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_COUNT() }");
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
	* @param inCrrsd_codigo CODIGO DE LA RESIDENCIA
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrrsd_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrrsd_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_carnet.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_carnet().getCRCNT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_carnet().getCRCOM_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_carnet().getCRADJ_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_carnet().getCRRSD_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_carnet().getCRCPJ_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_carnet().getCRCNT_SERIE());
			stmUpdate.setInt(7, this.getCgg_res_carnet().getCRCNT_MOTIVO());
			stmUpdate.setTimestamp(8, this.getCgg_res_carnet().getCRCNT_FECHA_EMISION()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_EMISION().getTime()):null);
			stmUpdate.setTimestamp(9, this.getCgg_res_carnet().getCRCNT_FECHA_APROBACION()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_APROBACION().getTime()):null);
			stmUpdate.setTimestamp(10, this.getCgg_res_carnet().getCRCNT_FECHA_CADUCIDAD()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_CADUCIDAD().getTime()):null);
			stmUpdate.setTimestamp(11, this.getCgg_res_carnet().getCRCNT_FECHA_DEPOSITO()!=null?new java.sql.Timestamp(this.getCgg_res_carnet().getCRCNT_FECHA_DEPOSITO().getTime()):null);
			stmUpdate.setBoolean(12, this.getCgg_res_carnet().getCRCNT_CARNET_IMPRESO());
			stmUpdate.setString(13, this.getCgg_res_carnet().getCRCNT_NUMERO_COMP());
			stmUpdate.setBigDecimal(14, this.getCgg_res_carnet().getCRCNT_VALOR());
			stmUpdate.setString(15, this.getCgg_res_carnet().getCRCNT_OBSERVACION());
			stmUpdate.setBoolean(16, this.getCgg_res_carnet().getCRCNT_ESTADO());
			stmUpdate.setString(17, this.getCgg_res_carnet().getCRCNT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_carnet DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_carnet OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_carnet select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_carnet().getCRCNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_carnet().setCRCNT_CODIGO(results.getString(1));
				this.getCgg_res_carnet().setCRCOM_CODIGO(results.getString(2));
				this.getCgg_res_carnet().setCRADJ_CODIGO(results.getString(3));
				this.getCgg_res_carnet().setCRRSD_CODIGO(results.getString(4));
				this.getCgg_res_carnet().setCRCPJ_CODIGO(results.getString(5));
				this.getCgg_res_carnet().setCRCNT_SERIE(results.getString(6));
				this.getCgg_res_carnet().setCRCNT_MOTIVO(results.getInt(7));
				this.getCgg_res_carnet().setCRCNT_FECHA_EMISION(results.getTimestamp(8));
				this.getCgg_res_carnet().setCRCNT_FECHA_APROBACION(results.getTimestamp(9));
				this.getCgg_res_carnet().setCRCNT_FECHA_CADUCIDAD(results.getTimestamp(10));
				this.getCgg_res_carnet().setCRCNT_FECHA_DEPOSITO(results.getTimestamp(11));
				this.getCgg_res_carnet().setCRCNT_CARNET_IMPRESO(results.getBoolean(12));
				this.getCgg_res_carnet().setCRCNT_NUMERO_COMP(results.getString(13));
				this.getCgg_res_carnet().setCRCNT_VALOR(results.getBigDecimal(14));
				this.getCgg_res_carnet().setCRCNT_OBSERVACION(results.getString(15));
				this.getCgg_res_carnet().setCRCNT_ESTADO(results.getBoolean(16));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_carnet();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_carnet DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_carnet().getCRCNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_carnet().getCRCNT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_carnet DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_carnet OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> selectCGG_RES_ADJUNTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> outCgg_res_carnet = new ArrayList<com.besixplus.sii.objects.Cgg_res_carnet>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_S_CGG_RES_ADJUNTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_carnet().getCRADJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_carnet tmpCgg_res_carnet = new com.besixplus.sii.objects.Cgg_res_carnet();
				tmpCgg_res_carnet.setCRCNT_CODIGO(results.getString(1));
				tmpCgg_res_carnet.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_carnet.setCRADJ_CODIGO(results.getString(3));
				tmpCgg_res_carnet.setCRRSD_CODIGO(results.getString(4));
				tmpCgg_res_carnet.setCRCPJ_CODIGO(results.getString(5));
				tmpCgg_res_carnet.setCRCNT_SERIE(results.getString(6));
				tmpCgg_res_carnet.setCRCNT_MOTIVO(results.getInt(7));
				tmpCgg_res_carnet.setCRCNT_FECHA_EMISION(results.getTimestamp(8));
				tmpCgg_res_carnet.setCRCNT_FECHA_APROBACION(results.getTimestamp(9));
				tmpCgg_res_carnet.setCRCNT_FECHA_CADUCIDAD(results.getTimestamp(10));
				tmpCgg_res_carnet.setCRCNT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_carnet.setCRCNT_CARNET_IMPRESO(results.getBoolean(12));
				tmpCgg_res_carnet.setCRCNT_NUMERO_COMP(results.getString(13));
				tmpCgg_res_carnet.setCRCNT_VALOR(results.getBigDecimal(14));
				tmpCgg_res_carnet.setCRCNT_OBSERVACION(results.getString(15));
				tmpCgg_res_carnet.setCRCNT_ESTADO(results.getBoolean(16));
				outCgg_res_carnet.add(tmpCgg_res_carnet);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_carnet;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_carnet DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_ADJUNTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_D_CGG_RES_ADJUNTO(?) }");
			stmDelete.setString(1, this.getCgg_res_carnet().getCRADJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_DS_CGG_RES_ADJUNTO(?) }");
				stmDelete.setString(1, this.getCgg_res_carnet().getCRADJ_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_carnet DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_comunicado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_carnet OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> selectCGG_RES_COMUNICADO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> outCgg_res_carnet = new ArrayList<com.besixplus.sii.objects.Cgg_res_carnet>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_S_CGG_RES_COMUNICADO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_carnet().getCRCOM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_carnet tmpCgg_res_carnet = new com.besixplus.sii.objects.Cgg_res_carnet();
				tmpCgg_res_carnet.setCRCNT_CODIGO(results.getString(1));
				tmpCgg_res_carnet.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_carnet.setCRADJ_CODIGO(results.getString(3));
				tmpCgg_res_carnet.setCRRSD_CODIGO(results.getString(4));
				tmpCgg_res_carnet.setCRCPJ_CODIGO(results.getString(5));
				tmpCgg_res_carnet.setCRCNT_SERIE(results.getString(6));
				tmpCgg_res_carnet.setCRCNT_MOTIVO(results.getInt(7));
				tmpCgg_res_carnet.setCRCNT_FECHA_EMISION(results.getTimestamp(8));
				tmpCgg_res_carnet.setCRCNT_FECHA_APROBACION(results.getTimestamp(9));
				tmpCgg_res_carnet.setCRCNT_FECHA_CADUCIDAD(results.getTimestamp(10));
				tmpCgg_res_carnet.setCRCNT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_carnet.setCRCNT_CARNET_IMPRESO(results.getBoolean(12));
				tmpCgg_res_carnet.setCRCNT_NUMERO_COMP(results.getString(13));
				tmpCgg_res_carnet.setCRCNT_VALOR(results.getBigDecimal(14));
				tmpCgg_res_carnet.setCRCNT_OBSERVACION(results.getString(15));
				tmpCgg_res_carnet.setCRCNT_ESTADO(results.getBoolean(16));
				outCgg_res_carnet.add(tmpCgg_res_carnet);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_carnet;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_carnet DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_comunicado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_COMUNICADO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_D_CGG_RES_COMUNICADO(?) }");
			stmDelete.setString(1, this.getCgg_res_carnet().getCRCOM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_DS_CGG_RES_COMUNICADO(?) }");
				stmDelete.setString(1, this.getCgg_res_carnet().getCRCOM_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_carnet DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_carnet OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> selectCGG_RES_RESIDENCIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> outCgg_res_carnet = new ArrayList<com.besixplus.sii.objects.Cgg_res_carnet>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARNET_S_CGG_RES_RESIDENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_carnet().getCRRSD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_carnet tmpCgg_res_carnet = new com.besixplus.sii.objects.Cgg_res_carnet();
				tmpCgg_res_carnet.setCRCNT_CODIGO(results.getString(1));
				tmpCgg_res_carnet.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_carnet.setCRADJ_CODIGO(results.getString(3));
				tmpCgg_res_carnet.setCRRSD_CODIGO(results.getString(4));
				tmpCgg_res_carnet.setCRCPJ_CODIGO(results.getString(5));
				tmpCgg_res_carnet.setCRCNT_SERIE(results.getString(6));
				tmpCgg_res_carnet.setCRCNT_MOTIVO(results.getInt(7));
				tmpCgg_res_carnet.setCRCNT_FECHA_EMISION(results.getTimestamp(8));
				tmpCgg_res_carnet.setCRCNT_FECHA_APROBACION(results.getTimestamp(9));
				tmpCgg_res_carnet.setCRCNT_FECHA_CADUCIDAD(results.getTimestamp(10));
				tmpCgg_res_carnet.setCRCNT_FECHA_DEPOSITO(results.getTimestamp(11));
				tmpCgg_res_carnet.setCRCNT_CARNET_IMPRESO(results.getBoolean(12));
				tmpCgg_res_carnet.setCRCNT_NUMERO_COMP(results.getString(13));
				tmpCgg_res_carnet.setCRCNT_VALOR(results.getBigDecimal(14));
				tmpCgg_res_carnet.setCRCNT_OBSERVACION(results.getString(15));
				tmpCgg_res_carnet.setCRCNT_ESTADO(results.getBoolean(16));
				outCgg_res_carnet.add(tmpCgg_res_carnet);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_carnet;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_carnet DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_RESIDENCIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_D_CGG_RES_RESIDENCIA(?) }");
			stmDelete.setString(1, this.getCgg_res_carnet().getCRRSD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARNET_DS_CGG_RES_RESIDENCIA(?) }");
				stmDelete.setString(1, this.getCgg_res_carnet().getCRRSD_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

}