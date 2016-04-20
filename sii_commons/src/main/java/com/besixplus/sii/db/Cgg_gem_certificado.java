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
* CLASE Cgg_gem_certificado
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_certificado.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_certificado implements Serializable{
	private static final long serialVersionUID = 2076567976;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_certificado.
	*/
	private com.besixplus.sii.objects.Cgg_gem_certificado myCgg_gem_certificado = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_certificado.
	*/
	public Cgg_gem_certificado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_certificado.
	* @param inCgg_gem_certificado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_certificado.
	*/
	public Cgg_gem_certificado(
		com.besixplus.sii.objects.Cgg_gem_certificado inCgg_gem_certificado
	){
		this.setCgg_gem_certificado(inCgg_gem_certificado);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_certificado.
	* @param inCgg_gem_certificado OBJETO Cgg_gem_certificado.
	* @return void
	*/
	public void setCgg_gem_certificado(com.besixplus.sii.objects.Cgg_gem_certificado inCgg_gem_certificado){
		this.myCgg_gem_certificado = inCgg_gem_certificado;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_certificado.
	* @return Cgg_gem_certificado OBJETO Cgg_gem_certificado.
	*/
	public com.besixplus.sii.objects.Cgg_gem_certificado getCgg_gem_certificado(){
		return this.myCgg_gem_certificado;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_INSERT(?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_certificado().getCGCER_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_certificado().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_certificado().getCGCER_INSTITUCION());
			stmInsert.setString(5, this.getCgg_gem_certificado().getCGCER_NOMBRE());
			stmInsert.setString(6, this.getCgg_gem_certificado().getCGCER_DESCRIPCION());
			stmInsert.setInt(7, this.getCgg_gem_certificado().getCGCER_DURACION());
			stmInsert.setTimestamp(8, this.getCgg_gem_certificado().getCGCER_FECHA_INICIO() == null ?null: new java.sql.Timestamp(this.getCgg_gem_certificado().getCGCER_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(9, this.getCgg_gem_certificado().getCGCER_FECHA_FIN() == null ?null :new java.sql.Timestamp(this.getCgg_gem_certificado().getCGCER_FECHA_FIN().getTime()));
			stmInsert.setString(10, this.getCgg_gem_certificado().getCGCER_TIPO_ADJUNTO());
			stmInsert.setString(11, this.getCgg_gem_certificado().getCGCER_NOMBRE_ADJUNTO());
			stmInsert.setBytes(12, this.getCgg_gem_certificado().getCGCER_ADJUNTO());
			stmInsert.setString(13, this.getCgg_gem_certificado().getCGCER_OBSERVACION());
			stmInsert.setInt(14, this.getCgg_gem_certificado().getCGCER_TIPO());
			stmInsert.setBoolean(15, this.getCgg_gem_certificado().getCGCER_ESTADO());
			stmInsert.setString(16, this.getCgg_gem_certificado().getCGCER_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_certificado().setCGCER_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> outCgg_gem_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_certificado tmpCgg_gem_certificado = new com.besixplus.sii.objects.Cgg_gem_certificado();
				tmpCgg_gem_certificado.setCGCER_CODIGO(results.getString(1));
				tmpCgg_gem_certificado.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_certificado.setCGCER_INSTITUCION(results.getString(3));
				tmpCgg_gem_certificado.setCGCER_NOMBRE(results.getString(4));
				tmpCgg_gem_certificado.setCGCER_DESCRIPCION(results.getString(5));
				tmpCgg_gem_certificado.setCGCER_DURACION(results.getInt(6));
				tmpCgg_gem_certificado.setCGCER_FECHA_INICIO(results.getTimestamp(7));
				tmpCgg_gem_certificado.setCGCER_FECHA_FIN(results.getTimestamp(8));
				tmpCgg_gem_certificado.setCGCER_TIPO_ADJUNTO(results.getString(9));
				tmpCgg_gem_certificado.setCGCER_NOMBRE_ADJUNTO(results.getString(10));
				tmpCgg_gem_certificado.setCGCER_ADJUNTO(results.getBytes(11));
				tmpCgg_gem_certificado.setCGCER_OBSERVACION(results.getString(12));
				tmpCgg_gem_certificado.setCGCER_TIPO(results.getInt(13));
				tmpCgg_gem_certificado.setCGCER_ESTADO(results.getBoolean(14));
				outCgg_gem_certificado.add(tmpCgg_gem_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_certificado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> outCgg_gem_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_certificado tmpCgg_gem_certificado = new com.besixplus.sii.objects.Cgg_gem_certificado();
				tmpCgg_gem_certificado.setCGCER_CODIGO(results.getString(1));
				tmpCgg_gem_certificado.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_certificado.setCGCER_INSTITUCION(results.getString(3));
				tmpCgg_gem_certificado.setCGCER_NOMBRE(results.getString(4));
				tmpCgg_gem_certificado.setCGCER_DESCRIPCION(results.getString(5));
				tmpCgg_gem_certificado.setCGCER_DURACION(results.getInt(6));
				tmpCgg_gem_certificado.setCGCER_FECHA_INICIO(results.getTimestamp(7));
				tmpCgg_gem_certificado.setCGCER_FECHA_FIN(results.getTimestamp(8));
				tmpCgg_gem_certificado.setCGCER_TIPO_ADJUNTO(results.getString(9));
				tmpCgg_gem_certificado.setCGCER_NOMBRE_ADJUNTO(results.getString(10));
				tmpCgg_gem_certificado.setCGCER_ADJUNTO(results.getBytes(11));
				tmpCgg_gem_certificado.setCGCER_OBSERVACION(results.getString(12));
				tmpCgg_gem_certificado.setCGCER_TIPO(results.getInt(13));
				tmpCgg_gem_certificado.setCGCER_ESTADO(results.getBoolean(14));
				outCgg_gem_certificado.add(tmpCgg_gem_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_certificado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_certificado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_certificado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_certificado;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_CERTIFICADO_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_certificado().getCGCER_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_certificado().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_certificado().getCGCER_INSTITUCION());
			stmUpdate.setString(4, this.getCgg_gem_certificado().getCGCER_NOMBRE());
			stmUpdate.setString(5, this.getCgg_gem_certificado().getCGCER_DESCRIPCION());
			stmUpdate.setInt(6, this.getCgg_gem_certificado().getCGCER_DURACION());
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_gem_certificado().getCGCER_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(8, new java.sql.Timestamp(this.getCgg_gem_certificado().getCGCER_FECHA_FIN().getTime()));
			stmUpdate.setString(9, this.getCgg_gem_certificado().getCGCER_TIPO_ADJUNTO());
			stmUpdate.setString(10, this.getCgg_gem_certificado().getCGCER_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(11, this.getCgg_gem_certificado().getCGCER_ADJUNTO());
			stmUpdate.setString(12, this.getCgg_gem_certificado().getCGCER_OBSERVACION());
			stmUpdate.setInt(13, this.getCgg_gem_certificado().getCGCER_TIPO());
			stmUpdate.setBoolean(14, this.getCgg_gem_certificado().getCGCER_ESTADO());
			stmUpdate.setString(15, this.getCgg_gem_certificado().getCGCER_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_certificado DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_certificado select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_certificado().getCGCER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_certificado().setCGCER_CODIGO(results.getString(1));
				this.getCgg_gem_certificado().setCRPER_CODIGO(results.getString(2));
				this.getCgg_gem_certificado().setCGCER_INSTITUCION(results.getString(3));
				this.getCgg_gem_certificado().setCGCER_NOMBRE(results.getString(4));
				this.getCgg_gem_certificado().setCGCER_DESCRIPCION(results.getString(5));
				this.getCgg_gem_certificado().setCGCER_DURACION(results.getInt(6));
				this.getCgg_gem_certificado().setCGCER_FECHA_INICIO(results.getTimestamp(7));
				this.getCgg_gem_certificado().setCGCER_FECHA_FIN(results.getTimestamp(8));
				this.getCgg_gem_certificado().setCGCER_TIPO_ADJUNTO(results.getString(9));
				this.getCgg_gem_certificado().setCGCER_NOMBRE_ADJUNTO(results.getString(10));
				this.getCgg_gem_certificado().setCGCER_ADJUNTO(results.getBytes(11));
				this.getCgg_gem_certificado().setCGCER_OBSERVACION(results.getString(12));
				this.getCgg_gem_certificado().setCGCER_TIPO(results.getInt(13));
				this.getCgg_gem_certificado().setCGCER_ESTADO(results.getBoolean(14));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_certificado();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_certificado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CERTIFICADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_certificado().getCGCER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CERTIFICADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_certificado().getCGCER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_certificado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> outCgg_gem_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CERTIFICADO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_certificado().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_certificado tmpCgg_gem_certificado = new com.besixplus.sii.objects.Cgg_gem_certificado();
				tmpCgg_gem_certificado.setCGCER_CODIGO(results.getString(1));
				tmpCgg_gem_certificado.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_certificado.setCGCER_INSTITUCION(results.getString(3));
				tmpCgg_gem_certificado.setCGCER_NOMBRE(results.getString(4));
				tmpCgg_gem_certificado.setCGCER_DESCRIPCION(results.getString(5));
				tmpCgg_gem_certificado.setCGCER_DURACION(results.getInt(6));
				tmpCgg_gem_certificado.setCGCER_FECHA_INICIO(results.getTimestamp(7));
				tmpCgg_gem_certificado.setCGCER_FECHA_FIN(results.getTimestamp(8));
				tmpCgg_gem_certificado.setCGCER_TIPO_ADJUNTO(results.getString(9));
				tmpCgg_gem_certificado.setCGCER_NOMBRE_ADJUNTO(results.getString(10));
				tmpCgg_gem_certificado.setCGCER_ADJUNTO(results.getBytes(11));
				tmpCgg_gem_certificado.setCGCER_OBSERVACION(results.getString(12));
				tmpCgg_gem_certificado.setCGCER_TIPO(results.getInt(13));
				tmpCgg_gem_certificado.setCGCER_ESTADO(results.getBoolean(14));
				outCgg_gem_certificado.add(tmpCgg_gem_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_certificado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_certificado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CERTIFICADO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_gem_certificado().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CERTIFICADO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_gem_certificado().getCRPER_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA. 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectCertificadosPersonaById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_certificado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONA_CERTIFICADO_BYID(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_certificado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_certificado;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int selectCountById(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCrper_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			//return selectCount(inConnection);
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.f_cgg_res_persona_certificados_countById(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3,inCrper_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCrper_codigo CRITERIO DE BUSQUEDA. CODIGO DE LA PERSONA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	
	public static ArrayList<HashMap<String,Object>> selectPageCertificadosPersona(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_certificado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_CERTIFICADO_SELECTPAGE_BYID_PER(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_certificado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_certificado;
	}

}