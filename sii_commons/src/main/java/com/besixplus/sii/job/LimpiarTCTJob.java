package com.besixplus.sii.job;

import com.besixplus.sii.db.Cgg_extras;
import com.besixplus.sii.db.ManagerConnection;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral on 9/9/16.
 */
public class LimpiarTCTJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Connection tmpConnection = ManagerConnection.getConnection();
        try {
            String tmpRes = new Cgg_extras().limpiarTCT(tmpConnection);
            tmpConnection.close();
            if(!tmpRes.equalsIgnoreCase("true")){
                System.err.println("LIMPIAR TCT != true: "+ tmpRes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
