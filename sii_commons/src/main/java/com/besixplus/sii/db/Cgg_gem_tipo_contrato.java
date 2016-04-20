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
* CLASE Cgg_gem_tipo_contrato
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_tipo_contrato.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_tipo_contrato implements Serializable{
	private static final long serialVersionUID = 1548315605;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_tipo_contrato.
	*/
	private com.besixplus.sii.objects.Cgg_gem_tipo_contrato myCgg_gem_tipo_contrato = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_tipo_contrato.
	*/
	public Cgg_gem_tipo_contrato(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_tipo_contrato.
	* @param inCgg_gem_tipo_contrato OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_tipo_contrato.
	*/
	public Cgg_gem_tipo_contrato(
		com.besixplus.sii.objects.Cgg_gem_tipo_contrato inCgg_gem_tipo_contrato
	){
		this.setCgg_gem_tipo_contrato(inCgg_gem_tipo_contrato);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_tipo_contrato.
	* @param inCgg_gem_tipo_contrato OBJETO Cgg_gem_tipo_contrato.
	* @return void
	*/
	public void setCgg_gem_tipo_contrato(com.besixplus.sii.objects.Cgg_gem_tipo_contrato inCgg_gem_tipo_contrato){
		this.myCgg_gem_tipo_contrato = inCgg_gem_tipo_contrato;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_tipo_contrato.
	* @return Cgg_gem_tipo_contrato OBJETO Cgg_gem_tipo_contrato.
	*/
	public com.besixplus.sii.objects.Cgg_gem_tipo_contrato getCgg_gem_tipo_contrato(){
		return this.myCgg_gem_tipo_contrato;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_tipo_contrato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_tipo_contrato().getCGTCN_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_tipo_contrato().getCGTCN_DESCRIPCION());
			stmInsert.setString(4, this.getCgg_gem_tipo_contrato().getCGTCN_OBSERVACION());
			stmInsert.setBoolean(5, this.getCgg_gem_tipo_contrato().getCGTCN_ESTADO());
			stmInsert.setString(6, this.getCgg_gem_tipo_contrato().getCGTCN_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_gem_tipo_contrato().getCGTCN_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_tipo_contrato().setCGTCN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_tipo_contrato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> outCgg_gem_tipo_contrato = new ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_tipo_contrato tmpCgg_gem_tipo_contrato = new com.besixplus.sii.objects.Cgg_gem_tipo_contrato();
				tmpCgg_gem_tipo_contrato.setCGTCN_CODIGO(results.getString(1));
				tmpCgg_gem_tipo_contrato.setCGTCN_DESCRIPCION(results.getString(2));
				tmpCgg_gem_tipo_contrato.setCGTCN_OBSERVACION(results.getString(3));
				tmpCgg_gem_tipo_contrato.setCGTCN_ESTADO(results.getBoolean(4));
				outCgg_gem_tipo_contrato.add(tmpCgg_gem_tipo_contrato);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_tipo_contrato;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_tipo_contrato QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO. 
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> outCgg_gem_tipo_contrato = new ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_tipo_contrato tmpCgg_gem_tipo_contrato = new com.besixplus.sii.objects.Cgg_gem_tipo_contrato();
				tmpCgg_gem_tipo_contrato.setCGTCN_CODIGO(results.getString(1));
				tmpCgg_gem_tipo_contrato.setCGTCN_DESCRIPCION(results.getString(2));
				tmpCgg_gem_tipo_contrato.setCGTCN_OBSERVACION(results.getString(3));
				tmpCgg_gem_tipo_contrato.setCGTCN_ESTADO(results.getBoolean(4));
				outCgg_gem_tipo_contrato.add(tmpCgg_gem_tipo_contrato);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_tipo_contrato;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_tipo_contrato QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_tipo_contrato> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_tipo_contrato = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_tipo_contrato.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_tipo_contrato;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_tipo_contrato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_tipo_contrato.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_TIPO_CONTRATO_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_tipo_contrato().getCGTCN_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_tipo_contrato().getCGTCN_DESCRIPCION());
			stmUpdate.setString(3, this.getCgg_gem_tipo_contrato().getCGTCN_OBSERVACION());
			stmUpdate.setBoolean(4, this.getCgg_gem_tipo_contrato().getCGTCN_ESTADO());
			stmUpdate.setString(5, this.getCgg_gem_tipo_contrato().getCGTCN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_tipo_contrato DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_tipo_contrato OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_tipo_contrato select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_TIPO_CONTRATO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_tipo_contrato().getCGTCN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_tipo_contrato().setCGTCN_CODIGO(results.getString(1));
				this.getCgg_gem_tipo_contrato().setCGTCN_DESCRIPCION(results.getString(2));
				this.getCgg_gem_tipo_contrato().setCGTCN_OBSERVACION(results.getString(3));
				this.getCgg_gem_tipo_contrato().setCGTCN_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_tipo_contrato();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_tipo_contrato DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_TIPO_CONTRATO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_tipo_contrato().getCGTCN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_TIPO_CONTRATO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_tipo_contrato().getCGTCN_CODIGO());
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