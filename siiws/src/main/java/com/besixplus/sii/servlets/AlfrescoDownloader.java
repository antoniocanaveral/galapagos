package com.besixplus.sii.servlets;

import com.bmlaurus.alfresco.AlfrescoActions;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by acanaveral on 1/6/16.
 */
public class AlfrescoDownloader extends HttpServlet implements Serializable {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String query = request.getQueryString();
            if(query != null){
                String fileId = query.split("=")[1];
                DataHandler file = AlfrescoActions.getDocument(fileId);
                String mimeType = file.getContentType();
                if (mimeType == null) {
                    // set to binary type if MIME mapping not found
                    mimeType = "application/octet-stream";
                }
                InputStream inStream = file.getInputStream();

                response.setContentType(mimeType);
                response.setContentLength(inStream.available());

                // forces download
                String headerKey = "Content-Disposition";
                String headerValue = String.format("inline; filename=\"%s\"", file.getName());
                response.setHeader(headerKey, headerValue);

                // obtains response's output stream
                OutputStream outStream = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }

                inStream.close();
                outStream.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
