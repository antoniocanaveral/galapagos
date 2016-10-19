package com.bmlaurus.attachment;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_configuracion;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.Cgg_res_persona_juridica;
import com.bmlaurus.alfresco.model.SiiDocControl;
import com.bmlaurus.ws.dinardap.CNE;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import com.bmlaurus.ws.dinardap.SRI;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral on 3/8/16.
 */
public class CreatorInvoker {

    private static final long TIME_LIMIT = 3600000; //1 hora

    private RegistroCivil registroCivil;
    private CNE cne;
    private SRI sri;
    private Cgg_res_persona persona;
    private Cgg_res_persona_juridica empresa;
    private String crper_codigo;
    private String crpjr_codigo;

    //
    private boolean isControlled=false;

    public CreatorInvoker(RegistroCivil registroCivil, CNE cne, Cgg_res_persona persona) {
        this.registroCivil = registroCivil;
        this.cne = cne;
        this.persona = persona;
    }

    public CreatorInvoker(SRI sri, Cgg_res_persona_juridica empresa) {
        this.sri = sri;
        this.empresa = empresa;
    }

    private long timeLimit(Connection objConn){
        long limit = TIME_LIMIT;
        try {
            com.besixplus.sii.objects.Cgg_configuracion tmpConfiguracion = new Cgg_configuracion();
            tmpConfiguracion.setCGCNF_CODIGO("CONF205");
            new com.besixplus.sii.db.Cgg_configuracion(tmpConfiguracion).select(objConn);
            if(tmpConfiguracion.getCGCNF_VALOR_CADENA()!=null){
                limit = Long.parseLong(tmpConfiguracion.getCGCNF_VALOR_CADENA());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return limit;
    }

    public void createEmpresaDocuments(){
        crpjr_codigo = empresa.getCRPJR_CODIGO();
        if (crpjr_codigo != null) {
            Thread t = new Thread() {
                public void run() {
                    crearRuc();
                }
            };
            t.start();
        }
    }

    public void createPersonaDocuments(){
        crper_codigo = persona.getCRPER_CODIGO();
        if (crper_codigo != null) {
            Thread t = new Thread() {
                public void run() {
                    crearCedula();
                    crearPapeleta();
                }
            };
            t.start();
        }
    }

    public CreatorInvoker controlled(){
        isControlled=true;
        return this;
    }

    private boolean evaluate(String document_type, String record_id){
        boolean ret = false;
        if(document_type==null||record_id==null)
            return false;

        if(!isControlled)
            ret=true;
        else{
            try {
                Connection con = ManagerConnection.getConnection();
                if(con!=null) {
                    SiiDocControl control = new SiiDocControl(document_type, record_id);
                    control.query(con);
                    if (control.getDate_created() == null || ((System.currentTimeMillis() - control.getDate_created().getTime()) > timeLimit(con))) {
                        control.save(con);
                        ret = true;
                    }
                    con.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return ret;
    }

    private void crearRuc(){
        if(evaluate(SiiDocControl.DOCUMENT_TYPE_RUC,empresa.getCRPJR_NUMERO_IDENTIFICACION())) {
            if (sri == null) {
                sri = new SRI(empresa.getCRPJR_NUMERO_IDENTIFICACION());
                sri.callServiceAsObject();
            }
            if (sri != null && sri.getResultStaus().equals(SRI.CALL_OK)) {
                try {
                    CreateSRIAttachment attachment = new CreateSRIAttachment(sri, crpjr_codigo);
                    attachment.attachReport();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void crearCedula(){
        if(evaluate(SiiDocControl.DOCUMENT_TYPE_CEDULA,persona.getCRPER_NUM_DOC_IDENTIFIC())) {
            if (registroCivil == null) {
                registroCivil = new RegistroCivil(persona.getCRPER_NUM_DOC_IDENTIFIC());
                registroCivil.callServiceAsObject();
            }
            if (registroCivil != null && registroCivil.getResultStaus().equals(RegistroCivil.CALL_OK)) {
                try {
                    CreateRCAttachment attachment = new CreateRCAttachment(registroCivil, crper_codigo);
                    attachment.attachReport();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void crearPapeleta(){
        if(evaluate(SiiDocControl.DOCUMENT_TYPE_PAPELETA,persona.getCRPER_NUM_DOC_IDENTIFIC())) {
            if (cne == null) {
                cne = new CNE(persona.getCRPER_NUM_DOC_IDENTIFIC());
                cne.callServiceAsObject();
            }
            if (cne != null && cne.getResultStaus().equals(CNE.CALL_OK)) {
                try {
                    CreateCNEAttachment attachmentCNE = new CreateCNEAttachment(cne, crper_codigo);
                    attachmentCNE.attachReport();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
