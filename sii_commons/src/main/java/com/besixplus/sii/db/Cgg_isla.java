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
* CLASE Cgg_isla
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_isla.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_isla implements Serializable{
	private static final long serialVersionUID = 225725095;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_isla.
	*/
	private com.besixplus.sii.objects.Cgg_isla myCgg_isla = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_isla.
	*/
	public Cgg_isla(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_isla.
	* @param inCgg_isla OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_isla.
	*/
	public Cgg_isla(
		com.besixplus.sii.objects.Cgg_isla inCgg_isla
	){
		this.setCgg_isla(inCgg_isla);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_isla.
	* @param inCgg_isla OBJETO Cgg_isla.
	* @return void
	*/
	public void setCgg_isla(com.besixplus.sii.objects.Cgg_isla inCgg_isla){
		this.myCgg_isla = inCgg_isla;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_isla.
	* @return Cgg_isla OBJETO Cgg_isla.
	*/
	public com.besixplus.sii.objects.Cgg_isla getCgg_isla(){
		return this.myCgg_isla;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_isla().getCISLA_CODIGO());
			stmInsert.setString(3, this.getCgg_isla().getCCTN_CODIGO());
			stmInsert.setString(4, this.getCgg_isla().getCISLA_NOMBRE());
			stmInsert.setString(5, this.getCgg_isla().getCISLA_ABREVIATURA());
			stmInsert.setBigDecimal(6, this.getCgg_isla().getCISLA_INDICE());
			stmInsert.setBoolean(7, this.getCgg_isla().getCISLA_ESTADO());
			stmInsert.setString(8, this.getCgg_isla().getCISLA_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_isla().getCISLA_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_isla().setCISLA_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_isla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_isla> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_isla> outCgg_isla = new ArrayList<com.besixplus.sii.objects.Cgg_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_isla tmpCgg_isla = new com.besixplus.sii.objects.Cgg_isla();
				tmpCgg_isla.setCISLA_CODIGO(results.getString(1));
				tmpCgg_isla.setCCTN_CODIGO(results.getString(2));
				tmpCgg_isla.setCISLA_NOMBRE(results.getString(3));
				tmpCgg_isla.setCISLA_ABREVIATURA(results.getString(4));
				tmpCgg_isla.setCISLA_INDICE(results.getBigDecimal(5));
				tmpCgg_isla.setCISLA_ESTADO(results.getBoolean(6));
				outCgg_isla.add(tmpCgg_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_isla;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_isla QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_isla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_isla = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_isla.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_isla;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_isla.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_ISLA_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_isla().getCISLA_CODIGO());
			stmUpdate.setString(2, this.getCgg_isla().getCCTN_CODIGO());
			stmUpdate.setString(3, this.getCgg_isla().getCISLA_NOMBRE());
			stmUpdate.setString(4, this.getCgg_isla().getCISLA_ABREVIATURA());
			stmUpdate.setBigDecimal(5, this.getCgg_isla().getCISLA_INDICE());
			stmUpdate.setBoolean(6, this.getCgg_isla().getCISLA_ESTADO());
			stmUpdate.setString(7, this.getCgg_isla().getCISLA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_isla DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_isla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_isla select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_isla().getCISLA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_isla().setCISLA_CODIGO(results.getString(1));
				this.getCgg_isla().setCCTN_CODIGO(results.getString(2));
				this.getCgg_isla().setCISLA_NOMBRE(results.getString(3));
				this.getCgg_isla().setCISLA_ABREVIATURA(results.getString(4));
				this.getCgg_isla().setCISLA_INDICE(results.getBigDecimal(5));
				this.getCgg_isla().setCISLA_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_isla();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_isla DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_ISLA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_isla().getCISLA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_ISLA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_isla().getCISLA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_isla DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_isla OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_isla> selectCGG_CANTON(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_isla> outCgg_isla = new ArrayList<com.besixplus.sii.objects.Cgg_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_S_CGG_CANTON(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_isla().getCCTN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_isla tmpCgg_isla = new com.besixplus.sii.objects.Cgg_isla();
				tmpCgg_isla.setCISLA_CODIGO(results.getString(1));
				tmpCgg_isla.setCCTN_CODIGO(results.getString(2));
				tmpCgg_isla.setCISLA_NOMBRE(results.getString(3));
				tmpCgg_isla.setCISLA_ABREVIATURA(results.getString(4));
				tmpCgg_isla.setCISLA_INDICE(results.getBigDecimal(5));
				tmpCgg_isla.setCISLA_ESTADO(results.getBoolean(6));
				outCgg_isla.add(tmpCgg_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_isla;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_isla DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_canton.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_ISLA_D_CGG_CANTON(?) }");
			stmDelete.setString(1, this.getCgg_isla().getCCTN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_ISLA_DS_CGG_CANTON(?) }");
				stmDelete.setString(1, this.getCgg_isla().getCCTN_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA SII.CGG_ISLA DESDE DONDE SE PUEDA ATENTER UN TRAMITE .
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_isla> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_isla> selectAllAtencionCliente(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_isla> outCgg_isla = new ArrayList<com.besixplus.sii.objects.Cgg_isla>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_SELECT_ATENCION_CLIENTE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_isla tmpCgg_isla = new com.besixplus.sii.objects.Cgg_isla();
				tmpCgg_isla.setCISLA_CODIGO(results.getString(1));
				tmpCgg_isla.setCCTN_CODIGO(results.getString(2));
				tmpCgg_isla.setCISLA_NOMBRE(results.getString(3));
				tmpCgg_isla.setCISLA_ABREVIATURA(results.getString(4));
				outCgg_isla.add(tmpCgg_isla);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_isla;
	}
}