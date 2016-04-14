package com.besixplus.sii.job;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.besixplus.sii.db.Cgg_ger_indicador_encargado;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_buzon_correo;

public class NotifyLeaderJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Messages myInfoMessages = new Messages(Messages.Types.Info);
		Connection tmpConnection = ManagerConnection.getConnection();
		try {
			tmpConnection.setAutoCommit(false);
			ArrayList<HashMap<String, Object>> tmpLeaders = new Cgg_ger_indicador_encargado().selectLeader(tmpConnection);
			for (HashMap<String, Object> tmpLeader : tmpLeaders) {
				Cgg_buzon_correo tmpBuzon = new Cgg_buzon_correo();
				tmpBuzon.setCBZC_CODIGO("KEYGEN");
				tmpBuzon.setCBZC_DESTINATARIO(tmpLeader.get("CSUCT_CONTACTO").toString());
				tmpBuzon.setCBZC_ASUNTO("Recordatorio Gerencial");
				tmpBuzon.setCBZC_MENSAJE(myInfoMessages.getMessage("sii.gerencial.indicador.notificacion", new String[]{tmpLeader.get("CGGIN_NOMBRE").toString(),tmpLeader.get("CCTN_NOMBRE").toString()}));
				tmpBuzon.setCBZC_ESTADO(true);
				tmpBuzon.setCBZC_TIPO_CONTENIDO("text/html");
				tmpBuzon.setCBZC_USUARIO_INSERT("notifyleader");
				tmpBuzon.setCBZC_USUARIO_UPDATE("notifyleader");
				new com.besixplus.sii.db.Cgg_buzon_correo(tmpBuzon).insert(tmpConnection);
			}
			tmpConnection.commit();
			tmpConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
