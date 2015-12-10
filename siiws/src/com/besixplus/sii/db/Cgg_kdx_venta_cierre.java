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
* CLASE Cgg_kdx_venta_cierre
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_venta_cierre.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_venta_cierre implements Serializable{
	private static final long serialVersionUID = 871472026;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_venta_cierre.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_venta_cierre myCgg_kdx_venta_cierre = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_cierre.
	*/
	public Cgg_kdx_venta_cierre(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_cierre.
	* @param inCgg_kdx_venta_cierre OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_venta_cierre.
	*/
	public Cgg_kdx_venta_cierre(
		com.besixplus.sii.objects.Cgg_kdx_venta_cierre inCgg_kdx_venta_cierre
	){
		this.setCgg_kdx_venta_cierre(inCgg_kdx_venta_cierre);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_venta_cierre.
	* @param inCgg_kdx_venta_cierre OBJETO Cgg_kdx_venta_cierre.
	* @return void
	*/
	public void setCgg_kdx_venta_cierre(com.besixplus.sii.objects.Cgg_kdx_venta_cierre inCgg_kdx_venta_cierre){
		this.myCgg_kdx_venta_cierre = inCgg_kdx_venta_cierre;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_venta_cierre.
	* @return Cgg_kdx_venta_cierre OBJETO Cgg_kdx_venta_cierre.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_venta_cierre getCgg_kdx_venta_cierre(){
		return this.myCgg_kdx_venta_cierre;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_venta_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_venta_cierre().getCKVTC_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_venta_cierre().getCKVNT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_venta_cierre().getCKCRR_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_kdx_venta_cierre().getCKVTC_ESTADO());
			stmInsert.setString(6, this.getCgg_kdx_venta_cierre().getCKVTC_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_venta_cierre().setCKVTC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_venta_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert1(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_INSERT1(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_venta_cierre().getCKVTC_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_venta_cierre().getCKVNT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_venta_cierre().getCKCRR_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_kdx_venta_cierre().getCKVTC_ESTADO());
			stmInsert.setString(6, this.getCgg_kdx_venta_cierre().getCKVTC_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_venta_cierre().setCKVTC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> outCgg_kdx_venta_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_cierre tmpCgg_kdx_venta_cierre = new com.besixplus.sii.objects.Cgg_kdx_venta_cierre();
				tmpCgg_kdx_venta_cierre.setCKVTC_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_cierre.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_cierre.setCKCRR_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_cierre.setCKVTC_ESTADO(results.getBoolean(4));
				outCgg_kdx_venta_cierre.add(tmpCgg_kdx_venta_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_cierre;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> outCgg_kdx_venta_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_venta_cierre tmpCgg_kdx_venta_cierre = new com.besixplus.sii.objects.Cgg_kdx_venta_cierre();
				tmpCgg_kdx_venta_cierre.setCKVTC_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_cierre.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_cierre.setCKCRR_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_cierre.setCKVTC_ESTADO(results.getBoolean(4));
				outCgg_kdx_venta_cierre.add(tmpCgg_kdx_venta_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_cierre;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_venta_cierre = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_venta_cierre.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_cierre;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_venta_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_venta_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_venta_cierre().getCKVTC_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_venta_cierre().getCKVNT_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_venta_cierre().getCKCRR_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_kdx_venta_cierre().getCKVTC_ESTADO());
			stmUpdate.setString(5, this.getCgg_kdx_venta_cierre().getCKVTC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_venta_cierre DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_cierre OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_venta_cierre select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_cierre().getCKVTC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_venta_cierre().setCKVTC_CODIGO(results.getString(1));
				this.getCgg_kdx_venta_cierre().setCKVNT_CODIGO(results.getString(2));
				this.getCgg_kdx_venta_cierre().setCKCRR_CODIGO(results.getString(3));
				this.getCgg_kdx_venta_cierre().setCKVTC_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_venta_cierre();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_venta_cierre DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_cierre().getCKVTC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_cierre().getCKVTC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_cierre OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> selectCGG_KDX_VENTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> outCgg_kdx_venta_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_S_CGG_KDX_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_cierre().getCKVNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_cierre tmpCgg_kdx_venta_cierre = new com.besixplus.sii.objects.Cgg_kdx_venta_cierre();
				tmpCgg_kdx_venta_cierre.setCKVTC_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_cierre.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_cierre.setCKCRR_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_cierre.setCKVTC_ESTADO(results.getBoolean(4));
				outCgg_kdx_venta_cierre.add(tmpCgg_kdx_venta_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_cierre;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_venta.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_D_CGG_KDX_VENTA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_cierre().getCKVNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_DS_CGG_KDX_VENTA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_cierre().getCKVNT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_cierre OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> selectCGG_KDX_CIERRE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre> outCgg_kdx_venta_cierre = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_cierre>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_CIERRE_S_CGG_KDX_CIERRE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_cierre().getCKCRR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_cierre tmpCgg_kdx_venta_cierre = new com.besixplus.sii.objects.Cgg_kdx_venta_cierre();
				tmpCgg_kdx_venta_cierre.setCKVTC_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_cierre.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_cierre.setCKCRR_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_cierre.setCKVTC_ESTADO(results.getBoolean(4));
				outCgg_kdx_venta_cierre.add(tmpCgg_kdx_venta_cierre);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_cierre;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_cierre DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_cierre.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_CIERRE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_D_CGG_KDX_CIERRE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_cierre().getCKCRR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_CIERRE_DS_CGG_KDX_CIERRE(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_cierre().getCKCRR_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_cierre_detalle QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectVentaCierreAll(
		java.sql.Connection inConnection,
		String inCkcrr_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_cierre_detalle = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_VENTA_CIERRE_S_CGG_KDX_CIERRE1(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCkcrr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_cierre_detalle.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_cierre_detalle;
	}
	
}