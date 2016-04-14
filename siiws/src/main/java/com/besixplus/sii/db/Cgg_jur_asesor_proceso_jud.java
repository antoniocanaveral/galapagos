package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_jur_asesor_proceso_jud
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_asesor_proceso_jud.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_jur_asesor_proceso_jud implements Serializable{
	private static final long serialVersionUID = 47820508;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud.
	*/
	private com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud myCgg_jur_asesor_proceso_jud = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor_proceso_jud.
	*/
	public Cgg_jur_asesor_proceso_jud(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor_proceso_jud.
	* @param inCgg_jur_asesor_proceso_jud OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_asesor_proceso_jud.
	*/
	public Cgg_jur_asesor_proceso_jud(
		com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud inCgg_jur_asesor_proceso_jud
	){
		this.setCgg_jur_asesor_proceso_jud(inCgg_jur_asesor_proceso_jud);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_asesor_proceso_jud.
	* @param inCgg_jur_asesor_proceso_jud OBJETO Cgg_jur_asesor_proceso_jud.
	* @return void
	*/
	public void setCgg_jur_asesor_proceso_jud(com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud inCgg_jur_asesor_proceso_jud){
		this.myCgg_jur_asesor_proceso_jud = inCgg_jur_asesor_proceso_jud;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_asesor_proceso_jud.
	* @return Cgg_jur_asesor_proceso_jud OBJETO Cgg_jur_asesor_proceso_jud.
	*/
	public com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud getCgg_jur_asesor_proceso_jud(){
		return this.myCgg_jur_asesor_proceso_jud;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_jur_asesor_proceso_jud.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_asesor_proceso_jud().getCJASP_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_jur_asesor_proceso_jud().getCJASP_ACTIVO());
			stmInsert.setBoolean(6, this.getCgg_jur_asesor_proceso_jud().getCJASP_ESTADO());
			stmInsert.setString(7, this.getCgg_jur_asesor_proceso_jud().getCJASP_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_jur_asesor_proceso_jud().getCJASP_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_jur_asesor_proceso_jud().setCJASP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_asesor_proceso_jud.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> outCgg_jur_asesor_proceso_jud = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud tmpCgg_jur_asesor_proceso_jud = new com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud();
				tmpCgg_jur_asesor_proceso_jud.setCJASP_CODIGO(results.getString(1));
				tmpCgg_jur_asesor_proceso_jud.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor_proceso_jud.setCUSU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ACTIVO(results.getBoolean(4));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor_proceso_jud.add(tmpCgg_jur_asesor_proceso_jud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor_proceso_jud;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_asesor_proceso_jud QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> outCgg_jur_asesor_proceso_jud = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud tmpCgg_jur_asesor_proceso_jud = new com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud();
				tmpCgg_jur_asesor_proceso_jud.setCJASP_CODIGO(results.getString(1));
				tmpCgg_jur_asesor_proceso_jud.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor_proceso_jud.setCUSU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ACTIVO(results.getBoolean(4));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor_proceso_jud.add(tmpCgg_jur_asesor_proceso_jud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor_proceso_jud;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_asesor_proceso_jud.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_asesor_proceso_jud.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJASP_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_jur_asesor_proceso_jud().getCJASP_ACTIVO());
			stmUpdate.setBoolean(5, this.getCgg_jur_asesor_proceso_jud().getCJASP_ESTADO());
			stmUpdate.setString(6, this.getCgg_jur_asesor_proceso_jud().getCJASP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_asesor_proceso_jud DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_asesor_proceso_jud().getCJASP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_asesor_proceso_jud().setCJASP_CODIGO(results.getString(1));
				this.getCgg_jur_asesor_proceso_jud().setCJPJU_CODIGO(results.getString(2));
				this.getCgg_jur_asesor_proceso_jud().setCUSU_CODIGO(results.getString(3));
				this.getCgg_jur_asesor_proceso_jud().setCJASP_ACTIVO(results.getBoolean(4));
				this.getCgg_jur_asesor_proceso_jud().setCJASP_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_asesor_proceso_jud();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_asesor_proceso_jud DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJASP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJASP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_asesor_proceso_jud DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> outCgg_jur_asesor_proceso_jud = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
			stmSelect.setString(3,this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud tmpCgg_jur_asesor_proceso_jud = new com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud();
				tmpCgg_jur_asesor_proceso_jud.setCJASP_CODIGO(results.getString(1));
				tmpCgg_jur_asesor_proceso_jud.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor_proceso_jud.setCUSU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ACTIVO(results.getBoolean(4));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor_proceso_jud.add(tmpCgg_jur_asesor_proceso_jud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor_proceso_jud;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_asesor_proceso_jud DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_USUARIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
			stmDelete.setString(2, this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
				stmDelete.setString(2, this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_asesor_proceso_jud DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_proceso_judicial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> selectCGG_JUR_PROCESO_JUDICIAL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud> outCgg_jur_asesor_proceso_jud = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_S_CGG_JUR_PROCESO_JUDICIAL(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
			stmSelect.setString(3,this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud tmpCgg_jur_asesor_proceso_jud = new com.besixplus.sii.objects.Cgg_jur_asesor_proceso_jud();
				tmpCgg_jur_asesor_proceso_jud.setCJASP_CODIGO(results.getString(1));
				tmpCgg_jur_asesor_proceso_jud.setCJPJU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor_proceso_jud.setCUSU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ACTIVO(results.getBoolean(4));
				tmpCgg_jur_asesor_proceso_jud.setCJASP_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor_proceso_jud.add(tmpCgg_jur_asesor_proceso_jud);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor_proceso_jud;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_asesor_proceso_jud DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_proceso_judicial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_JUR_PROCESO_JUDICIAL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_D_CGG_JUR_PROCESO_JUDICIAL(?, ?) }");
			stmDelete.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
			stmDelete.setString(2, this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_PROCESO_JUD_DS_CGG_JUR_PROCESO_JUDICIAL(?, ?) }");
				stmDelete.setString(1, this.getCgg_jur_asesor_proceso_jud().getCJPJU_CODIGO());
				stmDelete.setString(2, this.getCgg_jur_asesor_proceso_jud().getCUSU_CODIGO());
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