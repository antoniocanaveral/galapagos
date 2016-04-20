package com.besixplus.sii.db;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_dhu_institucion_responsable
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_institucion_responsable.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_dhu_institucion_responsable implements Serializable{
	private static final long serialVersionUID = 413520907;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_dhu_institucion_responsable.
	*/
	private com.besixplus.sii.objects.Cgg_dhu_institucion_responsable myCgg_dhu_institucion_responsable = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_institucion_responsable.
	*/
	public Cgg_dhu_institucion_responsable(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_institucion_responsable.
	* @param inCgg_dhu_institucion_responsable OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_dhu_institucion_responsable.
	*/
	public Cgg_dhu_institucion_responsable(
		com.besixplus.sii.objects.Cgg_dhu_institucion_responsable inCgg_dhu_institucion_responsable
	){
		this.setCgg_dhu_institucion_responsable(inCgg_dhu_institucion_responsable);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_dhu_institucion_responsable.
	* @param inCgg_dhu_institucion_responsable OBJETO Cgg_dhu_institucion_responsable.
	* @return void
	*/
	public void setCgg_dhu_institucion_responsable(com.besixplus.sii.objects.Cgg_dhu_institucion_responsable inCgg_dhu_institucion_responsable){
		this.myCgg_dhu_institucion_responsable = inCgg_dhu_institucion_responsable;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_dhu_institucion_responsable.
	* @return Cgg_dhu_institucion_responsable OBJETO Cgg_dhu_institucion_responsable.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_institucion_responsable getCgg_dhu_institucion_responsable(){
		return this.myCgg_dhu_institucion_responsable;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_institucion_responsable.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean insert(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_dhu_institucion_responsable().getCDITR_CODIGO());
			stmInsert.setString(3, this.getCgg_dhu_institucion_responsable().getCDITR_NOMBRE());
			stmInsert.setString(4, this.getCgg_dhu_institucion_responsable().getCDITR_DESCRIPCION());
			stmInsert.setBoolean(5, this.getCgg_dhu_institucion_responsable().getCDITR_ESTADO());
			stmInsert.setString(6, this.getCgg_dhu_institucion_responsable().getCDITR_USUARIO_INSERT());
			stmInsert.setString(7, this.getCgg_dhu_institucion_responsable().getCDITR_USUARIO_UPDATE());
			stmInsert.execute();
			this.getCgg_dhu_institucion_responsable().setCDITR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_institucion_responsable.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable> outCgg_dhu_institucion_responsable = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_dhu_institucion_responsable tmpCgg_dhu_institucion_responsable = new com.besixplus.sii.objects.Cgg_dhu_institucion_responsable();
				tmpCgg_dhu_institucion_responsable.setCDITR_CODIGO(results.getString(1));
				tmpCgg_dhu_institucion_responsable.setCDITR_NOMBRE(results.getString(2));
				tmpCgg_dhu_institucion_responsable.setCDITR_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_institucion_responsable.setCDITR_ESTADO(results.getBoolean(4));
				outCgg_dhu_institucion_responsable.add(tmpCgg_dhu_institucion_responsable);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_institucion_responsable;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_institucion_responsable QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable> outCgg_dhu_institucion_responsable = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_institucion_responsable>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_SELECT(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_dhu_institucion_responsable tmpCgg_dhu_institucion_responsable = new com.besixplus.sii.objects.Cgg_dhu_institucion_responsable();
				tmpCgg_dhu_institucion_responsable.setCDITR_CODIGO(results.getString(1));
				tmpCgg_dhu_institucion_responsable.setCDITR_NOMBRE(results.getString(2));
				tmpCgg_dhu_institucion_responsable.setCDITR_DESCRIPCION(results.getString(3));
				tmpCgg_dhu_institucion_responsable.setCDITR_ESTADO(results.getBoolean(4));
				outCgg_dhu_institucion_responsable.add(tmpCgg_dhu_institucion_responsable);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_dhu_institucion_responsable;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_dhu_institucion_responsable.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_COUNT() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_COUNT(?) }");
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
	/* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_dhu_institucion_responsable.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean update(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_UPDATE(?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_dhu_institucion_responsable().getCDITR_CODIGO());
			stmUpdate.setString(2, this.getCgg_dhu_institucion_responsable().getCDITR_NOMBRE());
			stmUpdate.setString(3, this.getCgg_dhu_institucion_responsable().getCDITR_DESCRIPCION());
			stmUpdate.setBoolean(4, this.getCgg_dhu_institucion_responsable().getCDITR_ESTADO());
			stmUpdate.setString(5, this.getCgg_dhu_institucion_responsable().getCDITR_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_dhu_institucion_responsable DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_dhu_institucion_responsable OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_dhu_institucion_responsable select(
		java.sql.Connection inConnection
	){
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_dhu_institucion_responsable().getCDITR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				this.getCgg_dhu_institucion_responsable().setCDITR_CODIGO(results.getString(1));
				this.getCgg_dhu_institucion_responsable().setCDITR_NOMBRE(results.getString(2));
				this.getCgg_dhu_institucion_responsable().setCDITR_DESCRIPCION(results.getString(3));
				this.getCgg_dhu_institucion_responsable().setCDITR_ESTADO(results.getBoolean(4));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return this.getCgg_dhu_institucion_responsable();
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_dhu_institucion_responsable DE ACUERDO A LA CLAVE PRIMARIA.
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
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_dhu_institucion_responsable().getCDITR_CODIGO());
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
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_DHU_INSTITUCION_RESPONSABLE_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_dhu_institucion_responsable().getCDITR_CODIGO());
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