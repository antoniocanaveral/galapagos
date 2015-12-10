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
* CLASE Cgg_ger_indicador
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_ger_indicador.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_ger_indicador implements Serializable{
	private static final long serialVersionUID = 1097672676;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_ger_indicador.
	*/
	private com.besixplus.sii.objects.Cgg_ger_indicador myCgg_ger_indicador = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador.
	*/
	public Cgg_ger_indicador(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador.
	* @param inCgg_ger_indicador OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_ger_indicador.
	*/
	public Cgg_ger_indicador(
		com.besixplus.sii.objects.Cgg_ger_indicador inCgg_ger_indicador
	){
		this.setCgg_ger_indicador(inCgg_ger_indicador);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_ger_indicador.
	* @param inCgg_ger_indicador OBJETO Cgg_ger_indicador.
	* @return void
	*/
	public void setCgg_ger_indicador(com.besixplus.sii.objects.Cgg_ger_indicador inCgg_ger_indicador){
		this.myCgg_ger_indicador = inCgg_ger_indicador;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_ger_indicador.
	* @return Cgg_ger_indicador OBJETO Cgg_ger_indicador.
	*/
	public com.besixplus.sii.objects.Cgg_ger_indicador getCgg_ger_indicador(){
		return this.myCgg_ger_indicador;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_ger_indicador.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_ger_indicador().getCGGIN_CODIGO());
			stmInsert.setString(3, this.getCgg_ger_indicador().getCGGIT_CODIGO());
			/*stmInsert.setString(4, this.getCgg_ger_indicador().getCUSU_CODIGO());
			stmInsert.setString(5, this.getCgg_ger_indicador().getCCTN_CODIGO());*/
			stmInsert.setString(4, this.getCgg_ger_indicador().getCGGIN_NOMBRE());
			stmInsert.setString(5, this.getCgg_ger_indicador().getCGGIN_DESCRIPCION());
			stmInsert.setBoolean(6, this.getCgg_ger_indicador().getCGGIN_ESTADO());
			stmInsert.setString(7, this.getCgg_ger_indicador().getCGGIN_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_ger_indicador().setCGGIN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> outCgg_ger_indicador = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador tmpCgg_ger_indicador = new com.besixplus.sii.objects.Cgg_ger_indicador();
				tmpCgg_ger_indicador.setCGGIN_CODIGO(results.getString(1));
				tmpCgg_ger_indicador.setCGGIT_CODIGO(results.getString(2));
				/*tmpCgg_ger_indicador.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador.setCCTN_CODIGO(results.getString(4));*/
				tmpCgg_ger_indicador.setCGGIN_NOMBRE(results.getString(3));
				tmpCgg_ger_indicador.setCGGIN_DESCRIPCION(results.getString(4));
				tmpCgg_ger_indicador.setCGGIN_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador.add(tmpCgg_ger_indicador);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> outCgg_ger_indicador = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_ger_indicador tmpCgg_ger_indicador = new com.besixplus.sii.objects.Cgg_ger_indicador();
				tmpCgg_ger_indicador.setCGGIN_CODIGO(results.getString(1));
				tmpCgg_ger_indicador.setCGGIT_CODIGO(results.getString(2));
				/*tmpCgg_ger_indicador.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador.setCCTN_CODIGO(results.getString(4));*/
				tmpCgg_ger_indicador.setCGGIN_NOMBRE(results.getString(3));
				tmpCgg_ger_indicador.setCGGIN_DESCRIPCION(results.getString(4));
				tmpCgg_ger_indicador.setCGGIN_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador.add(tmpCgg_ger_indicador);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_ger_indicador = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_SELECT(?,?,?,?,?,?) }");
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
				outCgg_ger_indicador.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_ger_indicador.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_ger_indicador.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_ger_indicador().getCGGIN_CODIGO());
			stmUpdate.setString(2, this.getCgg_ger_indicador().getCGGIT_CODIGO());
			/*stmUpdate.setString(3, this.getCgg_ger_indicador().getCUSU_CODIGO());
			stmUpdate.setString(4, this.getCgg_ger_indicador().getCCTN_CODIGO());*/
			stmUpdate.setString(3, this.getCgg_ger_indicador().getCGGIN_NOMBRE());
			stmUpdate.setString(4, this.getCgg_ger_indicador().getCGGIN_DESCRIPCION());
			stmUpdate.setBoolean(5, this.getCgg_ger_indicador().getCGGIN_ESTADO());
			stmUpdate.setString(6, this.getCgg_ger_indicador().getCGGIN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_ger_indicador DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_ger_indicador OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_ger_indicador select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador().getCGGIN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_ger_indicador().setCGGIN_CODIGO(results.getString(1));
				this.getCgg_ger_indicador().setCGGIT_CODIGO(results.getString(2));
				/*this.getCgg_ger_indicador().setCUSU_CODIGO(results.getString(3));
				this.getCgg_ger_indicador().setCCTN_CODIGO(results.getString(4));*/
				this.getCgg_ger_indicador().setCGGIN_NOMBRE(results.getString(3));
				this.getCgg_ger_indicador().setCGGIN_DESCRIPCION(results.getString(4));
				this.getCgg_ger_indicador().setCGGIN_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_ger_indicador();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_ger_indicador DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador().getCGGIN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador().getCGGIN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_ger_indicador DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_ger_indicador_tipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_ger_indicador OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> selectCGG_GER_INDICADOR_TIPO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> outCgg_ger_indicador = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_S_CGG_GER_INDICADOR_TIPO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador().getCGGIT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador tmpCgg_ger_indicador = new com.besixplus.sii.objects.Cgg_ger_indicador();
				tmpCgg_ger_indicador.setCGGIN_CODIGO(results.getString(1));
				tmpCgg_ger_indicador.setCGGIT_CODIGO(results.getString(2));
				/*tmpCgg_ger_indicador.setCUSU_CODIGO(results.getString(3));
				tmpCgg_ger_indicador.setCCTN_CODIGO(results.getString(4));*/
				tmpCgg_ger_indicador.setCGGIN_NOMBRE(results.getString(3));
				tmpCgg_ger_indicador.setCGGIN_DESCRIPCION(results.getString(4));
				tmpCgg_ger_indicador.setCGGIN_ESTADO(results.getBoolean(5));
				outCgg_ger_indicador.add(tmpCgg_ger_indicador);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_ger_indicador DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_ger_indicador_tipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GER_INDICADOR_TIPO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_D_CGG_GER_INDICADOR_TIPO(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador().getCGGIT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_DS_CGG_GER_INDICADOR_TIPO(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador().getCGGIT_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

}