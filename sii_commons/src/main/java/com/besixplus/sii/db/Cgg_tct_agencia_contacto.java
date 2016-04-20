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
* CLASE Cgg_tct_agencia_contacto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_agencia_contacto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_agencia_contacto implements Serializable{
	private static final long serialVersionUID = 531277476;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_agencia_contacto.
	*/
	private com.besixplus.sii.objects.Cgg_tct_agencia_contacto myCgg_tct_agencia_contacto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_agencia_contacto.
	*/
	public Cgg_tct_agencia_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_agencia_contacto.
	* @param inCgg_tct_agencia_contacto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_agencia_contacto.
	*/
	public Cgg_tct_agencia_contacto(
		com.besixplus.sii.objects.Cgg_tct_agencia_contacto inCgg_tct_agencia_contacto
	){
		this.setCgg_tct_agencia_contacto(inCgg_tct_agencia_contacto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_agencia_contacto.
	* @param inCgg_tct_agencia_contacto OBJETO Cgg_tct_agencia_contacto.
	* @return void
	*/
	public void setCgg_tct_agencia_contacto(com.besixplus.sii.objects.Cgg_tct_agencia_contacto inCgg_tct_agencia_contacto){
		this.myCgg_tct_agencia_contacto = inCgg_tct_agencia_contacto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_agencia_contacto.
	* @return Cgg_tct_agencia_contacto OBJETO Cgg_tct_agencia_contacto.
	*/
	public com.besixplus.sii.objects.Cgg_tct_agencia_contacto getCgg_tct_agencia_contacto(){
		return this.myCgg_tct_agencia_contacto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_agencia_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_agencia_contacto().getCTAGC_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
			stmInsert.setString(5, this.getCgg_tct_agencia_contacto().getCTAGC_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_tct_agencia_contacto().getCTAGC_CONTACTO());
			stmInsert.setBoolean(7, this.getCgg_tct_agencia_contacto().getCTAGC_ESTADO());
			stmInsert.setString(8, this.getCgg_tct_agencia_contacto().getCTAGC_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_tct_agencia_contacto().getCTAGC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_agencia_contacto().setCTAGC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> outCgg_tct_agencia_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_agencia_contacto tmpCgg_tct_agencia_contacto = new com.besixplus.sii.objects.Cgg_tct_agencia_contacto();
				tmpCgg_tct_agencia_contacto.setCTAGC_CODIGO(results.getString(1));
				tmpCgg_tct_agencia_contacto.setCTAGV_CODIGO(results.getString(2));
				tmpCgg_tct_agencia_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_tct_agencia_contacto.setCTAGC_DESCRIPCION(results.getString(4));
				tmpCgg_tct_agencia_contacto.setCTAGC_CONTACTO(results.getString(5));
				tmpCgg_tct_agencia_contacto.setCTAGC_ESTADO(results.getBoolean(6));
				outCgg_tct_agencia_contacto.add(tmpCgg_tct_agencia_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_agencia_contacto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> outCgg_tct_agencia_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_agencia_contacto tmpCgg_tct_agencia_contacto = new com.besixplus.sii.objects.Cgg_tct_agencia_contacto();
				tmpCgg_tct_agencia_contacto.setCTAGC_CODIGO(results.getString(1));
				tmpCgg_tct_agencia_contacto.setCTAGV_CODIGO(results.getString(2));
				tmpCgg_tct_agencia_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_tct_agencia_contacto.setCTAGC_DESCRIPCION(results.getString(4));
				tmpCgg_tct_agencia_contacto.setCTAGC_CONTACTO(results.getString(5));
				tmpCgg_tct_agencia_contacto.setCTAGC_ESTADO(results.getBoolean(6));
				outCgg_tct_agencia_contacto.add(tmpCgg_tct_agencia_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_agencia_contacto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_agencia_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_agencia_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_agencia_contacto().getCTAGC_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
			stmUpdate.setString(4, this.getCgg_tct_agencia_contacto().getCTAGC_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_tct_agencia_contacto().getCTAGC_CONTACTO());
			stmUpdate.setBoolean(6, this.getCgg_tct_agencia_contacto().getCTAGC_ESTADO());
			stmUpdate.setString(7, this.getCgg_tct_agencia_contacto().getCTAGC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_agencia_contacto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_agencia_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_agencia_contacto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_agencia_contacto().getCTAGC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_agencia_contacto().setCTAGC_CODIGO(results.getString(1));
				this.getCgg_tct_agencia_contacto().setCTAGV_CODIGO(results.getString(2));
				this.getCgg_tct_agencia_contacto().setCRTCO_CODIGO(results.getString(3));
				this.getCgg_tct_agencia_contacto().setCTAGC_DESCRIPCION(results.getString(4));
				this.getCgg_tct_agencia_contacto().setCTAGC_CONTACTO(results.getString(5));
				this.getCgg_tct_agencia_contacto().setCTAGC_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_agencia_contacto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_agencia_contacto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_agencia_contacto().getCTAGC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_agencia_contacto().getCTAGC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_agencia_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> selectCGG_RES_TIPO_CONTACTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> outCgg_tct_agencia_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_S_CGG_RES_TIPO_CONTACTO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_agencia_contacto tmpCgg_tct_agencia_contacto = new com.besixplus.sii.objects.Cgg_tct_agencia_contacto();
				tmpCgg_tct_agencia_contacto.setCTAGC_CODIGO(results.getString(1));
				tmpCgg_tct_agencia_contacto.setCTAGV_CODIGO(results.getString(2));
				tmpCgg_tct_agencia_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_tct_agencia_contacto.setCTAGC_DESCRIPCION(results.getString(4));
				tmpCgg_tct_agencia_contacto.setCTAGC_CONTACTO(results.getString(5));
				tmpCgg_tct_agencia_contacto.setCTAGC_ESTADO(results.getBoolean(6));
				outCgg_tct_agencia_contacto.add(tmpCgg_tct_agencia_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_agencia_contacto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_CONTACTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_D_CGG_RES_TIPO_CONTACTO(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_DS_CGG_RES_TIPO_CONTACTO(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_agencia_viaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_agencia_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> selectCGG_TCT_AGENCIA_VIAJE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> outCgg_tct_agencia_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_AGENCIA_CONTACTO_S_CGG_TCT_AGENCIA_VIAJE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_agencia_contacto tmpCgg_tct_agencia_contacto = new com.besixplus.sii.objects.Cgg_tct_agencia_contacto();
				tmpCgg_tct_agencia_contacto.setCTAGC_CODIGO(results.getString(1));
				tmpCgg_tct_agencia_contacto.setCTAGV_CODIGO(results.getString(2));
				tmpCgg_tct_agencia_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_tct_agencia_contacto.setCTAGC_DESCRIPCION(results.getString(4));
				tmpCgg_tct_agencia_contacto.setCTAGC_CONTACTO(results.getString(5));
				tmpCgg_tct_agencia_contacto.setCTAGC_ESTADO(results.getBoolean(6));
				outCgg_tct_agencia_contacto.add(tmpCgg_tct_agencia_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_agencia_contacto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_agencia_viaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_AGENCIA_VIAJE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_D_CGG_TCT_AGENCIA_VIAJE(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_AGENCIA_CONTACTO_DS_CGG_TCT_AGENCIA_VIAJE(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_agencia_contacto().getCRTCO_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_agencia_contacto().getCTAGV_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_agencia_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCtagv_codigo CODIGO DE LA AGENCIA DE VIAJES A CONSULTAR
	* * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_agencia_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAgenciaContacto(
		java.sql.Connection inConnection,
		String inCtagv_codigo 
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_agencia_contacto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_AGENCIA_VIAJE_CONTACTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCtagv_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_agencia_contacto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_agencia_contacto;
	}

}