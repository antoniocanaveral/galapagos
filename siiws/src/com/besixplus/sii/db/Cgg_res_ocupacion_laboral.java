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
* CLASE Cgg_res_ocupacion_laboral
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_ocupacion_laboral.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_ocupacion_laboral implements Serializable{
	private static final long serialVersionUID = 1072055360;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_ocupacion_laboral.
	*/
	private com.besixplus.sii.objects.Cgg_res_ocupacion_laboral myCgg_res_ocupacion_laboral = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_ocupacion_laboral.
	*/
	public Cgg_res_ocupacion_laboral(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_ocupacion_laboral.
	* @param inCgg_res_ocupacion_laboral OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_ocupacion_laboral.
	*/
	public Cgg_res_ocupacion_laboral(
		com.besixplus.sii.objects.Cgg_res_ocupacion_laboral inCgg_res_ocupacion_laboral
	){
		this.setCgg_res_ocupacion_laboral(inCgg_res_ocupacion_laboral);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_ocupacion_laboral.
	* @param inCgg_res_ocupacion_laboral OBJETO Cgg_res_ocupacion_laboral.
	* @return void
	*/
	public void setCgg_res_ocupacion_laboral(com.besixplus.sii.objects.Cgg_res_ocupacion_laboral inCgg_res_ocupacion_laboral){
		this.myCgg_res_ocupacion_laboral = inCgg_res_ocupacion_laboral;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_ocupacion_laboral.
	* @return Cgg_res_ocupacion_laboral OBJETO Cgg_res_ocupacion_laboral.
	*/
	public com.besixplus.sii.objects.Cgg_res_ocupacion_laboral getCgg_res_ocupacion_laboral(){
		return this.myCgg_res_ocupacion_laboral;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_ocupacion_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_ocupacion_laboral().getCROCL_CODIGO());
			stmInsert.setString(3, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmInsert.setString(5, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmInsert.setString(6, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
			stmInsert.setString(7, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmInsert.setInt(8, this.getCgg_res_ocupacion_laboral().getCROCL_TIPO());
			stmInsert.setBoolean(9, this.getCgg_res_ocupacion_laboral().getCROCL_ESTADO());
			stmInsert.setString(10, this.getCgg_res_ocupacion_laboral().getCROCL_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_res_ocupacion_laboral().getCROCL_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_ocupacion_laboral().setCROCL_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> outCgg_res_ocupacion_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpCgg_res_ocupacion_laboral = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
				tmpCgg_res_ocupacion_laboral.setCROCL_CODIGO(results.getString(1));
				tmpCgg_res_ocupacion_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_ocupacion_laboral.setCGG_CRPER_CODIGO(results.getString(3));
				tmpCgg_res_ocupacion_laboral.setCGCRG_CODIGO(results.getString(4));
				tmpCgg_res_ocupacion_laboral.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_res_ocupacion_laboral.setCRPJR_CODIGO(results.getString(6));
				tmpCgg_res_ocupacion_laboral.setCROCL_TIPO(results.getInt(7));
				tmpCgg_res_ocupacion_laboral.setCROCL_ESTADO(results.getBoolean(8));
				outCgg_res_ocupacion_laboral.add(tmpCgg_res_ocupacion_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_ocupacion_laboral;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> outCgg_res_ocupacion_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpCgg_res_ocupacion_laboral = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
				tmpCgg_res_ocupacion_laboral.setCROCL_CODIGO(results.getString(1));
				tmpCgg_res_ocupacion_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_ocupacion_laboral.setCGG_CRPER_CODIGO(results.getString(3));
				tmpCgg_res_ocupacion_laboral.setCGCRG_CODIGO(results.getString(4));
				tmpCgg_res_ocupacion_laboral.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_res_ocupacion_laboral.setCRPJR_CODIGO(results.getString(6));
				tmpCgg_res_ocupacion_laboral.setCROCL_TIPO(results.getInt(7));
				tmpCgg_res_ocupacion_laboral.setCROCL_ESTADO(results.getBoolean(8));
				outCgg_res_ocupacion_laboral.add(tmpCgg_res_ocupacion_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_ocupacion_laboral;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_ocupacion_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_ocupacion_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_ocupacion_laboral().getCROCL_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmUpdate.setInt(7, this.getCgg_res_ocupacion_laboral().getCROCL_TIPO());
			stmUpdate.setBoolean(8, this.getCgg_res_ocupacion_laboral().getCROCL_ESTADO());
			stmUpdate.setString(9, this.getCgg_res_ocupacion_laboral().getCROCL_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_ocupacion_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_ocupacion_laboral select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_ocupacion_laboral().getCROCL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_ocupacion_laboral().setCROCL_CODIGO(results.getString(1));
				this.getCgg_res_ocupacion_laboral().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_ocupacion_laboral().setCGG_CRPER_CODIGO(results.getString(3));
				this.getCgg_res_ocupacion_laboral().setCGCRG_CODIGO(results.getString(4));
				this.getCgg_res_ocupacion_laboral().setCSCTP_CODIGO(results.getString(5));
				this.getCgg_res_ocupacion_laboral().setCRPJR_CODIGO(results.getString(6));
				this.getCgg_res_ocupacion_laboral().setCROCL_TIPO(results.getInt(7));
				this.getCgg_res_ocupacion_laboral().setCROCL_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_ocupacion_laboral();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCROCL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCROCL_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_ocupacion_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> outCgg_res_ocupacion_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_S_CGG_RES_PERSONA_JURIDICA(?, ?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmSelect.setString(3,this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmSelect.setString(5,this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmSelect.setString(6,this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpCgg_res_ocupacion_laboral = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
				tmpCgg_res_ocupacion_laboral.setCROCL_CODIGO(results.getString(1));
				tmpCgg_res_ocupacion_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_ocupacion_laboral.setCGG_CRPER_CODIGO(results.getString(3));
				tmpCgg_res_ocupacion_laboral.setCGCRG_CODIGO(results.getString(4));
				tmpCgg_res_ocupacion_laboral.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_res_ocupacion_laboral.setCRPJR_CODIGO(results.getString(6));
				tmpCgg_res_ocupacion_laboral.setCROCL_TIPO(results.getInt(7));
				tmpCgg_res_ocupacion_laboral.setCROCL_ESTADO(results.getBoolean(8));
				outCgg_res_ocupacion_laboral.add(tmpCgg_res_ocupacion_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_ocupacion_laboral;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_D_CGG_RES_PERSONA_JURIDICA(?, ?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_DS_CGG_RES_PERSONA_JURIDICA(?, ?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
				stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
				stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
				stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_ocupacion_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> outCgg_res_ocupacion_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_S_CGG_RES_PERSONA(?, ?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmSelect.setString(3,this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmSelect.setString(5,this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmSelect.setString(6,this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpCgg_res_ocupacion_laboral = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
				tmpCgg_res_ocupacion_laboral.setCROCL_CODIGO(results.getString(1));
				tmpCgg_res_ocupacion_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_ocupacion_laboral.setCGG_CRPER_CODIGO(results.getString(3));
				tmpCgg_res_ocupacion_laboral.setCGCRG_CODIGO(results.getString(4));
				tmpCgg_res_ocupacion_laboral.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_res_ocupacion_laboral.setCRPJR_CODIGO(results.getString(6));
				tmpCgg_res_ocupacion_laboral.setCROCL_TIPO(results.getInt(7));
				tmpCgg_res_ocupacion_laboral.setCROCL_ESTADO(results.getBoolean(8));
				outCgg_res_ocupacion_laboral.add(tmpCgg_res_ocupacion_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_ocupacion_laboral;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_D_CGG_RES_PERSONA(?, ?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_DS_CGG_RES_PERSONA(?, ?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
				stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
				stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
				stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_ocupacion_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> selectCGG_GEM_CARGO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> outCgg_res_ocupacion_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_S_CGG_GEM_CARGO(?, ?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmSelect.setString(3,this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmSelect.setString(5,this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmSelect.setString(6,this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpCgg_res_ocupacion_laboral = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
				tmpCgg_res_ocupacion_laboral.setCROCL_CODIGO(results.getString(1));
				tmpCgg_res_ocupacion_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_ocupacion_laboral.setCGG_CRPER_CODIGO(results.getString(3));
				tmpCgg_res_ocupacion_laboral.setCGCRG_CODIGO(results.getString(4));
				tmpCgg_res_ocupacion_laboral.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_res_ocupacion_laboral.setCRPJR_CODIGO(results.getString(6));
				tmpCgg_res_ocupacion_laboral.setCROCL_TIPO(results.getInt(7));
				tmpCgg_res_ocupacion_laboral.setCROCL_ESTADO(results.getBoolean(8));
				outCgg_res_ocupacion_laboral.add(tmpCgg_res_ocupacion_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_ocupacion_laboral;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_CARGO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_D_CGG_GEM_CARGO(?, ?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_DS_CGG_GEM_CARGO(?, ?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
				stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
				stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
				stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_ocupacion_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> selectCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> outCgg_res_ocupacion_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OCUPACION_LABORAL_S_CGG_SECTOR_PRODUCTIVO(?, ?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmSelect.setString(3,this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmSelect.setString(5,this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmSelect.setString(6,this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpCgg_res_ocupacion_laboral = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
				tmpCgg_res_ocupacion_laboral.setCROCL_CODIGO(results.getString(1));
				tmpCgg_res_ocupacion_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_ocupacion_laboral.setCGG_CRPER_CODIGO(results.getString(3));
				tmpCgg_res_ocupacion_laboral.setCGCRG_CODIGO(results.getString(4));
				tmpCgg_res_ocupacion_laboral.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_res_ocupacion_laboral.setCRPJR_CODIGO(results.getString(6));
				tmpCgg_res_ocupacion_laboral.setCROCL_TIPO(results.getInt(7));
				tmpCgg_res_ocupacion_laboral.setCROCL_ESTADO(results.getBoolean(8));
				outCgg_res_ocupacion_laboral.add(tmpCgg_res_ocupacion_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_ocupacion_laboral;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_D_CGG_SECTOR_PRODUCTIVO(?, ?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
			stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
			stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
			stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OCUPACION_LABORAL_DS_CGG_SECTOR_PRODUCTIVO(?, ?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_res_ocupacion_laboral().getCGCRG_CODIGO());
				stmDelete.setString(2, this.getCgg_res_ocupacion_laboral().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_res_ocupacion_laboral().getCGG_CRPER_CODIGO());
				stmDelete.setString(4, this.getCgg_res_ocupacion_laboral().getCRPJR_CODIGO());
				stmDelete.setString(5, this.getCgg_res_ocupacion_laboral().getCSCTP_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectOcupacionPersonaDirect(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_OCUPACION_LABORAL_PERSONA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

}