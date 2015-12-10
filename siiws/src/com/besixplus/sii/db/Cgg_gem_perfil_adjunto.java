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
* CLASE Cgg_gem_perfil_adjunto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_perfil_adjunto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_perfil_adjunto implements Serializable{
	private static final long serialVersionUID = 1666044658;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_perfil_adjunto.
	*/
	private com.besixplus.sii.objects.Cgg_gem_perfil_adjunto myCgg_gem_perfil_adjunto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_adjunto.
	*/
	public Cgg_gem_perfil_adjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_adjunto.
	* @param inCgg_gem_perfil_adjunto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_perfil_adjunto.
	*/
	public Cgg_gem_perfil_adjunto(
		com.besixplus.sii.objects.Cgg_gem_perfil_adjunto inCgg_gem_perfil_adjunto
	){
		this.setCgg_gem_perfil_adjunto(inCgg_gem_perfil_adjunto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_perfil_adjunto.
	* @param inCgg_gem_perfil_adjunto OBJETO Cgg_gem_perfil_adjunto.
	* @return void
	*/
	public void setCgg_gem_perfil_adjunto(com.besixplus.sii.objects.Cgg_gem_perfil_adjunto inCgg_gem_perfil_adjunto){
		this.myCgg_gem_perfil_adjunto = inCgg_gem_perfil_adjunto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_perfil_adjunto.
	* @return Cgg_gem_perfil_adjunto OBJETO Cgg_gem_perfil_adjunto.
	*/
	public com.besixplus.sii.objects.Cgg_gem_perfil_adjunto getCgg_gem_perfil_adjunto(){
		return this.myCgg_gem_perfil_adjunto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_perfil_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_perfil_adjunto().getCGPFA_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_perfil_adjunto().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_perfil_adjunto().getCGPFA_DESCRIPCION());
			stmInsert.setString(5, this.getCgg_gem_perfil_adjunto().getCGPFA_NOMBRE_ADJUNTO());
			stmInsert.setString(6, this.getCgg_gem_perfil_adjunto().getCGPFA_TIPO_ADJUNTO());
			stmInsert.setBytes(7, this.getCgg_gem_perfil_adjunto().getCGPFA_ADJUNTO());
			stmInsert.setInt(8, this.getCgg_gem_perfil_adjunto().getCGPFA_TIPO());
			stmInsert.setBoolean(9, this.getCgg_gem_perfil_adjunto().getCGPFA_ESTADO());
			stmInsert.setString(10, this.getCgg_gem_perfil_adjunto().getCGPFA_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_perfil_adjunto().setCGPFA_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> outCgg_gem_perfil_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_adjunto tmpCgg_gem_perfil_adjunto = new com.besixplus.sii.objects.Cgg_gem_perfil_adjunto();
				tmpCgg_gem_perfil_adjunto.setCGPFA_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_adjunto.setCGPFA_DESCRIPCION(results.getString(3));
				tmpCgg_gem_perfil_adjunto.setCGPFA_NOMBRE_ADJUNTO(results.getString(4));
				tmpCgg_gem_perfil_adjunto.setCGPFA_TIPO_ADJUNTO(results.getString(5));
				tmpCgg_gem_perfil_adjunto.setCGPFA_ADJUNTO(results.getBytes(6));
				tmpCgg_gem_perfil_adjunto.setCGPFA_ESTADO(results.getBoolean(7));
				outCgg_gem_perfil_adjunto.add(tmpCgg_gem_perfil_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_adjunto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> outCgg_gem_perfil_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_perfil_adjunto tmpCgg_gem_perfil_adjunto = new com.besixplus.sii.objects.Cgg_gem_perfil_adjunto();
				tmpCgg_gem_perfil_adjunto.setCGPFA_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_adjunto.setCGPFA_DESCRIPCION(results.getString(3));
				tmpCgg_gem_perfil_adjunto.setCGPFA_NOMBRE_ADJUNTO(results.getString(4));
				tmpCgg_gem_perfil_adjunto.setCGPFA_TIPO_ADJUNTO(results.getString(5));
				tmpCgg_gem_perfil_adjunto.setCGPFA_ADJUNTO(results.getBytes(6));
				tmpCgg_gem_perfil_adjunto.setCGPFA_ESTADO(results.getBoolean(7));
				outCgg_gem_perfil_adjunto.add(tmpCgg_gem_perfil_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_adjunto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_perfil_adjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_perfil_adjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_adjunto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_perfil_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_perfil_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_ADJUNTO_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?,?) }");
			stmUpdate.setString(1, this.getCgg_gem_perfil_adjunto().getCGPFA_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_perfil_adjunto().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_perfil_adjunto().getCGPFA_DESCRIPCION());
			stmUpdate.setString(4, this.getCgg_gem_perfil_adjunto().getCGPFA_NOMBRE_ADJUNTO());
			stmUpdate.setString(5, this.getCgg_gem_perfil_adjunto().getCGPFA_TIPO_ADJUNTO());
			stmUpdate.setBytes(6, this.getCgg_gem_perfil_adjunto().getCGPFA_ADJUNTO());
			stmUpdate.setInt(7, this.getCgg_gem_perfil_adjunto().getCGPFA_TIPO());
			stmUpdate.setBoolean(8, this.getCgg_gem_perfil_adjunto().getCGPFA_ESTADO());
			stmUpdate.setString(9, this.getCgg_gem_perfil_adjunto().getCGPFA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_perfil_adjunto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_perfil_adjunto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_adjunto().getCGPFA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_perfil_adjunto().setCGPFA_CODIGO(results.getString(1));
				this.getCgg_gem_perfil_adjunto().setCRPER_CODIGO(results.getString(2));
				this.getCgg_gem_perfil_adjunto().setCGPFA_DESCRIPCION(results.getString(3));
				this.getCgg_gem_perfil_adjunto().setCGPFA_NOMBRE_ADJUNTO(results.getString(4));
				this.getCgg_gem_perfil_adjunto().setCGPFA_TIPO_ADJUNTO(results.getString(5));
				this.getCgg_gem_perfil_adjunto().setCGPFA_ADJUNTO(results.getBytes(6));
				this.getCgg_gem_perfil_adjunto().setCGPFA_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_perfil_adjunto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_perfil_adjunto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_ADJUNTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_adjunto().getCGPFA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_ADJUNTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_adjunto().getCGPFA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_adjunto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_perfil_prof.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> selectCGG_GEM_PERFIL_PROF(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto> outCgg_gem_perfil_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_ADJUNTO_S_CGG_GEM_PERFIL_PROF(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil_adjunto().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil_adjunto tmpCgg_gem_perfil_adjunto = new com.besixplus.sii.objects.Cgg_gem_perfil_adjunto();
				tmpCgg_gem_perfil_adjunto.setCGPFA_CODIGO(results.getString(1));
				tmpCgg_gem_perfil_adjunto.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_perfil_adjunto.setCGPFA_DESCRIPCION(results.getString(3));
				tmpCgg_gem_perfil_adjunto.setCGPFA_NOMBRE_ADJUNTO(results.getString(4));
				tmpCgg_gem_perfil_adjunto.setCGPFA_TIPO_ADJUNTO(results.getString(5));
				tmpCgg_gem_perfil_adjunto.setCGPFA_ADJUNTO(results.getBytes(6));
				tmpCgg_gem_perfil_adjunto.setCGPFA_ESTADO(results.getBoolean(7));
				outCgg_gem_perfil_adjunto.add(tmpCgg_gem_perfil_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil_adjunto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_perfil_prof.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_PERFIL_PROF(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_ADJUNTO_D_CGG_GEM_PERFIL_PROF(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil_adjunto().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_ADJUNTO_DS_CGG_GEM_PERFIL_PROF(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil_adjunto().getCRPER_CODIGO());
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
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCgpfa_tipo ESPECIFICA EL TIPO DE ARCHIVO.
		0 - TIPO PERFIL
		1 - TIPO CERTIFICADO
	* @param inCgied_codigo CODIGO DE LA INSTITUCION A CONSULTAR
	* * @return ArrayList<com.besixplus.sii.objects.Cgg_res_fase> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAdjuntosByIdPersona(
		java.sql.Connection inConnection,
		String inCrper_codigo,
		int inCgpfa_tipo
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_informacion_laboral = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_PERFIL_ADJUNTO_BYIDPERSONA(?,?::smallint) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrper_codigo);
			stmSelect.setInt(3,inCgpfa_tipo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_informacion_laboral.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_informacion_laboral;
	}

}