package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

/**
* CLASE Cgg_dhu_sadjunto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_sadjunto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_sadjunto implements Serializable{
	private static final long serialVersionUID = 1617841725;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_sadjunto.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_sadjunto myCgg_dhu_sadjunto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_sadjunto.
	*/
	public Cgg_dhu_sadjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_sadjunto.
	* @param inCgg_dhu_sadjunto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_sadjunto.
	*/
	public Cgg_dhu_sadjunto(
		com.besixplus.sii.objects.Cgg_dhu_sadjunto inCgg_dhu_sadjunto
	){
		this.setCgg_dhu_sadjunto(inCgg_dhu_sadjunto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_sadjunto.
	* @param inCgg_dhu_sadjunto OBJETO Cgg_dhu_sadjunto.
	* @return void
	*/
	public void setCgg_dhu_sadjunto(com.besixplus.sii.objects.Cgg_dhu_sadjunto inCgg_dhu_sadjunto){
		this.myCgg_dhu_sadjunto = inCgg_dhu_sadjunto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_sadjunto.
	* @return Cgg_dhu_sadjunto OBJETO Cgg_dhu_sadjunto.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_sadjunto getCgg_dhu_sadjunto(){
		return this.myCgg_dhu_sadjunto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_sadjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_sadjunto().getCDSAD_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
			stmInsert.setTimestamp(5,this.getCgg_dhu_sadjunto().getCDSAD_FECHA_REGISTRO()==null?null:new java.sql.Timestamp(this.getCgg_dhu_sadjunto().getCDSAD_FECHA_REGISTRO().getTime()));
			stmInsert.setString(6, this.getCgg_dhu_sadjunto().getCDSAD_NOMBRE_ADJUNTO());
			stmInsert.setBytes(7, this.getCgg_dhu_sadjunto().getCDSAD_ADJUNTO());
			stmInsert.setString(8, this.getCgg_dhu_sadjunto().getCDSAD_OBSERVACION());
			stmInsert.setBoolean(9, this.getCgg_dhu_sadjunto().getCDSAD_ESTADO());
			stmInsert.setString(10, this.getCgg_dhu_sadjunto().getCDSAD_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_dhu_sadjunto().getCDSAD_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_sadjunto().setCDSAD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> outCgg_dhu_sadjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_sadjunto tmpCgg_dhu_sadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
				tmpCgg_dhu_sadjunto.setCDSAD_CODIGO(results.getString(1));
				tmpCgg_dhu_sadjunto.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_sadjunto.setCDBCR_CODIGO(results.getString(3));
				tmpCgg_dhu_sadjunto.setCDSAD_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_dhu_sadjunto.setCDSAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_sadjunto.setCDSAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_sadjunto.setCDSAD_OBSERVACION(results.getString(7));
				tmpCgg_dhu_sadjunto.setCDSAD_ESTADO(results.getBoolean(8));
				outCgg_dhu_sadjunto.add(tmpCgg_dhu_sadjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> outCgg_dhu_sadjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_sadjunto tmpCgg_dhu_sadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
				tmpCgg_dhu_sadjunto.setCDSAD_CODIGO(results.getString(1));
				tmpCgg_dhu_sadjunto.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_sadjunto.setCDBCR_CODIGO(results.getString(3));
				tmpCgg_dhu_sadjunto.setCDSAD_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_dhu_sadjunto.setCDSAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_sadjunto.setCDSAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_sadjunto.setCDSAD_OBSERVACION(results.getString(7));
				tmpCgg_dhu_sadjunto.setCDSAD_ESTADO(results.getBoolean(8));
				outCgg_dhu_sadjunto.add(tmpCgg_dhu_sadjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_sadjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_sadjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_sadjunto().getCDSAD_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_dhu_sadjunto().getCDSAD_FECHA_REGISTRO().getTime()));
			stmUpdate.setString(5, this.getCgg_dhu_sadjunto().getCDSAD_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(6, this.getCgg_dhu_sadjunto().getCDSAD_ADJUNTO());
			stmUpdate.setString(7, this.getCgg_dhu_sadjunto().getCDSAD_OBSERVACION());
			stmUpdate.setBoolean(8, this.getCgg_dhu_sadjunto().getCDSAD_ESTADO());
			stmUpdate.setString(9, this.getCgg_dhu_sadjunto().getCDSAD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_sadjunto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_sadjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_sadjunto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_sadjunto().getCDSAD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_sadjunto().setCDSAD_CODIGO(results.getString(1));
				this.getCgg_dhu_sadjunto().setCDACD_CODIGO(results.getString(2));
				this.getCgg_dhu_sadjunto().setCDBCR_CODIGO(results.getString(3));
				this.getCgg_dhu_sadjunto().setCDSAD_FECHA_REGISTRO(results.getTimestamp(4));
				this.getCgg_dhu_sadjunto().setCDSAD_NOMBRE_ADJUNTO(results.getString(5));
				this.getCgg_dhu_sadjunto().setCDSAD_ADJUNTO(results.getBytes(6));
				this.getCgg_dhu_sadjunto().setCDSAD_OBSERVACION(results.getString(7));
				this.getCgg_dhu_sadjunto().setCDSAD_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_sadjunto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_sadjunto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_sadjunto().getCDSAD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_sadjunto().getCDSAD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_sadjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> selectCGG_DHU_BECA_CERTIFICADO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> outCgg_dhu_sadjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_S_CGG_DHU_BECA_CERTIFICADO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_sadjunto tmpCgg_dhu_sadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
				tmpCgg_dhu_sadjunto.setCDSAD_CODIGO(results.getString(1));
				tmpCgg_dhu_sadjunto.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_sadjunto.setCDBCR_CODIGO(results.getString(3));
				tmpCgg_dhu_sadjunto.setCDSAD_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_dhu_sadjunto.setCDSAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_sadjunto.setCDSAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_sadjunto.setCDSAD_OBSERVACION(results.getString(7));
				tmpCgg_dhu_sadjunto.setCDSAD_ESTADO(results.getBoolean(8));
				outCgg_dhu_sadjunto.add(tmpCgg_dhu_sadjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_BECA_CERTIFICADO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_D_CGG_DHU_BECA_CERTIFICADO(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_DS_CGG_DHU_BECA_CERTIFICADO(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_seguimiento_academico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_sadjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> selectCGG_DHU_SEGUIMIENTO_ACADEMICO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> outCgg_dhu_sadjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SADJUNTO_S_CGG_DHU_SEGUIMIENTO_ACADEMICO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_sadjunto tmpCgg_dhu_sadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
				tmpCgg_dhu_sadjunto.setCDSAD_CODIGO(results.getString(1));
				tmpCgg_dhu_sadjunto.setCDACD_CODIGO(results.getString(2));
				tmpCgg_dhu_sadjunto.setCDBCR_CODIGO(results.getString(3));
				tmpCgg_dhu_sadjunto.setCDSAD_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_dhu_sadjunto.setCDSAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_sadjunto.setCDSAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_sadjunto.setCDSAD_OBSERVACION(results.getString(7));
				tmpCgg_dhu_sadjunto.setCDSAD_ESTADO(results.getBoolean(8));
				outCgg_dhu_sadjunto.add(tmpCgg_dhu_sadjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_seguimiento_academico.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_D_CGG_DHU_SEGUIMIENTO_ACADEMICO(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SADJUNTO_DS_CGG_DHU_SEGUIMIENTO_ACADEMICO(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_sadjunto().getCDBCR_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public  ArrayList<HashMap<String,Object>> selectAdjuntoBeca1(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_sadjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_sadjunto_beca(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_dhu_sadjunto().getCDACD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_sadjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_sadjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAdjuntoBeca(
			java.sql.Connection inConnection,
			String inCdacd_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_sadjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_sadjunto_beca(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdacd_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_sadjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_sadjunto;
	}	
	/**
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE SEGUN EL USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrateData CREA UNA COLECCION DE DATOS.
	 * @return PERSONA DE RESPONSABLE DEL PROCESO 
	 * @throws SQLException 
	 */
	public static String ingresoAdjunto(
			java.sql.Connection inConnection,
			String inCrateData
	) throws SQLException{
		String valorAdjunto=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_TEMPORAL_ADJUNTO_ACUERDO(?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);	
		stmSelect.setString(2, inCrateData);	
		stmSelect.execute();
		valorAdjunto = stmSelect.getString(1);
		stmSelect.close();

		return valorAdjunto;
	}
	
	
}