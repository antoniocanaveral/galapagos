package com.jaspersoft.jasperserver.rest.sample;

import com.besixplus.sii.util.Env;
import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;
import com.bmlaurus.jasper.JasperResponse;
import com.bmlaurus.jaspersoft.model.ExtraResource;
import com.bmlaurus.jaspersoft.model.InputControl;
import com.bmlaurus.jaspersoft.model.JasperDataType;
import com.bmlaurus.jaspersoft.model.JasperReportResource;
import com.bmlaurus.jaspersoft.services.*;
import com.bmlaurus.virtual.VirtualCache;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by acanaveral on 12/5/16.
 */
public class LocalTests {

    @Test
    public void CreatePath(){
        System.err.println(validateReport("generated", "rptDinardapSRI"));
    }


    private String validateReport(String reportFolder, String reportName){
        Gson gson = new Gson();
        JasperResponse response = new JasperResponse(true,null,null);
        try {
            //String parentFolder = reportFolder.substring(0, reportFolder.lastIndexOf("/"));
            reportFolder = reportFolder.substring(reportFolder.lastIndexOf("/") + 1, reportFolder.length());

            Properties config = VirtualCache.getConfig(VirtualCache.PROP_JASPER_CONF);
            FolderService folderService = null;
            if (Boolean.valueOf(config.getProperty("INIT_JASPERSERVER"))) {
                UserService userService = new UserService();
                if (userService.loginToServer()) {
                    userService.verifyUser();
                    userService.logOut();
                }
                //CREAMOS LAS CARPETAS BASE
                folderService = new FolderService();
                if(folderService.loginToServer()) {
                    folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH"), "sii");
                    folderService.getOrCreateFolder(config.getProperty("SII_REPORTS_PATH"), "sii");
                    folderService.getOrCreateFolder(config.getProperty("SII_DATASOURCE_PATH"), "sii");
                    folderService.getOrCreateFolder(config.getProperty("SII_DATATYPES_PATH"), "sii");
                    folderService.getOrCreateFolder(config.getProperty("SII_CONTROLS_PATH"), "sii");
                    folderService.logOut();
                }
                //CREAMOS EL DATASOURCE
                DataSourceService dataSourceService = new DataSourceService();
                if(dataSourceService.loginToServer()) {
                    dataSourceService.getOrCreateDataSource();
                    dataSourceService.logOut();
                }
                //CREAMOS LOS DATATYPES BASE
                String dataTypes = config.getProperty("SII_DATA_TYPES");
                if(dataTypes!=null && dataTypes.length()>0) {
                    Type dataTypesListType = new TypeToken<ArrayList<JasperDataType>>() {
                    }.getType();
                    List<JasperDataType> types = gson.fromJson(dataTypes,dataTypesListType);
                    DataTypeService service = new DataTypeService();
                    if(service.loginToServer()) {
                        for (JasperDataType type : types) {
                            service.getOrCreateDataType(type);
                        }
                        service.logOut();
                    }
                }
                //AGREGAMOS LOS RECURSOS EXISTENTES EN SII_HOME
                File localResourceDir = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + config.getProperty("SII_RESOURCES_PATH"));
                if (localResourceDir != null && localResourceDir.exists()) {
                    FileService fileService = new FileService();
                    if(fileService.loginToServer()){
                        for (File resource : getAllFiles(localResourceDir.getPath())) {
                            if (resource.isFile()) {
                                String remotePath = resource.getPath().replace(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY"), "");
                                if (!fileService.touchFile(remotePath)) {
                                    //Si es reporte, creamos el reporte además de subir el archivo
                                    String justName = resource.getName().substring(0, resource.getName().indexOf("."));
                                    /*if (resource.getName().endsWith("jrxml")) {
                                        fileService.uploadFile(remotePath.replace("/" + resource.getName(), ""), resource.getName(), resource);
                                        List<InputControl> controls = null;
                                        InputControlService controlService = new InputControlService(fileService.getHttpContext());
                                        controls = controlService.getOrCreateInputControls(resource);
                                        JasperService jasperService = new JasperService(controls,fileService.getHttpContext());
                                        int beginIndex = remotePath.replace("/" + resource.getName(), "").lastIndexOf("/");
                                        String parentPath = remotePath.replace("/" + resource.getName(), "").substring(beginIndex + 1);
                                        String basePath = remotePath.replace("/" + resource.getName(), "").substring(0, beginIndex);
                                        jasperService.getOrCreateJasperReport(basePath, parentPath, justName, null);
                                    } else {*/
                                        //Subimos el archivo sin poner la extensión
                                        fileService.uploadFile(remotePath.replace("/" + resource.getName(), ""), justName, resource);
                                        //Subimos el archivo nuevamente pero con extensión
                                        //fileService.uploadFile(remotePath.replace("/" + resource.getName(), ""), resource.getName(), resource);
                                    //}

                                }
                            }
                        }
                        fileService.logOut();
                    }
                }

                //AGREGAMOS LOS RECURSOS ADICIONALES DEFINIDOS EN EL CONFIG.PROPERTIES
                Type resoucesListType = new TypeToken<ArrayList<ExtraResource>>() {
                }.getType();
                Type excludesListType = new TypeToken<ArrayList<String>>() {
                }.getType();
                List<ExtraResource> resources = (List<ExtraResource>) gson.fromJson(config.getProperty("SII_EXTRA_RESOURCES_PATHS"), resoucesListType);
                List<String> excludes = gson.fromJson(config.getProperty("SII_EXCLUDE_RESOURCES"), excludesListType);
                if (resources != null) {
                    for (ExtraResource resource : resources) {
                        String lastFolder = resource.getRemoteFolder().substring(resource.getRemoteFolder().lastIndexOf("/") + 1, resource.getRemoteFolder().length());
                        List<String> filesToUpload = new ArrayList<>();
                        if (resource.getLocalFile() == null) {
                            File folder = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + "/" + resource.getLocalFolder());
                            if (folder.exists()) {
                                File[] folders = folder.listFiles();
                                if (folders != null) {
                                    for (File inFile : folders) {
                                        String justName = inFile.getName().substring(0, inFile.getName().indexOf("."));
                                        if (excludes != null) {
                                            if (inFile.isFile() && !excludes.contains(inFile.getName()))
                                                filesToUpload.add(justName);
                                        } else {
                                            if (inFile.isFile())
                                                filesToUpload.add(justName);
                                        }
                                    }
                                }
                            }
                        } else
                            filesToUpload.add(resource.getLocalFile());

                        FileService fileService = new FileService();
                        if (fileService.loginToServer()){
                            folderService = new FolderService();
                            if(folderService.loginToServer()) {
                                for (String localFile : filesToUpload) {
                                    if (!fileService.touchFile(resource.getRemoteFolder() + "/" + localFile)) {
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
                                        List<InputControl> controls = null;
                                        InputControlService controlService = new InputControlService(folderService.getHttpContext());
                                        controls = controlService.getOrCreateInputControls(new File(resource.getLocalFile()));
                                        JasperService jasperService = new JasperService(controls, folderService.getHttpContext());
                                        jasperService.getOrCreateJasperReport(lastFolder, localFile.substring(0, localFile.lastIndexOf(".")), null);
                                    }
                                }
                                folderService.logOut();
                            }
                            fileService.logOut();
                        }
                    }
                }
            }
            //Desde aqui el validador normal.
            FileService fileService = new FileService();
            if(fileService.loginToServer()){
                List<JasperReportResource> resources = null;
                if (!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder + "/" + reportName + ".jrxml")) {
                    folderService = new FolderService(fileService.getHttpContext());
                    folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, reportFolder);
                }
                List<InputControl> controls = null;
                File reportRoot = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + config.getProperty("SII_REPORTS_PATH") + "/" + reportFolder + "/" + reportName + "_files");
                if (reportRoot != null && reportRoot.exists() && reportRoot.isDirectory()) {
                    for (File item : reportRoot.listFiles()) {
                        if (item.getName().contains(reportName)) {//Este es el reporte
                            if (!item.getName().endsWith(".jasper")) {//ignoramos los jasper
                                InputControlService controlService = new InputControlService(fileService.getHttpContext());
                                controls = controlService.getOrCreateInputControls(item);
                                if (!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder + "/" + reportName + ".jrxml"))
                                    fileService.uploadFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, reportName + ".jrxml", item);
                            } else {
                                System.err.println(".jasper found. Please Remove: " + item.getAbsolutePath());
                            }
                        } else {
                            if (!item.getName().endsWith(".jasper")) {//ignoramos los jasper
                                if (resources == null)
                                    resources = new ArrayList<>();
                                //Metemos el recurso en el repositorio.
                                String justName = item.getName().substring(0, item.getName().indexOf("."));
                                if (!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder + "/" + item.getName()))
                                    fileService.uploadFile(config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder, item.getName(), item);
                                JasperReportResource resource = new JasperReportResource(justName, config.getProperty("SII_RESOURCES_PATH") + "/" + reportFolder + "/" + item.getName());
                                resources.add(resource);
                            } else {
                                System.err.println(".jasper found. Please Remove: " + item.getAbsolutePath());
                            }
                        }
                    }
                } else {
                    response.setResult(false);
                    response.setErrorMessage("El archivo " + reportName + ".jrxml NO existe localmente");
                }

                JasperService jasperService = new JasperService(controls,fileService.getHttpContext());
                jasperService.getOrCreateJasperReport(reportFolder, reportName, resources);
                //Si los recursos son jrxml los creamos como reporte en la misma carpeta.
                /*if(resources!=null && resources.size()>0){
                    for(JasperReportResource resource:resources){
                        if(resource.getName().endsWith("jrxml")){
                            InputControlService controlService = new InputControlService(fileService.getHttpContext());
                            File fileResource = new File(Env.getHomePath() + config.getProperty("SII_LOCAL_REPOSITORY") + config.getProperty("SII_REPORTS_PATH") + "/" + reportFolder
                                    + "/" + reportName + "_files" + "/" + resource.getName());
                            controls = controlService.getOrCreateInputControls(fileResource);
                            jasperService = new JasperService(controls,fileService.getHttpContext());
                            jasperService.getOrCreateJasperReport(reportFolder, resource.getName().replace(".jrxml",""), null);
                        }
                    }
                }*/
                fileService.logOut();
            }

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
