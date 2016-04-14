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
* CLASE Cgg_kdx_tipo_pago
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_tipo_pago.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_kdx_tipo_pago implements Serializable{
	private static final long serialVersionUID = 204790405;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_kdx_tipo_pago.
	*/
	private com.besixplus.sii.objects.Cgg_kdx_tipo_pago myCgg_kdx_tipo_pago = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_tipo_pago.
	*/
	public Cgg_kdx_tipo_pago(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_tipo_pago.
	* @param inCgg_kdx_tipo_pago OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_kdx_tipo_pago.
	*/
	public Cgg_kdx_tipo_pago(
		com.besixplus.sii.objects.Cgg_kdx_tipo_pago inCgg_kdx_tipo_pago
	){
		this.setCgg_kdx_tipo_pago(inCgg_kdx_tipo_pago);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_kdx_tipo_pago.
	* @param inCgg_kdx_tipo_pago OBJETO Cgg_kdx_tipo_pago.
	* @return void
	*/
	public void setCgg_kdx_tipo_pago(com.besixplus.sii.objects.Cgg_kdx_tipo_pago inCgg_kdx_tipo_pago){
		this.myCgg_kdx_tipo_pago = inCgg_kdx_tipo_pago;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_kdx_tipo_pago.
	* @return Cgg_kdx_tipo_pago OBJETO Cgg_kdx_tipo_pago.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_tipo_pago getCgg_kdx_tipo_pago(){
		return this.myCgg_kdx_tipo_pago;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_tipo_pago.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_INSERT(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_kdx_tipo_pago().getCKTPG_CODIGO());
			stmInsert.setString(3, this.getCgg_kdx_tipo_pago().getCKTPG_DESCRIPCION());
			stmInsert.setString(4, this.getCgg_kdx_tipo_pago().getCKTPG_OBSERVACION());
			stmInsert.setBoolean(5, this.getCgg_kdx_tipo_pago().getCKTPG_ESTADO());
			stmInsert.setString(6, this.getCgg_kdx_tipo_pago().getCKTPG_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_kdx_tipo_pago().setCKTPG_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_tipo_pago.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> outCgg_kdx_tipo_pago = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_kdx_tipo_pago tmpCgg_kdx_tipo_pago = new com.besixplus.sii.objects.Cgg_kdx_tipo_pago();
				tmpCgg_kdx_tipo_pago.setCKTPG_CODIGO(results.getString(1));
				tmpCgg_kdx_tipo_pago.setCKTPG_DESCRIPCION(results.getString(2));
				tmpCgg_kdx_tipo_pago.setCKTPG_OBSERVACION(results.getString(3));
				tmpCgg_kdx_tipo_pago.setCKTPG_ESTADO(results.getBoolean(4));
				outCgg_kdx_tipo_pago.add(tmpCgg_kdx_tipo_pago);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_tipo_pago;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_tipo_pago QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> outCgg_kdx_tipo_pago = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_kdx_tipo_pago tmpCgg_kdx_tipo_pago = new com.besixplus.sii.objects.Cgg_kdx_tipo_pago();
				tmpCgg_kdx_tipo_pago.setCKTPG_CODIGO(results.getString(1));
				tmpCgg_kdx_tipo_pago.setCKTPG_DESCRIPCION(results.getString(2));
				tmpCgg_kdx_tipo_pago.setCKTPG_OBSERVACION(results.getString(3));
				tmpCgg_kdx_tipo_pago.setCKTPG_ESTADO(results.getBoolean(4));
				outCgg_kdx_tipo_pago.add(tmpCgg_kdx_tipo_pago);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_tipo_pago;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_tipo_pago QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_kdx_tipo_pago> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_kdx_tipo_pago = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_kdx_tipo_pago.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_kdx_tipo_pago;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_kdx_tipo_pago.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_kdx_tipo_pago.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_KDX_TIPO_PAGO_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_kdx_tipo_pago().getCKTPG_CODIGO());
			stmUpdate.setString(2, this.getCgg_kdx_tipo_pago().getCKTPG_DESCRIPCION());
			stmUpdate.setString(3, this.getCgg_kdx_tipo_pago().getCKTPG_OBSERVACION());
			stmUpdate.setBoolean(4, this.getCgg_kdx_tipo_pago().getCKTPG_ESTADO());
			stmUpdate.setString(5, this.getCgg_kdx_tipo_pago().getCKTPG_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_kdx_tipo_pago DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_kdx_tipo_pago OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_kdx_tipo_pago select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_KDX_TIPO_PAGO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_kdx_tipo_pago().getCKTPG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_kdx_tipo_pago().setCKTPG_CODIGO(results.getString(1));
				this.getCgg_kdx_tipo_pago().setCKTPG_DESCRIPCION(results.getString(2));
				this.getCgg_kdx_tipo_pago().setCKTPG_OBSERVACION(results.getString(3));
				this.getCgg_kdx_tipo_pago().setCKTPG_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_kdx_tipo_pago();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_kdx_tipo_pago DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TIPO_PAGO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_kdx_tipo_pago().getCKTPG_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_KDX_TIPO_PAGO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_kdx_tipo_pago().getCKTPG_CODIGO());
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