package com.besixplus.sii.servlets;

import com.besixplus.sii.objects.ServerResponse;
import com.bmlaurus.alfresco.AlfrescoActions;
import com.bmlaurus.alfresco.integration.*;
import com.bmlaurus.alfresco.model.SiiModelFile;
import com.bmlaurus.alfresco.utils.InputStreamDataSource;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.activation.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 30/5/16.
 */
public class AlfrescoUploader extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 7016250978287851292L;

    Gson gson = new Gson();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(req);
        ServerResponse respuestaServidor = new ServerResponse();
        if(tmpIsMultipart){
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(10485760);
            try {
                List<FileItem> items = upload.parseRequest(req);

                //Documento
                SiiAttachmentDocument document = null;
                //Datos de los Aspectos:
                //Almacenable:
                String caja = null;
                String carpeta = null;
                String descripcion = null;
                //Identificable:
                String table_name = null;
                String record_id = null;
                //Caducable
                Date caducidad = null;
                //Bytes Archivo
                DataHandler dh = null;

                //Aqui hay que armar el objeto que recibe los datos, para pasarselo al Alfresco.
                SiiModelFile modelFile = null;
                Map<String,String> identity = null;
                for(FileItem item : items){
                    if (item.isFormField()) {//Viene en el formulario
                        if(item.getFieldName().equals("fileDefinition")){
                            modelFile = gson.fromJson(item.getString().replace("\\","").replace("\"[{","[{").replace("}]\"", "}]"),SiiModelFile.class);
                        }else if(item.getFieldName().equals("identificable")) {
                            identity = gson.fromJson(item.getString().replace("\\", "").replace("\"[{","[{").replace("}]\"", "}]"), Map.class);
                            if(modelFile.getDocumentType().equals(SiiModelFile.DOCUMENT_TYPE_PERSONALES))
                                document = new SiiPersonalesDocument(identity.get("recordId"));
                            else if(modelFile.getDocumentType().equals(SiiModelFile.DOCUMENT_TYPE_RESPALDO))
                                document = new SiiRespaldoDocument(identity.get("recordId"));
                            //Desde aqui empezamos a armar los aspectos.
                        }else if(item.getFieldName().equals("CAJA_NAME"))
                            caja = item.getString();
                        else if(item.getFieldName().equals("CARPETA_NAME"))
                            carpeta = item.getString();
                        else if(item.getFieldName().equals("DESCRIPCION_NAME"))
                            descripcion = item.getString();
                        else if(item.getFieldName().equals("TABLE_NAME_NAME"))
                            table_name = item.getString();
                        else if(item.getFieldName().equals("RECORD_ID_NAME"))
                            record_id = item.getString();
                        else if(item.getFieldName().equals("CADUCIDAD_NAME"))
                            caducidad = new Date(item.getString());
                        else
                            System.out.println("NOT SUPPORTED: "+item.getFieldName() + " = " + item.getString());
                    }else{ // es un archivo
                        System.out.print("Es un archivo");
                        dh = new DataHandler(new InputStreamDataSource(item.getInputStream(),item.getName()));
                        //Agregamos nombre del archivo y propiedades
                        document.setPath(modelFile.getFileRepository());
                        document.setFileName(item.getName());
                    }
                }
                if(document!=null && dh!=null){
                    //Agregamos Aspectos
                    if(caja!=null || carpeta!=null || descripcion!=null)
                        document.addAspect(new SiiAlmacenable(caja,carpeta,descripcion));
                    if(table_name!=null && record_id!=null)
                        document.addAspect(new SiiIdentificable(table_name,record_id));
                    if(caducidad != null)
                        document.addAspect(new SiiCaducable(caducidad));

                    SiiFileResult result = AlfrescoActions.createFile(dh, document);
                    respuestaServidor.setObjData(result);
                    respuestaServidor.setSuccess(true);
                }else{
                    respuestaServidor.setMsg("No se pudo cargar el archivo en el servidor Alfresco");
                    respuestaServidor.setSuccess(false);
                }


            } catch (FileUploadException e) {
                e.printStackTrace();
                respuestaServidor.setSuccess(false);
                respuestaServidor.setMsg(e.getMessage());
            }
        }
        resp.setContentType("text/html");
        resp.getWriter().println(gson.toJson(respuestaServidor));
    }
}
