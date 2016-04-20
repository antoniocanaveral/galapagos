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
* CLASE Cgg_gem_entrevista
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_entrevista.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_entrevista implements Serializable{
	private static final long serialVersionUID = 2142422100;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_entrevista.
	*/
	private com.besixplus.sii.objects.Cgg_gem_entrevista myCgg_gem_entrevista = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_entrevista.
	*/
	public Cgg_gem_entrevista(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_entrevista.
	* @param inCgg_gem_entrevista OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_entrevista.
	*/
	public Cgg_gem_entrevista(
		com.besixplus.sii.objects.Cgg_gem_entrevista inCgg_gem_entrevista
	){
		this.setCgg_gem_entrevista(inCgg_gem_entrevista);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_entrevista.
	* @param inCgg_gem_entrevista OBJETO Cgg_gem_entrevista.
	* @return void
	*/
	public void setCgg_gem_entrevista(com.besixplus.sii.objects.Cgg_gem_entrevista inCgg_gem_entrevista){
		this.myCgg_gem_entrevista = inCgg_gem_entrevista;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_entrevista.
	* @return Cgg_gem_entrevista OBJETO Cgg_gem_entrevista.
	*/
	public com.besixplus.sii.objects.Cgg_gem_entrevista getCgg_gem_entrevista(){
		return this.myCgg_gem_entrevista;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_entrevista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_ENTREVISTA_INSERT(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_entrevista().getCGENT_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_entrevista().getCGCND_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_entrevista().getCGENT_ESTADO_ENTREVISTA());
			stmInsert.setTimestamp(5, new java.sql.Timestamp(this.getCgg_gem_entrevista().getCGENT_FECHA_REALIZACION().getTime()));
			stmInsert.setString(6, this.getCgg_gem_entrevista().getCGENT_LUGAR());
			stmInsert.setString(7, this.getCgg_gem_entrevista().getCGENT_OBSERVACION());
			stmInsert.setBoolean(8, this.getCgg_gem_entrevista().getCGENT_ESTADO());
			stmInsert.setString(9, this.getCgg_gem_entrevista().getCGENT_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_entrevista().setCGENT_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_entrevista QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_entrevista> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		String inCgvcn_codigo
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_entrevista = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_ENTREVISTA_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setString(8, inCgvcn_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_entrevista.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_entrevista;
	}	

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE.
	* @return NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		String inCgvcn_codigo
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword ="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_ENTREVISTA_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setString(3, inCgvcn_codigo);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_entrevista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_ENTREVISTA_UPDATE(?, ?, ?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_entrevista().getCGENT_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_entrevista().getCGCND_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_entrevista().getCGENT_ESTADO_ENTREVISTA());
			stmUpdate.setTimestamp(4, new java.sql.Timestamp(this.getCgg_gem_entrevista().getCGENT_FECHA_REALIZACION().getTime()));
			stmUpdate.setString(5, this.getCgg_gem_entrevista().getCGENT_LUGAR());
			stmUpdate.setString(6, this.getCgg_gem_entrevista().getCGENT_OBSERVACION());
			stmUpdate.setBoolean(7, this.getCgg_gem_entrevista().getCGENT_ESTADO());
			stmUpdate.setString(8, this.getCgg_gem_entrevista().getCGENT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_entrevista.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String registrarCriterioTecnico(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_ENTREVISTA_CRITERIO(?, ?, ?, ?,?) }");
			stmUpdate.setString(1, this.getCgg_gem_entrevista().getCGENT_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_entrevista().getCGENT_CRITERIO_TECNICO());
			stmUpdate.setTimestamp(3, new java.sql.Timestamp(this.getCgg_gem_entrevista().getCGENT_FECHA_CRITERIO_TECNICO().getTime()));
			stmUpdate.setBoolean(4, this.getCgg_gem_entrevista().getCGENT_ESTADO());
			stmUpdate.setString(5, this.getCgg_gem_entrevista().getCGENT_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_entrevista DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_ENTREVISTA_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_entrevista().getCGENT_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_ENTREVISTA_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_entrevista().getCGENT_CODIGO());
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