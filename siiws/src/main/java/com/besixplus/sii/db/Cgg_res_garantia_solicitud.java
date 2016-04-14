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
 * CLASE Cgg_res_garantia_solicitud
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_garantia_solicitud.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_garantia_solicitud implements Serializable{
	private static final long serialVersionUID = 479923536;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_garantia_solicitud.
	 */
	private com.besixplus.sii.objects.Cgg_res_garantia_solicitud myCgg_res_garantia_solicitud = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_garantia_solicitud.
	 */
	public Cgg_res_garantia_solicitud(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_garantia_solicitud.
	 * @param inCgg_res_garantia_solicitud OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_garantia_solicitud.
	 */
	public Cgg_res_garantia_solicitud(
			com.besixplus.sii.objects.Cgg_res_garantia_solicitud inCgg_res_garantia_solicitud
	){
		this.setCgg_res_garantia_solicitud(inCgg_res_garantia_solicitud);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_garantia_solicitud.
	 * @param inCgg_res_garantia_solicitud OBJETO Cgg_res_garantia_solicitud.
	 * @return void
	 */
	public void setCgg_res_garantia_solicitud(com.besixplus.sii.objects.Cgg_res_garantia_solicitud inCgg_res_garantia_solicitud){
		this.myCgg_res_garantia_solicitud = inCgg_res_garantia_solicitud;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_garantia_solicitud.
	 * @return Cgg_res_garantia_solicitud OBJETO Cgg_res_garantia_solicitud.
	 */
	public com.besixplus.sii.objects.Cgg_res_garantia_solicitud getCgg_res_garantia_solicitud(){
		return this.myCgg_res_garantia_solicitud;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_garantia_solicitud.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_garantia_solicitud().getCRGTS_CODIGO());
			stmInsert.setString(3, this.getCgg_res_garantia_solicitud().getCRGRT_CODIGO());
			stmInsert.setString(4, this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_res_garantia_solicitud().getCRGTS_ESTADO());
			stmInsert.setString(6, this.getCgg_res_garantia_solicitud().getCRGTS_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_res_garantia_solicitud().getCRGTS_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_garantia_solicitud().setCRGTS_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> outCgg_res_garantia_solicitud = new ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_garantia_solicitud tmpCgg_res_garantia_solicitud = new com.besixplus.sii.objects.Cgg_res_garantia_solicitud();
				tmpCgg_res_garantia_solicitud.setCRGTS_CODIGO(results.getString(1));
				tmpCgg_res_garantia_solicitud.setCRGRT_CODIGO(results.getString(2));
				tmpCgg_res_garantia_solicitud.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_garantia_solicitud.setCRGTS_ESTADO(results.getBoolean(4));
				outCgg_res_garantia_solicitud.add(tmpCgg_res_garantia_solicitud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia_solicitud;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> outCgg_res_garantia_solicitud = new ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_garantia_solicitud tmpCgg_res_garantia_solicitud = new com.besixplus.sii.objects.Cgg_res_garantia_solicitud();
				tmpCgg_res_garantia_solicitud.setCRGTS_CODIGO(results.getString(1));
				tmpCgg_res_garantia_solicitud.setCRGRT_CODIGO(results.getString(2));
				tmpCgg_res_garantia_solicitud.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_garantia_solicitud.setCRGTS_ESTADO(results.getBoolean(4));
				outCgg_res_garantia_solicitud.add(tmpCgg_res_garantia_solicitud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia_solicitud;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_garantia_solicitud.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_garantia_solicitud.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_garantia_solicitud().getCRGTS_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_garantia_solicitud().getCRGRT_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_res_garantia_solicitud().getCRGTS_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_garantia_solicitud().getCRGTS_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_garantia_solicitud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_garantia_solicitud select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_garantia_solicitud().getCRGTS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_garantia_solicitud().setCRGTS_CODIGO(results.getString(1));
				this.getCgg_res_garantia_solicitud().setCRGRT_CODIGO(results.getString(2));
				this.getCgg_res_garantia_solicitud().setCRTST_CODIGO(results.getString(3));
				this.getCgg_res_garantia_solicitud().setCRGTS_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_garantia_solicitud();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRGTS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRGTS_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_garantia_solicitud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> selectCGG_RES_GARANTIA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> outCgg_res_garantia_solicitud = new ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_S_CGG_RES_GARANTIA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_garantia_solicitud().getCRGRT_CODIGO());
			stmSelect.setString(3,this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_garantia_solicitud tmpCgg_res_garantia_solicitud = new com.besixplus.sii.objects.Cgg_res_garantia_solicitud();
				tmpCgg_res_garantia_solicitud.setCRGTS_CODIGO(results.getString(1));
				tmpCgg_res_garantia_solicitud.setCRGRT_CODIGO(results.getString(2));
				tmpCgg_res_garantia_solicitud.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_garantia_solicitud.setCRGTS_ESTADO(results.getBoolean(4));
				outCgg_res_garantia_solicitud.add(tmpCgg_res_garantia_solicitud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia_solicitud;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_garantia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_GARANTIA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_D_CGG_RES_GARANTIA(?) }");			
			stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{				
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_DS_CGG_RES_GARANTIA(?) }");				
				stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_garantia_solicitud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud> outCgg_res_garantia_solicitud = new ArrayList<com.besixplus.sii.objects.Cgg_res_garantia_solicitud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2,this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_garantia_solicitud tmpCgg_res_garantia_solicitud = new com.besixplus.sii.objects.Cgg_res_garantia_solicitud();
				tmpCgg_res_garantia_solicitud.setCRGTS_CODIGO(results.getString(1));
				tmpCgg_res_garantia_solicitud.setCRGRT_CODIGO(results.getString(2));
				tmpCgg_res_garantia_solicitud.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_garantia_solicitud.setCRGTS_ESTADO(results.getBoolean(4));
				outCgg_res_garantia_solicitud.add(tmpCgg_res_garantia_solicitud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia_solicitud;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_garantia_solicitud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>> selectCGG_RES_TIPO_SOLICITUD_TRAMITE1(
			java.sql.Connection inConnection
	){		
		ArrayList<HashMap<String,Object>> outCgg_res_garantia_solicitud = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SOLICITUD_S_CGG_RES_TIPO_SOLICITUD_TRAMITE1(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2,this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_garantia_solicitud.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia_solicitud;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_garantia_solicitud DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRGRT_CODIGO());
			stmDelete.setString(2, this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRGRT_CODIGO());
				stmDelete.setString(2, this.getCgg_res_garantia_solicitud().getCRTST_CODIGO());
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
	 * ELIMINA UN REGISTRO DE LA TABLA GARANTIA SOLICITUD DE ACUAERDO A SU CLAVE PRINCIPAL.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return VERDADERO/FALSO EN LA ELIMINACION DEL REGISTRO
	 */
	public String delete1(
			java.sql.Connection inConnection
	){
		String outResult = "true";						
		try{											
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_SOLICITUD_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_garantia_solicitud().getCRGTS_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}			
		return outResult;
	}

}