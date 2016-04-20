package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/*import javax.jws.WebParam;*/

/**
* CLASE Cgg_gem_vacante_perfil
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_vacante_perfil.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_vacante_perfil implements Serializable{
	private static final long serialVersionUID = 1325732934;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_vacante_perfil.
	*/
	private com.besixplus.sii.objects.Cgg_gem_vacante_perfil myCgg_gem_vacante_perfil = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante_perfil.
	*/
	public Cgg_gem_vacante_perfil(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante_perfil.
	* @param inCgg_gem_vacante_perfil OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_vacante_perfil.
	*/
	public Cgg_gem_vacante_perfil(
		com.besixplus.sii.objects.Cgg_gem_vacante_perfil inCgg_gem_vacante_perfil
	){
		this.setCgg_gem_vacante_perfil(inCgg_gem_vacante_perfil);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_vacante_perfil.
	* @param inCgg_gem_vacante_perfil OBJETO Cgg_gem_vacante_perfil.
	* @return void
	*/
	public void setCgg_gem_vacante_perfil(com.besixplus.sii.objects.Cgg_gem_vacante_perfil inCgg_gem_vacante_perfil){
		this.myCgg_gem_vacante_perfil = inCgg_gem_vacante_perfil;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_vacante_perfil.
	* @return Cgg_gem_vacante_perfil OBJETO Cgg_gem_vacante_perfil.
	*/
	public com.besixplus.sii.objects.Cgg_gem_vacante_perfil getCgg_gem_vacante_perfil(){
		return this.myCgg_gem_vacante_perfil;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_vacante_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_vacante_perfil().getCGVPR_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_vacante_perfil().getCGVCN_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_vacante_perfil().getCGPRF_CODIGO());
			stmInsert.setString(5, this.getCgg_gem_vacante_perfil().getCGVPR_DESCRIPCION());
			stmInsert.setBoolean(6, this.getCgg_gem_vacante_perfil().getCGVPR_ESTADO());
			stmInsert.setString(7, this.getCgg_gem_vacante_perfil().getCGVPR_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_gem_vacante_perfil().getCGVPR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_vacante_perfil().setCGVPR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> outCgg_gem_vacante_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_vacante_perfil tmpCgg_gem_vacante_perfil = new com.besixplus.sii.objects.Cgg_gem_vacante_perfil();
				tmpCgg_gem_vacante_perfil.setCGVPR_CODIGO(results.getString(1));
				tmpCgg_gem_vacante_perfil.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_vacante_perfil.setCGPRF_CODIGO(results.getString(3));
				tmpCgg_gem_vacante_perfil.setCGVPR_DESCRIPCION(results.getString(4));
				tmpCgg_gem_vacante_perfil.setCGVPR_ESTADO(results.getBoolean(5));
				outCgg_gem_vacante_perfil.add(tmpCgg_gem_vacante_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante_perfil;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> outCgg_gem_vacante_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_vacante_perfil tmpCgg_gem_vacante_perfil = new com.besixplus.sii.objects.Cgg_gem_vacante_perfil();
				tmpCgg_gem_vacante_perfil.setCGVPR_CODIGO(results.getString(1));
				tmpCgg_gem_vacante_perfil.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_vacante_perfil.setCGPRF_CODIGO(results.getString(3));
				tmpCgg_gem_vacante_perfil.setCGVPR_DESCRIPCION(results.getString(4));
				tmpCgg_gem_vacante_perfil.setCGVPR_ESTADO(results.getBoolean(5));
				outCgg_gem_vacante_perfil.add(tmpCgg_gem_vacante_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante_perfil;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO. 
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_vacante_perfil = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_vacante_perfil.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante_perfil;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_vacante_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_vacante_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_vacante_perfil().getCGVPR_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_vacante_perfil().getCGVCN_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_vacante_perfil().getCGPRF_CODIGO());
			stmUpdate.setString(4, this.getCgg_gem_vacante_perfil().getCGVPR_DESCRIPCION());
			stmUpdate.setBoolean(5, this.getCgg_gem_vacante_perfil().getCGVPR_ESTADO());
			stmUpdate.setString(6, this.getCgg_gem_vacante_perfil().getCGVPR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_vacante_perfil DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_vacante_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_vacante_perfil select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_vacante_perfil().getCGVPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_vacante_perfil().setCGVPR_CODIGO(results.getString(1));
				this.getCgg_gem_vacante_perfil().setCGVCN_CODIGO(results.getString(2));
				this.getCgg_gem_vacante_perfil().setCGPRF_CODIGO(results.getString(3));
				this.getCgg_gem_vacante_perfil().setCGVPR_DESCRIPCION(results.getString(4));
				this.getCgg_gem_vacante_perfil().setCGVPR_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_vacante_perfil();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_vacante_perfil DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_vacante_perfil().getCGVPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_vacante_perfil().getCGVPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_vacante_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> selectCGG_GEM_PERFIL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> outCgg_gem_vacante_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_S_CGG_GEM_PERFIL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_vacante_perfil().getCGPRF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_vacante_perfil tmpCgg_gem_vacante_perfil = new com.besixplus.sii.objects.Cgg_gem_vacante_perfil();
				tmpCgg_gem_vacante_perfil.setCGVPR_CODIGO(results.getString(1));
				tmpCgg_gem_vacante_perfil.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_vacante_perfil.setCGPRF_CODIGO(results.getString(3));
				tmpCgg_gem_vacante_perfil.setCGVPR_DESCRIPCION(results.getString(4));
				tmpCgg_gem_vacante_perfil.setCGVPR_ESTADO(results.getBoolean(5));
				outCgg_gem_vacante_perfil.add(tmpCgg_gem_vacante_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante_perfil;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_PERFIL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_D_CGG_GEM_PERFIL(?) }");
			stmDelete.setString(1, this.getCgg_gem_vacante_perfil().getCGPRF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_DS_CGG_GEM_PERFIL(?) }");
				stmDelete.setString(1, this.getCgg_gem_vacante_perfil().getCGPRF_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_vacante_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> selectCGG_GEM_VACANTE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil> outCgg_gem_vacante_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_S_CGG_GEM_VACANTE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_vacante_perfil().getCGVCN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_vacante_perfil tmpCgg_gem_vacante_perfil = new com.besixplus.sii.objects.Cgg_gem_vacante_perfil();
				tmpCgg_gem_vacante_perfil.setCGVPR_CODIGO(results.getString(1));
				tmpCgg_gem_vacante_perfil.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_vacante_perfil.setCGPRF_CODIGO(results.getString(3));
				tmpCgg_gem_vacante_perfil.setCGVPR_DESCRIPCION(results.getString(4));
				tmpCgg_gem_vacante_perfil.setCGVPR_ESTADO(results.getBoolean(5));
				outCgg_gem_vacante_perfil.add(tmpCgg_gem_vacante_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante_perfil;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_vacante_perfil DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_VACANTE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_D_CGG_GEM_VACANTE(?) }");
			stmDelete.setString(1, this.getCgg_gem_vacante_perfil().getCGVCN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_PERFIL_DS_CGG_GEM_VACANTE(?) }");
				stmDelete.setString(1, this.getCgg_gem_vacante_perfil().getCGVCN_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}
	
	/** SSELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_notificacion_imposibilitado 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_notificacion_imposibilitado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>> selectPerfilesOferta(
			java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion_imposibilitado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_PERFIL_S_PRF_VCN(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, myCgg_gem_vacante_perfil.getCGVCN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_notificacion_imposibilitado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion_imposibilitado;
	}

}