package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_configuracion
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_configuracion.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_configuracion implements Serializable{
	private static final long serialVersionUID = 1455401164;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_configuracion.
	*/
	private com.besixplus.sii.objects.Cgg_configuracion myCgg_configuracion = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_configuracion.
	*/
	public Cgg_configuracion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_configuracion.
	* @param inCgg_configuracion OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_configuracion.
	*/
	public Cgg_configuracion(
		com.besixplus.sii.objects.Cgg_configuracion inCgg_configuracion
	){
		this.setCgg_configuracion(inCgg_configuracion);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_configuracion.
	* @param inCgg_configuracion OBJETO Cgg_configuracion.
	* @return void
	*/
	public void setCgg_configuracion(com.besixplus.sii.objects.Cgg_configuracion inCgg_configuracion){
		this.myCgg_configuracion = inCgg_configuracion;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_configuracion.
	* @return Cgg_configuracion OBJETO Cgg_configuracion.
	*/
	public com.besixplus.sii.objects.Cgg_configuracion getCgg_configuracion(){
		return this.myCgg_configuracion;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_configuracion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_configuracion().getCGCNF_CODIGO());
			stmInsert.setString(3, this.getCgg_configuracion().getCGCNF_CONFIGURACION());
			stmInsert.setString(4, this.getCgg_configuracion().getCGCNF_VALOR_CADENA());
			stmInsert.setBigDecimal(5, new BigDecimal(this.getCgg_configuracion().getCGCNF_VALOR_NUMERICO()));
			stmInsert.setBoolean(6, this.getCgg_configuracion().getCGCNF_ESTADO());
			stmInsert.setString(7, this.getCgg_configuracion().getCGCNF_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_configuracion().getCGCNF_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_configuracion().setCGCNF_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_configuracion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_configuracion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_configuracion> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_configuracion> outCgg_configuracion = new ArrayList<com.besixplus.sii.objects.Cgg_configuracion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_configuracion tmpCgg_configuracion = new com.besixplus.sii.objects.Cgg_configuracion();
				tmpCgg_configuracion.setCGCNF_CODIGO(results.getString(1));
				tmpCgg_configuracion.setCGCNF_CONFIGURACION(results.getString(2));
				tmpCgg_configuracion.setCGCNF_VALOR_CADENA(results.getString(3));
				tmpCgg_configuracion.setCGCNF_VALOR_NUMERICO(results.getInt(4));
				tmpCgg_configuracion.setCGCNF_ESTADO(results.getBoolean(5));
				outCgg_configuracion.add(tmpCgg_configuracion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_configuracion;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_configuracion QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_configuracion> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_configuracion> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_configuracion> outCgg_configuracion = new ArrayList<com.besixplus.sii.objects.Cgg_configuracion>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_configuracion tmpCgg_configuracion = new com.besixplus.sii.objects.Cgg_configuracion();
				tmpCgg_configuracion.setCGCNF_CODIGO(results.getString(1));
				tmpCgg_configuracion.setCGCNF_CONFIGURACION(results.getString(2));
				tmpCgg_configuracion.setCGCNF_VALOR_CADENA(results.getString(3));
				tmpCgg_configuracion.setCGCNF_VALOR_NUMERICO(results.getBigDecimal(4).intValue());
				tmpCgg_configuracion.setCGCNF_ESTADO(results.getBoolean(5));
				outCgg_configuracion.add(tmpCgg_configuracion);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_configuracion;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_configuracion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_configuracion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_CONFIGURACION_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_configuracion().getCGCNF_CODIGO());
			stmUpdate.setString(2, this.getCgg_configuracion().getCGCNF_CONFIGURACION());
			stmUpdate.setString(3, this.getCgg_configuracion().getCGCNF_VALOR_CADENA());
			stmUpdate.setBigDecimal(4, new BigDecimal(this.getCgg_configuracion().getCGCNF_VALOR_NUMERICO()));
			stmUpdate.setBoolean(5, this.getCgg_configuracion().getCGCNF_ESTADO());
			stmUpdate.setString(6, this.getCgg_configuracion().getCGCNF_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_configuracion DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_configuracion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_configuracion select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_configuracion().getCGCNF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_configuracion().setCGCNF_CODIGO(results.getString(1));
				this.getCgg_configuracion().setCGCNF_CONFIGURACION(results.getString(2));
				this.getCgg_configuracion().setCGCNF_VALOR_CADENA(results.getString(3));
				this.getCgg_configuracion().setCGCNF_VALOR_NUMERICO(results.getBigDecimal(4).intValue());
				this.getCgg_configuracion().setCGCNF_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_configuracion();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_configuracion DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_CONFIGURACION_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_configuracion().getCGCNF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_CONFIGURACION_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_configuracion().getCGCNF_CODIGO());
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
	 * SELECCIONA UN REGISTRO DE TABLA CONFIGURACION EN BASE A SU VALOR DE CONFIGURACION.
	 * @param inConnection CONEXION DE DATOS. 
	 * @return Cgg_configuracion.
	 */
	public com.besixplus.sii.objects.Cgg_configuracion selectCGCNF_CONFIGURACION(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CONFIGURACION_SELECT1(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_configuracion().getCGCNF_CONFIGURACION());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_configuracion().setCGCNF_CODIGO(results.getString(1));
				this.getCgg_configuracion().setCGCNF_CONFIGURACION(results.getString(2));
				this.getCgg_configuracion().setCGCNF_VALOR_CADENA(results.getString(3));
				this.getCgg_configuracion().setCGCNF_VALOR_NUMERICO(results.getBigDecimal(4).intValue());
				this.getCgg_configuracion().setCGCNF_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_configuracion();
	}
	
	
	/**
	* SELECCIONA EL NUMERO DE SECUENCIA CORRESPONDIENTE UTILIZA PARA DATOS DE AMBITO GENERAL.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCgcsn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECUENCIA
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String generaNumero(
		java.sql.Connection inConnection,
		String inCgcsn_codigo
	){
		String outResult ;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_RPT_NUMERO_SECUENCIA(?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2,inCgcsn_codigo);
			stmInsert.execute();
			outResult = stmInsert.getString(1);
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "";
		}
		return outResult;
	}


}