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
* CLASE Cgg_res_movilidad
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_movilidad.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_movilidad implements Serializable{
	private static final long serialVersionUID = 1342899542;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_movilidad.
	*/
	private com.besixplus.sii.objects.Cgg_res_movilidad myCgg_res_movilidad = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad.
	*/
	public Cgg_res_movilidad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad.
	* @param inCgg_res_movilidad OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_movilidad.
	*/
	public Cgg_res_movilidad(
		com.besixplus.sii.objects.Cgg_res_movilidad inCgg_res_movilidad
	){
		this.setCgg_res_movilidad(inCgg_res_movilidad);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_movilidad.
	* @param inCgg_res_movilidad OBJETO Cgg_res_movilidad.
	* @return void
	*/
	public void setCgg_res_movilidad(com.besixplus.sii.objects.Cgg_res_movilidad inCgg_res_movilidad){
		this.myCgg_res_movilidad = inCgg_res_movilidad;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_movilidad.
	* @return Cgg_res_movilidad OBJETO Cgg_res_movilidad.
	*/
	public com.besixplus.sii.objects.Cgg_res_movilidad getCgg_res_movilidad(){
		return this.myCgg_res_movilidad;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_movilidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_movilidad().getCRMOV_CODIGO());
			stmInsert.setString(3, this.getCgg_res_movilidad().getCRALN_CODIGO());
			stmInsert.setString(4, this.getCgg_res_movilidad().getCARPT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_movilidad().getCGG_CARPT_CODIGO());
			stmInsert.setString(6, this.getCgg_res_movilidad().getCRPER_CODIGO());
			stmInsert.setString(7, this.getCgg_res_movilidad().getCTREG_CODIGO());
			stmInsert.setString(8, this.getCgg_res_movilidad().getCRRSD_CODIGO());
			stmInsert.setTimestamp(9, new java.sql.Timestamp(this.getCgg_res_movilidad().getCRMOV_FECHA_VIAJE().getTime()));
			stmInsert.setInt(10, this.getCgg_res_movilidad().getCRMOV_TIPO_OPERACION());
			stmInsert.setString(11, this.getCgg_res_movilidad().getCRMOV_NUMERO_VUELO());
			stmInsert.setString(12, this.getCgg_res_movilidad().getCRMOV_OBSERVACION());
			stmInsert.setInt(13, this.getCgg_res_movilidad().getCRMOV_TIPO_SALIDA());
			stmInsert.setBoolean(14, this.getCgg_res_movilidad().getCRMOV_FILTRO_INTERNO());
			stmInsert.setBoolean(15, this.getCgg_res_movilidad().getCRMOV_SOPORTE());
			stmInsert.setBoolean(16, this.getCgg_res_movilidad().getCRMOV_ESTADO());
			stmInsert.setString(17, this.getCgg_res_movilidad().getCRMOV_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_movilidad().setCRMOV_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_movilidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_movilidad().getCRMOV_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_movilidad().getCRALN_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_movilidad().getCARPT_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_movilidad().getCGG_CARPT_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_movilidad().getCRPER_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_movilidad().getCTREG_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_movilidad().getCRRSD_CODIGO());
			stmUpdate.setTimestamp(8, new java.sql.Timestamp(this.getCgg_res_movilidad().getCRMOV_FECHA_VIAJE().getTime()));
			stmUpdate.setInt(9, this.getCgg_res_movilidad().getCRMOV_TIPO_OPERACION());
			stmUpdate.setString(10, this.getCgg_res_movilidad().getCRMOV_NUMERO_VUELO());
			stmUpdate.setString(11, this.getCgg_res_movilidad().getCRMOV_OBSERVACION());
			stmUpdate.setInt(12, this.getCgg_res_movilidad().getCRMOV_TIPO_SALIDA());
			stmUpdate.setBoolean(13, this.getCgg_res_movilidad().getCRMOV_FILTRO_INTERNO());
			stmUpdate.setBoolean(14, this.getCgg_res_movilidad().getCRMOV_SOPORTE());
			stmUpdate.setBoolean(15, this.getCgg_res_movilidad().getCRMOV_ESTADO());
			stmUpdate.setString(16, this.getCgg_res_movilidad().getCRMOV_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_movilidad select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad().getCRMOV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_movilidad().setCRMOV_CODIGO(results.getString(1));
				this.getCgg_res_movilidad().setCRALN_CODIGO(results.getString(2));
				this.getCgg_res_movilidad().setCARPT_CODIGO(results.getString(3));
				this.getCgg_res_movilidad().setCGG_CARPT_CODIGO(results.getString(4));
				this.getCgg_res_movilidad().setCRPER_CODIGO(results.getString(5));
				this.getCgg_res_movilidad().setCTREG_CODIGO(results.getString(6));
				this.getCgg_res_movilidad().setCRRSD_CODIGO(results.getString(7));
				this.getCgg_res_movilidad().setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				this.getCgg_res_movilidad().setCRMOV_TIPO_OPERACION(results.getInt(9));
				this.getCgg_res_movilidad().setCRMOV_NUMERO_VUELO(results.getString(10));
				this.getCgg_res_movilidad().setCRMOV_OBSERVACION(results.getString(11));
				this.getCgg_res_movilidad().setCRMOV_TIPO_SALIDA(results.getInt(12));
				this.getCgg_res_movilidad().setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				this.getCgg_res_movilidad().setCRMOV_SOPORTE(results.getBoolean(14));
				this.getCgg_res_movilidad().setCRMOV_ESTADO(results.getBoolean(15));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_movilidad();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad().getCRMOV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad().getCRMOV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aerolinea.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectCGG_RES_AEROLINEA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_S_CGG_RES_AEROLINEA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad().getCRALN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aerolinea.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_D_CGG_RES_AEROLINEA(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad().getCRALN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DS_CGG_RES_AEROLINEA(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad().getCRALN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_S_CGG_RES_AEROPUERTO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad().getCARPT_CODIGO());
			stmSelect.setString(3,this.getCgg_res_movilidad().getCGG_CARPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_D_CGG_RES_AEROPUERTO(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad().getCARPT_CODIGO());
			stmDelete.setString(2, this.getCgg_res_movilidad().getCGG_CARPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DS_CGG_RES_AEROPUERTO(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad().getCARPT_CODIGO());
				stmDelete.setString(2, this.getCgg_res_movilidad().getCGG_CARPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectCGG_RES_RESIDENCIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_S_CGG_RES_RESIDENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad().getCRRSD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_residencia.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_D_CGG_RES_RESIDENCIA(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad().getCRRSD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DS_CGG_RES_RESIDENCIA(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad().getCRRSD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_registro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_movilidad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> selectCGG_TCT_REGISTRO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> outCgg_res_movilidad = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_S_CGG_TCT_REGISTRO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_movilidad().getCTREG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_movilidad tmpCgg_res_movilidad = new com.besixplus.sii.objects.Cgg_res_movilidad();
				tmpCgg_res_movilidad.setCRMOV_CODIGO(results.getString(1));
				tmpCgg_res_movilidad.setCRALN_CODIGO(results.getString(2));
				tmpCgg_res_movilidad.setCARPT_CODIGO(results.getString(3));
				tmpCgg_res_movilidad.setCGG_CARPT_CODIGO(results.getString(4));
				tmpCgg_res_movilidad.setCRPER_CODIGO(results.getString(5));
				tmpCgg_res_movilidad.setCTREG_CODIGO(results.getString(6));
				tmpCgg_res_movilidad.setCRRSD_CODIGO(results.getString(7));
				tmpCgg_res_movilidad.setCRMOV_FECHA_VIAJE(results.getTimestamp(8));
				tmpCgg_res_movilidad.setCRMOV_TIPO_OPERACION(results.getInt(9));
				tmpCgg_res_movilidad.setCRMOV_NUMERO_VUELO(results.getString(10));
				tmpCgg_res_movilidad.setCRMOV_OBSERVACION(results.getString(11));
				tmpCgg_res_movilidad.setCRMOV_TIPO_SALIDA(results.getInt(12));
				tmpCgg_res_movilidad.setCRMOV_FILTRO_INTERNO(results.getBoolean(13));
				tmpCgg_res_movilidad.setCRMOV_SOPORTE(results.getBoolean(14));
				tmpCgg_res_movilidad.setCRMOV_ESTADO(results.getBoolean(15));
				outCgg_res_movilidad.add(tmpCgg_res_movilidad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_movilidad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_registro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_REGISTRO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_D_CGG_TCT_REGISTRO(?) }");
			stmDelete.setString(1, this.getCgg_res_movilidad().getCTREG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MOVILIDAD_DS_CGG_TCT_REGISTRO(?) }");
				stmDelete.setString(1, this.getCgg_res_movilidad().getCTREG_CODIGO());
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
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectIngresoCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INGRESO_COUNT(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllIngreso(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INGRESO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA VARIAS TABLAS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA.
	* @param inCtgtr_numero NUMERO DEL GRUPO TABLA Cgg_tct_grupo_turista 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovilidadIngresoResidentesCodigo(
		java.sql.Connection inConnection,
		String inCrper_numero_residencia
		
	){
		ArrayList<HashMap<String,Object>> outCgg_codigo_barras = new ArrayList<HashMap<String,Object>>();
	
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_NUMERO_RESIDENCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_numero_residencia);		
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_codigo_barras.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_codigo_barras;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectIngresoResidentesCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INGRESO_RESIDENTES_COUNT(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllIngresoResidentes(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INGRESO_RESIDENTES_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inIdentificacion NUMERO DE IDENTIFICACION
	 * @param inMovimiento IDENTIFICATIVO DE TIPO DE MOVIMIENTO.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectBuscarPersonasCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inIdentificacion,
			int inMovimiento
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_MOVILIDAD_INGRESO_PAG_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inIdentificacion);
			stmSelect.setInt(4, inMovimiento);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inIdentificacion NUMERO DE IDENTIFICACION.
	 * @param inMovimiento TIPO DE MOVIMIENTO.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllBuscarPersonas(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inIdentificacion,
			int inMovimiento
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_MOVILIDAD_INGRESO_PAG_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inIdentificacion);
			stmSelect.setInt(9, inMovimiento);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA VARIAS TABLAS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	* @param inCtgtr_numero NUMERO DEL GRUPO TABLA Cgg_tct_grupo_turista 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovilidadPerNumIdentific(
		java.sql.Connection inConnection,
		String inCrper_num_doc_identific
		
	){
		ArrayList<HashMap<String,Object>> outCgg_codigo_barras = new ArrayList<HashMap<String,Object>>();
	
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_NUMERO_IDENTIFICATIVO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_num_doc_identific);		
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_codigo_barras.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_codigo_barras;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA VARIAS TABLAS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	* @param inCtgtr_numero NUMERO DEL GRUPO TABLA Cgg_tct_grupo_turista 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMovilidadSalidaPerNumIdentific(
		java.sql.Connection inConnection,
		String inCrper_num_doc_identific
		
	){
		ArrayList<HashMap<String,Object>> outCgg_codigo_barras = new ArrayList<HashMap<String,Object>>();
	
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_SALIDA_NUMERO_IDENTIFICATIVO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_num_doc_identific);		
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_codigo_barras.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_codigo_barras;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectResidentesCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_RESIDENCIA_PAG_COUNT(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inIdentificacion NUMERO DE IDENTIFICACION.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllResidentes(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inIdentificacion
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_RESIDENCIA_PAG_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inIdentificacion);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	/**
	 * Obtiene un registro de entradas - salidas para ser tratado en offline.
	 * @param inConnection Conexion de datos.
	 * @param in_user_name Nombre de usuario. 
	 * @return Conjunto de datos.
	 */
	public static ArrayList<HashMap<String,Object>> selectMovilidadIngresoOffLine(
			java.sql.Connection inConnection,
			String in_user_name
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_MOVILIDAD_INGRESO_SELECT_OFFLINE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);		
			stmSelect.setString(2, in_user_name);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona,cgg_res_movilida,cgg_res_residencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName Nombre de usuario.
	 * @param in_Canton Codigo de canton.
	 * @deprecated
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectResidenteOffLine(
			java.sql.Connection inConnection,
			String inUserName,
			String in_Canton

	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_MOVILIDAD_RESIDENCIA_SELECT_OFF(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);		
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, in_Canton);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	
	/**
	 * Devuelve una cadena en formato establecido de los datos de residencia deacuerdo al canton o total con fines de exportacion a otras fuentes de datos que requiera el CGG.
	 * @param inConnection Conexion de datos.
	 * @param inUserName Nombre de usuario.
	 * @param in_Canton Codigo de canton.
	 * @param inFormat Formato de salida de datos 0-JSON/1-XML.
	 * @return Cadena de datos en formato establecido.
	 */
	public String selectResidenteFormato(
			java.sql.Connection inConnection,
			String inUserName,
			int inFormat

	){
		String res = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_MOVILIDAD_SELECT_RESIDENCIA_FORMATO(?,?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);		
			stmSelect.setString(2, inUserName);			
			stmSelect.setInt(3, inFormat);
			stmSelect.execute();
			res = stmSelect.getString(1);					
			stmSelect.close();
		}catch(SQLException e){
			res = null;
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return res;
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona,cgg_res_movilida,cgg_res_residencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectMovilidadSalidaOffLine(
			java.sql.Connection inConnection,
			String inUserName
			
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_MOVILIDAD_SALIDA_SELECT_OFFLINE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);		
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	
	
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_movilidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert1(
		java.sql.Connection inConnection,
		String inCtreg_codigo_barras
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MOVILIDAD_INSERT1(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?, ?, ?, ?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_movilidad().getCRMOV_CODIGO());
			stmInsert.setString(3, this.getCgg_res_movilidad().getCRALN_CODIGO());
			stmInsert.setString(4, this.getCgg_res_movilidad().getCARPT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_movilidad().getCGG_CARPT_CODIGO());
			stmInsert.setString(6, this.getCgg_res_movilidad().getCRPER_CODIGO());
			stmInsert.setString(7, this.getCgg_res_movilidad().getCTREG_CODIGO());
			stmInsert.setString(8, this.getCgg_res_movilidad().getCRRSD_CODIGO());
			stmInsert.setTimestamp(9, new java.sql.Timestamp(this.getCgg_res_movilidad().getCRMOV_FECHA_VIAJE().getTime()));
			stmInsert.setInt(10, this.getCgg_res_movilidad().getCRMOV_TIPO_OPERACION());
			stmInsert.setString(11, this.getCgg_res_movilidad().getCRMOV_NUMERO_VUELO());
			stmInsert.setString(12, this.getCgg_res_movilidad().getCRMOV_OBSERVACION());
			stmInsert.setInt(13, this.getCgg_res_movilidad().getCRMOV_TIPO_SALIDA());
			stmInsert.setBoolean(14, this.getCgg_res_movilidad().getCRMOV_FILTRO_INTERNO());
			stmInsert.setBoolean(15, this.getCgg_res_movilidad().getCRMOV_SOPORTE());
			stmInsert.setBoolean(16, this.getCgg_res_movilidad().getCRMOV_ESTADO());
			stmInsert.setString(17, this.getCgg_res_movilidad().getCRMOV_USUARIO_INSERT());
			stmInsert.setString(18, inCtreg_codigo_barras);
			stmInsert.execute();
			this.getCgg_res_movilidad().setCRMOV_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * Funcion monitor para generacion de formato de residencia de persona.
	 * @param inConnection Conexion de datos.
	 */
	public void ResidenciaFormatoJob(
			java.sql.Connection inConnection			
	){		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{call SII.F_RESIDENCIA_FORMATO_MONITOR() }");			
			stmSelect.execute();							
			stmSelect.close();
		}catch(SQLException e){			
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}		
	}
	
}