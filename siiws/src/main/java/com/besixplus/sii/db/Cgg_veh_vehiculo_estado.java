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
* CLASE Cgg_veh_vehiculo_estado
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_vehiculo_estado.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_vehiculo_estado implements Serializable{
	private static final long serialVersionUID = 1911902811;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_vehiculo_estado.
	*/
	private com.besixplus.sii.objects.Cgg_veh_vehiculo_estado myCgg_veh_vehiculo_estado = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_estado.
	*/
	public Cgg_veh_vehiculo_estado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_estado.
	* @param inCgg_veh_vehiculo_estado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_vehiculo_estado.
	*/
	public Cgg_veh_vehiculo_estado(
		com.besixplus.sii.objects.Cgg_veh_vehiculo_estado inCgg_veh_vehiculo_estado
	){
		this.setCgg_veh_vehiculo_estado(inCgg_veh_vehiculo_estado);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_vehiculo_estado.
	* @param inCgg_veh_vehiculo_estado OBJETO Cgg_veh_vehiculo_estado.
	* @return void
	*/
	public void setCgg_veh_vehiculo_estado(com.besixplus.sii.objects.Cgg_veh_vehiculo_estado inCgg_veh_vehiculo_estado){
		this.myCgg_veh_vehiculo_estado = inCgg_veh_vehiculo_estado;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_vehiculo_estado.
	* @return Cgg_veh_vehiculo_estado OBJETO Cgg_veh_vehiculo_estado.
	*/
	public com.besixplus.sii.objects.Cgg_veh_vehiculo_estado getCgg_veh_vehiculo_estado(){
		return this.myCgg_veh_vehiculo_estado;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo_estado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_vehiculo_estado().getCVSVH_CODIGO());
			stmInsert.setString(3, this.getCgg_veh_vehiculo_estado().getCVVEH_CODIGO());
			stmInsert.setString(4, this.getCgg_veh_vehiculo_estado().getCVSVM_CODIGO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_veh_vehiculo_estado().getCVSVH_FECHA().getTime()));
			stmInsert.setString(6, this.getCgg_veh_vehiculo_estado().getCVSVH_OBSERVACION());
			stmInsert.setBoolean(7, this.getCgg_veh_vehiculo_estado().getCVSVH_ESTADO());
			stmInsert.setString(8, this.getCgg_veh_vehiculo_estado().getCVSVH_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_veh_vehiculo_estado().setCVSVH_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> outCgg_veh_vehiculo_estado = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo_estado tmpCgg_veh_vehiculo_estado = new com.besixplus.sii.objects.Cgg_veh_vehiculo_estado();
				tmpCgg_veh_vehiculo_estado.setCVSVH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo_estado.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo_estado.setCVSVM_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo_estado.setCVSVH_FECHA(results.getTimestamp(4));
				tmpCgg_veh_vehiculo_estado.setCVSVH_OBSERVACION(results.getString(5));
				tmpCgg_veh_vehiculo_estado.setCVSVH_ESTADO(results.getBoolean(6));
				outCgg_veh_vehiculo_estado.add(tmpCgg_veh_vehiculo_estado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_estado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> outCgg_veh_vehiculo_estado = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_veh_vehiculo_estado tmpCgg_veh_vehiculo_estado = new com.besixplus.sii.objects.Cgg_veh_vehiculo_estado();
				tmpCgg_veh_vehiculo_estado.setCVSVH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo_estado.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo_estado.setCVSVM_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo_estado.setCVSVH_FECHA(results.getTimestamp(4));
				tmpCgg_veh_vehiculo_estado.setCVSVH_OBSERVACION(results.getString(5));
				tmpCgg_veh_vehiculo_estado.setCVSVH_ESTADO(results.getBoolean(6));
				outCgg_veh_vehiculo_estado.add(tmpCgg_veh_vehiculo_estado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_estado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_veh_vehiculo_estado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_veh_vehiculo_estado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_estado;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_vehiculo_estado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo_estado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_vehiculo_estado().getCVSVH_CODIGO());
			stmUpdate.setString(2, this.getCgg_veh_vehiculo_estado().getCVVEH_CODIGO());
			stmUpdate.setString(3, this.getCgg_veh_vehiculo_estado().getCVSVM_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_veh_vehiculo_estado().getCVSVH_FECHA().getTime()));
			stmUpdate.setString(5, this.getCgg_veh_vehiculo_estado().getCVSVH_OBSERVACION());
			stmUpdate.setBoolean(6, this.getCgg_veh_vehiculo_estado().getCVSVH_ESTADO());
			stmUpdate.setString(7, this.getCgg_veh_vehiculo_estado().getCVSVH_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo_estado DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo_estado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_veh_vehiculo_estado select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo_estado().getCVSVH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_veh_vehiculo_estado().setCVSVH_CODIGO(results.getString(1));
				this.getCgg_veh_vehiculo_estado().setCVVEH_CODIGO(results.getString(2));
				this.getCgg_veh_vehiculo_estado().setCVSVM_CODIGO(results.getString(3));
				this.getCgg_veh_vehiculo_estado().setCVSVH_FECHA(results.getTimestamp(4));
				this.getCgg_veh_vehiculo_estado().setCVSVH_OBSERVACION(results.getString(5));
				this.getCgg_veh_vehiculo_estado().setCVSVH_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_veh_vehiculo_estado();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo_estado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo_estado().getCVSVH_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo_estado().getCVSVH_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo_estado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<LinkedHashMap<String, Object>> selectCGG_VEH_VEHICULO(
		java.sql.Connection inConnection
	){
		ArrayList<LinkedHashMap<String, Object>> outCgg_veh_vehiculo_estado = new ArrayList<LinkedHashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_S_CGG_VEH_VEHICULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo_estado().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				LinkedHashMap<String,Object> tmpObj = new LinkedHashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_veh_vehiculo_estado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_estado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_vehiculo.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_D_CGG_VEH_VEHICULO(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo_estado().getCVVEH_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_DS_CGG_VEH_VEHICULO(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo_estado().getCVVEH_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_estado_vhmt.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo_estado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> selectCGG_VEH_ESTADO_VHMT(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado> outCgg_veh_vehiculo_estado = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo_estado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_ESTADO_S_CGG_VEH_ESTADO_VHMT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo_estado().getCVSVM_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo_estado tmpCgg_veh_vehiculo_estado = new com.besixplus.sii.objects.Cgg_veh_vehiculo_estado();
				tmpCgg_veh_vehiculo_estado.setCVSVH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo_estado.setCVVEH_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo_estado.setCVSVM_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo_estado.setCVSVH_FECHA(results.getTimestamp(4));
				tmpCgg_veh_vehiculo_estado.setCVSVH_OBSERVACION(results.getString(5));
				tmpCgg_veh_vehiculo_estado.setCVSVH_ESTADO(results.getBoolean(6));
				outCgg_veh_vehiculo_estado.add(tmpCgg_veh_vehiculo_estado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo_estado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo_estado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_estado_vhmt.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_ESTADO_VHMT(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_D_CGG_VEH_ESTADO_VHMT(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo_estado().getCVSVM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_ESTADO_DS_CGG_VEH_ESTADO_VHMT(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo_estado().getCVSVM_CODIGO());
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