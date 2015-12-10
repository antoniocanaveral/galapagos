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
* CLASE Cgg_dhu_pregunta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_pregunta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_pregunta implements Serializable{
	private static final long serialVersionUID = 2064148569;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_pregunta.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_pregunta myCgg_dhu_pregunta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta.
	*/
	public Cgg_dhu_pregunta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta.
	* @param inCgg_dhu_pregunta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_pregunta.
	*/
	public Cgg_dhu_pregunta(
		com.besixplus.sii.objects.Cgg_dhu_pregunta inCgg_dhu_pregunta
	){
		this.setCgg_dhu_pregunta(inCgg_dhu_pregunta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_pregunta.
	* @param inCgg_dhu_pregunta OBJETO Cgg_dhu_pregunta.
	* @return void
	*/
	public void setCgg_dhu_pregunta(com.besixplus.sii.objects.Cgg_dhu_pregunta inCgg_dhu_pregunta){
		this.myCgg_dhu_pregunta = inCgg_dhu_pregunta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_pregunta.
	* @return Cgg_dhu_pregunta OBJETO Cgg_dhu_pregunta.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_pregunta getCgg_dhu_pregunta(){
		return this.myCgg_dhu_pregunta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_pregunta().getCDPRG_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_pregunta().getCDCAT_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_pregunta().getCDPRG_DESCRIPCION());
			stmInsert.setBoolean(5, this.getCgg_dhu_pregunta().getCDPRG_CUANTIFICABLE());
			stmInsert.setBoolean(6, this.getCgg_dhu_pregunta().getCDPRG_MULTIPLE());
			stmInsert.setBoolean(7, this.getCgg_dhu_pregunta().getCDPRG_ESTADO());
			stmInsert.setString(8, this.getCgg_dhu_pregunta().getCDPRG_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_dhu_pregunta().setCDPRG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> outCgg_dhu_pregunta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_pregunta tmpCgg_dhu_pregunta = new com.besixplus.sii.objects.Cgg_dhu_pregunta();
				tmpCgg_dhu_pregunta.setCDPRG_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta.setCDCAT_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta.setCDPRG_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_pregunta.setCDPRG_CUANTIFICABLE(results.getBoolean(4));
				tmpCgg_dhu_pregunta.setCDPRG_MULTIPLE(results.getBoolean(5));
				tmpCgg_dhu_pregunta.setCDPRG_ESTADO(results.getBoolean(6));
				outCgg_dhu_pregunta.add(tmpCgg_dhu_pregunta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> outCgg_dhu_pregunta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_pregunta tmpCgg_dhu_pregunta = new com.besixplus.sii.objects.Cgg_dhu_pregunta();
				tmpCgg_dhu_pregunta.setCDPRG_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta.setCDCAT_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta.setCDPRG_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_pregunta.setCDPRG_CUANTIFICABLE(results.getBoolean(4));
				tmpCgg_dhu_pregunta.setCDPRG_MULTIPLE(results.getBoolean(5));
				tmpCgg_dhu_pregunta.setCDPRG_ESTADO(results.getBoolean(6));
				outCgg_dhu_pregunta.add(tmpCgg_dhu_pregunta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECION DE LA COLUMNA DE ORDENAMIENTO.
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
		ArrayList<HashMap<String,Object>> outCgg_dhu_pregunta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_pregunta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_pregunta().getCDPRG_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_pregunta().getCDCAT_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_pregunta().getCDPRG_DESCRIPCION());
			stmUpdate.setBoolean(4, this.getCgg_dhu_pregunta().getCDPRG_CUANTIFICABLE());
			stmUpdate.setBoolean(5, this.getCgg_dhu_pregunta().getCDPRG_MULTIPLE());
			stmUpdate.setBoolean(6, this.getCgg_dhu_pregunta().getCDPRG_ESTADO());
			stmUpdate.setString(7, this.getCgg_dhu_pregunta().getCDPRG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_pregunta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_pregunta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_pregunta().getCDPRG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_pregunta().setCDPRG_CODIGO(results.getString(1));
				this.getCgg_dhu_pregunta().setCDCAT_CODIGO(results.getString(2));
				this.getCgg_dhu_pregunta().setCDPRG_DESCRIPCION(results.getString(3));
				this.getCgg_dhu_pregunta().setCDPRG_CUANTIFICABLE(results.getBoolean(4));
				this.getCgg_dhu_pregunta().setCDPRG_MULTIPLE(results.getBoolean(5));
				this.getCgg_dhu_pregunta().setCDPRG_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_pregunta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		/*boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;*/
		try{
			/*tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();*/
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta().getCDPRG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		/*if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_pregunta().getCDPRG_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}*/
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	* @return com.besixplus.sii.objects.Cgg_dhu_pregunta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> selectCGG_DHU_CATEGORIA(
		java.sql.Connection inConnection,
		String inCdcat_codigo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> outCgg_dhu_pregunta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_S_CGG_DHU_CATEGORIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCdcat_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_pregunta tmpCgg_dhu_pregunta = new com.besixplus.sii.objects.Cgg_dhu_pregunta();
				tmpCgg_dhu_pregunta.setCDPRG_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta.setCDCAT_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta.setCDPRG_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_pregunta.setCDPRG_CUANTIFICABLE(results.getBoolean(4));
				tmpCgg_dhu_pregunta.setCDPRG_MULTIPLE(results.getBoolean(5));
				tmpCgg_dhu_pregunta.setCDPRG_ESTADO(results.getBoolean(6));
				outCgg_dhu_pregunta.add(tmpCgg_dhu_pregunta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_CATEGORIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_D_CGG_DHU_CATEGORIA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta().getCDCAT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_DS_CGG_DHU_CATEGORIA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_pregunta().getCDCAT_CODIGO());
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
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deletePregunta(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta().getCDPRG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

}