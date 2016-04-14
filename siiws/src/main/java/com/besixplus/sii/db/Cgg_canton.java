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
* CLASE Cgg_canton
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_canton.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_canton implements Serializable{
	private static final long serialVersionUID = 534243074;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_canton.
	*/
	private com.besixplus.sii.objects.Cgg_canton myCgg_canton = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_canton.
	*/
	public Cgg_canton(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_canton.
	* @param inCgg_canton OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_canton.
	*/
	public Cgg_canton(
		com.besixplus.sii.objects.Cgg_canton inCgg_canton
	){
		this.setCgg_canton(inCgg_canton);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_canton.
	* @param inCgg_canton OBJETO Cgg_canton.
	* @return void
	*/
	public void setCgg_canton(com.besixplus.sii.objects.Cgg_canton inCgg_canton){
		this.myCgg_canton = inCgg_canton;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_canton.
	* @return Cgg_canton OBJETO Cgg_canton.
	*/
	public com.besixplus.sii.objects.Cgg_canton getCgg_canton(){
		return this.myCgg_canton;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_canton().getCCTN_CODIGO());
			stmInsert.setString(3, this.getCgg_canton().getCGPRV_CODIGO());
			stmInsert.setString(4, this.getCgg_canton().getCCTN_NOMBRE());
			stmInsert.setString(5, this.getCgg_canton().getCCTN_DESCRIPCION());
			stmInsert.setString(6, this.getCgg_canton().getCCTN_ABREVIATURA());
			stmInsert.setBoolean(7, this.getCgg_canton().getCCTN_ESTADO());
			stmInsert.setString(8, this.getCgg_canton().getCCTN_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_canton().getCCTN_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_canton().setCCTN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_canton> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_canton> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_canton> outCgg_canton = new ArrayList<com.besixplus.sii.objects.Cgg_canton>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_canton tmpCgg_canton = new com.besixplus.sii.objects.Cgg_canton();
				tmpCgg_canton.setCCTN_CODIGO(results.getString(1));
				tmpCgg_canton.setCGPRV_CODIGO(results.getString(2));
				tmpCgg_canton.setCCTN_NOMBRE(results.getString(3));
				tmpCgg_canton.setCCTN_DESCRIPCION(results.getString(4));
				tmpCgg_canton.setCCTN_ABREVIATURA(results.getString(5));
				//tmpCgg_canton.setCCTN_ESTADO(results.getBoolean(6));
				outCgg_canton.add(tmpCgg_canton);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_canton;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_canton QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_canton> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_canton> selectAll1(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_canton> outCgg_canton = new ArrayList<com.besixplus.sii.objects.Cgg_canton>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_canton tmpCgg_canton = new com.besixplus.sii.objects.Cgg_canton();
				tmpCgg_canton.setCCTN_CODIGO(results.getString(1));
				tmpCgg_canton.setCGPRV_CODIGO(results.getString(2));
				tmpCgg_canton.setCCTN_NOMBRE(results.getString(3));
				tmpCgg_canton.setCCTN_DESCRIPCION(results.getString(4));
				tmpCgg_canton.setCCTN_ABREVIATURA(results.getString(5));
				tmpCgg_canton.setCCTN_ESTADO(results.getBoolean(6));
				outCgg_canton.add(tmpCgg_canton);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_canton;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_CANTON_UPDATE(?, ?, ?, ?, ?, ?,?) }");
			stmUpdate.setString(1, this.getCgg_canton().getCCTN_CODIGO());
			stmUpdate.setString(2, this.getCgg_canton().getCGPRV_CODIGO());
			stmUpdate.setString(3, this.getCgg_canton().getCCTN_NOMBRE());
			stmUpdate.setString(4, this.getCgg_canton().getCCTN_DESCRIPCION());
			stmUpdate.setString(5, this.getCgg_canton().getCCTN_ABREVIATURA());
			stmUpdate.setBoolean(6, this.getCgg_canton().getCCTN_ESTADO());
			stmUpdate.setString(7, this.getCgg_canton().getCCTN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_canton DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_canton OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_canton select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_canton().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_canton().setCCTN_CODIGO(results.getString(1));
				this.getCgg_canton().setCGPRV_CODIGO(results.getString(2));
				this.getCgg_canton().setCCTN_NOMBRE(results.getString(3));
				this.getCgg_canton().setCCTN_DESCRIPCION(results.getString(4));
				this.getCgg_canton().setCCTN_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_canton();
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_canton QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_canton> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_canton = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_SELECT(?,?,?,?,?,?) }");
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
				outCgg_canton.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_canton;
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_canton DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_CANTON_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_canton().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_CANTON_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_canton().getCCTN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_canton DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_canton OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String, Object>> selectCGG_PROVINCIA(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String, Object>> outCgg_canton = new ArrayList<HashMap<String, Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_S_CGG_PROVINCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_canton().getCGPRV_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_canton.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_canton;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_canton DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_PROVINCIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_CANTON_D_CGG_PROVINCIA(?) }");
			stmDelete.setString(1, this.getCgg_canton().getCGPRV_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_CANTON_DS_CGG_PROVINCIA(?) }");
				stmDelete.setString(1, this.getCgg_canton().getCGPRV_CODIGO());
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
	 * SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_CANTON, JUNTO CON SUS DATOS RELACIONADOS HACIA LOS NIVELES SUSPERIORES
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return ArrayList<HashMap<String,Object>> OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectUp(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_Canton = new ArrayList<HashMap<String,Object>>();
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_CANTON_SELECT_UP_BY_NAME(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_canton().getCCTN_NOMBRE());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_Canton.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_Canton;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_canton> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>>  selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<HashMap<String,Object>>  outCgg_canton = new ArrayList<HashMap<String,Object>> ();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_canton.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_canton;
	}
	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_canton DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_provincia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCgprv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROVINCIA
	* @return com.besixplus.sii.objects.Cgg_canton OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static ArrayList<HashMap<String, Object>> selectCGG_PROVINCIA(
		java.sql.Connection inConnection,
		String inCgprv_codigo
	){
		ArrayList<HashMap<String, Object>> outCgg_canton = new ArrayList<HashMap<String, Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CANTON_S_CGG_PROVINCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCgprv_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_canton.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_canton;
	}
}