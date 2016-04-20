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
* CLASE Cgg_res_comunicado
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_comunicado.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_comunicado implements Serializable{
	private static final long serialVersionUID = 1624669827;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_comunicado.
	*/
	private com.besixplus.sii.objects.Cgg_res_comunicado myCgg_res_comunicado = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_comunicado.
	*/
	public Cgg_res_comunicado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_comunicado.
	* @param inCgg_res_comunicado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_comunicado.
	*/
	public Cgg_res_comunicado(
		com.besixplus.sii.objects.Cgg_res_comunicado inCgg_res_comunicado
	){
		this.setCgg_res_comunicado(inCgg_res_comunicado);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_comunicado.
	* @param inCgg_res_comunicado OBJETO Cgg_res_comunicado.
	* @return void
	*/
	public void setCgg_res_comunicado(com.besixplus.sii.objects.Cgg_res_comunicado inCgg_res_comunicado){
		this.myCgg_res_comunicado = inCgg_res_comunicado;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_comunicado.
	* @return Cgg_res_comunicado OBJETO Cgg_res_comunicado.
	*/
	public com.besixplus.sii.objects.Cgg_res_comunicado getCgg_res_comunicado(){
		return this.myCgg_res_comunicado;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_comunicado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_comunicado().getCRCOM_CODIGO());
			stmInsert.setString(3, this.getCgg_res_comunicado().getCRRES_CODIGO());
			stmInsert.setString(4, this.getCgg_res_comunicado().getCRPER_CODIGO());
			stmInsert.setString(5, this.getCgg_res_comunicado().getCGG_CRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_comunicado().getCRPJR_CODIGO());
			stmInsert.setString(7, this.getCgg_res_comunicado().getCRCOM_DESTINATARIO());
			stmInsert.setString(8, this.getCgg_res_comunicado().getCRCOM_ASUNTO());
			stmInsert.setTimestamp(9, new java.sql.Timestamp(this.getCgg_res_comunicado().getCRCOM_FECHA_RECEPCION().getTime()));
			stmInsert.setTimestamp(10, new java.sql.Timestamp(this.getCgg_res_comunicado().getCRCOM_FECHA_REVISION().getTime()));
			stmInsert.setString(11, this.getCgg_res_comunicado().getCRCOM_NUMERO_DOCUMENTO());
			stmInsert.setString(12, this.getCgg_res_comunicado().getCRCOM_DESCRIPCION());
			stmInsert.setString(13, this.getCgg_res_comunicado().getCRCOM_OBSERVACION());
			stmInsert.setString(14, this.getCgg_res_comunicado().getCRCOM_DESCRIPCION_ADJUNTO());
			stmInsert.setString(15, this.getCgg_res_comunicado().getCRCOM_NOMBRE_ADJUNTO());
			stmInsert.setString(16, this.getCgg_res_comunicado().getCRCOM_REMITENTE());
			stmInsert.setBytes(17, this.getCgg_res_comunicado().getCRCOM_ADJUNTO());
			stmInsert.setInt(18, this.getCgg_res_comunicado().getCRCOM_ESTADO_COMUNICADO());
			stmInsert.setBoolean(19, this.getCgg_res_comunicado().getCRCOM_ESTADO());
			stmInsert.setString(20, this.getCgg_res_comunicado().getCRCOM_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_comunicado().setCRCOM_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_comunicado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> outCgg_res_comunicado = new ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_comunicado tmpCgg_res_comunicado = new com.besixplus.sii.objects.Cgg_res_comunicado();
				tmpCgg_res_comunicado.setCRCOM_CODIGO(results.getString(1));
				tmpCgg_res_comunicado.setCRRES_CODIGO(results.getString(2));
				tmpCgg_res_comunicado.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_comunicado.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_comunicado.setCRPJR_CODIGO(results.getString(5));
				tmpCgg_res_comunicado.setCRCOM_DESTINATARIO(results.getString(6));
				tmpCgg_res_comunicado.setCRCOM_ASUNTO(results.getString(7));
				tmpCgg_res_comunicado.setCRCOM_FECHA_RECEPCION(results.getTimestamp(8));
				tmpCgg_res_comunicado.setCRCOM_FECHA_REVISION(results.getTimestamp(9));
				tmpCgg_res_comunicado.setCRCOM_NUMERO_DOCUMENTO(results.getString(10));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION(results.getString(11));
				tmpCgg_res_comunicado.setCRCOM_OBSERVACION(results.getString(12));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION_ADJUNTO(results.getString(13));
				tmpCgg_res_comunicado.setCRCOM_NOMBRE_ADJUNTO(results.getString(14));
				tmpCgg_res_comunicado.setCRCOM_REMITENTE(results.getString(15));
				tmpCgg_res_comunicado.setCRCOM_ADJUNTO(results.getBytes(16));
				tmpCgg_res_comunicado.setCRCOM_ESTADO_COMUNICADO(results.getInt(17));
				tmpCgg_res_comunicado.setCRCOM_ESTADO(results.getBoolean(18));
				outCgg_res_comunicado.add(tmpCgg_res_comunicado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_comunicado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> outCgg_res_comunicado = new ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_comunicado tmpCgg_res_comunicado = new com.besixplus.sii.objects.Cgg_res_comunicado();
				tmpCgg_res_comunicado.setCRCOM_CODIGO(results.getString(1));
				tmpCgg_res_comunicado.setCRRES_CODIGO(results.getString(2));
				tmpCgg_res_comunicado.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_comunicado.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_comunicado.setCRPJR_CODIGO(results.getString(5));
				tmpCgg_res_comunicado.setCRCOM_DESTINATARIO(results.getString(6));
				tmpCgg_res_comunicado.setCRCOM_ASUNTO(results.getString(7));
				tmpCgg_res_comunicado.setCRCOM_FECHA_RECEPCION(results.getTimestamp(8));
				tmpCgg_res_comunicado.setCRCOM_FECHA_REVISION(results.getTimestamp(9));
				tmpCgg_res_comunicado.setCRCOM_NUMERO_DOCUMENTO(results.getString(10));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION(results.getString(11));
				tmpCgg_res_comunicado.setCRCOM_OBSERVACION(results.getString(12));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION_ADJUNTO(results.getString(13));
				tmpCgg_res_comunicado.setCRCOM_NOMBRE_ADJUNTO(results.getString(14));
				tmpCgg_res_comunicado.setCRCOM_REMITENTE(results.getString(15));
				tmpCgg_res_comunicado.setCRCOM_ADJUNTO(results.getBytes(16));
				tmpCgg_res_comunicado.setCRCOM_ESTADO_COMUNICADO(results.getInt(17));
				tmpCgg_res_comunicado.setCRCOM_ESTADO(results.getBoolean(18));
				outCgg_res_comunicado.add(tmpCgg_res_comunicado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_comunicado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_comunicado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_comunicado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_comunicado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_comunicado().getCRCOM_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_comunicado().getCRRES_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_comunicado().getCRPER_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_comunicado().getCGG_CRPER_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_comunicado().getCRPJR_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_comunicado().getCRCOM_DESTINATARIO());
			stmUpdate.setString(7, this.getCgg_res_comunicado().getCRCOM_ASUNTO());
			stmUpdate.setTimestamp(8, new java.sql.Timestamp(this.getCgg_res_comunicado().getCRCOM_FECHA_RECEPCION().getTime()));
			stmUpdate.setTimestamp(9, new java.sql.Timestamp(this.getCgg_res_comunicado().getCRCOM_FECHA_REVISION().getTime()));
			stmUpdate.setString(10, this.getCgg_res_comunicado().getCRCOM_NUMERO_DOCUMENTO());
			stmUpdate.setString(11, this.getCgg_res_comunicado().getCRCOM_DESCRIPCION());
			stmUpdate.setString(12, this.getCgg_res_comunicado().getCRCOM_OBSERVACION());
			stmUpdate.setString(13, this.getCgg_res_comunicado().getCRCOM_DESCRIPCION_ADJUNTO());
			stmUpdate.setString(14, this.getCgg_res_comunicado().getCRCOM_NOMBRE_ADJUNTO());
			stmUpdate.setString(15, this.getCgg_res_comunicado().getCRCOM_REMITENTE());
			stmUpdate.setBytes(16, this.getCgg_res_comunicado().getCRCOM_ADJUNTO());
			stmUpdate.setInt(17, this.getCgg_res_comunicado().getCRCOM_ESTADO_COMUNICADO());
			stmUpdate.setBoolean(18, this.getCgg_res_comunicado().getCRCOM_ESTADO());
			stmUpdate.setString(19, this.getCgg_res_comunicado().getCRCOM_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_comunicado DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_comunicado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_comunicado select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_comunicado().getCRCOM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_comunicado().setCRCOM_CODIGO(results.getString(1));
				this.getCgg_res_comunicado().setCRRES_CODIGO(results.getString(2));
				this.getCgg_res_comunicado().setCRPER_CODIGO(results.getString(3));
				this.getCgg_res_comunicado().setCGG_CRPER_CODIGO(results.getString(4));
				this.getCgg_res_comunicado().setCRPJR_CODIGO(results.getString(5));
				this.getCgg_res_comunicado().setCRCOM_DESTINATARIO(results.getString(6));
				this.getCgg_res_comunicado().setCRCOM_ASUNTO(results.getString(7));
				this.getCgg_res_comunicado().setCRCOM_FECHA_RECEPCION(results.getTimestamp(8));
				this.getCgg_res_comunicado().setCRCOM_FECHA_REVISION(results.getTimestamp(9));
				this.getCgg_res_comunicado().setCRCOM_NUMERO_DOCUMENTO(results.getString(10));
				this.getCgg_res_comunicado().setCRCOM_DESCRIPCION(results.getString(11));
				this.getCgg_res_comunicado().setCRCOM_OBSERVACION(results.getString(12));
				this.getCgg_res_comunicado().setCRCOM_DESCRIPCION_ADJUNTO(results.getString(13));
				this.getCgg_res_comunicado().setCRCOM_NOMBRE_ADJUNTO(results.getString(14));
				this.getCgg_res_comunicado().setCRCOM_REMITENTE(results.getString(15));
				this.getCgg_res_comunicado().setCRCOM_ADJUNTO(results.getBytes(16));
				this.getCgg_res_comunicado().setCRCOM_ESTADO_COMUNICADO(results.getInt(17));
				this.getCgg_res_comunicado().setCRCOM_ESTADO(results.getBoolean(18));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_comunicado();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_comunicado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_comunicado().getCRCOM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_comunicado().getCRCOM_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_comunicado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_comunicado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> outCgg_res_comunicado = new ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_comunicado().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_comunicado tmpCgg_res_comunicado = new com.besixplus.sii.objects.Cgg_res_comunicado();
				tmpCgg_res_comunicado.setCRCOM_CODIGO(results.getString(1));
				tmpCgg_res_comunicado.setCRRES_CODIGO(results.getString(2));
				tmpCgg_res_comunicado.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_comunicado.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_comunicado.setCRPJR_CODIGO(results.getString(5));
				tmpCgg_res_comunicado.setCRCOM_DESTINATARIO(results.getString(6));
				tmpCgg_res_comunicado.setCRCOM_ASUNTO(results.getString(7));
				tmpCgg_res_comunicado.setCRCOM_FECHA_RECEPCION(results.getTimestamp(8));
				tmpCgg_res_comunicado.setCRCOM_FECHA_REVISION(results.getTimestamp(9));
				tmpCgg_res_comunicado.setCRCOM_NUMERO_DOCUMENTO(results.getString(10));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION(results.getString(11));
				tmpCgg_res_comunicado.setCRCOM_OBSERVACION(results.getString(12));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION_ADJUNTO(results.getString(13));
				tmpCgg_res_comunicado.setCRCOM_NOMBRE_ADJUNTO(results.getString(14));
				tmpCgg_res_comunicado.setCRCOM_REMITENTE(results.getString(15));
				tmpCgg_res_comunicado.setCRCOM_ADJUNTO(results.getBytes(16));
				tmpCgg_res_comunicado.setCRCOM_ESTADO_COMUNICADO(results.getInt(17));
				tmpCgg_res_comunicado.setCRCOM_ESTADO(results.getBoolean(18));
				outCgg_res_comunicado.add(tmpCgg_res_comunicado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_comunicado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_res_comunicado().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_res_comunicado().getCRPJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_comunicado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_comunicado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> outCgg_res_comunicado = new ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_S_CGG_RES_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_comunicado().getCGG_CRPER_CODIGO());
			stmSelect.setString(3,this.getCgg_res_comunicado().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_comunicado tmpCgg_res_comunicado = new com.besixplus.sii.objects.Cgg_res_comunicado();
				tmpCgg_res_comunicado.setCRCOM_CODIGO(results.getString(1));
				tmpCgg_res_comunicado.setCRRES_CODIGO(results.getString(2));
				tmpCgg_res_comunicado.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_comunicado.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_comunicado.setCRPJR_CODIGO(results.getString(5));
				tmpCgg_res_comunicado.setCRCOM_DESTINATARIO(results.getString(6));
				tmpCgg_res_comunicado.setCRCOM_ASUNTO(results.getString(7));
				tmpCgg_res_comunicado.setCRCOM_FECHA_RECEPCION(results.getTimestamp(8));
				tmpCgg_res_comunicado.setCRCOM_FECHA_REVISION(results.getTimestamp(9));
				tmpCgg_res_comunicado.setCRCOM_NUMERO_DOCUMENTO(results.getString(10));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION(results.getString(11));
				tmpCgg_res_comunicado.setCRCOM_OBSERVACION(results.getString(12));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION_ADJUNTO(results.getString(13));
				tmpCgg_res_comunicado.setCRCOM_NOMBRE_ADJUNTO(results.getString(14));
				tmpCgg_res_comunicado.setCRCOM_REMITENTE(results.getString(15));
				tmpCgg_res_comunicado.setCRCOM_ADJUNTO(results.getBytes(16));
				tmpCgg_res_comunicado.setCRCOM_ESTADO_COMUNICADO(results.getInt(17));
				tmpCgg_res_comunicado.setCRCOM_ESTADO(results.getBoolean(18));
				outCgg_res_comunicado.add(tmpCgg_res_comunicado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_comunicado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_D_CGG_RES_PERSONA(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_comunicado().getCGG_CRPER_CODIGO());
			stmDelete.setString(2, this.getCgg_res_comunicado().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_DS_CGG_RES_PERSONA(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_comunicado().getCGG_CRPER_CODIGO());
				stmDelete.setString(2, this.getCgg_res_comunicado().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_comunicado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_comunicado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> selectCGG_RES_RESOLUCION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> outCgg_res_comunicado = new ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_S_CGG_RES_RESOLUCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_comunicado().getCRRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_comunicado tmpCgg_res_comunicado = new com.besixplus.sii.objects.Cgg_res_comunicado();
				tmpCgg_res_comunicado.setCRCOM_CODIGO(results.getString(1));
				tmpCgg_res_comunicado.setCRRES_CODIGO(results.getString(2));
				tmpCgg_res_comunicado.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_comunicado.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_comunicado.setCRPJR_CODIGO(results.getString(5));
				tmpCgg_res_comunicado.setCRCOM_DESTINATARIO(results.getString(6));
				tmpCgg_res_comunicado.setCRCOM_ASUNTO(results.getString(7));
				tmpCgg_res_comunicado.setCRCOM_FECHA_RECEPCION(results.getTimestamp(8));
				tmpCgg_res_comunicado.setCRCOM_FECHA_REVISION(results.getTimestamp(9));
				tmpCgg_res_comunicado.setCRCOM_NUMERO_DOCUMENTO(results.getString(10));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION(results.getString(11));
				tmpCgg_res_comunicado.setCRCOM_OBSERVACION(results.getString(12));
				tmpCgg_res_comunicado.setCRCOM_DESCRIPCION_ADJUNTO(results.getString(13));
				tmpCgg_res_comunicado.setCRCOM_NOMBRE_ADJUNTO(results.getString(14));
				tmpCgg_res_comunicado.setCRCOM_REMITENTE(results.getString(15));
				tmpCgg_res_comunicado.setCRCOM_ADJUNTO(results.getBytes(16));
				tmpCgg_res_comunicado.setCRCOM_ESTADO_COMUNICADO(results.getInt(17));
				tmpCgg_res_comunicado.setCRCOM_ESTADO(results.getBoolean(18));
				outCgg_res_comunicado.add(tmpCgg_res_comunicado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_comunicado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_RESOLUCION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_D_CGG_RES_RESOLUCION(?) }");
			stmDelete.setString(1, this.getCgg_res_comunicado().getCRRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_COMUNICADO_DS_CGG_RES_RESOLUCION(?) }");
				stmDelete.setString(1, this.getCgg_res_comunicado().getCRRES_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_comunicado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectRemitenteAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_comunicado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_SELECT_REMITENTE(?,?,?,?,?,?) }");
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
				outCgg_res_comunicado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_comunicado;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectRemitenteCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_COMUNICADO_REMITENTE_COUNT(?) }");
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