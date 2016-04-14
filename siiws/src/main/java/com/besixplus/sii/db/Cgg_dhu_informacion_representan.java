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
* CLASE Cgg_dhu_informacion_representan
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_informacion_representan.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_informacion_representan implements Serializable{
	private static final long serialVersionUID = 1303589300;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_informacion_representan.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_informacion_representan myCgg_dhu_informacion_representan = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_informacion_representan.
	*/
	public Cgg_dhu_informacion_representan(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_informacion_representan.
	* @param inCgg_dhu_informacion_representan OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_informacion_representan.
	*/
	public Cgg_dhu_informacion_representan(
		com.besixplus.sii.objects.Cgg_dhu_informacion_representan inCgg_dhu_informacion_representan
	){
		this.setCgg_dhu_informacion_representan(inCgg_dhu_informacion_representan);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_informacion_representan.
	* @param inCgg_dhu_informacion_representan OBJETO Cgg_dhu_informacion_representan.
	* @return void
	*/
	public void setCgg_dhu_informacion_representan(com.besixplus.sii.objects.Cgg_dhu_informacion_representan inCgg_dhu_informacion_representan){
		this.myCgg_dhu_informacion_representan = inCgg_dhu_informacion_representan;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_informacion_representan.
	* @return Cgg_dhu_informacion_representan OBJETO Cgg_dhu_informacion_representan.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_informacion_representan getCgg_dhu_informacion_representan(){
		return this.myCgg_dhu_informacion_representan;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_informacion_representan.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_INSERT(?, ?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_informacion_representan().getCDINR_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
			stmInsert.setString(5, this.getCgg_dhu_informacion_representan().getCDINR_DESCRIPCION());
			stmInsert.setInt(6, this.getCgg_dhu_informacion_representan().getCDINR_TIPO_REPRESENTANTE());
			stmInsert.setBoolean(7, this.getCgg_dhu_informacion_representan().getCDINR_ESTADO());
			stmInsert.setString(8, this.getCgg_dhu_informacion_representan().getCDINR_USUARIO_INSERT());
			stmInsert.setString(9, this.getCgg_dhu_informacion_representan().getCDINR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_informacion_representan().setCDINR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_informacion_representan.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> outCgg_dhu_informacion_representan = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_informacion_representan tmpCgg_dhu_informacion_representan = new com.besixplus.sii.objects.Cgg_dhu_informacion_representan();
				tmpCgg_dhu_informacion_representan.setCDINR_CODIGO(results.getString(1));
				tmpCgg_dhu_informacion_representan.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_informacion_representan.setCDBEC_CODIGO(results.getString(3));
				tmpCgg_dhu_informacion_representan.setCDINR_DESCRIPCION(results.getString(4));
				tmpCgg_dhu_informacion_representan.setCDINR_TIPO_REPRESENTANTE(results.getInt(5));
				tmpCgg_dhu_informacion_representan.setCDINR_ESTADO(results.getBoolean(6));
				outCgg_dhu_informacion_representan.add(tmpCgg_dhu_informacion_representan);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_informacion_representan;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_informacion_representan QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_informacion_representan = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_SELECT(?,?,?,?,?,?) }");
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
				outCgg_dhu_informacion_representan.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_informacion_representan;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_informacion_representan.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_COUNT() }");
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
			return selectCount(inConnection);
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_informacion_representan.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String  outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_UPDATE(?, ?, ?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_informacion_representan().getCDINR_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
			stmUpdate.setString(4, this.getCgg_dhu_informacion_representan().getCDINR_DESCRIPCION());
			stmUpdate.setInt(5, this.getCgg_dhu_informacion_representan().getCDINR_TIPO_REPRESENTANTE());
			stmUpdate.setBoolean(6, this.getCgg_dhu_informacion_representan().getCDINR_ESTADO());
			stmUpdate.setString(7, this.getCgg_dhu_informacion_representan().getCDINR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_informacion_representan DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_informacion_representan OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_informacion_representan select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_informacion_representan().getCDINR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_informacion_representan().setCDINR_CODIGO(results.getString(1));
				this.getCgg_dhu_informacion_representan().setCRPER_CODIGO(results.getString(2));
				this.getCgg_dhu_informacion_representan().setCDBEC_CODIGO(results.getString(3));
				this.getCgg_dhu_informacion_representan().setCDINR_DESCRIPCION(results.getString(4));
				this.getCgg_dhu_informacion_representan().setCDINR_TIPO_REPRESENTANTE(results.getInt(5));
				this.getCgg_dhu_informacion_representan().setCDINR_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_informacion_representan();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_informacion_representan DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String delete(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_informacion_representan().getCDINR_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		if(outResult.equals("true")){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_informacion_representan().getCDINR_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = "false";
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_informacion_representan DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_informacion_representan OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> selectCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> outCgg_dhu_informacion_representan = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_S_CGG_DHU_BECA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_informacion_representan tmpCgg_dhu_informacion_representan = new com.besixplus.sii.objects.Cgg_dhu_informacion_representan();
				tmpCgg_dhu_informacion_representan.setCDINR_CODIGO(results.getString(1));
				tmpCgg_dhu_informacion_representan.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_informacion_representan.setCDBEC_CODIGO(results.getString(3));
				tmpCgg_dhu_informacion_representan.setCDINR_DESCRIPCION(results.getString(4));
				tmpCgg_dhu_informacion_representan.setCDINR_TIPO_REPRESENTANTE(results.getInt(5));
				tmpCgg_dhu_informacion_representan.setCDINR_ESTADO(results.getBoolean(6));
				outCgg_dhu_informacion_representan.add(tmpCgg_dhu_informacion_representan);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_informacion_representan;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_informacion_representan DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_BECA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_D_CGG_DHU_BECA(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_DS_CGG_DHU_BECA(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_informacion_representan DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_informacion_representan OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> selectCGG_RES_PERSONA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan> outCgg_dhu_informacion_representan = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_informacion_representan>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_S_CGG_RES_PERSONA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_informacion_representan tmpCgg_dhu_informacion_representan = new com.besixplus.sii.objects.Cgg_dhu_informacion_representan();
				tmpCgg_dhu_informacion_representan.setCDINR_CODIGO(results.getString(1));
				tmpCgg_dhu_informacion_representan.setCRPER_CODIGO(results.getString(2));
				tmpCgg_dhu_informacion_representan.setCDBEC_CODIGO(results.getString(3));
				tmpCgg_dhu_informacion_representan.setCDINR_DESCRIPCION(results.getString(4));
				tmpCgg_dhu_informacion_representan.setCDINR_TIPO_REPRESENTANTE(results.getInt(5));
				tmpCgg_dhu_informacion_representan.setCDINR_ESTADO(results.getBoolean(6));
				outCgg_dhu_informacion_representan.add(tmpCgg_dhu_informacion_representan);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_informacion_representan;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_informacion_representan DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_D_CGG_RES_PERSONA(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INFORMACION_REPRESENTAN_DS_CGG_RES_PERSONA(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_informacion_representan().getCDBEC_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_informacion_representan().getCRPER_CODIGO());
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