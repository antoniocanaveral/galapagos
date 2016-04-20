package com.besixplus.sii.db;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class Cgg_capacitacion {

	public Cgg_capacitacion() {
		
	}
	
	/**
	 * Selecciona una persona en base a su numero de documento.
	 * @param inConnection Conexion a base de datos.
	 * @param inCrper_num_doc_identific Numero de documento de persona.
	 * @return Nombre de la persona.
	 */
	public String seleccionaNombrePersona(
			java.sql.Connection inConnection,
			String inCrper_num_doc_identific
		){
			
			String tmpNombrePersona = "";
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_RES_PERSONA_CAPACITACION(?) }");
				stmSelect.registerOutParameter(1, Types.VARCHAR);
				stmSelect.setString(2, inCrper_num_doc_identific);
				stmSelect.execute();
				
				tmpNombrePersona = stmSelect.getString(1);	
								
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return tmpNombrePersona;
		}	
		
}
