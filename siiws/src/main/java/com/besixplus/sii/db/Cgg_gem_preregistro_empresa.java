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
* CLASE Cgg_gem_preregistro_empresa
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_preregistro_empresa.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_preregistro_empresa implements Serializable{
	private static final long serialVersionUID = 182062477;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_preregistro_empresa.
	*/
	private com.besixplus.sii.objects.Cgg_gem_preregistro_empresa myCgg_gem_preregistro_empresa = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_preregistro_empresa.
	*/
	public Cgg_gem_preregistro_empresa(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_preregistro_empresa.
	* @param inCgg_gem_preregistro_empresa OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_preregistro_empresa.
	*/
	public Cgg_gem_preregistro_empresa(
		com.besixplus.sii.objects.Cgg_gem_preregistro_empresa inCgg_gem_preregistro_empresa
	){
		this.setCgg_gem_preregistro_empresa(inCgg_gem_preregistro_empresa);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_preregistro_empresa.
	* @param inCgg_gem_preregistro_empresa OBJETO Cgg_gem_preregistro_empresa.
	* @return void
	*/
	public void setCgg_gem_preregistro_empresa(com.besixplus.sii.objects.Cgg_gem_preregistro_empresa inCgg_gem_preregistro_empresa){
		this.myCgg_gem_preregistro_empresa = inCgg_gem_preregistro_empresa;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_preregistro_empresa.
	* @return Cgg_gem_preregistro_empresa OBJETO Cgg_gem_preregistro_empresa.
	*/
	public com.besixplus.sii.objects.Cgg_gem_preregistro_empresa getCgg_gem_preregistro_empresa(){
		return this.myCgg_gem_preregistro_empresa;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_preregistro_empresa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_INSERT(?, ?, ?, ?, ?::date, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?,?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_preregistro_empresa().getCGPRE_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_preregistro_empresa().getCGPRE_RAZON_SOCIAL());
			stmInsert.setString(4, this.getCgg_gem_preregistro_empresa().getCGPRE_RUC());
			stmInsert.setString(5, this.getCgg_gem_preregistro_empresa().getCGPRE_REPRESENTANTE());
			stmInsert.setDate(6, new java.sql.Date(this.getCgg_gem_preregistro_empresa().getCGPRE_FECHA_CREACION().getTime()));
			stmInsert.setString(7, this.getCgg_gem_preregistro_empresa().getCGPRE_ACTIVIDAD());
			stmInsert.setString(8, this.getCgg_gem_preregistro_empresa().getCGPRE_DIRECCION());
			stmInsert.setString(9, this.getCgg_gem_preregistro_empresa().getCGPRE_SECTOR());
			stmInsert.setString(10, this.getCgg_gem_preregistro_empresa().getCGPRE_TIPO());
			stmInsert.setInt(11, this.getCgg_gem_preregistro_empresa().getCGPRE_NUMERO_EMPLEADO());
			stmInsert.setString(12, this.getCgg_gem_preregistro_empresa().getCGPRE_TELEFONO());
			stmInsert.setString(13, this.getCgg_gem_preregistro_empresa().getCGPRE_EMAIL());
			stmInsert.setString(14, this.getCgg_gem_preregistro_empresa().getCGPRE_CEDULA());
			stmInsert.setBytes(15, this.getCgg_gem_preregistro_empresa().getCGPRE_ADJUNTO());
			stmInsert.setString(16, this.getCgg_gem_preregistro_empresa().getCGPRE_TIPO_ADJUNTO());
			stmInsert.setString(17, this.getCgg_gem_preregistro_empresa().getCGPRE_NOMBRE_ADJUNTO());
			stmInsert.setString(18, this.getCgg_gem_preregistro_empresa().getCGPRE_CISLA_CODIGO());
			stmInsert.setBoolean(19, this.getCgg_gem_preregistro_empresa().getCGPRE_ESTADO());
			stmInsert.setString(20, this.getCgg_gem_preregistro_empresa().getCGPRE_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_preregistro_empresa().setCGPRE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_preregistro_empresa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> outCgg_gem_preregistro_empresa = new ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_preregistro_empresa tmpCgg_gem_preregistro_empresa = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
				tmpCgg_gem_preregistro_empresa.setCGPRE_CODIGO(results.getString(1));
				tmpCgg_gem_preregistro_empresa.setCGPRE_RAZON_SOCIAL(results.getString(2));
				tmpCgg_gem_preregistro_empresa.setCGPRE_RUC(results.getString(3));
				tmpCgg_gem_preregistro_empresa.setCGPRE_REPRESENTANTE(results.getString(4));
				tmpCgg_gem_preregistro_empresa.setCGPRE_FECHA_CREACION(results.getDate(5));
				tmpCgg_gem_preregistro_empresa.setCGPRE_ACTIVIDAD(results.getString(6));
				tmpCgg_gem_preregistro_empresa.setCGPRE_DIRECCION(results.getString(7));
				tmpCgg_gem_preregistro_empresa.setCGPRE_SECTOR(results.getString(8));
				tmpCgg_gem_preregistro_empresa.setCGPRE_TIPO(results.getString(9));
				tmpCgg_gem_preregistro_empresa.setCGPRE_NUMERO_EMPLEADO(results.getInt(10));
				tmpCgg_gem_preregistro_empresa.setCGPRE_TELEFONO(results.getString(11));
				tmpCgg_gem_preregistro_empresa.setCGPRE_EMAIL(results.getString(12));
				tmpCgg_gem_preregistro_empresa.setCGPRE_CEDULA(results.getString(13));
				tmpCgg_gem_preregistro_empresa.setCGPRE_ADJUNTO(results.getBytes(14));
				tmpCgg_gem_preregistro_empresa.setCGPRE_TIPO_ADJUNTO(results.getString(15));
				tmpCgg_gem_preregistro_empresa.setCGPRE_NOMBRE_ADJUNTO(results.getString(16));
				tmpCgg_gem_preregistro_empresa.setCGPRE_ESTADO(results.getBoolean(17));
				outCgg_gem_preregistro_empresa.add(tmpCgg_gem_preregistro_empresa);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_preregistro_empresa;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_preregistro_empresa QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> outCgg_gem_preregistro_empresa = new ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_preregistro_empresa tmpCgg_gem_preregistro_empresa = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
				tmpCgg_gem_preregistro_empresa.setCGPRE_CODIGO(results.getString(1));
				tmpCgg_gem_preregistro_empresa.setCGPRE_RAZON_SOCIAL(results.getString(2));
				tmpCgg_gem_preregistro_empresa.setCGPRE_RUC(results.getString(3));
				tmpCgg_gem_preregistro_empresa.setCGPRE_REPRESENTANTE(results.getString(4));
				tmpCgg_gem_preregistro_empresa.setCGPRE_FECHA_CREACION(results.getDate(5));
				tmpCgg_gem_preregistro_empresa.setCGPRE_ACTIVIDAD(results.getString(6));
				tmpCgg_gem_preregistro_empresa.setCGPRE_DIRECCION(results.getString(7));
				tmpCgg_gem_preregistro_empresa.setCGPRE_SECTOR(results.getString(8));
				tmpCgg_gem_preregistro_empresa.setCGPRE_TIPO(results.getString(9));
				tmpCgg_gem_preregistro_empresa.setCGPRE_NUMERO_EMPLEADO(results.getInt(10));
				tmpCgg_gem_preregistro_empresa.setCGPRE_TELEFONO(results.getString(11));
				tmpCgg_gem_preregistro_empresa.setCGPRE_EMAIL(results.getString(12));
				tmpCgg_gem_preregistro_empresa.setCGPRE_CEDULA(results.getString(13));
//				tmpCgg_gem_preregistro_empresa.setCGPRE_ADJUNTO(results.getBytes(14));
				tmpCgg_gem_preregistro_empresa.setCGPRE_TIPO_ADJUNTO(results.getString(14));
				tmpCgg_gem_preregistro_empresa.setCGPRE_NOMBRE_ADJUNTO(results.getString(15));
				tmpCgg_gem_preregistro_empresa.setCGPRE_CCTN_CODIGO(results.getString(16));
				tmpCgg_gem_preregistro_empresa.setCGPRE_CISLA_CODIGO(results.getString(17));
				tmpCgg_gem_preregistro_empresa.setCGPRE_ESTADO(results.getBoolean(18));
				outCgg_gem_preregistro_empresa.add(tmpCgg_gem_preregistro_empresa);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_preregistro_empresa;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_preregistro_empresa QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_preregistro_empresa = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_preregistro_empresa.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_preregistro_empresa;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_preregistro_empresa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_preregistro_empresa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_UPDATE(?, ?, ?, ?, ?::date, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_preregistro_empresa().getCGPRE_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_preregistro_empresa().getCGPRE_RAZON_SOCIAL());
			stmUpdate.setString(3, this.getCgg_gem_preregistro_empresa().getCGPRE_RUC());
			stmUpdate.setString(4, this.getCgg_gem_preregistro_empresa().getCGPRE_REPRESENTANTE());
			stmUpdate.setDate(5, new java.sql.Date(this.getCgg_gem_preregistro_empresa().getCGPRE_FECHA_CREACION().getTime()));
			stmUpdate.setString(6, this.getCgg_gem_preregistro_empresa().getCGPRE_ACTIVIDAD());
			stmUpdate.setString(7, this.getCgg_gem_preregistro_empresa().getCGPRE_DIRECCION());
			stmUpdate.setString(8, this.getCgg_gem_preregistro_empresa().getCGPRE_SECTOR());
			stmUpdate.setString(9, this.getCgg_gem_preregistro_empresa().getCGPRE_TIPO());
			stmUpdate.setInt(10, this.getCgg_gem_preregistro_empresa().getCGPRE_NUMERO_EMPLEADO());
			stmUpdate.setString(11, this.getCgg_gem_preregistro_empresa().getCGPRE_TELEFONO());
			stmUpdate.setString(12, this.getCgg_gem_preregistro_empresa().getCGPRE_EMAIL());
			stmUpdate.setString(13, this.getCgg_gem_preregistro_empresa().getCGPRE_CEDULA());
			stmUpdate.setBytes(14, this.getCgg_gem_preregistro_empresa().getCGPRE_ADJUNTO());
			stmUpdate.setString(15, this.getCgg_gem_preregistro_empresa().getCGPRE_TIPO_ADJUNTO());
			stmUpdate.setString(16, this.getCgg_gem_preregistro_empresa().getCGPRE_NOMBRE_ADJUNTO());
			stmUpdate.setBoolean(17, this.getCgg_gem_preregistro_empresa().getCGPRE_ESTADO());
			stmUpdate.setString(18, this.getCgg_gem_preregistro_empresa().getCGPRE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_preregistro_empresa DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_preregistro_empresa OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_preregistro_empresa select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_preregistro_empresa().getCGPRE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_preregistro_empresa().setCGPRE_CODIGO(results.getString(1));
				this.getCgg_gem_preregistro_empresa().setCGPRE_RAZON_SOCIAL(results.getString(2));
				this.getCgg_gem_preregistro_empresa().setCGPRE_RUC(results.getString(3));
				this.getCgg_gem_preregistro_empresa().setCGPRE_REPRESENTANTE(results.getString(4));
				this.getCgg_gem_preregistro_empresa().setCGPRE_FECHA_CREACION(results.getDate(5));
				this.getCgg_gem_preregistro_empresa().setCGPRE_ACTIVIDAD(results.getString(6));
				this.getCgg_gem_preregistro_empresa().setCGPRE_DIRECCION(results.getString(7));
				this.getCgg_gem_preregistro_empresa().setCGPRE_SECTOR(results.getString(8));
				this.getCgg_gem_preregistro_empresa().setCGPRE_TIPO(results.getString(9));
				this.getCgg_gem_preregistro_empresa().setCGPRE_NUMERO_EMPLEADO(results.getInt(10));
				this.getCgg_gem_preregistro_empresa().setCGPRE_TELEFONO(results.getString(11));
				this.getCgg_gem_preregistro_empresa().setCGPRE_EMAIL(results.getString(12));
				this.getCgg_gem_preregistro_empresa().setCGPRE_CEDULA(results.getString(13));
				this.getCgg_gem_preregistro_empresa().setCGPRE_ADJUNTO(results.getBytes(14));
				this.getCgg_gem_preregistro_empresa().setCGPRE_TIPO_ADJUNTO(results.getString(15));
				this.getCgg_gem_preregistro_empresa().setCGPRE_NOMBRE_ADJUNTO(results.getString(16));
				this.getCgg_gem_preregistro_empresa().setCGPRE_ESTADO(results.getBoolean(17));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_preregistro_empresa();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_preregistro_empresa DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_preregistro_empresa().getCGPRE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_preregistro_empresa().getCGPRE_CODIGO());
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_preregistro_empresa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String updateAdjunto(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_UPDATE_ADJUNTO( ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_preregistro_empresa().getCGPRE_CODIGO());
			stmUpdate.setBytes(2, this.getCgg_gem_preregistro_empresa().getCGPRE_ADJUNTO());
			stmUpdate.setString(3, this.getCgg_gem_preregistro_empresa().getCGPRE_TIPO_ADJUNTO());
			stmUpdate.setString(4, this.getCgg_gem_preregistro_empresa().getCGPRE_NOMBRE_ADJUNTO());
			stmUpdate.setBoolean(5, this.getCgg_gem_preregistro_empresa().getCGPRE_ESTADO());
			stmUpdate.setString(6, this.getCgg_gem_preregistro_empresa().getCGPRE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA.
	* @param inCrpjr CRITERIO DE BUSQUEDA. CODIGO DE LA EMPRESA JURIDICA
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static String selectCodigoByRUC(
		java.sql.Connection inConnection,
		String inCrpjr_codigo
	){
		String outCodigo = "";		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PREREGISTRO_EMPRESA_SELECTCODIGO_BYRUC(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setString(2, inCrpjr_codigo);
			stmSelect.execute();
			outCodigo = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCodigo;
	}
}