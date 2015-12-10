package com.besixplus.sii.job;

import java.sql.Connection;
import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.besixplus.sii.db.Cgg_extras;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.db.Cgg_res_movilidad;

/**
 * Tarea programada para generacion de formato de residencias.
 * @author BESIXPLUS CIA. LTDA.
 */
public class ResidenciaFormatoJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Connection tmpConnection = ManagerConnection.getConnection();
		try {
			new Cgg_res_movilidad().ResidenciaFormatoJob(tmpConnection);
			tmpConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
	}

}

