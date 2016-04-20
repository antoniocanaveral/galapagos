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
 * CLASE Cgg_buzon_correo
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_buzon_correo.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_buzon_correo implements Serializable{
	private static final long serialVersionUID = 806362699;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_buzon_correo.
	 */
	private com.besixplus.sii.objects.Cgg_buzon_correo myCgg_buzon_correo = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_buzon_correo.
	 */
	public Cgg_buzon_correo(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_buzon_correo.
	 * @param inCgg_buzon_correo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_buzon_correo.
	 */
	public Cgg_buzon_correo(
			com.besixplus.sii.objects.Cgg_buzon_correo inCgg_buzon_correo
	){
		this.setCgg_buzon_correo(inCgg_buzon_correo);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_buzon_correo.
	 * @param inCgg_buzon_correo OBJETO Cgg_buzon_correo.
	 * @return void
	 */
	public void setCgg_buzon_correo(com.besixplus.sii.objects.Cgg_buzon_correo inCgg_buzon_correo){
		this.myCgg_buzon_correo = inCgg_buzon_correo;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_buzon_correo.
	 * @return Cgg_buzon_correo OBJETO Cgg_buzon_correo.
	 */
	public com.besixplus.sii.objects.Cgg_buzon_correo getCgg_buzon_correo(){
		return this.myCgg_buzon_correo;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_buzon_correo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String insert(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_buzon_correo().getCBZC_CODIGO());
			stmInsert.setString(3, this.getCgg_buzon_correo().getCBZC_DESTINATARIO());
			stmInsert.setString(4, this.getCgg_buzon_correo().getCBZC_ASUNTO());
			stmInsert.setString(5, this.getCgg_buzon_correo().getCBZC_MENSAJE());
			stmInsert.setString(6, this.getCgg_buzon_correo().getCBZC_TIPO_CONTENIDO());
			stmInsert.setBigDecimal(7, this.getCgg_buzon_correo().getCBZC_NUMERO_INTENTOS());
			stmInsert.setBoolean(8, this.getCgg_buzon_correo().getCBZC_ENVIADO());
			stmInsert.setBoolean(9, this.getCgg_buzon_correo().getCBZC_ESTADO());
			stmInsert.setString(10, this.getCgg_buzon_correo().getCBZC_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_buzon_correo().setCBZC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_buzon_correo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> outCgg_buzon_correo = new ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_buzon_correo tmpCgg_buzon_correo = new com.besixplus.sii.objects.Cgg_buzon_correo();
				tmpCgg_buzon_correo.setCBZC_CODIGO(results.getString(1));
				tmpCgg_buzon_correo.setCBZC_DESTINATARIO(results.getString(2));
				tmpCgg_buzon_correo.setCBZC_ASUNTO(results.getString(3));
				tmpCgg_buzon_correo.setCBZC_MENSAJE(results.getString(4));
				tmpCgg_buzon_correo.setCBZC_TIPO_CONTENIDO(results.getString(5));
				tmpCgg_buzon_correo.setCBZC_NUMERO_INTENTOS(results.getBigDecimal(6));
				tmpCgg_buzon_correo.setCBZC_ENVIADO(results.getBoolean(7));
				tmpCgg_buzon_correo.setCBZC_ESTADO(results.getBoolean(8));
				outCgg_buzon_correo.add(tmpCgg_buzon_correo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_buzon_correo;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_buzon_correo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inCbzc_enviado ESTADO DEL CORREO
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public synchronized ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			boolean inCbzc_enviado
	){
		ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> outCgg_buzon_correo = new ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_SELECT_AS(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setBoolean(3, inCbzc_enviado);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_buzon_correo tmpCgg_buzon_correo = new com.besixplus.sii.objects.Cgg_buzon_correo();
				tmpCgg_buzon_correo.setCBZC_CODIGO(results.getString(1));
				tmpCgg_buzon_correo.setCBZC_DESTINATARIO(results.getString(2));
				tmpCgg_buzon_correo.setCBZC_ASUNTO(results.getString(3));
				tmpCgg_buzon_correo.setCBZC_MENSAJE(results.getString(4));
				tmpCgg_buzon_correo.setCBZC_TIPO_CONTENIDO(results.getString(5));
				tmpCgg_buzon_correo.setCBZC_NUMERO_INTENTOS(results.getBigDecimal(6));
				tmpCgg_buzon_correo.setCBZC_ENVIADO(results.getBoolean(7));
				tmpCgg_buzon_correo.setCBZC_ESTADO(results.getBoolean(8));
				tmpCgg_buzon_correo.setCBZC_USUARIO_INSERT(results.getString(10));
				outCgg_buzon_correo.add(tmpCgg_buzon_correo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_buzon_correo;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_buzon_correo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> outCgg_buzon_correo = new ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_buzon_correo tmpCgg_buzon_correo = new com.besixplus.sii.objects.Cgg_buzon_correo();
				tmpCgg_buzon_correo.setCBZC_CODIGO(results.getString(1));
				tmpCgg_buzon_correo.setCBZC_DESTINATARIO(results.getString(2));
				tmpCgg_buzon_correo.setCBZC_ASUNTO(results.getString(3));
				tmpCgg_buzon_correo.setCBZC_MENSAJE(results.getString(4));
				tmpCgg_buzon_correo.setCBZC_TIPO_CONTENIDO(results.getString(5));
				tmpCgg_buzon_correo.setCBZC_NUMERO_INTENTOS(results.getBigDecimal(6));
				tmpCgg_buzon_correo.setCBZC_ENVIADO(results.getBoolean(7));
				tmpCgg_buzon_correo.setCBZC_ESTADO(results.getBoolean(8));
				outCgg_buzon_correo.add(tmpCgg_buzon_correo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_buzon_correo;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_buzon_correo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_buzon_correo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_buzon_correo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_buzon_correo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_buzon_correo;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_buzon_correo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_COUNT(?) }");
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
	 * ACTUALIZA UN REGISTRO DE LA TABLA Cgg_buzon_correo.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public synchronized String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_BUZON_CORREO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_buzon_correo().getCBZC_CODIGO());
			stmUpdate.setString(2, this.getCgg_buzon_correo().getCBZC_DESTINATARIO());
			stmUpdate.setString(3, this.getCgg_buzon_correo().getCBZC_ASUNTO());
			stmUpdate.setString(4, this.getCgg_buzon_correo().getCBZC_MENSAJE());
			stmUpdate.setString(5, this.getCgg_buzon_correo().getCBZC_TIPO_CONTENIDO());
			stmUpdate.setBigDecimal(6, this.getCgg_buzon_correo().getCBZC_NUMERO_INTENTOS());
			stmUpdate.setBoolean(7, this.getCgg_buzon_correo().getCBZC_ENVIADO());
			stmUpdate.setBoolean(8, this.getCgg_buzon_correo().getCBZC_ESTADO());
			stmUpdate.setString(9, this.getCgg_buzon_correo().getCBZC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_buzon_correo DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_buzon_correo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_buzon_correo select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_BUZON_CORREO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_buzon_correo().getCBZC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_buzon_correo().setCBZC_CODIGO(results.getString(1));
				this.getCgg_buzon_correo().setCBZC_DESTINATARIO(results.getString(2));
				this.getCgg_buzon_correo().setCBZC_ASUNTO(results.getString(3));
				this.getCgg_buzon_correo().setCBZC_MENSAJE(results.getString(4));
				this.getCgg_buzon_correo().setCBZC_TIPO_CONTENIDO(results.getString(5));
				this.getCgg_buzon_correo().setCBZC_NUMERO_INTENTOS(results.getBigDecimal(6));
				this.getCgg_buzon_correo().setCBZC_ENVIADO(results.getBoolean(7));
				this.getCgg_buzon_correo().setCBZC_ESTADO(results.getBoolean(8));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_buzon_correo();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_buzon_correo DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inSoft VARIABLE QUE ALMACENA EL LISTADO PARA REALIZAR UNA ELIMINACION FISICA O LOGICA
	 
	  
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String delete(
			java.sql.Connection inConnection,
			boolean inSoft
	){
		String outResult = "true";
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			if(inSoft){
				tmpAutoCommit = inConnection.getAutoCommit();
				inConnection.setAutoCommit(false);
				tmpSP = inConnection.setSavepoint();
			}
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_BUZON_CORREO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_buzon_correo().getCBZC_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		if(outResult.equals("true") && inSoft){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_BUZON_CORREO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_buzon_correo().getCBZC_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
		}
		return outResult;
	}

}