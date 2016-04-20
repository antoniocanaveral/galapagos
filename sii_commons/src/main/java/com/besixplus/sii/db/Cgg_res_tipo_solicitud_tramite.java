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
* CLASE Cgg_res_tipo_solicitud_tramite
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tipo_solicitud_tramite.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_tipo_solicitud_tramite implements Serializable{
	private static final long serialVersionUID = 1548614204;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite.
	*/
	private com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite myCgg_res_tipo_solicitud_tramite = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_tramite.
	*/
	public Cgg_res_tipo_solicitud_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_tramite.
	* @param inCgg_res_tipo_solicitud_tramite OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_tipo_solicitud_tramite.
	*/
	public Cgg_res_tipo_solicitud_tramite(
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite inCgg_res_tipo_solicitud_tramite
	){
		this.setCgg_res_tipo_solicitud_tramite(inCgg_res_tipo_solicitud_tramite);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_tipo_solicitud_tramite.
	* @param inCgg_res_tipo_solicitud_tramite OBJETO Cgg_res_tipo_solicitud_tramite.
	* @return void
	*/
	public void setCgg_res_tipo_solicitud_tramite(com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite inCgg_res_tipo_solicitud_tramite){
		this.myCgg_res_tipo_solicitud_tramite = inCgg_res_tipo_solicitud_tramite;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_tipo_solicitud_tramite.
	* @return Cgg_res_tipo_solicitud_tramite OBJETO Cgg_res_tipo_solicitud_tramite.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite getCgg_res_tipo_solicitud_tramite(){
		return this.myCgg_res_tipo_solicitud_tramite;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_tipo_solicitud_tramite().getCRTST_CODIGO());
			stmInsert.setString(3, this.getCgg_res_tipo_solicitud_tramite().getCGG_CRTST_CODIGO());
			stmInsert.setString(4, this.getCgg_res_tipo_solicitud_tramite().getCRTPT_CODIGO());
			stmInsert.setString(5, this.getCgg_res_tipo_solicitud_tramite().getCRPRO_CODIGO());
			stmInsert.setString(6, this.getCgg_res_tipo_solicitud_tramite().getCRRES_CODIGO());
			stmInsert.setString(7, this.getCgg_res_tipo_solicitud_tramite().getCKESP_CODIGO());
			stmInsert.setString(8, this.getCgg_res_tipo_solicitud_tramite().getCRTST_DESCRIPCION());
			stmInsert.setString(9, this.getCgg_res_tipo_solicitud_tramite().getCRTST_OBSERVACION());
			stmInsert.setBoolean(10, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_GARANTIA());
			stmInsert.setBoolean(11, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_TRAMITE());
			stmInsert.setBoolean(12, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_GRUPO());
			stmInsert.setBoolean(13, this.getCgg_res_tipo_solicitud_tramite().getCRTST_ATENCION_CLIENTE());
			stmInsert.setBoolean(14, this.getCgg_res_tipo_solicitud_tramite().getCRTST_RESTRINGIDO());
			stmInsert.setBoolean(15, this.getCgg_res_tipo_solicitud_tramite().getCRTST_COMUNICADO_RADIAL());
			stmInsert.setInt(16, this.getCgg_res_tipo_solicitud_tramite().getCRTST_NUMERO_DIAS());
			stmInsert.setBoolean(17, this.getCgg_res_tipo_solicitud_tramite().getCRTST_VEHICULO());
			stmInsert.setBoolean(18, this.getCgg_res_tipo_solicitud_tramite().getCRTST_UNANIMIDAD());
			stmInsert.setBoolean(19, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_OTRO());
			stmInsert.setBoolean(20, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_BENEFICIARIO());
			stmInsert.setBigDecimal(21, this.getCgg_res_tipo_solicitud_tramite().getCRTST_INDICE());
			stmInsert.setBoolean(22, this.getCgg_res_tipo_solicitud_tramite().getCRTST_ESTADO());
			stmInsert.setString(23, this.getCgg_res_tipo_solicitud_tramite().getCRTST_USUARIO_INSERT());
			stmInsert.setString(24, this.getCgg_res_tipo_solicitud_tramite().getCRTST_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_tipo_solicitud_tramite().setCRTST_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> outCgg_res_tipo_solicitud_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_tramite.setCGG_CRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_tramite.setCRPRO_CODIGO(results.getString(4));
				tmpCgg_res_tipo_solicitud_tramite.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_tipo_solicitud_tramite.setCKESP_CODIGO(results.getString(6));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_DESCRIPCION(results.getString(7));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_OBSERVACION(results.getString(8));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GARANTIA(results.getBoolean(9));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_TRAMITE(results.getBoolean(10));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GRUPO(results.getBoolean(11));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_RESTRINGIDO(results.getBoolean(13));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_NUMERO_DIAS(results.getInt(15));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_VEHICULO(results.getBoolean(16));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_UNANIMIDAD(results.getBoolean(17));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_OTRO(results.getBoolean(18));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_INDICE(results.getBigDecimal(20));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ESTADO(results.getBoolean(21));
				outCgg_res_tipo_solicitud_tramite.add(tmpCgg_res_tipo_solicitud_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO ASC o DESC
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inSW VISUALIZA SOLO LAS SOLICITUDES QUE GENERAN TRAMITE
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE TIPO DE SOLICITUD DE TRAMITE.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		boolean inSW,
		String inCrtst_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_SELECT(?,?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setBoolean(8, inSW);
			stmSelect.setString(9, inCrtst_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tipo_solicitud_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inSW VISUALIZA SOLO LAS SOLICITUDES QUE GENERAN TRAMITE
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE TIPO DE SOLICITUD DE TRAMITE.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		boolean inSW,
		String inCrtst_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setBoolean(3, inSW);
			stmSelect.setString(4, inCrtst_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRTST_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_tipo_solicitud_tramite().getCGG_CRTST_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_tipo_solicitud_tramite().getCRTPT_CODIGO());
			stmUpdate.setString(4, this.getCgg_res_tipo_solicitud_tramite().getCRPRO_CODIGO());
			stmUpdate.setString(5, this.getCgg_res_tipo_solicitud_tramite().getCRRES_CODIGO());
			stmUpdate.setString(6, this.getCgg_res_tipo_solicitud_tramite().getCKESP_CODIGO());
			stmUpdate.setString(7, this.getCgg_res_tipo_solicitud_tramite().getCRTST_DESCRIPCION());
			stmUpdate.setString(8, this.getCgg_res_tipo_solicitud_tramite().getCRTST_OBSERVACION());
			stmUpdate.setBoolean(9, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_GARANTIA());
			stmUpdate.setBoolean(10, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_TRAMITE());
			stmUpdate.setBoolean(11, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_GRUPO());
			stmUpdate.setBoolean(12, this.getCgg_res_tipo_solicitud_tramite().getCRTST_ATENCION_CLIENTE());
			stmUpdate.setBoolean(13, this.getCgg_res_tipo_solicitud_tramite().getCRTST_RESTRINGIDO());
			stmUpdate.setBoolean(14, this.getCgg_res_tipo_solicitud_tramite().getCRTST_COMUNICADO_RADIAL());
			stmUpdate.setInt(15, this.getCgg_res_tipo_solicitud_tramite().getCRTST_NUMERO_DIAS());
			stmUpdate.setBoolean(16, this.getCgg_res_tipo_solicitud_tramite().getCRTST_VEHICULO());
			stmUpdate.setBoolean(17, this.getCgg_res_tipo_solicitud_tramite().getCRTST_UNANIMIDAD());
			stmUpdate.setBoolean(18, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_OTRO());
			stmUpdate.setBoolean(19, this.getCgg_res_tipo_solicitud_tramite().getCRTST_APLICA_BENEFICIARIO());
			stmUpdate.setBigDecimal(20, this.getCgg_res_tipo_solicitud_tramite().getCRTST_INDICE());
			stmUpdate.setBoolean(21, this.getCgg_res_tipo_solicitud_tramite().getCRTST_ESTADO());
			stmUpdate.setString(22, this.getCgg_res_tipo_solicitud_tramite().getCRTST_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_tramite().getCRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_CODIGO(results.getString(1));
				this.getCgg_res_tipo_solicitud_tramite().setCGG_CRTST_CODIGO(results.getString(2));
				this.getCgg_res_tipo_solicitud_tramite().setCRTPT_CODIGO(results.getString(3));
				this.getCgg_res_tipo_solicitud_tramite().setCRPRO_CODIGO(results.getString(4));
				this.getCgg_res_tipo_solicitud_tramite().setCRRES_CODIGO(results.getString(5));
				this.getCgg_res_tipo_solicitud_tramite().setCKESP_CODIGO(results.getString(6));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_DESCRIPCION(results.getString(7));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_OBSERVACION(results.getString(8));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_APLICA_GARANTIA(results.getBoolean(9));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_APLICA_TRAMITE(results.getBoolean(10));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_APLICA_GRUPO(results.getBoolean(11));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_RESTRINGIDO(results.getBoolean(13));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_NUMERO_DIAS(results.getInt(15));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_VEHICULO(results.getBoolean(16));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_UNANIMIDAD(results.getBoolean(17));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_APLICA_OTRO(results.getBoolean(18));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_INDICE(results.getBigDecimal(20));
				this.getCgg_res_tipo_solicitud_tramite().setCRTST_ESTADO(results.getBoolean(21));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_tipo_solicitud_tramite();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String delete(
		java.sql.Connection inConnection
	){
		String outResult = "true";		
		try{			
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRTST_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}		
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> selectCGG_RES_RESOLUCION(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> outCgg_res_tipo_solicitud_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_S_CGG_RES_RESOLUCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_tramite().getCRRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_tramite.setCGG_CRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_tramite.setCRPRO_CODIGO(results.getString(4));
				tmpCgg_res_tipo_solicitud_tramite.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_tipo_solicitud_tramite.setCKESP_CODIGO(results.getString(6));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_DESCRIPCION(results.getString(7));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_OBSERVACION(results.getString(8));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GARANTIA(results.getBoolean(9));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_TRAMITE(results.getBoolean(10));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GRUPO(results.getBoolean(11));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_RESTRINGIDO(results.getBoolean(13));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_NUMERO_DIAS(results.getInt(15));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_VEHICULO(results.getBoolean(16));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_UNANIMIDAD(results.getBoolean(17));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_OTRO(results.getBoolean(18));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_INDICE(results.getBigDecimal(20));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ESTADO(results.getBoolean(21));
				outCgg_res_tipo_solicitud_tramite.add(tmpCgg_res_tipo_solicitud_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_RESOLUCION(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_D_CGG_RES_RESOLUCION(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_DS_CGG_RES_RESOLUCION(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRRES_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> selectCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> outCgg_res_tipo_solicitud_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_tramite().getCGG_CRTST_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_tramite.setCGG_CRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_tramite.setCRPRO_CODIGO(results.getString(4));
				tmpCgg_res_tipo_solicitud_tramite.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_tipo_solicitud_tramite.setCKESP_CODIGO(results.getString(6));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_DESCRIPCION(results.getString(7));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_OBSERVACION(results.getString(8));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GARANTIA(results.getBoolean(9));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_TRAMITE(results.getBoolean(10));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GRUPO(results.getBoolean(11));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_RESTRINGIDO(results.getBoolean(13));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_NUMERO_DIAS(results.getInt(15));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_VEHICULO(results.getBoolean(16));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_UNANIMIDAD(results.getBoolean(17));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_OTRO(results.getBoolean(18));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_INDICE(results.getBigDecimal(20));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ESTADO(results.getBoolean(21));
				outCgg_res_tipo_solicitud_tramite.add(tmpCgg_res_tipo_solicitud_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_solicitud_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_SOLICITUD_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCGG_CRTST_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCGG_CRTST_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> selectCGG_RES_PROCESO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> outCgg_res_tipo_solicitud_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_S_CGG_RES_PROCESO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_tramite().getCRPRO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_tramite.setCGG_CRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_tramite.setCRPRO_CODIGO(results.getString(4));
				tmpCgg_res_tipo_solicitud_tramite.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_tipo_solicitud_tramite.setCKESP_CODIGO(results.getString(6));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_DESCRIPCION(results.getString(7));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_OBSERVACION(results.getString(8));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GARANTIA(results.getBoolean(9));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_TRAMITE(results.getBoolean(10));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GRUPO(results.getBoolean(11));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_RESTRINGIDO(results.getBoolean(13));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_NUMERO_DIAS(results.getInt(15));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_VEHICULO(results.getBoolean(16));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_UNANIMIDAD(results.getBoolean(17));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_OTRO(results.getBoolean(18));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_INDICE(results.getBigDecimal(20));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ESTADO(results.getBoolean(21));
				outCgg_res_tipo_solicitud_tramite.add(tmpCgg_res_tipo_solicitud_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_proceso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PROCESO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_D_CGG_RES_PROCESO(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRPRO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_DS_CGG_RES_PROCESO(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRPRO_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> selectCGG_RES_TIPO_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> outCgg_res_tipo_solicitud_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_S_CGG_RES_TIPO_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_tipo_solicitud_tramite().getCRTPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_CODIGO(results.getString(1));
				tmpCgg_res_tipo_solicitud_tramite.setCGG_CRTST_CODIGO(results.getString(2));
				tmpCgg_res_tipo_solicitud_tramite.setCRTPT_CODIGO(results.getString(3));
				tmpCgg_res_tipo_solicitud_tramite.setCRPRO_CODIGO(results.getString(4));
				tmpCgg_res_tipo_solicitud_tramite.setCRRES_CODIGO(results.getString(5));
				tmpCgg_res_tipo_solicitud_tramite.setCKESP_CODIGO(results.getString(6));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_DESCRIPCION(results.getString(7));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_OBSERVACION(results.getString(8));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GARANTIA(results.getBoolean(9));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_TRAMITE(results.getBoolean(10));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GRUPO(results.getBoolean(11));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_RESTRINGIDO(results.getBoolean(13));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_NUMERO_DIAS(results.getInt(15));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_VEHICULO(results.getBoolean(16));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_UNANIMIDAD(results.getBoolean(17));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_OTRO(results.getBoolean(18));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_INDICE(results.getBigDecimal(20));
				tmpCgg_res_tipo_solicitud_tramite.setCRTST_ESTADO(results.getBoolean(21));
				outCgg_res_tipo_solicitud_tramite.add(tmpCgg_res_tipo_solicitud_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TIPO_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_D_CGG_RES_TIPO_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRTPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_DS_CGG_RES_TIPO_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_res_tipo_solicitud_tramite().getCRTPT_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}
	
	/**Verifica si un usuario puede o no iniciar un tipo de solicitud de tramite.
	 * @param inConnection Conexion de datos.
	 * @param inCusu_codigo Codigo de usuario.
	 * @return 1-Inicia / 0 - No inicia.
	 */
	public String iniciaTipoSolicitudTramite(
			java.sql.Connection inConnection,
			String inCusu_codigo
		){			
		String outResult = "0";	
		try{			
				CallableStatement stmTipoSolicitudTramite = inConnection.prepareCall("{ ? = call SII.F_INICIA_TIPO_SOLICITUD_TRAMITE(?,?) }");
				stmTipoSolicitudTramite.registerOutParameter(1, Types.NUMERIC);
				stmTipoSolicitudTramite.setString(2, this.getCgg_res_tipo_solicitud_tramite().getCRTST_CODIGO());
				stmTipoSolicitudTramite.setString(3, inCusu_codigo);
				stmTipoSolicitudTramite.execute();
				outResult = String.valueOf( stmTipoSolicitudTramite.getBigDecimal(1));
				stmTipoSolicitudTramite.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}			
			return outResult;
		}
	
	/**
	 * Selecciona la solicitud padre de una solicitud. La selecion es recursiva sin importar en el nivel en el que se encuentre la solicitud especificado.
	 * @param inCrtst_codigo Codigo de tipo de solicitud
	 * @param inConnection Conexion de datos.
	 * @return Cgg_res_tipo_solicitud_tramite
	 */
	public com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite selectCGG_RES_TIPO_SOLICITUD_PADRE(
			String inCrtst_codigo,
			java.sql.Connection inConnection
		){
			com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite outCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_SELECT(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCrtst_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpCgg_res_tipo_solicitud_tramite = null;
				while (results.next()) {
					tmpCgg_res_tipo_solicitud_tramite = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_CODIGO(results.getString(1));
					tmpCgg_res_tipo_solicitud_tramite.setCGG_CRTST_CODIGO(results.getString(2));
					tmpCgg_res_tipo_solicitud_tramite.setCRTPT_CODIGO(results.getString(3));
					tmpCgg_res_tipo_solicitud_tramite.setCRPRO_CODIGO(results.getString(4));
					tmpCgg_res_tipo_solicitud_tramite.setCRRES_CODIGO(results.getString(5));
					tmpCgg_res_tipo_solicitud_tramite.setCKESP_CODIGO(results.getString(6));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_DESCRIPCION(results.getString(7));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_OBSERVACION(results.getString(8));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GARANTIA(results.getBoolean(9));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_TRAMITE(results.getBoolean(10));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_GRUPO(results.getBoolean(11));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_ATENCION_CLIENTE(results.getBoolean(12));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_RESTRINGIDO(results.getBoolean(13));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_COMUNICADO_RADIAL(results.getBoolean(14));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_NUMERO_DIAS(results.getInt(15));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_VEHICULO(results.getBoolean(16));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_UNANIMIDAD(results.getBoolean(17));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_OTRO(results.getBoolean(18));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_APLICA_BENEFICIARIO(results.getBoolean(19));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_INDICE(results.getBigDecimal(20));
					tmpCgg_res_tipo_solicitud_tramite.setCRTST_ESTADO(results.getBoolean(21));
				}
				if(tmpCgg_res_tipo_solicitud_tramite.getCGG_CRTST_CODIGO()!=null){
					outCgg_res_tipo_solicitud_tramite = this.selectCGG_RES_TIPO_SOLICITUD_PADRE(tmpCgg_res_tipo_solicitud_tramite.getCGG_CRTST_CODIGO(),inConnection);
				}else{
					outCgg_res_tipo_solicitud_tramite  = tmpCgg_res_tipo_solicitud_tramite;
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_res_tipo_solicitud_tramite;
		}
	
	/**
	* SELECCIONA LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectTipoPadreATC(
		java.sql.Connection inConnection,
		String inCgcnf_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_TIPO_SOLICITUD_PADRE_ATENCION_CLIENTE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCgcnf_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
				{
					if(results.getObject(i) != null)
					{
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
						
					}
				}				
				outCgg_res_tipo_solicitud_tramite.add(tmpObj);				
				
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}
	
	/**
	* SELECCIONA LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE.
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectTipoAtencionCliente(
		java.sql.Connection inConnection,
		String inCrtst_codigo,
		String inCgcnf_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_TIPO_SOLICITUD_ATENCION_CLIENTE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrtst_codigo);
			stmSelect.setString(3, inCgcnf_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_tipo_solicitud_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}
	
	/**
	* SELECCIONA LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllTipoSolicitudATC(
		java.sql.Connection inConnection,
		String inCgcnf_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
		int countMiddle = 0;
		try{
			String tmpCrtstPadre =  null;
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_TIPO_SOLICITUD_PADRE_ATENCION_CLIENTE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCgcnf_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
				{
					if(results.getObject(i) != null)
					{
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
						if(results.getMetaData().getColumnName(i).toUpperCase().equals("CRTST_CODIGO"))
							tmpCrtstPadre = results.getObject(i).toString();
					}
				}
				countMiddle = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectMiddleCountTipoSolicitudATC(inConnection,tmpCrtstPadre,inCgcnf_codigo);
				if (countMiddle>0)
				{
					tmpObj.put("TIPOSOLICITUD", com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectMiddleTipoSolicitudATC(inConnection,tmpCrtstPadre,inCgcnf_codigo));
				}
				else
				{	
					tmpObj.put("TIPOSOLICITUD", com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectTipoAtencionCliente(inConnection,tmpCrtstPadre,inCgcnf_codigo));
				}
				outCgg_res_tipo_solicitud_tramite.add(tmpObj);				
				
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO ASC o DESC
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inSW VISUALIZA SOLO LAS SOLICITUDES QUE GENERAN TRAMITE
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectPageDirectConPadre(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_TIPO_SOLICITUD_TRAMITE_CON_PADRE(?,?,?,?,?,?) }");
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
				outCgg_res_tipo_solicitud_tramite.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCountConPadre(
		java.sql.Connection inConnection,
		String inKeyword
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_RES_TIPO_SOLICITUD_TRAMITE_COUNT_CON_PADRE(?) }");
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
	* SELECCIONA LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE.
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectMiddleTipoSolicitudATC(
		java.sql.Connection inConnection,
		String inCrtst_codigo,
		String inCgcnf_codigo
		
	){
		ArrayList<HashMap<String,Object>> outCgg_res_tipo_solicitud_tramite = new ArrayList<HashMap<String,Object>>();
		try{
			String tmpCrtstPadre =  null;
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_TIPO_SOLICITUD_MIDDLE_ATENCION_CLIENTE(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrtst_codigo);
			stmSelect.setString(3, inCgcnf_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
				{
					if(results.getObject(i) != null)
					{
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
						if(results.getMetaData().getColumnName(i).toUpperCase().equals("CRTST_CODIGO"))
							tmpCrtstPadre = results.getObject(i).toString();
					}
				}
				tmpObj.put("TIPOSOLICITUDFINAL", com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectTipoAtencionCliente(inConnection,tmpCrtstPadre,inCgcnf_codigo));
				outCgg_res_tipo_solicitud_tramite.add(tmpObj);				
				
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_tipo_solicitud_tramite;
	}
	
	/**
	* SELECCIONA LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE.
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static int selectMiddleCountTipoSolicitudATC(
		java.sql.Connection inConnection,
		String inCrtst_codigo,
		String inCgcnf_codigo
		
	){
		int countMiddle =  0;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_TIPO_SOLICITUD_MIDDLE_ATENCION_CLIENTE_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrtst_codigo);
			stmSelect.setString(3, inCgcnf_codigo);
			stmSelect.execute();
			countMiddle = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return countMiddle;
	}
	
	/**
	* SELECCIONA LOS REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite EN FORMA DE ARBOL.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCgg_crtst_codigo
	* @return String
	*/
	public String selectTipoSolicitudTree(
		java.sql.Connection inConnection,
		String inCgg_crtst_codigo
	){
		String outResult = "false";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call SII.F_TIPO_SOLICITUD_PATH(?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2,inCgg_crtst_codigo);
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