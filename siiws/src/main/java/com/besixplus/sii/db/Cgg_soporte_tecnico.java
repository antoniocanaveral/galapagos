package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_soporte_tecnico
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_soporte_tecnico.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_soporte_tecnico implements Serializable{
	private static final long serialVersionUID = 1606475760;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_soporte_tecnico.
	*/
	private com.besixplus.sii.objects.Cgg_soporte_tecnico myCgg_soporte_tecnico = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_soporte_tecnico.
	*/
	public Cgg_soporte_tecnico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_soporte_tecnico.
	* @param inCgg_soporte_tecnico OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_soporte_tecnico.
	*/
	public Cgg_soporte_tecnico(
		com.besixplus.sii.objects.Cgg_soporte_tecnico inCgg_soporte_tecnico
	){
		this.setCgg_soporte_tecnico(inCgg_soporte_tecnico);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_soporte_tecnico.
	* @param inCgg_soporte_tecnico OBJETO Cgg_soporte_tecnico.
	* @return void
	*/
	public void setCgg_soporte_tecnico(com.besixplus.sii.objects.Cgg_soporte_tecnico inCgg_soporte_tecnico){
		this.myCgg_soporte_tecnico = inCgg_soporte_tecnico;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_soporte_tecnico.
	* @return Cgg_soporte_tecnico OBJETO Cgg_soporte_tecnico.
	*/
	public com.besixplus.sii.objects.Cgg_soporte_tecnico getCgg_soporte_tecnico(){
		return this.myCgg_soporte_tecnico;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_soporte_tecnico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SOPORTE_TECNICO_INSERT(?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_soporte_tecnico().getCSOTE_CODIGO());
			stmInsert.setString(3, this.getCgg_soporte_tecnico().getCSOTE_ASUNTO());
			stmInsert.setString(4, this.getCgg_soporte_tecnico().getCSOTE_NUMERO());
			stmInsert.setString(5, this.getCgg_soporte_tecnico().getCSOTE_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_soporte_tecnico().getCSOTE_CONTACTO());
			stmInsert.setInt(7, this.getCgg_soporte_tecnico().getCSOTE_ATENDIDO());
			stmInsert.setBoolean(8, this.getCgg_soporte_tecnico().getCSOTE_ESTADO());
			stmInsert.setString(9, this.getCgg_soporte_tecnico().getCSOTE_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_soporte_tecnico().getCSOTE_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_soporte_tecnico().setCSOTE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_soporte_tecnico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico> outCgg_soporte_tecnico = new ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SOPORTE_TECNICO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_soporte_tecnico tmpCgg_soporte_tecnico = new com.besixplus.sii.objects.Cgg_soporte_tecnico();
				tmpCgg_soporte_tecnico.setCSOTE_CODIGO(results.getString(1));
				tmpCgg_soporte_tecnico.setCSOTE_ASUNTO(results.getString(2));
				tmpCgg_soporte_tecnico.setCSOTE_NUMERO(results.getString(3));
				tmpCgg_soporte_tecnico.setCSOTE_DESCRIPCION(results.getString(4));
				tmpCgg_soporte_tecnico.setCSOTE_CONTACTO(results.getString(5));
				tmpCgg_soporte_tecnico.setCSOTE_ATENDIDO(results.getInt(6));
				tmpCgg_soporte_tecnico.setCSOTE_ESTADO(results.getBoolean(7));
				outCgg_soporte_tecnico.add(tmpCgg_soporte_tecnico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_soporte_tecnico;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_soporte_tecnico QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico> outCgg_soporte_tecnico = new ArrayList<com.besixplus.sii.objects.Cgg_soporte_tecnico>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SOPORTE_TECNICO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_soporte_tecnico tmpCgg_soporte_tecnico = new com.besixplus.sii.objects.Cgg_soporte_tecnico();
				tmpCgg_soporte_tecnico.setCSOTE_CODIGO(results.getString(1));
				tmpCgg_soporte_tecnico.setCSOTE_ASUNTO(results.getString(2));
				tmpCgg_soporte_tecnico.setCSOTE_NUMERO(results.getString(3));
				tmpCgg_soporte_tecnico.setCSOTE_DESCRIPCION(results.getString(4));
				tmpCgg_soporte_tecnico.setCSOTE_CONTACTO(results.getString(5));
				tmpCgg_soporte_tecnico.setCSOTE_ATENDIDO(results.getInt(6));
				tmpCgg_soporte_tecnico.setCSOTE_ESTADO(results.getBoolean(7));
				outCgg_soporte_tecnico.add(tmpCgg_soporte_tecnico);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_soporte_tecnico;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_soporte_tecnico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SOPORTE_TECNICO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SOPORTE_TECNICO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_soporte_tecnico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SOPORTE_TECNICO_UPDATE(?, ?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_soporte_tecnico().getCSOTE_CODIGO());
			stmUpdate.setString(2, this.getCgg_soporte_tecnico().getCSOTE_ASUNTO());
			stmUpdate.setString(3, this.getCgg_soporte_tecnico().getCSOTE_NUMERO());
			stmUpdate.setString(4, this.getCgg_soporte_tecnico().getCSOTE_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_soporte_tecnico().getCSOTE_CONTACTO());
			stmUpdate.setInt(6, this.getCgg_soporte_tecnico().getCSOTE_ATENDIDO());
			stmUpdate.setBoolean(7, this.getCgg_soporte_tecnico().getCSOTE_ESTADO());
			stmUpdate.setString(8, this.getCgg_soporte_tecnico().getCSOTE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_soporte_tecnico DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_soporte_tecnico OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_soporte_tecnico select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SOPORTE_TECNICO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_soporte_tecnico().getCSOTE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_soporte_tecnico().setCSOTE_CODIGO(results.getString(1));
				this.getCgg_soporte_tecnico().setCSOTE_ASUNTO(results.getString(2));
				this.getCgg_soporte_tecnico().setCSOTE_NUMERO(results.getString(3));
				this.getCgg_soporte_tecnico().setCSOTE_DESCRIPCION(results.getString(4));
				this.getCgg_soporte_tecnico().setCSOTE_CONTACTO(results.getString(5));
				this.getCgg_soporte_tecnico().setCSOTE_ATENDIDO(results.getInt(6));
				this.getCgg_soporte_tecnico().setCSOTE_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_soporte_tecnico();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_soporte_tecnico DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SOPORTE_TECNICO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_soporte_tecnico().getCSOTE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SOPORTE_TECNICO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_soporte_tecnico().getCSOTE_CODIGO());
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