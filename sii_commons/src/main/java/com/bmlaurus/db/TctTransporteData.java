package com.bmlaurus.db;

import com.bmlaurus.objects.TctTransporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 24/8/16.
 */
public class TctTransporteData {

    public static List<TctTransporte> getAllTransportes(Connection inConnection){
        List<TctTransporte> transportes = new ArrayList<>();

        String strSql = "SELECT * FROM SII.CGG_TCT_TRANSPORTE WHERE TCTTR_ESTADO";

        PreparedStatement stmt=null;
        ResultSet results=null;
        try {
            stmt = inConnection.prepareStatement(strSql);
            results = stmt.executeQuery();

            while (results.next()){
                TctTransporte transporte = new TctTransporte();
                transporte.setCodigo(results.getString("TCTTR_CODIGO"));
                transporte.setCodigoAerolinea(results.getString("CRALN_CODIGO"));
                transporte.setCodigoAeropuerto(results.getString("CARPT_CODIGO"));
                transporte.setVuelo(results.getString("TCTTR_NUMERO"));
                transporte.setEstado(results.getBoolean("TCTTR_ESTADO"));
                transporte.setFechaInsert(results.getDate("TCTTR_FECHA_INSERT"));
                transporte.setFechaUpdate(results.getDate("TCTTR_FECHA_UPDATE"));
                transporte.setUsuarioInsert(results.getString("TCTTR_USUARIO_INSERT"));
                transporte.setUsuarioUpdate(results.getString("TCTTR_USUARIO_UPDATE"));

                transportes.add(transporte);
            }

            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return transportes;
    }
}
