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
* CLASE Cgg_kdx_anulacion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_anulacion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_anulacion implements Serializable{
	private static final long serialVersionUID = 1221885518;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_anulacion.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_anulacion myCgg_kdx_anulacion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_anulacion.
	*/
	public Cgg_kdx_anulacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_anulacion.
	* @param inCgg_kdx_anulacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_anulacion.
	*/
	public Cgg_kdx_anulacion(
		com.besixplus.sii.objects.Cgg_kdx_anulacion inCgg_kdx_anulacion
	){
		this.setCgg_kdx_anulacion(inCgg_kdx_anulacion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_anulacion.
	* @param inCgg_kdx_anulacion OBJETO Cgg_kdx_anulacion.
	* @return void
	*/
	public void setCgg_kdx_anulacion(com.besixplus.sii.objects.Cgg_kdx_anulacion inCgg_kdx_anulacion){
		this.myCgg_kdx_anulacion = inCgg_kdx_anulacion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_anulacion.
	* @return Cgg_kdx_anulacion OBJETO Cgg_kdx_anulacion.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_anulacion getCgg_kdx_anulacion(){
		return this.myCgg_kdx_anulacion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_anulacion().getCKANL_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_anulacion().getCKASG_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_anulacion().getCKUPV_CODIGO());
			stmInsert.setString(5, this.getCgg_kdx_anulacion().getCKANL_NUMERO_ANULACION());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_kdx_anulacion().getCKANL_FECHA_ANULACION().getTime()));
			stmInsert.setInt(7, this.getCgg_kdx_anulacion().getCKANL_CANTIDAD());
			stmInsert.setBigDecimal(8, this.getCgg_kdx_anulacion().getCKANL_PRECIO_UNITARIO());
			stmInsert.setBigDecimal(9, this.getCgg_kdx_anulacion().getCKANL_PRECIO_TOTAL());
			stmInsert.setInt(10, this.getCgg_kdx_anulacion().getCKANL_SERIE_INICIO());
			stmInsert.setInt(11, this.getCgg_kdx_anulacion().getCKANL_SERIE_FIN());
			stmInsert.setString(12, this.getCgg_kdx_anulacion().getCKANL_OBSERVACION());
			stmInsert.setString(13, this.getCgg_kdx_anulacion().getCKANL_JUSTIFICACION());
			stmInsert.setInt(14, this.getCgg_kdx_anulacion().getCKANL_TIPO_ANULACION());
			stmInsert.setInt(15, this.getCgg_kdx_anulacion().getCKANL_ESTADO_ANULACION());
			stmInsert.setBoolean(16, this.getCgg_kdx_anulacion().getCKANL_ESTADO());
			stmInsert.setString(17, this.getCgg_kdx_anulacion().getCKANL_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_anulacion().setCKANL_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> outCgg_kdx_anulacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_anulacion tmpCgg_kdx_anulacion = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
				tmpCgg_kdx_anulacion.setCKANL_CODIGO(results.getString(1));
				tmpCgg_kdx_anulacion.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_anulacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_anulacion.setCKANL_NUMERO_ANULACION(results.getString(4));
				tmpCgg_kdx_anulacion.setCKANL_FECHA_ANULACION(results.getTimestamp(5));
				tmpCgg_kdx_anulacion.setCKANL_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_INICIO(results.getInt(9));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_FIN(results.getInt(10));
				tmpCgg_kdx_anulacion.setCKANL_OBSERVACION(results.getString(11));
				tmpCgg_kdx_anulacion.setCKANL_JUSTIFICACION(results.getString(12));
				tmpCgg_kdx_anulacion.setCKANL_TIPO_ANULACION(results.getInt(13));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO_ANULACION(results.getInt(14));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO(results.getBoolean(15));
				outCgg_kdx_anulacion.add(tmpCgg_kdx_anulacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_anulacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> outCgg_kdx_anulacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_anulacion tmpCgg_kdx_anulacion = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
				tmpCgg_kdx_anulacion.setCKANL_CODIGO(results.getString(1));
				tmpCgg_kdx_anulacion.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_anulacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_anulacion.setCKANL_NUMERO_ANULACION(results.getString(4));
				tmpCgg_kdx_anulacion.setCKANL_FECHA_ANULACION(results.getTimestamp(5));
				tmpCgg_kdx_anulacion.setCKANL_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_INICIO(results.getInt(9));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_FIN(results.getInt(10));
				tmpCgg_kdx_anulacion.setCKANL_OBSERVACION(results.getString(11));
				tmpCgg_kdx_anulacion.setCKANL_JUSTIFICACION(results.getString(12));
				tmpCgg_kdx_anulacion.setCKANL_TIPO_ANULACION(results.getInt(13));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO_ANULACION(results.getInt(14));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO(results.getBoolean(15));
				outCgg_kdx_anulacion.add(tmpCgg_kdx_anulacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_anulacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_anulacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_anulacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_anulacion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_anulacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_anulacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_anulacion().getCKANL_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_anulacion().getCKASG_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_anulacion().getCKUPV_CODIGO());
			stmUpdate.setString(4, this.getCgg_kdx_anulacion().getCKANL_NUMERO_ANULACION());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_kdx_anulacion().getCKANL_FECHA_ANULACION().getTime()));
			stmUpdate.setInt(6, this.getCgg_kdx_anulacion().getCKANL_CANTIDAD());
			stmUpdate.setBigDecimal(7, this.getCgg_kdx_anulacion().getCKANL_PRECIO_UNITARIO());
			stmUpdate.setBigDecimal(8, this.getCgg_kdx_anulacion().getCKANL_PRECIO_TOTAL());
			stmUpdate.setInt(9, this.getCgg_kdx_anulacion().getCKANL_SERIE_INICIO());
			stmUpdate.setInt(10, this.getCgg_kdx_anulacion().getCKANL_SERIE_FIN());
			stmUpdate.setString(11, this.getCgg_kdx_anulacion().getCKANL_OBSERVACION());
			stmUpdate.setString(12, this.getCgg_kdx_anulacion().getCKANL_JUSTIFICACION());
			stmUpdate.setInt(13, this.getCgg_kdx_anulacion().getCKANL_TIPO_ANULACION());
			stmUpdate.setInt(14, this.getCgg_kdx_anulacion().getCKANL_ESTADO_ANULACION());
			stmUpdate.setBoolean(15, this.getCgg_kdx_anulacion().getCKANL_ESTADO());
			stmUpdate.setString(16, this.getCgg_kdx_anulacion().getCKANL_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_anulacion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_anulacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_anulacion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_anulacion().getCKANL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_anulacion().setCKANL_CODIGO(results.getString(1));
				this.getCgg_kdx_anulacion().setCKASG_CODIGO(results.getString(2));
				this.getCgg_kdx_anulacion().setCKUPV_CODIGO(results.getString(3));
				this.getCgg_kdx_anulacion().setCKANL_NUMERO_ANULACION(results.getString(4));
				this.getCgg_kdx_anulacion().setCKANL_FECHA_ANULACION(results.getTimestamp(5));
				this.getCgg_kdx_anulacion().setCKANL_CANTIDAD(results.getInt(6));
				this.getCgg_kdx_anulacion().setCKANL_PRECIO_UNITARIO(results.getBigDecimal(7));
				this.getCgg_kdx_anulacion().setCKANL_PRECIO_TOTAL(results.getBigDecimal(8));
				this.getCgg_kdx_anulacion().setCKANL_SERIE_INICIO(results.getInt(9));
				this.getCgg_kdx_anulacion().setCKANL_SERIE_FIN(results.getInt(10));
				this.getCgg_kdx_anulacion().setCKANL_OBSERVACION(results.getString(11));
				this.getCgg_kdx_anulacion().setCKANL_JUSTIFICACION(results.getString(12));
				this.getCgg_kdx_anulacion().setCKANL_TIPO_ANULACION(results.getInt(13));
				this.getCgg_kdx_anulacion().setCKANL_ESTADO_ANULACION(results.getInt(14));
				this.getCgg_kdx_anulacion().setCKANL_ESTADO(results.getBoolean(15));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_anulacion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_anulacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_anulacion().getCKANL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_anulacion().getCKANL_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_anulacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> selectCGG_KDX_ASIGNACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> outCgg_kdx_anulacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_S_CGG_KDX_ASIGNACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_anulacion().getCKASG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_anulacion tmpCgg_kdx_anulacion = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
				tmpCgg_kdx_anulacion.setCKANL_CODIGO(results.getString(1));
				tmpCgg_kdx_anulacion.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_anulacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_anulacion.setCKANL_NUMERO_ANULACION(results.getString(4));
				tmpCgg_kdx_anulacion.setCKANL_FECHA_ANULACION(results.getTimestamp(5));
				tmpCgg_kdx_anulacion.setCKANL_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_INICIO(results.getInt(9));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_FIN(results.getInt(10));
				tmpCgg_kdx_anulacion.setCKANL_OBSERVACION(results.getString(11));
				tmpCgg_kdx_anulacion.setCKANL_JUSTIFICACION(results.getString(12));
				tmpCgg_kdx_anulacion.setCKANL_TIPO_ANULACION(results.getInt(13));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO_ANULACION(results.getInt(14));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO(results.getBoolean(15));
				outCgg_kdx_anulacion.add(tmpCgg_kdx_anulacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_anulacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_asignacion.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_D_CGG_KDX_ASIGNACION(?) }");
			stmDelete.setString(1, this.getCgg_kdx_anulacion().getCKASG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_DS_CGG_KDX_ASIGNACION(?) }");
				stmDelete.setString(1, this.getCgg_kdx_anulacion().getCKASG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_anulacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> selectCGG_KDX_USUARIO_PV(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> outCgg_kdx_anulacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_S_CGG_KDX_USUARIO_PV(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_anulacion().getCKUPV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_anulacion tmpCgg_kdx_anulacion = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
				tmpCgg_kdx_anulacion.setCKANL_CODIGO(results.getString(1));
				tmpCgg_kdx_anulacion.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_anulacion.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_anulacion.setCKANL_NUMERO_ANULACION(results.getString(4));
				tmpCgg_kdx_anulacion.setCKANL_FECHA_ANULACION(results.getTimestamp(5));
				tmpCgg_kdx_anulacion.setCKANL_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_anulacion.setCKANL_PRECIO_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_INICIO(results.getInt(9));
				tmpCgg_kdx_anulacion.setCKANL_SERIE_FIN(results.getInt(10));
				tmpCgg_kdx_anulacion.setCKANL_OBSERVACION(results.getString(11));
				tmpCgg_kdx_anulacion.setCKANL_JUSTIFICACION(results.getString(12));
				tmpCgg_kdx_anulacion.setCKANL_TIPO_ANULACION(results.getInt(13));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO_ANULACION(results.getInt(14));
				tmpCgg_kdx_anulacion.setCKANL_ESTADO(results.getBoolean(15));
				outCgg_kdx_anulacion.add(tmpCgg_kdx_anulacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_anulacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_D_CGG_KDX_USUARIO_PV(?) }");
			stmDelete.setString(1, this.getCgg_kdx_anulacion().getCKUPV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ANULACION_DS_CGG_KDX_USUARIO_PV(?) }");
				stmDelete.setString(1, this.getCgg_kdx_anulacion().getCKUPV_CODIGO());
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
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion Y ACTUALIZA EL STOCK DISPONIBLE EN CGG_KDX_ASIGNACION.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert1(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ANULACION_INSERT1(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_anulacion().getCKANL_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_anulacion().getCKASG_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_anulacion().getCKUPV_CODIGO());
			stmInsert.setString(5, this.getCgg_kdx_anulacion().getCKANL_NUMERO_ANULACION());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_kdx_anulacion().getCKANL_FECHA_ANULACION().getTime()));
			stmInsert.setInt(7, this.getCgg_kdx_anulacion().getCKANL_CANTIDAD());
			stmInsert.setBigDecimal(8, this.getCgg_kdx_anulacion().getCKANL_PRECIO_UNITARIO());
			stmInsert.setBigDecimal(9, this.getCgg_kdx_anulacion().getCKANL_PRECIO_TOTAL());
			stmInsert.setInt(10, this.getCgg_kdx_anulacion().getCKANL_SERIE_INICIO());
			stmInsert.setInt(11, this.getCgg_kdx_anulacion().getCKANL_SERIE_FIN());
			stmInsert.setString(12, this.getCgg_kdx_anulacion().getCKANL_OBSERVACION());
			stmInsert.setString(13, this.getCgg_kdx_anulacion().getCKANL_JUSTIFICACION());
			stmInsert.setInt(14, this.getCgg_kdx_anulacion().getCKANL_TIPO_ANULACION());
			stmInsert.setInt(15, this.getCgg_kdx_anulacion().getCKANL_ESTADO_ANULACION());
			stmInsert.setBoolean(16, this.getCgg_kdx_anulacion().getCKANL_ESTADO());
			stmInsert.setString(17, this.getCgg_kdx_anulacion().getCKANL_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_anulacion().setCKANL_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_kdx_anulacion
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String Numero de anulacion secuencial.
	* */
	public static String numeroAnulacion(
		java.sql.Connection inConnection
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_ANULACION_GENERA_NUMERO() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
}