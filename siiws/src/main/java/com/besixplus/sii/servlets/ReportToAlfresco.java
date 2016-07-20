package com.besixplus.sii.servlets;

import com.bmlaurus.attachment.ResolucionAttachment;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by acanaveral on 13/7/16.
 */
public class ReportToAlfresco extends HttpServlet implements Serializable {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8"));
        String collect = "";
        if(br != null){
            collect = br.readLine();
        }
        String result = "{false}";
        if(collect!=null) {
            Map receiver = new Gson().fromJson(collect, Map.class);

            String CRRST_CODIGO = (String) receiver.get("CRRST_CODIGO");
            String CRRES_CODIGO = (String) receiver.get("CRRES_CODIGO");
            String CRTRA_CODIGO = (String) receiver.get("CRTRA_CODIGO");
            String REPORT_NAME = (String) receiver.get("REPORT_NAME");

            ResolucionAttachment attachment = new ResolucionAttachment(CRRST_CODIGO, "Cgg_res_resol_tramite", null);
            attachment.setReportName(REPORT_NAME);
            try {
                String attach = attachment.attachReport();
                if(attach!=null)
                    result = "{"+attach+"}";
            } catch (SQLException e) {
                com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
            }
        }
        resp.setContentType("application/json");
        resp.getWriter().println(result);
    }
}
