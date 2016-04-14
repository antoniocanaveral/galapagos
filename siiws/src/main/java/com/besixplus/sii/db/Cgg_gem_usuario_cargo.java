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
* CLASE Cgg_gem_usuario_cargo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_usuario_cargo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_usuario_cargo implements Serializable{
	private static final long serialVersionUID = 2020738866;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_usuario_cargo.
	*/
	private com.besixplus.sii.objects.Cgg_gem_usuario_cargo myCgg_gem_usuario_cargo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_usuario_cargo.
	*/
	public Cgg_gem_usuario_cargo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_usuario_cargo.
	* @param inCgg_gem_usuario_cargo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_usuario_cargo.
	*/
	public Cgg_gem_usuario_cargo(
		com.besixplus.sii.objects.Cgg_gem_usuario_cargo inCgg_gem_usuario_cargo
	){
		this.setCgg_gem_usuario_cargo(inCgg_gem_usuario_cargo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_usuario_cargo.
	* @param inCgg_gem_usuario_cargo OBJETO Cgg_gem_usuario_cargo.
	* @return void
	*/
	public void setCgg_gem_usuario_cargo(com.besixplus.sii.objects.Cgg_gem_usuario_cargo inCgg_gem_usuario_cargo){
		this.myCgg_gem_usuario_cargo = inCgg_gem_usuario_cargo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_usuario_cargo.
	* @return Cgg_gem_usuario_cargo OBJETO Cgg_gem_usuario_cargo.
	*/
	public com.besixplus.sii.objects.Cgg_gem_usuario_cargo getCgg_gem_usuario_cargo(){
		return this.myCgg_gem_usuario_cargo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_usuario_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_INSERT(?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_usuario_cargo().getCGUCR_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_usuario_cargo().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_usuario_cargo().getCGCRG_CODIGO());
			stmInsert.setInt(5, this.getCgg_gem_usuario_cargo().getCGCRG_ESTADO_SUBSCRIPCION());
			stmInsert.setBoolean(6, this.getCgg_gem_usuario_cargo().getCGUCR_ESTADO());
			stmInsert.setString(7, this.getCgg_gem_usuario_cargo().getCGUCR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_usuario_cargo().setCGUCR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_usuario_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insertAll(
		java.sql.Connection inConnection,
		String inCusu_codigo,
		String inCgare_codigo,
		String inBusqueda,
		int inEstado,
		String Usuario
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_INSERT_ALL(?, ?, ?, ?::smallint, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, inCusu_codigo);
			stmInsert.setString(3, inCgare_codigo);
			stmInsert.setString(4, inBusqueda);
			stmInsert.setInt(5, inEstado);
			stmInsert.setBoolean(6, true);
			stmInsert.setString(7, Usuario);
			stmInsert.execute();
			this.getCgg_gem_usuario_cargo().setCGUCR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_usuario_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String, Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<HashMap<String , Object>> outCgg_gem_usuario_cargo = new ArrayList<HashMap<String, Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_SELECT_AS(?) }");
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
				outCgg_gem_usuario_cargo.add(tmpObj);
			}
			results.close();
			stmSelect.close();			
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_usuario_cargo;
	}

	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_usuario_cargo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_usuario_cargo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_usuario_cargo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_usuario_cargo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_usuario_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_usuario_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_UPDATE(?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_usuario_cargo().getCGUCR_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_usuario_cargo().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_usuario_cargo().getCGCRG_CODIGO());
			stmUpdate.setInt(4, this.getCgg_gem_usuario_cargo().getCGCRG_ESTADO_SUBSCRIPCION());
			stmUpdate.setBoolean(5, this.getCgg_gem_usuario_cargo().getCGUCR_ESTADO());
			stmUpdate.setString(6, this.getCgg_gem_usuario_cargo().getCGUCR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_usuario_cargo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_usuario_cargo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_usuario_cargo select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_usuario_cargo().getCGUCR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_usuario_cargo().setCGUCR_CODIGO(results.getString(1));
				this.getCgg_gem_usuario_cargo().setCUSU_CODIGO(results.getString(2));
				this.getCgg_gem_usuario_cargo().setCGCRG_CODIGO(results.getString(3));
				this.getCgg_gem_usuario_cargo().setCGCRG_ESTADO_SUBSCRIPCION(results.getInt(4));
				this.getCgg_gem_usuario_cargo().setCGUCR_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_usuario_cargo();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_usuario_cargo DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_usuario_cargo().getCGUCR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_usuario_cargo().getCGUCR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_usuario_cargo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_usuario_cargo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo> outCgg_gem_usuario_cargo = new ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_S_CGG_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_usuario_cargo().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_usuario_cargo tmpCgg_gem_usuario_cargo = new com.besixplus.sii.objects.Cgg_gem_usuario_cargo();
				tmpCgg_gem_usuario_cargo.setCGUCR_CODIGO(results.getString(1));
				tmpCgg_gem_usuario_cargo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_gem_usuario_cargo.setCGCRG_CODIGO(results.getString(3));
				tmpCgg_gem_usuario_cargo.setCGCRG_ESTADO_SUBSCRIPCION(results.getInt(4));
				tmpCgg_gem_usuario_cargo.setCGUCR_ESTADO(results.getBoolean(5));
				outCgg_gem_usuario_cargo.add(tmpCgg_gem_usuario_cargo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_usuario_cargo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_usuario_cargo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_D_CGG_USUARIO(?) }");
			stmDelete.setString(1, this.getCgg_gem_usuario_cargo().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_DS_CGG_USUARIO(?) }");
				stmDelete.setString(1, this.getCgg_gem_usuario_cargo().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_usuario_cargo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_usuario_cargo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo> selectCGG_GEM_CARGO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo> outCgg_gem_usuario_cargo = new ArrayList<com.besixplus.sii.objects.Cgg_gem_usuario_cargo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_USUARIO_CARGO_S_CGG_GEM_CARGO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_usuario_cargo().getCGCRG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_usuario_cargo tmpCgg_gem_usuario_cargo = new com.besixplus.sii.objects.Cgg_gem_usuario_cargo();
				tmpCgg_gem_usuario_cargo.setCGUCR_CODIGO(results.getString(1));
				tmpCgg_gem_usuario_cargo.setCUSU_CODIGO(results.getString(2));
				tmpCgg_gem_usuario_cargo.setCGCRG_CODIGO(results.getString(3));
				tmpCgg_gem_usuario_cargo.setCGCRG_ESTADO_SUBSCRIPCION(results.getInt(4));
				tmpCgg_gem_usuario_cargo.setCGUCR_ESTADO(results.getBoolean(5));
				outCgg_gem_usuario_cargo.add(tmpCgg_gem_usuario_cargo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_usuario_cargo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_usuario_cargo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_cargo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_CARGO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_D_CGG_GEM_CARGO(?) }");
			stmDelete.setString(1, this.getCgg_gem_usuario_cargo().getCGCRG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_USUARIO_CARGO_DS_CGG_GEM_CARGO(?) }");
				stmDelete.setString(1, this.getCgg_gem_usuario_cargo().getCGCRG_CODIGO());
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