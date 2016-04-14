package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

import com.besixplus.sii.objects.Cgg_res_fase_hijo;

/**
* CLASE Cgg_res_fase
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_fase.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_fase implements Serializable{
	private static final long serialVersionUID = 288522039;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_fase.
	*/
	private com.besixplus.sii.objects.Cgg_res_fase myCgg_res_fase = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase.
	*/
	public Cgg_res_fase(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase.
	* @param inCgg_res_fase OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_fase.
	*/
	public Cgg_res_fase(
		com.besixplus.sii.objects.Cgg_res_fase inCgg_res_fase
	){
		this.setCgg_res_fase(inCgg_res_fase);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_fase.
	* @param inCgg_res_fase OBJETO Cgg_res_fase.
	* @return void
	*/
	public void setCgg_res_fase(com.besixplus.sii.objects.Cgg_res_fase inCgg_res_fase){
		this.myCgg_res_fase = inCgg_res_fase;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_fase.
	* @return Cgg_res_fase OBJETO Cgg_res_fase.
	*/
	public com.besixplus.sii.objects.Cgg_res_fase getCgg_res_fase(){
		return this.myCgg_res_fase;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_fase().getCRFAS_CODIGO());
			stmInsert.setString(3, this.getCgg_res_fase().getCRPRO_CODIGO());
			stmInsert.setString(4, this.getCgg_res_fase().getCRETT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_fase().getCGG_CRETT_CODIGO());
			stmInsert.setString(6, this.getCgg_res_fase().getCRSEC_CODIGO());
			stmInsert.setString(7, this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
			stmInsert.setString(8, this.getCgg_res_fase().getCGG_CUSU_CODIGO());
			stmInsert.setString(9, this.getCgg_res_fase().getCRFAS_NOMBRE());
			stmInsert.setInt(10, this.getCgg_res_fase().getCRFAS_ORDEN());
			stmInsert.setString(11, this.getCgg_res_fase().getCRFAS_TAREA_REALIZA());
			stmInsert.setString(12, this.getCgg_res_fase().getCRFAS_FUNCION_EJECUTA());
			stmInsert.setBoolean(13, this.getCgg_res_fase().getCRFAS_SUBE_ADJUNTO());
			stmInsert.setBoolean(14, this.getCgg_res_fase().getCRFAS_SUBE_ADJUNTO_REQUISITO());
			stmInsert.setBoolean(15, this.getCgg_res_fase().getCRFAS_EJECUTA_DESPACHO());
			stmInsert.setBoolean(16, this.getCgg_res_fase().getCRFAS_ATENCION_NORMAL());
			stmInsert.setBoolean(17, this.getCgg_res_fase().getCRFAS_ESTADO());
			stmInsert.setString(18, this.getCgg_res_fase().getCRFAS_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_fase().setCRFAS_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert1(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_INSERT1(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_fase().getCRFAS_CODIGO());
			stmInsert.setString(3, this.getCgg_res_fase().getCRPRO_CODIGO());
			stmInsert.setString(4, this.getCgg_res_fase().getCRETT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_fase().getCGG_CRETT_CODIGO());
			stmInsert.setString(6, this.getCgg_res_fase().getCRSEC_CODIGO());
			stmInsert.setString(7, this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
			stmInsert.setString(8, this.getCgg_res_fase().getCGG_CUSU_CODIGO());
			stmInsert.setString(9, this.getCgg_res_fase().getCRFAS_NOMBRE());
			stmInsert.setInt(10, this.getCgg_res_fase().getCRFAS_ORDEN());
			stmInsert.setString(11, this.getCgg_res_fase().getCRFAS_TAREA_REALIZA());
			stmInsert.setString(12, this.getCgg_res_fase().getCRFAS_FUNCION_EJECUTA());
			stmInsert.setBoolean(13, this.getCgg_res_fase().getCRFAS_SUBE_ADJUNTO());
			stmInsert.setBoolean(14, this.getCgg_res_fase().getCRFAS_SUBE_ADJUNTO_REQUISITO());
			stmInsert.setBoolean(15, this.getCgg_res_fase().getCRFAS_EJECUTA_DESPACHO());
			stmInsert.setBoolean(16, this.getCgg_res_fase().getCRFAS_ATENCION_NORMAL());
			stmInsert.setBoolean(17, this.getCgg_res_fase().getCRFAS_ESTADO());
			stmInsert.setString(18, this.getCgg_res_fase().getCRFAS_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_fase().setCRFAS_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_fase = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_fase.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_COUNT() }");
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
		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_fase().getCRFAS_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_fase().getCRPRO_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_fase().getCRETT_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_fase().getCGG_CRETT_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_fase().getCRSEC_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_fase().getCGG_CUSU_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_fase().getCRFAS_NOMBRE());
			stmUpdate.setInt(9, this.getCgg_res_fase().getCRFAS_ORDEN());
			stmUpdate.setString(10, this.getCgg_res_fase().getCRFAS_TAREA_REALIZA());
			stmUpdate.setString(11, this.getCgg_res_fase().getCRFAS_FUNCION_EJECUTA());
			stmUpdate.setBoolean(12, this.getCgg_res_fase().getCRFAS_SUBE_ADJUNTO());
			stmUpdate.setBoolean(13, this.getCgg_res_fase().getCRFAS_SUBE_ADJUNTO_REQUISITO());
			stmUpdate.setBoolean(14, this.getCgg_res_fase().getCRFAS_EJECUTA_DESPACHO());
			stmUpdate.setBoolean(15, this.getCgg_res_fase().getCRFAS_ATENCION_NORMAL());
			stmUpdate.setBoolean(16, this.getCgg_res_fase().getCRFAS_ESTADO());
			stmUpdate.setString(17, this.getCgg_res_fase().getCRFAS_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_fase select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_fase().setCRFAS_CODIGO(results.getString(1));
				this.getCgg_res_fase().setCRPRO_CODIGO(results.getString(2));
				this.getCgg_res_fase().setCRETT_CODIGO(results.getString(3));
				this.getCgg_res_fase().setCGG_CRETT_CODIGO(results.getString(4));
				this.getCgg_res_fase().setCRSEC_CODIGO(results.getString(5));
				this.getCgg_res_fase().setCGG_CRFAS_CODIGO(results.getString(6));
				this.getCgg_res_fase().setCGG_CUSU_CODIGO(results.getString(7));
				this.getCgg_res_fase().setCRFAS_NOMBRE(results.getString(8));
				this.getCgg_res_fase().setCRFAS_ORDEN(results.getInt(9));
				this.getCgg_res_fase().setCRFAS_TAREA_REALIZA(results.getString(10));
				this.getCgg_res_fase().setCRFAS_FUNCION_EJECUTA(results.getString(11));
				this.getCgg_res_fase().setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				this.getCgg_res_fase().setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				this.getCgg_res_fase().setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				this.getCgg_res_fase().setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				this.getCgg_res_fase().setCRFAS_ESTADO(results.getBoolean(16));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_fase();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_fase().getCRFAS_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult == false){
			try{				
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_fase().getCRFAS_CODIGO());
				stmDelete.execute();
				stmDelete.close();
				outResult = true;
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_estado_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectCGG_RES_ESTADO_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_RES_ESTADO_TRAMITE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCGG_CRETT_CODIGO());
			stmSelect.setString(3,this.getCgg_res_fase().getCRETT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_estado_tramite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_D_CGG_RES_ESTADO_TRAMITE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_fase().getCGG_CRETT_CODIGO());
			stmDelete.setString(2, this.getCgg_res_fase().getCRETT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DS_CGG_RES_ESTADO_TRAMITE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_fase().getCGG_CRETT_CODIGO());
				stmDelete.setString(2, this.getCgg_res_fase().getCRETT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCGG_CUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_fase().getCGG_CUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_fase().getCGG_CUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_RES_FASE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_D_CGG_RES_FASE(?) }");
			stmDelete.setString(1, this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DS_CGG_RES_FASE(?) }");
				stmDelete.setString(1, this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectCGG_RES_PROCESO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_RES_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCRPRO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_proceso.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_D_CGG_RES_PROCESO(?) }");
			stmDelete.setString(1, this.getCgg_res_fase().getCRPRO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DS_CGG_RES_PROCESO(?) }");
				stmDelete.setString(1, this.getCgg_res_fase().getCRPRO_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seccion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase> selectCGG_RES_SECCION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_RES_SECCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCRSEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seccion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SECCION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_D_CGG_RES_SECCION(?) }");
			stmDelete.setString(1, this.getCgg_res_fase().getCRSEC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_DS_CGG_RES_SECCION(?) }");
				stmDelete.setString(1, this.getCgg_res_fase().getCRSEC_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public  ArrayList<HashMap<String,Object>> selectDirectFase(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_SELECT_CONTENT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrpro_codigo CODIGO DEL PROCESO A CONSULTAR.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectDirectFaseP(
		java.sql.Connection inConnection,
		String inCrpro_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_PROCESOF_SELECT_CONTENT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrpro_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrpro_codigo CODIGO DEL PROCESO A CONSULTAR
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectDirectCGG_RES_PROCESO(
		java.sql.Connection inConnection,
		String inCrpro_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_PROCESOF_SELECT_CONTENT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrpro_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++){					
					tmpObj.put(results.getMetaData().getColumnName(i), results.getObject(i));
				}							
				outCgg_res_fase.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public  ArrayList<HashMap<String,Object>> selectDirectCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_FASE_S_CGG_RES_FASE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}
	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ISLA.
	* @return com.besixplus.sii.objects.Cgg_res_fase OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase_hijo> selectCGG_RES_FASE1(
		java.sql.Connection inConnection,
		String inCisla_codigo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase_hijo> outCgg_res_fase = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_hijo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_RES_FASE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase().getCGG_CRFAS_CODIGO());
			stmSelect.setString(3,inCisla_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase_hijo tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase_hijo();
				tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
				tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
				tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
				tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
				tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
				tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
				tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
				tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
				tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
				tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
				tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
				tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
				tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
				tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
				tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
				tmpCgg_res_fase.setCRFAS_SUMILLA(" ");
				
				ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> objFaseUsuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario>();
				com.besixplus.sii.objects.Cgg_res_fase_usuario objTmpFaseUsuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
				
				objTmpFaseUsuario.setCRFAS_CODIGO(tmpCgg_res_fase.getCRFAS_CODIGO());				
				objFaseUsuario = new com.besixplus.sii.db.Cgg_res_fase_usuario(objTmpFaseUsuario).selectCGG_RES_FASE(inConnection);
				if(objFaseUsuario.size()>=1){
					tmpCgg_res_fase.setCUSU_CODIGO(((com.besixplus.sii.objects.Cgg_res_fase_usuario)objFaseUsuario.get(0)).getCUSU_CODIGO());
				}				
				outCgg_res_fase.add(tmpCgg_res_fase);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrpro_codigo CODIGO DEL PROCESO A CONSULTAR.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectParentFaseByProceso(
		java.sql.Connection inConnection,
		String inCrpro_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_PARENT_FASE_SELECT_BY_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrpro_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update1(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_UPDATE1(?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_res_fase().getCRFAS_CODIGO());
			stmUpdate.setInt(2, this.getCgg_res_fase().getCRFAS_ORDEN());
			stmUpdate.setString(3, this.getCgg_res_fase().getCRFAS_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * SELECCIONA TODAS LAS FASES CON INFORMACION DE USUARIO DE FASE DE UN PROCESO EN BASE AL CODIGO DEL MISMO ESPECIFICADO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGSITRO DE ISLA.
	 * @return COLECCION DE DATOS DE FASES CON INFORMACION DE USUARIO DE FASE.
	 */
	public ArrayList<HashMap<String, Object>> selectCGG_RES_PROCESO1(
			java.sql.Connection inConnection,
			String inCisla_codigo
		){
		ArrayList<HashMap<String, Object>> outCgg_res_fase = new ArrayList<HashMap<String, Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_S_CGG_RES_PROCESO(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,this.getCgg_res_fase().getCRPRO_CODIGO());
				stmSelect.setString(3,inCisla_codigo);				
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_fase.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_fase;
		}
	
	/**
	 * SELECCIONA LA FASE INICIAL DE UN PROCESO PARA EL REGISTRO DE UN TRAMITE.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @return OBJETO DE FASE SELECCIONADO.
	 */
	public com.besixplus.sii.objects.Cgg_res_fase selectFaseInicio(
			java.sql.Connection inConnection,
			String inCisla_codigo
		){
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_INICIO(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,this.getCgg_res_fase().getCRPRO_CODIGO());
				stmSelect.setString(3,inCisla_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				while (results.next()) {
					this.getCgg_res_fase().setCRFAS_CODIGO(results.getString(1));
					this.getCgg_res_fase().setCRPRO_CODIGO(results.getString(2));
					this.getCgg_res_fase().setCRETT_CODIGO(results.getString(3));
					this.getCgg_res_fase().setCGG_CRETT_CODIGO(results.getString(4));
					this.getCgg_res_fase().setCRSEC_CODIGO(results.getString(5));
					this.getCgg_res_fase().setCGG_CRFAS_CODIGO(results.getString(6));
					this.getCgg_res_fase().setCGG_CUSU_CODIGO(results.getString(7));
					this.getCgg_res_fase().setCRFAS_NOMBRE(results.getString(8));
					this.getCgg_res_fase().setCRFAS_ORDEN(results.getInt(9));
					this.getCgg_res_fase().setCRFAS_TAREA_REALIZA(results.getString(10));
					this.getCgg_res_fase().setCRFAS_FUNCION_EJECUTA(results.getString(11));
					this.getCgg_res_fase().setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
					this.getCgg_res_fase().setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
					this.getCgg_res_fase().setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
					this.getCgg_res_fase().setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
					this.getCgg_res_fase().setCRFAS_ESTADO(results.getBoolean(16));					
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return this.getCgg_res_fase();
		}
	
	/**
	 * SELECCIONA LA ULTIMA FASE DE UN PROCESO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @return OBJETO DE FASE SELECCIONADO.
	 */
	public com.besixplus.sii.objects.Cgg_res_fase selectFaseFinalizacion(
			java.sql.Connection inConnection,
			String inCisla_codigo
		){
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_FINALIZACION(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,this.getCgg_res_fase().getCRPRO_CODIGO());
				stmSelect.setString(3,inCisla_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				while (results.next()) {
					this.getCgg_res_fase().setCRFAS_CODIGO(results.getString(1));
					this.getCgg_res_fase().setCRPRO_CODIGO(results.getString(2));
					this.getCgg_res_fase().setCRETT_CODIGO(results.getString(3));
					this.getCgg_res_fase().setCGG_CRETT_CODIGO(results.getString(4));
					this.getCgg_res_fase().setCRSEC_CODIGO(results.getString(5));
					this.getCgg_res_fase().setCGG_CRFAS_CODIGO(results.getString(6));
					this.getCgg_res_fase().setCGG_CUSU_CODIGO(results.getString(7));
					this.getCgg_res_fase().setCRFAS_NOMBRE(results.getString(8));
					this.getCgg_res_fase().setCRFAS_ORDEN(results.getInt(9));
					this.getCgg_res_fase().setCRFAS_TAREA_REALIZA(results.getString(10));
					this.getCgg_res_fase().setCRFAS_FUNCION_EJECUTA(results.getString(11));
					this.getCgg_res_fase().setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
					this.getCgg_res_fase().setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
					this.getCgg_res_fase().setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
					this.getCgg_res_fase().setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
					this.getCgg_res_fase().setCRFAS_ESTADO(results.getBoolean(16));
					
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return this.getCgg_res_fase();
		}
	
	/**
	 * SELECCIONA LA FASE SIGUIENTE DE LA FASE ESPECIFICADO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @return COLECCION DE FASE.
	 */
	public Cgg_res_fase_hijo selectFaseSiguiente(
			java.sql.Connection inConnection,
			String inCisla_codigo
		){
		com.besixplus.sii.objects.Cgg_res_fase_hijo tmpCgg_res_fase = new com.besixplus.sii.objects.Cgg_res_fase_hijo();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_SIGUIENTE(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,this.getCgg_res_fase().getCRFAS_CODIGO());
				stmSelect.setString(3,inCisla_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				while (results.next()) {					
					tmpCgg_res_fase.setCRFAS_CODIGO(results.getString(1));
					tmpCgg_res_fase.setCRPRO_CODIGO(results.getString(2));
					tmpCgg_res_fase.setCRETT_CODIGO(results.getString(3));
					tmpCgg_res_fase.setCGG_CRETT_CODIGO(results.getString(4));
					tmpCgg_res_fase.setCRSEC_CODIGO(results.getString(5));
					tmpCgg_res_fase.setCGG_CRFAS_CODIGO(results.getString(6));
					tmpCgg_res_fase.setCGG_CUSU_CODIGO(results.getString(7));
					tmpCgg_res_fase.setCRFAS_NOMBRE(results.getString(8));
					tmpCgg_res_fase.setCRFAS_ORDEN(results.getInt(9));
					tmpCgg_res_fase.setCRFAS_TAREA_REALIZA(results.getString(10));
					tmpCgg_res_fase.setCRFAS_FUNCION_EJECUTA(results.getString(11));
					tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO(results.getBoolean(12));
					tmpCgg_res_fase.setCRFAS_SUBE_ADJUNTO_REQUISITO(results.getBoolean(13));
					tmpCgg_res_fase.setCRFAS_EJECUTA_DESPACHO(results.getBoolean(14));
					tmpCgg_res_fase.setCRFAS_ATENCION_NORMAL(results.getBoolean(15));
					tmpCgg_res_fase.setCRFAS_ESTADO(results.getBoolean(16));
					tmpCgg_res_fase.setCRFAS_SUMILLA(" ");
					
					ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> objFaseUsuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario>();
					com.besixplus.sii.objects.Cgg_res_fase_usuario objTmpFaseUsuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
					
					objTmpFaseUsuario.setCRFAS_CODIGO(tmpCgg_res_fase.getCRFAS_CODIGO());				
					objFaseUsuario = new com.besixplus.sii.db.Cgg_res_fase_usuario(objTmpFaseUsuario).selectCGG_RES_FASE(inConnection);
					if(objFaseUsuario.size()>=1){
						tmpCgg_res_fase.setCUSU_CODIGO(((com.besixplus.sii.objects.Cgg_res_fase_usuario)objFaseUsuario.get(0)).getCUSU_CODIGO());
					}									
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return tmpCgg_res_fase;
		}

}