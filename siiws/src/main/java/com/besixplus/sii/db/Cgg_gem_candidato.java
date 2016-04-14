package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

//import javax.jws.WebParam;

/**
* CLASE Cgg_gem_candidato
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_candidato.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_candidato implements Serializable{
	private static final long serialVersionUID = 599210971;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_candidato.
	*/
	private com.besixplus.sii.objects.Cgg_gem_candidato myCgg_gem_candidato = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_candidato.
	*/
	public Cgg_gem_candidato(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_candidato.
	* @param inCgg_gem_candidato OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_candidato.
	*/
	public Cgg_gem_candidato(
		com.besixplus.sii.objects.Cgg_gem_candidato inCgg_gem_candidato
	){
		this.setCgg_gem_candidato(inCgg_gem_candidato);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_candidato.
	* @param inCgg_gem_candidato OBJETO Cgg_gem_candidato.
	* @return void
	*/
	public void setCgg_gem_candidato(com.besixplus.sii.objects.Cgg_gem_candidato inCgg_gem_candidato){
		this.myCgg_gem_candidato = inCgg_gem_candidato;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_candidato.
	* @return Cgg_gem_candidato OBJETO Cgg_gem_candidato.
	*/
	public com.besixplus.sii.objects.Cgg_gem_candidato getCgg_gem_candidato(){
		return this.myCgg_gem_candidato;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_candidato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_candidato().getCGCND_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_candidato().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_candidato().getCGVCN_CODIGO());
			stmInsert.setBigDecimal(5, this.getCgg_gem_candidato().getCGCND_ASPIRACION_SALARIAL());
			stmInsert.setString(6, this.getCgg_gem_candidato().getCGCND_OBSERVACION());
			stmInsert.setBoolean(7, this.getCgg_gem_candidato().getCGCND_ESTADO());
			stmInsert.setString(8, this.getCgg_gem_candidato().getCGCND_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_candidato().setCGCND_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_candidato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> outCgg_gem_candidato = new ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_candidato tmpCgg_gem_candidato = new com.besixplus.sii.objects.Cgg_gem_candidato();
				tmpCgg_gem_candidato.setCGCND_CODIGO(results.getString(1));
				tmpCgg_gem_candidato.setCUSU_CODIGO(results.getString(2));
				tmpCgg_gem_candidato.setCGVCN_CODIGO(results.getString(3));
				tmpCgg_gem_candidato.setCGCND_FECHA_ENTREVISTA(results.getTimestamp(4));
				tmpCgg_gem_candidato.setCGCND_ASPIRACION_SALARIAL(results.getBigDecimal(5));
				tmpCgg_gem_candidato.setCGCND_OBSERVACION(results.getString(6));
				tmpCgg_gem_candidato.setCGCND_DESCRIPCION(results.getString(7));
				tmpCgg_gem_candidato.setCGCND_SELECCIONADO(results.getInt(8));
				tmpCgg_gem_candidato.setCGCND_ESTADO(results.getBoolean(9));
				outCgg_gem_candidato.add(tmpCgg_gem_candidato);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_candidato;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_candidato QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> outCgg_gem_candidato = new ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_candidato tmpCgg_gem_candidato = new com.besixplus.sii.objects.Cgg_gem_candidato();
				tmpCgg_gem_candidato.setCGCND_CODIGO(results.getString(1));
				tmpCgg_gem_candidato.setCUSU_CODIGO(results.getString(2));
				tmpCgg_gem_candidato.setCGVCN_CODIGO(results.getString(3));
				tmpCgg_gem_candidato.setCGCND_FECHA_ENTREVISTA(results.getTimestamp(4));
				tmpCgg_gem_candidato.setCGCND_ASPIRACION_SALARIAL(results.getBigDecimal(5));
				tmpCgg_gem_candidato.setCGCND_OBSERVACION(results.getString(6));
				tmpCgg_gem_candidato.setCGCND_DESCRIPCION(results.getString(7));
				tmpCgg_gem_candidato.setCGCND_SELECCIONADO(results.getInt(8));
				tmpCgg_gem_candidato.setCGCND_ESTADO(results.getBoolean(9));
				outCgg_gem_candidato.add(tmpCgg_gem_candidato);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_candidato;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_candidato QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE.
	* @param inTipo IDENTIFICATIVO DE CANDIDATO EN CASO QUE SEA PARA ENTREVISTA O VACANTE.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCgvcn_codigo,
		String inTipo
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_candidato = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_S_CGG_GEM_VACANTE(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, inStart);
			stmSelect.setInt(3, inLimit);
			stmSelect.setString(4, inSortFieldName);
			stmSelect.setString(5, inDirection);
			stmSelect.setString(6, inKeyword);
			stmSelect.setString(7, inCgvcn_codigo);
			stmSelect.setString(8, inTipo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_candidato.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_candidato;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_candidato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_COUNT() }");
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
	 * @param inTipo IDENTIFICATIVO DE CANDIDATO EN CASO QUE SEA PARA ENTREVISTA O VACANTE.
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inTipo,
		String inCgvcn_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword = " ";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inTipo);
			stmSelect.setString(4, inCgvcn_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_candidato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){		
		String rowsUpdate="";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{?=call sii.F_CGG_GEM_CANDIDATO_UPDATE(?, ?, ?,?,?, ?::smallint, ?,?) }");			
			stmUpdate.registerOutParameter(1, Types.INTEGER);
			stmUpdate.setString(2, this.getCgg_gem_candidato().getCGCND_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_gem_candidato().getCGCND_FECHA_ENTREVISTA().getTime()));
			stmUpdate.setString(4, this.getCgg_gem_candidato().getCGCND_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_gem_candidato().getCGCND_OBSERVACION());
			stmUpdate.setString(6, this.getCgg_gem_candidato().getCGCND_DETALLE());
			stmUpdate.setInt(7, this.getCgg_gem_candidato().getCGCND_SELECCIONADO());
			stmUpdate.setString(8, this.getCgg_gem_candidato().getCGCND_USUARIO_UPDATE());
			stmUpdate.setString(9, this.getCgg_gem_candidato().getCGVCN_CODIGO());			
			stmUpdate.executeUpdate();
			rowsUpdate = String.valueOf(stmUpdate.getInt(1));
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			rowsUpdate = e.getMessage();
		}		
		return rowsUpdate;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_candidato DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_candidato OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_candidato select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_candidato().getCGCND_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_candidato().setCGCND_CODIGO(results.getString(1));
				this.getCgg_gem_candidato().setCUSU_CODIGO(results.getString(2));
				this.getCgg_gem_candidato().setCGVCN_CODIGO(results.getString(3));
				this.getCgg_gem_candidato().setCGCND_FECHA_ENTREVISTA(results.getTimestamp(4));
				this.getCgg_gem_candidato().setCGCND_ASPIRACION_SALARIAL(results.getBigDecimal(5));
				this.getCgg_gem_candidato().setCGCND_OBSERVACION(results.getString(6));
				this.getCgg_gem_candidato().setCGCND_DESCRIPCION(results.getString(7));
				this.getCgg_gem_candidato().setCGCND_SELECCIONADO(results.getInt(8));
				this.getCgg_gem_candidato().setCGCND_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_candidato();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_candidato DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CANDIDATO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_candidato().getCGCND_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CANDIDATO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_candidato().getCGCND_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_candidato DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inTipo IDENTIFICATIVO DE CANDIDATO EN CASO QUE SEA PARA ENTREVISTA O VACANTE.
	* @return com.besixplus.sii.objects.Cgg_gem_candidato OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> selectCGG_GEM_VACANTE(
		java.sql.Connection inConnection,
		String inTipo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> outCgg_gem_candidato = new ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_S_CGG_GEM_VACANTE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.setString(2,inTipo);
			stmSelect.setString(3,this.getCgg_gem_candidato().getCGVCN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_candidato tmpCgg_gem_candidato = new com.besixplus.sii.objects.Cgg_gem_candidato();
				tmpCgg_gem_candidato.setCGCND_CODIGO(results.getString(1));
				tmpCgg_gem_candidato.setCUSU_CODIGO(results.getString(2));
				tmpCgg_gem_candidato.setCGVCN_CODIGO(results.getString(3));
				tmpCgg_gem_candidato.setCGCND_FECHA_ENTREVISTA(results.getTimestamp(4));
				tmpCgg_gem_candidato.setCGCND_ASPIRACION_SALARIAL(results.getBigDecimal(5));
				tmpCgg_gem_candidato.setCGCND_OBSERVACION(results.getString(6));
				tmpCgg_gem_candidato.setCGCND_DESCRIPCION(results.getString(7));
				tmpCgg_gem_candidato.setCGCND_SELECCIONADO(results.getInt(8));
				tmpCgg_gem_candidato.setCGCND_ESTADO(results.getBoolean(9));
				outCgg_gem_candidato.add(tmpCgg_gem_candidato);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_candidato;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_candidato DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_VACANTE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CANDIDATO_D_CGG_GEM_VACANTE(?) }");
			stmDelete.setString(1, this.getCgg_gem_candidato().getCGVCN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CANDIDATO_DS_CGG_GEM_VACANTE(?) }");
				stmDelete.setString(1, this.getCgg_gem_candidato().getCGVCN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_candidato DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_candidato OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato> outCgg_gem_candidato = new ArrayList<com.besixplus.sii.objects.Cgg_gem_candidato>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_candidato().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_candidato tmpCgg_gem_candidato = new com.besixplus.sii.objects.Cgg_gem_candidato();
				tmpCgg_gem_candidato.setCGCND_CODIGO(results.getString(1));
				tmpCgg_gem_candidato.setCUSU_CODIGO(results.getString(2));
				tmpCgg_gem_candidato.setCGVCN_CODIGO(results.getString(3));
				tmpCgg_gem_candidato.setCGCND_FECHA_ENTREVISTA(results.getTimestamp(4));
				tmpCgg_gem_candidato.setCGCND_ASPIRACION_SALARIAL(results.getBigDecimal(5));
				tmpCgg_gem_candidato.setCGCND_OBSERVACION(results.getString(6));
				tmpCgg_gem_candidato.setCGCND_DESCRIPCION(results.getString(7));
				tmpCgg_gem_candidato.setCGCND_SELECCIONADO(results.getInt(8));
				tmpCgg_gem_candidato.setCGCND_ESTADO(results.getBoolean(9));
				outCgg_gem_candidato.add(tmpCgg_gem_candidato);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_candidato;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_candidato DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_USUARIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CANDIDATO_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_gem_candidato().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_CANDIDATO_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_gem_candidato().getCUSU_CODIGO());
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
	 * @return NUMERO DE REGISTROS.
	 */
	public static BigDecimal selectCountLite(
			java.sql.Connection inConnection,
			String inKeyword
	){
		BigDecimal outCount = new BigDecimal(0);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_COUNT_LITE(?) }");
			stmSelect.registerOutParameter(1, Types.NUMERIC);
			stmSelect.setString(2, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getBigDecimal(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<LinkedHashMap<String,Object>> selectAllLite(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword			
	){
		ArrayList<LinkedHashMap<String,Object>> outCgg_res_persona = new ArrayList<LinkedHashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_CANDIDATO_SELECT_LITE(?,?,?,?,?,?) }");
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
				LinkedHashMap<String,Object> tmpObj = new LinkedHashMap<String,Object>();
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