package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_res_participante_tramite
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_participante_tramite.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_participante_tramite implements Serializable{
	private static final long serialVersionUID = 1122044223;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_participante_tramite.
	*/
	private com.besixplus.sii.objects.Cgg_res_participante_tramite myCgg_res_participante_tramite = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_participante_tramite.
	*/
	public Cgg_res_participante_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_participante_tramite.
	* @param inCgg_res_participante_tramite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_participante_tramite.
	*/
	public Cgg_res_participante_tramite(
		com.besixplus.sii.objects.Cgg_res_participante_tramite inCgg_res_participante_tramite
	){
		this.setCgg_res_participante_tramite(inCgg_res_participante_tramite);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_participante_tramite.
	* @param inCgg_res_participante_tramite OBJETO Cgg_res_participante_tramite.
	* @return void
	*/
	public void setCgg_res_participante_tramite(com.besixplus.sii.objects.Cgg_res_participante_tramite inCgg_res_participante_tramite){
		this.myCgg_res_participante_tramite = inCgg_res_participante_tramite;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_participante_tramite.
	* @return Cgg_res_participante_tramite OBJETO Cgg_res_participante_tramite.
	*/
	public com.besixplus.sii.objects.Cgg_res_participante_tramite getCgg_res_participante_tramite(){
		return this.myCgg_res_participante_tramite;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_participante_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_participante_tramite().getCRPTR_CODIGO());
			stmInsert.setString(3, this.getCgg_res_participante_tramite().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_res_participante_tramite().getCRPTR_ESTADO());
			stmInsert.setString(6, this.getCgg_res_participante_tramite().getCRPTR_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_res_participante_tramite().getCRPTR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_participante_tramite().setCRPTR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_participante_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> outCgg_res_participante_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_participante_tramite tmpCgg_res_participante_tramite = new com.besixplus.sii.objects.Cgg_res_participante_tramite();
				tmpCgg_res_participante_tramite.setCRPTR_CODIGO(results.getString(1));
				tmpCgg_res_participante_tramite.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_participante_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_participante_tramite.setCRPTR_ESTADO(results.getBoolean(4));
				outCgg_res_participante_tramite.add(tmpCgg_res_participante_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_participante_tramite;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_participante_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> outCgg_res_participante_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_participante_tramite tmpCgg_res_participante_tramite = new com.besixplus.sii.objects.Cgg_res_participante_tramite();
				tmpCgg_res_participante_tramite.setCRPTR_CODIGO(results.getString(1));
				tmpCgg_res_participante_tramite.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_participante_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_participante_tramite.setCRPTR_ESTADO(results.getBoolean(4));
				outCgg_res_participante_tramite.add(tmpCgg_res_participante_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_participante_tramite;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_participante_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_participante_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_participante_tramite().getCRPTR_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_participante_tramite().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_res_participante_tramite().getCRPTR_ESTADO());
			stmUpdate.setString(5, this.getCgg_res_participante_tramite().getCRPTR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_participante_tramite DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_participante_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_participante_tramite select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_participante_tramite().getCRPTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_participante_tramite().setCRPTR_CODIGO(results.getString(1));
				this.getCgg_res_participante_tramite().setCUSU_CODIGO(results.getString(2));
				this.getCgg_res_participante_tramite().setCRTPT_CODIGO(results.getString(3));
				this.getCgg_res_participante_tramite().setCRPTR_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_participante_tramite();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_participante_tramite DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_participante_tramite().getCRPTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_participante_tramite().getCRPTR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_participante_tramite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_participante_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> selectCGG_RES_TIPO_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> outCgg_res_participante_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_S_CGG_RES_TIPO_TRAMITE(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
			stmSelect.setString(3,this.getCgg_res_participante_tramite().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_participante_tramite tmpCgg_res_participante_tramite = new com.besixplus.sii.objects.Cgg_res_participante_tramite();
				tmpCgg_res_participante_tramite.setCRPTR_CODIGO(results.getString(1));
				tmpCgg_res_participante_tramite.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_participante_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_participante_tramite.setCRPTR_ESTADO(results.getBoolean(4));
				outCgg_res_participante_tramite.add(tmpCgg_res_participante_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_participante_tramite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_participante_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_D_CGG_RES_TIPO_TRAMITE(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
			stmDelete.setString(2, this.getCgg_res_participante_tramite().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_DS_CGG_RES_TIPO_TRAMITE(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
				stmDelete.setString(2, this.getCgg_res_participante_tramite().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_participante_tramite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_participante_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite> outCgg_res_participante_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_participante_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
			stmSelect.setString(3,this.getCgg_res_participante_tramite().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_participante_tramite tmpCgg_res_participante_tramite = new com.besixplus.sii.objects.Cgg_res_participante_tramite();
				tmpCgg_res_participante_tramite.setCRPTR_CODIGO(results.getString(1));
				tmpCgg_res_participante_tramite.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_participante_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_participante_tramite.setCRPTR_ESTADO(results.getBoolean(4));
				outCgg_res_participante_tramite.add(tmpCgg_res_participante_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_participante_tramite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_participante_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
			stmDelete.setString(2, this.getCgg_res_participante_tramite().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_PARTICIPANTE_TRAMITE_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_res_participante_tramite().getCRTPT_CODIGO());
				stmDelete.setString(2, this.getCgg_res_participante_tramite().getCUSU_CODIGO());
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