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
* CLASE Cgg_dhu_registro_encuesta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_registro_encuesta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_registro_encuesta implements Serializable{
	private static final long serialVersionUID = 1906084064;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_registro_encuesta.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_registro_encuesta myCgg_dhu_registro_encuesta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_registro_encuesta.
	*/
	public Cgg_dhu_registro_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_registro_encuesta.
	* @param inCgg_dhu_registro_encuesta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_registro_encuesta.
	*/
	public Cgg_dhu_registro_encuesta(
		com.besixplus.sii.objects.Cgg_dhu_registro_encuesta inCgg_dhu_registro_encuesta
	){
		this.setCgg_dhu_registro_encuesta(inCgg_dhu_registro_encuesta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_registro_encuesta.
	* @param inCgg_dhu_registro_encuesta OBJETO Cgg_dhu_registro_encuesta.
	* @return void
	*/
	public void setCgg_dhu_registro_encuesta(com.besixplus.sii.objects.Cgg_dhu_registro_encuesta inCgg_dhu_registro_encuesta){
		this.myCgg_dhu_registro_encuesta = inCgg_dhu_registro_encuesta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_registro_encuesta.
	* @return Cgg_dhu_registro_encuesta OBJETO Cgg_dhu_registro_encuesta.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_registro_encuesta getCgg_dhu_registro_encuesta(){
		return this.myCgg_dhu_registro_encuesta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_registro_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_registro_encuesta().getCDRGE_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmInsert.setString(6, this.getCgg_dhu_registro_encuesta().getCDRGE_RESPUESTA_ABIERTA());
			stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_dhu_registro_encuesta().getCDRGE_FECHA_REGISTRO().getTime()));
			stmInsert.setString(8, this.getCgg_dhu_registro_encuesta().getCDRGE_OBSERVACION());
			stmInsert.setBoolean(9, this.getCgg_dhu_registro_encuesta().getCDRGE_ESTADO());
			stmInsert.setString(10, this.getCgg_dhu_registro_encuesta().getCDRGE_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_dhu_registro_encuesta().getCDRGE_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_registro_encuesta().setCDRGE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> outCgg_dhu_registro_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_registro_encuesta tmpCgg_dhu_registro_encuesta = new com.besixplus.sii.objects.Cgg_dhu_registro_encuesta();
				tmpCgg_dhu_registro_encuesta.setCDRGE_CODIGO(results.getString(1));
				tmpCgg_dhu_registro_encuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_registro_encuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_registro_encuesta.setCDAPE_CODIGO(results.getString(4));
				tmpCgg_dhu_registro_encuesta.setCDRGE_RESPUESTA_ABIERTA(results.getString(5));
				tmpCgg_dhu_registro_encuesta.setCDRGE_FECHA_REGISTRO(results.getTimestamp(6));
				tmpCgg_dhu_registro_encuesta.setCDRGE_OBSERVACION(results.getString(7));
				tmpCgg_dhu_registro_encuesta.setCDRGE_ESTADO(results.getBoolean(8));
				outCgg_dhu_registro_encuesta.add(tmpCgg_dhu_registro_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_registro_encuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_registro_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_registro_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_COUNT() }");
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
			inKeyword = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_registro_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_registro_encuesta().getCDRGE_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmUpdate.setString(5, this.getCgg_dhu_registro_encuesta().getCDRGE_RESPUESTA_ABIERTA());
			stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_dhu_registro_encuesta().getCDRGE_FECHA_REGISTRO().getTime()));
			stmUpdate.setString(7, this.getCgg_dhu_registro_encuesta().getCDRGE_OBSERVACION());
			stmUpdate.setBoolean(8, this.getCgg_dhu_registro_encuesta().getCDRGE_ESTADO());
			stmUpdate.setString(9, this.getCgg_dhu_registro_encuesta().getCDRGE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_registro_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_registro_encuesta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_registro_encuesta().getCDRGE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_registro_encuesta().setCDRGE_CODIGO(results.getString(1));
				this.getCgg_dhu_registro_encuesta().setCDPRG_CODIGO(results.getString(2));
				this.getCgg_dhu_registro_encuesta().setCDRES_CODIGO(results.getString(3));
				this.getCgg_dhu_registro_encuesta().setCDAPE_CODIGO(results.getString(4));
				this.getCgg_dhu_registro_encuesta().setCDRGE_RESPUESTA_ABIERTA(results.getString(5));
				this.getCgg_dhu_registro_encuesta().setCDRGE_FECHA_REGISTRO(results.getTimestamp(6));
				this.getCgg_dhu_registro_encuesta().setCDRGE_OBSERVACION(results.getString(7));
				this.getCgg_dhu_registro_encuesta().setCDRGE_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_registro_encuesta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDRGE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDRGE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_registro_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> selectCGG_DHU_RESPUESTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> outCgg_dhu_registro_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_S_CGG_DHU_RESPUESTA(?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_registro_encuesta tmpCgg_dhu_registro_encuesta = new com.besixplus.sii.objects.Cgg_dhu_registro_encuesta();
				tmpCgg_dhu_registro_encuesta.setCDRGE_CODIGO(results.getString(1));
				tmpCgg_dhu_registro_encuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_registro_encuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_registro_encuesta.setCDAPE_CODIGO(results.getString(4));
				tmpCgg_dhu_registro_encuesta.setCDRGE_RESPUESTA_ABIERTA(results.getString(5));
				tmpCgg_dhu_registro_encuesta.setCDRGE_FECHA_REGISTRO(results.getTimestamp(6));
				tmpCgg_dhu_registro_encuesta.setCDRGE_OBSERVACION(results.getString(7));
				tmpCgg_dhu_registro_encuesta.setCDRGE_ESTADO(results.getBoolean(8));
				outCgg_dhu_registro_encuesta.add(tmpCgg_dhu_registro_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_RESPUESTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_D_CGG_DHU_RESPUESTA(?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_DS_CGG_DHU_RESPUESTA(?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_aplicacion_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_registro_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> selectCGG_DHU_APLICACION_ENCUESTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> outCgg_dhu_registro_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_S_CGG_DHU_APLICACION_ENCUESTA(?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_registro_encuesta tmpCgg_dhu_registro_encuesta = new com.besixplus.sii.objects.Cgg_dhu_registro_encuesta();
				tmpCgg_dhu_registro_encuesta.setCDRGE_CODIGO(results.getString(1));
				tmpCgg_dhu_registro_encuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_registro_encuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_registro_encuesta.setCDAPE_CODIGO(results.getString(4));
				tmpCgg_dhu_registro_encuesta.setCDRGE_RESPUESTA_ABIERTA(results.getString(5));
				tmpCgg_dhu_registro_encuesta.setCDRGE_FECHA_REGISTRO(results.getTimestamp(6));
				tmpCgg_dhu_registro_encuesta.setCDRGE_OBSERVACION(results.getString(7));
				tmpCgg_dhu_registro_encuesta.setCDRGE_ESTADO(results.getBoolean(8));
				outCgg_dhu_registro_encuesta.add(tmpCgg_dhu_registro_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_aplicacion_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_APLICACION_ENCUESTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_D_CGG_DHU_APLICACION_ENCUESTA(?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_DS_CGG_DHU_APLICACION_ENCUESTA(?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_registro_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> selectCGG_DHU_PREGUNTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta> outCgg_dhu_registro_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_registro_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_REGISTRO_ENCUESTA_S_CGG_DHU_PREGUNTA(?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_registro_encuesta tmpCgg_dhu_registro_encuesta = new com.besixplus.sii.objects.Cgg_dhu_registro_encuesta();
				tmpCgg_dhu_registro_encuesta.setCDRGE_CODIGO(results.getString(1));
				tmpCgg_dhu_registro_encuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_registro_encuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_registro_encuesta.setCDAPE_CODIGO(results.getString(4));
				tmpCgg_dhu_registro_encuesta.setCDRGE_RESPUESTA_ABIERTA(results.getString(5));
				tmpCgg_dhu_registro_encuesta.setCDRGE_FECHA_REGISTRO(results.getTimestamp(6));
				tmpCgg_dhu_registro_encuesta.setCDRGE_OBSERVACION(results.getString(7));
				tmpCgg_dhu_registro_encuesta.setCDRGE_ESTADO(results.getBoolean(8));
				outCgg_dhu_registro_encuesta.add(tmpCgg_dhu_registro_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_registro_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_PREGUNTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_D_CGG_DHU_PREGUNTA(?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_REGISTRO_ENCUESTA_DS_CGG_DHU_PREGUNTA(?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_registro_encuesta().getCDAPE_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_registro_encuesta().getCDPRG_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_registro_encuesta().getCDRES_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cuestionario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCdenc_codigo CODIGO DE LA ENCUESTA PARA FILTRAR LOS DATOS
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cuestionario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllCategoria(
		java.sql.Connection inConnection,
		String inCdenc_codigo		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_registro_encuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICAR_PREGUNTAS_RESPUESTAS_CATEGORIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdenc_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_registro_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cuestionario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	* @param inCdenc_codigo CODIGO DE LA ENCUESTA PARA FILTRAR LOS DATOS
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cuestionario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllRegistroEncuesta(
		java.sql.Connection inConnection,
		String inCdcat_codigo		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_registro_encuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICAR_PREGUNTAS_RESPUESTAS_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdcat_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_registro_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cuestionario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	* @param inCdenc_codigo CODIGO DE LA ENCUESTA PARA FILTRAR LOS DATOS
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cuestionario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllRespuestas_Preguntas(
		java.sql.Connection inConnection,
		String inCdcat_codigo		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_registro_encuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_DHU_RESPUESTAS_PREGUNTAS_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdcat_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_registro_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cuestionario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	* @param inCdenc_codigo CODIGO DE LA ENCUESTA PARA FILTRAR LOS DATOS
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cuestionario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllRegistroEncuestaByEnc(
		java.sql.Connection inConnection,
		String inCdcat_codigo,
		String inCdenc_codigo	
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_registro_encuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICAR_PREGUNTAS_RESPUESTAS_SELECT(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdcat_codigo);
			stmSelect.setString(3, inCdenc_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_registro_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_registro_encuesta;
	}
}