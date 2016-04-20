package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_atc_comunicado_radial
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_vacante.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_atc_comunicado_radial implements Serializable{
	private static final long serialVersionUID = 1787279567;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_vacante.
	*/
	private com.besixplus.sii.objects.Cgg_atc_comunicado_radial myCgg_atc_comunicado_radial = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_atc_comunicado_radial.
	*/
	public Cgg_atc_comunicado_radial(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_atc_comunicado_radial.
	* @param inCgg_atc_comunicado_radial OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_atc_comunicado_radial.
	*/
	public Cgg_atc_comunicado_radial(
		com.besixplus.sii.objects.Cgg_atc_comunicado_radial inCgg_atc_comunicado_radial
	){
		this.setCgg_atc_comunicado_radial(inCgg_atc_comunicado_radial);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_atc_comunicado_radial.
	* @param inCgg_atc_comunicado_radial OBJETO Cgg_atc_comunicado_radial.
	* @return void
	*/
	public void setCgg_atc_comunicado_radial(com.besixplus.sii.objects.Cgg_atc_comunicado_radial inCgg_atc_comunicado_radial){
		this.myCgg_atc_comunicado_radial = inCgg_atc_comunicado_radial;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_atc_comunicado_radial.
	* @return Cgg_atc_comunicado_radial OBJETO Cgg_atc_comunicado_radial.
	*/
	public com.besixplus.sii.objects.Cgg_atc_comunicado_radial getCgg_atc_comunicado_radial(){
		return this.myCgg_atc_comunicado_radial;
	}
	
	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @return outCount NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,		
		String inKeyword		
	){
		int outCount = 0;
		if (inKeyword == null || inKeyword.trim().length() == 0 )
			inKeyword ="";
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_COMUNICADO_RADIAL_COUNT(?) }");
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_vacante PARA VISUALIZAR LOS COMUNICADOS RADIALES QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inDirection DIRECCION DE LA COLUMNA DE ORDENAMIENTO
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_vacante> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
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
		ArrayList<HashMap<String,Object>> outCgg_gem_vacante = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call SII.F_CGG_ATC_COMUNICADO_RADIAL_SELECT(?,?,?,?,?,?) }");
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
				outCgg_gem_vacante.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_vacante;
	}	
}