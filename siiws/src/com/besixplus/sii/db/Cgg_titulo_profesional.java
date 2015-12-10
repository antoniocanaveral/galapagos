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
* CLASE Cgg_titulo_profesional
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_titulo_profesional.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_titulo_profesional implements Serializable{
	private static final long serialVersionUID = 590751258;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_titulo_profesional.
	*/
	private com.besixplus.sii.objects.Cgg_titulo_profesional myCgg_titulo_profesional = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_titulo_profesional.
	*/
	public Cgg_titulo_profesional(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_titulo_profesional.
	* @param inCgg_titulo_profesional OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_titulo_profesional.
	*/
	public Cgg_titulo_profesional(
		com.besixplus.sii.objects.Cgg_titulo_profesional inCgg_titulo_profesional
	){
		this.setCgg_titulo_profesional(inCgg_titulo_profesional);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_titulo_profesional.
	* @param inCgg_titulo_profesional OBJETO Cgg_titulo_profesional.
	* @return void
	*/
	public void setCgg_titulo_profesional(com.besixplus.sii.objects.Cgg_titulo_profesional inCgg_titulo_profesional){
		this.myCgg_titulo_profesional = inCgg_titulo_profesional;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_titulo_profesional.
	* @return Cgg_titulo_profesional OBJETO Cgg_titulo_profesional.
	*/
	public com.besixplus.sii.objects.Cgg_titulo_profesional getCgg_titulo_profesional(){
		return this.myCgg_titulo_profesional;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_titulo_profesional().getCGTPR_CODIGO());
			stmInsert.setString(3, this.getCgg_titulo_profesional().getCGTPR_DESCRIPCION());
			stmInsert.setBoolean(4, this.getCgg_titulo_profesional().getCGTPR_ESTADO());
			stmInsert.setString(5, this.getCgg_titulo_profesional().getCGTPR_USUARIO_INSERT());
			stmInsert.setString(6, this.getCgg_titulo_profesional().getCGTPR_USUARIO_UPDATE());
			stmInsert.setString(7, this.getCgg_titulo_profesional().getCGNES_CODIGO());
			stmInsert.execute();
			this.getCgg_titulo_profesional().setCGTPR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> outCgg_titulo_profesional = new ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_titulo_profesional tmpCgg_titulo_profesional = new com.besixplus.sii.objects.Cgg_titulo_profesional();
				tmpCgg_titulo_profesional.setCGTPR_CODIGO(results.getString(1));
				tmpCgg_titulo_profesional.setCGTPR_DESCRIPCION(results.getString(2));
				tmpCgg_titulo_profesional.setCGTPR_ESTADO(results.getBoolean(3));
				outCgg_titulo_profesional.add(tmpCgg_titulo_profesional);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_titulo_profesional;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_titulo_profesional QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
    * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> outCgg_titulo_profesional = new ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_titulo_profesional tmpCgg_titulo_profesional = new com.besixplus.sii.objects.Cgg_titulo_profesional();
				tmpCgg_titulo_profesional.setCGTPR_CODIGO(results.getString(1));
				tmpCgg_titulo_profesional.setCGTPR_DESCRIPCION(results.getString(2));
				tmpCgg_titulo_profesional.setCGTPR_ESTADO(results.getBoolean(3));
				tmpCgg_titulo_profesional.setCGNES_CODIGO(results.getString(4));
				tmpCgg_titulo_profesional.setCGNES_DESCRIPCION(results.getString(5));
				outCgg_titulo_profesional.add(tmpCgg_titulo_profesional);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_titulo_profesional;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_titulo_profesional QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_titulo_profesional> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_titulo_profesional = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_titulo_profesional.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_titulo_profesional;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TITULO_PROFESIONAL_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_titulo_profesional().getCGTPR_CODIGO());
			stmUpdate.setString(2, this.getCgg_titulo_profesional().getCGTPR_DESCRIPCION());
			stmUpdate.setBoolean(3, this.getCgg_titulo_profesional().getCGTPR_ESTADO());
			stmUpdate.setString(4, this.getCgg_titulo_profesional().getCGTPR_USUARIO_UPDATE());
			stmUpdate.setString(5, this.getCgg_titulo_profesional().getCGNES_CODIGO());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_titulo_profesional DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_titulo_profesional OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_titulo_profesional select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_PROFESIONAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_titulo_profesional().getCGTPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_titulo_profesional().setCGTPR_CODIGO(results.getString(1));
				this.getCgg_titulo_profesional().setCGTPR_DESCRIPCION(results.getString(2));
				this.getCgg_titulo_profesional().setCGTPR_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_titulo_profesional();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_titulo_profesional DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TITULO_PROFESIONAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_titulo_profesional().getCGTPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TITULO_PROFESIONAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_titulo_profesional().getCGTPR_CODIGO());
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
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE NIVEL DE ESTUDIO.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCountTituloByIdNivel(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCgnes_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TITULO_COUNT_BYID_NIVEL(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inCgnes_codigo);
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
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE NIVEL DE ESTUDIO.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCountTituloByNiveles(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCgnes_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TITULO_COUNT_BYNIVELES(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inCgnes_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGSITROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCgnes_codigo IDENTIFICATIVO UNICO DE NIVEL DE ESTUDIO.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageTituloByIdNivelEstudio(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCgnes_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_BYID_NIVELESTUDIO(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCgnes_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCodigosNiveles  IDENTIFICATIVO DE NIVELES.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageTituloByNiveles(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCodigosNiveles
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TITULO_BYNIVELES(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCodigosNiveles);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
}