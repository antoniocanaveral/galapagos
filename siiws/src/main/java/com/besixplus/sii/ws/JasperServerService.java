package com.besixplus.sii.ws;

import com.besixplus.sii.exception.EnvironmentVariableNotDefinedException;
import com.besixplus.sii.util.Env;
import com.bmlaurus.jasper.JasperResponse;
import com.bmlaurus.jaspersoft.model.ExtraResource;
import com.bmlaurus.jaspersoft.services.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by acanaveral on 16/5/16.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class JasperServerService implements Serializable {
    private static final long serialVersionUID = -7120354058063274129L;

    @Resource
    WebServiceContext wctx;

    @WebMethod
    public String validateReport(
            @WebParam(name="reportFolder") String reportFolder,
            @WebParam(name="reportName") String reportName
    ){
        Gson gson = new Gson();
        JasperResponse response = new JasperResponse(true,null,null);
        try {
            //String parentFolder = reportFolder.substring(0, reportFolder.lastIndexOf("/"));
            reportFolder = reportFolder.substring(reportFolder.lastIndexOf("/")+1,reportFolder.length());

            Properties config = Env.getExternalProperties("jasper/config.properties");
            FolderService folderService = null;
            if(Boolean.valueOf(config.getProperty("INIT_JASPERSERVER"))) {
                UserService userService = new UserService();
                userService.verifyUser();
                //CREAMOS LAS CARPETAS BASE
                folderService = new FolderService();
                folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH"), "sii");

                folderService = new FolderService();
                folderService.getOrCreateFolder(config.getProperty("SII_REPORTS_PATH"), "sii");

                folderService = new FolderService();
                folderService.getOrCreateFolder(config.getProperty("SII_DATASOURCE_PATH"), "sii");
                //CREAMOS EL DATASOURCE
                DataSourceService dataSourceService = new DataSourceService();
                dataSourceService.getOrCreateDataSource();

                //AGREGAMOS LOS RECURSOS ADICIONALES DEFINIDOS EN EL CONFIG.PROPERTIES
                Type resoucesListType = new TypeToken<ArrayList<ExtraResource>>() {
                }.getType();
                Type excludesListType = new TypeToken<ArrayList<String>>() {
                }.getType();
                List<ExtraResource> resources = gson.fromJson(config.getProperty("SII_EXTRA_RESOURCES_PATHS"), resoucesListType);
                List<String> excludes = gson.fromJson(config.getProperty("SII_EXCLUDE_RESOURCES"), excludesListType);
                if(resources!=null){
                    for (ExtraResource resource : resources) {
                        FileService fileService = new FileService();
                        String lastFolder = resource.getRemoteFolder().substring(resource.getRemoteFolder().lastIndexOf("/") + 1, resource.getRemoteFolder().length());
                        List<String> filesToUpload = new ArrayList<>();
                        if (resource.getLocalFile() == null) {
                            File folder = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + "/" + resource.getLocalFolder());
                            if (folder.exists()) {
                                File[] folders = folder.listFiles();
                                if (folders != null) {
                                    for (File inFile : folders) {
                                        if (excludes != null) {
                                            if (inFile.isFile() && !excludes.contains(inFile.getName()))
                                                filesToUpload.add(inFile.getName());
                                        } else {
                                            if (inFile.isFile())
                                                filesToUpload.add(inFile.getName());
                                        }
                                    }
                                }
                            }
                        } else
                            filesToUpload.add(resource.getLocalFile());
                        for (String localFile : filesToUpload) {
                            if (!fileService.touchFile(resource.getRemoteFolder() + "/" + localFile)) {
                                folderService = new FolderService();
                                folderService.getOrCreateFolder(resource.getRemoteFolder(), lastFolder);

                                File f = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + "/" + resource.getLocalFolder() + "/" + localFile);
                                if (f.exists())
                                    fileService.uploadFile(resource.getRemoteFolder(), localFile, f);
                                else {
                                    response.setResult(false);
                                    response.setErrorMessage("RECURSOS ADICIONALES: El archivo " + localFile + " NO existe localmente");
                                }
                            }
                            if (resource.isReport()) {
                                JasperService jasperService = new JasperService();
                                jasperService.getOrCreateJasperReport(lastFolder, localFile.substring(0, localFile.lastIndexOf(".")));
                            }
                        }
                    }
                }
            }
            FileService fileService = new FileService();
            if(!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH")+"/"+reportFolder+"/"+reportName+".jrxml")){
                folderService = new FolderService();
                folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, reportFolder);

                File f  = new File(Env.getHomePath()+config.getProperty("SII_LOCAL_REPOSITORY")+"/"+reportFolder+"/"+reportName+".jrxml");
                if(f.exists())
                    fileService.uploadFile(config.getProperty("SII_RESOURCES_PATH")+"/"+reportFolder, reportName+".jrxml", f);
                else{
                    response.setResult(false);
                    response.setErrorMessage("El archivo "+reportName+".jrxml NO existe localmente");
                }
            }

            JasperService jasperService = new JasperService();
            jasperService.getOrCreateJasperReport(reportFolder, reportName);

        } catch (EnvironmentVariableNotDefinedException e) {
            response.setErrorMessage(e.getMessage());
            response.setResult(false);
        }
        return gson.toJson(response);
    }
}
