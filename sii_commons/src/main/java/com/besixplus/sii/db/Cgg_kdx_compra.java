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
* CLASE Cgg_kdx_compra
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_compra.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_compra implements Serializable{
	private static final long serialVersionUID = 679587225;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_compra.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_compra myCgg_kdx_compra = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra.
	*/
	public Cgg_kdx_compra(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra.
	* @param inCgg_kdx_compra OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_compra.
	*/
	public Cgg_kdx_compra(
		com.besixplus.sii.objects.Cgg_kdx_compra inCgg_kdx_compra
	){
		this.setCgg_kdx_compra(inCgg_kdx_compra);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_compra.
	* @param inCgg_kdx_compra OBJETO Cgg_kdx_compra.
	* @return void
	*/
	public void setCgg_kdx_compra(com.besixplus.sii.objects.Cgg_kdx_compra inCgg_kdx_compra){
		this.myCgg_kdx_compra = inCgg_kdx_compra;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_compra.
	* @return Cgg_kdx_compra OBJETO Cgg_kdx_compra.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_compra getCgg_kdx_compra(){
		return this.myCgg_kdx_compra;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_compra.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_compra().getCKCMP_CODIGO());
			stmInsert.setInt(3, this.getCgg_kdx_compra().getCKCMP_LOTE());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_kdx_compra().getCKCMP_FECHA_INGRESO().getTime()));
			stmInsert.setString(5, this.getCgg_kdx_compra().getCKCMP_SERIE());
			stmInsert.setString(6, this.getCgg_kdx_compra().getCKCMP_PROCEDENCIA());
			stmInsert.setInt(7, this.getCgg_kdx_compra().getCKCMP_CANTIDAD());
			stmInsert.setString(8, this.getCgg_kdx_compra().getCKCMP_FACTURA());
			stmInsert.setString(9, this.getCgg_kdx_compra().getCKCMP_TOTAL());
			stmInsert.setBoolean(10, this.getCgg_kdx_compra().getCKCMP_ESTADO());
			stmInsert.setString(11, this.getCgg_kdx_compra().getCKCMP_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_compra().setCKCMP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> outCgg_kdx_compra = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_compra tmpCgg_kdx_compra = new com.besixplus.sii.objects.Cgg_kdx_compra();
				tmpCgg_kdx_compra.setCKCMP_CODIGO(results.getString(1));
				tmpCgg_kdx_compra.setCKCMP_LOTE(results.getInt(2));
				tmpCgg_kdx_compra.setCKCMP_FECHA_INGRESO(results.getTimestamp(3));
				tmpCgg_kdx_compra.setCKCMP_SERIE(results.getString(4));
				tmpCgg_kdx_compra.setCKCMP_PROCEDENCIA(results.getString(5));
				tmpCgg_kdx_compra.setCKCMP_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_compra.setCKCMP_FACTURA(results.getString(7));
				tmpCgg_kdx_compra.setCKCMP_TOTAL(results.getString(8));
				tmpCgg_kdx_compra.setCKCMP_ESTADO(results.getBoolean(9));
				outCgg_kdx_compra.add(tmpCgg_kdx_compra);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> outCgg_kdx_compra = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_compra tmpCgg_kdx_compra = new com.besixplus.sii.objects.Cgg_kdx_compra();
				tmpCgg_kdx_compra.setCKCMP_CODIGO(results.getString(1));
				tmpCgg_kdx_compra.setCKCMP_LOTE(results.getInt(2));
				tmpCgg_kdx_compra.setCKCMP_FECHA_INGRESO(results.getTimestamp(3));
				tmpCgg_kdx_compra.setCKCMP_SERIE(results.getString(4));
				tmpCgg_kdx_compra.setCKCMP_PROCEDENCIA(results.getString(5));
				tmpCgg_kdx_compra.setCKCMP_CANTIDAD(results.getInt(6));
				tmpCgg_kdx_compra.setCKCMP_FACTURA(results.getString(7));
				tmpCgg_kdx_compra.setCKCMP_TOTAL(results.getString(8));
				tmpCgg_kdx_compra.setCKCMP_ESTADO(results.getBoolean(9));
				outCgg_kdx_compra.add(tmpCgg_kdx_compra);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_compra = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_compra.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_compra.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_compra.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_compra().getCKCMP_CODIGO());
			stmUpdate.setInt(2, this.getCgg_kdx_compra().getCKCMP_LOTE());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_kdx_compra().getCKCMP_FECHA_INGRESO().getTime()));
			stmUpdate.setString(4, this.getCgg_kdx_compra().getCKCMP_SERIE());
			stmUpdate.setString(5, this.getCgg_kdx_compra().getCKCMP_PROCEDENCIA());
			stmUpdate.setInt(6, this.getCgg_kdx_compra().getCKCMP_CANTIDAD());
			stmUpdate.setString(7, this.getCgg_kdx_compra().getCKCMP_FACTURA());
			stmUpdate.setString(8, this.getCgg_kdx_compra().getCKCMP_TOTAL());
			stmUpdate.setBoolean(9, this.getCgg_kdx_compra().getCKCMP_ESTADO());
			stmUpdate.setString(10, this.getCgg_kdx_compra().getCKCMP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_compra DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_compra OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_compra select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_compra().getCKCMP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_compra().setCKCMP_CODIGO(results.getString(1));
				this.getCgg_kdx_compra().setCKCMP_LOTE(results.getInt(2));
				this.getCgg_kdx_compra().setCKCMP_FECHA_INGRESO(results.getTimestamp(3));
				this.getCgg_kdx_compra().setCKCMP_SERIE(results.getString(4));
				this.getCgg_kdx_compra().setCKCMP_PROCEDENCIA(results.getString(5));
				this.getCgg_kdx_compra().setCKCMP_CANTIDAD(results.getInt(6));
				this.getCgg_kdx_compra().setCKCMP_FACTURA(results.getString(7));
				this.getCgg_kdx_compra().setCKCMP_TOTAL(results.getString(8));
				this.getCgg_kdx_compra().setCKCMP_ESTADO(results.getBoolean(9));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_compra();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_compra DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_compra().getCKCMP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_COMPRA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_compra().getCKCMP_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllWithEspecie(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_kdx_compra = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_COMPRA_SELECT_ESPECIE(?,?,?,?,?,?) }");
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
				outCgg_kdx_compra.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_compra;
	}
}