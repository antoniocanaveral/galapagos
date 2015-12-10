package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
 * CLASE Cgg_ger_indicador_encargado
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_ger_indicador_encargado.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_ger_indicador_encargado implements Serializable{
	private static final long serialVersionUID = 22037001;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_ger_indicador_encargado.
	 */
	private com.besixplus.sii.objects.Cgg_ger_indicador_encargado myCgg_ger_indicador_encargado = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_encargado.
	 */
	public Cgg_ger_indicador_encargado(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_encargado.
	 * @param inCgg_ger_indicador_encargado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_ger_indicador_encargado.
	 */
	public Cgg_ger_indicador_encargado(
			com.besixplus.sii.objects.Cgg_ger_indicador_encargado inCgg_ger_indicador_encargado
	){
		this.setCgg_ger_indicador_encargado(inCgg_ger_indicador_encargado);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_ger_indicador_encargado.
	 * @param inCgg_ger_indicador_encargado OBJETO Cgg_ger_indicador_encargado.
	 * @return void
	 */
	public void setCgg_ger_indicador_encargado(com.besixplus.sii.objects.Cgg_ger_indicador_encargado inCgg_ger_indicador_encargado){
		this.myCgg_ger_indicador_encargado = inCgg_ger_indicador_encargado;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_ger_indicador_encargado.
	 * @return Cgg_ger_indicador_encargado OBJETO Cgg_ger_indicador_encargado.
	 */
	public com.besixplus.sii.objects.Cgg_ger_indicador_encargado getCgg_ger_indicador_encargado(){
		return this.myCgg_ger_indicador_encargado;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_ger_indicador_encargado.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_ger_indicador_encargado().getCGGIE_CODIGO());
			stmInsert.setString(3, this.getCgg_ger_indicador_encargado().getCCTN_CODIGO());
			stmInsert.setString(4, this.getCgg_ger_indicador_encargado().getCUSU_CODIGO());
			stmInsert.setString(5, this.getCgg_ger_indicador_encargado().getCGGIN_CODIGO());
			stmInsert.setBoolean(6, this.getCgg_ger_indicador_encargado().getCGGIE_ESTADO());
			stmInsert.setString(7, this.getCgg_ger_indicador_encargado().getCGGIE_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_ger_indicador_encargado().setCGGIE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> outCgg_ger_indicador_encargado = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador_encargado tmpCgg_ger_indicador_encargado = new com.besixplus.sii.objects.Cgg_ger_indicador_encargado();
				tmpCgg_ger_indicador_encargado.setCGGIE_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_encargado.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_indicador_encargado.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador_encargado.setCGGIN_CODIGO(results.getString(4));
				tmpCgg_ger_indicador_encargado.setCGGIE_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador_encargado.add(tmpCgg_ger_indicador_encargado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> outCgg_ger_indicador_encargado = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_ger_indicador_encargado tmpCgg_ger_indicador_encargado = new com.besixplus.sii.objects.Cgg_ger_indicador_encargado();
				tmpCgg_ger_indicador_encargado.setCGGIE_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_encargado.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_indicador_encargado.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador_encargado.setCGGIN_CODIGO(results.getString(4));
				tmpCgg_ger_indicador_encargado.setCGGIE_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador_encargado.add(tmpCgg_ger_indicador_encargado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_ger_indicador_encargado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_ger_indicador_encargado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_ger_indicador_encargado.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_COUNT(?) }");
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_ger_indicador_encargado.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_ger_indicador_encargado().getCGGIE_CODIGO());
			stmUpdate.setString(2, this.getCgg_ger_indicador_encargado().getCCTN_CODIGO());
			stmUpdate.setString(3, this.getCgg_ger_indicador_encargado().getCUSU_CODIGO());
			stmUpdate.setString(4, this.getCgg_ger_indicador_encargado().getCGGIN_CODIGO());
			stmUpdate.setBoolean(5, this.getCgg_ger_indicador_encargado().getCGGIE_ESTADO());
			stmUpdate.setString(6, this.getCgg_ger_indicador_encargado().getCGGIE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_ger_indicador_encargado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_ger_indicador_encargado select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador_encargado().getCGGIE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_ger_indicador_encargado().setCGGIE_CODIGO(results.getString(1));
				this.getCgg_ger_indicador_encargado().setCCTN_CODIGO(results.getString(2));
				this.getCgg_ger_indicador_encargado().setCUSU_CODIGO(results.getString(3));
				this.getCgg_ger_indicador_encargado().setCGGIN_CODIGO(results.getString(4));
				this.getCgg_ger_indicador_encargado().setCGGIE_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_ger_indicador_encargado();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCGGIE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCGGIE_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_ger_indicador.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_ger_indicador_encargado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> selectCGG_GER_INDICADOR(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> outCgg_ger_indicador_encargado = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_S_CGG_GER_INDICADOR(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador_encargado().getCGGIN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador_encargado tmpCgg_ger_indicador_encargado = new com.besixplus.sii.objects.Cgg_ger_indicador_encargado();
				tmpCgg_ger_indicador_encargado.setCGGIE_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_encargado.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_indicador_encargado.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador_encargado.setCGGIN_CODIGO(results.getString(4));
				tmpCgg_ger_indicador_encargado.setCGGIE_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador_encargado.add(tmpCgg_ger_indicador_encargado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_ger_indicador.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_GER_INDICADOR(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_D_CGG_GER_INDICADOR(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCGGIN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_DS_CGG_GER_INDICADOR(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCGGIN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_ger_indicador_encargado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> selectCGG_CANTON(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> outCgg_ger_indicador_encargado = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador_encargado().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador_encargado tmpCgg_ger_indicador_encargado = new com.besixplus.sii.objects.Cgg_ger_indicador_encargado();
				tmpCgg_ger_indicador_encargado.setCGGIE_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_encargado.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_indicador_encargado.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador_encargado.setCGGIN_CODIGO(results.getString(4));
				tmpCgg_ger_indicador_encargado.setCGGIE_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador_encargado.add(tmpCgg_ger_indicador_encargado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCCTN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_ger_indicador_encargado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> selectCGG_USUARIO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> outCgg_ger_indicador_encargado = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_ENCARGADO_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador_encargado().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador_encargado tmpCgg_ger_indicador_encargado = new com.besixplus.sii.objects.Cgg_ger_indicador_encargado();
				tmpCgg_ger_indicador_encargado.setCGGIE_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_encargado.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_indicador_encargado.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador_encargado.setCGGIN_CODIGO(results.getString(4));
				tmpCgg_ger_indicador_encargado.setCGGIE_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador_encargado.add(tmpCgg_ger_indicador_encargado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_ENCARGADO_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador_encargado().getCUSU_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_encargado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO.
	 * @param inCggin_codigo CODIGO DEL IDENTIFICADOR AL QUE PERTENECE.	
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_encargado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectCantonByIndicador(
			java.sql.Connection inConnection,
			String inUserName,
			String inCggin_codigo,
			String inCctn_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_ger_indicador_encargado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_CANTON_BY_INDI(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCggin_codigo);
			stmSelect.setString(4, inCctn_codigo);	
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_ger_indicador_encargado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_encargado;
	}

	/**
	 * OBTIENE LOS USUARIO RESPONSABLES DE ACTUALIZAR LOS VALORES DE LOS INDICADORES DEL MODULO GERENCIAL
	 * @param inConnection CONEXION DE LA BASE DE DATOS.
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> selectLeader(
			Connection inConnection
	){
		ArrayList<HashMap<String, Object>> outLeaders = new ArrayList<HashMap<String,Object>>();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_SELECT_LEADERS() }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outLeaders.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outLeaders;
	}
}