package com.bmlaurus.alfresco.integration;

import com.bmlaurus.alfresco.cmis.BaseAPI;
import com.bmlaurus.alfresco.entity.AlfFile;
import org.apache.chemistry.opencmis.client.api.Session;

import java.util.List;

/**
 * Created by acanaveral on 29/4/16.
 */
public class SiiConsulta extends BaseAPI{


    /**
     * Consulta todos los archivos existentes en un directorio en Alfresco
     * */
    public List<AlfFile> obtenerArchivos(String repoPath){
        List<AlfFile> files = null;

        // Get a CMIS session
        Session cmisSession = getCmisSession();

        //cmisSession.get

        return files;
    }
}
