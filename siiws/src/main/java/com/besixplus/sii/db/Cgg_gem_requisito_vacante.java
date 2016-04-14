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
* CLASE Cgg_gem_requisito_vacante
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_requisito_vacante.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_requisito_vacante implements Serializable{
	private static final long serialVersionUID = 1926896413;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_requisito_vacante.
	*/
	private com.besixplus.sii.objects.Cgg_gem_requisito_vacante myCgg_gem_requisito_vacante = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_requisito_vacante.
	*/
	public Cgg_gem_requisito_vacante(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_requisito_vacante.
	* @param inCgg_gem_requisito_vacante OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_requisito_vacante.
	*/
	public Cgg_gem_requisito_vacante(
		com.besixplus.sii.objects.Cgg_gem_requisito_vacante inCgg_gem_requisito_vacante
	){
		this.setCgg_gem_requisito_vacante(inCgg_gem_requisito_vacante);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_requisito_vacante.
	* @param inCgg_gem_requisito_vacante OBJETO Cgg_gem_requisito_vacante.
	* @return void
	*/
	public void setCgg_gem_requisito_vacante(com.besixplus.sii.objects.Cgg_gem_requisito_vacante inCgg_gem_requisito_vacante){
		this.myCgg_gem_requisito_vacante = inCgg_gem_requisito_vacante;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_requisito_vacante.
	* @return Cgg_gem_requisito_vacante OBJETO Cgg_gem_requisito_vacante.
	*/
	public com.besixplus.sii.objects.Cgg_gem_requisito_vacante getCgg_gem_requisito_vacante(){
		return this.myCgg_gem_requisito_vacante;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_requisito_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_requisito_vacante().getCGRVC_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_requisito_vacante().getCGVCN_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_requisito_vacante().getCGRVC_REQUISITO());
			stmInsert.setBoolean(5, this.getCgg_gem_requisito_vacante().getCGRVC_OBLIGATORIO());
			stmInsert.setBoolean(6, this.getCgg_gem_requisito_vacante().getCGRVC_ESTADO());
			stmInsert.setString(7, this.getCgg_gem_requisito_vacante().getCGRVC_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_gem_requisito_vacante().getCGRVC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_requisito_vacante().setCGRVC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_requisito_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> outCgg_gem_requisito_vacante = new ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_requisito_vacante tmpCgg_gem_requisito_vacante = new com.besixplus.sii.objects.Cgg_gem_requisito_vacante();
				tmpCgg_gem_requisito_vacante.setCGRVC_CODIGO(results.getString(1));
				tmpCgg_gem_requisito_vacante.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_requisito_vacante.setCGRVC_REQUISITO(results.getString(3));
				tmpCgg_gem_requisito_vacante.setCGRVC_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_gem_requisito_vacante.setCGRVC_ESTADO(results.getBoolean(5));
				outCgg_gem_requisito_vacante.add(tmpCgg_gem_requisito_vacante);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_requisito_vacante;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_requisito_vacante QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> outCgg_gem_requisito_vacante = new ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_requisito_vacante tmpCgg_gem_requisito_vacante = new com.besixplus.sii.objects.Cgg_gem_requisito_vacante();
				tmpCgg_gem_requisito_vacante.setCGRVC_CODIGO(results.getString(1));
				tmpCgg_gem_requisito_vacante.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_requisito_vacante.setCGRVC_REQUISITO(results.getString(3));
				tmpCgg_gem_requisito_vacante.setCGRVC_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_gem_requisito_vacante.setCGRVC_ESTADO(results.getBoolean(5));
				outCgg_gem_requisito_vacante.add(tmpCgg_gem_requisito_vacante);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_requisito_vacante;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_requisito_vacante QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_requisito_vacante = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_requisito_vacante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_requisito_vacante;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_requisito_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_requisito_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_REQUISITO_VACANTE_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_requisito_vacante().getCGRVC_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_requisito_vacante().getCGVCN_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_requisito_vacante().getCGRVC_REQUISITO());
			stmUpdate.setBoolean(4, this.getCgg_gem_requisito_vacante().getCGRVC_OBLIGATORIO());
			stmUpdate.setBoolean(5, this.getCgg_gem_requisito_vacante().getCGRVC_ESTADO());
			stmUpdate.setString(6, this.getCgg_gem_requisito_vacante().getCGRVC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_requisito_vacante DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_requisito_vacante OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_requisito_vacante select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_requisito_vacante().getCGRVC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_requisito_vacante().setCGRVC_CODIGO(results.getString(1));
				this.getCgg_gem_requisito_vacante().setCGVCN_CODIGO(results.getString(2));
				this.getCgg_gem_requisito_vacante().setCGRVC_REQUISITO(results.getString(3));
				this.getCgg_gem_requisito_vacante().setCGRVC_OBLIGATORIO(results.getBoolean(4));
				this.getCgg_gem_requisito_vacante().setCGRVC_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_requisito_vacante();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_requisito_vacante DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_REQUISITO_VACANTE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_requisito_vacante().getCGRVC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_REQUISITO_VACANTE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_requisito_vacante().getCGRVC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_requisito_vacante DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_requisito_vacante OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> selectCGG_GEM_VACANTE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante> outCgg_gem_requisito_vacante = new ArrayList<com.besixplus.sii.objects.Cgg_gem_requisito_vacante>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_REQUISITO_VACANTE_S_CGG_GEM_VACANTE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_requisito_vacante().getCGVCN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_requisito_vacante tmpCgg_gem_requisito_vacante = new com.besixplus.sii.objects.Cgg_gem_requisito_vacante();
				tmpCgg_gem_requisito_vacante.setCGRVC_CODIGO(results.getString(1));
				tmpCgg_gem_requisito_vacante.setCGVCN_CODIGO(results.getString(2));
				tmpCgg_gem_requisito_vacante.setCGRVC_REQUISITO(results.getString(3));
				tmpCgg_gem_requisito_vacante.setCGRVC_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_gem_requisito_vacante.setCGRVC_ESTADO(results.getBoolean(5));
				outCgg_gem_requisito_vacante.add(tmpCgg_gem_requisito_vacante);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_requisito_vacante;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_requisito_vacante DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_VACANTE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_REQUISITO_VACANTE_D_CGG_GEM_VACANTE(?) }");
			stmDelete.setString(1, this.getCgg_gem_requisito_vacante().getCGVCN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_REQUISITO_VACANTE_DS_CGG_GEM_VACANTE(?) }");
				stmDelete.setString(1, this.getCgg_gem_requisito_vacante().getCGVCN_CODIGO());
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