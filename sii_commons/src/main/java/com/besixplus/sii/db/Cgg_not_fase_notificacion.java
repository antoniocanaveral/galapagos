package com.besixplus.sii.db;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 * Created by acanaveral on 4/7/16.
 */
public class Cgg_not_fase_notificacion implements Serializable {

    private static final long serialVersionUID = -6480162500905704585L;

    private com.besixplus.sii.objects.Cgg_not_fase_notificacion myCgg_not_fase_notificacion = null;


    public Cgg_not_fase_notificacion() {
    }

    public Cgg_not_fase_notificacion(com.besixplus.sii.objects.Cgg_not_fase_notificacion myCgg_not_fase_notificacion) {
        this.myCgg_not_fase_notificacion = myCgg_not_fase_notificacion;
    }

    public com.besixplus.sii.objects.Cgg_not_fase_notificacion getCgg_not_fase_notificacion() {
        return myCgg_not_fase_notificacion;
    }

    public void setCgg_not_fase_notificacion(com.besixplus.sii.objects.Cgg_not_fase_notificacion myCgg_not_fase_notificacion) {
        this.myCgg_not_fase_notificacion = myCgg_not_fase_notificacion;
    }

    public ArrayList<com.besixplus.sii.objects.Cgg_not_fase_notificacion> selectByFase(
            java.sql.Connection inConnection
    ){
        ArrayList<com.besixplus.sii.objects.Cgg_not_fase_notificacion> outCgg_not_fase_notificacion = new ArrayList<>();
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_not_fase_notification_select(?) }");
            stmSelect.registerOutParameter(1, Types.OTHER);
            stmSelect.setString(2, getCgg_not_fase_notificacion().getCrfas_codigo());
            stmSelect.execute();
            ResultSet results = (ResultSet) stmSelect.getObject(1);
            while (results.next()) {
                com.besixplus.sii.objects.Cgg_not_fase_notificacion tmpCgg_not_fase_notificacion = new com.besixplus.sii.objects.Cgg_not_fase_notificacion();
                tmpCgg_not_fase_notificacion.setCrpro_codigo(results.getString(1));
                tmpCgg_not_fase_notificacion.setCrfas_codigo(results.getString(2));
                tmpCgg_not_fase_notificacion.setNtml_codigo(results.getString(3));
                tmpCgg_not_fase_notificacion.setNtfn_destinatario(results.getString(4));
                tmpCgg_not_fase_notificacion.setNtfn_estado(results.getBoolean(5));
                outCgg_not_fase_notificacion.add(tmpCgg_not_fase_notificacion);
            }
            results.close();
            stmSelect.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return outCgg_not_fase_notificacion;
    }

    /**
     * ELIMINA UN REGISTRO DE LA TABLA Cgg_not_fase_notificacion.
     * @param inConnection CONEXION A LA BASE DE DATOS.
     * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
     */
    public boolean deleteTrusted(
            java.sql.Connection inConnection
    ){
        boolean outResult = true;
        try{

            CallableStatement stmDelete = inConnection.prepareCall("{ call sii.f_cgg_not_fase_notification_delete(?,?,?,?) }");
            stmDelete.setString(1, this.getCgg_not_fase_notificacion().getCrpro_codigo());
            stmDelete.setString(2, this.getCgg_not_fase_notificacion().getCrfas_codigo());
            stmDelete.setString(3, this.getCgg_not_fase_notificacion().getNtml_codigo());
            stmDelete.setString(4, this.getCgg_not_fase_notificacion().getNtfn_destinatario());
            stmDelete.execute();
            stmDelete.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
            outResult = false;
        }

        return outResult;
    }


    /**
     * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_criterio.
     * @param inConnection CONEXION A LA BASE DE DATOS.
     * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
     */
    public String insert(
            java.sql.Connection inConnection
    ){
        String outResult = "true";
        try{
            CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.f_cgg_not_fase_notification_insert(?, ?, ?, ?, ?, ?, ?) }");
            stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
            stmInsert.setString(2, this.getCgg_not_fase_notificacion().getCrpro_codigo());
            stmInsert.setString(3, this.getCgg_not_fase_notificacion().getCrfas_codigo());
            stmInsert.setString(4, this.getCgg_not_fase_notificacion().getNtml_codigo());
            stmInsert.setString(5, this.getCgg_not_fase_notificacion().getNtfn_destinatario());
            stmInsert.setBoolean(6, this.getCgg_not_fase_notificacion().isNtfn_estado());
            stmInsert.setString(7, this.getCgg_not_fase_notificacion().getNtfn_usuario_insert());
            stmInsert.setString(8, this.getCgg_not_fase_notificacion().getNtfn_usuario_update());
            stmInsert.execute();
            stmInsert.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
            outResult = e.getMessage();
        }
        return outResult;
    }
}
