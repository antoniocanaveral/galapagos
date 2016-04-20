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
* CLASE Cgg_tct_adjunto_csv
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_adjunto_csv.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_tct_adjunto_csv implements Serializable{
	private static final long serialVersionUID = 1932299191;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_adjunto_csv.
	*/
	private com.besixplus.sii.objects.Cgg_tct_adjunto_csv myCgg_tct_adjunto_csv = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_adjunto_csv.
	*/
	public Cgg_tct_adjunto_csv(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_adjunto_csv.
	* @param inCgg_tct_adjunto_csv OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_tct_adjunto_csv.
	*/
	public Cgg_tct_adjunto_csv(
		com.besixplus.sii.objects.Cgg_tct_adjunto_csv inCgg_tct_adjunto_csv
	){
		this.setCgg_tct_adjunto_csv(inCgg_tct_adjunto_csv);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_adjunto_csv.
	* @param inCgg_tct_adjunto_csv OBJETO Cgg_tct_adjunto_csv.
	* @return void
	*/
	public void setCgg_tct_adjunto_csv(com.besixplus.sii.objects.Cgg_tct_adjunto_csv inCgg_tct_adjunto_csv){
		this.myCgg_tct_adjunto_csv = inCgg_tct_adjunto_csv;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_adjunto_csv.
	* @return Cgg_tct_adjunto_csv OBJETO Cgg_tct_adjunto_csv.
	*/
	public com.besixplus.sii.objects.Cgg_tct_adjunto_csv getCgg_tct_adjunto_csv(){
		return this.myCgg_tct_adjunto_csv;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_tct_adjunto_csv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_INSERT(?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_tct_adjunto_csv().getCTADC_CODIGO());
			stmInsert.setString(3, this.getCgg_tct_adjunto_csv().getCTADC_NOMBRE_ADJUNTO());
			stmInsert.setString(4, this.getCgg_tct_adjunto_csv().getCTADC_DESCRIPCION_ADJUNTO());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_tct_adjunto_csv().getCTADC_FECHA_REGISTRO().getTime()));
			stmInsert.setBytes(6, this.getCgg_tct_adjunto_csv().getCTADC_ADJUNTO());
			stmInsert.setBoolean(7, this.getCgg_tct_adjunto_csv().getCTADC_ESTADO());
			stmInsert.setString(8, this.getCgg_tct_adjunto_csv().getCTADC_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_tct_adjunto_csv().setCTADC_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_adjunto_csv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> outCgg_tct_adjunto_csv = new ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_adjunto_csv tmpCgg_tct_adjunto_csv = new com.besixplus.sii.objects.Cgg_tct_adjunto_csv();
				tmpCgg_tct_adjunto_csv.setCTADC_CODIGO(results.getString(1));
				tmpCgg_tct_adjunto_csv.setCTADC_NOMBRE_ADJUNTO(results.getString(2));
				tmpCgg_tct_adjunto_csv.setCTADC_DESCRIPCION_ADJUNTO(results.getString(3));
				tmpCgg_tct_adjunto_csv.setCTADC_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_tct_adjunto_csv.setCTADC_ADJUNTO(results.getBytes(5));
				tmpCgg_tct_adjunto_csv.setCTADC_ESTADO(results.getBoolean(6));
				outCgg_tct_adjunto_csv.add(tmpCgg_tct_adjunto_csv);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_adjunto_csv;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_adjunto_csv QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> outCgg_tct_adjunto_csv = new ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_tct_adjunto_csv tmpCgg_tct_adjunto_csv = new com.besixplus.sii.objects.Cgg_tct_adjunto_csv();
				tmpCgg_tct_adjunto_csv.setCTADC_CODIGO(results.getString(1));
				tmpCgg_tct_adjunto_csv.setCTADC_NOMBRE_ADJUNTO(results.getString(2));
				tmpCgg_tct_adjunto_csv.setCTADC_DESCRIPCION_ADJUNTO(results.getString(3));
				tmpCgg_tct_adjunto_csv.setCTADC_FECHA_REGISTRO(results.getTimestamp(4));
				tmpCgg_tct_adjunto_csv.setCTADC_ADJUNTO(results.getBytes(5));
				tmpCgg_tct_adjunto_csv.setCTADC_ESTADO(results.getBoolean(6));
				outCgg_tct_adjunto_csv.add(tmpCgg_tct_adjunto_csv);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_adjunto_csv;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_adjunto_csv QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_adjunto_csv> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_tct_adjunto_csv = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_SELECT(?,?,?,?,?,?) }");
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
				outCgg_tct_adjunto_csv.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_adjunto_csv;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_tct_adjunto_csv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_COUNT(?) }");
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
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_tct_adjunto_csv.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_TCT_ADJUNTO_CSV_UPDATE(?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_tct_adjunto_csv().getCTADC_CODIGO());
			stmUpdate.setString(2, this.getCgg_tct_adjunto_csv().getCTADC_NOMBRE_ADJUNTO());
			stmUpdate.setString(3, this.getCgg_tct_adjunto_csv().getCTADC_DESCRIPCION_ADJUNTO());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_tct_adjunto_csv().getCTADC_FECHA_REGISTRO().getTime()));
			stmUpdate.setBytes(5, this.getCgg_tct_adjunto_csv().getCTADC_ADJUNTO());
			stmUpdate.setBoolean(6, this.getCgg_tct_adjunto_csv().getCTADC_ESTADO());
			stmUpdate.setString(7, this.getCgg_tct_adjunto_csv().getCTADC_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_tct_adjunto_csv DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_tct_adjunto_csv OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_tct_adjunto_csv select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ADJUNTO_CSV_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_tct_adjunto_csv().getCTADC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_tct_adjunto_csv().setCTADC_CODIGO(results.getString(1));
				this.getCgg_tct_adjunto_csv().setCTADC_NOMBRE_ADJUNTO(results.getString(2));
				this.getCgg_tct_adjunto_csv().setCTADC_DESCRIPCION_ADJUNTO(results.getString(3));
				this.getCgg_tct_adjunto_csv().setCTADC_FECHA_REGISTRO(results.getTimestamp(4));
				this.getCgg_tct_adjunto_csv().setCTADC_ADJUNTO(results.getBytes(5));
				this.getCgg_tct_adjunto_csv().setCTADC_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_tct_adjunto_csv();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_tct_adjunto_csv DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_ADJUNTO_CSV_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_tct_adjunto_csv().getCTADC_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_TCT_ADJUNTO_CSV_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_tct_adjunto_csv().getCTADC_CODIGO());
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