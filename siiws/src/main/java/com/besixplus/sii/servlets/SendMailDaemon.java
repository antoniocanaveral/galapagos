package com.besixplus.sii.servlets;

import com.besixplus.sii.util.Env;
import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;
import com.bmlaurus.job.BaseJob;
import com.bmlaurus.job.BaseTrigger;
import com.bmlaurus.virtual.VirtualCache;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
        	/*Connection tmpConnection = ManagerConnection.getConnection();
        	tmpConnection.setAutoCommit(false);
        	Cgg_configuracion tmpConf = new Cgg_configuracion();
        	tmpConf.setCGCNF_CODIGO("CONF41");
        	new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpConnection);
        	
        	tmpConnection.setAutoCommit(true);
        	tmpConnection.close();*/
        	
			mySchedulerFactory = new StdSchedulerFactory();
			myScheduler = mySchedulerFactory.getScheduler();

			Properties props = VirtualCache.getConfig(VirtualCache.PROP_CRON_CONF);
			if(props!=null && props.getProperty("cron.jobs") != null) {
				Type jobList = new TypeToken<ArrayList<BaseJob>>() {
				}.getType();
				List<BaseJob> jobs = (List<BaseJob>) new Gson().fromJson(props.getProperty("cron.jobs"), jobList);

				ClassLoader externalClassLoader = this.getClass().getClassLoader();
				if(Env.resolveClassPath("cron/lib")!=null)
					externalClassLoader = new URLClassLoader (Env.resolveClassPath("cron/lib"), this.getClass().getClassLoader());

				for(BaseJob job:jobs){
					try {
						Class clazz = Class.forName(props.getProperty("cron.base")+job.getClassName(),false,externalClassLoader);
						JobDetail jd = new JobDetail(job.getName(), job.getGroup(), clazz);
						BaseTrigger trigger = job.getTrigger();
						if(trigger!=null){
							Trigger st = null;
							if(trigger.getType().equals(BaseTrigger.TYPE_SIMPLE))
								st = new SimpleTrigger(trigger.getName(),trigger.getGroup(),trigger.getRepeatCount(),trigger.getRepeatInterval()*60*1000);
							else if(trigger.getType().equals(BaseTrigger.TYPE_CRON))
								st = new CronTrigger(trigger.getName(),trigger.getGroup(),trigger.getCronExpression());
							else
								throw new Exception("Unsuported Trigger Exeption: "+ trigger.getType());

							myScheduler.scheduleJob(jd,st);

						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			/*JobDetail jd = new JobDetail("SendMailJob", StdScheduler.DEFAULT_GROUP,SendMailJob.class);
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
			myScheduler.scheduleJob(tmpJobResidenciaFormatoMonitor, tmpTriggerResidenciaFormatoMonitor);*/
			
			myScheduler.start(); 
		} catch (SchedulerException e) {
			e.printStackTrace();
		} /*catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/ catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (EnvironmentVariableNotDefinedException e) {
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
			Properties props = VirtualCache.getConfig(VirtualCache.PROP_CRON_CONF);
			if(props!=null && props.getProperty("cron.jobs") != null) {
				Type jobList = new TypeToken<ArrayList<BaseJob>>() {
				}.getType();
				List<BaseJob> jobs = (List<BaseJob>) new Gson().fromJson(props.getProperty("cron.jobs"), jobList);
				for(BaseJob job:jobs){
					myScheduler.deleteJob(job.getName(),job.getGroup());
				}
			}
			myScheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
