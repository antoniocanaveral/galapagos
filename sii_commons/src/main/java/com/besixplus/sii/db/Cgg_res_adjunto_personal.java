package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_adjunto_personal
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_adjunto_personal.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_adjunto_personal implements Serializable{
	private static final long serialVersionUID = 190147660;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_adjunto_personal.
	*/
	private com.besixplus.sii.objects.Cgg_res_adjunto_personal myCgg_res_adjunto_personal = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto_personal.
	*/
	public Cgg_res_adjunto_personal(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto_personal.
	* @param inCgg_res_adjunto_personal OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_adjunto_personal.
	*/
	public Cgg_res_adjunto_personal(
		com.besixplus.sii.objects.Cgg_res_adjunto_personal inCgg_res_adjunto_personal
	){
		this.setCgg_res_adjunto_personal(inCgg_res_adjunto_personal);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_adjunto_personal.
	* @param inCgg_res_adjunto_personal OBJETO Cgg_res_adjunto_personal.
	* @return void
	*/
	public void setCgg_res_adjunto_personal(com.besixplus.sii.objects.Cgg_res_adjunto_personal inCgg_res_adjunto_personal){
		this.myCgg_res_adjunto_personal = inCgg_res_adjunto_personal;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_adjunto_personal.
	* @return Cgg_res_adjunto_personal OBJETO Cgg_res_adjunto_personal.
	*/
	public com.besixplus.sii.objects.Cgg_res_adjunto_personal getCgg_res_adjunto_personal(){
		return this.myCgg_res_adjunto_personal;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_adjunto_personal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_adjunto_personal().getCRADP_CODIGO());
			stmInsert.setString(3, this.getCgg_res_adjunto_personal().getCRPER_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_adjunto_personal().getCRADP_FECHA_REGISTRO().getTime()));
			stmInsert.setString(5, this.getCgg_res_adjunto_personal().getCRADP_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_res_adjunto_personal().getCRADP_NOMBRE_ADJUNTO());
			stmInsert.setBytes(7, this.getCgg_res_adjunto_personal().getCRADP_ADJUNTO());
			stmInsert.setBoolean(8, this.getCgg_res_adjunto_personal().getCRADP_ESTADO());
			stmInsert.setString(9, this.getCgg_res_adjunto_personal().getCRADP_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_adjunto_personal().getCRADP_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_adjunto_personal().setCRADP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto_personal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> outCgg_res_adjunto_personal = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto_personal tmpCgg_res_adjunto_personal = new com.besixplus.sii.objects.Cgg_res_adjunto_personal();
				tmpCgg_res_adjunto_personal.setCRADP_CODIGO(results.getString(1));
				tmpCgg_res_adjunto_personal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto_personal.setCRADP_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_adjunto_personal.setCRADP_DESCRIPCION(results.getString(4));
				tmpCgg_res_adjunto_personal.setCRADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_res_adjunto_personal.setCRADP_ADJUNTO(results.getBytes(6));
				tmpCgg_res_adjunto_personal.setCRADP_ESTADO(results.getBoolean(7));
				outCgg_res_adjunto_personal.add(tmpCgg_res_adjunto_personal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto_personal;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto_personal QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> outCgg_res_adjunto_personal = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_adjunto_personal tmpCgg_res_adjunto_personal = new com.besixplus.sii.objects.Cgg_res_adjunto_personal();
				tmpCgg_res_adjunto_personal.setCRADP_CODIGO(results.getString(1));
				tmpCgg_res_adjunto_personal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto_personal.setCRADP_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_adjunto_personal.setCRADP_DESCRIPCION(results.getString(4));
				tmpCgg_res_adjunto_personal.setCRADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_res_adjunto_personal.setCRADP_ADJUNTO(results.getBytes(6));
				tmpCgg_res_adjunto_personal.setCRADP_ESTADO(results.getBoolean(7));
				outCgg_res_adjunto_personal.add(tmpCgg_res_adjunto_personal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto_personal;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_adjunto_personal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_adjunto_personal.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_PERSONAL_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_adjunto_personal().getCRADP_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_adjunto_personal().getCRPER_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_res_adjunto_personal().getCRADP_FECHA_REGISTRO().getTime()));
			stmUpdate.setString(4, this.getCgg_res_adjunto_personal().getCRADP_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_res_adjunto_personal().getCRADP_NOMBRE_ADJUNTO());
			stmUpdate.setBytes(6, this.getCgg_res_adjunto_personal().getCRADP_ADJUNTO());
			stmUpdate.setBoolean(7, this.getCgg_res_adjunto_personal().getCRADP_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_adjunto_personal().getCRADP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_adjunto_personal DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_adjunto_personal OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_adjunto_personal select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto_personal().getCRADP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_adjunto_personal().setCRADP_CODIGO(results.getString(1));
				this.getCgg_res_adjunto_personal().setCRPER_CODIGO(results.getString(2));
				this.getCgg_res_adjunto_personal().setCRADP_FECHA_REGISTRO(results.getTimestamp(3));
				this.getCgg_res_adjunto_personal().setCRADP_DESCRIPCION(results.getString(4));
				this.getCgg_res_adjunto_personal().setCRADP_NOMBRE_ADJUNTO(results.getString(5));
				this.getCgg_res_adjunto_personal().setCRADP_ADJUNTO(results.getBytes(6));
				this.getCgg_res_adjunto_personal().setCRADP_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_adjunto_personal();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_adjunto_personal DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_PERSONAL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto_personal().getCRADP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_PERSONAL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto_personal().getCRADP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto_personal DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_adjunto_personal OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal> outCgg_res_adjunto_personal = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto_personal>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_ADJUNTO_PERSONAL_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_adjunto_personal().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_adjunto_personal tmpCgg_res_adjunto_personal = new com.besixplus.sii.objects.Cgg_res_adjunto_personal();
				tmpCgg_res_adjunto_personal.setCRADP_CODIGO(results.getString(1));
				tmpCgg_res_adjunto_personal.setCRPER_CODIGO(results.getString(2));
				tmpCgg_res_adjunto_personal.setCRADP_FECHA_REGISTRO(results.getTimestamp(3));
				tmpCgg_res_adjunto_personal.setCRADP_DESCRIPCION(results.getString(4));
				tmpCgg_res_adjunto_personal.setCRADP_NOMBRE_ADJUNTO(results.getString(5));
				tmpCgg_res_adjunto_personal.setCRADP_ADJUNTO(results.getBytes(6));
				tmpCgg_res_adjunto_personal.setCRADP_ESTADO(results.getBoolean(7));
				outCgg_res_adjunto_personal.add(tmpCgg_res_adjunto_personal);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_adjunto_personal;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_adjunto_personal DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_PERSONAL_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_res_adjunto_personal().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_ADJUNTO_PERSONAL_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_res_adjunto_personal().getCRPER_CODIGO());
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