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
* CLASE Cgg_res_tramite_garantia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tramite_garantia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tramite_garantia implements Serializable{
	private static final long serialVersionUID = 2130586689;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tramite_garantia.
	*/
	private com.besixplus.sii.objects.Cgg_res_tramite_garantia myCgg_res_tramite_garantia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite_garantia.
	*/
	public Cgg_res_tramite_garantia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite_garantia.
	* @param inCgg_res_tramite_garantia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tramite_garantia.
	*/
	public Cgg_res_tramite_garantia(
		com.besixplus.sii.objects.Cgg_res_tramite_garantia inCgg_res_tramite_garantia
	){
		this.setCgg_res_tramite_garantia(inCgg_res_tramite_garantia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tramite_garantia.
	* @param inCgg_res_tramite_garantia OBJETO Cgg_res_tramite_garantia.
	* @return void
	*/
	public void setCgg_res_tramite_garantia(com.besixplus.sii.objects.Cgg_res_tramite_garantia inCgg_res_tramite_garantia){
		this.myCgg_res_tramite_garantia = inCgg_res_tramite_garantia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tramite_garantia.
	* @return Cgg_res_tramite_garantia OBJETO Cgg_res_tramite_garantia.
	*/
	public com.besixplus.sii.objects.Cgg_res_tramite_garantia getCgg_res_tramite_garantia(){
		return this.myCgg_res_tramite_garantia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_INSERT(?,?,?,?,?,?,?,?,?::smallint,?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tramite_garantia().getCRTGR_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tramite_garantia().getCRDPT_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
			stmInsert.setString(5, this.getCgg_res_tramite_garantia().getCRGRT_CODIGO());
			stmInsert.setBigDecimal(6, this.getCgg_res_tramite_garantia().getCRTGR_VALOR());
			stmInsert.setTimestamp(7, this.getCgg_res_tramite_garantia().getCRTGR_FECHA_SOLI_DEVOL()!=null?new java.sql.Timestamp(this.getCgg_res_tramite_garantia().getCRTGR_FECHA_SOLI_DEVOL().getTime()):null);
			stmInsert.setTimestamp(8, this.getCgg_res_tramite_garantia().getCRTGR_FECHA_DEVOLUCION()!=null?new java.sql.Timestamp(this.getCgg_res_tramite_garantia().getCRTGR_FECHA_DEVOLUCION().getTime()):null);
			stmInsert.setBoolean(9, this.getCgg_res_tramite_garantia().getCRTGR_DEVUELTO());
			stmInsert.setInt(10, this.getCgg_res_tramite_garantia().getCRTGR_ESTADO_ASIGNACION());
			stmInsert.setBoolean(11, this.getCgg_res_tramite_garantia().getCRTGR_ESTADO());
			stmInsert.setString(12, this.getCgg_res_tramite_garantia().getCRTGR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_tramite_garantia().setCRTGR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> outCgg_res_tramite_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpCgg_res_tramite_garantia = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
				tmpCgg_res_tramite_garantia.setCRTGR_CODIGO(results.getString(1));
				tmpCgg_res_tramite_garantia.setCRDPT_CODIGO(results.getString(2));
				tmpCgg_res_tramite_garantia.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_tramite_garantia.setCRGRT_CODIGO(results.getString(4));
				tmpCgg_res_tramite_garantia.setCRTGR_VALOR(results.getBigDecimal(5));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_SOLI_DEVOL(results.getTimestamp(6));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_DEVOLUCION(results.getTimestamp(7));
				tmpCgg_res_tramite_garantia.setCRTGR_DEVUELTO(results.getBoolean(8));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO_ASIGNACION(results.getInt(9));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO(results.getBoolean(10));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_INSERT(results.getString(11));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_UPDATE(results.getString(12));
				outCgg_res_tramite_garantia.add(tmpCgg_res_tramite_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite_garantia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> outCgg_res_tramite_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpCgg_res_tramite_garantia = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
				tmpCgg_res_tramite_garantia.setCRTGR_CODIGO(results.getString(1));
				tmpCgg_res_tramite_garantia.setCRDPT_CODIGO(results.getString(2));
				tmpCgg_res_tramite_garantia.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_tramite_garantia.setCRGRT_CODIGO(results.getString(4));
				tmpCgg_res_tramite_garantia.setCRTGR_VALOR(results.getBigDecimal(5));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_SOLI_DEVOL(results.getTimestamp(6));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_DEVOLUCION(results.getTimestamp(7));
				tmpCgg_res_tramite_garantia.setCRTGR_DEVUELTO(results.getBoolean(8));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO_ASIGNACION(results.getInt(9));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO(results.getBoolean(10));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_INSERT(results.getString(11));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_UPDATE(results.getString(12));
				outCgg_res_tramite_garantia.add(tmpCgg_res_tramite_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite_garantia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_tramite_garantia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_tramite_garantia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite_garantia;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tramite_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_UPDATE(?,?,?,?,?,?,?,?,?::smallint,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_tramite_garantia().getCRTGR_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tramite_garantia().getCRDPT_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_tramite_garantia().getCRGRT_CODIGO());
			stmUpdate.setBigDecimal(5, this.getCgg_res_tramite_garantia().getCRTGR_VALOR());
			stmUpdate.setTimestamp(6, this.getCgg_res_tramite_garantia().getCRTGR_FECHA_SOLI_DEVOL()!=null?new java.sql.Timestamp(this.getCgg_res_tramite_garantia().getCRTGR_FECHA_SOLI_DEVOL().getTime()):null);
			stmUpdate.setTimestamp(7, this.getCgg_res_tramite_garantia().getCRTGR_FECHA_DEVOLUCION()!=null?new java.sql.Timestamp(this.getCgg_res_tramite_garantia().getCRTGR_FECHA_DEVOLUCION().getTime()):null);
			stmUpdate.setBoolean(8, this.getCgg_res_tramite_garantia().getCRTGR_DEVUELTO());
			stmUpdate.setInt(9, this.getCgg_res_tramite_garantia().getCRTGR_ESTADO_ASIGNACION());
			stmUpdate.setBoolean(10, this.getCgg_res_tramite_garantia().getCRTGR_ESTADO());
			stmUpdate.setString(11, this.getCgg_res_tramite_garantia().getCRTGR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tramite_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tramite_garantia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite_garantia().getCRTGR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tramite_garantia().setCRTGR_CODIGO(results.getString(1));
				this.getCgg_res_tramite_garantia().setCRDPT_CODIGO(results.getString(2));
				this.getCgg_res_tramite_garantia().setCRTRA_CODIGO(results.getString(3));
				this.getCgg_res_tramite_garantia().setCRGRT_CODIGO(results.getString(4));
				this.getCgg_res_tramite_garantia().setCRTGR_VALOR(results.getBigDecimal(5));
				this.getCgg_res_tramite_garantia().setCRTGR_FECHA_SOLI_DEVOL(results.getTimestamp(6));
				this.getCgg_res_tramite_garantia().setCRTGR_FECHA_DEVOLUCION(results.getTimestamp(7));
				this.getCgg_res_tramite_garantia().setCRTGR_DEVUELTO(results.getBoolean(8));
				this.getCgg_res_tramite_garantia().setCRTGR_ESTADO_ASIGNACION(results.getInt(9));
				this.getCgg_res_tramite_garantia().setCRTGR_ESTADO(results.getBoolean(10));
				this.getCgg_res_tramite_garantia().setCRTGR_USUARIO_INSERT(results.getString(11));
				this.getCgg_res_tramite_garantia().setCRTGR_USUARIO_UPDATE(results.getString(12));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tramite_garantia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRTGR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRTGR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tramite_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> selectCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> outCgg_res_tramite_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_S_CGG_RES_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpCgg_res_tramite_garantia = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
				tmpCgg_res_tramite_garantia.setCRTGR_CODIGO(results.getString(1));
				tmpCgg_res_tramite_garantia.setCRDPT_CODIGO(results.getString(2));
				tmpCgg_res_tramite_garantia.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_tramite_garantia.setCRGRT_CODIGO(results.getString(4));
				tmpCgg_res_tramite_garantia.setCRTGR_VALOR(results.getBigDecimal(5));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_SOLI_DEVOL(results.getTimestamp(6));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_DEVOLUCION(results.getTimestamp(7));
				tmpCgg_res_tramite_garantia.setCRTGR_DEVUELTO(results.getBoolean(8));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO_ASIGNACION(results.getInt(9));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO(results.getBoolean(10));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_INSERT(results.getString(11));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_UPDATE(results.getString(12));
				outCgg_res_tramite_garantia.add(tmpCgg_res_tramite_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite_garantia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_D_CGG_RES_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_DS_CGG_RES_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_deposito_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tramite_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectCGG_RES_DEPOSITO_GARANTIA(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String, Object>> outCgg_res_tramite_garantia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_S_CGG_RES_DEPOSITO_GARANTIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite_garantia().getCRDPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tramite_garantia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite_garantia;
	}
	
	/**
	 * Selecciona los depositos de un tramite.
	 * @param inConnection Conexion a base de datos.
	 * @return Coleccion de datos.
	 */
	public ArrayList<HashMap<String,Object>> selectCGG_RES_TRAMITE_GARANTIA(
			java.sql.Connection inConnection
		){
			ArrayList<HashMap<String, Object>> outCgg_res_tramite_garantia = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_GARANTIA(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)						
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_tramite_garantia.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_tramite_garantia;
		}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_deposito_garantia.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_D_CGG_RES_DEPOSITO_GARANTIA(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRDPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_DS_CGG_RES_DEPOSITO_GARANTIA(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRDPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tramite_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> selectCGG_RES_GARANTIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> outCgg_res_tramite_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TRAMITE_GARANTIA_S_CGG_RES_GARANTIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tramite_garantia().getCRGRT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpCgg_res_tramite_garantia = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
				tmpCgg_res_tramite_garantia.setCRTGR_CODIGO(results.getString(1));
				tmpCgg_res_tramite_garantia.setCRDPT_CODIGO(results.getString(2));
				tmpCgg_res_tramite_garantia.setCRTRA_CODIGO(results.getString(3));
				tmpCgg_res_tramite_garantia.setCRGRT_CODIGO(results.getString(4));
				tmpCgg_res_tramite_garantia.setCRTGR_VALOR(results.getBigDecimal(5));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_SOLI_DEVOL(results.getTimestamp(6));
				tmpCgg_res_tramite_garantia.setCRTGR_FECHA_DEVOLUCION(results.getTimestamp(7));
				tmpCgg_res_tramite_garantia.setCRTGR_DEVUELTO(results.getBoolean(8));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO_ASIGNACION(results.getInt(9));
				tmpCgg_res_tramite_garantia.setCRTGR_ESTADO(results.getBoolean(10));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_INSERT(results.getString(11));
				tmpCgg_res_tramite_garantia.setCRTGR_USUARIO_UPDATE(results.getString(12));
				outCgg_res_tramite_garantia.add(tmpCgg_res_tramite_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tramite_garantia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_GARANTIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_D_CGG_RES_GARANTIA(?) }");
			stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRGRT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TRAMITE_GARANTIA_DS_CGG_RES_GARANTIA(?) }");
				stmDelete.setString(1, this.getCgg_res_tramite_garantia().getCRGRT_CODIGO());
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
	* CONTABILIZA CUANTAS GARANTIAS ESTAN PENDIENTES DE RETIRAR.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtra_codigo CODIGO DE TRAMITE.
	* @return int NUMERO DE REGISTROS.
	*/
	public int selectPendientes(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_GARANTIA_PEN_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, this.getCgg_res_tramite_garantia().getCRTRA_CODIGO());
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	 * MARCA UNA GARANTIA COMO DEVUELTA
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName USUARIO DEL SERVIDOR DE APLICACIONES
	 * @return <code>true</code> LA OPERACION SE REALIZO SIN PROBLEMAS
	 */
	public String updateDevolucionGarantia(
			java.sql.Connection inConnection,
			String inUserName
	){
		String outResult = "true";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ call SII.F_CGG_RES_DEPOSITO_GARANTIA_UPDATE_DEVOLUCION(?,?,?) }");
			stmSelect.setString(1, inUserName);
			stmSelect.setString(2, getCgg_res_tramite_garantia().getCRDPT_CODIGO());
			stmSelect.setString(3, getCgg_res_tramite_garantia().getCRTRA_CODIGO());
			stmSelect.execute();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

}