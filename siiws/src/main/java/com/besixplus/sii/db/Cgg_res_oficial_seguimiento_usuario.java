package com.besixplus.sii.db;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
* CLASE Cgg_res_oficial_seguimiento_usuario
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_oficial_seguimiento u Cgg_usuario.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_res_oficial_seguimiento_usuario {
	private static final long serialVersionUID = 80458565;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_res_oficial_seguimiento.
	*/
	private com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario myCgg_res_oficial_seguimiento_usuario = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_seguimiento.
	*/
	public Cgg_res_oficial_seguimiento_usuario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_seguimiento.
	* @param inCgg_res_oficial_seguimiento_usuario IDENTIFICADOR UNICO DEL USUARIO OFICIAL SEGUIMIENTO
	* @param inCgg_res_oficial_seguimiento OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_res_oficial_seguimiento.
	*/
	public Cgg_res_oficial_seguimiento_usuario(
		com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario inCgg_res_oficial_seguimiento_usuario
	){
		this.setCgg_res_oficial_seguimiento_usuario(inCgg_res_oficial_seguimiento_usuario);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_res_oficial_seguimiento.
	* @param inCgg_res_oficial_seguimiento_usuario IDENTIFICATIVO UNICO DE USUARIO OFICIAL SEGUIMIENTO.
	* @param inCgg_res_oficial_seguimiento OBJETO Cgg_res_oficial_seguimiento.
	* @return void
	*/
	public void setCgg_res_oficial_seguimiento_usuario(com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario inCgg_res_oficial_seguimiento_usuario){
		this.myCgg_res_oficial_seguimiento_usuario = inCgg_res_oficial_seguimiento_usuario;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_res_oficial_seguimiento.
	* @return Cgg_res_oficial_seguimiento OBJETO Cgg_res_oficial_seguimiento.
	*/
	public com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario getCgg_res_oficial_seguimiento_usuario(){
		return this.myCgg_res_oficial_seguimiento_usuario;
	}
	
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DEL ORDENAMIENTO.
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_usuario> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario> selectAll(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword
	){
		ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario> outCgg_res_oficial_seguimiento_usuario = new ArrayList<com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_oficial_seguimiento_usuario(?,?,?,?,?,?) }");
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
				com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario tmpCgg_res_oficial_seguimiento_usuario = new com.besixplus.sii.objects.Cgg_res_oficial_seguimiento_usuario();
				tmpCgg_res_oficial_seguimiento_usuario.setCROSG_CODIGO(results.getString(1));
				tmpCgg_res_oficial_seguimiento_usuario.setCUSU_CODIGO(results.getString(2));
				tmpCgg_res_oficial_seguimiento_usuario.setCUSU_NOMBRES(results.getString(3));
				tmpCgg_res_oficial_seguimiento_usuario.setCUSU_APELLIDOS(results.getString(4));
    			outCgg_res_oficial_seguimiento_usuario.add(tmpCgg_res_oficial_seguimiento_usuario);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_res_oficial_seguimiento_usuario;
	}
	
	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_res_oficial_seguimiento_usuario_count() }");
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
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call f_cgg_res_oficial_seguimiento_usuario_count(?) }");
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
	
}
