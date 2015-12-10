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
* CLASE Cgg_tct_grupo_hospedaje
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_grupo_hospedaje.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_grupo_hospedaje implements Serializable{
	private static final long serialVersionUID = 1431731083;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje.
	*/
	private com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje myCgg_tct_grupo_hospedaje = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_hospedaje.
	*/
	public Cgg_tct_grupo_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_hospedaje.
	* @param inCgg_tct_grupo_hospedaje OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_grupo_hospedaje.
	*/
	public Cgg_tct_grupo_hospedaje(
		com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje inCgg_tct_grupo_hospedaje
	){
		this.setCgg_tct_grupo_hospedaje(inCgg_tct_grupo_hospedaje);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_grupo_hospedaje.
	* @param inCgg_tct_grupo_hospedaje OBJETO Cgg_tct_grupo_hospedaje.
	* @return void
	*/
	public void setCgg_tct_grupo_hospedaje(com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje inCgg_tct_grupo_hospedaje){
		this.myCgg_tct_grupo_hospedaje = inCgg_tct_grupo_hospedaje;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_grupo_hospedaje.
	* @return Cgg_tct_grupo_hospedaje OBJETO Cgg_tct_grupo_hospedaje.
	*/
	public com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje getCgg_tct_grupo_hospedaje(){
		return this.myCgg_tct_grupo_hospedaje;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_grupo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_grupo_hospedaje().getCTGHJ_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_grupo_hospedaje().getCTTHJ_CODIGO());
			stmInsert.setString(5, this.getCgg_tct_grupo_hospedaje().getCTGHJ_LUGAR_HOSPEDAJE());
			stmInsert.setBoolean(6, this.getCgg_tct_grupo_hospedaje().getCTGHJ_ESTADO());
			stmInsert.setString(7, this.getCgg_tct_grupo_hospedaje().getCTGHJ_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_tct_grupo_hospedaje().getCTGHJ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_grupo_hospedaje().setCTGHJ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> outCgg_tct_grupo_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje tmpCgg_tct_grupo_hospedaje = new com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje();
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_hospedaje.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_hospedaje.setCTTHJ_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_grupo_hospedaje.add(tmpCgg_tct_grupo_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_hospedaje;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> outCgg_tct_grupo_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje tmpCgg_tct_grupo_hospedaje = new com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje();
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_hospedaje.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_hospedaje.setCTTHJ_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_grupo_hospedaje.add(tmpCgg_tct_grupo_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_hospedaje;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_grupo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_grupo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_grupo_hospedaje().getCTGHJ_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_grupo_hospedaje().getCTTHJ_CODIGO());
			stmUpdate.setString(4, this.getCgg_tct_grupo_hospedaje().getCTGHJ_LUGAR_HOSPEDAJE());
			stmUpdate.setBoolean(5, this.getCgg_tct_grupo_hospedaje().getCTGHJ_ESTADO());
			stmUpdate.setString(6, this.getCgg_tct_grupo_hospedaje().getCTGHJ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_hospedaje().getCTGHJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_grupo_hospedaje().setCTGHJ_CODIGO(results.getString(1));
				this.getCgg_tct_grupo_hospedaje().setCTGTR_CODIGO(results.getString(2));
				this.getCgg_tct_grupo_hospedaje().setCTTHJ_CODIGO(results.getString(3));
				this.getCgg_tct_grupo_hospedaje().setCTGHJ_LUGAR_HOSPEDAJE(results.getString(4));
				this.getCgg_tct_grupo_hospedaje().setCTGHJ_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_grupo_hospedaje();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_hospedaje().getCTGHJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_hospedaje().getCTGHJ_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_tipo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> selectCGG_TCT_TIPO_HOSPEDAJE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> outCgg_tct_grupo_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_S_CGG_TCT_TIPO_HOSPEDAJE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_grupo_hospedaje().getCTTHJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje tmpCgg_tct_grupo_hospedaje = new com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje();
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_hospedaje.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_hospedaje.setCTTHJ_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_grupo_hospedaje.add(tmpCgg_tct_grupo_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_hospedaje;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_tipo_hospedaje.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_TIPO_HOSPEDAJE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_D_CGG_TCT_TIPO_HOSPEDAJE(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_grupo_hospedaje().getCTTHJ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_DS_CGG_TCT_TIPO_HOSPEDAJE(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_grupo_hospedaje().getCTTHJ_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> selectCGG_TCT_GRUPO_TURISTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje> outCgg_tct_grupo_hospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_S_CGG_TCT_GRUPO_TURISTA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_grupo_hospedaje().getCTTHJ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje tmpCgg_tct_grupo_hospedaje = new com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje();
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_hospedaje.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_hospedaje.setCTTHJ_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_LUGAR_HOSPEDAJE(results.getString(4));
				tmpCgg_tct_grupo_hospedaje.setCTGHJ_ESTADO(results.getBoolean(5));
				outCgg_tct_grupo_hospedaje.add(tmpCgg_tct_grupo_hospedaje);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_hospedaje;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public String deleteCGG_TCT_GRUPO_TURISTA(
		java.sql.Connection inConnection
	){
		String outResult = "true";	
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_HOSPEDAJE_D_CGG_TCT_GRUPO_TURISTA(?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_hospedaje().getCTGTR_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		
		return outResult;
	}
	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param in_user_name
	 * @return com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectGrupohospedajeoff(
		java.sql.Connection inConnection,
		String in_user_name
		
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_grupo_hospedaje = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_grupo_hospedaje_offline(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, in_user_name);
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_grupo_hospedaje.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_hospedaje;
	}
}