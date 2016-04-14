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
* CLASE Cgg_veh_motor
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_motor.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_motor implements Serializable{
	private static final long serialVersionUID = 1443114262;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_motor.
	*/
	private com.besixplus.sii.objects.Cgg_veh_motor myCgg_veh_motor = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_motor.
	*/
	public Cgg_veh_motor(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_motor.
	* @param inCgg_veh_motor OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_motor.
	*/
	public Cgg_veh_motor(
		com.besixplus.sii.objects.Cgg_veh_motor inCgg_veh_motor
	){
		this.setCgg_veh_motor(inCgg_veh_motor);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_motor.
	* @param inCgg_veh_motor OBJETO Cgg_veh_motor.
	* @return void
	*/
	public void setCgg_veh_motor(com.besixplus.sii.objects.Cgg_veh_motor inCgg_veh_motor){
		this.myCgg_veh_motor = inCgg_veh_motor;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_motor.
	* @return Cgg_veh_motor OBJETO Cgg_veh_motor.
	*/
	public com.besixplus.sii.objects.Cgg_veh_motor getCgg_veh_motor(){
		return this.myCgg_veh_motor;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_INSERT(?, ?, ?, ?, ?, ?::smallint, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_motor().getCVMTR_CODIGO());
			stmInsert.setString(3, this.getCgg_veh_motor().getCVCLN_CODIGO());
			stmInsert.setString(4, this.getCgg_veh_motor().getCVMRC_CODIGO());
			stmInsert.setString(5, this.getCgg_veh_motor().getCVCMB_CODIGO());
			stmInsert.setString(6, this.getCgg_veh_motor().getCVMTR_SERIE());
			stmInsert.setInt(7, this.getCgg_veh_motor().getCVMTR_ANIO_FABRICACION());
			stmInsert.setBoolean(8, this.getCgg_veh_motor().getCVMTR_ESTADO_FUNCIONAL());
			stmInsert.setInt(9, this.getCgg_veh_motor().getCVMTR_TONELAJE());
			stmInsert.setBoolean(10, this.getCgg_veh_motor().getCVMTR_INGRESO());
			stmInsert.setTimestamp(11, this.getCgg_veh_motor().getCVMTR_FECHA_INGRESO()!=null?new java.sql.Timestamp(this.getCgg_veh_motor().getCVMTR_FECHA_INGRESO().getTime()):null);
			stmInsert.setBoolean(12, this.getCgg_veh_motor().getCVMTR_SALIO());
			stmInsert.setTimestamp(13, this.getCgg_veh_motor().getCVMTR_FECHA_SALIDA()!=null?new java.sql.Timestamp(this.getCgg_veh_motor().getCVMTR_FECHA_SALIDA().getTime()):null);
			stmInsert.setString(14, this.getCgg_veh_motor().getCVMTR_OBSERVACION());
			stmInsert.setBoolean(15, this.getCgg_veh_motor().getCVMTR_ESTADO());
			stmInsert.setString(16, this.getCgg_veh_motor().getCVMTR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_veh_motor().setCVMTR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> outCgg_veh_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_motor tmpCgg_veh_motor = new com.besixplus.sii.objects.Cgg_veh_motor();
				tmpCgg_veh_motor.setCVMTR_CODIGO(results.getString(1));
				tmpCgg_veh_motor.setCVCLN_CODIGO(results.getString(2));
				tmpCgg_veh_motor.setCVMRC_CODIGO(results.getString(3));
				tmpCgg_veh_motor.setCVCMB_CODIGO(results.getString(4));
				tmpCgg_veh_motor.setCVMTR_SERIE(results.getString(5));
				tmpCgg_veh_motor.setCVMTR_ANIO_FABRICACION(results.getInt(6));
				tmpCgg_veh_motor.setCVMTR_ESTADO_FUNCIONAL(results.getBoolean(7));
				tmpCgg_veh_motor.setCVMTR_TONELAJE(results.getInt(8));
				tmpCgg_veh_motor.setCVMTR_INGRESO(results.getBoolean(9));
				tmpCgg_veh_motor.setCVMTR_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_motor.setCVMTR_SALIO(results.getBoolean(11));
				tmpCgg_veh_motor.setCVMTR_FECHA_SALIDA(results.getTimestamp(12));
				tmpCgg_veh_motor.setCVMTR_OBSERVACION(results.getString(13));
				tmpCgg_veh_motor.setCVMTR_ESTADO(results.getBoolean(14));
				outCgg_veh_motor.add(tmpCgg_veh_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_motor;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_motor QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> outCgg_veh_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_veh_motor tmpCgg_veh_motor = new com.besixplus.sii.objects.Cgg_veh_motor();
				tmpCgg_veh_motor.setCVMTR_CODIGO(results.getString(1));
				tmpCgg_veh_motor.setCVCLN_CODIGO(results.getString(2));
				tmpCgg_veh_motor.setCVMRC_CODIGO(results.getString(3));
				tmpCgg_veh_motor.setCVCMB_CODIGO(results.getString(4));
				tmpCgg_veh_motor.setCVMTR_SERIE(results.getString(5));
				tmpCgg_veh_motor.setCVMTR_ANIO_FABRICACION(results.getInt(6));
				tmpCgg_veh_motor.setCVMTR_ESTADO_FUNCIONAL(results.getBoolean(7));
				tmpCgg_veh_motor.setCVMTR_TONELAJE(results.getInt(8));
				tmpCgg_veh_motor.setCVMTR_INGRESO(results.getBoolean(9));
				tmpCgg_veh_motor.setCVMTR_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_motor.setCVMTR_SALIO(results.getBoolean(11));
				tmpCgg_veh_motor.setCVMTR_FECHA_SALIDA(results.getTimestamp(12));
				tmpCgg_veh_motor.setCVMTR_OBSERVACION(results.getString(13));
				tmpCgg_veh_motor.setCVMTR_ESTADO(results.getBoolean(14));
				outCgg_veh_motor.add(tmpCgg_veh_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_motor;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_motor QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCvveh_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_veh_motor = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCvveh_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_veh_motor.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_motor;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_COUNT() }");
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
	* @param inCvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCvveh_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCvveh_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_motor().getCVMTR_CODIGO());
			stmUpdate.setString(2, this.getCgg_veh_motor().getCVCLN_CODIGO());
			stmUpdate.setString(3, this.getCgg_veh_motor().getCVMRC_CODIGO());
			stmUpdate.setString(4, this.getCgg_veh_motor().getCVCMB_CODIGO());
			stmUpdate.setString(5, this.getCgg_veh_motor().getCVMTR_SERIE());
			stmUpdate.setInt(6, this.getCgg_veh_motor().getCVMTR_ANIO_FABRICACION());
			stmUpdate.setBoolean(7, this.getCgg_veh_motor().getCVMTR_ESTADO_FUNCIONAL());
			stmUpdate.setInt(8, this.getCgg_veh_motor().getCVMTR_TONELAJE());
			stmUpdate.setBoolean(9, this.getCgg_veh_motor().getCVMTR_INGRESO());
			stmUpdate.setTimestamp(10, this.getCgg_veh_motor().getCVMTR_FECHA_INGRESO()!=null?new java.sql.Timestamp(this.getCgg_veh_motor().getCVMTR_FECHA_INGRESO().getTime()):null);
			stmUpdate.setBoolean(11, this.getCgg_veh_motor().getCVMTR_SALIO());
			stmUpdate.setTimestamp(12, this.getCgg_veh_motor().getCVMTR_FECHA_SALIDA()!=null?new java.sql.Timestamp(this.getCgg_veh_motor().getCVMTR_FECHA_SALIDA().getTime()):null);
			stmUpdate.setString(13, this.getCgg_veh_motor().getCVMTR_OBSERVACION());
			stmUpdate.setBoolean(14, this.getCgg_veh_motor().getCVMTR_ESTADO());
			stmUpdate.setString(15, this.getCgg_veh_motor().getCVMTR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_motor DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_veh_motor select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_motor().getCVMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_veh_motor().setCVMTR_CODIGO(results.getString(1));
				this.getCgg_veh_motor().setCVCLN_CODIGO(results.getString(2));
				this.getCgg_veh_motor().setCVMRC_CODIGO(results.getString(3));
				this.getCgg_veh_motor().setCVCMB_CODIGO(results.getString(4));
				this.getCgg_veh_motor().setCVMTR_SERIE(results.getString(5));
				this.getCgg_veh_motor().setCVMTR_ANIO_FABRICACION(results.getInt(6));
				this.getCgg_veh_motor().setCVMTR_ESTADO_FUNCIONAL(results.getBoolean(7));
				this.getCgg_veh_motor().setCVMTR_TONELAJE(results.getInt(8));
				this.getCgg_veh_motor().setCVMTR_INGRESO(results.getBoolean(9));
				this.getCgg_veh_motor().setCVMTR_FECHA_INGRESO(results.getTimestamp(10));
				this.getCgg_veh_motor().setCVMTR_SALIO(results.getBoolean(11));
				this.getCgg_veh_motor().setCVMTR_FECHA_SALIDA(results.getTimestamp(12));
				this.getCgg_veh_motor().setCVMTR_OBSERVACION(results.getString(13));
				this.getCgg_veh_motor().setCVMTR_ESTADO(results.getBoolean(14));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_veh_motor();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_motor DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_motor().getCVMTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_motor().getCVMTR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_motor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_combustible.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> selectCGG_VEH_COMBUSTIBLE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> outCgg_veh_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_S_CGG_VEH_COMBUSTIBLE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_motor().getCVCMB_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_motor tmpCgg_veh_motor = new com.besixplus.sii.objects.Cgg_veh_motor();
				tmpCgg_veh_motor.setCVMTR_CODIGO(results.getString(1));
				tmpCgg_veh_motor.setCVCLN_CODIGO(results.getString(2));
				tmpCgg_veh_motor.setCVMRC_CODIGO(results.getString(3));
				tmpCgg_veh_motor.setCVCMB_CODIGO(results.getString(4));
				tmpCgg_veh_motor.setCVMTR_SERIE(results.getString(5));
				tmpCgg_veh_motor.setCVMTR_ANIO_FABRICACION(results.getInt(6));
				tmpCgg_veh_motor.setCVMTR_ESTADO_FUNCIONAL(results.getBoolean(7));
				tmpCgg_veh_motor.setCVMTR_TONELAJE(results.getInt(8));
				tmpCgg_veh_motor.setCVMTR_INGRESO(results.getBoolean(9));
				tmpCgg_veh_motor.setCVMTR_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_motor.setCVMTR_SALIO(results.getBoolean(11));
				tmpCgg_veh_motor.setCVMTR_FECHA_SALIDA(results.getTimestamp(12));
				tmpCgg_veh_motor.setCVMTR_OBSERVACION(results.getString(13));
				tmpCgg_veh_motor.setCVMTR_ESTADO(results.getBoolean(14));
				outCgg_veh_motor.add(tmpCgg_veh_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_motor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_motor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_combustible.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_COMBUSTIBLE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_D_CGG_VEH_COMBUSTIBLE(?) }");
			stmDelete.setString(1, this.getCgg_veh_motor().getCVCMB_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_DS_CGG_VEH_COMBUSTIBLE(?) }");
				stmDelete.setString(1, this.getCgg_veh_motor().getCVCMB_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_motor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_marca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> selectCGG_VEH_MARCA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> outCgg_veh_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_S_CGG_VEH_MARCA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_motor().getCVMRC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_motor tmpCgg_veh_motor = new com.besixplus.sii.objects.Cgg_veh_motor();
				tmpCgg_veh_motor.setCVMTR_CODIGO(results.getString(1));
				tmpCgg_veh_motor.setCVCLN_CODIGO(results.getString(2));
				tmpCgg_veh_motor.setCVMRC_CODIGO(results.getString(3));
				tmpCgg_veh_motor.setCVCMB_CODIGO(results.getString(4));
				tmpCgg_veh_motor.setCVMTR_SERIE(results.getString(5));
				tmpCgg_veh_motor.setCVMTR_ANIO_FABRICACION(results.getInt(6));
				tmpCgg_veh_motor.setCVMTR_ESTADO_FUNCIONAL(results.getBoolean(7));
				tmpCgg_veh_motor.setCVMTR_TONELAJE(results.getInt(8));
				tmpCgg_veh_motor.setCVMTR_INGRESO(results.getBoolean(9));
				tmpCgg_veh_motor.setCVMTR_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_motor.setCVMTR_SALIO(results.getBoolean(11));
				tmpCgg_veh_motor.setCVMTR_FECHA_SALIDA(results.getTimestamp(12));
				tmpCgg_veh_motor.setCVMTR_OBSERVACION(results.getString(13));
				tmpCgg_veh_motor.setCVMTR_ESTADO(results.getBoolean(14));
				outCgg_veh_motor.add(tmpCgg_veh_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_motor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_motor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_marca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_MARCA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_D_CGG_VEH_MARCA(?) }");
			stmDelete.setString(1, this.getCgg_veh_motor().getCVMRC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_DS_CGG_VEH_MARCA(?) }");
				stmDelete.setString(1, this.getCgg_veh_motor().getCVMRC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_motor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_cilindraje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> selectCGG_VEH_CILINDRAJE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> outCgg_veh_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_MOTOR_S_CGG_VEH_CILINDRAJE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_motor().getCVCLN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_motor tmpCgg_veh_motor = new com.besixplus.sii.objects.Cgg_veh_motor();
				tmpCgg_veh_motor.setCVMTR_CODIGO(results.getString(1));
				tmpCgg_veh_motor.setCVCLN_CODIGO(results.getString(2));
				tmpCgg_veh_motor.setCVMRC_CODIGO(results.getString(3));
				tmpCgg_veh_motor.setCVCMB_CODIGO(results.getString(4));
				tmpCgg_veh_motor.setCVMTR_SERIE(results.getString(5));
				tmpCgg_veh_motor.setCVMTR_ANIO_FABRICACION(results.getInt(6));
				tmpCgg_veh_motor.setCVMTR_ESTADO_FUNCIONAL(results.getBoolean(7));
				tmpCgg_veh_motor.setCVMTR_TONELAJE(results.getInt(8));
				tmpCgg_veh_motor.setCVMTR_INGRESO(results.getBoolean(9));
				tmpCgg_veh_motor.setCVMTR_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_motor.setCVMTR_SALIO(results.getBoolean(11));
				tmpCgg_veh_motor.setCVMTR_FECHA_SALIDA(results.getTimestamp(12));
				tmpCgg_veh_motor.setCVMTR_OBSERVACION(results.getString(13));
				tmpCgg_veh_motor.setCVMTR_ESTADO(results.getBoolean(14));
				outCgg_veh_motor.add(tmpCgg_veh_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_motor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_motor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_cilindraje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_CILINDRAJE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_D_CGG_VEH_CILINDRAJE(?) }");
			stmDelete.setString(1, this.getCgg_veh_motor().getCVCLN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_MOTOR_DS_CGG_VEH_CILINDRAJE(?) }");
				stmDelete.setString(1, this.getCgg_veh_motor().getCVCLN_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

}