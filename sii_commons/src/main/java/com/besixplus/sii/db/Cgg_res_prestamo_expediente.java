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
* CLASE Cgg_res_prestamo_expediente
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_prestamo_expediente.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_prestamo_expediente implements Serializable{
	private static final long serialVersionUID = 495878471;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_prestamo_expediente.
	*/
	private com.besixplus.sii.objects.Cgg_res_prestamo_expediente myCgg_res_prestamo_expediente = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_prestamo_expediente.
	*/
	public Cgg_res_prestamo_expediente(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_prestamo_expediente.
	* @param inCgg_res_prestamo_expediente OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_prestamo_expediente.
	*/
	public Cgg_res_prestamo_expediente(
		com.besixplus.sii.objects.Cgg_res_prestamo_expediente inCgg_res_prestamo_expediente
	){
		this.setCgg_res_prestamo_expediente(inCgg_res_prestamo_expediente);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_prestamo_expediente.
	* @param inCgg_res_prestamo_expediente OBJETO Cgg_res_prestamo_expediente.
	* @return void
	*/
	public void setCgg_res_prestamo_expediente(com.besixplus.sii.objects.Cgg_res_prestamo_expediente inCgg_res_prestamo_expediente){
		this.myCgg_res_prestamo_expediente = inCgg_res_prestamo_expediente;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_prestamo_expediente.
	* @return Cgg_res_prestamo_expediente OBJETO Cgg_res_prestamo_expediente.
	*/
	public com.besixplus.sii.objects.Cgg_res_prestamo_expediente getCgg_res_prestamo_expediente(){
		return this.myCgg_res_prestamo_expediente;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_prestamo_expediente.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_INSERT(?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_prestamo_expediente().getCRPEX_CODIGO());
			stmInsert.setString(3, this.getCgg_res_prestamo_expediente().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_res_prestamo_expediente().getCRPER_CODIGO());
			stmInsert.setString(5, this.getCgg_res_prestamo_expediente().getCGG_CRPER_CODIGO());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_res_prestamo_expediente().getCRPEX_FECHA_OPERACION().getTime()));
			stmInsert.setInt(7, this.getCgg_res_prestamo_expediente().getCRPEX_MOVIMIENTO());
			stmInsert.setString(8, this.getCgg_res_prestamo_expediente().getCRPEX_OBSERVACION());
			stmInsert.setBoolean(9, this.getCgg_res_prestamo_expediente().getCRPEX_ESTADO());
			stmInsert.setString(10, this.getCgg_res_prestamo_expediente().getCRPEX_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_res_prestamo_expediente().getCRPEX_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_prestamo_expediente().setCRPEX_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> outCgg_res_prestamo_expediente = new ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_prestamo_expediente tmpCgg_res_prestamo_expediente = new com.besixplus.sii.objects.Cgg_res_prestamo_expediente();
				tmpCgg_res_prestamo_expediente.setCRPEX_CODIGO(results.getString(1));
				tmpCgg_res_prestamo_expediente.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_prestamo_expediente.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_prestamo_expediente.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_prestamo_expediente.setCRPEX_FECHA_OPERACION(results.getTimestamp(5));
				tmpCgg_res_prestamo_expediente.setCRPEX_MOVIMIENTO(results.getInt(6));
				tmpCgg_res_prestamo_expediente.setCRPEX_OBSERVACION(results.getString(7));
				tmpCgg_res_prestamo_expediente.setCRPEX_ESTADO(results.getBoolean(8));
				outCgg_res_prestamo_expediente.add(tmpCgg_res_prestamo_expediente);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_expediente;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> outCgg_res_prestamo_expediente = new ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_prestamo_expediente tmpCgg_res_prestamo_expediente = new com.besixplus.sii.objects.Cgg_res_prestamo_expediente();
				tmpCgg_res_prestamo_expediente.setCRPEX_CODIGO(results.getString(1));
				tmpCgg_res_prestamo_expediente.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_prestamo_expediente.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_prestamo_expediente.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_prestamo_expediente.setCRPEX_FECHA_OPERACION(results.getTimestamp(5));
				tmpCgg_res_prestamo_expediente.setCRPEX_MOVIMIENTO(results.getInt(6));
				tmpCgg_res_prestamo_expediente.setCRPEX_OBSERVACION(results.getString(7));
				tmpCgg_res_prestamo_expediente.setCRPEX_ESTADO(results.getBoolean(8));
				outCgg_res_prestamo_expediente.add(tmpCgg_res_prestamo_expediente);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_expediente;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_prestamo_expediente = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_prestamo_expediente.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_expediente;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_prestamo_expediente.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_prestamo_expediente.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_prestamo_expediente().getCRPEX_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_prestamo_expediente().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_prestamo_expediente().getCRPER_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_prestamo_expediente().getCGG_CRPER_CODIGO());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_res_prestamo_expediente().getCRPEX_FECHA_OPERACION().getTime()));
			stmUpdate.setInt(6, this.getCgg_res_prestamo_expediente().getCRPEX_MOVIMIENTO());
			stmUpdate.setString(7, this.getCgg_res_prestamo_expediente().getCRPEX_OBSERVACION());
			stmUpdate.setBoolean(8, this.getCgg_res_prestamo_expediente().getCRPEX_ESTADO());
			stmUpdate.setString(9, this.getCgg_res_prestamo_expediente().getCRPEX_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_prestamo_expediente DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_prestamo_expediente OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_prestamo_expediente select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_prestamo_expediente().getCRPEX_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_prestamo_expediente().setCRPEX_CODIGO(results.getString(1));
				this.getCgg_res_prestamo_expediente().setCUSU_CODIGO(results.getString(2));
				this.getCgg_res_prestamo_expediente().setCRPER_CODIGO(results.getString(3));
				this.getCgg_res_prestamo_expediente().setCGG_CRPER_CODIGO(results.getString(4));
				this.getCgg_res_prestamo_expediente().setCRPEX_FECHA_OPERACION(results.getTimestamp(5));
				this.getCgg_res_prestamo_expediente().setCRPEX_MOVIMIENTO(results.getInt(6));
				this.getCgg_res_prestamo_expediente().setCRPEX_OBSERVACION(results.getString(7));
				this.getCgg_res_prestamo_expediente().setCRPEX_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_prestamo_expediente();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_prestamo_expediente DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_prestamo_expediente().getCRPEX_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_prestamo_expediente().getCRPEX_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_prestamo_expediente OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> outCgg_res_prestamo_expediente = new ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_prestamo_expediente().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_prestamo_expediente tmpCgg_res_prestamo_expediente = new com.besixplus.sii.objects.Cgg_res_prestamo_expediente();
				tmpCgg_res_prestamo_expediente.setCRPEX_CODIGO(results.getString(1));
				tmpCgg_res_prestamo_expediente.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_prestamo_expediente.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_prestamo_expediente.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_prestamo_expediente.setCRPEX_FECHA_OPERACION(results.getTimestamp(5));
				tmpCgg_res_prestamo_expediente.setCRPEX_MOVIMIENTO(results.getInt(6));
				tmpCgg_res_prestamo_expediente.setCRPEX_OBSERVACION(results.getString(7));
				tmpCgg_res_prestamo_expediente.setCRPEX_ESTADO(results.getBoolean(8));
				outCgg_res_prestamo_expediente.add(tmpCgg_res_prestamo_expediente);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_expediente;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_prestamo_expediente().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_prestamo_expediente().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_prestamo_expediente OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> outCgg_res_prestamo_expediente = new ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_S_CGG_RES_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_prestamo_expediente().getCRPER_CODIGO());
			stmSelect.setString(3,this.getCgg_res_prestamo_expediente().getCGG_CRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_prestamo_expediente tmpCgg_res_prestamo_expediente = new com.besixplus.sii.objects.Cgg_res_prestamo_expediente();
				tmpCgg_res_prestamo_expediente.setCRPEX_CODIGO(results.getString(1));
				tmpCgg_res_prestamo_expediente.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_prestamo_expediente.setCRPER_CODIGO(results.getString(3));
				tmpCgg_res_prestamo_expediente.setCGG_CRPER_CODIGO(results.getString(4));
				tmpCgg_res_prestamo_expediente.setCRPEX_FECHA_OPERACION(results.getTimestamp(5));
				tmpCgg_res_prestamo_expediente.setCRPEX_MOVIMIENTO(results.getInt(6));
				tmpCgg_res_prestamo_expediente.setCRPEX_OBSERVACION(results.getString(7));
				tmpCgg_res_prestamo_expediente.setCRPEX_ESTADO(results.getBoolean(8));
				outCgg_res_prestamo_expediente.add(tmpCgg_res_prestamo_expediente);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_expediente;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_prestamo_expediente DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_D_CGG_RES_PERSONA(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_prestamo_expediente().getCRPER_CODIGO());
			stmDelete.setString(2, this.getCgg_res_prestamo_expediente().getCGG_CRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PRESTAMO_EXPEDIENTE_DS_CGG_RES_PERSONA(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_prestamo_expediente().getCRPER_CODIGO());
				stmDelete.setString(2, this.getCgg_res_prestamo_expediente().getCGG_CRPER_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_prestamo_espediente QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPrestamoExpePersona(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_prestamo_expediente = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_prestamo(?,?,?,?,?,?) }");
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
				outCgg_res_prestamo_expediente.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_expediente;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectExpPersonaCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_prestamo_expediente_count_persona(?) }");
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