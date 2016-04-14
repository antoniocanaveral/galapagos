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
 * CLASE Cgg_res_miembro_comite
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_miembro_comite.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_miembro_comite implements Serializable{
	private static final long serialVersionUID = 1944912611;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_miembro_comite.
	 */
	private com.besixplus.sii.objects.Cgg_res_miembro_comite myCgg_res_miembro_comite = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_miembro_comite.
	 */
	public Cgg_res_miembro_comite(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_miembro_comite.
	 * @param inCgg_res_miembro_comite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_miembro_comite.
	 */
	public Cgg_res_miembro_comite(
			com.besixplus.sii.objects.Cgg_res_miembro_comite inCgg_res_miembro_comite
	){
		this.setCgg_res_miembro_comite(inCgg_res_miembro_comite);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_miembro_comite.
	 * @param inCgg_res_miembro_comite OBJETO Cgg_res_miembro_comite.
	 * @return void
	 */
	public void setCgg_res_miembro_comite(com.besixplus.sii.objects.Cgg_res_miembro_comite inCgg_res_miembro_comite){
		this.myCgg_res_miembro_comite = inCgg_res_miembro_comite;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_miembro_comite.
	 * @return Cgg_res_miembro_comite OBJETO Cgg_res_miembro_comite.
	 */
	public com.besixplus.sii.objects.Cgg_res_miembro_comite getCgg_res_miembro_comite(){
		return this.myCgg_res_miembro_comite;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_miembro_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_COMITE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_miembro_comite().getCRMBC_CODIGO());
			stmInsert.setString(3, this.getCgg_res_miembro_comite().getCRCRG_CODIGO());
			stmInsert.setString(4, this.getCgg_res_miembro_comite().getCRDID_CODIGO());
			stmInsert.setString(5, this.getCgg_res_miembro_comite().getCUSU_CODIGO());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_res_miembro_comite().getCRMBC_FECHA_INICIO_FUNCIONES().getTime()));
			stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_res_miembro_comite().getCRMBC_FECHA_FIN_FUNCIONES().getTime()));
			stmInsert.setBoolean(8, this.getCgg_res_miembro_comite().getCRMBC_TITULAR());
			stmInsert.setBoolean(9, this.getCgg_res_miembro_comite().getCRMBC_AUTORIZADO());
			stmInsert.setBoolean(10, this.getCgg_res_miembro_comite().getCRMBC_ESTADO());
			stmInsert.setString(11, this.getCgg_res_miembro_comite().getCRMBC_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_res_miembro_comite().getCRMBC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_miembro_comite().setCRMBC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> outCgg_res_miembro_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_COMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_miembro_comite tmpCgg_res_miembro_comite = new com.besixplus.sii.objects.Cgg_res_miembro_comite();
				tmpCgg_res_miembro_comite.setCRMBC_CODIGO(results.getString(1));
				tmpCgg_res_miembro_comite.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_res_miembro_comite.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_miembro_comite.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_INICIO_FUNCIONES(results.getTimestamp(5));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_FIN_FUNCIONES(results.getTimestamp(6));
				tmpCgg_res_miembro_comite.setCRMBC_TITULAR(results.getBoolean(7));
				tmpCgg_res_miembro_comite.setCRMBC_AUTORIZADO(results.getBoolean(8));
				tmpCgg_res_miembro_comite.setCRMBC_ESTADO(results.getBoolean(9));
				outCgg_res_miembro_comite.add(tmpCgg_res_miembro_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_miembro_comite;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE.
	 * @param inShowAll VERIFICADOR DE VISUALIZACION.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrcom_codigo,
			boolean inShowAll
	){
		ArrayList<HashMap<String,Object>> outCgg_res_miembro_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_MIEMBRO_COMITE_DESCRIPCION_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrcom_codigo);
			stmSelect.setBoolean(9, inShowAll);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_miembro_comite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_miembro_comite;
	}	

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE
	 * @param inShowAll VERIFICADOR DE VISUALIZACION.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inCrcom_codigo,
			boolean inShowAll
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_RES_MIEMBRO_COMITE_DESCRIPCION_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrcom_codigo);
			stmSelect.setBoolean(4, inShowAll);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_miembro_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_miembro_comite().getCRMBC_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_miembro_comite().getCRCRG_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_miembro_comite().getCRDID_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_miembro_comite().getCUSU_CODIGO());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_res_miembro_comite().getCRMBC_FECHA_INICIO_FUNCIONES().getTime()));
			stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_res_miembro_comite().getCRMBC_FECHA_FIN_FUNCIONES().getTime()));
			stmUpdate.setBoolean(7, this.getCgg_res_miembro_comite().getCRMBC_TITULAR());
			stmUpdate.setBoolean(8, this.getCgg_res_miembro_comite().getCRMBC_AUTORIZADO());
			stmUpdate.setBoolean(9, this.getCgg_res_miembro_comite().getCRMBC_ESTADO());
			stmUpdate.setString(10, this.getCgg_res_miembro_comite().getCRMBC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_miembro_comite DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_miembro_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_miembro_comite select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_COMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_miembro_comite().getCRMBC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_miembro_comite().setCRMBC_CODIGO(results.getString(1));
				this.getCgg_res_miembro_comite().setCRCRG_CODIGO(results.getString(2));
				this.getCgg_res_miembro_comite().setCRDID_CODIGO(results.getString(3));
				this.getCgg_res_miembro_comite().setCUSU_CODIGO(results.getString(4));
				this.getCgg_res_miembro_comite().setCRMBC_FECHA_INICIO_FUNCIONES(results.getTimestamp(5));
				this.getCgg_res_miembro_comite().setCRMBC_FECHA_FIN_FUNCIONES(results.getTimestamp(6));
				this.getCgg_res_miembro_comite().setCRMBC_TITULAR(results.getBoolean(7));
				this.getCgg_res_miembro_comite().setCRMBC_AUTORIZADO(results.getBoolean(8));
				this.getCgg_res_miembro_comite().setCRMBC_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_miembro_comite();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_miembro_comite DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String delete(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_miembro_comite().getCRMBC_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		if(outResult.equals("true")){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_miembro_comite().getCRMBC_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_documento_identificacio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_miembro_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> selectCGG_RES_DOCUMENTO_IDENTIFICACIO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> outCgg_res_miembro_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_COMITE_S_CGG_RES_DOCUMENTO_IDENTIFICACIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_miembro_comite().getCRDID_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_miembro_comite tmpCgg_res_miembro_comite = new com.besixplus.sii.objects.Cgg_res_miembro_comite();
				tmpCgg_res_miembro_comite.setCRMBC_CODIGO(results.getString(1));
				tmpCgg_res_miembro_comite.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_res_miembro_comite.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_miembro_comite.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_INICIO_FUNCIONES(results.getTimestamp(5));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_FIN_FUNCIONES(results.getTimestamp(6));
				tmpCgg_res_miembro_comite.setCRMBC_TITULAR(results.getBoolean(7));
				tmpCgg_res_miembro_comite.setCRMBC_AUTORIZADO(results.getBoolean(8));
				tmpCgg_res_miembro_comite.setCRMBC_ESTADO(results.getBoolean(9));
				outCgg_res_miembro_comite.add(tmpCgg_res_miembro_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_miembro_comite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_documento_identificacio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_DOCUMENTO_IDENTIFICACIO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_D_CGG_RES_DOCUMENTO_IDENTIFICACIO(?) }");
			stmDelete.setString(1, this.getCgg_res_miembro_comite().getCRDID_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_DS_CGG_RES_DOCUMENTO_IDENTIFICACIO(?) }");
				stmDelete.setString(1, this.getCgg_res_miembro_comite().getCRDID_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_cargo_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_miembro_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> selectCGG_RES_CARGO_COMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> outCgg_res_miembro_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_COMITE_S_CGG_RES_CARGO_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_miembro_comite().getCRCRG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_miembro_comite tmpCgg_res_miembro_comite = new com.besixplus.sii.objects.Cgg_res_miembro_comite();
				tmpCgg_res_miembro_comite.setCRMBC_CODIGO(results.getString(1));
				tmpCgg_res_miembro_comite.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_res_miembro_comite.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_miembro_comite.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_INICIO_FUNCIONES(results.getTimestamp(5));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_FIN_FUNCIONES(results.getTimestamp(6));
				tmpCgg_res_miembro_comite.setCRMBC_TITULAR(results.getBoolean(7));
				tmpCgg_res_miembro_comite.setCRMBC_AUTORIZADO(results.getBoolean(8));
				tmpCgg_res_miembro_comite.setCRMBC_ESTADO(results.getBoolean(9));
				outCgg_res_miembro_comite.add(tmpCgg_res_miembro_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_miembro_comite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_cargo_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_CARGO_COMITE(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_D_CGG_RES_CARGO_COMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_miembro_comite().getCRCRG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_DS_CGG_RES_CARGO_COMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_miembro_comite().getCRCRG_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_miembro_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> selectCGG_USUARIO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> outCgg_res_miembro_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_COMITE_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_miembro_comite().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_miembro_comite tmpCgg_res_miembro_comite = new com.besixplus.sii.objects.Cgg_res_miembro_comite();
				tmpCgg_res_miembro_comite.setCRMBC_CODIGO(results.getString(1));
				tmpCgg_res_miembro_comite.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_res_miembro_comite.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_miembro_comite.setCUSU_CODIGO(results.getString(4));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_INICIO_FUNCIONES(results.getTimestamp(5));
				tmpCgg_res_miembro_comite.setCRMBC_FECHA_FIN_FUNCIONES(results.getTimestamp(6));
				tmpCgg_res_miembro_comite.setCRMBC_TITULAR(results.getBoolean(7));
				tmpCgg_res_miembro_comite.setCRMBC_AUTORIZADO(results.getBoolean(8));
				tmpCgg_res_miembro_comite.setCRMBC_ESTADO(results.getBoolean(9));
				outCgg_res_miembro_comite.add(tmpCgg_res_miembro_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_miembro_comite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_miembro_comite().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MIEMBRO_COMITE_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_miembro_comite().getCUSU_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_miembro_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_miembro_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllMiembro(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_miembro_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MIEMBRO_USUARIO_PERSONA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_miembro_comite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_miembro_comite;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCountMiembro(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_RES_MIEMBRO_USUARIO_PERSONA_COUNT(?) }");
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

}