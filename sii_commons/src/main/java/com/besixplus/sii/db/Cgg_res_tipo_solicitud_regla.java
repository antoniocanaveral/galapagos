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
* CLASE Cgg_res_tipo_solicitud_regla
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tipo_solicitud_regla.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tipo_solicitud_regla implements Serializable{
	private static final long serialVersionUID = 1450234494;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla.
	*/
	private com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla myCgg_res_tipo_solicitud_regla = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_regla.
	*/
	public Cgg_res_tipo_solicitud_regla(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_regla.
	* @param inCgg_res_tipo_solicitud_regla OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tipo_solicitud_regla.
	*/
	public Cgg_res_tipo_solicitud_regla(
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla inCgg_res_tipo_solicitud_regla
	){
		this.setCgg_res_tipo_solicitud_regla(inCgg_res_tipo_solicitud_regla);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tipo_solicitud_regla.
	* @param inCgg_res_tipo_solicitud_regla OBJETO Cgg_res_tipo_solicitud_regla.
	* @return void
	*/
	public void setCgg_res_tipo_solicitud_regla(com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla inCgg_res_tipo_solicitud_regla){
		this.myCgg_res_tipo_solicitud_regla = inCgg_res_tipo_solicitud_regla;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tipo_solicitud_regla.
	* @return Cgg_res_tipo_solicitud_regla OBJETO Cgg_res_tipo_solicitud_regla.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla getCgg_res_tipo_solicitud_regla(){
		return this.myCgg_res_tipo_solicitud_regla;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_regla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tipo_solicitud_regla().getCRTSE_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tipo_solicitud_regla().getCRTST_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tipo_solicitud_regla().getCRVAL_CODIGO());
			stmInsert.setString(5, this.getCgg_res_tipo_solicitud_regla().getCRTSE_CAMPO_EVALUACION());
			stmInsert.setString(6, this.getCgg_res_tipo_solicitud_regla().getCRTSE_VALOR_1());
			stmInsert.setBoolean(7, this.getCgg_res_tipo_solicitud_regla().getCRTSE_ESTADO());
			stmInsert.setString(8, this.getCgg_res_tipo_solicitud_regla().getCRTSE_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_res_tipo_solicitud_regla().getCRTSE_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_tipo_solicitud_regla().setCRTSE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> outCgg_res_tipo_solicitud_regla = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla tmpCgg_res_tipo_solicitud_regla = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla();
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_regla.setCRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_regla.setCRVAL_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_VALOR_1(results.getString(5));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_ESTADO(results.getBoolean(6));
				outCgg_res_tipo_solicitud_regla.add(tmpCgg_res_tipo_solicitud_regla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_regla;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> outCgg_res_tipo_solicitud_regla = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla tmpCgg_res_tipo_solicitud_regla = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla();
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_regla.setCRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_regla.setCRVAL_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_VALOR_1(results.getString(5));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_ESTADO(results.getBoolean(6));
				outCgg_res_tipo_solicitud_regla.add(tmpCgg_res_tipo_solicitud_regla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_regla;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_regla = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_tipo_solicitud_regla.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_regla;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_tipo_solicitud_regla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tipo_solicitud_regla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRTSE_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tipo_solicitud_regla().getCRTST_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tipo_solicitud_regla().getCRVAL_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_tipo_solicitud_regla().getCRTSE_CAMPO_EVALUACION());
			stmUpdate.setString(5, this.getCgg_res_tipo_solicitud_regla().getCRTSE_VALOR_1());
			stmUpdate.setBoolean(6, this.getCgg_res_tipo_solicitud_regla().getCRTSE_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_tipo_solicitud_regla().getCRTSE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_regla().getCRTSE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tipo_solicitud_regla().setCRTSE_CODIGO(results.getString(1));
				this.getCgg_res_tipo_solicitud_regla().setCRTST_CODIGO(results.getString(2));
				this.getCgg_res_tipo_solicitud_regla().setCRVAL_CODIGO(results.getString(3));
				this.getCgg_res_tipo_solicitud_regla().setCRTSE_CAMPO_EVALUACION(results.getString(4));
				this.getCgg_res_tipo_solicitud_regla().setCRTSE_VALOR_1(results.getString(5));
				this.getCgg_res_tipo_solicitud_regla().setCRTSE_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tipo_solicitud_regla();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRTSE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRTSE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> selectCGG_REGLA_VALIDACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> outCgg_res_tipo_solicitud_regla = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_REGLA_VALIDACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_regla().getCRVAL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla tmpCgg_res_tipo_solicitud_regla = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla();
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_regla.setCRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_regla.setCRVAL_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_VALOR_1(results.getString(5));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_ESTADO(results.getBoolean(6));
				outCgg_res_tipo_solicitud_regla.add(tmpCgg_res_tipo_solicitud_regla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_regla;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_REGLA_VALIDACION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_REGLA_VALIDACION(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRVAL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_DS_CGG_REGLA_VALIDACION(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRVAL_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla> outCgg_res_tipo_solicitud_regla = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_regla().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla tmpCgg_res_tipo_solicitud_regla = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla();
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_regla.setCRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_regla.setCRVAL_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_VALOR_1(results.getString(5));
				tmpCgg_res_tipo_solicitud_regla.setCRTSE_ESTADO(results.getBoolean(6));
				outCgg_res_tipo_solicitud_regla.add(tmpCgg_res_tipo_solicitud_regla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_regla;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRTST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_REGLA_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_regla().getCRTST_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_regla DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectCGG_RES_TIPO_SOLICITUD_TRAMITE1(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_regla = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLIC_REGLA_S_CGG_RES_TIPO_SOLIC_TRAMITE1(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_regla().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tipo_solicitud_regla.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_regla;
	}
	
}