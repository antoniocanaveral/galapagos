package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
* CLASE Cgg_tct_atractivos_actividades
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_atractivos_actividades
* @author BMLaurus
*/
public class Cgg_tct_atractivos_actividades implements Serializable{
	private static final long serialVersionUID = 804624590;

	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_tct_atractivos_actividades.
	*/
	private com.besixplus.sii.objects.Cgg_tct_atractivos_actividades myCgg_tct_atractivos_actividades = null;

	/**Cgg_tct_atractivos_actividades
	* CONSTRUCTOR DE LA CLASE Cgg_tct_atractivos_actividades.
	*/
	public Cgg_tct_atractivos_actividades(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_atractivos_actividades.
	*/
	public Cgg_tct_atractivos_actividades(
		com.besixplus.sii.objects.Cgg_tct_atractivos_actividades inCgg_tct_atractivos_actividades
	){
		this.setCgg_tct_atractivos_actividades(inCgg_tct_atractivos_actividades);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_tct_atractivos_actividades.
	* @return void
	*/
	public void setCgg_tct_atractivos_actividades(com.besixplus.sii.objects.Cgg_tct_atractivos_actividades inCgg_tct_atractivos_actividades){
		this.myCgg_tct_atractivos_actividades = inCgg_tct_atractivos_actividades;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_tct_atractivos_actividades.
	*/
	public com.besixplus.sii.objects.Cgg_tct_atractivos_actividades getCgg_tct_atractivos_actividades(){
		return this.myCgg_tct_atractivos_actividades;
	}
	/**
	* INGRESA UN REGISTRO EN LA TABLA Cgg_tct_atractivos_actividades
	*/
	public String insert(
			java.sql.Connection inConnection
		){
			String outResult = "true";
			try{
				CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_TCT_ATRACTIVOS_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
				stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
				stmInsert.setString(2, this.getCgg_tct_atractivos_actividades().getCTATA_CODIGO());
				stmInsert.setString(3, this.getCgg_tct_atractivos_actividades().getCTGTR_CODIGO());
				stmInsert.setString(4, this.getCgg_tct_atractivos_actividades().getCTATA_VIDA_MARINA());
				stmInsert.setString(5, this.getCgg_tct_atractivos_actividades().getCTATA_SOL_PLAYA());
				stmInsert.setString(6, this.getCgg_tct_atractivos_actividades().getCTATA_VIDA_TERRESTRE());
				stmInsert.setString(7, this.getCgg_tct_atractivos_actividades().getCTATA_PAISAJE());
				stmInsert.setString(8, this.getCgg_tct_atractivos_actividades().getCTATA_CRUCERO());
				stmInsert.setString(9, this.getCgg_tct_atractivos_actividades().getCTATA_BUCEO());
				stmInsert.setString(10, this.getCgg_tct_atractivos_actividades().getCTATA_SNORKEL());
				stmInsert.setString(11, this.getCgg_tct_atractivos_actividades().getCTATA_KAYAK());
			    stmInsert.setString(12, this.getCgg_tct_atractivos_actividades().getCTATA_SURF());
				stmInsert.setString(13, this.getCgg_tct_atractivos_actividades().getCTATA_SENDERISMO());
				stmInsert.setString(14, this.getCgg_tct_atractivos_actividades().getCTATA_OBSERVACION());
				stmInsert.setString(15, this.getCgg_tct_atractivos_actividades().getCTATA_FOTOGRAFIA());
				stmInsert.setString(16, this.getCgg_tct_atractivos_actividades().getCTATA_PESCA_VIVENCIAL());
				
				
				stmInsert.execute();
				stmInsert.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			}
			return outResult;
		}
}