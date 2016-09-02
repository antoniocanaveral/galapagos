package com.bmlaurus.db;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by acanaveral on 1/9/16.
 */
public class MasBuscadosData {
    public static String insert(Connection conn, Map record){
        String res="false";
        try {
            String strSQL = "INSERT INTO cgg_srv_mas_buscados(\n" +
                    "            tipoidentificacion, identificacion, apellidopaterno, apellidomaterno, \n" +
                    "            nombres, fecha, estado)\n" +
                    "    VALUES (?, ?, ?, ?, \n" +
                    "            ?, ?, ?);";

            PreparedStatement statement;

            statement = conn.prepareStatement(strSQL);
            statement.setString(1,(String) record.get("tipoIdentificacion"));
            statement.setString(2,(String) record.get("identificacion"));
            statement.setString(3,(String) record.get("apellidoPaterno"));
            statement.setString(4,(String) record.get("apellidoMaterno"));
            statement.setString(5,(String) record.get("nombres"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                statement.setDate(6,new Date(sdf.parse(record.get("fecha").toString()).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            statement.setBoolean(7,(Boolean) record.get("estado"));

            statement.execute();
            statement.close();

            res="true";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean exists(Connection conn, String identificacion){
        boolean exist = false;
        String strSql = "SELECT identificacion FROM SII.cgg_srv_mas_buscados WHERE identificacion=?";

        PreparedStatement stmt=null;
        ResultSet results=null;
        try {
            stmt = conn.prepareStatement(strSql);
            stmt.setString(1,identificacion);
            results = stmt.executeQuery();
            if(results!=null && results.next()){
                exist = true;
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return exist;
    }
}
