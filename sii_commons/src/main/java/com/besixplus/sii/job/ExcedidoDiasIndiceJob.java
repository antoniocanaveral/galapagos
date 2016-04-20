package com.besixplus.sii.job;

import com.besixplus.sii.db.Cgg_extras;
import com.besixplus.sii.db.ManagerConnection;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Tarea programada para excedido de dias indice.
 * @author BESIXPLUS CIA. LTDA.
 */
public class ExcedidoDiasIndiceJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Connection tmpConnection = ManagerConnection.getConnection();
		try {
			new Cgg_extras().ExcedidoDiasIndiceMonitor(tmpConnection);
			tmpConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

