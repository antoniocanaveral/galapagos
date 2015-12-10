package com.besixplus.sii.mail;

/**
 * Clase publica. Clase para notificacion de correo electronico asincrona.
 */
public class Notificador extends Thread {
    private String mail = null;
    private String asunto = null;
    private String contenido = null;
    private String[] nombreAdjunto = null;
    private byte[][] adjunto = null;   
    
    /**
     *Constructor publico. Inicializa la clase Notificador.
     * @param inMail Direccion de correo electronico al cual se destina el correo.
     * @param inAsunto Asunto del mail.
     * @param inContenido Contenido del mail.
     * @param inNombreAdjuntos Array de nombres de adjuntos para el mail.
     * @param inAdjuntos Array de contenido adjunto en base64 para el mail.
     */
    public Notificador(String inMail,String inAsunto,String inContenido,String[] inNombreAdjuntos,byte[][] inAdjuntos) {
        this.mail = inMail;
        this.asunto = inAsunto;
        this.contenido = inContenido;
        this.nombreAdjunto = inNombreAdjuntos;
        this.adjunto = inAdjuntos;
    }
    
    public void run(){
        SIICGGMail objMailService;
        try {
            objMailService= new SIICGGMail();
            String result= objMailService.sendMailAttachments(this.mail, this.asunto, this.contenido, this.nombreAdjunto, this.adjunto);                                                    
        } catch (Exception e) {           
        	com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }        
    }    
}
