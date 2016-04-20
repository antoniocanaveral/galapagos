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
 * CLASE Cgg_res_expulsion
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_expulsion.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_expulsion implements Serializable{
	private static final long serialVersionUID = 1753641153;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_expulsion.
	 */
	private com.besixplus.sii.objects.Cgg_res_expulsion myCgg_res_expulsion = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_expulsion.
	 */
	public Cgg_res_expulsion(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_expulsion.
	 * @param inCgg_res_expulsion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_expulsion.
	 */
	public Cgg_res_expulsion(
			com.besixplus.sii.objects.Cgg_res_expulsion inCgg_res_expulsion
	){
		this.setCgg_res_expulsion(inCgg_res_expulsion);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_expulsion.
	 * @param inCgg_res_expulsion OBJETO Cgg_res_expulsion.
	 * @return void
	 */
	public void setCgg_res_expulsion(com.besixplus.sii.objects.Cgg_res_expulsion inCgg_res_expulsion){
		this.myCgg_res_expulsion = inCgg_res_expulsion;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_expulsion.
	 * @return Cgg_res_expulsion OBJETO Cgg_res_expulsion.
	 */
	public com.besixplus.sii.objects.Cgg_res_expulsion getCgg_res_expulsion(){
		return this.myCgg_res_expulsion;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_expulsion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_INSERT(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_expulsion().getCREXP_CODIGO());
			stmInsert.setString(3, this.getCgg_res_expulsion().getCRMOV_CODIGO());
			stmInsert.setString(4, this.getCgg_res_expulsion().getCRNOT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_expulsion().getCRPER_CODIGO());
			stmInsert.setString(6, this.getCgg_res_expulsion().getCROSG_CODIGO());
			stmInsert.setString(7, this.getCgg_res_expulsion().getCTFSL_CODIGO());
			stmInsert.setTimestamp(8, new java.sql.Timestamp(this.getCgg_res_expulsion().getCREXP_FECHA_EXPULSION().getTime()));
			stmInsert.setInt(9, this.getCgg_res_expulsion().getCREXP_TIPO_PAGO());
			stmInsert.setBigDecimal(10, this.getCgg_res_expulsion().getCREXP_VALOR_VUELO());
			stmInsert.setString(11, this.getCgg_res_expulsion().getCREXP_OBSERVACION());
			stmInsert.setBoolean(12, this.getCgg_res_expulsion().getCREXP_ESTADO());
			stmInsert.setString(13, this.getCgg_res_expulsion().getCREXP_USUARIO_INSERT());
			stmInsert.setString(14, this.getCgg_res_expulsion().getCREXP_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_expulsion().setCREXP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_expulsion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> outCgg_res_expulsion = new ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_expulsion tmpCgg_res_expulsion = new com.besixplus.sii.objects.Cgg_res_expulsion();
				tmpCgg_res_expulsion.setCREXP_CODIGO(results.getString(1));
				tmpCgg_res_expulsion.setCRMOV_CODIGO(results.getString(2));
				tmpCgg_res_expulsion.setCRNOT_CODIGO(results.getString(3));
				tmpCgg_res_expulsion.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_expulsion.setCROSG_CODIGO(results.getString(5));
				tmpCgg_res_expulsion.setCTFSL_CODIGO(results.getString(6));
				tmpCgg_res_expulsion.setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				tmpCgg_res_expulsion.setCREXP_TIPO_PAGO(results.getInt(8));
				tmpCgg_res_expulsion.setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				tmpCgg_res_expulsion.setCREXP_OBSERVACION(results.getString(10));
				tmpCgg_res_expulsion.setCREXP_ESTADO(results.getBoolean(11));
				outCgg_res_expulsion.add(tmpCgg_res_expulsion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_expulsion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_expulsion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_DESCRIP_SELECT(?,?,?,?,?,?) }");
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
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_expulsion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_expulsion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_UPDATE(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_expulsion().getCREXP_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_expulsion().getCRMOV_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_expulsion().getCRNOT_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_expulsion().getCRPER_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_expulsion().getCROSG_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_expulsion().getCTFSL_CODIGO());
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_res_expulsion().getCREXP_FECHA_EXPULSION().getTime()));
			stmUpdate.setInt(8, this.getCgg_res_expulsion().getCREXP_TIPO_PAGO());
			stmUpdate.setBigDecimal(9, this.getCgg_res_expulsion().getCREXP_VALOR_VUELO());
			stmUpdate.setString(10, this.getCgg_res_expulsion().getCREXP_OBSERVACION());
			stmUpdate.setBoolean(11, this.getCgg_res_expulsion().getCREXP_ESTADO());
			stmUpdate.setString(12, this.getCgg_res_expulsion().getCREXP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_expulsion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_expulsion select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_expulsion().getCREXP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_expulsion().setCREXP_CODIGO(results.getString(1));
				this.getCgg_res_expulsion().setCRMOV_CODIGO(results.getString(2));
				this.getCgg_res_expulsion().setCRNOT_CODIGO(results.getString(3));
				this.getCgg_res_expulsion().setCRPER_CODIGO(results.getString(4));
				this.getCgg_res_expulsion().setCROSG_CODIGO(results.getString(5));
				this.getCgg_res_expulsion().setCTFSL_CODIGO(results.getString(6));
				this.getCgg_res_expulsion().setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				this.getCgg_res_expulsion().setCREXP_TIPO_PAGO(results.getInt(8));
				this.getCgg_res_expulsion().setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				this.getCgg_res_expulsion().setCREXP_OBSERVACION(results.getString(10));
				this.getCgg_res_expulsion().setCREXP_ESTADO(results.getBoolean(11));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_expulsion();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_expulsion().getCREXP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_expulsion().getCREXP_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_movilidad.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_expulsion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> selectCGG_RES_MOVILIDAD(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> outCgg_res_expulsion = new ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_S_CGG_RES_MOVILIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_expulsion().getCRMOV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_expulsion tmpCgg_res_expulsion = new com.besixplus.sii.objects.Cgg_res_expulsion();
				tmpCgg_res_expulsion.setCREXP_CODIGO(results.getString(1));
				tmpCgg_res_expulsion.setCRMOV_CODIGO(results.getString(2));
				tmpCgg_res_expulsion.setCRNOT_CODIGO(results.getString(3));
				tmpCgg_res_expulsion.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_expulsion.setCROSG_CODIGO(results.getString(5));
				tmpCgg_res_expulsion.setCTFSL_CODIGO(results.getString(6));
				tmpCgg_res_expulsion.setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				tmpCgg_res_expulsion.setCREXP_TIPO_PAGO(results.getInt(8));
				tmpCgg_res_expulsion.setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				tmpCgg_res_expulsion.setCREXP_OBSERVACION(results.getString(10));
				tmpCgg_res_expulsion.setCREXP_ESTADO(results.getBoolean(11));
				outCgg_res_expulsion.add(tmpCgg_res_expulsion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_movilidad.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_MOVILIDAD(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_D_CGG_RES_MOVILIDAD(?) }");
			stmDelete.setString(1, this.getCgg_res_expulsion().getCRMOV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DS_CGG_RES_MOVILIDAD(?) }");
				stmDelete.setString(1, this.getCgg_res_expulsion().getCRMOV_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_forma_salida.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_expulsion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> selectCGG_TCT_FORMA_SALIDA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> outCgg_res_expulsion = new ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_S_CGG_TCT_FORMA_SALIDA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_expulsion().getCTFSL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_expulsion tmpCgg_res_expulsion = new com.besixplus.sii.objects.Cgg_res_expulsion();
				tmpCgg_res_expulsion.setCREXP_CODIGO(results.getString(1));
				tmpCgg_res_expulsion.setCRMOV_CODIGO(results.getString(2));
				tmpCgg_res_expulsion.setCRNOT_CODIGO(results.getString(3));
				tmpCgg_res_expulsion.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_expulsion.setCROSG_CODIGO(results.getString(5));
				tmpCgg_res_expulsion.setCTFSL_CODIGO(results.getString(6));
				tmpCgg_res_expulsion.setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				tmpCgg_res_expulsion.setCREXP_TIPO_PAGO(results.getInt(8));
				tmpCgg_res_expulsion.setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				tmpCgg_res_expulsion.setCREXP_OBSERVACION(results.getString(10));
				tmpCgg_res_expulsion.setCREXP_ESTADO(results.getBoolean(11));
				outCgg_res_expulsion.add(tmpCgg_res_expulsion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_forma_salida.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_TCT_FORMA_SALIDA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_D_CGG_TCT_FORMA_SALIDA(?) }");
			stmDelete.setString(1, this.getCgg_res_expulsion().getCTFSL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DS_CGG_TCT_FORMA_SALIDA(?) }");
				stmDelete.setString(1, this.getCgg_res_expulsion().getCTFSL_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_expulsion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> outCgg_res_expulsion = new ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_expulsion().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_expulsion tmpCgg_res_expulsion = new com.besixplus.sii.objects.Cgg_res_expulsion();
				tmpCgg_res_expulsion.setCREXP_CODIGO(results.getString(1));
				tmpCgg_res_expulsion.setCRMOV_CODIGO(results.getString(2));
				tmpCgg_res_expulsion.setCRNOT_CODIGO(results.getString(3));
				tmpCgg_res_expulsion.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_expulsion.setCROSG_CODIGO(results.getString(5));
				tmpCgg_res_expulsion.setCTFSL_CODIGO(results.getString(6));
				tmpCgg_res_expulsion.setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				tmpCgg_res_expulsion.setCREXP_TIPO_PAGO(results.getInt(8));
				tmpCgg_res_expulsion.setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				tmpCgg_res_expulsion.setCREXP_OBSERVACION(results.getString(10));
				tmpCgg_res_expulsion.setCREXP_ESTADO(results.getBoolean(11));
				outCgg_res_expulsion.add(tmpCgg_res_expulsion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_expulsion().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_expulsion().getCRPER_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_expulsion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> selectCGG_RES_NOTIFICACION(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> outCgg_res_expulsion = new ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_S_CGG_RES_NOTIFICACION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_expulsion().getCRNOT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_expulsion tmpCgg_res_expulsion = new com.besixplus.sii.objects.Cgg_res_expulsion();
				tmpCgg_res_expulsion.setCREXP_CODIGO(results.getString(1));
				tmpCgg_res_expulsion.setCRMOV_CODIGO(results.getString(2));
				tmpCgg_res_expulsion.setCRNOT_CODIGO(results.getString(3));
				tmpCgg_res_expulsion.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_expulsion.setCROSG_CODIGO(results.getString(5));
				tmpCgg_res_expulsion.setCTFSL_CODIGO(results.getString(6));
				tmpCgg_res_expulsion.setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				tmpCgg_res_expulsion.setCREXP_TIPO_PAGO(results.getInt(8));
				tmpCgg_res_expulsion.setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				tmpCgg_res_expulsion.setCREXP_OBSERVACION(results.getString(10));
				tmpCgg_res_expulsion.setCREXP_ESTADO(results.getBoolean(11));
				outCgg_res_expulsion.add(tmpCgg_res_expulsion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_notificacion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_NOTIFICACION(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_D_CGG_RES_NOTIFICACION(?) }");
			stmDelete.setString(1, this.getCgg_res_expulsion().getCRNOT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DS_CGG_RES_NOTIFICACION(?) }");
				stmDelete.setString(1, this.getCgg_res_expulsion().getCRNOT_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_oficial_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_expulsion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> selectCGG_RES_OFICIAL_SEGUIMIENTO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> outCgg_res_expulsion = new ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_S_CGG_RES_OFICIAL_SEGUIMIENTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_expulsion().getCROSG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_expulsion tmpCgg_res_expulsion = new com.besixplus.sii.objects.Cgg_res_expulsion();
				tmpCgg_res_expulsion.setCREXP_CODIGO(results.getString(1));
				tmpCgg_res_expulsion.setCRMOV_CODIGO(results.getString(2));
				tmpCgg_res_expulsion.setCRNOT_CODIGO(results.getString(3));
				tmpCgg_res_expulsion.setCRPER_CODIGO(results.getString(4));
				tmpCgg_res_expulsion.setCROSG_CODIGO(results.getString(5));
				tmpCgg_res_expulsion.setCTFSL_CODIGO(results.getString(6));
				tmpCgg_res_expulsion.setCREXP_FECHA_EXPULSION(results.getTimestamp(7));
				tmpCgg_res_expulsion.setCREXP_TIPO_PAGO(results.getInt(8));
				tmpCgg_res_expulsion.setCREXP_VALOR_VUELO(results.getBigDecimal(9));
				tmpCgg_res_expulsion.setCREXP_OBSERVACION(results.getString(10));
				tmpCgg_res_expulsion.setCREXP_ESTADO(results.getBoolean(11));
				outCgg_res_expulsion.add(tmpCgg_res_expulsion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_expulsion;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_expulsion DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_oficial_seguimiento.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_OFICIAL_SEGUIMIENTO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_D_CGG_RES_OFICIAL_SEGUIMIENTO(?) }");
			stmDelete.setString(1, this.getCgg_res_expulsion().getCROSG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_EXPULSION_DS_CGG_RES_OFICIAL_SEGUIMIENTO(?) }");
				stmDelete.setString(1, this.getCgg_res_expulsion().getCROSG_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_expulsion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_expulsion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersona(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_expulsion = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_EXPULSION_PERSONA_SELECT(?,?,?,?,?,?) }");
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
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectPersonaCount(
			java.sql.Connection inConnection,
			String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_EXPULSION_PERSONA_COUNT(?) }");
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