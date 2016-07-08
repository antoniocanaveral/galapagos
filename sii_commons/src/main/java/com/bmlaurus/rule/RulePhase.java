package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_tramite;

import java.sql.Connection;

/**
 * Created by acanaveral on 7/7/16.
 */
public abstract class RulePhase {


    protected Connection connection;

    public RulePhase(Connection connection) {
        this.connection = connection;
    }

    /**
     * @param inUserName USUARIO ENCARGADO DE CUMPLIR CON EL SEGUIMIENTO.
     * */
    public abstract String executeRule(Cgg_res_seguimiento objSeguimiento, Cgg_res_tramite tramite, String inUserName);
}
