package com.besixplus.sii.mail;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.*;
import com.besixplus.sii.util.Env;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by acanaveral on 6/7/16.
 */
public class ProcessMail extends Thread{

    private Cgg_res_seguimiento seguimiento;
    private Cgg_res_tramite tramite;
    private Cgg_res_fase fase;
    private int inCrseg_tipo_respuesta; //NEGADO=0 - APROBADO=1

    private final String TIPO_MAIL = "CRTCO1";
    private final String USER_MAIL = "maildaemon";

    public ProcessMail(Cgg_res_seguimiento seguimiento, Cgg_res_tramite tramite, Cgg_res_fase fase, int inCrseg_tipo_respuesta) {
        this.seguimiento = seguimiento;
        this.tramite = tramite;
        this.fase = fase;
        this.inCrseg_tipo_respuesta = inCrseg_tipo_respuesta;
    }

    @Override
    public void run() {
        Connection objConn= ManagerConnection.getConnection();
        if(tramite==null)
            return;//TODO:Log
        try {
            objConn.setAutoCommit(false);
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

    private String buildTextMessage(Connection objConn, Cgg_not_mail mail){
        StringBuilder bodyMail = new StringBuilder();
        Properties props = Env.getExternalProperties("mailing/format.properties");
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
        bodyMail.append(mail.getNtml_body());

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
        String template = Env.getStringResource("mailing/"+props.getProperty("mail.html.template"));
        if(template!=null){
            String replacer = props.getProperty("mail.html.content_string");
            String content = contentBody(mail.getNtml_body());
            template = template.replaceAll(replacer,content);
            bodyMail.append(template);
        }
        return bodyMail.toString();
    }

    ///Leer el mensaje buscando @ (arrobas)
    // FORMATO:
    //      @T:[campo]@ -> datos del tramite -> puede llamarse a datos relacionados, usando el mismo formato de alfresco (campo_join;tabla.campo_respuesta)
    //      @S:[campo]@ -> datos del seguimiento
    //      @F:[campo]@ -> datos de la fase
    //AUXILIARES:
    //      @$AUSPICIANTE@ -> Nombres Completos del Auspiciante
    //      @$AUSPICIANTE_ID@ -> Cédula del Auspiciante
    //      @$BENEFICIARIO@ -> Nombres Completos del Beneficiario
    //      @$BENEFICIARIO_ID@ -> Cédula del Beneficiario

    //Obtener el contenido de las @ y reemplazarlo por la ejecución de la base de datos.
    //Seguir recorriendo el mensaje hasta el final.

    private String contentBody(String mailBody){
        StringBuilder buffer = new StringBuilder();

        if(mailBody.contains("@")){

        }else{
            buffer.append(mailBody);
        }


        return buffer.toString();
    }


}
