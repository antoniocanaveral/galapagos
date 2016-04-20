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
* CLASE Cgg_res_movilidad_interna
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_movilidad_interna.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_movilidad_interna implements Serializable{
	private static final long serialVersionUID = 1691439513;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_movilidad_interna.
	*/
	private com.besixplus.sii.objects.Cgg_res_movilidad_interna myCgg_res_movilidad_interna = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad_interna.
	*/
	public Cgg_res_movilidad_interna(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad_interna.
	* @param inCgg_res_movilidad_interna OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_movilidad_interna.
	*/
	public Cgg_res_movilidad_interna(
		com.besixplus.sii.objects.Cgg_res_movilidad_interna inCgg_res_movilidad_interna
	){
		this.setCgg_res_movilidad_interna(inCgg_res_movilidad_interna);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_movilidad_interna.
	* @param inCgg_res_movilidad_interna OBJETO Cgg_res_movilidad_interna.
	* @return void
	*/
	public void setCgg_res_movilidad_interna(com.besixplus.sii.objects.Cgg_res_movilidad_interna inCgg_res_movilidad_interna){
		this.myCgg_res_movilidad_interna = inCgg_res_movilidad_interna;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_movilidad_interna.
	* @return Cgg_res_movilidad_interna OBJETO Cgg_res_movilidad_interna.
	*/
	public com.besixplus.sii.objects.Cgg_res_movilidad_interna getCgg_res_movilidad_interna(){
		return this.myCgg_res_movilidad_interna;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_movilidad_interna.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_movilidad_interna().getCRMVI_CODIGO());
			stmInsert.setString(3, this.getCgg_res_movilidad_interna().getCRMLE_CODIGO());
			stmInsert.setString(4, this.getCgg_res_movilidad_interna().getCGG_CRMLE_CODIGO());
			stmInsert.setString(5, this.getCgg_res_movilidad_interna().getCREMB_CODIGO());
			stmInsert.setString(6, this.getCgg_res_movilidad_interna().getCRPER_CODIGO());
			stmInsert.setString(7, this.getCgg_res_movilidad_interna().getCRMOV_CODIGO());
			stmInsert.setString(8, this.getCgg_res_movilidad_interna().getCARPT_CODIGO());
			stmInsert.setString(9, this.getCgg_res_movilidad_interna().getCGG_CARPT_CODIGO());
			stmInsert.setString(10, this.getCgg_res_movilidad_interna().getCRALN_CODIGO());
			stmInsert.setString(11, this.getCgg_res_movilidad_interna().getCRALN_DESCRIPCION_VUELO());
			stmInsert.setTimestamp(12, new java.sql.Timestamp(this.getCgg_res_movilidad_interna().getCRMVI_FECHA_VIAJE().getTime()));
			stmInsert.setInt(13, this.getCgg_res_movilidad_interna().getCRMVI_TIPO_OPERACION());
			stmInsert.setString(14, this.getCgg_res_movilidad_interna().getCRMVI_OBSERVACION());
			stmInsert.setBoolean(15, this.getCgg_res_movilidad_interna().getCRMVI_ESTADO());
			stmInsert.setString(16, this.getCgg_res_movilidad_interna().getCRMVI_USUARIO_INSERT());
			stmInsert.setString(17, this.getCgg_res_movilidad_interna().getCRMVI_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_movilidad_interna().setCRMVI_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad_interna = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_movilidad_interna.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_movilidad_interna.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_movilidad_interna().getCRMVI_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_movilidad_interna().getCRMLE_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_movilidad_interna().getCGG_CRMLE_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_movilidad_interna().getCREMB_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_movilidad_interna().getCRPER_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_movilidad_interna().getCRMOV_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_movilidad_interna().getCARPT_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_movilidad_interna().getCGG_CARPT_CODIGO());
			stmUpdate.setString(9, this.getCgg_res_movilidad_interna().getCRALN_CODIGO());
			stmUpdate.setString(10, this.getCgg_res_movilidad_interna().getCRALN_DESCRIPCION_VUELO());
			stmUpdate.setTimestamp(11, new java.sql.Timestamp(this.getCgg_res_movilidad_interna().getCRMVI_FECHA_VIAJE().getTime()));
			stmUpdate.setInt(12, this.getCgg_res_movilidad_interna().getCRMVI_TIPO_OPERACION());
			stmUpdate.setString(13, this.getCgg_res_movilidad_interna().getCRMVI_OBSERVACION());
			stmUpdate.setBoolean(14, this.getCgg_res_movilidad_interna().getCRMVI_ESTADO());
			stmUpdate.setString(15, this.getCgg_res_movilidad_interna().getCRMVI_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_movilidad_interna select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCRMVI_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_movilidad_interna().setCRMVI_CODIGO(results.getString(1));
				this.getCgg_res_movilidad_interna().setCRMLE_CODIGO(results.getString(2));
				this.getCgg_res_movilidad_interna().setCGG_CRMLE_CODIGO(results.getString(3));
				this.getCgg_res_movilidad_interna().setCREMB_CODIGO(results.getString(4));
				this.getCgg_res_movilidad_interna().setCRPER_CODIGO(results.getString(5));
				this.getCgg_res_movilidad_interna().setCRMOV_CODIGO(results.getString(6));
				this.getCgg_res_movilidad_interna().setCARPT_CODIGO(results.getString(7));
				this.getCgg_res_movilidad_interna().setCGG_CARPT_CODIGO(results.getString(8));
				this.getCgg_res_movilidad_interna().setCRALN_CODIGO(results.getString(9));
				this.getCgg_res_movilidad_interna().setCRALN_DESCRIPCION_VUELO(results.getString(10));
				this.getCgg_res_movilidad_interna().setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				this.getCgg_res_movilidad_interna().setCRMVI_TIPO_OPERACION(results.getInt(12));
				this.getCgg_res_movilidad_interna().setCRMVI_OBSERVACION(results.getString(13));
				this.getCgg_res_movilidad_interna().setCRMVI_ESTADO(results.getBoolean(14));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_movilidad_interna();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRMVI_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRMVI_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_muelle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectCGG_RES_MUELLE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_S_CGG_RES_MUELLE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCRMLE_CODIGO());
			stmSelect.setString(3,this.getCgg_res_movilidad_interna().getCGG_CRMLE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_muelle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_MUELLE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_D_CGG_RES_MUELLE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRMLE_CODIGO());
			stmDelete.setString(2, this.getCgg_res_movilidad_interna().getCGG_CRMLE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DS_CGG_RES_MUELLE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRMLE_CODIGO());
				stmDelete.setString(2, this.getCgg_res_movilidad_interna().getCGG_CRMLE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_S_CGG_RES_AEROPUERTO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCARPT_CODIGO());
			stmSelect.setString(3,this.getCgg_res_movilidad_interna().getCGG_CARPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_D_CGG_RES_AEROPUERTO(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCARPT_CODIGO());
			stmDelete.setString(2, this.getCgg_res_movilidad_interna().getCGG_CARPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DS_CGG_RES_AEROPUERTO(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCARPT_CODIGO());
				stmDelete.setString(2, this.getCgg_res_movilidad_interna().getCGG_CARPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_movilidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectCGG_RES_MOVILIDAD(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_S_CGG_RES_MOVILIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCRMOV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_movilidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_MOVILIDAD(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_D_CGG_RES_MOVILIDAD(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRMOV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DS_CGG_RES_MOVILIDAD(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRMOV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_embarcacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectCGG_RES_EMBARCACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_S_CGG_RES_EMBARCACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCREMB_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_embarcacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_EMBARCACION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_D_CGG_RES_EMBARCACION(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCREMB_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DS_CGG_RES_EMBARCACION(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCREMB_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aerolinea.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectCGG_RES_AEROLINEA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_S_CGG_RES_AEROLINEA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCRALN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aerolinea.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_AEROLINEA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_D_CGG_RES_AEROLINEA(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRALN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DS_CGG_RES_AEROLINEA(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRALN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad_interna OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> outCgg_res_movilidad_interna = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INTERNA_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad_interna().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad_interna tmpCgg_res_movilidad_interna = new com.besixplus.sii.objects.Cgg_res_movilidad_interna();
				tmpCgg_res_movilidad_interna.setCRMVI_CODIGO(results.getString(1));
				tmpCgg_res_movilidad_interna.setCRMLE_CODIGO(results.getString(2));
				tmpCgg_res_movilidad_interna.setCGG_CRMLE_CODIGO(results.getString(3));
				tmpCgg_res_movilidad_interna.setCREMB_CODIGO(results.getString(4));
				tmpCgg_res_movilidad_interna.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad_interna.setCRMOV_CODIGO(results.getString(6));
				tmpCgg_res_movilidad_interna.setCARPT_CODIGO(results.getString(7));
				tmpCgg_res_movilidad_interna.setCGG_CARPT_CODIGO(results.getString(8));
				tmpCgg_res_movilidad_interna.setCRALN_CODIGO(results.getString(9));
				tmpCgg_res_movilidad_interna.setCRALN_DESCRIPCION_VUELO(results.getString(10));
				tmpCgg_res_movilidad_interna.setCRMVI_FECHA_VIAJE(results.getTimestamp(11));
				tmpCgg_res_movilidad_interna.setCRMVI_TIPO_OPERACION(results.getInt(12));
				tmpCgg_res_movilidad_interna.setCRMVI_OBSERVACION(results.getString(13));
				tmpCgg_res_movilidad_interna.setCRMVI_ESTADO(results.getBoolean(14));
				outCgg_res_movilidad_interna.add(tmpCgg_res_movilidad_interna);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_INTERNA_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad_interna().getCRPER_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA VARIAS TABLAS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param in_crper_numero_identificacion NUMERO DE IDENTIFICACION DE UNA PERSONA.
	* @param inCtreg_codigo_barras DOCUMENTO DE BUSQUEDA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad_interna> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovilidadInternaDocumentoSalida(
		java.sql.Connection inConnection,
		String in_crper_numero_identificacion
		
	){
		ArrayList<HashMap<String,Object>> outCgg_documento_identific = new ArrayList<HashMap<String,Object>>();
	
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call f_cgg_tct_movilidad_interna_select_documento_identific_ingreso(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, in_crper_numero_identificacion);		
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_documento_identific.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_documento_identific;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovildadInternaDatos(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad_interna = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_movilidad_interna_select_datos(?,?,?,?,?,?) }");
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
				outCgg_res_movilidad_interna.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE VARIAS TABLAS QUE SE RELACIONAN CON MOVILIDAD QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrper_numero_identificacion NUMERO DE IDENTIFICACION DE UNA PERSONA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovildadPersonaIngreso(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCrper_numero_identificacion
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad_persona_ingreso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_movilidad_interna_select_documento_identific_general(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrper_numero_identificacion);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad_persona_ingreso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_persona_ingreso;
	}	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCrper_numero_identificacion NUMERO DE IDENTIFICACION DE UNA PERSONA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectMovilidadCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrper_numero_identificacion
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_movilidad_interna_select_documento_identific_general_count(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrper_numero_identificacion);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE VARIAS TABLAS QUE SE RELACIONAN CON MOVILIDAD QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
    * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovildadInternaIngreso(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad_persona_ingreso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_movilidad_interna_ingreso(?,?,?,?,?,?) }");
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
				outCgg_res_movilidad_persona_ingreso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_persona_ingreso;
	}	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectMovilidadInternaIngresoCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_movilidad_interna_ingreso_count(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_actividad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA.
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectActividadMovilidadInterna(
			java.sql.Connection inConnection,		
			String inCrmvi_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_tct_movilidad_int_actividad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_registro_actividad_interna(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrmvi_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_movilidad_int_actividad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_movilidad_int_actividad;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_tipo_hospedaje QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA.
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectHospedajeMovilidadInterna(
			java.sql.Connection inConnection,		
			String inCrmvi_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_tct_movilidad_int_hospedaje = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_registro_hospedaje_interno(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrmvi_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_movilidad_int_hospedaje.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_movilidad_int_hospedaje;
	}
	
}