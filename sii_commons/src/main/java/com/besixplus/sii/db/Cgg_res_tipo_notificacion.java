package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_tipo_notificacion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tipo_notificacion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tipo_notificacion implements Serializable{
	private static final long serialVersionUID = 583998361;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tipo_notificacion.
	*/
	private com.besixplus.sii.objects.Cgg_res_tipo_notificacion myCgg_res_tipo_notificacion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_notificacion.
	*/
	public Cgg_res_tipo_notificacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_notificacion.
	* @param inCgg_res_tipo_notificacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tipo_notificacion.
	*/
	public Cgg_res_tipo_notificacion(
		com.besixplus.sii.objects.Cgg_res_tipo_notificacion inCgg_res_tipo_notificacion
	){
		this.setCgg_res_tipo_notificacion(inCgg_res_tipo_notificacion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tipo_notificacion.
	* @param inCgg_res_tipo_notificacion OBJETO Cgg_res_tipo_notificacion.
	* @return void
	*/
	public void setCgg_res_tipo_notificacion(com.besixplus.sii.objects.Cgg_res_tipo_notificacion inCgg_res_tipo_notificacion){
		this.myCgg_res_tipo_notificacion = inCgg_res_tipo_notificacion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tipo_notificacion.
	* @return Cgg_res_tipo_notificacion OBJETO Cgg_res_tipo_notificacion.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_notificacion getCgg_res_tipo_notificacion(){
		return this.myCgg_res_tipo_notificacion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tipo_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_NOTIFICACION_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tipo_notificacion().getCRTNT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tipo_notificacion().getCRTNT_DESCRIPCION());
			stmInsert.setBoolean(4, this.getCgg_res_tipo_notificacion().getCRTNT_CAUSAL_SALIDA());
			stmInsert.setString(5, this.getCgg_res_tipo_notificacion().getCRTNT_SUSTENTO_LEGAL());
			stmInsert.setBoolean(6, this.getCgg_res_tipo_notificacion().getCRTNT_CAUSAL_CADUCIDAD());
			stmInsert.setBoolean(7, this.getCgg_res_tipo_notificacion().getCRTNT_ESTADO());
			stmInsert.setString(8, this.getCgg_res_tipo_notificacion().getCRTNT_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_res_tipo_notificacion().getCRTNT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_tipo_notificacion().setCRTNT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> outCgg_res_tipo_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_NOTIFICACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_notificacion tmpCgg_res_tipo_notificacion = new com.besixplus.sii.objects.Cgg_res_tipo_notificacion();
				tmpCgg_res_tipo_notificacion.setCRTNT_CODIGO(results.getString(1));
				tmpCgg_res_tipo_notificacion.setCRTNT_DESCRIPCION(results.getString(2));
				tmpCgg_res_tipo_notificacion.setCRTNT_CAUSAL_SALIDA(results.getBoolean(3));
				tmpCgg_res_tipo_notificacion.setCRTNT_SUSTENTO_LEGAL(results.getString(4));
				tmpCgg_res_tipo_notificacion.setCRTNT_CAUSAL_CADUCIDAD(results.getBoolean(5));
				tmpCgg_res_tipo_notificacion.setCRTNT_ESTADO(results.getBoolean(6));
				outCgg_res_tipo_notificacion.add(tmpCgg_res_tipo_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_notificacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_notificacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> outCgg_res_tipo_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_NOTIFICACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tipo_notificacion tmpCgg_res_tipo_notificacion = new com.besixplus.sii.objects.Cgg_res_tipo_notificacion();
				tmpCgg_res_tipo_notificacion.setCRTNT_CODIGO(results.getString(1));
				tmpCgg_res_tipo_notificacion.setCRTNT_DESCRIPCION(results.getString(2));
				tmpCgg_res_tipo_notificacion.setCRTNT_CAUSAL_SALIDA(results.getBoolean(3));
				tmpCgg_res_tipo_notificacion.setCRTNT_SUSTENTO_LEGAL(results.getString(4));
				tmpCgg_res_tipo_notificacion.setCRTNT_CAUSAL_CADUCIDAD(results.getBoolean(5));
				tmpCgg_res_tipo_notificacion.setCRTNT_ESTADO(results.getBoolean(6));
				outCgg_res_tipo_notificacion.add(tmpCgg_res_tipo_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_notificacion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_tipo_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_NOTIFICACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_NOTIFICACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tipo_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_NOTIFICACION_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_tipo_notificacion().getCRTNT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tipo_notificacion().getCRTNT_DESCRIPCION());
			stmUpdate.setBoolean(3, this.getCgg_res_tipo_notificacion().getCRTNT_CAUSAL_SALIDA());
			stmUpdate.setString(4, this.getCgg_res_tipo_notificacion().getCRTNT_SUSTENTO_LEGAL());
			stmUpdate.setBoolean(5, this.getCgg_res_tipo_notificacion().getCRTNT_CAUSAL_CADUCIDAD());
			stmUpdate.setBoolean(6, this.getCgg_res_tipo_notificacion().getCRTNT_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_tipo_notificacion().getCRTNT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tipo_notificacion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_notificacion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_NOTIFICACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_notificacion().getCRTNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tipo_notificacion().setCRTNT_CODIGO(results.getString(1));
				this.getCgg_res_tipo_notificacion().setCRTNT_DESCRIPCION(results.getString(2));
				this.getCgg_res_tipo_notificacion().setCRTNT_CAUSAL_SALIDA(results.getBoolean(3));
				this.getCgg_res_tipo_notificacion().setCRTNT_SUSTENTO_LEGAL(results.getString(4));
				this.getCgg_res_tipo_notificacion().setCRTNT_CAUSAL_CADUCIDAD(results.getBoolean(5));
				this.getCgg_res_tipo_notificacion().setCRTNT_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tipo_notificacion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tipo_notificacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_NOTIFICACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_notificacion().getCRTNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_NOTIFICACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_notificacion().getCRTNT_CODIGO());
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