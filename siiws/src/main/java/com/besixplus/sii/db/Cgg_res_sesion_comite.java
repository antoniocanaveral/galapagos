package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

/**
* CLASE Cgg_res_sesion_comite
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_sesion_comite.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_sesion_comite implements Serializable{
	private static final long serialVersionUID = 1037866139;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_sesion_comite.
	*/
	private com.besixplus.sii.objects.Cgg_res_sesion_comite myCgg_res_sesion_comite = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_comite.
	*/
	public Cgg_res_sesion_comite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_comite.
	* @param inCgg_res_sesion_comite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_sesion_comite.
	*/
	public Cgg_res_sesion_comite(
		com.besixplus.sii.objects.Cgg_res_sesion_comite inCgg_res_sesion_comite
	){
		this.setCgg_res_sesion_comite(inCgg_res_sesion_comite);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_sesion_comite.
	* @param inCgg_res_sesion_comite OBJETO Cgg_res_sesion_comite.
	* @return void
	*/
	public void setCgg_res_sesion_comite(com.besixplus.sii.objects.Cgg_res_sesion_comite inCgg_res_sesion_comite){
		this.myCgg_res_sesion_comite = inCgg_res_sesion_comite;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_sesion_comite.
	* @return Cgg_res_sesion_comite OBJETO Cgg_res_sesion_comite.
	*/
	public com.besixplus.sii.objects.Cgg_res_sesion_comite getCgg_res_sesion_comite(){
		return this.myCgg_res_sesion_comite;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_sesion_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_sesion_comite().getCRSSC_CODIGO());
			stmInsert.setString(3, this.getCgg_res_sesion_comite().getCISLA_CODIGO());
			stmInsert.setString(4, this.getCgg_res_sesion_comite().getCRCOM_CODIGO());
			stmInsert.setTimestamp(5, this.getCgg_res_sesion_comite().getCRSSC_FECHA_REUNION()!=null?new java.sql.Timestamp(this.getCgg_res_sesion_comite().getCRSSC_FECHA_REUNION().getTime()):null);
			stmInsert.setTimestamp(6, this.getCgg_res_sesion_comite().getCRSSC_FECHA_FINALIZACION()!=null?new java.sql.Timestamp(this.getCgg_res_sesion_comite().getCRSSC_FECHA_FINALIZACION().getTime()):null);
			stmInsert.setString(7, this.getCgg_res_sesion_comite().getCRSSC_NUMERO_SESION());
			stmInsert.setString(8, this.getCgg_res_sesion_comite().getCRSSC_EXTRACTO());
			stmInsert.setString(9, this.getCgg_res_sesion_comite().getCRSSC_OBSERVACION());
			stmInsert.setTimestamp(10, new java.sql.Timestamp(this.getCgg_res_sesion_comite().getCRSSC_FECHA_CONVOCATORIA().getTime()));
			stmInsert.setString(11, this.getCgg_res_sesion_comite().getCRSSC_MOTIVO_CONVOCATORIA());
			stmInsert.setString(12, this.getCgg_res_sesion_comite().getCRSSC_DESCRIPCION_ADJUNTO());
			stmInsert.setString(13, this.getCgg_res_sesion_comite().getCRSSC_NOMBRE_ADJUNTO());
			stmInsert.setBytes(14, this.getCgg_res_sesion_comite().getCRSSC_ADJUNTO());
			stmInsert.setInt(15, this.getCgg_res_sesion_comite().getCRSSC_ESTADO_CONVOCATORIA());
			stmInsert.setBoolean(16, this.getCgg_res_sesion_comite().getCRSSC_ESTADO());
			stmInsert.setString(17, this.getCgg_res_sesion_comite().getCRSSC_USUARIO_INSERT());
			stmInsert.setString(18, this.getCgg_res_sesion_comite().getCRSSC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_sesion_comite().setCRSSC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> outCgg_res_sesion_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_sesion_comite tmpCgg_res_sesion_comite = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
				tmpCgg_res_sesion_comite.setCRSSC_CODIGO(results.getString(1));
				tmpCgg_res_sesion_comite.setCISLA_CODIGO(results.getString(2));
				tmpCgg_res_sesion_comite.setCRCOM_CODIGO(results.getString(3));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_REUNION(results.getTimestamp(4));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_FINALIZACION(results.getTimestamp(5));
				tmpCgg_res_sesion_comite.setCRSSC_NUMERO_SESION(results.getString(6));
				tmpCgg_res_sesion_comite.setCRSSC_EXTRACTO(results.getString(7));
				tmpCgg_res_sesion_comite.setCRSSC_OBSERVACION(results.getString(8));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_CONVOCATORIA(results.getTimestamp(9));
				tmpCgg_res_sesion_comite.setCRSSC_MOTIVO_CONVOCATORIA(results.getString(10));
				tmpCgg_res_sesion_comite.setCRSSC_DESCRIPCION_ADJUNTO(results.getString(11));
				tmpCgg_res_sesion_comite.setCRSSC_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_sesion_comite.setCRSSC_ADJUNTO(results.getBytes(13));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO_CONVOCATORIA(results.getInt(14));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO(results.getBoolean(15));
				outCgg_res_sesion_comite.add(tmpCgg_res_sesion_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_sesion_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_sesion_comite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_sesion_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_UPDATE_ADJUNTO(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_sesion_comite().getCRSSC_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_sesion_comite().getCISLA_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_sesion_comite().getCRCOM_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_sesion_comite().getCRSSC_FECHA_REUNION().getTime()));
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_res_sesion_comite().getCRSSC_FECHA_FINALIZACION().getTime()));
			stmUpdate.setString(6, this.getCgg_res_sesion_comite().getCRSSC_NUMERO_SESION());
			stmUpdate.setString(7, this.getCgg_res_sesion_comite().getCRSSC_EXTRACTO());
			stmUpdate.setString(8, this.getCgg_res_sesion_comite().getCRSSC_OBSERVACION());
			stmUpdate.setTimestamp(9, new java.sql.Timestamp(this.getCgg_res_sesion_comite().getCRSSC_FECHA_CONVOCATORIA().getTime()));
			stmUpdate.setString(10, this.getCgg_res_sesion_comite().getCRSSC_MOTIVO_CONVOCATORIA());
			stmUpdate.setString(11, this.getCgg_res_sesion_comite().getCRSSC_DESCRIPCION_ADJUNTO());
			stmUpdate.setString(12, this.getCgg_res_sesion_comite().getCRSSC_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(13, this.getCgg_res_sesion_comite().getCRSSC_ADJUNTO());
			stmUpdate.setInt(14, this.getCgg_res_sesion_comite().getCRSSC_ESTADO_CONVOCATORIA());
			stmUpdate.setBoolean(15, this.getCgg_res_sesion_comite().getCRSSC_ESTADO());
			stmUpdate.setString(16, this.getCgg_res_sesion_comite().getCRSSC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_sesion_comite DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_sesion_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_sesion_comite select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_sesion_comite().getCRSSC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_sesion_comite().setCRSSC_CODIGO(results.getString(1));
				this.getCgg_res_sesion_comite().setCISLA_CODIGO(results.getString(2));
				this.getCgg_res_sesion_comite().setCRCOM_CODIGO(results.getString(3));
				this.getCgg_res_sesion_comite().setCRSSC_FECHA_REUNION(results.getTimestamp(4));
				this.getCgg_res_sesion_comite().setCRSSC_FECHA_FINALIZACION(results.getTimestamp(5));
				this.getCgg_res_sesion_comite().setCRSSC_NUMERO_SESION(results.getString(6));
				this.getCgg_res_sesion_comite().setCRSSC_EXTRACTO(results.getString(7));
				this.getCgg_res_sesion_comite().setCRSSC_OBSERVACION(results.getString(8));
				this.getCgg_res_sesion_comite().setCRSSC_FECHA_CONVOCATORIA(results.getTimestamp(9));
				this.getCgg_res_sesion_comite().setCRSSC_MOTIVO_CONVOCATORIA(results.getString(10));
				this.getCgg_res_sesion_comite().setCRSSC_DESCRIPCION_ADJUNTO(results.getString(11));
				this.getCgg_res_sesion_comite().setCRSSC_NOMBRE_ADJUNTO(results.getString(12));
				this.getCgg_res_sesion_comite().setCRSSC_ADJUNTO(results.getBytes(13));
				this.getCgg_res_sesion_comite().setCRSSC_ESTADO_CONVOCATORIA(results.getInt(14));
				this.getCgg_res_sesion_comite().setCRSSC_ESTADO(results.getBoolean(15));
				this.getCgg_res_sesion_comite().setCRSSC_USUARIO_INSERT(results.getString(17));
				this.getCgg_res_sesion_comite().setCRSSC_USUARIO_UPDATE(results.getString(18));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_sesion_comite();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_sesion_comite DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_sesion_comite().getCRSSC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_sesion_comite().getCRSSC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_sesion_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> selectCGG_ISLA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> outCgg_res_sesion_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_S_CGG_ISLA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_sesion_comite().getCISLA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_sesion_comite tmpCgg_res_sesion_comite = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
				tmpCgg_res_sesion_comite.setCRSSC_CODIGO(results.getString(1));
				tmpCgg_res_sesion_comite.setCISLA_CODIGO(results.getString(2));
				tmpCgg_res_sesion_comite.setCRCOM_CODIGO(results.getString(3));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_REUNION(results.getTimestamp(4));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_FINALIZACION(results.getTimestamp(5));
				tmpCgg_res_sesion_comite.setCRSSC_NUMERO_SESION(results.getString(6));
				tmpCgg_res_sesion_comite.setCRSSC_EXTRACTO(results.getString(7));
				tmpCgg_res_sesion_comite.setCRSSC_OBSERVACION(results.getString(8));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_CONVOCATORIA(results.getTimestamp(9));
				tmpCgg_res_sesion_comite.setCRSSC_MOTIVO_CONVOCATORIA(results.getString(10));
				tmpCgg_res_sesion_comite.setCRSSC_DESCRIPCION_ADJUNTO(results.getString(11));
				tmpCgg_res_sesion_comite.setCRSSC_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_sesion_comite.setCRSSC_ADJUNTO(results.getBytes(13));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO_CONVOCATORIA(results.getInt(14));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO(results.getBoolean(15));
				outCgg_res_sesion_comite.add(tmpCgg_res_sesion_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_ISLA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_D_CGG_ISLA(?) }");
			stmDelete.setString(1, this.getCgg_res_sesion_comite().getCISLA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_DS_CGG_ISLA(?) }");
				stmDelete.setString(1, this.getCgg_res_sesion_comite().getCISLA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_sesion_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> selectCGG_RES_COMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> outCgg_res_sesion_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_S_CGG_RES_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_sesion_comite().getCRCOM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_sesion_comite tmpCgg_res_sesion_comite = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
				tmpCgg_res_sesion_comite.setCRSSC_CODIGO(results.getString(1));
				tmpCgg_res_sesion_comite.setCISLA_CODIGO(results.getString(2));
				tmpCgg_res_sesion_comite.setCRCOM_CODIGO(results.getString(3));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_REUNION(results.getTimestamp(4));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_FINALIZACION(results.getTimestamp(5));
				tmpCgg_res_sesion_comite.setCRSSC_NUMERO_SESION(results.getString(6));
				tmpCgg_res_sesion_comite.setCRSSC_EXTRACTO(results.getString(7));
				tmpCgg_res_sesion_comite.setCRSSC_OBSERVACION(results.getString(8));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_CONVOCATORIA(results.getTimestamp(9));
				tmpCgg_res_sesion_comite.setCRSSC_MOTIVO_CONVOCATORIA(results.getString(10));
				tmpCgg_res_sesion_comite.setCRSSC_DESCRIPCION_ADJUNTO(results.getString(11));
				tmpCgg_res_sesion_comite.setCRSSC_NOMBRE_ADJUNTO(results.getString(12));
				tmpCgg_res_sesion_comite.setCRSSC_ADJUNTO(results.getBytes(13));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO_CONVOCATORIA(results.getInt(14));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO(results.getBoolean(15));
				outCgg_res_sesion_comite.add(tmpCgg_res_sesion_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_comite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_D_CGG_RES_COMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_sesion_comite().getCRCOM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_SESION_COMITE_DS_CGG_RES_COMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_sesion_comite().getCRCOM_CODIGO());
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
	* GENERA EL NUMERO DE SESION DE COMITE DE LA TABLA Cgg_res_sesion_comite
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	* @return valorSesion EL NUMERO DE GENERADO PARA CADA SESION DE COMITE.
	* 	*/
	public static String numeroSesion(
		java.sql.Connection inConnection,
		String inCisla_codigo
	){
		String valorSesion=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GENERA_NUM_SESION_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setString(2, inCisla_codigo);
			stmSelect.execute();
			valorSesion = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorSesion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/ 
	public static int tramitesSesionCount(
		java.sql.Connection inConnection,
		String inCrssc_codigo,
		String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_COMITE_SESION_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrssc_codigo);
			stmSelect.setString(3, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> tramitesSesion(		
		java.sql.Connection inConnection,	
		String inUserName,		
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCrssc_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_sesion_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_COMITE_SESION(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);		
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrssc_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_sesion_comite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
	}
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tramite_comite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION.
	* @return com.besixplus.sii.objects.Cgg_res_tramite_comite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String, Object>> selectCGG_RES_SESION_TRAMITE(
			java.sql.Connection inConnection,
			String inCrssc_codigo
		){
			ArrayList<HashMap<String, Object>> outCgg_res_sesion_comite = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TRAMITE_COMITE_SESION_SELECT(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCrssc_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					
					outCgg_res_sesion_comite.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_sesion_comite;
		}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> selectAllAprobado(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> outCgg_res_sesion_comite = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_APROBADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_sesion_comite tmpCgg_res_sesion_comite = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
				tmpCgg_res_sesion_comite.setCRSSC_CODIGO(results.getString(1));
				tmpCgg_res_sesion_comite.setCISLA_CODIGO(results.getString(2));
				tmpCgg_res_sesion_comite.setISLA(results.getString(3));
				tmpCgg_res_sesion_comite.setCRCOM_CODIGO(results.getString(4));
				tmpCgg_res_sesion_comite.setCOMITE(results.getString(5));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_REUNION(results.getTimestamp(6));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_FINALIZACION(results.getTimestamp(7));
				tmpCgg_res_sesion_comite.setCRSSC_NUMERO_SESION(results.getString(8));
				tmpCgg_res_sesion_comite.setCRSSC_EXTRACTO(results.getString(9));
				tmpCgg_res_sesion_comite.setCRSSC_OBSERVACION(results.getString(10));
				tmpCgg_res_sesion_comite.setCRSSC_FECHA_CONVOCATORIA(results.getTimestamp(11));
				tmpCgg_res_sesion_comite.setCRSSC_MOTIVO_CONVOCATORIA(results.getString(12));
				tmpCgg_res_sesion_comite.setCRSSC_DESCRIPCION_ADJUNTO(results.getString(13));
				tmpCgg_res_sesion_comite.setCRSSC_NOMBRE_ADJUNTO(results.getString(14));				
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO_CONVOCATORIA(results.getInt(15));
				tmpCgg_res_sesion_comite.setCRSSC_ESTADO(results.getBoolean(16));
				outCgg_res_sesion_comite.add(tmpCgg_res_sesion_comite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_sesion_comite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCountAprobado(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_APROBADO_COUNT() }");
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
	public static int selectCountAprobado(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCountAprobado(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_COMITE_APROBADO_COUNT(?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.	
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllSesionAdjunto(
		java.sql.Connection inConnection,
		String inCrssc_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_res_sesion_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_SESION_ADJUNTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrssc_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_sesion_comite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_sesion_comite;
	}
	
	/**
	 * OBTIENE LOS VOTOS DATOS SOBRE LOS TRAMITES O RESOLUCIONES TRATADAS EN UNA SESION
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inTramites <code>true</code> SOLO TRAMITES
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> selectVotos(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			boolean inTramites
		){
			ArrayList<HashMap<String, Object>> outCgg_res_sesion_comite = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_SC_TRAMITE_VOTOS(?,?,?,?,?,?,?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inUserName);
				stmSelect.setInt(3, inStart);
				stmSelect.setInt(4, inLimit);
				stmSelect.setString(5, inSortFieldName);
				stmSelect.setString(6, inDirection);
				stmSelect.setString(7, inKeyword);
				stmSelect.setString(8, getCgg_res_sesion_comite().getCRSSC_CODIGO());
				stmSelect.setBoolean(9, inTramites);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					
					outCgg_res_sesion_comite.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_sesion_comite;
		}
	
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inTramites IDENTIFICATIVO DE TRAMITES.
	* @return int NUMERO DE REGISTROS.
	*/
	public int selectVotosCount(
		java.sql.Connection inConnection,
		String inKeyword,
		boolean inTramites
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_SC_TRAMITE_VOTOS_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, getCgg_res_sesion_comite().getCRSSC_CODIGO());
			stmSelect.setBoolean(4, inTramites);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
}