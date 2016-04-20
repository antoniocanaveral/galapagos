package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_informe_testigo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_informe_testigo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_informe_testigo implements Serializable{
	private static final long serialVersionUID = 2101633044;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_informe_testigo.
	*/
	private com.besixplus.sii.objects.Cgg_res_informe_testigo myCgg_res_informe_testigo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_testigo.
	*/
	public Cgg_res_informe_testigo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_testigo.
	* @param inCgg_res_informe_testigo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_informe_testigo.
	*/
	public Cgg_res_informe_testigo(
		com.besixplus.sii.objects.Cgg_res_informe_testigo inCgg_res_informe_testigo
	){
		this.setCgg_res_informe_testigo(inCgg_res_informe_testigo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_informe_testigo.
	* @param inCgg_res_informe_testigo OBJETO Cgg_res_informe_testigo.
	* @return void
	*/
	public void setCgg_res_informe_testigo(com.besixplus.sii.objects.Cgg_res_informe_testigo inCgg_res_informe_testigo){
		this.myCgg_res_informe_testigo = inCgg_res_informe_testigo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_informe_testigo.
	* @return Cgg_res_informe_testigo OBJETO Cgg_res_informe_testigo.
	*/
	public com.besixplus.sii.objects.Cgg_res_informe_testigo getCgg_res_informe_testigo(){
		return this.myCgg_res_informe_testigo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_informe_testigo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_informe_testigo().getCRINT_CODIGO());
			stmInsert.setString(3, this.getCgg_res_informe_testigo().getCRMTR_CODIGO());
			stmInsert.setString(4, this.getCgg_res_informe_testigo().getCRINT_NUMERO());
			stmInsert.setString(5, this.getCgg_res_informe_testigo().getCRINT_OBSERVACION());
			stmInsert.setBoolean(6, this.getCgg_res_informe_testigo().getCRINT_ESTADO());
			stmInsert.setString(7, this.getCgg_res_informe_testigo().getCRINT_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_res_informe_testigo().getCRINT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_informe_testigo().setCRINT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_testigo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> outCgg_res_informe_testigo = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_testigo tmpCgg_res_informe_testigo = new com.besixplus.sii.objects.Cgg_res_informe_testigo();
				tmpCgg_res_informe_testigo.setCRINT_CODIGO(results.getString(1));
				tmpCgg_res_informe_testigo.setCRMTR_CODIGO(results.getString(2));
				tmpCgg_res_informe_testigo.setCRINT_NUMERO(results.getString(3));
				tmpCgg_res_informe_testigo.setCRINT_OBSERVACION(results.getString(4));
				tmpCgg_res_informe_testigo.setCRINT_ESTADO(results.getBoolean(5));
				outCgg_res_informe_testigo.add(tmpCgg_res_informe_testigo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_testigo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_testigo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> outCgg_res_informe_testigo = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_informe_testigo tmpCgg_res_informe_testigo = new com.besixplus.sii.objects.Cgg_res_informe_testigo();
				tmpCgg_res_informe_testigo.setCRINT_CODIGO(results.getString(1));
				tmpCgg_res_informe_testigo.setCRMTR_CODIGO(results.getString(2));
				tmpCgg_res_informe_testigo.setCRINT_NUMERO(results.getString(3));
				tmpCgg_res_informe_testigo.setCRINT_OBSERVACION(results.getString(4));
				tmpCgg_res_informe_testigo.setCRINT_ESTADO(results.getBoolean(5));
				outCgg_res_informe_testigo.add(tmpCgg_res_informe_testigo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_testigo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_informe_testigo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_informe_testigo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_TESTIGO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_informe_testigo().getCRINT_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_informe_testigo().getCRMTR_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_informe_testigo().getCRINT_NUMERO());
			stmUpdate.setString(4, this.getCgg_res_informe_testigo().getCRINT_OBSERVACION());
			stmUpdate.setBoolean(5, this.getCgg_res_informe_testigo().getCRINT_ESTADO());
			stmUpdate.setString(6, this.getCgg_res_informe_testigo().getCRINT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_informe_testigo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_testigo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_informe_testigo select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_testigo().getCRINT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_informe_testigo().setCRINT_CODIGO(results.getString(1));
				this.getCgg_res_informe_testigo().setCRMTR_CODIGO(results.getString(2));
				this.getCgg_res_informe_testigo().setCRINT_NUMERO(results.getString(3));
				this.getCgg_res_informe_testigo().setCRINT_OBSERVACION(results.getString(4));
				this.getCgg_res_informe_testigo().setCRINT_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_informe_testigo();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_informe_testigo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_TESTIGO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_testigo().getCRINT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_TESTIGO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_testigo().getCRINT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_informe_testigo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_testigo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> selectCGG_RES_MATRIMONIO(
		java.sql.Connection inConnection
		
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo> outCgg_res_informe_testigo = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_testigo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_TESTIGO_S_CGG_RES_MATRIMONIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_testigo().getCRMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_testigo tmpCgg_res_informe_testigo = new com.besixplus.sii.objects.Cgg_res_informe_testigo();
				tmpCgg_res_informe_testigo.setCRINT_CODIGO(results.getString(1));
				tmpCgg_res_informe_testigo.setCRMTR_CODIGO(results.getString(2));
				tmpCgg_res_informe_testigo.setCRINT_NUMERO(results.getString(3));
				tmpCgg_res_informe_testigo.setCRINT_OBSERVACION(results.getString(4));
				tmpCgg_res_informe_testigo.setCRINT_ESTADO(results.getBoolean(5));
				outCgg_res_informe_testigo.add(tmpCgg_res_informe_testigo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_testigo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_informe_testigo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_MATRIMONIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_TESTIGO_D_CGG_RES_MATRIMONIO(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_testigo().getCRMTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_TESTIGO_DS_CGG_RES_MATRIMONIO(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_testigo().getCRMTR_CODIGO());
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
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_res_informe_testigo 
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_testigo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static String geneNumDoc(
		java.sql.Connection inConnection
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_INFORME_TESTIGO() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);						
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}

}