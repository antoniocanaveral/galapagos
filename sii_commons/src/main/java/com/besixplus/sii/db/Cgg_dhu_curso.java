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
* CLASE Cgg_dhu_curso
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_curso.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_curso implements Serializable{
	private static final long serialVersionUID = 848418682;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_curso.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_curso myCgg_dhu_curso = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_curso.
	*/
	public Cgg_dhu_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_curso.
	* @param inCgg_dhu_curso OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_curso.
	*/
	public Cgg_dhu_curso(
		com.besixplus.sii.objects.Cgg_dhu_curso inCgg_dhu_curso
	){
		this.setCgg_dhu_curso(inCgg_dhu_curso);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_curso.
	* @param inCgg_dhu_curso OBJETO Cgg_dhu_curso.
	* @return void
	*/
	public void setCgg_dhu_curso(com.besixplus.sii.objects.Cgg_dhu_curso inCgg_dhu_curso){
		this.myCgg_dhu_curso = inCgg_dhu_curso;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_curso.
	* @return Cgg_dhu_curso OBJETO Cgg_dhu_curso.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_curso getCgg_dhu_curso(){
		return this.myCgg_dhu_curso;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?::smallint,?::smallint,?::smallint,?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_curso().getCDCUR_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_curso().getCDTCR_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_curso().getCCTN_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_curso().getCSCTP_CODIGO());
			stmInsert.setString(6, this.getCgg_dhu_curso().getCDITR_CODIGO());
			stmInsert.setString(7, this.getCgg_dhu_curso().getCRPER_CODIGO());
			stmInsert.setString(8, this.getCgg_dhu_curso().getCDCUR_DESCRIPCION());
			stmInsert.setTimestamp(9,this.getCgg_dhu_curso().getCDCUR_FECHA_PREVISTA_INICIO()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_PREVISTA_INICIO().getTime()));
			stmInsert.setTimestamp(10,this.getCgg_dhu_curso().getCDCUR_FECHA_INICIO()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(11,this.getCgg_dhu_curso().getCDCUR_FECHA_CULMINACION()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_CULMINACION().getTime()));
			stmInsert.setTimestamp(12,this.getCgg_dhu_curso().getCDCUR_FECHA_PREVISTA_CULMINACION()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_PREVISTA_CULMINACION().getTime()));
			stmInsert.setString(13, this.getCgg_dhu_curso().getCDCUR_HORARIO());
			stmInsert.setString(14, this.getCgg_dhu_curso().getCDCUR_HORARIO1());
			stmInsert.setInt(15, this.getCgg_dhu_curso().getCDCUR_NUMERO_HORAS_PEDAGOGICAS());
			stmInsert.setInt(16, this.getCgg_dhu_curso().getCDCUR_NUMERO_HORAS());
			stmInsert.setInt(17, this.getCgg_dhu_curso().getCDCUR_NUMERO_MODULOS());
			stmInsert.setString(18, this.getCgg_dhu_curso().getCDCUR_CONTENIDO());
			stmInsert.setString(19, this.getCgg_dhu_curso().getCDCUR_INSTITUCION());
			stmInsert.setString(20, this.getCgg_dhu_curso().getCDCUR_ESTABLECIMIENTO());
			stmInsert.setBigDecimal(21, this.getCgg_dhu_curso().getCDCUR_COSTO());
			stmInsert.setBigDecimal(22, this.getCgg_dhu_curso().getCDCUR_PORCENTAJE_FINANCIADO());
			stmInsert.setString(23, this.getCgg_dhu_curso().getCDCUR_OBSERVACION());
			stmInsert.setInt(24, this.getCgg_dhu_curso().getCDCUR_VALORACION());
			stmInsert.setInt(25, this.getCgg_dhu_curso().getCDCUR_NUMERO_ASISTENTE());
			stmInsert.setInt(26, this.getCgg_dhu_curso().getCDCUR_ESTADO_CURSO());
			stmInsert.setBoolean(27, this.getCgg_dhu_curso().getCDCUR_ESTADO());
			stmInsert.setString(28, this.getCgg_dhu_curso().getCDCUR_USUARIO_INSERT());
			stmInsert.setString(29, this.getCgg_dhu_curso().getCDCUR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_curso().setCDCUR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO1(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_dhu_curso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?::smallint, ?::smallint, ?::smallint, ?, ?, ?, ?, ?, ?, ?::smallint,?::smallint, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_curso().getCDCUR_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_curso().getCDTCR_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_curso().getCCTN_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_curso().getCSCTP_CODIGO());
			stmUpdate.setString(5, this.getCgg_dhu_curso().getCDITR_CODIGO());
			stmUpdate.setString(6, this.getCgg_dhu_curso().getCRPER_CODIGO());
			stmUpdate.setString(7, this.getCgg_dhu_curso().getCDCUR_DESCRIPCION());
			stmUpdate.setTimestamp(8, new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_PREVISTA_INICIO().getTime()));
			stmUpdate.setTimestamp(9,this.getCgg_dhu_curso().getCDCUR_FECHA_INICIO()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(10,this.getCgg_dhu_curso().getCDCUR_FECHA_CULMINACION()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_CULMINACION().getTime()));
			stmUpdate.setTimestamp(11, new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_PREVISTA_CULMINACION().getTime()));
			stmUpdate.setString(12, this.getCgg_dhu_curso().getCDCUR_HORARIO());
			stmUpdate.setString(13, this.getCgg_dhu_curso().getCDCUR_HORARIO1());
			stmUpdate.setInt(14, this.getCgg_dhu_curso().getCDCUR_NUMERO_HORAS_PEDAGOGICAS());
			stmUpdate.setInt(15, this.getCgg_dhu_curso().getCDCUR_NUMERO_HORAS());
			stmUpdate.setInt(16, this.getCgg_dhu_curso().getCDCUR_NUMERO_MODULOS());
			stmUpdate.setString(17, this.getCgg_dhu_curso().getCDCUR_CONTENIDO());
			stmUpdate.setString(18, this.getCgg_dhu_curso().getCDCUR_INSTITUCION());
			stmUpdate.setString(19, this.getCgg_dhu_curso().getCDCUR_ESTABLECIMIENTO());
			stmUpdate.setBigDecimal(20, this.getCgg_dhu_curso().getCDCUR_COSTO());
			stmUpdate.setBigDecimal(21, this.getCgg_dhu_curso().getCDCUR_PORCENTAJE_FINANCIADO());
			stmUpdate.setString(22, this.getCgg_dhu_curso().getCDCUR_OBSERVACION());
			stmUpdate.setInt(23, this.getCgg_dhu_curso().getCDCUR_VALORACION());
			stmUpdate.setInt(24, this.getCgg_dhu_curso().getCDCUR_NUMERO_ASISTENTE());
			stmUpdate.setInt(25, this.getCgg_dhu_curso().getCDCUR_ESTADO_CURSO());
			stmUpdate.setBoolean(26, this.getCgg_dhu_curso().getCDCUR_ESTADO());
			stmUpdate.setString(27, this.getCgg_dhu_curso().getCDCUR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_curso select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_curso().getCDCUR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_curso().setCDCUR_CODIGO(results.getString(1));
				this.getCgg_dhu_curso().setCDTCR_CODIGO(results.getString(2));
				this.getCgg_dhu_curso().setCCTN_CODIGO(results.getString(3));
				this.getCgg_dhu_curso().setCSCTP_CODIGO(results.getString(4));
				this.getCgg_dhu_curso().setCDITR_CODIGO(results.getString(5));
				this.getCgg_dhu_curso().setCRPER_CODIGO(results.getString(6));
				this.getCgg_dhu_curso().setCDCUR_DESCRIPCION(results.getString(7));
				this.getCgg_dhu_curso().setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				this.getCgg_dhu_curso().setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				this.getCgg_dhu_curso().setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				this.getCgg_dhu_curso().setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				this.getCgg_dhu_curso().setCDCUR_HORARIO(results.getString(12));
				this.getCgg_dhu_curso().setCDCUR_HORARIO1(results.getString(13));
				this.getCgg_dhu_curso().setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				this.getCgg_dhu_curso().setCDCUR_NUMERO_HORAS(results.getInt(15));
				this.getCgg_dhu_curso().setCDCUR_NUMERO_MODULOS(results.getInt(16));
				this.getCgg_dhu_curso().setCDCUR_CONTENIDO(results.getString(17));
				this.getCgg_dhu_curso().setCDCUR_INSTITUCION(results.getString(18));
				this.getCgg_dhu_curso().setCDCUR_ESTABLECIMIENTO(results.getString(19));
				this.getCgg_dhu_curso().setCDCUR_COSTO(results.getBigDecimal(20));
				this.getCgg_dhu_curso().setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				this.getCgg_dhu_curso().setCDCUR_OBSERVACION(results.getString(22));
				this.getCgg_dhu_curso().setCDCUR_VALORACION(results.getInt(23));
				this.getCgg_dhu_curso().setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				this.getCgg_dhu_curso().setCDCUR_ESTADO_CURSO(results.getInt(25));
				this.getCgg_dhu_curso().setCDCUR_ESTADO(results.getBoolean(26));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_curso();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_curso().getCDCUR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_curso().getCDCUR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_curso().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO1(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_curso().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_curso().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectCGG_CANTON(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_curso().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO1(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_dhu_curso().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_dhu_curso().getCCTN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_institucion_responsable.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectCGG_DHU_INSTITUCION_RESPONSABLE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_S_CGG_DHU_INSTITUCION_RESPONSABLE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_curso().getCDITR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO1(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_institucion_responsable.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_INSTITUCION_RESPONSABLE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_D_CGG_DHU_INSTITUCION_RESPONSABLE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_curso().getCDITR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DS_CGG_DHU_INSTITUCION_RESPONSABLE(?) }");
				stmDelete.setString(1, this.getCgg_dhu_curso().getCDITR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectCGG_DHU_TIPO_CURSO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_S_CGG_DHU_TIPO_CURSO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_curso().getCDTCR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(10));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO1(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_TIPO_CURSO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_D_CGG_DHU_TIPO_CURSO(?) }");
			stmDelete.setString(1, this.getCgg_dhu_curso().getCDTCR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DS_CGG_DHU_TIPO_CURSO(?) }");
				stmDelete.setString(1, this.getCgg_dhu_curso().getCDTCR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> selectCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso> outCgg_dhu_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_S_CGG_SECTOR_PRODUCTIVO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_curso().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_curso tmpCgg_dhu_curso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				tmpCgg_dhu_curso.setCDCUR_CODIGO(results.getString(1));
				tmpCgg_dhu_curso.setCDTCR_CODIGO(results.getString(2));
				tmpCgg_dhu_curso.setCCTN_CODIGO(results.getString(3));
				tmpCgg_dhu_curso.setCSCTP_CODIGO(results.getString(4));
				tmpCgg_dhu_curso.setCDITR_CODIGO(results.getString(5));
				tmpCgg_dhu_curso.setCRPER_CODIGO(results.getString(6));
				tmpCgg_dhu_curso.setCDCUR_DESCRIPCION(results.getString(7));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_INICIO(results.getTimestamp(8));
				tmpCgg_dhu_curso.setCDCUR_FECHA_INICIO(results.getTimestamp(9));
				tmpCgg_dhu_curso.setCDCUR_FECHA_CULMINACION(results.getTimestamp(19));
				tmpCgg_dhu_curso.setCDCUR_FECHA_PREVISTA_CULMINACION(results.getTimestamp(11));
				tmpCgg_dhu_curso.setCDCUR_HORARIO(results.getString(12));
				tmpCgg_dhu_curso.setCDCUR_HORARIO1(results.getString(13));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(results.getInt(14));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_HORAS(results.getInt(15));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_MODULOS(results.getInt(16));
				tmpCgg_dhu_curso.setCDCUR_CONTENIDO(results.getString(17));
				tmpCgg_dhu_curso.setCDCUR_INSTITUCION(results.getString(18));
				tmpCgg_dhu_curso.setCDCUR_ESTABLECIMIENTO(results.getString(19));
				tmpCgg_dhu_curso.setCDCUR_COSTO(results.getBigDecimal(20));
				tmpCgg_dhu_curso.setCDCUR_PORCENTAJE_FINANCIADO(results.getBigDecimal(21));
				tmpCgg_dhu_curso.setCDCUR_OBSERVACION(results.getString(22));
				tmpCgg_dhu_curso.setCDCUR_VALORACION(results.getInt(23));
				tmpCgg_dhu_curso.setCDCUR_NUMERO_ASISTENTE(results.getInt(24));
				tmpCgg_dhu_curso.setCDCUR_ESTADO_CURSO(results.getInt(25));
				tmpCgg_dhu_curso.setCDCUR_ESTADO(results.getBoolean(26));
				outCgg_dhu_curso.add(tmpCgg_dhu_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_curso DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_D_CGG_SECTOR_PRODUCTIVO(?) }");
			stmDelete.setString(1, this.getCgg_dhu_curso().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_CURSO_DS_CGG_SECTOR_PRODUCTIVO(?) }");
				stmDelete.setString(1, this.getCgg_dhu_curso().getCSCTP_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCurso(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_curso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_curso_select_page(?,?,?,?,?,?) }");
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
				outCgg_dhu_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_curso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoCursoTerminado(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.f_cgg_dhu_curso_estado_update_terminado( ?,?,?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_curso().getCDCUR_CODIGO());
			stmUpdate.setTimestamp(2,this.getCgg_dhu_curso().getCDCUR_FECHA_CULMINACION()==null?null:new java.sql.Timestamp(this.getCgg_dhu_curso().getCDCUR_FECHA_CULMINACION().getTime()));		
			stmUpdate.setInt(3, this.getCgg_dhu_curso().getCDCUR_ESTADO_CURSO());
			stmUpdate.setString(4, this.getCgg_dhu_curso().getCDCUR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_curso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoCurso(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.f_cgg_dhu_curso_estado_update( ?,?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_curso().getCDCUR_CODIGO());
			stmUpdate.setInt(2, this.getCgg_dhu_curso().getCDCUR_ESTADO_CURSO());
			stmUpdate.setString(3, this.getCgg_dhu_curso().getCDCUR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCursoEstado(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_curso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_curso_historial(?,?,?,?,?,?) }");
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
				outCgg_dhu_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCursoEstadoCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CURSO_HISTORIAL_COUNT(?) }");
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
	*  NUMERO DE ASISTENTES INSCRITOS DE LA TABLA Cgg_dhu_asistente_curso
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param in_Cdcur_codigo PARAMETRO PARA CONTABILIZAR LOS ASISTENTES
	* @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static int NumeroInscrito(
		java.sql.Connection inConnection,	
		String in_Cdcur_codigo
	){
		int valorRetorno=0;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_numero_asistente(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2,in_Cdcur_codigo);	
			stmSelect.execute();
			valorRetorno = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CURSO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCursoAsistente(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCdtcr_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_curso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_curso_asistente_select(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCdtcr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCursoAsistenteCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_curso_asistente_select_count(?) }");
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
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CURSO.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCursoAsistenteCountByTipo(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCdtcr_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_curso_asistente_select_countCdtcr_codigo(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCdtcr_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO. 
	* @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CURSO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCursoInscripcion(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCdtcr_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_curso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_curso_inscripcion_select(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCdtcr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CURSO.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCursoInscripcionCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCdtcr_codigo
	){
		int outCount = 0;
		/*if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);*/
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_DHU_CURSO_INSCRIPCION_SELECT_COUNTBYTIPO(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCdtcr_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CURSO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectCursoInscripcionByTipo(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCdtcr_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_curso = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_DHU_CURSO_INSCRIPCION_SELECTBYTIPO(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCdtcr_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_curso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_curso;
	}
}