package com.besixplus.sii.job;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_buzon_correo;
import com.besixplus.sii.objects.Cgg_configuracion;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SendMailJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Connection tmpCon = ManagerConnection.getConnection();
		try {
			tmpCon.setAutoCommit(false);
			
			Cgg_configuracion tmpConf = new Cgg_configuracion();
        	tmpConf.setCGCNF_CODIGO("CONF42");
        	new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpCon);
			
			ArrayList<Cgg_buzon_correo> tmpCorreos = new com.besixplus.sii.db.Cgg_buzon_correo().selectAll(tmpCon, "maildaemon", false);
			
			tmpCon.setAutoCommit(true);
			tmpCon.close();
			
			for (Cgg_buzon_correo tmpCorreo : tmpCorreos) {
				new SendMailThread(tmpCorreo, tmpConf.getCGCNF_VALOR_CADENA()).start();
			}
			
			tmpCorreos.clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

/**
 * Envia los e-mails a los destinatarios.
 * @author BESIXPLUS CIA. LTDA.
 *
 */
class SendMailThread extends Thread{
	private Cgg_buzon_correo myCorreo = null;
	private String myEmailCC = null;
	
	public SendMailThread(Cgg_buzon_correo inCorreo, String inEmailCC){
		super(inCorreo.getCBZC_CODIGO());
		this.myCorreo = inCorreo;
		this.myEmailCC = inEmailCC;
	}

	public void run() {
		try {
			MimeMessage tmpMessage = new MimeMessage(ManagerConnection.getMailSession());
			String tmpUserUpdate = myCorreo.getCBZC_USUARIO_INSERT();
			if (tmpUserUpdate.equals("@GEM@")){
				Cgg_configuracion tmpConf1 = new Cgg_configuracion();
				Connection tmpCon1 = ManagerConnection.getConnection();
				try {
					tmpCon1.setAutoCommit(false);
					tmpConf1.setCGCNF_CODIGO("CONF52");
		        	new com.besixplus.sii.db.Cgg_configuracion(tmpConf1).select(tmpCon1);		        	
		        	tmpMessage.setFrom(new InternetAddress(tmpConf1.getCGCNF_VALOR_CADENA()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				tmpCon1.close();
			}
			tmpMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(myCorreo.getCBZC_DESTINATARIO()));
			tmpMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(myEmailCC));
			tmpMessage.setSubject(myCorreo.getCBZC_ASUNTO());
			tmpMessage.setContent(myCorreo.getCBZC_MENSAJE()!=null?myCorreo.getCBZC_MENSAJE():"", myCorreo.getCBZC_TIPO_CONTENIDO());
			Transport.send(tmpMessage);
			myCorreo.setCBZC_ENVIADO(true);
		} catch (MessagingException e) {
			e.printStackTrace();
			myCorreo.setCBZC_ENVIADO(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection tmpCon = ManagerConnection.getConnection();
			myCorreo.setCBZC_NUMERO_INTENTOS(new BigDecimal( (myCorreo.getCBZC_NUMERO_INTENTOS()!=null?myCorreo.getCBZC_NUMERO_INTENTOS().intValue():0) + 1));
			myCorreo.setCBZC_USUARIO_UPDATE("maildaemon");
			
			if(myCorreo.getCBZC_ENVIADO())
				new com.besixplus.sii.db.Cgg_buzon_correo(myCorreo).delete(tmpCon, false);
			else
				new com.besixplus.sii.db.Cgg_buzon_correo(myCorreo).update(tmpCon);
			
			tmpCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
} 
