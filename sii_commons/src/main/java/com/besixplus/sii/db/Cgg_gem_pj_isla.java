package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_gem_pj_isla
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_pj_isla.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_pj_isla implements Serializable{
	private static final long serialVersionUID = 2103886060;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_pj_isla.
	*/
	private com.besixplus.sii.objects.Cgg_gem_pj_isla myCgg_gem_pj_isla = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_pj_isla.
	*/
	public Cgg_gem_pj_isla(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_pj_isla.
	* @param inCgg_gem_pj_isla OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_pj_isla.
	*/
	public Cgg_gem_pj_isla(
		com.besixplus.sii.objects.Cgg_gem_pj_isla inCgg_gem_pj_isla
	){
		this.setCgg_gem_pj_isla(inCgg_gem_pj_isla);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_pj_isla.
	* @param inCgg_gem_pj_isla OBJETO Cgg_gem_pj_isla.
	* @return void
	*/
	public void setCgg_gem_pj_isla(com.besixplus.sii.objects.Cgg_gem_pj_isla inCgg_gem_pj_isla){
		this.myCgg_gem_pj_isla = inCgg_gem_pj_isla;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_pj_isla.
	* @return Cgg_gem_pj_isla OBJETO Cgg_gem_pj_isla.
	*/
	public com.besixplus.sii.objects.Cgg_gem_pj_isla getCgg_gem_pj_isla(){
		return this.myCgg_gem_pj_isla;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_pj_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_pj_isla().getCPJIS_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_pj_isla().getCISLA_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_gem_pj_isla().getCPJIS_ESTADO());
			stmInsert.setString(6, this.getCgg_gem_pj_isla().getCPJIS_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_gem_pj_isla().getCPJIS_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_pj_isla().setCPJIS_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_pj_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> outCgg_gem_pj_isla = new ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_pj_isla tmpCgg_gem_pj_isla = new com.besixplus.sii.objects.Cgg_gem_pj_isla();
				tmpCgg_gem_pj_isla.setCPJIS_CODIGO(results.getString(1));
				tmpCgg_gem_pj_isla.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_gem_pj_isla.setCISLA_CODIGO(results.getString(3));
				tmpCgg_gem_pj_isla.setCPJIS_ESTADO(results.getBoolean(4));
				outCgg_gem_pj_isla.add(tmpCgg_gem_pj_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_pj_isla;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_pj_isla QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> outCgg_gem_pj_isla = new ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_pj_isla tmpCgg_gem_pj_isla = new com.besixplus.sii.objects.Cgg_gem_pj_isla();
				tmpCgg_gem_pj_isla.setCPJIS_CODIGO(results.getString(1));
				tmpCgg_gem_pj_isla.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_gem_pj_isla.setCISLA_CODIGO(results.getString(3));
				tmpCgg_gem_pj_isla.setCPJIS_ESTADO(results.getBoolean(4));
				outCgg_gem_pj_isla.add(tmpCgg_gem_pj_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_pj_isla;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_pj_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_pj_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_pj_isla().getCPJIS_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_pj_isla().getCISLA_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_gem_pj_isla().getCPJIS_ESTADO());
			stmUpdate.setString(5, this.getCgg_gem_pj_isla().getCPJIS_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_pj_isla DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_pj_isla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_pj_isla select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_pj_isla().getCPJIS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_pj_isla().setCPJIS_CODIGO(results.getString(1));
				this.getCgg_gem_pj_isla().setCRPJR_CODIGO(results.getString(2));
				this.getCgg_gem_pj_isla().setCISLA_CODIGO(results.getString(3));
				this.getCgg_gem_pj_isla().setCPJIS_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_pj_isla();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_pj_isla DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_pj_isla().getCPJIS_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_pj_isla().getCPJIS_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_pj_isla DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_pj_isla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> selectCGG_ISLA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> outCgg_gem_pj_isla = new ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_S_CGG_ISLA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_pj_isla().getCISLA_CODIGO());
			stmSelect.setString(3,this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_pj_isla tmpCgg_gem_pj_isla = new com.besixplus.sii.objects.Cgg_gem_pj_isla();
				tmpCgg_gem_pj_isla.setCPJIS_CODIGO(results.getString(1));
				tmpCgg_gem_pj_isla.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_gem_pj_isla.setCISLA_CODIGO(results.getString(3));
				tmpCgg_gem_pj_isla.setCPJIS_ESTADO(results.getBoolean(4));
				outCgg_gem_pj_isla.add(tmpCgg_gem_pj_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_pj_isla;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_pj_isla DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_ISLA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_D_CGG_ISLA(?, ?) }");
			stmDelete.setString(1, this.getCgg_gem_pj_isla().getCISLA_CODIGO());
			stmDelete.setString(2, this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_DS_CGG_ISLA(?, ?) }");
				stmDelete.setString(1, this.getCgg_gem_pj_isla().getCISLA_CODIGO());
				stmDelete.setString(2, this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_pj_isla DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_pj_isla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla> outCgg_gem_pj_isla = new ArrayList<com.besixplus.sii.objects.Cgg_gem_pj_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PJ_ISLA_S_CGG_RES_PERSONA_JURIDICA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_pj_isla().getCISLA_CODIGO());
			stmSelect.setString(3,this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_pj_isla tmpCgg_gem_pj_isla = new com.besixplus.sii.objects.Cgg_gem_pj_isla();
				tmpCgg_gem_pj_isla.setCPJIS_CODIGO(results.getString(1));
				tmpCgg_gem_pj_isla.setCRPJR_CODIGO(results.getString(2));
				tmpCgg_gem_pj_isla.setCISLA_CODIGO(results.getString(3));
				tmpCgg_gem_pj_isla.setCPJIS_ESTADO(results.getBoolean(4));
				outCgg_gem_pj_isla.add(tmpCgg_gem_pj_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_pj_isla;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_pj_isla DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_D_CGG_RES_PERSONA_JURIDICA(?, ?) }");
			stmDelete.setString(1, this.getCgg_gem_pj_isla().getCISLA_CODIGO());
			stmDelete.setString(2, this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PJ_ISLA_DS_CGG_RES_PERSONA_JURIDICA(?, ?) }");
				stmDelete.setString(1, this.getCgg_gem_pj_isla().getCISLA_CODIGO());
				stmDelete.setString(2, this.getCgg_gem_pj_isla().getCRPJR_CODIGO());
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