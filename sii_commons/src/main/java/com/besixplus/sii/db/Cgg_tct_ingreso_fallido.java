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
* CLASE Cgg_tct_ingreso_fallido
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_ingreso_fallido.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_ingreso_fallido implements Serializable{
	private static final long serialVersionUID = 2039450589;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_ingreso_fallido.
	*/
	private com.besixplus.sii.objects.Cgg_tct_ingreso_fallido myCgg_tct_ingreso_fallido = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_ingreso_fallido.
	*/
	public Cgg_tct_ingreso_fallido(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_ingreso_fallido.
	* @param inCgg_tct_ingreso_fallido OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_ingreso_fallido.
	*/
	public Cgg_tct_ingreso_fallido(
		com.besixplus.sii.objects.Cgg_tct_ingreso_fallido inCgg_tct_ingreso_fallido
	){
		this.setCgg_tct_ingreso_fallido(inCgg_tct_ingreso_fallido);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_ingreso_fallido.
	* @param inCgg_tct_ingreso_fallido OBJETO Cgg_tct_ingreso_fallido.
	* @return void
	*/
	public void setCgg_tct_ingreso_fallido(com.besixplus.sii.objects.Cgg_tct_ingreso_fallido inCgg_tct_ingreso_fallido){
		this.myCgg_tct_ingreso_fallido = inCgg_tct_ingreso_fallido;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_ingreso_fallido.
	* @return Cgg_tct_ingreso_fallido OBJETO Cgg_tct_ingreso_fallido.
	*/
	public com.besixplus.sii.objects.Cgg_tct_ingreso_fallido getCgg_tct_ingreso_fallido(){
		return this.myCgg_tct_ingreso_fallido;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_ingreso_fallido.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_INSERT(?, ?, ?, ?, ?::smallint, ?, ?, ?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_ingreso_fallido().getCTIGF_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_ingreso_fallido().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_ingreso_fallido().getCARPT_CODIGO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_tct_ingreso_fallido().getCTIGF_FECHA_INTENTO().getTime()));
			stmInsert.setInt(6, this.getCgg_tct_ingreso_fallido().getCTIGF_TIPO_INGRESO_FALLIDO());
			stmInsert.setString(7, this.getCgg_tct_ingreso_fallido().getCTIGF_DESCRIPCION());
			stmInsert.setBoolean(8, this.getCgg_tct_ingreso_fallido().getCTIGF_ESTADO());
			stmInsert.setString(9, this.getCgg_tct_ingreso_fallido().getCTIGF_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_tct_ingreso_fallido().getCTIGF_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_ingreso_fallido().setCTIGF_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> outCgg_tct_ingreso_fallido = new ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_ingreso_fallido tmpCgg_tct_ingreso_fallido = new com.besixplus.sii.objects.Cgg_tct_ingreso_fallido();
				tmpCgg_tct_ingreso_fallido.setCTIGF_CODIGO(results.getString(1));
				tmpCgg_tct_ingreso_fallido.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_ingreso_fallido.setCARPT_CODIGO(results.getString(3));
				tmpCgg_tct_ingreso_fallido.setCTIGF_FECHA_INTENTO(results.getTimestamp(4));
				tmpCgg_tct_ingreso_fallido.setCTIGF_TIPO_INGRESO_FALLIDO(results.getInt(5));
				tmpCgg_tct_ingreso_fallido.setCTIGF_DESCRIPCION(results.getString(6));
				tmpCgg_tct_ingreso_fallido.setCTIGF_ESTADO(results.getBoolean(7));
				outCgg_tct_ingreso_fallido.add(tmpCgg_tct_ingreso_fallido);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_ingreso_fallido;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> outCgg_tct_ingreso_fallido = new ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_ingreso_fallido tmpCgg_tct_ingreso_fallido = new com.besixplus.sii.objects.Cgg_tct_ingreso_fallido();
				tmpCgg_tct_ingreso_fallido.setCTIGF_CODIGO(results.getString(1));
				tmpCgg_tct_ingreso_fallido.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_ingreso_fallido.setCARPT_CODIGO(results.getString(3));
				tmpCgg_tct_ingreso_fallido.setCTIGF_FECHA_INTENTO(results.getTimestamp(4));
				tmpCgg_tct_ingreso_fallido.setCTIGF_TIPO_INGRESO_FALLIDO(results.getInt(5));
				tmpCgg_tct_ingreso_fallido.setCTIGF_DESCRIPCION(results.getString(6));
				tmpCgg_tct_ingreso_fallido.setCTIGF_ESTADO(results.getBoolean(7));
				outCgg_tct_ingreso_fallido.add(tmpCgg_tct_ingreso_fallido);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_ingreso_fallido;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectingresofallido(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_ingreso_fallido = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_SELECT(?,?,?,?,?,?) }");
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
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_ingreso_fallido.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_ingreso_fallido;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_tct_ingreso_fallido = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_tct_ingreso_fallido.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_ingreso_fallido;
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
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_ingreso_fallido.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_UPDATE(?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_ingreso_fallido().getCTIGF_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_ingreso_fallido().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_ingreso_fallido().getCARPT_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_tct_ingreso_fallido().getCTIGF_FECHA_INTENTO().getTime()));
			stmUpdate.setInt(5, this.getCgg_tct_ingreso_fallido().getCTIGF_TIPO_INGRESO_FALLIDO());
			stmUpdate.setString(6, this.getCgg_tct_ingreso_fallido().getCTIGF_DESCRIPCION());
			stmUpdate.setBoolean(7, this.getCgg_tct_ingreso_fallido().getCTIGF_ESTADO());
			stmUpdate.setString(8, this.getCgg_tct_ingreso_fallido().getCTIGF_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_ingreso_fallido DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_ingreso_fallido OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_ingreso_fallido select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_ingreso_fallido().getCTIGF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_ingreso_fallido().setCTIGF_CODIGO(results.getString(1));
				this.getCgg_tct_ingreso_fallido().setCRPER_CODIGO(results.getString(2));
				this.getCgg_tct_ingreso_fallido().setCARPT_CODIGO(results.getString(3));
				this.getCgg_tct_ingreso_fallido().setCTIGF_FECHA_INTENTO(results.getTimestamp(4));
				this.getCgg_tct_ingreso_fallido().setCTIGF_TIPO_INGRESO_FALLIDO(results.getInt(5));
				this.getCgg_tct_ingreso_fallido().setCTIGF_DESCRIPCION(results.getString(6));
				this.getCgg_tct_ingreso_fallido().setCTIGF_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_ingreso_fallido();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_ingreso_fallido DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_ingreso_fallido().getCTIGF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_ingreso_fallido().getCTIGF_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_ingreso_fallido OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> selectCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> outCgg_tct_ingreso_fallido = new ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_S_CGG_RES_AEROPUERTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_ingreso_fallido().getCARPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_ingreso_fallido tmpCgg_tct_ingreso_fallido = new com.besixplus.sii.objects.Cgg_tct_ingreso_fallido();
				tmpCgg_tct_ingreso_fallido.setCTIGF_CODIGO(results.getString(1));
				tmpCgg_tct_ingreso_fallido.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_ingreso_fallido.setCARPT_CODIGO(results.getString(3));
				tmpCgg_tct_ingreso_fallido.setCTIGF_FECHA_INTENTO(results.getTimestamp(4));
				tmpCgg_tct_ingreso_fallido.setCTIGF_TIPO_INGRESO_FALLIDO(results.getInt(5));
				tmpCgg_tct_ingreso_fallido.setCTIGF_DESCRIPCION(results.getString(6));
				tmpCgg_tct_ingreso_fallido.setCTIGF_ESTADO(results.getBoolean(7));
				outCgg_tct_ingreso_fallido.add(tmpCgg_tct_ingreso_fallido);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_ingreso_fallido;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_D_CGG_RES_AEROPUERTO(?) }");
			stmDelete.setString(1, this.getCgg_tct_ingreso_fallido().getCARPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_DS_CGG_RES_AEROPUERTO(?) }");
				stmDelete.setString(1, this.getCgg_tct_ingreso_fallido().getCARPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_ingreso_fallido OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido> outCgg_tct_ingreso_fallido = new ArrayList<com.besixplus.sii.objects.Cgg_tct_ingreso_fallido>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_INGRESO_FALLIDO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_ingreso_fallido().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_ingreso_fallido tmpCgg_tct_ingreso_fallido = new com.besixplus.sii.objects.Cgg_tct_ingreso_fallido();
				tmpCgg_tct_ingreso_fallido.setCTIGF_CODIGO(results.getString(1));
				tmpCgg_tct_ingreso_fallido.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_ingreso_fallido.setCARPT_CODIGO(results.getString(3));
				tmpCgg_tct_ingreso_fallido.setCTIGF_FECHA_INTENTO(results.getTimestamp(4));
				tmpCgg_tct_ingreso_fallido.setCTIGF_TIPO_INGRESO_FALLIDO(results.getInt(5));
				tmpCgg_tct_ingreso_fallido.setCTIGF_DESCRIPCION(results.getString(6));
				tmpCgg_tct_ingreso_fallido.setCTIGF_ESTADO(results.getBoolean(7));
				outCgg_tct_ingreso_fallido.add(tmpCgg_tct_ingreso_fallido);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_ingreso_fallido;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_ingreso_fallido DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_tct_ingreso_fallido().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_INGRESO_FALLIDO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_tct_ingreso_fallido().getCRPER_CODIGO());
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