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
* CLASE Cgg_res_tipo_contacto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tipo_contacto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tipo_contacto implements Serializable{
	private static final long serialVersionUID = 1590120158;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tipo_contacto.
	*/
	private com.besixplus.sii.objects.Cgg_res_tipo_contacto myCgg_res_tipo_contacto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_contacto.
	*/
	public Cgg_res_tipo_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_contacto.
	* @param inCgg_res_tipo_contacto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tipo_contacto.
	*/
	public Cgg_res_tipo_contacto(
		com.besixplus.sii.objects.Cgg_res_tipo_contacto inCgg_res_tipo_contacto
	){
		this.setCgg_res_tipo_contacto(inCgg_res_tipo_contacto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tipo_contacto.
	* @param inCgg_res_tipo_contacto OBJETO Cgg_res_tipo_contacto.
	* @return void
	*/
	public void setCgg_res_tipo_contacto(com.besixplus.sii.objects.Cgg_res_tipo_contacto inCgg_res_tipo_contacto){
		this.myCgg_res_tipo_contacto = inCgg_res_tipo_contacto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tipo_contacto.
	* @return Cgg_res_tipo_contacto OBJETO Cgg_res_tipo_contacto.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_contacto getCgg_res_tipo_contacto(){
		return this.myCgg_res_tipo_contacto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tipo_contacto().getCRTCO_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tipo_contacto().getCRTCO_NOMBRE());
			stmInsert.setString(4, this.getCgg_res_tipo_contacto().getCRTCO_NOMBRE_IMAGEN());
			stmInsert.setBytes(5, this.getCgg_res_tipo_contacto().getCRTCO_IMAGEN());
			stmInsert.setBoolean(6, this.getCgg_res_tipo_contacto().getCRTCO_ESTADO());
			stmInsert.setString(7, this.getCgg_res_tipo_contacto().getCRTCO_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_res_tipo_contacto().getCRTCO_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_tipo_contacto().setCRTCO_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> outCgg_res_tipo_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_contacto tmpCgg_res_tipo_contacto = new com.besixplus.sii.objects.Cgg_res_tipo_contacto();
				tmpCgg_res_tipo_contacto.setCRTCO_CODIGO(results.getString(1));
				tmpCgg_res_tipo_contacto.setCRTCO_NOMBRE(results.getString(2));
				tmpCgg_res_tipo_contacto.setCRTCO_NOMBRE_IMAGEN(results.getString(3));
				tmpCgg_res_tipo_contacto.setCRTCO_IMAGEN(results.getBytes(4));
				tmpCgg_res_tipo_contacto.setCRTCO_ESTADO(results.getBoolean(5));
				outCgg_res_tipo_contacto.add(tmpCgg_res_tipo_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_contacto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> outCgg_res_tipo_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_tipo_contacto tmpCgg_res_tipo_contacto = new com.besixplus.sii.objects.Cgg_res_tipo_contacto();
				tmpCgg_res_tipo_contacto.setCRTCO_CODIGO(results.getString(1));
				tmpCgg_res_tipo_contacto.setCRTCO_NOMBRE(results.getString(2));
				tmpCgg_res_tipo_contacto.setCRTCO_NOMBRE_IMAGEN(results.getString(3));
				tmpCgg_res_tipo_contacto.setCRTCO_IMAGEN(results.getBytes(4));
				tmpCgg_res_tipo_contacto.setCRTCO_ESTADO(results.getBoolean(5));
				outCgg_res_tipo_contacto.add(tmpCgg_res_tipo_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_contacto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_contacto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_tipo_contacto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_contacto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_CONTACTO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_tipo_contacto().getCRTCO_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tipo_contacto().getCRTCO_NOMBRE());
			stmUpdate.setString(3, this.getCgg_res_tipo_contacto().getCRTCO_NOMBRE_IMAGEN());
			stmUpdate.setBytes(4, this.getCgg_res_tipo_contacto().getCRTCO_IMAGEN());
			stmUpdate.setBoolean(5, this.getCgg_res_tipo_contacto().getCRTCO_ESTADO());
			stmUpdate.setString(6, this.getCgg_res_tipo_contacto().getCRTCO_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tipo_contacto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_contacto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_CONTACTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_contacto().getCRTCO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tipo_contacto().setCRTCO_CODIGO(results.getString(1));
				this.getCgg_res_tipo_contacto().setCRTCO_NOMBRE(results.getString(2));
				this.getCgg_res_tipo_contacto().setCRTCO_NOMBRE_IMAGEN(results.getString(3));
				this.getCgg_res_tipo_contacto().setCRTCO_IMAGEN(results.getBytes(4));
				this.getCgg_res_tipo_contacto().setCRTCO_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tipo_contacto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tipo_contacto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_CONTACTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_contacto().getCRTCO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_CONTACTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_contacto().getCRTCO_CODIGO());
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