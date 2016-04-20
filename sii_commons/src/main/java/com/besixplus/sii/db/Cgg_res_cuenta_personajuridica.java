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
* CLASE Cgg_res_cuenta_personajuridica
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_cuenta_personajuridica.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_cuenta_personajuridica implements Serializable{
	private static final long serialVersionUID = 234506209;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica.
	*/
	private com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica myCgg_res_cuenta_personajuridica = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cuenta_personajuridica.
	*/
	public Cgg_res_cuenta_personajuridica(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cuenta_personajuridica.
	* @param inCgg_res_cuenta_personajuridica OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_cuenta_personajuridica.
	*/
	public Cgg_res_cuenta_personajuridica(
		com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica inCgg_res_cuenta_personajuridica
	){
		this.setCgg_res_cuenta_personajuridica(inCgg_res_cuenta_personajuridica);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_cuenta_personajuridica.
	* @param inCgg_res_cuenta_personajuridica OBJETO Cgg_res_cuenta_personajuridica.
	* @return void
	*/
	public void setCgg_res_cuenta_personajuridica(com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica inCgg_res_cuenta_personajuridica){
		this.myCgg_res_cuenta_personajuridica = inCgg_res_cuenta_personajuridica;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_cuenta_personajuridica.
	* @return Cgg_res_cuenta_personajuridica OBJETO Cgg_res_cuenta_personajuridica.
	*/
	public com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica getCgg_res_cuenta_personajuridica(){
		return this.myCgg_res_cuenta_personajuridica;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_cuenta_personajuridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_cuenta_personajuridica().getCRCPJ_CODIGO());
			stmInsert.setString(3, this.getCgg_res_cuenta_personajuridica().getCGG_CRPJR_CODIGO());
			stmInsert.setString(4, this.getCgg_res_cuenta_personajuridica().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_res_cuenta_personajuridica().getCRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_cuenta_personajuridica().getCRCPJ_NUMERO_CUENTA());
			stmInsert.setString(7, this.getCgg_res_cuenta_personajuridica().getCRCPJ_DESCRIPCION());
			stmInsert.setInt(8, this.getCgg_res_cuenta_personajuridica().getCRCPJ_TIPO_CUENTA());
			stmInsert.setBoolean(9, this.getCgg_res_cuenta_personajuridica().getCRCPJ_ESTADO());
			stmInsert.setString(10, this.getCgg_res_cuenta_personajuridica().getCRCPJ_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_res_cuenta_personajuridica().getCRCPJ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_cuenta_personajuridica().setCRCPJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> outCgg_res_cuenta_personajuridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica tmpCgg_res_cuenta_personajuridica = new com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica();
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_CODIGO(results.getString(1));
				tmpCgg_res_cuenta_personajuridica.setCGG_CRPJR_CODIGO(results.getString(2));
				tmpCgg_res_cuenta_personajuridica.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_cuenta_personajuridica.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_NUMERO_CUENTA(results.getString(5));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_DESCRIPCION(results.getString(6));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_TIPO_CUENTA(results.getInt(7));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_ESTADO(results.getBoolean(8));
				outCgg_res_cuenta_personajuridica.add(tmpCgg_res_cuenta_personajuridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cuenta_personajuridica;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> outCgg_res_cuenta_personajuridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica tmpCgg_res_cuenta_personajuridica = new com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica();
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_CODIGO(results.getString(1));
				tmpCgg_res_cuenta_personajuridica.setCGG_CRPJR_CODIGO(results.getString(2));
				tmpCgg_res_cuenta_personajuridica.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_cuenta_personajuridica.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_NUMERO_CUENTA(results.getString(5));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_DESCRIPCION(results.getString(6));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_TIPO_CUENTA(results.getInt(7));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_ESTADO(results.getBoolean(8));
				outCgg_res_cuenta_personajuridica.add(tmpCgg_res_cuenta_personajuridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cuenta_personajuridica;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO. 
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA. 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCrpjr_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_cuenta_personajuridica = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrpjr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_cuenta_personajuridica.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cuenta_personajuridica;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_cuenta_personajuridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_COUNT() }");
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
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrpjr_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrpjr_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_cuenta_personajuridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_cuenta_personajuridica().getCRCPJ_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_cuenta_personajuridica().getCGG_CRPJR_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_cuenta_personajuridica().getCRPJR_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_cuenta_personajuridica().getCRPER_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_cuenta_personajuridica().getCRCPJ_NUMERO_CUENTA());
			stmUpdate.setString(6, this.getCgg_res_cuenta_personajuridica().getCRCPJ_DESCRIPCION());
			stmUpdate.setInt(7, this.getCgg_res_cuenta_personajuridica().getCRCPJ_TIPO_CUENTA());
			stmUpdate.setBoolean(8, this.getCgg_res_cuenta_personajuridica().getCRCPJ_ESTADO());
			stmUpdate.setString(9, this.getCgg_res_cuenta_personajuridica().getCRCPJ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_cuenta_personajuridica().getCRCPJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_cuenta_personajuridica().setCRCPJ_CODIGO(results.getString(1));
				this.getCgg_res_cuenta_personajuridica().setCGG_CRPJR_CODIGO(results.getString(2));
				this.getCgg_res_cuenta_personajuridica().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_res_cuenta_personajuridica().setCRPER_CODIGO(results.getString(4));
				this.getCgg_res_cuenta_personajuridica().setCRCPJ_NUMERO_CUENTA(results.getString(5));
				this.getCgg_res_cuenta_personajuridica().setCRCPJ_DESCRIPCION(results.getString(6));
				this.getCgg_res_cuenta_personajuridica().setCRCPJ_TIPO_CUENTA(results.getInt(7));
				this.getCgg_res_cuenta_personajuridica().setCRCPJ_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_cuenta_personajuridica();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_cuenta_personajuridica().getCRCPJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_cuenta_personajuridica().getCRCPJ_CODIGO());
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
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCRCPJ_CODIGO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String delete(
		java.sql.Connection inConnection,
		String inCRCPJ_CODIGO
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_DELETE(?) }");
			stmDelete.setString(1, inCRCPJ_CODIGO);
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		if(outResult.equals("true")){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_DELETE_SOFT(?) }");
				stmDelete.setString(1, inCRCPJ_CODIGO);
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = "false";
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> outCgg_res_cuenta_personajuridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_cuenta_personajuridica().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica tmpCgg_res_cuenta_personajuridica = new com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica();
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_CODIGO(results.getString(1));
				tmpCgg_res_cuenta_personajuridica.setCGG_CRPJR_CODIGO(results.getString(2));
				tmpCgg_res_cuenta_personajuridica.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_cuenta_personajuridica.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_NUMERO_CUENTA(results.getString(5));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_DESCRIPCION(results.getString(6));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_TIPO_CUENTA(results.getInt(7));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_ESTADO(results.getBoolean(8));
				outCgg_res_cuenta_personajuridica.add(tmpCgg_res_cuenta_personajuridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cuenta_personajuridica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public String deleteCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_res_cuenta_personajuridica().getCRPJR_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		if(outResult.equals("true")){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_res_cuenta_personajuridica().getCRPJR_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}
	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> outCgg_res_cuenta_personajuridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_cuenta_personajuridica().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica tmpCgg_res_cuenta_personajuridica = new com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica();
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_CODIGO(results.getString(1));
				tmpCgg_res_cuenta_personajuridica.setCGG_CRPJR_CODIGO(results.getString(2));
				tmpCgg_res_cuenta_personajuridica.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_cuenta_personajuridica.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_NUMERO_CUENTA(results.getString(5));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_DESCRIPCION(results.getString(6));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_TIPO_CUENTA(results.getInt(7));
				tmpCgg_res_cuenta_personajuridica.setCRCPJ_ESTADO(results.getBoolean(8));
				outCgg_res_cuenta_personajuridica.add(tmpCgg_res_cuenta_personajuridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cuenta_personajuridica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_cuenta_personajuridica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_cuenta_personajuridica().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CUENTA_PERSONAJURIDICA_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_cuenta_personajuridica().getCRPER_CODIGO());
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