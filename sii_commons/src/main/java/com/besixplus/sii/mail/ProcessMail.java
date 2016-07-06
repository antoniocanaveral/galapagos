package com.besixplus.sii.mail;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_not_fase_notificacion;
import com.besixplus.sii.objects.Cgg_res_seguimiento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by acanaveral on 6/7/16.
 */
public class ProcessMail extends Thread{

    private Cgg_res_seguimiento seguimiento;

    public ProcessMail(Cgg_res_seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Override
    public void run() {
        Connection objConn= ManagerConnection.getConnection();
        try {
            objConn.setAutoCommit(false);
            String crfs_codigo = seguimiento.getCGG_CRFAS_CODIGO();
            Cgg_not_fase_notificacion objNot = new Cgg_not_fase_notificacion();
            objNot.setCrfas_codigo(crfs_codigo);
            ArrayList<Cgg_not_fase_notificacion> notifications = new com.besixplus.sii.db.Cgg_not_fase_notificacion(objNot).selectByFase(objConn);
            for(Cgg_not_fase_notificacion not:notifications){
                //TODO:IMPLEMENTAR LA NOTIFICACION POR MAIL
                System.out.println("NOTIFICACION por MAIL");
            }
            objConn.setAutoCommit(true);
            objConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
