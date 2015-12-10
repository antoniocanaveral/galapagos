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
* CLASE Cgg_dhu_beca
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_beca.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_beca implements Serializable{
	private static final long serialVersionUID = 478893788;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_beca.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_beca myCgg_dhu_beca = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca.
	*/
	public Cgg_dhu_beca(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca.
	* @param inCgg_dhu_beca OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_beca.
	*/
	public Cgg_dhu_beca(
		com.besixplus.sii.objects.Cgg_dhu_beca inCgg_dhu_beca
	){
		this.setCgg_dhu_beca(inCgg_dhu_beca);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_beca.
	* @param inCgg_dhu_beca OBJETO Cgg_dhu_beca.
	* @return void
	*/
	public void setCgg_dhu_beca(com.besixplus.sii.objects.Cgg_dhu_beca inCgg_dhu_beca){
		this.myCgg_dhu_beca = inCgg_dhu_beca;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_beca.
	* @return Cgg_dhu_beca OBJETO Cgg_dhu_beca.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_beca getCgg_dhu_beca(){
		return this.myCgg_dhu_beca;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_INSERT(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint,?::smallint,?, ?,?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_beca().getCDBEC_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_beca().getCDTBC_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_beca().getCGESP_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_beca().getCGIED_CODIGO());
			stmInsert.setString(6, this.getCgg_dhu_beca().getCPAIS_CODIGO());
			stmInsert.setString(7, this.getCgg_dhu_beca().getCGTPR_CODIGO());
			stmInsert.setString(8, this.getCgg_dhu_beca().getCRPER_CODIGO());
			stmInsert.setString(9, this.getCgg_dhu_beca().getCGG_CRPER_CODIGO());
			stmInsert.setString(10, this.getCgg_dhu_beca().getCRPJR_CODIGO());
			stmInsert.setString(11, this.getCgg_dhu_beca().getCDBEC_NUMERO());
			stmInsert.setTimestamp(12, new java.sql.Timestamp(this.getCgg_dhu_beca().getCDBEC_FECHA_INGRESO().getTime()));
			stmInsert.setString(13, this.getCgg_dhu_beca().getCDBEC_FUNCIONARIO());
			stmInsert.setString(14, this.getCgg_dhu_beca().getCDBEC_NUMERO_APROBACION());
			stmInsert.setTimestamp(15, new java.sql.Timestamp(this.getCgg_dhu_beca().getCDBEC_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(16, new java.sql.Timestamp(this.getCgg_dhu_beca().getCDBEC_FECHA_FIN().getTime()));
			stmInsert.setString(17, this.getCgg_dhu_beca().getCDBEC_NUMERO_CONVENIO());
			stmInsert.setString(18, this.getCgg_dhu_beca().getCDBEC_VSALIDA_ORIGEN());
			stmInsert.setString(19, this.getCgg_dhu_beca().getCDBEC_VSALIDA_DESTINO());
			stmInsert.setBigDecimal(20, this.getCgg_dhu_beca().getCDBEC_VSALIDA_VALOR());
			stmInsert.setString(21, this.getCgg_dhu_beca().getCDBEC_VRETORNO_ORIGEN());
			stmInsert.setString(22, this.getCgg_dhu_beca().getCDBEC_VRETORNO_DESTINO());
			stmInsert.setBigDecimal(23, this.getCgg_dhu_beca().getCDBEC_VRETORNO_VALOR());
			stmInsert.setString(24, this.getCgg_dhu_beca().getCDBEC_CARRERA());
			stmInsert.setInt(25, this.getCgg_dhu_beca().getCDBEC_TIPO_CICLO());
			stmInsert.setInt(26, this.getCgg_dhu_beca().getCDBEC_TOTAL_CICLOS());
			stmInsert.setString(27, this.getCgg_dhu_beca().getCDBEC_NUMERO_CUENTO());
			stmInsert.setString(28, this.getCgg_dhu_beca().getCDBEC_NUMERO_APROBACION_MODIFICATORIO());
			stmInsert.setString(29, this.getCgg_dhu_beca().getCDBEC_NUMERO_CONTRATO_MODIFICATORIO());
			stmInsert.setString(30, this.getCgg_dhu_beca().getCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO());
			stmInsert.setString(31, this.getCgg_dhu_beca().getCDBEC_OBSERVACION());
			stmInsert.setBoolean(32, this.getCgg_dhu_beca().getCDBEC_TITULO_ENTREGADO());
			stmInsert.setBoolean(33, this.getCgg_dhu_beca().getCDBEC_BECA_DEVENGADA());
			stmInsert.setInt(34, this.getCgg_dhu_beca().getCDBEC_ESTADO_APROBACION());
			stmInsert.setBigDecimal(35, this.getCgg_dhu_beca().getCDBEC_VALOR_REEMBOLSO());
			stmInsert.setBoolean(36, this.getCgg_dhu_beca().getCDBEC_ESTADO());
			stmInsert.setString(37, this.getCgg_dhu_beca().getCDBEC_USUARIO_INSERT());
			stmInsert.setString(38, this.getCgg_dhu_beca().getCDBEC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_beca().setCDBEC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_beca.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint,?::smallint,?, ?,?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_beca().getCDBEC_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_beca().getCDTBC_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_beca().getCGESP_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_beca().getCGIED_CODIGO());
			stmUpdate.setString(5, this.getCgg_dhu_beca().getCPAIS_CODIGO());
			stmUpdate.setString(6, this.getCgg_dhu_beca().getCGTPR_CODIGO());
			stmUpdate.setString(7, this.getCgg_dhu_beca().getCRPER_CODIGO());
			stmUpdate.setString(8, this.getCgg_dhu_beca().getCGG_CRPER_CODIGO());
			stmUpdate.setString(9, this.getCgg_dhu_beca().getCRPJR_CODIGO());
			stmUpdate.setString(10, this.getCgg_dhu_beca().getCDBEC_NUMERO());
			stmUpdate.setTimestamp(11, new java.sql.Timestamp(this.getCgg_dhu_beca().getCDBEC_FECHA_INGRESO().getTime()));
			stmUpdate.setString(12, this.getCgg_dhu_beca().getCDBEC_FUNCIONARIO());
			stmUpdate.setString(13, this.getCgg_dhu_beca().getCDBEC_NUMERO_APROBACION());
			stmUpdate.setTimestamp(14, new java.sql.Timestamp(this.getCgg_dhu_beca().getCDBEC_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(15, new java.sql.Timestamp(this.getCgg_dhu_beca().getCDBEC_FECHA_FIN().getTime()));
			stmUpdate.setString(16, this.getCgg_dhu_beca().getCDBEC_NUMERO_CONVENIO());
			stmUpdate.setString(17, this.getCgg_dhu_beca().getCDBEC_VSALIDA_ORIGEN());
			stmUpdate.setString(18, this.getCgg_dhu_beca().getCDBEC_VSALIDA_DESTINO());
			stmUpdate.setBigDecimal(19, this.getCgg_dhu_beca().getCDBEC_VSALIDA_VALOR());
			stmUpdate.setString(20, this.getCgg_dhu_beca().getCDBEC_VRETORNO_ORIGEN());
			stmUpdate.setString(21, this.getCgg_dhu_beca().getCDBEC_VRETORNO_DESTINO());
			stmUpdate.setBigDecimal(22, this.getCgg_dhu_beca().getCDBEC_VRETORNO_VALOR());
			stmUpdate.setString(23, this.getCgg_dhu_beca().getCDBEC_CARRERA());
			stmUpdate.setInt(24, this.getCgg_dhu_beca().getCDBEC_TIPO_CICLO());
			stmUpdate.setInt(25, this.getCgg_dhu_beca().getCDBEC_TOTAL_CICLOS());
			stmUpdate.setString(26, this.getCgg_dhu_beca().getCDBEC_NUMERO_CUENTO());
			stmUpdate.setString(27, this.getCgg_dhu_beca().getCDBEC_NUMERO_APROBACION_MODIFICATORIO());
			stmUpdate.setString(28, this.getCgg_dhu_beca().getCDBEC_NUMERO_CONTRATO_MODIFICATORIO());
			stmUpdate.setString(29, this.getCgg_dhu_beca().getCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO());
			stmUpdate.setString(30, this.getCgg_dhu_beca().getCDBEC_OBSERVACION());
			stmUpdate.setBoolean(31, this.getCgg_dhu_beca().getCDBEC_TITULO_ENTREGADO());
			stmUpdate.setBoolean(32, this.getCgg_dhu_beca().getCDBEC_BECA_DEVENGADA());
			stmUpdate.setInt(33, this.getCgg_dhu_beca().getCDBEC_ESTADO_APROBACION());
			stmUpdate.setBigDecimal(34, this.getCgg_dhu_beca().getCDBEC_VALOR_REEMBOLSO());
			stmUpdate.setBoolean(35, this.getCgg_dhu_beca().getCDBEC_ESTADO());
			stmUpdate.setString(36, this.getCgg_dhu_beca().getCDBEC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_beca select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCDBEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_beca().setCDBEC_CODIGO(results.getString(1));
				this.getCgg_dhu_beca().setCDTBC_CODIGO(results.getString(2));
				this.getCgg_dhu_beca().setCGESP_CODIGO(results.getString(3));
				this.getCgg_dhu_beca().setCGIED_CODIGO(results.getString(4));
				this.getCgg_dhu_beca().setCPAIS_CODIGO(results.getString(5));
				this.getCgg_dhu_beca().setCGTPR_CODIGO(results.getString(6));
				this.getCgg_dhu_beca().setCRPER_CODIGO(results.getString(7));
				this.getCgg_dhu_beca().setCGG_CRPER_CODIGO(results.getString(8));
				this.getCgg_dhu_beca().setCRPJR_CODIGO(results.getString(9));
				this.getCgg_dhu_beca().setCDBEC_NUMERO(results.getString(10));
				this.getCgg_dhu_beca().setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				this.getCgg_dhu_beca().setCDBEC_FUNCIONARIO(results.getString(12));
				this.getCgg_dhu_beca().setCDBEC_NUMERO_APROBACION(results.getString(13));
				this.getCgg_dhu_beca().setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				this.getCgg_dhu_beca().setCDBEC_FECHA_FIN(results.getTimestamp(15));
				this.getCgg_dhu_beca().setCDBEC_NUMERO_CONVENIO(results.getString(16));
				this.getCgg_dhu_beca().setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				this.getCgg_dhu_beca().setCDBEC_VSALIDA_DESTINO(results.getString(18));
				this.getCgg_dhu_beca().setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				this.getCgg_dhu_beca().setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				this.getCgg_dhu_beca().setCDBEC_VRETORNO_DESTINO(results.getString(21));
				this.getCgg_dhu_beca().setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				this.getCgg_dhu_beca().setCDBEC_CARRERA(results.getString(23));
				this.getCgg_dhu_beca().setCDBEC_TIPO_CICLO(results.getInt(24));
				this.getCgg_dhu_beca().setCDBEC_TOTAL_CICLOS(results.getInt(25));
				this.getCgg_dhu_beca().setCDBEC_NUMERO_CUENTO(results.getString(26));
				this.getCgg_dhu_beca().setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				this.getCgg_dhu_beca().setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				this.getCgg_dhu_beca().setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				this.getCgg_dhu_beca().setCDBEC_OBSERVACION(results.getString(30));
				this.getCgg_dhu_beca().setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				this.getCgg_dhu_beca().setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				this.getCgg_dhu_beca().setCDBEC_ESTADO_APROBACION(results.getInt(33));
				this.getCgg_dhu_beca().setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				this.getCgg_dhu_beca().setCDBEC_ESTADO(results.getBoolean(35));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_beca();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SQLException 
	*/
	public String delete(
		java.sql.Connection inConnection
	)throws SQLException{
		String outResult = "true";
	
			//try{
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCDBEC_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			/*}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}*/
		//}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_especialidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_ESPECIALIDAD(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_ESPECIALIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCGESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_especialidad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_ESPECIALIDAD(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_ESPECIALIDAD(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCGESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_ESPECIALIDAD(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCGESP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_INSTITUCION_EDUCATIVA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_INSTITUCION_EDUCATIVA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCGIED_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_INSTITUCION_EDUCATIVA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_INSTITUCION_EDUCATIVA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCGIED_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_INSTITUCION_EDUCATIVA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCGIED_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_pais.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_PAIS(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_PAIS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCPAIS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_pais.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_PAIS(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_PAIS(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCPAIS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_PAIS(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCPAIS_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_entidad_financiera.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_RES_ENTIDAD_FINANCIERA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_RES_ENTIDAD_FINANCIERA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_entidad_financiera.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_ENTIDAD_FINANCIERA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_RES_ENTIDAD_FINANCIERA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_RES_ENTIDAD_FINANCIERA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCRPJR_CODIGO());
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
<<<<<<< .mine
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_TITULO_PROFESIONAL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_TITULO_PROFESIONAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCGTPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_titulo_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TITULO_PROFESIONAL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_TITULO_PROFESIONAL(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCGTPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_TITULO_PROFESIONAL(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCGTPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_DHU_TIPO_BECA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_DHU_TIPO_BECA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCDTBC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_TIPO_BECA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_DHU_TIPO_BECA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCDTBC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_DHU_TIPO_BECA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCDTBC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> outCgg_dhu_beca = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_S_CGG_RES_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca().getCRPER_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_beca().getCGG_CRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca tmpCgg_dhu_beca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				tmpCgg_dhu_beca.setCDBEC_CODIGO(results.getString(1));
				tmpCgg_dhu_beca.setCDTBC_CODIGO(results.getString(2));
				tmpCgg_dhu_beca.setCGESP_CODIGO(results.getString(3));
				tmpCgg_dhu_beca.setCGIED_CODIGO(results.getString(4));
				tmpCgg_dhu_beca.setCPAIS_CODIGO(results.getString(5));
				tmpCgg_dhu_beca.setCGTPR_CODIGO(results.getString(6));
				tmpCgg_dhu_beca.setCRPER_CODIGO(results.getString(7));
				tmpCgg_dhu_beca.setCGG_CRPER_CODIGO(results.getString(8));
				tmpCgg_dhu_beca.setCRPJR_CODIGO(results.getString(9));
				tmpCgg_dhu_beca.setCDBEC_NUMERO(results.getString(10));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INGRESO(results.getTimestamp(11));
				tmpCgg_dhu_beca.setCDBEC_FUNCIONARIO(results.getString(12));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION(results.getString(13));
				tmpCgg_dhu_beca.setCDBEC_FECHA_INICIO(results.getTimestamp(14));
				tmpCgg_dhu_beca.setCDBEC_FECHA_FIN(results.getTimestamp(15));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONVENIO(results.getString(16));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_ORIGEN(results.getString(17));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_DESTINO(results.getString(18));
				tmpCgg_dhu_beca.setCDBEC_VSALIDA_VALOR(results.getBigDecimal(19));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_ORIGEN(results.getString(20));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_DESTINO(results.getString(21));
				tmpCgg_dhu_beca.setCDBEC_VRETORNO_VALOR(results.getBigDecimal(22));
				tmpCgg_dhu_beca.setCDBEC_CARRERA(results.getString(23));
				tmpCgg_dhu_beca.setCDBEC_TIPO_CICLO(results.getInt(24));
				tmpCgg_dhu_beca.setCDBEC_TOTAL_CICLOS(results.getInt(25));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CUENTO(results.getString(26));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(results.getString(27));
				tmpCgg_dhu_beca.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(results.getString(28));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(results.getString(29));
				tmpCgg_dhu_beca.setCDBEC_OBSERVACION(results.getString(30));
				tmpCgg_dhu_beca.setCDBEC_TITULO_ENTREGADO(results.getBoolean(31));
				tmpCgg_dhu_beca.setCDBEC_BECA_DEVENGADA(results.getBoolean(32));
				tmpCgg_dhu_beca.setCDBEC_ESTADO_APROBACION(results.getInt(33));
				tmpCgg_dhu_beca.setCDBEC_VALOR_REEMBOLSO(results.getBigDecimal(34));
				tmpCgg_dhu_beca.setCDBEC_ESTADO(results.getBoolean(35));
				outCgg_dhu_beca.add(tmpCgg_dhu_beca);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_D_CGG_RES_PERSONA(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca().getCRPER_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_beca().getCGG_CRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_DS_CGG_RES_PERSONA(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca().getCRPER_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_beca().getCGG_CRPER_CODIGO());
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

	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona,cgg_usuario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPersonaFuncionario(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca_funcionario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_funcionario(?,?,?,?,?,?) }");
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
				outCgg_dhu_beca_funcionario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_funcionario;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectPersonaFuncionarioCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_FUNCIONARIO_COUNT(?) }");
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
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_dhu_beca
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static String geneNumBeca(
		java.sql.Connection inConnection
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_BECA() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
	
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectPersonaBecaCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrtst_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_PERFIL_PROF_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCrtst_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}	
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_persona_respresentante DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectPersonaRepresentanteBeca(
		java.sql.Connection inConnection,
		String inCrper_num_doc_identific
		//String inCrtst_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_resprensentante = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PERSONA_REPRESENTANTE(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inCrper_num_doc_identific);
				//stmSelect.setString(2, inCrtst_codigo);
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_resprensentante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_resprensentante;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona,cgg_dhu_informacion_represntante,cgg_res_residencia DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectRepresentanteBeca(
		java.sql.Connection inConnection,
		String inCdbec_codigo
		//String inCrtst_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_resprensentante = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_beca_representante(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCdbec_codigo);
				//stmSelect.setString(2, inCrtst_codigo);
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_resprensentante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_resprensentante;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectBeca(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_beca_edit_select(?,?,?,?,?,?) }");
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
				outCgg_dhu_beca.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_persona DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectPersonaResidenteBeca(
		java.sql.Connection inConnection,
		String inCrper_num_doc_identific
	
		
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_residnte_permanente = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_beca(?) }");
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
				outCgg_dhu_residnte_permanente.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_residnte_permanente;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectBecaResidentePermanente(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_persona_beca_select(?,?,?,?,?,?) }");
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
				outCgg_dhu_beca.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectbecapersonaCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )			
			inKeyword = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_persona_beca_select_count(?) }");
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
	public String updateEstadoAprobacionBeca(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.f_cgg_dhu_beca_estado_update( ?,?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_beca().getCDBEC_CODIGO());
			stmUpdate.setInt(2, this.getCgg_dhu_beca().getCDBEC_ESTADO_APROBACION());		
			stmUpdate.setString(3, this.getCgg_dhu_beca().getCDBEC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
}