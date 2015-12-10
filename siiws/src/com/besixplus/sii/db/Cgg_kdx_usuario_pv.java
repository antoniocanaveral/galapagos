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
* CLASE Cgg_kdx_usuario_pv
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_usuario_pv.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_usuario_pv implements Serializable{
	private static final long serialVersionUID = 829127482;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_usuario_pv.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_usuario_pv myCgg_kdx_usuario_pv = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_usuario_pv.
	*/
	public Cgg_kdx_usuario_pv(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_usuario_pv.
	* @param inCgg_kdx_usuario_pv OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_usuario_pv.
	*/
	public Cgg_kdx_usuario_pv(
		com.besixplus.sii.objects.Cgg_kdx_usuario_pv inCgg_kdx_usuario_pv
	){
		this.setCgg_kdx_usuario_pv(inCgg_kdx_usuario_pv);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_usuario_pv.
	* @param inCgg_kdx_usuario_pv OBJETO Cgg_kdx_usuario_pv.
	* @return void
	*/
	public void setCgg_kdx_usuario_pv(com.besixplus.sii.objects.Cgg_kdx_usuario_pv inCgg_kdx_usuario_pv){
		this.myCgg_kdx_usuario_pv = inCgg_kdx_usuario_pv;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_usuario_pv.
	* @return Cgg_kdx_usuario_pv OBJETO Cgg_kdx_usuario_pv.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_usuario_pv getCgg_kdx_usuario_pv(){
		return this.myCgg_kdx_usuario_pv;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_usuario_pv().getCKUPV_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_usuario_pv().getCKPVT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_usuario_pv().getCUSU_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_kdx_usuario_pv().getCKPVT_ACTIVO());
			stmInsert.setBoolean(6, this.getCgg_kdx_usuario_pv().getCKUPV_SUPERVISOR());
			stmInsert.setBoolean(7, this.getCgg_kdx_usuario_pv().getCKUPV_ESTADO());
			stmInsert.setString(8, this.getCgg_kdx_usuario_pv().getCKUPV_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_usuario_pv().setCKUPV_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> outCgg_kdx_usuario_pv = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_usuario_pv tmpCgg_kdx_usuario_pv = new com.besixplus.sii.objects.Cgg_kdx_usuario_pv();
				tmpCgg_kdx_usuario_pv.setCKUPV_CODIGO(results.getString(1));
				tmpCgg_kdx_usuario_pv.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_usuario_pv.setCUSU_CODIGO(results.getString(3));
				tmpCgg_kdx_usuario_pv.setCKPVT_ACTIVO(results.getBoolean(4));
				tmpCgg_kdx_usuario_pv.setCKUPV_SUPERVISOR(results.getBoolean(5));
				tmpCgg_kdx_usuario_pv.setCKUPV_ESTADO(results.getBoolean(6));
				outCgg_kdx_usuario_pv.add(tmpCgg_kdx_usuario_pv);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_usuario_pv;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> outCgg_kdx_usuario_pv = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_usuario_pv tmpCgg_kdx_usuario_pv = new com.besixplus.sii.objects.Cgg_kdx_usuario_pv();
				tmpCgg_kdx_usuario_pv.setCKUPV_CODIGO(results.getString(1));
				tmpCgg_kdx_usuario_pv.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_usuario_pv.setCUSU_CODIGO(results.getString(3));
				tmpCgg_kdx_usuario_pv.setCKPVT_ACTIVO(results.getBoolean(4));
				tmpCgg_kdx_usuario_pv.setCKUPV_SUPERVISOR(results.getBoolean(5));
				tmpCgg_kdx_usuario_pv.setCKUPV_ESTADO(results.getBoolean(6));
				outCgg_kdx_usuario_pv.add(tmpCgg_kdx_usuario_pv);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_usuario_pv;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_usuario_pv = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_usuario_pv.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_usuario_pv;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_usuario_pv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_usuario_pv().getCKUPV_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_usuario_pv().getCKPVT_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_usuario_pv().getCUSU_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_kdx_usuario_pv().getCKPVT_ACTIVO());
			stmUpdate.setBoolean(5, this.getCgg_kdx_usuario_pv().getCKUPV_SUPERVISOR());
			stmUpdate.setBoolean(6, this.getCgg_kdx_usuario_pv().getCKUPV_ESTADO());
			stmUpdate.setString(7, this.getCgg_kdx_usuario_pv().getCKUPV_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_usuario_pv OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_usuario_pv select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_usuario_pv().getCKUPV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_usuario_pv().setCKUPV_CODIGO(results.getString(1));
				this.getCgg_kdx_usuario_pv().setCKPVT_CODIGO(results.getString(2));
				this.getCgg_kdx_usuario_pv().setCUSU_CODIGO(results.getString(3));
				this.getCgg_kdx_usuario_pv().setCKPVT_ACTIVO(results.getBoolean(4));
				this.getCgg_kdx_usuario_pv().setCKUPV_SUPERVISOR(results.getBoolean(5));
				this.getCgg_kdx_usuario_pv().setCKUPV_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_usuario_pv();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCKUPV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCKUPV_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_usuario_pv OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> outCgg_kdx_usuario_pv = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_usuario_pv().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_usuario_pv tmpCgg_kdx_usuario_pv = new com.besixplus.sii.objects.Cgg_kdx_usuario_pv();
				tmpCgg_kdx_usuario_pv.setCKUPV_CODIGO(results.getString(1));
				tmpCgg_kdx_usuario_pv.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_usuario_pv.setCUSU_CODIGO(results.getString(3));
				tmpCgg_kdx_usuario_pv.setCKPVT_ACTIVO(results.getBoolean(4));
				tmpCgg_kdx_usuario_pv.setCKUPV_SUPERVISOR(results.getBoolean(5));
				tmpCgg_kdx_usuario_pv.setCKUPV_ESTADO(results.getBoolean(6));
				outCgg_kdx_usuario_pv.add(tmpCgg_kdx_usuario_pv);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_usuario_pv;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_usuario_pv OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> selectCGG_KDX_PUNTO_VENTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv> outCgg_kdx_usuario_pv = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_S_CGG_KDX_PUNTO_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_usuario_pv().getCKPVT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_usuario_pv tmpCgg_kdx_usuario_pv = new com.besixplus.sii.objects.Cgg_kdx_usuario_pv();
				tmpCgg_kdx_usuario_pv.setCKUPV_CODIGO(results.getString(1));
				tmpCgg_kdx_usuario_pv.setCKPVT_CODIGO(results.getString(2));
				tmpCgg_kdx_usuario_pv.setCUSU_CODIGO(results.getString(3));
				tmpCgg_kdx_usuario_pv.setCKPVT_ACTIVO(results.getBoolean(4));
				tmpCgg_kdx_usuario_pv.setCKUPV_SUPERVISOR(results.getBoolean(5));
				tmpCgg_kdx_usuario_pv.setCKUPV_ESTADO(results.getBoolean(6));
				outCgg_kdx_usuario_pv.add(tmpCgg_kdx_usuario_pv);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_usuario_pv;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_PUNTO_VENTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_D_CGG_KDX_PUNTO_VENTA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCKPVT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_DS_CGG_KDX_PUNTO_VENTA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCKPVT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_usuario_pv>  VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectUsuarioPV(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_fase_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_USUARIO_PV_ALL_S_CGG_KDX_PUNTO_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_usuario_pv().getCKPVT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_fase_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_fase_usuario;
	}
	
	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_usuario_pv DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteTrusted(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
			try{
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_USUARIO_PV_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_usuario_pv().getCKUPV_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		
		return outResult;
	}

	/**
	* VERIFICA SI UN USUARIO SE HALLA ASIGNADO A UN PUNTO DE VENTA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DE QUIEN SE VERIFICARA SU ASIGNACION.
	* @return String RESPUESTA DE LA VERIFICACION.
	*/
	public static String verificarUsuarioAsignado(
		java.sql.Connection inConnection,
		String inUserName
	){
		String outResult = "false";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_USUARIO_PV_IS_ASIGNED(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setString(2,inUserName );
			stmSelect.execute();
			outResult = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outResult;
	}

}