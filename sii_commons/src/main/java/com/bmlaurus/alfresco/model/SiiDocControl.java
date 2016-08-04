package com.bmlaurus.alfresco.model;

import java.io.Serializable;
import java.sql.*;

/**
 * Created by acanaveral on 4/8/16.
 */
public class SiiDocControl implements Serializable {
    private static final long serialVersionUID = 7539419966726689781L;
    public static final String DOCUMENT_TYPE_CEDULA="cedula";
    public static final String DOCUMENT_TYPE_PAPELETA="papeleta";
    public static final String DOCUMENT_TYPE_RUC="ruc";

    private String document_type;
    private String record_id;
    private Date date_created;


    public SiiDocControl(String document_type, String record_id) {
        this.document_type = document_type;
        this.record_id = record_id;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public void query(Connection conn){
        try {
            PreparedStatement pstmt = conn.prepareCall("SELECT date_created FROM sii.cgg_ecm_doc_control WHERE document_type = ? AND record_id = ?");
            pstmt.setString(1,document_type);
            pstmt.setString(2,record_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs!=null && rs.next()){
                date_created = rs.getDate("date_created");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean save(Connection conn){
        boolean result = false;
        date_created = new Date(System.currentTimeMillis());
        try {
            PreparedStatement pstmt = conn.prepareCall("SELECT document_type,record_id FROM sii.cgg_ecm_doc_control WHERE document_type = ? AND record_id = ?");
            pstmt.setString(1,document_type);
            pstmt.setString(2,record_id);
            ResultSet rs = pstmt.executeQuery();
            String strSQL = null;
            PreparedStatement statement;
            if(rs!=null && rs.next()){
                rs.close();
                pstmt.close();
                //Empezamos con la persistencia
                strSQL = "UPDATE sii.cgg_ecm_doc_control SET document_type=?, record_id=?, date_created=? WHERE document_type = ? AND record_id = ?";
                statement = conn.prepareStatement(strSQL);
                statement.setString(1,document_type);
                statement.setString(2,record_id);
                statement.setDate(3, date_created);
                //
                statement.setString(4,document_type);
                statement.setString(5,record_id);
            }else{//INSERT
                strSQL = "INSERT INTO sii.cgg_ecm_doc_control (document_type, record_id, date_created) " +
                        "    VALUES (?, ?, ?);";
                statement = conn.prepareStatement(strSQL);
                statement.setString(1,document_type);
                statement.setString(2,record_id);
                statement.setDate(3, date_created);
            }
            statement.execute();
            statement.close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
