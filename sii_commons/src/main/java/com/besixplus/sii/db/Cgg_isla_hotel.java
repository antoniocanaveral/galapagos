package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
* CLASE Cgg_isla_hotel
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_isla_hotel
* @author BMLaurus
*/
public class Cgg_isla_hotel implements Serializable{
	//private static final long serialVersionUID = 804624590;

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_isla_hotel> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_isla_hotel> selectByIsland(
		java.sql.Connection inConnection,
		String in_isla_codigo
	){
		ArrayList<com.besixplus.sii.objects.Cgg_isla_hotel> outCgg_isla_hotel = new ArrayList<com.besixplus.sii.objects.Cgg_isla_hotel>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ISLA_HOTEL_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, in_isla_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_isla_hotel tmpCgg_isla_hotel = new com.besixplus.sii.objects.Cgg_isla_hotel();
				tmpCgg_isla_hotel.setCDISHO_CODIGO(results.getString(1));
				tmpCgg_isla_hotel.setCDISHO_NOMBRE(results.getString(2));
				outCgg_isla_hotel.add(tmpCgg_isla_hotel);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_isla_hotel;
	}

}