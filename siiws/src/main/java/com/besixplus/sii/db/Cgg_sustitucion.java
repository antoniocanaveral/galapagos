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
* CLASE Cgg_sustitucion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sustitucion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sustitucion implements Serializable{
	private static final long serialVersionUID = 1812229365;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sustitucion.
	*/
	private com.besixplus.sii.objects.Cgg_sustitucion myCgg_sustitucion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sustitucion.
	*/
	public Cgg_sustitucion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sustitucion.
	* @param inCgg_sustitucion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sustitucion.
	*/
	public Cgg_sustitucion(
		com.besixplus.sii.objects.Cgg_sustitucion inCgg_sustitucion
	){
		this.setCgg_sustitucion(inCgg_sustitucion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sustitucion.
	* @param inCgg_sustitucion OBJETO Cgg_sustitucion.
	* @return void
	*/
	public void setCgg_sustitucion(com.besixplus.sii.objects.Cgg_sustitucion inCgg_sustitucion){
		this.myCgg_sustitucion = inCgg_sustitucion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sustitucion.
	* @return Cgg_sustitucion OBJETO Cgg_sustitucion.
	*/
	public com.besixplus.sii.objects.Cgg_sustitucion getCgg_sustitucion(){
		return this.myCgg_sustitucion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sustitucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_INSERT(?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sustitucion().getCSUST_CODIGO());
			stmInsert.setString(3, this.getCgg_sustitucion().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_sustitucion().getCGG_CUSU_CODIGO());
			stmInsert.setInt(5, this.getCgg_sustitucion().getCSUST_MODALIDAD());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_sustitucion().getCSUST_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_sustitucion().getCSUST_FECHA_FIN().getTime()));
			stmInsert.setBoolean(8, this.getCgg_sustitucion().getCSUST_ESTADO_ENCARGO());
			stmInsert.setBoolean(9, this.getCgg_sustitucion().getCSUST_ESTADO());
			stmInsert.setString(10, this.getCgg_sustitucion().getCSUST_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_sustitucion().getCSUST_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_sustitucion().setCSUST_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sustitucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> outCgg_sustitucion = new ArrayList<com.besixplus.sii.objects.Cgg_sustitucion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sustitucion tmpCgg_sustitucion = new com.besixplus.sii.objects.Cgg_sustitucion();
				tmpCgg_sustitucion.setCSUST_CODIGO(results.getString(1));
				tmpCgg_sustitucion.setCUSU_CODIGO(results.getString(2));
				tmpCgg_sustitucion.setCGG_CUSU_CODIGO(results.getString(3));
				tmpCgg_sustitucion.setCSUST_MODALIDAD(results.getInt(4));
				tmpCgg_sustitucion.setCSUST_FECHA_INICIO(results.getTimestamp(5));
				tmpCgg_sustitucion.setCSUST_FECHA_FIN(results.getTimestamp(6));
				tmpCgg_sustitucion.setCSUST_ESTADO_ENCARGO(results.getBoolean(7));
				tmpCgg_sustitucion.setCSUST_ESTADO(results.getBoolean(8));
				outCgg_sustitucion.add(tmpCgg_sustitucion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sustitucion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sustitucion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> outCgg_sustitucion = new ArrayList<com.besixplus.sii.objects.Cgg_sustitucion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_sustitucion tmpCgg_sustitucion = new com.besixplus.sii.objects.Cgg_sustitucion();
				tmpCgg_sustitucion.setCSUST_CODIGO(results.getString(1));
				tmpCgg_sustitucion.setCUSU_CODIGO(results.getString(2));
				tmpCgg_sustitucion.setCGG_CUSU_CODIGO(results.getString(3));
				tmpCgg_sustitucion.setCSUST_MODALIDAD(results.getInt(4));
				tmpCgg_sustitucion.setCSUST_FECHA_INICIO(results.getTimestamp(5));
				tmpCgg_sustitucion.setCSUST_FECHA_FIN(results.getTimestamp(6));
				tmpCgg_sustitucion.setCSUST_ESTADO_ENCARGO(results.getBoolean(7));
				tmpCgg_sustitucion.setCSUST_ESTADO(results.getBoolean(8));
				outCgg_sustitucion.add(tmpCgg_sustitucion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sustitucion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sustitucion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_sustitucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_sustitucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sustitucion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sustitucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sustitucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SUSTITUCION_UPDATE(?, ?, ?, ?::smallint, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sustitucion().getCSUST_CODIGO());
			stmUpdate.setString(2, this.getCgg_sustitucion().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_sustitucion().getCGG_CUSU_CODIGO());
			stmUpdate.setInt(4, this.getCgg_sustitucion().getCSUST_MODALIDAD());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_sustitucion().getCSUST_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_sustitucion().getCSUST_FECHA_FIN().getTime()));
			stmUpdate.setBoolean(7, this.getCgg_sustitucion().getCSUST_ESTADO_ENCARGO());
			stmUpdate.setBoolean(8, this.getCgg_sustitucion().getCSUST_ESTADO());
			stmUpdate.setString(9, this.getCgg_sustitucion().getCSUST_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sustitucion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sustitucion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sustitucion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sustitucion().getCSUST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sustitucion().setCSUST_CODIGO(results.getString(1));
				this.getCgg_sustitucion().setCUSU_CODIGO(results.getString(2));
				this.getCgg_sustitucion().setCGG_CUSU_CODIGO(results.getString(3));
				this.getCgg_sustitucion().setCSUST_MODALIDAD(results.getInt(4));
				this.getCgg_sustitucion().setCSUST_FECHA_INICIO(results.getTimestamp(5));
				this.getCgg_sustitucion().setCSUST_FECHA_FIN(results.getTimestamp(6));
				this.getCgg_sustitucion().setCSUST_ESTADO_ENCARGO(results.getBoolean(7));
				this.getCgg_sustitucion().setCSUST_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sustitucion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sustitucion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SUSTITUCION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sustitucion().getCSUST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SUSTITUCION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sustitucion().getCSUST_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_sustitucion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sustitucion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sustitucion> outCgg_sustitucion = new ArrayList<com.besixplus.sii.objects.Cgg_sustitucion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SUSTITUCION_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sustitucion().getCUSU_CODIGO());
			stmSelect.setString(3,this.getCgg_sustitucion().getCGG_CUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sustitucion tmpCgg_sustitucion = new com.besixplus.sii.objects.Cgg_sustitucion();
				tmpCgg_sustitucion.setCSUST_CODIGO(results.getString(1));
				tmpCgg_sustitucion.setCUSU_CODIGO(results.getString(2));
				tmpCgg_sustitucion.setCGG_CUSU_CODIGO(results.getString(3));
				tmpCgg_sustitucion.setCSUST_MODALIDAD(results.getInt(4));
				tmpCgg_sustitucion.setCSUST_FECHA_INICIO(results.getTimestamp(5));
				tmpCgg_sustitucion.setCSUST_FECHA_FIN(results.getTimestamp(6));
				tmpCgg_sustitucion.setCSUST_ESTADO_ENCARGO(results.getBoolean(7));
				tmpCgg_sustitucion.setCSUST_ESTADO(results.getBoolean(8));
				outCgg_sustitucion.add(tmpCgg_sustitucion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sustitucion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_sustitucion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SUSTITUCION_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_sustitucion().getCUSU_CODIGO());
			stmDelete.setString(2, this.getCgg_sustitucion().getCGG_CUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SUSTITUCION_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_sustitucion().getCUSU_CODIGO());
				stmDelete.setString(2, this.getCgg_sustitucion().getCGG_CUSU_CODIGO());
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