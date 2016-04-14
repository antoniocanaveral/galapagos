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
* CLASE Cgg_kdx_especie
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_especie.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_especie implements Serializable{
	private static final long serialVersionUID = 929272160;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_especie.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_especie myCgg_kdx_especie = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_especie.
	*/
	public Cgg_kdx_especie(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_especie.
	* @param inCgg_kdx_especie OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_especie.
	*/
	public Cgg_kdx_especie(
		com.besixplus.sii.objects.Cgg_kdx_especie inCgg_kdx_especie
	){
		this.setCgg_kdx_especie(inCgg_kdx_especie);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_especie.
	* @param inCgg_kdx_especie OBJETO Cgg_kdx_especie.
	* @return void
	*/
	public void setCgg_kdx_especie(com.besixplus.sii.objects.Cgg_kdx_especie inCgg_kdx_especie){
		this.myCgg_kdx_especie = inCgg_kdx_especie;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_especie.
	* @return Cgg_kdx_especie OBJETO Cgg_kdx_especie.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_especie getCgg_kdx_especie(){
		return this.myCgg_kdx_especie;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_INSERT(?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_especie().getCKESP_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_especie().getCKESP_NOMBRE());
			stmInsert.setBigDecimal(4, this.getCgg_kdx_especie().getCKESP_PRECIO());
			stmInsert.setInt(5, this.getCgg_kdx_especie().getCKESP_CANTIDAD());
			stmInsert.setInt(6, this.getCgg_kdx_especie().getCKESP_DISPONIBLE_MIN());
			stmInsert.setInt(7, this.getCgg_kdx_especie().getCKESP_DISPONIBLE_MAX());
			stmInsert.setInt(8, this.getCgg_kdx_especie().getCKESP_TIPO());
			stmInsert.setInt(9, this.getCgg_kdx_especie().getCKESP_INDICE());
			stmInsert.setString(10, this.getCgg_kdx_especie().getCKESP_REPORTE());
			stmInsert.setBoolean(11, this.getCgg_kdx_especie().getCKESP_ESTADO());
			stmInsert.setString(12, this.getCgg_kdx_especie().getCKESP_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_especie().setCKESP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inCkesp_tipo TIPO DE ESPECIE
		0 - RESIDENCIA
		1 - TCT
		2 - OTROS
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inCkesp_tipo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> outCgg_kdx_especie = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_SELECT_AS(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inCkesp_tipo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_especie tmpCgg_kdx_especie = new com.besixplus.sii.objects.Cgg_kdx_especie();
				tmpCgg_kdx_especie.setCKESP_CODIGO(results.getString(1));
				tmpCgg_kdx_especie.setCKESP_NOMBRE(results.getString(2));
				tmpCgg_kdx_especie.setCKESP_PRECIO(results.getBigDecimal(3));
				tmpCgg_kdx_especie.setCKESP_CANTIDAD(results.getInt(4));
				tmpCgg_kdx_especie.setCKESP_DISPONIBLE_MIN(results.getInt(5));
				tmpCgg_kdx_especie.setCKESP_DISPONIBLE_MAX(results.getInt(6));
				tmpCgg_kdx_especie.setCKESP_TIPO(results.getInt(7));
				tmpCgg_kdx_especie.setCKESP_INDICE(results.getInt(8));
				tmpCgg_kdx_especie.setCKESP_REPORTE(results.getString(9));
				tmpCgg_kdx_especie.setCKESP_ESTADO(results.getBoolean(10));
				outCgg_kdx_especie.add(tmpCgg_kdx_especie);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_especie;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_especie QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> outCgg_kdx_especie = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_especie tmpCgg_kdx_especie = new com.besixplus.sii.objects.Cgg_kdx_especie();
				tmpCgg_kdx_especie.setCKESP_CODIGO(results.getString(1));
				tmpCgg_kdx_especie.setCKESP_NOMBRE(results.getString(2));
				tmpCgg_kdx_especie.setCKESP_PRECIO(results.getBigDecimal(3));
				tmpCgg_kdx_especie.setCKESP_CANTIDAD(results.getInt(4));
				tmpCgg_kdx_especie.setCKESP_DISPONIBLE_MIN(results.getInt(5));
				tmpCgg_kdx_especie.setCKESP_DISPONIBLE_MAX(results.getInt(6));
				tmpCgg_kdx_especie.setCKESP_TIPO(results.getInt(7));
				tmpCgg_kdx_especie.setCKESP_INDICE(results.getInt(8));
				tmpCgg_kdx_especie.setCKESP_REPORTE(results.getString(9));
				tmpCgg_kdx_especie.setCKESP_ESTADO(results.getBoolean(10));
				outCgg_kdx_especie.add(tmpCgg_kdx_especie);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_especie;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_especie QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_especie = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_especie.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_especie;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_especie.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_ESPECIE_UPDATE(?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_especie().getCKESP_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_especie().getCKESP_NOMBRE());
			stmUpdate.setBigDecimal(3, this.getCgg_kdx_especie().getCKESP_PRECIO());
			stmUpdate.setInt(4, this.getCgg_kdx_especie().getCKESP_CANTIDAD());
			stmUpdate.setInt(5, this.getCgg_kdx_especie().getCKESP_DISPONIBLE_MIN());
			stmUpdate.setInt(6, this.getCgg_kdx_especie().getCKESP_DISPONIBLE_MAX());
			stmUpdate.setInt(7, this.getCgg_kdx_especie().getCKESP_TIPO());
			stmUpdate.setInt(8, this.getCgg_kdx_especie().getCKESP_INDICE());
			stmUpdate.setString(9, this.getCgg_kdx_especie().getCKESP_REPORTE());
			stmUpdate.setBoolean(10, this.getCgg_kdx_especie().getCKESP_ESTADO());
			stmUpdate.setString(11, this.getCgg_kdx_especie().getCKESP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_especie DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_especie OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_especie select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_ESPECIE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_especie().getCKESP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_especie().setCKESP_CODIGO(results.getString(1));
				this.getCgg_kdx_especie().setCKESP_NOMBRE(results.getString(2));
				this.getCgg_kdx_especie().setCKESP_PRECIO(results.getBigDecimal(3));
				this.getCgg_kdx_especie().setCKESP_CANTIDAD(results.getInt(4));
				this.getCgg_kdx_especie().setCKESP_DISPONIBLE_MIN(results.getInt(5));
				this.getCgg_kdx_especie().setCKESP_DISPONIBLE_MAX(results.getInt(6));
				this.getCgg_kdx_especie().setCKESP_TIPO(results.getInt(7));
				this.getCgg_kdx_especie().setCKESP_INDICE(results.getInt(8));
				this.getCgg_kdx_especie().setCKESP_REPORTE(results.getString(9));
				this.getCgg_kdx_especie().setCKESP_ESTADO(results.getBoolean(10));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_especie();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_especie DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ESPECIE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_especie().getCKESP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_ESPECIE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_especie().getCKESP_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_especie QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectTipoEspecie(
		java.sql.Connection inConnection
		
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_especie = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_KARDEX_ESPECIE_SELECT() }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_kdx_especie.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_especie;
	}

}