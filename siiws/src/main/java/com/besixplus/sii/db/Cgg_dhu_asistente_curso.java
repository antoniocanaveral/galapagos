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
* CLASE Cgg_dhu_asistente_curso
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_asistente_curso.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_asistente_curso implements Serializable{
	private static final long serialVersionUID = 1274221081;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_asistente_curso.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_asistente_curso myCgg_dhu_asistente_curso = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_asistente_curso.
	*/
	public Cgg_dhu_asistente_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_asistente_curso.
	* @param inCgg_dhu_asistente_curso OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_asistente_curso.
	*/
	public Cgg_dhu_asistente_curso(
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso inCgg_dhu_asistente_curso
	){
		this.setCgg_dhu_asistente_curso(inCgg_dhu_asistente_curso);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_asistente_curso.
	* @param inCgg_dhu_asistente_curso OBJETO Cgg_dhu_asistente_curso.
	* @return void
	*/
	public void setCgg_dhu_asistente_curso(com.besixplus.sii.objects.Cgg_dhu_asistente_curso inCgg_dhu_asistente_curso){
		this.myCgg_dhu_asistente_curso = inCgg_dhu_asistente_curso;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_asistente_curso.
	* @return Cgg_dhu_asistente_curso OBJETO Cgg_dhu_asistente_curso.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_asistente_curso getCgg_dhu_asistente_curso(){
		return this.myCgg_dhu_asistente_curso;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmInsert.setString(6, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
			stmInsert.setString(7, this.getCgg_dhu_asistente_curso().getCDASC_ACTIVIDAD_REALIZADA());
			stmInsert.setBigDecimal(8, this.getCgg_dhu_asistente_curso().getCDASC_NOTA_FINAL());
			stmInsert.setString(9, this.getCgg_dhu_asistente_curso().getCDASC_NUMERO_CERTIFICADO());
			stmInsert.setTimestamp(10,this.getCgg_dhu_asistente_curso().getCDASC_FECHA_EMISION_CERTIFICADO()==null?null:new java.sql.Timestamp(this.getCgg_dhu_asistente_curso().getCDASC_FECHA_EMISION_CERTIFICADO().getTime()));
			stmInsert.setInt(11, this.getCgg_dhu_asistente_curso().getCDASC_ESTADO_INSCRIPCION());
			stmInsert.setInt(12, this.getCgg_dhu_asistente_curso().getCDASC_APROBADO());
			stmInsert.setBoolean(13, this.getCgg_dhu_asistente_curso().getCDASC_ESTADO());
			stmInsert.setString(14, this.getCgg_dhu_asistente_curso().getCDASC_USUARIO_INSERT());
			stmInsert.setString(15, this.getCgg_dhu_asistente_curso().getCDASC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_asistente_curso().setCDASC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			//outResult = "false";
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> outCgg_dhu_asistente_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpCgg_dhu_asistente_curso = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
				tmpCgg_dhu_asistente_curso.setCDASC_CODIGO(results.getString(1));
				tmpCgg_dhu_asistente_curso.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_asistente_curso.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_asistente_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_asistente_curso.setCUSU_CODIGO(results.getString(5));
				tmpCgg_dhu_asistente_curso.setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				tmpCgg_dhu_asistente_curso.setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				tmpCgg_dhu_asistente_curso.setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				tmpCgg_dhu_asistente_curso.setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				tmpCgg_dhu_asistente_curso.setCDASC_APROBADO(results.getInt(11));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO(results.getBoolean(12));
				outCgg_dhu_asistente_curso.add(tmpCgg_dhu_asistente_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> outCgg_dhu_asistente_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpCgg_dhu_asistente_curso = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
				tmpCgg_dhu_asistente_curso.setCDASC_CODIGO(results.getString(1));
				tmpCgg_dhu_asistente_curso.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_asistente_curso.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_asistente_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_asistente_curso.setCUSU_CODIGO(results.getString(5));
				tmpCgg_dhu_asistente_curso.setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				tmpCgg_dhu_asistente_curso.setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				tmpCgg_dhu_asistente_curso.setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				tmpCgg_dhu_asistente_curso.setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				tmpCgg_dhu_asistente_curso.setCDASC_APROBADO(results.getInt(11));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO(results.getBoolean(12));
				outCgg_dhu_asistente_curso.add(tmpCgg_dhu_asistente_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_asistente_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_COUNT() }");
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
			inKeyword="";//return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmUpdate.setString(5, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
			stmUpdate.setString(6, this.getCgg_dhu_asistente_curso().getCDASC_ACTIVIDAD_REALIZADA());
			stmUpdate.setBigDecimal(7, this.getCgg_dhu_asistente_curso().getCDASC_NOTA_FINAL());
			stmUpdate.setString(8, this.getCgg_dhu_asistente_curso().getCDASC_NUMERO_CERTIFICADO());
			stmUpdate.setTimestamp(9,this.getCgg_dhu_asistente_curso().getCDASC_FECHA_EMISION_CERTIFICADO()==null?null:new java.sql.Timestamp(this.getCgg_dhu_asistente_curso().getCDASC_FECHA_EMISION_CERTIFICADO().getTime()));
			stmUpdate.setInt(10, this.getCgg_dhu_asistente_curso().getCDASC_ESTADO_INSCRIPCION());
			stmUpdate.setInt(11, this.getCgg_dhu_asistente_curso().getCDASC_APROBADO());
			stmUpdate.setBoolean(12, this.getCgg_dhu_asistente_curso().getCDASC_ESTADO());
			stmUpdate.setString(13, this.getCgg_dhu_asistente_curso().getCDASC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_asistente_curso select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_asistente_curso().setCDASC_CODIGO(results.getString(1));
				this.getCgg_dhu_asistente_curso().setCRPER_CODIGO(results.getString(2));
				this.getCgg_dhu_asistente_curso().setCDCUR_CODIGO(results.getString(3));
				this.getCgg_dhu_asistente_curso().setCSCTP_CODIGO(results.getString(4));
				this.getCgg_dhu_asistente_curso().setCUSU_CODIGO(results.getString(5));
				this.getCgg_dhu_asistente_curso().setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				this.getCgg_dhu_asistente_curso().setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				this.getCgg_dhu_asistente_curso().setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				this.getCgg_dhu_asistente_curso().setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				this.getCgg_dhu_asistente_curso().setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				this.getCgg_dhu_asistente_curso().setCDASC_APROBADO(results.getInt(11));
				this.getCgg_dhu_asistente_curso().setCDASC_ESTADO(results.getBoolean(12));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_asistente_curso();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> outCgg_dhu_asistente_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_S_CGG_RES_PERSONA(?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmSelect.setString(5,this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpCgg_dhu_asistente_curso = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
				tmpCgg_dhu_asistente_curso.setCDASC_CODIGO(results.getString(1));
				tmpCgg_dhu_asistente_curso.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_asistente_curso.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_asistente_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_asistente_curso.setCUSU_CODIGO(results.getString(5));
				tmpCgg_dhu_asistente_curso.setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				tmpCgg_dhu_asistente_curso.setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				tmpCgg_dhu_asistente_curso.setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				tmpCgg_dhu_asistente_curso.setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				tmpCgg_dhu_asistente_curso.setCDASC_APROBADO(results.getInt(11));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO(results.getBoolean(12));
				outCgg_dhu_asistente_curso.add(tmpCgg_dhu_asistente_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_D_CGG_RES_PERSONA(?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_DS_CGG_RES_PERSONA(?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
				stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> selectCGG_DHU_CURSO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> outCgg_dhu_asistente_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_S_CGG_DHU_CURSO(?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmSelect.setString(5,this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpCgg_dhu_asistente_curso = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
				tmpCgg_dhu_asistente_curso.setCDASC_CODIGO(results.getString(1));
				tmpCgg_dhu_asistente_curso.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_asistente_curso.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_asistente_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_asistente_curso.setCUSU_CODIGO(results.getString(5));
				tmpCgg_dhu_asistente_curso.setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				tmpCgg_dhu_asistente_curso.setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				tmpCgg_dhu_asistente_curso.setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				tmpCgg_dhu_asistente_curso.setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				tmpCgg_dhu_asistente_curso.setCDASC_APROBADO(results.getInt(11));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO(results.getBoolean(12));
				outCgg_dhu_asistente_curso.add(tmpCgg_dhu_asistente_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_CURSO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_D_CGG_DHU_CURSO(?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_DS_CGG_DHU_CURSO(?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
				stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> outCgg_dhu_asistente_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_S_CGG_USUARIO(?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmSelect.setString(5,this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpCgg_dhu_asistente_curso = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
				tmpCgg_dhu_asistente_curso.setCDASC_CODIGO(results.getString(1));
				tmpCgg_dhu_asistente_curso.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_asistente_curso.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_asistente_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_asistente_curso.setCUSU_CODIGO(results.getString(5));
				tmpCgg_dhu_asistente_curso.setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				tmpCgg_dhu_asistente_curso.setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				tmpCgg_dhu_asistente_curso.setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				tmpCgg_dhu_asistente_curso.setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				tmpCgg_dhu_asistente_curso.setCDASC_APROBADO(results.getInt(11));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO(results.getBoolean(12));
				outCgg_dhu_asistente_curso.add(tmpCgg_dhu_asistente_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_USUARIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_D_CGG_USUARIO(?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_DS_CGG_USUARIO(?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
				stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> selectCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> outCgg_dhu_asistente_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ASISTENTE_CURSO_S_CGG_SECTOR_PRODUCTIVO(?, ?, ?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmSelect.setString(4,this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmSelect.setString(5,this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpCgg_dhu_asistente_curso = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
				tmpCgg_dhu_asistente_curso.setCDASC_CODIGO(results.getString(1));
				tmpCgg_dhu_asistente_curso.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_asistente_curso.setCDCUR_CODIGO(results.getString(3));
				tmpCgg_dhu_asistente_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_asistente_curso.setCUSU_CODIGO(results.getString(5));
				tmpCgg_dhu_asistente_curso.setCDASC_ACTIVIDAD_REALIZADA(results.getString(6));
				tmpCgg_dhu_asistente_curso.setCDASC_NOTA_FINAL(results.getBigDecimal(7));
				tmpCgg_dhu_asistente_curso.setCDASC_NUMERO_CERTIFICADO(results.getString(8));
				tmpCgg_dhu_asistente_curso.setCDASC_FECHA_EMISION_CERTIFICADO(results.getTimestamp(9));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO_INSCRIPCION(results.getInt(10));
				tmpCgg_dhu_asistente_curso.setCDASC_APROBADO(results.getInt(11));
				tmpCgg_dhu_asistente_curso.setCDASC_ESTADO(results.getBoolean(12));
				outCgg_dhu_asistente_curso.add(tmpCgg_dhu_asistente_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_D_CGG_SECTOR_PRODUCTIVO(?, ?, ?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
			stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
			stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CURSO_DS_CGG_SECTOR_PRODUCTIVO(?, ?, ?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_asistente_curso().getCDCUR_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_asistente_curso().getCRPER_CODIGO());
				stmDelete.setString(3, this.getCgg_dhu_asistente_curso().getCSCTP_CODIGO());
				stmDelete.setString(4, this.getCgg_dhu_asistente_curso().getCUSU_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAsistente(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_curso_residente(?,?,?,?,?,?) }");
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
				outCgg_dhu_asistente.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int Selectasistentecount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_curso_residente_count(?) }");
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
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectAsistenteCurso(
		java.sql.Connection inConnection,
		String inCrper_num_doc_identific
	
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente_curso = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_residente(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCrper_num_doc_identific);
			
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_asistente_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllAsistenteCurso(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_curso_select_page(?,?,?,?,?,?) }");
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
				outCgg_dhu_asistente.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	 * @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectAsistenteCalificacion(
		java.sql.Connection inConnection,
		String inCdcur_codigo
	
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente_curso = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_calificacion(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCdcur_codigo);
			
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_asistente_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	 * @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectAsistenteInscrito(
		java.sql.Connection inConnection,
		String inCdcur_codigo
	
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente_curso = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_inscrito(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCdcur_codigo);
			
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_asistente_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	 * @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectAsistenteCerti(
		java.sql.Connection inConnection,
		String inCdcur_codigo
	
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente_curso = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_certificado(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCdcur_codigo);
			
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_asistente_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_curso;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	 * @return com.besixplus.sii.objects.Cgg_dhu_asistente_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectAsisInscrito(
		java.sql.Connection inConnection,
		String inCdcur_codigo
	
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_asistente_inscripcion = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_asistente_inscrito_select(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCdcur_codigo);
			
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_asistente_inscripcion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_asistente_inscripcion;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoInscrito(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.f_cgg_dhu_asistente_estado_inscrito_update( ?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());		
			stmUpdate.setInt(2, this.getCgg_dhu_asistente_curso().getCDASC_ESTADO_INSCRIPCION());			
			stmUpdate.setString(3, this.getCgg_dhu_asistente_curso().getCDASC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateAprobadoCurso(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CALIFICACION_UPDATE( ?,?,?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
			stmUpdate.setBigDecimal(2, this.getCgg_dhu_asistente_curso().getCDASC_NOTA_FINAL());
			stmUpdate.setInt(3, this.getCgg_dhu_asistente_curso().getCDASC_APROBADO());		
			stmUpdate.setString(4, this.getCgg_dhu_asistente_curso().getCDASC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_asistente_curso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateAprobadoCertificado(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_ASISTENTE_CERTIFICADO_UPDATE( ?,?,?,?) }");
			stmUpdate.setString(1, this.getCgg_dhu_asistente_curso().getCDASC_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_asistente_curso().getCDASC_NUMERO_CERTIFICADO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_dhu_asistente_curso().getCDASC_FECHA_EMISION_CERTIFICADO().getTime()));	
			stmUpdate.setString(4, this.getCgg_dhu_asistente_curso().getCDASC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_res_notificacion
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static String geneNumAprobacion(
		java.sql.Connection inConnection		
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_numero_minimo_aprobacion() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
}