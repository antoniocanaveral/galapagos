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
* CLASE Cgg_sector_productivo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sector_productivo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sector_productivo implements Serializable{
	private static final long serialVersionUID = 1675167737;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sector_productivo.
	*/
	private com.besixplus.sii.objects.Cgg_sector_productivo myCgg_sector_productivo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sector_productivo.
	*/
	public Cgg_sector_productivo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sector_productivo.
	* @param inCgg_sector_productivo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sector_productivo.
	*/
	public Cgg_sector_productivo(
		com.besixplus.sii.objects.Cgg_sector_productivo inCgg_sector_productivo
	){
		this.setCgg_sector_productivo(inCgg_sector_productivo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sector_productivo.
	* @param inCgg_sector_productivo OBJETO Cgg_sector_productivo.
	* @return void
	*/
	public void setCgg_sector_productivo(com.besixplus.sii.objects.Cgg_sector_productivo inCgg_sector_productivo){
		this.myCgg_sector_productivo = inCgg_sector_productivo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sector_productivo.
	* @return Cgg_sector_productivo OBJETO Cgg_sector_productivo.
	*/
	public com.besixplus.sii.objects.Cgg_sector_productivo getCgg_sector_productivo(){
		return this.myCgg_sector_productivo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sector_productivo().getCSCTP_CODIGO());
			stmInsert.setString(3, this.getCgg_sector_productivo().getCGG_CSCTP_CODIGO());
			stmInsert.setString(4, this.getCgg_sector_productivo().getCSCTP_NOMBRE());
			stmInsert.setString(5, this.getCgg_sector_productivo().getCSCTP_DESCRIPCION());
			stmInsert.setBoolean(6, this.getCgg_sector_productivo().getCSCTP_ESTADO());
			stmInsert.setString(7, this.getCgg_sector_productivo().getCSCTP_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_sector_productivo().getCSCTP_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_sector_productivo().setCSCTP_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> outCgg_sector_productivo = new ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sector_productivo tmpCgg_sector_productivo = new com.besixplus.sii.objects.Cgg_sector_productivo();
				tmpCgg_sector_productivo.setCSCTP_CODIGO(results.getString(1));
				tmpCgg_sector_productivo.setCGG_CSCTP_CODIGO(results.getString(2));
				tmpCgg_sector_productivo.setCSCTP_NOMBRE(results.getString(3));
				tmpCgg_sector_productivo.setCSCTP_DESCRIPCION(results.getString(4));
				tmpCgg_sector_productivo.setCSCTP_ESTADO(results.getBoolean(5));
				outCgg_sector_productivo.add(tmpCgg_sector_productivo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sector_productivo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sector_productivo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> outCgg_sector_productivo = new ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_sector_productivo tmpCgg_sector_productivo = new com.besixplus.sii.objects.Cgg_sector_productivo();
				tmpCgg_sector_productivo.setCSCTP_CODIGO(results.getString(1));
				tmpCgg_sector_productivo.setCGG_CSCTP_CODIGO(results.getString(2));
				tmpCgg_sector_productivo.setCSCTP_NOMBRE(results.getString(3));
				tmpCgg_sector_productivo.setCSCTP_DESCRIPCION(results.getString(4));
				tmpCgg_sector_productivo.setCSCTP_ESTADO(results.getBoolean(5));
				outCgg_sector_productivo.add(tmpCgg_sector_productivo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sector_productivo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sector_productivo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_sector_productivo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_sector_productivo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sector_productivo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_SECTOR_PRODUCTIVO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_sector_productivo().getCSCTP_CODIGO());
			stmUpdate.setString(2, this.getCgg_sector_productivo().getCGG_CSCTP_CODIGO());
			stmUpdate.setString(3, this.getCgg_sector_productivo().getCSCTP_NOMBRE());
			stmUpdate.setString(4, this.getCgg_sector_productivo().getCSCTP_DESCRIPCION());
			stmUpdate.setBoolean(5, this.getCgg_sector_productivo().getCSCTP_ESTADO());
			stmUpdate.setString(6, this.getCgg_sector_productivo().getCSCTP_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_sector_productivo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sector_productivo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_sector_productivo select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sector_productivo().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_sector_productivo().setCSCTP_CODIGO(results.getString(1));
				this.getCgg_sector_productivo().setCGG_CSCTP_CODIGO(results.getString(2));
				this.getCgg_sector_productivo().setCSCTP_NOMBRE(results.getString(3));
				this.getCgg_sector_productivo().setCSCTP_DESCRIPCION(results.getString(4));
				this.getCgg_sector_productivo().setCSCTP_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_sector_productivo();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_sector_productivo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SECTOR_PRODUCTIVO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_sector_productivo().getCSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SECTOR_PRODUCTIVO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_sector_productivo().getCSCTP_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_sector_productivo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_sector_productivo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> selectCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> outCgg_sector_productivo = new ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_S_CGG_SECTOR_PRODUCTIVO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_sector_productivo().getCGG_CSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_sector_productivo tmpCgg_sector_productivo = new com.besixplus.sii.objects.Cgg_sector_productivo();
				tmpCgg_sector_productivo.setCSCTP_CODIGO(results.getString(1));
				tmpCgg_sector_productivo.setCGG_CSCTP_CODIGO(results.getString(2));
				tmpCgg_sector_productivo.setCSCTP_NOMBRE(results.getString(3));
				tmpCgg_sector_productivo.setCSCTP_DESCRIPCION(results.getString(4));
				tmpCgg_sector_productivo.setCSCTP_ESTADO(results.getBoolean(5));
				outCgg_sector_productivo.add(tmpCgg_sector_productivo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sector_productivo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_sector_productivo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SECTOR_PRODUCTIVO_D_CGG_SECTOR_PRODUCTIVO(?) }");
			stmDelete.setString(1, this.getCgg_sector_productivo().getCGG_CSCTP_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_SECTOR_PRODUCTIVO_DS_CGG_SECTOR_PRODUCTIVO(?) }");
				stmDelete.setString(1, this.getCgg_sector_productivo().getCGG_CSCTP_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sector_productivo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllParent(
		java.sql.Connection inConnection,
		String inUserName		
	){
		ArrayList<HashMap<String,Object>> outCgg_sector_productivo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_SECTOR_PRODUCTIVO_SELECT_PARENT(?) }");
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
				outCgg_sector_productivo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_sector_productivo;
	}
}