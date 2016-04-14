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
* CLASE Cgg_jur_adjunto_acuerdo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_adjunto_acuerdo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_jur_adjunto_acuerdo implements Serializable{
	private static final long serialVersionUID = 1109600821;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo.
	*/
	private com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo myCgg_jur_adjunto_acuerdo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_acuerdo.
	*/
	public Cgg_jur_adjunto_acuerdo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_acuerdo.
	* @param inCgg_jur_adjunto_acuerdo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_adjunto_acuerdo.
	*/
	public Cgg_jur_adjunto_acuerdo(
		com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo inCgg_jur_adjunto_acuerdo
	){
		this.setCgg_jur_adjunto_acuerdo(inCgg_jur_adjunto_acuerdo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_adjunto_acuerdo.
	* @param inCgg_jur_adjunto_acuerdo OBJETO Cgg_jur_adjunto_acuerdo.
	* @return void
	*/
	public void setCgg_jur_adjunto_acuerdo(com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo inCgg_jur_adjunto_acuerdo){
		this.myCgg_jur_adjunto_acuerdo = inCgg_jur_adjunto_acuerdo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_adjunto_acuerdo.
	* @return Cgg_jur_adjunto_acuerdo OBJETO Cgg_jur_adjunto_acuerdo.
	*/
	public com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo getCgg_jur_adjunto_acuerdo(){
		return this.myCgg_jur_adjunto_acuerdo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_jur_adjunto_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
			java.sql.Connection inConnection
		){
			String outResult = "true";
			try{
				CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
				stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
				stmInsert.setString(2, this.getCgg_jur_adjunto_acuerdo().getCJADA_CODIGO());
				stmInsert.setString(3, this.getCgg_jur_adjunto_acuerdo().getCJACU_CODIGO());
				stmInsert.setString(4, this.getCgg_jur_adjunto_acuerdo().getCJADA_DESCRIPCION());
				stmInsert.setString(5, this.getCgg_jur_adjunto_acuerdo().getCJADA_NOMBRE_ADJUNTO());
				stmInsert.setBytes(6, this.getCgg_jur_adjunto_acuerdo().getCJADA_ADJUNTO());
				stmInsert.setBoolean(7, this.getCgg_jur_adjunto_acuerdo().getCJADA_ESTADO());
				stmInsert.setString(8, this.getCgg_jur_adjunto_acuerdo().getCJADA_USUARIO_INSERT());
				stmInsert.setString(9, this.getCgg_jur_adjunto_acuerdo().getCJHAC_CODIGO());
				stmInsert.execute();
				this.getCgg_jur_adjunto_acuerdo().setCJADA_CODIGO(stmInsert.getString(1));
				stmInsert.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
			return outResult;
		}


	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> selectAll(
			java.sql.Connection inConnection,
			String inUserName
		){
			ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> outCgg_jur_adjunto_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_SELECT_AS(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inUserName);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				while (results.next()) {
					com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo tmpCgg_jur_adjunto_acuerdo = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
					tmpCgg_jur_adjunto_acuerdo.setCJADA_CODIGO(results.getString(1));
					tmpCgg_jur_adjunto_acuerdo.setCJACU_CODIGO(results.getString(2));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_DESCRIPCION(results.getString(3));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_NOMBRE_ADJUNTO(results.getString(4));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_ADJUNTO(results.getBytes(5));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_ESTADO(results.getBoolean(6));
					tmpCgg_jur_adjunto_acuerdo.setCJHAC_CODIGO(results.getString(7));
					outCgg_jur_adjunto_acuerdo.add(tmpCgg_jur_adjunto_acuerdo);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_jur_adjunto_acuerdo;
		}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
		){
			ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> outCgg_jur_adjunto_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_SELECT(?,?,?,?,?,?) }");
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
					com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo tmpCgg_jur_adjunto_acuerdo = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
					tmpCgg_jur_adjunto_acuerdo.setCJADA_CODIGO(results.getString(1));
					tmpCgg_jur_adjunto_acuerdo.setCJACU_CODIGO(results.getString(2));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_DESCRIPCION(results.getString(3));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_NOMBRE_ADJUNTO(results.getString(4));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_ADJUNTO(results.getBytes(5));
					tmpCgg_jur_adjunto_acuerdo.setCJADA_ESTADO(results.getBoolean(6));
					tmpCgg_jur_adjunto_acuerdo.setCJHAC_CODIGO(results.getString(7));
					outCgg_jur_adjunto_acuerdo.add(tmpCgg_jur_adjunto_acuerdo);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_jur_adjunto_acuerdo;
		}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_adjunto_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_adjunto_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_adjunto_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_adjunto_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
			java.sql.Connection inConnection
		){
			String outResult = "true";
			try{
				CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
				stmUpdate.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJADA_CODIGO());
				stmUpdate.setString(2, this.getCgg_jur_adjunto_acuerdo().getCJACU_CODIGO());
				stmUpdate.setString(3, this.getCgg_jur_adjunto_acuerdo().getCJADA_DESCRIPCION());
				stmUpdate.setString(4, this.getCgg_jur_adjunto_acuerdo().getCJADA_NOMBRE_ADJUNTO());
				stmUpdate.setBytes(5, this.getCgg_jur_adjunto_acuerdo().getCJADA_ADJUNTO());
				stmUpdate.setBoolean(6, this.getCgg_jur_adjunto_acuerdo().getCJADA_ESTADO());
				stmUpdate.setString(7, this.getCgg_jur_adjunto_acuerdo().getCJADA_USUARIO_UPDATE());
				stmUpdate.setString(8, this.getCgg_jur_adjunto_acuerdo().getCJHAC_CODIGO());
				stmUpdate.executeUpdate();
				stmUpdate.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
			return outResult;
		}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_adjunto_acuerdo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_adjunto_acuerdo().getCJADA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_adjunto_acuerdo().setCJADA_CODIGO(results.getString(1));
				this.getCgg_jur_adjunto_acuerdo().setCJACU_CODIGO(results.getString(2));
				this.getCgg_jur_adjunto_acuerdo().setCJADA_DESCRIPCION(results.getString(3));
				this.getCgg_jur_adjunto_acuerdo().setCJADA_NOMBRE_ADJUNTO(results.getString(4));
				this.getCgg_jur_adjunto_acuerdo().setCJADA_ADJUNTO(results.getBytes(5));
				this.getCgg_jur_adjunto_acuerdo().setCJADA_ESTADO(results.getBoolean(6));
				this.getCgg_jur_adjunto_acuerdo().setCJHAC_CODIGO(results.getString(11));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_adjunto_acuerdo();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_adjunto_acuerdo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJADA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJADA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_historial_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> selectCGG_JUR_HISTORIAL_ACUERDO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> outCgg_jur_adjunto_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_S_CGG_JUR_HISTORIAL_ACUERDO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_adjunto_acuerdo().getCJHAC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo tmpCgg_jur_adjunto_acuerdo = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
				tmpCgg_jur_adjunto_acuerdo.setCJADA_CODIGO(results.getString(1));
				tmpCgg_jur_adjunto_acuerdo.setCJACU_CODIGO(results.getString(2));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_DESCRIPCION(results.getString(3));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_NOMBRE_ADJUNTO(results.getString(4));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_ADJUNTO(results.getBytes(5));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_ESTADO(results.getBoolean(6));
				tmpCgg_jur_adjunto_acuerdo.setCJHAC_CODIGO(results.getString(7));
				outCgg_jur_adjunto_acuerdo.add(tmpCgg_jur_adjunto_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_historial_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_JUR_HISTORIAL_ACUERDO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_D_CGG_JUR_HISTORIAL_ACUERDO(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJHAC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_DS_CGG_JUR_HISTORIAL_ACUERDO(?) }");
				stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJHAC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> selectCGG_JUR_ACUERDO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> outCgg_jur_adjunto_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_S_CGG_JUR_ACUERDO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_adjunto_acuerdo().getCJACU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo tmpCgg_jur_adjunto_acuerdo = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
				tmpCgg_jur_adjunto_acuerdo.setCJADA_CODIGO(results.getString(1));
				tmpCgg_jur_adjunto_acuerdo.setCJACU_CODIGO(results.getString(2));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_DESCRIPCION(results.getString(3));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_NOMBRE_ADJUNTO(results.getString(4));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_ADJUNTO(results.getBytes(5));
				tmpCgg_jur_adjunto_acuerdo.setCJADA_ESTADO(results.getBoolean(6));
				tmpCgg_jur_adjunto_acuerdo.setCJHAC_CODIGO(results.getString(7));
				outCgg_jur_adjunto_acuerdo.add(tmpCgg_jur_adjunto_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_JUR_ACUERDO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_D_CGG_JUR_ACUERDO(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJACU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_DS_CGG_JUR_ACUERDO(?) }");
				stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJACU_CODIGO());
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
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE SEGUN EL USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrateData CODIGO DE ADJUNTO TEMPORAL.	 
	 * @return PERSONA DE RESPONSABLE DEL PROCESO 
	 * @throws SQLException 
	 */
	public static String ingresoAdjunto(
			java.sql.Connection inConnection,
			String inCrateData
	) throws SQLException{
		String valorAdjunto=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_TEMPORAL_ADJUNTO_ACUERDO(?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);	
		stmSelect.setString(2, inCrateData);	
		stmSelect.execute();
		valorAdjunto = stmSelect.getString(1);
		stmSelect.close();

		return valorAdjunto;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCjacu_Codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllAcuerdoAdjunto(
		java.sql.Connection inConnection,
		String inCjacu_Codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_adjunto_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_S_CGG_JUR_ACUERDO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCjacu_Codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_adjunto_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}
	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public String deleteAdjuntoAcuerdo(
			java.sql.Connection inConnection
	){
		String outResult = "true";		
		try{				
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ADJUNTO_ACUERDO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_adjunto_acuerdo().getCJADA_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}

		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_adjunto_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCjhac_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllHistorialAcuerdoAdjunto(
		java.sql.Connection inConnection,
		String inCjhac_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_adjunto_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_ACUERDO_S_CGG_JUR_HISTORIAL_ACUERDO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCjhac_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_adjunto_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_adjunto_acuerdo;
	}
	
}