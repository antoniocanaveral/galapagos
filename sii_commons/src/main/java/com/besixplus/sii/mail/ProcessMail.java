package com.besixplus.sii.mail;

import com.besixplus.sii.db.ManagerConnection;
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

    private final String TIPO_MAIL = "CRTCO1";
    private final String USER_MAIL = "maildaemon";

    public ProcessMail(Cgg_res_seguimiento seguimiento, Cgg_res_tramite tramite, Cgg_res_fase fase) {
        this.seguimiento = seguimiento;
        this.tramite = tramite;
        this.fase = fase;
    }

    @Override
    public void run() {
        Connection objConn= ManagerConnection.getConnection();
        try {
            objConn.setAutoCommit(false);
            String crfs_codigo = seguimiento.getCGG_CRFAS_CODIGO();
            Cgg_not_fase_notificacion objNot = new Cgg_not_fase_notificacion();
            objNot.setCrfas_codigo(crfs_codigo);
            ArrayList<Cgg_not_fase_notificacion> notifications = new com.besixplus.sii.db.Cgg_not_fase_notificacion(objNot).selectByFase(objConn);
            for(Cgg_not_fase_notificacion not:notifications){
                String destMail = "draft@mail.com";
                Cgg_res_persona_contacto contacto = null;
                switch (not.getNtfn_destinatario()){
                    case Cgg_not_fase_notificacion.DEST_AUSPICIANTE:
                        contacto = new Cgg_res_persona_contacto();
                        contacto.setCRPER_CODIGO(tramite.getCRPER_CODIGO());
                        for (Cgg_res_persona_contacto current : new com.besixplus.sii.db.Cgg_res_persona_contacto(contacto).selectCGG_RES_PERSONA(objConn)){
                            if(current.getCRTCO_CODIGO().equals(TIPO_MAIL) && current.getCRPRC_ESTADO()){
                                destMail = current.getCRPRC_CONTACTO();
                            }
                        }
                        break;
                    case Cgg_not_fase_notificacion.DEST_BENEFICIARIO:
                        contacto = new Cgg_res_persona_contacto();
                        contacto.setCRPER_CODIGO(tramite.getCGG_CRPER_CODIGO());
                        for (Cgg_res_persona_contacto current : new com.besixplus.sii.db.Cgg_res_persona_contacto(contacto).selectCGG_RES_PERSONA(objConn)){
                            if(current.getCRTCO_CODIGO().equals(TIPO_MAIL) && current.getCRPRC_ESTADO()){
                                destMail = current.getCRPRC_CONTACTO();
                            }
                        }
                        break;
                    //FIXME: Faltantes
                    case Cgg_not_fase_notificacion.DEST_FUNCIONARIOFASE:
                        break;
                    case Cgg_not_fase_notificacion.DEST_GOBIERNO:
                        break;
                    default:
                        break;
                }

                Cgg_not_mail correo = new Cgg_not_mail();
                correo.setNtml_codigo(not.getNtml_codigo());
                correo = new com.besixplus.sii.db.Cgg_not_mail(correo).selectByCode(objConn);
                if(correo!=null){
                    buildMessage(objConn, correo,destMail);
                }
                System.out.println("NOTIFICACION por MAIL");
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
        objCorreo.setCBZC_MENSAJE(buildMessage(mail));
        objCorreo.setCBZC_USUARIO_INSERT(USER_MAIL);
        objCorreo.setCBZC_USUARIO_UPDATE(USER_MAIL);
        String result = new com.besixplus.sii.db.Cgg_buzon_correo(objCorreo).insert(conn);
        if(result==null || !result.equals("true"))
            System.err.println("El correo no sera enviado. ["+destMail+"] "+mail.getNtml_subject() +" :"+result);
    }

    private String buildMessage(Cgg_not_mail mail){
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
}
