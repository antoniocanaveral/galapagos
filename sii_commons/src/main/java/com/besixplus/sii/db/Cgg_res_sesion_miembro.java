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
* CLASE Cgg_res_sesion_miembro
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_sesion_miembro.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_sesion_miembro implements Serializable{
	private static final long serialVersionUID = 2122318090;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_sesion_miembro.
	*/
	private com.besixplus.sii.objects.Cgg_res_sesion_miembro myCgg_res_sesion_miembro = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_miembro.
	*/
	public Cgg_res_sesion_miembro(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_miembro.
	* @param inCgg_res_sesion_miembro OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_sesion_miembro.
	*/
	public Cgg_res_sesion_miembro(
		com.besixplus.sii.objects.Cgg_res_sesion_miembro inCgg_res_sesion_miembro
	){
		this.setCgg_res_sesion_miembro(inCgg_res_sesion_miembro);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_sesion_miembro.
	* @param inCgg_res_sesion_miembro OBJETO Cgg_res_sesion_miembro.
	* @return void
	*/
	public void setCgg_res_sesion_miembro(com.besixplus.sii.objects.Cgg_res_sesion_miembro inCgg_res_sesion_miembro){
		this.myCgg_res_sesion_miembro = inCgg_res_sesion_miembro;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_sesion_miembro.
	* @return Cgg_res_sesion_miembro OBJETO Cgg_res_sesion_miembro.
	*/
	public com.besixplus.sii.objects.Cgg_res_sesion_miembro getCgg_res_sesion_miembro(){
		return this.myCgg_res_sesion_miembro;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_sesion_miembro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_sesion_miembro().getCRSMB_CODIGO());
			stmInsert.setString(3, this.getCgg_res_sesion_miembro().getCRSSC_CODIGO());
			stmInsert.setString(4, this.getCgg_res_sesion_miembro().getCRMBC_CODIGO());
			stmInsert.setString(5, this.getCgg_res_sesion_miembro().getCGG_CRMBC_CODIGO());
			stmInsert.setBoolean(6, this.getCgg_res_sesion_miembro().getCRSMB_PRESIDENTE());
			stmInsert.setBoolean(7, this.getCgg_res_sesion_miembro().getCRSMB_PRESENTE());
			stmInsert.setBoolean(8, this.getCgg_res_sesion_miembro().getCRSMB_ESTADO());
			stmInsert.setString(9, this.getCgg_res_sesion_miembro().getCRSMB_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_sesion_miembro().getCRSMB_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_sesion_miembro().setCRSMB_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> outCgg_res_sesion_miembro = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_sesion_miembro tmpCgg_res_sesion_miembro = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
				tmpCgg_res_sesion_miembro.setCRSMB_CODIGO(results.getString(1));
				tmpCgg_res_sesion_miembro.setCRSSC_CODIGO(results.getString(2));
				tmpCgg_res_sesion_miembro.setCRMBC_CODIGO(results.getString(3));
				tmpCgg_res_sesion_miembro.setCGG_CRMBC_CODIGO(results.getString(4));
				tmpCgg_res_sesion_miembro.setCRSMB_PRESIDENTE(results.getBoolean(5));
				tmpCgg_res_sesion_miembro.setCRSMB_PRESENTE(results.getBoolean(6));
				tmpCgg_res_sesion_miembro.setCRSMB_ESTADO(results.getBoolean(7));
				outCgg_res_sesion_miembro.add(tmpCgg_res_sesion_miembro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_miembro;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	
	public static ArrayList<HashMap<String,Object>> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrcom_codigo
		){
			ArrayList<HashMap<String,Object>> outCgg_res_sesion_miembro = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_SELECT(?,?,?,?,?,?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inUserName);
				stmSelect.setInt(3, inStart);
				stmSelect.setInt(4, inLimit);
				stmSelect.setString(5, inSortFieldName);
				stmSelect.setString(6, inDirection);
				stmSelect.setString(7, inKeyword);
				stmSelect.setString(8, inCrcom_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_sesion_miembro.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_sesion_miembro;
		}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_sesion_miembro = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_sesion_miembro.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_miembro;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_sesion_miembro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inCrcom_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrcom_codigo);
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
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrcom_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection,inCrcom_codigo);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrcom_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_sesion_miembro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_sesion_miembro().getCRSMB_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_sesion_miembro().getCRSSC_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_sesion_miembro().getCRMBC_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_sesion_miembro().getCGG_CRMBC_CODIGO());
			stmUpdate.setBoolean(5, this.getCgg_res_sesion_miembro().getCRSMB_PRESIDENTE());
			stmUpdate.setBoolean(6, this.getCgg_res_sesion_miembro().getCRSMB_PRESENTE());
			stmUpdate.setBoolean(7, this.getCgg_res_sesion_miembro().getCRSMB_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_sesion_miembro().getCRSMB_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_sesion_miembro DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_sesion_miembro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_sesion_miembro select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_sesion_miembro().getCRSMB_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_sesion_miembro().setCRSMB_CODIGO(results.getString(1));
				this.getCgg_res_sesion_miembro().setCRSSC_CODIGO(results.getString(2));
				this.getCgg_res_sesion_miembro().setCRMBC_CODIGO(results.getString(3));
				this.getCgg_res_sesion_miembro().setCGG_CRMBC_CODIGO(results.getString(4));
				this.getCgg_res_sesion_miembro().setCRSMB_PRESIDENTE(results.getBoolean(5));
				this.getCgg_res_sesion_miembro().setCRSMB_PRESENTE(results.getBoolean(6));
				this.getCgg_res_sesion_miembro().setCRSMB_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_sesion_miembro();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_sesion_miembro DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_sesion_miembro().getCRSMB_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_sesion_miembro().getCRSMB_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_miembro_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_sesion_miembro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> selectCGG_RES_MIEMBRO_COMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> outCgg_res_sesion_miembro = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_S_CGG_RES_MIEMBRO_COMITE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_sesion_miembro().getCRMBC_CODIGO());
			stmSelect.setString(3,this.getCgg_res_sesion_miembro().getCGG_CRMBC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_sesion_miembro tmpCgg_res_sesion_miembro = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
				tmpCgg_res_sesion_miembro.setCRSMB_CODIGO(results.getString(1));
				tmpCgg_res_sesion_miembro.setCRSSC_CODIGO(results.getString(2));
				tmpCgg_res_sesion_miembro.setCRMBC_CODIGO(results.getString(3));
				tmpCgg_res_sesion_miembro.setCGG_CRMBC_CODIGO(results.getString(4));
				tmpCgg_res_sesion_miembro.setCRSMB_PRESIDENTE(results.getBoolean(5));
				tmpCgg_res_sesion_miembro.setCRSMB_PRESENTE(results.getBoolean(6));
				tmpCgg_res_sesion_miembro.setCRSMB_ESTADO(results.getBoolean(7));
				outCgg_res_sesion_miembro.add(tmpCgg_res_sesion_miembro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_miembro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_miembro_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_MIEMBRO_COMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_D_CGG_RES_MIEMBRO_COMITE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_sesion_miembro().getCRMBC_CODIGO());
			stmDelete.setString(2, this.getCgg_res_sesion_miembro().getCGG_CRMBC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_DS_CGG_RES_MIEMBRO_COMITE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_sesion_miembro().getCRMBC_CODIGO());
				stmDelete.setString(2, this.getCgg_res_sesion_miembro().getCGG_CRMBC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_sesion_miembro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> selectCGG_RES_SESION_COMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> outCgg_res_sesion_miembro = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_MIEMBRO_S_CGG_RES_SESION_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_sesion_miembro().getCRSSC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_sesion_miembro tmpCgg_res_sesion_miembro = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
				tmpCgg_res_sesion_miembro.setCRSMB_CODIGO(results.getString(1));
				tmpCgg_res_sesion_miembro.setCRSSC_CODIGO(results.getString(2));
				tmpCgg_res_sesion_miembro.setCRMBC_CODIGO(results.getString(3));
				tmpCgg_res_sesion_miembro.setCGG_CRMBC_CODIGO(results.getString(4));
				tmpCgg_res_sesion_miembro.setCRSMB_PRESIDENTE(results.getBoolean(5));
				tmpCgg_res_sesion_miembro.setCRSMB_PRESENTE(results.getBoolean(6));
				tmpCgg_res_sesion_miembro.setCRSMB_ESTADO(results.getBoolean(7));
				outCgg_res_sesion_miembro.add(tmpCgg_res_sesion_miembro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_miembro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SESION_COMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_D_CGG_RES_SESION_COMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_sesion_miembro().getCRSSC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_MIEMBRO_DS_CGG_RES_SESION_COMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_sesion_miembro().getCRSSC_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	
	public static ArrayList<HashMap<String,Object>> selectAllSesion(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrcom_codigo
		){
			ArrayList<HashMap<String,Object>> outCgg_res_sesion_miembro = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ASISTENCIA_SESION_COMITE_SELECT(?,?,?,?,?,?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inUserName);
				stmSelect.setInt(3, inStart);
				stmSelect.setInt(4, inLimit);
				stmSelect.setString(5, inSortFieldName);
				stmSelect.setString(6, inDirection);
				stmSelect.setString(7, inKeyword);
				stmSelect.setString(8, inCrcom_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_sesion_miembro.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_sesion_miembro;
		}

	
	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_sesion_miembro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCountSesion(
		java.sql.Connection inConnection,
		String inCrcom_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ASISTENCIA_SESION_COMITE_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrcom_codigo);
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
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCountSesion(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrcom_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCountSesion(inConnection,inCrcom_codigo);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ASISTENCIA_SESION_COMITE_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrcom_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

}