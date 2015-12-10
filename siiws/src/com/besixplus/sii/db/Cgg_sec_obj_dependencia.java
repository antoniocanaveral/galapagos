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
* CLASE Cgg_sec_obj_dependencia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_obj_dependencia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_obj_dependencia implements Serializable{
	private static final long serialVersionUID = 738900723;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_obj_dependencia.
	*/
	private com.besixplus.sii.objects.Cgg_sec_obj_dependencia myCgg_sec_obj_dependencia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_obj_dependencia.
	*/
	public Cgg_sec_obj_dependencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_obj_dependencia.
	* @param inCgg_sec_obj_dependencia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_obj_dependencia.
	*/
	public Cgg_sec_obj_dependencia(
		com.besixplus.sii.objects.Cgg_sec_obj_dependencia inCgg_sec_obj_dependencia
	){
		this.setCgg_sec_obj_dependencia(inCgg_sec_obj_dependencia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_obj_dependencia.
	* @param inCgg_sec_obj_dependencia OBJETO Cgg_sec_obj_dependencia.
	* @return void
	*/
	public void setCgg_sec_obj_dependencia(com.besixplus.sii.objects.Cgg_sec_obj_dependencia inCgg_sec_obj_dependencia){
		this.myCgg_sec_obj_dependencia = inCgg_sec_obj_dependencia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_obj_dependencia.
	* @return Cgg_sec_obj_dependencia OBJETO Cgg_sec_obj_dependencia.
	*/
	public com.besixplus.sii.objects.Cgg_sec_obj_dependencia getCgg_sec_obj_dependencia(){
		return this.myCgg_sec_obj_dependencia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_obj_dependencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_obj_dependencia().getCSBJD_CODIGO());
			stmInsert.setString(3, this.getCgg_sec_obj_dependencia().getCSOBJ_CODIGO());
			stmInsert.setString(4, this.getCgg_sec_obj_dependencia().getCGG_CSOBJ_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_sec_obj_dependencia().getCSBJD_ESTADO());
			stmInsert.setString(6, this.getCgg_sec_obj_dependencia().getCSBJD_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_sec_obj_dependencia().setCSBJD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_obj_dependencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inCsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_obj_dependencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		String inCsobj_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_sec_obj_dependencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_SELECT_AS(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCsobj_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_sec_obj_dependencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_obj_dependencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_obj_dependencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCsobj_codigo CODIGO DEL OBJETO QUE SE TIENE DEPENDENCIAS
	* @param inTypeObject TIPO DE OBJETOS QUE SE DESEA OBTENER: 0 - INTERFACES VISUALES, 1 - SERVICIOS WEB
	* @param inSW FILTAR LOS OBJETOS QUE NO ESTAN AGREGADOS COMO DEPENDENCIAS DEL OBJETOS DEPENDIENTE
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_obj_dependencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCsobj_codigo,
		int inTypeObject,
		boolean inSW
	){
		ArrayList<HashMap<String,Object>> outCgg_sec_obj_dependencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_SELECT(?,?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCsobj_codigo);
			stmSelect.setInt(9, inTypeObject);
			stmSelect.setBoolean(10, inSW);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_sec_obj_dependencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_obj_dependencia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sec_obj_dependencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_COUNT() }");
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
	* @param inCsobj_codigo CODIGO DEL OBJETO QUE SE TIENE DEPENDENCIAS
	* @param inTypeObject IDENTIFICATIVO DE TIPO DE OBJETO.
	* @param inSW FILTAR LOS OBJETOS QUE NO ESTAN AGREGADOS COMO DEPENDENCIAS DEL OBJETOS DEPENDIENTE
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCsobj_codigo,
		int inTypeObject,
		boolean inSW
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_COUNT(?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCsobj_codigo);
			stmSelect.setInt(4, inTypeObject);
			stmSelect.setBoolean(5, inSW);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sec_obj_dependencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJ_DEPENDENCIA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sec_obj_dependencia().getCSBJD_CODIGO());
			stmUpdate.setString(2, this.getCgg_sec_obj_dependencia().getCSOBJ_CODIGO());
			stmUpdate.setString(3, this.getCgg_sec_obj_dependencia().getCGG_CSOBJ_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_sec_obj_dependencia().getCSBJD_ESTADO());
			stmUpdate.setString(5, this.getCgg_sec_obj_dependencia().getCSBJD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_obj_dependencia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_obj_dependencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_obj_dependencia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_obj_dependencia().getCSBJD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_obj_dependencia().setCSBJD_CODIGO(results.getString(1));
				this.getCgg_sec_obj_dependencia().setCSOBJ_CODIGO(results.getString(2));
				this.getCgg_sec_obj_dependencia().setCGG_CSOBJ_CODIGO(results.getString(3));
				this.getCgg_sec_obj_dependencia().setCSBJD_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_obj_dependencia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sec_obj_dependencia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJ_DEPENDENCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sec_obj_dependencia().getCSBJD_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_sec_obj_dependencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sec_objeto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_obj_dependencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_sec_obj_dependencia> selectCGG_SEC_OBJETO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_obj_dependencia> outCgg_sec_obj_dependencia = new ArrayList<com.besixplus.sii.objects.Cgg_sec_obj_dependencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_OBJ_DEPENDENCIA_S_CGG_SEC_OBJETO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_obj_dependencia().getCGG_CSOBJ_CODIGO());
			stmSelect.setString(3,this.getCgg_sec_obj_dependencia().getCSOBJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_obj_dependencia tmpCgg_sec_obj_dependencia = new com.besixplus.sii.objects.Cgg_sec_obj_dependencia();
				tmpCgg_sec_obj_dependencia.setCSBJD_CODIGO(results.getString(1));
				tmpCgg_sec_obj_dependencia.setCSOBJ_CODIGO(results.getString(2));
				tmpCgg_sec_obj_dependencia.setCGG_CSOBJ_CODIGO(results.getString(3));
				tmpCgg_sec_obj_dependencia.setCSBJD_ESTADO(results.getBoolean(4));
				outCgg_sec_obj_dependencia.add(tmpCgg_sec_obj_dependencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_obj_dependencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_sec_obj_dependencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sec_objeto.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJ_DEPENDENCIA_D_CGG_SEC_OBJETO(?, ?) }");
			stmDelete.setString(1, this.getCgg_sec_obj_dependencia().getCGG_CSOBJ_CODIGO());
			stmDelete.setString(2, this.getCgg_sec_obj_dependencia().getCSOBJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_OBJ_DEPENDENCIA_DS_CGG_SEC_OBJETO(?, ?) }");
				stmDelete.setString(1, this.getCgg_sec_obj_dependencia().getCGG_CSOBJ_CODIGO());
				stmDelete.setString(2, this.getCgg_sec_obj_dependencia().getCSOBJ_CODIGO());
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