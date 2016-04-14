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
* CLASE Cgg_ger_indicador_tipo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_ger_indicador_tipo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_ger_indicador_tipo implements Serializable{
	private static final long serialVersionUID = 1300420211;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_ger_indicador_tipo.
	*/
	private com.besixplus.sii.objects.Cgg_ger_indicador_tipo myCgg_ger_indicador_tipo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_tipo.
	*/
	public Cgg_ger_indicador_tipo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_tipo.
	* @param inCgg_ger_indicador_tipo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_ger_indicador_tipo.
	*/
	public Cgg_ger_indicador_tipo(
		com.besixplus.sii.objects.Cgg_ger_indicador_tipo inCgg_ger_indicador_tipo
	){
		this.setCgg_ger_indicador_tipo(inCgg_ger_indicador_tipo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_ger_indicador_tipo.
	* @param inCgg_ger_indicador_tipo OBJETO Cgg_ger_indicador_tipo.
	* @return void
	*/
	public void setCgg_ger_indicador_tipo(com.besixplus.sii.objects.Cgg_ger_indicador_tipo inCgg_ger_indicador_tipo){
		this.myCgg_ger_indicador_tipo = inCgg_ger_indicador_tipo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_ger_indicador_tipo.
	* @return Cgg_ger_indicador_tipo OBJETO Cgg_ger_indicador_tipo.
	*/
	public com.besixplus.sii.objects.Cgg_ger_indicador_tipo getCgg_ger_indicador_tipo(){
		return this.myCgg_ger_indicador_tipo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_ger_indicador_tipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_INSERT(?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_ger_indicador_tipo().getCGGIT_CODIGO());
			stmInsert.setString(3, this.getCgg_ger_indicador_tipo().getCGGIT_DESCRIPCION());
			stmInsert.setBoolean(4, this.getCgg_ger_indicador_tipo().getCGGIT_ESTADO());
			stmInsert.setString(5, this.getCgg_ger_indicador_tipo().getCGGIT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_ger_indicador_tipo().setCGGIT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_tipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> outCgg_ger_indicador_tipo = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_ger_indicador_tipo tmpCgg_ger_indicador_tipo = new com.besixplus.sii.objects.Cgg_ger_indicador_tipo();
				tmpCgg_ger_indicador_tipo.setCGGIT_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_tipo.setCGGIT_DESCRIPCION(results.getString(2));
				tmpCgg_ger_indicador_tipo.setCGGIT_ESTADO(results.getBoolean(3));
				outCgg_ger_indicador_tipo.add(tmpCgg_ger_indicador_tipo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_tipo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_tipo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> outCgg_ger_indicador_tipo = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_ger_indicador_tipo tmpCgg_ger_indicador_tipo = new com.besixplus.sii.objects.Cgg_ger_indicador_tipo();
				tmpCgg_ger_indicador_tipo.setCGGIT_CODIGO(results.getString(1));
				tmpCgg_ger_indicador_tipo.setCGGIT_DESCRIPCION(results.getString(2));
				tmpCgg_ger_indicador_tipo.setCGGIT_ESTADO(results.getBoolean(3));
				outCgg_ger_indicador_tipo.add(tmpCgg_ger_indicador_tipo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_tipo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador_tipo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador_tipo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_ger_indicador_tipo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_ger_indicador_tipo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_ger_indicador_tipo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_ger_indicador_tipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_ger_indicador_tipo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_TIPO_UPDATE(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_ger_indicador_tipo().getCGGIT_CODIGO());
			stmUpdate.setString(2, this.getCgg_ger_indicador_tipo().getCGGIT_DESCRIPCION());
			stmUpdate.setBoolean(3, this.getCgg_ger_indicador_tipo().getCGGIT_ESTADO());
			stmUpdate.setString(4, this.getCgg_ger_indicador_tipo().getCGGIT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_ger_indicador_tipo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_ger_indicador_tipo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_ger_indicador_tipo select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GER_INDICADOR_TIPO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_ger_indicador_tipo().getCGGIT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_ger_indicador_tipo().setCGGIT_CODIGO(results.getString(1));
				this.getCgg_ger_indicador_tipo().setCGGIT_DESCRIPCION(results.getString(2));
				this.getCgg_ger_indicador_tipo().setCGGIT_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_ger_indicador_tipo();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_ger_indicador_tipo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_TIPO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_ger_indicador_tipo().getCGGIT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GER_INDICADOR_TIPO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_ger_indicador_tipo().getCGGIT_CODIGO());
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