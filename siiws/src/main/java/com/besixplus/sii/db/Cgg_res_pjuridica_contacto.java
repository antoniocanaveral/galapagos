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
* CLASE Cgg_res_pjuridica_contacto
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_pjuridica_contacto.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_pjuridica_contacto implements Serializable{
	private static final long serialVersionUID = 622695786;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_pjuridica_contacto.
	*/
	private com.besixplus.sii.objects.Cgg_res_pjuridica_contacto myCgg_res_pjuridica_contacto = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_pjuridica_contacto.
	*/
	public Cgg_res_pjuridica_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_pjuridica_contacto.
	* @param inCgg_res_pjuridica_contacto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_pjuridica_contacto.
	*/
	public Cgg_res_pjuridica_contacto(
		com.besixplus.sii.objects.Cgg_res_pjuridica_contacto inCgg_res_pjuridica_contacto
	){
		this.setCgg_res_pjuridica_contacto(inCgg_res_pjuridica_contacto);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_pjuridica_contacto.
	* @param inCgg_res_pjuridica_contacto OBJETO Cgg_res_pjuridica_contacto.
	* @return void
	*/
	public void setCgg_res_pjuridica_contacto(com.besixplus.sii.objects.Cgg_res_pjuridica_contacto inCgg_res_pjuridica_contacto){
		this.myCgg_res_pjuridica_contacto = inCgg_res_pjuridica_contacto;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_pjuridica_contacto.
	* @return Cgg_res_pjuridica_contacto OBJETO Cgg_res_pjuridica_contacto.
	*/
	public com.besixplus.sii.objects.Cgg_res_pjuridica_contacto getCgg_res_pjuridica_contacto(){
		return this.myCgg_res_pjuridica_contacto;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_pjuridica_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_pjuridica_contacto().getCRPJC_CODIGO());
			stmInsert.setString(3, this.getCgg_res_pjuridica_contacto().getCRPJR_CODIGO());
			stmInsert.setString(4, this.getCgg_res_pjuridica_contacto().getCRTCO_CODIGO());
			stmInsert.setString(5, this.getCgg_res_pjuridica_contacto().getCRPJC_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_res_pjuridica_contacto().getCRPJC_CONTACTO());
			stmInsert.setBoolean(7, this.getCgg_res_pjuridica_contacto().getCRPJC_PRINCIPAL());
			stmInsert.setBoolean(8, this.getCgg_res_pjuridica_contacto().getCRPJC_ESTADO());
			stmInsert.setString(9, this.getCgg_res_pjuridica_contacto().getCRPJC_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_pjuridica_contacto().getCRPJC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_pjuridica_contacto().setCRPJC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> outCgg_res_pjuridica_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_pjuridica_contacto tmpCgg_res_pjuridica_contacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
				tmpCgg_res_pjuridica_contacto.setCRPJC_CODIGO(results.getString(1));
				tmpCgg_res_pjuridica_contacto.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_res_pjuridica_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_res_pjuridica_contacto.setCRPJC_DESCRIPCION(results.getString(4));
				tmpCgg_res_pjuridica_contacto.setCRPJC_CONTACTO(results.getString(5));
				tmpCgg_res_pjuridica_contacto.setCRPJC_PRINCIPAL(results.getBoolean(6));
				tmpCgg_res_pjuridica_contacto.setCRPJC_ESTADO(results.getBoolean(7));
				outCgg_res_pjuridica_contacto.add(tmpCgg_res_pjuridica_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_pjuridica_contacto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> outCgg_res_pjuridica_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_pjuridica_contacto tmpCgg_res_pjuridica_contacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
				tmpCgg_res_pjuridica_contacto.setCRPJC_CODIGO(results.getString(1));
				tmpCgg_res_pjuridica_contacto.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_res_pjuridica_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_res_pjuridica_contacto.setCRPJC_DESCRIPCION(results.getString(4));
				tmpCgg_res_pjuridica_contacto.setCRPJC_CONTACTO(results.getString(5));
				tmpCgg_res_pjuridica_contacto.setCRPJC_PRINCIPAL(results.getBoolean(6));
				tmpCgg_res_pjuridica_contacto.setCRPJC_ESTADO(results.getBoolean(7));
				outCgg_res_pjuridica_contacto.add(tmpCgg_res_pjuridica_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_pjuridica_contacto;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO. 
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_pjuridica_contacto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_pjuridica_contacto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_pjuridica_contacto;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_pjuridica_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_pjuridica_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_pjuridica_contacto().getCRPJC_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_pjuridica_contacto().getCRPJR_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_pjuridica_contacto().getCRTCO_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_pjuridica_contacto().getCRPJC_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_res_pjuridica_contacto().getCRPJC_CONTACTO());
			stmUpdate.setBoolean(6, this.getCgg_res_pjuridica_contacto().getCRPJC_PRINCIPAL());
			stmUpdate.setBoolean(7, this.getCgg_res_pjuridica_contacto().getCRPJC_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_pjuridica_contacto().getCRPJC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_pjuridica_contacto DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_pjuridica_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_pjuridica_contacto select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_pjuridica_contacto().getCRPJC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_pjuridica_contacto().setCRPJC_CODIGO(results.getString(1));
				this.getCgg_res_pjuridica_contacto().setCRPJR_CODIGO(results.getString(2));
				this.getCgg_res_pjuridica_contacto().setCRTCO_CODIGO(results.getString(3));
				this.getCgg_res_pjuridica_contacto().setCRPJC_DESCRIPCION(results.getString(4));
				this.getCgg_res_pjuridica_contacto().setCRPJC_CONTACTO(results.getString(5));
				this.getCgg_res_pjuridica_contacto().setCRPJC_PRINCIPAL(results.getBoolean(6));
				this.getCgg_res_pjuridica_contacto().setCRPJC_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_pjuridica_contacto();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_pjuridica_contacto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_pjuridica_contacto().getCRPJC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_pjuridica_contacto().getCRPJC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_pjuridica_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> selectCGG_RES_TIPO_CONTACTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> outCgg_res_pjuridica_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_S_CGG_RES_TIPO_CONTACTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_pjuridica_contacto().getCRTCO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_pjuridica_contacto tmpCgg_res_pjuridica_contacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
				tmpCgg_res_pjuridica_contacto.setCRPJC_CODIGO(results.getString(1));
				tmpCgg_res_pjuridica_contacto.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_res_pjuridica_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_res_pjuridica_contacto.setCRPJC_DESCRIPCION(results.getString(4));
				tmpCgg_res_pjuridica_contacto.setCRPJC_CONTACTO(results.getString(5));
				tmpCgg_res_pjuridica_contacto.setCRPJC_PRINCIPAL(results.getBoolean(6));
				tmpCgg_res_pjuridica_contacto.setCRPJC_ESTADO(results.getBoolean(7));
				outCgg_res_pjuridica_contacto.add(tmpCgg_res_pjuridica_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_pjuridica_contacto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_contacto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_CONTACTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_D_CGG_RES_TIPO_CONTACTO(?) }");
			stmDelete.setString(1, this.getCgg_res_pjuridica_contacto().getCRTCO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_DS_CGG_RES_TIPO_CONTACTO(?) }");
				stmDelete.setString(1, this.getCgg_res_pjuridica_contacto().getCRTCO_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_pjuridica_contacto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto> outCgg_res_pjuridica_contacto = new ArrayList<com.besixplus.sii.objects.Cgg_res_pjuridica_contacto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PJURIDICA_CONTACTO_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_pjuridica_contacto().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_pjuridica_contacto tmpCgg_res_pjuridica_contacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
				tmpCgg_res_pjuridica_contacto.setCRPJC_CODIGO(results.getString(1));
				tmpCgg_res_pjuridica_contacto.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_res_pjuridica_contacto.setCRTCO_CODIGO(results.getString(3));
				tmpCgg_res_pjuridica_contacto.setCRPJC_DESCRIPCION(results.getString(4));
				tmpCgg_res_pjuridica_contacto.setCRPJC_CONTACTO(results.getString(5));
				tmpCgg_res_pjuridica_contacto.setCRPJC_PRINCIPAL(results.getBoolean(6));
				tmpCgg_res_pjuridica_contacto.setCRPJC_ESTADO(results.getBoolean(7));
				outCgg_res_pjuridica_contacto.add(tmpCgg_res_pjuridica_contacto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_pjuridica_contacto;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_pjuridica_contacto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_res_pjuridica_contacto().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PJURIDICA_CONTACTO_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_res_pjuridica_contacto().getCRPJR_CODIGO());
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