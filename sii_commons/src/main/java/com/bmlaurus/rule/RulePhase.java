package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_res_tramite;
import com.besixplus.sii.objects.Cgg_res_seguimiento;

import java.sql.Connection;

/**
 * Created by acanaveral on 7/7/16.
 */
public interface RulePhase {

    /**
     * @param inUserName USUARIO ENCARGADO DE CUMPLIR CON EL SEGUIMIENTO.
     * */
    String executeRule(Cgg_res_seguimiento objSeguimiento, Cgg_res_tramite tramite, String inUserName);

    void setConnection(Connection conn);
}
