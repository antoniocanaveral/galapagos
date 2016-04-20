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
* CLASE Cgg_res_solicitud_requisito
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_solicitud_requisito.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_solicitud_requisito implements Serializable{
	private static final long serialVersionUID = 532083485;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_solicitud_requisito.
	*/
	private com.besixplus.sii.objects.Cgg_res_solicitud_requisito myCgg_res_solicitud_requisito = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_solicitud_requisito.
	*/
	public Cgg_res_solicitud_requisito(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_solicitud_requisito.
	* @param inCgg_res_solicitud_requisito OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_solicitud_requisito.
	*/
	public Cgg_res_solicitud_requisito(
		com.besixplus.sii.objects.Cgg_res_solicitud_requisito inCgg_res_solicitud_requisito
	){
		this.setCgg_res_solicitud_requisito(inCgg_res_solicitud_requisito);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_solicitud_requisito.
	* @param inCgg_res_solicitud_requisito OBJETO Cgg_res_solicitud_requisito.
	* @return void
	*/
	public void setCgg_res_solicitud_requisito(com.besixplus.sii.objects.Cgg_res_solicitud_requisito inCgg_res_solicitud_requisito){
		this.myCgg_res_solicitud_requisito = inCgg_res_solicitud_requisito;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_solicitud_requisito.
	* @return Cgg_res_solicitud_requisito OBJETO Cgg_res_solicitud_requisito.
	*/
	public com.besixplus.sii.objects.Cgg_res_solicitud_requisito getCgg_res_solicitud_requisito(){
		return this.myCgg_res_solicitud_requisito;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_solicitud_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_INSERT(?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_solicitud_requisito().getCRSRQ_CODIGO());
			stmInsert.setString(3, this.getCgg_res_solicitud_requisito().getCRREQ_CODIGO());
			stmInsert.setString(4, this.getCgg_res_solicitud_requisito().getCRTST_CODIGO());
			stmInsert.setString(5, this.getCgg_res_solicitud_requisito().getCRSRQ_DESCRIPCION());
			stmInsert.setBoolean(6, this.getCgg_res_solicitud_requisito().getCRSRQ_REQUERIDO());
			stmInsert.setInt(7, this.getCgg_res_solicitud_requisito().getCRSRQ_PARTICIPANTE());
			stmInsert.setBoolean(8, this.getCgg_res_solicitud_requisito().getCRSRQ_ESTADO());
			stmInsert.setString(9, this.getCgg_res_solicitud_requisito().getCRSRQ_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_solicitud_requisito().getCRSRQ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_solicitud_requisito().setCRSRQ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> outCgg_res_solicitud_requisito = new ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_solicitud_requisito tmpCgg_res_solicitud_requisito = new com.besixplus.sii.objects.Cgg_res_solicitud_requisito();
				tmpCgg_res_solicitud_requisito.setCRSRQ_CODIGO(results.getString(1));
				tmpCgg_res_solicitud_requisito.setCRREQ_CODIGO(results.getString(2));
				tmpCgg_res_solicitud_requisito.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_solicitud_requisito.setCRSRQ_DESCRIPCION(results.getString(4));
				tmpCgg_res_solicitud_requisito.setCRSRQ_REQUERIDO(results.getBoolean(5));
				tmpCgg_res_solicitud_requisito.setCRSRQ_PARTICIPANTE(results.getInt(6));
				tmpCgg_res_solicitud_requisito.setCRSRQ_ESTADO(results.getBoolean(7));
				outCgg_res_solicitud_requisito.add(tmpCgg_res_solicitud_requisito);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_solicitud_requisito;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> outCgg_res_solicitud_requisito = new ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_solicitud_requisito tmpCgg_res_solicitud_requisito = new com.besixplus.sii.objects.Cgg_res_solicitud_requisito();
				tmpCgg_res_solicitud_requisito.setCRSRQ_CODIGO(results.getString(1));
				tmpCgg_res_solicitud_requisito.setCRREQ_CODIGO(results.getString(2));
				tmpCgg_res_solicitud_requisito.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_solicitud_requisito.setCRSRQ_DESCRIPCION(results.getString(4));
				tmpCgg_res_solicitud_requisito.setCRSRQ_REQUERIDO(results.getBoolean(5));
				tmpCgg_res_solicitud_requisito.setCRSRQ_PARTICIPANTE(results.getInt(6));
				tmpCgg_res_solicitud_requisito.setCRSRQ_ESTADO(results.getBoolean(7));
				outCgg_res_solicitud_requisito.add(tmpCgg_res_solicitud_requisito);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_solicitud_requisito;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_solicitud_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_solicitud_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_SOLICITUD_REQUISITO_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_solicitud_requisito().getCRSRQ_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_solicitud_requisito().getCRREQ_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_solicitud_requisito().getCRTST_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_solicitud_requisito().getCRSRQ_DESCRIPCION());
			stmUpdate.setBoolean(5, this.getCgg_res_solicitud_requisito().getCRSRQ_REQUERIDO());
			stmUpdate.setInt(6, this.getCgg_res_solicitud_requisito().getCRSRQ_PARTICIPANTE());
			stmUpdate.setBoolean(7, this.getCgg_res_solicitud_requisito().getCRSRQ_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_solicitud_requisito().getCRSRQ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_solicitud_requisito OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_solicitud_requisito select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_solicitud_requisito().getCRSRQ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_solicitud_requisito().setCRSRQ_CODIGO(results.getString(1));
				this.getCgg_res_solicitud_requisito().setCRREQ_CODIGO(results.getString(2));
				this.getCgg_res_solicitud_requisito().setCRTST_CODIGO(results.getString(3));
				this.getCgg_res_solicitud_requisito().setCRSRQ_DESCRIPCION(results.getString(4));
				this.getCgg_res_solicitud_requisito().setCRSRQ_REQUERIDO(results.getBoolean(5));
				this.getCgg_res_solicitud_requisito().setCRSRQ_PARTICIPANTE(results.getInt(6));
				this.getCgg_res_solicitud_requisito().setCRSRQ_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_solicitud_requisito();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String delete(
		java.sql.Connection inConnection
	){
		String outResult = "true";		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SOLICITUD_REQUISITO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_solicitud_requisito().getCRSRQ_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}		
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_solicitud_requisito OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> selectCGG_RES_REQUISITO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> outCgg_res_solicitud_requisito = new ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_S_CGG_RES_REQUISITO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_solicitud_requisito().getCRREQ_CODIGO());
			stmSelect.setString(3,this.getCgg_res_solicitud_requisito().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_solicitud_requisito tmpCgg_res_solicitud_requisito = new com.besixplus.sii.objects.Cgg_res_solicitud_requisito();
				tmpCgg_res_solicitud_requisito.setCRSRQ_CODIGO(results.getString(1));
				tmpCgg_res_solicitud_requisito.setCRREQ_CODIGO(results.getString(2));
				tmpCgg_res_solicitud_requisito.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_solicitud_requisito.setCRSRQ_DESCRIPCION(results.getString(4));
				tmpCgg_res_solicitud_requisito.setCRSRQ_REQUERIDO(results.getBoolean(5));
				tmpCgg_res_solicitud_requisito.setCRSRQ_PARTICIPANTE(results.getInt(6));
				tmpCgg_res_solicitud_requisito.setCRSRQ_ESTADO(results.getBoolean(7));
				outCgg_res_solicitud_requisito.add(tmpCgg_res_solicitud_requisito);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_solicitud_requisito;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_REQUISITO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SOLICITUD_REQUISITO_D_CGG_RES_REQUISITO(? ) }");
			stmDelete.setString(1, this.getCgg_res_solicitud_requisito().getCRREQ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SOLICITUD_REQUISITO_DS_CGG_RES_REQUISITO(? ) }");
				stmDelete.setString(1, this.getCgg_res_solicitud_requisito().getCRREQ_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_solicitud_requisito OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> outCgg_res_solicitud_requisito = new ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2,this.getCgg_res_solicitud_requisito().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_solicitud_requisito tmpCgg_res_solicitud_requisito = new com.besixplus.sii.objects.Cgg_res_solicitud_requisito();
				tmpCgg_res_solicitud_requisito.setCRSRQ_CODIGO(results.getString(1));
				tmpCgg_res_solicitud_requisito.setCRREQ_CODIGO(results.getString(2));
				tmpCgg_res_solicitud_requisito.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_solicitud_requisito.setCRSRQ_DESCRIPCION(results.getString(4));
				tmpCgg_res_solicitud_requisito.setCRSRQ_REQUERIDO(results.getBoolean(5));
				tmpCgg_res_solicitud_requisito.setCRSRQ_PARTICIPANTE(results.getInt(6));
				tmpCgg_res_solicitud_requisito.setCRSRQ_ESTADO(results.getBoolean(7));
				outCgg_res_solicitud_requisito.add(tmpCgg_res_solicitud_requisito);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_solicitud_requisito;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SOLICITUD_REQUISITO_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");																			   
			stmDelete.setString(1, this.getCgg_res_solicitud_requisito().getCRTST_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}	

	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_solicitud_requisito DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD DE TRAMITE.
	* @return com.besixplus.sii.objects.Cgg_res_solicitud_requisito OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectTIPO_SOLICITUD_TRAMITE_REQUISITOS_ALL(
			java.sql.Connection inConnection,
			String inCrtst_codigo
			
		){
			ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SOLICITUD_REQUISITO_S_TIPO_SOLICITUD_S_REQUISITO_ALL(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCrtst_codigo);						
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_tipo_solicitud_tramite.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_tipo_solicitud_tramite;
		}
	
}