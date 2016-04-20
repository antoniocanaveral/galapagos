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
* CLASE Cgg_res_informe_pareja
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_informe_pareja.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_informe_pareja implements Serializable{
	private static final long serialVersionUID = 107087196;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_informe_pareja.
	*/
	private com.besixplus.sii.objects.Cgg_res_informe_pareja myCgg_res_informe_pareja = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_pareja.
	*/
	public Cgg_res_informe_pareja(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_pareja.
	* @param inCgg_res_informe_pareja OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_informe_pareja.
	*/
	public Cgg_res_informe_pareja(
		com.besixplus.sii.objects.Cgg_res_informe_pareja inCgg_res_informe_pareja
	){
		this.setCgg_res_informe_pareja(inCgg_res_informe_pareja);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_informe_pareja.
	* @param inCgg_res_informe_pareja OBJETO Cgg_res_informe_pareja.
	* @return void
	*/
	public void setCgg_res_informe_pareja(com.besixplus.sii.objects.Cgg_res_informe_pareja inCgg_res_informe_pareja){
		this.myCgg_res_informe_pareja = inCgg_res_informe_pareja;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_informe_pareja.
	* @return Cgg_res_informe_pareja OBJETO Cgg_res_informe_pareja.
	*/
	public com.besixplus.sii.objects.Cgg_res_informe_pareja getCgg_res_informe_pareja(){
		return this.myCgg_res_informe_pareja;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_informe_pareja.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_PAREJA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_res_informe_pareja().getCRINF_CODIGO());
			stmInsert.setString(3, this.getCgg_res_informe_pareja().getCROFM_CODIGO());
			stmInsert.setTimestamp(4, new java.sql.Timestamp(this.getCgg_res_informe_pareja().getCRINF_FECHA_ENTREGA().getTime()));
			stmInsert.setString(5, this.getCgg_res_informe_pareja().getCRINF_EXTRACTO());
			stmInsert.setString(6, this.getCgg_res_informe_pareja().getCRINF_NUMERO_DOCUMENTO());
			stmInsert.setString(7, this.getCgg_res_informe_pareja().getCRINF_OBSERVACION());
			stmInsert.setBoolean(8, this.getCgg_res_informe_pareja().getCRINF_ESTADO());
			stmInsert.setString(9, this.getCgg_res_informe_pareja().getCRINF_USUARIO_INSERT());
			stmInsert.setString(10, this.getCgg_res_informe_pareja().getCRINF_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_res_informe_pareja().setCRINF_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_pareja.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja> outCgg_res_informe_pareja = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_PAREJA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_pareja tmpCgg_res_informe_pareja = new com.besixplus.sii.objects.Cgg_res_informe_pareja();
				tmpCgg_res_informe_pareja.setCRINF_CODIGO(results.getString(1));
				tmpCgg_res_informe_pareja.setCROFM_CODIGO(results.getString(2));
				tmpCgg_res_informe_pareja.setCRINF_FECHA_ENTREGA(results.getTimestamp(3));
				tmpCgg_res_informe_pareja.setCRINF_EXTRACTO(results.getString(4));
				tmpCgg_res_informe_pareja.setCRINF_NUMERO_DOCUMENTO(results.getString(5));
				tmpCgg_res_informe_pareja.setCRINF_OBSERVACION(results.getString(6));
				tmpCgg_res_informe_pareja.setCRINF_ESTADO(results.getBoolean(7));
				outCgg_res_informe_pareja.add(tmpCgg_res_informe_pareja);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_pareja;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_pareja QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja> selectAll(
		java.sql.Connection inConnection,		
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja> outCgg_res_informe_pareja = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_pareja>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_PAREJA_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_pareja().getCRMTR_CODIGO());
			stmSelect.setString(3, inUserName);
			stmSelect.setInt(4, inStart);
			stmSelect.setInt(5, inLimit);
			stmSelect.setString(6, inSortFieldName);
			stmSelect.setString(7, inDirection);
			stmSelect.setString(8, inKeyword);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_informe_pareja tmpCgg_res_informe_pareja = new com.besixplus.sii.objects.Cgg_res_informe_pareja();
				tmpCgg_res_informe_pareja.setCRINF_CODIGO(results.getString(1));
				tmpCgg_res_informe_pareja.setCODIGO_ADJUNTO(results.getString(2));
				tmpCgg_res_informe_pareja.setADJUNTO(results.getString(3));
				tmpCgg_res_informe_pareja.setCROFM_CODIGO(results.getString(4));
				tmpCgg_res_informe_pareja.setCRINF_FECHA_ENTREGA(results.getTimestamp(5));
				tmpCgg_res_informe_pareja.setCRINF_EXTRACTO(results.getString(6));
				tmpCgg_res_informe_pareja.setCRINF_NUMERO_DOCUMENTO(results.getString(7));
				tmpCgg_res_informe_pareja.setCRINF_OBSERVACION(results.getString(8));				
				tmpCgg_res_informe_pareja.setCRINF_ESTADO(results.getBoolean(9));
				outCgg_res_informe_pareja.add(tmpCgg_res_informe_pareja);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_pareja;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_informe_pareja.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inCrmtr_codigo
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_PAREJA_COUNT(?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrmtr_codigo);
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
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inCrmtr_codigo,
		String inKeyword
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			return selectCount(inConnection,inCrmtr_codigo);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_PAREJA_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inCrmtr_codigo);
			stmSelect.setString(3, inKeyword);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_informe_pareja.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_PAREJA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_informe_pareja().getCRINF_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_informe_pareja().getCROFM_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_res_informe_pareja().getCRINF_FECHA_ENTREGA().getTime()));
			stmUpdate.setString(4, this.getCgg_res_informe_pareja().getCRINF_EXTRACTO());
			stmUpdate.setString(5, this.getCgg_res_informe_pareja().getCRINF_NUMERO_DOCUMENTO());
			stmUpdate.setString(6, this.getCgg_res_informe_pareja().getCRINF_OBSERVACION());
			stmUpdate.setBoolean(7, this.getCgg_res_informe_pareja().getCRINF_ESTADO());
			stmUpdate.setString(8, this.getCgg_res_informe_pareja().getCRINF_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_informe_pareja DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_pareja OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_informe_pareja select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_INFORME_PAREJA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_pareja().getCRINF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_informe_pareja().setCRINF_CODIGO(results.getString(1));
				this.getCgg_res_informe_pareja().setCROFM_CODIGO(results.getString(2));
				this.getCgg_res_informe_pareja().setCRINF_FECHA_ENTREGA(results.getTimestamp(3));
				this.getCgg_res_informe_pareja().setCRINF_EXTRACTO(results.getString(4));
				this.getCgg_res_informe_pareja().setCRINF_NUMERO_DOCUMENTO(results.getString(5));
				this.getCgg_res_informe_pareja().setCRINF_OBSERVACION(results.getString(6));
				this.getCgg_res_informe_pareja().setCRINF_ESTADO(results.getBoolean(7));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_informe_pareja();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_res_informe_pareja DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_PAREJA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_pareja().getCRINF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_PAREJA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_pareja().getCRINF_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_informe_pareja DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_oficial_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_pareja OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<HashMap<String,Object>> selectCGG_RES_OFI_MATRIMONIO(
		java.sql.Connection inConnection
	){
		ArrayList<HashMap<String,Object>> outCgg_res_informe_pareja = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_RES_INFORME_PAREJA_S_CGG_RES_MATRIMONIO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_informe_pareja().getCRMTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_informe_pareja.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_informe_pareja;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_informe_pareja DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_oficial_matrimonio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_OFICIAL_MATRIMONIO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_PAREJA_D_CGG_RES_OFICIAL_MATRIMONIO(?) }");
			stmDelete.setString(1, this.getCgg_res_informe_pareja().getCROFM_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_INFORME_PAREJA_DS_CGG_RES_OFICIAL_MATRIMONIO(?) }");
				stmDelete.setString(1, this.getCgg_res_informe_pareja().getCROFM_CODIGO());
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
	* GENERA EL NUMERO DE DOCUMENTO DE LA TABLA Cgg_res_informe_pareja
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_res_informe_testigo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public static String geneNumDoc(
		java.sql.Connection inConnection
	){
		String valorRetorno=null;
		try{
			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_INFORME_PAREJA() }");
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
	/* SELECCIONA EL OFICIAL ASIGNADO AL MATRIMONIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO.
	 * @return String 
	 */


	public static String selectOficialMatrimonio(
			java.sql.Connection inConnection,
			String inCrmtr_codigo
	){
		String valorOficial = null;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_OFICIAL_MATRIMONIO_INFORME(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setString(2,inCrmtr_codigo);
			stmSelect.execute();
			valorOficial=stmSelect.getString(1);			
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorOficial;
	}
}