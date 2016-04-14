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
* CLASE Cgg_dhu_pregunta_respuesta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_pregunta_respuesta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_pregunta_respuesta implements Serializable{
	private static final long serialVersionUID = 1786959792;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta myCgg_dhu_pregunta_respuesta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta_respuesta.
	*/
	public Cgg_dhu_pregunta_respuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta_respuesta.
	* @param inCgg_dhu_pregunta_respuesta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_pregunta_respuesta.
	*/
	public Cgg_dhu_pregunta_respuesta(
		com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta inCgg_dhu_pregunta_respuesta
	){
		this.setCgg_dhu_pregunta_respuesta(inCgg_dhu_pregunta_respuesta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_pregunta_respuesta.
	* @param inCgg_dhu_pregunta_respuesta OBJETO Cgg_dhu_pregunta_respuesta.
	* @return void
	*/
	public void setCgg_dhu_pregunta_respuesta(com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta inCgg_dhu_pregunta_respuesta){
		this.myCgg_dhu_pregunta_respuesta = inCgg_dhu_pregunta_respuesta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_pregunta_respuesta.
	* @return Cgg_dhu_pregunta_respuesta OBJETO Cgg_dhu_pregunta_respuesta.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta getCgg_dhu_pregunta_respuesta(){
		return this.myCgg_dhu_pregunta_respuesta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_INSERT(?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_pregunta_respuesta().getCDPRS_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
			stmInsert.setInt(5, this.getCgg_dhu_pregunta_respuesta().getCDPRS_VALORACION()==0?0:this.getCgg_dhu_pregunta_respuesta().getCDPRS_VALORACION());			
			stmInsert.setBoolean(6, this.getCgg_dhu_pregunta_respuesta().getCDPRS_ESTADO());
			stmInsert.setString(7, this.getCgg_dhu_pregunta_respuesta().getCDPRS_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_dhu_pregunta_respuesta().getCDPRS_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_pregunta_respuesta().setCDPRS_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> outCgg_dhu_pregunta_respuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta tmpCgg_dhu_pregunta_respuesta = new com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta();
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta_respuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta_respuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_VALORACION(results.getInt(4));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_ESTADO(results.getBoolean(5));
				outCgg_dhu_pregunta_respuesta.add(tmpCgg_dhu_pregunta_respuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_dhu_pregunta_respuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_pregunta_respuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> outCgg_dhu_pregunta_respuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta tmpCgg_dhu_pregunta_respuesta = new com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta();
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta_respuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta_respuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_VALORACION(results.getInt(4));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_ESTADO(results.getBoolean(5));
				outCgg_dhu_pregunta_respuesta.add(tmpCgg_dhu_pregunta_respuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_pregunta_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_COUNT() }");
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
			inKeyword = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_UPDATE(?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRS_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
			stmUpdate.setInt(4, this.getCgg_dhu_pregunta_respuesta().getCDPRS_VALORACION());
			stmUpdate.setBoolean(5, this.getCgg_dhu_pregunta_respuesta().getCDPRS_ESTADO());
			stmUpdate.setString(6, this.getCgg_dhu_pregunta_respuesta().getCDPRS_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_pregunta_respuesta().getCDPRS_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_pregunta_respuesta().setCDPRS_CODIGO(results.getString(1));
				this.getCgg_dhu_pregunta_respuesta().setCDPRG_CODIGO(results.getString(2));
				this.getCgg_dhu_pregunta_respuesta().setCDRES_CODIGO(results.getString(3));
				this.getCgg_dhu_pregunta_respuesta().setCDPRS_VALORACION(results.getInt(4));
				this.getCgg_dhu_pregunta_respuesta().setCDPRS_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_pregunta_respuesta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		//boolean tmpAutoCommit = false;
		//Savepoint tmpSP = null;
		try{
			/*tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);*/
			//tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRS_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		/*if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRS_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}*/
		return outResult;
	}
	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcate_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteAllByCategoria(
		java.sql.Connection inConnection,
		String inCdcate_codigo
	){
		boolean outResult = true;		
		try{
			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_DELETE_ALL_BYCATEGORIA(?) }");
			stmDelete.setString(1, inCdcate_codigo);
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> selectCGG_DHU_RESPUESTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> outCgg_dhu_pregunta_respuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_S_CGG_DHU_RESPUESTA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta tmpCgg_dhu_pregunta_respuesta = new com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta();
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta_respuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta_respuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_VALORACION(results.getInt(4));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_ESTADO(results.getBoolean(5));
				outCgg_dhu_pregunta_respuesta.add(tmpCgg_dhu_pregunta_respuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_RESPUESTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_D_CGG_DHU_RESPUESTA(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_DS_CGG_DHU_RESPUESTA(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> selectCGG_DHU_PREGUNTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta> outCgg_dhu_pregunta_respuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_S_CGG_DHU_PREGUNTA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta tmpCgg_dhu_pregunta_respuesta = new com.besixplus.sii.objects.Cgg_dhu_pregunta_respuesta();
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_CODIGO(results.getString(1));
				tmpCgg_dhu_pregunta_respuesta.setCDPRG_CODIGO(results.getString(2));
				tmpCgg_dhu_pregunta_respuesta.setCDRES_CODIGO(results.getString(3));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_VALORACION(results.getInt(4));
				tmpCgg_dhu_pregunta_respuesta.setCDPRS_ESTADO(results.getBoolean(5));
				outCgg_dhu_pregunta_respuesta.add(tmpCgg_dhu_pregunta_respuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_PREGUNTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_D_CGG_DHU_PREGUNTA(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_DS_CGG_DHU_PREGUNTA(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_pregunta_respuesta().getCDRES_CODIGO());
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCdcat_codigo CODIGO DE LA TABLA CGG_DHU_CATEGORIA 	
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPregunta_PreguntaRespuesta(
		java.sql.Connection inConnection,		
		String inCdcat_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_pregunta_respuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_CATEGORIA_PREGUNTA_PREGUNTA_RESPUESTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdcat_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_pregunta_respuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.	
	* @param inCdprg_codigo CODIGO DE LA TABLA CGG_DHU_PREGUNTA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectRespuesta_PreguntaRespuesta(
		java.sql.Connection inConnection,		
		String inCdprg_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_pregunta_respuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_PREGUNTA_RESPUESTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdprg_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_pregunta_respuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}
	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta_respuesta DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_pregunta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deletePREGUNTA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;		
		try{
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_D_CGG_DHU_PREGUNTA(?) }");
			stmDelete.setString(1, this.getCgg_dhu_pregunta_respuesta().getCDPRG_CODIGO());			
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		
		return outResult;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPreguntaRespuestaGeneral(
		java.sql.Connection inConnection,
		String inCdcat_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_pregunta_respuesta = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_PREGUNTA_RESPUESTA_SELECT_BY_CATEGORIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCdcat_codigo);
			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_dhu_pregunta_respuesta.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_pregunta_respuesta;
	}
}