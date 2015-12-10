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
* CLASE Cgg_kdx_venta_detalle
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_venta_detalle.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_venta_detalle implements Serializable{
	private static final long serialVersionUID = 1599128012;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_venta_detalle.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_venta_detalle myCgg_kdx_venta_detalle = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_detalle.
	*/
	public Cgg_kdx_venta_detalle(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_detalle.
	* @param inCgg_kdx_venta_detalle OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_venta_detalle.
	*/
	public Cgg_kdx_venta_detalle(
		com.besixplus.sii.objects.Cgg_kdx_venta_detalle inCgg_kdx_venta_detalle
	){
		this.setCgg_kdx_venta_detalle(inCgg_kdx_venta_detalle);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_venta_detalle.
	* @param inCgg_kdx_venta_detalle OBJETO Cgg_kdx_venta_detalle.
	* @return void
	*/
	public void setCgg_kdx_venta_detalle(com.besixplus.sii.objects.Cgg_kdx_venta_detalle inCgg_kdx_venta_detalle){
		this.myCgg_kdx_venta_detalle = inCgg_kdx_venta_detalle;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_venta_detalle.
	* @return Cgg_kdx_venta_detalle OBJETO Cgg_kdx_venta_detalle.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_venta_detalle getCgg_kdx_venta_detalle(){
		return this.myCgg_kdx_venta_detalle;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_venta_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_venta_detalle().getCKVDT_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_venta_detalle().getCKVNT_CODIGO());
			stmInsert.setString(4, this.getCgg_kdx_venta_detalle().getCKESP_CODIGO());
			stmInsert.setString(5, this.getCgg_kdx_venta_detalle().getCTREG_CODIGO());
			stmInsert.setString(6, this.getCgg_kdx_venta_detalle().getCRCNT_CODIGO());
			stmInsert.setString(7, this.getCgg_kdx_venta_detalle().getCTIGF_CODIGO());
			stmInsert.setInt(8, this.getCgg_kdx_venta_detalle().getCKVDT_CANTIDAD());
			stmInsert.setInt(9, this.getCgg_kdx_venta_detalle().getCKVDT_SERIE());
			stmInsert.setBigDecimal(10, this.getCgg_kdx_venta_detalle().getCKVDT_PRECIO_UNITARIO());
			stmInsert.setBigDecimal(11, this.getCgg_kdx_venta_detalle().getCKVDT_TOTAL());
			stmInsert.setBoolean(12, this.getCgg_kdx_venta_detalle().getCKVDT_ESTADO());
			stmInsert.setString(13, this.getCgg_kdx_venta_detalle().getCKVDT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_venta_detalle().setCKVDT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> outCgg_kdx_venta_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_detalle tmpCgg_kdx_venta_detalle = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				tmpCgg_kdx_venta_detalle.setCKVDT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_detalle.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_detalle.setCTREG_CODIGO(results.getString(4));
				tmpCgg_kdx_venta_detalle.setCRCNT_CODIGO(results.getString(5));
				tmpCgg_kdx_venta_detalle.setCTIGF_CODIGO(results.getString(6));
				tmpCgg_kdx_venta_detalle.setCKVDT_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_venta_detalle.setCKVDT_SERIE(results.getInt(8));
				tmpCgg_kdx_venta_detalle.setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_venta_detalle.setCKVDT_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_venta_detalle.setCKVDT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta_detalle.add(tmpCgg_kdx_venta_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> outCgg_kdx_venta_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_venta_detalle tmpCgg_kdx_venta_detalle = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				tmpCgg_kdx_venta_detalle.setCKVDT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_detalle.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_detalle.setCTREG_CODIGO(results.getString(4));
				tmpCgg_kdx_venta_detalle.setCRCNT_CODIGO(results.getString(5));
				tmpCgg_kdx_venta_detalle.setCTIGF_CODIGO(results.getString(6));
				tmpCgg_kdx_venta_detalle.setCKVDT_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_venta_detalle.setCKVDT_SERIE(results.getInt(8));
				tmpCgg_kdx_venta_detalle.setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_venta_detalle.setCKVDT_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_venta_detalle.setCKVDT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta_detalle.add(tmpCgg_kdx_venta_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_venta_detalle = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_venta_detalle.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_venta_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_venta_detalle.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_venta_detalle().getCKVDT_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_venta_detalle().getCKVNT_CODIGO());
			stmUpdate.setString(3, this.getCgg_kdx_venta_detalle().getCKESP_CODIGO());
			stmUpdate.setString(4, this.getCgg_kdx_venta_detalle().getCTREG_CODIGO());
			stmUpdate.setString(5, this.getCgg_kdx_venta_detalle().getCRCNT_CODIGO());
			stmUpdate.setString(6, this.getCgg_kdx_venta_detalle().getCTIGF_CODIGO());
			stmUpdate.setInt(7, this.getCgg_kdx_venta_detalle().getCKVDT_CANTIDAD());
			stmUpdate.setInt(8, this.getCgg_kdx_venta_detalle().getCKVDT_SERIE());
			stmUpdate.setBigDecimal(9, this.getCgg_kdx_venta_detalle().getCKVDT_PRECIO_UNITARIO());
			stmUpdate.setBigDecimal(10, this.getCgg_kdx_venta_detalle().getCKVDT_TOTAL());
			stmUpdate.setBoolean(11, this.getCgg_kdx_venta_detalle().getCKVDT_ESTADO());
			stmUpdate.setString(12, this.getCgg_kdx_venta_detalle().getCKVDT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_venta_detalle select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCKVDT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_venta_detalle().setCKVDT_CODIGO(results.getString(1));
				this.getCgg_kdx_venta_detalle().setCKVNT_CODIGO(results.getString(2));
				this.getCgg_kdx_venta_detalle().setCKESP_CODIGO(results.getString(3));
				this.getCgg_kdx_venta_detalle().setCTREG_CODIGO(results.getString(4));
				this.getCgg_kdx_venta_detalle().setCRCNT_CODIGO(results.getString(5));
				this.getCgg_kdx_venta_detalle().setCTIGF_CODIGO(results.getString(6));
				this.getCgg_kdx_venta_detalle().setCKVDT_CANTIDAD(results.getInt(7));
				this.getCgg_kdx_venta_detalle().setCKVDT_SERIE(results.getInt(8));
				this.getCgg_kdx_venta_detalle().setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				this.getCgg_kdx_venta_detalle().setCKVDT_TOTAL(results.getBigDecimal(10));
				this.getCgg_kdx_venta_detalle().setCKVDT_ESTADO(results.getBoolean(11));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_venta_detalle();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCKVDT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCKVDT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> selectCGG_KDX_VENTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> outCgg_kdx_venta_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_S_CGG_KDX_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCKVNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_detalle tmpCgg_kdx_venta_detalle = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				tmpCgg_kdx_venta_detalle.setCKVDT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_detalle.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_detalle.setCTREG_CODIGO(results.getString(4));
				tmpCgg_kdx_venta_detalle.setCRCNT_CODIGO(results.getString(5));
				tmpCgg_kdx_venta_detalle.setCTIGF_CODIGO(results.getString(6));
				tmpCgg_kdx_venta_detalle.setCKVDT_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_venta_detalle.setCKVDT_SERIE(results.getInt(8));
				tmpCgg_kdx_venta_detalle.setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_venta_detalle.setCKVDT_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_venta_detalle.setCKVDT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta_detalle.add(tmpCgg_kdx_venta_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_venta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_KDX_VENTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_D_CGG_KDX_VENTA(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCKVNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_DS_CGG_KDX_VENTA(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCKVNT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_registro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String, Object>> selectCGG_TCT_REGISTRO(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String, Object>> outCgg_kdx_venta_detalle = new ArrayList<HashMap<String, Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_S_CGG_TCT_REGISTRO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCTREG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_venta_detalle.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_hospedaje DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public String deleteCGG_TCT_REGISTRO1(
		java.sql.Connection inConnection
	){
		String outResult = "true";	
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_D_CGG_TCT_REGISTRO(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCTREG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_ingreso_fallido.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> selectCGG_TCT_INGRESO_FALLIDO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> outCgg_kdx_venta_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_S_CGG_TCT_INGRESO_FALLIDO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCTIGF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_detalle tmpCgg_kdx_venta_detalle = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				tmpCgg_kdx_venta_detalle.setCKVDT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_detalle.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_detalle.setCTREG_CODIGO(results.getString(4));
				tmpCgg_kdx_venta_detalle.setCRCNT_CODIGO(results.getString(5));
				tmpCgg_kdx_venta_detalle.setCTIGF_CODIGO(results.getString(6));
				tmpCgg_kdx_venta_detalle.setCKVDT_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_venta_detalle.setCKVDT_SERIE(results.getInt(8));
				tmpCgg_kdx_venta_detalle.setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_venta_detalle.setCKVDT_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_venta_detalle.setCKVDT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta_detalle.add(tmpCgg_kdx_venta_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_ingreso_fallido.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_INGRESO_FALLIDO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_D_CGG_TCT_INGRESO_FALLIDO(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCTIGF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_DS_CGG_TCT_INGRESO_FALLIDO(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCTIGF_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_carnet.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> selectCGG_RES_CARNET(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> outCgg_kdx_venta_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_S_CGG_RES_CARNET(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCRCNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_detalle tmpCgg_kdx_venta_detalle = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				tmpCgg_kdx_venta_detalle.setCKVDT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_detalle.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_detalle.setCTREG_CODIGO(results.getString(4));
				tmpCgg_kdx_venta_detalle.setCRCNT_CODIGO(results.getString(5));
				tmpCgg_kdx_venta_detalle.setCTIGF_CODIGO(results.getString(6));
				tmpCgg_kdx_venta_detalle.setCKVDT_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_venta_detalle.setCKVDT_SERIE(results.getInt(8));
				tmpCgg_kdx_venta_detalle.setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_venta_detalle.setCKVDT_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_venta_detalle.setCKVDT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta_detalle.add(tmpCgg_kdx_venta_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_carnet.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_CARNET(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_D_CGG_RES_CARNET(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCRCNT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_DS_CGG_RES_CARNET(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCRCNT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> selectCGG_KDX_ESPECIE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle> outCgg_kdx_venta_detalle = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_venta_detalle>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_S_CGG_KDX_ESPECIE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCKESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_venta_detalle tmpCgg_kdx_venta_detalle = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				tmpCgg_kdx_venta_detalle.setCKVDT_CODIGO(results.getString(1));
				tmpCgg_kdx_venta_detalle.setCKVNT_CODIGO(results.getString(2));
				tmpCgg_kdx_venta_detalle.setCKESP_CODIGO(results.getString(3));
				tmpCgg_kdx_venta_detalle.setCTREG_CODIGO(results.getString(4));
				tmpCgg_kdx_venta_detalle.setCRCNT_CODIGO(results.getString(5));
				tmpCgg_kdx_venta_detalle.setCTIGF_CODIGO(results.getString(6));
				tmpCgg_kdx_venta_detalle.setCKVDT_CANTIDAD(results.getInt(7));
				tmpCgg_kdx_venta_detalle.setCKVDT_SERIE(results.getInt(8));
				tmpCgg_kdx_venta_detalle.setCKVDT_PRECIO_UNITARIO(results.getBigDecimal(9));
				tmpCgg_kdx_venta_detalle.setCKVDT_TOTAL(results.getBigDecimal(10));
				tmpCgg_kdx_venta_detalle.setCKVDT_ESTADO(results.getBoolean(11));
				outCgg_kdx_venta_detalle.add(tmpCgg_kdx_venta_detalle);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_kdx_especie.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_D_CGG_KDX_ESPECIE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCKESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_VENTA_DETALLE_DS_CGG_KDX_ESPECIE(?) }");
				stmDelete.setString(1, this.getCgg_kdx_venta_detalle().getCKESP_CODIGO());
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
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_venta_detalle CORRESPONDIENTE A LA VENTA DE TCT.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inAmbito IDENTIFICADOR DEL TIPO DE ESPECIE.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String ventaRegistro(
		java.sql.Connection inConnection,
		String inUserName,
		int inAmbito
	){
		String outResult = "true";
		try{
			CallableStatement stmInsertTCTVenta = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_REGISTRO(?,?,?,?) }");
			stmInsertTCTVenta.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsertTCTVenta.setString(2, inUserName);
			stmInsertTCTVenta.setInt(3, inAmbito);
			stmInsertTCTVenta.setString(4, this.getCgg_kdx_venta_detalle().getCKESP_CODIGO());
			stmInsertTCTVenta.setString(5, this.getCgg_kdx_venta_detalle().getCTREG_CODIGO());
			stmInsertTCTVenta.execute();
			outResult = stmInsertTCTVenta.getString(1);
			stmInsertTCTVenta.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_venta_detalle DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_venta_detalle OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectGroupByVenta(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_venta_detalle = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_VENTA_DETALLE_SELECT_GROUP_BY_VENTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_venta_detalle().getCKVNT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_venta_detalle.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_venta_detalle;
	}
	
}