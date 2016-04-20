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
* CLASE Cgg_provincia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_provincia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_provincia implements Serializable{
	private static final long serialVersionUID = 986267178;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_provincia.
	*/
	private com.besixplus.sii.objects.Cgg_provincia myCgg_provincia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_provincia.
	*/
	public Cgg_provincia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_provincia.
	* @param inCgg_provincia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_provincia.
	*/
	public Cgg_provincia(
		com.besixplus.sii.objects.Cgg_provincia inCgg_provincia
	){
		this.setCgg_provincia(inCgg_provincia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_provincia.
	* @param inCgg_provincia OBJETO Cgg_provincia.
	* @return void
	*/
	public void setCgg_provincia(com.besixplus.sii.objects.Cgg_provincia inCgg_provincia){
		this.myCgg_provincia = inCgg_provincia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_provincia.
	* @return Cgg_provincia OBJETO Cgg_provincia.
	*/
	public com.besixplus.sii.objects.Cgg_provincia getCgg_provincia(){
		return this.myCgg_provincia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_provincia().getCGPRV_CODIGO());
			stmInsert.setString(3, this.getCgg_provincia().getCPAIS_CODIGO());
			stmInsert.setString(4, this.getCgg_provincia().getCGPRV_NOMBRE());
			stmInsert.setString(5, this.getCgg_provincia().getCGPRV_DESCRIPCION());
			stmInsert.setBoolean(6, this.getCgg_provincia().getCGPRV_ESTADO());
			stmInsert.setString(7, this.getCgg_provincia().getCGPRV_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_provincia().getCGPRV_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_provincia().setCGPRV_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_provincia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_provincia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_provincia> outCgg_provincia = new ArrayList<com.besixplus.sii.objects.Cgg_provincia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_provincia tmpCgg_provincia = new com.besixplus.sii.objects.Cgg_provincia();
				tmpCgg_provincia.setCGPRV_CODIGO(results.getString(1));
				tmpCgg_provincia.setCPAIS_CODIGO(results.getString(2));
				tmpCgg_provincia.setCGPRV_NOMBRE(results.getString(3));
			/*	tmpCgg_provincia.setCGPRV_DESCRIPCION(results.getString(4));
				tmpCgg_provincia.setCGPRV_ESTADO(results.getBoolean(5));*/
				outCgg_provincia.add(tmpCgg_provincia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_provincia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_provincia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_provincia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_provincia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_provincia> outCgg_provincia = new ArrayList<com.besixplus.sii.objects.Cgg_provincia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_provincia tmpCgg_provincia = new com.besixplus.sii.objects.Cgg_provincia();
				tmpCgg_provincia.setCGPRV_CODIGO(results.getString(1));
				tmpCgg_provincia.setCPAIS_CODIGO(results.getString(2));
				tmpCgg_provincia.setCGPRV_NOMBRE(results.getString(3));
				tmpCgg_provincia.setCGPRV_DESCRIPCION(results.getString(4));
				tmpCgg_provincia.setCGPRV_ESTADO(results.getBoolean(5));
				outCgg_provincia.add(tmpCgg_provincia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_provincia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_PROVINCIA_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_provincia().getCGPRV_CODIGO());
			stmUpdate.setString(2, this.getCgg_provincia().getCPAIS_CODIGO());
			stmUpdate.setString(3, this.getCgg_provincia().getCGPRV_NOMBRE());
			stmUpdate.setString(4, this.getCgg_provincia().getCGPRV_DESCRIPCION());
			stmUpdate.setBoolean(5, this.getCgg_provincia().getCGPRV_ESTADO());
			stmUpdate.setString(6, this.getCgg_provincia().getCGPRV_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_provincia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_provincia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_provincia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_provincia().getCGPRV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_provincia().setCGPRV_CODIGO(results.getString(1));
				this.getCgg_provincia().setCPAIS_CODIGO(results.getString(2));
				this.getCgg_provincia().setCGPRV_NOMBRE(results.getString(3));
				this.getCgg_provincia().setCGPRV_DESCRIPCION(results.getString(4));
				this.getCgg_provincia().setCGPRV_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_provincia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_provincia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_PROVINCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_provincia().getCGPRV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_PROVINCIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_provincia().getCGPRV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_provincia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_pais.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_provincia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_provincia> selectCGG_PAIS(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_provincia> outCgg_provincia = new ArrayList<com.besixplus.sii.objects.Cgg_provincia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_S_CGG_PAIS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_provincia().getCPAIS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_provincia tmpCgg_provincia = new com.besixplus.sii.objects.Cgg_provincia();
				tmpCgg_provincia.setCGPRV_CODIGO(results.getString(1));
				tmpCgg_provincia.setCPAIS_CODIGO(results.getString(2));
				tmpCgg_provincia.setCGPRV_NOMBRE(results.getString(3));
				outCgg_provincia.add(tmpCgg_provincia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_provincia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_provincia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_pais.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_PAIS(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_PROVINCIA_D_CGG_PAIS(?) }");
			stmDelete.setString(1, this.getCgg_provincia().getCPAIS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_PROVINCIA_DS_CGG_PAIS(?) }");
				stmDelete.setString(1, this.getCgg_provincia().getCPAIS_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE PAIS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_provincia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static  ArrayList<HashMap<String,Object>>  selectAllJoin(
		java.sql.Connection inConnection,
		String inCpais_codigo
	){
		 ArrayList<HashMap<String,Object>>  outCgg_provincia = new  ArrayList<HashMap<String,Object>> ();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_PROVINCIA_S_CGG_PAIS(?)}");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCpais_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				tmpObj.put("CANTONES", Cgg_canton.selectCGG_PROVINCIA(inConnection,results.getString(1).toString()));
				outCgg_provincia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_provincia;
	}
}