package com.bmlaurus.ws.service;

import com.besixplus.sii.util.Env;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by acanaveral on 29/6/16.
 */
public class ConnectionUtils {


    public String getFichaGeneral(String numeroIdentificacion, int codigoPaquete) throws MalformedURLException,
            IOException {

        Properties config = Env.getExternalProperties("dinardap/config.properties");

        //Code to make a webservice HTTP request
        String responseString = "";
        String outputString = "";
        String wsURL = config.getProperty("wsurl");
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection)connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput = config.getProperty("body");
        //Reemplazamos los parametros
        xmlInput = xmlInput.replaceFirst("\\?",numeroIdentificacion);
        xmlInput = xmlInput.replaceFirst("\\?",codigoPaquete+"");

        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length",String.valueOf(b.length));
        Type headersListType = new TypeToken<ArrayList<String>>() {
        }.getType();

        List<String> headers = new Gson().fromJson(config.getProperty("headers"),headersListType);
        for(String head: headers){
            String[] prop = head.split("\\$");
            httpConn.setRequestProperty(prop[0],prop[1]);
        }


        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        //Write the content of the request to the outputstream of the HTTP Connection.
        out.write(b);
        out.close();
        //Ready with sending the request.

        //Read the response.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        //Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }

        //Devolvemos un JSON con el resultado
        JSONObject result = org.json.XML.toJSONObject(outputString);
        return result.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("ns2:getFichaGeneralResponse").getJSONObject("return").toString();
    }
}
