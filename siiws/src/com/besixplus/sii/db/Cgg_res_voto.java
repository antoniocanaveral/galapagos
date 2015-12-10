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
 * CLASE Cgg_res_voto
 * ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_voto.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_res_voto implements Serializable{
	private static final long serialVersionUID = 1837835528;
	/**
	 * VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_voto.
	 */
	private com.besixplus.sii.objects.Cgg_res_voto myCgg_res_voto = null;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_voto.
	 */
	public Cgg_res_voto(){}
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_voto.
	 * @param inCgg_res_voto OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_voto.
	 */
	public Cgg_res_voto(
			com.besixplus.sii.objects.Cgg_res_voto inCgg_res_voto
	){
		this.setCgg_res_voto(inCgg_res_voto);
	}

	/**
	 * ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_voto.
	 * @param inCgg_res_voto OBJETO Cgg_res_voto.
	 * @return void
	 */
	public void setCgg_res_voto(com.besixplus.sii.objects.Cgg_res_voto inCgg_res_voto){
		this.myCgg_res_voto = inCgg_res_voto;
	}
	/**
	 * OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_voto.
	 * @return Cgg_res_voto OBJETO Cgg_res_voto.
	 */
	public com.besixplus.sii.objects.Cgg_res_voto getCgg_res_voto(){
		return this.myCgg_res_voto;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_voto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SQLException 
	 */
	public String insert(
			java.sql.Connection inConnection
	) throws SQLException{
		String outResult = "true";

		CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_INSERT(?, ?, ?, ?::smallint, ?, ?, ?, ?) }");
		stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
		stmInsert.setString(2, this.getCgg_res_voto().getCRVTO_CODIGO());
		stmInsert.setString(3, this.getCgg_res_voto().getCRSMB_CODIGO());
		stmInsert.setString(4, this.getCgg_res_voto().getCRRES_CODIGO());
		stmInsert.setInt(5, this.getCgg_res_voto().getCRVTO_VOTACION());
		stmInsert.setString(6, this.getCgg_res_voto().getCRVTO_OBSERVACION());
		stmInsert.setBoolean(7, this.getCgg_res_voto().getCRVTO_ESTADO());
		stmInsert.setString(8, this.getCgg_res_voto().getCRVTO_USUARIO_INSERT());
		stmInsert.setString(9, this.getCgg_res_voto().getCRVTO_USUARIO_UPDATE());
		stmInsert.execute();
		this.getCgg_res_voto().setCRVTO_CODIGO(stmInsert.getString(1));
		stmInsert.close();

		return outResult;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_voto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_voto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_voto> selectAll(
			java.sql.Connection inConnection,
			String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_voto> outCgg_res_voto = new ArrayList<com.besixplus.sii.objects.Cgg_res_voto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_voto tmpCgg_res_voto = new com.besixplus.sii.objects.Cgg_res_voto();
				tmpCgg_res_voto.setCRVTO_CODIGO(results.getString(1));
				tmpCgg_res_voto.setCRSMB_CODIGO(results.getString(2));
				tmpCgg_res_voto.setCRRES_CODIGO(results.getString(3));
				tmpCgg_res_voto.setCRVTO_VOTACION(results.getInt(4));
				tmpCgg_res_voto.setCRVTO_OBSERVACION(results.getString(5));
				tmpCgg_res_voto.setCRVTO_ESTADO(results.getBoolean(6));
				outCgg_res_voto.add(tmpCgg_res_voto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_voto;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_voto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_voto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_voto> selectAll(
			java.sql.Connection inConnection,
			String inUserName,
			int inStart,
			int inLimit,
			String inSortFieldName,
			String inDirection,
			String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_voto> outCgg_res_voto = new ArrayList<com.besixplus.sii.objects.Cgg_res_voto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_voto tmpCgg_res_voto = new com.besixplus.sii.objects.Cgg_res_voto();
				tmpCgg_res_voto.setCRVTO_CODIGO(results.getString(1));
				tmpCgg_res_voto.setCRSMB_CODIGO(results.getString(2));
				tmpCgg_res_voto.setCRRES_CODIGO(results.getString(3));
				tmpCgg_res_voto.setCRVTO_VOTACION(results.getInt(4));
				tmpCgg_res_voto.setCRVTO_OBSERVACION(results.getString(5));
				tmpCgg_res_voto.setCRVTO_ESTADO(results.getBoolean(6));
				outCgg_res_voto.add(tmpCgg_res_voto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_voto;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_voto QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	 * @param inStart INDICE DE INICIO.
	 * @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	 * @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	 * @param inKeyword CRITERIO DE BUSQUEDA
	 * @return ArrayList<com.besixplus.sii.objects.Cgg_res_voto> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_res_voto = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_res_voto.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_voto;
	}

	/**
	 * CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res_voto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return int TOTAL DE REGISTROS.
	 */
	public static int selectCount(
			java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_res_voto.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	public String update(
			java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_UPDATE(?, ?, ?, ?::smallint, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_res_voto().getCRVTO_CODIGO());
			stmUpdate.setString(2, this.getCgg_res_voto().getCRSMB_CODIGO());
			stmUpdate.setString(3, this.getCgg_res_voto().getCRRES_CODIGO());
			stmUpdate.setInt(4, this.getCgg_res_voto().getCRVTO_VOTACION());
			stmUpdate.setString(5, this.getCgg_res_voto().getCRVTO_OBSERVACION());
			stmUpdate.setBoolean(6, this.getCgg_res_voto().getCRVTO_ESTADO());
			stmUpdate.setString(7, this.getCgg_res_voto().getCRVTO_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	 * SELECCIONA UN REGISTRO DE LA TABLA Cgg_res_voto DE ACUERDO A LA CLAVE PRIMARIA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_voto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public com.besixplus.sii.objects.Cgg_res_voto select(
			java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_voto().getCRVTO_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_res_voto().setCRVTO_CODIGO(results.getString(1));
				this.getCgg_res_voto().setCRSMB_CODIGO(results.getString(2));
				this.getCgg_res_voto().setCRRES_CODIGO(results.getString(3));
				this.getCgg_res_voto().setCRVTO_VOTACION(results.getInt(4));
				this.getCgg_res_voto().setCRVTO_OBSERVACION(results.getString(5));
				this.getCgg_res_voto().setCRVTO_ESTADO(results.getBoolean(6));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_res_voto();
	}

	/**
	 * ELIMINA UN REGISTRO DE LA TABLA Cgg_res_voto DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_res_voto().getCRVTO_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_res_voto().getCRVTO_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_voto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_voto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_voto> selectCGG_RES_RESOLUCION(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_voto> outCgg_res_voto = new ArrayList<com.besixplus.sii.objects.Cgg_res_voto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_S_CGG_RES_RESOLUCION(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_voto().getCRRES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_voto tmpCgg_res_voto = new com.besixplus.sii.objects.Cgg_res_voto();
				tmpCgg_res_voto.setCRVTO_CODIGO(results.getString(1));
				tmpCgg_res_voto.setCRSMB_CODIGO(results.getString(2));
				tmpCgg_res_voto.setCRRES_CODIGO(results.getString(3));
				tmpCgg_res_voto.setCRVTO_VOTACION(results.getInt(4));
				tmpCgg_res_voto.setCRVTO_OBSERVACION(results.getString(5));
				tmpCgg_res_voto.setCRVTO_ESTADO(results.getBoolean(6));
				outCgg_res_voto.add(tmpCgg_res_voto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_voto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_voto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_resolucion.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_RESOLUCION(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_D_CGG_RES_RESOLUCION(?) }");
			stmDelete.setString(1, this.getCgg_res_voto().getCRRES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_DS_CGG_RES_RESOLUCION(?) }");
				stmDelete.setString(1, this.getCgg_res_voto().getCRRES_CODIGO());
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
	 * SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_voto DE ACUERDO
	 * A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_miembro.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return com.besixplus.sii.objects.Cgg_res_voto OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_voto> selectCGG_RES_SESION_MIEMBRO(
			java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_voto> outCgg_res_voto = new ArrayList<com.besixplus.sii.objects.Cgg_res_voto>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_VOTO_S_CGG_RES_SESION_MIEMBRO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_res_voto().getCRSMB_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_res_voto tmpCgg_res_voto = new com.besixplus.sii.objects.Cgg_res_voto();
				tmpCgg_res_voto.setCRVTO_CODIGO(results.getString(1));
				tmpCgg_res_voto.setCRSMB_CODIGO(results.getString(2));
				tmpCgg_res_voto.setCRRES_CODIGO(results.getString(3));
				tmpCgg_res_voto.setCRVTO_VOTACION(results.getInt(4));
				tmpCgg_res_voto.setCRVTO_OBSERVACION(results.getString(5));
				tmpCgg_res_voto.setCRVTO_ESTADO(results.getBoolean(6));
				outCgg_res_voto.add(tmpCgg_res_voto);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_voto;
	}

	/**
	 * ELIMINA LOS REGISTROS DE LA TABLA Cgg_res_voto DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_sesion_miembro.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	 */
	public boolean deleteCGG_RES_SESION_MIEMBRO(
			java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_D_CGG_RES_SESION_MIEMBRO(?) }");
			stmDelete.setString(1, this.getCgg_res_voto().getCRSMB_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_RES_VOTO_DS_CGG_RES_SESION_MIEMBRO(?) }");
				stmDelete.setString(1, this.getCgg_res_voto().getCRSMB_CODIGO());
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