package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

import com.besixplus.sii.objects.Cgg_usuario_persona;

/**
 * CLASE Cgg_usuario
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_usuario.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_usuario implements Serializable{
	private static final long serialVersionUID = 1523494718;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_usuario.
	 */
	private com.besixplus.sii.objects.Cgg_usuario myCgg_usuario = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_usuario.
	 */
	public Cgg_usuario(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_usuario.
	 * @param inCgg_usuario OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_usuario.
	 */
	public Cgg_usuario(
			com.besixplus.sii.objects.Cgg_usuario inCgg_usuario
	){
		this.setCgg_usuario(inCgg_usuario);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_usuario.
	 * @param inCgg_usuario OBJETO Cgg_usuario.
	 * @return void
	 */
	public void setCgg_usuario(com.besixplus.sii.objects.Cgg_usuario inCgg_usuario){
		this.myCgg_usuario = inCgg_usuario;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_usuario.
	 * @return Cgg_usuario OBJETO Cgg_usuario.
	 */
	public com.besixplus.sii.objects.Cgg_usuario getCgg_usuario(){
		return this.myCgg_usuario;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_usuario().getCUSU_CODIGO());
			stmInsert.setString(3, this.getCgg_usuario().getCRCRG_CODIGO());
			stmInsert.setString(4, this.getCgg_usuario().getCRPER_CODIGO());
			stmInsert.setString(5, this.getCgg_usuario().getCRPJR_CODIGO());
			stmInsert.setString(6, this.getCgg_usuario().getCCTN_CODIGO());
			stmInsert.setString(7, this.getCgg_usuario().getCISLA_CODIGO());
			stmInsert.setString(8, this.getCgg_usuario().getCUSU_NOMBRE_USUARIO());
			stmInsert.setString(9, this.getCgg_usuario().getCUSU_CLAVE_ACCESO());
			stmInsert.setBoolean(10, this.getCgg_usuario().getCUSU_USUARIO_INTERNO());
			stmInsert.setBoolean(11, this.getCgg_usuario().getCUSU_CADUCA_CLAVE());
			stmInsert.setTimestamp(12, new java.sql.Timestamp(this.getCgg_usuario().getCUSU_FECHA_CLAVE_ACT().getTime()));
			stmInsert.setBoolean(13, this.getCgg_usuario().getCUSU_ACTIVO());
			stmInsert.setBoolean(14, this.getCgg_usuario().getCUSU_CAMBIAR_CLAVE());
			stmInsert.setBoolean(15, this.getCgg_usuario().getCUSU_ESTADO());
			stmInsert.setString(16, this.getCgg_usuario().getCUSU_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_usuario().setCUSU_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_usuario> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> outCgg_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_usuario tmpCgg_usuario = new com.besixplus.sii.objects.Cgg_usuario();
				tmpCgg_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_usuario.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_usuario.setCRPER_CODIGO(results.getString(3));
				tmpCgg_usuario.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_usuario.setCCTN_CODIGO(results.getString(5));
				tmpCgg_usuario.setCISLA_CODIGO(results.getString(6));
				tmpCgg_usuario.setCUSU_NOMBRE_USUARIO(results.getString(7));
				tmpCgg_usuario.setCUSU_CLAVE_ACCESO(results.getString(8));
				tmpCgg_usuario.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				tmpCgg_usuario.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				tmpCgg_usuario.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				tmpCgg_usuario.setCUSU_ACTIVO(results.getBoolean(12));
				tmpCgg_usuario.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				tmpCgg_usuario.setCUSU_ESTADO(results.getBoolean(14));
				outCgg_usuario.add(tmpCgg_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_usuario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCusu_usuario_interno IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO INTERNO
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword,
			String inCusu_usuario_interno,
			String inCrper_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCusu_usuario_interno);
			stmSelect.setString(9, inCrper_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCusu_usuario_interno IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO INTERNO
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA.
	 * @return int NUMERO DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection,
			String inKeyword,
			String inCusu_usuario_interno,
			String inCrper_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCusu_usuario_interno);
			stmSelect.setString(4, inCrper_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_usuario.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_usuario().getCUSU_CODIGO());
			stmUpdate.setString(2, this.getCgg_usuario().getCRCRG_CODIGO());
			stmUpdate.setString(3, this.getCgg_usuario().getCRPER_CODIGO());
			stmUpdate.setString(4, this.getCgg_usuario().getCRPJR_CODIGO());
			stmUpdate.setString(5, this.getCgg_usuario().getCCTN_CODIGO());
			stmUpdate.setString(6, this.getCgg_usuario().getCISLA_CODIGO());
			stmUpdate.setString(7, this.getCgg_usuario().getCUSU_NOMBRE_USUARIO());
			stmUpdate.setString(8, this.getCgg_usuario().getCUSU_CLAVE_ACCESO());
			stmUpdate.setBoolean(9, this.getCgg_usuario().getCUSU_USUARIO_INTERNO());
			stmUpdate.setBoolean(10, this.getCgg_usuario().getCUSU_CADUCA_CLAVE());
			stmUpdate.setTimestamp(11, this.getCgg_usuario().getCUSU_FECHA_CLAVE_ACT()!=null?new java.sql.Timestamp(this.getCgg_usuario().getCUSU_FECHA_CLAVE_ACT().getTime()):null);
			stmUpdate.setBoolean(12, this.getCgg_usuario().getCUSU_ACTIVO());
			stmUpdate.setBoolean(13, this.getCgg_usuario().getCUSU_CAMBIAR_CLAVE());
			stmUpdate.setBoolean(14, this.getCgg_usuario().getCUSU_ESTADO());
			stmUpdate.setString(15, this.getCgg_usuario().getCUSU_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_usuario select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_usuario().setCUSU_CODIGO(results.getString(1));
				this.getCgg_usuario().setCRCRG_CODIGO(results.getString(2));
				this.getCgg_usuario().setCRPER_CODIGO(results.getString(3));
				this.getCgg_usuario().setCRPJR_CODIGO(results.getString(4));
				this.getCgg_usuario().setCCTN_CODIGO(results.getString(5));
				this.getCgg_usuario().setCISLA_CODIGO(results.getString(6));
				this.getCgg_usuario().setCUSU_NOMBRE_USUARIO(results.getString(7));
				this.getCgg_usuario().setCUSU_CLAVE_ACCESO(results.getString(8));
				this.getCgg_usuario().setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				this.getCgg_usuario().setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				this.getCgg_usuario().setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				this.getCgg_usuario().setCUSU_ACTIVO(results.getBoolean(12));
				this.getCgg_usuario().setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				this.getCgg_usuario().setCUSU_ESTADO(results.getBoolean(14));				
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_usuario();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inSoft MODO DE ELIMINADO DE LA INFORMACION: <code>true</code> LOGICO, <code>false</code> PERMANENTE
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String delete(
			java.sql.Connection inConnection,
			boolean inSoft
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			if(inSoft){
				tmpAutoCommit = inConnection.getAutoCommit();
				inConnection.setAutoCommit(false);
				tmpSP = inConnection.setSavepoint();
			}
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_usuario().getCUSU_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		if(outResult.equals("true") && inSoft){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_usuario().getCUSU_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}

	/**
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_usuario> selectCGG_CANTON(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> outCgg_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_usuario tmpCgg_usuario = new com.besixplus.sii.objects.Cgg_usuario();
				tmpCgg_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_usuario.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_usuario.setCRPER_CODIGO(results.getString(3));
				tmpCgg_usuario.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_usuario.setCCTN_CODIGO(results.getString(5));
				tmpCgg_usuario.setCISLA_CODIGO(results.getString(6));
				tmpCgg_usuario.setCUSU_NOMBRE_USUARIO(results.getString(7));
				tmpCgg_usuario.setCUSU_CLAVE_ACCESO(results.getString(8));
				tmpCgg_usuario.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				tmpCgg_usuario.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				tmpCgg_usuario.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				tmpCgg_usuario.setCUSU_ACTIVO(results.getBoolean(12));
				tmpCgg_usuario.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				tmpCgg_usuario.setCUSU_ESTADO(results.getBoolean(14));
				outCgg_usuario.add(tmpCgg_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_CANTON(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_usuario().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_usuario().getCCTN_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_usuario> selectCGG_ISLA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> outCgg_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_S_CGG_ISLA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCISLA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_usuario tmpCgg_usuario = new com.besixplus.sii.objects.Cgg_usuario();
				tmpCgg_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_usuario.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_usuario.setCRPER_CODIGO(results.getString(3));
				tmpCgg_usuario.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_usuario.setCCTN_CODIGO(results.getString(5));
				tmpCgg_usuario.setCISLA_CODIGO(results.getString(6));
				tmpCgg_usuario.setCUSU_NOMBRE_USUARIO(results.getString(7));
				tmpCgg_usuario.setCUSU_CLAVE_ACCESO(results.getString(8));
				tmpCgg_usuario.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				tmpCgg_usuario.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				tmpCgg_usuario.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				tmpCgg_usuario.setCUSU_ACTIVO(results.getBoolean(12));
				tmpCgg_usuario.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				tmpCgg_usuario.setCUSU_ESTADO(results.getBoolean(14));
				outCgg_usuario.add(tmpCgg_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_isla.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_D_CGG_ISLA(?) }");
			stmDelete.setString(1, this.getCgg_usuario().getCISLA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DS_CGG_ISLA(?) }");
				stmDelete.setString(1, this.getCgg_usuario().getCISLA_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_cargo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_usuario> selectCGG_RES_CARGO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> outCgg_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_S_CGG_RES_CARGO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCRCRG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_usuario tmpCgg_usuario = new com.besixplus.sii.objects.Cgg_usuario();
				tmpCgg_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_usuario.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_usuario.setCRPER_CODIGO(results.getString(3));
				tmpCgg_usuario.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_usuario.setCCTN_CODIGO(results.getString(5));
				tmpCgg_usuario.setCISLA_CODIGO(results.getString(6));
				tmpCgg_usuario.setCUSU_NOMBRE_USUARIO(results.getString(7));
				tmpCgg_usuario.setCUSU_CLAVE_ACCESO(results.getString(8));
				tmpCgg_usuario.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				tmpCgg_usuario.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				tmpCgg_usuario.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				tmpCgg_usuario.setCUSU_ACTIVO(results.getBoolean(12));
				tmpCgg_usuario.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				tmpCgg_usuario.setCUSU_ESTADO(results.getBoolean(14));
				outCgg_usuario.add(tmpCgg_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_cargo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_CARGO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_D_CGG_RES_CARGO(?) }");
			stmDelete.setString(1, this.getCgg_usuario().getCRCRG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DS_CGG_RES_CARGO(?) }");
				stmDelete.setString(1, this.getCgg_usuario().getCRCRG_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_usuario> selectCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> outCgg_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_usuario tmpCgg_usuario = new com.besixplus.sii.objects.Cgg_usuario();
				tmpCgg_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_usuario.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_usuario.setCRPER_CODIGO(results.getString(3));
				tmpCgg_usuario.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_usuario.setCCTN_CODIGO(results.getString(5));
				tmpCgg_usuario.setCISLA_CODIGO(results.getString(6));
				tmpCgg_usuario.setCUSU_NOMBRE_USUARIO(results.getString(7));
				tmpCgg_usuario.setCUSU_CLAVE_ACCESO(results.getString(8));
				tmpCgg_usuario.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				tmpCgg_usuario.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				tmpCgg_usuario.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				tmpCgg_usuario.setCUSU_ACTIVO(results.getBoolean(12));
				tmpCgg_usuario.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				tmpCgg_usuario.setCUSU_ESTADO(results.getBoolean(14));
				outCgg_usuario.add(tmpCgg_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_PERSONA(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_usuario().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_usuario().getCRPER_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_usuario> selectCGG_RES_PERSONA_JURIDICA(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> outCgg_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_S_CGG_RES_PERSONA_JURIDICA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_usuario tmpCgg_usuario = new com.besixplus.sii.objects.Cgg_usuario();
				tmpCgg_usuario.setCUSU_CODIGO(results.getString(1));
				tmpCgg_usuario.setCRCRG_CODIGO(results.getString(2));
				tmpCgg_usuario.setCRPER_CODIGO(results.getString(3));
				tmpCgg_usuario.setCRPJR_CODIGO(results.getString(4));
				tmpCgg_usuario.setCCTN_CODIGO(results.getString(5));
				tmpCgg_usuario.setCISLA_CODIGO(results.getString(6));
				tmpCgg_usuario.setCUSU_NOMBRE_USUARIO(results.getString(7));
				tmpCgg_usuario.setCUSU_CLAVE_ACCESO(results.getString(8));
				tmpCgg_usuario.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				tmpCgg_usuario.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				tmpCgg_usuario.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				tmpCgg_usuario.setCUSU_ACTIVO(results.getBoolean(12));
				tmpCgg_usuario.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				tmpCgg_usuario.setCUSU_ESTADO(results.getBoolean(14));
				outCgg_usuario.add(tmpCgg_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_D_CGG_RES_PERSONA_JURIDICA(?) }");
			stmDelete.setString(1, this.getCgg_usuario().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_USUARIO_DS_CGG_RES_PERSONA_JURIDICA(?) }");
				stmDelete.setString(1, this.getCgg_usuario().getCRPJR_CODIGO());
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
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_usuario DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_usuario OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public HashMap<String, Object> selectByUsername(
			java.sql.Connection inConnection
	){
		HashMap<String, Object> outUsuario = new HashMap<String, Object>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_POR_NOMBRE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCUSU_NOMBRE_USUARIO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				outUsuario = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
					outUsuario.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));

				this.getCgg_usuario().setCUSU_CODIGO(outUsuario.get("CUSU_CODIGO").toString());
				this.getCgg_usuario().setCRCRG_CODIGO(outUsuario.get("CRCRG_CODIGO")!=null?outUsuario.get("CRCRG_CODIGO").toString():null);
				this.getCgg_usuario().setCRPER_CODIGO(outUsuario.get("CRPER_CODIGO")!=null?outUsuario.get("CRPER_CODIGO").toString():null);
				this.getCgg_usuario().setCRPJR_CODIGO(outUsuario.get("CRPJR_CODIGO")!=null?outUsuario.get("CRPJR_CODIGO").toString():null);
				this.getCgg_usuario().setCCTN_CODIGO(outUsuario.get("CCTN_CODIGO")!=null?outUsuario.get("CCTN_CODIGO").toString():null);
				this.getCgg_usuario().setCUSU_NOMBRE_USUARIO(outUsuario.get("CUSU_NOMBRE_USUARIO").toString());
				this.getCgg_usuario().setCUSU_CLAVE_ACCESO(outUsuario.get("CUSU_CLAVE_ACCESO").toString());
				this.getCgg_usuario().setCUSU_USUARIO_INTERNO(Boolean.valueOf(outUsuario.get("CUSU_USUARIO_INTERNO").toString()));
				this.getCgg_usuario().setCUSU_CADUCA_CLAVE(Boolean.valueOf(outUsuario.get("CUSU_CADUCA_CLAVE").toString()));
				this.getCgg_usuario().setCUSU_FECHA_CLAVE_ACT((Date) outUsuario.get("CUSU_FECHA_CLAVE_ACT"));
				this.getCgg_usuario().setCUSU_ACTIVO(Boolean.valueOf(outUsuario.get("CUSU_ACTIVO").toString()));
				this.getCgg_usuario().setCUSU_CAMBIAR_CLAVE(outUsuario.get("CUSU_CAMBIAR_CLAVE")!=null?Boolean.valueOf(outUsuario.get("CUSU_CAMBIAR_CLAVE").toString()):false);
				this.getCgg_usuario().setCUSU_ESTADO(Boolean.valueOf(outUsuario.get("CUSU_ESTADO").toString()));
				this.getCgg_usuario().setCISLA_CODIGO(outUsuario.get("CISLA_CODIGO")!= null?outUsuario.get("CISLA_CODIGO").toString():null);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outUsuario;
	}
	/**
	 * Verifica que la contrasenia sea correcta segun el usuario
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCusu_codigo CRITERIO DE BUSQUEDA. CODIGO DEL USUARIO
	 * @param inCusu_clave_acceso CLAVE DE ACCESO
	 * @return outResult true / false.
	 */
	public String verificarContraseniaByUsuario(
			java.sql.Connection inConnection		
	){
		String outResult = "true";		
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_VERIFICAR_CONTRASENIA_BYUSUARIO(?,?) }");
			stmSelect.registerOutParameter(1, Types.BOOLEAN);
			stmSelect.setString(2, this.getCgg_usuario().getCUSU_CODIGO());
			stmSelect.setString(3, this.getCgg_usuario().getCUSU_CLAVE_ACCESO());
			stmSelect.execute();
			if(!stmSelect.getBoolean(1))
				outResult = "La clave anterior no coinciden.";
			stmSelect.close();
		}catch(SQLException e){
			outResult = e.getMessage();
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outResult;
	}

	/**Selecciona un usuario en por su codigo especificado junto con informacion de los nombres de la persona asociada.
	 * @param inConnection Conexion de datos.
	 * @return Objeto con informacion del usuario y la persona asociada.
	 */
	public com.besixplus.sii.objects.Cgg_usuario_persona select1(
			java.sql.Connection inConnection
	){		
		Cgg_usuario_persona objUsuarioPersonal = new Cgg_usuario_persona();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				objUsuarioPersonal.setCUSU_CODIGO(results.getString(1));
				objUsuarioPersonal.setCRCRG_CODIGO(results.getString(2));
				objUsuarioPersonal.setCRPER_CODIGO(results.getString(3));
				objUsuarioPersonal.setCRPJR_CODIGO(results.getString(4));
				objUsuarioPersonal.setCCTN_CODIGO(results.getString(5));
				objUsuarioPersonal.setCISLA_CODIGO(results.getString(6));
				objUsuarioPersonal.setCUSU_NOMBRE_USUARIO(results.getString(7));
				objUsuarioPersonal.setCUSU_CLAVE_ACCESO(results.getString(8));
				objUsuarioPersonal.setCUSU_USUARIO_INTERNO(results.getBoolean(9));
				objUsuarioPersonal.setCUSU_CADUCA_CLAVE(results.getBoolean(10));
				objUsuarioPersonal.setCUSU_FECHA_CLAVE_ACT(results.getTimestamp(11));
				objUsuarioPersonal.setCUSU_ACTIVO(results.getBoolean(12));
				objUsuarioPersonal.setCUSU_CAMBIAR_CLAVE(results.getBoolean(13));
				objUsuarioPersonal.setCUSU_ESTADO(results.getBoolean(14));
				

				com.besixplus.sii.objects.Cgg_res_persona objPersona = new com.besixplus.sii.objects.Cgg_res_persona();
				objPersona.setCRPER_CODIGO(results.getString(3));
				objPersona = new com.besixplus.sii.db.Cgg_res_persona(objPersona).select(inConnection);
				objUsuarioPersonal.setCRPER_APELLIDO_MATERNO(objPersona.getCRPER_APELLIDO_MATERNO());
				objUsuarioPersonal.setCRPER_APELLIDO_PATERNO(objPersona.getCRPER_APELLIDO_PATERNO());
				objUsuarioPersonal.setCRPER_NOMBRE_PERSONA(objPersona.getCRPER_NOMBRE_PERSONA());
				objUsuarioPersonal.setCRPER_NOMBRES(objPersona.getCRPER_NOMBRES());					

			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return objUsuarioPersonal;
	}
	/**Selecciona un usuario en por su codigo especificado junto con informacion de los nombres de la persona asociada.
	 * @param inConnection Conexion de datos.
	 * @return Objeto con informacion del usuario y la persona asociada.
	 */
	public com.besixplus.sii.objects.Cgg_usuario_persona selectCodigoUsuarioByIdUsuario(
			java.sql.Connection inConnection
	){		
		Cgg_usuario_persona objUsuarioPersonal = new Cgg_usuario_persona();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_SELECT_CODIGO_BY_NOMBRE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_usuario().getCUSU_NOMBRE_USUARIO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {					
				objUsuarioPersonal.setCUSU_CODIGO(results.getString(1));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return objUsuarioPersonal;
	}
}