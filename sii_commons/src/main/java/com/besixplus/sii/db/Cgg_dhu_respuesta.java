package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_dhu_respuesta
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_respuesta.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_respuesta implements Serializable{
	private static final long serialVersionUID = 404243540;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_respuesta.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_respuesta myCgg_dhu_respuesta = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_respuesta.
	*/
	public Cgg_dhu_respuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_respuesta.
	* @param inCgg_dhu_respuesta OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_respuesta.
	*/
	public Cgg_dhu_respuesta(
		com.besixplus.sii.objects.Cgg_dhu_respuesta inCgg_dhu_respuesta
	){
		this.setCgg_dhu_respuesta(inCgg_dhu_respuesta);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_respuesta.
	* @param inCgg_dhu_respuesta OBJETO Cgg_dhu_respuesta.
	* @return void
	*/
	public void setCgg_dhu_respuesta(com.besixplus.sii.objects.Cgg_dhu_respuesta inCgg_dhu_respuesta){
		this.myCgg_dhu_respuesta = inCgg_dhu_respuesta;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_respuesta.
	* @return Cgg_dhu_respuesta OBJETO Cgg_dhu_respuesta.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_respuesta getCgg_dhu_respuesta(){
		return this.myCgg_dhu_respuesta;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_respuesta().getCDRES_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_respuesta().getCDRES_DESCRIPCION());
			stmInsert.setBoolean(4, this.getCgg_dhu_respuesta().getCDRES_ESTADO());
			stmInsert.setString(5, this.getCgg_dhu_respuesta().getCDRES_USUARIO_INSERT());
			stmInsert.setString(6, this.getCgg_dhu_respuesta().getCDRES_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_respuesta().setCDRES_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta> outCgg_dhu_respuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_respuesta tmpCgg_dhu_respuesta = new com.besixplus.sii.objects.Cgg_dhu_respuesta();
				tmpCgg_dhu_respuesta.setCDRES_CODIGO(results.getString(1));
				tmpCgg_dhu_respuesta.setCDRES_DESCRIPCION(results.getString(2));
				tmpCgg_dhu_respuesta.setCDRES_ESTADO(results.getBoolean(3));
				outCgg_dhu_respuesta.add(tmpCgg_dhu_respuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_respuesta;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_respuesta QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta> outCgg_dhu_respuesta = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_respuesta>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_respuesta tmpCgg_dhu_respuesta = new com.besixplus.sii.objects.Cgg_dhu_respuesta();
				tmpCgg_dhu_respuesta.setCDRES_CODIGO(results.getString(1));
				tmpCgg_dhu_respuesta.setCDRES_DESCRIPCION(results.getString(2));
				tmpCgg_dhu_respuesta.setCDRES_ESTADO(results.getBoolean(3));
				outCgg_dhu_respuesta.add(tmpCgg_dhu_respuesta);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_respuesta;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_respuesta.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_RESPUESTA_UPDATE(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_respuesta().getCDRES_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_respuesta().getCDRES_DESCRIPCION());
			stmUpdate.setBoolean(3, this.getCgg_dhu_respuesta().getCDRES_ESTADO());
			stmUpdate.setString(4, this.getCgg_dhu_respuesta().getCDRES_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_respuesta DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_respuesta OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_respuesta select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_RESPUESTA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_respuesta().getCDRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_respuesta().setCDRES_CODIGO(results.getString(1));
				this.getCgg_dhu_respuesta().setCDRES_DESCRIPCION(results.getString(2));
				this.getCgg_dhu_respuesta().setCDRES_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_respuesta();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_respuesta DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_RESPUESTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_respuesta().getCDRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_RESPUESTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_respuesta().getCDRES_CODIGO());
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