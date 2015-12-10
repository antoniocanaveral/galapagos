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
* CLASE Cgg_res_aeropuerto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_aeropuerto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_aeropuerto implements Serializable{
	private static final long serialVersionUID = 1916092017;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_aeropuerto.
	*/
	private com.besixplus.sii.objects.Cgg_res_aeropuerto myCgg_res_aeropuerto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_aeropuerto.
	*/
	public Cgg_res_aeropuerto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_aeropuerto.
	* @param inCgg_res_aeropuerto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_aeropuerto.
	*/
	public Cgg_res_aeropuerto(
		com.besixplus.sii.objects.Cgg_res_aeropuerto inCgg_res_aeropuerto
	){
		this.setCgg_res_aeropuerto(inCgg_res_aeropuerto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_aeropuerto.
	* @param inCgg_res_aeropuerto OBJETO Cgg_res_aeropuerto.
	* @return void
	*/
	public void setCgg_res_aeropuerto(com.besixplus.sii.objects.Cgg_res_aeropuerto inCgg_res_aeropuerto){
		this.myCgg_res_aeropuerto = inCgg_res_aeropuerto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_aeropuerto.
	* @return Cgg_res_aeropuerto OBJETO Cgg_res_aeropuerto.
	*/
	public com.besixplus.sii.objects.Cgg_res_aeropuerto getCgg_res_aeropuerto(){
		return this.myCgg_res_aeropuerto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_INSERT(?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_aeropuerto().getCARPT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_aeropuerto().getCCTN_CODIGO());
			stmInsert.setString(4, this.getCgg_res_aeropuerto().getCARPT_NOMBRE());
			stmInsert.setInt(5, this.getCgg_res_aeropuerto().getCARPT_TIPO_AEREOPUERTO());
			stmInsert.setBoolean(6, this.getCgg_res_aeropuerto().getCARPT_ESTADO());
			stmInsert.setString(7, this.getCgg_res_aeropuerto().getCARPT_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_res_aeropuerto().getCARPT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_aeropuerto().setCARPT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> outCgg_res_aeropuerto = new ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_aeropuerto tmpCgg_res_aeropuerto = new com.besixplus.sii.objects.Cgg_res_aeropuerto();
				tmpCgg_res_aeropuerto.setCARPT_CODIGO(results.getString(1));
				tmpCgg_res_aeropuerto.setCCTN_CODIGO(results.getString(2));
				tmpCgg_res_aeropuerto.setCARPT_NOMBRE(results.getString(3));
				tmpCgg_res_aeropuerto.setCARPT_TIPO_AEREOPUERTO(results.getInt(4));
				tmpCgg_res_aeropuerto.setCARPT_ESTADO(results.getBoolean(5));
				outCgg_res_aeropuerto.add(tmpCgg_res_aeropuerto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_aeropuerto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_aeropuerto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		
		ArrayList<HashMap<String,Object>> outCgg_res_aeropuerto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_aeropuerto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_aeropuerto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_aeropuerto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_aeropuerto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_aeropuerto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_aeropuerto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_AEROPUERTO_UPDATE(?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_aeropuerto().getCARPT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_aeropuerto().getCCTN_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_aeropuerto().getCARPT_NOMBRE());
			stmUpdate.setInt(4, this.getCgg_res_aeropuerto().getCARPT_TIPO_AEREOPUERTO());
			stmUpdate.setBoolean(5, this.getCgg_res_aeropuerto().getCARPT_ESTADO());
			stmUpdate.setString(6, this.getCgg_res_aeropuerto().getCARPT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_aeropuerto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_aeropuerto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_aeropuerto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_aeropuerto().getCARPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_aeropuerto().setCARPT_CODIGO(results.getString(1));
				this.getCgg_res_aeropuerto().setCCTN_CODIGO(results.getString(2));
				this.getCgg_res_aeropuerto().setCARPT_NOMBRE(results.getString(3));
				this.getCgg_res_aeropuerto().setCARPT_TIPO_AEREOPUERTO(results.getInt(4));
				this.getCgg_res_aeropuerto().setCARPT_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_aeropuerto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_aeropuerto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_AEROPUERTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_aeropuerto().getCARPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_AEROPUERTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_aeropuerto().getCARPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_aeropuerto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_aeropuerto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> selectCGG_CANTON(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> outCgg_res_aeropuerto = new ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_aeropuerto().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_aeropuerto tmpCgg_res_aeropuerto = new com.besixplus.sii.objects.Cgg_res_aeropuerto();
				tmpCgg_res_aeropuerto.setCARPT_CODIGO(results.getString(1));
				tmpCgg_res_aeropuerto.setCCTN_CODIGO(results.getString(2));
				tmpCgg_res_aeropuerto.setCARPT_NOMBRE(results.getString(3));
				tmpCgg_res_aeropuerto.setCARPT_TIPO_AEREOPUERTO(results.getInt(4));
				tmpCgg_res_aeropuerto.setCARPT_ESTADO(results.getBoolean(5));
				outCgg_res_aeropuerto.add(tmpCgg_res_aeropuerto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_aeropuerto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_aeropuerto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_AEROPUERTO_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_res_aeropuerto().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_AEROPUERTO_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_res_aeropuerto().getCCTN_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_aeropuerto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCarpt_tipo_aereopuerto CRITERIO DE BUSQUEDA. TIPO DE AEREOPUERTO / 0 EXTERNO /1 INTERNO
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirectByTipo(
		java.sql.Connection inConnection,
		int inCarpt_tipo_aereopuerto
	){
		ArrayList<HashMap<String,Object>> outCgg_res_aeropuerto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_AEROPUERTO_SELECT_BY_TIPO(?::smallint) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, inCarpt_tipo_aereopuerto);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_aeropuerto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_aeropuerto;
	}
}