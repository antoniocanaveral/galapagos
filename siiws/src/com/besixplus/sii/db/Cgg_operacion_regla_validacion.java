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
* CLASE Cgg_operacion_regla_validacion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_operacion_regla_validacion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_operacion_regla_validacion implements Serializable{
	private static final long serialVersionUID = 1941224223;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_operacion_regla_validacion.
	*/
	private com.besixplus.sii.objects.Cgg_operacion_regla_validacion myCgg_operacion_regla_validacion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_operacion_regla_validacion.
	*/
	public Cgg_operacion_regla_validacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_operacion_regla_validacion.
	* @param inCgg_operacion_regla_validacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_operacion_regla_validacion.
	*/
	public Cgg_operacion_regla_validacion(
		com.besixplus.sii.objects.Cgg_operacion_regla_validacion inCgg_operacion_regla_validacion
	){
		this.setCgg_operacion_regla_validacion(inCgg_operacion_regla_validacion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_operacion_regla_validacion.
	* @param inCgg_operacion_regla_validacion OBJETO Cgg_operacion_regla_validacion.
	* @return void
	*/
	public void setCgg_operacion_regla_validacion(com.besixplus.sii.objects.Cgg_operacion_regla_validacion inCgg_operacion_regla_validacion){
		this.myCgg_operacion_regla_validacion = inCgg_operacion_regla_validacion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_operacion_regla_validacion.
	* @return Cgg_operacion_regla_validacion OBJETO Cgg_operacion_regla_validacion.
	*/
	public com.besixplus.sii.objects.Cgg_operacion_regla_validacion getCgg_operacion_regla_validacion(){
		return this.myCgg_operacion_regla_validacion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_operacion_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_operacion_regla_validacion().getCORV_CODIGO());
			stmInsert.setString(3, this.getCgg_operacion_regla_validacion().getCRVAL_CODIGO());
			stmInsert.setString(4, this.getCgg_operacion_regla_validacion().getCOPVL_CODIGO());
			stmInsert.setString(5, this.getCgg_operacion_regla_validacion().getCORV_CAMPO_EVALUACION());
			stmInsert.setBigDecimal(6, this.getCgg_operacion_regla_validacion().getCORV_VALOR_1());
			stmInsert.setBoolean(7, this.getCgg_operacion_regla_validacion().getCORV_ESTADO());
			stmInsert.setString(8, this.getCgg_operacion_regla_validacion().getCORV_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_operacion_regla_validacion().getCORV_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_operacion_regla_validacion().setCORV_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> outCgg_operacion_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_operacion_regla_validacion tmpCgg_operacion_regla_validacion = new com.besixplus.sii.objects.Cgg_operacion_regla_validacion();
				tmpCgg_operacion_regla_validacion.setCORV_CODIGO(results.getString(1));
				tmpCgg_operacion_regla_validacion.setCRVAL_CODIGO(results.getString(2));
				tmpCgg_operacion_regla_validacion.setCOPVL_CODIGO(results.getString(3));
				tmpCgg_operacion_regla_validacion.setCORV_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_operacion_regla_validacion.setCORV_VALOR_1(results.getBigDecimal(5));
				tmpCgg_operacion_regla_validacion.setCORV_ESTADO(results.getBoolean(6));
				outCgg_operacion_regla_validacion.add(tmpCgg_operacion_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_operacion_regla_validacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> outCgg_operacion_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_operacion_regla_validacion tmpCgg_operacion_regla_validacion = new com.besixplus.sii.objects.Cgg_operacion_regla_validacion();
				tmpCgg_operacion_regla_validacion.setCORV_CODIGO(results.getString(1));
				tmpCgg_operacion_regla_validacion.setCRVAL_CODIGO(results.getString(2));
				tmpCgg_operacion_regla_validacion.setCOPVL_CODIGO(results.getString(3));
				tmpCgg_operacion_regla_validacion.setCORV_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_operacion_regla_validacion.setCORV_VALOR_1(results.getBigDecimal(5));
				tmpCgg_operacion_regla_validacion.setCORV_ESTADO(results.getBoolean(6));
				outCgg_operacion_regla_validacion.add(tmpCgg_operacion_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_operacion_regla_validacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_operacion_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_operacion_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_operacion_regla_validacion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_operacion_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_COUNT() }");
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
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_operacion_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_operacion_regla_validacion().getCORV_CODIGO());
			stmUpdate.setString(2, this.getCgg_operacion_regla_validacion().getCRVAL_CODIGO());
			stmUpdate.setString(3, this.getCgg_operacion_regla_validacion().getCOPVL_CODIGO());
			stmUpdate.setString(4, this.getCgg_operacion_regla_validacion().getCORV_CAMPO_EVALUACION());
			stmUpdate.setBigDecimal(5, this.getCgg_operacion_regla_validacion().getCORV_VALOR_1());
			stmUpdate.setBoolean(6, this.getCgg_operacion_regla_validacion().getCORV_ESTADO());
			stmUpdate.setString(7, this.getCgg_operacion_regla_validacion().getCORV_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_operacion_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_operacion_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_operacion_regla_validacion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_operacion_regla_validacion().getCORV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_operacion_regla_validacion().setCORV_CODIGO(results.getString(1));
				this.getCgg_operacion_regla_validacion().setCRVAL_CODIGO(results.getString(2));
				this.getCgg_operacion_regla_validacion().setCOPVL_CODIGO(results.getString(3));
				this.getCgg_operacion_regla_validacion().setCORV_CAMPO_EVALUACION(results.getString(4));
				this.getCgg_operacion_regla_validacion().setCORV_VALOR_1(results.getBigDecimal(5));
				this.getCgg_operacion_regla_validacion().setCORV_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_operacion_regla_validacion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_operacion_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_operacion_regla_validacion().getCORV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_operacion_regla_validacion().getCORV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_operacion_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_operacion_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> selectCGG_OPERACION_VALIDACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> outCgg_operacion_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_OPERACION_VALIDACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_operacion_regla_validacion().getCOPVL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_operacion_regla_validacion tmpCgg_operacion_regla_validacion = new com.besixplus.sii.objects.Cgg_operacion_regla_validacion();
				tmpCgg_operacion_regla_validacion.setCORV_CODIGO(results.getString(1));
				tmpCgg_operacion_regla_validacion.setCRVAL_CODIGO(results.getString(2));
				tmpCgg_operacion_regla_validacion.setCOPVL_CODIGO(results.getString(3));
				tmpCgg_operacion_regla_validacion.setCORV_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_operacion_regla_validacion.setCORV_VALOR_1(results.getBigDecimal(5));
				tmpCgg_operacion_regla_validacion.setCORV_ESTADO(results.getBoolean(6));
				outCgg_operacion_regla_validacion.add(tmpCgg_operacion_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_operacion_regla_validacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_operacion_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_OPERACION_VALIDACION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_OPERACION_VALIDACION(?) }");
			stmDelete.setString(1, this.getCgg_operacion_regla_validacion().getCOPVL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_DS_CGG_OPERACION_VALIDACION(?) }");
				stmDelete.setString(1, this.getCgg_operacion_regla_validacion().getCOPVL_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_regla_validacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_operacion_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> selectCGG_REGLA_VALIDACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion> outCgg_operacion_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_operacion_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_REGLA_VALIDACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_operacion_regla_validacion().getCRVAL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_operacion_regla_validacion tmpCgg_operacion_regla_validacion = new com.besixplus.sii.objects.Cgg_operacion_regla_validacion();
				tmpCgg_operacion_regla_validacion.setCORV_CODIGO(results.getString(1));
				tmpCgg_operacion_regla_validacion.setCRVAL_CODIGO(results.getString(2));
				tmpCgg_operacion_regla_validacion.setCOPVL_CODIGO(results.getString(3));
				tmpCgg_operacion_regla_validacion.setCORV_CAMPO_EVALUACION(results.getString(4));
				tmpCgg_operacion_regla_validacion.setCORV_VALOR_1(results.getBigDecimal(5));
				tmpCgg_operacion_regla_validacion.setCORV_ESTADO(results.getBoolean(6));
				outCgg_operacion_regla_validacion.add(tmpCgg_operacion_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_operacion_regla_validacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_operacion_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_regla_validacion.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_REGLA_VALIDACION(?) }");
			stmDelete.setString(1, this.getCgg_operacion_regla_validacion().getCRVAL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_OPERACION_REGLA_VALIDACION_DS_CGG_REGLA_VALIDACION(?) }");
				stmDelete.setString(1, this.getCgg_operacion_regla_validacion().getCRVAL_CODIGO());
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
	* SELECCIONA TODOS LOS REGISTRO DE LA TABLA CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
	* RELACIONADOS CON LA TABLA SII.CGG_OPERACION_VALIDACION.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectCGG_OPERACION_VALIDACION1(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_operacion_regla = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_OPERACION_VALIDACION1(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_operacion_regla_validacion().getCOPVL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_operacion_regla.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_operacion_regla;
	}


}