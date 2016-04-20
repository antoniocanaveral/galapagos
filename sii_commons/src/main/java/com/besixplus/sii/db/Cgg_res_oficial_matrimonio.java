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
* CLASE Cgg_res_oficial_matrimonio
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_oficial_matrimonio.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_oficial_matrimonio implements Serializable{
	private static final long serialVersionUID = 824315188;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_oficial_matrimonio.
	*/
	private com.besixplus.sii.objects.Cgg_res_oficial_matrimonio myCgg_res_oficial_matrimonio = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_matrimonio.
	*/
	public Cgg_res_oficial_matrimonio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_matrimonio.
	* @param inCgg_res_oficial_matrimonio OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_oficial_matrimonio.
	*/
	public Cgg_res_oficial_matrimonio(
		com.besixplus.sii.objects.Cgg_res_oficial_matrimonio inCgg_res_oficial_matrimonio
	){
		this.setCgg_res_oficial_matrimonio(inCgg_res_oficial_matrimonio);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_oficial_matrimonio.
	* @param inCgg_res_oficial_matrimonio OBJETO Cgg_res_oficial_matrimonio.
	* @return void
	*/
	public void setCgg_res_oficial_matrimonio(com.besixplus.sii.objects.Cgg_res_oficial_matrimonio inCgg_res_oficial_matrimonio){
		this.myCgg_res_oficial_matrimonio = inCgg_res_oficial_matrimonio;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_oficial_matrimonio.
	* @return Cgg_res_oficial_matrimonio OBJETO Cgg_res_oficial_matrimonio.
	*/
	public com.besixplus.sii.objects.Cgg_res_oficial_matrimonio getCgg_res_oficial_matrimonio(){
		return this.myCgg_res_oficial_matrimonio;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_oficial_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_oficial_matrimonio().getCROFM_CODIGO());
			stmInsert.setString(3, this.getCgg_res_oficial_matrimonio().getCRMTR_CODIGO());
			stmInsert.setString(4, this.getCgg_res_oficial_matrimonio().getCUSU_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_res_oficial_matrimonio().getCROFM_ESTADO());
			stmInsert.setString(6, this.getCgg_res_oficial_matrimonio().getCROFM_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_res_oficial_matrimonio().getCROFM_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_oficial_matrimonio().setCROFM_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> outCgg_res_oficial_matrimonio = new ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_oficial_matrimonio tmpCgg_res_oficial_matrimonio = new com.besixplus.sii.objects.Cgg_res_oficial_matrimonio();
				tmpCgg_res_oficial_matrimonio.setCROFM_CODIGO(results.getString(1));
				tmpCgg_res_oficial_matrimonio.setCRMTR_CODIGO(results.getString(2));
				tmpCgg_res_oficial_matrimonio.setCUSU_CODIGO(results.getString(3));
				tmpCgg_res_oficial_matrimonio.setCROFM_ESTADO(results.getBoolean(4));
				outCgg_res_oficial_matrimonio.add(tmpCgg_res_oficial_matrimonio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_matrimonio;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> outCgg_res_oficial_matrimonio = new ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_oficial_matrimonio tmpCgg_res_oficial_matrimonio = new com.besixplus.sii.objects.Cgg_res_oficial_matrimonio();
				tmpCgg_res_oficial_matrimonio.setCROFM_CODIGO(results.getString(1));
				tmpCgg_res_oficial_matrimonio.setCRMTR_CODIGO(results.getString(2));
				tmpCgg_res_oficial_matrimonio.setCUSU_CODIGO(results.getString(3));
				tmpCgg_res_oficial_matrimonio.setCROFM_ESTADO(results.getBoolean(4));
				outCgg_res_oficial_matrimonio.add(tmpCgg_res_oficial_matrimonio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_matrimonio;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_oficial_matrimonio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_oficial_matrimonio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_matrimonio;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_oficial_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_oficial_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_oficial_matrimonio().getCROFM_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_oficial_matrimonio().getCRMTR_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_oficial_matrimonio().getCUSU_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_res_oficial_matrimonio().getCROFM_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_oficial_matrimonio().getCROFM_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_oficial_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_oficial_matrimonio select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_oficial_matrimonio().getCROFM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_oficial_matrimonio().setCROFM_CODIGO(results.getString(1));
				this.getCgg_res_oficial_matrimonio().setCRMTR_CODIGO(results.getString(2));
				this.getCgg_res_oficial_matrimonio().setCUSU_CODIGO(results.getString(3));
				this.getCgg_res_oficial_matrimonio().setCROFM_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_oficial_matrimonio();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_oficial_matrimonio().getCROFM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_oficial_matrimonio().getCROFM_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO.
	* @return com.besixplus.sii.objects.Cgg_res_oficial_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String, Object>> selectCGG_USUARIO(
		java.sql.Connection inConnection,
		String inCrmtr_codigo
	){
		ArrayList<HashMap<String, Object>> outCgg_res_oficial_matrimonio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrmtr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				
				outCgg_res_oficial_matrimonio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_matrimonio;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_USUARIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_oficial_matrimonio().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_oficial_matrimonio().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_oficial_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> selectCGG_RES_MATRIMONIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio> outCgg_res_oficial_matrimonio = new ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_matrimonio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_S_CGG_RES_MATRIMONIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_oficial_matrimonio().getCRMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_oficial_matrimonio tmpCgg_res_oficial_matrimonio = new com.besixplus.sii.objects.Cgg_res_oficial_matrimonio();
				tmpCgg_res_oficial_matrimonio.setCROFM_CODIGO(results.getString(1));
				tmpCgg_res_oficial_matrimonio.setCRMTR_CODIGO(results.getString(2));
				tmpCgg_res_oficial_matrimonio.setCUSU_CODIGO(results.getString(3));
				tmpCgg_res_oficial_matrimonio.setCROFM_ESTADO(results.getBoolean(4));
				outCgg_res_oficial_matrimonio.add(tmpCgg_res_oficial_matrimonio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_matrimonio;
	}

	
	
	
	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_MATRIMONIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_D_CGG_RES_MATRIMONIO(?) }");
			stmDelete.setString(1, this.getCgg_res_oficial_matrimonio().getCRMTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_OFICIAL_MATRIMONIO_DS_CGG_RES_MATRIMONIO(?) }");
				stmDelete.setString(1, this.getCgg_res_oficial_matrimonio().getCRMTR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio DE ACUERDO
	*A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_matrimonio
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO.
	* @return com.besixplus.sii.objects.Cgg_res_oficial_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String, Object>> selectCGG_RES_OFICIAL_MATRIMONIO(
		java.sql.Connection inConnection,
		String inCrmtr_codigo
	){
		ArrayList<HashMap<String, Object>> outCgg_res_oficial_matrimonio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_OFICIAL_MATRIMONIO_S_CGG_RES_MATRIMONIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrmtr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				
				outCgg_res_oficial_matrimonio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_matrimonio;
	}

}