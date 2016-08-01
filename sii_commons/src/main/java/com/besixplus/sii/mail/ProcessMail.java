package com.besixplus.sii.mail;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.*;
import com.besixplus.sii.util.Env;
import com.bmlaurus.alfresco.db.SiiDataLoader;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by acanaveral on 6/7/16.
 */
public class ProcessMail extends Thread{

    private Cgg_res_seguimiento seguimiento;
    private Cgg_res_tramite tramite;
    private Cgg_res_fase fase;
    private int inCrseg_tipo_respuesta; //NEGADO=0 - APROBADO=1

    private Cgg_not_mail externalMail;
    private String externalDestinatario;
    Map<String,String> externalAuxData;

    private final String TIPO_MAIL = "CRTCO1";
    private final String USER_MAIL = "maildaemon";

    private boolean isTramite=false;

    public ProcessMail(Cgg_res_seguimiento seguimiento, Cgg_res_tramite tramite, Cgg_res_fase fase, int inCrseg_tipo_respuesta) {
        this.seguimiento = seguimiento;
        this.tramite = tramite;
        this.fase = fase;
        this.inCrseg_tipo_respuesta = inCrseg_tipo_respuesta;
        isTramite = true;
    }

    public ProcessMail(Cgg_not_mail mail, String destinatario, Map<String,String> auxData){
        externalMail = mail;
        externalDestinatario=destinatario;
        externalAuxData = auxData;
    }

    @Override
    public void run() {
        if(isTramite)
            tramiteMail();

        if(externalMail!=null)
            externalMail();
    }

