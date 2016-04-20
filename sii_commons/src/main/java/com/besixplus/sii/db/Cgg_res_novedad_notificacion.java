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
* CLASE Cgg_res_novedad_notificacion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_novedad_notificacion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_novedad_notificacion implements Serializable{
	private static final long serialVersionUID = 470081497;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_novedad_notificacion.
	*/
	private com.besixplus.sii.objects.Cgg_res_novedad_notificacion myCgg_res_novedad_notificacion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_novedad_notificacion.
	*/
	public Cgg_res_novedad_notificacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_novedad_notificacion.
	* @param inCgg_res_novedad_notificacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_novedad_notificacion.
	*/
	public Cgg_res_novedad_notificacion(
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion inCgg_res_novedad_notificacion
	){
		this.setCgg_res_novedad_notificacion(inCgg_res_novedad_notificacion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_novedad_notificacion.
	* @param inCgg_res_novedad_notificacion OBJETO Cgg_res_novedad_notificacion.
	* @return void
	*/
	public void setCgg_res_novedad_notificacion(com.besixplus.sii.objects.Cgg_res_novedad_notificacion inCgg_res_novedad_notificacion){
		this.myCgg_res_novedad_notificacion = inCgg_res_novedad_notificacion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_novedad_notificacion.
	* @return Cgg_res_novedad_notificacion OBJETO Cgg_res_novedad_notificacion.
	*/
	public com.besixplus.sii.objects.Cgg_res_novedad_notificacion getCgg_res_novedad_notificacion(){
		return this.myCgg_res_novedad_notificacion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_novedad_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_INSERT(?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_novedad_notificacion().getCRNOV_CODIGO());
			stmInsert.setString(3, this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
			stmInsert.setTimestamp(4, this.getCgg_res_novedad_notificacion().getCRNOV_FECHA_REGISTRO()==null?null:new java.sql.Timestamp(this.getCgg_res_novedad_notificacion().getCRNOV_FECHA_REGISTRO().getTime()));
			stmInsert.setString(5, this.getCgg_res_novedad_notificacion().getCRNOV_DESCRIPCION());
			stmInsert.setInt(6, this.getCgg_res_novedad_notificacion().getCRNOV_TIPO());
			stmInsert.setBoolean(7, this.getCgg_res_novedad_notificacion().getCRNOV_ESTADO());
			stmInsert.setString(8, this.getCgg_res_novedad_notificacion().getCRNOV_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_res_novedad_notificacion().getCRNOV_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_novedad_notificacion().setCRNOV_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> outCgg_res_novedad_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpCgg_res_novedad_notificacion = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
				tmpCgg_res_novedad_notificacion.setCRNOV_CODIGO(results.getString(1));
				tmpCgg_res_novedad_notificacion.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_novedad_notificacion.setCRNOV_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_novedad_notificacion.setCRNOV_DESCRIPCION(results.getString(4));
				tmpCgg_res_novedad_notificacion.setCRNOV_TIPO(results.getInt(5));
				tmpCgg_res_novedad_notificacion.setCRNOV_ESTADO(results.getBoolean(6));
				outCgg_res_novedad_notificacion.add(tmpCgg_res_novedad_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_novedad_notificacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> outCgg_res_novedad_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpCgg_res_novedad_notificacion = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
				tmpCgg_res_novedad_notificacion.setCRNOV_CODIGO(results.getString(1));
				tmpCgg_res_novedad_notificacion.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_novedad_notificacion.setCRNOV_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_novedad_notificacion.setCRNOV_DESCRIPCION(results.getString(4));
				tmpCgg_res_novedad_notificacion.setCRNOV_TIPO(results.getInt(5));
				tmpCgg_res_novedad_notificacion.setCRNOV_ESTADO(results.getBoolean(6));
				outCgg_res_novedad_notificacion.add(tmpCgg_res_novedad_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_novedad_notificacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_novedad_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_novedad_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_novedad_notificacion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_novedad_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_novedad_notificacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_UPDATE(?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_novedad_notificacion().getCRNOV_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_res_novedad_notificacion().getCRNOV_FECHA_REGISTRO().getTime()));
			stmUpdate.setString(4, this.getCgg_res_novedad_notificacion().getCRNOV_DESCRIPCION());
			stmUpdate.setInt(5, this.getCgg_res_novedad_notificacion().getCRNOV_TIPO());
			stmUpdate.setBoolean(6, this.getCgg_res_novedad_notificacion().getCRNOV_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_novedad_notificacion().getCRNOV_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_novedad_notificacion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_novedad_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_novedad_notificacion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_novedad_notificacion().getCRNOV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_novedad_notificacion().setCRNOV_CODIGO(results.getString(1));
				this.getCgg_res_novedad_notificacion().setCRSEG_CODIGO(results.getString(2));
				this.getCgg_res_novedad_notificacion().setCRNOV_FECHA_REGISTRO(results.getTimestamp(3));
				this.getCgg_res_novedad_notificacion().setCRNOV_DESCRIPCION(results.getString(4));
				this.getCgg_res_novedad_notificacion().setCRNOV_TIPO(results.getInt(5));
				this.getCgg_res_novedad_notificacion().setCRNOV_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_novedad_notificacion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_novedad_notificacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_novedad_notificacion().getCRNOV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_novedad_notificacion().getCRNOV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_novedad_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> selectCGG_RES_SEGUIMIENTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> outCgg_res_novedad_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpCgg_res_novedad_notificacion = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
				tmpCgg_res_novedad_notificacion.setCRNOV_CODIGO(results.getString(1));
				tmpCgg_res_novedad_notificacion.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_novedad_notificacion.setCRNOV_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_novedad_notificacion.setCRNOV_DESCRIPCION(results.getString(4));
				tmpCgg_res_novedad_notificacion.setCRNOV_TIPO(results.getInt(5));
				tmpCgg_res_novedad_notificacion.setCRNOV_ESTADO(results.getBoolean(6));
				outCgg_res_novedad_notificacion.add(tmpCgg_res_novedad_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_novedad_notificacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SEGUIMIENTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_DS_CGG_RES_SEGUIMIENTO(?) }");
				stmDelete.setString(1, this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
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
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SEGUIMIENTO1(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}
	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento de manera recursiva entre los seguimientos padres de este seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_novedad_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	@Deprecated
	public ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> selectCGG_RES_SEGUIMIENTO1(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> outCgg_res_novedad_notificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_NOTIFICACION_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpCgg_res_novedad_notificacion = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
				tmpCgg_res_novedad_notificacion.setCRNOV_CODIGO(results.getString(1));
				tmpCgg_res_novedad_notificacion.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_novedad_notificacion.setCRNOV_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_novedad_notificacion.setCRNOV_DESCRIPCION(results.getString(4));
				tmpCgg_res_novedad_notificacion.setCRNOV_TIPO(results.getInt(5));
				tmpCgg_res_novedad_notificacion.setCRNOV_ESTADO(results.getBoolean(6));
				tmpCgg_res_novedad_notificacion.setCRNOV_USUARIO_INSERT(results.getString(8));
				tmpCgg_res_novedad_notificacion.setCRNOV_USUARIO_UPDATE(results.getString(10));
				outCgg_res_novedad_notificacion.add(tmpCgg_res_novedad_notificacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_novedad_notificacion;
	}
	
	/**
	 * SELECCIONA TODAS LAS NOVEDADES DE UN TRAMITE HASTA EL SEGUIMIENTO ESPECIFICADO.
	 * @param inConnection CONEXION DE DATOS.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE TRAMITE.
	 * @return COLECCION DE ADJUNTOS.
	 */
	public ArrayList<HashMap<String,Object>> selectNovedadTramite(
			java.sql.Connection inConnection,
			String inCrtra_codigo		
		){
			ArrayList<HashMap<String,Object>> outCgg_res_novedad_notificacion = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_NOVEDAD_TRAMITE(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inCrtra_codigo);
				stmSelect.setString(3, this.getCgg_res_novedad_notificacion().getCRSEG_CODIGO());				
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)						
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_novedad_notificacion.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_novedad_notificacion;
		}

}