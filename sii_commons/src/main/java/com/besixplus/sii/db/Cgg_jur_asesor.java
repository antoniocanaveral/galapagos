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
* CLASE Cgg_jur_asesor
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_asesor.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_jur_asesor implements Serializable{
	private static final long serialVersionUID = 109968212;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_jur_asesor.
	*/
	private com.besixplus.sii.objects.Cgg_jur_asesor myCgg_jur_asesor = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor.
	*/
	public Cgg_jur_asesor(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor.
	* @param inCgg_jur_asesor OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_jur_asesor.
	*/
	public Cgg_jur_asesor(
		com.besixplus.sii.objects.Cgg_jur_asesor inCgg_jur_asesor
	){
		this.setCgg_jur_asesor(inCgg_jur_asesor);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_jur_asesor.
	* @param inCgg_jur_asesor OBJETO Cgg_jur_asesor.
	* @return void
	*/
	public void setCgg_jur_asesor(com.besixplus.sii.objects.Cgg_jur_asesor inCgg_jur_asesor){
		this.myCgg_jur_asesor = inCgg_jur_asesor;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_jur_asesor.
	* @return Cgg_jur_asesor OBJETO Cgg_jur_asesor.
	*/
	public com.besixplus.sii.objects.Cgg_jur_asesor getCgg_jur_asesor(){
		return this.myCgg_jur_asesor;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_jur_asesor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_INSERT(?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_jur_asesor().getCJASE_CODIGO());
			stmInsert.setString(3, this.getCgg_jur_asesor().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_jur_asesor().getCJPJU_CODIGO());
			stmInsert.setInt(5, this.getCgg_jur_asesor().getCJASE_ACTIVO());
			stmInsert.setBoolean(6, this.getCgg_jur_asesor().getCJASE_ESTADO());
			stmInsert.setString(7, this.getCgg_jur_asesor().getCJASE_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_jur_asesor().setCJASE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_asesor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> outCgg_jur_asesor = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_asesor tmpCgg_jur_asesor = new com.besixplus.sii.objects.Cgg_jur_asesor();
				tmpCgg_jur_asesor.setCJASE_CODIGO(results.getString(1));
				tmpCgg_jur_asesor.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor.setCJPJU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor.setCJASE_ACTIVO(results.getInt(4));
				tmpCgg_jur_asesor.setCJASE_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor.add(tmpCgg_jur_asesor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_asesor QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String, Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_jur_asesor = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_asesor.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_asesor QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_jur_asesor = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_SELECT(?,?,?,?,?,?) }");
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
				outCgg_jur_asesor.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_jur_asesor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_jur_asesor.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_UPDATE(?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_jur_asesor().getCJASE_CODIGO());
			stmUpdate.setString(2, this.getCgg_jur_asesor().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_jur_asesor().getCJPJU_CODIGO());
			stmUpdate.setInt(4, this.getCgg_jur_asesor().getCJASE_ACTIVO());
			stmUpdate.setBoolean(5, this.getCgg_jur_asesor().getCJASE_ESTADO());
			stmUpdate.setString(6, this.getCgg_jur_asesor().getCJASE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_jur_asesor DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_asesor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_jur_asesor select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_asesor().getCJASE_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_jur_asesor().setCJASE_CODIGO(results.getString(1));
				this.getCgg_jur_asesor().setCUSU_CODIGO(results.getString(2));
				this.getCgg_jur_asesor().setCJPJU_CODIGO(results.getString(3));
				this.getCgg_jur_asesor().setCJASE_ACTIVO(results.getInt(4));
				this.getCgg_jur_asesor().setCJASE_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_jur_asesor();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_jur_asesor DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_jur_asesor().getCJASE_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_jur_asesor().getCJASE_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_asesor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_asesor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> outCgg_jur_asesor = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_asesor().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_asesor tmpCgg_jur_asesor = new com.besixplus.sii.objects.Cgg_jur_asesor();
				tmpCgg_jur_asesor.setCJASE_CODIGO(results.getString(1));
				tmpCgg_jur_asesor.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor.setCJPJU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor.setCJASE_ACTIVO(results.getInt(4));
				tmpCgg_jur_asesor.setCJASE_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor.add(tmpCgg_jur_asesor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_asesor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_jur_asesor().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_jur_asesor().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_jur_asesor DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_proceso_judicial.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_jur_asesor OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> selectCGG_JUR_PROCESO_JUDICIAL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor> outCgg_jur_asesor = new ArrayList<com.besixplus.sii.objects.Cgg_jur_asesor>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_JUR_ASESOR_S_CGG_JUR_PROCESO_JUDICIAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_jur_asesor().getCJPJU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_jur_asesor tmpCgg_jur_asesor = new com.besixplus.sii.objects.Cgg_jur_asesor();
				tmpCgg_jur_asesor.setCJASE_CODIGO(results.getString(1));
				tmpCgg_jur_asesor.setCUSU_CODIGO(results.getString(2));
				tmpCgg_jur_asesor.setCJPJU_CODIGO(results.getString(3));
				tmpCgg_jur_asesor.setCJASE_ACTIVO(results.getInt(4));
				tmpCgg_jur_asesor.setCJASE_ESTADO(results.getBoolean(5));
				outCgg_jur_asesor.add(tmpCgg_jur_asesor);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_jur_asesor;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_jur_asesor DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_jur_proceso_judicial.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_D_CGG_JUR_PROCESO_JUDICIAL(?) }");
			stmDelete.setString(1, this.getCgg_jur_asesor().getCJPJU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_JUR_ASESOR_DS_CGG_JUR_PROCESO_JUDICIAL(?) }");
				stmDelete.setString(1, this.getCgg_jur_asesor().getCJPJU_CODIGO());
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