    private void externalMail(){
        try {
            Connection objConn = ManagerConnection.getConnection();
            objConn.setAutoCommit(false);

            if (externalMail != null) {
                buildMessage(objConn, externalMail, externalDestinatario);
            }
            System.out.println("NOTIFICACION por MAIL (EXTERNAL)");

            objConn.commit();
            objConn.setAutoCommit(true);
            objConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tramiteMail(){
        try {
            Connection objConn= ManagerConnection.getConnection();
            objConn.setAutoCommit(false);

            if(tramite==null || tramite.getCRTRA_CODIGO()==null){
                if(seguimiento!=null) {
                    tramite.setCRTRA_CODIGO(seguimiento.getCRTRA_CODIGO());
                    tramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).select(objConn);
                }else
                    tramite=null;
            }
            if(tramite==null)
                return;//TODO:Log

            String crfs_codigo = null;
            if(seguimiento!=null) {
                crfs_codigo = seguimiento.getCGG_CRFAS_CODIGO();
            }else{
                if(fase==null) {
                    fase = new Cgg_res_fase();
                    fase.setCRPRO_CODIGO(tramite.getCRPRO_CODIGO());
                    fase = new com.besixplus.sii.db.Cgg_res_fase(fase).selectFaseInicio(objConn, tramite.getCISLA_CODIGO());
                    if (fase.getCRFAS_CODIGO() != null &&
                            fase.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
                            fase.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()) {
                        crfs_codigo = fase.getCRFAS_CODIGO();
                    } else
                        return;//TODO:Log
                }else{
                    crfs_codigo = fase.getCRFAS_CODIGO();
                }
            }

            Cgg_not_fase_notificacion objNot = new Cgg_not_fase_notificacion();
            objNot.setCRFAS_CODIGO(crfs_codigo);
            ArrayList<Cgg_not_fase_notificacion> notifications = new com.besixplus.sii.db.Cgg_not_fase_notificacion(objNot).selectByFase(objConn);
            for(Cgg_not_fase_notificacion not:notifications){
                if(not.getNTFN_RESPUESTA_FASE_INT()==inCrseg_tipo_respuesta) {//VALIDAMOS PARA TIPO DE RESPUESTA
                    boolean enviar = true;
                    if(not.getNTFN_TIPO_SOLICITUD()!= null && not.getNTFN_TIPO_SOLICITUD().length()>0){
                        enviar = not.getNTFN_TIPO_SOLICITUD().equals(tramite.getCRTST_CODIGO());
                    }
                    if(enviar) {
                        String destMail = "antoniocanaveral@gmail.com";
                        Cgg_res_persona_contacto contacto = null;
                        switch (not.getNTFN_DESTINATARIO()) {
                            case Cgg_not_fase_notificacion.DEST_AUSPICIANTE:
                                contacto = new Cgg_res_persona_contacto();
                                contacto.setCRPER_CODIGO(tramite.getCRPER_CODIGO());
                                for (Cgg_res_persona_contacto current : new com.besixplus.sii.db.Cgg_res_persona_contacto(contacto).selectCGG_RES_PERSONA(objConn)) {
                                    if (current.getCRTCO_CODIGO().equals(TIPO_MAIL) && current.getCRPRC_ESTADO()) {
                                        destMail = current.getCRPRC_CONTACTO();
                                    }
                                }
                                break;
                            case Cgg_not_fase_notificacion.DEST_BENEFICIARIO:
                                contacto = new Cgg_res_persona_contacto();
                                contacto.setCRPER_CODIGO(tramite.getCGG_CRPER_CODIGO());
                                for (Cgg_res_persona_contacto current : new com.besixplus.sii.db.Cgg_res_persona_contacto(contacto).selectCGG_RES_PERSONA(objConn)) {
                                    if (current.getCRTCO_CODIGO().equals(TIPO_MAIL) && current.getCRPRC_ESTADO()) {
                                        destMail = current.getCRPRC_CONTACTO();
                                    }
                                }
                                break;
                            //FIXME: Faltantes
                            case Cgg_not_fase_notificacion.DEST_FUNCIONARIOFASE:
                                break;
                            case Cgg_not_fase_notificacion.DEST_GOBIERNO:
                                Cgg_configuracion tmpConf = new Cgg_configuracion();
                                tmpConf.setCGCNF_CODIGO("CONF42");
                                tmpConf = new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(objConn);
                                destMail = tmpConf.getCGCNF_VALOR_CADENA();
                                break;
                            default:
                                break;
                        }

                        Cgg_not_mail correo = new Cgg_not_mail();
                        correo.setNtml_codigo(not.getNTML_CODIGO());
                        correo = new com.besixplus.sii.db.Cgg_not_mail(correo).selectByCode(objConn);
                        if (correo != null) {
                            buildMessage(objConn, correo, destMail);
                        }
                        System.out.println("NOTIFICACION por MAIL");
                    }
                }
            }
            objConn.commit();
            objConn.setAutoCommit(true);
            objConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void buildMessage(Connection conn, Cgg_not_mail mail, String destMail){
        Cgg_buzon_correo objCorreo = new Cgg_buzon_correo();
        objCorreo.setCBZC_CODIGO("KEYGEN");
        objCorreo.setCBZC_ASUNTO(mail.getNtml_subject());
        objCorreo.setCBZC_DESTINATARIO(destMail);
        objCorreo.setCBZC_ESTADO(true);
        objCorreo.setCBZC_ENVIADO(false);
        objCorreo.setCBZC_NUMERO_INTENTOS(BigDecimal.ZERO);
        objCorreo.setCBZC_TIPO_CONTENIDO(mail.getNtml_type());
        if(mail.getNtml_type().equals("html"))
            objCorreo.setCBZC_MENSAJE(buildHtmlMessage(conn, mail));
        else
            objCorreo.setCBZC_MENSAJE(buildTextMessage(conn, mail));
        objCorreo.setCBZC_USUARIO_INSERT(USER_MAIL);
        objCorreo.setCBZC_USUARIO_UPDATE(USER_MAIL);
        String result = new com.besixplus.sii.db.Cgg_buzon_correo(objCorreo).insert(conn);
        if(result==null || !result.equals("true"))
            System.err.println("El correo no sera enviado. ["+destMail+"] "+mail.getNtml_subject() +" :"+result);
    }

    private String noDataStr = "NO DATA";
    private String buildTextMessage(Connection objConn, Cgg_not_mail mail){
        StringBuilder bodyMail = new StringBuilder();
        Properties props = Env.getExternalProperties("mailing/format.properties");
        noDataStr = props.getProperty("mail.no_data");
        if(mail.isNtml_sendheader()){
            if(mail.getNtml_header_override()!=null && mail.getNtml_header_override().length()>=0)
                bodyMail.append(mail.getNtml_header_override());
            else{
                //La cabecera por default
                if(props!=null){
                    bodyMail.append(props.getProperty("mail.header"));
                }
            }
        }

        //FIXME: Implementar la construccion dinamica del cuerpo del correo.
        bodyMail.append(contentBody(objConn,mail.getNtml_body()));

        if(mail.isNtml_sendheader()){
            if(mail.getNtml_header_override()!=null && mail.getNtml_header_override().length()>=0)
                bodyMail.append(mail.getNtml_header_override());
            else{
                //El pie por default
                if(props!=null){
                    bodyMail.append(props.getProperty("mail.footer"));
                }
            }
        }

        return bodyMail.toString();
    }

    private String buildHtmlMessage(Connection objConn, Cgg_not_mail mail){
        StringBuilder bodyMail = new StringBuilder();
        Properties props = Env.getExternalProperties("mailing/format.properties");
        noDataStr = props.getProperty("mail.no_data");
        String template = Env.getStringResource("mailing/"+props.getProperty("mail.html.template"));
        if(template!=null){
            String replacer = props.getProperty("mail.html.content_string");
            String content = contentBody(objConn, mail.getNtml_body());
            String body = template.replace(replacer,content);
            bodyMail.append(body);
        }
        return bodyMail.toString();
    }

    ///Leer el mensaje buscando @ (arrobas)
    // FORMATO:
    //      @T:[campo]@ -> datos del tramite -> puede llamarse a datos relacionados, usando el mismo formato de alfresco (campo_join;tabla.campo_respuesta)
    //      @S:[campo]@ -> datos del seguimiento
    //      @F:[campo]@ -> datos de la fase
    //      Cualquier otra tabla mediante el formato @[Nombre_Tabla]*[record_id]:[campo]@
    //AUXILIARES:
    //      @$AUSPICIANTE@ -> Nombres Completos del Auspiciante
    //      @$AUSPICIANTE_ID@ -> Cédula del Auspiciante
    //      @$BENEFICIARIO@ -> Nombres Completos del Beneficiario
    //      @$BENEFICIARIO_ID@ -> Cédula del Beneficiario
    //      @$TIPO_RESIDENCIA@ -> Tipo de la Solicitud de Residencia

    //Obtener el contenido de las @ y reemplazarlo por la ejecución de la base de datos.
    //Seguir recorriendo el mensaje hasta el final.

    public String contentBody(Connection objConn, String mailBody){
        StringBuilder buffer = new StringBuilder();

        int index = 0;
        String analizer = null;
        while (index < mailBody.length()){
            analizer = mailBody.substring(index);
            if(analizer.contains("@")){
                int addIndex = analizer.indexOf("@");
                //Agregamos lo que esta antes de las arrobas
                if(addIndex>0)
                    buffer.append(analizer.substring(0,addIndex));

                //Evaluamos las Arrobas
                String evaluate = analizer.substring(addIndex);
                int addLimit = evaluate.replaceFirst("@","?").indexOf("@");
                String result = dataResolver(objConn, evaluate.substring(1,addLimit));
                buffer.append(result);
                index = index + addIndex+addLimit+1;
            }else{
                buffer.append(analizer);
                index = index + analizer.length();
            }
        }
        return buffer.toString();
    }


    private String dataResolver(Connection conn, String dataPath){
        String result = noDataStr;
        String tableName = null;
        String recordId = null;
        List<String> path = new ArrayList<>();
        if(dataPath.contains(":")){//ES UNA LLAMADA CON CAMPOS
            String splitter[] = dataPath.split(":");
            switch (splitter[0]){
                case "T":   tableName = "cgg_res_tramite";
                            recordId = tramite.getCRTRA_CODIGO();
                    break;
                case "S":   tableName = "cgg_res_seguimiento";
                            recordId = seguimiento.getCRSEG_CODIGO();
                    break;
                case "F":   tableName = "cgg_res_fase";
                            recordId = fase.getCRFAS_CODIGO();
                    break;
                default:    String comparator = splitter[0];
                            if(comparator.contains("*")){
                                String dinamic[] = comparator.split("\\*");
                                tableName = dinamic[0];
                                recordId = dinamic[1];
                            }else
                                return result;
                    break;

            }
            path.add("@"+splitter[1]+"@");
        }else if(dataPath.contains("$")){//ES UNA LLAMADA DIRECTA
            tableName = "cgg_res_persona";
            switch (dataPath){
                case "$AUSPICIANTE":
                    recordId = tramite.getCRPER_CODIGO();
                    path.add("@crper_nombres@");
                    path.add("@crper_apellido_paterno@");
                    path.add("@crper_apellido_materno@");
                    break;
                case "$AUSPICIANTE_ID":
                    recordId = tramite.getCRPER_CODIGO();
                    path.add("@crper_num_doc_identific@");
                    break;
                case "$BENEFICIARIO":
                    recordId = tramite.getCGG_CRPER_CODIGO();
                    path.add("@crper_nombres@");
                    path.add("@crper_apellido_paterno@");
                    path.add("@crper_apellido_materno@");
                    break;
                case "$BENEFICIARIO_ID":
                    recordId = tramite.getCGG_CRPER_CODIGO();
                    path.add("@crper_num_doc_identific@");
                    break;
                case "$TIPO_RESIDENCIA":
                    tableName = "cgg_res_tramite";
                    recordId = tramite.getCRTRA_CODIGO();
                    path.add("@crtst_codigo;cgg_res_tipo_solicitud_tramite.#cgg_crtst_codigo!cgg_res_tipo_solicitud_tramite$crtst_descripcion#@");
                    break;
                default:
                    if(externalAuxData!=null && externalAuxData.size()>0){
                        if(externalAuxData.get(dataPath)!=null)
                            path.add(externalAuxData.get(dataPath));
                    }
                    break;
            }
        }else{
            System.err.println("EL Parametro del correo no tiene el formato adecuado: "+dataPath);
        }
        if(path.size()>0)
            result="";
        for(String data:path) {
            try {
                if(data.startsWith("@"))
                    result = result + cleanData(SiiDataLoader.repoResolver(conn, tableName, recordId, data))+" ";
                else
                    result = data;
                if(result.trim().length()==0)
                    result=noDataStr;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private String cleanData(String data){
        String result="";
        if(data!=null && data.length()>0){
            try {
                data = data.substring(0, data.length() - 1);
                result = data.replace("null", "");
            }catch (Exception e){
                System.out.println("algo paso: " +e.getMessage());
            }
        }
        return result;
    }

}
