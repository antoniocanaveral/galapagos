package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
* CLASE Cgg_catalogo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_catalogo
* @author BMLaurus
*/
public class Cgg_catalogo implements Serializable{
	//private static final long serialVersionUID = 804624590;

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tipo_tramite.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_catalogo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_catalogo> selectByType(
		java.sql.Connection inConnection,
		String in_identificador
	){
		ArrayList<com.besixplus.sii.objects.Cgg_catalogo> outCgg_catalogo = new ArrayList<com.besixplus.sii.objects.Cgg_catalogo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_CATALOGO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, in_identificador);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_catalogo tmpCgg_catalogo = new com.besixplus.sii.objects.Cgg_catalogo();
				tmpCgg_catalogo.setCDCATA_CODIGO(results.getString(1));
				tmpCgg_catalogo.setCDCATA_DESCRIPCION(results.getString(2));
				outCgg_catalogo.add(tmpCgg_catalogo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_catalogo;
	}

}