package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;

import com.besixplus.sii.objects.Usuario;

/**import java.util.HashMap;

import com.besixplus.sii.objects.Cgg_usuario;
import com.besixplus.sii.objects.Usuario;*/

/**
 * CLASE Cgg_res_matrimonio
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_matrimonio.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_matrimonio implements Serializable{
	private static final long serialVersionUID = 352094675;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_matrimonio.
	 */
	private com.besixplus.sii.objects.Cgg_res_matrimonio myCgg_res_matrimonio = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_matrimonio.
	 */
	public Cgg_res_matrimonio(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_matrimonio.
	 * @param inCgg_res_matrimonio OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_matrimonio.
	 */
	public Cgg_res_matrimonio(
			com.besixplus.sii.objects.Cgg_res_matrimonio inCgg_res_matrimonio
	){
		this.setCgg_res_matrimonio(inCgg_res_matrimonio);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_matrimonio.
	 * @param inCgg_res_matrimonio OBJETO Cgg_res_matrimonio.
	 * @return void
	 */
	public void setCgg_res_matrimonio(com.besixplus.sii.objects.Cgg_res_matrimonio inCgg_res_matrimonio){
		this.myCgg_res_matrimonio = inCgg_res_matrimonio;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_matrimonio.
	 * @return Cgg_res_matrimonio OBJETO Cgg_res_matrimonio.
	 */
	public com.besixplus.sii.objects.Cgg_res_matrimonio getCgg_res_matrimonio(){
		return this.myCgg_res_matrimonio;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_INSERT(?, ?, ?, ?::smallint, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_matrimonio().getCRMTR_CODIGO());
			stmInsert.setString(3, this.getCgg_res_matrimonio().getCRTRA_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_matrimonio().getCRMTR_FECHA_MATRIMONIO().getTime()));
			stmInsert.setInt(5, this.getCgg_res_matrimonio().getCRMTR_TIPO());
			stmInsert.setInt(6, this.getCgg_res_matrimonio().getCRMTR_ESTADO_SEGUIMIENTO());
			stmInsert.setBoolean(7, this.getCgg_res_matrimonio().getCRMTR_ESTADO());
			stmInsert.setString(8, this.getCgg_res_matrimonio().getCRMTR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_res_matrimonio().setCRMTR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_matrimonio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> outCgg_res_matrimonio = new ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_matrimonio tmpCgg_res_matrimonio = new com.besixplus.sii.objects.Cgg_res_matrimonio();
				tmpCgg_res_matrimonio.setCRMTR_CODIGO(results.getString(1));
				tmpCgg_res_matrimonio.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_matrimonio.setCRMTR_FECHA_MATRIMONIO(results.getTimestamp(3));
				tmpCgg_res_matrimonio.setCRMTR_TIPO(results.getInt(4));
				tmpCgg_res_matrimonio.setCRMTR_ESTADO_SEGUIMIENTO(results.getInt(5));
				tmpCgg_res_matrimonio.setCRMTR_ESTADO(results.getBoolean(6));
				outCgg_res_matrimonio.add(tmpCgg_res_matrimonio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_matrimonio;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_matrimonio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> outCgg_res_matrimonio = new ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio>();
		try{																	   
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_MATRIMONIO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_matrimonio tmpCgg_res_matrimonio = new com.besixplus.sii.objects.Cgg_res_matrimonio();
				tmpCgg_res_matrimonio.setCRMTR_CODIGO(results.getString(1));
				tmpCgg_res_matrimonio.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_matrimonio.setCRTRA_NUMERO(results.getString(3));
				tmpCgg_res_matrimonio.setRESIDENTE(results.getString(4));
				tmpCgg_res_matrimonio.setCONYUGE(results.getString(5));	
				tmpCgg_res_matrimonio.setCRMTR_FECHA_MATRIMONIO(results.getTimestamp(6));				
				tmpCgg_res_matrimonio.setOFICIALES(new Cgg_res_matrimonio(tmpCgg_res_matrimonio).selectUsuario(inConnection));
				tmpCgg_res_matrimonio.setCRMTR_TIPO(results.getInt(7));
				tmpCgg_res_matrimonio.setCRMTR_ESTADO_SEGUIMIENTO(results.getInt(8));
				tmpCgg_res_matrimonio.setCRMTR_ESTADO(results.getBoolean(9));
				outCgg_res_matrimonio.add(tmpCgg_res_matrimonio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_matrimonio;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_matrimonio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inUserName
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
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
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inUserName
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection,inUserName);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inUserName);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_matrimonio.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
		){
			String outResult = "true";
			try{
				CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_MATRIMONIO_UPDATE(?, ?, ?, ?::smallint, ?::smallint, ?, ?) }");
				stmUpdate.setString(1, this.getCgg_res_matrimonio().getCRMTR_CODIGO());
				stmUpdate.setString(2, this.getCgg_res_matrimonio().getCRTRA_CODIGO());
				stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_res_matrimonio().getCRMTR_FECHA_MATRIMONIO().getTime()));
				stmUpdate.setInt(4, this.getCgg_res_matrimonio().getCRMTR_TIPO());
				stmUpdate.setInt(5, this.getCgg_res_matrimonio().getCRMTR_ESTADO_SEGUIMIENTO());
				stmUpdate.setBoolean(6, this.getCgg_res_matrimonio().getCRMTR_ESTADO());
				stmUpdate.setString(7, this.getCgg_res_matrimonio().getCRMTR_USUARIO_UPDATE());
				stmUpdate.executeUpdate();
				stmUpdate.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
			return outResult;
		}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_matrimonio DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_matrimonio select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_matrimonio().getCRMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_matrimonio().setCRMTR_CODIGO(results.getString(1));
				this.getCgg_res_matrimonio().setCRTRA_CODIGO(results.getString(2));
				this.getCgg_res_matrimonio().setCRMTR_FECHA_MATRIMONIO(results.getTimestamp(3));
				this.getCgg_res_matrimonio().setCRMTR_TIPO(results.getInt(4));
				this.getCgg_res_matrimonio().setCRMTR_ESTADO_SEGUIMIENTO(results.getInt(5));
				this.getCgg_res_matrimonio().setCRMTR_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_matrimonio();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_matrimonio DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MATRIMONIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_matrimonio().getCRMTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MATRIMONIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_matrimonio().getCRMTR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_matrimonio DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> selectCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> outCgg_res_matrimonio = new ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_S_CGG_RES_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_matrimonio().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_matrimonio tmpCgg_res_matrimonio = new com.besixplus.sii.objects.Cgg_res_matrimonio();
				tmpCgg_res_matrimonio.setCRMTR_CODIGO(results.getString(1));
				tmpCgg_res_matrimonio.setCRTRA_CODIGO(results.getString(2));
				tmpCgg_res_matrimonio.setCRMTR_FECHA_MATRIMONIO(results.getTimestamp(3));
				tmpCgg_res_matrimonio.setCRMTR_TIPO(results.getInt(4));
				tmpCgg_res_matrimonio.setCRMTR_ESTADO_SEGUIMIENTO(results.getInt(5));
				tmpCgg_res_matrimonio.setCRMTR_ESTADO(results.getBoolean(6));
				outCgg_res_matrimonio.add(tmpCgg_res_matrimonio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_matrimonio;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_matrimonio DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MATRIMONIO_D_CGG_RES_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_matrimonio().getCRTRA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_MATRIMONIO_DS_CGG_RES_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_matrimonio().getCRTRA_CODIGO());
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
	 * ELIMINA FISICAMENTE  REGISTROS DE LA TABLA Cgg_res_ofial_matrimionio DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_matrimonio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public boolean deleteOficial_Matrimonio(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_MATRIMONIO_DELETE_OFICIAL_MATRIMONIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_matrimonio().getCRMTR_CODIGO());
			stmSelect.execute();		
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/		
	public ArrayList<Usuario> selectUsuario(
			java.sql.Connection inConnection			
	){
		ArrayList<Usuario> outCgg_res_usuario= new ArrayList<Usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_MATRIMONIO_OFICIAL(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, this.getCgg_res_matrimonio().getCRMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				Usuario tmpCgg_res_usuario = new Usuario();
				tmpCgg_res_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_res_usuario.setCUSU_NOMBRES(results.getString(2));
				tmpCgg_res_usuario.setCUSU_APELLIDOS(results.getString(3));
				outCgg_res_usuario.add(tmpCgg_res_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_usuario;
	}
	
}