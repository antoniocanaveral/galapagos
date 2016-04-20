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
* CLASE Cgg_res_fase_usuario
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_fase_usuario.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_fase_usuario implements Serializable{
	private static final long serialVersionUID = 1696467863;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_fase_usuario.
	*/
	private com.besixplus.sii.objects.Cgg_res_fase_usuario myCgg_res_fase_usuario = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase_usuario.
	*/
	public Cgg_res_fase_usuario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase_usuario.
	* @param inCgg_res_fase_usuario OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_fase_usuario.
	*/
	public Cgg_res_fase_usuario(
		com.besixplus.sii.objects.Cgg_res_fase_usuario inCgg_res_fase_usuario
	){
		this.setCgg_res_fase_usuario(inCgg_res_fase_usuario);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_fase_usuario.
	* @param inCgg_res_fase_usuario OBJETO Cgg_res_fase_usuario.
	* @return void
	*/
	public void setCgg_res_fase_usuario(com.besixplus.sii.objects.Cgg_res_fase_usuario inCgg_res_fase_usuario){
		this.myCgg_res_fase_usuario = inCgg_res_fase_usuario;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_fase_usuario.
	* @return Cgg_res_fase_usuario OBJETO Cgg_res_fase_usuario.
	*/
	public com.besixplus.sii.objects.Cgg_res_fase_usuario getCgg_res_fase_usuario(){
		return this.myCgg_res_fase_usuario;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_fase_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_fase_usuario().getCRFSU_CODIGO());
			stmInsert.setString(3, this.getCgg_res_fase_usuario().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_res_fase_usuario().getCRFAS_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_res_fase_usuario().getCRFSU_ACTIVO());
			stmInsert.setBoolean(6, this.getCgg_res_fase_usuario().getCRFSU_ESTADO());
			stmInsert.setString(7, this.getCgg_res_fase_usuario().getCRFSU_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_res_fase_usuario().getCRFSU_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_fase_usuario().setCRFSU_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> outCgg_res_fase_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase_usuario tmpCgg_res_fase_usuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
				tmpCgg_res_fase_usuario.setCRFSU_CODIGO(results.getString(1));
				tmpCgg_res_fase_usuario.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_fase_usuario.setCRFAS_CODIGO(results.getString(3));
				tmpCgg_res_fase_usuario.setCRFSU_ACTIVO(results.getBoolean(4));
				tmpCgg_res_fase_usuario.setCRFSU_ESTADO(results.getBoolean(5));
				outCgg_res_fase_usuario.add(tmpCgg_res_fase_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> outCgg_res_fase_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_fase_usuario tmpCgg_res_fase_usuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
				tmpCgg_res_fase_usuario.setCRFSU_CODIGO(results.getString(1));
				tmpCgg_res_fase_usuario.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_fase_usuario.setCRFAS_CODIGO(results.getString(3));
				tmpCgg_res_fase_usuario.setCRFSU_ACTIVO(results.getBoolean(4));
				tmpCgg_res_fase_usuario.setCRFSU_ESTADO(results.getBoolean(5));
				outCgg_res_fase_usuario.add(tmpCgg_res_fase_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_fase_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_fase_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_fase_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_fase_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_fase_usuario().getCRFSU_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_fase_usuario().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_fase_usuario().getCRFAS_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_res_fase_usuario().getCRFSU_ACTIVO());
			stmUpdate.setBoolean(5, this.getCgg_res_fase_usuario().getCRFSU_ESTADO());
			stmUpdate.setString(6, this.getCgg_res_fase_usuario().getCRFSU_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_fase_usuario DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_fase_usuario select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase_usuario().getCRFSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_fase_usuario().setCRFSU_CODIGO(results.getString(1));
				this.getCgg_res_fase_usuario().setCUSU_CODIGO(results.getString(2));
				this.getCgg_res_fase_usuario().setCRFAS_CODIGO(results.getString(3));
				this.getCgg_res_fase_usuario().setCRFSU_ACTIVO(results.getBoolean(4));
				this.getCgg_res_fase_usuario().setCRFSU_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_fase_usuario();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_fase_usuario DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_fase_usuario().getCRFSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_fase_usuario().getCRFSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> outCgg_res_fase_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase_usuario().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase_usuario tmpCgg_res_fase_usuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
				tmpCgg_res_fase_usuario.setCRFSU_CODIGO(results.getString(1));
				tmpCgg_res_fase_usuario.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_fase_usuario.setCRFAS_CODIGO(results.getString(3));
				tmpCgg_res_fase_usuario.setCRFSU_ACTIVO(results.getBoolean(4));
				tmpCgg_res_fase_usuario.setCRFSU_ESTADO(results.getBoolean(5));
				outCgg_res_fase_usuario.add(tmpCgg_res_fase_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_fase_usuario().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_fase_usuario().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_fase_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> selectCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario> outCgg_res_fase_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_S_CGG_RES_FASE(?)}");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_fase_usuario().getCRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_fase_usuario tmpCgg_res_fase_usuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
				tmpCgg_res_fase_usuario.setCRFSU_CODIGO(results.getString(1));
				tmpCgg_res_fase_usuario.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_fase_usuario.setCRFAS_CODIGO(results.getString(3));
				tmpCgg_res_fase_usuario.setCRFSU_ACTIVO(results.getBoolean(4));
				tmpCgg_res_fase_usuario.setCRFSU_ESTADO(results.getBoolean(5));
				outCgg_res_fase_usuario.add(tmpCgg_res_fase_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_D_CGG_RES_FASE(?) }");
			stmDelete.setString(1, this.getCgg_res_fase_usuario().getCRFAS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_FASE_USUARIO_DS_CGG_RES_FASE(?) }");
				stmDelete.setString(1, this.getCgg_res_fase_usuario().getCRFAS_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_fase_usuario DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrfas_codigo CODIGO DE LA FASE PARA CONSULTA DE LOS USUARIOS
	* @return com.besixplus.sii.objects.Cgg_res_fase_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static  ArrayList<HashMap<String,Object>> selectDirectFaseUsuario(
		java.sql.Connection inConnection,
		String inCrfas_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_USUARIO_ALL_S_CGG_RES_FASE(?)}");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrfas_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}
	
	/**
	 * OBTIENE UNA COLECCION CON INFORMACION DE TODOS LOS USUARIOS DE UNA FASE Y DE UNA ISLA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGSITRO DE ISLA.
	 * @return COLECCION CON INFORMACION.
	 */
	public ArrayList<HashMap<String,Object>> selectUsuariosFase(
			java.sql.Connection inConnection,
			String inCisla_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_FASE_TODOS_USUARIO(?,?)}");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_fase_usuario().getCRFAS_CODIGO());
			stmSelect.setString(3,inCisla_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}
	
}