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
* CLASE Cgg_jur_criterio
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_criterio.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_jur_criterio implements Serializable{
	private static final long serialVersionUID = 99895673;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_criterio.
	*/
	private com.besixplus.sii.objects.Cgg_jur_criterio myCgg_jur_criterio = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_criterio.
	*/
	public Cgg_jur_criterio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_criterio.
	* @param inCgg_jur_criterio OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_criterio.
	*/
	public Cgg_jur_criterio(
		com.besixplus.sii.objects.Cgg_jur_criterio inCgg_jur_criterio
	){
		this.setCgg_jur_criterio(inCgg_jur_criterio);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_criterio.
	* @param inCgg_jur_criterio OBJETO Cgg_jur_criterio.
	* @return void
	*/
	public void setCgg_jur_criterio(com.besixplus.sii.objects.Cgg_jur_criterio inCgg_jur_criterio){
		this.myCgg_jur_criterio = inCgg_jur_criterio;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_criterio.
	* @return Cgg_jur_criterio OBJETO Cgg_jur_criterio.
	*/
	public com.besixplus.sii.objects.Cgg_jur_criterio getCgg_jur_criterio(){
		return this.myCgg_jur_criterio;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_jur_criterio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_criterio().getCJCRI_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_criterio().getCRFAS_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_criterio().getCJCRI_REQUERIMIENTO());
			stmInsert.setBoolean(5, this.getCgg_jur_criterio().getCJCRI_REQUERIDO());
			stmInsert.setBoolean(6, this.getCgg_jur_criterio().getCJCRI_ESTADO());
			stmInsert.setString(7, this.getCgg_jur_criterio().getCJCRI_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_jur_criterio().getCJCRI_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_jur_criterio().setCJCRI_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_criterio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> outCgg_jur_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_criterio tmpCgg_jur_criterio = new com.besixplus.sii.objects.Cgg_jur_criterio();
				tmpCgg_jur_criterio.setCJCRI_CODIGO(results.getString(1));
				tmpCgg_jur_criterio.setCRFAS_CODIGO(results.getString(2));
				tmpCgg_jur_criterio.setCJCRI_REQUERIMIENTO(results.getString(3));
				tmpCgg_jur_criterio.setCJCRI_REQUERIDO(results.getBoolean(4));
				tmpCgg_jur_criterio.setCJCRI_ESTADO(results.getBoolean(5));
				outCgg_jur_criterio.add(tmpCgg_jur_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_criterio;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_criterio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
    * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> outCgg_jur_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_jur_criterio tmpCgg_jur_criterio = new com.besixplus.sii.objects.Cgg_jur_criterio();
				tmpCgg_jur_criterio.setCJCRI_CODIGO(results.getString(1));
				tmpCgg_jur_criterio.setCRFAS_CODIGO(results.getString(2));
				tmpCgg_jur_criterio.setCJCRI_REQUERIMIENTO(results.getString(3));
				tmpCgg_jur_criterio.setCJCRI_REQUERIDO(results.getBoolean(4));
				tmpCgg_jur_criterio.setCJCRI_ESTADO(results.getBoolean(5));
				outCgg_jur_criterio.add(tmpCgg_jur_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_criterio;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_criterio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_criterio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_criterio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_criterio;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_criterio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return OTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_criterio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_CRITERIO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_criterio().getCJCRI_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_criterio().getCRFAS_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_criterio().getCJCRI_REQUERIMIENTO());
			stmUpdate.setBoolean(4, this.getCgg_jur_criterio().getCJCRI_REQUERIDO());
			stmUpdate.setBoolean(5, this.getCgg_jur_criterio().getCJCRI_ESTADO());
			stmUpdate.setString(6, this.getCgg_jur_criterio().getCJCRI_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_criterio DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_criterio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_jur_criterio select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_criterio().getCJCRI_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_criterio().setCJCRI_CODIGO(results.getString(1));
				this.getCgg_jur_criterio().setCRFAS_CODIGO(results.getString(2));
				this.getCgg_jur_criterio().setCJCRI_REQUERIMIENTO(results.getString(3));
				this.getCgg_jur_criterio().setCJCRI_REQUERIDO(results.getBoolean(4));
				this.getCgg_jur_criterio().setCJCRI_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_criterio();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_criterio DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_CRITERIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_criterio().getCJCRI_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_CRITERIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_criterio().getCJCRI_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_criterio DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_criterio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> selectCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio> outCgg_jur_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_CRITERIO_S_CGG_RES_FASE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_criterio().getCRFAS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_criterio tmpCgg_jur_criterio = new com.besixplus.sii.objects.Cgg_jur_criterio();
				tmpCgg_jur_criterio.setCJCRI_CODIGO(results.getString(1));
				tmpCgg_jur_criterio.setCRFAS_CODIGO(results.getString(2));
				tmpCgg_jur_criterio.setCJCRI_REQUERIMIENTO(results.getString(3));
				tmpCgg_jur_criterio.setCJCRI_REQUERIDO(results.getBoolean(4));
				tmpCgg_jur_criterio.setCJCRI_ESTADO(results.getBoolean(5));
				outCgg_jur_criterio.add(tmpCgg_jur_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_criterio;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_criterio DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_fase.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_FASE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_CRITERIO_D_CGG_RES_FASE(?) }");
			stmDelete.setString(1, this.getCgg_jur_criterio().getCRFAS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_CRITERIO_DS_CGG_RES_FASE(?) }");
				stmDelete.setString(1, this.getCgg_jur_criterio().getCRFAS_CODIGO());
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
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_criterio DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteTrusted(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
		
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_CRITERIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_criterio().getCJCRI_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		
		return outResult;
	}

}