package com.besixplus.sii.servlets;

import com.bmlaurus.virtual.VirtualCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Created by acanaveral on 11/8/16.
 */
public class CacheController extends HttpServlet implements Serializable {

    /* Se invoca de la siguiente manera: operation=view, operation=reset, operation=remove:jasper/conf.properties */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Cache Controller</title></head>");
            out.println("<body>");
            out.println("<h1>Cache Controller</h1>");
            // Echo client's request information
            out.println("<h3>Client Info</h3>");
            out.println("<p>Request URI: " + req.getRequestURI() + "</p>");
            out.println("<p>Protocol: " + req.getProtocol() + "</p>");
            out.println("<p>Service Path: " + req.getServletPath() + "</p>");
            out.println("<p>Remote Address: " + req.getRemoteAddr() + "</p>");
            out.println("<br/><br/>");

            String query = req.getQueryString();
            if(query != null){
                String operationID = query.split("=")[1];
                out.println("<h3>Operation ID: [ " + operationID+ " ] </h3>");
                if(operationID!=null){
                    switch (operationID){
                        case "reset":
                            VirtualCache.resetCache();
                            out.println("<p>CACHE RESETED</p>");
                            break;
                        case "view":
                            out.println("<p>"+VirtualCache.toPrettyJSON()+"</p>");
                            break;
                        default:
                            out.println("<p>Not implemented yet</p>");
                            break;
                    }
                }else
                    out.println("<p>Usage: CacheControllerSVR?operation=view, CacheControllerSVR?operation=reset</p>");
            }else
                out.println("<p>Usage: CacheControllerSVR?operation=view, CacheControllerSVR?operation=reset</p>");

        }catch (Exception ex){
            out.println("<p>ERROR: " + ex.getMessage() + "</p>");
        }finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}
