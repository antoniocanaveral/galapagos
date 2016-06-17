package com.besixplus.sii.db;

import com.besixplus.sii.misc.CGGEnumerators.DataTypes;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASE Cgg_regla_validacion
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_regla_validacion.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_regla_validacion implements Serializable{
	private static final long serialVersionUID = 1669434193;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_regla_validacion.
	 */
	private com.besixplus.sii.objects.Cgg_regla_validacion myCgg_regla_validacion = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_regla_validacion.
	 */
	public Cgg_regla_validacion(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_regla_validacion.
	 * @param inCgg_regla_validacion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_regla_validacion.
	 */
	public Cgg_regla_validacion(
			com.besixplus.sii.objects.Cgg_regla_validacion inCgg_regla_validacion
	){
		this.setCgg_regla_validacion(inCgg_regla_validacion);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_regla_validacion.
	 * @param inCgg_regla_validacion OBJETO Cgg_regla_validacion.
	 * @return void
	 */
	public void setCgg_regla_validacion(com.besixplus.sii.objects.Cgg_regla_validacion inCgg_regla_validacion){
		this.myCgg_regla_validacion = inCgg_regla_validacion;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_regla_validacion.
	 * @return Cgg_regla_validacion OBJETO Cgg_regla_validacion.
	 */
	public com.besixplus.sii.objects.Cgg_regla_validacion getCgg_regla_validacion(){
		return this.myCgg_regla_validacion;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_regla_validacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_regla_validacion().getCRVAL_CODIGO());
			stmInsert.setString(3, this.getCgg_regla_validacion().getCGCNF_CODIGO());
			stmInsert.setString(4, this.getCgg_regla_validacion().getCRVAL_NOMBRE());
			stmInsert.setString(5, this.getCgg_regla_validacion().getCRVAL_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_regla_validacion().getCRVAL_FUNCION_VALIDACION());
			stmInsert.setString(7, this.getCgg_regla_validacion().getCRVAL_OPERADOR_COMPARADOR());
			stmInsert.setString(8, this.getCgg_regla_validacion().getCRVAL_VALOR_LIBRE());
			stmInsert.setString(9, this.getCgg_regla_validacion().getCRVAL_RESULTADO_ACEPTACION());
			stmInsert.setString(10, this.getCgg_regla_validacion().getCRVAL_SUGERENCIA());
			stmInsert.setInt(11, this.getCgg_regla_validacion().getCRVAL_TIPO());
			stmInsert.setTimestamp(12, new java.sql.Timestamp(this.getCgg_regla_validacion().getCRVAR_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(13, new java.sql.Timestamp(this.getCgg_regla_validacion().getCRVAR_FECHA_FIN().getTime()));
			stmInsert.setString(14, this.getCgg_regla_validacion().getCRVAL_VALOR_1());
			stmInsert.setString(15, this.getCgg_regla_validacion().getCRVAL_VALOR_2());
			stmInsert.setBoolean(16, this.getCgg_regla_validacion().getCRVAL_ESTADO());
			stmInsert.setString(17, this.getCgg_regla_validacion().getCRVAL_USUARIO_INSERT());
			stmInsert.setString(18, this.getCgg_regla_validacion().getCRVAL_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_regla_validacion().setCRVAL_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_regla_validacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> outCgg_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_regla_validacion tmpCgg_regla_validacion = new com.besixplus.sii.objects.Cgg_regla_validacion();
				tmpCgg_regla_validacion.setCRVAL_CODIGO(results.getString(1));
				tmpCgg_regla_validacion.setCGCNF_CODIGO(results.getString(2));
				tmpCgg_regla_validacion.setCRVAL_NOMBRE(results.getString(3));
				tmpCgg_regla_validacion.setCRVAL_DESCRIPCION(results.getString(4));
				tmpCgg_regla_validacion.setCRVAL_FUNCION_VALIDACION(results.getString(5));
				tmpCgg_regla_validacion.setCRVAL_OPERADOR_COMPARADOR(results.getString(6));
				tmpCgg_regla_validacion.setCRVAL_VALOR_LIBRE(results.getString(7));
				tmpCgg_regla_validacion.setCRVAL_RESULTADO_ACEPTACION(results.getString(8));
				tmpCgg_regla_validacion.setCRVAL_SUGERENCIA(results.getString(9));
				tmpCgg_regla_validacion.setCRVAL_TIPO(results.getInt(10));
				tmpCgg_regla_validacion.setCRVAR_FECHA_INICIO(results.getTimestamp(11));
				tmpCgg_regla_validacion.setCRVAR_FECHA_FIN(results.getTimestamp(12));
				tmpCgg_regla_validacion.setCRVAL_VALOR_1(results.getString(13));
				tmpCgg_regla_validacion.setCRVAL_VALOR_2(results.getString(14));
				tmpCgg_regla_validacion.setCRVAL_ESTADO(results.getBoolean(15));
				outCgg_regla_validacion.add(tmpCgg_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_regla_validacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> outCgg_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_regla_validacion tmpCgg_regla_validacion = new com.besixplus.sii.objects.Cgg_regla_validacion();
				tmpCgg_regla_validacion.setCRVAL_CODIGO(results.getString(1));
				tmpCgg_regla_validacion.setCGCNF_CODIGO(results.getString(2));
				tmpCgg_regla_validacion.setCRVAL_NOMBRE(results.getString(3));
				tmpCgg_regla_validacion.setCRVAL_DESCRIPCION(results.getString(4));
				tmpCgg_regla_validacion.setCRVAL_FUNCION_VALIDACION(results.getString(5));
				tmpCgg_regla_validacion.setCRVAL_OPERADOR_COMPARADOR(results.getString(6));
				tmpCgg_regla_validacion.setCRVAL_VALOR_LIBRE(results.getString(7));
				tmpCgg_regla_validacion.setCRVAL_RESULTADO_ACEPTACION(results.getString(8));
				tmpCgg_regla_validacion.setCRVAL_SUGERENCIA(results.getString(9));
				tmpCgg_regla_validacion.setCRVAL_TIPO(results.getInt(10));
				tmpCgg_regla_validacion.setCRVAR_FECHA_INICIO(results.getTimestamp(11));
				tmpCgg_regla_validacion.setCRVAR_FECHA_FIN(results.getTimestamp(12));
				tmpCgg_regla_validacion.setCRVAL_VALOR_1(results.getString(13));
				tmpCgg_regla_validacion.setCRVAL_VALOR_2(results.getString(14));
				tmpCgg_regla_validacion.setCRVAL_ESTADO(results.getBoolean(15));
				outCgg_regla_validacion.add(tmpCgg_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_regla_validacion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT(?,?,?,?,?,?) }");
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
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_regla_validacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_regla_validacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_REGLA_VALIDACION_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_regla_validacion().getCRVAL_CODIGO());
			stmUpdate.setString(2, this.getCgg_regla_validacion().getCGCNF_CODIGO());
			stmUpdate.setString(3, this.getCgg_regla_validacion().getCRVAL_NOMBRE());
			stmUpdate.setString(4, this.getCgg_regla_validacion().getCRVAL_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_regla_validacion().getCRVAL_FUNCION_VALIDACION());
			stmUpdate.setString(6, this.getCgg_regla_validacion().getCRVAL_OPERADOR_COMPARADOR());
			stmUpdate.setString(7, this.getCgg_regla_validacion().getCRVAL_VALOR_LIBRE());
			stmUpdate.setString(8, this.getCgg_regla_validacion().getCRVAL_RESULTADO_ACEPTACION());
			stmUpdate.setString(9, this.getCgg_regla_validacion().getCRVAL_SUGERENCIA());
			stmUpdate.setInt(10, this.getCgg_regla_validacion().getCRVAL_TIPO());
			stmUpdate.setTimestamp(11, new java.sql.Timestamp(this.getCgg_regla_validacion().getCRVAR_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(12, new java.sql.Timestamp(this.getCgg_regla_validacion().getCRVAR_FECHA_FIN().getTime()));
			stmUpdate.setString(13, this.getCgg_regla_validacion().getCRVAL_VALOR_1());
			stmUpdate.setString(14, this.getCgg_regla_validacion().getCRVAL_VALOR_2());
			stmUpdate.setBoolean(15, this.getCgg_regla_validacion().getCRVAL_ESTADO());
			stmUpdate.setString(16, this.getCgg_regla_validacion().getCRVAL_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_regla_validacion select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_regla_validacion().getCRVAL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_regla_validacion().setCRVAL_CODIGO(results.getString(1));
				this.getCgg_regla_validacion().setCGCNF_CODIGO(results.getString(2));
				this.getCgg_regla_validacion().setCRVAL_NOMBRE(results.getString(3));
				this.getCgg_regla_validacion().setCRVAL_DESCRIPCION(results.getString(4));
				this.getCgg_regla_validacion().setCRVAL_FUNCION_VALIDACION(results.getString(5));
				this.getCgg_regla_validacion().setCRVAL_OPERADOR_COMPARADOR(results.getString(6));
				this.getCgg_regla_validacion().setCRVAL_VALOR_LIBRE(results.getString(7));
				this.getCgg_regla_validacion().setCRVAL_RESULTADO_ACEPTACION(results.getString(8));
				this.getCgg_regla_validacion().setCRVAL_SUGERENCIA(results.getString(9));
				this.getCgg_regla_validacion().setCRVAL_TIPO(results.getInt(10));
				this.getCgg_regla_validacion().setCRVAR_FECHA_INICIO(results.getTimestamp(11));
				this.getCgg_regla_validacion().setCRVAR_FECHA_FIN(results.getTimestamp(12));
				this.getCgg_regla_validacion().setCRVAL_VALOR_1(results.getString(13));
				this.getCgg_regla_validacion().setCRVAL_VALOR_2(results.getString(14));
				this.getCgg_regla_validacion().setCRVAL_ESTADO(results.getBoolean(15));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_regla_validacion();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_REGLA_VALIDACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_regla_validacion().getCRVAL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_REGLA_VALIDACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_regla_validacion().getCRVAL_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_configuracion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> selectCGG_CONFIGURACION(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> outCgg_regla_validacion = new ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_S_CGG_CONFIGURACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_regla_validacion().getCGCNF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_regla_validacion tmpCgg_regla_validacion = new com.besixplus.sii.objects.Cgg_regla_validacion();
				tmpCgg_regla_validacion.setCRVAL_CODIGO(results.getString(1));
				tmpCgg_regla_validacion.setCGCNF_CODIGO(results.getString(2));
				tmpCgg_regla_validacion.setCRVAL_NOMBRE(results.getString(3));
				tmpCgg_regla_validacion.setCRVAL_DESCRIPCION(results.getString(4));
				tmpCgg_regla_validacion.setCRVAL_FUNCION_VALIDACION(results.getString(5));
				tmpCgg_regla_validacion.setCRVAL_OPERADOR_COMPARADOR(results.getString(6));
				tmpCgg_regla_validacion.setCRVAL_VALOR_LIBRE(results.getString(7));
				tmpCgg_regla_validacion.setCRVAL_RESULTADO_ACEPTACION(results.getString(8));
				tmpCgg_regla_validacion.setCRVAL_SUGERENCIA(results.getString(9));
				tmpCgg_regla_validacion.setCRVAL_TIPO(results.getInt(10));
				tmpCgg_regla_validacion.setCRVAR_FECHA_INICIO(results.getTimestamp(11));
				tmpCgg_regla_validacion.setCRVAR_FECHA_FIN(results.getTimestamp(12));
				tmpCgg_regla_validacion.setCRVAL_VALOR_1(results.getString(13));
				tmpCgg_regla_validacion.setCRVAL_VALOR_2(results.getString(14));
				tmpCgg_regla_validacion.setCRVAL_ESTADO(results.getBoolean(15));
				outCgg_regla_validacion.add(tmpCgg_regla_validacion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_configuracion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_CONFIGURACION(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_REGLA_VALIDACION_D_CGG_CONFIGURACION(?) }");
			stmDelete.setString(1, this.getCgg_regla_validacion().getCGCNF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_REGLA_VALIDACION_DS_CGG_CONFIGURACION(?) }");
				stmDelete.setString(1, this.getCgg_regla_validacion().getCGCNF_CODIGO());
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
	 * SELECCIONA TODAS LAS FUNCIONES PLSQL DEL ESQUEMA DEL SII PARA ESTABLECIMIENTO DE LA FUNCION PL/SQL QUE VALIDAR EL VALOR DE LA FUNCION.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return COLECCION DE FUNCION PL/SQL DEL ESQUEMA SII.
	 */
	public ArrayList<HashMap<String,Object>> seleccionFuncionPlSql(
			java.sql.Connection inConnection,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_FUNCION_PLSQL(?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, inStart);
			stmSelect.setInt(3, inLimit);
			stmSelect.setString(4, inSortFieldName);
			stmSelect.setString(5, inDirection);
			stmSelect.setString(6, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * SELECCIONA TODAS LAS FUNCIONES PLSQL DEL ESQUEMA SII PARA ESTABLECIMIENTO DE LA FUNCION PL/SQL QUE VALIDAR EL VALOR DE LA FUNCION.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return COLECCION DE FUNCION PL/SQL DEL ESQUEMA SII.
	 */
	public int selectCountFuncionPlSql(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_FUNCION_PLSQL_COUNT(?) }");
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
	 * SELECCIONA UNA FUNCION PLSQL DEL ESQUEMA SII.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION DE FUNCION PL/SQL DEL ESQUEMA SII.
	 */
	public ArrayList<HashMap<String,Object>> seleccionReglaFuncionPlSql(
			java.sql.Connection inConnection			
	){
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_FUNCION_PLSQL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_regla_validacion().getCRVAL_NOMBRE());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE SOLICITUD DE TRAMITE .
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>>  selectReglaTipoSolicitud(
			java.sql.Connection inConnection,String inCrtst_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT_TIPO_SOLICITUD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrtst_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}
	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE SOLICITUD DE TRAMITE .
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCopvl_formulario FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO.
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>>  selectReglaOperacionValidacionByForm(
			java.sql.Connection inConnection,String inCopvl_formulario 
	){
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT_OPERACION_VALIDACION_BY_FORM(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCopvl_formulario);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}
	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE SOLICITUD DE TRAMITE .
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCopvl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION.
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>>  selectReglaOperacionValidacion(
			java.sql.Connection inConnection,String inCopvl_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT_OPERACION_VALIDACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCopvl_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion JUNTO CON LOS DATOS DE LOS PARAMETOS DE LA FUNCION PLSQL QUE EJECUTARA .
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<HashMap<String,Object>>  selectReglaLiteParametros(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<HashMap<String,Object>> outCgg_regla_validacion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_REGLA_VALIDACION_SELECT_LITE_PARAMS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)						
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_regla_validacion.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_regla_validacion;
	}

	/**SELECCIONA LA INFORMACION DE LA TABLA Cgg_regla_validacion
	 * @param inConnection CONEXION A LA BASE DE DATOS. 
	 * @return REGLA DE METADATOS.
	 */

	public Cgg_regla_validacion_metadatos selectReglaMetadatos(java.sql.Connection inConnection)
	{
		CallableStatement stmSelect;
		Cgg_regla_validacion_metadatos outReglaMetadados =  new Cgg_regla_validacion_metadatos();
		try {
			//String 
			stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_REGLA_VALIDACION_FUNCION_PLSQL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);	
			stmSelect.setString(2, this.getCgg_regla_validacion().getCRVAL_FUNCION_VALIDACION());
			stmSelect.execute();

			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				outReglaMetadados.setNOMBREFUNCION(results.getString(1));
				outReglaMetadados.setNUMEROARGUMENTOS(results.getInt(2));
				outReglaMetadados.setNOMBREARGUMENTOS(results.getString(3));
				outReglaMetadados.setTIPORESPUESTA(results.getString(4));
				outReglaMetadados.setTIPODATOARGUMENTOS(results.getString(5));
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outReglaMetadados;
	}

	/**VERIFICA LAS REGLAS DE VALIDACION
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inReglaMetadados IDENTIFICACION DE LA REGLA DE VALIDACION.
	 * @param inJSONRegla IDENTIFICATIVO PARA EL OBJETO JSON.
	 * @return VALIDACION.
	 */
	public String reglaStatement(java.sql.Connection inConnection,
			Cgg_regla_validacion_metadatos inReglaMetadados,
			JSONObject inJSONRegla)
	{
		String sqlSentencia = null;
		CallableStatement stmSelect;
		String argumentos = "";
		String tipoDatosArgumentos;
		String nombreArgumentos;
		String [] arrayTipoDatosArgumentos = null;
		String [] arrayNombreArgumentos = null;
		JSONObject objJSONReglaParams = null;
		try {
			// TODO OBTIENE LOS PARAMETROS PARA LA EJECUCION DE LA FUNCION EN FORMATO JSON
			objJSONReglaParams = new JSONArray(inJSONRegla.getString("CRTSE_CAMPO_EVALUACION")).getJSONObject(0);

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String respuesta = "false";
		int contador = 0;
		tipoDatosArgumentos = inReglaMetadados.getTIPODATOARGUMENTOS().substring(1,inReglaMetadados.getTIPODATOARGUMENTOS().length()-1);
		nombreArgumentos = inReglaMetadados.getNOMBREARGUMENTOS().substring(1,inReglaMetadados.getNOMBREARGUMENTOS().length()-1);
		if(!tipoDatosArgumentos.trim().isEmpty())
		{
			arrayTipoDatosArgumentos = tipoDatosArgumentos.split(",");
			arrayNombreArgumentos = nombreArgumentos.split(",");
		}

		for (int i = 1 ; i <= inReglaMetadados.getNUMEROARGUMENTOS(); i++)
		{
			argumentos += "?";
			if(i<inReglaMetadados.getNUMEROARGUMENTOS())
				argumentos += ",";
		}
		try {
			sqlSentencia = "{ ? = call SII."+ inJSONRegla.getString("CRVAL_FUNCION_VALIDACION") +"("+argumentos.trim()+ ") }";

			stmSelect = inConnection.prepareCall(sqlSentencia);

			if(inReglaMetadados.getTIPORESPUESTA().toUpperCase().equals(DataTypes.INTEGER.getValue()))
			{
				stmSelect.registerOutParameter(1, Types.INTEGER);	
			}
			if(inReglaMetadados.getTIPORESPUESTA().toUpperCase().equals(DataTypes.VARCHAR.getValue()) || inReglaMetadados.getTIPORESPUESTA().toUpperCase().equals(DataTypes.VARCHAR1.getValue()))
			{
				stmSelect.registerOutParameter(1, Types.VARCHAR);	
			}
			if(inReglaMetadados.getTIPORESPUESTA().toUpperCase().equals(DataTypes.BOOLEAN.getValue()))
			{
				stmSelect.registerOutParameter(1, Types.BOOLEAN);	
			}
			if(inReglaMetadados.getTIPORESPUESTA().toUpperCase().equals(DataTypes.NUMERIC.getValue()))
			{
				stmSelect.registerOutParameter(1, Types.NUMERIC);	
			}
			for (int i = 0 ; i+2 <= inReglaMetadados.getNUMEROARGUMENTOS()-1; i++)
			{
				tipoDatosArgumentos = ltrim(arrayTipoDatosArgumentos[i]);
				if(objJSONReglaParams.has(arrayNombreArgumentos[i].toUpperCase())) {
					if (tipoDatosArgumentos.toUpperCase().equals(DataTypes.INTEGER.getValue()))
						stmSelect.setInt(i + 2, objJSONReglaParams.getInt(arrayNombreArgumentos[i].toUpperCase()));

					if (tipoDatosArgumentos.toUpperCase().equals(DataTypes.VARCHAR.getValue()))
						stmSelect.setString(i + 2, objJSONReglaParams.getString(arrayNombreArgumentos[i].toUpperCase()));

					if (tipoDatosArgumentos.toUpperCase().equals(DataTypes.BOOLEAN.getValue()))
						stmSelect.setBoolean(i + 2, objJSONReglaParams.getBoolean(arrayNombreArgumentos[i].toUpperCase()));

					if (tipoDatosArgumentos.toUpperCase().equals(DataTypes.NUMERIC.getValue()))
						stmSelect.setBigDecimal(i + 2, new BigDecimal(objJSONReglaParams.getInt(arrayNombreArgumentos[i].toUpperCase())));

					if (tipoDatosArgumentos.toUpperCase().equals(DataTypes.TIMESTAMP.getValue())) {
						//stmSelect.setTimestamp(i+2, Timestamp.valueOf(objJSONReglaParams.getString(arrayNombreArgumentos[i].toUpperCase())));
						try {
							stmSelect.setTimestamp(i + 2, new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(objJSONReglaParams.getString(arrayNombreArgumentos[i].toUpperCase())).getTime()));
						} catch (ParseException e) {
							String strDate = objJSONReglaParams.getString(arrayNombreArgumentos[i].toUpperCase());
							SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date date;
							try {
								date = sdfSource.parse(strDate);
								SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
								strDate = sdfDestination.format(date);
								stmSelect.setTimestamp(i + 2, new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(strDate).getTime()));
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}else{
					stmSelect.setObject(i + 2,null);
				}
				contador = i+2;
			}
			stmSelect.setString(contador+1,inJSONRegla.getString("CRVAL_OPERADOR_COMPARADOR"));
			if(inJSONRegla.has("CGCNF_CODIGO") && !inJSONRegla.getString("CGCNF_CODIGO").trim().isEmpty() && !inJSONRegla.getString("CGCNF_CODIGO").equals("null")){
				stmSelect.setString(contador+2,inJSONRegla.getString("CGCNF_CODIGO"));
			}else{
				stmSelect.setString(contador+2,inJSONRegla.getString("CRVAL_VALOR_LIBRE"));
			}
			stmSelect.execute();
			respuesta = stmSelect.getString(1);
			stmSelect.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return outReglaMetadados;
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}
	
	/**
	 * @param source 
	 * @return
	 */
	public String ltrim(String source) {
		return source.replaceAll("^\\s+", "");
	}

	/**VALIDACION DE LA REGLA 
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inFunctionName NOMBRE DE LA FUNCION.
	 * @param inParams IDENTIFICATIVO UNICO DE PARAMETROS.
	 * @return VALIDACION.
	 */
	public String validar(Connection inConnection, String inFunctionName, JSONArray inParams){
		String outResult = "true";
		String tmpStmParams = "(";
		try {
			CallableStatement tmpStm = null;
			for(int i = 0; i < inParams.length(); i++){
				if(i>0) tmpStmParams += ",";
				tmpStmParams += "?";
			}
			tmpStmParams +=")";
			tmpStm = inConnection.prepareCall("{ ? = call SII."+inFunctionName+tmpStmParams+" }");
			tmpStm.registerOutParameter(1, Types.VARCHAR);
			for(int i = 0; i < inParams.length(); i++)
				tmpStm.setString(i+2, inParams.getString(i));
			tmpStm.execute();
			outResult = tmpStm.getString(1);
			tmpStm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			outResult = e.getMessage();
		} catch (JSONException e) {
			outResult = e.getMessage();
			e.printStackTrace();
		}
		return outResult;
	}
}