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
* CLASE Cgg_dhu_beca_certificado
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_beca_certificado.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_beca_certificado implements Serializable{
	private static final long serialVersionUID = 936118293;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_beca_certificado.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_beca_certificado myCgg_dhu_beca_certificado = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca_certificado.
	*/
	public Cgg_dhu_beca_certificado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca_certificado.
	* @param inCgg_dhu_beca_certificado OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_beca_certificado.
	*/
	public Cgg_dhu_beca_certificado(
		com.besixplus.sii.objects.Cgg_dhu_beca_certificado inCgg_dhu_beca_certificado
	){
		this.setCgg_dhu_beca_certificado(inCgg_dhu_beca_certificado);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_beca_certificado.
	* @param inCgg_dhu_beca_certificado OBJETO Cgg_dhu_beca_certificado.
	* @return void
	*/
	public void setCgg_dhu_beca_certificado(com.besixplus.sii.objects.Cgg_dhu_beca_certificado inCgg_dhu_beca_certificado){
		this.myCgg_dhu_beca_certificado = inCgg_dhu_beca_certificado;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_beca_certificado.
	* @return Cgg_dhu_beca_certificado OBJETO Cgg_dhu_beca_certificado.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_beca_certificado getCgg_dhu_beca_certificado(){
		return this.myCgg_dhu_beca_certificado;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_beca_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_beca_certificado().getCDBCR_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
			stmInsert.setString(4, this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_dhu_beca_certificado().getCDBCR_OBLIGATORIO());
			stmInsert.setBoolean(6, this.getCgg_dhu_beca_certificado().getCDBCR_ESTADO());
			stmInsert.setString(7, this.getCgg_dhu_beca_certificado().getCDBCR_USUARIO_INSERT());
			stmInsert.setString(8, this.getCgg_dhu_beca_certificado().getCDBCR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_beca_certificado().setCDBCR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> outCgg_dhu_beca_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca_certificado tmpCgg_dhu_beca_certificado = new com.besixplus.sii.objects.Cgg_dhu_beca_certificado();
				tmpCgg_dhu_beca_certificado.setCDBCR_CODIGO(results.getString(1));
				tmpCgg_dhu_beca_certificado.setCDTCA_CODIGO(results.getString(2));
				tmpCgg_dhu_beca_certificado.setCDTBC_CODIGO(results.getString(3));
				tmpCgg_dhu_beca_certificado.setCDBCR_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_dhu_beca_certificado.setCDBCR_ESTADO(results.getBoolean(5));
				outCgg_dhu_beca_certificado.add(tmpCgg_dhu_beca_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_certificado;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca_certificado QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> outCgg_dhu_beca_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_beca_certificado tmpCgg_dhu_beca_certificado = new com.besixplus.sii.objects.Cgg_dhu_beca_certificado();
				tmpCgg_dhu_beca_certificado.setCDBCR_CODIGO(results.getString(1));
				tmpCgg_dhu_beca_certificado.setCDTCA_CODIGO(results.getString(2));
				tmpCgg_dhu_beca_certificado.setCDTBC_CODIGO(results.getString(3));
				tmpCgg_dhu_beca_certificado.setCDBCR_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_dhu_beca_certificado.setCDBCR_ESTADO(results.getBoolean(5));
				outCgg_dhu_beca_certificado.add(tmpCgg_dhu_beca_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_certificado;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_beca_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_beca_certificado.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_beca_certificado().getCDBCR_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
			stmUpdate.setString(3, this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_dhu_beca_certificado().getCDBCR_OBLIGATORIO());
			stmUpdate.setBoolean(5, this.getCgg_dhu_beca_certificado().getCDBCR_ESTADO());
			stmUpdate.setString(6, this.getCgg_dhu_beca_certificado().getCDBCR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_beca_certificado DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_beca_certificado select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca_certificado().getCDBCR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_beca_certificado().setCDBCR_CODIGO(results.getString(1));
				this.getCgg_dhu_beca_certificado().setCDTCA_CODIGO(results.getString(2));
				this.getCgg_dhu_beca_certificado().setCDTBC_CODIGO(results.getString(3));
				this.getCgg_dhu_beca_certificado().setCDBCR_OBLIGATORIO(results.getBoolean(4));
				this.getCgg_dhu_beca_certificado().setCDBCR_ESTADO(results.getBoolean(5));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_beca_certificado();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_beca_certificado DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca_certificado().getCDBCR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca_certificado().getCDBCR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca_certificado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> selectCGG_DHU_TIPO_BECA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> outCgg_dhu_beca_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_S_CGG_DHU_TIPO_BECA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca_certificado tmpCgg_dhu_beca_certificado = new com.besixplus.sii.objects.Cgg_dhu_beca_certificado();
				tmpCgg_dhu_beca_certificado.setCDBCR_CODIGO(results.getString(1));
				tmpCgg_dhu_beca_certificado.setCDTCA_CODIGO(results.getString(2));
				tmpCgg_dhu_beca_certificado.setCDTBC_CODIGO(results.getString(3));
				tmpCgg_dhu_beca_certificado.setCDBCR_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_dhu_beca_certificado.setCDBCR_ESTADO(results.getBoolean(5));
				outCgg_dhu_beca_certificado.add(tmpCgg_dhu_beca_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_certificado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca_certificado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_beca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_TIPO_BECA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_D_CGG_DHU_TIPO_BECA(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_DS_CGG_DHU_TIPO_BECA(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_dhu_beca_certificado DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_cacademico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_beca_certificado OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> selectCGG_DHU_TIPO_CACADEMICO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado> outCgg_dhu_beca_certificado = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca_certificado>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_BECA_CERTIFICADO_S_CGG_DHU_TIPO_CACADEMICO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
			stmSelect.setString(3,this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_beca_certificado tmpCgg_dhu_beca_certificado = new com.besixplus.sii.objects.Cgg_dhu_beca_certificado();
				tmpCgg_dhu_beca_certificado.setCDBCR_CODIGO(results.getString(1));
				tmpCgg_dhu_beca_certificado.setCDTCA_CODIGO(results.getString(2));
				tmpCgg_dhu_beca_certificado.setCDTBC_CODIGO(results.getString(3));
				tmpCgg_dhu_beca_certificado.setCDBCR_OBLIGATORIO(results.getBoolean(4));
				tmpCgg_dhu_beca_certificado.setCDBCR_ESTADO(results.getBoolean(5));
				outCgg_dhu_beca_certificado.add(tmpCgg_dhu_beca_certificado);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_certificado;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_dhu_beca_certificado DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_dhu_tipo_cacademico.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_DHU_TIPO_CACADEMICO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_D_CGG_DHU_TIPO_CACADEMICO(?, ?) }");
			stmDelete.setString(1, this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
			stmDelete.setString(2, this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_BECA_CERTIFICADO_DS_CGG_DHU_TIPO_CACADEMICO(?, ?) }");
				stmDelete.setString(1, this.getCgg_dhu_beca_certificado().getCDTBC_CODIGO());
				stmDelete.setString(2, this.getCgg_dhu_beca_certificado().getCDTCA_CODIGO());
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
	public static ArrayList<HashMap<String,Object>> selectBecaCertificado(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_dhu_beca_certificado = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_dhu_beca_certificado_select(?,?,?,?,?,?) }");
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
				outCgg_dhu_beca_certificado.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_beca_certificado;
	}

}