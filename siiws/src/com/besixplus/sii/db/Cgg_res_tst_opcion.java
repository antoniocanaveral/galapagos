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
* CLASE Cgg_res_tst_opcion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tst_opcion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tst_opcion implements Serializable{
	private static final long serialVersionUID = 1855380326;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tst_opcion.
	*/
	private com.besixplus.sii.objects.Cgg_res_tst_opcion myCgg_res_tst_opcion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tst_opcion.
	*/
	public Cgg_res_tst_opcion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tst_opcion.
	* @param inCgg_res_tst_opcion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tst_opcion.
	*/
	public Cgg_res_tst_opcion(
		com.besixplus.sii.objects.Cgg_res_tst_opcion inCgg_res_tst_opcion
	){
		this.setCgg_res_tst_opcion(inCgg_res_tst_opcion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tst_opcion.
	* @param inCgg_res_tst_opcion OBJETO Cgg_res_tst_opcion.
	* @return void
	*/
	public void setCgg_res_tst_opcion(com.besixplus.sii.objects.Cgg_res_tst_opcion inCgg_res_tst_opcion){
		this.myCgg_res_tst_opcion = inCgg_res_tst_opcion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tst_opcion.
	* @return Cgg_res_tst_opcion OBJETO Cgg_res_tst_opcion.
	*/
	public com.besixplus.sii.objects.Cgg_res_tst_opcion getCgg_res_tst_opcion(){
		return this.myCgg_res_tst_opcion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tst_opcion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tst_opcion().getCRTSO_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tst_opcion().getCRTSO_NOMBRE());
			stmInsert.setString(4, this.getCgg_res_tst_opcion().getCRTSO_DESCRIPCION());
			stmInsert.setBoolean(5, this.getCgg_res_tst_opcion().getCRTSO_ESTADO());
			stmInsert.setString(6, this.getCgg_res_tst_opcion().getCRTSO_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_tst_opcion().setCRTSO_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tst_opcion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> outCgg_res_tst_opcion = new ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tst_opcion tmpCgg_res_tst_opcion = new com.besixplus.sii.objects.Cgg_res_tst_opcion();
				tmpCgg_res_tst_opcion.setCRTSO_CODIGO(results.getString(1));
				tmpCgg_res_tst_opcion.setCRTSO_NOMBRE(results.getString(2));
				tmpCgg_res_tst_opcion.setCRTSO_DESCRIPCION(results.getString(3));
				tmpCgg_res_tst_opcion.setCRTSO_ESTADO(results.getBoolean(4));
				tmpCgg_res_tst_opcion.setCRTSO_USUARIO_INSERT(results.getString(5));
				tmpCgg_res_tst_opcion.setCRTSO_USUARIO_UPDATE(results.getString(6));
				outCgg_res_tst_opcion.add(tmpCgg_res_tst_opcion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_opcion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tst_opcion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> outCgg_res_tst_opcion = new ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tst_opcion tmpCgg_res_tst_opcion = new com.besixplus.sii.objects.Cgg_res_tst_opcion();
				tmpCgg_res_tst_opcion.setCRTSO_CODIGO(results.getString(1));
				tmpCgg_res_tst_opcion.setCRTSO_NOMBRE(results.getString(2));
				tmpCgg_res_tst_opcion.setCRTSO_DESCRIPCION(results.getString(3));
				tmpCgg_res_tst_opcion.setCRTSO_ESTADO(results.getBoolean(4));
				tmpCgg_res_tst_opcion.setCRTSO_USUARIO_INSERT(results.getString(5));
				tmpCgg_res_tst_opcion.setCRTSO_USUARIO_UPDATE(results.getString(6));
				outCgg_res_tst_opcion.add(tmpCgg_res_tst_opcion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_opcion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tst_opcion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tst_opcion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_tst_opcion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_tst_opcion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_opcion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_tst_opcion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tst_opcion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_OPCION_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_tst_opcion().getCRTSO_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tst_opcion().getCRTSO_NOMBRE());
			stmUpdate.setString(3, this.getCgg_res_tst_opcion().getCRTSO_DESCRIPCION());
			stmUpdate.setBoolean(4, this.getCgg_res_tst_opcion().getCRTSO_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_tst_opcion().getCRTSO_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tst_opcion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tst_opcion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tst_opcion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_OPCION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tst_opcion().getCRTSO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tst_opcion().setCRTSO_CODIGO(results.getString(1));
				this.getCgg_res_tst_opcion().setCRTSO_NOMBRE(results.getString(2));
				this.getCgg_res_tst_opcion().setCRTSO_DESCRIPCION(results.getString(3));
				this.getCgg_res_tst_opcion().setCRTSO_ESTADO(results.getBoolean(4));
				this.getCgg_res_tst_opcion().setCRTSO_USUARIO_INSERT(results.getString(5));
				this.getCgg_res_tst_opcion().setCRTSO_USUARIO_UPDATE(results.getString(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tst_opcion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tst_opcion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_OPCION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tst_opcion().getCRTSO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_OPCION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tst_opcion().getCRTSO_CODIGO());
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