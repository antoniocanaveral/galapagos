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
* CLASE Cgg_kdx_venta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_venta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_venta implements Serializable{
	private static final long serialVersionUID = 530251850;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_venta.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_venta myCgg_kdx_venta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta.
	*/
	public Cgg_kdx_venta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta.
	* @param inCgg_kdx_venta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_venta.
	*/
	public Cgg_kdx_venta(
		com.besixplus.sii.objects.Cgg_kdx_venta inCgg_kdx_venta
	){
		this.setCgg_kdx_venta(inCgg_kdx_venta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_venta.
	* @param inCgg_kdx_venta OBJETO Cgg_kdx_venta.
	* @return void
	*/
	public void setCgg_kdx_venta(com.besixplus.sii.objects.Cgg_kdx_venta inCgg_kdx_venta){
		this.myCgg_kdx_venta = inCgg_kdx_venta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_venta.
	* @return Cgg_kdx_venta OBJETO Cgg_kdx_venta.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_venta getCgg_kdx_venta(){
		return this.myCgg_kdx_venta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_INSERT(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_venta().getCKVNT_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_venta().getCKASG_CODIGO());
			stmInsert.setInt(4, this.getCgg_kdx_venta().getCKVNT_LOTE());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_kdx_venta().getCKVNT_FECHA_INGRESO().getTime()));
			stmInsert.setString(6, this.getCgg_kdx_venta().getCKVNT_NUMERO_VENTA());
			stmInsert.setInt(7, this.getCgg_kdx_venta().getCKVNT_SERIE_INICIO());
			stmInsert.setInt(8, this.getCgg_kdx_venta().getCKVNT_SERIE_FIN());
			stmInsert.setInt(9, this.getCgg_kdx_venta().getCKVNT_CANTIDAD());
			stmInsert.setString(10, this.getCgg_kdx_venta().getCKVNT_TOTAL());
			stmInsert.setInt(11, this.getCgg_kdx_venta().getCKVNT_ESTADO_VENTA());
			stmInsert.setBoolean(12, this.getCgg_kdx_venta().getCKVNT_ESTADO());
			stmInsert.setString(13, this.getCgg_kdx_venta().getCKVNT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_venta().setCKVNT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> outCgg_kdx_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta tmpCgg_kdx_venta = new com.besixplus.sii.objects.Cgg_kdx_venta();
				tmpCgg_kdx_venta.setCKVNT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_venta.setCKVNT_LOTE(results.getInt(3));
				tmpCgg_kdx_venta.setCKVNT_FECHA_INGRESO(results.getTimestamp(4));
				tmpCgg_kdx_venta.setCKVNT_NUMERO_VENTA(results.getString(5));
				tmpCgg_kdx_venta.setCKVNT_SERIE_INICIO(results.getInt(6));
				tmpCgg_kdx_venta.setCKVNT_SERIE_FIN(results.getInt(7));
				tmpCgg_kdx_venta.setCKVNT_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_venta.setCKVNT_TOTAL(results.getString(9));
				tmpCgg_kdx_venta.setCKVNT_ESTADO_VENTA(results.getInt(10));
				tmpCgg_kdx_venta.setCKVNT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta.add(tmpCgg_kdx_venta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> outCgg_kdx_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_venta tmpCgg_kdx_venta = new com.besixplus.sii.objects.Cgg_kdx_venta();
				tmpCgg_kdx_venta.setCKVNT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_venta.setCKVNT_LOTE(results.getInt(3));
				tmpCgg_kdx_venta.setCKVNT_FECHA_INGRESO(results.getTimestamp(4));
				tmpCgg_kdx_venta.setCKVNT_NUMERO_VENTA(results.getString(5));
				tmpCgg_kdx_venta.setCKVNT_SERIE_INICIO(results.getInt(6));
				tmpCgg_kdx_venta.setCKVNT_SERIE_FIN(results.getInt(7));
				tmpCgg_kdx_venta.setCKVNT_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_venta.setCKVNT_TOTAL(results.getString(9));
				tmpCgg_kdx_venta.setCKVNT_ESTADO_VENTA(results.getInt(10));
				tmpCgg_kdx_venta.setCKVNT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta.add(tmpCgg_kdx_venta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_venta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_venta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_venta().getCKVNT_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_venta().getCKASG_CODIGO());
			stmUpdate.setInt(3, this.getCgg_kdx_venta().getCKVNT_LOTE());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_kdx_venta().getCKVNT_FECHA_INGRESO().getTime()));
			stmUpdate.setString(5, this.getCgg_kdx_venta().getCKVNT_NUMERO_VENTA());
			stmUpdate.setInt(6, this.getCgg_kdx_venta().getCKVNT_SERIE_INICIO());
			stmUpdate.setInt(7, this.getCgg_kdx_venta().getCKVNT_SERIE_FIN());
			stmUpdate.setInt(8, this.getCgg_kdx_venta().getCKVNT_CANTIDAD());
			stmUpdate.setString(9, this.getCgg_kdx_venta().getCKVNT_TOTAL());
			stmUpdate.setInt(10, this.getCgg_kdx_venta().getCKVNT_ESTADO_VENTA());
			stmUpdate.setBoolean(11, this.getCgg_kdx_venta().getCKVNT_ESTADO());
			stmUpdate.setString(12, this.getCgg_kdx_venta().getCKVNT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_venta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_venta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta().getCKVNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_venta().setCKVNT_CODIGO(results.getString(1));
				this.getCgg_kdx_venta().setCKASG_CODIGO(results.getString(2));
				this.getCgg_kdx_venta().setCKVNT_LOTE(results.getInt(3));
				this.getCgg_kdx_venta().setCKVNT_FECHA_INGRESO(results.getTimestamp(4));
				this.getCgg_kdx_venta().setCKVNT_NUMERO_VENTA(results.getString(5));
				this.getCgg_kdx_venta().setCKVNT_SERIE_INICIO(results.getInt(6));
				this.getCgg_kdx_venta().setCKVNT_SERIE_FIN(results.getInt(7));
				this.getCgg_kdx_venta().setCKVNT_CANTIDAD(results.getInt(8));
				this.getCgg_kdx_venta().setCKVNT_TOTAL(results.getString(9));
				this.getCgg_kdx_venta().setCKVNT_ESTADO_VENTA(results.getInt(10));
				this.getCgg_kdx_venta().setCKVNT_ESTADO(results.getBoolean(11));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_venta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_venta DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta().getCKVNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta().getCKVNT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_asignacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> selectCGG_KDX_ASIGNACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> outCgg_kdx_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_S_CGG_KDX_ASIGNACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta().getCKASG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta tmpCgg_kdx_venta = new com.besixplus.sii.objects.Cgg_kdx_venta();
				tmpCgg_kdx_venta.setCKVNT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta.setCKASG_CODIGO(results.getString(2));
				tmpCgg_kdx_venta.setCKVNT_LOTE(results.getInt(3));
				tmpCgg_kdx_venta.setCKVNT_FECHA_INGRESO(results.getTimestamp(4));
				tmpCgg_kdx_venta.setCKVNT_NUMERO_VENTA(results.getString(5));
				tmpCgg_kdx_venta.setCKVNT_SERIE_INICIO(results.getInt(6));
				tmpCgg_kdx_venta.setCKVNT_SERIE_FIN(results.getInt(7));
				tmpCgg_kdx_venta.setCKVNT_CANTIDAD(results.getInt(8));
				tmpCgg_kdx_venta.setCKVNT_TOTAL(results.getString(9));
				tmpCgg_kdx_venta.setCKVNT_ESTADO_VENTA(results.getInt(10));
				tmpCgg_kdx_venta.setCKVNT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta.add(tmpCgg_kdx_venta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_asignacion.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_D_CGG_KDX_ASIGNACION(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta().getCKASG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DS_CGG_KDX_ASIGNACION(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta().getCKASG_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCkvnt_estado_venta ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
		0.-  REGISTRADA
		1.-  CONTABILIZADA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectByEstado(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		int inCkvnt_estado_venta
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_venta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_SELECT_BY_PUNTO_VENTA_ESTADO(?,?,?,?,?,?,?::smallint) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setInt(8, inCkvnt_estado_venta);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_venta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inCkvnt_estado_venta ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
		0.-  REGISTRADA
		1.-  CONTABILIZADA
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inUserName,
		int inCkvnt_estado_venta
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_COUNT(?,?,?::smallint) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2,inKeyword );
			stmSelect.setString(3,inUserName );
			stmSelect.setInt(4, inCkvnt_estado_venta);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
}