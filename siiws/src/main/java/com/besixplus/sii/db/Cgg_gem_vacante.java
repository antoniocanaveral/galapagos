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
* CLASE Cgg_gem_vacante
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_vacante.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_vacante implements Serializable{
	private static final long serialVersionUID = 1787279567;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_vacante.
	*/
	private com.besixplus.sii.objects.Cgg_gem_vacante myCgg_gem_vacante = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante.
	*/
	public Cgg_gem_vacante(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante.
	* @param inCgg_gem_vacante OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_vacante.
	*/
	public Cgg_gem_vacante(
		com.besixplus.sii.objects.Cgg_gem_vacante inCgg_gem_vacante
	){
		this.setCgg_gem_vacante(inCgg_gem_vacante);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_vacante.
	* @param inCgg_gem_vacante OBJETO Cgg_gem_vacante.
	* @return void
	*/
	public void setCgg_gem_vacante(com.besixplus.sii.objects.Cgg_gem_vacante inCgg_gem_vacante){
		this.myCgg_gem_vacante = inCgg_gem_vacante;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_vacante.
	* @return Cgg_gem_vacante OBJETO Cgg_gem_vacante.
	*/
	public com.besixplus.sii.objects.Cgg_gem_vacante getCgg_gem_vacante(){
		return this.myCgg_gem_vacante;
	}

		
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insertUsers(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_INSERT_USERS( ?,?, ?, ?, ?, ?, ?, ?,  ?::smallint,?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?,?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_vacante().getCGVCN_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_vacante().getCUSU_CODIGO());			
			stmInsert.setString(4, this.getCgg_gem_vacante().getCSCTP_CODIGO());
			stmInsert.setString(5, this.getCgg_gem_vacante().getCGTCN_CODIGO());
			stmInsert.setString(6, this.getCgg_gem_vacante().getCGTSA_CODIGO());
			stmInsert.setString(7, this.getCgg_gem_vacante().getCGCRG_CODIGO());
			stmInsert.setString(8, this.getCgg_gem_vacante().getCGTPR_CODIGO());
			stmInsert.setString(9, this.getCgg_gem_vacante().getCGVCN_TITULO());
			stmInsert.setInt(10, this.getCgg_gem_vacante().getCGVCN_ESTADO_OFERTA());
			stmInsert.setString(11, this.getCgg_gem_vacante().getCGVCN_DESCRIPCION());
			stmInsert.setBigDecimal(12, this.getCgg_gem_vacante().getCGVCN_SALARIO());
			stmInsert.setString(13, this.getCgg_gem_vacante().getCGVCN_DIRECCION());
			stmInsert.setTimestamp(14, new java.sql.Timestamp(this.getCgg_gem_vacante().getCGVCN_FECHA_INGRESO().getTime()));
			stmInsert.setInt(15, this.getCgg_gem_vacante().getCGVCN_NUMERO_VACANTES());
			stmInsert.setInt(16, this.getCgg_gem_vacante().getCGVCN_DURACION());
			stmInsert.setBigDecimal(17, this.getCgg_gem_vacante().getCGVCN_DURACION_TIEMPO());
			stmInsert.setString(18, this.getCgg_gem_vacante().getCGVCN_EXPERIENCIA());
			stmInsert.setBoolean(19, this.getCgg_gem_vacante().getCGVCN_ESTADO());
			stmInsert.setString(20, this.getCgg_gem_vacante().getCGVCN_USUARIO_INSERT());
			stmInsert.setString(21, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_vacante().setCGVCN_CODIGO(stmInsert.getString(1));
			outResult=stmInsert.getString(1);
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_vacante QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inRol ROL DEL USUARIO
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inRol
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_vacante = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_SELECT_ROL(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inRol);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_vacante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante;
	}	

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DE USUARIO.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inRol NOMBRE DEL ROL.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inUserName,
		String inKeyword,
		String inRol
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword ="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_COUNT_ROL(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inKeyword);
			stmSelect.setString(4, inRol);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String updateUsers(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{call sii.F_CGG_GEM_VACANTE_UPDATE_USERS(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?,?::smallint) }");
			stmUpdate.setString(1, this.getCgg_gem_vacante().getCGVCN_CODIGO());			
			stmUpdate.setString(2, this.getCgg_gem_vacante().getCSCTP_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_vacante().getCGTCN_CODIGO());
			stmUpdate.setString(4, this.getCgg_gem_vacante().getCGTSA_CODIGO());
			stmUpdate.setString(5, this.getCgg_gem_vacante().getCGCRG_CODIGO());
			stmUpdate.setString(6, this.getCgg_gem_vacante().getCGTPR_CODIGO());
			stmUpdate.setString(7, this.getCgg_gem_vacante().getCGVCN_TITULO());					
			stmUpdate.setString(8, this.getCgg_gem_vacante().getCGVCN_DESCRIPCION());
			stmUpdate.setBigDecimal(9, this.getCgg_gem_vacante().getCGVCN_SALARIO());
			stmUpdate.setString(10, this.getCgg_gem_vacante().getCGVCN_DIRECCION());			
			stmUpdate.setInt(11, this.getCgg_gem_vacante().getCGVCN_NUMERO_VACANTES());
			stmUpdate.setInt(12, this.getCgg_gem_vacante().getCGVCN_DURACION());
			stmUpdate.setBigDecimal(13, this.getCgg_gem_vacante().getCGVCN_DURACION_TIEMPO());
			stmUpdate.setString(14, this.getCgg_gem_vacante().getCGVCN_EXPERIENCIA());
			stmUpdate.setBoolean(15, this.getCgg_gem_vacante().getCGVCN_ESTADO());
			stmUpdate.setString(16, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmUpdate.setInt(17, this.getCgg_gem_vacante().getCGVCN_ESTADO_OFERTA());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_vacante DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE.
	* @return com.besixplus.sii.objects.Cgg_gem_vacante OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public HashMap<String,Object> select(
		java.sql.Connection inConnection,
		String inCgvcn_codigo
	){		
		HashMap<String,Object> tmpObj = new HashMap<String,Object>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCgvcn_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {				
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));				
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return tmpObj;			
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_vacante DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_vacante().getCGVCN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_VACANTE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_vacante().getCGVCN_CODIGO());
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
	/* APRUEBA UNA OFERTA, GENERA EL COMUNICADO RADIAL Y PUBLICA LA OFERTA EN LA WEB.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String NUMERO DE COMUNICADO RADIAL.
	*/
	public String aprobarOfertaVacante(
		java.sql.Connection inConnection
	){
		String outResult ="true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_APROBAR(?, ?, ?::smallint, ?, ?) }");
			stmUpdate.registerOutParameter(1, Types.VARCHAR);
			stmUpdate.setString(2, this.getCgg_gem_vacante().getCGVCN_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_gem_vacante().getCGVCN_FECHA_PUBLICACION().getTime()));
			stmUpdate.setInt(4, this.getCgg_gem_vacante().getCGVCN_DURACION_OFERTA());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_gem_vacante().getCGVCN_FECHA_EXPIRACION().getTime()));
			stmUpdate.setString(6, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			outResult= stmUpdate.getString(1);			
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult=e.getMessage();
		}
		return outResult;
	}
	
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_vacante.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param user NOMBRE DE USUARIO.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String getRolUsuario(
		java.sql.Connection inConnection,
		String user
	){
		String outResult ="";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_GET_ROL_USUARIO(?) }");
			stmUpdate.registerOutParameter(1, Types.VARCHAR);
			stmUpdate.setString(2, user);
			stmUpdate.execute();
			outResult= stmUpdate.getString(1);			
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult=e.getMessage();
		}
		return outResult;
	}
	/**
	/* GENERA LA EXISTENCIA/NO EXISTENCIA DE MANO DE OBRA DE LA OFERTA. 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String generarExistenciaManoObra(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_VACANTE_UPDATE_MANOBRA(?, ?::smallint, ?, ?, ?) }");
			stmUpdate.registerOutParameter(1, Types.VARCHAR);
			stmUpdate.setString(2, this.getCgg_gem_vacante().getCGVCN_CODIGO());
			stmUpdate.setInt(3, this.getCgg_gem_vacante().getCGVCN_EXISTENCIA_MANOBRA());
			stmUpdate.setString(4, this.getCgg_gem_vacante().getCGVCN_JUSTIFICACION_NO_CONTRAT());
			stmUpdate.setBoolean(5, this.getCgg_gem_vacante().getCGVCN_ESTADO());
			stmUpdate.setString(6, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmUpdate.execute();
			outResult= stmUpdate.getString(1);
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * ACTUALIZA EL ESTADO DE LA OFERTA.
	 * @param inConnection CONEXION DE LA BASE DE DATOS.
	 * @param inCgvcn_codigo CODIGO DE LA OFERTA VACANTE.
	 * @param inCgvcn_estado_oferta ESTADO DE LA OFERTA A SER ACTUALIZADO.
	 * @return
	 */
	public String actualizarEstadoOferta(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call SII.F_CGG_GEM_VACANTE_UPDATE_ESTADO(?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_vacante().getCGVCN_CODIGO());
			stmUpdate.setInt(2, this.getCgg_gem_vacante().getCGVCN_ESTADO_OFERTA());
			stmUpdate.setString(3, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * ACTUALIZA EL ESTADO DE LA OFERTA
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inMsgRevision MENSAJE DE LA REVISION.
	 * @param inCgvcn_codigo CODIGO DE LA OFERTA VACANTE
	 * @param inCgvcn_estado_oferta ESTADO DE LA OFERTA A SER ACTUALIZADO.
	 * @return
	 */
	public String enviarParaRevision(
		java.sql.Connection inConnection,
		String inMsgRevision
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call SII.F_CGG_GEM_VACANTE_REVISION(?, ?::smallint, ?,?) }");
			stmUpdate.setString(1, this.getCgg_gem_vacante().getCGVCN_CODIGO());
			stmUpdate.setInt(2, this.getCgg_gem_vacante().getCGVCN_ESTADO_OFERTA());
			stmUpdate.setString(3, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmUpdate.setString(4, inMsgRevision);
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * SELECCIONA LA INFORMACION MAS RELEVANTE DE UN USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @param inCusu_codigo CODIGO UNICO DEL USUARIO
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> selectInformacionUsuario(
		java.sql.Connection inConnection,
		String inCusu_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_USUARIO_SELECT_INFO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCusu_codigo );
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}	
	
	/**
	/* FINALIZA EL PROCESO DE LA OFERTA VACANTE.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String finalizarProceso(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{call sii.F_CGG_GEM_VACANTE_FINALIZAR(?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_vacante().getCGVCN_CODIGO());
			stmUpdate.setInt(2, this.getCgg_gem_vacante().getCGVCN_ESTADO_OFERTA());
			stmUpdate.setString(3, this.getCgg_gem_vacante().getCGVCN_JUSTIFICACION_NO_CONTRAT());
			stmUpdate.setString(4, this.getCgg_gem_vacante().getCGVCN_USUARIO_UPDATE());
			stmUpdate.execute();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * VERIFICA SI UN COMUNICADO RADIAL ES VALIDO PARA SER UTILIZADO PARA UNA RESIDENCIA.
	 * AL SER VALIDO SIGNIFICA QUE EL COMUNICADO NO ESTA EXPIRADO, NI SE HA SELECCIONADO ALGUN PERSONAL PARA SU VACANTE O SI NO SE HA PRESENTADO PERSONAL SE RIGE POR LA FECHA DE EXPIRACION.
	 * @param inConnection CONEXION A LA BASE DE DATOS
	 * @return 0 - INVALIDO / 1 - VALIDO.
	 */
	public String verificarComunicado(
			java.sql.Connection inConnection
		){			
			String resultado = "0";
			try{
				CallableStatement stmVacante = inConnection.prepareCall("{ ?= call SII.F_VERIFICAR_COMUNICADO(?) }");
				stmVacante.registerOutParameter(1, Types.VARCHAR);
				stmVacante.setString(2, this.getCgg_gem_vacante().getCGVCN_NUMERO_COMUNICADO());
				stmVacante.execute();
				resultado = stmVacante.getString(1);
				stmVacante.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				resultado = e.getMessage();
			}
			return resultado;
		}
	
	/**
	 * SELECCIONA LA INFORMACION MAS RELEVANTE A LAS OFERTAS DE UN USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCusu_codigo CODIGO DEL USUARIO DE LA TABLA CANDIDATO
	 * @return
	 */
	public static ArrayList<HashMap<String,Object>> selectOfertasByUsuario(		
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,		
		String inCusu_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_usuario = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_OFERTAS_SELECT_BYUSUARIOS(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);			
			stmSelect.setString(8, inCusu_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_usuario.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_usuario;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inCusu_codigo CRITERIO DE BUSQUEDA. CODIGO DEL USUARIO DE LA TABLA CANDIDATO
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int countOfertasByUsuario(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCusu_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_OFERTAS_COUNT_BYUSUARIOS(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCusu_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}
	
	/**
	 * SELECCIONA INFORMACION DE USUARIOS RESPONSABLES DE UNA EMPRESA
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @param inCusu_codigo CODIGO DEL USUARIO DE LA TABLA CANDIDATO
	 * @return TOTAL DE REGISTROS 
	 */
	public int selectUsuarioEmpresaCount(
		java.sql.Connection inConnection,
		String inKeyword		
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_SELECT_USUARIO_EMPRESA_COUNT(?) }");
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
	
	/**SELECCIONA INFORMACION DE LOS USUARIOS DE UNA EMPRESA
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTROS A CONSIDERAR.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA.
	 * @return TOTAL DE REGISTROS.
	 */
	public static ArrayList<HashMap<String,Object>> selectUsuarioEmpresa(		
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword			
		){
			ArrayList<HashMap<String,Object>> outCgg_usuario_empresa = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GEM_SELECT_USUARIO_EMPRESA(?,?,?,?,?,?) }");
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
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_usuario_empresa.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_usuario_empresa;
		}
}