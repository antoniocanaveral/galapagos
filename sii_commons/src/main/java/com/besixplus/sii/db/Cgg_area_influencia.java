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
* CLASE Cgg_area_influencia
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_area_influencia.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_area_influencia implements Serializable{
	private static final long serialVersionUID = 1532724556;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_area_influencia.
	*/
	private com.besixplus.sii.objects.Cgg_area_influencia myCgg_area_influencia = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_area_influencia.
	*/
	public Cgg_area_influencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_area_influencia.
	* @param inCgg_area_influencia OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_area_influencia.
	*/
	public Cgg_area_influencia(
		com.besixplus.sii.objects.Cgg_area_influencia inCgg_area_influencia
	){
		this.setCgg_area_influencia(inCgg_area_influencia);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_area_influencia.
	* @param inCgg_area_influencia OBJETO Cgg_area_influencia.
	* @return void
	*/
	public void setCgg_area_influencia(com.besixplus.sii.objects.Cgg_area_influencia inCgg_area_influencia){
		this.myCgg_area_influencia = inCgg_area_influencia;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_area_influencia.
	* @return Cgg_area_influencia OBJETO Cgg_area_influencia.
	*/
	public com.besixplus.sii.objects.Cgg_area_influencia getCgg_area_influencia(){
		return this.myCgg_area_influencia;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_area_influencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_area_influencia().getCAINF_CODIGO());
			stmInsert.setString(3, this.getCgg_area_influencia().getCAINF_NOMBRE());
			stmInsert.setString(4, this.getCgg_area_influencia().getCAINF_DESCRIPCION());
			stmInsert.setBoolean(5, this.getCgg_area_influencia().getCAINF_ESTADO());
			stmInsert.setString(6, this.getCgg_area_influencia().getCAINF_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_area_influencia().setCAINF_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_area_influencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> outCgg_area_influencia = new ArrayList<com.besixplus.sii.objects.Cgg_area_influencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_area_influencia tmpCgg_area_influencia = new com.besixplus.sii.objects.Cgg_area_influencia();
				tmpCgg_area_influencia.setCAINF_CODIGO(results.getString(1));
				tmpCgg_area_influencia.setCAINF_NOMBRE(results.getString(2));
				tmpCgg_area_influencia.setCAINF_DESCRIPCION(results.getString(3));
				tmpCgg_area_influencia.setCAINF_ESTADO(results.getBoolean(4));
				outCgg_area_influencia.add(tmpCgg_area_influencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_area_influencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_area_influencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> outCgg_area_influencia = new ArrayList<com.besixplus.sii.objects.Cgg_area_influencia>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_area_influencia tmpCgg_area_influencia = new com.besixplus.sii.objects.Cgg_area_influencia();
				tmpCgg_area_influencia.setCAINF_CODIGO(results.getString(1));
				tmpCgg_area_influencia.setCAINF_NOMBRE(results.getString(2));
				tmpCgg_area_influencia.setCAINF_DESCRIPCION(results.getString(3));
				tmpCgg_area_influencia.setCAINF_ESTADO(results.getBoolean(4));
				outCgg_area_influencia.add(tmpCgg_area_influencia);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_area_influencia;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_area_influencia QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_area_influencia> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<HashMap<String,Object>> outCgg_area_influencia = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_area_influencia.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_area_influencia;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_area_influencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_area_influencia.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_AREA_INFLUENCIA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_area_influencia().getCAINF_CODIGO());
			stmUpdate.setString(2, this.getCgg_area_influencia().getCAINF_NOMBRE());
			stmUpdate.setString(3, this.getCgg_area_influencia().getCAINF_DESCRIPCION());
			stmUpdate.setBoolean(4, this.getCgg_area_influencia().getCAINF_ESTADO());
			stmUpdate.setString(5, this.getCgg_area_influencia().getCAINF_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_area_influencia DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_area_influencia OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_area_influencia select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_AREA_INFLUENCIA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_area_influencia().getCAINF_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_area_influencia().setCAINF_CODIGO(results.getString(1));
				this.getCgg_area_influencia().setCAINF_NOMBRE(results.getString(2));
				this.getCgg_area_influencia().setCAINF_DESCRIPCION(results.getString(3));
				this.getCgg_area_influencia().setCAINF_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_area_influencia();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_area_influencia DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_AREA_INFLUENCIA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_area_influencia().getCAINF_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_AREA_INFLUENCIA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_area_influencia().getCAINF_CODIGO());
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