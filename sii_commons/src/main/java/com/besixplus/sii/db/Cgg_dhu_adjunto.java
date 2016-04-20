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
* CLASE Cgg_dhu_adjunto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_adjunto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_adjunto implements Serializable{
	private static final long serialVersionUID = 1617110444;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_adjunto.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_adjunto myCgg_dhu_adjunto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_adjunto.
	*/
	public Cgg_dhu_adjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_adjunto.
	* @param inCgg_dhu_adjunto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_adjunto.
	*/
	public Cgg_dhu_adjunto(
		com.besixplus.sii.objects.Cgg_dhu_adjunto inCgg_dhu_adjunto
	){
		this.setCgg_dhu_adjunto(inCgg_dhu_adjunto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_adjunto.
	* @param inCgg_dhu_adjunto OBJETO Cgg_dhu_adjunto.
	* @return void
	*/
	public void setCgg_dhu_adjunto(com.besixplus.sii.objects.Cgg_dhu_adjunto inCgg_dhu_adjunto){
		this.myCgg_dhu_adjunto = inCgg_dhu_adjunto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_adjunto.
	* @return Cgg_dhu_adjunto OBJETO Cgg_dhu_adjunto.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_adjunto getCgg_dhu_adjunto(){
		return this.myCgg_dhu_adjunto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_adjunto().getCDAD_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_adjunto().getCDBEC_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_adjunto().getCDAD_DESCRIPCION());
			stmInsert.setString(5, this.getCgg_dhu_adjunto().getCDAD_OBSERVACION());
			stmInsert.setString(6, this.getCgg_dhu_adjunto().getCDAD_NOMBRE_ADJUNTO());
			stmInsert.setBytes(7, this.getCgg_dhu_adjunto().getCDAD_ADJUNTO());
			stmInsert.setInt(8, this.getCgg_dhu_adjunto().getCDAD_TIPO());
			stmInsert.setString(9, this.getCgg_dhu_adjunto().getCDAD_DESCRIPCION_CONTENIDO());
			stmInsert.setBoolean(10, this.getCgg_dhu_adjunto().getCDAD_ESTADO());
			stmInsert.setString(11, this.getCgg_dhu_adjunto().getCDAD_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_dhu_adjunto().getCDAD_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_adjunto().setCDAD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> outCgg_dhu_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_adjunto tmpCgg_dhu_adjunto = new com.besixplus.sii.objects.Cgg_dhu_adjunto();
				tmpCgg_dhu_adjunto.setCDAD_CODIGO(results.getString(1));
				tmpCgg_dhu_adjunto.setCDBEC_CODIGO(results.getString(2));
				tmpCgg_dhu_adjunto.setCDAD_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_adjunto.setCDAD_OBSERVACION(results.getString(4));
				tmpCgg_dhu_adjunto.setCDAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_adjunto.setCDAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_adjunto.setCDAD_TIPO(results.getInt(7));
				tmpCgg_dhu_adjunto.setCDAD_DESCRIPCION_CONTENIDO(results.getString(8));
				tmpCgg_dhu_adjunto.setCDAD_ESTADO(results.getBoolean(9));
				outCgg_dhu_adjunto.add(tmpCgg_dhu_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_adjunto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> outCgg_dhu_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_adjunto tmpCgg_dhu_adjunto = new com.besixplus.sii.objects.Cgg_dhu_adjunto();
				tmpCgg_dhu_adjunto.setCDAD_CODIGO(results.getString(1));
				tmpCgg_dhu_adjunto.setCDBEC_CODIGO(results.getString(2));
				tmpCgg_dhu_adjunto.setCDAD_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_adjunto.setCDAD_OBSERVACION(results.getString(4));
				tmpCgg_dhu_adjunto.setCDAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_adjunto.setCDAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_adjunto.setCDAD_TIPO(results.getInt(7));
				tmpCgg_dhu_adjunto.setCDAD_DESCRIPCION_CONTENIDO(results.getString(8));
				tmpCgg_dhu_adjunto.setCDAD_ESTADO(results.getBoolean(9));
				outCgg_dhu_adjunto.add(tmpCgg_dhu_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_adjunto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_dhu_adjunto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_adjunto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_adjunto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_adjunto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_ADJUNTO_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_adjunto().getCDAD_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_adjunto().getCDBEC_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_adjunto().getCDAD_DESCRIPCION());
			stmUpdate.setString(4, this.getCgg_dhu_adjunto().getCDAD_OBSERVACION());
			stmUpdate.setString(5, this.getCgg_dhu_adjunto().getCDAD_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(6, this.getCgg_dhu_adjunto().getCDAD_ADJUNTO());
			stmUpdate.setInt(7, this.getCgg_dhu_adjunto().getCDAD_TIPO());
			stmUpdate.setString(8, this.getCgg_dhu_adjunto().getCDAD_DESCRIPCION_CONTENIDO());
			stmUpdate.setBoolean(9, this.getCgg_dhu_adjunto().getCDAD_ESTADO());
			stmUpdate.setString(10, this.getCgg_dhu_adjunto().getCDAD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_adjunto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_adjunto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_adjunto().getCDAD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_adjunto().setCDAD_CODIGO(results.getString(1));
				this.getCgg_dhu_adjunto().setCDBEC_CODIGO(results.getString(2));
				this.getCgg_dhu_adjunto().setCDAD_DESCRIPCION(results.getString(3));
				this.getCgg_dhu_adjunto().setCDAD_OBSERVACION(results.getString(4));
				this.getCgg_dhu_adjunto().setCDAD_NOMBRE_ADJUNTO(results.getString(5));
				this.getCgg_dhu_adjunto().setCDAD_ADJUNTO(results.getBytes(6));
				this.getCgg_dhu_adjunto().setCDAD_TIPO(results.getInt(7));
				this.getCgg_dhu_adjunto().setCDAD_DESCRIPCION_CONTENIDO(results.getString(8));
				this.getCgg_dhu_adjunto().setCDAD_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_adjunto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_adjunto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ADJUNTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_adjunto().getCDAD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ADJUNTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_adjunto().getCDAD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_adjunto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_adjunto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> selectCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> outCgg_dhu_adjunto = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_ADJUNTO_S_CGG_DHU_BECA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_adjunto().getCDBEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_adjunto tmpCgg_dhu_adjunto = new com.besixplus.sii.objects.Cgg_dhu_adjunto();
				tmpCgg_dhu_adjunto.setCDAD_CODIGO(results.getString(1));
				tmpCgg_dhu_adjunto.setCDBEC_CODIGO(results.getString(2));
				tmpCgg_dhu_adjunto.setCDAD_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_adjunto.setCDAD_OBSERVACION(results.getString(4));
				tmpCgg_dhu_adjunto.setCDAD_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_dhu_adjunto.setCDAD_ADJUNTO(results.getBytes(6));
				tmpCgg_dhu_adjunto.setCDAD_TIPO(results.getInt(7));
				tmpCgg_dhu_adjunto.setCDAD_DESCRIPCION_CONTENIDO(results.getString(8));
				tmpCgg_dhu_adjunto.setCDAD_ESTADO(results.getBoolean(9));
				outCgg_dhu_adjunto.add(tmpCgg_dhu_adjunto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_adjunto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_adjunto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ADJUNTO_D_CGG_DHU_BECA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_adjunto().getCDBEC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_ADJUNTO_DS_CGG_DHU_BECA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_adjunto().getCDBEC_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_adjunto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_adjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public  ArrayList<HashMap<String,Object>> selectAdjuntoBeca(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_adjunto(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_dhu_adjunto().getCDBEC_CODIGO());
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
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE SEGUN EL USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrateData CREA DATOS
	 * @return PERSONA RESPONSABLE DEL PROCESO 
	 * @throws SQLException 
	 */
	public static String ingresoAdjunto(
			java.sql.Connection inConnection,
			String inCrateData
	) throws SQLException{
		String valorAdjunto=null;

		CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ADJUNTO_TEMPORAL_ADJUNTO_ACUERDO(?) }");
		stmSelect.registerOutParameter(1, Types.VARCHAR);	
		stmSelect.setString(2, inCrateData);	
		stmSelect.execute();
		valorAdjunto = stmSelect.getString(1);
		stmSelect.close();

		return valorAdjunto;
	}
}