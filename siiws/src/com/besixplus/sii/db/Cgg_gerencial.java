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
* CLASE Cgg_gerencial
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gerencial.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gerencial implements Serializable{
	private static final long serialVersionUID = 873946769;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gerencial.
	*/
	private com.besixplus.sii.objects.Cgg_gerencial myCgg_gerencial = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gerencial.
	*/
	public Cgg_gerencial(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gerencial.
	* @param inCgg_gerencial OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gerencial.
	*/
	public Cgg_gerencial(
		com.besixplus.sii.objects.Cgg_gerencial inCgg_gerencial
	){
		this.setCgg_gerencial(inCgg_gerencial);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gerencial.
	* @param inCgg_gerencial OBJETO Cgg_gerencial.
	* @return void
	*/
	public void setCgg_gerencial(com.besixplus.sii.objects.Cgg_gerencial inCgg_gerencial){
		this.myCgg_gerencial = inCgg_gerencial;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gerencial.
	* @return Cgg_gerencial OBJETO Cgg_gerencial.
	*/
	public com.besixplus.sii.objects.Cgg_gerencial getCgg_gerencial(){
		return this.myCgg_gerencial;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gerencial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_INSERT(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gerencial().getCGGER_CODIGO());
			stmInsert.setString(3, this.getCgg_gerencial().getCWMOD_CODIGO());
			stmInsert.setString(4, this.getCgg_gerencial().getCGGER_NOMBRE());
			stmInsert.setString(5, this.getCgg_gerencial().getCGGER_TITULO());
			stmInsert.setString(6, this.getCgg_gerencial().getCGGER_URL());
			stmInsert.setString(7, this.getCgg_gerencial().getCGGER_PARAMETROS());
			stmInsert.setString(8, this.getCgg_gerencial().getCGGER_DESCRIPCION());
			stmInsert.setInt(9, this.getCgg_gerencial().getCGGER_TIPO());
			stmInsert.setBoolean(10, this.getCgg_gerencial().getCGGER_ESTADO());
			stmInsert.setString(11, this.getCgg_gerencial().getCGGER_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gerencial().setCGGER_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gerencial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gerencial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gerencial> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gerencial> outCgg_gerencial = new ArrayList<com.besixplus.sii.objects.Cgg_gerencial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gerencial tmpCgg_gerencial = new com.besixplus.sii.objects.Cgg_gerencial();
				tmpCgg_gerencial.setCGGER_CODIGO(results.getString(1));
				tmpCgg_gerencial.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_gerencial.setCGGER_NOMBRE(results.getString(3));
				tmpCgg_gerencial.setCGGER_TITULO(results.getString(4));
				tmpCgg_gerencial.setCGGER_URL(results.getString(5));
				tmpCgg_gerencial.setCGGER_PARAMETROS(results.getString(6));
				tmpCgg_gerencial.setCGGER_DESCRIPCION(results.getString(7));
				tmpCgg_gerencial.setCGGER_TIPO(results.getInt(8));
				tmpCgg_gerencial.setCGGER_ESTADO(results.getBoolean(9));
				outCgg_gerencial.add(tmpCgg_gerencial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gerencial;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gerencial QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gerencial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gerencial> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gerencial> outCgg_gerencial = new ArrayList<com.besixplus.sii.objects.Cgg_gerencial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gerencial tmpCgg_gerencial = new com.besixplus.sii.objects.Cgg_gerencial();
				tmpCgg_gerencial.setCGGER_CODIGO(results.getString(1));
				tmpCgg_gerencial.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_gerencial.setCGGER_NOMBRE(results.getString(3));
				tmpCgg_gerencial.setCGGER_TITULO(results.getString(4));
				tmpCgg_gerencial.setCGGER_URL(results.getString(5));
				tmpCgg_gerencial.setCGGER_PARAMETROS(results.getString(6));
				tmpCgg_gerencial.setCGGER_DESCRIPCION(results.getString(7));
				tmpCgg_gerencial.setCGGER_TIPO(results.getInt(8));
				tmpCgg_gerencial.setCGGER_ESTADO(results.getBoolean(9));
				outCgg_gerencial.add(tmpCgg_gerencial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gerencial;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gerencial QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO DE WEB MODULO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gerencial> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCwmod_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_gerencial = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCwmod_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gerencial.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gerencial;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gerencial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gerencial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GERENCIAL_UPDATE(?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gerencial().getCGGER_CODIGO());
			stmUpdate.setString(2, this.getCgg_gerencial().getCWMOD_CODIGO());
			stmUpdate.setString(3, this.getCgg_gerencial().getCGGER_NOMBRE());
			stmUpdate.setString(4, this.getCgg_gerencial().getCGGER_TITULO());
			stmUpdate.setString(5, this.getCgg_gerencial().getCGGER_URL());
			stmUpdate.setString(6, this.getCgg_gerencial().getCGGER_PARAMETROS());
			stmUpdate.setString(7, this.getCgg_gerencial().getCGGER_DESCRIPCION());
			stmUpdate.setInt(8, this.getCgg_gerencial().getCGGER_TIPO());
			stmUpdate.setBoolean(9, this.getCgg_gerencial().getCGGER_ESTADO());
			stmUpdate.setString(10, this.getCgg_gerencial().getCGGER_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gerencial DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gerencial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gerencial select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gerencial().getCGGER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gerencial().setCGGER_CODIGO(results.getString(1));
				this.getCgg_gerencial().setCWMOD_CODIGO(results.getString(2));
				this.getCgg_gerencial().setCGGER_NOMBRE(results.getString(3));
				this.getCgg_gerencial().setCGGER_TITULO(results.getString(4));
				this.getCgg_gerencial().setCGGER_URL(results.getString(5));
				this.getCgg_gerencial().setCGGER_PARAMETROS(results.getString(6));
				this.getCgg_gerencial().setCGGER_DESCRIPCION(results.getString(7));
				this.getCgg_gerencial().setCGGER_TIPO(results.getInt(8));
				this.getCgg_gerencial().setCGGER_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gerencial();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gerencial DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GERENCIAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gerencial().getCGGER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GERENCIAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gerencial().getCGGER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gerencial DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_web_modulo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gerencial OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gerencial> selectCGG_WEB_MODULO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gerencial> outCgg_gerencial = new ArrayList<com.besixplus.sii.objects.Cgg_gerencial>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_S_CGG_WEB_MODULO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gerencial().getCWMOD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gerencial tmpCgg_gerencial = new com.besixplus.sii.objects.Cgg_gerencial();
				tmpCgg_gerencial.setCGGER_CODIGO(results.getString(1));
				tmpCgg_gerencial.setCWMOD_CODIGO(results.getString(2));
				tmpCgg_gerencial.setCGGER_NOMBRE(results.getString(3));
				tmpCgg_gerencial.setCGGER_TITULO(results.getString(4));
				tmpCgg_gerencial.setCGGER_URL(results.getString(5));
				tmpCgg_gerencial.setCGGER_PARAMETROS(results.getString(6));
				tmpCgg_gerencial.setCGGER_DESCRIPCION(results.getString(7));
				tmpCgg_gerencial.setCGGER_TIPO(results.getInt(8));
				tmpCgg_gerencial.setCGGER_ESTADO(results.getBoolean(9));
				outCgg_gerencial.add(tmpCgg_gerencial);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gerencial;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gerencial DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_web_modulo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_WEB_MODULO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GERENCIAL_D_CGG_WEB_MODULO(?) }");
			stmDelete.setString(1, this.getCgg_gerencial().getCWMOD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GERENCIAL_DS_CGG_WEB_MODULO(?) }");
				stmDelete.setString(1, this.getCgg_gerencial().getCWMOD_CODIGO());
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
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO DE WEB MODULO.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCountByModulo(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCwmod_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GERENCIAL_COUNTByModulo(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCwmod_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
}