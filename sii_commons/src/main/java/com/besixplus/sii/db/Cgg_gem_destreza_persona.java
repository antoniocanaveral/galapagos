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
* CLASE Cgg_gem_destreza_persona
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_destreza_persona.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_destreza_persona implements Serializable{
	private static final long serialVersionUID = 877163000;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_destreza_persona.
	*/
	private com.besixplus.sii.objects.Cgg_gem_destreza_persona myCgg_gem_destreza_persona = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_destreza_persona.
	*/
	public Cgg_gem_destreza_persona(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_destreza_persona.
	* @param inCgg_gem_destreza_persona OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_destreza_persona.
	*/
	public Cgg_gem_destreza_persona(
		com.besixplus.sii.objects.Cgg_gem_destreza_persona inCgg_gem_destreza_persona
	){
		this.setCgg_gem_destreza_persona(inCgg_gem_destreza_persona);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_destreza_persona.
	* @param inCgg_gem_destreza_persona OBJETO Cgg_gem_destreza_persona.
	* @return void
	*/
	public void setCgg_gem_destreza_persona(com.besixplus.sii.objects.Cgg_gem_destreza_persona inCgg_gem_destreza_persona){
		this.myCgg_gem_destreza_persona = inCgg_gem_destreza_persona;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_destreza_persona.
	* @return Cgg_gem_destreza_persona OBJETO Cgg_gem_destreza_persona.
	*/
	public com.besixplus.sii.objects.Cgg_gem_destreza_persona getCgg_gem_destreza_persona(){
		return this.myCgg_gem_destreza_persona;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_destreza_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_destreza_persona().getCGDPR_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_gem_destreza_persona().getCGDPR_ESTADO());
			stmInsert.setString(6, this.getCgg_gem_destreza_persona().getCGDPR_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_gem_destreza_persona().getCGDPR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_destreza_persona().setCGDPR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> outCgg_gem_destreza_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_destreza_persona tmpCgg_gem_destreza_persona = new com.besixplus.sii.objects.Cgg_gem_destreza_persona();
				tmpCgg_gem_destreza_persona.setCGDPR_CODIGO(results.getString(1));
				tmpCgg_gem_destreza_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_destreza_persona.setCGDST_CODIGO(results.getString(3));
				tmpCgg_gem_destreza_persona.setCGDPR_ESTADO(results.getBoolean(4));
				outCgg_gem_destreza_persona.add(tmpCgg_gem_destreza_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_destreza_persona;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> outCgg_gem_destreza_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_destreza_persona tmpCgg_gem_destreza_persona = new com.besixplus.sii.objects.Cgg_gem_destreza_persona();
				tmpCgg_gem_destreza_persona.setCGDPR_CODIGO(results.getString(1));
				tmpCgg_gem_destreza_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_destreza_persona.setCGDST_CODIGO(results.getString(3));
				tmpCgg_gem_destreza_persona.setCGDPR_ESTADO(results.getBoolean(4));
				outCgg_gem_destreza_persona.add(tmpCgg_gem_destreza_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_destreza_persona;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_destreza_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_destreza_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_destreza_persona().getCGDPR_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_gem_destreza_persona().getCGDPR_ESTADO());
			stmUpdate.setString(5, this.getCgg_gem_destreza_persona().getCGDPR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_destreza_persona DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_destreza_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_destreza_persona select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_destreza_persona().getCGDPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_destreza_persona().setCGDPR_CODIGO(results.getString(1));
				this.getCgg_gem_destreza_persona().setCRPER_CODIGO(results.getString(2));
				this.getCgg_gem_destreza_persona().setCGDST_CODIGO(results.getString(3));
				this.getCgg_gem_destreza_persona().setCGDPR_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_destreza_persona();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_destreza_persona DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_destreza_persona().getCGDPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_destreza_persona().getCGDPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_destrezas.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_destreza_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> selectCGG_GEM_DESTREZAS(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> outCgg_gem_destreza_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_S_CGG_GEM_DESTREZAS(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
			stmSelect.setString(3,this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_destreza_persona tmpCgg_gem_destreza_persona = new com.besixplus.sii.objects.Cgg_gem_destreza_persona();
				tmpCgg_gem_destreza_persona.setCGDPR_CODIGO(results.getString(1));
				tmpCgg_gem_destreza_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_destreza_persona.setCGDST_CODIGO(results.getString(3));
				tmpCgg_gem_destreza_persona.setCGDPR_ESTADO(results.getBoolean(4));
				outCgg_gem_destreza_persona.add(tmpCgg_gem_destreza_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_destreza_persona;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_destrezas.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_DESTREZAS(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_D_CGG_GEM_DESTREZAS(?, ?) }");
			stmDelete.setString(1, this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
			stmDelete.setString(2, this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_DS_CGG_GEM_DESTREZAS(?, ?) }");
				stmDelete.setString(1, this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
				stmDelete.setString(2, this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_destreza_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> outCgg_gem_destreza_persona = new ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZA_PERSONA_S_CGG_RES_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
			stmSelect.setString(3,this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_destreza_persona tmpCgg_gem_destreza_persona = new com.besixplus.sii.objects.Cgg_gem_destreza_persona();
				tmpCgg_gem_destreza_persona.setCGDPR_CODIGO(results.getString(1));
				tmpCgg_gem_destreza_persona.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_destreza_persona.setCGDST_CODIGO(results.getString(3));
				tmpCgg_gem_destreza_persona.setCGDPR_ESTADO(results.getBoolean(4));
				outCgg_gem_destreza_persona.add(tmpCgg_gem_destreza_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_destreza_persona;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_D_CGG_RES_PERSONA(?, ?) }");
			stmDelete.setString(1, this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
			stmDelete.setString(2, this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_DESTREZA_PERSONA_DS_CGG_RES_PERSONA(?, ?) }");
				stmDelete.setString(1, this.getCgg_gem_destreza_persona().getCGDST_CODIGO());
				stmDelete.setString(2, this.getCgg_gem_destreza_persona().getCRPER_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS. 
	 * @param inCrper_codigo CRITERIO DE BUSQUEDA.IDENTIFICATIVO UNICO DE LA PERSONA.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_gem_destreza_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectDestrezasPersonaById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_destreza_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_DESTREZAS_PERSONA_BYID(?) }");
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
				outCgg_gem_destreza_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_destreza_persona;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA
	* @param inCgdst_tipo CRITERIO DE BUSQUEDA. TIPO DE REGISTRO DE LA TABLA DESTREZA / TRUE - DESTREZA / FALSE - HABILIDAD
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int selectCountById(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrper_codigo,
		Boolean inCgdst_tipo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_DESTREZA_PERSONA_COUNT_BYID(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inCrper_codigo);
			stmSelect.setBoolean(4,inCgdst_tipo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrper_codigo IDENTIFICATIVO UNICO DE LA PERSONA. CRITERIO DE BUSQUEDA
	* @param inCgdst_tipo CRITERIO DE BUSQUEDA. TIPO DE REGISTRO DE LA TABLA DESTREZA / TRUE - DESTREZA / FALSE - HABILIDAD
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPageDestrezaPersona(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrper_codigo,
			boolean inCgdst_tipo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_DESTREZA_PERSONA_SELECTPAGE_BYID(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrper_codigo);
			stmSelect.setBoolean(9, inCgdst_tipo);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_destreza_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrper_codigo IDENTIFICATIVO UNICO DE LA PERSONA. CRITERIO DE BUSQUEDA
	* @param inCgdst_tipo CRITERIO DE BUSQUEDA. TIPO DE REGISTRO DE LA TABLA DESTREZA / TRUE - DESTREZA / FALSE - HABILIDAD
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPageDestrezaHabilidadPersona(
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_DESTREZA_HABILIDAD_PERSONA_SELECTPAGE_BYID(?,?,?,?,?,?,?) }");
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
	* @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA
	* @param inCgdst_tipo CRITERIO DE BUSQUEDA. TIPO DE REGISTRO DE LA TABLA DESTREZA / TRUE - DESTREZA / FALSE - HABILIDAD
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int selectCountDestrezaHabilidadById(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrper_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_DESTREZA_HABILIDAD_PERSONA_COUNT_BYID(?,?) }");
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