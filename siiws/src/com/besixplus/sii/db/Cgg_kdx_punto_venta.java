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
* CLASE Cgg_kdx_punto_venta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_punto_venta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_punto_venta implements Serializable{
	private static final long serialVersionUID = 504009950;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_punto_venta.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_punto_venta myCgg_kdx_punto_venta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_punto_venta.
	*/
	public Cgg_kdx_punto_venta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_punto_venta.
	* @param inCgg_kdx_punto_venta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_punto_venta.
	*/
	public Cgg_kdx_punto_venta(
		com.besixplus.sii.objects.Cgg_kdx_punto_venta inCgg_kdx_punto_venta
	){
		this.setCgg_kdx_punto_venta(inCgg_kdx_punto_venta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_punto_venta.
	* @param inCgg_kdx_punto_venta OBJETO Cgg_kdx_punto_venta.
	* @return void
	*/
	public void setCgg_kdx_punto_venta(com.besixplus.sii.objects.Cgg_kdx_punto_venta inCgg_kdx_punto_venta){
		this.myCgg_kdx_punto_venta = inCgg_kdx_punto_venta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_punto_venta.
	* @return Cgg_kdx_punto_venta OBJETO Cgg_kdx_punto_venta.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_punto_venta getCgg_kdx_punto_venta(){
		return this.myCgg_kdx_punto_venta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_punto_venta().getCKPVT_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_punto_venta().getCCTN_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_punto_venta().getCKPVT_NOMBRE());
			stmInsert.setString(5, this.getCgg_kdx_punto_venta().getCKPVT_OBSERVACION());
			stmInsert.setBoolean(6, this.getCgg_kdx_punto_venta().getCKPVT_ESTADO());
			stmInsert.setString(7, this.getCgg_kdx_punto_venta().getCKPVT_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_kdx_punto_venta().getCKPVT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_kdx_punto_venta().setCKPVT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> outCgg_kdx_punto_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_punto_venta tmpCgg_kdx_punto_venta = new com.besixplus.sii.objects.Cgg_kdx_punto_venta();
				tmpCgg_kdx_punto_venta.setCKPVT_CODIGO(results.getString(1));
				tmpCgg_kdx_punto_venta.setCCTN_CODIGO(results.getString(2));
				tmpCgg_kdx_punto_venta.setCKPVT_NOMBRE(results.getString(3));
				tmpCgg_kdx_punto_venta.setCKPVT_OBSERVACION(results.getString(4));
				tmpCgg_kdx_punto_venta.setCKPVT_ESTADO(results.getBoolean(5));
				outCgg_kdx_punto_venta.add(tmpCgg_kdx_punto_venta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_punto_venta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_punto_venta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> outCgg_kdx_punto_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_punto_venta tmpCgg_kdx_punto_venta = new com.besixplus.sii.objects.Cgg_kdx_punto_venta();
				tmpCgg_kdx_punto_venta.setCKPVT_CODIGO(results.getString(1));
				tmpCgg_kdx_punto_venta.setCCTN_CODIGO(results.getString(2));
				tmpCgg_kdx_punto_venta.setCKPVT_NOMBRE(results.getString(3));
				tmpCgg_kdx_punto_venta.setCKPVT_OBSERVACION(results.getString(4));
				tmpCgg_kdx_punto_venta.setCKPVT_ESTADO(results.getBoolean(5));
				outCgg_kdx_punto_venta.add(tmpCgg_kdx_punto_venta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_punto_venta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_punto_venta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_punto_venta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_punto_venta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_punto_venta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_punto_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_PUNTO_VENTA_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_punto_venta().getCKPVT_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_punto_venta().getCCTN_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_punto_venta().getCKPVT_NOMBRE());
			stmUpdate.setString(4, this.getCgg_kdx_punto_venta().getCKPVT_OBSERVACION());
			stmUpdate.setBoolean(5, this.getCgg_kdx_punto_venta().getCKPVT_ESTADO());
			stmUpdate.setString(6, this.getCgg_kdx_punto_venta().getCKPVT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_punto_venta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_punto_venta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_punto_venta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_punto_venta().getCKPVT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_punto_venta().setCKPVT_CODIGO(results.getString(1));
				this.getCgg_kdx_punto_venta().setCCTN_CODIGO(results.getString(2));
				this.getCgg_kdx_punto_venta().setCKPVT_NOMBRE(results.getString(3));
				this.getCgg_kdx_punto_venta().setCKPVT_OBSERVACION(results.getString(4));
				this.getCgg_kdx_punto_venta().setCKPVT_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_punto_venta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_punto_venta DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_PUNTO_VENTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_punto_venta().getCKPVT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_PUNTO_VENTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_punto_venta().getCKPVT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_punto_venta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_punto_venta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> selectCGG_CANTON(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta> outCgg_kdx_punto_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_PUNTO_VENTA_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_punto_venta().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_punto_venta tmpCgg_kdx_punto_venta = new com.besixplus.sii.objects.Cgg_kdx_punto_venta();
				tmpCgg_kdx_punto_venta.setCKPVT_CODIGO(results.getString(1));
				tmpCgg_kdx_punto_venta.setCCTN_CODIGO(results.getString(2));
				tmpCgg_kdx_punto_venta.setCKPVT_NOMBRE(results.getString(3));
				tmpCgg_kdx_punto_venta.setCKPVT_OBSERVACION(results.getString(4));
				tmpCgg_kdx_punto_venta.setCKPVT_ESTADO(results.getBoolean(5));
				outCgg_kdx_punto_venta.add(tmpCgg_kdx_punto_venta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_punto_venta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_punto_venta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_PUNTO_VENTA_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_kdx_punto_venta().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_PUNTO_VENTA_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_kdx_punto_venta().getCCTN_CODIGO());
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
	 * Selecciona todos los puntos de venta con el codigo de usuario de punto.
	 * @param inConnection Conexion de datos.
	 * @param inUserName Nombre de usuario.
	 * @return Coleccion de datos.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario> selectPuntoUsuario(
			java.sql.Connection inConnection,
			String inUserName,
			String inKeyword
		){
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario> outCgg_kdx_punto_venta = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_KDX_PUNTO_VENTA_USUARIO(?,?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, inUserName);
				stmSelect.setString(3, inKeyword);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				while (results.next()) {
					com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario tmpCgg_kdx_punto_venta = new com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario();
					tmpCgg_kdx_punto_venta.setCKPVT_CODIGO(results.getString(1));
					tmpCgg_kdx_punto_venta.setCCTN_CODIGO(results.getString(2));
					tmpCgg_kdx_punto_venta.setCKPVT_NOMBRE(results.getString(3));
					tmpCgg_kdx_punto_venta.setCUSU_CODIGO(results.getString(4));
					tmpCgg_kdx_punto_venta.setCUSU_NOMBRE_USUARIO(results.getString(5));
					outCgg_kdx_punto_venta.add(tmpCgg_kdx_punto_venta);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_kdx_punto_venta;
		}

}