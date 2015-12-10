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
* CLASE Cgg_kdx_compra_detalle
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_compra_detalle.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_compra_detalle implements Serializable{
	private static final long serialVersionUID = 1259592367;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_compra_detalle.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_compra_detalle myCgg_kdx_compra_detalle = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra_detalle.
	*/
	public Cgg_kdx_compra_detalle(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra_detalle.
	* @param inCgg_kdx_compra_detalle OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_compra_detalle.
	*/
	public Cgg_kdx_compra_detalle(
		com.besixplus.sii.objects.Cgg_kdx_compra_detalle inCgg_kdx_compra_detalle
	){
		this.setCgg_kdx_compra_detalle(inCgg_kdx_compra_detalle);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_compra_detalle.
	* @param inCgg_kdx_compra_detalle OBJETO Cgg_kdx_compra_detalle.
	* @return void
	*/
	public void setCgg_kdx_compra_detalle(com.besixplus.sii.objects.Cgg_kdx_compra_detalle inCgg_kdx_compra_detalle){
		this.myCgg_kdx_compra_detalle = inCgg_kdx_compra_detalle;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_compra_detalle.
	* @return Cgg_kdx_compra_detalle OBJETO Cgg_kdx_compra_detalle.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_compra_detalle getCgg_kdx_compra_detalle(){
		return this.myCgg_kdx_compra_detalle;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_compra_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_compra_detalle().getCKCMD_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_compra_detalle().getCKCMP_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_compra_detalle().getCKESP_CODIGO());
			stmInsert.setInt(5, this.getCgg_kdx_compra_detalle().getCKCMD_SERIE_INICIO());
			stmInsert.setInt(6, this.getCgg_kdx_compra_detalle().getCKCMD_SERIE_FIN());
			stmInsert.setInt(7, this.getCgg_kdx_compra_detalle().getCKCMD_CANTIDAD());
			stmInsert.setBigDecimal(8, this.getCgg_kdx_compra_detalle().getCKCMD_PRECIO_UNITARIO());
			stmInsert.setBigDecimal(9, this.getCgg_kdx_compra_detalle().getCKCMD_TOTAL());
			stmInsert.setBoolean(10, this.getCgg_kdx_compra_detalle().getCKCMD_ESTADO());
			stmInsert.setString(11, this.getCgg_kdx_compra_detalle().getCKCMD_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_compra_detalle().setCKCMD_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> outCgg_kdx_compra_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_compra_detalle tmpCgg_kdx_compra_detalle = new com.besixplus.sii.objects.Cgg_kdx_compra_detalle();
				tmpCgg_kdx_compra_detalle.setCKCMD_CODIGO(results.getString(1));
				tmpCgg_kdx_compra_detalle.setCKCMP_CODIGO(results.getString(2));
				tmpCgg_kdx_compra_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_INICIO(results.getInt(4));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_FIN(results.getInt(5));
				tmpCgg_kdx_compra_detalle.setCKCMD_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_compra_detalle.setCKCMD_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_compra_detalle.setCKCMD_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_compra_detalle.setCKCMD_ESTADO(results.getBoolean(9));
				outCgg_kdx_compra_detalle.add(tmpCgg_kdx_compra_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra_detalle;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> outCgg_kdx_compra_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_compra_detalle tmpCgg_kdx_compra_detalle = new com.besixplus.sii.objects.Cgg_kdx_compra_detalle();
				tmpCgg_kdx_compra_detalle.setCKCMD_CODIGO(results.getString(1));
				tmpCgg_kdx_compra_detalle.setCKCMP_CODIGO(results.getString(2));
				tmpCgg_kdx_compra_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_INICIO(results.getInt(4));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_FIN(results.getInt(5));
				tmpCgg_kdx_compra_detalle.setCKCMD_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_compra_detalle.setCKCMD_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_compra_detalle.setCKCMD_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_compra_detalle.setCKCMD_ESTADO(results.getBoolean(9));
				outCgg_kdx_compra_detalle.add(tmpCgg_kdx_compra_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra_detalle;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_compra_detalle = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_compra_detalle.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra_detalle;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_compra_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_compra_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_compra_detalle().getCKCMD_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_compra_detalle().getCKCMP_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_compra_detalle().getCKESP_CODIGO());
			stmUpdate.setInt(4, this.getCgg_kdx_compra_detalle().getCKCMD_SERIE_INICIO());
			stmUpdate.setInt(5, this.getCgg_kdx_compra_detalle().getCKCMD_SERIE_FIN());
			stmUpdate.setInt(6, this.getCgg_kdx_compra_detalle().getCKCMD_CANTIDAD());
			stmUpdate.setBigDecimal(7, this.getCgg_kdx_compra_detalle().getCKCMD_PRECIO_UNITARIO());
			stmUpdate.setBigDecimal(8, this.getCgg_kdx_compra_detalle().getCKCMD_TOTAL());
			stmUpdate.setBoolean(9, this.getCgg_kdx_compra_detalle().getCKCMD_ESTADO());
			stmUpdate.setString(10, this.getCgg_kdx_compra_detalle().getCKCMD_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_compra_detalle DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_compra_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_compra_detalle select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_compra_detalle().getCKCMD_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_compra_detalle().setCKCMD_CODIGO(results.getString(1));
				this.getCgg_kdx_compra_detalle().setCKCMP_CODIGO(results.getString(2));
				this.getCgg_kdx_compra_detalle().setCKESP_CODIGO(results.getString(3));
				this.getCgg_kdx_compra_detalle().setCKCMD_SERIE_INICIO(results.getInt(4));
				this.getCgg_kdx_compra_detalle().setCKCMD_SERIE_FIN(results.getInt(5));
				this.getCgg_kdx_compra_detalle().setCKCMD_CANTIDAD(results.getInt(6));
				this.getCgg_kdx_compra_detalle().setCKCMD_PRECIO_UNITARIO(results.getBigDecimal(7));
				this.getCgg_kdx_compra_detalle().setCKCMD_TOTAL(results.getBigDecimal(8));
				this.getCgg_kdx_compra_detalle().setCKCMD_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_compra_detalle();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_compra_detalle DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_compra_detalle().getCKCMD_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_compra_detalle().getCKCMD_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_compra_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> selectCGG_KDX_ESPECIE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> outCgg_kdx_compra_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_S_CGG_KDX_ESPECIE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_compra_detalle().getCKESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_compra_detalle tmpCgg_kdx_compra_detalle = new com.besixplus.sii.objects.Cgg_kdx_compra_detalle();
				tmpCgg_kdx_compra_detalle.setCKCMD_CODIGO(results.getString(1));
				tmpCgg_kdx_compra_detalle.setCKCMP_CODIGO(results.getString(2));
				tmpCgg_kdx_compra_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_INICIO(results.getInt(4));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_FIN(results.getInt(5));
				tmpCgg_kdx_compra_detalle.setCKCMD_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_compra_detalle.setCKCMD_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_compra_detalle.setCKCMD_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_compra_detalle.setCKCMD_ESTADO(results.getBoolean(9));
				outCgg_kdx_compra_detalle.add(tmpCgg_kdx_compra_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_ESPECIE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_D_CGG_KDX_ESPECIE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_compra_detalle().getCKESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_DS_CGG_KDX_ESPECIE(?) }");
				stmDelete.setString(1, this.getCgg_kdx_compra_detalle().getCKESP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_compra.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_compra_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> selectCGG_KDX_COMPRA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle> outCgg_kdx_compra_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_DETALLE_S_CGG_KDX_COMPRA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_compra_detalle().getCKCMP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_compra_detalle tmpCgg_kdx_compra_detalle = new com.besixplus.sii.objects.Cgg_kdx_compra_detalle();
				tmpCgg_kdx_compra_detalle.setCKCMD_CODIGO(results.getString(1));
				tmpCgg_kdx_compra_detalle.setCKCMP_CODIGO(results.getString(2));
				tmpCgg_kdx_compra_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_INICIO(results.getInt(4));
				tmpCgg_kdx_compra_detalle.setCKCMD_SERIE_FIN(results.getInt(5));
				tmpCgg_kdx_compra_detalle.setCKCMD_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_compra_detalle.setCKCMD_PRECIO_UNITARIO(results.getBigDecimal(7));
				tmpCgg_kdx_compra_detalle.setCKCMD_TOTAL(results.getBigDecimal(8));
				tmpCgg_kdx_compra_detalle.setCKCMD_ESTADO(results.getBoolean(9));
				outCgg_kdx_compra_detalle.add(tmpCgg_kdx_compra_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_compra_detalle DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_compra.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_COMPRA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_D_CGG_KDX_COMPRA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_compra_detalle().getCKCMP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DETALLE_DS_CGG_KDX_COMPRA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_compra_detalle().getCKCMP_CODIGO());
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