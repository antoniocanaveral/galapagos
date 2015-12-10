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
* CLASE Cgg_res_cargo_comite
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_cargo_comite.
* @autor BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_cargo_comite implements Serializable{
	private static final long serialVersionUID = 119411131;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_cargo_comite.
	*/
	private com.besixplus.sii.objects.Cgg_res_cargo_comite myCgg_res_cargo_comite = null;

	/**
	* CONTRUCTOR DE LA CLASE Cgg_res_cargo_comite.
	*/
	public Cgg_res_cargo_comite(){}
	/**
	* CONTRUCTOR DE LA CLASE Cgg_res_cargo_comite.
	* @param inCgg_res_cargo_comite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_cargo_comite.
	*/
	public Cgg_res_cargo_comite(
		com.besixplus.sii.objects.Cgg_res_cargo_comite inCgg_res_cargo_comite
	){
		this.setCgg_res_cargo_comite(inCgg_res_cargo_comite);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_cargo_comite.
	* @param inCgg_res_cargo_comite OBJETO Cgg_res_cargo_comite.
	* @return void
	*/
	public void setCgg_res_cargo_comite(com.besixplus.sii.objects.Cgg_res_cargo_comite inCgg_res_cargo_comite){
		this.myCgg_res_cargo_comite = inCgg_res_cargo_comite;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_cargo_comite.
	* @return Cgg_res_cargo_comite OBJETO Cgg_res_cargo_comite.
	*/
	public com.besixplus.sii.objects.Cgg_res_cargo_comite getCgg_res_cargo_comite(){
		return this.myCgg_res_cargo_comite;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_cargo_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_cargo_comite().getCRCRG_CODIGO());
			stmInsert.setString(3, this.getCgg_res_cargo_comite().getCRCOM_CODIGO());
			stmInsert.setString(4, this.getCgg_res_cargo_comite().getCRCRG_NOMBRE());
			stmInsert.setBoolean(5, this.getCgg_res_cargo_comite().getCRCRG_PRINCIPAL());
			stmInsert.setBoolean(6, this.getCgg_res_cargo_comite().getCRCRG_VOTO_DIRIMENTE());
			stmInsert.setBoolean(7, this.getCgg_res_cargo_comite().getCRCRG_ESTADO());
			stmInsert.setString(8, this.getCgg_res_cargo_comite().getCRCRG_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_cargo_comite().setCRCRG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cargo_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> outCgg_res_cargo_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_cargo_comite tmpCgg_res_cargo_comite = new com.besixplus.sii.objects.Cgg_res_cargo_comite();
				tmpCgg_res_cargo_comite.setCRCRG_CODIGO(results.getString(1));
				tmpCgg_res_cargo_comite.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_cargo_comite.setCRCRG_NOMBRE(results.getString(3));
				tmpCgg_res_cargo_comite.setCRCRG_PRINCIPAL(results.getBoolean(4));
				tmpCgg_res_cargo_comite.setCRCRG_VOTO_DIRIMENTE(results.getBoolean(5));
				tmpCgg_res_cargo_comite.setCRCRG_ESTADO(results.getBoolean(6));
				outCgg_res_cargo_comite.add(tmpCgg_res_cargo_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cargo_comite;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cargo_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> outCgg_res_cargo_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_cargo_comite tmpCgg_res_cargo_comite = new com.besixplus.sii.objects.Cgg_res_cargo_comite();
				tmpCgg_res_cargo_comite.setCRCRG_CODIGO(results.getString(1));
				tmpCgg_res_cargo_comite.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_cargo_comite.setCRCRG_NOMBRE(results.getString(3));
				tmpCgg_res_cargo_comite.setCRCRG_PRINCIPAL(results.getBoolean(4));
				tmpCgg_res_cargo_comite.setCRCRG_VOTO_DIRIMENTE(results.getBoolean(5));
				tmpCgg_res_cargo_comite.setCRCRG_ESTADO(results.getBoolean(6));
				outCgg_res_cargo_comite.add(tmpCgg_res_cargo_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cargo_comite;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cargo_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_cargo_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_cargo_comite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cargo_comite;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_cargo_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_cargo_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_CARGO_COMITE_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_cargo_comite().getCRCRG_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_cargo_comite().getCRCOM_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_cargo_comite().getCRCRG_NOMBRE());
			stmUpdate.setBoolean(4, this.getCgg_res_cargo_comite().getCRCRG_PRINCIPAL());
			stmUpdate.setBoolean(5, this.getCgg_res_cargo_comite().getCRCRG_VOTO_DIRIMENTE());
			stmUpdate.setBoolean(6, this.getCgg_res_cargo_comite().getCRCRG_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_cargo_comite().getCRCRG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_cargo_comite DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_cargo_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_cargo_comite select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_cargo_comite().getCRCRG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_cargo_comite().setCRCRG_CODIGO(results.getString(1));
				this.getCgg_res_cargo_comite().setCRCOM_CODIGO(results.getString(2));
				this.getCgg_res_cargo_comite().setCRCRG_NOMBRE(results.getString(3));
				this.getCgg_res_cargo_comite().setCRCRG_PRINCIPAL(results.getBoolean(4));
				this.getCgg_res_cargo_comite().setCRCRG_VOTO_DIRIMENTE(results.getBoolean(5));
				this.getCgg_res_cargo_comite().setCRCRG_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_cargo_comite();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_cargo_comite DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARGO_COMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_cargo_comite().getCRCRG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARGO_COMITE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_cargo_comite().getCRCRG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_cargo_comite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_cargo_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> selectCGG_RES_COMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> outCgg_res_cargo_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_S_CGG_RES_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_cargo_comite().getCRCOM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_cargo_comite tmpCgg_res_cargo_comite = new com.besixplus.sii.objects.Cgg_res_cargo_comite();
				tmpCgg_res_cargo_comite.setCRCRG_CODIGO(results.getString(1));
				tmpCgg_res_cargo_comite.setCRCOM_CODIGO(results.getString(2));
				tmpCgg_res_cargo_comite.setCRCRG_NOMBRE(results.getString(3));
				tmpCgg_res_cargo_comite.setCRCRG_PRINCIPAL(results.getBoolean(4));
				tmpCgg_res_cargo_comite.setCRCRG_VOTO_DIRIMENTE(results.getBoolean(5));
				tmpCgg_res_cargo_comite.setCRCRG_ESTADO(results.getBoolean(6));
				outCgg_res_cargo_comite.add(tmpCgg_res_cargo_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cargo_comite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_cargo_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_COMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARGO_COMITE_D_CGG_RES_COMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_cargo_comite().getCRCOM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_CARGO_COMITE_DS_CGG_RES_COMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_cargo_comite().getCRCOM_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_cargo_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> selectAllComite(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCrcom_codigo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite> outCgg_res_cargo_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_cargo_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_RES_COMITE_CARGO_COMITE_SELECT(?,?,?,?,?,?,?) }");
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
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_cargo_comite tmpCgg_res_cargo_comite = new com.besixplus.sii.objects.Cgg_res_cargo_comite();
				tmpCgg_res_cargo_comite.setCRCRG_CODIGO(results.getString(1));
				tmpCgg_res_cargo_comite.setCRCOM_CODIGO(results.getString(2));			
				tmpCgg_res_cargo_comite.setCRCRG_NOMBRE(results.getString(3));
				tmpCgg_res_cargo_comite.setCRCRG_VOTO_DIRIMENTE(results.getBoolean(4));
				tmpCgg_res_cargo_comite.setCRCRG_ESTADO(results.getBoolean(5));
				outCgg_res_cargo_comite.add(tmpCgg_res_cargo_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_cargo_comite;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_cargo_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCountComite(
		java.sql.Connection inConnection,
		String inCrcom_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_COUNT(?) }");
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
	public static int selectCountComite(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrcom_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCountComite(inConnection,inCrcom_codigo);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_CARGO_COMITE_COUNT(?,?) }");
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