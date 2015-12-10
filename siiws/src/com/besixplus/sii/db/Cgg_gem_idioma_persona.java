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
* CLASE Cgg_gem_idioma_persona
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_idioma_persona.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_idioma_persona implements Serializable{
	private static final long serialVersionUID = 2124628579;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_idioma_persona.
	*/
	private com.besixplus.sii.objects.Cgg_gem_idioma_persona myCgg_gem_idioma_persona = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_idioma_persona.
	*/
	public Cgg_gem_idioma_persona(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_idioma_persona.
	* @param inCgg_gem_idioma_persona OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_idioma_persona.
	*/
	public Cgg_gem_idioma_persona(
		com.besixplus.sii.objects.Cgg_gem_idioma_persona inCgg_gem_idioma_persona
	){
		this.setCgg_gem_idioma_persona(inCgg_gem_idioma_persona);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_idioma_persona.
	* @param inCgg_gem_idioma_persona OBJETO Cgg_gem_idioma_persona.
	* @return void
	*/
	public void setCgg_gem_idioma_persona(com.besixplus.sii.objects.Cgg_gem_idioma_persona inCgg_gem_idioma_persona){
		this.myCgg_gem_idioma_persona = inCgg_gem_idioma_persona;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_idioma_persona.
	* @return Cgg_gem_idioma_persona OBJETO Cgg_gem_idioma_persona.
	*/
	public com.besixplus.sii.objects.Cgg_gem_idioma_persona getCgg_gem_idioma_persona(){
		return this.myCgg_gem_idioma_persona;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_idioma_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_idioma_persona().getCGIDP_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_idioma_persona().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_idioma_persona().getCGIDM_CODIGO());
			stmInsert.setBigDecimal(5, this.getCgg_gem_idioma_persona().getCGIDP_ESCRITURA());
			stmInsert.setBigDecimal(6, this.getCgg_gem_idioma_persona().getCGIDP_LECTURA());
			stmInsert.setBigDecimal(7, this.getCgg_gem_idioma_persona().getCGIDP_HABLAR());
			stmInsert.setBigDecimal(8, this.getCgg_gem_idioma_persona().getCGIDP_ESCUCHAR());
			stmInsert.setBoolean(9, this.getCgg_gem_idioma_persona().getCGIDP_ESTADO());
			stmInsert.setString(10, this.getCgg_gem_idioma_persona().getCGIDP_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_idioma_persona().setCGIDP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> outCgg_gem_idioma_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_idioma_persona tmpCgg_gem_idioma_persona = new com.besixplus.sii.objects.Cgg_gem_idioma_persona();
				tmpCgg_gem_idioma_persona.setCGIDP_CODIGO(results.getString(1));
				tmpCgg_gem_idioma_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_idioma_persona.setCGIDM_CODIGO(results.getString(3));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCRITURA(results.getBigDecimal(4));
				tmpCgg_gem_idioma_persona.setCGIDP_LECTURA(results.getBigDecimal(5));
				tmpCgg_gem_idioma_persona.setCGIDP_HABLAR(results.getBigDecimal(6));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCUCHAR(results.getBigDecimal(7));
				tmpCgg_gem_idioma_persona.setCGIDP_ESTADO(results.getBoolean(8));
				outCgg_gem_idioma_persona.add(tmpCgg_gem_idioma_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_idioma_persona;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> outCgg_gem_idioma_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_idioma_persona tmpCgg_gem_idioma_persona = new com.besixplus.sii.objects.Cgg_gem_idioma_persona();
				tmpCgg_gem_idioma_persona.setCGIDP_CODIGO(results.getString(1));
				tmpCgg_gem_idioma_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_idioma_persona.setCGIDM_CODIGO(results.getString(3));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCRITURA(results.getBigDecimal(4));
				tmpCgg_gem_idioma_persona.setCGIDP_LECTURA(results.getBigDecimal(5));
				tmpCgg_gem_idioma_persona.setCGIDP_HABLAR(results.getBigDecimal(6));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCUCHAR(results.getBigDecimal(7));
				tmpCgg_gem_idioma_persona.setCGIDP_ESTADO(results.getBoolean(8));
				outCgg_gem_idioma_persona.add(tmpCgg_gem_idioma_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_idioma_persona;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_idioma_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_idioma_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_idioma_persona;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_idioma_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_idioma_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_idioma_persona().getCGIDP_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_idioma_persona().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_idioma_persona().getCGIDM_CODIGO());
			stmUpdate.setBigDecimal(4, this.getCgg_gem_idioma_persona().getCGIDP_ESCRITURA());
			stmUpdate.setBigDecimal(5, this.getCgg_gem_idioma_persona().getCGIDP_LECTURA());
			stmUpdate.setBigDecimal(6, this.getCgg_gem_idioma_persona().getCGIDP_HABLAR());
			stmUpdate.setBigDecimal(7, this.getCgg_gem_idioma_persona().getCGIDP_ESCUCHAR());
			stmUpdate.setBoolean(8, this.getCgg_gem_idioma_persona().getCGIDP_ESTADO());
			stmUpdate.setString(9, this.getCgg_gem_idioma_persona().getCGIDP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_idioma_persona DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_idioma_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_idioma_persona select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_idioma_persona().getCGIDP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_idioma_persona().setCGIDP_CODIGO(results.getString(1));
				this.getCgg_gem_idioma_persona().setCRPER_CODIGO(results.getString(2));
				this.getCgg_gem_idioma_persona().setCGIDM_CODIGO(results.getString(3));
				this.getCgg_gem_idioma_persona().setCGIDP_ESCRITURA(results.getBigDecimal(4));
				this.getCgg_gem_idioma_persona().setCGIDP_LECTURA(results.getBigDecimal(5));
				this.getCgg_gem_idioma_persona().setCGIDP_HABLAR(results.getBigDecimal(6));
				this.getCgg_gem_idioma_persona().setCGIDP_ESCUCHAR(results.getBigDecimal(7));
				this.getCgg_gem_idioma_persona().setCGIDP_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_idioma_persona();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_idioma_persona DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_idioma_persona().getCGIDP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_idioma_persona().getCGIDP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_idioma.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_idioma_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> selectCGG_GEM_IDIOMA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> outCgg_gem_idioma_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_S_CGG_GEM_IDIOMA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_idioma_persona().getCGIDM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_idioma_persona tmpCgg_gem_idioma_persona = new com.besixplus.sii.objects.Cgg_gem_idioma_persona();
				tmpCgg_gem_idioma_persona.setCGIDP_CODIGO(results.getString(1));
				tmpCgg_gem_idioma_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_idioma_persona.setCGIDM_CODIGO(results.getString(3));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCRITURA(results.getBigDecimal(4));
				tmpCgg_gem_idioma_persona.setCGIDP_LECTURA(results.getBigDecimal(5));
				tmpCgg_gem_idioma_persona.setCGIDP_HABLAR(results.getBigDecimal(6));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCUCHAR(results.getBigDecimal(7));
				tmpCgg_gem_idioma_persona.setCGIDP_ESTADO(results.getBoolean(8));
				outCgg_gem_idioma_persona.add(tmpCgg_gem_idioma_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_idioma_persona;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_idioma.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_IDIOMA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_D_CGG_GEM_IDIOMA(?) }");
			stmDelete.setString(1, this.getCgg_gem_idioma_persona().getCGIDM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_DS_CGG_GEM_IDIOMA(?) }");
				stmDelete.setString(1, this.getCgg_gem_idioma_persona().getCGIDM_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_idioma_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona> outCgg_gem_idioma_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_idioma_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_IDIOMA_PERSONA_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_idioma_persona().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_idioma_persona tmpCgg_gem_idioma_persona = new com.besixplus.sii.objects.Cgg_gem_idioma_persona();
				tmpCgg_gem_idioma_persona.setCGIDP_CODIGO(results.getString(1));
				tmpCgg_gem_idioma_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_idioma_persona.setCGIDM_CODIGO(results.getString(3));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCRITURA(results.getBigDecimal(4));
				tmpCgg_gem_idioma_persona.setCGIDP_LECTURA(results.getBigDecimal(5));
				tmpCgg_gem_idioma_persona.setCGIDP_HABLAR(results.getBigDecimal(6));
				tmpCgg_gem_idioma_persona.setCGIDP_ESCUCHAR(results.getBigDecimal(7));
				tmpCgg_gem_idioma_persona.setCGIDP_ESTADO(results.getBoolean(8));
				outCgg_gem_idioma_persona.add(tmpCgg_gem_idioma_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_idioma_persona;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_idioma_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_gem_idioma_persona().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_IDIOMA_PERSONA_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_gem_idioma_persona().getCRPER_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
  	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectIdiomasPersonaById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_IDIOMAS_PERSONA_SELECTBYID(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);			
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
	 * @param inUserName NOMBRE DE USUARIO.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageIdiomasPersona(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_idiomasPaginadosIdiomasBYID(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrper_codigo);
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
	* @param inCrper_codigo CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountById(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrper_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.f_cgg_res_persona_idiomas_countById(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inCrper_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

}