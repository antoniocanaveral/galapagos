package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
 * CLASE Cgg_res_resolucion
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_resolucion.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_resolucion implements Serializable{
	private static final long serialVersionUID = 1268132926;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_resolucion.
	 */
	private com.besixplus.sii.objects.Cgg_res_resolucion myCgg_res_resolucion = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_resolucion.
	 */
	public Cgg_res_resolucion(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_resolucion.
	 * @param inCgg_res_resolucion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_resolucion.
	 */
	public Cgg_res_resolucion(
			com.besixplus.sii.objects.Cgg_res_resolucion inCgg_res_resolucion
	){
		this.setCgg_res_resolucion(inCgg_res_resolucion);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_resolucion.
	 * @param inCgg_res_resolucion OBJETO Cgg_res_resolucion.
	 * @return void
	 */
	public void setCgg_res_resolucion(com.besixplus.sii.objects.Cgg_res_resolucion inCgg_res_resolucion){
		this.myCgg_res_resolucion = inCgg_res_resolucion;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_resolucion.
	 * @return Cgg_res_resolucion OBJETO Cgg_res_resolucion.
	 */
	public com.besixplus.sii.objects.Cgg_res_resolucion getCgg_res_resolucion(){
		return this.myCgg_res_resolucion;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SQLException 
	 */
	public String insert(
			java.sql.Connection inConnection
	) throws SQLException{
		String outResult = "true";
		CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_INSERT(?,?,?,?::smallint,?,?,?::smallint,?::smallint,?::smallint,?,?,?,?,?,?,?,?,?,?,?,?,?,?::smallint,?,?,?) }");
		stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
		stmInsert.setString(2, this.getCgg_res_resolucion().getCRRES_CODIGO());
		stmInsert.setString(3, this.getCgg_res_resolucion().getCRSSC_CODIGO());
		stmInsert.setString(4, this.getCgg_res_resolucion().getCRRES_NUMERO_RESOLUCION());
		stmInsert.setInt(5, this.getCgg_res_resolucion().getCRRES_TIPO());
		stmInsert.setString(6, this.getCgg_res_resolucion().getCRRES_OBSERVACIONES());
		stmInsert.setString(7, this.getCgg_res_resolucion().getCRRES_EXTRACTO_RESOLUCION());
		stmInsert.setInt(8, this.getCgg_res_resolucion().getCRRES_VOTOS_APROBACION());
		stmInsert.setInt(9, this.getCgg_res_resolucion().getCRRES_VOTOS_NEGACION());
		stmInsert.setInt(10, this.getCgg_res_resolucion().getCRRES_VOTOS_ABSTENCION());
		stmInsert.setTimestamp(11, new java.sql.Timestamp(getCgg_res_resolucion().getCRRES_FECHA_EMISION()!=null?this.getCgg_res_resolucion().getCRRES_FECHA_EMISION().getTime():new Date().getTime()));			
		stmInsert.setTimestamp(12, new java.sql.Timestamp(getCgg_res_resolucion().getCRRES_FECHA_EJECUCION()!=null?this.getCgg_res_resolucion().getCRRES_FECHA_EJECUCION().getTime():new Date().getTime()));
		stmInsert.setTimestamp(13, this.getCgg_res_resolucion().getCRRES_FECHA_ANULACION()!=null? new java.sql.Timestamp(this.getCgg_res_resolucion().getCRRES_FECHA_ANULACION().getTime()):null);
		stmInsert.setTimestamp(14, this.getCgg_res_resolucion().getCRRES_FECHA_CONFIRMACION()!=null?new java.sql.Timestamp(this.getCgg_res_resolucion().getCRRES_FECHA_CONFIRMACION().getTime()):null);
		stmInsert.setString(15, this.getCgg_res_resolucion().getCRRES_RESOLUCION_REEMPLAZA());
		stmInsert.setString(16, this.getCgg_res_resolucion().getCRRES_NOMBRE_ADJUNTO_RESOL());
		stmInsert.setBytes(17, this.getCgg_res_resolucion().getCRRES_ADJUNTO_RESOLUCION());
		stmInsert.setString(18, this.getCgg_res_resolucion().getCRRES_DESCRIPCION_ADJUNTO());
		stmInsert.setTimestamp(19, this.getCgg_res_resolucion().getCRRES_FECHA_APELACION()!=null?new java.sql.Timestamp(this.getCgg_res_resolucion().getCRRES_FECHA_APELACION().getTime()):null);
		stmInsert.setString(20, this.getCgg_res_resolucion().getCRRES_EXTRACTO_APELACION());
		stmInsert.setString(21, this.getCgg_res_resolucion().getCRRES_NUMERO_APELACION());
		stmInsert.setString(22, this.getCgg_res_resolucion().getCRRES_NOMBRE_ADJUNTO_APELAC());
		stmInsert.setBytes(23, this.getCgg_res_resolucion().getCRRES_ADJUNTO_APELACION());
		stmInsert.setInt(24, this.getCgg_res_resolucion().getCRRES_ESTADO_RESOLUCION());
		stmInsert.setBoolean(25, this.getCgg_res_resolucion().getCRRES_ESTADO());
		stmInsert.setString(26, this.getCgg_res_resolucion().getCRRES_USUARIO_INSERT());
		stmInsert.setString(27, this.getCgg_res_resolucion().getCRRES_USUARIO_UPDATE());
		stmInsert.execute();
		this.getCgg_res_resolucion().setCRRES_CODIGO(stmInsert.getString(1));
		stmInsert.close();

		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> outCgg_res_resolucion = new ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_resolucion tmpCgg_res_resolucion = new com.besixplus.sii.objects.Cgg_res_resolucion();
				tmpCgg_res_resolucion.setCRRES_CODIGO(results.getString(1));
				tmpCgg_res_resolucion.setCRSSC_CODIGO(results.getString(2));
				tmpCgg_res_resolucion.setCRRES_NUMERO_RESOLUCION(results.getString(3));
				tmpCgg_res_resolucion.setCRRES_TIPO(results.getInt(4));
				tmpCgg_res_resolucion.setCRRES_OBSERVACIONES(results.getString(5));
				tmpCgg_res_resolucion.setCRRES_EXTRACTO_RESOLUCION(results.getString(6));
				tmpCgg_res_resolucion.setCRRES_VOTOS_APROBACION(results.getInt(7));
				tmpCgg_res_resolucion.setCRRES_VOTOS_NEGACION(results.getInt(8));
				tmpCgg_res_resolucion.setCRRES_VOTOS_ABSTENCION(results.getInt(9));
				tmpCgg_res_resolucion.setCRRES_FECHA_EMISION(results.getTimestamp(10));
				tmpCgg_res_resolucion.setCRRES_FECHA_EJECUCION(results.getTimestamp(11));
				tmpCgg_res_resolucion.setCRRES_FECHA_ANULACION(results.getTimestamp(12));
				tmpCgg_res_resolucion.setCRRES_FECHA_CONFIRMACION(results.getTimestamp(13));
				tmpCgg_res_resolucion.setCRRES_RESOLUCION_REEMPLAZA(results.getString(14));
				tmpCgg_res_resolucion.setCRRES_NOMBRE_ADJUNTO_RESOL(results.getString(15));
				tmpCgg_res_resolucion.setCRRES_ADJUNTO_RESOLUCION(results.getBytes(16));
				tmpCgg_res_resolucion.setCRRES_DESCRIPCION_ADJUNTO(results.getString(17));
				tmpCgg_res_resolucion.setCRRES_FECHA_APELACION(results.getTimestamp(18));
				tmpCgg_res_resolucion.setCRRES_EXTRACTO_APELACION(results.getString(19));
				tmpCgg_res_resolucion.setCRRES_NUMERO_APELACION(results.getString(20));
				tmpCgg_res_resolucion.setCRRES_NOMBRE_ADJUNTO_APELAC(results.getString(21));
				tmpCgg_res_resolucion.setCRRES_ADJUNTO_APELACION(results.getBytes(22));
				tmpCgg_res_resolucion.setCRRES_ESTADO_RESOLUCION(results.getInt(23));
				tmpCgg_res_resolucion.setCRRES_ESTADO(results.getBoolean(24));
				outCgg_res_resolucion.add(tmpCgg_res_resolucion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_resolucion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrres_estado_resolucion ESTADO DE LA RESOLUCION:
			0 - ESPERANDO VOTACION
			1 - APROBADA
			2 - NEGADA
			3 - EJECUTADA
			4 - ANULADA
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGSITRO DE SESION.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			int inCrres_estado_resolucion,
			String inCrssc_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_resolucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setInt(8, inCrres_estado_resolucion);
			stmSelect.setString(9, inCrssc_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_resolucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_COUNT() }");
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
	 * @param inCrres_estado_resolucion ESTADO DE LA RESOLUCION:
			0 - ESPERANDO VOTACION
			1 - APROBADA
			2 - NEGADA
			3 - EJECUTADA
			4 - ANULADA
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword,
			int inCrres_estado_resolucion,
			String inCrssc_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setInt(3, inCrres_estado_resolucion);
			stmSelect.setString(4, inCrssc_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SQLException 
	 */
	public String update(
			java.sql.Connection inConnection
	) throws SQLException{
		String outResult = "true";

		CallableStatement stmUpdate = inConnection.prepareCall("{ call SII.F_CGG_RES_RESOLUCION_UPDATE_ADJUNTOS(?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?::smallint, ?::smallint, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
		stmUpdate.setString(1, this.getCgg_res_resolucion().getCRRES_CODIGO());
		stmUpdate.setString(2, this.getCgg_res_resolucion().getCRSSC_CODIGO());
		stmUpdate.setString(3, this.getCgg_res_resolucion().getCRRES_NUMERO_RESOLUCION());
		stmUpdate.setInt(4, this.getCgg_res_resolucion().getCRRES_TIPO());
		stmUpdate.setString(5, this.getCgg_res_resolucion().getCRRES_OBSERVACIONES());
		stmUpdate.setString(6, this.getCgg_res_resolucion().getCRRES_EXTRACTO_RESOLUCION());
		stmUpdate.setInt(7, this.getCgg_res_resolucion().getCRRES_VOTOS_APROBACION());
		stmUpdate.setInt(8, this.getCgg_res_resolucion().getCRRES_VOTOS_NEGACION());
		stmUpdate.setInt(9, this.getCgg_res_resolucion().getCRRES_VOTOS_ABSTENCION());
		stmUpdate.setTimestamp(10, new java.sql.Timestamp(getCgg_res_resolucion().getCRRES_FECHA_EMISION()!=null?getCgg_res_resolucion().getCRRES_FECHA_EMISION().getTime():new Date().getTime()));			
		stmUpdate.setTimestamp(11, new java.sql.Timestamp(getCgg_res_resolucion().getCRRES_FECHA_EJECUCION()!=null?getCgg_res_resolucion().getCRRES_FECHA_EJECUCION().getTime():new Date().getTime()));
		stmUpdate.setTimestamp(12, new java.sql.Timestamp(getCgg_res_resolucion().getCRRES_FECHA_ANULACION()!=null?getCgg_res_resolucion().getCRRES_FECHA_ANULACION().getTime():new Date().getTime()));			
		stmUpdate.setTimestamp(13, this.getCgg_res_resolucion().getCRRES_FECHA_CONFIRMACION() != null ? new java.sql.Timestamp(this.getCgg_res_resolucion().getCRRES_FECHA_CONFIRMACION().getTime()):null);
		stmUpdate.setString(14, this.getCgg_res_resolucion().getCRRES_RESOLUCION_REEMPLAZA());
		stmUpdate.setString(15, this.getCgg_res_resolucion().getCRRES_NOMBRE_ADJUNTO_RESOL());
		stmUpdate.setBytes(16, this.getCgg_res_resolucion().getCRRES_ADJUNTO_RESOLUCION());
		stmUpdate.setString(17, this.getCgg_res_resolucion().getCRRES_DESCRIPCION_ADJUNTO());
		stmUpdate.setTimestamp(18, this.getCgg_res_resolucion().getCRRES_FECHA_APELACION()!=null?new java.sql.Timestamp(this.getCgg_res_resolucion().getCRRES_FECHA_APELACION().getTime()):null);
		stmUpdate.setString(19, this.getCgg_res_resolucion().getCRRES_EXTRACTO_APELACION());
		stmUpdate.setString(20, this.getCgg_res_resolucion().getCRRES_NUMERO_APELACION());
		stmUpdate.setString(21, this.getCgg_res_resolucion().getCRRES_NOMBRE_ADJUNTO_APELAC());
		stmUpdate.setBytes(22, this.getCgg_res_resolucion().getCRRES_ADJUNTO_APELACION());
		stmUpdate.setInt(23, this.getCgg_res_resolucion().getCRRES_ESTADO_RESOLUCION());
		stmUpdate.setBoolean(24, this.getCgg_res_resolucion().getCRRES_ESTADO());
		stmUpdate.setString(25, this.getCgg_res_resolucion().getCRRES_USUARIO_UPDATE());
		stmUpdate.executeUpdate();
		stmUpdate.close();

		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_resolucion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_resolucion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_resolucion select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_resolucion().getCRRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_resolucion().setCRRES_CODIGO(results.getString(1));
				this.getCgg_res_resolucion().setCRSSC_CODIGO(results.getString(2));
				this.getCgg_res_resolucion().setCRRES_NUMERO_RESOLUCION(results.getString(3));
				this.getCgg_res_resolucion().setCRRES_TIPO(results.getInt(4));
				this.getCgg_res_resolucion().setCRRES_OBSERVACIONES(results.getString(5));
				this.getCgg_res_resolucion().setCRRES_EXTRACTO_RESOLUCION(results.getString(6));
				this.getCgg_res_resolucion().setCRRES_VOTOS_APROBACION(results.getInt(7));
				this.getCgg_res_resolucion().setCRRES_VOTOS_NEGACION(results.getInt(8));
				this.getCgg_res_resolucion().setCRRES_VOTOS_ABSTENCION(results.getInt(9));
				this.getCgg_res_resolucion().setCRRES_FECHA_EMISION(results.getTimestamp(10));
				this.getCgg_res_resolucion().setCRRES_FECHA_EJECUCION(results.getTimestamp(11));
				this.getCgg_res_resolucion().setCRRES_FECHA_ANULACION(results.getTimestamp(12));
				this.getCgg_res_resolucion().setCRRES_FECHA_CONFIRMACION(results.getTimestamp(13));
				this.getCgg_res_resolucion().setCRRES_RESOLUCION_REEMPLAZA(results.getString(14));
				this.getCgg_res_resolucion().setCRRES_NOMBRE_ADJUNTO_RESOL(results.getString(15));
				this.getCgg_res_resolucion().setCRRES_ADJUNTO_RESOLUCION(results.getBytes(16));
				this.getCgg_res_resolucion().setCRRES_DESCRIPCION_ADJUNTO(results.getString(17));
				this.getCgg_res_resolucion().setCRRES_FECHA_APELACION(results.getTimestamp(18));
				this.getCgg_res_resolucion().setCRRES_EXTRACTO_APELACION(results.getString(19));
				this.getCgg_res_resolucion().setCRRES_NUMERO_APELACION(results.getString(20));
				this.getCgg_res_resolucion().setCRRES_NOMBRE_ADJUNTO_APELAC(results.getString(21));
				this.getCgg_res_resolucion().setCRRES_ADJUNTO_APELACION(results.getBytes(22));
				this.getCgg_res_resolucion().setCRRES_ESTADO_RESOLUCION(results.getInt(23));
				this.getCgg_res_resolucion().setCRRES_ESTADO(results.getBoolean(24));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_resolucion();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_resolucion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String delete(
			java.sql.Connection inConnection
	){
		return delete(inConnection, true);
	}
	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_resolucion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inSoft SI HACE UN ELIMINADO LOGICO DEL REGISTRO.
	 * @return String <code>"true"</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO EL MESAJE DE ERROR.
	 */
	public String delete(
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESOLUCION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_resolucion().getCRRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESOLUCION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_resolucion().getCRRES_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_resolucion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_resolucion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> selectCGG_RES_SESION_COMITE(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> outCgg_res_resolucion = new ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_RESOLUCION_S_CGG_RES_SESION_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_resolucion().getCRSSC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_resolucion tmpCgg_res_resolucion = new com.besixplus.sii.objects.Cgg_res_resolucion();
				tmpCgg_res_resolucion.setCRRES_CODIGO(results.getString(1));
				tmpCgg_res_resolucion.setCRSSC_CODIGO(results.getString(2));
				tmpCgg_res_resolucion.setCRRES_NUMERO_RESOLUCION(results.getString(3));
				tmpCgg_res_resolucion.setCRRES_TIPO(results.getInt(4));
				tmpCgg_res_resolucion.setCRRES_OBSERVACIONES(results.getString(5));
				tmpCgg_res_resolucion.setCRRES_EXTRACTO_RESOLUCION(results.getString(6));
				tmpCgg_res_resolucion.setCRRES_VOTOS_APROBACION(results.getInt(7));
				tmpCgg_res_resolucion.setCRRES_VOTOS_NEGACION(results.getInt(8));
				tmpCgg_res_resolucion.setCRRES_VOTOS_ABSTENCION(results.getInt(9));
				tmpCgg_res_resolucion.setCRRES_FECHA_EMISION(results.getTimestamp(10));
				tmpCgg_res_resolucion.setCRRES_FECHA_EJECUCION(results.getTimestamp(11));
				tmpCgg_res_resolucion.setCRRES_FECHA_ANULACION(results.getTimestamp(12));
				tmpCgg_res_resolucion.setCRRES_FECHA_CONFIRMACION(results.getTimestamp(13));
				tmpCgg_res_resolucion.setCRRES_RESOLUCION_REEMPLAZA(results.getString(14));
				tmpCgg_res_resolucion.setCRRES_NOMBRE_ADJUNTO_RESOL(results.getString(15));
				tmpCgg_res_resolucion.setCRRES_ADJUNTO_RESOLUCION(results.getBytes(16));
				tmpCgg_res_resolucion.setCRRES_DESCRIPCION_ADJUNTO(results.getString(17));
				tmpCgg_res_resolucion.setCRRES_FECHA_APELACION(results.getTimestamp(18));
				tmpCgg_res_resolucion.setCRRES_EXTRACTO_APELACION(results.getString(19));
				tmpCgg_res_resolucion.setCRRES_NUMERO_APELACION(results.getString(20));
				tmpCgg_res_resolucion.setCRRES_NOMBRE_ADJUNTO_APELAC(results.getString(21));
				tmpCgg_res_resolucion.setCRRES_ADJUNTO_APELACION(results.getBytes(22));
				tmpCgg_res_resolucion.setCRRES_ESTADO_RESOLUCION(results.getInt(23));
				tmpCgg_res_resolucion.setCRRES_ESTADO(results.getBoolean(24));
				outCgg_res_resolucion.add(tmpCgg_res_resolucion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_resolucion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESOLUCION_D_CGG_RES_SESION_COMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_resolucion().getCRSSC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESOLUCION_DS_CGG_RES_SESION_COMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_resolucion().getCRSSC_CODIGO());
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
	 * ACTUALIZA LOS REGISTROS DE LA TABLA Cgg_res_resolucion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public static String releaseCGG_RES_SESION_COMITE(
			java.sql.Connection inConnection,
			String inCrssc_codigo
	){
		String outResult = null;
		try{
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESOLUCION_R_CGG_RES_SESION_COMITE(?) }");
			stmDelete.setString(1, inCrssc_codigo);
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	////////////////////////////////////
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res RESOLUCION QUE ESTEN EN ESTADO DE "Esperando Votacion" Y SE PUEDAN MOSTRAR PARA LA TABLAt Cgg_res voto 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO DE LOS DATOS ASC o DESC
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inSW SOLO CONTAR LAS RESOLUCIONES ASOCIADAS A UN TRAMITE.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectVotar(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			boolean inSW
	){
		ArrayList<HashMap<String,Object>> outCgg_res_resolucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_VOTAR_RESOLUCION(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setBoolean(8, inSW);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_resolucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inSW SOLO CONTAR LAS RESOLUCIONES ASOCIADAS A UN TRAMITE.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCountVotar(
			java.sql.Connection inConnection,
			String inUserName,
			String inKeyword,
			boolean inSW
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.f_cgg_res_votar_resolucion_count(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inKeyword);
			stmSelect.setBoolean(4, inSW);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	///////////////////////////////////
	/**
	 * GENERA EL NUMERO DE RESOLUCION DE LA TABLA Cgg_res_resolucion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCisla_codigo CODIGO DE ISLA DONDE SE GENERA LA RESOLUCION.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE.
	 * @return valorResolucion NUMERO GENERADO PARA CADA RESOLUCION.
	 * @throws SQLException 
	 */
	public static String numeroResolucion(
			java.sql.Connection inConnection,
			String inCisla_codigo,
			String inCrtra_codigo
	) throws SQLException{
		String valorResolucion=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GENERA_NUM_RESOLUCION(?,?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);
		stmSelect.setString(2, inCisla_codigo);
		stmSelect.setString(3, inCrtra_codigo);
		stmSelect.execute();
		valorResolucion = stmSelect.getString(1);
		stmSelect.close();

		return valorResolucion;
	}
	/**
	 * GENERA EL NUMERO DE APELACION A LA RESOLUCION DE LA TABLA Cgg_res_resolucion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return valorApelacion EL NUMERO GENERADO PARA LA APELACION. 
	 */
	public static String numeroApelacion(
			java.sql.Connection inConnection
	){
		String valorApelacion=null;
		try{

			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GENERA_NUM_APELACION_RESOLUCION() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.execute();
			valorApelacion = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorApelacion;
	}
	/**
	 * CONTABILIZA LOS VOTOS APROBADOS DE LA RESOLUCION DE LA TABLA Cgg_res_resolucion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @return valorAprobado TOTAL DE VOTOS APROBADOS.
	 * @throws SQLException 
	 */
	public static int votosAprobados(
			java.sql.Connection inConnection,
			String inCrres_codigo
	) throws SQLException{
		int valorAprobado=0;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_VOTOS_APROBADOS(?) }");
		stmSelect.registerOutParameter(1, Types.INTEGER);		
		stmSelect.setString(2, inCrres_codigo);
		stmSelect.execute();
		valorAprobado = stmSelect.getInt(1);			
		stmSelect.close();

		return valorAprobado;
	}
	/**
	 * CONTABILIZA LOS VOTOS APROBADOS DE LA RESOLUCION DE LA TABLA Cgg_res_resolucion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @return votosReprobados TOTAL DE VOTOS APROBADOS.
	 * @throws SQLException 
	 */
	public static int votosReprobados(
			java.sql.Connection inConnection,
			String inCrres_codigo
	) throws SQLException{
		int votosReprobados=0;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_VOTOS_REPROBADOS(?) }");
		stmSelect.registerOutParameter(1, Types.INTEGER);
		stmSelect.setString(2, inCrres_codigo);
		stmSelect.execute();
		votosReprobados = stmSelect.getInt(1);			
		stmSelect.close();

		return votosReprobados;
	}
	/**
	 * CONTABILIZA LOS VOTOS APROBADOS DE LA RESOLUCION DE LA TABLA Cgg_res_resolucion
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @return votosReprobados TOTAL DE VOTOS APROBADOS.
	 * @throws SQLException 
	 */
	public static int votosAbstenciones(
			java.sql.Connection inConnection,
			String inCrres_codigo
	) throws SQLException{
		int votoAbstenciones=0;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_VOTOS_ABSTENCIONES(?) }");
		stmSelect.registerOutParameter(1, Types.INTEGER);
		stmSelect.setString(2, inCrres_codigo);
		stmSelect.execute();
		votoAbstenciones = stmSelect.getInt(1);			
		stmSelect.close();

		return votoAbstenciones;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res RESOLUCION QUE ESTEN EN ESTADO DE "Esperando Votacion"  Y SE PUEDAN MOSTRAR PARA LA TABLA Cgg_res voto 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectMiembrosComite(
			java.sql.Connection inConnection,
			String inCrssc_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_resolucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_MIEMBRO_SESION_VOTO(?) }");
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
				outCgg_res_resolucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res RESOLUCION QUE ESTEN EN ESTADO DE "Esperando Votacion" Y SE PUEDAN MOSTRAR PARA LA TABLA Cgg_res voto 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrssc_codigo CODIGO DE SESION
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectVotarAdmin(
			java.sql.Connection inConnection,			
			String inUserName,			
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrssc_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_resolucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTAR_RESOLUCION_ADMIN(?,?,?,?,?,?,?) }");
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
				outCgg_res_resolucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inCrssc_codigo CODIGO DE SESION
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCountVotarAdmin(
			java.sql.Connection inConnection,
			String inUserName,
			String inCrssc_codigo,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTAR_RESOLUCION_COUNT_ADMIN(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCrssc_codigo);
			stmSelect.setString(4, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	///////////////////////////////////
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.	
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllResolucionAdjunto(
			java.sql.Connection inConnection,
			String inCrres_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_res_sesion_comite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_ADJUNTO_RESOLUCION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrres_codigo);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res RESOLUCIONES QUE ESTEN EN ESTADO DE "Esperando Votacion" Y SE PUEDAN MOSTRAR PARA LA TABLA Cgg_res voto 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inCrssc_codigo CODIGO DE SESION
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectVotarAdmin1(
			java.sql.Connection inConnection,
			String inUserName,
			String inCrssc_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_resolucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTAR_RESOLUCION_ADMIN1(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCrssc_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_resolucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res resolucion  que esten en estado de "Esperando Votacion" y se puedan mostrar para la tabla Cgg_res voto 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectMiembrosComite1(
			java.sql.Connection inConnection,			
			String inUserName,			
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrssc_codigo,
			String inCrres_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_resolucion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_MIEMBRO_SESION_VOTO1(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2, inUserName);			
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrssc_codigo);
			stmSelect.setString(9, inCrres_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_resolucion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_resolucion;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCountVotaMiembrosComite(
			java.sql.Connection inConnection,
			String inCrssc_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.f_cgg_res_votar_miembros_comite_count(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrssc_codigo);
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
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCountVotaMiembrosComite(
			java.sql.Connection inConnection,
			String inKeyword,
			String inCrssc_codigo,
			String inCrres_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.f_cgg_res_votar_miembro_comite_count(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrssc_codigo);
			stmSelect.setString(4, inCrres_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * GENERA EL NUMERO DE GRUPO DE LA TABLA Cgg_tct_grupo_turista
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE.
	 * @return valorGrupo el numero generado para cada registro de TCT
	 * @throws SQLException 
	 */
	public static String datosPersonaTramite_Residencia(
			java.sql.Connection inConnection,
			String inCrtra_codigo

	) throws SQLException{
		String datosPersonaTramite_Residencia=null;
		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_RES_RESOLUCION_VOTO_RESIDENCIA_SELECT(?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);
		stmSelect.setString(2, inCrtra_codigo);
		stmSelect.execute();
		datosPersonaTramite_Residencia = stmSelect.getString(1);			
		stmSelect.close();
		return datosPersonaTramite_Residencia;
	}
	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tramite_comite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite_comite.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public String deleteSESION_TRAMITE_RESOLUCION(
			java.sql.Connection inConnection
	){
		String outResult = "true";	
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_RESOLUCION_TRAMITE_SESION_D(?) }");
			stmDelete.setString(1, this.getCgg_res_resolucion().getCRSSC_CODIGO());			
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}

		return outResult;
	}

	/**
	 * Actualiza la fecha de confirmacion de la resolucion.
	 * @param inConnection Conexion de datos.
	 * @return Cadena de datos indicando el estado de la actualizacion.
	 */
	public String actualizarConfirmacion(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		CallableStatement stmUpdate;
		try {
			stmUpdate = inConnection.prepareCall("{ call SII.F_CGG_RES_RESOLUCION_UPDATE1(?, ?, ?) }");

			stmUpdate.setString(1, this.getCgg_res_resolucion().getCRRES_CODIGO());				
			stmUpdate.setTimestamp(2, this.getCgg_res_resolucion().getCRRES_FECHA_CONFIRMACION() != null ? new java.sql.Timestamp(this.getCgg_res_resolucion().getCRRES_FECHA_CONFIRMACION().getTime()):null);		
			stmUpdate.setString(3, this.getCgg_res_resolucion().getCRRES_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();

		} catch (SQLException e) {		
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}		
		return outResult;
	}

	/**
	 * ANULAR UN RESOLUCION
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES
	 * @return 
	 */
	public String anular(
			Connection inConnection,
			String inUserName
	){
		String outResult = "true";
		try{
			CallableStatement stmDelete = inConnection.prepareCall("{ call SII.F_CGG_RES_RESOLUCION_ANULAR(?,?) }");
			stmDelete.setString(1, inUserName);
			stmDelete.setString(2, this.getCgg_res_resolucion().getCRRES_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

}