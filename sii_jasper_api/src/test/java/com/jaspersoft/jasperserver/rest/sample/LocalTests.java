package com.jaspersoft.jasperserver.rest.sample;

import com.besixplus.sii.util.Env;
import com.bmlaurus.jaspersoft.services.*;
import org.junit.Test;

import java.io.File;
import java.util.Properties;

/**
 * Created by acanaveral on 12/5/16.
 */
public class LocalTests {

    @Test
    public void CreatePath(){
        //CREAMOS LAS CARPETAS BASE
        Properties config = Env.getExternalProperties("jasper/config.properties");
        FolderService folderService = null;
        if(Boolean.valueOf(config.getProperty("INIT_JASPERSERVER"))) {
            UserService userService = new UserService();
            userService.verifyUser();

            folderService = new FolderService();
            folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH"), "sii");

            folderService = new FolderService();
            folderService.getOrCreateFolder(config.getProperty("SII_REPORTS_PATH"), "sii");

            folderService = new FolderService();
            folderService.getOrCreateFolder(config.getProperty("SII_DATASOURCE_PATH"), "sii");

            DataSourceService dataSourceService = new DataSourceService();
            dataSourceService.getOrCreateDataSource();

        }

        //INICIAMOS UNA TRANSACCION A PARTIR DE LA PETICION:
        //http://localhost:8081/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&j_username=sii&j_password=sii&ParentFolderUri=/Reports/sii/residencia&reportUnit=/Reports/sii/residencia/rptListadoSolicitudesResidenciaReceptados&output=pdf&P_FECHA_INICIAL=20160516045455&P_FECHA_FINAL=20160516045455&P_CUSU_CODIGO=CUSU35510&P_CRTST_CODIGO=CRTST1&P_CRSEC_CODIGO=&P_CRSEG_ESTADO_ATENCION=0

        FileService fileService = new FileService();
        if(!fileService.touchFile(config.getProperty("SII_RESOURCES_PATH")+"/"+"residencia/rptListadoSolicitudesResidenciaReceptados.jrxml")){
            folderService = new FolderService();
            folderService.getOrCreateFolder(config.getProperty("SII_RESOURCES_PATH")+"/"+"residencia","residencia");

            File f = new File("/Users/acanaveral/Desarrollo/Advance/fuentes/galapagos_ws/galapagos/doc/reports/residencia/rptListadoSolicitudesResidenciaReceptados.jrxml");
            fileService.uploadFile(config.getProperty("SII_RESOURCES_PATH")+"/"+"residencia", "rptListadoSolicitudesResidenciaReceptados.jrxml", f);
        }

        JasperService jasperService = new JasperService();
        jasperService.getOrCreateJasperReport("residencia","rptListadoSolicitudesResidenciaReceptados");

    }
}
