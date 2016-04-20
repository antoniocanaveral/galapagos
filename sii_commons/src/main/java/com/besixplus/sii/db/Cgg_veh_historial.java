package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_veh_historial
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_historial.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_historial implements Serializable{
	private static final long serialVersionUID = 226943905;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_historial.
	*/
	private com.besixplus.sii.objects.Cgg_veh_historial myCgg_veh_historial = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_historial.
	*/
	public Cgg_veh_historial(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_historial.
	* @param inCgg_veh_historial OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_historial.
	*/
	public Cgg_veh_historial(
		com.besixplus.sii.objects.Cgg_veh_historial inCgg_veh_historial
	){
		this.setCgg_veh_historial(inCgg_veh_historial);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_historial.
	* @param inCgg_veh_historial OBJETO Cgg_veh_historial.
	* @return void
	*/
	public void setCgg_veh_historial(com.besixplus.sii.objects.Cgg_veh_historial inCgg_veh_historial){
		this.myCgg_veh_historial = inCgg_veh_historial;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_historial.
	* @return Cgg_veh_historial OBJETO Cgg_veh_historial.
	*/
	public com.besixplus.sii.objects.Cgg_veh_historial getCgg_veh_historial(){
		return this.myCgg_veh_historial;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_historial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_historial().getCVHST_CODIGO());
			stmInsert.setString(3, this.getCgg_veh_historial().getCVVEH_CODIGO());
			stmInsert.setString(4, this.getCgg_veh_historial().getCRPER_CODIGO());
			stmInsert.setString(5, this.getCgg_veh_historial().getCRPJR_CODIGO());
			stmInsert.setBoolean(6, this.getCgg_veh_historial().getCVHST_EXPULSADO());
			stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_veh_historial().getCVHST_FECHA_TRASPASO().getTime()));
			stmInsert.setBoolean(8, this.getCgg_veh_historial().getCVHST_PROPIETARIO());
			stmInsert.setString(9, this.getCgg_veh_historial().getCVHST_CONCEPTO());
			stmInsert.setInt(10, this.getCgg_veh_historial().getCVHST_TIPO_PERMANENCIA());
			stmInsert.setTimestamp(11, new java.sql.Timestamp(this.getCgg_veh_historial().getCVHST_FECHA_INGRESO().getTime()));
			stmInsert.setTimestamp(12, new java.sql.Timestamp(this.getCgg_veh_historial().getCVHST_FECHA_SALIDA().getTime()));
			stmInsert.setInt(13, this.getCgg_veh_historial().getCVHST_TIEMPO_ESTADIA());
			stmInsert.setString(14, this.getCgg_veh_historial().getCVHST_OBSERVACIONES());
			stmInsert.setBoolean(15, this.getCgg_veh_historial().getCVHST_ESTADO());
			stmInsert.setString(16, this.getCgg_veh_historial().getCVHST_USUARIO_INSERT());
			stmInsert.setString(17, this.getCgg_veh_historial().getCVHST_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_veh_historial().setCVHST_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_historial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> outCgg_veh_historial = new ArrayList<com.besixplus.sii.objects.Cgg_veh_historial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_historial tmpCgg_veh_historial = new com.besixplus.sii.objects.Cgg_veh_historial();
				tmpCgg_veh_historial.setCVHST_CODIGO(results.getString(1));
				tmpCgg_veh_historial.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_historial.setCRPER_CODIGO(results.getString(3));
				tmpCgg_veh_historial.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_veh_historial.setCVHST_EXPULSADO(results.getBoolean(5));
				tmpCgg_veh_historial.setCVHST_FECHA_TRASPASO(results.getTimestamp(6));
				tmpCgg_veh_historial.setCVHST_PROPIETARIO(results.getBoolean(7));
				tmpCgg_veh_historial.setCVHST_CONCEPTO(results.getString(8));
				tmpCgg_veh_historial.setCVHST_TIPO_PERMANENCIA(results.getInt(9));
				tmpCgg_veh_historial.setCVHST_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_historial.setCVHST_FECHA_SALIDA(results.getTimestamp(11));
				tmpCgg_veh_historial.setCVHST_TIEMPO_ESTADIA(results.getInt(12));
				tmpCgg_veh_historial.setCVHST_OBSERVACIONES(results.getString(13));
				tmpCgg_veh_historial.setCVHST_ESTADO(results.getBoolean(14));
				outCgg_veh_historial.add(tmpCgg_veh_historial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_historial;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_historial QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_veh_historial = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_SELECT(?,?,?,?,?,?,?) }");
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
				outCgg_veh_historial.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_historial;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_historial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_COUNT() }");
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
	* @param inCvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCvveh_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_COUNT(?,?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_historial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_historial().getCVHST_CODIGO());
			stmUpdate.setString(2, this.getCgg_veh_historial().getCVVEH_CODIGO());
			stmUpdate.setString(3, this.getCgg_veh_historial().getCRPER_CODIGO());
			stmUpdate.setString(4, this.getCgg_veh_historial().getCRPJR_CODIGO());
			stmUpdate.setBoolean(5, this.getCgg_veh_historial().getCVHST_EXPULSADO());
			stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_veh_historial().getCVHST_FECHA_TRASPASO().getTime()));
			stmUpdate.setBoolean(7, this.getCgg_veh_historial().getCVHST_PROPIETARIO());
			stmUpdate.setString(8, this.getCgg_veh_historial().getCVHST_CONCEPTO());
			stmUpdate.setInt(9, this.getCgg_veh_historial().getCVHST_TIPO_PERMANENCIA());
			stmUpdate.setTimestamp(10, new java.sql.Timestamp(this.getCgg_veh_historial().getCVHST_FECHA_INGRESO().getTime()));
			stmUpdate.setTimestamp(11, new java.sql.Timestamp(this.getCgg_veh_historial().getCVHST_FECHA_SALIDA().getTime()));
			stmUpdate.setInt(12, this.getCgg_veh_historial().getCVHST_TIEMPO_ESTADIA());
			stmUpdate.setString(13, this.getCgg_veh_historial().getCVHST_OBSERVACIONES());
			stmUpdate.setBoolean(14, this.getCgg_veh_historial().getCVHST_ESTADO());
			stmUpdate.setString(15, this.getCgg_veh_historial().getCVHST_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_historial DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_historial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_veh_historial select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_historial().getCVHST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_veh_historial().setCVHST_CODIGO(results.getString(1));
				this.getCgg_veh_historial().setCVVEH_CODIGO(results.getString(2));
				this.getCgg_veh_historial().setCRPER_CODIGO(results.getString(3));
				this.getCgg_veh_historial().setCRPJR_CODIGO(results.getString(4));
				this.getCgg_veh_historial().setCVHST_EXPULSADO(results.getBoolean(5));
				this.getCgg_veh_historial().setCVHST_FECHA_TRASPASO(results.getTimestamp(6));
				this.getCgg_veh_historial().setCVHST_PROPIETARIO(results.getBoolean(7));
				this.getCgg_veh_historial().setCVHST_CONCEPTO(results.getString(8));
				this.getCgg_veh_historial().setCVHST_TIPO_PERMANENCIA(results.getInt(9));
				this.getCgg_veh_historial().setCVHST_FECHA_INGRESO(results.getTimestamp(10));
				this.getCgg_veh_historial().setCVHST_FECHA_SALIDA(results.getTimestamp(11));
				this.getCgg_veh_historial().setCVHST_TIEMPO_ESTADIA(results.getInt(12));
				this.getCgg_veh_historial().setCVHST_OBSERVACIONES(results.getString(13));
				this.getCgg_veh_historial().setCVHST_ESTADO(results.getBoolean(14));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_veh_historial();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_historial DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_historial().getCVHST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_historial().getCVHST_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_historial DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_historial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> outCgg_veh_historial = new ArrayList<com.besixplus.sii.objects.Cgg_veh_historial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_historial().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_historial tmpCgg_veh_historial = new com.besixplus.sii.objects.Cgg_veh_historial();
				tmpCgg_veh_historial.setCVHST_CODIGO(results.getString(1));
				tmpCgg_veh_historial.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_historial.setCRPER_CODIGO(results.getString(3));
				tmpCgg_veh_historial.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_veh_historial.setCVHST_EXPULSADO(results.getBoolean(5));
				tmpCgg_veh_historial.setCVHST_FECHA_TRASPASO(results.getTimestamp(6));
				tmpCgg_veh_historial.setCVHST_PROPIETARIO(results.getBoolean(7));
				tmpCgg_veh_historial.setCVHST_CONCEPTO(results.getString(8));
				tmpCgg_veh_historial.setCVHST_TIPO_PERMANENCIA(results.getInt(9));
				tmpCgg_veh_historial.setCVHST_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_historial.setCVHST_FECHA_SALIDA(results.getTimestamp(11));
				tmpCgg_veh_historial.setCVHST_TIEMPO_ESTADIA(results.getInt(12));
				tmpCgg_veh_historial.setCVHST_OBSERVACIONES(results.getString(13));
				tmpCgg_veh_historial.setCVHST_ESTADO(results.getBoolean(14));
				outCgg_veh_historial.add(tmpCgg_veh_historial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_historial;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_historial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_veh_historial().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_veh_historial().getCRPJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_historial DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_historial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> outCgg_veh_historial = new ArrayList<com.besixplus.sii.objects.Cgg_veh_historial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_historial().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_historial tmpCgg_veh_historial = new com.besixplus.sii.objects.Cgg_veh_historial();
				tmpCgg_veh_historial.setCVHST_CODIGO(results.getString(1));
				tmpCgg_veh_historial.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_historial.setCRPER_CODIGO(results.getString(3));
				tmpCgg_veh_historial.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_veh_historial.setCVHST_EXPULSADO(results.getBoolean(5));
				tmpCgg_veh_historial.setCVHST_FECHA_TRASPASO(results.getTimestamp(6));
				tmpCgg_veh_historial.setCVHST_PROPIETARIO(results.getBoolean(7));
				tmpCgg_veh_historial.setCVHST_CONCEPTO(results.getString(8));
				tmpCgg_veh_historial.setCVHST_TIPO_PERMANENCIA(results.getInt(9));
				tmpCgg_veh_historial.setCVHST_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_historial.setCVHST_FECHA_SALIDA(results.getTimestamp(11));
				tmpCgg_veh_historial.setCVHST_TIEMPO_ESTADIA(results.getInt(12));
				tmpCgg_veh_historial.setCVHST_OBSERVACIONES(results.getString(13));
				tmpCgg_veh_historial.setCVHST_ESTADO(results.getBoolean(14));
				outCgg_veh_historial.add(tmpCgg_veh_historial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_historial;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_historial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_veh_historial().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_veh_historial().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_historial DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_historial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> selectCGG_VEH_VEHICULO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> outCgg_veh_historial = new ArrayList<com.besixplus.sii.objects.Cgg_veh_historial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_HISTORIAL_S_CGG_VEH_VEHICULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_historial().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_historial tmpCgg_veh_historial = new com.besixplus.sii.objects.Cgg_veh_historial();
				tmpCgg_veh_historial.setCVHST_CODIGO(results.getString(1));
				tmpCgg_veh_historial.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_historial.setCRPER_CODIGO(results.getString(3));
				tmpCgg_veh_historial.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_veh_historial.setCVHST_EXPULSADO(results.getBoolean(5));
				tmpCgg_veh_historial.setCVHST_FECHA_TRASPASO(results.getTimestamp(6));
				tmpCgg_veh_historial.setCVHST_PROPIETARIO(results.getBoolean(7));
				tmpCgg_veh_historial.setCVHST_CONCEPTO(results.getString(8));
				tmpCgg_veh_historial.setCVHST_TIPO_PERMANENCIA(results.getInt(9));
				tmpCgg_veh_historial.setCVHST_FECHA_INGRESO(results.getTimestamp(10));
				tmpCgg_veh_historial.setCVHST_FECHA_SALIDA(results.getTimestamp(11));
				tmpCgg_veh_historial.setCVHST_TIEMPO_ESTADIA(results.getInt(12));
				tmpCgg_veh_historial.setCVHST_OBSERVACIONES(results.getString(13));
				tmpCgg_veh_historial.setCVHST_ESTADO(results.getBoolean(14));
				outCgg_veh_historial.add(tmpCgg_veh_historial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_historial;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_historial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_D_CGG_VEH_VEHICULO(?) }");
			stmDelete.setString(1, this.getCgg_veh_historial().getCVVEH_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_HISTORIAL_DS_CGG_VEH_VEHICULO(?) }");
				stmDelete.setString(1, this.getCgg_veh_historial().getCVVEH_CODIGO());
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
	 * OBTIENE LOS VEHICULOS DE UNA PERSONA
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inCrper_codigo CODIGO DE PERSONA
	 * @param inCvveh_tipo TIPO DE VEHICULO, <code>0</code> TERRESTRES, <code>1</code> MARITIMOS Y <code>2</code> AEREOS
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> selectVehiculo(
			Connection inConnection,
			String inCrper_codigo,
			int inCvveh_tipo
	){
		ArrayList<HashMap<String, Object>> outVehiculos = new ArrayList<HashMap<String,Object>>();
		try {
			CallableStatement tmpStmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_VEH_HISTORIAL_PERSONAL(?,?) }");
			tmpStmSelect.registerOutParameter(1, Types.OTHER);
			tmpStmSelect.setString(2, inCrper_codigo);
			tmpStmSelect.setInt(3, inCvveh_tipo);
			tmpStmSelect.execute();
			ResultSet tmpRes = (ResultSet) tmpStmSelect.getObject(1);
			int tmpColumnCount = tmpRes.getMetaData().getColumnCount(); 
			while(tmpRes.next()){
				HashMap<String, Object> tmpRow = new HashMap<String, Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(tmpRes.getObject(i) != null)
						tmpRow.put(tmpRes.getMetaData().getColumnName(i).toUpperCase(), tmpRes.getObject(i));
				outVehiculos.add(tmpRow);
			}
			tmpRes.close();
			tmpStmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outVehiculos;
	}
	
	/**
	 * Obtiene los vehiculos que no tiene duenio.
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCvveh_tipo TIPO DE VEHICULO, <code>0</code> TERRESTRES, <code>1</code> MARITIMOS Y <code>2</code> AEREOS
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> selectVehiculoLibre(
			Connection inConnection,	
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			int inCvveh_tipo
	){
		ArrayList<HashMap<String, Object>> outVehiculos = new ArrayList<HashMap<String,Object>>();
		try {
			CallableStatement tmpStmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_VEH_LIBRE_SELECT(?,?,?,?,?,?,?) }");
			tmpStmSelect.registerOutParameter(1, Types.OTHER);
			tmpStmSelect.setString(2, inUserName);
			tmpStmSelect.setInt(3, inStart);
			tmpStmSelect.setInt(4, inLimit);
			tmpStmSelect.setString(5, inSortFieldName);
			tmpStmSelect.setString(6, inDirection);
			tmpStmSelect.setString(7, inKeyword);
			tmpStmSelect.setInt(8, inCvveh_tipo);
			tmpStmSelect.execute();
			ResultSet tmpRes = (ResultSet) tmpStmSelect.getObject(1);
			int tmpColumnCount = tmpRes.getMetaData().getColumnCount(); 
			while(tmpRes.next()){
				HashMap<String, Object> tmpRow = new HashMap<String, Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpRow.put(tmpRes.getMetaData().getColumnName(i).toUpperCase(), tmpRes.getObject(i));
				outVehiculos.add(tmpRow);
			}
			tmpRes.close();
			tmpStmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outVehiculos;
	}
	
	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_historial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCvveh_tipo TIPO DE VEHICULO, <code>0</code> TERRESTRES, <code>1</code> MARITIMOS Y <code>2</code> AEREOS
	* @return int TOTAL DE REGISTROS.
	*/
	public int selectVehiculoLibreCount(
		java.sql.Connection inConnection,
		String inKeyword,
		int inCvveh_tipo		
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_VEH_LIBRE_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2,inKeyword);
			stmSelect.setInt(3,inCvveh_tipo);			
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	
}