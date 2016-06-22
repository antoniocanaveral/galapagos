package com.bmlaurus.alfresco.db;

import com.bmlaurus.alfresco.model.SiiModelFile;
import com.bmlaurus.alfresco.model.SiiModelMetadata;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 21/6/16.
 */
public class SiiDataSaver {

    private SiiModelMetadata metadata;
    private List<SiiModelFile> modelFiles;
    private String metadataCode;
    private Connection inConnection;

    public SiiDataSaver(java.sql.Connection con, String user, String table_name, String filter,List<SiiModelFile> files){
       //Vemos si existe el ModelMetadata
        inConnection=con;
        metadata = SiiDataLoader.getAlfrescoMetadata(inConnection,table_name,filter);
        if(metadata==null){
            metadata.setTableName(table_name);
            metadata.setFilter(filter);
            metadata.setIsList(true);
            metadata.setCode(getNewMetadataCode());
        }else
            metadataCode = metadata.getCode();

        List<SiiModelFile> loaded = metadata.getFileList();

        if(files!=null && files.size()>0){
            modelFiles =  new ArrayList<>();
            for(SiiModelFile file:files){
                if(file.getCode().equals("KEYGEN"))
                    file.setCode(getNewFileCode());
                modelFiles.add(file);
            }
        }
    }

    private String getNewMetadataCode(){
        String code=null;

        metadataCode = code;
        return code;
    }

    private String getNewFileCode(){
        String code = null;

        return code;
    }

    public void save(){}
}
