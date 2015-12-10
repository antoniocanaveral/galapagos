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
* CLASE Cgg_dhu_aplicacion_encuesta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_aplicacion_encuesta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_aplicacion_encuesta implements Serializable{
	private static final long serialVersionUID = 544385399;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta myCgg_dhu_aplicacion_encuesta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_aplicacion_encuesta.
	*/
	public Cgg_dhu_aplicacion_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_aplicacion_encuesta.
	* @param inCgg_dhu_aplicacion_encuesta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_aplicacion_encuesta.
	*/
	public Cgg_dhu_aplicacion_encuesta(
		com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta inCgg_dhu_aplicacion_encuesta
	){
		this.setCgg_dhu_aplicacion_encuesta(inCgg_dhu_aplicacion_encuesta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_aplicacion_encuesta.
	* @param inCgg_dhu_aplicacion_encuesta OBJETO Cgg_dhu_aplicacion_encuesta.
	* @return void
	*/
	public void setCgg_dhu_aplicacion_encuesta(com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta inCgg_dhu_aplicacion_encuesta){
		this.myCgg_dhu_aplicacion_encuesta = inCgg_dhu_aplicacion_encuesta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_aplicacion_encuesta.
	* @return Cgg_dhu_aplicacion_encuesta OBJETO Cgg_dhu_aplicacion_encuesta.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta getCgg_dhu_aplicacion_encuesta(){
		return this.myCgg_dhu_aplicacion_encuesta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_aplicacion_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_aplicacion_encuesta().getCDCRE_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_dhu_aplicacion_encuesta().getCDAPE_FECHA().getTime()));
			stmInsert.setString(5, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_OBSERVACION());
			stmInsert.setBoolean(6, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_ESTADO());
			stmInsert.setString(7, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_aplicacion_encuesta().setCDAPE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_aplicacion_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta> outCgg_dhu_aplicacion_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta tmpCgg_dhu_aplicacion_encuesta = new com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta();
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_CODIGO(results.getString(1));
				tmpCgg_dhu_aplicacion_encuesta.setCDCRE_CODIGO(results.getString(2));
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_FECHA(results.getTimestamp(3));
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_OBSERVACION(results.getString(4));
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_ESTADO(results.getBoolean(5));
				outCgg_dhu_aplicacion_encuesta.add(tmpCgg_dhu_aplicacion_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_aplicacion_encuesta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_aplicacion_encuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){  ArrayList<HashMap<String,Object>> outCgg_dhu_aplicacion_encuesta= new ArrayList<HashMap<String,Object>>();
		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_aplicacion_encuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_aplicacion_encuesta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_aplicacion_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_aplicacion_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_APLICACION_ENCUESTA_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_aplicacion_encuesta().getCDCRE_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_dhu_aplicacion_encuesta().getCDAPE_FECHA().getTime()));
			stmUpdate.setString(4, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_OBSERVACION());
			stmUpdate.setBoolean(5, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_ESTADO());
			stmUpdate.setString(6, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_aplicacion_encuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_aplicacion_encuesta().getCDAPE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_aplicacion_encuesta().setCDAPE_CODIGO(results.getString(1));
				this.getCgg_dhu_aplicacion_encuesta().setCDCRE_CODIGO(results.getString(2));
				this.getCgg_dhu_aplicacion_encuesta().setCDAPE_FECHA(results.getTimestamp(3));
				this.getCgg_dhu_aplicacion_encuesta().setCDAPE_OBSERVACION(results.getString(4));
				this.getCgg_dhu_aplicacion_encuesta().setCDAPE_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_aplicacion_encuesta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_aplicacion_encuesta DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_APLICACION_ENCUESTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_APLICACION_ENCUESTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_aplicacion_encuesta().getCDAPE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_aplicacion_encuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_cronograma_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta> selectCGG_DHU_CRONOGRAMA_ENCUESTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta> outCgg_dhu_aplicacion_encuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_APLICACION_ENCUESTA_S_CGG_DHU_CRONOGRAMA_ENCUESTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_aplicacion_encuesta().getCDCRE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta tmpCgg_dhu_aplicacion_encuesta = new com.besixplus.sii.objects.Cgg_dhu_aplicacion_encuesta();
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_CODIGO(results.getString(1));
				tmpCgg_dhu_aplicacion_encuesta.setCDCRE_CODIGO(results.getString(2));
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_FECHA(results.getTimestamp(3));
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_OBSERVACION(results.getString(4));
				tmpCgg_dhu_aplicacion_encuesta.setCDAPE_ESTADO(results.getBoolean(5));
				outCgg_dhu_aplicacion_encuesta.add(tmpCgg_dhu_aplicacion_encuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_aplicacion_encuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_aplicacion_encuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_cronograma_encuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_CRONOGRAMA_ENCUESTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_APLICACION_ENCUESTA_D_CGG_DHU_CRONOGRAMA_ENCUESTA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_aplicacion_encuesta().getCDCRE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_APLICACION_ENCUESTA_DS_CGG_DHU_CRONOGRAMA_ENCUESTA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_aplicacion_encuesta().getCDCRE_CODIGO());
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