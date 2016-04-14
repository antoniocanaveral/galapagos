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
* CLASE Cgg_kdx_vd_denominacion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_vd_denominacion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_vd_denominacion implements Serializable{
	private static final long serialVersionUID = 430344971;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_vd_denominacion.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_vd_denominacion myCgg_kdx_vd_denominacion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_vd_denominacion.
	*/
	public Cgg_kdx_vd_denominacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_vd_denominacion.
	* @param inCgg_kdx_vd_denominacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_vd_denominacion.
	*/
	public Cgg_kdx_vd_denominacion(
		com.besixplus.sii.objects.Cgg_kdx_vd_denominacion inCgg_kdx_vd_denominacion
	){
		this.setCgg_kdx_vd_denominacion(inCgg_kdx_vd_denominacion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_vd_denominacion.
	* @param inCgg_kdx_vd_denominacion OBJETO Cgg_kdx_vd_denominacion.
	* @return void
	*/
	public void setCgg_kdx_vd_denominacion(com.besixplus.sii.objects.Cgg_kdx_vd_denominacion inCgg_kdx_vd_denominacion){
		this.myCgg_kdx_vd_denominacion = inCgg_kdx_vd_denominacion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_vd_denominacion.
	* @return Cgg_kdx_vd_denominacion OBJETO Cgg_kdx_vd_denominacion.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_vd_denominacion getCgg_kdx_vd_denominacion(){
		return this.myCgg_kdx_vd_denominacion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_vd_denominacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_INSERT(?, ?, ?, ?::smallint, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_vd_denominacion().getCKVDD_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_vd_denominacion().getCKVNT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_vd_denominacion().getCKDNM_CODIGO());
			stmInsert.setInt(5, this.getCgg_kdx_vd_denominacion().getCKVDD_CANTIDAD());
			stmInsert.setBigDecimal(6, this.getCgg_kdx_vd_denominacion().getCKVDD_VALOR());
			stmInsert.setBigDecimal(7, this.getCgg_kdx_vd_denominacion().getCKVDD_TOTAL());
			stmInsert.setBoolean(8, this.getCgg_kdx_vd_denominacion().getCKVDD_ESTADO());
			stmInsert.setString(9, this.getCgg_kdx_vd_denominacion().getCKVDD_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_kdx_vd_denominacion().getCKVDD_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_kdx_vd_denominacion().setCKVDD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> outCgg_kdx_vd_denominacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_vd_denominacion tmpCgg_kdx_vd_denominacion = new com.besixplus.sii.objects.Cgg_kdx_vd_denominacion();
				tmpCgg_kdx_vd_denominacion.setCKVDD_CODIGO(results.getString(1));
				tmpCgg_kdx_vd_denominacion.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_vd_denominacion.setCKDNM_CODIGO(results.getString(3));
				tmpCgg_kdx_vd_denominacion.setCKVDD_CANTIDAD(results.getInt(4));
				tmpCgg_kdx_vd_denominacion.setCKVDD_VALOR(results.getBigDecimal(5));
				tmpCgg_kdx_vd_denominacion.setCKVDD_TOTAL(results.getBigDecimal(6));
				tmpCgg_kdx_vd_denominacion.setCKVDD_ESTADO(results.getBoolean(7));
				outCgg_kdx_vd_denominacion.add(tmpCgg_kdx_vd_denominacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_vd_denominacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> outCgg_kdx_vd_denominacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_vd_denominacion tmpCgg_kdx_vd_denominacion = new com.besixplus.sii.objects.Cgg_kdx_vd_denominacion();
				tmpCgg_kdx_vd_denominacion.setCKVDD_CODIGO(results.getString(1));
				tmpCgg_kdx_vd_denominacion.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_vd_denominacion.setCKDNM_CODIGO(results.getString(3));
				tmpCgg_kdx_vd_denominacion.setCKVDD_CANTIDAD(results.getInt(4));
				tmpCgg_kdx_vd_denominacion.setCKVDD_VALOR(results.getBigDecimal(5));
				tmpCgg_kdx_vd_denominacion.setCKVDD_TOTAL(results.getBigDecimal(6));
				tmpCgg_kdx_vd_denominacion.setCKVDD_ESTADO(results.getBoolean(7));
				outCgg_kdx_vd_denominacion.add(tmpCgg_kdx_vd_denominacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_vd_denominacion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_vd_denominacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_vd_denominacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_vd_denominacion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_vd_denominacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_vd_denominacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_UPDATE(?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_vd_denominacion().getCKVDD_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_vd_denominacion().getCKVNT_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_vd_denominacion().getCKDNM_CODIGO());
			stmUpdate.setInt(4, this.getCgg_kdx_vd_denominacion().getCKVDD_CANTIDAD());
			stmUpdate.setBigDecimal(5, this.getCgg_kdx_vd_denominacion().getCKVDD_VALOR());
			stmUpdate.setBigDecimal(6, this.getCgg_kdx_vd_denominacion().getCKVDD_TOTAL());
			stmUpdate.setBoolean(7, this.getCgg_kdx_vd_denominacion().getCKVDD_ESTADO());
			stmUpdate.setString(8, this.getCgg_kdx_vd_denominacion().getCKVDD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_vd_denominacion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_vd_denominacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_vd_denominacion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_vd_denominacion().getCKVDD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_vd_denominacion().setCKVDD_CODIGO(results.getString(1));
				this.getCgg_kdx_vd_denominacion().setCKVNT_CODIGO(results.getString(2));
				this.getCgg_kdx_vd_denominacion().setCKDNM_CODIGO(results.getString(3));
				this.getCgg_kdx_vd_denominacion().setCKVDD_CANTIDAD(results.getInt(4));
				this.getCgg_kdx_vd_denominacion().setCKVDD_VALOR(results.getBigDecimal(5));
				this.getCgg_kdx_vd_denominacion().setCKVDD_TOTAL(results.getBigDecimal(6));
				this.getCgg_kdx_vd_denominacion().setCKVDD_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_vd_denominacion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_vd_denominacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_vd_denominacion().getCKVDD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_vd_denominacion().getCKVDD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_vd_denominacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> selectCGG_KDX_VENTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> outCgg_kdx_vd_denominacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_S_CGG_KDX_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_vd_denominacion().getCKVNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_vd_denominacion tmpCgg_kdx_vd_denominacion = new com.besixplus.sii.objects.Cgg_kdx_vd_denominacion();
				tmpCgg_kdx_vd_denominacion.setCKVDD_CODIGO(results.getString(1));
				tmpCgg_kdx_vd_denominacion.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_vd_denominacion.setCKDNM_CODIGO(results.getString(3));
				tmpCgg_kdx_vd_denominacion.setCKVDD_CANTIDAD(results.getInt(4));
				tmpCgg_kdx_vd_denominacion.setCKVDD_VALOR(results.getBigDecimal(5));
				tmpCgg_kdx_vd_denominacion.setCKVDD_TOTAL(results.getBigDecimal(6));
				tmpCgg_kdx_vd_denominacion.setCKVDD_ESTADO(results.getBoolean(7));
				outCgg_kdx_vd_denominacion.add(tmpCgg_kdx_vd_denominacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_vd_denominacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_VENTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_VENTA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_vd_denominacion().getCKVNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_DS_CGG_KDX_VENTA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_vd_denominacion().getCKVNT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_denominacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_vd_denominacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> selectCGG_KDX_DENOMINACION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion> outCgg_kdx_vd_denominacion = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_vd_denominacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VD_DENOMINACION_S_CGG_KDX_DENOMINACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_vd_denominacion().getCKDNM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_vd_denominacion tmpCgg_kdx_vd_denominacion = new com.besixplus.sii.objects.Cgg_kdx_vd_denominacion();
				tmpCgg_kdx_vd_denominacion.setCKVDD_CODIGO(results.getString(1));
				tmpCgg_kdx_vd_denominacion.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_vd_denominacion.setCKDNM_CODIGO(results.getString(3));
				tmpCgg_kdx_vd_denominacion.setCKVDD_CANTIDAD(results.getInt(4));
				tmpCgg_kdx_vd_denominacion.setCKVDD_VALOR(results.getBigDecimal(5));
				tmpCgg_kdx_vd_denominacion.setCKVDD_TOTAL(results.getBigDecimal(6));
				tmpCgg_kdx_vd_denominacion.setCKVDD_ESTADO(results.getBoolean(7));
				outCgg_kdx_vd_denominacion.add(tmpCgg_kdx_vd_denominacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_vd_denominacion;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_vd_denominacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_denominacion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_DENOMINACION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_DENOMINACION(?) }");
			stmDelete.setString(1, this.getCgg_kdx_vd_denominacion().getCKDNM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VD_DENOMINACION_DS_CGG_KDX_DENOMINACION(?) }");
				stmDelete.setString(1, this.getCgg_kdx_vd_denominacion().getCKDNM_CODIGO());
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