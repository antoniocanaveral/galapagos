package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_sec_rol
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_rol.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_rol implements Serializable{
	private static final long serialVersionUID = 1479695842;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_rol.
	*/
	private com.besixplus.sii.objects.Cgg_sec_rol myCgg_sec_rol = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_rol.
	*/
	public Cgg_sec_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_rol.
	* @param inCgg_sec_rol OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_rol.
	*/
	public Cgg_sec_rol(
		com.besixplus.sii.objects.Cgg_sec_rol inCgg_sec_rol
	){
		this.setCgg_sec_rol(inCgg_sec_rol);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_rol.
	* @param inCgg_sec_rol OBJETO Cgg_sec_rol.
	* @return void
	*/
	public void setCgg_sec_rol(com.besixplus.sii.objects.Cgg_sec_rol inCgg_sec_rol){
		this.myCgg_sec_rol = inCgg_sec_rol;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_rol.
	* @return Cgg_sec_rol OBJETO Cgg_sec_rol.
	*/
	public com.besixplus.sii.objects.Cgg_sec_rol getCgg_sec_rol(){
		return this.myCgg_sec_rol;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_ROL_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_rol().getCSROL_CODIGO());
			stmInsert.setString(3, this.getCgg_sec_rol().getCSROL_NOMBRE());
			stmInsert.setBoolean(4, this.getCgg_sec_rol().getCSROL_ESTADO());
			stmInsert.setString(5, this.getCgg_sec_rol().getCSROL_USUARIO_INSERT());
			stmInsert.setString(6, this.getCgg_sec_rol().getCSROL_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_sec_rol().setCSROL_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_rol> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_rol> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_rol> outCgg_sec_rol = new ArrayList<com.besixplus.sii.objects.Cgg_sec_rol>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_ROL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sec_rol tmpCgg_sec_rol = new com.besixplus.sii.objects.Cgg_sec_rol();
				tmpCgg_sec_rol.setCSROL_CODIGO(results.getString(1));
				tmpCgg_sec_rol.setCSROL_NOMBRE(results.getString(2));
				tmpCgg_sec_rol.setCSROL_ESTADO(results.getBoolean(3));
				outCgg_sec_rol.add(tmpCgg_sec_rol);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_rol;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_rol QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sec_rol> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sec_rol> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sec_rol> outCgg_sec_rol = new ArrayList<com.besixplus.sii.objects.Cgg_sec_rol>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_ROL_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_sec_rol tmpCgg_sec_rol = new com.besixplus.sii.objects.Cgg_sec_rol();
				tmpCgg_sec_rol.setCSROL_CODIGO(results.getString(1));
				tmpCgg_sec_rol.setCSROL_NOMBRE(results.getString(2));
				tmpCgg_sec_rol.setCSROL_ESTADO(results.getBoolean(3));
				outCgg_sec_rol.add(tmpCgg_sec_rol);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sec_rol;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sec_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_ROL_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_ROL_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sec_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SEC_ROL_UPDATE(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sec_rol().getCSROL_CODIGO());
			stmUpdate.setString(2, this.getCgg_sec_rol().getCSROL_NOMBRE());
			stmUpdate.setBoolean(3, this.getCgg_sec_rol().getCSROL_ESTADO());
			stmUpdate.setString(4, this.getCgg_sec_rol().getCSROL_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sec_rol DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sec_rol OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sec_rol select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_ROL_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sec_rol().getCSROL_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sec_rol().setCSROL_CODIGO(results.getString(1));
				this.getCgg_sec_rol().setCSROL_NOMBRE(results.getString(2));
				this.getCgg_sec_rol().setCSROL_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sec_rol();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sec_rol DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_ROL_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sec_rol().getCSROL_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SEC_ROL_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sec_rol().getCSROL_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}

}