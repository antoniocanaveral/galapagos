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
* CLASE Cgg_institucion_nivel
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_institucion_nivel.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_institucion_nivel implements Serializable{
	private static final long serialVersionUID = 522906775;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_institucion_nivel.
	*/
	private com.besixplus.sii.objects.Cgg_institucion_nivel myCgg_institucion_nivel = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_nivel.
	*/
	public Cgg_institucion_nivel(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_nivel.
	* @param inCgg_institucion_nivel OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_institucion_nivel.
	*/
	public Cgg_institucion_nivel(
		com.besixplus.sii.objects.Cgg_institucion_nivel inCgg_institucion_nivel
	){
		this.setCgg_institucion_nivel(inCgg_institucion_nivel);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_institucion_nivel.
	* @param inCgg_institucion_nivel OBJETO Cgg_institucion_nivel.
	* @return void
	*/
	public void setCgg_institucion_nivel(com.besixplus.sii.objects.Cgg_institucion_nivel inCgg_institucion_nivel){
		this.myCgg_institucion_nivel = inCgg_institucion_nivel;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_institucion_nivel.
	* @return Cgg_institucion_nivel OBJETO Cgg_institucion_nivel.
	*/
	public com.besixplus.sii.objects.Cgg_institucion_nivel getCgg_institucion_nivel(){
		return this.myCgg_institucion_nivel;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_institucion_nivel.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_institucion_nivel().getCGIEN_CODIGO());
			stmInsert.setString(3, this.getCgg_institucion_nivel().getCGNES_CODIGO());
			stmInsert.setString(4, this.getCgg_institucion_nivel().getCGIED_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_institucion_nivel().getCGIEN_ESTADO());
			stmInsert.setString(6, this.getCgg_institucion_nivel().getCGIEN_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_institucion_nivel().setCGIEN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_nivel.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> outCgg_institucion_nivel = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_institucion_nivel tmpCgg_institucion_nivel = new com.besixplus.sii.objects.Cgg_institucion_nivel();
				tmpCgg_institucion_nivel.setCGIEN_CODIGO(results.getString(1));
				tmpCgg_institucion_nivel.setCGNES_CODIGO(results.getString(2));
				tmpCgg_institucion_nivel.setCGIED_CODIGO(results.getString(3));
				tmpCgg_institucion_nivel.setCGIEN_ESTADO(results.getBoolean(4));
				outCgg_institucion_nivel.add(tmpCgg_institucion_nivel);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_nivel;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_nivel QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> outCgg_institucion_nivel = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_institucion_nivel tmpCgg_institucion_nivel = new com.besixplus.sii.objects.Cgg_institucion_nivel();
				tmpCgg_institucion_nivel.setCGIEN_CODIGO(results.getString(1));
				tmpCgg_institucion_nivel.setCGNES_CODIGO(results.getString(2));
				tmpCgg_institucion_nivel.setCGIED_CODIGO(results.getString(3));
				tmpCgg_institucion_nivel.setCGIEN_ESTADO(results.getBoolean(4));
				outCgg_institucion_nivel.add(tmpCgg_institucion_nivel);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_nivel;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_nivel QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_institucion_nivel = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_institucion_nivel.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_nivel;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_institucion_nivel.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_institucion_nivel.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_institucion_nivel().getCGIEN_CODIGO());
			stmUpdate.setString(2, this.getCgg_institucion_nivel().getCGNES_CODIGO());
			stmUpdate.setString(3, this.getCgg_institucion_nivel().getCGIED_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_institucion_nivel().getCGIEN_ESTADO());
			stmUpdate.setString(5, this.getCgg_institucion_nivel().getCGIEN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_institucion_nivel DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_institucion_nivel OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_institucion_nivel select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_institucion_nivel().getCGIEN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_institucion_nivel().setCGIEN_CODIGO(results.getString(1));
				this.getCgg_institucion_nivel().setCGNES_CODIGO(results.getString(2));
				this.getCgg_institucion_nivel().setCGIED_CODIGO(results.getString(3));
				this.getCgg_institucion_nivel().setCGIEN_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_institucion_nivel();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_institucion_nivel DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_institucion_nivel().getCGIEN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_institucion_nivel().getCGIEN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_institucion_nivel DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_institucion_nivel OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> selectCGG_INSTITUCION_EDUCATIVA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> outCgg_institucion_nivel = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_S_CGG_INSTITUCION_EDUCATIVA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_institucion_nivel().getCGIED_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_institucion_nivel tmpCgg_institucion_nivel = new com.besixplus.sii.objects.Cgg_institucion_nivel();
				tmpCgg_institucion_nivel.setCGIEN_CODIGO(results.getString(1));
				tmpCgg_institucion_nivel.setCGNES_CODIGO(results.getString(2));
				tmpCgg_institucion_nivel.setCGIED_CODIGO(results.getString(3));
				tmpCgg_institucion_nivel.setCGIEN_ESTADO(results.getBoolean(4));
				outCgg_institucion_nivel.add(tmpCgg_institucion_nivel);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_nivel;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_institucion_nivel DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_INSTITUCION_EDUCATIVA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_D_CGG_INSTITUCION_EDUCATIVA(?) }");
			stmDelete.setString(1, this.getCgg_institucion_nivel().getCGIED_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_DS_CGG_INSTITUCION_EDUCATIVA(?) }");
				stmDelete.setString(1, this.getCgg_institucion_nivel().getCGIED_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_institucion_nivel DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_institucion_nivel OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> selectCGG_NIVEL_ESTUDIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel> outCgg_institucion_nivel = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_nivel>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_NIVEL_S_CGG_NIVEL_ESTUDIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_institucion_nivel().getCGNES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_institucion_nivel tmpCgg_institucion_nivel = new com.besixplus.sii.objects.Cgg_institucion_nivel();
				tmpCgg_institucion_nivel.setCGIEN_CODIGO(results.getString(1));
				tmpCgg_institucion_nivel.setCGNES_CODIGO(results.getString(2));
				tmpCgg_institucion_nivel.setCGIED_CODIGO(results.getString(3));
				tmpCgg_institucion_nivel.setCGIEN_ESTADO(results.getBoolean(4));
				outCgg_institucion_nivel.add(tmpCgg_institucion_nivel);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_nivel;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_institucion_nivel DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_NIVEL_ESTUDIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_D_CGG_NIVEL_ESTUDIO(?) }");
			stmDelete.setString(1, this.getCgg_institucion_nivel().getCGNES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_NIVEL_DS_CGG_NIVEL_ESTUDIO(?) }");
				stmDelete.setString(1, this.getCgg_institucion_nivel().getCGNES_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgied_codigo CODIGO DE LA INSTITUCION A CONSULTAR
	* * @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectInstitucionNivel(
		java.sql.Connection inConnection,
		String inCgied_codigo 
	){
		ArrayList<HashMap<String,Object>> outCgg_institucion_contacto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_INSTITUCION_NIVEL_SELECT_INSTITUCION_NIVEL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCgied_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_institucion_contacto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_contacto;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgnes_codigo CRITERIO DE BUSQUEDA
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageInstitucionByIdNivel1(
			java.sql.Connection inConnection,
			String inCgnes_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_BYID_NIVELESTUDIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCgnes_codigo);			
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
	 * @param inCgnes_codigo IDENTIFICATIVO UNICO DE NIVEL DE ESTUDIO.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageInstitucionByIdNivel(
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_BYID_NIVELESTUDIO(?,?,?,?,?,?,?) }");
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
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE NIVEL DE ESTUDIO.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountInstitucionByIdNivel(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCgnes_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_INSTITUCION_COUNT_BYID_NIVEL(?,?) }");
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
}