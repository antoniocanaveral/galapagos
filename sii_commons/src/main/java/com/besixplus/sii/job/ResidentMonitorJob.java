package com.besixplus.sii.job;

import com.besixplus.sii.db.Cgg_extras;
import com.besixplus.sii.db.ManagerConnection;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Connection;
import java.sql.SQLException;

public class ResidentMonitorJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Connection tmpConnection = ManagerConnection.getConnection();
		try {
			String tmpRes = new Cgg_extras().residenciaMonitor(tmpConnection);
			
			if(!tmpRes.equalsIgnoreCase("true")){
				/**Cgg_configuracion tmpConf = new Cgg_configuracion();
				tmpConf.setCGCNF_CODIGO("CONF53");
				new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpConnection);
				if(tmpConf.getCGCNF_VALOR_CADENA()!= null && !tmpConf.getCGCNF_VALOR_CADENA().trim().isEmpty()){
					Cgg_buzon_correo tmpBuzon = new Cgg_buzon_correo();
					tmpBuzon.setCBZC_CODIGO("KEYGEN");
					tmpBuzon.setCBZC_ASUNTO("Error en el monitor de residencias");
					tmpBuzon.setCBZC_DESTINATARIO(tmpConf.getCGCNF_VALOR_CADENA());
					tmpBuzon.setCBZC_ESTADO(true);
					tmpBuzon.setCBZC_TIPO_CONTENIDO("text/plain");
					tmpBuzon.setCBZC_USUARIO_INSERT("monitor");
					tmpBuzon.setCBZC_USUARIO_UPDATE("monitor");
					tmpBuzon.setCBZC_MENSAJE(tmpRes);
					new com.besixplus.sii.db.Cgg_buzon_correo(tmpBuzon).insert(tmpConnection);
				}**/
				System.err.println("MONITOR DE RESIDENCIA != true: "+ tmpRes);
			}
			tmpConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
