package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_dhu_tipo_curso
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_tipo_curso.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_tipo_curso implements Serializable{
	private static final long serialVersionUID = 1600279052;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_tipo_curso.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_tipo_curso myCgg_dhu_tipo_curso = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_curso.
	*/
	public Cgg_dhu_tipo_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_curso.
	* @param inCgg_dhu_tipo_curso OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_tipo_curso.
	*/
	public Cgg_dhu_tipo_curso(
		com.besixplus.sii.objects.Cgg_dhu_tipo_curso inCgg_dhu_tipo_curso
	){
		this.setCgg_dhu_tipo_curso(inCgg_dhu_tipo_curso);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_tipo_curso.
	* @param inCgg_dhu_tipo_curso OBJETO Cgg_dhu_tipo_curso.
	* @return void
	*/
	public void setCgg_dhu_tipo_curso(com.besixplus.sii.objects.Cgg_dhu_tipo_curso inCgg_dhu_tipo_curso){
		this.myCgg_dhu_tipo_curso = inCgg_dhu_tipo_curso;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_tipo_curso.
	* @return Cgg_dhu_tipo_curso OBJETO Cgg_dhu_tipo_curso.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_tipo_curso getCgg_dhu_tipo_curso(){
		return this.myCgg_dhu_tipo_curso;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_tipo_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_TIPO_CURSO_INSERT(?,?,?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_tipo_curso().getCDTCR_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_tipo_curso().getCDTCR_NOMBRE());
			stmInsert.setInt(4, this.getCgg_dhu_tipo_curso().getCDTCR_TIPO_RESIDENTE());
			stmInsert.setBoolean(5, this.getCgg_dhu_tipo_curso().getCDTCR_ESTADO());
			stmInsert.setString(6, this.getCgg_dhu_tipo_curso().getCDTCR_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_dhu_tipo_curso().getCDTCR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_tipo_curso().setCDTCR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_tipo_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso> outCgg_dhu_tipo_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_TIPO_CURSO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_tipo_curso tmpCgg_dhu_tipo_curso = new com.besixplus.sii.objects.Cgg_dhu_tipo_curso();
				tmpCgg_dhu_tipo_curso.setCDTCR_CODIGO(results.getString(1));
				tmpCgg_dhu_tipo_curso.setCDTCR_NOMBRE(results.getString(2));
				tmpCgg_dhu_tipo_curso.setCDTCR_TIPO_RESIDENTE(results.getInt(3));
				tmpCgg_dhu_tipo_curso.setCDTCR_ESTADO(results.getBoolean(4));
				outCgg_dhu_tipo_curso.add(tmpCgg_dhu_tipo_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_tipo_curso;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_tipo_curso QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso> outCgg_dhu_tipo_curso = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_tipo_curso>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_TIPO_CURSO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_tipo_curso tmpCgg_dhu_tipo_curso = new com.besixplus.sii.objects.Cgg_dhu_tipo_curso();
				tmpCgg_dhu_tipo_curso.setCDTCR_CODIGO(results.getString(1));
				tmpCgg_dhu_tipo_curso.setCDTCR_NOMBRE(results.getString(2));
				tmpCgg_dhu_tipo_curso.setCDTCR_TIPO_RESIDENTE(results.getInt(3));
				tmpCgg_dhu_tipo_curso.setCDTCR_ESTADO(results.getBoolean(4));
				outCgg_dhu_tipo_curso.add(tmpCgg_dhu_tipo_curso);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_tipo_curso;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_tipo_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_TIPO_CURSO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_TIPO_CURSO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_tipo_curso.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_TIPO_CURSO_UPDATE(?,?,?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_tipo_curso().getCDTCR_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_tipo_curso().getCDTCR_NOMBRE());
			stmUpdate.setInt(3, this.getCgg_dhu_tipo_curso().getCDTCR_TIPO_RESIDENTE());
			stmUpdate.setBoolean(4, this.getCgg_dhu_tipo_curso().getCDTCR_ESTADO());
			stmUpdate.setString(5, this.getCgg_dhu_tipo_curso().getCDTCR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = "false";
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_tipo_curso DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_tipo_curso OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_tipo_curso select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_TIPO_CURSO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_tipo_curso().getCDTCR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_tipo_curso().setCDTCR_CODIGO(results.getString(1));
				this.getCgg_dhu_tipo_curso().setCDTCR_NOMBRE(results.getString(2));
				this.getCgg_dhu_tipo_curso().setCDTCR_TIPO_RESIDENTE(results.getInt(3));
				this.getCgg_dhu_tipo_curso().setCDTCR_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_tipo_curso();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_tipo_curso DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_TIPO_CURSO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_tipo_curso().getCDTCR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_TIPO_CURSO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_tipo_curso().getCDTCR_CODIGO());
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