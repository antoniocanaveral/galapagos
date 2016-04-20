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

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Clase Publica. Clase para el manejo de correo electronico desde una cuenta.
 */
public class Mail {
    private String host;
    private String protocol;
    private String user;
    private String password;
    private Properties props = new Properties();
    
    /**
     * Constructor Publico.
     */
    public Mail(){
        this(null,null,null,null);
    }
    
    /**
     * Constructor Publico Sobrecargado.
     * @param inHost
     * @param inProtocol
     * @param inUser
     * @param inPassword
     */
    public Mail(String inHost,String inProtocol,String inUser,String inPassword){
        this.host = inHost;
        this.protocol = inProtocol;
        this.user = inUser;
        this.password = inPassword;
                
        this.props.setProperty("mail.host", this.host);
        this.props.setProperty("mail.transport.protocol", this.protocol);
        this.props.setProperty("mail.user", this.user);
        this.props.setProperty("mail.password", this.password);        
    }
    
    public String sendHtmlMultipartMail(String inSenderMail, String inReceiveMail,String inSubject,MimeMultipart inMultipartContent){
        String aux = "false";
        try{
                    Session mailSession = Session.getDefaultInstance(this.props, null);                    
                    Transport transport = mailSession.getTransport();
                    MimeMessage message = new MimeMessage(mailSession);
                    message.setSubject(inSubject);
                    message.setFrom(new InternetAddress(inSenderMail));
                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(inReceiveMail));                
                    message.setContent(inMultipartContent);
                    transport.connect();
                    transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
                    transport.close();
                    aux = "true";
        }catch(Exception er){
            er.printStackTrace();
            aux = er.getMessage();
        }
        return aux;
    }
    
    public boolean sendPlainMail(String inSenderMail, String inReceiveMail,String inSubject,String inContent){
        Boolean aux = false;
        try{
                    Session mailSession = Session.getDefaultInstance(this.props, null);                    
                    Transport transport = mailSession.getTransport();
                    MimeMessage message = new MimeMessage(mailSession);
                    message.setSubject(inSubject);
                    message.setFrom(new InternetAddress(inSenderMail));
                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(inReceiveMail));                
                    message.setContent(inContent, "text/html");
                    transport.connect();
                    transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
                    transport.close();
                    aux = true;
        }catch(Exception er){
            er.printStackTrace();
            aux = false;
        }
        return aux;
    }
}
