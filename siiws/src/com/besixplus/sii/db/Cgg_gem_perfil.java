package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/*import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;*/

/**
* CLASE Cgg_gem_perfil
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_perfil.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_perfil implements Serializable{
	private static final long serialVersionUID = 1326443484;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_perfil.
	*/
	private com.besixplus.sii.objects.Cgg_gem_perfil myCgg_gem_perfil = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil.
	*/
	public Cgg_gem_perfil(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil.
	* @param inCgg_gem_perfil OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_perfil.
	*/
	public Cgg_gem_perfil(
		com.besixplus.sii.objects.Cgg_gem_perfil inCgg_gem_perfil
	){
		this.setCgg_gem_perfil(inCgg_gem_perfil);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_perfil.
	* @param inCgg_gem_perfil OBJETO Cgg_gem_perfil.
	* @return void
	*/
	public void setCgg_gem_perfil(com.besixplus.sii.objects.Cgg_gem_perfil inCgg_gem_perfil){
		this.myCgg_gem_perfil = inCgg_gem_perfil;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_perfil.
	* @return Cgg_gem_perfil OBJETO Cgg_gem_perfil.
	*/
	public com.besixplus.sii.objects.Cgg_gem_perfil getCgg_gem_perfil(){
		return this.myCgg_gem_perfil;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_perfil().getCGPRF_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_perfil().getCGESP_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_perfil().getCGTPR_CODIGO());
			stmInsert.setString(5, this.getCgg_gem_perfil().getCGNES_CODIGO());
			stmInsert.setString(6, this.getCgg_gem_perfil().getCGDST_CODIGO());
			stmInsert.setBoolean(7, this.getCgg_gem_perfil().getCGPRF_ESTADO());
			stmInsert.setString(8, this.getCgg_gem_perfil().getCGPRF_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_gem_perfil().getCGPRF_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_perfil().setCGPRF_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> outCgg_gem_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil tmpCgg_gem_perfil = new com.besixplus.sii.objects.Cgg_gem_perfil();
				tmpCgg_gem_perfil.setCGPRF_CODIGO(results.getString(1));
				tmpCgg_gem_perfil.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil.setCGNES_CODIGO(results.getString(4));
				tmpCgg_gem_perfil.setCGDST_CODIGO(results.getString(5));
				tmpCgg_gem_perfil.setCGPRF_ESTADO(results.getBoolean(6));
				outCgg_gem_perfil.add(tmpCgg_gem_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> outCgg_gem_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_perfil tmpCgg_gem_perfil = new com.besixplus.sii.objects.Cgg_gem_perfil();
				tmpCgg_gem_perfil.setCGPRF_CODIGO(results.getString(1));
				tmpCgg_gem_perfil.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil.setCGNES_CODIGO(results.getString(4));
				tmpCgg_gem_perfil.setCGDST_CODIGO(results.getString(5));
				tmpCgg_gem_perfil.setCGPRF_ESTADO(results.getBoolean(6));
				outCgg_gem_perfil.add(tmpCgg_gem_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_perfil = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_perfil.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_perfil.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_perfil().getCGPRF_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_perfil().getCGESP_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_perfil().getCGTPR_CODIGO());
			stmUpdate.setString(4, this.getCgg_gem_perfil().getCGNES_CODIGO());
			stmUpdate.setString(5, this.getCgg_gem_perfil().getCGDST_CODIGO());
			stmUpdate.setBoolean(6, this.getCgg_gem_perfil().getCGPRF_ESTADO());
			stmUpdate.setString(7, this.getCgg_gem_perfil().getCGPRF_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_perfil DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_perfil select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil().getCGPRF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_perfil().setCGPRF_CODIGO(results.getString(1));
				this.getCgg_gem_perfil().setCGESP_CODIGO(results.getString(2));
				this.getCgg_gem_perfil().setCGTPR_CODIGO(results.getString(3));
				this.getCgg_gem_perfil().setCGNES_CODIGO(results.getString(4));
				this.getCgg_gem_perfil().setCGDST_CODIGO(results.getString(5));
				this.getCgg_gem_perfil().setCGPRF_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_perfil();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_perfil DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil().getCGPRF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil().getCGPRF_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_especialidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> selectCGG_ESPECIALIDAD(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> outCgg_gem_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_S_CGG_ESPECIALIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil().getCGESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil tmpCgg_gem_perfil = new com.besixplus.sii.objects.Cgg_gem_perfil();
				tmpCgg_gem_perfil.setCGPRF_CODIGO(results.getString(1));
				tmpCgg_gem_perfil.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil.setCGNES_CODIGO(results.getString(4));
				tmpCgg_gem_perfil.setCGDST_CODIGO(results.getString(5));
				tmpCgg_gem_perfil.setCGPRF_ESTADO(results.getBoolean(6));
				outCgg_gem_perfil.add(tmpCgg_gem_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_especialidad.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_D_CGG_ESPECIALIDAD(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil().getCGESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_DS_CGG_ESPECIALIDAD(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil().getCGESP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> selectCGG_TITULO_PROFESIONAL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> outCgg_gem_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_S_CGG_TITULO_PROFESIONAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil().getCGTPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil tmpCgg_gem_perfil = new com.besixplus.sii.objects.Cgg_gem_perfil();
				tmpCgg_gem_perfil.setCGPRF_CODIGO(results.getString(1));
				tmpCgg_gem_perfil.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil.setCGNES_CODIGO(results.getString(4));
				tmpCgg_gem_perfil.setCGDST_CODIGO(results.getString(5));
				tmpCgg_gem_perfil.setCGPRF_ESTADO(results.getBoolean(6));
				outCgg_gem_perfil.add(tmpCgg_gem_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_titulo_profesional.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_D_CGG_TITULO_PROFESIONAL(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil().getCGTPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_DS_CGG_TITULO_PROFESIONAL(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil().getCGTPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_perfil DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_perfil OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> selectCGG_NIVEL_ESTUDIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> outCgg_gem_perfil = new ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_S_CGG_NIVEL_ESTUDIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_perfil().getCGNES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_perfil tmpCgg_gem_perfil = new com.besixplus.sii.objects.Cgg_gem_perfil();
				tmpCgg_gem_perfil.setCGPRF_CODIGO(results.getString(1));
				tmpCgg_gem_perfil.setCGESP_CODIGO(results.getString(2));
				tmpCgg_gem_perfil.setCGTPR_CODIGO(results.getString(3));
				tmpCgg_gem_perfil.setCGNES_CODIGO(results.getString(4));
				tmpCgg_gem_perfil.setCGDST_CODIGO(results.getString(5));
				tmpCgg_gem_perfil.setCGPRF_ESTADO(results.getBoolean(6));
				outCgg_gem_perfil.add(tmpCgg_gem_perfil);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_perfil DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_nivel_estudio.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_D_CGG_NIVEL_ESTUDIO(?) }");
			stmDelete.setString(1, this.getCgg_gem_perfil().getCGNES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERFIL_DS_CGG_NIVEL_ESTUDIO(?) }");
				stmDelete.setString(1, this.getCgg_gem_perfil().getCGNES_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_perfil QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
    * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_perfil> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String, Object>> selectAllPrz(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String, Object>> outCgg_gem_perfil = new ArrayList<HashMap<String, Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERFIL_SELECT_PRZ(?,?,?,?,?,?) }");
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
				outCgg_gem_perfil.add(tmpObj);
			}			
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_perfil;
	}


}