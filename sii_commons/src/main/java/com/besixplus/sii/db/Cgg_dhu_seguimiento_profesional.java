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
* CLASE Cgg_dhu_seguimiento_profesional
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_seguimiento_profesional.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_seguimiento_profesional implements Serializable{
	private static final long serialVersionUID = 1825478222;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional myCgg_dhu_seguimiento_profesional = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_profesional.
	*/
	public Cgg_dhu_seguimiento_profesional(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_profesional.
	* @param inCgg_dhu_seguimiento_profesional OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_seguimiento_profesional.
	*/
	public Cgg_dhu_seguimiento_profesional(
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional inCgg_dhu_seguimiento_profesional
	){
		this.setCgg_dhu_seguimiento_profesional(inCgg_dhu_seguimiento_profesional);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_seguimiento_profesional.
	* @param inCgg_dhu_seguimiento_profesional OBJETO Cgg_dhu_seguimiento_profesional.
	* @return void
	*/
	public void setCgg_dhu_seguimiento_profesional(com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional inCgg_dhu_seguimiento_profesional){
		this.myCgg_dhu_seguimiento_profesional = inCgg_dhu_seguimiento_profesional;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_seguimiento_profesional.
	* @return Cgg_dhu_seguimiento_profesional OBJETO Cgg_dhu_seguimiento_profesional.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional getCgg_dhu_seguimiento_profesional(){
		return this.myCgg_dhu_seguimiento_profesional;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_INSERT(?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_seguimiento_profesional().getCDSPR_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_seguimiento_profesional().getCDBEC_CODIGO());
			stmInsert.setInt(4, this.getCgg_dhu_seguimiento_profesional().getCDSPR_ANIO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_profesional().getCDSPR_FECHA_INGRESO().getTime()));
			stmInsert.setString(6, this.getCgg_dhu_seguimiento_profesional().getCDSPR_INSTITUCION());
			stmInsert.setString(7, this.getCgg_dhu_seguimiento_profesional().getCDSPR_CARGO());
			stmInsert.setTimestamp(8, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_profesional().getCDSPR_FECHA_SALIDA().getTime()));
			stmInsert.setString(9, this.getCgg_dhu_seguimiento_profesional().getCDSPR_OBSERVACIONES());
			stmInsert.setBoolean(10, this.getCgg_dhu_seguimiento_profesional().getCDSPR_ESTADO());
			stmInsert.setString(11, this.getCgg_dhu_seguimiento_profesional().getCDSPR_USUARIO_INSERT());
			stmInsert.setString(12, this.getCgg_dhu_seguimiento_profesional().getCDSPR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_seguimiento_profesional().setCDSPR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> outCgg_dhu_seguimiento_profesional = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional tmpCgg_dhu_seguimiento_profesional = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional();
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_profesional.setCDBEC_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_ANIO(results.getInt(3));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_FECHA_INGRESO(results.getTimestamp(4));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_INSTITUCION(results.getString(5));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_CARGO(results.getString(6));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_OBSERVACIONES(results.getString(8));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_ESTADO(results.getBoolean(9));
				outCgg_dhu_seguimiento_profesional.add(tmpCgg_dhu_seguimiento_profesional);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_profesional;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_profesional QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> outCgg_dhu_seguimiento_profesional = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional tmpCgg_dhu_seguimiento_profesional = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional();
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_profesional.setCDBEC_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_ANIO(results.getInt(3));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_FECHA_INGRESO(results.getTimestamp(4));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_INSTITUCION(results.getString(5));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_CARGO(results.getString(6));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_OBSERVACIONES(results.getString(8));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_ESTADO(results.getBoolean(9));
				outCgg_dhu_seguimiento_profesional.add(tmpCgg_dhu_seguimiento_profesional);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_profesional;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_seguimiento_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_profesional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_UPDATE(?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_seguimiento_profesional().getCDSPR_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_seguimiento_profesional().getCDBEC_CODIGO());
			stmUpdate.setInt(3, this.getCgg_dhu_seguimiento_profesional().getCDSPR_ANIO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_profesional().getCDSPR_FECHA_INGRESO().getTime()));
			stmUpdate.setString(5, this.getCgg_dhu_seguimiento_profesional().getCDSPR_INSTITUCION());
			stmUpdate.setString(6, this.getCgg_dhu_seguimiento_profesional().getCDSPR_CARGO());
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_dhu_seguimiento_profesional().getCDSPR_FECHA_SALIDA().getTime()));
			stmUpdate.setString(8, this.getCgg_dhu_seguimiento_profesional().getCDSPR_OBSERVACIONES());
			stmUpdate.setBoolean(9, this.getCgg_dhu_seguimiento_profesional().getCDSPR_ESTADO());
			stmUpdate.setString(10, this.getCgg_dhu_seguimiento_profesional().getCDSPR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_profesional DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_profesional().getCDSPR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_CODIGO(results.getString(1));
				this.getCgg_dhu_seguimiento_profesional().setCDBEC_CODIGO(results.getString(2));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_ANIO(results.getInt(3));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_FECHA_INGRESO(results.getTimestamp(4));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_INSTITUCION(results.getString(5));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_CARGO(results.getString(6));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_FECHA_SALIDA(results.getTimestamp(7));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_OBSERVACIONES(results.getString(8));
				this.getCgg_dhu_seguimiento_profesional().setCDSPR_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_seguimiento_profesional();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_seguimiento_profesional DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_profesional().getCDSPR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_profesional().getCDSPR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_profesional DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> selectCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional> outCgg_dhu_seguimiento_profesional = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_S_CGG_DHU_BECA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_seguimiento_profesional().getCDBEC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional tmpCgg_dhu_seguimiento_profesional = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_profesional();
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_CODIGO(results.getString(1));
				tmpCgg_dhu_seguimiento_profesional.setCDBEC_CODIGO(results.getString(2));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_ANIO(results.getInt(3));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_FECHA_INGRESO(results.getTimestamp(4));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_INSTITUCION(results.getString(5));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_CARGO(results.getString(6));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_OBSERVACIONES(results.getString(8));
				tmpCgg_dhu_seguimiento_profesional.setCDSPR_ESTADO(results.getBoolean(9));
				outCgg_dhu_seguimiento_profesional.add(tmpCgg_dhu_seguimiento_profesional);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_profesional;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_profesional DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_D_CGG_DHU_BECA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_seguimiento_profesional().getCDBEC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_SEGUIMIENTO_PROFESIONAL_DS_CGG_DHU_BECA(?) }");
				stmDelete.setString(1, this.getCgg_dhu_seguimiento_profesional().getCDBEC_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_profesional QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllSeguimientoProfesional(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_seguimiento_profesional = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_seguimiento_profesional_select_page(?,?,?,?,?,?) }");
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
				outCgg_dhu_seguimiento_profesional.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_seguimiento_profesional;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectBecaProfesional(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SEG_PROFESIONAL(?,?,?,?,?,?) }");
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
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectBecaProfesioanalCount(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SEG_PROFESIONAL_COUNT(?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param in_crper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_sadjunto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectBecaSegProfesional(
		java.sql.Connection inConnection,
		String in_crper_num_doc_identific
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_becaprofesional = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_SEG_PROFESIONAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,in_crper_num_doc_identific);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_becaprofesional.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_becaprofesional;
	}	


}