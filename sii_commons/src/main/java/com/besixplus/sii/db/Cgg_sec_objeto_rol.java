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
* CLASE Cgg_sec_objeto_rol
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_objeto_rol.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_objeto_rol implements Serializable{
	private static final long serialVersionUID = 438338121;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_objeto_rol.
	*/
	private com.besixplus.sii.objects.Cgg_sec_objeto_rol myCgg_sec_objeto_rol = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto_rol.
	*/
	public Cgg_sec_objeto_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto_rol.
	* @param inCgg_sec_objeto_rol OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_objeto_rol.
	*/
	public Cgg_sec_objeto_rol(
		com.besixplus.sii.objects.Cgg_sec_objeto_rol inCgg_sec_objeto_rol
	){
		this.setCgg_sec_objeto_rol(inCgg_sec_objeto_rol);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_objeto_rol.
	* @param inCgg_sec_objeto_rol OBJETO Cgg_sec_objeto_rol.
	* @return void
	*/
	public void setCgg_sec_objeto_rol(com.besixplus.sii.objects.Cgg_sec_objeto_rol inCgg_sec_objeto_rol){
		this.myCgg_sec_objeto_rol = inCgg_sec_objeto_rol;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_objeto_rol.
	* @return Cgg_sec_objeto_rol OBJETO Cgg_sec_objeto_rol.
	*/
	public com.besixplus.sii.objects.Cgg_sec_objeto_rol getCgg_sec_objeto_rol(){
		return this.myCgg_sec_objeto_rol;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_objeto_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_objeto_rol().getCSBJR_CODIGO());
			stmInsert.setString(3, this.getCgg_sec_objeto_rol().getCSROL_CODIGO());
			stmInsert.setString(4, this.getCgg_sec_objeto_rol().getCSOBJ_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_sec_objeto_rol().getCSBJR_ACCESO_DIRECTO());
			stmInsert.setString(6, this.getCgg_sec_objeto_rol().getCSBJR_ACCESO_DIRECTO_TEXTO());
			stmInsert.setBoolean(7, this.getCgg_sec_objeto_rol().getCSBJR_ESTADO());
			stmInsert.setString(8, this.getCgg_sec_objeto_rol().getCSBJR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_sec_objeto_rol().setCSBJR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> outCgg_sec_objeto_rol = new ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_objeto_rol tmpCgg_sec_objeto_rol = new com.besixplus.sii.objects.Cgg_sec_objeto_rol();
				tmpCgg_sec_objeto_rol.setCSBJR_CODIGO(results.getString(1));
				tmpCgg_sec_objeto_rol.setCSROL_CODIGO(results.getString(2));
				tmpCgg_sec_objeto_rol.setCSOBJ_CODIGO(results.getString(3));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO(results.getBoolean(4));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO_TEXTO(results.getString(5));
				tmpCgg_sec_objeto_rol.setCSBJR_ESTADO(results.getBoolean(6));
				outCgg_sec_objeto_rol.add(tmpCgg_sec_objeto_rol);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto_rol;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inTypeObject TIPO DE OBJETOS DEL SISTEMA. 0 - INTERFACE VISUAL, 1 - SERVICIOS WEB
	* @param inCsrol_codigo CODIGO DEL ROL
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		int inTypeObject,
		String inCsrol_codigo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> outCgg_sec_objeto_rol = new ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setInt(8, inTypeObject);
			stmSelect.setString(9, inCsrol_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_objeto_rol tmpCgg_sec_objeto_rol = new com.besixplus.sii.objects.Cgg_sec_objeto_rol();
				tmpCgg_sec_objeto_rol.setCSBJR_CODIGO(results.getString(1));
				tmpCgg_sec_objeto_rol.setCSROL_CODIGO(results.getString(2));
				tmpCgg_sec_objeto_rol.setCSOBJ_CODIGO(results.getString(3));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO(results.getBoolean(4));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO_TEXTO(results.getString(5));
				tmpCgg_sec_objeto_rol.setCSBJR_ESTADO(results.getBoolean(6));
				outCgg_sec_objeto_rol.add(tmpCgg_sec_objeto_rol);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto_rol;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inTypeObject TIPO DE OBJETOS DEL SISTEMA. 0 - INTERFACE VISUAL, 1 - SERVICIOS WEB
	* @param inCsrol_codigo CODIGO DEL ROL
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		int inTypeObject,
		String inCsrol_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_sec_objeto_rol = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setInt(8, inTypeObject);
			stmSelect.setString(9, inCsrol_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_sec_objeto_rol.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto_rol;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sec_objeto_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inTypeObject IDENTIFICATIVO DE TIPO DE OBJETO.
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ROL.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		int inTypeObject,
		String inCsrol_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setInt(2, inTypeObject);
			stmSelect.setString(3, inCsrol_codigo);
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
	* @param inTypeObject IDENTIFICATIVO DE TIPO DE OBJETO.
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ROL.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		int inTypeObject,
		String inCsrol_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection, inTypeObject, inCsrol_codigo);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setInt(3, inTypeObject);
			stmSelect.setString(4, inCsrol_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sec_objeto_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sec_objeto_rol().getCSBJR_CODIGO());
			stmUpdate.setString(2, this.getCgg_sec_objeto_rol().getCSROL_CODIGO());
			stmUpdate.setString(3, this.getCgg_sec_objeto_rol().getCSOBJ_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_sec_objeto_rol().getCSBJR_ACCESO_DIRECTO());
			stmUpdate.setString(5, this.getCgg_sec_objeto_rol().getCSBJR_ACCESO_DIRECTO_TEXTO());
			stmUpdate.setBoolean(6, this.getCgg_sec_objeto_rol().getCSBJR_ESTADO());
			stmUpdate.setString(7, this.getCgg_sec_objeto_rol().getCSBJR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_objeto_rol DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_objeto_rol OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_objeto_rol select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_objeto_rol().getCSBJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_objeto_rol().setCSBJR_CODIGO(results.getString(1));
				this.getCgg_sec_objeto_rol().setCSROL_CODIGO(results.getString(2));
				this.getCgg_sec_objeto_rol().setCSOBJ_CODIGO(results.getString(3));
				this.getCgg_sec_objeto_rol().setCSBJR_ACCESO_DIRECTO(results.getBoolean(4));
				this.getCgg_sec_objeto_rol().setCSBJR_ACCESO_DIRECTO_TEXTO(results.getString(5));
				this.getCgg_sec_objeto_rol().setCSBJR_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_objeto_rol();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sec_objeto_rol DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sec_objeto_rol().getCSBJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sec_objeto_rol().getCSBJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sec_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_objeto_rol OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> selectCGG_SEC_ROL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> outCgg_sec_objeto_rol = new ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_S_CGG_SEC_ROL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_objeto_rol().getCSROL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_objeto_rol tmpCgg_sec_objeto_rol = new com.besixplus.sii.objects.Cgg_sec_objeto_rol();
				tmpCgg_sec_objeto_rol.setCSBJR_CODIGO(results.getString(1));
				tmpCgg_sec_objeto_rol.setCSROL_CODIGO(results.getString(2));
				tmpCgg_sec_objeto_rol.setCSOBJ_CODIGO(results.getString(3));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO(results.getBoolean(4));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO_TEXTO(results.getString(5));
				tmpCgg_sec_objeto_rol.setCSBJR_ESTADO(results.getBoolean(6));
				outCgg_sec_objeto_rol.add(tmpCgg_sec_objeto_rol);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto_rol;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sec_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_SEC_ROL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_D_CGG_SEC_ROL(?) }");
			stmDelete.setString(1, this.getCgg_sec_objeto_rol().getCSROL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_DS_CGG_SEC_ROL(?) }");
				stmDelete.setString(1, this.getCgg_sec_objeto_rol().getCSROL_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_objeto_rol OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> selectCGG_SEC_OBJETO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol> outCgg_sec_objeto_rol = new ArrayList<com.besixplus.sii.objects.Cgg_sec_objeto_rol>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJETO_ROL_S_CGG_SEC_OBJETO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_objeto_rol().getCSOBJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_objeto_rol tmpCgg_sec_objeto_rol = new com.besixplus.sii.objects.Cgg_sec_objeto_rol();
				tmpCgg_sec_objeto_rol.setCSBJR_CODIGO(results.getString(1));
				tmpCgg_sec_objeto_rol.setCSROL_CODIGO(results.getString(2));
				tmpCgg_sec_objeto_rol.setCSOBJ_CODIGO(results.getString(3));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO(results.getBoolean(4));
				tmpCgg_sec_objeto_rol.setCSBJR_ACCESO_DIRECTO_TEXTO(results.getString(5));
				tmpCgg_sec_objeto_rol.setCSBJR_ESTADO(results.getBoolean(6));
				outCgg_sec_objeto_rol.add(tmpCgg_sec_objeto_rol);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_objeto_rol;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_sec_objeto_rol DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_SEC_OBJETO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_D_CGG_SEC_OBJETO(?) }");
			stmDelete.setString(1, this.getCgg_sec_objeto_rol().getCSOBJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJETO_ROL_DS_CGG_SEC_OBJETO(?) }");
				stmDelete.setString(1, this.getCgg_sec_objeto_rol().getCSOBJ_CODIGO());
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