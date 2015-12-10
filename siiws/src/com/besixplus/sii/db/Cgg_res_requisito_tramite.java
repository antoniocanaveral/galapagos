package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

import com.besixplus.sii.objects.Cgg_res_adjunto;

/**
 * CLASE Cgg_res_requisito_tramite
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_requisito_tramite.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_requisito_tramite implements Serializable{
	private static final long serialVersionUID = 77657195;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_requisito_tramite.
	 */
	private com.besixplus.sii.objects.Cgg_res_requisito_tramite myCgg_res_requisito_tramite = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_requisito_tramite.
	 */
	public Cgg_res_requisito_tramite(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_requisito_tramite.
	 * @param inCgg_res_requisito_tramite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_requisito_tramite.
	 */
	public Cgg_res_requisito_tramite(
			com.besixplus.sii.objects.Cgg_res_requisito_tramite inCgg_res_requisito_tramite
	){
		this.setCgg_res_requisito_tramite(inCgg_res_requisito_tramite);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_requisito_tramite.
	 * @param inCgg_res_requisito_tramite OBJETO Cgg_res_requisito_tramite.
	 * @return void
	 */
	public void setCgg_res_requisito_tramite(com.besixplus.sii.objects.Cgg_res_requisito_tramite inCgg_res_requisito_tramite){
		this.myCgg_res_requisito_tramite = inCgg_res_requisito_tramite;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_requisito_tramite.
	 * @return Cgg_res_requisito_tramite OBJETO Cgg_res_requisito_tramite.
	 */
	public com.besixplus.sii.objects.Cgg_res_requisito_tramite getCgg_res_requisito_tramite(){
		return this.myCgg_res_requisito_tramite;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_requisito_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_requisito_tramite().getCRRQT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_requisito_tramite().getCRTRA_CODIGO());
			stmInsert.setString(4, this.getCgg_res_requisito_tramite().getCRSRQ_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_res_requisito_tramite().getCRRQT_CUMPLE());
			stmInsert.setString(6, this.getCgg_res_requisito_tramite().getCRRQT_OBSERVACION());
			stmInsert.setBoolean(7, this.getCgg_res_requisito_tramite().getCRRQT_ESTADO());
			stmInsert.setString(8, this.getCgg_res_requisito_tramite().getCRRQT_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_res_requisito_tramite().getCRRQT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_requisito_tramite().setCRRQT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> outCgg_res_requisito_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_requisito_tramite tmpCgg_res_requisito_tramite = new com.besixplus.sii.objects.Cgg_res_requisito_tramite();
				tmpCgg_res_requisito_tramite.setCRRQT_CODIGO(results.getString(1));
				tmpCgg_res_requisito_tramite.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_requisito_tramite.setCRSRQ_CODIGO(results.getString(3));
				tmpCgg_res_requisito_tramite.setCRRQT_CUMPLE(results.getBoolean(4));
				tmpCgg_res_requisito_tramite.setCRRQT_OBSERVACION(results.getString(5));
				tmpCgg_res_requisito_tramite.setCRRQT_ESTADO(results.getBoolean(6));
				outCgg_res_requisito_tramite.add(tmpCgg_res_requisito_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> outCgg_res_requisito_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_requisito_tramite tmpCgg_res_requisito_tramite = new com.besixplus.sii.objects.Cgg_res_requisito_tramite();
				tmpCgg_res_requisito_tramite.setCRRQT_CODIGO(results.getString(1));
				tmpCgg_res_requisito_tramite.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_requisito_tramite.setCRSRQ_CODIGO(results.getString(3));
				tmpCgg_res_requisito_tramite.setCRRQT_CUMPLE(results.getBoolean(4));
				tmpCgg_res_requisito_tramite.setCRRQT_OBSERVACION(results.getString(5));
				tmpCgg_res_requisito_tramite.setCRRQT_ESTADO(results.getBoolean(6));
				outCgg_res_requisito_tramite.add(tmpCgg_res_requisito_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_requisito_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_requisito_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_requisito_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_requisito_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public boolean update(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_TRAMITE_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_requisito_tramite().getCRRQT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_requisito_tramite().getCRTRA_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_requisito_tramite().getCRSRQ_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_res_requisito_tramite().getCRRQT_CUMPLE());
			stmUpdate.setString(5, this.getCgg_res_requisito_tramite().getCRRQT_OBSERVACION());
			stmUpdate.setBoolean(6, this.getCgg_res_requisito_tramite().getCRRQT_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_requisito_tramite().getCRRQT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_requisito_tramite DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_requisito_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_requisito_tramite select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_requisito_tramite().getCRRQT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_requisito_tramite().setCRRQT_CODIGO(results.getString(1));
				this.getCgg_res_requisito_tramite().setCRTRA_CODIGO(results.getString(2));
				this.getCgg_res_requisito_tramite().setCRSRQ_CODIGO(results.getString(3));
				this.getCgg_res_requisito_tramite().setCRRQT_CUMPLE(results.getBoolean(4));
				this.getCgg_res_requisito_tramite().setCRRQT_OBSERVACION(results.getString(5));
				this.getCgg_res_requisito_tramite().setCRRQT_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_requisito_tramite();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_requisito_tramite DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_TRAMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_requisito_tramite().getCRRQT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_TRAMITE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_requisito_tramite().getCRRQT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_requisito_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> selectCGG_RES_TRAMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> outCgg_res_requisito_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_S_CGG_RES_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_requisito_tramite().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_requisito_tramite tmpCgg_res_requisito_tramite = new com.besixplus.sii.objects.Cgg_res_requisito_tramite();
				tmpCgg_res_requisito_tramite.setCRRQT_CODIGO(results.getString(1));
				tmpCgg_res_requisito_tramite.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_requisito_tramite.setCRSRQ_CODIGO(results.getString(3));
				tmpCgg_res_requisito_tramite.setCRRQT_CUMPLE(results.getBoolean(4));
				tmpCgg_res_requisito_tramite.setCRRQT_OBSERVACION(results.getString(5));
				tmpCgg_res_requisito_tramite.setCRRQT_ESTADO(results.getBoolean(6));
				outCgg_res_requisito_tramite.add(tmpCgg_res_requisito_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return boolean <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_TRAMITE(
			java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_TRAMITE_D_CGG_RES_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_requisito_tramite().getCRTRA_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_solicitud_requisito.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_requisito_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> selectCGG_RES_SOLICITUD_REQUISITO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite> outCgg_res_requisito_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_requisito_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_TRAMITE_S_CGG_RES_SOLICITUD_REQUISITO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_requisito_tramite().getCRSRQ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_requisito_tramite tmpCgg_res_requisito_tramite = new com.besixplus.sii.objects.Cgg_res_requisito_tramite();
				tmpCgg_res_requisito_tramite.setCRRQT_CODIGO(results.getString(1));
				tmpCgg_res_requisito_tramite.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_requisito_tramite.setCRSRQ_CODIGO(results.getString(3));
				tmpCgg_res_requisito_tramite.setCRRQT_CUMPLE(results.getBoolean(4));
				tmpCgg_res_requisito_tramite.setCRRQT_OBSERVACION(results.getString(5));
				tmpCgg_res_requisito_tramite.setCRRQT_ESTADO(results.getBoolean(6));
				outCgg_res_requisito_tramite.add(tmpCgg_res_requisito_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_requisito_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_solicitud_requisito.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_SOLICITUD_REQUISITO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_TRAMITE_D_CGG_RES_SOLICITUD_REQUISITO(?) }");
			stmDelete.setString(1, this.getCgg_res_requisito_tramite().getCRSRQ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_TRAMITE_DS_CGG_RES_SOLICITUD_REQUISITO(?) }");
				stmDelete.setString(1, this.getCgg_res_requisito_tramite().getCRSRQ_CODIGO());
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
	 * Devuleve un vector dinamico con informacion de la consulta de tramite, requisito-tramite, requisito-solicitud-tramite, requisito.
	 * @param inConnection Conexion de datos.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param inCrtst_codigo Codigo de solicitud de tipo de tramite para requerimiento.
	 * @return Vector de datos.
	 */
	public ArrayList<HashMap<String,Object>> selectRequisitoTramite(
			java.sql.Connection inConnection,
			String inCrtra_codigo,
			String inCrtst_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_requisito_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_SELECT_REQUISITOTIPOSOLICITUDTRAMITE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);				
			stmSelect.setString(2,inCrtst_codigo);
			stmSelect.setString(3,inCrtra_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++){												
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				}
				outCgg_res_requisito_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}
	
	/**
	 * Selecciona todos lo requisitos de un tramite junto con informacion del adjunto que esta relacionado con los requisitos.
	 * @param inConnection Conexion de datos.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param inCrtst_codigo Codigo de solicitud de tipo de tramite para requerimiento.
	 * @return Vector de datos.
	 */
	public ArrayList<HashMap<String,Object>> selectRequisitoAjdunto(
			java.sql.Connection inConnection,
			String inCrtra_codigo,
			String inCrtst_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_requisito_tramite = new ArrayList<HashMap<String,Object>>();
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_SELECT_REQUISITOTIPOSOLICITUDTRAMITE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);				
			stmSelect.setString(2,inCrtst_codigo);
			stmSelect.setString(3,inCrtra_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++){												
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					if(results.getMetaData().getColumnName(i).toUpperCase().equalsIgnoreCase("CRRQT_CODIGO")==true){
						ArrayList<Cgg_res_adjunto> colAdjuntoRequisito = new ArrayList<Cgg_res_adjunto>();
						Cgg_res_adjunto tmpAdjunto = new Cgg_res_adjunto();
						tmpAdjunto.setCRRQT_CODIGO(results.getString(i));
						colAdjuntoRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(tmpAdjunto).selectCGG_RES_REQUISITO_TRAMITE(inConnection);
						if(colAdjuntoRequisito.size()>=1){
							tmpAdjunto = colAdjuntoRequisito.get(0);
							tmpAdjunto.setCRADJ_ARCHIVO_ADJUNTO(null);
						}else{
							tmpAdjunto=null;
						}						
						tmpObj.put("CRADJ_DATA",tmpAdjunto);
					}
				}													
				outCgg_res_requisito_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito_tramite;
	}

}