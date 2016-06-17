/**
This file is part of SISSOL.

    SISSOL is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SISSOL is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SISSOL.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.besixplus.sii.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Clase Publica. Clase para el envio de mail con estilo del SIICGG.
 */
public class SIICGGMail {
    
    private Mail objMail=null;
    
    /**
     * Constructor Publico. Inicializa la clase SIICGGMail.
     */
    public SIICGGMail() {
        objMail = new Mail("mail1.cgg.gov.ec","smtp","siicgg","pi31416");
    }
    
    /**
     * Metodo Publico. Envia un correo electronico con los datos por defecto de una cuenta de correo del SIICGG a un destinatario especificado.
     * @param inReceiveMail Direccion de correo electronico.
     * @param inSubject Cadena de titulo del mail.
     * @param inContent Contenido o cuerpo del correo.
     * @return Verdadero/Falso al envio del correo.
     */
    public String sendMail(String inReceiveMail,String inSubject,String inContent){
        String aux = "false";
        MimeMultipart multipart = new MimeMultipart("related");            
        try{            
            BodyPart messageBodyPart = new MimeBodyPart();                        
            String htmlText ="<body>"+
            "<table width='100%'  border='0'>"+
              "<tr>"+
                "<td width='11%'><img src=\"cid:image\" width='86' height='56'></td>"+
                "<td width='89%'><p><span>Sistema Integral Informatico SIICGG</span><br>"+
                    "<span>CONSEJO DE GOBIERNO REGIMEN ESPECIAL GALAPAGOS</span></p><br>Sistema de notificaciones.</td>"+
              "</tr>"+
              "<tr>"+
                "<td>Asunto:</td>"+
                "<td><strong>"+inSubject+"</strong><br>"+inContent+"</td>"+
              "</tr>"+
            "</table>" +
            "<br>";
            messageBodyPart.setContent(htmlText, "text/html");    
            multipart.addBodyPart(messageBodyPart);                    
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("cgg2.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID","<image>");            
            multipart.addBodyPart(messageBodyPart);
        }catch(Exception e){
            e.printStackTrace();
            aux = e.getMessage();
        }        
        aux = String.valueOf(objMail.sendHtmlMultipartMail("siicgg@cgg.gov.ec",inReceiveMail,inSubject,multipart));
        return aux;
    }    
    
    /**
     * Metodo Publico. Envia un correo electronico con los datos por defecto de una cuenta de correo de la EEASA a un destinatario especificado.s
     * @param inReceiveMail Direccion de correo electronico.
     * @param inSubject Cadena de titulo del mail.
     * @param inContent Contenido o cuerpo del correo.
     * @param inAttachmentNames Array de los nombres de los adjuntos que se envian.
     * @param inAttachmentContents Array del contenido de los adjuntos que se envian. 
     * @return Verdadero/Falso al envio del correo.
     */
    public String sendMailAttachments(String inReceiveMail,String inSubject,String inContent,String[] inAttachmentNames,String[] inAttachmentContents){
        String aux = "false";
        MimeMultipart multipart = new MimeMultipart("related");            
        try{            
            BodyPart messageBodyPart = new MimeBodyPart();                        
            String htmlText ="<body>"+
            "<table width='100%'  border='0'>"+
            "<tr>"+
              "<td width='11%'><img src=\"cid:image\" width='86' height='56'></td>"+
              "<td width='89%'><p><span>Sistema Integral Informatico SIICGG</span><br>"+
                  "<span>CONSEJO DE GOBIERNO REGIMEN ESPECIAL GALAPAGOS</span></p><br>Sistema de notificaciones.</td>"+
            "</tr>"+
            "<tr>"+
              "<td>Asunto:</td>"+
              "<td><strong>"+inSubject+"</strong><br>"+inContent+"</td>"+
            "</tr>"+
          "</table>" +
          "<br><br>";
            messageBodyPart.setContent(htmlText, "text/html");  
            
            multipart.addBodyPart(messageBodyPart);                    
            
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("cgg2.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID","<image>");            
            
            multipart.addBodyPart(messageBodyPart);
            
            for(int i = 0; i< inAttachmentContents.length;i++ ){
                byte [] objArchivo = Base64.decode(inAttachmentContents[i]);
                messageBodyPart = new MimeBodyPart();                                
                DataSource fds1=new ByteArrayDataSource(objArchivo,"application/octet-stream");                                
                messageBodyPart.setDataHandler(new DataHandler(fds1));                
                messageBodyPart.setFileName(inAttachmentNames[i]);                
                multipart.addBodyPart(messageBodyPart);    
            }
                                                        
        }catch(Exception e){
            e.printStackTrace();
            aux = e.getMessage();
        }        
        aux = objMail.sendHtmlMultipartMail("siicgg@cgg.gov.ec",inReceiveMail,inSubject,multipart);
        return aux;
    }
    
