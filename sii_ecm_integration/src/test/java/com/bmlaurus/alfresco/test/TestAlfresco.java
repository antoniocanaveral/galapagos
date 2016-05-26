package com.bmlaurus.alfresco.test;

import com.bmlaurus.alfresco.cmis.BaseAPI;
import com.bmlaurus.alfresco.entity.AlfUser;
import com.bmlaurus.alfresco.integration.SiiAlmacenable;
import com.bmlaurus.alfresco.integration.SiiCaducable;
import com.bmlaurus.alfresco.integration.SiiIdentificable;
import com.bmlaurus.alfresco.integration.SiiPersonalesDocument;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by acanaveral on 26/4/16.
 */
public class TestAlfresco {

    @Test
    public void AlfrescoLogin_LogOut(){

        AlfUser user = new AlfUser();
        user.setUsername("acanaveral");
        user.setPassword("adm5505");

        /*AlfrescoServer conn = new AlfrescoServer("http://200.125.146.82","80","/alfresco/service/api/");
        AlfSessionData sessionData = conn.logIn(user);
        assert sessionData!=null;
        assert sessionData.getTicket()!=null;
        if(sessionData!=null) { //logged IN
            user.setData(sessionData);
            assert conn.logOut(user) == true;
        }*/

    }

    @Test
    public void CreateFolder(){
        /*AlfUser user = new AlfUser();
        user.setUsername("acanaveral");
        user.setPassword("adm5505");

        AlfrescoServer conn = new AlfrescoServer("http://200.125.146.82","80","/alfresco/service/api/");
        AlfSessionData sessionData = conn.logIn(user);
        if(sessionData!=null) { //logged IN
            user.setData(sessionData);
            List folders = conn.createPath(user, "res/casos/123456789");
            conn.logOut(user);
        }*/
        System.setProperty("sii.home", "/Users/acanaveral/Desarrollo/Advance/fuentes/galapagos_ws/galapagos/SII_HOME");
        BaseAPI cmis = new BaseAPI();
        // Find the root folder of our target site
        try {
            String rootFolderId = cmis.getRootFolderId(cmis.getSite());
            // Create a new folder in the root folder
            List<Folder> subFolder = cmis.createFoldersByPath(rootFolderId, "res/casos/123456789");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UploadFileToFolder(){
        System.setProperty("sii.home","/Users/acanaveral/Desarrollo/Advance/fuentes/galapagos_ws/galapagos/SII_HOME");
        BaseAPI cmis = new BaseAPI();
        File file = new File("/Users/antonio/Downloads/test.pdf");
        try {
            //Obtenemos el Objeto
            CmisObject obj = cmis.getObjectByPath("res/casos/123456789" + "/" + "test.pdf");
            if(obj != null) {
                if (obj instanceof Document) {
                    cmis.updateDocument((Document) obj,file, null);
                } else{
                    System.out.println("Object :"+obj.getType().getId());
                }
            }else{
                String rootFolderId = cmis.getRootFolderId(cmis.getSite());
                // Create a new folder in the root folder
                List<Folder> subFolder = cmis.createFoldersByPath(rootFolderId, "res/casos/123456789");
                cmis.createDocument(subFolder.get(subFolder.size() - 1), file, "application/pdf", null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ShowFolderContent(){
        System.setProperty("sii.home","/Users/acanaveral/Desarrollo/Advance/fuentes/galapagos_ws/galapagos/SII_HOME");
        BaseAPI cmis = new BaseAPI();
        StringBuffer objs = new StringBuffer();
        CmisObject folder = null;
        try {
            folder = cmis.getObjectByPath("res/casos/123456789");
            for(CmisObject obj:cmis.getObjectsById(folder.getId())){
                objs.append("Type: "+obj.getType().getDisplayName()+ " - Name: "+ obj.getName()+ " - Id: " + obj.getId() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(objs.toString());
    }

    @Test
    public void DocumentsAndAspects(){
        System.setProperty("sii.home","/Users/acanaveral/Desarrollo/Advance/fuentes/galapagos_ws/galapagos/SII_HOME");
        BaseAPI cmis = new BaseAPI();

        File file = new File("/Users/antonio/Downloads/test.pdf");

        //Generamos el documento y los aspectos necesarios. Pueden ser varios.
        SiiPersonalesDocument doc = new SiiPersonalesDocument("1710679968");
        doc.addAspect(new SiiAlmacenable("C10", "1", "Descripcion del almacenamiento"));
        doc.addAspect(new SiiCaducable(new Date()));
        doc.addAspect(new SiiIdentificable("tabla_test", "testID1"));

        try {
            //Obtenemos el Objeto
            CmisObject obj = cmis.getObjectByPath("res/casos/123456789" + "/" + "test.pdf");
            if(obj != null) {
                if (obj instanceof Document) {
                    cmis.updateDocument((Document) obj,file, doc);
                } else{
                    System.out.println("Object :"+obj.getType().getId());
                }
            }else{
                String rootFolderId = cmis.getRootFolderId(cmis.getSite());
                // Create a new folder in the root folder
                List<Folder> subFolder = cmis.createFoldersByPath(rootFolderId, "res/casos/123456789");
                cmis.createDocument(subFolder.get(subFolder.size() - 1), file, "application/pdf", doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void AlfrescoAspect(){
        /*// INICIALIZAMOS EL UPLOADER
        AlfrescoUpload au = new AlfrescoUpload();
        // au.setServer_host("200.124.229.73");
        au.setServer_host("200.125.146.82");
        au.setServer_port("80");
        au.setServer_username("acanaveral");
        au.setServer_password("adm5505");

        // DEFINIMOS LAS PROPIEDADES GENERALES DE LA CARPETA
        // au.setSpaceDescription("Descripción para la Carpeta"); ---> SI NO PONEMOS, USA EL DEFAULT

        // DEFINIMOS LAS PROPIEDADES GENERALES DEL ARCHIVO
        au.setContentDescription("Descripción para el Archivo 2");
        au.setContentTitle("Título del Archivo 2");
        au.setContentAuthor("Antonio Cañaveral");

        // ESTABLECEMOS LAS PROPIEDADES DEL ASPECT
        String propertynames[] = { new String("entrega"), new String("No Transporte"),
                new String("Carta de Porte"), new String("Doc Modelo"), new String("No Pedido"),
                new String("No Factura"), new String("Factura"), new String("Transportista"),
                new String("Placa Vehiculo"), new String("Fecha Creacion") };
        String propertyvalues[] = { new String("124"), new String("457"), new String("780"),
                new String("ABC124"), new String("PEDIDO124"), new String("006-001-0174973"),
                new String("006-FACTURA."), new String("TRANSQUITO SA"), new String("PBX-124"),
                new String("2012-06-5") };

        Aspect as = new Aspect("FacturaEdesa", "{lge.logexedesa.model}", propertynames, propertyvalues);

        // HACEMOS LA LLAMADA PARA QUE CREE LA RUTA Y SUBA EL ARCHIVO o VERSIÓN
        Reference destino = au.createPathToAlfresco("edesa/2012/05/006-001-0174976");
        if (destino != null)
            au.uploadFileToAlfresco(destino, "test1.pdf", "/Users/antonio/Downloads/test.pdf", as);*/
    }
}
