package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_veh_vehiculo_motor
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_vehiculo_motor.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_vehiculo_motor implements Serializable{
	private static final long serialVersionUID = 1228588490;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_vehiculo_motor.
	*/
	private com.besixplus.sii.objects.Cgg_veh_vehiculo_motor myCgg_veh_vehiculo_motor = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_motor.
	*/
	public Cgg_veh_vehiculo_motor(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_motor.
	* @param inCgg_veh_vehiculo_motor OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_vehiculo_motor.
	*/
	public Cgg_veh_vehiculo_motor(
		com.besixplus.sii.objects.Cgg_veh_vehiculo_motor inCgg_veh_vehiculo_motor
	){
		this.setCgg_veh_vehiculo_motor(inCgg_veh_vehiculo_motor);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_vehiculo_motor.
	* @param inCgg_veh_vehiculo_motor OBJETO Cgg_veh_vehiculo_motor.
	* @return void
	*/
	public void setCgg_veh_vehiculo_motor(com.besixplus.sii.objects.Cgg_veh_vehiculo_motor inCgg_veh_vehiculo_motor){
		this.myCgg_veh_vehiculo_motor = inCgg_veh_vehiculo_motor;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_vehiculo_motor.
	* @return Cgg_veh_vehiculo_motor OBJETO Cgg_veh_vehiculo_motor.
	*/
	public com.besixplus.sii.objects.Cgg_veh_vehiculo_motor getCgg_veh_vehiculo_motor(){
		return this.myCgg_veh_vehiculo_motor;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_vehiculo_motor().getCVVMT_CODIGO());
			stmInsert.setString(3, this.getCgg_veh_vehiculo_motor().getCVVEH_CODIGO());
			stmInsert.setString(4, this.getCgg_veh_vehiculo_motor().getCVMTR_CODIGO());
			stmInsert.setTimestamp(5, this.getCgg_veh_vehiculo_motor().getCVVMT_FECHA()!=null?new java.sql.Timestamp(this.getCgg_veh_vehiculo_motor().getCVVMT_FECHA().getTime()):null);
			stmInsert.setString(6, this.getCgg_veh_vehiculo_motor().getCVVMT_OBSERVACION());
			stmInsert.setBoolean(7, this.getCgg_veh_vehiculo_motor().getCVVMT_ESTADO());
			stmInsert.setString(8, this.getCgg_veh_vehiculo_motor().getCVVMT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_veh_vehiculo_motor().setCVVMT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> outCgg_veh_vehiculo_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo_motor tmpCgg_veh_vehiculo_motor = new com.besixplus.sii.objects.Cgg_veh_vehiculo_motor();
				tmpCgg_veh_vehiculo_motor.setCVVMT_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo_motor.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo_motor.setCVMTR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo_motor.setCVVMT_FECHA(results.getTimestamp(4));
				tmpCgg_veh_vehiculo_motor.setCVVMT_OBSERVACION(results.getString(5));
				tmpCgg_veh_vehiculo_motor.setCVVMT_ESTADO(results.getBoolean(6));
				outCgg_veh_vehiculo_motor.add(tmpCgg_veh_vehiculo_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_motor;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> outCgg_veh_vehiculo_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_veh_vehiculo_motor tmpCgg_veh_vehiculo_motor = new com.besixplus.sii.objects.Cgg_veh_vehiculo_motor();
				tmpCgg_veh_vehiculo_motor.setCVVMT_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo_motor.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo_motor.setCVMTR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo_motor.setCVVMT_FECHA(results.getTimestamp(4));
				tmpCgg_veh_vehiculo_motor.setCVVMT_OBSERVACION(results.getString(5));
				tmpCgg_veh_vehiculo_motor.setCVVMT_ESTADO(results.getBoolean(6));
				outCgg_veh_vehiculo_motor.add(tmpCgg_veh_vehiculo_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_motor;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_veh_vehiculo_motor = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_SELECT(?,?,?,?,?,?) }");
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
				outCgg_veh_vehiculo_motor.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_motor;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_vehiculo_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_vehiculo_motor().getCVVMT_CODIGO());
			stmUpdate.setString(2, this.getCgg_veh_vehiculo_motor().getCVVEH_CODIGO());
			stmUpdate.setString(3, this.getCgg_veh_vehiculo_motor().getCVMTR_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_veh_vehiculo_motor().getCVVMT_FECHA().getTime()));
			stmUpdate.setString(5, this.getCgg_veh_vehiculo_motor().getCVVMT_OBSERVACION());
			stmUpdate.setBoolean(6, this.getCgg_veh_vehiculo_motor().getCVVMT_ESTADO());
			stmUpdate.setString(7, this.getCgg_veh_vehiculo_motor().getCVVMT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo_motor DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_veh_vehiculo_motor select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo_motor().getCVVMT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_veh_vehiculo_motor().setCVVMT_CODIGO(results.getString(1));
				this.getCgg_veh_vehiculo_motor().setCVVEH_CODIGO(results.getString(2));
				this.getCgg_veh_vehiculo_motor().setCVMTR_CODIGO(results.getString(3));
				this.getCgg_veh_vehiculo_motor().setCVVMT_FECHA(results.getTimestamp(4));
				this.getCgg_veh_vehiculo_motor().setCVVMT_OBSERVACION(results.getString(5));
				this.getCgg_veh_vehiculo_motor().setCVVMT_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_veh_vehiculo_motor();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo_motor DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo_motor().getCVVMT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo_motor().getCVVMT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<LinkedHashMap<String, Object>> selectCGG_VEH_VEHICULO(
		java.sql.Connection inConnection
	){
		ArrayList<LinkedHashMap<String, Object>> outCgg_veh_vehiculo_motor = new ArrayList<LinkedHashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_S_CGG_VEH_VEHICULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo_motor().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				LinkedHashMap<String,Object> tmpObj = new LinkedHashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_veh_vehiculo_motor.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_motor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_VEHICULO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_D_CGG_VEH_VEHICULO(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo_motor().getCVVEH_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_DS_CGG_VEH_VEHICULO(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo_motor().getCVVEH_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo_motor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> selectCGG_VEH_MOTOR(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor> outCgg_veh_vehiculo_motor = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_motor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_MOTOR_S_CGG_VEH_MOTOR(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo_motor().getCVMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo_motor tmpCgg_veh_vehiculo_motor = new com.besixplus.sii.objects.Cgg_veh_vehiculo_motor();
				tmpCgg_veh_vehiculo_motor.setCVVMT_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo_motor.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo_motor.setCVMTR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo_motor.setCVVMT_FECHA(results.getTimestamp(4));
				tmpCgg_veh_vehiculo_motor.setCVVMT_OBSERVACION(results.getString(5));
				tmpCgg_veh_vehiculo_motor.setCVVMT_ESTADO(results.getBoolean(6));
				outCgg_veh_vehiculo_motor.add(tmpCgg_veh_vehiculo_motor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_motor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_motor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_motor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_MOTOR(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_D_CGG_VEH_MOTOR(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo_motor().getCVMTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_MOTOR_DS_CGG_VEH_MOTOR(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo_motor().getCVMTR_CODIGO());
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