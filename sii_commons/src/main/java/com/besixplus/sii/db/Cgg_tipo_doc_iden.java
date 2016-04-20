package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_tipo_doc_iden
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tipo_doc_iden.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tipo_doc_iden implements Serializable{
	private static final long serialVersionUID = 679582973;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tipo_doc_iden.
	*/
	private com.besixplus.sii.objects.Cgg_tipo_doc_iden myCgg_tipo_doc_iden = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tipo_doc_iden.
	*/
	public Cgg_tipo_doc_iden(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tipo_doc_iden.
	* @param inCgg_tipo_doc_iden OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tipo_doc_iden.
	*/
	public Cgg_tipo_doc_iden(
		com.besixplus.sii.objects.Cgg_tipo_doc_iden inCgg_tipo_doc_iden
	){
		this.setCgg_tipo_doc_iden(inCgg_tipo_doc_iden);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tipo_doc_iden.
	* @param inCgg_tipo_doc_iden OBJETO Cgg_tipo_doc_iden.
	* @return void
	*/
	public void setCgg_tipo_doc_iden(com.besixplus.sii.objects.Cgg_tipo_doc_iden inCgg_tipo_doc_iden){
		this.myCgg_tipo_doc_iden = inCgg_tipo_doc_iden;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tipo_doc_iden.
	* @return Cgg_tipo_doc_iden OBJETO Cgg_tipo_doc_iden.
	*/
	public com.besixplus.sii.objects.Cgg_tipo_doc_iden getCgg_tipo_doc_iden(){
		return this.myCgg_tipo_doc_iden;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tipo_doc_iden.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_DOC_IDEN_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tipo_doc_iden().getCTDID_CODIGO());
			stmInsert.setString(3, this.getCgg_tipo_doc_iden().getCTDID_NOMBRE());
			stmInsert.setBoolean(4, this.getCgg_tipo_doc_iden().getCTDID_ESTADO());
			stmInsert.setString(5, this.getCgg_tipo_doc_iden().getCTDID_USUARIO_INSERT());
			stmInsert.setString(6, this.getCgg_tipo_doc_iden().getCTDID_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tipo_doc_iden().setCTDID_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tipo_doc_iden.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden> outCgg_tipo_doc_iden = new ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_DOC_IDEN_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tipo_doc_iden tmpCgg_tipo_doc_iden = new com.besixplus.sii.objects.Cgg_tipo_doc_iden();
				tmpCgg_tipo_doc_iden.setCTDID_CODIGO(results.getString(1));
				tmpCgg_tipo_doc_iden.setCTDID_NOMBRE(results.getString(2));
				tmpCgg_tipo_doc_iden.setCTDID_ESTADO(results.getBoolean(3));
				outCgg_tipo_doc_iden.add(tmpCgg_tipo_doc_iden);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tipo_doc_iden;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tipo_doc_iden QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden> outCgg_tipo_doc_iden = new ArrayList<com.besixplus.sii.objects.Cgg_tipo_doc_iden>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_DOC_IDEN_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tipo_doc_iden tmpCgg_tipo_doc_iden = new com.besixplus.sii.objects.Cgg_tipo_doc_iden();
				tmpCgg_tipo_doc_iden.setCTDID_CODIGO(results.getString(1));
				tmpCgg_tipo_doc_iden.setCTDID_NOMBRE(results.getString(2));
				tmpCgg_tipo_doc_iden.setCTDID_ESTADO(results.getBoolean(3));
				outCgg_tipo_doc_iden.add(tmpCgg_tipo_doc_iden);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tipo_doc_iden;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tipo_doc_iden.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_DOC_IDEN_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_DOC_IDEN_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tipo_doc_iden.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TIPO_DOC_IDEN_UPDATE(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tipo_doc_iden().getCTDID_CODIGO());
			stmUpdate.setString(2, this.getCgg_tipo_doc_iden().getCTDID_NOMBRE());
			stmUpdate.setBoolean(3, this.getCgg_tipo_doc_iden().getCTDID_ESTADO());
			stmUpdate.setString(4, this.getCgg_tipo_doc_iden().getCTDID_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tipo_doc_iden DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tipo_doc_iden OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tipo_doc_iden select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_DOC_IDEN_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tipo_doc_iden().getCTDID_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tipo_doc_iden().setCTDID_CODIGO(results.getString(1));
				this.getCgg_tipo_doc_iden().setCTDID_NOMBRE(results.getString(2));
				this.getCgg_tipo_doc_iden().setCTDID_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tipo_doc_iden();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tipo_doc_iden DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TIPO_DOC_IDEN_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tipo_doc_iden().getCTDID_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TIPO_DOC_IDEN_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tipo_doc_iden().getCTDID_CODIGO());
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