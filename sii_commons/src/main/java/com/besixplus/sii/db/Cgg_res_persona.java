package com.besixplus.sii.db;

import com.besixplus.sii.misc.Utils;
import org.postgresql.jdbc4.Jdbc4Array;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * CLASE Cgg_res_persona
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_persona.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_persona implements Serializable{
	private static final long serialVersionUID = 125759570;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_persona.
	 */
	private com.besixplus.sii.objects.Cgg_res_persona myCgg_res_persona = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_persona.
	 */
	public Cgg_res_persona(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_persona.
	 * @param inCgg_res_persona OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_persona.
	 */
	public Cgg_res_persona(
			com.besixplus.sii.objects.Cgg_res_persona inCgg_res_persona
	){
		this.setCgg_res_persona(inCgg_res_persona);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_persona.
	 * @param inCgg_res_persona OBJETO Cgg_res_persona.
	 * @return void
	 */
	public void setCgg_res_persona(com.besixplus.sii.objects.Cgg_res_persona inCgg_res_persona){
		this.myCgg_res_persona = inCgg_res_persona;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_persona.
	 * @return Cgg_res_persona OBJETO Cgg_res_persona.
	 */
	public com.besixplus.sii.objects.Cgg_res_persona getCgg_res_persona(){
		return this.myCgg_res_persona;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_persona().getCRPER_CODIGO());
			stmInsert.setString(3, this.getCgg_res_persona().getCRECV_CODIGO());
			stmInsert.setString(4, this.getCgg_res_persona().getCRDID_CODIGO());
			stmInsert.setString(5, this.getCgg_res_persona().getCRTSG_CODIGO());
			stmInsert.setString(6, this.getCgg_res_persona().getCGNCN_CODIGO());
			stmInsert.setString(7, this.getCgg_res_persona().getCPRR_CODIGO());
			stmInsert.setString(8, this.getCgg_res_persona().getCCTN_CODIGO());
			stmInsert.setString(9, this.getCgg_res_persona().getCGG_CCTN_CODIGO());
			stmInsert.setString(10, this.getCgg_res_persona().getCPAIS_CODIGO());
			stmInsert.setString(11, this.getCgg_res_persona().getCGG_CPAIS_CODIGO());
			stmInsert.setString(12, this.getCgg_res_persona().getCRPER_NOMBRES());
			stmInsert.setString(13, this.getCgg_res_persona().getCRPER_APELLIDO_PATERNO());
			stmInsert.setString(14, this.getCgg_res_persona().getCRPER_APELLIDO_MATERNO());
			stmInsert.setString(15, this.getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmInsert.setTimestamp(16,  this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO().getTime()));
			stmInsert.setString(17, this.getCgg_res_persona().getCRPER_LUGAR_NACIMIENTO());
			stmInsert.setInt(18, this.getCgg_res_persona().getCRPER_GENERO());
			stmInsert.setString(19, this.getCgg_res_persona().getCRPER_OBSERVACIONES());
			stmInsert.setString(20, this.getCgg_res_persona().getCRPER_NUMERO_RESIDENCIA());
			stmInsert.setBytes(21, this.getCgg_res_persona().getCRPER_FOTO());
			stmInsert.setBytes(22, this.getCgg_res_persona().getCRPER_FOTO_CURRICULUM());
			stmInsert.setString(23, this.getCgg_res_persona().getCRPER_HUELLA_DACTILAR());
			stmInsert.setBytes(24, this.getCgg_res_persona().getCRPER_HUELLA_IMAGEN());
			stmInsert.setString(25, this.getCgg_res_persona().getCRPER_HUELLA_CADENA());
			stmInsert.setBytes(26, this.getCgg_res_persona().getCRPER_FIRMA());
			stmInsert.setBoolean(27, this.getCgg_res_persona().getCRPER_AUTORIZADO());
			stmInsert.setString(28, this.getCgg_res_persona().getCRPER_NUMERO_EXPEDIENTE());
			stmInsert.setTimestamp(29,this.getCgg_res_persona().getCRPER_FECHA_ARCHIVO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_ARCHIVO().getTime()));
			stmInsert.setBoolean(30, this.getCgg_res_persona().getCRPER_EMPLEADO());
			stmInsert.setTimestamp(31, this.getCgg_res_persona().getCRPER_FECHA_ULTIMO_EMPLEO() == null ?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_ULTIMO_EMPLEO().getTime()));
			stmInsert.setBigDecimal(32, this.getCgg_res_persona().getCRPER_ASPIRACION_SALARIAL());
			stmInsert.setBoolean(33, this.getCgg_res_persona().getCRPER_CUPO_VEHICULAR());
			stmInsert.setInt(34, this.getCgg_res_persona().getCRPER_TIPO_PERSONA());
			stmInsert.setBoolean(35, this.getCgg_res_persona().getCRPER_ESTADO_INTERFECTO());
			stmInsert.setTimestamp(36, this.getCgg_res_persona().getCRPER_FECHA_DEFUNCION()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_DEFUNCION().getTime()));
			stmInsert.setString(37, this.getCgg_res_persona().getCRPER_NUMERO_ACTA());
			stmInsert.setBytes(38, this.getCgg_res_persona().getCRPER_ADJUNTO_ACTA());
			stmInsert.setString(39, this.getCgg_res_persona().getCRPER_NOMBRE_ADJUNTO_ACTA());
			stmInsert.setInt(40, this.getCgg_res_persona().getCRPER_TIPO());
			stmInsert.setBoolean(41, this.getCgg_res_persona().getCRPER_ATENCION_CLIENTE());
			stmInsert.setBoolean(42, this.getCgg_res_persona().getCRPER_ESTADO());
			stmInsert.setString(43, this.getCgg_res_persona().getCRPER_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_persona().setCRPER_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_COUNT(?) }");
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
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_COUNT() }");
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
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_nacionalidad.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectCGG_NACIONALIDAD(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_S_CGG_NACIONALIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCGNCN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_nacionalidad.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_NACIONALIDAD(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_D_CGG_NACIONALIDAD(?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCGNCN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DS_CGG_NACIONALIDAD(?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCGNCN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_parroquia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectCGG_PARROQUIA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_S_CGG_PARROQUIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCPRR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_parroquia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_PARROQUIA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_D_CGG_PARROQUIA(?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCPRR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DS_CGG_PARROQUIA(?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCPRR_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_sanguineo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectCGG_RES_TIPO_SANGUINEO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_S_CGG_RES_TIPO_SANGUINEO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCRTSG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_sanguineo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_TIPO_SANGUINEO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_D_CGG_RES_TIPO_SANGUINEO(?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCRTSG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DS_CGG_RES_TIPO_SANGUINEO(?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCRTSG_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectCGG_CANTON(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_S_CGG_CANTON(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCCTN_CODIGO());
			stmSelect.setString(3, this.getCgg_res_persona().getCGG_CCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_D_CGG_CANTON(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCCTN_CODIGO());
			stmDelete.setString(2, this.getCgg_res_persona().getCGG_CCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DS_CGG_CANTON(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCCTN_CODIGO());
				stmDelete.setString(2, this.getCgg_res_persona().getCGG_CCTN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_estado_civil.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectCGG_RES_ESTADO_CIVIL(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_S_CGG_RES_ESTADO_CIVIL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona().getCRECV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_estado_civil.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_ESTADO_CIVIL(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_D_CGG_RES_ESTADO_CIVIL(?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCRECV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DS_CGG_RES_ESTADO_CIVIL(?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCRECV_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_documento_identificacio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectCGG_RES_DOCUMENTO_IDENTIFICACIO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_persona = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_S_CGG_RES_DOCUMENTO_IDENTIFICACIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCRDID_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_persona = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_persona.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_persona.setCRECV_CODIGO(results.getString(2));
				tmpCgg_res_persona.setCRDID_CODIGO(results.getString(3));
				tmpCgg_res_persona.setCRTSG_CODIGO(results.getString(4));
				tmpCgg_res_persona.setCGNCN_CODIGO(results.getString(5));
				tmpCgg_res_persona.setCPRR_CODIGO(results.getString(6));
				tmpCgg_res_persona.setCCTN_CODIGO(results.getString(7));
				tmpCgg_res_persona.setCGG_CCTN_CODIGO(results.getString(8));
				tmpCgg_res_persona.setCPAIS_CODIGO(results.getString(9));
				tmpCgg_res_persona.setCGG_CPAIS_CODIGO(results.getString(10));
				tmpCgg_res_persona.setCRPER_NOMBRES(results.getString(11));
				tmpCgg_res_persona.setCRPER_APELLIDO_PATERNO(results.getString(12));
				tmpCgg_res_persona.setCRPER_APELLIDO_MATERNO(results.getString(13));
				tmpCgg_res_persona.setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				tmpCgg_res_persona.setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				tmpCgg_res_persona.setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				tmpCgg_res_persona.setCRPER_GENERO(results.getInt(17));
				tmpCgg_res_persona.setCRPER_OBSERVACIONES(results.getString(18));
				tmpCgg_res_persona.setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				tmpCgg_res_persona.setCRPER_FOTO(results.getBytes(20));
				tmpCgg_res_persona.setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				tmpCgg_res_persona.setCRPER_HUELLA_DACTILAR(results.getString(22));
				tmpCgg_res_persona.setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				tmpCgg_res_persona.setCRPER_HUELLA_CADENA(results.getString(24));
				tmpCgg_res_persona.setCRPER_FIRMA(results.getBytes(25));
				tmpCgg_res_persona.setCRPER_AUTORIZADO(results.getBoolean(26));
				tmpCgg_res_persona.setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				tmpCgg_res_persona.setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				tmpCgg_res_persona.setCRPER_EMPLEADO(results.getBoolean(29));
				tmpCgg_res_persona.setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				tmpCgg_res_persona.setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				tmpCgg_res_persona.setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				tmpCgg_res_persona.setCRPER_TIPO_PERSONA(results.getInt(33));
				tmpCgg_res_persona.setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				tmpCgg_res_persona.setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				tmpCgg_res_persona.setCRPER_NUMERO_ACTA(results.getString(36));
				tmpCgg_res_persona.setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				tmpCgg_res_persona.setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				tmpCgg_res_persona.setCRPER_TIPO(results.getInt(39));
				tmpCgg_res_persona.setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				tmpCgg_res_persona.setCRPER_ESTADO(results.getBoolean(41));
				outCgg_res_persona.add(tmpCgg_res_persona);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_documento_identificacio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_DOCUMENTO_IDENTIFICACIO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_D_CGG_RES_DOCUMENTO_IDENTIFICACIO(?) }");
			stmDelete.setString(1, this.getCgg_res_persona().getCRDID_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_DS_CGG_RES_DOCUMENTO_IDENTIFICACIO(?) }");
				stmDelete.setString(1, this.getCgg_res_persona().getCRDID_CODIGO());
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_persona().getCRECV_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_persona().getCRDID_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_persona().getCRTSG_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_persona().getCGNCN_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_persona().getCPRR_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_persona().getCCTN_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_persona().getCGG_CCTN_CODIGO());
			stmUpdate.setString(9, this.getCgg_res_persona().getCPAIS_CODIGO());
			stmUpdate.setString(10, this.getCgg_res_persona().getCGG_CPAIS_CODIGO());
			stmUpdate.setString(11, this.getCgg_res_persona().getCRPER_NOMBRES());
			stmUpdate.setString(12, this.getCgg_res_persona().getCRPER_APELLIDO_PATERNO());
			stmUpdate.setString(13, this.getCgg_res_persona().getCRPER_APELLIDO_MATERNO());
			stmUpdate.setString(14, this.getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmUpdate.setTimestamp(15, this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO().getTime()));
			stmUpdate.setString(16, this.getCgg_res_persona().getCRPER_LUGAR_NACIMIENTO());
			stmUpdate.setInt(17, this.getCgg_res_persona().getCRPER_GENERO());
			stmUpdate.setString(18, this.getCgg_res_persona().getCRPER_OBSERVACIONES());
			stmUpdate.setString(19, this.getCgg_res_persona().getCRPER_NUMERO_RESIDENCIA());
			stmUpdate.setBytes(20, this.getCgg_res_persona().getCRPER_FOTO());
			stmUpdate.setBytes(21, this.getCgg_res_persona().getCRPER_FOTO_CURRICULUM());
			stmUpdate.setString(22, this.getCgg_res_persona().getCRPER_HUELLA_DACTILAR());
			stmUpdate.setBytes(23, this.getCgg_res_persona().getCRPER_HUELLA_IMAGEN());
			stmUpdate.setString(24, this.getCgg_res_persona().getCRPER_HUELLA_CADENA());
			stmUpdate.setBytes(25, this.getCgg_res_persona().getCRPER_FIRMA());
			stmUpdate.setBoolean(26, this.getCgg_res_persona().getCRPER_AUTORIZADO());
			stmUpdate.setString(27, this.getCgg_res_persona().getCRPER_NUMERO_EXPEDIENTE());
			stmUpdate.setTimestamp(28, this.getCgg_res_persona().getCRPER_FECHA_ARCHIVO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_ARCHIVO().getTime()));
			stmUpdate.setBoolean(29, this.getCgg_res_persona().getCRPER_EMPLEADO());
			stmUpdate.setTimestamp(30, this.getCgg_res_persona().getCRPER_FECHA_ULTIMO_EMPLEO() == null ?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_ULTIMO_EMPLEO().getTime()));
			stmUpdate.setBigDecimal(31, this.getCgg_res_persona().getCRPER_ASPIRACION_SALARIAL());
			stmUpdate.setBoolean(32, this.getCgg_res_persona().getCRPER_CUPO_VEHICULAR());
			stmUpdate.setInt(33, this.getCgg_res_persona().getCRPER_TIPO_PERSONA());
			stmUpdate.setBoolean(34, this.getCgg_res_persona().getCRPER_ESTADO_INTERFECTO());
			stmUpdate.setTimestamp(35, this.getCgg_res_persona().getCRPER_FECHA_DEFUNCION()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_DEFUNCION().getTime()));
			stmUpdate.setString(36, this.getCgg_res_persona().getCRPER_NUMERO_ACTA());
			stmUpdate.setBytes(37, this.getCgg_res_persona().getCRPER_ADJUNTO_ACTA());
			stmUpdate.setString(38, this.getCgg_res_persona().getCRPER_NOMBRE_ADJUNTO_ACTA());
			stmUpdate.setInt(39, this.getCgg_res_persona().getCRPER_TIPO());
			stmUpdate.setBoolean(40, this.getCgg_res_persona().getCRPER_ATENCION_CLIENTE());
			stmUpdate.setBoolean(41, this.getCgg_res_persona().getCRPER_ESTADO());
			stmUpdate.setString(42, this.getCgg_res_persona().getCRPER_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_persona select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_persona().setCRPER_CODIGO(results.getString(1));
				this.getCgg_res_persona().setCRECV_CODIGO(results.getString(2));
				this.getCgg_res_persona().setCRDID_CODIGO(results.getString(3));
				this.getCgg_res_persona().setCRTSG_CODIGO(results.getString(4));
				this.getCgg_res_persona().setCGNCN_CODIGO(results.getString(5));
				this.getCgg_res_persona().setCPRR_CODIGO(results.getString(6));
				this.getCgg_res_persona().setCCTN_CODIGO(results.getString(7));
				this.getCgg_res_persona().setCGG_CCTN_CODIGO(results.getString(8));
				this.getCgg_res_persona().setCPAIS_CODIGO(results.getString(9));
				this.getCgg_res_persona().setCGG_CPAIS_CODIGO(results.getString(10));
				this.getCgg_res_persona().setCRPER_NOMBRES(results.getString(11));
				this.getCgg_res_persona().setCRPER_APELLIDO_PATERNO(results.getString(12));
				this.getCgg_res_persona().setCRPER_APELLIDO_MATERNO(results.getString(13));
				this.getCgg_res_persona().setCRPER_NUM_DOC_IDENTIFIC(results.getString(14));
				this.getCgg_res_persona().setCRPER_FECHA_NACIMIENTO(results.getTimestamp(15));
				this.getCgg_res_persona().setCRPER_LUGAR_NACIMIENTO(results.getString(16));
				this.getCgg_res_persona().setCRPER_GENERO(results.getInt(17));
				this.getCgg_res_persona().setCRPER_OBSERVACIONES(results.getString(18));
				this.getCgg_res_persona().setCRPER_NUMERO_RESIDENCIA(results.getString(19));
				this.getCgg_res_persona().setCRPER_FOTO(results.getBytes(20));
				this.getCgg_res_persona().setCRPER_FOTO_CURRICULUM(results.getBytes(21));
				this.getCgg_res_persona().setCRPER_HUELLA_DACTILAR(results.getString(22));
				this.getCgg_res_persona().setCRPER_HUELLA_IMAGEN(results.getBytes(23));
				this.getCgg_res_persona().setCRPER_HUELLA_CADENA(results.getString(24));
				this.getCgg_res_persona().setCRPER_FIRMA(results.getBytes(25));
				this.getCgg_res_persona().setCRPER_AUTORIZADO(results.getBoolean(26));
				this.getCgg_res_persona().setCRPER_NUMERO_EXPEDIENTE(results.getString(27));
				this.getCgg_res_persona().setCRPER_FECHA_ARCHIVO(results.getTimestamp(28));
				this.getCgg_res_persona().setCRPER_EMPLEADO(results.getBoolean(29));
				this.getCgg_res_persona().setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(30));
				this.getCgg_res_persona().setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(31));
				this.getCgg_res_persona().setCRPER_CUPO_VEHICULAR(results.getBoolean(32));
				this.getCgg_res_persona().setCRPER_TIPO_PERSONA(results.getInt(33));
				this.getCgg_res_persona().setCRPER_ESTADO_INTERFECTO(results.getBoolean(34));
				this.getCgg_res_persona().setCRPER_FECHA_DEFUNCION(results.getTimestamp(35));
				this.getCgg_res_persona().setCRPER_NUMERO_ACTA(results.getString(36));
				this.getCgg_res_persona().setCRPER_ADJUNTO_ACTA(results.getBytes(37));
				this.getCgg_res_persona().setCRPER_NOMBRE_ADJUNTO_ACTA(results.getString(38));
				this.getCgg_res_persona().setCRPER_TIPO(results.getInt(39));
				this.getCgg_res_persona().setCRPER_ATENCION_CLIENTE(results.getBoolean(40));
				this.getCgg_res_persona().setCRPER_ESTADO(results.getBoolean(41));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_persona();
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrtst_codigo CONSIDERAR LAS PERSONAS QUE PERTENECEN A UN TIPO DE SOLICITUD DE TRAMITE
	 * @param inCarnet CONSIDERAR SOLO LAS PERSONAS QUE TIENE UN TRAMITE DE CARNETIZACION
	 * @param inIdentificacion NUMERO DE IDENTIFICACION.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<LinkedHashMap<String,Object>> selectAllLite(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrtst_codigo,
			boolean inCarnet,
			String inIdentificacion
	){
		ArrayList<LinkedHashMap<String,Object>> outCgg_res_persona = new ArrayList<LinkedHashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_LITE(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrtst_codigo);
			stmSelect.setBoolean(9, inCarnet);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				LinkedHashMap<String,Object> tmpObj = new LinkedHashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCrtst_codigo CONSIDERAR LAS PERSONAS QUE PERTENECEN A UN TIPO DE SOLICITUD DE TRAMITE
	 * @param inCarnet CONSIDERAR SOLO LAS PERSONAS QUE TIENE UN TRAMITE DE CARNETIZACION
	 * @param inIdentificacion NUMERO DE IDENTIFICACION
	 * @return int NUMERO DE REGISTROS.
	 */
	public static BigDecimal selectCountLite(
			java.sql.Connection inConnection,
			String inKeyword,
			String inCrtst_codigo,
			boolean inCarnet,
			String inIdentificacion
	){
		BigDecimal outCount = new BigDecimal(0);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_COUNT_LITE(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.NUMERIC);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrtst_codigo);
			stmSelect.setBoolean(4, inCarnet);
			stmSelect.execute();
			outCount = stmSelect.getBigDecimal(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * ACTUALIZA LA IMAGEN DE LAS HUELLAS DACTILARES DE UNA PERSONA.
	 * NOTA: LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String updateHuellaImagen(Connection inConnection){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_UPDATE_HUELLA_IMG(?,?,?,?) }");
			stmUpdate.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());
			stmUpdate.setString(2,this.getCgg_res_persona().getCRPER_HUELLA_DACTILAR());
			stmUpdate.setBytes(3, this.getCgg_res_persona().getCRPER_HUELLA_IMAGEN());
			stmUpdate.setString(4, this.getCgg_res_persona().getCRPER_HUELLA_CADENA());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}




	/**
	 * SELECCIONA LA INFORMACION QUE SE IMPRIME EN LAS ESPECIES DE RESIDENCIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public HashMap<String,Object> selectInfoCarnet(Connection inConnection){
		HashMap<String,Object> outPersona = new HashMap<String,Object>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_INFO_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			outPersona = new Utils().toHashMap(results);
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outPersona;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update1(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_UPDATE1(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_persona().getCRECV_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_persona().getCRDID_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_persona().getCRTSG_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_persona().getCGNCN_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_persona().getCPRR_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_persona().getCCTN_CODIGO());
			stmUpdate.setString(8, this.getCgg_res_persona().getCGG_CCTN_CODIGO());
			stmUpdate.setString(9, this.getCgg_res_persona().getCPAIS_CODIGO());
			stmUpdate.setString(10, this.getCgg_res_persona().getCGG_CPAIS_CODIGO());	
			stmUpdate.setString(11, this.getCgg_res_persona().getCRPER_NOMBRES());
			stmUpdate.setString(12, this.getCgg_res_persona().getCRPER_APELLIDO_PATERNO());
			stmUpdate.setString(13, this.getCgg_res_persona().getCRPER_APELLIDO_MATERNO());
			stmUpdate.setString(14, this.getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmUpdate.setTimestamp(15, this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO().getTime()));
			stmUpdate.setString(16, this.getCgg_res_persona().getCRPER_LUGAR_NACIMIENTO());
			stmUpdate.setInt(17, this.getCgg_res_persona().getCRPER_GENERO());
			stmUpdate.setString(18, this.getCgg_res_persona().getCRPER_OBSERVACIONES());
			stmUpdate.setString(19, this.getCgg_res_persona().getCRPER_NUMERO_RESIDENCIA());	
			stmUpdate.setBoolean(20, this.getCgg_res_persona().getCRPER_AUTORIZADO());
			stmUpdate.setString(21, this.getCgg_res_persona().getCRPER_NUMERO_EXPEDIENTE());
			stmUpdate.setTimestamp(22, this.getCgg_res_persona().getCRPER_FECHA_ARCHIVO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_ARCHIVO().getTime()));
			stmUpdate.setBoolean(23, this.getCgg_res_persona().getCRPER_EMPLEADO());
			stmUpdate.setTimestamp(24, this.getCgg_res_persona().getCRPER_FECHA_ULTIMO_EMPLEO() == null ?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_ULTIMO_EMPLEO().getTime()));
			stmUpdate.setBigDecimal(25, this.getCgg_res_persona().getCRPER_ASPIRACION_SALARIAL());
			stmUpdate.setBoolean(26, this.getCgg_res_persona().getCRPER_CUPO_VEHICULAR());
			stmUpdate.setInt(27, this.getCgg_res_persona().getCRPER_TIPO_PERSONA());
			stmUpdate.setBoolean(28, this.getCgg_res_persona().getCRPER_ESTADO_INTERFECTO());
			stmUpdate.setTimestamp(29, this.getCgg_res_persona().getCRPER_FECHA_DEFUNCION()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_DEFUNCION().getTime()));
			stmUpdate.setString(30, this.getCgg_res_persona().getCRPER_NUMERO_ACTA());
			stmUpdate.setInt(31, this.getCgg_res_persona().getCRPER_TIPO());
			stmUpdate.setBoolean(32, this.getCgg_res_persona().getCRPER_ATENCION_CLIENTE());
			stmUpdate.setBoolean(33, this.getCgg_res_persona().getCRPER_ESTADO());
			stmUpdate.setString(34, this.getCgg_res_persona().getCRPER_USUARIO_UPDATE());	
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	public static ArrayList<HashMap<String, Object>> selectPersonaNotificacion(Connection inConnection, String inUserName, int inStart, int inLimit, String inSortFieldName, String inDirection, String inKeyword)
	{
		ArrayList outCgg_res_persona = new ArrayList();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_s_notificacion(?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap tmpObj = new HashMap();
				for (int i = 1; i <= tmpColumnCount; i++)
					if (results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	public static int selectCountNotificacion(Connection inConnection, String inKeyword)
	{
		int outCount = 0;
		if ((inKeyword == null) || (inKeyword.trim().length() == 0))
			return selectCount(inConnection);
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f.cgg_res_persona_notificacion_count(?) }");
			stmSelect.registerOutParameter(1, 4);
			stmSelect.setString(2, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param incrper_codigo IDENTIFICATIVO DE LA PERSONA.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersonaContactoNotificacion(
			java.sql.Connection inConnection,
			String incrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_s_contacto(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, incrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	public static ArrayList<HashMap<String, Object>> selectPersonaDenuncia(Connection inConnection, String inUserName, int inStart, int inLimit, String inSortFieldName, String inDirection, String inKeyword)
	{
		ArrayList outCgg_res_persona = new ArrayList();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_s_denuncia(?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap tmpObj = new HashMap();
				for (int i = 1; i <= tmpColumnCount; i++)
					if (results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	public static int selectDenunciaCount(Connection inConnection, String inKeyword)
	{
		int outCount = 0;
		if ((inKeyword == null) || (inKeyword.trim().length() == 0))
			return selectCount(inConnection);
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_denuncia_count(?) }");
			stmSelect.registerOutParameter(1, 4);
			stmSelect.setString(2, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_persona selectNumDoc(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_NUM_DOC(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_persona().setCRPER_CODIGO(results.getString(1));
				this.getCgg_res_persona().setCRECV_CODIGO(results.getString(2));
				this.getCgg_res_persona().setCRDID_CODIGO(results.getString(3));
				this.getCgg_res_persona().setCRTSG_CODIGO(results.getString(4));
				this.getCgg_res_persona().setCGNCN_CODIGO(results.getString(5));
				this.getCgg_res_persona().setCPRR_CODIGO(results.getString(6));
				this.getCgg_res_persona().setCCTN_CODIGO(results.getString(7));
				this.getCgg_res_persona().setCGG_CCTN_CODIGO(results.getString(8));
				this.getCgg_res_persona().setCRPER_NOMBRES(results.getString(9));
				this.getCgg_res_persona().setCRPER_APELLIDO_PATERNO(results.getString(10));
				this.getCgg_res_persona().setCRPER_APELLIDO_MATERNO(results.getString(11));
				this.getCgg_res_persona().setCRPER_NUM_DOC_IDENTIFIC(results.getString(12));
				this.getCgg_res_persona().setCRPER_FECHA_NACIMIENTO(results.getTimestamp(13));
				this.getCgg_res_persona().setCRPER_LUGAR_NACIMIENTO(results.getString(14));
				this.getCgg_res_persona().setCRPER_GENERO(results.getInt(15));
				this.getCgg_res_persona().setCRPER_OBSERVACIONES(results.getString(16));
				this.getCgg_res_persona().setCRPER_NUMERO_RESIDENCIA(results.getString(17));
				//this.getCgg_res_persona().setCRPER_FOTO(results.getBytes(18));
				//this.getCgg_res_persona().setCRPER_FOTO_CURRICULUM(results.getBytes(19));
				//this.getCgg_res_persona().setCRPER_HUELLA_DACTILAR(results.getBytes(20));
				//this.getCgg_res_persona().setCRPER_FIRMA(results.getBytes(21));
				this.getCgg_res_persona().setCRPER_AUTORIZADO(results.getBoolean(22));
				this.getCgg_res_persona().setCRPER_NUMERO_EXPEDIENTE(results.getString(23));
				this.getCgg_res_persona().setCRPER_FECHA_ARCHIVO(results.getTimestamp(24));
				this.getCgg_res_persona().setCRPER_EMPLEADO(results.getBoolean(25));
				this.getCgg_res_persona().setCRPER_FECHA_ULTIMO_EMPLEO(results.getTimestamp(26));
				this.getCgg_res_persona().setCRPER_ASPIRACION_SALARIAL(results.getBigDecimal(27));
				this.getCgg_res_persona().setCRPER_CUPO_VEHICULAR(results.getBoolean(28));
				this.getCgg_res_persona().setCRPER_TIPO_PERSONA(results.getInt(29));
				this.getCgg_res_persona().setCRPER_ESTADO_INTERFECTO(results.getBoolean(30));
				this.getCgg_res_persona().setCRPER_FECHA_DEFUNCION(results.getTimestamp(31));
				this.getCgg_res_persona().setCRPER_NUMERO_ACTA(results.getString(32));
				this.getCgg_res_persona().setCRPER_TIPO(results.getInt(33));
				this.getCgg_res_persona().setCRPER_ATENCION_CLIENTE(results.getBoolean(34));
				this.getCgg_res_persona().setCRPER_ESTADO(results.getBoolean(35));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			e.printStackTrace();
		}
		return this.getCgg_res_persona();
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_persona> selectPrestamoExpediente(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> outCgg_res_personaexpediente = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_prestamo_expediente_select_persona(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_persona tmpCgg_res_personaexpediente = new com.besixplus.sii.objects.Cgg_res_persona();
				tmpCgg_res_personaexpediente.setCRPER_CODIGO(results.getString(1));
				tmpCgg_res_personaexpediente.setCRPER_NOMBRE_PERSONA(results.getString(2));
				tmpCgg_res_personaexpediente.setCRPER_NUM_DOC_IDENTIFIC(results.getString(3));
				tmpCgg_res_personaexpediente.setCRPER_NUMERO_EXPEDIENTE(results.getString(4));
				tmpCgg_res_personaexpediente.setCRPER_FECHA_ARCHIVO(results.getTimestamp(5));
				tmpCgg_res_personaexpediente.setPRESTAMOEXPEDIENTE(results.getString(6));
				tmpCgg_res_personaexpediente.setMOVIMIENTO(new Cgg_res_persona(tmpCgg_res_personaexpediente).selectPrestamo(inConnection));
				tmpCgg_res_personaexpediente.setCRPER_ESTADO(results.getBoolean(7));
				outCgg_res_personaexpediente.add(tmpCgg_res_personaexpediente);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_personaexpediente;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_prestamo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */		
	public ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> selectPrestamo(
			java.sql.Connection inConnection			
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente> outCgg_res_prestamo_consulta= new ArrayList<com.besixplus.sii.objects.Cgg_res_prestamo_expediente>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_prestamo_expe_persona(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_persona().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_prestamo_expediente tmpCgg_res_prestamo_expediente = new com.besixplus.sii.objects.Cgg_res_prestamo_expediente();
				tmpCgg_res_prestamo_expediente.setCRPEX_CODIGO(results.getString(1));
				tmpCgg_res_prestamo_expediente.setCGG_CRPER_CODIGO(results.getString(2));
				tmpCgg_res_prestamo_expediente.setCRPER_NOMBRE_RECIBE(results.getString(3));
				tmpCgg_res_prestamo_expediente.setCRPEX_MOVIMIENTO(results.getInt(4));
				tmpCgg_res_prestamo_expediente.setCRPEX_FECHA_OPERACION(results.getTimestamp(5));
				tmpCgg_res_prestamo_expediente.setCRPEX_OBSERVACION(results.getString(6));
				outCgg_res_prestamo_consulta.add(tmpCgg_res_prestamo_expediente);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_prestamo_consulta;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectPrestamoCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		//if (inKeyword == null || inKeyword.trim().length() == 0 )
		//	return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_expediente_count(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectObservado(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_OBSERVADO(?,?,?,?,?,?) }");
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
				tmpObj.put("OBSERVADO", Cgg_res_observado.selectCGG_RES_PERSONADirect(results.getString(1).toString(), inConnection));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectObservadoCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		//if (inKeyword == null || inKeyword.trim().length() == 0 )
		//return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_COUNT_OBSERVADO(?) }");
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
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectPersonaConultaCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_consulta_count(?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectConsultaGeneralPersona(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inIdentificacion
	){
		ArrayList<HashMap<String,Object>> outCgg_res_personahistorial = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_consulta_general(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inIdentificacion);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));

				outCgg_res_personahistorial.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_personahistorial;
	}

	public com.besixplus.sii.objects.Cgg_res_persona selectNumDocHistorial(Connection inConnection)
	{
		try
		{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_num_doc_historial(?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			while (results.next()) {
				getCgg_res_persona().setCRPER_CODIGO(results.getString(1));
				getCgg_res_persona().setCRECV_ESTADO_CIVIL(results.getString(2));
				getCgg_res_persona().setCRDID_TIPO(results.getString(3));
				getCgg_res_persona().setCGNCN_NOMBRE(results.getString(4));
				getCgg_res_persona().setCPRR_NOMBRE(results.getString(5));
				getCgg_res_persona().setCCNT_NOMBRE(results.getString(6));
				getCgg_res_persona().setCCNT_NOMBRE_ORIGEN(results.getString(7));
				getCgg_res_persona().setCRPER_NOMBRES(results.getString(8));
				getCgg_res_persona().setCRPER_APELLIDO_PATERNO(results.getString(9));
				getCgg_res_persona().setCRPER_APELLIDO_MATERNO(results.getString(10));
				getCgg_res_persona().setCRPER_NUM_DOC_IDENTIFIC(results.getString(11));
				getCgg_res_persona().setCRPER_FECHA_NACIMIENTO(results.getTimestamp(12));
				getCgg_res_persona().setCRPER_LUGAR_NACIMIENTO(results.getString(13));
				getCgg_res_persona().setCRPER_GENERO(results.getInt(14));
				getCgg_res_persona().setCRPER_NUMERO_RESIDENCIA(results.getString(15));
				getCgg_res_persona().setCRPER_AUTORIZADO(results.getBoolean(16));
				getCgg_res_persona().setCRPER_TIPO_PERSONA(results.getInt(17));
				getCgg_res_persona().setCRPER_TIPO(results.getInt(18));
				getCgg_res_persona().setCRPER_ESTADO(results.getBoolean(19));
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
			e.printStackTrace();
		}
		return getCgg_res_persona();
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_observadoDE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersonaHistorialObservado(
			java.sql.Connection inConnection,
			String inCrper_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_res_observado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_consulta_observado(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_observado .add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_observado ;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_notificacion DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE PERSONA
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersonaHistorialNotificacion(
			java.sql.Connection inConnection,
			String inCrper_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_consulta_notificado(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_notificacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion;
	}

	public static ArrayList<HashMap<String, Object>> selectPersonaHistorialMovilidadIngreso(Connection inConnection, String inCrper_codigo)
	{
		ArrayList outCgg_res_movilidad_ingreso = new ArrayList();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_movilidad_ingreso(?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap tmpObj = new HashMap();
				for (int i = 1; i <= tmpColumnCount; i++)
					if (results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad_ingreso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
			outCgg_res_movilidad_ingreso = selectPersonaHistorialMovilidadGeneral(inConnection, inCrper_codigo, outCgg_res_movilidad_ingreso);
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_ingreso;
	}

	public static ArrayList<HashMap<String, Object>> selectPersonaHistorialMovilidadGeneral(Connection inConnection, String inCrper_codigo, ArrayList<HashMap<String, Object>> inCgg_res_movilidad)
	{
		try
		{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_movilidad_general(?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap tmpObj = new HashMap();
				for (int i = 1; i <= tmpColumnCount; i++)
					if (results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				inCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return inCgg_res_movilidad;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrper_codigo CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectPersonaHistorialMovilidadGeneral(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_MOVILIDAD_GENERAL(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));

				outCgg_res_movilidad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad;
	}
	public static ArrayList<HashMap<String, Object>> selectPersonaHistorialMovilidadInternaIngreso(Connection inConnection, String inCrper_codigo)
	{
		ArrayList outCgg_res_movilidad_interna_ingreso = new ArrayList();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_movilidad_interna_ingreso(?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap tmpObj = new HashMap();
				for (int i = 1; i <= tmpColumnCount; i++)
					if (results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad_interna_ingreso.add(tmpObj);
			}
			results.close();
			stmSelect.close();
			outCgg_res_movilidad_interna_ingreso = selectPersonaHistorialMovilidadInterna(inConnection, inCrper_codigo, outCgg_res_movilidad_interna_ingreso);
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_movilidad_interna_ingreso;
	}

	public static ArrayList<HashMap<String, Object>> selectPersonaHistorialMovilidadInterna(Connection inConnection, String inCrper_codigo, ArrayList<HashMap<String, Object>> inCgg_res_movilidad_interna)
	{
		try
		{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_movilidad_interna(?) }");
			stmSelect.registerOutParameter(1, 1111);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet)stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap tmpObj = new HashMap();
				for (int i = 1; i <= tmpColumnCount; i++)
					if (results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				inCgg_res_movilidad_interna.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return inCgg_res_movilidad_interna;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCrper_codigo 
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectMovilidadGeneralCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inCrper_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_PERSONA_SELECT_MOVILIDAD_GENERAL_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrper_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCrper_codigo CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	public static ArrayList<HashMap<String,Object>> selectPersonaHistorialMovilidadInterna(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_movilidad_interna = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_movilidad_interna(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_movilidad_interna.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}

		return outCgg_res_movilidad_interna;
	}/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectMovilidadInternaCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		//if (inKeyword == null || inKeyword.trim().length() == 0 )
		//return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_movilidad_interna_count(?) }");
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
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_expulsion DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */



	public static ArrayList<HashMap<String,Object>> selectPersonaHistorialExpulsion(
			java.sql.Connection inConnection,
			String inCrper_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_res_expulsion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_consulta_expulsion(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_expulsion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_residencia DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersonaEstadia(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_estadia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_consulta_estadia(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_estadia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_estadia;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_residencia DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */



	public static ArrayList<HashMap<String,Object>> selectPersonaResidenciaHistorial(
			java.sql.Connection inConnection,
			String inCrper_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_HISTORIAL_RESIDENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_residencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_residencia DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */



	public static ArrayList<HashMap<String,Object>> selectPersonaEstadiaHistorial(
			java.sql.Connection inConnection,
			String inCrper_num_doc_identific

	){
		ArrayList<HashMap<String,Object>> outCgg_res_residencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_consulta_estadia_historial(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_num_doc_identific);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_residencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_residencia;
	}

	public static int selectPersonaHistorialCount(Connection inConnection, String inKeyword)
	{
		int outCount = 0;
		try
		{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_count(?) }");
			stmSelect.registerOutParameter(1, 4);
			stmSelect.setString(2, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		} catch (SQLException e) {
			SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectPersonaHistorialCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inIdentificacion
	){
		int outCount = 0;
		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_count(?) }");
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insertTctPersona(
			java.sql.Connection inConnection
	){
		String outResult = "true";

		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_PERSONA_INSERT(?, ?, ?, ?, ?, ?, ?,?::smallint,?,  ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_persona().getCRPER_CODIGO());			
			stmInsert.setString(3, this.getCgg_res_persona().getCRDID_CODIGO());			
			stmInsert.setString(4, this.getCgg_res_persona().getCGNCN_CODIGO());			
			stmInsert.setString(5, this.getCgg_res_persona().getCRPER_NOMBRES());
			stmInsert.setString(6, this.getCgg_res_persona().getCRPER_APELLIDO_PATERNO());			
			stmInsert.setString(7, this.getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmInsert.setTimestamp(8, this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO().getTime()));			
			stmInsert.setInt(9, this.getCgg_res_persona().getCRPER_GENERO());
			stmInsert.setString(10, this.getCgg_res_persona().getCGG_CPAIS_CODIGO());
			stmInsert.setBoolean(11, this.getCgg_res_persona().getCRPER_ESTADO());
			stmInsert.setString(12, this.getCgg_res_persona().getCRPER_USUARIO_INSERT());
			stmInsert.setString(13,this.getCgg_res_persona().getCRPER_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_persona().setCRPER_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateTctPersona(
			java.sql.Connection inConnection

	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_PERSONA_UPDATE(?, ?, ?, ?, ?, ?, ?,?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());			
			stmUpdate.setString(2, this.getCgg_res_persona().getCRDID_CODIGO());			
			stmUpdate.setString(3, this.getCgg_res_persona().getCGNCN_CODIGO());			
			stmUpdate.setString(4, this.getCgg_res_persona().getCRPER_NOMBRES());
			stmUpdate.setString(5, this.getCgg_res_persona().getCRPER_APELLIDO_PATERNO());			
			stmUpdate.setString(6, this.getCgg_res_persona().getCRPER_NUM_DOC_IDENTIFIC());
			stmUpdate.setTimestamp(7, this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO()==null?null:new java.sql.Timestamp(this.getCgg_res_persona().getCRPER_FECHA_NACIMIENTO().getTime()));			
			stmUpdate.setInt(8, this.getCgg_res_persona().getCRPER_GENERO());
			stmUpdate.setString(9, this.getCgg_res_persona().getCGG_CPAIS_CODIGO());
			stmUpdate.setBoolean(10, this.getCgg_res_persona().getCRPER_ESTADO());			
			stmUpdate.setString(11,this.getCgg_res_persona().getCRPER_USUARIO_UPDATE());				
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectDatosPersonalesById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DATOS_PERSONALES_BYID(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectFotoCurriculumById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECTFOTOBYID(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE TENGAN REGISTRADO UNA HUELLA DACTILAR.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return 
	 */
	public static ArrayList<HashMap<String,Object>> selectHuellas(
			java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_HUELLAS() }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE TENGAN REGISTRADO UNA HUELLA DACTILAR.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCRPER_NUMERO_DOC NUMERO DE RESIDENCIA O DOCUMENTO DE IDENTIFICACION.
	 * @return 
	 */
	public static ArrayList<HashMap<String,Object>> selectHuellas(
			java.sql.Connection inConnection,
			String inCRPER_NUMERO_DOC
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_HUELLAS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCRPER_NUMERO_DOC);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	/**
	 * ACTUALIZA LA IMAGEN DE LA FOTO DE UNA PERSONA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String updateFoto(Connection inConnection){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_UPDATE_FOTO(?,?) }");
			stmUpdate.setString(1,this.getCgg_res_persona().getCRPER_CODIGO());
			stmUpdate.setBytes(2,this.getCgg_res_persona().getCRPER_FOTO());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * ACTUALIZA LA IMAGEN DE LA FIRMA DE UNA PERSONA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String updateFirma(Connection inConnection){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_UPDATE_FIRMA(?,?) }");
			stmUpdate.setString(1,this.getCgg_res_persona().getCRPER_CODIGO());
			stmUpdate.setBytes(2,this.getCgg_res_persona().getCRPER_FIRMA());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	 * OBTIENE LOS CAMPOS DE FOTOGRAFIA,HUELLAS Y FIRMA DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA.
	 * @return ArrayList<HashMap<String,Object>> OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAdjuntosIdentificacionById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_SELECT_ADJUNTOS_IDENTIFICACION_BYID(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

	/**
	 * Genera un numero de expediente para un nuevo residente. Este numero es el numero de expediente o carnet.
	 * El numero de expediente es generado del total de numero de expedientes existentes +1.
	 * @param inConnection Conexion de datos.
	 * @return Cadena de datos con el numero de expediente siguiente.
	 */
	public String generarExpediente(
			java.sql.Connection inConnection
	){
		String outCount = "0";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_GENERA_EXPEDIENTE() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.execute();
			outCount = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outCount = "0";
		}
		return outCount;
	}

	/**
	 * Actualiza el numero de expediente de una persona. El numero de expediente es un codigo unico q se utiliza para identificar la residencia de una persona.
	 * @param inConnection Conexion de datos.
	 * @return Verdadero/falso/Error en la actualizacion.
	 */
	public String actualizarNumeroResidencia(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_ACTUALIZAR_NUMERO_RESIDENCIA(?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_persona().getCRPER_CODIGO());				
			stmUpdate.setString(2, this.getCgg_res_persona().getCRPER_NUMERO_RESIDENCIA());								
			stmUpdate.setString(3, this.getCgg_res_persona().getCRPER_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	 * ACTUALIZA LA IMAGEN DEL CURRICULUM DE UNA PERSONA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String updateFotoCurriculum(Connection inConnection){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PERSONA_UPDATE_FOTO_CURRICULUM(?,?,?,?,?,?) }");
			stmUpdate.setString(1,this.getCgg_res_persona().getCRPER_CODIGO());
			stmUpdate.setBytes(2,this.getCgg_res_persona().getCRPER_FOTO_CURRICULUM());
			stmUpdate.setString(3,this.getCgg_res_persona().getCCTN_CODIGO());
			stmUpdate.setString(4,this.getCgg_res_persona().getCPRR_CODIGO());
			stmUpdate.setString(5,this.getCgg_res_persona().getCGG_CPAIS_CODIGO());
			stmUpdate.setBoolean(6,this.getCgg_res_persona().getCRPER_EMPLEADO());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	 * OBTIENE LOS CORREOS ELECTRONICO DE UNA PERSONA
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param inSW MODO DE CONSULTA, <code>0</code> SE BASA EN EL CODIGO DE LA PERSONA, <code>1</code> EN EL CODIGO DEL USUARIO
	 * @return
	 */
	public ArrayList<HashMap<String, String>> selectEmails(
			Connection inConnection,
			String inCrper_codigo,
			int inSW
	){
		ArrayList<HashMap<String, String>> outEmails = new ArrayList<HashMap<String,String>>();
		String[] tmpEmails = null;
		try{
			CallableStatement tmpStmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_EMAILS(?,?) }");
			tmpStmSelect.registerOutParameter(1, Types.ARRAY);
			tmpStmSelect.setString(2, inCrper_codigo);
			tmpStmSelect.setInt(3, inSW);
			tmpStmSelect.execute();
			if(tmpStmSelect.getObject(1) != null){
				tmpEmails = ((String[])((Jdbc4Array)tmpStmSelect.getObject(1)).getArray());
				tmpStmSelect.close();
				for (String tmpEmail : tmpEmails) {
					HashMap<String, String> tmpBuff = new HashMap<String, String>();
					tmpBuff.put("email", tmpEmail);
					outEmails.add(tmpBuff);
				}
			}
			tmpStmSelect.close();
		}catch(SQLException inException){
			inException.printStackTrace();
		}
		return outEmails;
	}

	/**
	 * SELECCIONA LOS DATOS DE LA PERSONA DE ACUERDO A SU NOMBRE DE USUARIO .
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<HashMap<String,Object>> OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectDatosAuspiciante(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_PERSONA_SELECT_DATOS_AUSPICIANTE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}

}