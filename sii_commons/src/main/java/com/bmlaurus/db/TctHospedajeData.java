package com.bmlaurus.db;

import com.bmlaurus.objects.TctHospedaje;

import java.sql.*;

/**
 * Created by acanaveral on 26/8/16.
 */
public class TctHospedajeData {


    private static String getNewCode(Connection inConnection) throws SQLException {
        String code=null;
        CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.f_keygen(?,?,?) }");
        stmInsert.registerOutParameter(1, Types.VARCHAR);
        stmInsert.setString(2,"Cgg_tct_hospedaje");
        stmInsert.setString(3,"cthos_codigo");
        stmInsert.setString(4,"CTHOS");
        stmInsert.execute();
        code = stmInsert.getString(1);
        stmInsert.close();
        return code;
    }


    public static String insert(Connection conn, TctHospedaje hospedaje){
        String res="false";
        try {

            hospedaje.setEstado(true);
            hospedaje.setCodigo(getNewCode(conn));
            hospedaje.setFechaInsert(new Date(System.currentTimeMillis()));
            hospedaje.setFechaUpdate(new Date(System.currentTimeMillis()));

            String strSQL = "INSERT INTO cgg_tct_hospedaje(\n" +
                    "            cthos_codigo, ctreg_codigo, cthos_tipo, cisla_codigo, cthos_lugar, \n" +
                    "            cthos_fechaingreso, cthos_fechasalida, cthos_reserva, cthos_estado, \n" +
                    "            cthos_fecha_insert, cthos_usuario_insert, cthos_fecha_update, \n" +
                    "            cthos_usuario_update)\n" +
                    "    VALUES (?, ?, ?, ?, ?, \n" +
                    "            ?, ?, ?, ?, \n" +
                    "            ?, ?, ?, \n" +
                    "            ?)";


            PreparedStatement statement;

            statement = conn.prepareStatement(strSQL);
            statement.setString(1,hospedaje.getCodigo());
            statement.setString(2,hospedaje.getCodigoPreregistro());
            statement.setString(3,hospedaje.getTipoHospedaje());
            statement.setString(4,hospedaje.getCodigoIsla());
            statement.setString(5,hospedaje.getLugarHospedaje());
            statement.setDate(6,hospedaje.getFechaIngreso());
            statement.setDate(7,hospedaje.getFechaSalida());
            statement.setString(8,hospedaje.getReserva());
            statement.setBoolean(9,hospedaje.isEstado());
            statement.setDate(10, hospedaje.getFechaInsert());
            statement.setString(11, hospedaje.getUsuarioInsert());
            statement.setDate(12, hospedaje.getFechaUpdate());
            statement.setString(13, hospedaje.getUsuarioUpdate());

            statement.execute();
            statement.close();

            res="true";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

}
