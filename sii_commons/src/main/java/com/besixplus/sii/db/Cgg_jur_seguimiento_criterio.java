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
 * CLASE Cgg_jur_seguimiento_criterio
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_seguimiento_criterio.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_jur_seguimiento_criterio implements Serializable{
	private static final long serialVersionUID = 1166500716;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio.
	 */
	private com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio myCgg_jur_seguimiento_criterio = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_seguimiento_criterio.
	 */
	public Cgg_jur_seguimiento_criterio(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_seguimiento_criterio.
	 * @param inCgg_jur_seguimiento_criterio OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_seguimiento_criterio.
	 */
	public Cgg_jur_seguimiento_criterio(
			com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio inCgg_jur_seguimiento_criterio
	){
		this.setCgg_jur_seguimiento_criterio(inCgg_jur_seguimiento_criterio);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_seguimiento_criterio.
	 * @param inCgg_jur_seguimiento_criterio OBJETO Cgg_jur_seguimiento_criterio.
	 * @return void
	 */
	public void setCgg_jur_seguimiento_criterio(com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio inCgg_jur_seguimiento_criterio){
		this.myCgg_jur_seguimiento_criterio = inCgg_jur_seguimiento_criterio;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_seguimiento_criterio.
	 * @return Cgg_jur_seguimiento_criterio OBJETO Cgg_jur_seguimiento_criterio.
	 */
	public com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio getCgg_jur_seguimiento_criterio(){
		return this.myCgg_jur_seguimiento_criterio;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_seguimiento_criterio().getCJSGC_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_seguimiento_criterio().getCRSEG_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_seguimiento_criterio().getCJCRI_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_jur_seguimiento_criterio().getCJSGC_RESPUESTA());
			stmInsert.setString(6, this.getCgg_jur_seguimiento_criterio().getCJSGC_JUSTIFICACION());
			stmInsert.setString(7, this.getCgg_jur_seguimiento_criterio().getCJSGC_OBSERVACION());
			stmInsert.setString(8, this.getCgg_jur_seguimiento_criterio().getCJSGC_NOMBRE_ADJUNTO());
			stmInsert.setBytes(9, this.getCgg_jur_seguimiento_criterio().getCJSGC_ADJUNTO());
			stmInsert.setBoolean(10, this.getCgg_jur_seguimiento_criterio().getCJSGC_ESTADO());
			stmInsert.setString(11, this.getCgg_jur_seguimiento_criterio().getCJSGC_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_jur_seguimiento_criterio().getCJSGC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_jur_seguimiento_criterio().setCJSGC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> outCgg_jur_seguimiento_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpCgg_jur_seguimiento_criterio = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
				tmpCgg_jur_seguimiento_criterio.setCJSGC_CODIGO(results.getString(1));
				tmpCgg_jur_seguimiento_criterio.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_jur_seguimiento_criterio.setCJCRI_CODIGO(results.getString(3));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_RESPUESTA(results.getBoolean(4));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_JUSTIFICACION(results.getString(5));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_OBSERVACION(results.getString(6));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_NOMBRE_ADJUNTO(results.getString(7));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ADJUNTO(results.getBytes(8));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ESTADO(results.getBoolean(9));
				outCgg_jur_seguimiento_criterio.add(tmpCgg_jur_seguimiento_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> outCgg_jur_seguimiento_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpCgg_jur_seguimiento_criterio = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
				tmpCgg_jur_seguimiento_criterio.setCJSGC_CODIGO(results.getString(1));
				tmpCgg_jur_seguimiento_criterio.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_jur_seguimiento_criterio.setCJCRI_CODIGO(results.getString(3));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_RESPUESTA(results.getBoolean(4));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_JUSTIFICACION(results.getString(5));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_OBSERVACION(results.getString(6));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_NOMBRE_ADJUNTO(results.getString(7));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ADJUNTO(results.getBytes(8));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ESTADO(results.getBoolean(9));
				outCgg_jur_seguimiento_criterio.add(tmpCgg_jur_seguimiento_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_seguimiento_criterio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_SELECT(?,?,?,?,?,?) }");
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
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_seguimiento_criterio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_seguimiento_criterio().getCJSGC_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_seguimiento_criterio().getCRSEG_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_seguimiento_criterio().getCJCRI_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_jur_seguimiento_criterio().getCJSGC_RESPUESTA());
			stmUpdate.setString(5, this.getCgg_jur_seguimiento_criterio().getCJSGC_JUSTIFICACION());
			stmUpdate.setString(6, this.getCgg_jur_seguimiento_criterio().getCJSGC_OBSERVACION());
			stmUpdate.setString(7, this.getCgg_jur_seguimiento_criterio().getCJSGC_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(8, this.getCgg_jur_seguimiento_criterio().getCJSGC_ADJUNTO());
			stmUpdate.setBoolean(9, this.getCgg_jur_seguimiento_criterio().getCJSGC_ESTADO());
			stmUpdate.setString(10, this.getCgg_jur_seguimiento_criterio().getCJSGC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_seguimiento_criterio DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_seguimiento_criterio().getCJSGC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_seguimiento_criterio().setCJSGC_CODIGO(results.getString(1));
				this.getCgg_jur_seguimiento_criterio().setCRSEG_CODIGO(results.getString(2));
				this.getCgg_jur_seguimiento_criterio().setCJCRI_CODIGO(results.getString(3));
				this.getCgg_jur_seguimiento_criterio().setCJSGC_RESPUESTA(results.getBoolean(4));
				this.getCgg_jur_seguimiento_criterio().setCJSGC_JUSTIFICACION(results.getString(5));
				this.getCgg_jur_seguimiento_criterio().setCJSGC_OBSERVACION(results.getString(6));
				this.getCgg_jur_seguimiento_criterio().setCJSGC_NOMBRE_ADJUNTO(results.getString(7));
				this.getCgg_jur_seguimiento_criterio().setCJSGC_ADJUNTO(results.getBytes(8));
				this.getCgg_jur_seguimiento_criterio().setCJSGC_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_seguimiento_criterio();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_seguimiento_criterio DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_seguimiento_criterio().getCJSGC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_seguimiento_criterio().getCJSGC_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> selectCGG_JUR_CRITERIO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> outCgg_jur_seguimiento_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_S_CGG_JUR_CRITERIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_seguimiento_criterio().getCJCRI_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpCgg_jur_seguimiento_criterio = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
				tmpCgg_jur_seguimiento_criterio.setCJSGC_CODIGO(results.getString(1));
				tmpCgg_jur_seguimiento_criterio.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_jur_seguimiento_criterio.setCJCRI_CODIGO(results.getString(3));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_RESPUESTA(results.getBoolean(4));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_JUSTIFICACION(results.getString(5));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_OBSERVACION(results.getString(6));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_NOMBRE_ADJUNTO(results.getString(7));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ADJUNTO(results.getBytes(8));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ESTADO(results.getBoolean(9));
				outCgg_jur_seguimiento_criterio.add(tmpCgg_jur_seguimiento_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_JUR_CRITERIO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_D_CGG_JUR_CRITERIO(?) }");
			stmDelete.setString(1, this.getCgg_jur_seguimiento_criterio().getCJCRI_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_DS_CGG_JUR_CRITERIO(?) }");
				stmDelete.setString(1, this.getCgg_jur_seguimiento_criterio().getCJCRI_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> selectCGG_RES_SEGUIMIENTO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> outCgg_jur_seguimiento_criterio = new ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_seguimiento_criterio().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpCgg_jur_seguimiento_criterio = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
				tmpCgg_jur_seguimiento_criterio.setCJSGC_CODIGO(results.getString(1));
				tmpCgg_jur_seguimiento_criterio.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_jur_seguimiento_criterio.setCJCRI_CODIGO(results.getString(3));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_RESPUESTA(results.getBoolean(4));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_JUSTIFICACION(results.getString(5));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_OBSERVACION(results.getString(6));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_NOMBRE_ADJUNTO(results.getString(7));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ADJUNTO(results.getBytes(8));
				tmpCgg_jur_seguimiento_criterio.setCJSGC_ESTADO(results.getBoolean(9));
				outCgg_jur_seguimiento_criterio.add(tmpCgg_jur_seguimiento_criterio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_SEGUIMIENTO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_jur_seguimiento_criterio().getCRSEG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}
	
	/**
	 * SELECCIONA TODOS LOS CRITERIOS JURIDICOS A CUMPLIRSE PARA UN SEGUIMIENTO DE ACUERDO A SU FASE.
	 * LA CONSULTA SELECCIONA EN BASE AL CODIGO DE SEGUIMIENTO CUANDO SE EDITA INFORMACION Y A LA FASE CUANDO LA INFORMACION ES NUEVA REGISTRARSE.
	 * LA SELECCION INTERNA REALIZA UN LEFT JOIN CON LA INFORMACION DE LAS TABLAS SEGUIMIENTO,SEGUIMIENTO_CRITERIO, CRITERIO Y FASE.
	 * @param inCrfas_codigo CODIGO DE FASE
	 * @param inCrseg_codigo CODIGO DE SEGUIMIENTO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION CON INFORMACION DE LOS CRITERIOS JURIDICOS DE UN SEGUIMIENTO.
	 */
	public ArrayList<HashMap<String,Object>> selectSEGUIMIENTO_CRITERIO(
			String inCrfas_codigo,
			String inCrseg_codigo,
			java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_seguimiento_criterio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_JUR_SEGUIMIENTO_CRITERIO_CUMPLIMIENTO(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrfas_codigo);
			stmSelect.setString(3,inCrseg_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);			
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_seguimiento_criterio.add(tmpObj);
			}							
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllDirectJuridico(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_seguimiento_criterio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_TRAMITE_JURIDICO_SELECT(?,?,?,?,?,?) }");
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
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_jur_seguimiento_criterio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_seguimiento_criterio;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCountJuridico(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_COUNT() }");
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
	public static int selectCountJuridico(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCountJuridico(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_SEGUIMIENTO_CRITERIO_COUNT(?) }");
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