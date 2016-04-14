package com.besixplus.sii.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.job.ExcedidoDiasIndiceJob;
import com.besixplus.sii.job.ExcedidoDiasJob;
import com.besixplus.sii.job.NotifyLeaderJob;
import com.besixplus.sii.job.ResidenciaFormatoJob;
import com.besixplus.sii.job.ResidentMonitorJob;
import com.besixplus.sii.job.SendMailJob;
import com.besixplus.sii.objects.Cgg_configuracion;

/**
 * Servlet implementation class SendMailDaemon
 */
public class SendMailDaemon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SchedulerFactory mySchedulerFactory = new StdSchedulerFactory();
	private Scheduler myScheduler = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailDaemon() {
        super();
        try {
        	Connection tmpConnection = ManagerConnection.getConnection();
        	tmpConnection.setAutoCommit(false);
        	Cgg_configuracion tmpConf = new Cgg_configuracion();
        	tmpConf.setCGCNF_CODIGO("CONF41");
        	new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpConnection);
        	
        	tmpConnection.setAutoCommit(true);
        	tmpConnection.close();
        	
			mySchedulerFactory = new StdSchedulerFactory();
			myScheduler = mySchedulerFactory.getScheduler();
			
			JobDetail jd = new JobDetail("SendMailJob", StdScheduler.DEFAULT_GROUP,SendMailJob.class);
			SimpleTrigger st = new SimpleTrigger("MailTrigger", "MailGroup", SimpleTrigger.REPEAT_INDEFINITELY, (tmpConf.getCGCNF_VALOR_NUMERICO()*60*1000) );
			myScheduler.scheduleJob(jd,st);
			
			JobDetail tmpJobNotifyLeader = new JobDetail("NotifyLeaderJob", StdScheduler.DEFAULT_GROUP, NotifyLeaderJob.class);
			CronTrigger tmpTrigger = new CronTrigger("NotifyLeaderTrigger", StdScheduler.DEFAULT_GROUP, "0 0 0 5 * ?");
			myScheduler.scheduleJob(tmpJobNotifyLeader, tmpTrigger);
			
			JobDetail tmpJobResidentMonitor = new JobDetail("ResidentMonitorJob", StdScheduler.DEFAULT_GROUP, ResidentMonitorJob.class);
			CronTrigger tmpTriggerResidentMonitor = new CronTrigger("ResidentMonitorTrigger", StdScheduler.DEFAULT_GROUP, "0 0 1 * * ?");
			myScheduler.scheduleJob(tmpJobResidentMonitor, tmpTriggerResidentMonitor);
			
			JobDetail tmpJobExcedidoDiasMonitor = new JobDetail("ExcedidoDiasJob", StdScheduler.DEFAULT_GROUP, ExcedidoDiasJob.class);
			CronTrigger tmpTriggerExcedidoDiasMonitor = new CronTrigger("TriggerExcedidoDiasMonitor", StdScheduler.DEFAULT_GROUP, "0 0 23 * * ?");
			myScheduler.scheduleJob(tmpJobExcedidoDiasMonitor, tmpTriggerExcedidoDiasMonitor);
			
			JobDetail tmpJobExcedidoDiasIndiceMonitor = new JobDetail("ExcedidoDiasIndiceJob", StdScheduler.DEFAULT_GROUP, ExcedidoDiasIndiceJob.class);
			CronTrigger tmpTriggerExcedidoDiasIndiceMonitor = new CronTrigger("TriggerExcedidoDiasIndiceMonitor", StdScheduler.DEFAULT_GROUP, "0 0 23 L * ?");
			myScheduler.scheduleJob(tmpJobExcedidoDiasIndiceMonitor, tmpTriggerExcedidoDiasIndiceMonitor);
			
			JobDetail tmpJobResidenciaFormatoMonitor = new JobDetail("ResidenciaFormatoJob", StdScheduler.DEFAULT_GROUP, ResidenciaFormatoJob.class);
			//CronTrigger tmpTriggerResidenciaFormatoMonitor = new CronTrigger("TriggerResidenciaFormatoMonitor", StdScheduler.DEFAULT_GROUP, "0 0/59 * * * ?");
			CronTrigger tmpTriggerResidenciaFormatoMonitor = new CronTrigger("TriggerResidenciaFormatoMonitor", StdScheduler.DEFAULT_GROUP, "0 0 23 * * ?");
			myScheduler.scheduleJob(tmpJobResidenciaFormatoMonitor, tmpTriggerResidenciaFormatoMonitor);
			
			myScheduler.start(); 
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@Override
	public void destroy() {
		super.destroy();
		try {
			myScheduler.deleteJob("SendMailJob", StdScheduler.DEFAULT_GROUP);
			myScheduler.deleteJob("NotifyLeaderJob", StdScheduler.DEFAULT_GROUP);
			myScheduler.deleteJob("ResidentMonitorJob", StdScheduler.DEFAULT_GROUP);
			myScheduler.deleteJob("ExcedidoDiasJob", StdScheduler.DEFAULT_GROUP);
			myScheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
