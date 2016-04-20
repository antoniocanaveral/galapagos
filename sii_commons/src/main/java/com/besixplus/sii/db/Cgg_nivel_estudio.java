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
* CLASE Cgg_nivel_estudio
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_nivel_estudio.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_nivel_estudio implements Serializable{
	private static final long serialVersionUID = 224674231;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_nivel_estudio.
	*/
	private com.besixplus.sii.objects.Cgg_nivel_estudio myCgg_nivel_estudio = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_nivel_estudio.
	*/
	public Cgg_nivel_estudio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_nivel_estudio.
	* @param inCgg_nivel_estudio OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_nivel_estudio.
	*/
	public Cgg_nivel_estudio(
		com.besixplus.sii.objects.Cgg_nivel_estudio inCgg_nivel_estudio
	){
		this.setCgg_nivel_estudio(inCgg_nivel_estudio);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_nivel_estudio.
	* @param inCgg_nivel_estudio OBJETO Cgg_nivel_estudio.
	* @return void
	*/
	public void setCgg_nivel_estudio(com.besixplus.sii.objects.Cgg_nivel_estudio inCgg_nivel_estudio){
		this.myCgg_nivel_estudio = inCgg_nivel_estudio;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_nivel_estudio.
	* @return Cgg_nivel_estudio OBJETO Cgg_nivel_estudio.
	*/
	public com.besixplus.sii.objects.Cgg_nivel_estudio getCgg_nivel_estudio(){
		return this.myCgg_nivel_estudio;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_INSERT(?, ?, ?::smallint, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_nivel_estudio().getCGNES_CODIGO());
			stmInsert.setString(3, this.getCgg_nivel_estudio().getCGNES_DESCRIPCION());
			stmInsert.setInt(4, this.getCgg_nivel_estudio().getCGNES_GRADO());
			stmInsert.setBoolean(5, this.getCgg_nivel_estudio().getCGNES_ESTADO());
			stmInsert.setString(6, this.getCgg_nivel_estudio().getCGNES_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_nivel_estudio().getCGNES_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_nivel_estudio().setCGNES_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> outCgg_nivel_estudio = new ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_nivel_estudio tmpCgg_nivel_estudio = new com.besixplus.sii.objects.Cgg_nivel_estudio();
				tmpCgg_nivel_estudio.setCGNES_CODIGO(results.getString(1));
				tmpCgg_nivel_estudio.setCGNES_DESCRIPCION(results.getString(2));
				tmpCgg_nivel_estudio.setCGNES_GRADO(results.getInt(3));
				tmpCgg_nivel_estudio.setCGNES_ESTADO(results.getBoolean(4));
				outCgg_nivel_estudio.add(tmpCgg_nivel_estudio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_nivel_estudio;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_nivel_estudio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> outCgg_nivel_estudio = new ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_nivel_estudio tmpCgg_nivel_estudio = new com.besixplus.sii.objects.Cgg_nivel_estudio();
				tmpCgg_nivel_estudio.setCGNES_CODIGO(results.getString(1));
				tmpCgg_nivel_estudio.setCGNES_DESCRIPCION(results.getString(2));
				tmpCgg_nivel_estudio.setCGNES_GRADO(results.getInt(3));
				tmpCgg_nivel_estudio.setCGNES_ESTADO(results.getBoolean(4));
				outCgg_nivel_estudio.add(tmpCgg_nivel_estudio);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_nivel_estudio;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_nivel_estudio QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_nivel_estudio> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_nivel_estudio = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_SELECT(?,?,?,?,?,?) }");
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
				outCgg_nivel_estudio.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_nivel_estudio;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_nivel_estudio.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_NIVEL_ESTUDIO_UPDATE(?, ?, ?::smallint, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_nivel_estudio().getCGNES_CODIGO());
			stmUpdate.setString(2, this.getCgg_nivel_estudio().getCGNES_DESCRIPCION());
			stmUpdate.setInt(3, this.getCgg_nivel_estudio().getCGNES_GRADO());
			stmUpdate.setBoolean(4, this.getCgg_nivel_estudio().getCGNES_ESTADO());
			stmUpdate.setString(5, this.getCgg_nivel_estudio().getCGNES_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_nivel_estudio DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_nivel_estudio OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_nivel_estudio select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_NIVEL_ESTUDIO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_nivel_estudio().getCGNES_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_nivel_estudio().setCGNES_CODIGO(results.getString(1));
				this.getCgg_nivel_estudio().setCGNES_DESCRIPCION(results.getString(2));
				this.getCgg_nivel_estudio().setCGNES_GRADO(results.getInt(3));
				this.getCgg_nivel_estudio().setCGNES_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_nivel_estudio();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_nivel_estudio DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_NIVEL_ESTUDIO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_nivel_estudio().getCGNES_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_NIVEL_ESTUDIO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_nivel_estudio().getCGNES_CODIGO());
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