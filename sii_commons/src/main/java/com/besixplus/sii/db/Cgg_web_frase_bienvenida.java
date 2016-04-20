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
* CLASE Cgg_web_frase_bienvenida
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_web_frase_bienvenida.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_web_frase_bienvenida implements Serializable{
	private static final long serialVersionUID = 1673887128;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_web_frase_bienvenida.
	*/
	private com.besixplus.sii.objects.Cgg_web_frase_bienvenida myCgg_web_frase_bienvenida = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_frase_bienvenida.
	*/
	public Cgg_web_frase_bienvenida(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_frase_bienvenida.
	* @param inCgg_web_frase_bienvenida OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_web_frase_bienvenida.
	*/
	public Cgg_web_frase_bienvenida(
		com.besixplus.sii.objects.Cgg_web_frase_bienvenida inCgg_web_frase_bienvenida
	){
		this.setCgg_web_frase_bienvenida(inCgg_web_frase_bienvenida);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_web_frase_bienvenida.
	* @param inCgg_web_frase_bienvenida OBJETO Cgg_web_frase_bienvenida.
	* @return void
	*/
	public void setCgg_web_frase_bienvenida(com.besixplus.sii.objects.Cgg_web_frase_bienvenida inCgg_web_frase_bienvenida){
		this.myCgg_web_frase_bienvenida = inCgg_web_frase_bienvenida;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_web_frase_bienvenida.
	* @return Cgg_web_frase_bienvenida OBJETO Cgg_web_frase_bienvenida.
	*/
	public com.besixplus.sii.objects.Cgg_web_frase_bienvenida getCgg_web_frase_bienvenida(){
		return this.myCgg_web_frase_bienvenida;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_web_frase_bienvenida.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_web_frase_bienvenida().getCWFB_CODIGO());
			stmInsert.setString(3, this.getCgg_web_frase_bienvenida().getCWFB_CONTENIDO());
			stmInsert.setBoolean(4, this.getCgg_web_frase_bienvenida().getCWFB_HIBILITADO());
			stmInsert.setBoolean(5, this.getCgg_web_frase_bienvenida().getCWFB_ESTADO());
			stmInsert.setString(6, this.getCgg_web_frase_bienvenida().getCWFB_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_web_frase_bienvenida().setCWFB_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_frase_bienvenida.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> outCgg_web_frase_bienvenida = new ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_web_frase_bienvenida tmpCgg_web_frase_bienvenida = new com.besixplus.sii.objects.Cgg_web_frase_bienvenida();
				tmpCgg_web_frase_bienvenida.setCWFB_CODIGO(results.getString(1));
				tmpCgg_web_frase_bienvenida.setCWFB_CONTENIDO(results.getString(2));
				tmpCgg_web_frase_bienvenida.setCWFB_HIBILITADO(results.getBoolean(3));
				tmpCgg_web_frase_bienvenida.setCWFB_ESTADO(results.getBoolean(4));
				outCgg_web_frase_bienvenida.add(tmpCgg_web_frase_bienvenida);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_frase_bienvenida;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_frase_bienvenida QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> outCgg_web_frase_bienvenida = new ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_web_frase_bienvenida tmpCgg_web_frase_bienvenida = new com.besixplus.sii.objects.Cgg_web_frase_bienvenida();
				tmpCgg_web_frase_bienvenida.setCWFB_CODIGO(results.getString(1));
				tmpCgg_web_frase_bienvenida.setCWFB_CONTENIDO(results.getString(2));
				tmpCgg_web_frase_bienvenida.setCWFB_HIBILITADO(results.getBoolean(3));
				tmpCgg_web_frase_bienvenida.setCWFB_ESTADO(results.getBoolean(4));
				outCgg_web_frase_bienvenida.add(tmpCgg_web_frase_bienvenida);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_frase_bienvenida;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_web_frase_bienvenida QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_web_frase_bienvenida> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_web_frase_bienvenida = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_SELECT(?,?,?,?,?,?) }");
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
				outCgg_web_frase_bienvenida.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_web_frase_bienvenida;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_web_frase_bienvenida.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_web_frase_bienvenida.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_WEB_FRASE_BIENVENIDA_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_web_frase_bienvenida().getCWFB_CODIGO());
			stmUpdate.setString(2, this.getCgg_web_frase_bienvenida().getCWFB_CONTENIDO());
			stmUpdate.setBoolean(3, this.getCgg_web_frase_bienvenida().getCWFB_HIBILITADO());
			stmUpdate.setBoolean(4, this.getCgg_web_frase_bienvenida().getCWFB_ESTADO());
			stmUpdate.setString(5, this.getCgg_web_frase_bienvenida().getCWFB_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_web_frase_bienvenida DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_web_frase_bienvenida OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_web_frase_bienvenida select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_WEB_FRASE_BIENVENIDA_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_web_frase_bienvenida().getCWFB_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_web_frase_bienvenida().setCWFB_CODIGO(results.getString(1));
				this.getCgg_web_frase_bienvenida().setCWFB_CONTENIDO(results.getString(2));
				this.getCgg_web_frase_bienvenida().setCWFB_HIBILITADO(results.getBoolean(3));
				this.getCgg_web_frase_bienvenida().setCWFB_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_web_frase_bienvenida();
	}	

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_web_frase_bienvenida DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_FRASE_BIENVENIDA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_web_frase_bienvenida().getCWFB_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_WEB_FRASE_BIENVENIDA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_web_frase_bienvenida().getCWFB_CODIGO());
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