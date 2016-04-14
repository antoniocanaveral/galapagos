package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_garantia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_garantia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_garantia implements Serializable{
	private static final long serialVersionUID = 615570516;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_garantia.
	*/
	private com.besixplus.sii.objects.Cgg_res_garantia myCgg_res_garantia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_garantia.
	*/
	public Cgg_res_garantia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_garantia.
	* @param inCgg_res_garantia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_garantia.
	*/
	public Cgg_res_garantia(
		com.besixplus.sii.objects.Cgg_res_garantia inCgg_res_garantia
	){
		this.setCgg_res_garantia(inCgg_res_garantia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_garantia.
	* @param inCgg_res_garantia OBJETO Cgg_res_garantia.
	* @return void
	*/
	public void setCgg_res_garantia(com.besixplus.sii.objects.Cgg_res_garantia inCgg_res_garantia){
		this.myCgg_res_garantia = inCgg_res_garantia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_garantia.
	* @return Cgg_res_garantia OBJETO Cgg_res_garantia.
	*/
	public com.besixplus.sii.objects.Cgg_res_garantia getCgg_res_garantia(){
		return this.myCgg_res_garantia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_garantia().getCRGRT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_garantia().getCRGRT_DESCRPCION());
			stmInsert.setBigDecimal(4, this.getCgg_res_garantia().getCRGRT_VALOR());
			stmInsert.setBoolean(5, this.getCgg_res_garantia().getCRGRT_ESTADO());
			stmInsert.setString(6, this.getCgg_res_garantia().getCRGRT_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_res_garantia().getCRGRT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_garantia().setCRGRT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_garantia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_garantia> outCgg_res_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_garantia tmpCgg_res_garantia = new com.besixplus.sii.objects.Cgg_res_garantia();
				tmpCgg_res_garantia.setCRGRT_CODIGO(results.getString(1));
				tmpCgg_res_garantia.setCRGRT_DESCRPCION(results.getString(2));
				tmpCgg_res_garantia.setCRGRT_VALOR(results.getBigDecimal(3));
				tmpCgg_res_garantia.setCRGRT_ESTADO(results.getBoolean(4));
				outCgg_res_garantia.add(tmpCgg_res_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_garantia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_garantia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_garantia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_garantia> outCgg_res_garantia = new ArrayList<com.besixplus.sii.objects.Cgg_res_garantia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_garantia tmpCgg_res_garantia = new com.besixplus.sii.objects.Cgg_res_garantia();
				tmpCgg_res_garantia.setCRGRT_CODIGO(results.getString(1));
				tmpCgg_res_garantia.setCRGRT_DESCRPCION(results.getString(2));
				tmpCgg_res_garantia.setCRGRT_VALOR(results.getBigDecimal(3));
				tmpCgg_res_garantia.setCRGRT_ESTADO(results.getBoolean(4));
				outCgg_res_garantia.add(tmpCgg_res_garantia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_garantia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_garantia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_garantia().getCRGRT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_garantia().getCRGRT_DESCRPCION());
			stmUpdate.setBigDecimal(3, this.getCgg_res_garantia().getCRGRT_VALOR());
			stmUpdate.setBoolean(4, this.getCgg_res_garantia().getCRGRT_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_garantia().getCRGRT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_garantia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_garantia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_garantia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_GARANTIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_garantia().getCRGRT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_garantia().setCRGRT_CODIGO(results.getString(1));
				this.getCgg_res_garantia().setCRGRT_DESCRPCION(results.getString(2));
				this.getCgg_res_garantia().setCRGRT_VALOR(results.getBigDecimal(3));
				this.getCgg_res_garantia().setCRGRT_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_garantia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_garantia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_garantia().getCRGRT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_GARANTIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_garantia().getCRGRT_CODIGO());
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