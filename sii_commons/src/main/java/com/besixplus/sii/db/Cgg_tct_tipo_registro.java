package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
* CLASE Cgg_tct_tipo_registro
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_tipo_registro
* @author BMLaurus
*/
public class Cgg_tct_tipo_registro implements Serializable{
	//private static final long serialVersionUID = 804624590;

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_tipo_registro
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_registro> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_registro> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_registro> outCgg_tct_tipo_registro = new ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_registro>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_TIPO_REGISTRO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_tct_tipo_registro tmpCgg_tct_tipo_registro = new com.besixplus.sii.objects.Cgg_tct_tipo_registro();
				tmpCgg_tct_tipo_registro.setTCTTR_CODIGO(results.getString(1));
				tmpCgg_tct_tipo_registro.setTCTTR_NOMBRE(results.getString(2));
				outCgg_tct_tipo_registro.add(tmpCgg_tct_tipo_registro);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			SQLErrorHandler.errorHandler(e);
		}
		return outCgg_tct_tipo_registro;
	}

}