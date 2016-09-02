package com.besixplus.sii.servlets;

import com.bmlaurus.db.MasBuscadosData;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 1/9/16.
 */
public class MasBuscadosImporter extends HttpServlet implements Serializable {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8"));
        String collect = "";
        if(br != null){
            collect = br.readLine();
        }
        String result = "{false}";
        if(collect!=null) {
            List<Map> receiver = new Gson().fromJson(collect, List.class);
            try {
                Connection connection = com.besixplus.sii.db.ManagerConnection.getConnection();
                for(Map data:receiver){
                    String res = MasBuscadosData.insert(connection, data);
                    if(res==null||res.equals("false"))
                        break;
                }
                result = "{true}";
                connection.close();
            } catch (SQLException e) {
                com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
            }
        }
        resp.setContentType("application/json");
        resp.getWriter().println(result);
    }
}
