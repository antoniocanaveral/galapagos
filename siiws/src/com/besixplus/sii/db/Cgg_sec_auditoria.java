package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_sec_auditoria
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_auditoria.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_auditoria implements Serializable{
	private static final long serialVersionUID = 943946304;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_auditoria.
	*/
	private com.besixplus.sii.objects.Cgg_sec_auditoria myCgg_sec_auditoria = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_auditoria.
	*/
	public Cgg_sec_auditoria(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_auditoria.
	* @param inCgg_sec_auditoria OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_auditoria.
	*/
	public Cgg_sec_auditoria(
		com.besixplus.sii.objects.Cgg_sec_auditoria inCgg_sec_auditoria
	){
		this.setCgg_sec_auditoria(inCgg_sec_auditoria);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_auditoria.
	* @param inCgg_sec_auditoria OBJETO Cgg_sec_auditoria.
	* @return void
	*/
	public void setCgg_sec_auditoria(com.besixplus.sii.objects.Cgg_sec_auditoria inCgg_sec_auditoria){
		this.myCgg_sec_auditoria = inCgg_sec_auditoria;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_auditoria.
	* @return Cgg_sec_auditoria OBJETO Cgg_sec_auditoria.
	*/
	public com.besixplus.sii.objects.Cgg_sec_auditoria getCgg_sec_auditoria(){
		return this.myCgg_sec_auditoria;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_auditoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_AUDITORIA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_auditoria().getCSADT_CODIGO());
			stmInsert.setTimestamp(3, new java.sql.Timestamp(this.getCgg_sec_auditoria().getCSADT_FECHA().getTime()));
			stmInsert.setString(4, this.getCgg_sec_auditoria().getCSADT_USUARIO());
			stmInsert.setString(5, this.getCgg_sec_auditoria().getCSADT_IP());
			stmInsert.setString(6, this.getCgg_sec_auditoria().getCSADT_SESION());
			stmInsert.setString(7, this.getCgg_sec_auditoria().getCSADT_TABLA());
			stmInsert.setString(8, this.getCgg_sec_auditoria().getCSADT_OPERACION());
			stmInsert.setString(9, this.getCgg_sec_auditoria().getCSADT_DATO_ANTIGUO());
			stmInsert.setString(10, this.getCgg_sec_auditoria().getCSADT_DATO_NUEVO());
			stmInsert.execute();
			this.getCgg_sec_auditoria().setCSADT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_auditoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> outCgg_sec_auditoria = new ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_AUDITORIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_auditoria tmpCgg_sec_auditoria = new com.besixplus.sii.objects.Cgg_sec_auditoria();
				tmpCgg_sec_auditoria.setCSADT_CODIGO(results.getString(1));
				tmpCgg_sec_auditoria.setCSADT_FECHA(results.getTimestamp(2));
				tmpCgg_sec_auditoria.setCSADT_USUARIO(results.getString(3));
				tmpCgg_sec_auditoria.setCSADT_IP(results.getString(4));
				tmpCgg_sec_auditoria.setCSADT_SESION(results.getString(5));
				tmpCgg_sec_auditoria.setCSADT_TABLA(results.getString(6));
				tmpCgg_sec_auditoria.setCSADT_OPERACION(results.getString(7));
				tmpCgg_sec_auditoria.setCSADT_DATO_ANTIGUO(results.getString(8));
				tmpCgg_sec_auditoria.setCSADT_DATO_NUEVO(results.getString(9));
				outCgg_sec_auditoria.add(tmpCgg_sec_auditoria);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_auditoria;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_auditoria QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> outCgg_sec_auditoria = new ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_AUDITORIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_sec_auditoria tmpCgg_sec_auditoria = new com.besixplus.sii.objects.Cgg_sec_auditoria();
				tmpCgg_sec_auditoria.setCSADT_CODIGO(results.getString(1));
				tmpCgg_sec_auditoria.setCSADT_FECHA(results.getTimestamp(2));
				tmpCgg_sec_auditoria.setCSADT_USUARIO(results.getString(3));
				tmpCgg_sec_auditoria.setCSADT_IP(results.getString(4));
				tmpCgg_sec_auditoria.setCSADT_SESION(results.getString(5));
				tmpCgg_sec_auditoria.setCSADT_TABLA(results.getString(6));
				tmpCgg_sec_auditoria.setCSADT_OPERACION(results.getString(7));
				tmpCgg_sec_auditoria.setCSADT_DATO_ANTIGUO(results.getString(8));
				tmpCgg_sec_auditoria.setCSADT_DATO_NUEVO(results.getString(9));
				outCgg_sec_auditoria.add(tmpCgg_sec_auditoria);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_auditoria;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sec_auditoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_AUDITORIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_AUDITORIA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sec_auditoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SEC_AUDITORIA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sec_auditoria().getCSADT_CODIGO());
			stmUpdate.setTimestamp(2, new java.sql.Timestamp(this.getCgg_sec_auditoria().getCSADT_FECHA().getTime()));
			stmUpdate.setString(3, this.getCgg_sec_auditoria().getCSADT_USUARIO());
			stmUpdate.setString(4, this.getCgg_sec_auditoria().getCSADT_IP());
			stmUpdate.setString(5, this.getCgg_sec_auditoria().getCSADT_SESION());
			stmUpdate.setString(6, this.getCgg_sec_auditoria().getCSADT_TABLA());
			stmUpdate.setString(7, this.getCgg_sec_auditoria().getCSADT_OPERACION());
			stmUpdate.setString(8, this.getCgg_sec_auditoria().getCSADT_DATO_ANTIGUO());
			stmUpdate.setString(9, this.getCgg_sec_auditoria().getCSADT_DATO_NUEVO());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_auditoria DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_auditoria OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_auditoria select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_AUDITORIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_auditoria().getCSADT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_auditoria().setCSADT_CODIGO(results.getString(1));
				this.getCgg_sec_auditoria().setCSADT_FECHA(results.getTimestamp(2));
				this.getCgg_sec_auditoria().setCSADT_USUARIO(results.getString(3));
				this.getCgg_sec_auditoria().setCSADT_IP(results.getString(4));
				this.getCgg_sec_auditoria().setCSADT_SESION(results.getString(5));
				this.getCgg_sec_auditoria().setCSADT_TABLA(results.getString(6));
				this.getCgg_sec_auditoria().setCSADT_OPERACION(results.getString(7));
				this.getCgg_sec_auditoria().setCSADT_DATO_ANTIGUO(results.getString(8));
				this.getCgg_sec_auditoria().setCSADT_DATO_NUEVO(results.getString(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_auditoria();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sec_auditoria DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_AUDITORIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sec_auditoria().getCSADT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_AUDITORIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sec_auditoria().getCSADT_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

}