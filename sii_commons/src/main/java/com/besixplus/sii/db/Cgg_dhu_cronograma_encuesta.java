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
* CLASE Cgg_dhu_cronograma_encuesta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_cronograma_encuesta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_cronograma_encuesta implements Serializable{
	private static final long serialVersionUID = 438541091;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta myCgg_dhu_cronograma_encuesta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_cronograma_encuesta.
	*/
	public Cgg_dhu_cronograma_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_cronograma_encuesta.
	* @param inCgg_dhu_cronograma_encuesta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_cronograma_encuesta.
	*/
	public Cgg_dhu_cronograma_encuesta(
		com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta inCgg_dhu_cronograma_encuesta
	){
		this.setCgg_dhu_cronograma_encuesta(inCgg_dhu_cronograma_encuesta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_cronograma_encuesta.
	* @param inCgg_dhu_cronograma_encuesta OBJETO Cgg_dhu_cronograma_encuesta.
	* @return void
	*/
	public void setCgg_dhu_cronograma_encuesta(com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta inCgg_dhu_cronograma_encuesta){
		this.myCgg_dhu_cronograma_encuesta = inCgg_dhu_cronograma_encuesta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_cronograma_encuesta.
	* @return Cgg_dhu_cronograma_encuesta OBJETO Cgg_dhu_cronograma_encuesta.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta getCgg_dhu_cronograma_encuesta(){
		return this.myCgg_dhu_cronograma_encuesta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_cronograma_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_cronograma_encuesta().getCDCRE_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_cronograma_encuesta().getCDENC_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_cronograma_encuesta().getCDCUR_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_cronograma_encuesta().getCISLA_CODIGO());
			stmInsert.setString(6, this.getCgg_dhu_cronograma_encuesta().getCDCRE_DESCRIPCION());
			stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_dhu_cronograma_encuesta().getCDCRE_FECHA_EJECUCION().getTime()));
			stmInsert.setTimestamp(8, new java.sql.Timestamp(this.getCgg_dhu_cronograma_encuesta().getCDCRE_FECHA_MAXIMA_REALIZACION().getTime()));
			stmInsert.setBoolean(9, this.getCgg_dhu_cronograma_encuesta().getCDCRE_ESTADO());
			stmInsert.setString(10, this.getCgg_dhu_cronograma_encuesta().getCDCRE_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_dhu_cronograma_encuesta().setCDCRE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> outCgg_dhu_cronograma_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta tmpCgg_dhu_cronograma_encuesta = new com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta();
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_CODIGO(results.getString(1));
				tmpCgg_dhu_cronograma_encuesta.setCDENC_CODIGO(results.getString(2));
				tmpCgg_dhu_cronograma_encuesta.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_cronograma_encuesta.setCISLA_CODIGO(results.getString(4));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_DESCRIPCION(results.getString(5));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_EJECUCION(results.getTimestamp(6));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_MAXIMA_REALIZACION(results.getTimestamp(7));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_ESTADO(results.getBoolean(8));
				outCgg_dhu_cronograma_encuesta.add(tmpCgg_dhu_cronograma_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_cronograma_encuesta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> outCgg_dhu_cronograma_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta tmpCgg_dhu_cronograma_encuesta = new com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta();
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_CODIGO(results.getString(1));
				tmpCgg_dhu_cronograma_encuesta.setCDENC_CODIGO(results.getString(2));
				tmpCgg_dhu_cronograma_encuesta.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_cronograma_encuesta.setCISLA_CODIGO(results.getString(4));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_DESCRIPCION(results.getString(5));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_EJECUCION(results.getTimestamp(6));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_MAXIMA_REALIZACION(results.getTimestamp(7));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_ESTADO(results.getBoolean(8));
				outCgg_dhu_cronograma_encuesta.add(tmpCgg_dhu_cronograma_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_cronograma_encuesta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_dhu_cronograma_encuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_cronograma_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_cronograma_encuesta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_cronograma_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_COUNT() }");
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
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_cronograma_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDCRE_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_cronograma_encuesta().getCDENC_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_cronograma_encuesta().getCDCUR_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_cronograma_encuesta().getCISLA_CODIGO());
			stmUpdate.setString(5, this.getCgg_dhu_cronograma_encuesta().getCDCRE_DESCRIPCION());
			stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_dhu_cronograma_encuesta().getCDCRE_FECHA_EJECUCION().getTime()));
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_dhu_cronograma_encuesta().getCDCRE_FECHA_MAXIMA_REALIZACION().getTime()));
			stmUpdate.setBoolean(8, this.getCgg_dhu_cronograma_encuesta().getCDCRE_ESTADO());
			stmUpdate.setString(9, this.getCgg_dhu_cronograma_encuesta().getCDCRE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_cronograma_encuesta().getCDCRE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_cronograma_encuesta().setCDCRE_CODIGO(results.getString(1));
				this.getCgg_dhu_cronograma_encuesta().setCDENC_CODIGO(results.getString(2));
				this.getCgg_dhu_cronograma_encuesta().setCDCUR_CODIGO(results.getString(3));
				this.getCgg_dhu_cronograma_encuesta().setCISLA_CODIGO(results.getString(4));
				this.getCgg_dhu_cronograma_encuesta().setCDCRE_DESCRIPCION(results.getString(5));
				this.getCgg_dhu_cronograma_encuesta().setCDCRE_FECHA_EJECUCION(results.getTimestamp(6));
				this.getCgg_dhu_cronograma_encuesta().setCDCRE_FECHA_MAXIMA_REALIZACION(results.getTimestamp(7));
				this.getCgg_dhu_cronograma_encuesta().setCDCRE_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_cronograma_encuesta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDCRE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDCRE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> selectCGG_ISLA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> outCgg_dhu_cronograma_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_S_CGG_ISLA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_cronograma_encuesta().getCISLA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta tmpCgg_dhu_cronograma_encuesta = new com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta();
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_CODIGO(results.getString(1));
				tmpCgg_dhu_cronograma_encuesta.setCDENC_CODIGO(results.getString(2));
				tmpCgg_dhu_cronograma_encuesta.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_cronograma_encuesta.setCISLA_CODIGO(results.getString(4));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_DESCRIPCION(results.getString(5));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_EJECUCION(results.getTimestamp(6));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_MAXIMA_REALIZACION(results.getTimestamp(7));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_ESTADO(results.getBoolean(8));
				outCgg_dhu_cronograma_encuesta.add(tmpCgg_dhu_cronograma_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_cronograma_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_ISLA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_D_CGG_ISLA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCISLA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_DS_CGG_ISLA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCISLA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> selectCGG_DHU_ENCUESTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> outCgg_dhu_cronograma_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_S_CGG_DHU_ENCUESTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_cronograma_encuesta().getCDENC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta tmpCgg_dhu_cronograma_encuesta = new com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta();
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_CODIGO(results.getString(1));
				tmpCgg_dhu_cronograma_encuesta.setCDENC_CODIGO(results.getString(2));
				tmpCgg_dhu_cronograma_encuesta.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_cronograma_encuesta.setCISLA_CODIGO(results.getString(4));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_DESCRIPCION(results.getString(5));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_EJECUCION(results.getTimestamp(6));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_MAXIMA_REALIZACION(results.getTimestamp(7));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_ESTADO(results.getBoolean(8));
				outCgg_dhu_cronograma_encuesta.add(tmpCgg_dhu_cronograma_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_cronograma_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_ENCUESTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_D_CGG_DHU_ENCUESTA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDENC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_DS_CGG_DHU_ENCUESTA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDENC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> selectCGG_DHU_CURSO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta> outCgg_dhu_cronograma_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_S_CGG_DHU_CURSO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_cronograma_encuesta().getCDCUR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta tmpCgg_dhu_cronograma_encuesta = new com.besixplus.sii.objects.Cgg_dhu_cronograma_encuesta();
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_CODIGO(results.getString(1));
				tmpCgg_dhu_cronograma_encuesta.setCDENC_CODIGO(results.getString(2));
				tmpCgg_dhu_cronograma_encuesta.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_cronograma_encuesta.setCISLA_CODIGO(results.getString(4));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_DESCRIPCION(results.getString(5));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_EJECUCION(results.getTimestamp(6));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_FECHA_MAXIMA_REALIZACION(results.getTimestamp(7));
				tmpCgg_dhu_cronograma_encuesta.setCDCRE_ESTADO(results.getBoolean(8));
				outCgg_dhu_cronograma_encuesta.add(tmpCgg_dhu_cronograma_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_cronograma_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_cronograma_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_CURSO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_D_CGG_DHU_CURSO(?) }");
			stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDCUR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CRONOGRAMA_ENCUESTA_DS_CGG_DHU_CURSO(?) }");
				stmDelete.setString(1, this.getCgg_dhu_cronograma_encuesta().getCDCUR_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

}