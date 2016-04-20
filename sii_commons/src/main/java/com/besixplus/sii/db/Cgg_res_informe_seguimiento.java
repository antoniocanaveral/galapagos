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
* CLASE Cgg_res_informe_seguimiento
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_informe_seguimiento.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_informe_seguimiento implements Serializable{
	private static final long serialVersionUID = 1909612795;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_informe_seguimiento.
	*/
	private com.besixplus.sii.objects.Cgg_res_informe_seguimiento myCgg_res_informe_seguimiento = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_seguimiento.
	*/
	public Cgg_res_informe_seguimiento(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_seguimiento.
	* @param inCgg_res_informe_seguimiento OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_informe_seguimiento.
	*/
	public Cgg_res_informe_seguimiento(
		com.besixplus.sii.objects.Cgg_res_informe_seguimiento inCgg_res_informe_seguimiento
	){
		this.setCgg_res_informe_seguimiento(inCgg_res_informe_seguimiento);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_informe_seguimiento.
	* @param inCgg_res_informe_seguimiento OBJETO Cgg_res_informe_seguimiento.
	* @return void
	*/
	public void setCgg_res_informe_seguimiento(com.besixplus.sii.objects.Cgg_res_informe_seguimiento inCgg_res_informe_seguimiento){
		this.myCgg_res_informe_seguimiento = inCgg_res_informe_seguimiento;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_informe_seguimiento.
	* @return Cgg_res_informe_seguimiento OBJETO Cgg_res_informe_seguimiento.
	*/
	public com.besixplus.sii.objects.Cgg_res_informe_seguimiento getCgg_res_informe_seguimiento(){
		return this.myCgg_res_informe_seguimiento;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_informe_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_informe_seguimiento().getCRISE_CODIGO());
			stmInsert.setString(3, this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
			stmInsert.setString(4, this.getCgg_res_informe_seguimiento().getCRSEC_CODIGO());
			stmInsert.setString(5, this.getCgg_res_informe_seguimiento().getCRISE_NUMERO_INFORME());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_res_informe_seguimiento().getCRISE_FECHA_INFORME().getTime()));
			stmInsert.setString(7, this.getCgg_res_informe_seguimiento().getCRISE_ASUNTO_INFORME());
			stmInsert.setString(8, this.getCgg_res_informe_seguimiento().getCRISE_EXTRACTO_INFORME());
			stmInsert.setString(9, this.getCgg_res_informe_seguimiento().getCRISE_DESCRIPCION_ADJUNTO());
			stmInsert.setBoolean(10, this.getCgg_res_informe_seguimiento().getCRISE_ESTADO());
			stmInsert.setString(11, this.getCgg_res_informe_seguimiento().getCRISE_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_res_informe_seguimiento().getCRISE_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_informe_seguimiento().setCRISE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> outCgg_res_informe_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpCgg_res_informe_seguimiento = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
				tmpCgg_res_informe_seguimiento.setCRISE_CODIGO(results.getString(1));
				tmpCgg_res_informe_seguimiento.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_informe_seguimiento.setCRSEC_CODIGO(results.getString(3));
				tmpCgg_res_informe_seguimiento.setCRISE_NUMERO_INFORME(results.getString(4));
				tmpCgg_res_informe_seguimiento.setCRISE_FECHA_INFORME(results.getTimestamp(5));
				tmpCgg_res_informe_seguimiento.setCRISE_ASUNTO_INFORME(results.getString(6));
				tmpCgg_res_informe_seguimiento.setCRISE_EXTRACTO_INFORME(results.getString(7));
				tmpCgg_res_informe_seguimiento.setCRISE_DESCRIPCION_ADJUNTO(results.getString(8));
				tmpCgg_res_informe_seguimiento.setCRISE_ESTADO(results.getBoolean(9));
				outCgg_res_informe_seguimiento.add(tmpCgg_res_informe_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_seguimiento;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> outCgg_res_informe_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpCgg_res_informe_seguimiento = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
				tmpCgg_res_informe_seguimiento.setCRISE_CODIGO(results.getString(1));
				tmpCgg_res_informe_seguimiento.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_informe_seguimiento.setCRSEC_CODIGO(results.getString(3));
				tmpCgg_res_informe_seguimiento.setCRISE_NUMERO_INFORME(results.getString(4));
				tmpCgg_res_informe_seguimiento.setCRISE_FECHA_INFORME(results.getTimestamp(5));
				tmpCgg_res_informe_seguimiento.setCRISE_ASUNTO_INFORME(results.getString(6));
				tmpCgg_res_informe_seguimiento.setCRISE_EXTRACTO_INFORME(results.getString(7));
				tmpCgg_res_informe_seguimiento.setCRISE_DESCRIPCION_ADJUNTO(results.getString(8));
				tmpCgg_res_informe_seguimiento.setCRISE_ESTADO(results.getBoolean(9));
				outCgg_res_informe_seguimiento.add(tmpCgg_res_informe_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_seguimiento;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_informe_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_informe_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_seguimiento;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_informe_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_informe_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_informe_seguimiento().getCRISE_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_informe_seguimiento().getCRSEC_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_informe_seguimiento().getCRISE_NUMERO_INFORME());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_res_informe_seguimiento().getCRISE_FECHA_INFORME().getTime()));
			stmUpdate.setString(6, this.getCgg_res_informe_seguimiento().getCRISE_ASUNTO_INFORME());
			stmUpdate.setString(7, this.getCgg_res_informe_seguimiento().getCRISE_EXTRACTO_INFORME());
			stmUpdate.setString(8, this.getCgg_res_informe_seguimiento().getCRISE_DESCRIPCION_ADJUNTO());
			stmUpdate.setBoolean(9, this.getCgg_res_informe_seguimiento().getCRISE_ESTADO());
			stmUpdate.setString(10, this.getCgg_res_informe_seguimiento().getCRISE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_informe_seguimiento select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_seguimiento().getCRISE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_informe_seguimiento().setCRISE_CODIGO(results.getString(1));
				this.getCgg_res_informe_seguimiento().setCRSEG_CODIGO(results.getString(2));
				this.getCgg_res_informe_seguimiento().setCRSEC_CODIGO(results.getString(3));
				this.getCgg_res_informe_seguimiento().setCRISE_NUMERO_INFORME(results.getString(4));
				this.getCgg_res_informe_seguimiento().setCRISE_FECHA_INFORME(results.getTimestamp(5));
				this.getCgg_res_informe_seguimiento().setCRISE_ASUNTO_INFORME(results.getString(6));
				this.getCgg_res_informe_seguimiento().setCRISE_EXTRACTO_INFORME(results.getString(7));
				this.getCgg_res_informe_seguimiento().setCRISE_DESCRIPCION_ADJUNTO(results.getString(8));
				this.getCgg_res_informe_seguimiento().setCRISE_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_informe_seguimiento();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRISE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRISE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seccion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> selectCGG_RES_SECCION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> outCgg_res_informe_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_S_CGG_RES_SECCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_seguimiento().getCRSEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpCgg_res_informe_seguimiento = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
				tmpCgg_res_informe_seguimiento.setCRISE_CODIGO(results.getString(1));
				tmpCgg_res_informe_seguimiento.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_informe_seguimiento.setCRSEC_CODIGO(results.getString(3));
				tmpCgg_res_informe_seguimiento.setCRISE_NUMERO_INFORME(results.getString(4));
				tmpCgg_res_informe_seguimiento.setCRISE_FECHA_INFORME(results.getTimestamp(5));
				tmpCgg_res_informe_seguimiento.setCRISE_ASUNTO_INFORME(results.getString(6));
				tmpCgg_res_informe_seguimiento.setCRISE_EXTRACTO_INFORME(results.getString(7));
				tmpCgg_res_informe_seguimiento.setCRISE_DESCRIPCION_ADJUNTO(results.getString(8));
				tmpCgg_res_informe_seguimiento.setCRISE_ESTADO(results.getBoolean(9));
				outCgg_res_informe_seguimiento.add(tmpCgg_res_informe_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_seguimiento;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seccion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SECCION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_D_CGG_RES_SECCION(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRSEC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_DS_CGG_RES_SECCION(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRSEC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> selectCGG_RES_SEGUIMIENTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> outCgg_res_informe_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpCgg_res_informe_seguimiento = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
				tmpCgg_res_informe_seguimiento.setCRISE_CODIGO(results.getString(1));
				tmpCgg_res_informe_seguimiento.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_informe_seguimiento.setCRSEC_CODIGO(results.getString(3));
				tmpCgg_res_informe_seguimiento.setCRISE_NUMERO_INFORME(results.getString(4));
				tmpCgg_res_informe_seguimiento.setCRISE_FECHA_INFORME(results.getTimestamp(5));
				tmpCgg_res_informe_seguimiento.setCRISE_ASUNTO_INFORME(results.getString(6));
				tmpCgg_res_informe_seguimiento.setCRISE_EXTRACTO_INFORME(results.getString(7));
				tmpCgg_res_informe_seguimiento.setCRISE_DESCRIPCION_ADJUNTO(results.getString(8));
				tmpCgg_res_informe_seguimiento.setCRISE_ESTADO(results.getBoolean(9));
				outCgg_res_informe_seguimiento.add(tmpCgg_res_informe_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_seguimiento;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SEGUIMIENTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_DS_CGG_RES_SEGUIMIENTO(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
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
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_SEGUIMIENTO1(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		
		try{			
			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_SEGUIMIENTO_D_CGG_RES_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}
	
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_seguimiento de manera recursiva a travez de los seguimientos padres.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_seguimiento OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> selectCGG_RES_SEGUIMIENTO1(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> outCgg_res_informe_seguimiento = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_SEGUIMIENTO_S_CGG_RES_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpCgg_res_informe_seguimiento = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
				tmpCgg_res_informe_seguimiento.setCRISE_CODIGO(results.getString(1));
				tmpCgg_res_informe_seguimiento.setCRSEG_CODIGO(results.getString(2));
				tmpCgg_res_informe_seguimiento.setCRSEC_CODIGO(results.getString(3));
				tmpCgg_res_informe_seguimiento.setCRISE_NUMERO_INFORME(results.getString(4));
				tmpCgg_res_informe_seguimiento.setCRISE_FECHA_INFORME(results.getTimestamp(5));
				tmpCgg_res_informe_seguimiento.setCRISE_ASUNTO_INFORME(results.getString(6));
				tmpCgg_res_informe_seguimiento.setCRISE_EXTRACTO_INFORME(results.getString(7));
				tmpCgg_res_informe_seguimiento.setCRISE_DESCRIPCION_ADJUNTO(results.getString(8));
				tmpCgg_res_informe_seguimiento.setCRISE_ESTADO(results.getBoolean(9));
				outCgg_res_informe_seguimiento.add(tmpCgg_res_informe_seguimiento);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_seguimiento;
	}
		
	/**
	 * Selecciona todos los informes de un tramite hasta el seguimiento especificado.
	 * @param inConnection Conexion de datos.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @return Coleccion de adjuntos.
	 */
	public ArrayList<HashMap<String,Object>> selectInformeTramite(
			java.sql.Connection inConnection,
			String inCrtra_codigo
		){
			ArrayList<HashMap<String,Object>> outCgg_res_informe_seguimiento = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TRAMITE(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inCrtra_codigo);
				stmSelect.setString(3, this.getCgg_res_informe_seguimiento().getCRSEG_CODIGO());				
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)						
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_informe_seguimiento.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_informe_seguimiento;
		}

}