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
* CLASE Cgg_res_tst_aplica
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tst_aplica.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tst_aplica implements Serializable{
	private static final long serialVersionUID = 59370734;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tst_aplica.
	*/
	private com.besixplus.sii.objects.Cgg_res_tst_aplica myCgg_res_tst_aplica = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tst_aplica.
	*/
	public Cgg_res_tst_aplica(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tst_aplica.
	* @param inCgg_res_tst_aplica OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tst_aplica.
	*/
	public Cgg_res_tst_aplica(
		com.besixplus.sii.objects.Cgg_res_tst_aplica inCgg_res_tst_aplica
	){
		this.setCgg_res_tst_aplica(inCgg_res_tst_aplica);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tst_aplica.
	* @param inCgg_res_tst_aplica OBJETO Cgg_res_tst_aplica.
	* @return void
	*/
	public void setCgg_res_tst_aplica(com.besixplus.sii.objects.Cgg_res_tst_aplica inCgg_res_tst_aplica){
		this.myCgg_res_tst_aplica = inCgg_res_tst_aplica;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tst_aplica.
	* @return Cgg_res_tst_aplica OBJETO Cgg_res_tst_aplica.
	*/
	public com.besixplus.sii.objects.Cgg_res_tst_aplica getCgg_res_tst_aplica(){
		return this.myCgg_res_tst_aplica;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tst_aplica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tst_aplica().getCRTAO_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tst_aplica().getCRTSO_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tst_aplica().getCRTST_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_res_tst_aplica().getCRTAO_ESTADO());
			stmInsert.setString(6, this.getCgg_res_tst_aplica().getCRTAO_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_tst_aplica().setCRTAO_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> outCgg_res_tst_aplica = new ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tst_aplica tmpCgg_res_tst_aplica = new com.besixplus.sii.objects.Cgg_res_tst_aplica();
				tmpCgg_res_tst_aplica.setCRTAO_CODIGO(results.getString(1));
				tmpCgg_res_tst_aplica.setCRTSO_CODIGO(results.getString(2));
				tmpCgg_res_tst_aplica.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_tst_aplica.setCRTAO_ESTADO(results.getBoolean(4));
				tmpCgg_res_tst_aplica.setCRTAO_USUARIO_INSERT(results.getString(5));
				tmpCgg_res_tst_aplica.setCRTAO_USUARIO_UPDATE(results.getString(6));
				outCgg_res_tst_aplica.add(tmpCgg_res_tst_aplica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_aplica;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> outCgg_res_tst_aplica = new ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tst_aplica tmpCgg_res_tst_aplica = new com.besixplus.sii.objects.Cgg_res_tst_aplica();
				tmpCgg_res_tst_aplica.setCRTAO_CODIGO(results.getString(1));
				tmpCgg_res_tst_aplica.setCRTSO_CODIGO(results.getString(2));
				tmpCgg_res_tst_aplica.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_tst_aplica.setCRTAO_ESTADO(results.getBoolean(4));
				tmpCgg_res_tst_aplica.setCRTAO_USUARIO_INSERT(results.getString(5));
				tmpCgg_res_tst_aplica.setCRTAO_USUARIO_UPDATE(results.getString(6));
				outCgg_res_tst_aplica.add(tmpCgg_res_tst_aplica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_aplica;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_tst_aplica = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_tst_aplica.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_aplica;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tst_aplica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_tst_aplica().getCRTAO_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tst_aplica().getCRTSO_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tst_aplica().getCRTST_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_res_tst_aplica().getCRTAO_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_tst_aplica().getCRTAO_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tst_aplica DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tst_aplica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tst_aplica select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tst_aplica().getCRTAO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tst_aplica().setCRTAO_CODIGO(results.getString(1));
				this.getCgg_res_tst_aplica().setCRTSO_CODIGO(results.getString(2));
				this.getCgg_res_tst_aplica().setCRTST_CODIGO(results.getString(3));
				this.getCgg_res_tst_aplica().setCRTAO_ESTADO(results.getBoolean(4));
				this.getCgg_res_tst_aplica().setCRTAO_USUARIO_INSERT(results.getString(5));
				this.getCgg_res_tst_aplica().setCRTAO_USUARIO_UPDATE(results.getString(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tst_aplica();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tst_aplica DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tst_aplica().getCRTAO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tst_aplica().getCRTAO_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tst_opciones.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tst_aplica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> selectCGG_RES_TST_OPCIONES(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica> outCgg_res_tst_aplica = new ArrayList<com.besixplus.sii.objects.Cgg_res_tst_aplica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_S_CGG_RES_TST_OPCIONES(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tst_aplica().getCRTSO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tst_aplica tmpCgg_res_tst_aplica = new com.besixplus.sii.objects.Cgg_res_tst_aplica();
				tmpCgg_res_tst_aplica.setCRTAO_CODIGO(results.getString(1));
				tmpCgg_res_tst_aplica.setCRTSO_CODIGO(results.getString(2));
				tmpCgg_res_tst_aplica.setCRTST_CODIGO(results.getString(3));
				tmpCgg_res_tst_aplica.setCRTAO_ESTADO(results.getBoolean(4));
				tmpCgg_res_tst_aplica.setCRTAO_USUARIO_INSERT(results.getString(5));
				tmpCgg_res_tst_aplica.setCRTAO_USUARIO_UPDATE(results.getString(6));
				outCgg_res_tst_aplica.add(tmpCgg_res_tst_aplica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_aplica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tst_opciones.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TST_OPCIONES(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_D_CGG_RES_TST_OPCIONES(?) }");
			stmDelete.setString(1, this.getCgg_res_tst_aplica().getCRTSO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_DS_CGG_RES_TST_OPCIONES(?) }");
				stmDelete.setString(1, this.getCgg_res_tst_aplica().getCRTSO_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tst_aplica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String, Object>> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String, Object>> outCgg_res_tst_aplica = new ArrayList<HashMap<String, Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TST_APLICA_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tst_aplica().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tst_aplica.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tst_aplica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tst_aplica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inSoft TIPO DE RESPUESTA PARA ELIMINAR FISICO O LOGICO.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public String deleteCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection,
		boolean inSoft
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			if(inSoft){
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			}
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tst_aplica().getCRTST_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		if(outResult.equals("true") && inSoft){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TST_APLICA_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tst_aplica().getCRTST_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}

}