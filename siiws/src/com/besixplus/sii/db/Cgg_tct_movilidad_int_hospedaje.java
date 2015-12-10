package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_tct_movilidad_int_hospedaje
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_movilidad_int_hospedaje.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_movilidad_int_hospedaje implements Serializable{
	private static final long serialVersionUID = 702372027;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje.
	*/
	private com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje myCgg_tct_movilidad_int_hospedaje = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_int_hospedaje.
	*/
	public Cgg_tct_movilidad_int_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_int_hospedaje.
	* @param inCgg_tct_movilidad_int_hospedaje OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_movilidad_int_hospedaje.
	*/
	public Cgg_tct_movilidad_int_hospedaje(
		com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje inCgg_tct_movilidad_int_hospedaje
	){
		this.setCgg_tct_movilidad_int_hospedaje(inCgg_tct_movilidad_int_hospedaje);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_movilidad_int_hospedaje.
	* @param inCgg_tct_movilidad_int_hospedaje OBJETO Cgg_tct_movilidad_int_hospedaje.
	* @return void
	*/
	public void setCgg_tct_movilidad_int_hospedaje(com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje inCgg_tct_movilidad_int_hospedaje){
		this.myCgg_tct_movilidad_int_hospedaje = inCgg_tct_movilidad_int_hospedaje;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_movilidad_int_hospedaje.
	* @return Cgg_tct_movilidad_int_hospedaje OBJETO Cgg_tct_movilidad_int_hospedaje.
	*/
	public com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje getCgg_tct_movilidad_int_hospedaje(){
		return this.myCgg_tct_movilidad_int_hospedaje;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_movilidad_int_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
			stmInsert.setString(5, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_LUGAR_HOSPEDAJE());
			stmInsert.setBoolean(6, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_ESTADO());
			stmInsert.setString(7, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_movilidad_int_hospedaje().setCTMHJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> outCgg_tct_movilidad_int_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje tmpCgg_tct_movilidad_int_hospedaje = new com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje();
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_CODIGO(results.getString(1));
				tmpCgg_tct_movilidad_int_hospedaje.setCTTHJ_CODIGO(results.getString(2));
				tmpCgg_tct_movilidad_int_hospedaje.setCRMVI_CODIGO(results.getString(3));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_movilidad_int_hospedaje.add(tmpCgg_tct_movilidad_int_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_movilidad_int_hospedaje;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_hospedaje QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> outCgg_tct_movilidad_int_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje tmpCgg_tct_movilidad_int_hospedaje = new com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje();
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_CODIGO(results.getString(1));
				tmpCgg_tct_movilidad_int_hospedaje.setCTTHJ_CODIGO(results.getString(2));
				tmpCgg_tct_movilidad_int_hospedaje.setCRMVI_CODIGO(results.getString(3));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_movilidad_int_hospedaje.add(tmpCgg_tct_movilidad_int_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_movilidad_int_hospedaje;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_movilidad_int_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_movilidad_int_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
			stmUpdate.setString(4, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_LUGAR_HOSPEDAJE());
			stmUpdate.setBoolean(5, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_ESTADO());
			stmUpdate.setString(6, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_movilidad_int_hospedaje DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_movilidad_int_hospedaje().setCTMHJ_CODIGO(results.getString(1));
				this.getCgg_tct_movilidad_int_hospedaje().setCTTHJ_CODIGO(results.getString(2));
				this.getCgg_tct_movilidad_int_hospedaje().setCRMVI_CODIGO(results.getString(3));
				this.getCgg_tct_movilidad_int_hospedaje().setCTMHJ_LUGAR_HOSPEDAJE(results.getString(4));
				this.getCgg_tct_movilidad_int_hospedaje().setCTMHJ_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_movilidad_int_hospedaje();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_movilidad_int_hospedaje DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCTMHJ_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_hospedaje DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_tipo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> selectCGG_TCT_TIPO_HOSPEDAJE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> outCgg_tct_movilidad_int_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_S_CGG_TCT_TIPO_HOSPEDAJE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje tmpCgg_tct_movilidad_int_hospedaje = new com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje();
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_CODIGO(results.getString(1));
				tmpCgg_tct_movilidad_int_hospedaje.setCTTHJ_CODIGO(results.getString(2));
				tmpCgg_tct_movilidad_int_hospedaje.setCRMVI_CODIGO(results.getString(3));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_movilidad_int_hospedaje.add(tmpCgg_tct_movilidad_int_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_movilidad_int_hospedaje;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_hospedaje DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_tipo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_TIPO_HOSPEDAJE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_D_CGG_TCT_TIPO_HOSPEDAJE(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_DS_CGG_TCT_TIPO_HOSPEDAJE(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_hospedaje DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_movilidad_interna.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> selectCGG_RES_MOVILIDAD_INTERNA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje> outCgg_tct_movilidad_int_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_S_CGG_RES_MOVILIDAD_INTERNA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje tmpCgg_tct_movilidad_int_hospedaje = new com.besixplus.sii.objects.Cgg_tct_movilidad_int_hospedaje();
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_CODIGO(results.getString(1));
				tmpCgg_tct_movilidad_int_hospedaje.setCTTHJ_CODIGO(results.getString(2));
				tmpCgg_tct_movilidad_int_hospedaje.setCRMVI_CODIGO(results.getString(3));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_movilidad_int_hospedaje.setCTMHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_movilidad_int_hospedaje.add(tmpCgg_tct_movilidad_int_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_movilidad_int_hospedaje;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_movilidad_int_hospedaje DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_movilidad_interna.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_MOVILIDAD_INTERNA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_D_CGG_RES_MOVILIDAD_INTERNA(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_MOVILIDAD_INT_HOSPEDAJE_DS_CGG_RES_MOVILIDAD_INTERNA(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_movilidad_int_hospedaje().getCRMVI_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_movilidad_int_hospedaje().getCTTHJ_CODIGO());
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