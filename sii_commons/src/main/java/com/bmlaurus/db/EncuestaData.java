package com.bmlaurus.db;

import com.bmlaurus.objects.ItemEncuesta;
import com.bmlaurus.objects.PreguntaEncuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 23/8/16.
 */
public class EncuestaData {

    public static List<PreguntaEncuesta> getAllPreguntas(Connection inConnection, String categoria_pregunta){
        List<PreguntaEncuesta> preguntas = new ArrayList<>();

        String strSql = "SELECT PRE.*,ITM.* " +
                " FROM SII.CGG_ENC_PREGUNTA PRE " +
                " JOIN SII.CGG_ENC_ITEM ITM ON PRE.ENCPR_CODIGO = ITM.ENCPR_CODIGO " +
                " WHERE PRE.ENCPR_ESTADO AND ITM.ENCIT_ESTADO AND PRE.ENCPR_CATEGORIA=?" +
                " ORDER BY PRE.ENCPR_CODIGO, ITM.ENCIT_CODIGO";

        PreparedStatement stmt=null;
        ResultSet results=null;
        try {
            stmt = inConnection.prepareStatement(strSql);
            stmt.setString(1, categoria_pregunta);
            results = stmt.executeQuery();

            String preguntaCode = null;
            PreguntaEncuesta pregunta = null;
            List<ItemEncuesta> items = null;
            while (results.next()){
                if(!results.getString("ENCPR_CODIGO").equals(preguntaCode)){

                    if(items!=null && items.size()>0 && pregunta!=null) {
                        pregunta.setItems(items);
                        preguntas.add(pregunta);
                    }

                    items = new ArrayList<>();
                    preguntaCode = results.getString("ENCPR_CODIGO");
                    pregunta = new PreguntaEncuesta();
                    pregunta.setCodigo(results.getString("ENCPR_CODIGO"));
                    pregunta.setTipo(results.getString("ENCPR_TYPE"));
                    pregunta.setCategoria(results.getString("ENCPR_CATEGORIA"));
                    pregunta.setDescripcion(results.getString("ENCPR_DESCRIPCION"));
                    pregunta.setEstado(results.getBoolean("ENCPR_ESTADO"));
                    pregunta.setFechaInsert(results.getDate("ENCPR_FECHA_INSERT"));
                    pregunta.setFechaUpdate(results.getDate("ENCPR_FECHA_UPDATE"));
                    pregunta.setUsuarioInsert(results.getString("ENCPR_USUARIO_INSERT"));
                    pregunta.setUsuarioUpdate(results.getString("ENCPR_USUARIO_UPDATE"));
                }

                ItemEncuesta item = new ItemEncuesta();
                item.setCodigo(results.getString("ENCIT_CODIGO"));
                item.setCodigoPregunta(preguntaCode);
                item.setDescripcion(results.getString("ENCIT_DESCRIPCION"));
                item.setEstado(results.getBoolean("ENCIT_ESTADO"));
                item.setFechaInsert(results.getDate("ENCIT_FECHA_INSERT"));
                item.setFechaUpdate(results.getDate("ENCIT_FECHA_UPDATE"));
                item.setUsuarioInsert(results.getString("ENCIT_USUARIO_INSERT"));
                item.setUsuarioUpdate(results.getString("ENCIT_USUARIO_UPDATE"));

                items.add(item);
            }

            if(items!=null && items.size()>0 && pregunta!=null) {
                pregunta.setItems(items);
                preguntas.add(pregunta);
            }

            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return preguntas;
    }
}
