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
* CLASE Cgg_tct_grupo_turista
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_grupo_turista.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_grupo_turista implements Serializable{
	private static final long serialVersionUID = 1097519586;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_grupo_turista.
	*/
	private com.besixplus.sii.objects.Cgg_tct_grupo_turista myCgg_tct_grupo_turista = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_turista.
	*/
	public Cgg_tct_grupo_turista(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_turista.
	* @param inCgg_tct_grupo_turista OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_grupo_turista.
	*/
	public Cgg_tct_grupo_turista(
		com.besixplus.sii.objects.Cgg_tct_grupo_turista inCgg_tct_grupo_turista
	){
		this.setCgg_tct_grupo_turista(inCgg_tct_grupo_turista);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_grupo_turista.
	* @param inCgg_tct_grupo_turista OBJETO Cgg_tct_grupo_turista.
	* @return void
	*/
	public void setCgg_tct_grupo_turista(com.besixplus.sii.objects.Cgg_tct_grupo_turista inCgg_tct_grupo_turista){
		this.myCgg_tct_grupo_turista = inCgg_tct_grupo_turista;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_grupo_turista.
	* @return Cgg_tct_grupo_turista OBJETO Cgg_tct_grupo_turista.
	*/
	public com.besixplus.sii.objects.Cgg_tct_grupo_turista getCgg_tct_grupo_turista(){
		return this.myCgg_tct_grupo_turista;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_grupo_turista().getCTGTR_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
			stmInsert.setString(4, this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
			stmInsert.setInt(5, this.getCgg_tct_grupo_turista().getCTGTR_NUMERO());
			stmInsert.setTimestamp(6, new java.sql.Timestamp(this.getCgg_tct_grupo_turista().getCTGTR_FECHA_RESERVA().getTime()));
			stmInsert.setTimestamp(7, new java.sql.Timestamp(this.getCgg_tct_grupo_turista().getCTGTR_FECHA_INGRESO().getTime()));
			stmInsert.setTimestamp(8, new java.sql.Timestamp(this.getCgg_tct_grupo_turista().getCTGTR_FECHA_SALIDA().getTime()));
			stmInsert.setBoolean(9, this.getCgg_tct_grupo_turista().getCTGTR_ESTADO());
			stmInsert.setString(10, this.getCgg_tct_grupo_turista().getCTGTR_USUARIO_INSERT());
			stmInsert.setString(11, this.getCgg_tct_grupo_turista().getCTGTR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_grupo_turista().setCTGTR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> outCgg_tct_grupo_turista = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_turista tmpCgg_tct_grupo_turista = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
				tmpCgg_tct_grupo_turista.setCTGTR_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_turista.setCUSU_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_turista.setCTADC_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_turista.setCTGTR_NUMERO(results.getInt(4));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_RESERVA(results.getTimestamp(5));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_INGRESO(results.getTimestamp(6));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_tct_grupo_turista.setCTGTR_ESTADO(results.getBoolean(8));
				outCgg_tct_grupo_turista.add(tmpCgg_tct_grupo_turista);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_turista;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_grupo_turista QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> outCgg_tct_grupo_turista = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_grupo_turista tmpCgg_tct_grupo_turista = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
				tmpCgg_tct_grupo_turista.setCTGTR_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_turista.setCUSU_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_turista.setCTADC_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_turista.setCTGTR_NUMERO(results.getInt(4));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_RESERVA(results.getTimestamp(5));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_INGRESO(results.getTimestamp(6));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_tct_grupo_turista.setCTGTR_ESTADO(results.getBoolean(8));
				outCgg_tct_grupo_turista.add(tmpCgg_tct_grupo_turista);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_turista;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_grupo_turista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_grupo_turista().getCTGTR_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
			stmUpdate.setString(3, this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
			stmUpdate.setInt(4, this.getCgg_tct_grupo_turista().getCTGTR_NUMERO());
			stmUpdate.setTimestamp(5, new java.sql.Timestamp(this.getCgg_tct_grupo_turista().getCTGTR_FECHA_RESERVA().getTime()));
			stmUpdate.setTimestamp(6, new java.sql.Timestamp(this.getCgg_tct_grupo_turista().getCTGTR_FECHA_INGRESO().getTime()));
			stmUpdate.setTimestamp(7, new java.sql.Timestamp(this.getCgg_tct_grupo_turista().getCTGTR_FECHA_SALIDA().getTime()));
			stmUpdate.setBoolean(8, this.getCgg_tct_grupo_turista().getCTGTR_ESTADO());
			stmUpdate.setString(9, this.getCgg_tct_grupo_turista().getCTGTR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_grupo_turista DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_turista OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_grupo_turista select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_turista().getCTGTR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_grupo_turista().setCTGTR_CODIGO(results.getString(1));
				this.getCgg_tct_grupo_turista().setCUSU_CODIGO(results.getString(2));
				this.getCgg_tct_grupo_turista().setCTADC_CODIGO(results.getString(3));
				this.getCgg_tct_grupo_turista().setCTGTR_NUMERO(results.getInt(4));
				this.getCgg_tct_grupo_turista().setCTGTR_FECHA_RESERVA(results.getTimestamp(5));
				this.getCgg_tct_grupo_turista().setCTGTR_FECHA_INGRESO(results.getTimestamp(6));
				this.getCgg_tct_grupo_turista().setCTGTR_FECHA_SALIDA(results.getTimestamp(7));
				this.getCgg_tct_grupo_turista().setCTGTR_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_grupo_turista();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_grupo_turista DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_turista().getCTGTR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_turista().getCTGTR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_turista DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_turista OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> selectCGG_USUARIO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> outCgg_tct_grupo_turista = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_S_CGG_USUARIO(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_turista tmpCgg_tct_grupo_turista = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
				tmpCgg_tct_grupo_turista.setCTGTR_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_turista.setCUSU_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_turista.setCTADC_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_turista.setCTGTR_NUMERO(results.getInt(4));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_RESERVA(results.getTimestamp(5));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_INGRESO(results.getTimestamp(6));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_tct_grupo_turista.setCTGTR_ESTADO(results.getBoolean(8));
				outCgg_tct_grupo_turista.add(tmpCgg_tct_grupo_turista);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_turista;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_turista DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_usuario.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_D_CGG_USUARIO(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_DS_CGG_USUARIO(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_turista DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_adjunto_csv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_grupo_turista OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> selectCGG_TCT_ADJUNTO_CSV(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista> outCgg_tct_grupo_turista = new ArrayList<com.besixplus.sii.objects.Cgg_tct_grupo_turista>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_S_CGG_TCT_ADJUNTO_CSV(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
			stmSelect.setString(3,this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_grupo_turista tmpCgg_tct_grupo_turista = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
				tmpCgg_tct_grupo_turista.setCTGTR_CODIGO(results.getString(1));
				tmpCgg_tct_grupo_turista.setCUSU_CODIGO(results.getString(2));
				tmpCgg_tct_grupo_turista.setCTADC_CODIGO(results.getString(3));
				tmpCgg_tct_grupo_turista.setCTGTR_NUMERO(results.getInt(4));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_RESERVA(results.getTimestamp(5));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_INGRESO(results.getTimestamp(6));
				tmpCgg_tct_grupo_turista.setCTGTR_FECHA_SALIDA(results.getTimestamp(7));
				tmpCgg_tct_grupo_turista.setCTGTR_ESTADO(results.getBoolean(8));
				outCgg_tct_grupo_turista.add(tmpCgg_tct_grupo_turista);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_grupo_turista;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_tct_grupo_turista DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_tct_adjunto_csv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_TCT_ADJUNTO_CSV(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_D_CGG_TCT_ADJUNTO_CSV(?, ?) }");
			stmDelete.setString(1, this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
			stmDelete.setString(2, this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_GRUPO_TURISTA_DS_CGG_TCT_ADJUNTO_CSV(?, ?) }");
				stmDelete.setString(1, this.getCgg_tct_grupo_turista().getCTADC_CODIGO());
				stmDelete.setString(2, this.getCgg_tct_grupo_turista().getCUSU_CODIGO());
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
	 * SELECCIONA EL CODIGO DE LA TABLA CGG.USUARIO
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCusu_Nombre_Usuario NOMBRE DEL USUARIO ALMACENADO EN LA BASE
	 * @return codigoUsuario el numero generado para cada registro de TCT
	 */
	public static String selecUsuario(
			java.sql.Connection inConnection,
			String inCusu_Nombre_Usuario
			
	){
		String codigoUsuario=null;
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call F_CGG_TCT_GRUPO_TURISTA_USUARIO(?) }");
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
	 * GENERA EL NUMERO DE GRUPO DE LA TABLA Cgg_tct_grupo_turista
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return valorGrupo el numero generado para cada registro de TCT
	 */
	public static String numeroGrupoTct(
			java.sql.Connection inConnection
			
	){
		String valorGrupoTuris=null;
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_GENERA_NUM_GRUPO_TURISTA() }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);		
			stmSelect.execute();
			valorGrupoTuris = stmSelect.getString(1);			
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return valorGrupoTuris;
	}
	/**
	 * SELECCIONA EL NUMERO DE GRUPO DE LA TABLA Cgg_tct_grupo_actividad
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCtgtr_codigo CODIGO DE LA TABLA  Cgg_tct_grupo_actividad
	 * @return numeroGrupo NUMERO DE GRUPO 
	 */
	public static String selectNumero(
			java.sql.Connection inConnection,
			String inCtgtr_codigo
			
	){
		String codigoGrupo=null;
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_NUMERO_GRUPO_TURISTA(?) }");
			stmSelect.registerOutParameter(1, Types.VARCHAR);		
			stmSelect.setString(2, inCtgtr_codigo);		
			stmSelect.execute();
			codigoGrupo = stmSelect.getString(1);			
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return codigoGrupo;
	}
	
	/**
	 * SELECCIONA INFORMACION ADICIONAL DE UN GRUPO DE TURISTAS
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return COLECCION DE INFORMACION.
	 * 
	 */
	public ArrayList<HashMap<String, Object>> selectInformation(
			java.sql.Connection inConnection
	){
		ArrayList<HashMap<String, Object>> outInformation = new ArrayList<HashMap<String,Object>>();
		try{			
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_GRUPO_TURISTA_SELECT_INFO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);		
			stmSelect.setString(2, getCgg_tct_grupo_turista().getCTGTR_CODIGO());		
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1); 
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outInformation.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outInformation;
	}

}