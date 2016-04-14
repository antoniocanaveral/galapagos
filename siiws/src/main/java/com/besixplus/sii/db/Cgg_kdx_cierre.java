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
* CLASE Cgg_kdx_cierre
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_cierre.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_cierre implements Serializable{
	private static final long serialVersionUID = 1546111667;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_cierre.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_cierre myCgg_kdx_cierre = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_cierre.
	*/
	public Cgg_kdx_cierre(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_cierre.
	* @param inCgg_kdx_cierre OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_cierre.
	*/
	public Cgg_kdx_cierre(
		com.besixplus.sii.objects.Cgg_kdx_cierre inCgg_kdx_cierre
	){
		this.setCgg_kdx_cierre(inCgg_kdx_cierre);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_cierre.
	* @param inCgg_kdx_cierre OBJETO Cgg_kdx_cierre.
	* @return void
	*/
	public void setCgg_kdx_cierre(com.besixplus.sii.objects.Cgg_kdx_cierre inCgg_kdx_cierre){
		this.myCgg_kdx_cierre = inCgg_kdx_cierre;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_cierre.
	* @return Cgg_kdx_cierre OBJETO Cgg_kdx_cierre.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_cierre getCgg_kdx_cierre(){
		return this.myCgg_kdx_cierre;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_cierre().getCKCRR_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_cierre().getCKPVT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_cierre().getCKUPV_CODIGO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_kdx_cierre().getCKCRR_FECHA_CIERRE().getTime()));
			stmInsert.setString(6, this.getCgg_kdx_cierre().getCKCRR_NUMERO_CIERRE());
			stmInsert.setBigDecimal(7, this.getCgg_kdx_cierre().getCKCRR_TOTAL_VENTA());
			stmInsert.setBigDecimal(8, this.getCgg_kdx_cierre().getCKCRR_TOTAL());
			stmInsert.setString(9, this.getCgg_kdx_cierre().getCKCRR_OBSERVACION());
			stmInsert.setBigDecimal(10, this.getCgg_kdx_cierre().getCKCRR_DIFERENCIA());
			stmInsert.setInt(11, this.getCgg_kdx_cierre().getCKCRR_ESTADO_CIERRE());
			stmInsert.setBoolean(12, this.getCgg_kdx_cierre().getCKCRR_ESTADO());
			stmInsert.setString(13, this.getCgg_kdx_cierre().getCKCRR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_cierre().setCKCRR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> outCgg_kdx_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_cierre tmpCgg_kdx_cierre = new com.besixplus.sii.objects.Cgg_kdx_cierre();
				tmpCgg_kdx_cierre.setCKCRR_CODIGO(results.getString(1));
				tmpCgg_kdx_cierre.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_cierre.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_cierre.setCKCRR_FECHA_CIERRE(results.getTimestamp(4));
				tmpCgg_kdx_cierre.setCKCRR_NUMERO_CIERRE(results.getString(5));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL_VENTA(results.getBigDecimal(6));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL(results.getBigDecimal(7));
				tmpCgg_kdx_cierre.setCKCRR_OBSERVACION(results.getString(8));
				tmpCgg_kdx_cierre.setCKCRR_DIFERENCIA(results.getBigDecimal(9));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO_CIERRE(results.getInt(10));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO(results.getBoolean(11));
				outCgg_kdx_cierre.add(tmpCgg_kdx_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_cierre QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> outCgg_kdx_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_cierre tmpCgg_kdx_cierre = new com.besixplus.sii.objects.Cgg_kdx_cierre();
				tmpCgg_kdx_cierre.setCKCRR_CODIGO(results.getString(1));
				tmpCgg_kdx_cierre.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_cierre.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_cierre.setCKCRR_FECHA_CIERRE(results.getTimestamp(4));
				tmpCgg_kdx_cierre.setCKCRR_NUMERO_CIERRE(results.getString(5));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL_VENTA(results.getBigDecimal(6));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL(results.getBigDecimal(7));
				tmpCgg_kdx_cierre.setCKCRR_OBSERVACION(results.getString(8));
				tmpCgg_kdx_cierre.setCKCRR_DIFERENCIA(results.getBigDecimal(9));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO_CIERRE(results.getInt(10));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO(results.getBoolean(11));
				outCgg_kdx_cierre.add(tmpCgg_kdx_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_cierre QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_cierre = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_cierre.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_cierre().getCKCRR_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_cierre().getCKPVT_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_cierre().getCKUPV_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_kdx_cierre().getCKCRR_FECHA_CIERRE().getTime()));
			stmUpdate.setString(5, this.getCgg_kdx_cierre().getCKCRR_NUMERO_CIERRE());
			stmUpdate.setBigDecimal(6, this.getCgg_kdx_cierre().getCKCRR_TOTAL_VENTA());
			stmUpdate.setBigDecimal(7, this.getCgg_kdx_cierre().getCKCRR_TOTAL());
			stmUpdate.setString(8, this.getCgg_kdx_cierre().getCKCRR_OBSERVACION());
			stmUpdate.setBigDecimal(9, this.getCgg_kdx_cierre().getCKCRR_DIFERENCIA());
			stmUpdate.setInt(10, this.getCgg_kdx_cierre().getCKCRR_ESTADO_CIERRE());
			stmUpdate.setBoolean(11, this.getCgg_kdx_cierre().getCKCRR_ESTADO());
			stmUpdate.setString(12, this.getCgg_kdx_cierre().getCKCRR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_cierre DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_cierre OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_cierre select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_cierre().getCKCRR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_cierre().setCKCRR_CODIGO(results.getString(1));
				this.getCgg_kdx_cierre().setCKPVT_CODIGO(results.getString(2));
				this.getCgg_kdx_cierre().setCKUPV_CODIGO(results.getString(3));
				this.getCgg_kdx_cierre().setCKCRR_FECHA_CIERRE(results.getTimestamp(4));
				this.getCgg_kdx_cierre().setCKCRR_NUMERO_CIERRE(results.getString(5));
				this.getCgg_kdx_cierre().setCKCRR_TOTAL_VENTA(results.getBigDecimal(6));
				this.getCgg_kdx_cierre().setCKCRR_TOTAL(results.getBigDecimal(7));
				this.getCgg_kdx_cierre().setCKCRR_OBSERVACION(results.getString(8));
				this.getCgg_kdx_cierre().setCKCRR_DIFERENCIA(results.getBigDecimal(9));
				this.getCgg_kdx_cierre().setCKCRR_ESTADO_CIERRE(results.getInt(10));
				this.getCgg_kdx_cierre().setCKCRR_ESTADO(results.getBoolean(11));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_cierre();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_cierre DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_cierre().getCKCRR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_cierre().getCKCRR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_cierre DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_cierre OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> selectCGG_KDX_PUNTO_VENTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> outCgg_kdx_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_S_CGG_KDX_PUNTO_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_cierre().getCKPVT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_cierre tmpCgg_kdx_cierre = new com.besixplus.sii.objects.Cgg_kdx_cierre();
				tmpCgg_kdx_cierre.setCKCRR_CODIGO(results.getString(1));
				tmpCgg_kdx_cierre.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_cierre.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_cierre.setCKCRR_FECHA_CIERRE(results.getTimestamp(4));
				tmpCgg_kdx_cierre.setCKCRR_NUMERO_CIERRE(results.getString(5));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL_VENTA(results.getBigDecimal(6));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL(results.getBigDecimal(7));
				tmpCgg_kdx_cierre.setCKCRR_OBSERVACION(results.getString(8));
				tmpCgg_kdx_cierre.setCKCRR_DIFERENCIA(results.getBigDecimal(9));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO_CIERRE(results.getInt(10));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO(results.getBoolean(11));
				outCgg_kdx_cierre.add(tmpCgg_kdx_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_cierre DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_D_CGG_KDX_PUNTO_VENTA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_cierre().getCKPVT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_DS_CGG_KDX_PUNTO_VENTA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_cierre().getCKPVT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_cierre DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_cierre OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> selectCGG_KDX_USUARIO_PV(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> outCgg_kdx_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_S_CGG_KDX_USUARIO_PV(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_cierre().getCKUPV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_cierre tmpCgg_kdx_cierre = new com.besixplus.sii.objects.Cgg_kdx_cierre();
				tmpCgg_kdx_cierre.setCKCRR_CODIGO(results.getString(1));
				tmpCgg_kdx_cierre.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_cierre.setCKUPV_CODIGO(results.getString(3));
				tmpCgg_kdx_cierre.setCKCRR_FECHA_CIERRE(results.getTimestamp(4));
				tmpCgg_kdx_cierre.setCKCRR_NUMERO_CIERRE(results.getString(5));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL_VENTA(results.getBigDecimal(6));
				tmpCgg_kdx_cierre.setCKCRR_TOTAL(results.getBigDecimal(7));
				tmpCgg_kdx_cierre.setCKCRR_OBSERVACION(results.getString(8));
				tmpCgg_kdx_cierre.setCKCRR_DIFERENCIA(results.getBigDecimal(9));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO_CIERRE(results.getInt(10));
				tmpCgg_kdx_cierre.setCKCRR_ESTADO(results.getBoolean(11));
				outCgg_kdx_cierre.add(tmpCgg_kdx_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_cierre DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_usuario_pv.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_D_CGG_KDX_USUARIO_PV(?) }");
			stmDelete.setString(1, this.getCgg_kdx_cierre().getCKUPV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_CIERRE_DS_CGG_KDX_USUARIO_PV(?) }");
				stmDelete.setString(1, this.getCgg_kdx_cierre().getCKUPV_CODIGO());
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
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_kdx_cierre
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return String NUMERO DE TRANSFERENCIAS SECUENCIAL.
	* */
	public static String numeroCierre(
		java.sql.Connection inConnection,
		String inUserName
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_GENERA_NUMERO(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_cierre QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_cierre = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_CIERRE_SELECT1(?,?,?,?,?,?) }");
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
				outCgg_kdx_cierre.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre;
	}
}