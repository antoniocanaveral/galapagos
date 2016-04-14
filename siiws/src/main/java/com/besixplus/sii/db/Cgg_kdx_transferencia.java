package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/*import javax.jws.WebParam;*/

/**
* CLASE Cgg_kdx_transferencia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_transferencia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_transferencia implements Serializable{
	private static final long serialVersionUID = 1117372172;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_transferencia.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_transferencia myCgg_kdx_transferencia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_transferencia.
	*/
	public Cgg_kdx_transferencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_transferencia.
	* @param inCgg_kdx_transferencia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_transferencia.
	*/
	public Cgg_kdx_transferencia(
		com.besixplus.sii.objects.Cgg_kdx_transferencia inCgg_kdx_transferencia
	){
		this.setCgg_kdx_transferencia(inCgg_kdx_transferencia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_transferencia.
	* @param inCgg_kdx_transferencia OBJETO Cgg_kdx_transferencia.
	* @return void
	*/
	public void setCgg_kdx_transferencia(com.besixplus.sii.objects.Cgg_kdx_transferencia inCgg_kdx_transferencia){
		this.myCgg_kdx_transferencia = inCgg_kdx_transferencia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_transferencia.
	* @return Cgg_kdx_transferencia OBJETO Cgg_kdx_transferencia.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_transferencia getCgg_kdx_transferencia(){
		return this.myCgg_kdx_transferencia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_transferencia().getCKTRN_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_transferencia().getCKPVT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_transferencia().getCKESP_CODIGO());
			stmInsert.setString(5, this.getCgg_kdx_transferencia().getCKTRN_NUMERO_TRANSFERENCIA());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_kdx_transferencia().getCKTRN_FECHA_RECEPCION().getTime()));
			stmInsert.setInt(7, this.getCgg_kdx_transferencia().getCKTRN_CANTIDAD());
			stmInsert.setBigDecimal(8, this.getCgg_kdx_transferencia().getCKTRN_PRECIO_UNITARIO());
			stmInsert.setInt(9, this.getCgg_kdx_transferencia().getCKTRN_SERIE_INICIO());
			stmInsert.setInt(10, this.getCgg_kdx_transferencia().getCKTRN_SERIE_FIN());
			stmInsert.setString(11, this.getCgg_kdx_transferencia().getCKTRN_OBSERVACION());
			stmInsert.setInt(12, this.getCgg_kdx_transferencia().getCKTRN_CANTIDAD_DISPONIBLE());
			stmInsert.setInt(13, this.getCgg_kdx_transferencia().getCKTRN_ESTADO_TRANSFERENCIA());
			stmInsert.setBoolean(14, this.getCgg_kdx_transferencia().getCKTRN_ESTADO());
			stmInsert.setString(15, this.getCgg_kdx_transferencia().getCKTRN_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_transferencia().setCKTRN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> outCgg_kdx_transferencia = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_transferencia tmpCgg_kdx_transferencia = new com.besixplus.sii.objects.Cgg_kdx_transferencia();
				tmpCgg_kdx_transferencia.setCKTRN_CODIGO(results.getString(1));
				tmpCgg_kdx_transferencia.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_transferencia.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_transferencia.setCKTRN_NUMERO_TRANSFERENCIA(results.getString(4));
				tmpCgg_kdx_transferencia.setCKTRN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_transferencia.setCKTRN_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_INICIO(results.getInt(8));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_FIN(results.getInt(9));
				tmpCgg_kdx_transferencia.setCKTRN_OBSERVACION(results.getString(10));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD_DISPONIBLE(results.getInt(11));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO_TRANSFERENCIA(results.getInt(12));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO(results.getBoolean(13));
				outCgg_kdx_transferencia.add(tmpCgg_kdx_transferencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> outCgg_kdx_transferencia = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_transferencia tmpCgg_kdx_transferencia = new com.besixplus.sii.objects.Cgg_kdx_transferencia();
				tmpCgg_kdx_transferencia.setCKTRN_CODIGO(results.getString(1));
				tmpCgg_kdx_transferencia.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_transferencia.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_transferencia.setCKTRN_NUMERO_TRANSFERENCIA(results.getString(4));
				tmpCgg_kdx_transferencia.setCKTRN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_transferencia.setCKTRN_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_INICIO(results.getInt(8));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_FIN(results.getInt(9));
				tmpCgg_kdx_transferencia.setCKTRN_OBSERVACION(results.getString(10));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD_DISPONIBLE(results.getInt(11));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO_TRANSFERENCIA(results.getInt(12));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO(results.getBoolean(13));
				outCgg_kdx_transferencia.add(tmpCgg_kdx_transferencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_transferencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_transferencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_transferencia().getCKTRN_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_transferencia().getCKPVT_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_transferencia().getCKESP_CODIGO());
			stmUpdate.setString(4, this.getCgg_kdx_transferencia().getCKTRN_NUMERO_TRANSFERENCIA());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_kdx_transferencia().getCKTRN_FECHA_RECEPCION().getTime()));
			stmUpdate.setInt(6, this.getCgg_kdx_transferencia().getCKTRN_CANTIDAD());
			stmUpdate.setBigDecimal(7, this.getCgg_kdx_transferencia().getCKTRN_PRECIO_UNITARIO());
			stmUpdate.setInt(8, this.getCgg_kdx_transferencia().getCKTRN_SERIE_INICIO());
			stmUpdate.setInt(9, this.getCgg_kdx_transferencia().getCKTRN_SERIE_FIN());
			stmUpdate.setString(10, this.getCgg_kdx_transferencia().getCKTRN_OBSERVACION());
			stmUpdate.setInt(11, this.getCgg_kdx_transferencia().getCKTRN_CANTIDAD_DISPONIBLE());
			stmUpdate.setInt(12, this.getCgg_kdx_transferencia().getCKTRN_ESTADO_TRANSFERENCIA());
			stmUpdate.setBoolean(13, this.getCgg_kdx_transferencia().getCKTRN_ESTADO());
			stmUpdate.setString(14, this.getCgg_kdx_transferencia().getCKTRN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_transferencia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_transferencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_transferencia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_transferencia().getCKTRN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_transferencia().setCKTRN_CODIGO(results.getString(1));
				this.getCgg_kdx_transferencia().setCKPVT_CODIGO(results.getString(2));
				this.getCgg_kdx_transferencia().setCKESP_CODIGO(results.getString(3));
				this.getCgg_kdx_transferencia().setCKTRN_NUMERO_TRANSFERENCIA(results.getString(4));
				this.getCgg_kdx_transferencia().setCKTRN_FECHA_RECEPCION(results.getTimestamp(5));
				this.getCgg_kdx_transferencia().setCKTRN_CANTIDAD(results.getInt(6));
				this.getCgg_kdx_transferencia().setCKTRN_PRECIO_UNITARIO(results.getBigDecimal(7));
				this.getCgg_kdx_transferencia().setCKTRN_SERIE_INICIO(results.getInt(8));
				this.getCgg_kdx_transferencia().setCKTRN_SERIE_FIN(results.getInt(9));
				this.getCgg_kdx_transferencia().setCKTRN_OBSERVACION(results.getString(10));
				this.getCgg_kdx_transferencia().setCKTRN_CANTIDAD_DISPONIBLE(results.getInt(11));
				this.getCgg_kdx_transferencia().setCKTRN_ESTADO_TRANSFERENCIA(results.getInt(12));
				this.getCgg_kdx_transferencia().setCKTRN_ESTADO(results.getBoolean(13));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_transferencia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_transferencia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_transferencia().getCKTRN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_transferencia().getCKTRN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_transferencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> selectCGG_KDX_ESPECIE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> outCgg_kdx_transferencia = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_S_CGG_KDX_ESPECIE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_transferencia().getCKESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_transferencia tmpCgg_kdx_transferencia = new com.besixplus.sii.objects.Cgg_kdx_transferencia();
				tmpCgg_kdx_transferencia.setCKTRN_CODIGO(results.getString(1));
				tmpCgg_kdx_transferencia.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_transferencia.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_transferencia.setCKTRN_NUMERO_TRANSFERENCIA(results.getString(4));
				tmpCgg_kdx_transferencia.setCKTRN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_transferencia.setCKTRN_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_INICIO(results.getInt(8));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_FIN(results.getInt(9));
				tmpCgg_kdx_transferencia.setCKTRN_OBSERVACION(results.getString(10));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD_DISPONIBLE(results.getInt(11));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO_TRANSFERENCIA(results.getInt(12));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO(results.getBoolean(13));
				outCgg_kdx_transferencia.add(tmpCgg_kdx_transferencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_D_CGG_KDX_ESPECIE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_transferencia().getCKESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_DS_CGG_KDX_ESPECIE(?) }");
				stmDelete.setString(1, this.getCgg_kdx_transferencia().getCKESP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_transferencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> selectCGG_KDX_PUNTO_VENTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> outCgg_kdx_transferencia = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_S_CGG_KDX_PUNTO_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_transferencia().getCKPVT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_transferencia tmpCgg_kdx_transferencia = new com.besixplus.sii.objects.Cgg_kdx_transferencia();
				tmpCgg_kdx_transferencia.setCKTRN_CODIGO(results.getString(1));
				tmpCgg_kdx_transferencia.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_transferencia.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_transferencia.setCKTRN_NUMERO_TRANSFERENCIA(results.getString(4));
				tmpCgg_kdx_transferencia.setCKTRN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_transferencia.setCKTRN_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_INICIO(results.getInt(8));
				tmpCgg_kdx_transferencia.setCKTRN_SERIE_FIN(results.getInt(9));
				tmpCgg_kdx_transferencia.setCKTRN_OBSERVACION(results.getString(10));
				tmpCgg_kdx_transferencia.setCKTRN_CANTIDAD_DISPONIBLE(results.getInt(11));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO_TRANSFERENCIA(results.getInt(12));
				tmpCgg_kdx_transferencia.setCKTRN_ESTADO(results.getBoolean(13));
				outCgg_kdx_transferencia.add(tmpCgg_kdx_transferencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_PUNTO_VENTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_D_CGG_KDX_PUNTO_VENTA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_transferencia().getCKPVT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_DS_CGG_KDX_PUNTO_VENTA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_transferencia().getCKPVT_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* INCLUYENDO EL NOMBRE DE LA ESPECIE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect1(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_transferencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT1(?,?,?,?,?,?) }");
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
				outCgg_kdx_transferencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}
	/**
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_kdx_transferencia
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String NUMERO DE TRANSFERENCIA SECUENCIAL
	* */
	public static String numeroTransferencia(
		java.sql.Connection inConnection
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_GENERA_NUMERO() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* INCLUYENDO EL NOMBRE DE LA ESPECIE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCkpvt_codigo 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectDisponiblePV(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCkpvt_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_transferencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT_DISPONIBLE_PV(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCkpvt_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_transferencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCkpvt_codigo CODIGO IDENTIFICATIVO DE PUNTO DE VENTA 
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountDisponiblePV(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCkpvt_codigo
	){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_COUNT_DISPONIBLE_PV(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCkpvt_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* INCLUYENDO EL NOMBRE DE LA ESPECIE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_transferencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectByPuntoVenta(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_transferencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_SELECT_PUNTO_VENTA(?,?,?,?,?,?) }");
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
				outCgg_kdx_transferencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_transferencia;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inCkpvt_codigo CODIGO IDENTIFICATIVO DE PUNTO DE VENTA 
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountByPuntoVenta(
		java.sql.Connection inConnection,
		String inKeyword,
		String inUserName
	){
		int outCount = 0;
/*		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TRANSFERENCIA_COUNT_PUNTO_VENTA(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inUserName);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String updateStock(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_TRANSFERENCIA_UPDATE_STOCK(?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_transferencia().getCKTRN_CODIGO());
			stmUpdate.setInt(2, this.getCgg_kdx_transferencia().getCKTRN_CANTIDAD());
			stmUpdate.setString(3, this.getCgg_kdx_transferencia().getCKTRN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	
	/**
	* VERIFICA SI LA SERIE INGRESADA PARA LA OPERACION ES VALIDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES.
	* @param inCkesp_codigo_verificacion IDENTIFICATIVO UNICO DE VERIFICACION DE REGISTRO DE ESPECIES 
	* @param inCkesp_tipo_control IDENTIFICADOR DEL TIPO DE CONTROL QUE SE APLICARA 0 TRANSFERENCIAS, 1 ASIGNACIONES .
	* @param inCktrn_serie_inicio SERIE DE INICIO DE LAS ESPECIES.
	* @param inCktrn_serie_fin SERIE DE FIN DE LAS ESPECIES.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String controlSerie(
		java.sql.Connection inConnection,
		String inCkesp_codigo,
		int inCkesp_tipo_control,
		int inCktrn_serie_inicio,
		int inCktrn_serie_fin
	){
		String outResult = null ;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_CONTROL_SERIES(?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmSelect.setString(2, inCkesp_codigo);
			stmSelect.setInt(3, inCkesp_tipo_control);
			stmSelect.setInt(4, inCktrn_serie_inicio);
			stmSelect.setInt(5, inCktrn_serie_fin);
			stmSelect.execute();
			outResult = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
}