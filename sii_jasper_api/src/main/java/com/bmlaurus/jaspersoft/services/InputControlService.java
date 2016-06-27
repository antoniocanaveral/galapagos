package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.InputControl;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.bmlaurus.jaspersoft.model.BaseRestModel.HDR_CONTENT_TYPE;

/**
 * Created by acanaveral on 26/6/16.
 */
public class InputControlService extends BaseAPI {

    public List<InputControl> getOrCreateInputControls(File jrxml){
        List<InputControl> inputControls = null;
        if(jrxml!=null && jrxml.isFile()){
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(jrxml);
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("parameter");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        if(eElement.getAttribute("name")!=null && eElement.getAttribute("class")!=null) {
                            System.out.println("Param Name : " + eElement.getAttribute("name"));
                            System.out.println("Param Class : " + eElement.getAttribute("class"));
                            /*if (eElement.getElementsByTagName("defaultValueExpression") != null && eElement.getElementsByTagName("defaultValueExpression").getLength()>0) {
                                System.out.println("Default Expression : " + eElement.getElementsByTagName("defaultValueExpression").item(0).getTextContent());
                            }*/
                            //Creamos el Parametro:
                            if(!eElement.getAttribute("name").equals("SUBREPORT_DIR")){
                                if(inputControls==null)
                                    inputControls = new ArrayList<>();
                                InputControl inputControl = getOrCreateInputControl(eElement.getAttribute("name"), eElement.getAttribute("class"));
                                inputControls.add(inputControl);
                            }
                        }else
                            log.error("Control error: missing name or class");
                    }
                }
            }catch (ParserConfigurationException ex){
                ex.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputControls;
    }

    public InputControl getOrCreateInputControl(String controlName, String className){
        InputControl inputControl = null;
        HttpResponse httpRes = null;
        if(loginToServer()){
            try {
                //Buscamos el control
                HttpGet get = new HttpGet();
                inputControl = new InputControl();
                get.setHeader(HDR_CONTENT_TYPE, inputControl.getConten_type());
                get.setHeader("Accept", "application/json");
                httpRes = sendRequest(get, config.getProperty("RESOURCE") + config.getProperty("SII_CONTROLS_PATH") + "/"+ controlName, null);
                if (validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                        releaseConnection(httpRes);
                        inputControl = createInputControl(controlName,className);
                    } else {
                        inputControl = getEntity(httpRes, InputControl.class);
                        releaseConnection(httpRes);
                    }
                }
            }catch (Exception e){
                log.error(e);
            }
        }
        return inputControl;
    }

    private InputControl createInputControl(String controlName, String className){
        InputControl result = null;
        HttpResponse httpRes = null;
        try {
            //Buscamos la carpeta
            HttpPut put = new HttpPut();
            InputControl control = new InputControl();
            control.setLabel(controlName);
            control.setId(controlName);
            control.resolveType(className);
            control.setUri(config.getProperty("RESOURCE") + config.getProperty("SII_CONTROLS_PATH") + "/" +controlName);
            control.setDescription(config.getProperty("SII_DESCRIPTION"));
            control.setVisible(true);
            control.resolveDataType(className);
            //jasper.setUri(config.getProperty("RESOURCE") + basePath +"/"+ parentPath + (parentPath.isEmpty() ? "" : "/") + reportName);
            put.setHeader(HDR_CONTENT_TYPE, control.getConten_type());
            put.setHeader("Accept", "application/json");
            put.setEntity(new StringEntity(getGsonEngine().getGson().toJson(control)));
            httpRes = sendRequest(put, config.getProperty("RESOURCE") + config.getProperty("SII_CONTROLS_PATH") + "/"+ controlName,null);
            if(validateRequest(httpRes)) {
                if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
                        || httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = getEntity(httpRes, InputControl.class);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }finally {
            releaseConnection(httpRes);
        }
        return  result;
    }


}
