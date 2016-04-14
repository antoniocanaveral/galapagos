package com.besixplus.sii.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class InitParameters {

    private String ipServidor = "";
    private String puertoServidor = "";
    private String ipBDD = "";
    private String puertoBDD = "";
    private String nombreBDD = "";
    private String ipReportes = "";
    private String puertoReportes = "";
    private String pathXml = "/home/advance/Desktop/ADVANCE/PROYECTO SII/SERVIDOR/jboss-5.1.0.GA/server/default/deploy/parameters.xml";
    private String userBdd="";
    private String passwordBDD="";

    public InitParameters (){
        getParameters();
    }

    /**
     * Obtiene los datos de los parámetros del archivo xml en el servidor
     */
    public void getParameters() {
        try {
            DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse(pathXml);
            Element raiz = documento.getDocumentElement();
            Node bddIp = raiz.getElementsByTagName("bdd-ip").item(0);
            ipBDD = bddIp.getNodeValue();
            System.out.print(ipBDD+puertoServidor+ipServidor+puertoBDD+ipReportes);
            Node bddPort = raiz.getElementsByTagName("bdd-port").item(0);
            puertoBDD = bddPort.getNodeValue();
            Node bddName = raiz.getElementsByTagName("bdd-name").item(0);
            nombreBDD = bddName.getNodeValue();
            Node serverIp = raiz.getElementsByTagName("server-ip").item(0);
            ipServidor = serverIp.getNodeValue();
            Node serverPort = raiz.getElementsByTagName("server-port").item(0);
            puertoServidor = serverPort.getNodeValue();
            Node reportIp = raiz.getElementsByTagName("report-ip").item(0);
            ipReportes = reportIp.getNodeValue();
            Node reportPort = raiz.getElementsByTagName("report-port").item(0);
            puertoReportes = reportPort.getNodeValue();
            Node bddUser = raiz.getElementsByTagName("bdd-user").item(0);
            userBdd=bddUser.getNodeValue();
            Node passBDD = raiz.getElementsByTagName("bdd-pass").item(0);
            passwordBDD=passBDD.getNodeValue();
        } catch (SAXException ex) {
            System.out.println("ERROR: El formato XML del fichero no es correcto\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n" + ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n" + ex.getMessage());
        }

    }


    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public String getPuertoServidor() {
        return puertoServidor;
    }

    public void setPuertoServidor(String puertoServidor) {
        this.puertoServidor = puertoServidor;
    }

    public String getIpBDD() {
        return ipBDD;
    }

    public void setIpBDD(String ipBDD) {
        this.ipBDD = ipBDD;
    }

    public String getPuertoBDD() {
        return puertoBDD;
    }

    public void setPuertoBDD(String puertoBDD) {
        this.puertoBDD = puertoBDD;
    }

    public String getNombreBDD() {
        return nombreBDD;
    }

    public void setNombreBDD(String nombreBDD) {
        this.nombreBDD = nombreBDD;
    }

    public String getIpReportes() {
        return ipReportes;
    }

    public void setIpReportes(String ipReportes) {
        this.ipReportes = ipReportes;
    }

    public String getPuertoReportes() {
        return puertoReportes;
    }

    public void setPuertoReportes(String puertoReportes) {
        this.puertoReportes = puertoReportes;
    }

    public String getUserBdd() {
        return userBdd;
    }

    public void setUserBdd(String userBdd) {
        this.userBdd = userBdd;
    }

	public String getPasswordBDD() {
		return passwordBDD;
	}

	public void setPasswordBDD(String passwordBDD) {
		this.passwordBDD = passwordBDD;
	}
    
    
}