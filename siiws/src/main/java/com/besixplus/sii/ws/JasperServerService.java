package com.besixplus.sii.ws;

import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;
import com.besixplus.sii.util.Env;
import com.bmlaurus.jasper.JasperResponse;
import com.bmlaurus.jaspersoft.model.ExtraResource;
import com.bmlaurus.jaspersoft.model.JasperReportResource;
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
    ) {
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

                //AGREGAMOS LOS RECURSOS EXISTENTES EN SII_HOME
                File localResourceDir = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + config.getProperty("SII_RESOURCES_PATH"));
                if(localResourceDir!=null && localResourceDir.exists()){
                    for(File resource : getAllFiles(localResourceDir.getPath())){
                        FileService fileService = new FileService();
                        if(resource.isFile()){
                            String remotePath = resource.getPath().replace(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY"),"");
                            if (!fileService.touchFile(remotePath)){
                                //Si es reporte, creamos el reporte además de subir el archivo
                                String justName = resource.getName().substring(0, resource.getName().indexOf("."));
                                if(resource.getName().endsWith("jrxml")) {
                                    fileService.uploadFile(remotePath.replace("/" + resource.getName(), ""), resource.getName(), resource);
                                    JasperService jasperService = new JasperService();
                                    int beginIndex = remotePath.replace("/" + resource.getName(), "").lastIndexOf("/");
                                    String parentPath = remotePath.replace("/" + resource.getName(), "").substring(beginIndex + 1);
                                    String basePath = remotePath.replace("/" + resource.getName(), "").substring(0,beginIndex);
                                    jasperService.getOrCreateJasperReport(basePath, parentPath, justName, null);
                                }else{//Subimos el archivo sin poner la extensión
                                    fileService.uploadFile(remotePath.replace("/" + resource.getName(), ""),justName , resource);
                                }

                            }
                        }
                    }
                }

                //AGREGAMOS LOS RECURSOS ADICIONALES DEFINIDOS EN EL CONFIG.PROPERTIES
                Type resoucesListType = new TypeToken<ArrayList<ExtraResource>>() {
                }.getType();
                Type excludesListType = new TypeToken<ArrayList<String>>() {
                }.getType();
                List<ExtraResource> resources = (List<ExtraResource>) gson.fromJson(config.getProperty("SII_EXTRA_RESOURCES_PATHS"), resoucesListType);
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
                                jasperService.getOrCreateJasperReport(lastFolder, localFile.substring(0, localFile.lastIndexOf(".")),null);
                            }
                        }
                    }
                }
            }
            FileService fileService = new FileService();
            List<JasperReportResource> resources = null;
            if(!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH")+"/"+reportFolder+"/"+reportName+".jrxml")) {
                folderService = new FolderService();
                folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, reportFolder);
            }
            File reportRoot = new File(Env.getHomePath()+config.getProperty("SII_LOCAL_REPOSITORY")+config.getProperty("SII_REPORTS_PATH")+"/"+reportFolder+"/"+reportName+"_files");
            if(reportRoot != null && reportRoot.exists() && reportRoot.isDirectory()) {
                for(File item:reportRoot.listFiles()){
                    if(item.getName().contains(reportName)){
                        if(!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder+"/"+reportName + ".jrxml"))
                            fileService.uploadFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, reportName + ".jrxml", item);
                    }else{
                        if(resources==null)
                            resources = new ArrayList<>();
                        //Metemos el recurso en el repositorio.
                        if(!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder +"/"+ item.getName()))
                            fileService.uploadFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, item.getName(), item);
                        JasperReportResource resource = new JasperReportResource(item.getName(),config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder + "/"+item.getName());
                        resources.add(resource);
                    }
                }
            } else {
                response.setResult(false);
                response.setErrorMessage("El archivo " + reportName + ".jrxml NO existe localmente");
            }

            JasperService jasperService = new JasperService();
            jasperService.getOrCreateJasperReport(reportFolder, reportName, resources);

        } catch (EnvironmentVariableNotDefinedException e) {
            response.setErrorMessage(e.getMessage());
            response.setResult(false);
        }
        return gson.toJson(response);
    }

    private List<File> getAllFiles(String basePath){
        List<File> files =  new ArrayList<>();
        File base = new File(basePath);
        if(base!=null){
            for(File item: base.listFiles()){
                if(!item.isHidden()) {
                    if (item.isDirectory())
                        files.addAll(getAllFiles(item.getPath()));
                    else
                        files.add(item);
                }
            }
        }
        return files;
    }
}