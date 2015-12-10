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
* CLASE Cgg_res_certificado
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_certificado.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_certificado implements Serializable{
	private static final long serialVersionUID = 1638769822;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_certificado.
	*/
	private com.besixplus.sii.objects.Cgg_res_certificado myCgg_res_certificado = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_certificado.
	*/
	public Cgg_res_certificado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_certificado.
	* @param inCgg_res_certificado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_certificado.
	*/
	public Cgg_res_certificado(
		com.besixplus.sii.objects.Cgg_res_certificado inCgg_res_certificado
	){
		this.setCgg_res_certificado(inCgg_res_certificado);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_certificado.
	* @param inCgg_res_certificado OBJETO Cgg_res_certificado.
	* @return void
	*/
	public void setCgg_res_certificado(com.besixplus.sii.objects.Cgg_res_certificado inCgg_res_certificado){
		this.myCgg_res_certificado = inCgg_res_certificado;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_certificado.
	* @return Cgg_res_certificado OBJETO Cgg_res_certificado.
	*/
	public com.besixplus.sii.objects.Cgg_res_certificado getCgg_res_certificado(){
		return this.myCgg_res_certificado;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_certificado().getCRCRT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_certificado().getCRRSD_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_certificado().getCRCRT_FECHA_EMISION().getTime()));
			stmInsert.setString(5, this.getCgg_res_certificado().getCRCRT_NUMERO());
			stmInsert.setString(6, this.getCgg_res_certificado().getCRCRT_CONTENIDO());
			stmInsert.setInt(7, this.getCgg_res_certificado().getCRCRT_ANIO());
			stmInsert.setBoolean(8, this.getCgg_res_certificado().getCRCRT_ESTADO());
			stmInsert.setString(9, this.getCgg_res_certificado().getCRCRT_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_certificado().getCRCRT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_certificado().setCRCRT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> outCgg_res_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_res_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_certificado tmpCgg_res_certificado = new com.besixplus.sii.objects.Cgg_res_certificado();
				tmpCgg_res_certificado.setCRCRT_CODIGO(results.getString(1));
				tmpCgg_res_certificado.setCRRSD_CODIGO(results.getString(2));
				tmpCgg_res_certificado.setCRCRT_FECHA_EMISION(results.getTimestamp(3));
				tmpCgg_res_certificado.setCRCRT_NUMERO(results.getString(4));
				tmpCgg_res_certificado.setCRCRT_CONTENIDO(results.getString(5));
				tmpCgg_res_certificado.setCRCRT_ANIO(results.getInt(6));
				tmpCgg_res_certificado.setCRCRT_ESTADO(results.getBoolean(7));
				outCgg_res_certificado.add(tmpCgg_res_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_certificado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> outCgg_res_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_res_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_certificado tmpCgg_res_certificado = new com.besixplus.sii.objects.Cgg_res_certificado();
				tmpCgg_res_certificado.setCRCRT_CODIGO(results.getString(1));
				tmpCgg_res_certificado.setCRRSD_CODIGO(results.getString(2));
				tmpCgg_res_certificado.setCRCRT_FECHA_EMISION(results.getTimestamp(3));
				tmpCgg_res_certificado.setCRCRT_NUMERO(results.getString(4));
				tmpCgg_res_certificado.setCRCRT_CONTENIDO(results.getString(5));
				tmpCgg_res_certificado.setCRCRT_ANIO(results.getInt(6));
				tmpCgg_res_certificado.setCRCRT_ESTADO(results.getBoolean(7));
				outCgg_res_certificado.add(tmpCgg_res_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_certificado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_certificado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_certificado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_certificado;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_CERTIFICADO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_certificado().getCRCRT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_certificado().getCRRSD_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_res_certificado().getCRCRT_FECHA_EMISION().getTime()));
			stmUpdate.setString(4, this.getCgg_res_certificado().getCRCRT_NUMERO());
			stmUpdate.setString(5, this.getCgg_res_certificado().getCRCRT_CONTENIDO());
			stmUpdate.setInt(6, this.getCgg_res_certificado().getCRCRT_ANIO());
			stmUpdate.setBoolean(7, this.getCgg_res_certificado().getCRCRT_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_certificado().getCRCRT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_certificado DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_certificado select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_certificado().getCRCRT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_certificado().setCRCRT_CODIGO(results.getString(1));
				this.getCgg_res_certificado().setCRRSD_CODIGO(results.getString(2));
				this.getCgg_res_certificado().setCRCRT_FECHA_EMISION(results.getTimestamp(3));
				this.getCgg_res_certificado().setCRCRT_NUMERO(results.getString(4));
				this.getCgg_res_certificado().setCRCRT_CONTENIDO(results.getString(5));
				this.getCgg_res_certificado().setCRCRT_ANIO(results.getInt(6));
				this.getCgg_res_certificado().setCRCRT_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_certificado();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_certificado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CERTIFICADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_certificado().getCRCRT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CERTIFICADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_certificado().getCRCRT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_certificado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> selectCGG_RES_RESIDENCIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_certificado> outCgg_res_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_res_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CERTIFICADO_S_CGG_RES_RESIDENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_certificado().getCRRSD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_certificado tmpCgg_res_certificado = new com.besixplus.sii.objects.Cgg_res_certificado();
				tmpCgg_res_certificado.setCRCRT_CODIGO(results.getString(1));
				tmpCgg_res_certificado.setCRRSD_CODIGO(results.getString(2));
				tmpCgg_res_certificado.setCRCRT_FECHA_EMISION(results.getTimestamp(3));
				tmpCgg_res_certificado.setCRCRT_NUMERO(results.getString(4));
				tmpCgg_res_certificado.setCRCRT_CONTENIDO(results.getString(5));
				tmpCgg_res_certificado.setCRCRT_ANIO(results.getInt(6));
				tmpCgg_res_certificado.setCRCRT_ESTADO(results.getBoolean(7));
				outCgg_res_certificado.add(tmpCgg_res_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_certificado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_certificado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_residencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_RESIDENCIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CERTIFICADO_D_CGG_RES_RESIDENCIA(?) }");
			stmDelete.setString(1, this.getCgg_res_certificado().getCRRSD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CERTIFICADO_DS_CGG_RES_RESIDENCIA(?) }");
				stmDelete.setString(1, this.getCgg_res_certificado().getCRRSD_CODIGO());
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