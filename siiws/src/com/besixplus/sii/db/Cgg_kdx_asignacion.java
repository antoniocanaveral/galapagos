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
* CLASE Cgg_kdx_asignacion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_asignacion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_asignacion implements Serializable{
	private static final long serialVersionUID = 888856974;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_asignacion.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_asignacion myCgg_kdx_asignacion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_asignacion.
	*/
	public Cgg_kdx_asignacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_asignacion.
	* @param inCgg_kdx_asignacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_asignacion.
	*/
	public Cgg_kdx_asignacion(
		com.besixplus.sii.objects.Cgg_kdx_asignacion inCgg_kdx_asignacion
	){
		this.setCgg_kdx_asignacion(inCgg_kdx_asignacion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_asignacion.
	* @param inCgg_kdx_asignacion OBJETO Cgg_kdx_asignacion.
	* @return void
	*/
	public void setCgg_kdx_asignacion(com.besixplus.sii.objects.Cgg_kdx_asignacion inCgg_kdx_asignacion){
		this.myCgg_kdx_asignacion = inCgg_kdx_asignacion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_asignacion.
	* @return Cgg_kdx_asignacion OBJETO Cgg_kdx_asignacion.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_asignacion getCgg_kdx_asignacion(){
		return this.myCgg_kdx_asignacion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_asignacion().getCKASG_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_asignacion().getCKTRN_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_asignacion().getCKUPV_CODIGO());
			stmInsert.setString(5, this.getCgg_kdx_asignacion().getCGG_CKUPV_CODIGO());
			stmInsert.setString(6, this.getCgg_kdx_asignacion().getCGG_CKASG_CODIGO());
			stmInsert.setString(7, this.getCgg_kdx_asignacion().getCKASG_NUMERO_ASIGNACION());
			stmInsert.setTimestamp(8, new java.sql.Timestamp(this.getCgg_kdx_asignacion().getCKASG_FECHA_RECEPCION().getTime()));
			stmInsert.setInt(9, this.getCgg_kdx_asignacion().getCKASG_CANTIDAD());
			stmInsert.setBigDecimal(10, this.getCgg_kdx_asignacion().getCKASG_PRECIO_UNITARIO());
			stmInsert.setInt(11, this.getCgg_kdx_asignacion().getCKASG_SERIE_INICIO());
			stmInsert.setInt(12, this.getCgg_kdx_asignacion().getCKASG_SERIE_FIN());
			stmInsert.setString(13, this.getCgg_kdx_asignacion().getCKASG_OBSERVACION());
			stmInsert.setInt(14, this.getCgg_kdx_asignacion().getCKASG_CANTIDAD_DISPONIBLE());
			stmInsert.setInt(15, this.getCgg_kdx_asignacion().getCKASG_ESTADO_ASIGNACION());
			stmInsert.setBoolean(16, this.getCgg_kdx_asignacion().getCKASG_ESTADO());
			stmInsert.setString(17, this.getCgg_kdx_asignacion().getCKASG_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_asignacion().setCKASG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> outCgg_kdx_asignacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_asignacion tmpCgg_kdx_asignacion = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
				tmpCgg_kdx_asignacion.setCKASG_CODIGO(results.getString(1));
				tmpCgg_kdx_asignacion.setCKTRN_CODIGO(results.getString(2));
				tmpCgg_kdx_asignacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_asignacion.setCGG_CKUPV_CODIGO(results.getString(4));
				tmpCgg_kdx_asignacion.setCGG_CKASG_CODIGO(results.getString(5));
				tmpCgg_kdx_asignacion.setCKASG_NUMERO_ASIGNACION(results.getString(6));
				tmpCgg_kdx_asignacion.setCKASG_FECHA_RECEPCION(results.getTimestamp(7));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_asignacion.setCKASG_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_INICIO(results.getInt(10));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_FIN(results.getInt(11));
				tmpCgg_kdx_asignacion.setCKASG_OBSERVACION(results.getString(12));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD_DISPONIBLE(results.getInt(13));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO_ASIGNACION(results.getInt(14));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO(results.getBoolean(15));
				outCgg_kdx_asignacion.add(tmpCgg_kdx_asignacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> outCgg_kdx_asignacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_asignacion tmpCgg_kdx_asignacion = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
				tmpCgg_kdx_asignacion.setCKASG_CODIGO(results.getString(1));
				tmpCgg_kdx_asignacion.setCKTRN_CODIGO(results.getString(2));
				tmpCgg_kdx_asignacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_asignacion.setCGG_CKUPV_CODIGO(results.getString(4));
				tmpCgg_kdx_asignacion.setCGG_CKASG_CODIGO(results.getString(5));
				tmpCgg_kdx_asignacion.setCKASG_NUMERO_ASIGNACION(results.getString(6));
				tmpCgg_kdx_asignacion.setCKASG_FECHA_RECEPCION(results.getTimestamp(7));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_asignacion.setCKASG_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_INICIO(results.getInt(10));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_FIN(results.getInt(11));
				tmpCgg_kdx_asignacion.setCKASG_OBSERVACION(results.getString(12));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD_DISPONIBLE(results.getInt(13));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO_ASIGNACION(results.getInt(14));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO(results.getBoolean(15));
				outCgg_kdx_asignacion.add(tmpCgg_kdx_asignacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_asignacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_asignacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_asignacion().getCKASG_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_asignacion().getCKTRN_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_asignacion().getCKUPV_CODIGO());
			stmUpdate.setString(4, this.getCgg_kdx_asignacion().getCGG_CKUPV_CODIGO());
			stmUpdate.setString(5, this.getCgg_kdx_asignacion().getCGG_CKASG_CODIGO());
			stmUpdate.setString(6, this.getCgg_kdx_asignacion().getCKASG_NUMERO_ASIGNACION());
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_kdx_asignacion().getCKASG_FECHA_RECEPCION().getTime()));
			stmUpdate.setInt(8, this.getCgg_kdx_asignacion().getCKASG_CANTIDAD());
			stmUpdate.setBigDecimal(9, this.getCgg_kdx_asignacion().getCKASG_PRECIO_UNITARIO());
			stmUpdate.setInt(10, this.getCgg_kdx_asignacion().getCKASG_SERIE_INICIO());
			stmUpdate.setInt(11, this.getCgg_kdx_asignacion().getCKASG_SERIE_FIN());
			stmUpdate.setString(12, this.getCgg_kdx_asignacion().getCKASG_OBSERVACION());
			stmUpdate.setInt(13, this.getCgg_kdx_asignacion().getCKASG_CANTIDAD_DISPONIBLE());
			stmUpdate.setInt(14, this.getCgg_kdx_asignacion().getCKASG_ESTADO_ASIGNACION());
			stmUpdate.setBoolean(15, this.getCgg_kdx_asignacion().getCKASG_ESTADO());
			stmUpdate.setString(16, this.getCgg_kdx_asignacion().getCKASG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_asignacion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_asignacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_asignacion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_asignacion().getCKASG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_asignacion().setCKASG_CODIGO(results.getString(1));
				this.getCgg_kdx_asignacion().setCKTRN_CODIGO(results.getString(2));
				this.getCgg_kdx_asignacion().setCKUPV_CODIGO(results.getString(3));
				this.getCgg_kdx_asignacion().setCGG_CKUPV_CODIGO(results.getString(4));
				this.getCgg_kdx_asignacion().setCGG_CKASG_CODIGO(results.getString(5));
				this.getCgg_kdx_asignacion().setCKASG_NUMERO_ASIGNACION(results.getString(6));
				this.getCgg_kdx_asignacion().setCKASG_FECHA_RECEPCION(results.getTimestamp(7));
				this.getCgg_kdx_asignacion().setCKASG_CANTIDAD(results.getInt(8));
				this.getCgg_kdx_asignacion().setCKASG_PRECIO_UNITARIO(results.getBigDecimal(9));
				this.getCgg_kdx_asignacion().setCKASG_SERIE_INICIO(results.getInt(10));
				this.getCgg_kdx_asignacion().setCKASG_SERIE_FIN(results.getInt(11));
				this.getCgg_kdx_asignacion().setCKASG_OBSERVACION(results.getString(12));
				this.getCgg_kdx_asignacion().setCKASG_CANTIDAD_DISPONIBLE(results.getInt(13));
				this.getCgg_kdx_asignacion().setCKASG_ESTADO_ASIGNACION(results.getInt(14));
				this.getCgg_kdx_asignacion().setCKASG_ESTADO(results.getBoolean(15));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_asignacion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_asignacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_asignacion().getCKASG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_asignacion().getCKASG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_asignacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> selectCGG_KDX_ASIGNACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> outCgg_kdx_asignacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_S_CGG_KDX_ASIGNACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_asignacion().getCGG_CKASG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_asignacion tmpCgg_kdx_asignacion = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
				tmpCgg_kdx_asignacion.setCKASG_CODIGO(results.getString(1));
				tmpCgg_kdx_asignacion.setCKTRN_CODIGO(results.getString(2));
				tmpCgg_kdx_asignacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_asignacion.setCGG_CKUPV_CODIGO(results.getString(4));
				tmpCgg_kdx_asignacion.setCGG_CKASG_CODIGO(results.getString(5));
				tmpCgg_kdx_asignacion.setCKASG_NUMERO_ASIGNACION(results.getString(6));
				tmpCgg_kdx_asignacion.setCKASG_FECHA_RECEPCION(results.getTimestamp(7));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_asignacion.setCKASG_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_INICIO(results.getInt(10));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_FIN(results.getInt(11));
				tmpCgg_kdx_asignacion.setCKASG_OBSERVACION(results.getString(12));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD_DISPONIBLE(results.getInt(13));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO_ASIGNACION(results.getInt(14));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO(results.getBoolean(15));
				outCgg_kdx_asignacion.add(tmpCgg_kdx_asignacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_ASIGNACION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_D_CGG_KDX_ASIGNACION(?) }");
			stmDelete.setString(1, this.getCgg_kdx_asignacion().getCGG_CKASG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_DS_CGG_KDX_ASIGNACION(?) }");
				stmDelete.setString(1, this.getCgg_kdx_asignacion().getCGG_CKASG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_asignacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> selectCGG_KDX_TRANSFERENCIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> outCgg_kdx_asignacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_S_CGG_KDX_TRANSFERENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_asignacion().getCKTRN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_asignacion tmpCgg_kdx_asignacion = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
				tmpCgg_kdx_asignacion.setCKASG_CODIGO(results.getString(1));
				tmpCgg_kdx_asignacion.setCKTRN_CODIGO(results.getString(2));
				tmpCgg_kdx_asignacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_asignacion.setCGG_CKUPV_CODIGO(results.getString(4));
				tmpCgg_kdx_asignacion.setCGG_CKASG_CODIGO(results.getString(5));
				tmpCgg_kdx_asignacion.setCKASG_NUMERO_ASIGNACION(results.getString(6));
				tmpCgg_kdx_asignacion.setCKASG_FECHA_RECEPCION(results.getTimestamp(7));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_asignacion.setCKASG_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_INICIO(results.getInt(10));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_FIN(results.getInt(11));
				tmpCgg_kdx_asignacion.setCKASG_OBSERVACION(results.getString(12));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD_DISPONIBLE(results.getInt(13));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO_ASIGNACION(results.getInt(14));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO(results.getBoolean(15));
				outCgg_kdx_asignacion.add(tmpCgg_kdx_asignacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_transferencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_TRANSFERENCIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_D_CGG_KDX_TRANSFERENCIA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_asignacion().getCKTRN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_DS_CGG_KDX_TRANSFERENCIA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_asignacion().getCKTRN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_asignacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> selectCGG_KDX_USUARIO_PV(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> outCgg_kdx_asignacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_S_CGG_KDX_USUARIO_PV(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_asignacion().getCGG_CKUPV_CODIGO());
			stmSelect.setString(3,this.getCgg_kdx_asignacion().getCKUPV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_asignacion tmpCgg_kdx_asignacion = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
				tmpCgg_kdx_asignacion.setCKASG_CODIGO(results.getString(1));
				tmpCgg_kdx_asignacion.setCKTRN_CODIGO(results.getString(2));
				tmpCgg_kdx_asignacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_asignacion.setCGG_CKUPV_CODIGO(results.getString(4));
				tmpCgg_kdx_asignacion.setCGG_CKASG_CODIGO(results.getString(5));
				tmpCgg_kdx_asignacion.setCKASG_NUMERO_ASIGNACION(results.getString(6));
				tmpCgg_kdx_asignacion.setCKASG_FECHA_RECEPCION(results.getTimestamp(7));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_asignacion.setCKASG_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_INICIO(results.getInt(10));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_FIN(results.getInt(11));
				tmpCgg_kdx_asignacion.setCKASG_OBSERVACION(results.getString(12));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD_DISPONIBLE(results.getInt(13));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO_ASIGNACION(results.getInt(14));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO(results.getBoolean(15));
				outCgg_kdx_asignacion.add(tmpCgg_kdx_asignacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_USUARIO_PV(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_D_CGG_KDX_USUARIO_PV(?, ?) }");
			stmDelete.setString(1, this.getCgg_kdx_asignacion().getCGG_CKUPV_CODIGO());
			stmDelete.setString(2, this.getCgg_kdx_asignacion().getCKUPV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_DS_CGG_KDX_USUARIO_PV(?, ?) }");
				stmDelete.setString(1, this.getCgg_kdx_asignacion().getCGG_CKUPV_CODIGO());
				stmDelete.setString(2, this.getCgg_kdx_asignacion().getCKUPV_CODIGO());
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
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_kdx_asignacion
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String NUMERO DE ASIGNACION SECUENCIAL.
	*/
	public String numeroAsignacion(
		java.sql.Connection inConnection
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_GENERA_NUMERO(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);	
			stmSelect.setString(2,this.getCgg_kdx_asignacion().getCKASG_USUARIO_INSERT());
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv., POR USUARIO QUE RECIBE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_asignacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> selectCGG_KDX_USUARIO_RECIBE_PV(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> outCgg_kdx_asignacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_S_CGG_KDX_USUARIO_RECIBE_PV(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_asignacion().getCGG_CKUPV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_asignacion tmpCgg_kdx_asignacion = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
				tmpCgg_kdx_asignacion.setCKASG_CODIGO(results.getString(1));
				tmpCgg_kdx_asignacion.setCKTRN_CODIGO(results.getString(2));
				tmpCgg_kdx_asignacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_asignacion.setCGG_CKUPV_CODIGO(results.getString(4));
				tmpCgg_kdx_asignacion.setCKASG_NUMERO_ASIGNACION(results.getString(5));
				tmpCgg_kdx_asignacion.setCKASG_FECHA_RECEPCION(results.getTimestamp(6));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_asignacion.setCKASG_PRECIO_UNITARIO(results.getBigDecimal(8));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_INICIO(results.getInt(9));
				tmpCgg_kdx_asignacion.setCKASG_SERIE_FIN(results.getInt(10));
				tmpCgg_kdx_asignacion.setCKASG_CANTIDAD_DISPONIBLE(results.getInt(11));
				tmpCgg_kdx_asignacion.setCKASG_ESTADO(results.getBoolean(12));
				outCgg_kdx_asignacion.add(tmpCgg_kdx_asignacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}
	/**
	* OBTIENE INFORMACION DEL PUNTO DE VENTA, EN FUNCION DEL NOMBRE DE USUARIO
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectUsuarioPuntoVenta(
		java.sql.Connection inConnection,
		String inUserName		
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_asignacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_SELECT_PUNTO_VENTA_DATOS_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_asignacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_asignacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_SELECT1(?,?,?,?,?,?) }");
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
				outCgg_kdx_asignacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_asignacion;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* INCLUYENDO EL NOMBRE DE LA ESPECIE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCgg_Ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectUsuarioRecibePV(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCgg_Ckupv_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_transferencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_S_CGG_KDX_USUARIO_RECIBE_PV(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCgg_Ckupv_codigo);
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
	 * @param inCgg_Ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	* @param inCkpvt_codigo CODIGO IDENTIFICATIVO DE PUNTO DE VENTA 
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountUsuarioRecibePV(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCgg_Ckupv_codigo
	){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ASIGNACION_COUNT_USUARIO_RECIBE_PV(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCgg_Ckupv_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}


	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String updateEstado(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_ASIGNACION_UPDATE_ESTADO(?,?::smallint,?) }");
			stmUpdate.setString(1, this.getCgg_kdx_asignacion().getCKASG_CODIGO());
			stmUpdate.setInt(2, this.getCgg_kdx_asignacion().getCKASG_ESTADO_ASIGNACION());
			stmUpdate.setString(3, this.getCgg_kdx_asignacion().getCKASG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inUserName CODIGO IDENTIFICATIVO DEL USUARIO
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountAsignacionPV(
		java.sql.Connection inConnection,
		String inKeyword,
		String inUserName
	){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_ASIGNACION_COUNT_PV(?,?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* INCLUYENDO EL NOMBRE DE LA ESPECIE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAsignacionPV(
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_ASIGNACION_SELECT_PV(?,?,?,?,?,?) }");
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
	* @param inUserName CODIGO IDENTIFICATIVO DEL USUARIO
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountStockPV(
		java.sql.Connection inConnection,
		String inKeyword,
		String inUserName
	){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_ASIGNACION_COUNT_STOCK_PV(?,?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* INCLUYENDO EL NOMBRE DE LA ESPECIE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectStockPV(
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_ASIGNACION_SELECT_STOCK_PV(?,?,?,?,?,?) }");
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
	
}