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
public class Cgg_not_mail implements Serializable{
    private static final long serialVersionUID = 2555616207657289066L;

    private com.besixplus.sii.objects.Cgg_not_mail myCgg_not_mail = null;

    public Cgg_not_mail() {
    }

    public Cgg_not_mail(com.besixplus.sii.objects.Cgg_not_mail myCgg_not_mail) {
        this.myCgg_not_mail = myCgg_not_mail;
    }

    public com.besixplus.sii.objects.Cgg_not_mail getMyCgg_not_mail() {
        return myCgg_not_mail;
    }

    public void setMyCgg_not_mail(com.besixplus.sii.objects.Cgg_not_mail myCgg_not_mail) {
        this.myCgg_not_mail = myCgg_not_mail;
    }
    /*
        ntml_codigo,
		ntml_name,
		ntml_description,
		ntml_subject,
		ntml_type,
		ntml_body,
		ntml_sendheader,
		ntml_sendfooter,
		ntml_header_override,
		ntml_footer_override,
		ntml_estado,
		ntml_fecha_insert,
		ntml_usuario_insert,
		ntml_fecha_update,
		ntml_usuario_update
     */
    public ArrayList<com.besixplus.sii.objects.Cgg_not_mail> selectAll(java.sql.Connection inConnection){
        ArrayList<com.besixplus.sii.objects.Cgg_not_mail> outCgg_not_mail = new ArrayList<>();
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_not_mail_select_all() }");
            stmSelect.registerOutParameter(1, Types.OTHER);
            stmSelect.execute();
            ResultSet results = (ResultSet) stmSelect.getObject(1);
            while (results.next()) {
                com.besixplus.sii.objects.Cgg_not_mail tmpCgg_not_mail = new com.besixplus.sii.objects.Cgg_not_mail();
                tmpCgg_not_mail.setNtml_codigo(results.getString(1));
                tmpCgg_not_mail.setNtml_name(results.getString(2));
                tmpCgg_not_mail.setNtml_description(results.getString(3));
                tmpCgg_not_mail.setNtml_subject(results.getString(4));
                tmpCgg_not_mail.setNtml_type(results.getString(5));
                tmpCgg_not_mail.setNtml_body(results.getString(6));
                tmpCgg_not_mail.setNtml_sendheader(results.getBoolean(7));
                tmpCgg_not_mail.setNtml_sendfooter(results.getBoolean(8));
                tmpCgg_not_mail.setNtml_estado(results.getBoolean(9));
                tmpCgg_not_mail.setNtml_fecha_insert(results.getTimestamp(10));
                tmpCgg_not_mail.setNtml_usuario_insert(results.getString(11));
                tmpCgg_not_mail.setNtml_fecha_update(results.getTimestamp(12));
                tmpCgg_not_mail.setNtml_usuario_update(results.getString(13));
                outCgg_not_mail.add(tmpCgg_not_mail);
            }
            results.close();
            stmSelect.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return outCgg_not_mail;
    }

    public com.besixplus.sii.objects.Cgg_not_mail selectByCode(java.sql.Connection inConnection){
        com.besixplus.sii.objects.Cgg_not_mail outCgg_not_mail = new com.besixplus.sii.objects.Cgg_not_mail();
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.f_cgg_not_mail_selectByCode(?) }");
            stmSelect.registerOutParameter(1, Types.OTHER);
            stmSelect.setString(2,getMyCgg_not_mail().getNtml_codigo());
            stmSelect.execute();
            ResultSet results = (ResultSet) stmSelect.getObject(1);
            while (results.next()) {
                outCgg_not_mail.setNtml_codigo(results.getString(1));
                outCgg_not_mail.setNtml_name(results.getString(2));
                outCgg_not_mail.setNtml_description(results.getString(3));
                outCgg_not_mail.setNtml_subject(results.getString(4));
                outCgg_not_mail.setNtml_type(results.getString(5));
                outCgg_not_mail.setNtml_body(results.getString(6));
                outCgg_not_mail.setNtml_sendheader(results.getBoolean(7));
                outCgg_not_mail.setNtml_sendfooter(results.getBoolean(8));
                outCgg_not_mail.setNtml_estado(results.getBoolean(9));
                outCgg_not_mail.setNtml_fecha_insert(results.getTimestamp(10));
                outCgg_not_mail.setNtml_usuario_insert(results.getString(11));
                outCgg_not_mail.setNtml_fecha_update(results.getTimestamp(12));
                outCgg_not_mail.setNtml_usuario_update(results.getString(13));
            }
            results.close();
            stmSelect.close();
        }catch (SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return outCgg_not_mail;
    }


}
