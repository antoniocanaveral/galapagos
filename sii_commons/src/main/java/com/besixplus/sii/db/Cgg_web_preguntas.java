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
* CLASE Cgg_web_preguntas
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_web_preguntas.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_web_preguntas implements Serializable{
	private static final long serialVersionUID = 1274174591;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_web_preguntas.
	*/
	private com.besixplus.sii.objects.Cgg_web_preguntas myCgg_web_preguntas = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_preguntas.
	*/
	public Cgg_web_preguntas(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_preguntas.
	* @param inCgg_web_preguntas OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_web_preguntas.
	*/
	public Cgg_web_preguntas(
		com.besixplus.sii.objects.Cgg_web_preguntas inCgg_web_preguntas
	){
		this.setCgg_web_preguntas(inCgg_web_preguntas);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_web_preguntas.
	* @param inCgg_web_preguntas OBJETO Cgg_web_preguntas.
	* @return void
	*/
	public void setCgg_web_preguntas(com.besixplus.sii.objects.Cgg_web_preguntas inCgg_web_preguntas){
		this.myCgg_web_preguntas = inCgg_web_preguntas;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_web_preguntas.
	* @return Cgg_web_preguntas OBJETO Cgg_web_preguntas.
	*/
	public com.besixplus.sii.objects.Cgg_web_preguntas getCgg_web_preguntas(){
		return this.myCgg_web_preguntas;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_web_preguntas.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_INSERT(?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_web_preguntas().getCWPRG_CODIGO());
			stmInsert.setString(3, this.getCgg_web_preguntas().getCWMOD_CODIGO());
			stmInsert.setString(4, this.getCgg_web_preguntas().getCWPRG_PREGUNTA());
			stmInsert.setString(5, this.getCgg_web_preguntas().getCWPRG_RESPUESTA());
			stmInsert.setString(6, this.getCgg_web_preguntas().getCWPRG_OBSERVACION());
			stmInsert.setInt(7, this.getCgg_web_preguntas().getCWPRG_PRIORIDAD());
			stmInsert.setBoolean(8, this.getCgg_web_preguntas().getCWPRG_ESTADO());
			stmInsert.setString(9, this.getCgg_web_preguntas().getCWPRG_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_web_preguntas().setCWPRG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_preguntas.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> outCgg_web_preguntas = new ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_web_preguntas tmpCgg_web_preguntas = new com.besixplus.sii.objects.Cgg_web_preguntas();
				tmpCgg_web_preguntas.setCWPRG_CODIGO(results.getString(1));
				tmpCgg_web_preguntas.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_web_preguntas.setCWPRG_PREGUNTA(results.getString(3));
				tmpCgg_web_preguntas.setCWPRG_RESPUESTA(results.getString(4));
				tmpCgg_web_preguntas.setCWPRG_OBSERVACION(results.getString(5));
				tmpCgg_web_preguntas.setCWPRG_PRIORIDAD(results.getInt(6));
				tmpCgg_web_preguntas.setCWPRG_ESTADO(results.getBoolean(7));
				outCgg_web_preguntas.add(tmpCgg_web_preguntas);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_preguntas;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_preguntas QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> outCgg_web_preguntas = new ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_web_preguntas tmpCgg_web_preguntas = new com.besixplus.sii.objects.Cgg_web_preguntas();
				tmpCgg_web_preguntas.setCWPRG_CODIGO(results.getString(1));
				tmpCgg_web_preguntas.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_web_preguntas.setCWPRG_PREGUNTA(results.getString(3));
				tmpCgg_web_preguntas.setCWPRG_RESPUESTA(results.getString(4));
				tmpCgg_web_preguntas.setCWPRG_OBSERVACION(results.getString(5));
				tmpCgg_web_preguntas.setCWPRG_PRIORIDAD(results.getInt(6));
				tmpCgg_web_preguntas.setCWPRG_ESTADO(results.getBoolean(7));
				outCgg_web_preguntas.add(tmpCgg_web_preguntas);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_preguntas;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_preguntas QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_web_preguntas = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_SELECT(?,?,?,?,?,?) }");
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
				outCgg_web_preguntas.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_preguntas;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_web_preguntas.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_web_preguntas.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_WEB_PREGUNTAS_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_web_preguntas().getCWPRG_CODIGO());
			stmUpdate.setString(2, this.getCgg_web_preguntas().getCWMOD_CODIGO());
			stmUpdate.setString(3, this.getCgg_web_preguntas().getCWPRG_PREGUNTA());
			stmUpdate.setString(4, this.getCgg_web_preguntas().getCWPRG_RESPUESTA());
			stmUpdate.setString(5, this.getCgg_web_preguntas().getCWPRG_OBSERVACION());
			stmUpdate.setInt(6, this.getCgg_web_preguntas().getCWPRG_PRIORIDAD());
			stmUpdate.setBoolean(7, this.getCgg_web_preguntas().getCWPRG_ESTADO());
			stmUpdate.setString(8, this.getCgg_web_preguntas().getCWPRG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_web_preguntas DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_web_preguntas OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_web_preguntas select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_web_preguntas().getCWPRG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_web_preguntas().setCWPRG_CODIGO(results.getString(1));
				this.getCgg_web_preguntas().setCWMOD_CODIGO(results.getString(2));
				this.getCgg_web_preguntas().setCWPRG_PREGUNTA(results.getString(3));
				this.getCgg_web_preguntas().setCWPRG_RESPUESTA(results.getString(4));
				this.getCgg_web_preguntas().setCWPRG_OBSERVACION(results.getString(5));
				this.getCgg_web_preguntas().setCWPRG_PRIORIDAD(results.getInt(6));
				this.getCgg_web_preguntas().setCWPRG_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_web_preguntas();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_web_preguntas DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_PREGUNTAS_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_web_preguntas().getCWPRG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_PREGUNTAS_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_web_preguntas().getCWPRG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_web_preguntas DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_web_modulo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_web_preguntas OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> selectCGG_WEB_MODULO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> outCgg_web_preguntas = new ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_S_CGG_WEB_MODULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_web_preguntas().getCWMOD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_web_preguntas tmpCgg_web_preguntas = new com.besixplus.sii.objects.Cgg_web_preguntas();
				tmpCgg_web_preguntas.setCWPRG_CODIGO(results.getString(1));
				tmpCgg_web_preguntas.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_web_preguntas.setCWPRG_PREGUNTA(results.getString(3));
				tmpCgg_web_preguntas.setCWPRG_RESPUESTA(results.getString(4));
				tmpCgg_web_preguntas.setCWPRG_OBSERVACION(results.getString(5));
				tmpCgg_web_preguntas.setCWPRG_PRIORIDAD(results.getInt(6));
				tmpCgg_web_preguntas.setCWPRG_ESTADO(results.getBoolean(7));
				outCgg_web_preguntas.add(tmpCgg_web_preguntas);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_preguntas;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_web_preguntas DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_web_modulo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_WEB_MODULO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_PREGUNTAS_D_CGG_WEB_MODULO(?) }");
			stmDelete.setString(1, this.getCgg_web_preguntas().getCWMOD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_PREGUNTAS_DS_CGG_WEB_MODULO(?) }");
				stmDelete.setString(1, this.getCgg_web_preguntas().getCWMOD_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_preguntas QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCwmod_Codigo IDENTIFICATIVO UNICO DE REGISTRO DE WEB MOODULO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_preguntas> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPageDirectByModulo(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCwmod_Codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_web_preguntas = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_WEB_PREGUNTAS_SELECT_BY_MODULO(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCwmod_Codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_web_preguntas.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_preguntas;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO DE WEB MODULO.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCountByModulo(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCwmod_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_PREGUNTAS_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCwmod_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

}