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
* CLASE Cgg_veh_cilindraje
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_cilindraje.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_cilindraje implements Serializable{
	private static final long serialVersionUID = 333122506;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_cilindraje.
	*/
	private com.besixplus.sii.objects.Cgg_veh_cilindraje myCgg_veh_cilindraje = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_cilindraje.
	*/
	public Cgg_veh_cilindraje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_cilindraje.
	* @param inCgg_veh_cilindraje OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_cilindraje.
	*/
	public Cgg_veh_cilindraje(
		com.besixplus.sii.objects.Cgg_veh_cilindraje inCgg_veh_cilindraje
	){
		this.setCgg_veh_cilindraje(inCgg_veh_cilindraje);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_cilindraje.
	* @param inCgg_veh_cilindraje OBJETO Cgg_veh_cilindraje.
	* @return void
	*/
	public void setCgg_veh_cilindraje(com.besixplus.sii.objects.Cgg_veh_cilindraje inCgg_veh_cilindraje){
		this.myCgg_veh_cilindraje = inCgg_veh_cilindraje;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_cilindraje.
	* @return Cgg_veh_cilindraje OBJETO Cgg_veh_cilindraje.
	*/
	public com.besixplus.sii.objects.Cgg_veh_cilindraje getCgg_veh_cilindraje(){
		return this.myCgg_veh_cilindraje;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_cilindraje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_INSERT(?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_cilindraje().getCVCLN_CODIGO());
			stmInsert.setInt(3, this.getCgg_veh_cilindraje().getCVCLN_CILINDRAJE());
			stmInsert.setString(4, this.getCgg_veh_cilindraje().getCVCLN_OBSERVACION());
			stmInsert.setBoolean(5, this.getCgg_veh_cilindraje().getCVCLN_ESTADO());
			stmInsert.setString(6, this.getCgg_veh_cilindraje().getCVCLN_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_veh_cilindraje().getCVCLN_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_veh_cilindraje().setCVCLN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_cilindraje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> outCgg_veh_cilindraje = new ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_cilindraje tmpCgg_veh_cilindraje = new com.besixplus.sii.objects.Cgg_veh_cilindraje();
				tmpCgg_veh_cilindraje.setCVCLN_CODIGO(results.getString(1));
				tmpCgg_veh_cilindraje.setCVCLN_CILINDRAJE(results.getInt(2));
				tmpCgg_veh_cilindraje.setCVCLN_OBSERVACION(results.getString(3));
				tmpCgg_veh_cilindraje.setCVCLN_ESTADO(results.getBoolean(4));
				outCgg_veh_cilindraje.add(tmpCgg_veh_cilindraje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_cilindraje;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_cilindraje QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> outCgg_veh_cilindraje = new ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_veh_cilindraje tmpCgg_veh_cilindraje = new com.besixplus.sii.objects.Cgg_veh_cilindraje();
				tmpCgg_veh_cilindraje.setCVCLN_CODIGO(results.getString(1));
				tmpCgg_veh_cilindraje.setCVCLN_CILINDRAJE(results.getInt(2));
				tmpCgg_veh_cilindraje.setCVCLN_OBSERVACION(results.getString(3));
				tmpCgg_veh_cilindraje.setCVCLN_ESTADO(results.getBoolean(4));
				outCgg_veh_cilindraje.add(tmpCgg_veh_cilindraje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_cilindraje;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_cilindraje QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_cilindraje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_veh_cilindraje = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_veh_cilindraje.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_cilindraje;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_cilindraje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_cilindraje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_CILINDRAJE_UPDATE(?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_cilindraje().getCVCLN_CODIGO());
			stmUpdate.setInt(2, this.getCgg_veh_cilindraje().getCVCLN_CILINDRAJE());
			stmUpdate.setString(3, this.getCgg_veh_cilindraje().getCVCLN_OBSERVACION());
			stmUpdate.setBoolean(4, this.getCgg_veh_cilindraje().getCVCLN_ESTADO());
			stmUpdate.setString(5, this.getCgg_veh_cilindraje().getCVCLN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_cilindraje DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_cilindraje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_veh_cilindraje select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CILINDRAJE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_cilindraje().getCVCLN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_veh_cilindraje().setCVCLN_CODIGO(results.getString(1));
				this.getCgg_veh_cilindraje().setCVCLN_CILINDRAJE(results.getInt(2));
				this.getCgg_veh_cilindraje().setCVCLN_OBSERVACION(results.getString(3));
				this.getCgg_veh_cilindraje().setCVCLN_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_veh_cilindraje();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_cilindraje DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_CILINDRAJE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_cilindraje().getCVCLN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_CILINDRAJE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_cilindraje().getCVCLN_CODIGO());
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