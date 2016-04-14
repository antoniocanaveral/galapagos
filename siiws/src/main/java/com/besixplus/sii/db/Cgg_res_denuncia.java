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
* CLASE Cgg_res_denuncia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_denuncia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_denuncia implements Serializable{
	private static final long serialVersionUID = 1403496477;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_denuncia.
	*/
	private com.besixplus.sii.objects.Cgg_res_denuncia myCgg_res_denuncia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_denuncia.
	*/
	public Cgg_res_denuncia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_denuncia.
	* @param inCgg_res_denuncia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_denuncia.
	*/
	public Cgg_res_denuncia(
		com.besixplus.sii.objects.Cgg_res_denuncia inCgg_res_denuncia
	){
		this.setCgg_res_denuncia(inCgg_res_denuncia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_denuncia.
	* @param inCgg_res_denuncia OBJETO Cgg_res_denuncia.
	* @return void
	*/
	public void setCgg_res_denuncia(com.besixplus.sii.objects.Cgg_res_denuncia inCgg_res_denuncia){
		this.myCgg_res_denuncia = inCgg_res_denuncia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_denuncia.
	* @return Cgg_res_denuncia OBJETO Cgg_res_denuncia.
	*/
	public com.besixplus.sii.objects.Cgg_res_denuncia getCgg_res_denuncia(){
		return this.myCgg_res_denuncia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_denuncia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_denuncia().getCRDEN_CODIGO());
			stmInsert.setString(3, this.getCgg_res_denuncia().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_res_denuncia().getCRDEN_ANIO());
			stmInsert.setString(5, this.getCgg_res_denuncia().getCRDEN_NUMERO());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_res_denuncia().getCRDEN_FECHA_RECEPCION().getTime()));
			stmInsert.setString(7, this.getCgg_res_denuncia().getCRDEN_NUMERO_DOC_IDENT());
			stmInsert.setString(8, this.getCgg_res_denuncia().getCRDEN_NOMBRES());
			stmInsert.setString(9, this.getCgg_res_denuncia().getCRDEN_APELLIDOS());
			stmInsert.setString(10, this.getCgg_res_denuncia().getCRDEN_DESCRIPCION());
			stmInsert.setString(11, this.getCgg_res_denuncia().getCRDEN_CONTACTO());
			stmInsert.setInt(12, this.getCgg_res_denuncia().getCRDEN_TIPO());
			stmInsert.setBoolean(13, this.getCgg_res_denuncia().getCRDEN_DENUNCIA());
			stmInsert.setString(14, this.getCgg_res_denuncia().getCRDEN_SEGUIMIENTO());
			stmInsert.setInt(15, this.getCgg_res_denuncia().getCRDEN_ESTADO_DENUNCIA());
			stmInsert.setBoolean(16, this.getCgg_res_denuncia().getCRDEN_ESTADO());
			stmInsert.setString(17, this.getCgg_res_denuncia().getCRDEN_USUARIO_INSERT());
			stmInsert.setString(18, this.getCgg_res_denuncia().getCRDEN_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_denuncia().setCRDEN_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> outCgg_res_denuncia = new ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_denuncia tmpCgg_res_denuncia = new com.besixplus.sii.objects.Cgg_res_denuncia();
				tmpCgg_res_denuncia.setCRDEN_CODIGO(results.getString(1));
				tmpCgg_res_denuncia.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_denuncia.setCRDEN_ANIO(results.getString(3));
				tmpCgg_res_denuncia.setCRDEN_NUMERO(results.getString(4));
				tmpCgg_res_denuncia.setCRDEN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_res_denuncia.setCRDEN_NUMERO_DOC_IDENT(results.getString(6));
				tmpCgg_res_denuncia.setCRDEN_NOMBRES(results.getString(7));
				tmpCgg_res_denuncia.setCRDEN_APELLIDOS(results.getString(8));
				tmpCgg_res_denuncia.setCRDEN_DESCRIPCION(results.getString(9));
				tmpCgg_res_denuncia.setCRDEN_CONTACTO(results.getString(10));
				tmpCgg_res_denuncia.setCRDEN_TIPO(results.getInt(11));
				tmpCgg_res_denuncia.setCRDEN_DENUNCIA(results.getBoolean(12));
				tmpCgg_res_denuncia.setCRDEN_SEGUIMIENTO(results.getString(13));
				tmpCgg_res_denuncia.setCRDEN_ESTADO_DENUNCIA(results.getInt(14));
				tmpCgg_res_denuncia.setCRDEN_ESTADO(results.getBoolean(15));
				outCgg_res_denuncia.add(tmpCgg_res_denuncia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_denuncia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO. 
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inTipo IDENTIFICATIVO DEL TIPO.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inTipo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> outCgg_res_denuncia = new ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inTipo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_denuncia tmpCgg_res_denuncia = new com.besixplus.sii.objects.Cgg_res_denuncia();
				tmpCgg_res_denuncia.setCRDEN_CODIGO(results.getString(1));
				tmpCgg_res_denuncia.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_denuncia.setCRDEN_ANIO(results.getString(3));
				tmpCgg_res_denuncia.setCRDEN_NUMERO(results.getString(4));
				tmpCgg_res_denuncia.setCRDEN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_res_denuncia.setCRDEN_NUMERO_DOC_IDENT(results.getString(6));
				tmpCgg_res_denuncia.setCRDEN_NOMBRES(results.getString(7));
				tmpCgg_res_denuncia.setCRDEN_APELLIDOS(results.getString(8));
				tmpCgg_res_denuncia.setCRDEN_DESCRIPCION(results.getString(9));
				tmpCgg_res_denuncia.setCRDEN_CONTACTO(results.getString(10));
				tmpCgg_res_denuncia.setCRDEN_TIPO(results.getInt(11));
				tmpCgg_res_denuncia.setCRDEN_DENUNCIA(results.getBoolean(12));
				tmpCgg_res_denuncia.setCRDEN_SEGUIMIENTO(results.getString(13));
				tmpCgg_res_denuncia.setCRDEN_ESTADO_DENUNCIA(results.getInt(14));
				tmpCgg_res_denuncia.setCRDEN_ESTADO(results.getBoolean(15));
				outCgg_res_denuncia.add(tmpCgg_res_denuncia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_denuncia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inTipo IDENTIFICATIVO PARA SABER SI LA DENUNCIA ES DE RESIDENCIA O GESTION DE EMPLEO. 
	
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inTipo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_denuncia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_SELECT_DIRECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inTipo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_denuncia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_denuncia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_denuncia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_COUNT() }");
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
	* @param inTipo IDENTIFICATIVO PARA SABER SI LA DENUNCIA ES DE RESIDENCIA O GESTION DE EMPLEO.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inTipo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword = " ";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inTipo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_denuncia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_DENUNCIA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_denuncia().getCRDEN_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_denuncia().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_denuncia().getCRDEN_ANIO());
			stmUpdate.setString(4, this.getCgg_res_denuncia().getCRDEN_NUMERO());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_res_denuncia().getCRDEN_FECHA_RECEPCION().getTime()));
			stmUpdate.setString(6, this.getCgg_res_denuncia().getCRDEN_NUMERO_DOC_IDENT());
			stmUpdate.setString(7, this.getCgg_res_denuncia().getCRDEN_NOMBRES());
			stmUpdate.setString(8, this.getCgg_res_denuncia().getCRDEN_APELLIDOS());
			stmUpdate.setString(9, this.getCgg_res_denuncia().getCRDEN_DESCRIPCION());
			stmUpdate.setString(10, this.getCgg_res_denuncia().getCRDEN_CONTACTO());
			stmUpdate.setInt(11, this.getCgg_res_denuncia().getCRDEN_TIPO());
			stmUpdate.setBoolean(12, this.getCgg_res_denuncia().getCRDEN_DENUNCIA());
			stmUpdate.setString(13, this.getCgg_res_denuncia().getCRDEN_SEGUIMIENTO());
			stmUpdate.setInt(14, this.getCgg_res_denuncia().getCRDEN_ESTADO_DENUNCIA());
			stmUpdate.setBoolean(15, this.getCgg_res_denuncia().getCRDEN_ESTADO());
			stmUpdate.setString(16, this.getCgg_res_denuncia().getCRDEN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_denuncia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_denuncia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_denuncia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_denuncia().getCRDEN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_denuncia().setCRDEN_CODIGO(results.getString(1));
				this.getCgg_res_denuncia().setCUSU_CODIGO(results.getString(2));
				this.getCgg_res_denuncia().setCRDEN_ANIO(results.getString(3));
				this.getCgg_res_denuncia().setCRDEN_NUMERO(results.getString(4));
				this.getCgg_res_denuncia().setCRDEN_FECHA_RECEPCION(results.getTimestamp(5));
				this.getCgg_res_denuncia().setCRDEN_NUMERO_DOC_IDENT(results.getString(6));
				this.getCgg_res_denuncia().setCRDEN_NOMBRES(results.getString(7));
				this.getCgg_res_denuncia().setCRDEN_APELLIDOS(results.getString(8));
				this.getCgg_res_denuncia().setCRDEN_DESCRIPCION(results.getString(9));
				this.getCgg_res_denuncia().setCRDEN_CONTACTO(results.getString(10));
				this.getCgg_res_denuncia().setCRDEN_TIPO(results.getInt(11));
				this.getCgg_res_denuncia().setCRDEN_DENUNCIA(results.getBoolean(12));
				this.getCgg_res_denuncia().setCRDEN_SEGUIMIENTO(results.getString(13));
				this.getCgg_res_denuncia().setCRDEN_ESTADO_DENUNCIA(results.getInt(14));
				this.getCgg_res_denuncia().setCRDEN_ESTADO(results.getBoolean(15));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_denuncia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_denuncia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DENUNCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_denuncia().getCRDEN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DENUNCIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_denuncia().getCRDEN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_denuncia DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_denuncia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> outCgg_res_denuncia = new ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_DENUNCIA_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_denuncia().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_denuncia tmpCgg_res_denuncia = new com.besixplus.sii.objects.Cgg_res_denuncia();
				tmpCgg_res_denuncia.setCRDEN_CODIGO(results.getString(1));
				tmpCgg_res_denuncia.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_denuncia.setCRDEN_ANIO(results.getString(3));
				tmpCgg_res_denuncia.setCRDEN_NUMERO(results.getString(4));
				tmpCgg_res_denuncia.setCRDEN_FECHA_RECEPCION(results.getTimestamp(5));
				tmpCgg_res_denuncia.setCRDEN_NUMERO_DOC_IDENT(results.getString(6));
				tmpCgg_res_denuncia.setCRDEN_NOMBRES(results.getString(7));
				tmpCgg_res_denuncia.setCRDEN_APELLIDOS(results.getString(8));
				tmpCgg_res_denuncia.setCRDEN_DESCRIPCION(results.getString(9));
				tmpCgg_res_denuncia.setCRDEN_CONTACTO(results.getString(10));
				tmpCgg_res_denuncia.setCRDEN_TIPO(results.getInt(11));
				tmpCgg_res_denuncia.setCRDEN_DENUNCIA(results.getBoolean(12));
				tmpCgg_res_denuncia.setCRDEN_SEGUIMIENTO(results.getString(13));
				tmpCgg_res_denuncia.setCRDEN_ESTADO_DENUNCIA(results.getInt(14));
				tmpCgg_res_denuncia.setCRDEN_ESTADO(results.getBoolean(15));
				outCgg_res_denuncia.add(tmpCgg_res_denuncia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_denuncia;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_denuncia DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DENUNCIA_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_res_denuncia().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_DENUNCIA_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_res_denuncia().getCUSU_CODIGO());
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
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_res_notificacion
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_notificacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static String geneNumDenuncia(
		java.sql.Connection inConnection		
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_DENUNCIA(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			
			stmSelect.execute();
			valorRetorno = stmSelect.getString(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRetorno;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_denuncia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String updateDenunciaNot(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_DENUNCIA_UPDATE_NOTI(?,?::smallint,?) }");
			stmUpdate.setString(1, this.getCgg_res_denuncia().getCRDEN_CODIGO());
			stmUpdate.setInt(2, this.getCgg_res_denuncia().getCRDEN_ESTADO_DENUNCIA());
			stmUpdate.setString(3, this.getCgg_res_denuncia().getCRDEN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult ="false";
		}
		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param incrper_codigo IDENTIFICATIVO DE LA PERSONA.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia<<> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectDenunciaEstado(
			java.sql.Connection inConnection,
			String incrper_codigo
		){
			ArrayList<HashMap<String,Object>> outCgg_res_denuncia = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_denuncia_select_estado(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, incrper_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)
						if(results.getObject(i) != null)
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_res_denuncia.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_denuncia;
		}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_persona> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPersonaDenuncia(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_denuncia_select_noti(?,?,?,?,?,?) }");
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
				outCgg_res_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_persona;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCountDenuncia(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f.cgg_res_denuncia_count_noti(?) }");
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
	

}