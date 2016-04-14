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
* CLASE Cgg_institucion_educativa
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_institucion_educativa.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_institucion_educativa implements Serializable{
	private static final long serialVersionUID = 1234604248;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_institucion_educativa.
	*/
	private com.besixplus.sii.objects.Cgg_institucion_educativa myCgg_institucion_educativa = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_educativa.
	*/
	public Cgg_institucion_educativa(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_educativa.
	* @param inCgg_institucion_educativa OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_institucion_educativa.
	*/
	public Cgg_institucion_educativa(
		com.besixplus.sii.objects.Cgg_institucion_educativa inCgg_institucion_educativa
	){
		this.setCgg_institucion_educativa(inCgg_institucion_educativa);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_institucion_educativa.
	* @param inCgg_institucion_educativa OBJETO Cgg_institucion_educativa.
	* @return void
	*/
	public void setCgg_institucion_educativa(com.besixplus.sii.objects.Cgg_institucion_educativa inCgg_institucion_educativa){
		this.myCgg_institucion_educativa = inCgg_institucion_educativa;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_institucion_educativa.
	* @return Cgg_institucion_educativa OBJETO Cgg_institucion_educativa.
	*/
	public com.besixplus.sii.objects.Cgg_institucion_educativa getCgg_institucion_educativa(){
		return this.myCgg_institucion_educativa;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_institucion_educativa().getCGIED_CODIGO());
			stmInsert.setString(3, this.getCgg_institucion_educativa().getCPAIS_CODIGO());
			stmInsert.setString(4, this.getCgg_institucion_educativa().getCGIED_DESCRIPCION());
			stmInsert.setString(5, this.getCgg_institucion_educativa().getCGIED_DIRECCION());
			stmInsert.setBoolean(6, this.getCgg_institucion_educativa().getCGIED_ESTADO());
			stmInsert.setString(7, this.getCgg_institucion_educativa().getCGIED_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_institucion_educativa().getCGIED_USUARIO_UPDATE());
			stmInsert.setString(9, this.getCgg_institucion_educativa().getCGIED_NOMBRE());
			stmInsert.execute();
			this.getCgg_institucion_educativa().setCGIED_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> outCgg_institucion_educativa = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_institucion_educativa tmpCgg_institucion_educativa = new com.besixplus.sii.objects.Cgg_institucion_educativa();
				tmpCgg_institucion_educativa.setCGIED_CODIGO(results.getString(1));
				tmpCgg_institucion_educativa.setCPAIS_CODIGO(results.getString(2));
				tmpCgg_institucion_educativa.setCGIED_DESCRIPCION(results.getString(3));
				tmpCgg_institucion_educativa.setCGIED_DIRECCION(results.getString(4));
				tmpCgg_institucion_educativa.setCGIED_ESTADO(results.getBoolean(5));
				outCgg_institucion_educativa.add(tmpCgg_institucion_educativa);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_educativa;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_educativa QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> outCgg_institucion_educativa = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_institucion_educativa tmpCgg_institucion_educativa = new com.besixplus.sii.objects.Cgg_institucion_educativa();
				tmpCgg_institucion_educativa.setCGIED_CODIGO(results.getString(1));
				tmpCgg_institucion_educativa.setCPAIS_CODIGO(results.getString(2));
				tmpCgg_institucion_educativa.setCGIED_DESCRIPCION(results.getString(3));
				tmpCgg_institucion_educativa.setCGIED_DIRECCION(results.getString(4));
				tmpCgg_institucion_educativa.setCGIED_ESTADO(results.getBoolean(5));
				tmpCgg_institucion_educativa.setCGIED_NOMBRE(results.getString(6));
				outCgg_institucion_educativa.add(tmpCgg_institucion_educativa);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_educativa;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_educativa QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_institucion_educativa = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_institucion_educativa.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_educativa;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_institucion_educativa.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_EDUCATIVA_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_institucion_educativa().getCGIED_CODIGO());
			stmUpdate.setString(2, this.getCgg_institucion_educativa().getCPAIS_CODIGO());
			stmUpdate.setString(3, this.getCgg_institucion_educativa().getCGIED_DESCRIPCION());
			stmUpdate.setString(4, this.getCgg_institucion_educativa().getCGIED_DIRECCION());
			stmUpdate.setBoolean(5, this.getCgg_institucion_educativa().getCGIED_ESTADO());
			stmUpdate.setString(6, this.getCgg_institucion_educativa().getCGIED_USUARIO_UPDATE());
			stmUpdate.setString(7, this.getCgg_institucion_educativa().getCGIED_NOMBRE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_institucion_educativa DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_institucion_educativa OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_institucion_educativa select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_institucion_educativa().getCGIED_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_institucion_educativa().setCGIED_CODIGO(results.getString(1));
				this.getCgg_institucion_educativa().setCPAIS_CODIGO(results.getString(2));
				this.getCgg_institucion_educativa().setCGIED_DESCRIPCION(results.getString(3));
				this.getCgg_institucion_educativa().setCGIED_DIRECCION(results.getString(4));
				this.getCgg_institucion_educativa().setCGIED_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_institucion_educativa();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_institucion_educativa DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_EDUCATIVA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_institucion_educativa().getCGIED_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_EDUCATIVA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_institucion_educativa().getCGIED_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_institucion_educativa DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_pais.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_institucion_educativa OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> selectCGG_PAIS(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> outCgg_institucion_educativa = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_INSTITUCION_EDUCATIVA_S_CGG_PAIS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_institucion_educativa().getCPAIS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_institucion_educativa tmpCgg_institucion_educativa = new com.besixplus.sii.objects.Cgg_institucion_educativa();
				tmpCgg_institucion_educativa.setCGIED_CODIGO(results.getString(1));
				tmpCgg_institucion_educativa.setCPAIS_CODIGO(results.getString(2));
				tmpCgg_institucion_educativa.setCGIED_DESCRIPCION(results.getString(3));
				tmpCgg_institucion_educativa.setCGIED_DIRECCION(results.getString(4));
				tmpCgg_institucion_educativa.setCGIED_ESTADO(results.getBoolean(5));
				outCgg_institucion_educativa.add(tmpCgg_institucion_educativa);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_institucion_educativa;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_institucion_educativa DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_pais.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_EDUCATIVA_D_CGG_PAIS(?) }");
			stmDelete.setString(1, this.getCgg_institucion_educativa().getCPAIS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_INSTITUCION_EDUCATIVA_DS_CGG_PAIS(?) }");
				stmDelete.setString(1, this.getCgg_institucion_educativa().getCPAIS_CODIGO());
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