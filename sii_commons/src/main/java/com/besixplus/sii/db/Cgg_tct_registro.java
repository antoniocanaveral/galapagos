package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_tct_registro
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_registro.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_registro implements Serializable{
	private static final long serialVersionUID = 2072373783;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_registro.
	*/
	private com.besixplus.sii.objects.Cgg_tct_registro myCgg_tct_registro = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro.
	*/
	public Cgg_tct_registro(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro.
	* @param inCgg_tct_registro OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_registro.
	*/
	public Cgg_tct_registro(
		com.besixplus.sii.objects.Cgg_tct_registro inCgg_tct_registro
	){
		this.setCgg_tct_registro(inCgg_tct_registro);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_registro.
	* @param inCgg_tct_registro OBJETO Cgg_tct_registro.
	* @return void
	*/
	public void setCgg_tct_registro(com.besixplus.sii.objects.Cgg_tct_registro inCgg_tct_registro){
		this.myCgg_tct_registro = inCgg_tct_registro;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_registro.
	* @return Cgg_tct_registro OBJETO Cgg_tct_registro.
	*/
	public com.besixplus.sii.objects.Cgg_tct_registro getCgg_tct_registro(){
		return this.myCgg_tct_registro;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_registro().getCTREG_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_registro().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_registro().getCTGTR_CODIGO());
			stmInsert.setString(5, this.getCgg_tct_registro().getCUSU_CODIGO());
			stmInsert.setString(6, this.getCgg_tct_registro().getCGG_CUSU_CODIGO());
			stmInsert.setString(7, this.getCgg_tct_registro().getCARPT_CODIGO());
			stmInsert.setString(8, this.getCgg_tct_registro().getCGG_CARPT_CODIGO());
			stmInsert.setString(9, this.getCgg_tct_registro().getCRALN_CODIGO());
			stmInsert.setString(10, this.getCgg_tct_registro().getCRTRA_CODIGO());
			stmInsert.setInt(11, this.getCgg_tct_registro().getCTREG_NUMERO());
			stmInsert.setTimestamp(12, this.getCgg_tct_registro().getCTREG_FECHA_PREREGISTRO()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_FECHA_PREREGISTRO().getTime()):null);
			stmInsert.setTimestamp(13, this.getCgg_tct_registro().getCTREG_FECHA_INGRESO()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_FECHA_INGRESO().getTime()):null);
			stmInsert.setString(14, this.getCgg_tct_registro().getCTREG_CODIGO_BARRAS());
			stmInsert.setTimestamp(15, this.getCgg_tct_registro().getCTREG_FECHA_SALIDA()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_FECHA_SALIDA().getTime()):null);
			stmInsert.setTimestamp(16, this.getCgg_tct_registro().getCTREG_IMPRESION_ESPECIE()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_IMPRESION_ESPECIE().getTime()):null);
			stmInsert.setInt(17, this.getCgg_tct_registro().getCTREG_ESTADO_REGISTRO());
			stmInsert.setString(18, this.getCgg_tct_registro().getCTREG_OBSERVACION());
			stmInsert.setBoolean(19, this.getCgg_tct_registro().getCTREG_ESTADO());
			stmInsert.setString(20, this.getCgg_tct_registro().getCTREG_USUARIO_INSERT());
			stmInsert.setString(21, this.getCgg_tct_registro().getCTREG_CATEGORIA());
			stmInsert.setString(22, this.getCgg_tct_registro().getCTREG_TIPO_REGISTRO());
			stmInsert.setString(23, this.getCgg_tct_registro().getCTREG_NUMERO_VUELO());
			stmInsert.setString(24, this.getCgg_tct_registro().getCTREG_TIPO_HOSPEDAJE());
			stmInsert.setString(25, this.getCgg_tct_registro().getCTREG_ISLA_HOSPEDAJE());
			stmInsert.setString(26, this.getCgg_tct_registro().getCTREG_NOMBRE_HOSPEDAJE_CRUCERO());
			stmInsert.setString(27, this.getCgg_tct_registro().getCTREG_NOMBRE_HOSPEDAJE_HOTEL());
			stmInsert.setString(28, this.getCgg_tct_registro().getCTREG_LUGAR_HOSPEDAJE());
			stmInsert.setString(29, this.getCgg_tct_registro().getCTREG_VIAJE_ACOMPANANTE());
			stmInsert.setString(30, this.getCgg_tct_registro().getCTREG_VIAJE_MOTIVO());
			stmInsert.setString(31, this.getCgg_tct_registro().getCTREG_VIAJE_ACTIVIDADES());
			stmInsert.setString(32, this.getCgg_tct_registro().getCTREG_VIAJE_NUM_MIEMBROS());
			stmInsert.setString(33, this.getCgg_tct_registro().getCTREG_VIAJE_TOUR());
			stmInsert.setString(34, this.getCgg_tct_registro().getCTREG_VIAJE_CUAL());
			
			
			stmInsert.execute();
			this.getCgg_tct_registro().setCTREG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_registro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_registro QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		boolean inOperacional
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_registro = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setBoolean(8,inOperacional);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_registro.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inUserName,
		String inKeyword,
		boolean inOperacional
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_COUNT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inKeyword);
			stmSelect.setBoolean(4, inOperacional);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_registro.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_registro().getCTREG_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_registro().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_registro().getCTGTR_CODIGO());
			stmUpdate.setString(4, this.getCgg_tct_registro().getCUSU_CODIGO());
			stmUpdate.setString(5, this.getCgg_tct_registro().getCGG_CUSU_CODIGO());
			stmUpdate.setString(6, this.getCgg_tct_registro().getCARPT_CODIGO());
			stmUpdate.setString(7, this.getCgg_tct_registro().getCGG_CARPT_CODIGO());
			stmUpdate.setString(8, this.getCgg_tct_registro().getCRALN_CODIGO());
			stmUpdate.setString(9, this.getCgg_tct_registro().getCRTRA_CODIGO());
			stmUpdate.setInt(10, this.getCgg_tct_registro().getCTREG_NUMERO());
			stmUpdate.setTimestamp(11, this.getCgg_tct_registro().getCTREG_FECHA_PREREGISTRO()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_FECHA_PREREGISTRO().getTime()):null);
			stmUpdate.setTimestamp(12, this.getCgg_tct_registro().getCTREG_FECHA_INGRESO()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_FECHA_INGRESO().getTime()):null);
			stmUpdate.setString(13, this.getCgg_tct_registro().getCTREG_CODIGO_BARRAS());
			stmUpdate.setTimestamp(14, this.getCgg_tct_registro().getCTREG_FECHA_SALIDA()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_FECHA_SALIDA().getTime()):null);
			stmUpdate.setTimestamp(15, this.getCgg_tct_registro().getCTREG_IMPRESION_ESPECIE()!=null?new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_IMPRESION_ESPECIE().getTime()):null);
			stmUpdate.setInt(16, this.getCgg_tct_registro().getCTREG_ESTADO_REGISTRO());
			stmUpdate.setString(17, this.getCgg_tct_registro().getCTREG_OBSERVACION());
			stmUpdate.setBoolean(18, this.getCgg_tct_registro().getCTREG_ESTADO());
			stmUpdate.setString(19, this.getCgg_tct_registro().getCTREG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_registro select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCTREG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_registro().setCTREG_CODIGO(results.getString(1));
				this.getCgg_tct_registro().setCRPER_CODIGO(results.getString(2));
				this.getCgg_tct_registro().setCTGTR_CODIGO(results.getString(3));
				this.getCgg_tct_registro().setCUSU_CODIGO(results.getString(4));
				this.getCgg_tct_registro().setCGG_CUSU_CODIGO(results.getString(5));
				this.getCgg_tct_registro().setCARPT_CODIGO(results.getString(6));
				this.getCgg_tct_registro().setCGG_CARPT_CODIGO(results.getString(7));
				this.getCgg_tct_registro().setCRALN_CODIGO(results.getString(8));
				this.getCgg_tct_registro().setCRTRA_CODIGO(results.getString(9));
				this.getCgg_tct_registro().setCTREG_NUMERO(results.getInt(10));
				this.getCgg_tct_registro().setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				this.getCgg_tct_registro().setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				this.getCgg_tct_registro().setCTREG_CODIGO_BARRAS(results.getString(13));
				this.getCgg_tct_registro().setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				this.getCgg_tct_registro().setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				this.getCgg_tct_registro().setCTREG_ESTADO_REGISTRO(results.getInt(16));
				this.getCgg_tct_registro().setCTREG_OBSERVACION(results.getString(17));
				this.getCgg_tct_registro().setCTREG_ESTADO(results.getBoolean(18));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_registro();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCTREG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_registro().getCTREG_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_S_CGG_RES_AEROPUERTO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCARPT_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_registro().getCGG_CARPT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aeropuerto.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_AEROPUERTO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_D_CGG_RES_AEROPUERTO(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCARPT_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_registro().getCGG_CARPT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DS_CGG_RES_AEROPUERTO(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_registro().getCARPT_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_registro().getCGG_CARPT_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_S_CGG_RES_TRAMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCRTRA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_TRAMITE(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_D_CGG_RES_TRAMITE(?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCRTRA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DS_CGG_RES_TRAMITE(?) }");
				stmDelete.setString(1, this.getCgg_tct_registro().getCRTRA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectCGG_TCT_GRUPO_TURISTA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_S_CGG_TCT_GRUPO_TURISTA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCTGTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public String deleteCGG_TCT_GRUPO_TURISTA(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_D_CGG_TCT_GRUPO_TURISTA(?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCTGTR_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCGG_CUSU_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_registro().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCGG_CUSU_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_registro().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_registro().getCGG_CUSU_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_registro().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aerolinea.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectCGG_RES_AEROLINEA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_S_CGG_RES_AEROLINEA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCRALN_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_aerolinea.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_AEROLINEA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_D_CGG_RES_AEROLINEA(?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCRALN_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DS_CGG_RES_AEROLINEA(?) }");
				stmDelete.setString(1, this.getCgg_tct_registro().getCRALN_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_registro OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> outCgg_tct_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_S_CGG_RES_PERSONA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_registro().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_registro tmpCgg_tct_registro = new com.besixplus.sii.objects.Cgg_tct_registro();
				tmpCgg_tct_registro.setCTREG_CODIGO(results.getString(1));
				tmpCgg_tct_registro.setCRPER_CODIGO(results.getString(2));
				tmpCgg_tct_registro.setCTGTR_CODIGO(results.getString(3));
				tmpCgg_tct_registro.setCUSU_CODIGO(results.getString(4));
				tmpCgg_tct_registro.setCGG_CUSU_CODIGO(results.getString(5));
				tmpCgg_tct_registro.setCARPT_CODIGO(results.getString(6));
				tmpCgg_tct_registro.setCGG_CARPT_CODIGO(results.getString(7));
				tmpCgg_tct_registro.setCRALN_CODIGO(results.getString(8));
				tmpCgg_tct_registro.setCRTRA_CODIGO(results.getString(9));
				tmpCgg_tct_registro.setCTREG_NUMERO(results.getInt(10));
				tmpCgg_tct_registro.setCTREG_FECHA_PREREGISTRO(results.getTimestamp(11));
				tmpCgg_tct_registro.setCTREG_FECHA_INGRESO(results.getTimestamp(12));
				tmpCgg_tct_registro.setCTREG_CODIGO_BARRAS(results.getString(13));
				tmpCgg_tct_registro.setCTREG_FECHA_SALIDA(results.getTimestamp(14));
				tmpCgg_tct_registro.setCTREG_IMPRESION_ESPECIE(results.getTimestamp(15));
				tmpCgg_tct_registro.setCTREG_ESTADO_REGISTRO(results.getInt(16));
				tmpCgg_tct_registro.setCTREG_OBSERVACION(results.getString(17));
				tmpCgg_tct_registro.setCTREG_ESTADO(results.getBoolean(18));
				outCgg_tct_registro.add(tmpCgg_tct_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_registro DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_D_CGG_RES_PERSONA(?) }");
			stmDelete.setString(1, this.getCgg_tct_registro().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_DS_CGG_RES_PERSONA(?) }");
				stmDelete.setString(1, this.getCgg_tct_registro().getCRPER_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION.
	 * @param inCrper_num_doc_identific NUMERO DE IDENTIFICACION DE LA TABLA Cgg_res_persona PARA LA BUSQUEDA
	 * @param inCtregFechaIngreso FECHA DE INGRESO  A LA PROVINCIA POR TCT.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectPersona(
			java.sql.Connection inConnection,	
			String inCrdid_codigo,
			String inCrper_num_doc_identific,
			java.util.Date inCtregFechaIngreso

	){
		ArrayList<HashMap<String,Object>> outCgg_tct_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_TRAMITE_TCT_SELECT(?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrdid_codigo);	
			stmSelect.setString(3, inCrper_num_doc_identific);	
			stmSelect.setTimestamp(4, new java.sql.Timestamp(inCtregFechaIngreso.getTime()));
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_persona;
	}
	/**
	 * GENERA EL NUMERO DE REGISTRO DE LA TABLA Cgg_tct_registro
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return valorRegistro el numero generado para cada registro de TCT
	 */

	public static String numeroRegistroTct(
			java.sql.Connection inConnection

	){
		String valorRegistro=null;
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GENERA_NUM_REGISTRO_TCT() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);		
			stmSelect.execute();
			valorRegistro = stmSelect.getString(1);			
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorRegistro;
	}
	/**
	 * SELECCIONA EL CODIGO DE LA TABLA CGG.USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCusu_Nombre_Usuario NOMBRE DEL USUARIO ALMACENADO EN LA BASE
	 * @return codigoUsuario EL NUMERO GENERADO PARA CADA REGISTRO DE TCT
	 */
	public static String selecUsuario(
			java.sql.Connection inConnection,
			String inCusu_Nombre_Usuario

	){
		String codigoUsuario=null;
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_TCT_REGISTRO_USUARIO(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);		
			stmSelect.setString(2, inCusu_Nombre_Usuario);		
			stmSelect.execute();
			codigoUsuario = stmSelect.getString(1);			
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return codigoUsuario;
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_actividad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS.
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectActividad(
			java.sql.Connection inConnection,		
			String inCtgtr_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_tct_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_GRUPO_ACTIVIDAD(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCtgtr_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_persona;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_tipo_hospedaje QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS.
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectHospedaje(
			java.sql.Connection inConnection,		
			String inCtgtr_codigo

	){
		ArrayList<HashMap<String,Object>> outCgg_tct_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_REGISTRO_GRUPO_HOSPEDAJE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCtgtr_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_persona;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS.
	 * @param inCtreg_estado_registro ESTADO DEL PROCESO DE REGISTRO DE TCT
		0 - PREREGISTRADA
		1 - IMPRESA
		2 - ACTIVA
		3 - ANULADA
		4 - SOPORTE POR CIERRE DE RESIDENCIA
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectTctPersona(
			java.sql.Connection inConnection,		
			String inCtgtr_codigo,
			String inCtreg_estado_registro

	){
		ArrayList<HashMap<String,Object>> outCgg_tct_persona = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_REGISTRO_PERSONA(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCtgtr_codigo);
			stmSelect.setString(3, inCtreg_estado_registro);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_persona.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_persona;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA VARIAS TABLAS QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCtgtr_numero NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO DE TURISTAS.
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro 
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<HashMap<String,Object>> selectRegistroCodigo(
			java.sql.Connection inConnection,
			String inCtgtr_numero

	){
		ArrayList<HashMap<String,Object>> outCgg_codigo_barras = new ArrayList<HashMap<String,Object>>();

		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_REGISTRO_CODIGO_BARRAS_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setInt(2, Integer.parseInt(inCtgtr_numero));		
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_codigo_barras.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_codigo_barras;
	}
	/**
	 * SELECCIONA UN REGISTRO DE VARIAS TABLAS DE ACUERDO A SU CODIGO.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @return com.besixplus.sii.objects.Cgg_res_persona OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */



	public static ArrayList<HashMap<String,Object>> selectPersonaImposibilitada(
			java.sql.Connection inConnection,
			String inCrper_num_doc_identific

	){
		ArrayList<HashMap<String,Object>> outCgg_res_notificacion_imposibilitado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_persona_select_imposibilitada_notificacion(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCrper_num_doc_identific);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_res_notificacion_imposibilitado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_notificacion_imposibilitado;
	}

	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_registro.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstado(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_ESTADO_UPDATE(?, ?, ?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_registro().getCTREG_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_registro().getCGG_CUSU_CODIGO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_tct_registro().getCTREG_IMPRESION_ESPECIE().getTime()));
			stmUpdate.setInt(4, this.getCgg_tct_registro().getCTREG_ESTADO_REGISTRO());			
			stmUpdate.setString(5, this.getCgg_tct_registro().getCTREG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_registro.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String updateEstadoAnulado(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_REGISTRO_ESTADO_ANULADA_UPDATE(?, ?, ?::smallint, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_registro().getCTREG_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_registro().getCGG_CUSU_CODIGO());			
			stmUpdate.setInt(3, this.getCgg_tct_registro().getCTREG_ESTADO_REGISTRO());			
			stmUpdate.setString(4, this.getCgg_tct_registro().getCTREG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	 * OBTIENE UNA COLECCION CON INFORMACION DE CERTIFICADOS DE TRANSEUNTES, PERSONA, TRAMITE Y RESIDENCIA PARA VERIFICACION DE TCT OFFLINE.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION CON INFORMACION.
	 */
	public static ArrayList<HashMap<String,Object>> selectTranseunteOffline(
			java.sql.Connection inConnection			
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_registro = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_OFFLINE_TRANSEUNTES() }");
			stmSelect.registerOutParameter(1, Types.OTHER);					
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_registro.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}
	
	/**
	 * OBTIENE UNA COLECCION CON INFORMACION LAS PERSONAS NOTIFICADAS PARA VERIFICACION DE TCT OFFLINE.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION DE INFORMACION.
	 */
	public static ArrayList<HashMap<String,Object>> selectNotificadoOffline(
			java.sql.Connection inConnection			
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_registro = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_OFFLINE_NOTIFICADOS() }");
			stmSelect.registerOutParameter(1, Types.OTHER);					
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_registro.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}
	
	/**
	 * OBTIENE UNA COLECCION CON INFORMACION DE LAS PERSONAS IMPEDIDAS DE INGRESO POR LA RESTRICCION DE 90 DIAS ANUALES PARA VERIFICACION DE TCT OFFLINE. 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION DE INFORMACION.
	 */
	public static ArrayList<HashMap<String,Object>> selectExcedidoDiasOffline(
			java.sql.Connection inConnection			
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_registro = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_OFFLINE_DIAS_PERMANENCIA() }");
			stmSelect.registerOutParameter(1, Types.OTHER);					
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_registro.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}
	
	/**
	 * OBTIENE UNA COLECCION CON INFORMACION DE LOS GRUPOS Y PRE REGISTROS PREVIAMENTE REGISTRADOS EN EL SISTEMA Y QUE ESTAN CON ESTADO PRE REGISTRADO. 
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION DE INFORMACION.
	 */
	public static ArrayList<HashMap<String,Object>> selectGrupoTuristaRegistroOffline(
			java.sql.Connection inConnection			
	){
		ArrayList<HashMap<String,Object>> outCgg_tct_registro = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_GRUPO_REGISTRO_OFFLINE() }");
			stmSelect.registerOutParameter(1, Types.OTHER);					
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_tct_registro.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_registro;
	}
	
	/**
	 * Obtiene el ultimo numero de grupo de un registro offline de grupo de un usuario.
	 * @param inCUSU_NUMERO Numero de usuario formado por la parte numerica del campo clave clave ejem: CUSU147 - 147
	 * @param inConnection Conexion de datos.
	 * @return Ultimo numero de grupo.
	 */
	public static String getNumeracionGrupoOffline(
			String inCUSU_NUMERO,
			java.sql.Connection inConnection			
	){
		String outResult = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_GRUPO_NUMERACION_OFFLINE(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);
			stmSelect.setString(2, inCUSU_NUMERO);
			stmSelect.execute();
			outResult= stmSelect.getString(1);					
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outResult;
	}
	
	/**
	 * Obtiene el ultimo numero de grupo de un registro offline de grupo de un usuario.
	 * @param inCUSU_NUMERO Numero de usuario formado por la parte numerica del campo clave clave ejem: CUSU147 - 147
	 * @param inConnection Conexion de datos.
	 * @return Ultimo numero de grupo.
	 */
	public static String getNumeracionRegistroOffline(
			String inCUSU_NUMERO,
			java.sql.Connection inConnection			
	){
		String outResult = "";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_REGISTRO_NUMERACION_OFFLINE(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);	
			stmSelect.setString(2, inCUSU_NUMERO);
			stmSelect.execute();
			outResult= stmSelect.getString(1);					
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outResult;
	}

	/**
	 * OBTIENE INFORMACION DE LAS ESPECIES IMPRESAS ASOCIADAS A UN REGISTRO DE TCT.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DE USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<HashMap<String,Object>> selectEspeciesImpresas(
			Connection inConnection,
			String inUserName
			){
		ArrayList<HashMap<String,Object>> outEspecies = new ArrayList<HashMap<String,Object>>();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_ESPECIES_IMPRESAS(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, this.getCgg_tct_registro().getCTREG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outEspecies.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outEspecies;
	}
	
	/**
	 * Valida la informacion de personas para que no contenga caracteres invalidos.
	 * @param inConnection Conexion de datos.
	 * @return Numero de identicacion de personas con informacion invalida.
	 */
	public ArrayList<HashMap<String,Object>> validarInformacionOffline(
			Connection inConnection			
			){
		ArrayList<HashMap<String,Object>> outEspecies = new ArrayList<HashMap<String,Object>>();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_TCT_VALIDA_INFORMACION_OFFLINE() }");
			stmSelect.registerOutParameter(1, Types.OTHER);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)					
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outEspecies.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outEspecies;
	}
}