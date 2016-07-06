package com.bmlaurus.rule;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.util.Constantes;
import com.bmlaurus.util.DateUtil;
import com.bmlaurus.ws.dinardap.RegistroCivil;

import org.json.JSONObject;

/**
 * Created by acanaveral on 15/6/16.
 */
public class TenyearsApplicationResidenceValidator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
    	List<com.besixplus.sii.objects.Cgg_res_tramite> listaTramite = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
    	 Cgg_res_persona auspiciante = new Cgg_res_persona();
    	try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_res_tramite tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
			
		    tramite.setCRTST_CODIGO(Constantes.SOLICITUD_41_1B_CONVIVIENYE_RESIDENTE_PERM); 
		    tramite.setCGG_CRPER_CODIGO(ruleData.getCGGCRPER_CODIGO()); 
		    tramite.setCRPER_CODIGO(ruleData.getCRPER_CODIGO());
		    
	     	listaTramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).selectCGG_RES_PERSONA_TIPO(con);
	     	auspiciante.setCRPER_CODIGO(ruleData.getCRPER_CODIGO());
	    	auspiciante = new com.besixplus.sii.db.Cgg_res_persona(auspiciante).select(con);
	     	
	     	con.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		}		
    	
    	if(listaTramite == null || listaTramite.isEmpty()){
     		return "false,"+Constantes.MENSAJE_SOLICITUD_TEMPORAL;
     	}
    	
    	 Date fechaRecepcion = listaTramite.get(0).getCRTRA_FECHA_RECEPCION();
    	 Date fechaDiezAnos = DateUtil.sumarAnos(fechaRecepcion, DateUtil.ANOS);
 	 	 Date fechaActual = new Date(); 
 	 	 
    	if(fechaDiezAnos.before(fechaActual) || fechaDiezAnos.equals(fechaActual)){
    		return "true";
    	}else{
    		RegistroCivil registroCivil = new RegistroCivil(auspiciante.getCRPER_NUM_DOC_IDENTIFIC());//cedula del auspiciante
            registroCivil.callServiceAsObject();
            
            if(registroCivil.getFechaDefuncion()!=null && !registroCivil.getFechaDefuncion().trim().isEmpty()){
            	return "true";
            }	
 	     }
            
    	return "false,"+regla.getString("CRVAL_SUGERENCIA");
    }
}
