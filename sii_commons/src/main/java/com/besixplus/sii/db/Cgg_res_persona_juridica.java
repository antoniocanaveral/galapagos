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
* CLASE Cgg_res_persona_juridica
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_persona_juridica.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_persona_juridica implements Serializable{
	private static final long serialVersionUID = 1165102883;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_persona_juridica.
	*/
	private com.besixplus.sii.objects.Cgg_res_persona_juridica myCgg_res_persona_juridica = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona_juridica.
	*/
	public Cgg_res_persona_juridica(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona_juridica.
	* @param inCgg_res_persona_juridica OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_persona_juridica.
	*/
	public Cgg_res_persona_juridica(
		com.besixplus.sii.objects.Cgg_res_persona_juridica inCgg_res_persona_juridica
	){
		this.setCgg_res_persona_juridica(inCgg_res_persona_juridica);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_persona_juridica.
	* @param inCgg_res_persona_juridica OBJETO Cgg_res_persona_juridica.
	* @return void
	*/
	public void setCgg_res_persona_juridica(com.besixplus.sii.objects.Cgg_res_persona_juridica inCgg_res_persona_juridica){
		this.myCgg_res_persona_juridica = inCgg_res_persona_juridica;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_persona_juridica.
	* @return Cgg_res_persona_juridica OBJETO Cgg_res_persona_juridica.
	*/
	public com.besixplus.sii.objects.Cgg_res_persona_juridica getCgg_res_persona_juridica(){
		return this.myCgg_res_persona_juridica;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_persona_juridica().getCRPJR_CODIGO());
			stmInsert.setString(3, this.getCgg_res_persona_juridica().getCSCTP_CODIGO());
			stmInsert.setString(4, this.getCgg_res_persona_juridica().getCVSCT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_persona_juridica().getCCTN_CODIGO());
			stmInsert.setString(6, this.getCgg_res_persona_juridica().getCRPJR_RAZON_SOCIAL());
			stmInsert.setString(7, this.getCgg_res_persona_juridica().getCRPJR_NUMERO_IDENTIFICACION());
			stmInsert.setTimestamp(8, new java.sql.Timestamp(this.getCgg_res_persona_juridica().getCRPJR_FECHA_CONSTITUCION().getTime()));
			stmInsert.setString(9, this.getCgg_res_persona_juridica().getCRPJR_DIRECCION());
			stmInsert.setString(10, this.getCgg_res_persona_juridica().getCRPJR_ACTIVIDAD());
			stmInsert.setBigDecimal(11, this.getCgg_res_persona_juridica().getCRPJR_NUMERO_EMPLEADOS());
			stmInsert.setInt(12, this.getCgg_res_persona_juridica().getCRPJR_TIPO());
			stmInsert.setString(13, this.getCgg_res_persona_juridica().getCRPJR_OBSERVACION());
			stmInsert.setBoolean(14, this.getCgg_res_persona_juridica().getCRPJR_ESTADO());
			stmInsert.setString(15, this.getCgg_res_persona_juridica().getCRPJR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_persona_juridica().setCRPJR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> outCgg_res_persona_juridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona_juridica tmpCgg_res_persona_juridica = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
				tmpCgg_res_persona_juridica.setCRPJR_CODIGO(results.getString(1));
				tmpCgg_res_persona_juridica.setCSCTP_CODIGO(results.getString(2));
				tmpCgg_res_persona_juridica.setCVSCT_CODIGO(results.getString(3));
				tmpCgg_res_persona_juridica.setCCTN_CODIGO(results.getString(4));
				tmpCgg_res_persona_juridica.setCRPJR_RAZON_SOCIAL(results.getString(5));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_IDENTIFICACION(results.getString(6));
				tmpCgg_res_persona_juridica.setCRPJR_FECHA_CONSTITUCION(results.getTimestamp(7));
				tmpCgg_res_persona_juridica.setCRPJR_DIRECCION(results.getString(8));
				tmpCgg_res_persona_juridica.setCRPJR_ACTIVIDAD(results.getString(9));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_EMPLEADOS(results.getBigDecimal(10));
				tmpCgg_res_persona_juridica.setCRPJR_TIPO(results.getInt(11));
				tmpCgg_res_persona_juridica.setCRPJR_OBSERVACION(results.getString(12));
				tmpCgg_res_persona_juridica.setCRPJR_ESTADO(results.getBoolean(13));
				outCgg_res_persona_juridica.add(tmpCgg_res_persona_juridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_persona_juridica = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_persona_juridica.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_persona_juridica().getCRPJR_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_persona_juridica().getCSCTP_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_persona_juridica().getCVSCT_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_persona_juridica().getCCTN_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_persona_juridica().getCRPJR_RAZON_SOCIAL());
			stmUpdate.setString(6, this.getCgg_res_persona_juridica().getCRPJR_NUMERO_IDENTIFICACION());
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_res_persona_juridica().getCRPJR_FECHA_CONSTITUCION().getTime()));
			stmUpdate.setString(8, this.getCgg_res_persona_juridica().getCRPJR_DIRECCION());
			stmUpdate.setString(9, this.getCgg_res_persona_juridica().getCRPJR_ACTIVIDAD());
			stmUpdate.setBigDecimal(10, this.getCgg_res_persona_juridica().getCRPJR_NUMERO_EMPLEADOS());
			stmUpdate.setInt(11, this.getCgg_res_persona_juridica().getCRPJR_TIPO());
			stmUpdate.setString(12, this.getCgg_res_persona_juridica().getCRPJR_OBSERVACION());
			stmUpdate.setBoolean(13, this.getCgg_res_persona_juridica().getCRPJR_ESTADO());
			stmUpdate.setString(14, this.getCgg_res_persona_juridica().getCRPJR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona_juridica DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_persona_juridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_persona_juridica select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona_juridica().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_persona_juridica().setCRPJR_CODIGO(results.getString(1));
				this.getCgg_res_persona_juridica().setCSCTP_CODIGO(results.getString(2));
				this.getCgg_res_persona_juridica().setCVSCT_CODIGO(results.getString(3));
				this.getCgg_res_persona_juridica().setCCTN_CODIGO(results.getString(4));
				this.getCgg_res_persona_juridica().setCRPJR_RAZON_SOCIAL(results.getString(5));
				this.getCgg_res_persona_juridica().setCRPJR_NUMERO_IDENTIFICACION(results.getString(6));
				this.getCgg_res_persona_juridica().setCRPJR_FECHA_CONSTITUCION(results.getTimestamp(7));
				this.getCgg_res_persona_juridica().setCRPJR_DIRECCION(results.getString(8));
				this.getCgg_res_persona_juridica().setCRPJR_ACTIVIDAD(results.getString(9));
				this.getCgg_res_persona_juridica().setCRPJR_NUMERO_EMPLEADOS(results.getBigDecimal(10));
				this.getCgg_res_persona_juridica().setCRPJR_TIPO(results.getInt(11));
				this.getCgg_res_persona_juridica().setCRPJR_OBSERVACION(results.getString(12));
				this.getCgg_res_persona_juridica().setCRPJR_ESTADO(results.getBoolean(13));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_persona_juridica();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_persona_juridica DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_persona_juridica().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_persona_juridica().getCRPJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_persona_juridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> selectCGG_CANTON(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> outCgg_res_persona_juridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona_juridica().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona_juridica tmpCgg_res_persona_juridica = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
				tmpCgg_res_persona_juridica.setCRPJR_CODIGO(results.getString(1));
				tmpCgg_res_persona_juridica.setCSCTP_CODIGO(results.getString(2));
				tmpCgg_res_persona_juridica.setCVSCT_CODIGO(results.getString(3));
				tmpCgg_res_persona_juridica.setCCTN_CODIGO(results.getString(4));
				tmpCgg_res_persona_juridica.setCRPJR_RAZON_SOCIAL(results.getString(5));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_IDENTIFICACION(results.getString(6));
				tmpCgg_res_persona_juridica.setCRPJR_FECHA_CONSTITUCION(results.getTimestamp(7));
				tmpCgg_res_persona_juridica.setCRPJR_DIRECCION(results.getString(8));
				tmpCgg_res_persona_juridica.setCRPJR_ACTIVIDAD(results.getString(9));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_EMPLEADOS(results.getBigDecimal(10));
				tmpCgg_res_persona_juridica.setCRPJR_TIPO(results.getInt(11));
				tmpCgg_res_persona_juridica.setCRPJR_OBSERVACION(results.getString(12));
				tmpCgg_res_persona_juridica.setCRPJR_ESTADO(results.getBoolean(13));
				outCgg_res_persona_juridica.add(tmpCgg_res_persona_juridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_CANTON(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_res_persona_juridica().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_res_persona_juridica().getCCTN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_persona_juridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> selectCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> outCgg_res_persona_juridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_S_CGG_SECTOR_PRODUCTIVO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona_juridica().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona_juridica tmpCgg_res_persona_juridica = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
				tmpCgg_res_persona_juridica.setCRPJR_CODIGO(results.getString(1));
				tmpCgg_res_persona_juridica.setCSCTP_CODIGO(results.getString(2));
				tmpCgg_res_persona_juridica.setCVSCT_CODIGO(results.getString(3));
				tmpCgg_res_persona_juridica.setCCTN_CODIGO(results.getString(4));
				tmpCgg_res_persona_juridica.setCRPJR_RAZON_SOCIAL(results.getString(5));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_IDENTIFICACION(results.getString(6));
				tmpCgg_res_persona_juridica.setCRPJR_FECHA_CONSTITUCION(results.getTimestamp(7));
				tmpCgg_res_persona_juridica.setCRPJR_DIRECCION(results.getString(8));
				tmpCgg_res_persona_juridica.setCRPJR_ACTIVIDAD(results.getString(9));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_EMPLEADOS(results.getBigDecimal(10));
				tmpCgg_res_persona_juridica.setCRPJR_TIPO(results.getInt(11));
				tmpCgg_res_persona_juridica.setCRPJR_OBSERVACION(results.getString(12));
				tmpCgg_res_persona_juridica.setCRPJR_ESTADO(results.getBoolean(13));
				outCgg_res_persona_juridica.add(tmpCgg_res_persona_juridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_D_CGG_SECTOR_PRODUCTIVO(?) }");
			stmDelete.setString(1, this.getCgg_res_persona_juridica().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_DS_CGG_SECTOR_PRODUCTIVO(?) }");
				stmDelete.setString(1, this.getCgg_res_persona_juridica().getCSCTP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_sector.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_persona_juridica OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> selectCGG_VEH_SECTOR(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> outCgg_res_persona_juridica = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_S_CGG_VEH_SECTOR(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona_juridica().getCVSCT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona_juridica tmpCgg_res_persona_juridica = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
				tmpCgg_res_persona_juridica.setCRPJR_CODIGO(results.getString(1));
				tmpCgg_res_persona_juridica.setCSCTP_CODIGO(results.getString(2));
				tmpCgg_res_persona_juridica.setCVSCT_CODIGO(results.getString(3));
				tmpCgg_res_persona_juridica.setCCTN_CODIGO(results.getString(4));
				tmpCgg_res_persona_juridica.setCRPJR_RAZON_SOCIAL(results.getString(5));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_IDENTIFICACION(results.getString(6));
				tmpCgg_res_persona_juridica.setCRPJR_FECHA_CONSTITUCION(results.getTimestamp(7));
				tmpCgg_res_persona_juridica.setCRPJR_DIRECCION(results.getString(8));
				tmpCgg_res_persona_juridica.setCRPJR_ACTIVIDAD(results.getString(9));
				tmpCgg_res_persona_juridica.setCRPJR_NUMERO_EMPLEADOS(results.getBigDecimal(10));
				tmpCgg_res_persona_juridica.setCRPJR_TIPO(results.getInt(11));
				tmpCgg_res_persona_juridica.setCRPJR_OBSERVACION(results.getString(12));
				tmpCgg_res_persona_juridica.setCRPJR_ESTADO(results.getBoolean(13));
				outCgg_res_persona_juridica.add(tmpCgg_res_persona_juridica);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_sector.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_SECTOR(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_D_CGG_VEH_SECTOR(?) }");
			stmDelete.setString(1, this.getCgg_res_persona_juridica().getCVSCT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_JURIDICA_DS_CGG_VEH_SECTOR(?) }");
				stmDelete.setString(1, this.getCgg_res_persona_juridica().getCVSCT_CODIGO());
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
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int selectCountByRol(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_JURIDICA_COUNT_BY_ROL(?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPageByRol(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona_juridica = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_PERSONAJ_BYROL(?,?,?,?,?,?) }");
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
				outCgg_res_persona_juridica.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrpjr_numero_identificacion NUMERO DE DOCUMENTO DE IDENTIFICACION DE UNA PERSONA JURIDICA.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCodigoByNumIdentific(
			java.sql.Connection inConnection,			
			String inCrpjr_numero_identificacion
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona_juridica = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_PERSONAJ_CODIGO_BYNUM_IDEN(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrpjr_numero_identificacion);						
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona_juridica.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona_juridica;
	}
}