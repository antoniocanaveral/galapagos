package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_gem_personaj_areaf
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_personaj_areaf.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_personaj_areaf implements Serializable{
	private static final long serialVersionUID = 1087073739;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_personaj_areaf.
	*/
	private com.besixplus.sii.objects.Cgg_gem_personaj_areaf myCgg_gem_personaj_areaf = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_personaj_areaf.
	*/
	public Cgg_gem_personaj_areaf(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_personaj_areaf.
	* @param inCgg_gem_personaj_areaf OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_personaj_areaf.
	*/
	public Cgg_gem_personaj_areaf(
		com.besixplus.sii.objects.Cgg_gem_personaj_areaf inCgg_gem_personaj_areaf
	){
		this.setCgg_gem_personaj_areaf(inCgg_gem_personaj_areaf);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_personaj_areaf.
	* @param inCgg_gem_personaj_areaf OBJETO Cgg_gem_personaj_areaf.
	* @return void
	*/
	public void setCgg_gem_personaj_areaf(com.besixplus.sii.objects.Cgg_gem_personaj_areaf inCgg_gem_personaj_areaf){
		this.myCgg_gem_personaj_areaf = inCgg_gem_personaj_areaf;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_personaj_areaf.
	* @return Cgg_gem_personaj_areaf OBJETO Cgg_gem_personaj_areaf.
	*/
	public com.besixplus.sii.objects.Cgg_gem_personaj_areaf getCgg_gem_personaj_areaf(){
		return this.myCgg_gem_personaj_areaf;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_personaj_areaf.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_personaj_areaf().getCGPJA_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_gem_personaj_areaf().getCGPJA_ESTADO());
			stmInsert.setString(6, this.getCgg_gem_personaj_areaf().getCGPJA_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_gem_personaj_areaf().getCGPJA_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_gem_personaj_areaf().setCGPJA_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_personaj_areaf.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> outCgg_gem_personaj_areaf = new ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_personaj_areaf tmpCgg_gem_personaj_areaf = new com.besixplus.sii.objects.Cgg_gem_personaj_areaf();
				tmpCgg_gem_personaj_areaf.setCGPJA_CODIGO(results.getString(1));
				tmpCgg_gem_personaj_areaf.setCGARE_CODIGO(results.getString(2));
				tmpCgg_gem_personaj_areaf.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_gem_personaj_areaf.setCGPJA_ESTADO(results.getBoolean(4));
				outCgg_gem_personaj_areaf.add(tmpCgg_gem_personaj_areaf);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_personaj_areaf;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_personaj_areaf QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	 * @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> outCgg_gem_personaj_areaf = new ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_gem_personaj_areaf tmpCgg_gem_personaj_areaf = new com.besixplus.sii.objects.Cgg_gem_personaj_areaf();
				tmpCgg_gem_personaj_areaf.setCGPJA_CODIGO(results.getString(1));
				tmpCgg_gem_personaj_areaf.setCGARE_CODIGO(results.getString(2));
				tmpCgg_gem_personaj_areaf.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_gem_personaj_areaf.setCGPJA_ESTADO(results.getBoolean(4));
				outCgg_gem_personaj_areaf.add(tmpCgg_gem_personaj_areaf);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_personaj_areaf;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_gem_personaj_areaf.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_personaj_areaf.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_personaj_areaf().getCGPJA_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
			stmUpdate.setBoolean(4, this.getCgg_gem_personaj_areaf().getCGPJA_ESTADO());
			stmUpdate.setString(5, this.getCgg_gem_personaj_areaf().getCGPJA_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_gem_personaj_areaf DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_personaj_areaf OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_gem_personaj_areaf select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_personaj_areaf().getCGPJA_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_gem_personaj_areaf().setCGPJA_CODIGO(results.getString(1));
				this.getCgg_gem_personaj_areaf().setCGARE_CODIGO(results.getString(2));
				this.getCgg_gem_personaj_areaf().setCRPJR_CODIGO(results.getString(3));
				this.getCgg_gem_personaj_areaf().setCGPJA_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_gem_personaj_areaf();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_personaj_areaf DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_personaj_areaf().getCGPJA_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_gem_personaj_areaf().getCGPJA_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_personaj_areaf DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_area_funcional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_personaj_areaf OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> selectCGG_GEM_AREA_FUNCIONAL(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> outCgg_gem_personaj_areaf = new ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_S_CGG_GEM_AREA_FUNCIONAL(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
			stmSelect.setString(3,this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_personaj_areaf tmpCgg_gem_personaj_areaf = new com.besixplus.sii.objects.Cgg_gem_personaj_areaf();
				tmpCgg_gem_personaj_areaf.setCGPJA_CODIGO(results.getString(1));
				tmpCgg_gem_personaj_areaf.setCGARE_CODIGO(results.getString(2));
				tmpCgg_gem_personaj_areaf.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_gem_personaj_areaf.setCGPJA_ESTADO(results.getBoolean(4));
				outCgg_gem_personaj_areaf.add(tmpCgg_gem_personaj_areaf);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_personaj_areaf;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_personaj_areaf DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_gem_area_funcional.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_GEM_AREA_FUNCIONAL(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_D_CGG_GEM_AREA_FUNCIONAL(?, ?) }");
			stmDelete.setString(1, this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
			stmDelete.setString(2, this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_DS_CGG_GEM_AREA_FUNCIONAL(?, ?) }");
				stmDelete.setString(1, this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
				stmDelete.setString(2, this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_gem_personaj_areaf DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_gem_personaj_areaf OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> selectCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf> outCgg_gem_personaj_areaf = new ArrayList<com.besixplus.sii.objects.Cgg_gem_personaj_areaf>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_PERSONAJ_AREAF_S_CGG_RES_PERSONA_JURIDICA(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
			stmSelect.setString(3,this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_gem_personaj_areaf tmpCgg_gem_personaj_areaf = new com.besixplus.sii.objects.Cgg_gem_personaj_areaf();
				tmpCgg_gem_personaj_areaf.setCGPJA_CODIGO(results.getString(1));
				tmpCgg_gem_personaj_areaf.setCGARE_CODIGO(results.getString(2));
				tmpCgg_gem_personaj_areaf.setCRPJR_CODIGO(results.getString(3));
				tmpCgg_gem_personaj_areaf.setCGPJA_ESTADO(results.getBoolean(4));
				outCgg_gem_personaj_areaf.add(tmpCgg_gem_personaj_areaf);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_personaj_areaf;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_gem_personaj_areaf DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_res_persona_juridica.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_RES_PERSONA_JURIDICA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_D_CGG_RES_PERSONA_JURIDICA(?, ?) }");
			stmDelete.setString(1, this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
			stmDelete.setString(2, this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_PERSONAJ_AREAF_DS_CGG_RES_PERSONA_JURIDICA(?, ?) }");
				stmDelete.setString(1, this.getCgg_gem_personaj_areaf().getCGARE_CODIGO());
				stmDelete.setString(2, this.getCgg_gem_personaj_areaf().getCRPJR_CODIGO());
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