package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_proceso
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_proceso.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_proceso implements Serializable{
	private static final long serialVersionUID = 2110468032;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_proceso.
	*/
	private com.besixplus.sii.objects.Cgg_res_proceso myCgg_res_proceso = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_proceso.
	*/
	public Cgg_res_proceso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_proceso.
	* @param inCgg_res_proceso OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_proceso.
	*/
	public Cgg_res_proceso(
		com.besixplus.sii.objects.Cgg_res_proceso inCgg_res_proceso
	){
		this.setCgg_res_proceso(inCgg_res_proceso);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_proceso.
	* @param inCgg_res_proceso OBJETO Cgg_res_proceso.
	* @return void
	*/
	public void setCgg_res_proceso(com.besixplus.sii.objects.Cgg_res_proceso inCgg_res_proceso){
		this.myCgg_res_proceso = inCgg_res_proceso;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_proceso.
	* @return Cgg_res_proceso OBJETO Cgg_res_proceso.
	*/
	public com.besixplus.sii.objects.Cgg_res_proceso getCgg_res_proceso(){
		return this.myCgg_res_proceso;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_proceso().getCRPRO_CODIGO());
			stmInsert.setString(3, this.getCgg_res_proceso().getCRPRO_NOMBRE());
			stmInsert.setBoolean(4, this.getCgg_res_proceso().getCRPRO_ESTADO());
			stmInsert.setString(5, this.getCgg_res_proceso().getCRPRO_USUARIO_INSERT());
			stmInsert.setString(6, this.getCgg_res_proceso().getCRPRO_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_proceso().setCRPRO_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_proceso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_proceso> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_proceso> outCgg_res_proceso = new ArrayList<com.besixplus.sii.objects.Cgg_res_proceso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_proceso tmpCgg_res_proceso = new com.besixplus.sii.objects.Cgg_res_proceso();
				tmpCgg_res_proceso.setCRPRO_CODIGO(results.getString(1));
				tmpCgg_res_proceso.setCRPRO_NOMBRE(results.getString(2));
				tmpCgg_res_proceso.setCRPRO_ESTADO(results.getBoolean(3));
				outCgg_res_proceso.add(tmpCgg_res_proceso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_proceso;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_proceso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_proceso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_proceso> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_proceso> outCgg_res_proceso = new ArrayList<com.besixplus.sii.objects.Cgg_res_proceso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_proceso tmpCgg_res_proceso = new com.besixplus.sii.objects.Cgg_res_proceso();
				tmpCgg_res_proceso.setCRPRO_CODIGO(results.getString(1));
				tmpCgg_res_proceso.setCRPRO_NOMBRE(results.getString(2));
				tmpCgg_res_proceso.setCRPRO_ESTADO(results.getBoolean(3));
				outCgg_res_proceso.add(tmpCgg_res_proceso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_proceso;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PROCESO_UPDATE(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_proceso().getCRPRO_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_proceso().getCRPRO_NOMBRE());
			stmUpdate.setBoolean(3, this.getCgg_res_proceso().getCRPRO_ESTADO());
			stmUpdate.setString(4, this.getCgg_res_proceso().getCRPRO_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_proceso DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_proceso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_proceso select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_proceso().getCRPRO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_proceso().setCRPRO_CODIGO(results.getString(1));
				this.getCgg_res_proceso().setCRPRO_NOMBRE(results.getString(2));
				this.getCgg_res_proceso().setCRPRO_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_proceso();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_proceso DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PROCESO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_proceso().getCRPRO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PROCESO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_proceso().getCRPRO_CODIGO());
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
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_proceso CORRESPONDIENTE A UN TIPO DE SOLICITUD DE TRAMITE.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	* @return com.besixplus.sii.objects.Cgg_res_proceso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_proceso selectByTipoSolicitudTramite(
		java.sql.Connection inConnection,
		String inCrtst_codigo
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PROCESO_SELECT_BY_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrtst_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_proceso().setCRPRO_CODIGO(results.getString(1));
				this.getCgg_res_proceso().setCRPRO_NOMBRE(results.getString(2));
				this.getCgg_res_proceso().setCRPRO_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_proceso();
	}

}