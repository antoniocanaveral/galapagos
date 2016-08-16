package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
* CLASE Cgg_tipo_tramite
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tipo_tramite.
* @author BMLaurus
*/
public class Cgg_tipo_tramite implements Serializable{
	//private static final long serialVersionUID = 804624590;

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tipo_tramite> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tipo_tramite> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tipo_tramite> outCgg_tipo_tramite = new ArrayList<com.besixplus.sii.objects.Cgg_tipo_tramite>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TIPO_TRAMITE_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tipo_tramite tmpCgg_tipo_tramite = new com.besixplus.sii.objects.Cgg_tipo_tramite();
				tmpCgg_tipo_tramite.setCRTT_CODIGO(results.getString(1));
				tmpCgg_tipo_tramite.setCRTT_NOMBRE(results.getString(2));
				outCgg_tipo_tramite.add(tmpCgg_tipo_tramite);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tipo_tramite;
	}

}