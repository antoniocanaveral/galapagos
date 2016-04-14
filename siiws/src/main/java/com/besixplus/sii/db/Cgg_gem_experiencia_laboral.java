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
* CLASE Cgg_gem_experiencia_laboral
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_experiencia_laboral.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_experiencia_laboral implements Serializable{
	private static final long serialVersionUID = 1570151609;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_experiencia_laboral.
	*/
	private com.besixplus.sii.objects.Cgg_gem_experiencia_laboral myCgg_gem_experiencia_laboral = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_experiencia_laboral.
	*/
	public Cgg_gem_experiencia_laboral(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_experiencia_laboral.
	* @param inCgg_gem_experiencia_laboral OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_experiencia_laboral.
	*/
	public Cgg_gem_experiencia_laboral(
		com.besixplus.sii.objects.Cgg_gem_experiencia_laboral inCgg_gem_experiencia_laboral
	){
		this.setCgg_gem_experiencia_laboral(inCgg_gem_experiencia_laboral);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_experiencia_laboral.
	* @param inCgg_gem_experiencia_laboral OBJETO Cgg_gem_experiencia_laboral.
	* @return void
	*/
	public void setCgg_gem_experiencia_laboral(com.besixplus.sii.objects.Cgg_gem_experiencia_laboral inCgg_gem_experiencia_laboral){
		this.myCgg_gem_experiencia_laboral = inCgg_gem_experiencia_laboral;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_experiencia_laboral.
	* @return Cgg_gem_experiencia_laboral OBJETO Cgg_gem_experiencia_laboral.
	*/
	public com.besixplus.sii.objects.Cgg_gem_experiencia_laboral getCgg_gem_experiencia_laboral(){
		return this.myCgg_gem_experiencia_laboral;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_experiencia_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_experiencia_laboral().getCGEXL_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_experiencia_laboral().getCRPER_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_gem_experiencia_laboral().getCGEXL_FECHA_INICIO().getTime()));
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_gem_experiencia_laboral().getCGEXL_FECHA_FIN().getTime()));
			stmInsert.setString(6, this.getCgg_gem_experiencia_laboral().getCGEXL_RAZON_SOCIAL());
			stmInsert.setString(7, this.getCgg_gem_experiencia_laboral().getCGEXL_CIUDAD());
			stmInsert.setString(8, this.getCgg_gem_experiencia_laboral().getCGEXL_CARGO());
			stmInsert.setString(9, this.getCgg_gem_experiencia_laboral().getCGEXL_DESCRIPCION());
			stmInsert.setInt(10, this.getCgg_gem_experiencia_laboral().getCGEXL_PERSONAS_CARGO());
			stmInsert.setString(11, this.getCgg_gem_experiencia_laboral().getCGEXL_CONTACTO());
			stmInsert.setString(12, this.getCgg_gem_experiencia_laboral().getCGEXL_TELEFONO());
			stmInsert.setString(13, this.getCgg_gem_experiencia_laboral().getCGEXL_OBSERVACIONES());
			stmInsert.setBoolean(14, this.getCgg_gem_experiencia_laboral().getCGEXL_ESTADO());
			stmInsert.setString(15, this.getCgg_gem_experiencia_laboral().getCGEXL_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_experiencia_laboral().setCGEXL_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_experiencia_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> outCgg_gem_experiencia_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_experiencia_laboral tmpCgg_gem_experiencia_laboral = new com.besixplus.sii.objects.Cgg_gem_experiencia_laboral();
				tmpCgg_gem_experiencia_laboral.setCGEXL_CODIGO(results.getString(1));
				tmpCgg_gem_experiencia_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_experiencia_laboral.setCGEXL_FECHA_INICIO(results.getTimestamp(3));
				tmpCgg_gem_experiencia_laboral.setCGEXL_FECHA_FIN(results.getTimestamp(4));
				tmpCgg_gem_experiencia_laboral.setCGEXL_RAZON_SOCIAL(results.getString(5));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CIUDAD(results.getString(6));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CARGO(results.getString(7));
				tmpCgg_gem_experiencia_laboral.setCGEXL_DESCRIPCION(results.getString(8));
				tmpCgg_gem_experiencia_laboral.setCGEXL_PERSONAS_CARGO(results.getInt(9));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CONTACTO(results.getString(10));
				tmpCgg_gem_experiencia_laboral.setCGEXL_TELEFONO(results.getString(11));
				tmpCgg_gem_experiencia_laboral.setCGEXL_OBSERVACIONES(results.getString(12));
				tmpCgg_gem_experiencia_laboral.setCGEXL_ESTADO(results.getBoolean(13));
				outCgg_gem_experiencia_laboral.add(tmpCgg_gem_experiencia_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_experiencia_laboral;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_experiencia_laboral QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> outCgg_gem_experiencia_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_experiencia_laboral tmpCgg_gem_experiencia_laboral = new com.besixplus.sii.objects.Cgg_gem_experiencia_laboral();
				tmpCgg_gem_experiencia_laboral.setCGEXL_CODIGO(results.getString(1));
				tmpCgg_gem_experiencia_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_experiencia_laboral.setCGEXL_FECHA_INICIO(results.getTimestamp(3));
				tmpCgg_gem_experiencia_laboral.setCGEXL_FECHA_FIN(results.getTimestamp(4));
				tmpCgg_gem_experiencia_laboral.setCGEXL_RAZON_SOCIAL(results.getString(5));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CIUDAD(results.getString(6));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CARGO(results.getString(7));
				tmpCgg_gem_experiencia_laboral.setCGEXL_DESCRIPCION(results.getString(8));
				tmpCgg_gem_experiencia_laboral.setCGEXL_PERSONAS_CARGO(results.getInt(9));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CONTACTO(results.getString(10));
				tmpCgg_gem_experiencia_laboral.setCGEXL_TELEFONO(results.getString(11));
				tmpCgg_gem_experiencia_laboral.setCGEXL_OBSERVACIONES(results.getString(12));
				tmpCgg_gem_experiencia_laboral.setCGEXL_ESTADO(results.getBoolean(13));
				outCgg_gem_experiencia_laboral.add(tmpCgg_gem_experiencia_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_experiencia_laboral;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_experiencia_laboral QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_experiencia_laboral = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_experiencia_laboral.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_experiencia_laboral;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_experiencia_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_experiencia_laboral.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_experiencia_laboral().getCGEXL_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_experiencia_laboral().getCRPER_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_gem_experiencia_laboral().getCGEXL_FECHA_INICIO().getTime()));
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_gem_experiencia_laboral().getCGEXL_FECHA_FIN().getTime()));
			stmUpdate.setString(5, this.getCgg_gem_experiencia_laboral().getCGEXL_RAZON_SOCIAL());
			stmUpdate.setString(6, this.getCgg_gem_experiencia_laboral().getCGEXL_CIUDAD());
			stmUpdate.setString(7, this.getCgg_gem_experiencia_laboral().getCGEXL_CARGO());
			stmUpdate.setString(8, this.getCgg_gem_experiencia_laboral().getCGEXL_DESCRIPCION());
			stmUpdate.setInt(9, this.getCgg_gem_experiencia_laboral().getCGEXL_PERSONAS_CARGO());
			stmUpdate.setString(10, this.getCgg_gem_experiencia_laboral().getCGEXL_CONTACTO());
			stmUpdate.setString(11, this.getCgg_gem_experiencia_laboral().getCGEXL_TELEFONO());
			stmUpdate.setString(12, this.getCgg_gem_experiencia_laboral().getCGEXL_OBSERVACIONES());
			stmUpdate.setBoolean(13, this.getCgg_gem_experiencia_laboral().getCGEXL_ESTADO());
			stmUpdate.setString(14, this.getCgg_gem_experiencia_laboral().getCGEXL_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_experiencia_laboral DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_experiencia_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_experiencia_laboral select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_experiencia_laboral().getCGEXL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_experiencia_laboral().setCGEXL_CODIGO(results.getString(1));
				this.getCgg_gem_experiencia_laboral().setCRPER_CODIGO(results.getString(2));
				this.getCgg_gem_experiencia_laboral().setCGEXL_FECHA_INICIO(results.getTimestamp(3));
				this.getCgg_gem_experiencia_laboral().setCGEXL_FECHA_FIN(results.getTimestamp(4));
				this.getCgg_gem_experiencia_laboral().setCGEXL_RAZON_SOCIAL(results.getString(5));
				this.getCgg_gem_experiencia_laboral().setCGEXL_CIUDAD(results.getString(6));
				this.getCgg_gem_experiencia_laboral().setCGEXL_CARGO(results.getString(7));
				this.getCgg_gem_experiencia_laboral().setCGEXL_DESCRIPCION(results.getString(8));
				this.getCgg_gem_experiencia_laboral().setCGEXL_PERSONAS_CARGO(results.getInt(9));
				this.getCgg_gem_experiencia_laboral().setCGEXL_CONTACTO(results.getString(10));
				this.getCgg_gem_experiencia_laboral().setCGEXL_TELEFONO(results.getString(11));
				this.getCgg_gem_experiencia_laboral().setCGEXL_OBSERVACIONES(results.getString(12));
				this.getCgg_gem_experiencia_laboral().setCGEXL_ESTADO(results.getBoolean(13));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_experiencia_laboral();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_experiencia_laboral DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_experiencia_laboral().getCGEXL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_experiencia_laboral().getCGEXL_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_experiencia_laboral DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_experiencia_laboral OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral> outCgg_gem_experiencia_laboral = new ArrayList<com.besixplus.sii.objects.Cgg_gem_experiencia_laboral>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_experiencia_laboral().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_experiencia_laboral tmpCgg_gem_experiencia_laboral = new com.besixplus.sii.objects.Cgg_gem_experiencia_laboral();
				tmpCgg_gem_experiencia_laboral.setCGEXL_CODIGO(results.getString(1));
				tmpCgg_gem_experiencia_laboral.setCRPER_CODIGO(results.getString(2));
				tmpCgg_gem_experiencia_laboral.setCGEXL_FECHA_INICIO(results.getTimestamp(3));
				tmpCgg_gem_experiencia_laboral.setCGEXL_FECHA_FIN(results.getTimestamp(4));
				tmpCgg_gem_experiencia_laboral.setCGEXL_RAZON_SOCIAL(results.getString(5));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CIUDAD(results.getString(6));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CARGO(results.getString(7));
				tmpCgg_gem_experiencia_laboral.setCGEXL_DESCRIPCION(results.getString(8));
				tmpCgg_gem_experiencia_laboral.setCGEXL_PERSONAS_CARGO(results.getInt(9));
				tmpCgg_gem_experiencia_laboral.setCGEXL_CONTACTO(results.getString(10));
				tmpCgg_gem_experiencia_laboral.setCGEXL_TELEFONO(results.getString(11));
				tmpCgg_gem_experiencia_laboral.setCGEXL_OBSERVACIONES(results.getString(12));
				tmpCgg_gem_experiencia_laboral.setCGEXL_ESTADO(results.getBoolean(13));
				outCgg_gem_experiencia_laboral.add(tmpCgg_gem_experiencia_laboral);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_experiencia_laboral;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_experiencia_laboral DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_gem_experiencia_laboral().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_EXPERIENCIA_LABORAL_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_gem_experiencia_laboral().getCRPER_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectExpLaboralPersonaById(
			java.sql.Connection inConnection,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONA_EXPERIENCIA_LABORAL_BYID(?) }");
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
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCrper_codigo CRITERIO DE BUSQUEDA.
	* @return NUMERO DE REGISTROS.
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_EXPERIENCIA_LABORAL_COUNT_BYID(?,?) }");
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGSITROS QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPageExpLabPersona(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_EXPERIENCIA_LABORAL_SELECTPAGE_BYID(?,?,?,?,?,?,?) }");
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
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
}