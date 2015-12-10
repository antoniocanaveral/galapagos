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
* CLASE Cgg_tct_grupo_actividad
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_grupo_actividad.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_grupo_actividad implements Serializable{
	private static final long serialVersionUID = 495897448;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_grupo_actividad.
	*/
	private com.besixplus.sii.objects.Cgg_tct_grupo_actividad myCgg_tct_grupo_actividad = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_actividad.
	*/
	public Cgg_tct_grupo_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_actividad.
	* @param inCgg_tct_grupo_actividad OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_grupo_actividad.
	*/
	public Cgg_tct_grupo_actividad(
		com.besixplus.sii.objects.Cgg_tct_grupo_actividad inCgg_tct_grupo_actividad
	){
		this.setCgg_tct_grupo_actividad(inCgg_tct_grupo_actividad);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_grupo_actividad.
	* @param inCgg_tct_grupo_actividad OBJETO Cgg_tct_grupo_actividad.
	* @return void
	*/
	public void setCgg_tct_grupo_actividad(com.besixplus.sii.objects.Cgg_tct_grupo_actividad inCgg_tct_grupo_actividad){
		this.myCgg_tct_grupo_actividad = inCgg_tct_grupo_actividad;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_grupo_actividad.
	* @return Cgg_tct_grupo_actividad OBJETO Cgg_tct_grupo_actividad.
	*/
	public com.besixplus.sii.objects.Cgg_tct_grupo_actividad getCgg_tct_grupo_actividad(){
		return this.myCgg_tct_grupo_actividad;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_grupo_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_grupo_actividad().getCTGAC_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_grupo_actividad().getCTACT_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_tct_grupo_actividad().getCTGAC_ESTADO());
			stmInsert.setString(6, this.getCgg_tct_grupo_actividad().getCTGAC_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_tct_grupo_actividad().getCTGAC_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_grupo_actividad().setCTGAC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_grupo_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> outCgg_tct_grupo_actividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_actividad tmpCgg_tct_grupo_actividad = new com.besixplus.sii.objects.Cgg_tct_grupo_actividad();
				tmpCgg_tct_grupo_actividad.setCTGAC_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_actividad.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_actividad.setCTACT_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_actividad.setCTGAC_ESTADO(results.getBoolean(4));
				outCgg_tct_grupo_actividad.add(tmpCgg_tct_grupo_actividad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_actividad;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_grupo_actividad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> outCgg_tct_grupo_actividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_grupo_actividad tmpCgg_tct_grupo_actividad = new com.besixplus.sii.objects.Cgg_tct_grupo_actividad();
				tmpCgg_tct_grupo_actividad.setCTGAC_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_actividad.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_actividad.setCTACT_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_actividad.setCTGAC_ESTADO(results.getBoolean(4));
				outCgg_tct_grupo_actividad.add(tmpCgg_tct_grupo_actividad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_actividad;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_grupo_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_grupo_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_grupo_actividad().getCTGAC_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_grupo_actividad().getCTACT_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_tct_grupo_actividad().getCTGAC_ESTADO());
			stmUpdate.setString(5, this.getCgg_tct_grupo_actividad().getCTGAC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_actividad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_grupo_actividad select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_actividad().getCTGAC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_grupo_actividad().setCTGAC_CODIGO(results.getString(1));
				this.getCgg_tct_grupo_actividad().setCTGTR_CODIGO(results.getString(2));
				this.getCgg_tct_grupo_actividad().setCTACT_CODIGO(results.getString(3));
				this.getCgg_tct_grupo_actividad().setCTGAC_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_grupo_actividad();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_actividad().getCTGAC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_actividad().getCTGAC_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_actividad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> selectCGG_TCT_GRUPO_TURISTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> outCgg_tct_grupo_actividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_S_CGG_TCT_GRUPO_TURISTA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_actividad().getCTACT_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_actividad tmpCgg_tct_grupo_actividad = new com.besixplus.sii.objects.Cgg_tct_grupo_actividad();
				tmpCgg_tct_grupo_actividad.setCTGAC_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_actividad.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_actividad.setCTACT_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_actividad.setCTGAC_ESTADO(results.getBoolean(4));
				outCgg_tct_grupo_actividad.add(tmpCgg_tct_grupo_actividad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_actividad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public String deleteCGG_TCT_GRUPO_TURISTA(
		java.sql.Connection inConnection
	){
		String outResult = "true";	
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_D_CGG_TCT_GRUPO_TURISTA(?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_actividad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> selectCGG_TCT_ACTIVIDAD(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad> outCgg_tct_grupo_actividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_actividad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_S_CGG_TCT_ACTIVIDAD(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_actividad().getCTACT_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_actividad tmpCgg_tct_grupo_actividad = new com.besixplus.sii.objects.Cgg_tct_grupo_actividad();
				tmpCgg_tct_grupo_actividad.setCTGAC_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_actividad.setCTGTR_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_actividad.setCTACT_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_actividad.setCTGAC_ESTADO(results.getBoolean(4));
				outCgg_tct_grupo_actividad.add(tmpCgg_tct_grupo_actividad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_actividad;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_ACTIVIDAD(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_D_CGG_TCT_ACTIVIDAD(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_actividad().getCTACT_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_ACTIVIDAD_DS_CGG_TCT_ACTIVIDAD(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_actividad().getCTACT_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_grupo_actividad().getCTGTR_CODIGO());
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
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_grupo_actividad DE ACUERDO A SU NUMERO DE DOCUMENTO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param in_user_name
	 * @return com.besixplus.sii.objects.Cgg_tct_grupo_actividad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
		


	public static ArrayList<HashMap<String,Object>> selectGrupoActividadoff(
		java.sql.Connection inConnection,
		String in_user_name
		
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_grupo_actividad = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_tct_grupo_actividad_offline(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2, in_user_name);
				stmSelect.execute();
			   ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_grupo_actividad.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_actividad;
	}

}