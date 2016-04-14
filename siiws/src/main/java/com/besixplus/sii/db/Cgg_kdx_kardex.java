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
* CLASE Cgg_kdx_kardex
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_kardex.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_kardex implements Serializable{
	private static final long serialVersionUID = 51946884;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_kardex.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_kardex myCgg_kdx_kardex = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_kardex.
	*/
	public Cgg_kdx_kardex(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_kardex.
	* @param inCgg_kdx_kardex OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_kardex.
	*/
	public Cgg_kdx_kardex(
		com.besixplus.sii.objects.Cgg_kdx_kardex inCgg_kdx_kardex
	){
		this.setCgg_kdx_kardex(inCgg_kdx_kardex);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_kardex.
	* @param inCgg_kdx_kardex OBJETO Cgg_kdx_kardex.
	* @return void
	*/
	public void setCgg_kdx_kardex(com.besixplus.sii.objects.Cgg_kdx_kardex inCgg_kdx_kardex){
		this.myCgg_kdx_kardex = inCgg_kdx_kardex;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_kardex.
	* @return Cgg_kdx_kardex OBJETO Cgg_kdx_kardex.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_kardex getCgg_kdx_kardex(){
		return this.myCgg_kdx_kardex;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_kardex().getCKKRD_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmInsert.setInt(4, this.getCgg_kdx_kardex().getCKKRD_NUMERO());
			stmInsert.setString(5, this.getCgg_kdx_kardex().getCKKRD_DETALLE());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_kdx_kardex().getCKKRD_FECHA_REGISTRO().getTime()));
			stmInsert.setInt(7, this.getCgg_kdx_kardex().getCKKRD_TIPO_MOVIMIENTO());
			stmInsert.setInt(8, this.getCgg_kdx_kardex().getCKKRD_TIPO_OPERACION());
			stmInsert.setInt(9, this.getCgg_kdx_kardex().getCKKRD_INGRESO_CANTIDAD());
			stmInsert.setBigDecimal(10, this.getCgg_kdx_kardex().getCKKRD_INGRESO_PU());
			stmInsert.setBigDecimal(11, this.getCgg_kdx_kardex().getCKKRD_INGRESO_TOTAL());
			stmInsert.setInt(12, this.getCgg_kdx_kardex().getCKKRD_SALIDA_CANTIDAD());
			stmInsert.setBigDecimal(13, this.getCgg_kdx_kardex().getCKKRD_SALIDA_PU());
			stmInsert.setBigDecimal(14, this.getCgg_kdx_kardex().getCKKRD_SALIDA_TOTAL());
			stmInsert.setInt(15, this.getCgg_kdx_kardex().getCKKRD_TOTAL_CANTIDAD());
			stmInsert.setBigDecimal(16, this.getCgg_kdx_kardex().getCKKRD_TOTAL_PU());
			stmInsert.setBigDecimal(17, this.getCgg_kdx_kardex().getCKKRD_TOTAL_TOTAL());
			stmInsert.setBoolean(18, this.getCgg_kdx_kardex().getCKKRD_ESTADO());
			stmInsert.setString(19, this.getCgg_kdx_kardex().getCKKRD_USUARIO_INSERT());
			stmInsert.setString(20, this.getCgg_kdx_kardex().getCKKRD_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_kdx_kardex().setCKKRD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> outCgg_kdx_kardex = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_kardex tmpCgg_kdx_kardex = new com.besixplus.sii.objects.Cgg_kdx_kardex();
				tmpCgg_kdx_kardex.setCKKRD_CODIGO(results.getString(1));
				tmpCgg_kdx_kardex.setCKESP_CODIGO(results.getString(2));
				tmpCgg_kdx_kardex.setCKKRD_NUMERO(results.getInt(3));
				tmpCgg_kdx_kardex.setCKKRD_DETALLE(results.getString(4));
				tmpCgg_kdx_kardex.setCKKRD_FECHA_REGISTRO(results.getTimestamp(5));
				tmpCgg_kdx_kardex.setCKKRD_TIPO_MOVIMIENTO(results.getInt(6));
				tmpCgg_kdx_kardex.setCKKRD_TIPO_OPERACION(results.getInt(7));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_PU(results.getBigDecimal(9));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_CANTIDAD(results.getInt(11));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_PU(results.getBigDecimal(12));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_TOTAL(results.getBigDecimal(13));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_CANTIDAD(results.getInt(14));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_PU(results.getBigDecimal(15));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_TOTAL(results.getBigDecimal(16));
				tmpCgg_kdx_kardex.setCKKRD_ESTADO(results.getBoolean(17));
				outCgg_kdx_kardex.add(tmpCgg_kdx_kardex);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_kardex;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_kardex QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCIOND DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> outCgg_kdx_kardex = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_kardex tmpCgg_kdx_kardex = new com.besixplus.sii.objects.Cgg_kdx_kardex();
				tmpCgg_kdx_kardex.setCKKRD_CODIGO(results.getString(1));
				tmpCgg_kdx_kardex.setCKESP_CODIGO(results.getString(2));
				tmpCgg_kdx_kardex.setCKKRD_NUMERO(results.getInt(3));
				tmpCgg_kdx_kardex.setCKKRD_DETALLE(results.getString(4));
				tmpCgg_kdx_kardex.setCKKRD_FECHA_REGISTRO(results.getTimestamp(5));
				tmpCgg_kdx_kardex.setCKKRD_TIPO_MOVIMIENTO(results.getInt(6));
				tmpCgg_kdx_kardex.setCKKRD_TIPO_OPERACION(results.getInt(7));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_PU(results.getBigDecimal(9));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_CANTIDAD(results.getInt(11));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_PU(results.getBigDecimal(12));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_TOTAL(results.getBigDecimal(13));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_CANTIDAD(results.getInt(14));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_PU(results.getBigDecimal(15));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_TOTAL(results.getBigDecimal(16));
				tmpCgg_kdx_kardex.setCKKRD_ESTADO(results.getBoolean(17));
				outCgg_kdx_kardex.add(tmpCgg_kdx_kardex);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_kardex;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_kardex QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_kardex = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_SELECT1(?,?,?,?,?,?) }");
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
				outCgg_kdx_kardex.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_kardex;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_KARDEX_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_kardex().getCKKRD_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmUpdate.setInt(3, this.getCgg_kdx_kardex().getCKKRD_NUMERO());
			stmUpdate.setString(4, this.getCgg_kdx_kardex().getCKKRD_DETALLE());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_kdx_kardex().getCKKRD_FECHA_REGISTRO().getTime()));
			stmUpdate.setInt(6, this.getCgg_kdx_kardex().getCKKRD_TIPO_MOVIMIENTO());
			stmUpdate.setInt(7, this.getCgg_kdx_kardex().getCKKRD_TIPO_OPERACION());
			stmUpdate.setInt(8, this.getCgg_kdx_kardex().getCKKRD_INGRESO_CANTIDAD());
			stmUpdate.setBigDecimal(9, this.getCgg_kdx_kardex().getCKKRD_INGRESO_PU());
			stmUpdate.setBigDecimal(10, this.getCgg_kdx_kardex().getCKKRD_INGRESO_TOTAL());
			stmUpdate.setInt(11, this.getCgg_kdx_kardex().getCKKRD_SALIDA_CANTIDAD());
			stmUpdate.setBigDecimal(12, this.getCgg_kdx_kardex().getCKKRD_SALIDA_PU());
			stmUpdate.setBigDecimal(13, this.getCgg_kdx_kardex().getCKKRD_SALIDA_TOTAL());
			stmUpdate.setInt(14, this.getCgg_kdx_kardex().getCKKRD_TOTAL_CANTIDAD());
			stmUpdate.setBigDecimal(15, this.getCgg_kdx_kardex().getCKKRD_TOTAL_PU());
			stmUpdate.setBigDecimal(16, this.getCgg_kdx_kardex().getCKKRD_TOTAL_TOTAL());
			stmUpdate.setBoolean(17, this.getCgg_kdx_kardex().getCKKRD_ESTADO());
			stmUpdate.setString(18, this.getCgg_kdx_kardex().getCKKRD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_kardex DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_kardex OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_kardex select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_kardex().getCKKRD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_kardex().setCKKRD_CODIGO(results.getString(1));
				this.getCgg_kdx_kardex().setCKESP_CODIGO(results.getString(2));
				this.getCgg_kdx_kardex().setCKKRD_NUMERO(results.getInt(3));
				this.getCgg_kdx_kardex().setCKKRD_DETALLE(results.getString(4));
				this.getCgg_kdx_kardex().setCKKRD_FECHA_REGISTRO(results.getTimestamp(5));
				this.getCgg_kdx_kardex().setCKKRD_TIPO_MOVIMIENTO(results.getInt(6));
				this.getCgg_kdx_kardex().setCKKRD_TIPO_OPERACION(results.getInt(7));
				this.getCgg_kdx_kardex().setCKKRD_INGRESO_CANTIDAD(results.getInt(8));
				this.getCgg_kdx_kardex().setCKKRD_INGRESO_PU(results.getBigDecimal(9));
				this.getCgg_kdx_kardex().setCKKRD_INGRESO_TOTAL(results.getBigDecimal(10));
				this.getCgg_kdx_kardex().setCKKRD_SALIDA_CANTIDAD(results.getInt(11));
				this.getCgg_kdx_kardex().setCKKRD_SALIDA_PU(results.getBigDecimal(12));
				this.getCgg_kdx_kardex().setCKKRD_SALIDA_TOTAL(results.getBigDecimal(13));
				this.getCgg_kdx_kardex().setCKKRD_TOTAL_CANTIDAD(results.getInt(14));
				this.getCgg_kdx_kardex().setCKKRD_TOTAL_PU(results.getBigDecimal(15));
				this.getCgg_kdx_kardex().setCKKRD_TOTAL_TOTAL(results.getBigDecimal(16));
				this.getCgg_kdx_kardex().setCKKRD_ESTADO(results.getBoolean(17));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_kardex();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_kardex DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_KARDEX_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_kardex().getCKKRD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_KARDEX_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_kardex().getCKKRD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_kardex DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_kardex OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> selectCGG_KDX_ESPECIE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> outCgg_kdx_kardex = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_S_CGG_KDX_ESPECIE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_kardex tmpCgg_kdx_kardex = new com.besixplus.sii.objects.Cgg_kdx_kardex();
				tmpCgg_kdx_kardex.setCKKRD_CODIGO(results.getString(1));
				tmpCgg_kdx_kardex.setCKESP_CODIGO(results.getString(2));
				tmpCgg_kdx_kardex.setCKKRD_NUMERO(results.getInt(3));
				tmpCgg_kdx_kardex.setCKKRD_DETALLE(results.getString(4));
				tmpCgg_kdx_kardex.setCKKRD_FECHA_REGISTRO(results.getTimestamp(5));
				tmpCgg_kdx_kardex.setCKKRD_TIPO_MOVIMIENTO(results.getInt(6));
				tmpCgg_kdx_kardex.setCKKRD_TIPO_OPERACION(results.getInt(7));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_PU(results.getBigDecimal(9));
				tmpCgg_kdx_kardex.setCKKRD_INGRESO_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_CANTIDAD(results.getInt(11));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_PU(results.getBigDecimal(12));
				tmpCgg_kdx_kardex.setCKKRD_SALIDA_TOTAL(results.getBigDecimal(13));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_CANTIDAD(results.getInt(14));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_PU(results.getBigDecimal(15));
				tmpCgg_kdx_kardex.setCKKRD_TOTAL_TOTAL(results.getBigDecimal(16));
				tmpCgg_kdx_kardex.setCKKRD_ESTADO(results.getBoolean(17));
				outCgg_kdx_kardex.add(tmpCgg_kdx_kardex);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_kardex;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_kardex DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_ESPECIE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_KARDEX_D_CGG_KDX_ESPECIE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_kardex().getCKESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_KARDEX_DS_CGG_KDX_ESPECIE(?) }");
				stmDelete.setString(1, this.getCgg_kdx_kardex().getCKESP_CODIGO());
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
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String ejecutarOperacion(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_KARDEX_EJECUTAR_CALCULO(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_kardex().getCKKRD_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_kardex().getCKKRD_DETALLE());
			stmInsert.setInt(5, this.getCgg_kdx_kardex().getCKKRD_TIPO_MOVIMIENTO());
			stmInsert.setInt(6, this.getCgg_kdx_kardex().getCKKRD_TIPO_OPERACION());
			stmInsert.setInt(7, this.getCgg_kdx_kardex().getCKKRD_INGRESO_CANTIDAD());
			stmInsert.setBigDecimal(8, this.getCgg_kdx_kardex().getCKKRD_INGRESO_PU());
			stmInsert.setBigDecimal(9, this.getCgg_kdx_kardex().getCKKRD_INGRESO_TOTAL());
			stmInsert.setBoolean(10, this.getCgg_kdx_kardex().getCKKRD_ESTADO());
			stmInsert.setString(11, this.getCgg_kdx_kardex().getCKKRD_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_kdx_kardex().getCKKRD_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_kdx_kardex().setCKKRD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String controlStock(
		java.sql.Connection inConnection
	){
		String outResult = "false";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_KARDEX_CONTROL_STOCK(? ) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmInsert.execute();
			outResult = stmInsert.getString(1);
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String verificaInventarioInicial(
		java.sql.Connection inConnection
	){
		String outResult = "false";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_KARDEX_EXISTE_INVENTARIO(? ) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmInsert.execute();
			outResult = stmInsert.getString(1);
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* DEVUELDE EL STOCK ACTUAL DE LA EN LA TABLA Cgg_kdx_kardex.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public  ArrayList<HashMap<String,Object>> selectStockActual(
		java.sql.Connection inConnection		
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_kardex = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_KARDEX_STOCK(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_kdx_kardex().getCKESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_kardex.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_kardex;
	}


}