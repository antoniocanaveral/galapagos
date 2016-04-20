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
* CLASE Cgg_jur_anticipo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_anticipo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_jur_anticipo implements Serializable{
	private static final long serialVersionUID = 2003423735;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_anticipo.
	*/
	private com.besixplus.sii.objects.Cgg_jur_anticipo myCgg_jur_anticipo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_anticipo.
	*/
	public Cgg_jur_anticipo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_anticipo.
	* @param inCgg_jur_anticipo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_anticipo.
	*/
	public Cgg_jur_anticipo(
		com.besixplus.sii.objects.Cgg_jur_anticipo inCgg_jur_anticipo
	){
		this.setCgg_jur_anticipo(inCgg_jur_anticipo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_anticipo.
	* @param inCgg_jur_anticipo OBJETO Cgg_jur_anticipo.
	* @return void
	*/
	public void setCgg_jur_anticipo(com.besixplus.sii.objects.Cgg_jur_anticipo inCgg_jur_anticipo){
		this.myCgg_jur_anticipo = inCgg_jur_anticipo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_anticipo.
	* @return Cgg_jur_anticipo OBJETO Cgg_jur_anticipo.
	*/
	public com.besixplus.sii.objects.Cgg_jur_anticipo getCgg_jur_anticipo(){
		return this.myCgg_jur_anticipo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_jur_anticipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_anticipo().getCJAAC_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_anticipo().getCJACU_CODIGO());
			stmInsert.setBigDecimal(4, this.getCgg_jur_anticipo().getCJAAC_PORCENTAJE());
			stmInsert.setString(5, this.getCgg_jur_anticipo().getCJAAC_OBSERVACION());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_jur_anticipo().getCJAAC_FECHA().getTime()));
			stmInsert.setBigDecimal(7, this.getCgg_jur_anticipo().getCJAAC_MONTO());
			stmInsert.setString(8, this.getCgg_jur_anticipo().getCJAAC_VALOR_1());
			stmInsert.setBoolean(9, this.getCgg_jur_anticipo().getCJAAC_ESTADO());
			stmInsert.setString(10, this.getCgg_jur_anticipo().getCJAAC_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_jur_anticipo().setCJAAC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_anticipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> outCgg_jur_anticipo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_anticipo tmpCgg_jur_anticipo = new com.besixplus.sii.objects.Cgg_jur_anticipo();
				tmpCgg_jur_anticipo.setCJAAC_CODIGO(results.getString(1));
				tmpCgg_jur_anticipo.setCJACU_CODIGO(results.getString(2));
				tmpCgg_jur_anticipo.setCJAAC_PORCENTAJE(results.getBigDecimal(3));
				tmpCgg_jur_anticipo.setCJAAC_OBSERVACION(results.getString(4));
				tmpCgg_jur_anticipo.setCJAAC_FECHA(results.getTimestamp(5));
				tmpCgg_jur_anticipo.setCJAAC_MONTO(results.getBigDecimal(6));
				tmpCgg_jur_anticipo.setCJAAC_VALOR_1(results.getString(7));
				tmpCgg_jur_anticipo.setCJAAC_ESTADO(results.getBoolean(8));
				outCgg_jur_anticipo.add(tmpCgg_jur_anticipo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_anticipo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_anticipo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String, Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_anticipo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_anticipo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_anticipo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_anticipo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_anticipo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_anticipo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_anticipo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_anticipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_anticipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_ANTICIPO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_anticipo().getCJAAC_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_anticipo().getCJACU_CODIGO());
			stmUpdate.setBigDecimal(3, this.getCgg_jur_anticipo().getCJAAC_PORCENTAJE());
			stmUpdate.setString(4, this.getCgg_jur_anticipo().getCJAAC_OBSERVACION());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_jur_anticipo().getCJAAC_FECHA().getTime()));
			stmUpdate.setBigDecimal(6, this.getCgg_jur_anticipo().getCJAAC_MONTO());
			stmUpdate.setString(7, this.getCgg_jur_anticipo().getCJAAC_VALOR_1());
			stmUpdate.setBoolean(8, this.getCgg_jur_anticipo().getCJAAC_ESTADO());
			stmUpdate.setString(9, this.getCgg_jur_anticipo().getCJAAC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_anticipo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_anticipo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_jur_anticipo select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_anticipo().getCJAAC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_anticipo().setCJAAC_CODIGO(results.getString(1));
				this.getCgg_jur_anticipo().setCJACU_CODIGO(results.getString(2));
				this.getCgg_jur_anticipo().setCJAAC_PORCENTAJE(results.getBigDecimal(3));
				this.getCgg_jur_anticipo().setCJAAC_OBSERVACION(results.getString(4));
				this.getCgg_jur_anticipo().setCJAAC_FECHA(results.getTimestamp(5));
				this.getCgg_jur_anticipo().setCJAAC_MONTO(results.getBigDecimal(6));
				this.getCgg_jur_anticipo().setCJAAC_VALOR_1(results.getString(7));
				this.getCgg_jur_anticipo().setCJAAC_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_anticipo();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_anticipo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ANTICIPO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_anticipo().getCJAAC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ANTICIPO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_anticipo().getCJAAC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_anticipo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_anticipo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> selectCGG_JUR_ACUERDO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo> outCgg_jur_anticipo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_anticipo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ANTICIPO_S_CGG_JUR_ACUERDO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_anticipo().getCJACU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_anticipo tmpCgg_jur_anticipo = new com.besixplus.sii.objects.Cgg_jur_anticipo();
				tmpCgg_jur_anticipo.setCJAAC_CODIGO(results.getString(1));
				tmpCgg_jur_anticipo.setCJACU_CODIGO(results.getString(2));
				tmpCgg_jur_anticipo.setCJAAC_PORCENTAJE(results.getBigDecimal(3));
				tmpCgg_jur_anticipo.setCJAAC_OBSERVACION(results.getString(4));
				tmpCgg_jur_anticipo.setCJAAC_FECHA(results.getTimestamp(5));
				tmpCgg_jur_anticipo.setCJAAC_MONTO(results.getBigDecimal(6));
				tmpCgg_jur_anticipo.setCJAAC_VALOR_1(results.getString(7));
				tmpCgg_jur_anticipo.setCJAAC_ESTADO(results.getBoolean(8));
				outCgg_jur_anticipo.add(tmpCgg_jur_anticipo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_anticipo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_anticipo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_acuerdo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_JUR_ACUERDO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ANTICIPO_D_CGG_JUR_ACUERDO(?) }");
			stmDelete.setString(1, this.getCgg_jur_anticipo().getCJACU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ANTICIPO_DS_CGG_JUR_ACUERDO(?) }");
				stmDelete.setString(1, this.getCgg_jur_anticipo().getCJACU_CODIGO());
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