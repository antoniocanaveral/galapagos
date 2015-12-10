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
* CLASE Cgg_ger_matriz
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_ger_matriz.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_ger_matriz implements Serializable{
	private static final long serialVersionUID = 833747891;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_ger_matriz.
	*/
	private com.besixplus.sii.objects.Cgg_ger_matriz myCgg_ger_matriz = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_matriz.
	*/
	public Cgg_ger_matriz(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_matriz.
	* @param inCgg_ger_matriz OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_ger_matriz.
	*/
	public Cgg_ger_matriz(
		com.besixplus.sii.objects.Cgg_ger_matriz inCgg_ger_matriz
	){
		this.setCgg_ger_matriz(inCgg_ger_matriz);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_ger_matriz.
	* @param inCgg_ger_matriz OBJETO Cgg_ger_matriz.
	* @return void
	*/
	public void setCgg_ger_matriz(com.besixplus.sii.objects.Cgg_ger_matriz inCgg_ger_matriz){
		this.myCgg_ger_matriz = inCgg_ger_matriz;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_ger_matriz.
	* @return Cgg_ger_matriz OBJETO Cgg_ger_matriz.
	*/
	public com.besixplus.sii.objects.Cgg_ger_matriz getCgg_ger_matriz(){
		return this.myCgg_ger_matriz;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_ger_matriz.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_ger_matriz().getCGGMA_CODIGO());
			stmInsert.setString(3, this.getCgg_ger_matriz().getCCTN_CODIGO());
			stmInsert.setString(4, this.getCgg_ger_matriz().getCGGIN_CODIGO());
			stmInsert.setString(5, this.getCgg_ger_matriz().getCUSU_CODIGO());
			stmInsert.setString(6, this.getCgg_ger_matriz().getCGGMA_MES());
			stmInsert.setString(7, this.getCgg_ger_matriz().getCGGMA_ANIO());
			stmInsert.setBigDecimal(8, this.getCgg_ger_matriz().getCGGMA_VALOR());
			stmInsert.setString(9, this.getCgg_ger_matriz().getCGGMA_DESCRIPCION());
			stmInsert.setBigDecimal(10, this.getCgg_ger_matriz().getCGGMA_ACTUALIZACIONES());
			stmInsert.setBoolean(11, this.getCgg_ger_matriz().getCGGMA_ESTADO());
			stmInsert.setString(12, this.getCgg_ger_matriz().getCGGMA_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_ger_matriz().setCGGMA_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_matriz.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> outCgg_ger_matriz = new ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_matriz tmpCgg_ger_matriz = new com.besixplus.sii.objects.Cgg_ger_matriz();
				tmpCgg_ger_matriz.setCGGMA_CODIGO(results.getString(1));
				tmpCgg_ger_matriz.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_matriz.setCGGIN_CODIGO(results.getString(3));
				tmpCgg_ger_matriz.setCUSU_CODIGO(results.getString(4));
				tmpCgg_ger_matriz.setCGGMA_MES(results.getString(5));
				tmpCgg_ger_matriz.setCGGMA_ANIO(results.getString(6));
				tmpCgg_ger_matriz.setCGGMA_VALOR(results.getBigDecimal(7));
				tmpCgg_ger_matriz.setCGGMA_DESCRIPCION(results.getString(8));
				tmpCgg_ger_matriz.setCGGMA_ACTUALIZACIONES(results.getBigDecimal(9));
				tmpCgg_ger_matriz.setCGGMA_ESTADO(results.getBoolean(9));
				outCgg_ger_matriz.add(tmpCgg_ger_matriz);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_matriz;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_matriz QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> outCgg_ger_matriz = new ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_ger_matriz tmpCgg_ger_matriz = new com.besixplus.sii.objects.Cgg_ger_matriz();
				tmpCgg_ger_matriz.setCGGMA_CODIGO(results.getString(1));
				tmpCgg_ger_matriz.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_matriz.setCGGIN_CODIGO(results.getString(3));
				tmpCgg_ger_matriz.setCUSU_CODIGO(results.getString(4));
				tmpCgg_ger_matriz.setCGGMA_MES(results.getString(5));
				tmpCgg_ger_matriz.setCGGMA_ANIO(results.getString(6));
				tmpCgg_ger_matriz.setCGGMA_VALOR(results.getBigDecimal(7));
				tmpCgg_ger_matriz.setCGGMA_DESCRIPCION(results.getString(8));
				tmpCgg_ger_matriz.setCGGMA_ACTUALIZACIONES(results.getBigDecimal(9));
				tmpCgg_ger_matriz.setCGGMA_ESTADO(results.getBoolean(10));
				outCgg_ger_matriz.add(tmpCgg_ger_matriz);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_matriz;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_matriz QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_ger_matriz = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_SELECT(?,?,?,?,?,?) }");
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
				outCgg_ger_matriz.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_matriz;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_ger_matriz.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_ger_matriz.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
			stmUpdate.setString(1, this.getCgg_ger_matriz().getCGGMA_CODIGO());
			stmUpdate.setString(2, this.getCgg_ger_matriz().getCCTN_CODIGO());
			stmUpdate.setString(3, this.getCgg_ger_matriz().getCGGIN_CODIGO());
			stmUpdate.setString(4, this.getCgg_ger_matriz().getCUSU_CODIGO());
			stmUpdate.setString(5, this.getCgg_ger_matriz().getCGGMA_MES());
			stmUpdate.setString(6, this.getCgg_ger_matriz().getCGGMA_ANIO());
			stmUpdate.setBigDecimal(7, this.getCgg_ger_matriz().getCGGMA_VALOR());
			stmUpdate.setString(8, this.getCgg_ger_matriz().getCGGMA_DESCRIPCION());
			stmUpdate.setBigDecimal(9, this.getCgg_ger_matriz().getCGGMA_ACTUALIZACIONES());
			stmUpdate.setBoolean(10, this.getCgg_ger_matriz().getCGGMA_ESTADO());
			stmUpdate.setString(11, this.getCgg_ger_matriz().getCGGMA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_ger_matriz DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_ger_matriz OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_ger_matriz select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_matriz().getCGGMA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_ger_matriz().setCGGMA_CODIGO(results.getString(1));
				this.getCgg_ger_matriz().setCCTN_CODIGO(results.getString(2));
				this.getCgg_ger_matriz().setCGGIN_CODIGO(results.getString(3));
				this.getCgg_ger_matriz().setCUSU_CODIGO(results.getString(4));
				this.getCgg_ger_matriz().setCGGMA_MES(results.getString(5));
				this.getCgg_ger_matriz().setCGGMA_ANIO(results.getString(6));
				this.getCgg_ger_matriz().setCGGMA_VALOR(results.getBigDecimal(7));
				this.getCgg_ger_matriz().setCGGMA_DESCRIPCION(results.getString(8));
				this.getCgg_ger_matriz().setCGGMA_ACTUALIZACIONES(results.getBigDecimal(9));
				this.getCgg_ger_matriz().setCGGMA_ESTADO(results.getBoolean(10));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_ger_matriz();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_ger_matriz DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_ger_matriz().getCGGMA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_ger_matriz().getCGGMA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_ger_matriz DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_ger_indicador.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_ger_matriz OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> selectCGG_GER_INDICADOR(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> outCgg_ger_matriz = new ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_S_CGG_GER_INDICADOR(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_matriz().getCGGIN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_matriz tmpCgg_ger_matriz = new com.besixplus.sii.objects.Cgg_ger_matriz();
				tmpCgg_ger_matriz.setCGGMA_CODIGO(results.getString(1));
				tmpCgg_ger_matriz.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_matriz.setCGGIN_CODIGO(results.getString(3));
				tmpCgg_ger_matriz.setCUSU_CODIGO(results.getString(4));
				tmpCgg_ger_matriz.setCGGMA_MES(results.getString(5));
				tmpCgg_ger_matriz.setCGGMA_ANIO(results.getString(6));
				tmpCgg_ger_matriz.setCGGMA_VALOR(results.getBigDecimal(7));
				tmpCgg_ger_matriz.setCGGMA_DESCRIPCION(results.getString(8));
				tmpCgg_ger_matriz.setCGGMA_ACTUALIZACIONES(results.getBigDecimal(9));
				tmpCgg_ger_matriz.setCGGMA_ESTADO(results.getBoolean(10));
				outCgg_ger_matriz.add(tmpCgg_ger_matriz);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_matriz;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_ger_matriz DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_ger_indicador.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_D_CGG_GER_INDICADOR(?) }");
			stmDelete.setString(1, this.getCgg_ger_matriz().getCGGIN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_DS_CGG_GER_INDICADOR(?) }");
				stmDelete.setString(1, this.getCgg_ger_matriz().getCGGIN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_ger_matriz DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_ger_matriz OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> selectCGG_CANTON(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> outCgg_ger_matriz = new ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_MATRIZ_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_matriz().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_matriz tmpCgg_ger_matriz = new com.besixplus.sii.objects.Cgg_ger_matriz();
				tmpCgg_ger_matriz.setCGGMA_CODIGO(results.getString(1));
				tmpCgg_ger_matriz.setCCTN_CODIGO(results.getString(2));
				tmpCgg_ger_matriz.setCGGIN_CODIGO(results.getString(3));
				tmpCgg_ger_matriz.setCUSU_CODIGO(results.getString(4));
				tmpCgg_ger_matriz.setCGGMA_MES(results.getString(5));
				tmpCgg_ger_matriz.setCGGMA_ANIO(results.getString(6));
				tmpCgg_ger_matriz.setCGGMA_VALOR(results.getBigDecimal(7));
				tmpCgg_ger_matriz.setCGGMA_DESCRIPCION(results.getString(8));
				tmpCgg_ger_matriz.setCGGMA_ACTUALIZACIONES(results.getBigDecimal(9));
				tmpCgg_ger_matriz.setCGGMA_ESTADO(results.getBoolean(10));
				outCgg_ger_matriz.add(tmpCgg_ger_matriz);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_matriz;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_ger_matriz DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_ger_matriz().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_MATRIZ_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_ger_matriz().getCCTN_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_matriz QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inCggin_codigo CODIGO DEL INDICADOR
	* @param inCggma_anio ANIO DEL INDICADOR	
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_matriz> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectDirectGrid(
		java.sql.Connection inConnection,
		String inUserName,
		String inCggin_codigo,		
		String inCggma_anio	
	){
		ArrayList<HashMap<String,Object>> outCgg_ger_matriz = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_GER_MATRIZ_SELECT_GRID(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCggin_codigo);
			stmSelect.setString(4, inCggma_anio);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_ger_matriz.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_matriz;
	}
}