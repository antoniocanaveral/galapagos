package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_requisito
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_requisito.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_requisito implements Serializable{
	private static final long serialVersionUID = 1661105467;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_requisito.
	*/
	private com.besixplus.sii.objects.Cgg_res_requisito myCgg_res_requisito = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_requisito.
	*/
	public Cgg_res_requisito(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_requisito.
	* @param inCgg_res_requisito OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_requisito.
	*/
	public Cgg_res_requisito(
		com.besixplus.sii.objects.Cgg_res_requisito inCgg_res_requisito
	){
		this.setCgg_res_requisito(inCgg_res_requisito);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_requisito.
	* @param inCgg_res_requisito OBJETO Cgg_res_requisito.
	* @return void
	*/
	public void setCgg_res_requisito(com.besixplus.sii.objects.Cgg_res_requisito inCgg_res_requisito){
		this.myCgg_res_requisito = inCgg_res_requisito;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_requisito.
	* @return Cgg_res_requisito OBJETO Cgg_res_requisito.
	*/
	public com.besixplus.sii.objects.Cgg_res_requisito getCgg_res_requisito(){
		return this.myCgg_res_requisito;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_requisito().getCRREQ_CODIGO());
			stmInsert.setString(3, this.getCgg_res_requisito().getCRREQ_DESCRIPCION());
			stmInsert.setString(4, this.getCgg_res_requisito().getCRREQ_OBSERVACION());
			stmInsert.setBoolean(5, this.getCgg_res_requisito().getCRREQ_ESTADO());
			stmInsert.setString(6, this.getCgg_res_requisito().getCRREQ_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_res_requisito().getCRREQ_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_requisito().setCRREQ_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_requisito> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_requisito> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_requisito> outCgg_res_requisito = new ArrayList<com.besixplus.sii.objects.Cgg_res_requisito>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_requisito tmpCgg_res_requisito = new com.besixplus.sii.objects.Cgg_res_requisito();
				tmpCgg_res_requisito.setCRREQ_CODIGO(results.getString(1));
				tmpCgg_res_requisito.setCRREQ_DESCRIPCION(results.getString(2));
				tmpCgg_res_requisito.setCRREQ_OBSERVACION(results.getString(3));
				tmpCgg_res_requisito.setCRREQ_ESTADO(results.getBoolean(4));
				outCgg_res_requisito.add(tmpCgg_res_requisito);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_requisito QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_requisito> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_requisito> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_requisito> outCgg_res_requisito = new ArrayList<com.besixplus.sii.objects.Cgg_res_requisito>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_requisito tmpCgg_res_requisito = new com.besixplus.sii.objects.Cgg_res_requisito();
				tmpCgg_res_requisito.setCRREQ_CODIGO(results.getString(1));
				tmpCgg_res_requisito.setCRREQ_DESCRIPCION(results.getString(2));
				tmpCgg_res_requisito.setCRREQ_OBSERVACION(results.getString(3));
				tmpCgg_res_requisito.setCRREQ_ESTADO(results.getBoolean(4));
				outCgg_res_requisito.add(tmpCgg_res_requisito);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_requisito;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_requisito.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_requisito().getCRREQ_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_requisito().getCRREQ_DESCRIPCION());
			stmUpdate.setString(3, this.getCgg_res_requisito().getCRREQ_OBSERVACION());
			stmUpdate.setBoolean(4, this.getCgg_res_requisito().getCRREQ_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_requisito().getCRREQ_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_requisito DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_requisito OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_requisito select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_REQUISITO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_requisito().getCRREQ_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_requisito().setCRREQ_CODIGO(results.getString(1));
				this.getCgg_res_requisito().setCRREQ_DESCRIPCION(results.getString(2));
				this.getCgg_res_requisito().setCRREQ_OBSERVACION(results.getString(3));
				this.getCgg_res_requisito().setCRREQ_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_requisito();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_requisito DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_requisito().getCRREQ_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_REQUISITO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_requisito().getCRREQ_CODIGO());
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