package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_tct_actividad
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_actividad.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_actividad implements Serializable{
	private static final long serialVersionUID = 825668525;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_actividad.
	*/
	private com.besixplus.sii.objects.Cgg_tct_actividad myCgg_tct_actividad = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_actividad.
	*/
	public Cgg_tct_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_actividad.
	* @param inCgg_tct_actividad OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_actividad.
	*/
	public Cgg_tct_actividad(
		com.besixplus.sii.objects.Cgg_tct_actividad inCgg_tct_actividad
	){
		this.setCgg_tct_actividad(inCgg_tct_actividad);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_actividad.
	* @param inCgg_tct_actividad OBJETO Cgg_tct_actividad.
	* @return void
	*/
	public void setCgg_tct_actividad(com.besixplus.sii.objects.Cgg_tct_actividad inCgg_tct_actividad){
		this.myCgg_tct_actividad = inCgg_tct_actividad;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_actividad.
	* @return Cgg_tct_actividad OBJETO Cgg_tct_actividad.
	*/
	public com.besixplus.sii.objects.Cgg_tct_actividad getCgg_tct_actividad(){
		return this.myCgg_tct_actividad;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ACTIVIDAD_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_actividad().getCTACT_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_actividad().getCTACT_NOMBRE());
			stmInsert.setBoolean(4, this.getCgg_tct_actividad().getCTACT_ESTADO());
			stmInsert.setString(5, this.getCgg_tct_actividad().getCTACT_USUARIO_INSERT());
			stmInsert.setString(6, this.getCgg_tct_actividad().getCTACT_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_tct_actividad().setCTACT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> outCgg_tct_actividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ACTIVIDAD_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_actividad tmpCgg_tct_actividad = new com.besixplus.sii.objects.Cgg_tct_actividad();
				tmpCgg_tct_actividad.setCTACT_CODIGO(results.getString(1));
				tmpCgg_tct_actividad.setCTACT_NOMBRE(results.getString(2));
				tmpCgg_tct_actividad.setCTACT_ESTADO(results.getBoolean(3));
				outCgg_tct_actividad.add(tmpCgg_tct_actividad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_actividad;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_actividad QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
    * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> outCgg_tct_actividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ACTIVIDAD_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_actividad tmpCgg_tct_actividad = new com.besixplus.sii.objects.Cgg_tct_actividad();
				tmpCgg_tct_actividad.setCTACT_CODIGO(results.getString(1));
				tmpCgg_tct_actividad.setCTACT_NOMBRE(results.getString(2));
				tmpCgg_tct_actividad.setCTACT_ESTADO(results.getBoolean(3));
				outCgg_tct_actividad.add(tmpCgg_tct_actividad);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_actividad;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ACTIVIDAD_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ACTIVIDAD_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_actividad.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_ACTIVIDAD_UPDATE(?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_actividad().getCTACT_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_actividad().getCTACT_NOMBRE());
			stmUpdate.setBoolean(3, this.getCgg_tct_actividad().getCTACT_ESTADO());
			stmUpdate.setString(4, this.getCgg_tct_actividad().getCTACT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_actividad DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_actividad OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_actividad select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ACTIVIDAD_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_actividad().getCTACT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_actividad().setCTACT_CODIGO(results.getString(1));
				this.getCgg_tct_actividad().setCTACT_NOMBRE(results.getString(2));
				this.getCgg_tct_actividad().setCTACT_ESTADO(results.getBoolean(3));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_actividad();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_actividad DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_ACTIVIDAD_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_actividad().getCTACT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_ACTIVIDAD_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_actividad().getCTACT_CODIGO());
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