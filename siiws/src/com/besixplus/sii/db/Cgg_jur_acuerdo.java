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
 * CLASE Cgg_jur_acuerdo
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_acuerdo.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_jur_acuerdo implements Serializable{
	private static final long serialVersionUID = 1507245733;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_acuerdo.
	 */
	private com.besixplus.sii.objects.Cgg_jur_acuerdo myCgg_jur_acuerdo = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_acuerdo.
	 */
	public Cgg_jur_acuerdo(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_jur_acuerdo.
	 * @param inCgg_jur_acuerdo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_acuerdo.
	 */
	public Cgg_jur_acuerdo(
			com.besixplus.sii.objects.Cgg_jur_acuerdo inCgg_jur_acuerdo
	){
		this.setCgg_jur_acuerdo(inCgg_jur_acuerdo);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_acuerdo.
	 * @param inCgg_jur_acuerdo OBJETO Cgg_jur_acuerdo.
	 * @return void
	 */
	public void setCgg_jur_acuerdo(com.besixplus.sii.objects.Cgg_jur_acuerdo inCgg_jur_acuerdo){
		this.myCgg_jur_acuerdo = inCgg_jur_acuerdo;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_acuerdo.
	 * @return Cgg_jur_acuerdo OBJETO Cgg_jur_acuerdo.
	 */
	public com.besixplus.sii.objects.Cgg_jur_acuerdo getCgg_jur_acuerdo(){
		return this.myCgg_jur_acuerdo;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_acuerdo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_acuerdo().getCJACU_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_acuerdo().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_acuerdo().getCRPJR_CODIGO());
			stmInsert.setString(5, this.getCgg_jur_acuerdo().getCRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_jur_acuerdo().getCGG_CUSU_CODIGO());
			stmInsert.setString(7, this.getCgg_jur_acuerdo().getCSCTP_CODIGO());
			stmInsert.setString(8, this.getCgg_jur_acuerdo().getCJTPR_CODIGO());
			stmInsert.setString(9, this.getCgg_jur_acuerdo().getCAINF_CODIGO());
			stmInsert.setBigDecimal(10, this.getCgg_jur_acuerdo().getCJACU_ANIO());
			stmInsert.setString(11, this.getCgg_jur_acuerdo().getCJACU_NUMERO());
			stmInsert.setString(12, this.getCgg_jur_acuerdo().getCJACU_OBJETO());
			stmInsert.setString(13, this.getCgg_jur_acuerdo().getCJACU_DESCRIPCION());
			stmInsert.setString(14, this.getCgg_jur_acuerdo().getCJACU_JURISDICCION_AMBITO());
			stmInsert.setTimestamp(15, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_SUSCRIPCION().getTime()));
			stmInsert.setString(16, this.getCgg_jur_acuerdo().getCJACU_INSTITUCION_FIRMA());
			stmInsert.setTimestamp(17, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_INICIO().getTime()));
			stmInsert.setString(18, this.getCgg_jur_acuerdo().getCJACU_RESPONSABLE());
			stmInsert.setString(19, this.getCgg_jur_acuerdo().getCJACU_PARTIDA_PRESUPUESTARIA());
			stmInsert.setBigDecimal(20, this.getCgg_jur_acuerdo().getCJACU_COSTO());
			stmInsert.setInt(21, this.getCgg_jur_acuerdo().getCJACU_TIEMPO());
			stmInsert.setInt(22, this.getCgg_jur_acuerdo().getCJACU_ESTADO_EJECUCION());
			stmInsert.setTimestamp(23, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_FINALIZACION().getTime()));
			stmInsert.setString(24, this.getCgg_jur_acuerdo().getCJACU_OBSERVACION());
			stmInsert.setInt(25, this.getCgg_jur_acuerdo().getCJACU_TIPO());
			stmInsert.setInt(26, this.getCgg_jur_acuerdo().getCJACU_TIPO_PERSONA());
			stmInsert.setBoolean(27, this.getCgg_jur_acuerdo().getCJACU_ADENDUM());
			stmInsert.setTimestamp(28, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_ADENDUM().getTime()));
			stmInsert.setString(29, this.getCgg_jur_acuerdo().getCJACU_OBJETO_ADENDUM());
			stmInsert.setBoolean(30, this.getCgg_jur_acuerdo().getCJACU_ESTADO());
			stmInsert.setString(31, this.getCgg_jur_acuerdo().getCJACU_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_jur_acuerdo().setCJACU_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_acuerdo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_COUNT(?) }");
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_acuerdo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_acuerdo().getCJACU_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_acuerdo().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_acuerdo().getCRPJR_CODIGO());
			stmUpdate.setString(4, this.getCgg_jur_acuerdo().getCRPER_CODIGO());
			stmUpdate.setString(5, this.getCgg_jur_acuerdo().getCGG_CUSU_CODIGO());
			stmUpdate.setString(6, this.getCgg_jur_acuerdo().getCSCTP_CODIGO());
			stmUpdate.setString(7, this.getCgg_jur_acuerdo().getCJTPR_CODIGO());
			stmUpdate.setString(8, this.getCgg_jur_acuerdo().getCAINF_CODIGO());
			stmUpdate.setBigDecimal(9, this.getCgg_jur_acuerdo().getCJACU_ANIO());
			stmUpdate.setString(10, this.getCgg_jur_acuerdo().getCJACU_NUMERO());
			stmUpdate.setString(11, this.getCgg_jur_acuerdo().getCJACU_OBJETO());
			stmUpdate.setString(12, this.getCgg_jur_acuerdo().getCJACU_DESCRIPCION());
			stmUpdate.setString(13, this.getCgg_jur_acuerdo().getCJACU_JURISDICCION_AMBITO());
			stmUpdate.setTimestamp(14, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_SUSCRIPCION().getTime()));
			stmUpdate.setString(15, this.getCgg_jur_acuerdo().getCJACU_INSTITUCION_FIRMA());
			stmUpdate.setTimestamp(16, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_INICIO().getTime()));
			stmUpdate.setString(17, this.getCgg_jur_acuerdo().getCJACU_RESPONSABLE());
			stmUpdate.setString(18, this.getCgg_jur_acuerdo().getCJACU_PARTIDA_PRESUPUESTARIA());
			stmUpdate.setBigDecimal(19, this.getCgg_jur_acuerdo().getCJACU_COSTO());
			stmUpdate.setInt(20, this.getCgg_jur_acuerdo().getCJACU_TIEMPO());
			stmUpdate.setInt(21, this.getCgg_jur_acuerdo().getCJACU_ESTADO_EJECUCION());
			stmUpdate.setTimestamp(22, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_FINALIZACION().getTime()));
			stmUpdate.setString(23, this.getCgg_jur_acuerdo().getCJACU_OBSERVACION());
			stmUpdate.setInt(24, this.getCgg_jur_acuerdo().getCJACU_TIPO());
			stmUpdate.setInt(25, this.getCgg_jur_acuerdo().getCJACU_TIPO_PERSONA());
			stmUpdate.setBoolean(26, this.getCgg_jur_acuerdo().getCJACU_ADENDUM());
			stmUpdate.setTimestamp(27, new java.sql.Timestamp(this.getCgg_jur_acuerdo().getCJACU_FECHA_ADENDUM().getTime()));
			stmUpdate.setString(28, this.getCgg_jur_acuerdo().getCJACU_OBJETO_ADENDUM());
			stmUpdate.setBoolean(29, this.getCgg_jur_acuerdo().getCJACU_ESTADO());
			stmUpdate.setString(30, this.getCgg_jur_acuerdo().getCJACU_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_jur_acuerdo select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCJACU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_acuerdo().setCJACU_CODIGO(results.getString(1));
				this.getCgg_jur_acuerdo().setCUSU_CODIGO(results.getString(2));
				this.getCgg_jur_acuerdo().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_jur_acuerdo().setCRPER_CODIGO(results.getString(4));
				this.getCgg_jur_acuerdo().setCGG_CUSU_CODIGO(results.getString(5));
				this.getCgg_jur_acuerdo().setCSCTP_CODIGO(results.getString(6));
				this.getCgg_jur_acuerdo().setCJTPR_CODIGO(results.getString(7));
				this.getCgg_jur_acuerdo().setCAINF_CODIGO(results.getString(8));
				this.getCgg_jur_acuerdo().setCJACU_ANIO(results.getBigDecimal(9));
				this.getCgg_jur_acuerdo().setCJACU_NUMERO(results.getString(10));
				this.getCgg_jur_acuerdo().setCJACU_OBJETO(results.getString(11));
				this.getCgg_jur_acuerdo().setCJACU_DESCRIPCION(results.getString(12));
				this.getCgg_jur_acuerdo().setCJACU_JURISDICCION_AMBITO(results.getString(13));
				this.getCgg_jur_acuerdo().setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				this.getCgg_jur_acuerdo().setCJACU_INSTITUCION_FIRMA(results.getString(15));
				this.getCgg_jur_acuerdo().setCJACU_FECHA_INICIO(results.getTimestamp(16));
				this.getCgg_jur_acuerdo().setCJACU_RESPONSABLE(results.getString(17));
				this.getCgg_jur_acuerdo().setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				this.getCgg_jur_acuerdo().setCJACU_COSTO(results.getBigDecimal(19));
				this.getCgg_jur_acuerdo().setCJACU_TIEMPO(results.getInt(20));
				this.getCgg_jur_acuerdo().setCJACU_ESTADO_EJECUCION(results.getInt(21));
				this.getCgg_jur_acuerdo().setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				this.getCgg_jur_acuerdo().setCJACU_OBSERVACION(results.getString(23));
				this.getCgg_jur_acuerdo().setCJACU_TIPO(results.getInt(24));
				this.getCgg_jur_acuerdo().setCJACU_TIPO_PERSONA(results.getInt(25));
				this.getCgg_jur_acuerdo().setCJACU_ADENDUM(results.getBoolean(26));
				this.getCgg_jur_acuerdo().setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				this.getCgg_jur_acuerdo().setCJACU_OBJETO_ADENDUM(results.getString(28));
				this.getCgg_jur_acuerdo().setCJACU_ESTADO(results.getBoolean(29));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_acuerdo();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCJACU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCJACU_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_tipo_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectCGG_JUR_TIPO_PROCESO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_S_CGG_JUR_TIPO_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCJTPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_tipo_proceso.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_JUR_TIPO_PROCESO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_D_CGG_JUR_TIPO_PROCESO(?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCJTPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DS_CGG_JUR_TIPO_PROCESO(?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCJTPR_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectCGG_USUARIO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCGG_CUSU_CODIGO());
			stmSelect.setString(3,this.getCgg_jur_acuerdo().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCGG_CUSU_CODIGO());
			stmDelete.setString(2, this.getCgg_jur_acuerdo().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCGG_CUSU_CODIGO());
				stmDelete.setString(2, this.getCgg_jur_acuerdo().getCUSU_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_area_influencia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectCGG_AREA_INFLUENCIA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_S_CGG_AREA_INFLUENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCAINF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_area_influencia.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_AREA_INFLUENCIA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_D_CGG_AREA_INFLUENCIA(?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCAINF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DS_CGG_AREA_INFLUENCIA(?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCAINF_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectCGG_SECTOR_PRODUCTIVO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_S_CGG_SECTOR_PRODUCTIVO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_D_CGG_SECTOR_PRODUCTIVO(?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DS_CGG_SECTOR_PRODUCTIVO(?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCSCTP_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectCGG_RES_PERSONA_JURIDICA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_PERSONA_JURIDICA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCRPJR_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_jur_acuerdo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> outCgg_jur_acuerdo = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_acuerdo().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_acuerdo tmpCgg_jur_acuerdo = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
				tmpCgg_jur_acuerdo.setCJACU_CODIGO(results.getString(1));
				tmpCgg_jur_acuerdo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_acuerdo.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_jur_acuerdo.setCRPER_CODIGO(results.getString(4));
				tmpCgg_jur_acuerdo.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_jur_acuerdo.setCSCTP_CODIGO(results.getString(6));
				tmpCgg_jur_acuerdo.setCJTPR_CODIGO(results.getString(7));
				tmpCgg_jur_acuerdo.setCAINF_CODIGO(results.getString(8));
				tmpCgg_jur_acuerdo.setCJACU_ANIO(results.getBigDecimal(9));
				tmpCgg_jur_acuerdo.setCJACU_NUMERO(results.getString(10));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO(results.getString(11));
				tmpCgg_jur_acuerdo.setCJACU_DESCRIPCION(results.getString(12));
				tmpCgg_jur_acuerdo.setCJACU_JURISDICCION_AMBITO(results.getString(13));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_SUSCRIPCION(results.getTimestamp(14));
				tmpCgg_jur_acuerdo.setCJACU_INSTITUCION_FIRMA(results.getString(15));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_INICIO(results.getTimestamp(16));
				tmpCgg_jur_acuerdo.setCJACU_RESPONSABLE(results.getString(17));
				tmpCgg_jur_acuerdo.setCJACU_PARTIDA_PRESUPUESTARIA(results.getString(18));
				tmpCgg_jur_acuerdo.setCJACU_COSTO(results.getBigDecimal(19));
				tmpCgg_jur_acuerdo.setCJACU_TIEMPO(results.getInt(20));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO_EJECUCION(results.getInt(21));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_FINALIZACION(results.getTimestamp(22));
				tmpCgg_jur_acuerdo.setCJACU_OBSERVACION(results.getString(23));
				tmpCgg_jur_acuerdo.setCJACU_TIPO(results.getInt(24));
				tmpCgg_jur_acuerdo.setCJACU_TIPO_PERSONA(results.getInt(25));
				tmpCgg_jur_acuerdo.setCJACU_ADENDUM(results.getBoolean(26));
				tmpCgg_jur_acuerdo.setCJACU_FECHA_ADENDUM(results.getTimestamp(27));
				tmpCgg_jur_acuerdo.setCJACU_OBJETO_ADENDUM(results.getString(28));
				tmpCgg_jur_acuerdo.setCJACU_ESTADO(results.getBoolean(29));
				outCgg_jur_acuerdo.add(tmpCgg_jur_acuerdo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_jur_acuerdo().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ACUERDO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_jur_acuerdo().getCRPER_CODIGO());
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
	 * GENERA EL NUMERO DEL ACUERDO DE LA TABLA Cgg_jur_acuerdo
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return valorContrato NUMERO GENERADO PARA CADA ACUERDO
	 * @throws SQLException 
	 */
	public static String numeroAcuerdoContrato(
			java.sql.Connection inConnection
	) throws SQLException{
		String valorContrato=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_CONTRATO() }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);						
		stmSelect.execute();
		valorContrato = stmSelect.getString(1);
		stmSelect.close();

		return valorContrato;
	}
	/**
	 * GENERA EL NUMERO DEL ACUERDO DE LA TABLA Cgg_jur_acuerdo
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return valorConvenio NUMERO GENERADO PARA CADA ACUERDO.
	 * @throws SQLException 
	 */
	public static String numeroAcuerdoConvenio(
			java.sql.Connection inConnection
	) throws SQLException{
		String valorConvenio=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_CONVENIO() }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);						
		stmSelect.execute();
		valorConvenio = stmSelect.getString(1);
		stmSelect.close();

		return valorConvenio;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String, Object>> selectAllAcuerdo(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_DESC_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_acuerdo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCountAcuerdo(		
			java.sql.Connection inConnection,
			String inUserName
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_DESC_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
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
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return NUMERO DE REGISTROS.
	 */
	public static int selectCountAcuerdo(
			java.sql.Connection inConnection,
			String inKeyword,
			String inUserName
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCountAcuerdo(inConnection,inUserName);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ACUERDO_DESC_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);			
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inUserName);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_acuerdo
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstado(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call F_CGG_JUR_HISTORIAL_ACUERDO_UPDATE_ACUERDO(?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_acuerdo().getCJACU_CODIGO());					
			stmUpdate.setInt(2, this.getCgg_jur_acuerdo().getCJACU_ESTADO_EJECUCION());	
			stmUpdate.setString(3, this.getCgg_jur_acuerdo().getCJACU_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_usuario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllUsuarioInterno(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_acuerdo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_INTERNO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_acuerdo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_acuerdo;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_acuerdo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCountUsuarioInterno(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_INTERNO_COUNT() }");
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
	public static int selectCountUsuarioInterno(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_INTERNO_COUNT(?) }");
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

}