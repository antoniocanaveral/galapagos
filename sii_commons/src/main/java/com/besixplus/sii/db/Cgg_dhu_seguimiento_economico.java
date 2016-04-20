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
* CLASE Cgg_dhu_seguimiento_economico
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_seguimiento_economico.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_seguimiento_economico implements Serializable{
	private static final long serialVersionUID = 1361868713;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico myCgg_dhu_seguimiento_economico = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_economico.
	*/
	public Cgg_dhu_seguimiento_economico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_economico.
	* @param inCgg_dhu_seguimiento_economico OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_seguimiento_economico.
	*/
	public Cgg_dhu_seguimiento_economico(
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico inCgg_dhu_seguimiento_economico
	){
		this.setCgg_dhu_seguimiento_economico(inCgg_dhu_seguimiento_economico);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_seguimiento_economico.
	* @param inCgg_dhu_seguimiento_economico OBJETO Cgg_dhu_seguimiento_economico.
	* @return void
	*/
	public void setCgg_dhu_seguimiento_economico(com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico inCgg_dhu_seguimiento_economico){
		this.myCgg_dhu_seguimiento_economico = inCgg_dhu_seguimiento_economico;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_seguimiento_economico.
	* @return Cgg_dhu_seguimiento_economico OBJETO Cgg_dhu_seguimiento_economico.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico getCgg_dhu_seguimiento_economico(){
		return this.myCgg_dhu_seguimiento_economico;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_economico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO_TRANSFERENCIA());
			stmInsert.setBigDecimal(6, this.getCgg_dhu_seguimiento_economico().getCDSEC_VALOR());
			//stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSFERENCIA().getTime()));
			stmInsert.setTimestamp(7, this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSFERENCIA()==null?null:new java.sql.Timestamp(this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSFERENCIA().getTime()));
			stmInsert.setString(8, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO_TRANSF_IECE());
			stmInsert.setBigDecimal(9, this.getCgg_dhu_seguimiento_economico().getCDSEC_VALOR_IECE());
			stmInsert.setTimestamp(10, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSF_IECE().getTime()));
			stmInsert.setBoolean(11, this.getCgg_dhu_seguimiento_economico().getCDSEC_CIERRE_DESEMBOLSO());
			stmInsert.setString(12, this.getCgg_dhu_seguimiento_economico().getCDSEC_OBSERVACION());
			stmInsert.setBoolean(13, this.getCgg_dhu_seguimiento_economico().getCDSEC_ESTADO());
			stmInsert.setString(14, this.getCgg_dhu_seguimiento_economico().getCDSEC_USUARIO_INSERT());
			stmInsert.setString(15, this.getCgg_dhu_seguimiento_economico().getCDSEC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_seguimiento_economico().setCDSEC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> outCgg_dhu_seguimiento_economico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico tmpCgg_dhu_seguimiento_economico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico();
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_economico.setCDTCP_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_economico.setCDACD_CODIGO(results.getString(3));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSFERENCIA(results.getString(4));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR(results.getBigDecimal(5));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSFERENCIA(results.getTimestamp(6));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSF_IECE(results.getString(7));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR_IECE(results.getBigDecimal(8));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSF_IECE(results.getTimestamp(9));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CIERRE_DESEMBOLSO(results.getBoolean(10));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_OBSERVACION(results.getString(11));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_ESTADO(results.getBoolean(12));
				outCgg_dhu_seguimiento_economico.add(tmpCgg_dhu_seguimiento_economico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_economico;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> outCgg_dhu_seguimiento_economico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico tmpCgg_dhu_seguimiento_economico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico();
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_economico.setCDTCP_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_economico.setCDACD_CODIGO(results.getString(3));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSFERENCIA(results.getString(4));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR(results.getBigDecimal(5));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSFERENCIA(results.getTimestamp(6));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSF_IECE(results.getString(7));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR_IECE(results.getBigDecimal(8));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSF_IECE(results.getTimestamp(9));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CIERRE_DESEMBOLSO(results.getBoolean(10));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_OBSERVACION(results.getString(11));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_ESTADO(results.getBoolean(12));
				outCgg_dhu_seguimiento_economico.add(tmpCgg_dhu_seguimiento_economico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_economico;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_seguimiento_economico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_COUNT() }");
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
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_economico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?) }");
			stmUpdate.setString(1, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO_TRANSFERENCIA());
			stmUpdate.setBigDecimal(5, this.getCgg_dhu_seguimiento_economico().getCDSEC_VALOR());
			stmUpdate.setTimestamp(6, this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSFERENCIA()==null?null:new java.sql.Timestamp(this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSFERENCIA().getTime()));	
			
			stmUpdate.setString(7, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO_TRANSF_IECE());
			stmUpdate.setBigDecimal(8, this.getCgg_dhu_seguimiento_economico().getCDSEC_VALOR_IECE());
			stmUpdate.setTimestamp(9, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_economico().getCDSEC_FECHA_TRANSF_IECE().getTime()));
			stmUpdate.setBoolean(10, this.getCgg_dhu_seguimiento_economico().getCDSEC_CIERRE_DESEMBOLSO());
			stmUpdate.setString(11, this.getCgg_dhu_seguimiento_economico().getCDSEC_OBSERVACION());
			stmUpdate.setBoolean(12, this.getCgg_dhu_seguimiento_economico().getCDSEC_ESTADO());
			stmUpdate.setString(13, this.getCgg_dhu_seguimiento_economico().getCDSEC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_economico DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_seguimiento_economico().setCDSEC_CODIGO(results.getString(1));
				this.getCgg_dhu_seguimiento_economico().setCDTCP_CODIGO(results.getString(2));
				this.getCgg_dhu_seguimiento_economico().setCDACD_CODIGO(results.getString(3));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_CODIGO_TRANSFERENCIA(results.getString(4));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_VALOR(results.getBigDecimal(5));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_FECHA_TRANSFERENCIA(results.getTimestamp(6));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_CODIGO_TRANSF_IECE(results.getString(7));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_VALOR_IECE(results.getBigDecimal(8));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_FECHA_TRANSF_IECE(results.getTimestamp(9));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_CIERRE_DESEMBOLSO(results.getBoolean(10));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_OBSERVACION(results.getString(11));
				this.getCgg_dhu_seguimiento_economico().setCDSEC_ESTADO(results.getBoolean(12));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_seguimiento_economico();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_economico DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_economico().getCDSEC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_concepto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> selectCGG_DHU_TIPO_CONCEPTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> outCgg_dhu_seguimiento_economico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_S_CGG_DHU_TIPO_CONCEPTO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico tmpCgg_dhu_seguimiento_economico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico();
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_economico.setCDTCP_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_economico.setCDACD_CODIGO(results.getString(3));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSFERENCIA(results.getString(4));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR(results.getBigDecimal(5));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSFERENCIA(results.getTimestamp(6));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSF_IECE(results.getString(7));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR_IECE(results.getBigDecimal(8));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSF_IECE(results.getTimestamp(9));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CIERRE_DESEMBOLSO(results.getBoolean(10));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_OBSERVACION(results.getString(11));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_ESTADO(results.getBoolean(12));
				outCgg_dhu_seguimiento_economico.add(tmpCgg_dhu_seguimiento_economico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_economico;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_concepto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_TIPO_CONCEPTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_D_CGG_DHU_TIPO_CONCEPTO(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_DS_CGG_DHU_TIPO_CONCEPTO(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> selectCGG_DHU_SEGUIMIENTO_ACADEMICO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico> outCgg_dhu_seguimiento_economico = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_S_CGG_DHU_SEGUIMIENTO_ACADEMICO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico tmpCgg_dhu_seguimiento_economico = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_economico();
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_economico.setCDTCP_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_economico.setCDACD_CODIGO(results.getString(3));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSFERENCIA(results.getString(4));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR(results.getBigDecimal(5));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSFERENCIA(results.getTimestamp(6));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CODIGO_TRANSF_IECE(results.getString(7));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_VALOR_IECE(results.getBigDecimal(8));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_FECHA_TRANSF_IECE(results.getTimestamp(9));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_CIERRE_DESEMBOLSO(results.getBoolean(10));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_OBSERVACION(results.getString(11));
				tmpCgg_dhu_seguimiento_economico.setCDSEC_ESTADO(results.getBoolean(12));
				outCgg_dhu_seguimiento_economico.add(tmpCgg_dhu_seguimiento_economico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_economico;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_SEGUIMIENTO_ACADEMICO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_D_CGG_DHU_SEGUIMIENTO_ACADEMICO(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_ECONOMICO_DS_CGG_DHU_SEGUIMIENTO_ACADEMICO(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_economico().getCDACD_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_seguimiento_economico().getCDTCP_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_economico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllSeguimientoEconomico(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_seguimiento_economico_select_page(?,?,?,?,?,?) }");
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
				outCgg_dhu_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectSeguiAcademico(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_seguimiento_academico_consulta(?,?,?,?,?,?) }");
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
				outCgg_dhu_seguimiento.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectSeguimientoCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_seguimiento_academico_consulta_count(?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param in_crper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectSeguiaca(
		java.sql.Connection inConnection,
		String in_crper_num_doc_identific
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento_academico = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_ACADEMICO_BECA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,in_crper_num_doc_identific);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_seguimiento_academico.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_academico;
	}	

	
}