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
* CLASE Cgg_res_representante_legal
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_representante_legal.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_representante_legal implements Serializable{
	private static final long serialVersionUID = 745504166;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_representante_legal.
	*/
	private com.besixplus.sii.objects.Cgg_res_representante_legal myCgg_res_representante_legal = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_representante_legal.
	*/
	public Cgg_res_representante_legal(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_representante_legal.
	* @param inCgg_res_representante_legal OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_representante_legal.
	*/
	public Cgg_res_representante_legal(
		com.besixplus.sii.objects.Cgg_res_representante_legal inCgg_res_representante_legal
	){
		this.setCgg_res_representante_legal(inCgg_res_representante_legal);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_representante_legal.
	* @param inCgg_res_representante_legal OBJETO Cgg_res_representante_legal.
	* @return void
	*/
	public void setCgg_res_representante_legal(com.besixplus.sii.objects.Cgg_res_representante_legal inCgg_res_representante_legal){
		this.myCgg_res_representante_legal = inCgg_res_representante_legal;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_representante_legal.
	* @return Cgg_res_representante_legal OBJETO Cgg_res_representante_legal.
	*/
	public com.besixplus.sii.objects.Cgg_res_representante_legal getCgg_res_representante_legal(){
		return this.myCgg_res_representante_legal;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_representante_legal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_representante_legal().getCRRPT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_representante_legal().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_representante_legal().getCRPJR_CODIGO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_res_representante_legal().getCRRPT_FECHA_REGISTRO().getTime()));
			stmInsert.setBoolean(6, this.getCgg_res_representante_legal().getCRRPT_ACTIVO());
			stmInsert.setBoolean(7, this.getCgg_res_representante_legal().getCRRPT_ESTADO());
			stmInsert.setString(8, this.getCgg_res_representante_legal().getCRRPT_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_res_representante_legal().getCRRPT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_representante_legal().setCRRPT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_representante_legal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> outCgg_res_representante_legal = new ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_representante_legal tmpCgg_res_representante_legal = new com.besixplus.sii.objects.Cgg_res_representante_legal();
				tmpCgg_res_representante_legal.setCRRPT_CODIGO(results.getString(1));
				tmpCgg_res_representante_legal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_representante_legal.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_representante_legal.setCRRPT_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_res_representante_legal.setCRRPT_ACTIVO(results.getBoolean(5));
				tmpCgg_res_representante_legal.setCRRPT_ESTADO(results.getBoolean(6));
				outCgg_res_representante_legal.add(tmpCgg_res_representante_legal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_representante_legal;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_representante_legal QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> outCgg_res_representante_legal = new ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_representante_legal tmpCgg_res_representante_legal = new com.besixplus.sii.objects.Cgg_res_representante_legal();
				tmpCgg_res_representante_legal.setCRRPT_CODIGO(results.getString(1));
				tmpCgg_res_representante_legal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_representante_legal.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_representante_legal.setCRRPT_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_res_representante_legal.setCRRPT_ACTIVO(results.getBoolean(5));
				tmpCgg_res_representante_legal.setCRRPT_ESTADO(results.getBoolean(6));
				outCgg_res_representante_legal.add(tmpCgg_res_representante_legal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_representante_legal;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_representante_legal QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_representante_legal = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_representante_legal.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_representante_legal;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_representante_legal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_representante_legal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_representante_legal().getCRRPT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_representante_legal().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_representante_legal().getCRPJR_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_representante_legal().getCRRPT_FECHA_REGISTRO().getTime()));
			stmUpdate.setBoolean(5, this.getCgg_res_representante_legal().getCRRPT_ACTIVO());
			stmUpdate.setBoolean(6, this.getCgg_res_representante_legal().getCRRPT_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_representante_legal().getCRRPT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_representante_legal DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_representante_legal OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_representante_legal select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_representante_legal().getCRRPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_representante_legal().setCRRPT_CODIGO(results.getString(1));
				this.getCgg_res_representante_legal().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_representante_legal().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_res_representante_legal().setCRRPT_FECHA_REGISTRO(results.getTimestamp(4));
				this.getCgg_res_representante_legal().setCRRPT_ACTIVO(results.getBoolean(5));
				this.getCgg_res_representante_legal().setCRRPT_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_representante_legal();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_representante_legal DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_representante_legal().getCRRPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_representante_legal().getCRRPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_representante_legal DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_representante_legal OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> outCgg_res_representante_legal = new ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_representante_legal().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_representante_legal tmpCgg_res_representante_legal = new com.besixplus.sii.objects.Cgg_res_representante_legal();
				tmpCgg_res_representante_legal.setCRRPT_CODIGO(results.getString(1));
				tmpCgg_res_representante_legal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_representante_legal.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_representante_legal.setCRRPT_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_res_representante_legal.setCRRPT_ACTIVO(results.getBoolean(5));
				tmpCgg_res_representante_legal.setCRRPT_ESTADO(results.getBoolean(6));
				outCgg_res_representante_legal.add(tmpCgg_res_representante_legal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_representante_legal;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_representante_legal DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_res_representante_legal().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_res_representante_legal().getCRPJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_representante_legal DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_representante_legal OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> outCgg_res_representante_legal = new ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_LEGAL_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_representante_legal().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_representante_legal tmpCgg_res_representante_legal = new com.besixplus.sii.objects.Cgg_res_representante_legal();
				tmpCgg_res_representante_legal.setCRRPT_CODIGO(results.getString(1));
				tmpCgg_res_representante_legal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_representante_legal.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_res_representante_legal.setCRRPT_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_res_representante_legal.setCRRPT_ACTIVO(results.getBoolean(5));
				tmpCgg_res_representante_legal.setCRRPT_ESTADO(results.getBoolean(6));
				outCgg_res_representante_legal.add(tmpCgg_res_representante_legal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_representante_legal;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_representante_legal DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_representante_legal().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REPRESENTANTE_LEGAL_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_representante_legal().getCRPER_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_representante_legal QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrpjr_codigo CODIGO DE LA PERSONA JURIDICA DE QUIEN SE OBTENDRA EL REPRESENTANTE LEGAL
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_representante_legal> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectRepresentantePersona(
		java.sql.Connection inConnection,
		String inCrpjr_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_representante_legal = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REPRESENTANTE_PERSONA_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrpjr_codigo);

			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_representante_legal.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_representante_legal;
	}

}