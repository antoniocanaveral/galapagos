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
* CLASE Cgg_veh_categoria
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_categoria.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_categoria implements Serializable{
	private static final long serialVersionUID = 1104357761;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_categoria.
	*/
	private com.besixplus.sii.objects.Cgg_veh_categoria myCgg_veh_categoria = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_categoria.
	*/
	public Cgg_veh_categoria(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_categoria.
	* @param inCgg_veh_categoria OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_categoria.
	*/
	public Cgg_veh_categoria(
		com.besixplus.sii.objects.Cgg_veh_categoria inCgg_veh_categoria
	){
		this.setCgg_veh_categoria(inCgg_veh_categoria);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_categoria.
	* @param inCgg_veh_categoria OBJETO Cgg_veh_categoria.
	* @return void
	*/
	public void setCgg_veh_categoria(com.besixplus.sii.objects.Cgg_veh_categoria inCgg_veh_categoria){
		this.myCgg_veh_categoria = inCgg_veh_categoria;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_categoria.
	* @return Cgg_veh_categoria OBJETO Cgg_veh_categoria.
	*/
	public com.besixplus.sii.objects.Cgg_veh_categoria getCgg_veh_categoria(){
		return this.myCgg_veh_categoria;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_categoria().getCVCTG_CODIGO());
			stmInsert.setString(3, this.getCgg_veh_categoria().getCGG_CVCTG_CODIGO());
			stmInsert.setString(4, this.getCgg_veh_categoria().getCVCTG_NOMBRE());
			stmInsert.setString(5, this.getCgg_veh_categoria().getCVCTG_OBSERVACION());
			stmInsert.setBoolean(6, this.getCgg_veh_categoria().getCVCTG_ESTADO());
			stmInsert.setString(7, this.getCgg_veh_categoria().getCVCTG_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_veh_categoria().setCVCTG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> outCgg_veh_categoria = new ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_categoria tmpCgg_veh_categoria = new com.besixplus.sii.objects.Cgg_veh_categoria();
				tmpCgg_veh_categoria.setCVCTG_CODIGO(results.getString(1));
				tmpCgg_veh_categoria.setCGG_CVCTG_CODIGO(results.getString(2));
				tmpCgg_veh_categoria.setCVCTG_NOMBRE(results.getString(3));
				tmpCgg_veh_categoria.setCVCTG_OBSERVACION(results.getString(4));
				tmpCgg_veh_categoria.setCVCTG_ESTADO(results.getBoolean(5));
				outCgg_veh_categoria.add(tmpCgg_veh_categoria);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_categoria;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_categoria QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> outCgg_veh_categoria = new ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_veh_categoria tmpCgg_veh_categoria = new com.besixplus.sii.objects.Cgg_veh_categoria();
				tmpCgg_veh_categoria.setCVCTG_CODIGO(results.getString(1));
				tmpCgg_veh_categoria.setCGG_CVCTG_CODIGO(results.getString(2));
				tmpCgg_veh_categoria.setCVCTG_NOMBRE(results.getString(3));
				tmpCgg_veh_categoria.setCVCTG_OBSERVACION(results.getString(4));
				tmpCgg_veh_categoria.setCVCTG_ESTADO(results.getBoolean(5));
				outCgg_veh_categoria.add(tmpCgg_veh_categoria);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_categoria;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_categoria QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_veh_categoria = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_veh_categoria.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_categoria;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_CATEGORIA_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_categoria().getCVCTG_CODIGO());
			stmUpdate.setString(2, this.getCgg_veh_categoria().getCGG_CVCTG_CODIGO());
			stmUpdate.setString(3, this.getCgg_veh_categoria().getCVCTG_NOMBRE());
			stmUpdate.setString(4, this.getCgg_veh_categoria().getCVCTG_OBSERVACION());
			stmUpdate.setBoolean(5, this.getCgg_veh_categoria().getCVCTG_ESTADO());
			stmUpdate.setString(6, this.getCgg_veh_categoria().getCVCTG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_categoria DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_categoria OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_veh_categoria select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_categoria().getCVCTG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_veh_categoria().setCVCTG_CODIGO(results.getString(1));
				this.getCgg_veh_categoria().setCGG_CVCTG_CODIGO(results.getString(2));
				this.getCgg_veh_categoria().setCVCTG_NOMBRE(results.getString(3));
				this.getCgg_veh_categoria().setCVCTG_OBSERVACION(results.getString(4));
				this.getCgg_veh_categoria().setCVCTG_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_veh_categoria();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_categoria DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_CATEGORIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_categoria().getCVCTG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_CATEGORIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_categoria().getCVCTG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_categoria DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_categoria OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> selectCGG_VEH_CATEGORIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria> outCgg_veh_categoria = new ArrayList<com.besixplus.sii.objects.Cgg_veh_categoria>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_CATEGORIA_S_CGG_VEH_CATEGORIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_categoria().getCGG_CVCTG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_categoria tmpCgg_veh_categoria = new com.besixplus.sii.objects.Cgg_veh_categoria();
				tmpCgg_veh_categoria.setCVCTG_CODIGO(results.getString(1));
				tmpCgg_veh_categoria.setCGG_CVCTG_CODIGO(results.getString(2));
				tmpCgg_veh_categoria.setCVCTG_NOMBRE(results.getString(3));
				tmpCgg_veh_categoria.setCVCTG_OBSERVACION(results.getString(4));
				tmpCgg_veh_categoria.setCVCTG_ESTADO(results.getBoolean(5));
				outCgg_veh_categoria.add(tmpCgg_veh_categoria);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_categoria;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_categoria DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_CATEGORIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_CATEGORIA_D_CGG_VEH_CATEGORIA(?) }");
			stmDelete.setString(1, this.getCgg_veh_categoria().getCGG_CVCTG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_CATEGORIA_DS_CGG_VEH_CATEGORIA(?) }");
				stmDelete.setString(1, this.getCgg_veh_categoria().getCGG_CVCTG_CODIGO());
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
	* SELECCIONA LOS REGISTRO EN LA TABLA Cgg_veh_categoria EN FORMA DE ARBOL.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgg_cvctg_codigo
	* @return String
	*/
	public String selectCategoriaTree(
		java.sql.Connection inConnection,
		String inCgg_cvctg_codigo
	){
		String outResult = "false";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call SII.F_CGG_VEH_CATEGORIA_PATH(?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2,inCgg_cvctg_codigo);
			stmInsert.execute();
			outResult = stmInsert.getString(1);
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			//outResult = e.getMessage();
			return outResult;
		}
		return '['+outResult+']';
	}
	
}