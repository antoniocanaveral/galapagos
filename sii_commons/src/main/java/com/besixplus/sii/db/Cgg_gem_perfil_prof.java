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
* CLASE Cgg_gem_perfil_prof
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_perfil_prof.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_perfil_prof implements Serializable{
	private static final long serialVersionUID = 1797647971;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_perfil_prof.
	*/
	private com.besixplus.sii.objects.Cgg_gem_perfil_prof myCgg_gem_perfil_prof = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_prof.
	*/
	public Cgg_gem_perfil_prof(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_prof.
	* @param inCgg_gem_perfil_prof OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_perfil_prof.
	*/
	public Cgg_gem_perfil_prof(
		com.besixplus.sii.objects.Cgg_gem_perfil_prof inCgg_gem_perfil_prof
	){
		this.setCgg_gem_perfil_prof(inCgg_gem_perfil_prof);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_perfil_prof.
	* @param inCgg_gem_perfil_prof OBJETO Cgg_gem_perfil_prof.
	* @return void
	*/
	public void setCgg_gem_perfil_prof(com.besixplus.sii.objects.Cgg_gem_perfil_prof inCgg_gem_perfil_prof){
		this.myCgg_gem_perfil_prof = inCgg_gem_perfil_prof;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_perfil_prof.
	* @return Cgg_gem_perfil_prof OBJETO Cgg_gem_perfil_prof.
	*/
	public com.besixplus.sii.objects.Cgg_gem_perfil_prof getCgg_gem_perfil_prof(){
		return this.myCgg_gem_perfil_prof;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_perfil_prof.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?::date, ?::date, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_perfil_prof().getCGPPR_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_perfil_prof().getCGESP_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_perfil_prof().getCGTPR_CODIGO());
			stmInsert.setString(5, this.getCgg_gem_perfil_prof().getCGMDC_CODIGO());
			stmInsert.setString(6, this.getCgg_gem_perfil_prof().getCRPER_CODIGO());
			stmInsert.setString(7, this.getCgg_gem_perfil_prof().getCGIEN_CODIGO());
			stmInsert.setInt(8, this.getCgg_gem_perfil_prof().getCGPPR_NIVEL_APROBADO());
			stmInsert.setDate(9, this.getCgg_gem_perfil_prof().getCGPPR_FECHA_INICIO() == null ?null:new java.sql.Date(this.getCgg_gem_perfil_prof().getCGPPR_FECHA_INICIO().getTime()));
			stmInsert.setDate(10,this.getCgg_gem_perfil_prof().getCGPPR_FECHA_FIN()==null?null: new java.sql.Date(this.getCgg_gem_perfil_prof().getCGPPR_FECHA_FIN().getTime()));
			stmInsert.setBoolean(11, this.getCgg_gem_perfil_prof().getCGPPR_CONFIRMADO());
			stmInsert.setTimestamp(12, new java.sql.Timestamp(this.getCgg_gem_perfil_prof().getCGPPR_FECHA_CONFIRMACION().getTime()));
			stmInsert.setBoolean(13, this.getCgg_gem_perfil_prof().getCGPPR_PREDETERMINADO());
			stmInsert.setBoolean(14, this.getCgg_gem_perfil_prof().getCGPPR_ESTADO());
			stmInsert.setString(15, this.getCgg_gem_perfil_prof().getCGPPR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_perfil_prof().setCGPPR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_perfil_prof = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_perfil_prof.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_perfil_prof.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_perfil_prof.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?::date, ?::date, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_perfil_prof().getCGPPR_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_perfil_prof().getCGESP_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_perfil_prof().getCGTPR_CODIGO());
			stmUpdate.setString(4, this.getCgg_gem_perfil_prof().getCGMDC_CODIGO());
			stmUpdate.setString(5, this.getCgg_gem_perfil_prof().getCRPER_CODIGO());
			stmUpdate.setString(6, this.getCgg_gem_perfil_prof().getCGIEN_CODIGO());
			stmUpdate.setInt(7, this.getCgg_gem_perfil_prof().getCGPPR_NIVEL_APROBADO());
			stmUpdate.setDate(8, this.getCgg_gem_perfil_prof().getCGPPR_FECHA_INICIO() == null ?null:new java.sql.Date(this.getCgg_gem_perfil_prof().getCGPPR_FECHA_INICIO().getTime()));
			stmUpdate.setDate(9,this.getCgg_gem_perfil_prof().getCGPPR_FECHA_FIN()==null?null: new java.sql.Date(this.getCgg_gem_perfil_prof().getCGPPR_FECHA_FIN().getTime()));
			stmUpdate.setBoolean(10, this.getCgg_gem_perfil_prof().getCGPPR_CONFIRMADO());
			stmUpdate.setTimestamp(11, new java.sql.Timestamp(this.getCgg_gem_perfil_prof().getCGPPR_FECHA_CONFIRMACION().getTime()));
			stmUpdate.setBoolean(12, this.getCgg_gem_perfil_prof().getCGPPR_PREDETERMINADO());
			stmUpdate.setBoolean(13, this.getCgg_gem_perfil_prof().getCGPPR_ESTADO());
			stmUpdate.setString(14, this.getCgg_gem_perfil_prof().getCGPPR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_perfil_prof select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCGPPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_perfil_prof().setCGPPR_CODIGO(results.getString(1));
				this.getCgg_gem_perfil_prof().setCGESP_CODIGO(results.getString(2));
				this.getCgg_gem_perfil_prof().setCGTPR_CODIGO(results.getString(3));
				this.getCgg_gem_perfil_prof().setCGMDC_CODIGO(results.getString(4));
				this.getCgg_gem_perfil_prof().setCRPER_CODIGO(results.getString(5));
				this.getCgg_gem_perfil_prof().setCGIEN_CODIGO(results.getString(6));
				this.getCgg_gem_perfil_prof().setCGPPR_NIVEL_APROBADO(results.getInt(7));
				this.getCgg_gem_perfil_prof().setCGPPR_FECHA_INICIO(results.getDate(8));
				this.getCgg_gem_perfil_prof().setCGPPR_FECHA_FIN(results.getDate(9));
				this.getCgg_gem_perfil_prof().setCGPPR_CONFIRMADO(results.getBoolean(10));
				this.getCgg_gem_perfil_prof().setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				this.getCgg_gem_perfil_prof().setCGPPR_PREDETERMINADO(results.getBoolean(12));
				this.getCgg_gem_perfil_prof().setCGPPR_ESTADO(results.getBoolean(13));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_perfil_prof();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGPPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGPPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_institucion_nivel.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectCGG_INSTITUCION_NIVEL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_S_CGG_INSTITUCION_NIVEL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCGIEN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_institucion_nivel.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_INSTITUCION_NIVEL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_D_CGG_INSTITUCION_NIVEL(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGIEN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DS_CGG_INSTITUCION_NIVEL(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGIEN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_especialidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectCGG_ESPECIALIDAD(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_S_CGG_ESPECIALIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCGESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_especialidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_ESPECIALIDAD(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_D_CGG_ESPECIALIDAD(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DS_CGG_ESPECIALIDAD(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGESP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_modalidad_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectCGG_MODALIDAD_CURSO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_S_CGG_MODALIDAD_CURSO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCGMDC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_modalidad_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_MODALIDAD_CURSO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_D_CGG_MODALIDAD_CURSO(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGMDC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DS_CGG_MODALIDAD_CURSO(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGMDC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
/*	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectCGG_NIVEL_ESTUDIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_S_CGG_NIVEL_ESTUDIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCGNES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGIED_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGNES_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(7));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(8));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(9));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(10));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(11));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(12));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}*/

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	/*public boolean deleteCGG_NIVEL_ESTUDIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_D_CGG_NIVEL_ESTUDIO(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGNES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DS_CGG_NIVEL_ESTUDIO(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGNES_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}*/

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectCGG_TITULO_PROFESIONAL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_S_CGG_TITULO_PROFESIONAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCGTPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}


	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TITULO_PROFESIONAL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_D_CGG_TITULO_PROFESIONAL(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGTPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DS_CGG_TITULO_PROFESIONAL(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCGTPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_prof OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> outCgg_gem_perfil_prof = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_prof().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_prof tmpCgg_gem_perfil_prof = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				tmpCgg_gem_perfil_prof.setCGPPR_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_prof.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_prof.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil_prof.setCGMDC_CODIGO(results.getString(4));
				tmpCgg_gem_perfil_prof.setCRPER_CODIGO(results.getString(5));
				tmpCgg_gem_perfil_prof.setCGIEN_CODIGO(results.getString(6));
				tmpCgg_gem_perfil_prof.setCGPPR_NIVEL_APROBADO(results.getInt(7));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_INICIO(results.getDate(8));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_FIN(results.getDate(9));
				tmpCgg_gem_perfil_prof.setCGPPR_CONFIRMADO(results.getBoolean(10));
				tmpCgg_gem_perfil_prof.setCGPPR_FECHA_CONFIRMACION(results.getTimestamp(11));
				tmpCgg_gem_perfil_prof.setCGPPR_PREDETERMINADO(results.getBoolean(12));
				tmpCgg_gem_perfil_prof.setCGPPR_ESTADO(results.getBoolean(13));
				outCgg_gem_perfil_prof.add(tmpCgg_gem_perfil_prof);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_PROF_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_prof().getCRPER_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public  ArrayList<HashMap<String,Object>> selectPerfilPersona(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_perfil_prof = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_PROF_SELECT_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_gem_perfil_prof().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_perfil_prof.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectEducacionById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_perfil_prof_educacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EDUCACION_SELECTBYID(?) }");
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
				outCgg_gem_perfil_prof_educacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_prof_educacion;
	}	
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE ORDENACION DE LOS CAMPOS
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA A BUSCAR
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPagePerfilProfesional(
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_PERFIL_PROF_SELECT_GENERAL(?,?,?,?,?,?,?) }");
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
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int selectCountByIdPersona(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrper_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_PERFIL_PROF_COUNTBYID_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrper_codigo);
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
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE ORDENACION DE LOS CAMPOS
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCodigoNiveles IDENTIFICATIVO UNICO DE NIVELES.
	* @param inCodigoEspecialidades IDENTIFICATIVO UNICO DE ESPECIALIDADES.
	* @param inCodigoTitulos IDENTIFICATIVO UNICO DE TITULOS.
	* @param inCodigoDestrezas IDENTIFICATIVO UNICO DE DESTREZAS.
	* @param inCodigoIdiomas IDENTIFICATIVO UNICO DE IDIOMAS.
	* @param inCodigoIslas IDENTIFICATIVO UNICO DE ISLAS.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA A BUSCAR
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_prof> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPageDinamicoPersonas(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCodigoNiveles,
			String inCodigoEspecialidades,
			String inCodigoTitulos,
			String inCodigoDestrezas,
			String inCodigoIdiomas,
			String inCodigoIslas
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_PERFIL_DINAMICO(?,?,?,?,?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCodigoNiveles);
			stmSelect.setString(9, inCodigoEspecialidades);
			stmSelect.setString(10, inCodigoTitulos);
			stmSelect.setString(11, inCodigoDestrezas);
			stmSelect.setString(12, inCodigoIdiomas);
			stmSelect.setString(13, inCodigoIslas);
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
	 * @param inCodigoNiveles IDENTIFICATIVO UNICO DE NIVELES.
	 * @param inCodigoEspecialidades IDENTIFICATIVO UNICO DE ESPECIALIDADES.
	 * @param inCodigoTitulos IDENTIFICATIVO UNICO DE TITULOS.
	 * @param inCodigoDestrezas IDENTIFICATIVO UNICO DE DESTREZAS.
	 * @param inCodigoIdiomas IDENTIFICATIVO UNICO DE IDIOMAS.
	 * @param inCodigoIslas IDENTIFICATIVO UNICO DE ISLAS.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA.
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int countDinamicoPersonas(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCodigoNiveles,
		String inCodigoEspecialidades,
		String inCodigoTitulos,
		String inCodigoDestrezas,
		String inCodigoIdiomas,
		String inCodigoIslas
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword ="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_PERFIL_DINAMICO_COUNT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCodigoNiveles);
			stmSelect.setString(4, inCodigoEspecialidades);
			stmSelect.setString(5, inCodigoTitulos);
			stmSelect.setString(6, inCodigoDestrezas);
			stmSelect.setString(7, inCodigoIdiomas);
			stmSelect.setString(8, inCodigoIslas);			
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
}