    /**
     *Metodo de servicio publico. Envia un correo electronico simple a los parametros especificados.
     * @param inSenderMail Correo de envio.
     * @param inReceiveMail Correo de recepcion.
     * @param inSubject Titulo del mensaje.
     * @param inContent Cuerpo del mensaje.
     * @return Verdadero / Falso en el envio del mensaje.
     */
    public boolean sendPlainmail(String inSenderMail, String inReceiveMail,String inSubject,String inContent){
        boolean aux = true;
        aux=objMail.sendPlainMail(inSenderMail,inReceiveMail,inSubject,inContent);
        return aux;
    }   
    
    /**
     * Metodo Publico. Envia un correo electronico con los datos por defecto de una cuenta de correo de la EEASA a un destinatario especificado.s
     * @param inReceiveMail Direccion de correo electronico.
     * @param inSubject Cadena de titulo del mail.
     * @param inContent Contenido o cuerpo del correo.
     * @param inAttachmentNames Array de los nombres de los adjuntos que se envian.
     * @param inAttachmentContents Array del contenido de los adjuntos que se envian. 
     * @return Verdadero/Falso al envio del correo.
     */
    public String sendMailAttachments(String inReceiveMail,String inSubject,String inContent,String[] inAttachmentNames,byte [][] inAttachmentContents){
        String aux = "false";
        MimeMultipart multipart = new MimeMultipart("related");            
        try{            
            BodyPart messageBodyPart = new MimeBodyPart();                        
            String htmlText ="<body>"+
            "<table width='100%'  border='0'>"+
            "<tr>"+
              "<td width='11%'><img src=\"cid:image\" width='86' height='56'></td>"+
              "<td width='89%'><p><span>Sistema Integral Informatico SIICGG</span><br>"+
                  "<span>CONSEJO DE GOBIERNO REGIMEN ESPECIAL GALAPAGOS</span></p><br>Sistema de notificaciones.</td>"+
            "</tr>"+
            "<tr>"+
              "<td>Asunto:</td>"+
              "<td><strong>"+inSubject+"</strong><br>"+inContent+"</td>"+
            "</tr>"+
          "</table>" +
          "<br>";
            messageBodyPart.setContent(htmlText, "text/html");  
            
            multipart.addBodyPart(messageBodyPart);                    
            
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("cgg2.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID","<image>");            
            
            multipart.addBodyPart(messageBodyPart);
            
            for(int i = 0; i< inAttachmentContents.length;i++ ){                
                messageBodyPart = new MimeBodyPart();                                
                DataSource fds1=new ByteArrayDataSource(inAttachmentContents[i],"application/octet-stream");                                
                messageBodyPart.setDataHandler(new DataHandler(fds1));                
                messageBodyPart.setFileName(inAttachmentNames[i]);                
                multipart.addBodyPart(messageBodyPart);    
            }
                                                        
        }catch(Exception e){
            e.printStackTrace();
            aux = e.getMessage();
        }        
        aux = objMail.sendHtmlMultipartMail("siicgg@cgg.gov.ec",inReceiveMail,inSubject,multipart);
        return aux;
    }
}
